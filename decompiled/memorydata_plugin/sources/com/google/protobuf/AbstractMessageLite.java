package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractMessageLite.Builder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractMessageLite<MessageType extends AbstractMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> implements MessageLite {
    protected int memoizedHashCode;

    public static abstract class Builder<MessageType extends AbstractMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> implements MessageLite.Builder {

        static final class LimitedInputStream extends FilterInputStream {
            private int limit;

            LimitedInputStream(InputStream r1, int r2) {
                super(r1);
                this.limit = r2;
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
                int r0 = super.read();
                if (r0 < 0) goto L9;
                this.limit--;
            L9:
                return r0;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read(byte[] r2, int r3, int r4) {
                int r0 = this.limit;
                if (r0 > 0) goto L6;
                return -1;
            L6:
                int r5 = super.read(r2, r3, Math.min(r4, r0));
                if (r5 < 0) goto L9;
                this.limit -= r5;
            L9:
                return r5;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public long skip(long r3) {
                int r4 = (int) super.skip(Math.min(r3, this.limit));
                if (r4 < 0) goto L6;
                this.limit -= r4;
            L6:
                return r4;
            }
        }

        public Builder() {
        }

        @Deprecated
        public static <T> void addAll(Iterable<T> r2, Collection<? super T> r3) {
            addAll((Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.preCheckCast((Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin"), List.class, "com.obric.memorydata.plugin"));
        }

        public static <T> void addAll(Iterable<T> r4, List<? super T> r5) {
            Iterable r6 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin");
            List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            Internal.checkNotNull(r6);
            if (ZeusTransformUtils.instanceOf(r6, LazyStringList.class) == false) goto L23;
            List<?> r8 = ((LazyStringList) ZeusTransformUtils.preCheckCast(r6, LazyStringList.class, "com.obric.memorydata.plugin")).getUnderlyingElements();
            LazyStringList r0 = (LazyStringList) ZeusTransformUtils.preCheckCast(r7, LazyStringList.class, "com.obric.memorydata.plugin");
            int r9 = r7.size();
            Iterator<?> r10 = r8.iterator();
        L6:
            if (r10.hasNext() == false) goto L37;
            Object r2 = r10.next();
            if (r2 == null) goto L9;
            if (ZeusTransformUtils.instanceOf(r2, ByteString.class) == true) goto L16;
            if ((r2 instanceof byte[]) == true) goto L20;
            r0.add((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin"));
            goto L6
        L20:
            ByteString r3 = ByteString.copyFrom((byte[]) ZeusTransformUtils.preCheckCast(r2, byte[].class, "com.obric.memorydata.plugin"));
        L17:
            r0.add(r3);
            goto L6
        L16:
            r3 = (ByteString) ZeusTransformUtils.preCheckCast(r2, ByteString.class, "com.obric.memorydata.plugin");
            goto L17
        L9:
            String r11 = "Element at index " + (r0.size() - r9) + " is null.";
            int r1 = r0.size() - 1;
        L10:
            if (r1 < r9) goto L13;
            r0.remove(r1);
            r1 = r1 - 1;
            goto L10
        L13:
            throw new NullPointerException(r11);
        L37:
            return;
        L23:
            if (ZeusTransformUtils.instanceOf(r6, PrimitiveNonBoxingCollection.class) == false) goto L25;
            r7.addAll((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin"));
            return;
        L25:
            addAllCheckingNulls(r6, r7);
        }

        private static <T> void addAllCheckingNulls(Iterable<T> r4, List<? super T> r5) {
            Iterable r6 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin");
            List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r6, Collection.class) == false) goto L10;
            int r0 = ((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")).size();
            if (ZeusTransformUtils.instanceOf(r7, ArrayList.class) == false) goto L8;
            ((ArrayList) ZeusTransformUtils.preCheckCast(r7, ArrayList.class, "com.obric.memorydata.plugin")).ensureCapacity(r7.size() + r0);
            goto L10
        L8:
            if (ZeusTransformUtils.instanceOf(r7, ProtobufArrayList.class) == false) goto L10;
            ((ProtobufArrayList) ZeusTransformUtils.preCheckCast(r7, ProtobufArrayList.class, "com.obric.memorydata.plugin")).ensureCapacity(r7.size() + r0);
        L10:
            int r1 = r7.size();
            if (ZeusTransformUtils.instanceOf(r6, List.class) == true) goto L13;
        L20:
            Iterator<T> r8 = r6.iterator();
        L22:
            if (r8.hasNext() == false) goto L34;
            T r2 = r8.next();
            if (r2 != null) goto L26;
            resetListAndThrow(r7, r1);
        L26:
            r7.add(r2);
            goto L22
        L34:
            return;
        L13:
            if (ZeusTransformUtils.instanceOf(r6, RandomAccess.class) == false) goto L20;
            List r9 = (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin");
            int r3 = r9.size();
            int r10 = 0;
        L15:
            if (r10 >= r3) goto L27;
            Object r11 = r9.get(r10);
            if (r11 != null) goto L19;
            resetListAndThrow(r7, r1);
        L19:
            r7.add(r11);
            r10 = r10 + 1;
            goto L15
        }

        private String getReadingExceptionMessage(String r3) {
            return "Reading " + getClass().getName() + " from a " + r3 + " threw an IOException (should never happen).";
        }

        public static UninitializedMessageException newUninitializedMessageException(MessageLite r2) {
            return new UninitializedMessageException((MessageLite) ZeusTransformUtils.wrapperContextForParams(r2, MessageLite.class, "com.obric.memorydata.plugin"));
        }

        private static void resetListAndThrow(List<?> r2, int r3) {
            List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
            String r0 = "Element at index " + (r4.size() - r3) + " is null.";
            int r1 = r4.size() - 1;
        L3:
            if (r1 < r3) goto L6;
            r4.remove(r1);
            r1 = r1 - 1;
            goto L3
        L6:
            throw new NullPointerException(r0);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public abstract BuilderType clone();

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clone() {
            return clone();
        }

        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo141clone() {
            return clone();
        }

        public abstract BuilderType internalMergeFrom(MessageType r1);

        @Override // com.google.protobuf.MessageLite.Builder
        public boolean mergeDelimitedFrom(InputStream r2) {
            return mergeDelimitedFrom(r2, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.google.protobuf.MessageLite.Builder
        public boolean mergeDelimitedFrom(InputStream r3, ExtensionRegistryLite r4) {
            int r0 = r3.read();
            if (r0 != (-1)) goto L6;
            return false;
        L6:
            mergeFrom(new LimitedInputStream(r3, CodedInputStream.readRawVarint32(r0, r3)), r4);
            return true;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(ByteString r3) {
            CodedInputStream r4 = r3.newCodedInput();     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            mergeFrom(r4);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            r4.checkLastTagWas(0);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            return this;
        L7:
            e = move-exception;
            throw e;
        L4:
            e = move-exception;
            throw new RuntimeException(getReadingExceptionMessage("ByteString"), e);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(ByteString r2, ExtensionRegistryLite r3) {
            CodedInputStream r4 = r2.newCodedInput();     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            mergeFrom(r4, r3);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            r4.checkLastTagWas(0);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            return this;
        L7:
            e = move-exception;
            throw e;
        L4:
            e = move-exception;
            throw new RuntimeException(getReadingExceptionMessage("ByteString"), e);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(CodedInputStream r2) {
            return (BuilderType) mergeFrom(r2, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public abstract BuilderType mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2);

        @Override // com.google.protobuf.MessageLite.Builder
        public BuilderType mergeFrom(MessageLite r3) {
            MessageLite r4 = (MessageLite) ZeusTransformUtils.wrapperContextForParams(r3, MessageLite.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(getDefaultInstanceForType().getClass(), r4) == false) goto L7;
            return (BuilderType) internalMergeFrom((AbstractMessageLite) ZeusTransformUtils.preCheckCast(r4, AbstractMessageLite.class, "com.obric.memorydata.plugin"));
        L7:
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(InputStream r2) {
            CodedInputStream r3 = CodedInputStream.newInstance(r2);
            mergeFrom(r3);
            r3.checkLastTagWas(0);
            return this;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(InputStream r1, ExtensionRegistryLite r2) {
            CodedInputStream r3 = CodedInputStream.newInstance(r1);
            mergeFrom(r3, r2);
            r3.checkLastTagWas(0);
            return this;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(byte[] r3) {
            return (BuilderType) mergeFrom(r3, 0, r3.length);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(byte[] r1, int r2, int r3) {
            CodedInputStream r4 = CodedInputStream.newInstance(r1, r2, r3);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            mergeFrom(r4);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            r4.checkLastTagWas(0);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            return this;
        L7:
            e = move-exception;
            throw e;
        L4:
            e = move-exception;
            throw new RuntimeException(getReadingExceptionMessage("byte array"), e);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(byte[] r1, int r2, int r3, ExtensionRegistryLite r4) {
            CodedInputStream r5 = CodedInputStream.newInstance(r1, r2, r3);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            mergeFrom(r5, r4);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            r5.checkLastTagWas(0);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            return this;
        L7:
            e = move-exception;
            throw e;
        L4:
            e = move-exception;
            throw new RuntimeException(getReadingExceptionMessage("byte array"), e);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(byte[] r3, ExtensionRegistryLite r4) {
            return (BuilderType) mergeFrom(r3, 0, r3.length, r4);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(ByteString r1) {
            return mergeFrom(r1);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(ByteString r1, ExtensionRegistryLite r2) {
            return mergeFrom(r1, r2);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r1) {
            return mergeFrom(r1);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
            return mergeFrom(r1, r2);
        }

        @Override // com.google.protobuf.MessageLite.Builder
        public /* synthetic */ MessageLite.Builder mergeFrom(MessageLite r3) {
            return mergeFrom((MessageLite) ZeusTransformUtils.wrapperContextForParams(r3, MessageLite.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(InputStream r1) {
            return mergeFrom(r1);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(InputStream r1, ExtensionRegistryLite r2) {
            return mergeFrom(r1, r2);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r1) {
            return mergeFrom(r1);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r1, int r2, int r3) {
            return mergeFrom(r1, r2, r3);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r1, int r2, int r3, ExtensionRegistryLite r4) {
            return mergeFrom(r1, r2, r3, r4);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r1, ExtensionRegistryLite r2) {
            return mergeFrom(r1, r2);
        }
    }

    protected interface InternalOneOfEnum {
        int getNumber();
    }

    public AbstractMessageLite() {
        this.memoizedHashCode = 0;
    }

    public static <T> void addAll(Iterable<T> r2, List<? super T> r3) {
        Builder.addAll((Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    public static void checkByteStringIsUtf8(ByteString r1) {
        if (r1.isValidUtf8() == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("Byte string is not UTF-8.");
    }

    private String getSerializingExceptionMessage(String r3) {
        return "Serializing " + getClass().getName() + " to a " + r3 + " threw an IOException (should never happen).";
    }

    int getMemoizedSerializedSize() {
        throw new UnsupportedOperationException();
    }

    int getSerializedSize(Schema r3) {
        Schema r4 = (Schema) ZeusTransformUtils.wrapperContextForParams(r3, Schema.class, "com.obric.memorydata.plugin");
        int r0 = getMemoizedSerializedSize();
        if (r0 != (-1)) goto L6;
        int r1 = r4.getSerializedSize(this);
        setMemoizedSerializedSize(r1);
        return r1;
    L6:
        return r0;
    }

    UninitializedMessageException newUninitializedMessageException() {
        return new UninitializedMessageException(this);
    }

    void setMemoizedSerializedSize(int r1) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.protobuf.MessageLite
    public byte[] toByteArray() {
        byte[] r0 = new byte[getSerializedSize()];     // Catch: IOException -> L4
        CodedOutputStream r1 = CodedOutputStream.newInstance(r0);     // Catch: IOException -> L4
        writeTo(r1);     // Catch: IOException -> L4
        r1.checkNoSpaceLeft();     // Catch: IOException -> L4
        return r0;
    L4:
        e = move-exception;
        throw new RuntimeException(getSerializingExceptionMessage("byte array"), e);
    }

    @Override // com.google.protobuf.MessageLite
    public ByteString toByteString() {
        ByteString.CodedBuilder r0 = ByteString.newCodedBuilder(getSerializedSize());     // Catch: IOException -> L4
        writeTo(r0.getCodedOutput());     // Catch: IOException -> L4
        return r0.build();
    L4:
        e = move-exception;
        throw new RuntimeException(getSerializingExceptionMessage("ByteString"), e);
    }

    @Override // com.google.protobuf.MessageLite
    public void writeDelimitedTo(OutputStream r3) {
        int r0 = getSerializedSize();
        CodedOutputStream r4 = CodedOutputStream.newInstance(r3, CodedOutputStream.computePreferredBufferSize(CodedOutputStream.computeUInt32SizeNoTag(r0) + r0));
        r4.writeUInt32NoTag(r0);
        writeTo(r4);
        r4.flush();
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(OutputStream r2) {
        CodedOutputStream r3 = CodedOutputStream.newInstance(r2, CodedOutputStream.computePreferredBufferSize(getSerializedSize()));
        writeTo(r3);
        r3.flush();
    }
}
