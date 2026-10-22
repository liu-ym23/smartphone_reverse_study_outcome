package androidx.room.jarjarred.kotlinx.metadata.internal.protobuf;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractMessageLite implements MessageLite {
    protected int memoizedHashCode;

    public static abstract class Builder<BuilderType extends Builder> implements MessageLite.Builder {

        public static final class LimitedInputStream extends FilterInputStream {
            private int limit;

            public LimitedInputStream(InputStream r5, int r10) {
                super(r5);
                this.limit = r10;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int available() throws IOException {
                return Math.min(super.available(), this.limit);
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read() throws IOException {
                if (this.limit > 0) goto L6;
                return -1;
            L6:
                int r5 = super.read();
                if (r5 < 0) goto L9;
                this.limit--;
            L9:
                return r5;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public long skip(long r5) throws IOException {
                long r10 = super.skip(Math.min(r5, this.limit));
                if (r10 < 0) goto L5;
                this.limit = (int) (((long) this.limit) - r10);
            L5:
                return r10;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read(byte[] r5, int r10, int r11) throws IOException {
                int r12 = this.limit;
                if (r12 > 0) goto L6;
                return -1;
            L6:
                int r13 = super.read(r5, r10, Math.min(r11, r12));
                if (r13 < 0) goto L9;
                this.limit -= r13;
            L9:
                return r13;
            }
        }

        public Builder() {
        }

        public static <T> void addAll(Iterable<T> r5, Collection<? super T> r10) {
            if ((r5 instanceof LazyStringList) == false) goto L6;
            checkForNullValues(((LazyStringList) r5).getUnderlyingElements());
            r10.addAll((Collection) r5);
            return;
        L6:
            if ((r5 instanceof Collection) == false) goto L8;
            checkForNullValues(r5);
            r10.addAll((Collection) r5);
            return;
        L8:
            Iterator<T> r11 = r5.iterator();
        L10:
            if (r11.hasNext() == false) goto L15;
            T r12 = r11.next();
            r12.getClass();
            r10.add(r12);
            goto L10
        }

        private static void checkForNullValues(Iterable<?> r5) {
            Iterator<?> r10 = r5.iterator();
        L4:
            if (r10.hasNext() == false) goto L6;
            r10.next().getClass();
            goto L4
        }

        public static UninitializedMessageException newUninitializedMessageException(MessageLite r5) {
            return new UninitializedMessageException(r5);
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite.Builder
        public abstract BuilderType clone();

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clone() {
            return clone();
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite.Builder
        public boolean mergeDelimitedFrom(InputStream r5, ExtensionRegistryLite r10) throws IOException {
            int r11 = r5.read();
            if (r11 != (-1)) goto L6;
            return false;
        L6:
            mergeFrom(new LimitedInputStream(r5, CodedInputStream.readRawVarint32(r11, r5)), r10);
            return true;
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite.Builder
        public abstract BuilderType mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException;

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(ByteString r5) throws InvalidProtocolBufferException {
            return mergeFrom(r5);
        }

        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo76clone() throws CloneNotSupportedException {
            return clone();
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(ByteString r5, ExtensionRegistryLite r10) throws InvalidProtocolBufferException {
            return mergeFrom(r5, r10);
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r5) throws IOException {
            return mergeFrom(r5);
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
            return mergeFrom(r5, r10);
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite.Builder
        public boolean mergeDelimitedFrom(InputStream r5) throws IOException {
            return mergeDelimitedFrom(r5, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(InputStream r5) throws IOException {
            return mergeFrom(r5);
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(InputStream r5, ExtensionRegistryLite r10) throws IOException {
            return mergeFrom(r5, r10);
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r5) throws InvalidProtocolBufferException {
            return mergeFrom(r5);
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r5, int r10, int r11) throws InvalidProtocolBufferException {
            return mergeFrom(r5, r10, r11);
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r5, int r10, int r11, ExtensionRegistryLite r12) throws InvalidProtocolBufferException {
            return mergeFrom(r5, r10, r11, r12);
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r5, ExtensionRegistryLite r10) throws InvalidProtocolBufferException {
            return mergeFrom(r5, r10);
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite.Builder
        public BuilderType mergeFrom(CodedInputStream r5) throws IOException {
            return (BuilderType) mergeFrom(r5, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite.Builder
        public BuilderType mergeFrom(ByteString r5) throws InvalidProtocolBufferException {
            CodedInputStream r10 = r5.newCodedInput();     // Catch: IOException -> L4 InvalidProtocolBufferException -> L6
            mergeFrom(r10);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L6
            r10.checkLastTagWas(0);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L6
            return this;
        L6:
            e = move-exception;
            throw e;
        L4:
            e = move-exception;
            throw new RuntimeException("Reading from a ByteString threw an IOException (should never happen).", e);
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite.Builder
        public BuilderType mergeFrom(ByteString r5, ExtensionRegistryLite r10) throws InvalidProtocolBufferException {
            CodedInputStream r11 = r5.newCodedInput();     // Catch: IOException -> L4 InvalidProtocolBufferException -> L6
            mergeFrom(r11, r10);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L6
            r11.checkLastTagWas(0);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L6
            return this;
        L6:
            e = move-exception;
            throw e;
        L4:
            e = move-exception;
            throw new RuntimeException("Reading from a ByteString threw an IOException (should never happen).", e);
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite.Builder
        public BuilderType mergeFrom(byte[] r5) throws InvalidProtocolBufferException {
            return (BuilderType) mergeFrom(r5, 0, r5.length);
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite.Builder
        public BuilderType mergeFrom(byte[] r5, int r10, int r11) throws InvalidProtocolBufferException {
            CodedInputStream r12 = CodedInputStream.newInstance(r5, r10, r11);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L6
            mergeFrom(r12);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L6
            r12.checkLastTagWas(0);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L6
            return this;
        L6:
            e = move-exception;
            throw e;
        L4:
            e = move-exception;
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e);
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite.Builder
        public BuilderType mergeFrom(byte[] r5, ExtensionRegistryLite r10) throws InvalidProtocolBufferException {
            return (BuilderType) mergeFrom(r5, 0, r5.length, r10);
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite.Builder
        public BuilderType mergeFrom(byte[] r5, int r10, int r11, ExtensionRegistryLite r12) throws InvalidProtocolBufferException {
            CodedInputStream r13 = CodedInputStream.newInstance(r5, r10, r11);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L6
            mergeFrom(r13, r12);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L6
            r13.checkLastTagWas(0);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L6
            return this;
        L6:
            e = move-exception;
            throw e;
        L4:
            e = move-exception;
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e);
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite.Builder
        public BuilderType mergeFrom(InputStream r5) throws IOException {
            CodedInputStream r10 = CodedInputStream.newInstance(r5);
            mergeFrom(r10);
            r10.checkLastTagWas(0);
            return this;
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite.Builder
        public BuilderType mergeFrom(InputStream r5, ExtensionRegistryLite r10) throws IOException {
            CodedInputStream r11 = CodedInputStream.newInstance(r5);
            mergeFrom(r11, r10);
            r11.checkLastTagWas(0);
            return this;
        }
    }

    public AbstractMessageLite() {
        this.memoizedHashCode = 0;
    }

    public static void checkByteStringIsUtf8(ByteString r5) throws IllegalArgumentException {
        if (r5.isValidUtf8() == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("Byte string is not UTF-8.");
    }

    public UninitializedMessageException newUninitializedMessageException() {
        return new UninitializedMessageException(this);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite
    public byte[] toByteArray() {
        byte[] r5 = new byte[getSerializedSize()];     // Catch: IOException -> L4
        CodedOutputStream r10 = CodedOutputStream.newInstance(r5);     // Catch: IOException -> L4
        writeTo(r10);     // Catch: IOException -> L4
        r10.checkNoSpaceLeft();     // Catch: IOException -> L4
        return r5;
    L4:
        e = move-exception;
        throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite
    public ByteString toByteString() {
        ByteString.CodedBuilder r5 = ByteString.newCodedBuilder(getSerializedSize());     // Catch: IOException -> L4
        writeTo(r5.getCodedOutput());     // Catch: IOException -> L4
        return r5.build();
    L4:
        e = move-exception;
        throw new RuntimeException("Serializing to a ByteString threw an IOException (should never happen).", e);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite
    public void writeDelimitedTo(OutputStream r5) throws IOException {
        int r10 = getSerializedSize();
        CodedOutputStream r11 = CodedOutputStream.newInstance(r5, CodedOutputStream.computePreferredBufferSize(CodedOutputStream.computeRawVarint32Size(r10) + r10));
        r11.writeRawVarint32(r10);
        writeTo(r11);
        r11.flush();
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite
    public void writeTo(OutputStream r5) throws IOException {
        CodedOutputStream r10 = CodedOutputStream.newInstance(r5, CodedOutputStream.computePreferredBufferSize(getSerializedSize()));
        writeTo(r10);
        r10.flush();
    }
}
