package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractMessageLite.Builder;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractMessageLite<MessageType extends AbstractMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> implements MessageLite {
    protected int memoizedHashCode;

    public static abstract class Builder<MessageType extends AbstractMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> implements MessageLite.Builder {

        static final class LimitedInputStream extends FilterInputStream {
            private int limit;

            LimitedInputStream(InputStream r10, int r11) {
                super(r10);
                this.limit = r11;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int available() {
                return Math.min(super.available(), this.limit);
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read() {
                if (this.limit > 0) goto L6;
                return -1;
            L6:
                int r10 = super.read();
                if (r10 < 0) goto L9;
                this.limit--;
            L9:
                return r10;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read(byte[] r10, int r11, int r12) {
                int r13 = this.limit;
                if (r13 > 0) goto L6;
                return -1;
            L6:
                int r14 = super.read(r10, r11, Math.min(r12, r13));
                if (r14 < 0) goto L9;
                this.limit -= r14;
            L9:
                return r14;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public long skip(long r10) {
                int r11 = (int) super.skip(Math.min(r10, this.limit));
                if (r11 < 0) goto L6;
                this.limit -= r11;
            L6:
                return r11;
            }
        }

        public Builder() {
        }

        @Deprecated
        protected static <T> void addAll(Iterable<T> r10, Collection<? super T> r11) {
            addAll(r10, (List) r11);
        }

        protected static <T> void addAll(Iterable<T> r10, List<? super T> r11) {
            Internal.checkNotNull(r10);
            if ((r10 instanceof LazyStringList) == false) goto L23;
            List<?> r12 = ((LazyStringList) r10).getUnderlyingElements();
            LazyStringList r13 = (LazyStringList) r11;
            int r14 = r11.size();
            Iterator<?> r15 = r12.iterator();
        L6:
            if (r15.hasNext() == false) goto L37;
            Object r16 = r15.next();
            if (r16 == null) goto L9;
            if ((r16 instanceof ByteString) == true) goto L16;
            if ((r16 instanceof byte[]) == true) goto L20;
            r13.add((String) r16);
            goto L6
        L20:
            ByteString r17 = ByteString.copyFrom((byte[]) r16);
        L17:
            r13.add(r17);
            goto L6
        L16:
            r17 = (ByteString) r16;
            goto L17
        L9:
            String r18 = "Element at index " + (r13.size() - r14) + " is null.";
            int r19 = r13.size() - 1;
        L10:
            if (r19 < r14) goto L13;
            r13.remove(r19);
            r19 = r19 - 1;
            goto L10
        L13:
            throw new NullPointerException(r18);
        L37:
            return;
        L23:
            if ((r10 instanceof PrimitiveNonBoxingCollection) == false) goto L25;
            r11.addAll((Collection) r10);
            return;
        L25:
            addAllCheckingNulls(r10, r11);
        }

        private static <T> void addAllCheckingNulls(Iterable<T> r10, List<? super T> r11) {
            if ((r10 instanceof Collection) == false) goto L10;
            int r12 = ((Collection) r10).size();
            if ((r11 instanceof ArrayList) == false) goto L8;
            ((ArrayList) r11).ensureCapacity(r11.size() + r12);
            goto L10
        L8:
            if ((r11 instanceof ProtobufArrayList) == false) goto L10;
            ((ProtobufArrayList) r11).ensureCapacity(r11.size() + r12);
        L10:
            int r13 = r11.size();
            if ((r10 instanceof List) == true) goto L13;
        L20:
            Iterator<T> r14 = r10.iterator();
        L22:
            if (r14.hasNext() == false) goto L34;
            Object r15 = r14.next();
            if (r15 != null) goto L26;
            resetListAndThrow(r11, r13);
        L26:
            r11.add(r15);
            goto L22
        L34:
            return;
        L13:
            if ((r10 instanceof RandomAccess) == false) goto L20;
            List r16 = (List) r10;
            int r17 = r16.size();
            int r18 = 0;
        L15:
            if (r18 >= r17) goto L27;
            a1.b r19 = (Object) r16.get(r18);
            if (r19 != null) goto L19;
            resetListAndThrow(r11, r13);
        L19:
            r11.add(r19);
            r18 = r18 + 1;
            goto L15
        }

        private String getReadingExceptionMessage(String r10) {
            return "Reading " + getClass().getName() + " from a " + r10 + " threw an IOException (should never happen).";
        }

        protected static UninitializedMessageException newUninitializedMessageException(MessageLite r10) {
            return new UninitializedMessageException(r10);
        }

        private static void resetListAndThrow(List<?> r10, int r11) {
            String r12 = "Element at index " + (r10.size() - r11) + " is null.";
            int r13 = r10.size() - 1;
        L3:
            if (r13 < r11) goto L6;
            r10.remove(r13);
            r13 = r13 - 1;
            goto L3
        L6:
            throw new NullPointerException(r12);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public abstract BuilderType clone();

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clone() {
            return clone();
        }

        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo13clone() {
            return clone();
        }

        protected abstract BuilderType internalMergeFrom(MessageType r10);

        @Override // com.google.protobuf.MessageLite.Builder
        public boolean mergeDelimitedFrom(InputStream r10) {
            return mergeDelimitedFrom(r10, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.google.protobuf.MessageLite.Builder
        public boolean mergeDelimitedFrom(InputStream r10, ExtensionRegistryLite r11) {
            int r12 = r10.read();
            if (r12 != (-1)) goto L6;
            return false;
        L6:
            mergeFrom(new LimitedInputStream(r10, CodedInputStream.readRawVarint32(r12, r10)), r11);
            return true;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(ByteString r10) {
            CodedInputStream r11 = r10.newCodedInput();     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            mergeFrom(r11);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            r11.checkLastTagWas(0);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            return this;
        L7:
            e = move-exception;
            throw e;
        L4:
            e = move-exception;
            throw new RuntimeException(getReadingExceptionMessage("ByteString"), e);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(ByteString r10, ExtensionRegistryLite r11) {
            CodedInputStream r12 = r10.newCodedInput();     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            mergeFrom(r12, r11);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            r12.checkLastTagWas(0);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            return this;
        L7:
            e = move-exception;
            throw e;
        L4:
            e = move-exception;
            throw new RuntimeException(getReadingExceptionMessage("ByteString"), e);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(CodedInputStream r10) {
            return (BuilderType) mergeFrom(r10, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public abstract BuilderType mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11);

        @Override // com.google.protobuf.MessageLite.Builder
        public BuilderType mergeFrom(MessageLite r10) {
            if (getDefaultInstanceForType().getClass().isInstance(r10) == false) goto L7;
            return (BuilderType) internalMergeFrom((AbstractMessageLite) r10);
        L7:
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(InputStream r10) {
            CodedInputStream r11 = CodedInputStream.newInstance(r10);
            mergeFrom(r11);
            r11.checkLastTagWas(0);
            return this;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(InputStream r10, ExtensionRegistryLite r11) {
            CodedInputStream r12 = CodedInputStream.newInstance(r10);
            mergeFrom(r12, r11);
            r12.checkLastTagWas(0);
            return this;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(byte[] r10) {
            return (BuilderType) mergeFrom(r10, 0, r10.length);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(byte[] r10, int r11, int r12) {
            CodedInputStream r13 = CodedInputStream.newInstance(r10, r11, r12);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            mergeFrom(r13);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            r13.checkLastTagWas(0);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            return this;
        L7:
            e = move-exception;
            throw e;
        L4:
            e = move-exception;
            throw new RuntimeException(getReadingExceptionMessage("byte array"), e);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(byte[] r10, int r11, int r12, ExtensionRegistryLite r13) {
            CodedInputStream r14 = CodedInputStream.newInstance(r10, r11, r12);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            mergeFrom(r14, r13);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            r14.checkLastTagWas(0);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            return this;
        L7:
            e = move-exception;
            throw e;
        L4:
            e = move-exception;
            throw new RuntimeException(getReadingExceptionMessage("byte array"), e);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(byte[] r10, ExtensionRegistryLite r11) {
            return (BuilderType) mergeFrom(r10, 0, r10.length, r11);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(ByteString r10) {
            return mergeFrom(r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(ByteString r10, ExtensionRegistryLite r11) {
            return mergeFrom(r10, r11);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r10) {
            return mergeFrom(r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
            return mergeFrom(r10, r11);
        }

        @Override // com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(MessageLite r10) {
            return mergeFrom(r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(InputStream r10) {
            return mergeFrom(r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(InputStream r10, ExtensionRegistryLite r11) {
            return mergeFrom(r10, r11);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r10) {
            return mergeFrom(r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r10, int r11, int r12) {
            return mergeFrom(r10, r11, r12);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r10, int r11, int r12, ExtensionRegistryLite r13) {
            return mergeFrom(r10, r11, r12, r13);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r10, ExtensionRegistryLite r11) {
            return mergeFrom(r10, r11);
        }
    }

    protected interface InternalOneOfEnum {
        int getNumber();
    }

    public AbstractMessageLite() {
        this.memoizedHashCode = 0;
    }

    protected static <T> void addAll(Iterable<T> r10, List<? super T> r11) {
        Builder.addAll(r10, r11);
    }

    protected static void checkByteStringIsUtf8(ByteString r10) {
        if (r10.isValidUtf8() == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("Byte string is not UTF-8.");
    }

    private String getSerializingExceptionMessage(String r10) {
        return "Serializing " + getClass().getName() + " to a " + r10 + " threw an IOException (should never happen).";
    }

    int getMemoizedSerializedSize() {
        throw new UnsupportedOperationException();
    }

    int getSerializedSize(Schema r10) {
        int r11 = getMemoizedSerializedSize();
        if (r11 != (-1)) goto L6;
        int r12 = r10.getSerializedSize(this);
        setMemoizedSerializedSize(r12);
        return r12;
    L6:
        return r11;
    }

    UninitializedMessageException newUninitializedMessageException() {
        return new UninitializedMessageException(this);
    }

    void setMemoizedSerializedSize(int r10) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.protobuf.MessageLite
    public byte[] toByteArray() {
        byte[] r10 = new byte[getSerializedSize()];     // Catch: IOException -> L4
        CodedOutputStream r11 = CodedOutputStream.newInstance(r10);     // Catch: IOException -> L4
        writeTo(r11);     // Catch: IOException -> L4
        r11.checkNoSpaceLeft();     // Catch: IOException -> L4
        return r10;
    L4:
        e = move-exception;
        throw new RuntimeException(getSerializingExceptionMessage("byte array"), e);
    }

    @Override // com.google.protobuf.MessageLite
    public ByteString toByteString() {
        ByteString.CodedBuilder r10 = ByteString.newCodedBuilder(getSerializedSize());     // Catch: IOException -> L4
        writeTo(r10.getCodedOutput());     // Catch: IOException -> L4
        return r10.build();
    L4:
        e = move-exception;
        throw new RuntimeException(getSerializingExceptionMessage("ByteString"), e);
    }

    @Override // com.google.protobuf.MessageLite
    public void writeDelimitedTo(OutputStream r10) {
        int r11 = getSerializedSize();
        CodedOutputStream r12 = CodedOutputStream.newInstance(r10, CodedOutputStream.computePreferredBufferSize(CodedOutputStream.computeUInt32SizeNoTag(r11) + r11));
        r12.writeUInt32NoTag(r11);
        writeTo(r12);
        r12.flush();
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(OutputStream r10) {
        CodedOutputStream r11 = CodedOutputStream.newInstance(r10, CodedOutputStream.computePreferredBufferSize(getSerializedSize()));
        writeTo(r11);
        r11.flush();
    }
}
