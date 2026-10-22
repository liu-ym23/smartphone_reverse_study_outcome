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

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractMessageLite<MessageType extends AbstractMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> implements MessageLite {
    protected int memoizedHashCode;

    public static abstract class Builder<MessageType extends AbstractMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> implements MessageLite.Builder {

        public static final class LimitedInputStream extends FilterInputStream {
            private int limit;

            public LimitedInputStream(InputStream r8, int r10) {
                super(r8);
                this.limit = r10;
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
                int r8 = super.read();
                if (r8 < 0) goto L9;
                this.limit--;
            L9:
                return r8;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public long skip(long r8) {
                int r10 = (int) super.skip(Math.min(r8, this.limit));
                if (r10 < 0) goto L6;
                this.limit -= r10;
            L6:
                return r10;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read(byte[] r8, int r10, int r11) {
                int r12 = this.limit;
                if (r12 > 0) goto L6;
                return -1;
            L6:
                int r13 = super.read(r8, r10, Math.min(r11, r12));
                if (r13 < 0) goto L9;
                this.limit -= r13;
            L9:
                return r13;
            }
        }

        public Builder() {
        }

        @Deprecated
        public static <T> void addAll(Iterable<T> r8, Collection<? super T> r10) {
            addAll(r8, (List) r10);
        }

        private static <T> void addAllCheckingNulls(Iterable<T> r8, List<? super T> r10) {
            if ((r8 instanceof Collection) == false) goto L10;
            int r11 = ((Collection) r8).size();
            if ((r10 instanceof ArrayList) == false) goto L8;
            ((ArrayList) r10).ensureCapacity(r10.size() + r11);
            goto L10
        L8:
            if ((r10 instanceof ProtobufArrayList) == false) goto L10;
            ((ProtobufArrayList) r10).ensureCapacity(r10.size() + r11);
        L10:
            int r12 = r10.size();
            if ((r8 instanceof List) == true) goto L13;
        L20:
            Iterator<T> r13 = r8.iterator();
        L22:
            if (r13.hasNext() == false) goto L34;
            Object r14 = r13.next();
            if (r14 != null) goto L26;
            resetListAndThrow(r10, r12);
        L26:
            r10.add(r14);
            goto L22
        L34:
            return;
        L13:
            if ((r8 instanceof RandomAccess) == false) goto L20;
            List r15 = (List) r8;
            int r16 = r15.size();
            int r17 = 0;
        L15:
            if (r17 >= r16) goto L27;
            a0.d r18 = (Object) r15.get(r17);
            if (r18 != null) goto L19;
            resetListAndThrow(r10, r12);
        L19:
            r10.add(r18);
            r17 = r17 + 1;
            goto L15
        }

        private String getReadingExceptionMessage(String r8) {
            return "Reading " + getClass().getName() + " from a " + r8 + " threw an IOException (should never happen).";
        }

        public static UninitializedMessageException newUninitializedMessageException(MessageLite r8) {
            return new UninitializedMessageException(r8);
        }

        private static void resetListAndThrow(List<?> r8, int r10) {
            String r11 = "Element at index " + (r8.size() - r10) + " is null.";
            int r12 = r8.size() - 1;
        L3:
            if (r12 < r10) goto L6;
            r8.remove(r12);
            r12 = r12 - 1;
            goto L3
        L6:
            throw new NullPointerException(r11);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public abstract BuilderType clone();

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clone() {
            return clone();
        }

        public abstract BuilderType internalMergeFrom(MessageType r8);

        @Override // com.google.protobuf.MessageLite.Builder
        public boolean mergeDelimitedFrom(InputStream r8) {
            return mergeDelimitedFrom(r8, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(ByteString r8) {
            CodedInputStream r10 = r8.newCodedInput();     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            mergeFrom(r10);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            r10.checkLastTagWas(0);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            return this;
        L7:
            e = move-exception;
            throw e;
        L4:
            e = move-exception;
            throw new RuntimeException(getReadingExceptionMessage("ByteString"), e);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public abstract BuilderType mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10);

        public static <T> void addAll(Iterable<T> r8, List<? super T> r10) {
            Internal.checkNotNull(r8);
            if ((r8 instanceof LazyStringList) == false) goto L23;
            List<?> r11 = ((LazyStringList) r8).getUnderlyingElements();
            LazyStringList r12 = (LazyStringList) r10;
            int r13 = r10.size();
            Iterator<?> r14 = r11.iterator();
        L6:
            if (r14.hasNext() == false) goto L37;
            Object r15 = r14.next();
            if (r15 == null) goto L9;
            if ((r15 instanceof ByteString) == true) goto L16;
            if ((r15 instanceof byte[]) == true) goto L20;
            r12.add((String) r15);
            goto L6
        L20:
            ByteString r16 = ByteString.copyFrom((byte[]) r15);
        L17:
            r12.add(r16);
            goto L6
        L16:
            r16 = (ByteString) r15;
            goto L17
        L9:
            String r17 = "Element at index " + (r12.size() - r13) + " is null.";
            int r18 = r12.size() - 1;
        L10:
            if (r18 < r13) goto L13;
            r12.remove(r18);
            r18 = r18 - 1;
            goto L10
        L13:
            throw new NullPointerException(r17);
        L37:
            return;
        L23:
            if ((r8 instanceof PrimitiveNonBoxingCollection) == false) goto L25;
            r10.addAll((Collection) r8);
            return;
        L25:
            addAllCheckingNulls(r8, r10);
        }

        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo1clone() {
            return clone();
        }

        @Override // com.google.protobuf.MessageLite.Builder
        public boolean mergeDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
            int r11 = r8.read();
            if (r11 != (-1)) goto L6;
            return false;
        L6:
            mergeFrom(new LimitedInputStream(r8, CodedInputStream.readRawVarint32(r11, r8)), r10);
            return true;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(ByteString r8, ExtensionRegistryLite r10) {
            CodedInputStream r11 = r8.newCodedInput();     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            mergeFrom(r11, r10);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
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
        public BuilderType mergeFrom(CodedInputStream r8) {
            return (BuilderType) mergeFrom(r8, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.google.protobuf.MessageLite.Builder
        public BuilderType mergeFrom(MessageLite r8) {
            if (getDefaultInstanceForType().getClass().isInstance(r8) == false) goto L7;
            return (BuilderType) internalMergeFrom((AbstractMessageLite) r8);
        L7:
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(InputStream r8) {
            CodedInputStream r10 = CodedInputStream.newInstance(r8);
            mergeFrom(r10);
            r10.checkLastTagWas(0);
            return this;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(InputStream r8, ExtensionRegistryLite r10) {
            CodedInputStream r11 = CodedInputStream.newInstance(r8);
            mergeFrom(r11, r10);
            r11.checkLastTagWas(0);
            return this;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(byte[] r8) {
            return (BuilderType) mergeFrom(r8, 0, r8.length);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(byte[] r8, int r10, int r11) {
            CodedInputStream r12 = CodedInputStream.newInstance(r8, r10, r11);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            mergeFrom(r12);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            r12.checkLastTagWas(0);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            return this;
        L7:
            e = move-exception;
            throw e;
        L4:
            e = move-exception;
            throw new RuntimeException(getReadingExceptionMessage("byte array"), e);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(byte[] r8, int r10, int r11, ExtensionRegistryLite r12) {
            CodedInputStream r13 = CodedInputStream.newInstance(r8, r10, r11);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            mergeFrom(r13, r12);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
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
        public BuilderType mergeFrom(byte[] r8, ExtensionRegistryLite r10) {
            return (BuilderType) mergeFrom(r8, 0, r8.length, r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(ByteString r8) {
            return mergeFrom(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(ByteString r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r8) {
            return mergeFrom(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(MessageLite r8) {
            return mergeFrom(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(InputStream r8) {
            return mergeFrom(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(InputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r8) {
            return mergeFrom(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r8, int r10, int r11) {
            return mergeFrom(r8, r10, r11);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r8, int r10, int r11, ExtensionRegistryLite r12) {
            return mergeFrom(r8, r10, r11, r12);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }
    }

    public interface InternalOneOfEnum {
        int getNumber();
    }

    public AbstractMessageLite() {
        this.memoizedHashCode = 0;
    }

    public static <T> void addAll(Iterable<T> r8, List<? super T> r10) {
        Builder.addAll(r8, r10);
    }

    public static void checkByteStringIsUtf8(ByteString r8) {
        if (r8.isValidUtf8() == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("Byte string is not UTF-8.");
    }

    private String getSerializingExceptionMessage(String r8) {
        return "Serializing " + getClass().getName() + " to a " + r8 + " threw an IOException (should never happen).";
    }

    public int getMemoizedSerializedSize() {
        throw new UnsupportedOperationException();
    }

    public int getSerializedSize(Schema r8) {
        int r10 = getMemoizedSerializedSize();
        if (r10 != (-1)) goto L6;
        int r11 = r8.getSerializedSize(this);
        setMemoizedSerializedSize(r11);
        return r11;
    L6:
        return r10;
    }

    public UninitializedMessageException newUninitializedMessageException() {
        return new UninitializedMessageException(this);
    }

    public void setMemoizedSerializedSize(int r8) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.protobuf.MessageLite
    public byte[] toByteArray() {
        byte[] r8 = new byte[getSerializedSize()];     // Catch: IOException -> L4
        CodedOutputStream r10 = CodedOutputStream.newInstance(r8);     // Catch: IOException -> L4
        writeTo(r10);     // Catch: IOException -> L4
        r10.checkNoSpaceLeft();     // Catch: IOException -> L4
        return r8;
    L4:
        e = move-exception;
        throw new RuntimeException(getSerializingExceptionMessage("byte array"), e);
    }

    @Override // com.google.protobuf.MessageLite
    public ByteString toByteString() {
        ByteString.CodedBuilder r8 = ByteString.newCodedBuilder(getSerializedSize());     // Catch: IOException -> L4
        writeTo(r8.getCodedOutput());     // Catch: IOException -> L4
        return r8.build();
    L4:
        e = move-exception;
        throw new RuntimeException(getSerializingExceptionMessage("ByteString"), e);
    }

    @Override // com.google.protobuf.MessageLite
    public void writeDelimitedTo(OutputStream r8) {
        int r10 = getSerializedSize();
        CodedOutputStream r11 = CodedOutputStream.newInstance(r8, CodedOutputStream.computePreferredBufferSize(CodedOutputStream.computeUInt32SizeNoTag(r10) + r10));
        r11.writeUInt32NoTag(r10);
        writeTo(r11);
        r11.flush();
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(OutputStream r8) {
        CodedOutputStream r10 = CodedOutputStream.newInstance(r8, CodedOutputStream.computePreferredBufferSize(getSerializedSize()));
        writeTo(r10);
        r10.flush();
    }
}
