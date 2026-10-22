package com.ttnet.org.chromium.net;

import android.os.ParcelFileDescriptor;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes2.dex */
public final class UploadDataProviders {

    public static final class ByteBufferUploadProvider extends UploadDataProvider {
        private final ByteBuffer mUploadBuffer;

        private ByteBufferUploadProvider(ByteBuffer r8) {
            this.mUploadBuffer = r8;
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public long getLength() {
            return this.mUploadBuffer.limit();
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public void read(UploadDataSink r8, ByteBuffer r10) {
            if (r10.hasRemaining() == false) goto L11;
            if (r10.remaining() < this.mUploadBuffer.remaining()) goto L7;
            r10.put(this.mUploadBuffer);
        L8:
            r8.onReadSucceeded(false);
            return;
        L7:
            int r11 = this.mUploadBuffer.limit();
            ByteBuffer r12 = this.mUploadBuffer;
            int r13 = r12.position();
            r12.limit(r10.remaining() + r13);
            r10.put(this.mUploadBuffer);
            this.mUploadBuffer.limit(r11);
            goto L8
        L11:
            throw new IllegalStateException("Cronet passed a buffer with no bytes remaining");
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public void rewind(UploadDataSink r8) {
            this.mUploadBuffer.position(0);
            r8.onRewindSucceeded();
        }

        public /* synthetic */ ByteBufferUploadProvider(ByteBuffer r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public interface FileChannelProvider {
        FileChannel getChannel();
    }

    public static final class FileUploadProvider extends UploadDataProvider {
        private volatile FileChannel mChannel;
        private final Object mLock;
        private final FileChannelProvider mProvider;

        private FileUploadProvider(FileChannelProvider r8) {
            this.mLock = new Object();
            this.mProvider = r8;
        }

        private FileChannel getChannel() {
            if (this.mChannel != null) goto L15;
            Object r8 = this.mLock;
            monitor-enter(r8);
        L11:
            th = move-exception;
            throw th;
        L7:
            if (this.mChannel != null) goto L9;
            this.mChannel = this.mProvider.getChannel();     // Catch: Throwable -> L11
        L9:
            monitor-exit(r8);     // Catch: Throwable -> L11
        L15:
            return this.mChannel;
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            FileChannel r8 = this.mChannel;
            if (r8 == null) goto L6;
            r8.close();
            return;
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public long getLength() {
            return getChannel().size();
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public void read(UploadDataSink r8, ByteBuffer r10) {
            if (r10.hasRemaining() == false) goto L13;
            FileChannel r11 = getChannel();
            int r12 = 0;
        L5:
            if (r12 != 0) goto L10;
            int r13 = r11.read(r10);
            if (r13 == (-1)) goto L10;
            r12 = r12 + r13;
        L10:
            r8.onReadSucceeded(false);
            return;
        L13:
            throw new IllegalStateException("Cronet passed a buffer with no bytes remaining");
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public void rewind(UploadDataSink r8) {
            getChannel().position(0);
            r8.onRewindSucceeded();
        }

        public /* synthetic */ FileUploadProvider(FileChannelProvider r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    private UploadDataProviders() {
    }

    public static UploadDataProvider create(final ParcelFileDescriptor r8) {
        return new FileUploadProvider(new AnonymousClass2(r8), null);
    }

    public static UploadDataProvider create(final File r8) {
        return new FileUploadProvider(new AnonymousClass1(r8), null);
    }

    public static UploadDataProvider create(ByteBuffer r8) {
        return new ByteBufferUploadProvider(r8.slice(), null);
    }

    public static UploadDataProvider create(byte[] r8) {
        return create(r8, 0, r8.length);
    }

    public static UploadDataProvider create(byte[] r8, int r10, int r11) {
        return new ByteBufferUploadProvider(ByteBuffer.wrap(r8, r10, r11).slice(), null);
    }
}
