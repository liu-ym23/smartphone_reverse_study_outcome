package com.ttnet.org.chromium.net;

import android.os.ParcelFileDescriptor;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes2.dex */
public final class UploadDataProviders {

    private static final class ByteBufferUploadProvider extends UploadDataProvider {
        private final ByteBuffer mUploadBuffer;

        private ByteBufferUploadProvider(ByteBuffer r10) {
            this.mUploadBuffer = r10;
        }

        /* synthetic */ ByteBufferUploadProvider(ByteBuffer r10, AnonymousClass1 r11) {
            this(r10);
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public long getLength() {
            return this.mUploadBuffer.limit();
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public void read(UploadDataSink r10, ByteBuffer r11) {
            if (r11.hasRemaining() == false) goto L11;
            if (r11.remaining() < this.mUploadBuffer.remaining()) goto L7;
            r11.put(this.mUploadBuffer);
        L8:
            r10.onReadSucceeded(false);
            return;
        L7:
            int r12 = this.mUploadBuffer.limit();
            ByteBuffer r13 = this.mUploadBuffer;
            r13.limit(r13.position() + r11.remaining());
            r11.put(this.mUploadBuffer);
            this.mUploadBuffer.limit(r12);
            goto L8
        L11:
            throw new IllegalStateException("Cronet passed a buffer with no bytes remaining");
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public void rewind(UploadDataSink r10) {
            this.mUploadBuffer.position(0);
            r10.onRewindSucceeded();
        }
    }

    private interface FileChannelProvider {
        FileChannel getChannel();
    }

    private static final class FileUploadProvider extends UploadDataProvider {
        private volatile FileChannel mChannel;
        private final Object mLock;
        private final FileChannelProvider mProvider;

        private FileUploadProvider(FileChannelProvider r10) {
            this.mLock = new Object();
            this.mProvider = r10;
        }

        /* synthetic */ FileUploadProvider(FileChannelProvider r10, AnonymousClass1 r11) {
            this(r10);
        }

        private FileChannel getChannel() {
            if (this.mChannel != null) goto L15;
            Object r10 = this.mLock;
            monitor-enter(r10);
        L11:
            th = move-exception;
            throw th;
        L7:
            if (this.mChannel != null) goto L9;
            this.mChannel = this.mProvider.getChannel();     // Catch: Throwable -> L11
        L9:
            monitor-exit(r10);     // Catch: Throwable -> L11
        L15:
            return this.mChannel;
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            FileChannel r10 = this.mChannel;
            if (r10 == null) goto L6;
            r10.close();
            return;
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public long getLength() {
            return getChannel().size();
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public void read(UploadDataSink r10, ByteBuffer r11) {
            if (r11.hasRemaining() == false) goto L13;
            FileChannel r12 = getChannel();
            int r13 = 0;
        L5:
            if (r13 != 0) goto L10;
            int r14 = r12.read(r11);
            if (r14 == (-1)) goto L10;
            r13 = r13 + r14;
        L10:
            r10.onReadSucceeded(false);
            return;
        L13:
            throw new IllegalStateException("Cronet passed a buffer with no bytes remaining");
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public void rewind(UploadDataSink r10) {
            getChannel().position(0);
            r10.onRewindSucceeded();
        }
    }

    private UploadDataProviders() {
    }

    public static UploadDataProvider create(final ParcelFileDescriptor r10) {
        return new FileUploadProvider(new AnonymousClass2(r10), null);
    }

    public static UploadDataProvider create(final File r10) {
        return new FileUploadProvider(new AnonymousClass1(r10), null);
    }

    public static UploadDataProvider create(ByteBuffer r10) {
        return new ByteBufferUploadProvider(r10.slice(), null);
    }

    public static UploadDataProvider create(byte[] r10) {
        return create(r10, 0, r10.length);
    }

    public static UploadDataProvider create(byte[] r10, int r11, int r12) {
        return new ByteBufferUploadProvider(ByteBuffer.wrap(r10, r11, r12).slice(), null);
    }
}
