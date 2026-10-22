package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.a;
import com.google.crypto.tink.shaded.protobuf.a.AbstractC0207a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a<MessageType extends a<MessageType, BuilderType>, BuilderType extends AbstractC0207a<MessageType, BuilderType>> implements at {
    protected int memoizedHashCode;

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0207a<MessageType extends a<MessageType, BuilderType>, BuilderType extends AbstractC0207a<MessageType, BuilderType>> implements at.a {

        /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.a$a$a, reason: collision with other inner class name */
        static final class C0208a extends FilterInputStream {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private int f4934a;

            C0208a(InputStream r1, int r2) {
                super(r1);
                this.f4934a = r2;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int available() {
                return Math.min(super.available(), this.f4934a);
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read() {
                if (this.f4934a > 0) goto L6;
                return -1;
            L6:
                int r0 = super.read();
                if (r0 < 0) goto L9;
                this.f4934a--;
            L9:
                return r0;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read(byte[] r2, int r3, int r4) {
                int r0 = this.f4934a;
                if (r0 > 0) goto L6;
                return -1;
            L6:
                int r5 = super.read(r2, r3, Math.min(r4, r0));
                if (r5 < 0) goto L9;
                this.f4934a -= r5;
            L9:
                return r5;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public long skip(long r3) {
                int r4 = (int) super.skip(Math.min(r3, this.f4934a));
                if (r4 < 0) goto L6;
                this.f4934a -= r4;
            L6:
                return r4;
            }
        }

        public AbstractC0207a() {
        }

        private String a(String r3) {
            return "Reading " + getClass().getName() + " from a " + r3 + " threw an IOException (should never happen).";
        }

        public static <T> void a(Iterable<T> r4, List<? super T> r5) {
            Iterable r6 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin");
            List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            ab.a(r6);
            if (ZeusTransformUtils.instanceOf(r6, ah.class) == false) goto L19;
            List<?> r8 = ((ah) ZeusTransformUtils.preCheckCast(r6, ah.class, "com.obric.memorydata.plugin")).d();
            ah r0 = (ah) ZeusTransformUtils.preCheckCast(r7, ah.class, "com.obric.memorydata.plugin");
            int r9 = r7.size();
            Iterator<?> r10 = r8.iterator();
        L6:
            if (r10.hasNext() == false) goto L32;
            Object r2 = r10.next();
            if (r2 == null) goto L9;
            if (ZeusTransformUtils.instanceOf(r2, ByteString.class) == true) goto L16;
            r0.add((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin"));
            goto L6
        L16:
            r0.a((ByteString) ZeusTransformUtils.preCheckCast(r2, ByteString.class, "com.obric.memorydata.plugin"));
            goto L6
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
        L32:
            return;
        L19:
            if (ZeusTransformUtils.instanceOf(r6, bf.class) == false) goto L21;
            r7.addAll((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin"));
            return;
        L21:
            b(r6, r7);
        }

        private static <T> void b(Iterable<T> r4, List<? super T> r5) {
            Iterable r6 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin");
            List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r7, ArrayList.class) == true) goto L5;
        L7:
            int r0 = r7.size();
            Iterator<T> r8 = r6.iterator();
        L9:
            if (r8.hasNext() == false) goto L18;
            T r1 = r8.next();
            if (r1 == null) goto L12;
            r7.add(r1);
            goto L9
        L12:
            String r9 = "Element at index " + (r7.size() - r0) + " is null.";
            int r2 = r7.size() - 1;
        L13:
            if (r2 < r0) goto L16;
            r7.remove(r2);
            r2 = r2 - 1;
            goto L13
        L16:
            throw new NullPointerException(r9);
        L18:
            return;
        L5:
            if (ZeusTransformUtils.instanceOf(r6, Collection.class) == false) goto L7;
            ((ArrayList) ZeusTransformUtils.preCheckCast(r7, ArrayList.class, "com.obric.memorydata.plugin")).ensureCapacity(r7.size() + ((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")).size());
            goto L7
        }

        public static UninitializedMessageException c(at r2) {
            return new UninitializedMessageException((at) ZeusTransformUtils.wrapperContextForParams(r2, at.class, "com.obric.memorydata.plugin"));
        }

        public abstract BuilderType a();

        public abstract BuilderType a(MessageType r1);

        public BuilderType a(k r2) {
            return (BuilderType) a(r2, q.a());
        }

        public abstract BuilderType a(k r1, q r2);

        public BuilderType a(byte[] r1, int r2, int r3) {
            k r4 = k.a(r1, r2, r3);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            a(r4);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            r4.a(0);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            return this;
        L7:
            e = move-exception;
            throw e;
        L4:
            e = move-exception;
            throw new RuntimeException(a("byte array"), e);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.at.a
        public /* synthetic */ at.a a(at r3) {
            return b((at) ZeusTransformUtils.wrapperContextForParams(r3, at.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.at.a
        public /* synthetic */ at.a a(byte[] r1) {
            return b(r1);
        }

        public BuilderType b(at r3) {
            at r4 = (at) ZeusTransformUtils.wrapperContextForParams(r3, at.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(getDefaultInstanceForType().getClass(), r4) == false) goto L7;
            return (BuilderType) a((a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.memorydata.plugin"));
        L7:
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }

        public BuilderType b(byte[] r3) {
            return (BuilderType) a(r3, 0, r3.length);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.at.a
        public /* synthetic */ at.a b(k r1, q r2) {
            return a(r1, r2);
        }

        public /* synthetic */ Object clone() {
            return a();
        }
    }

    public a() {
        this.memoizedHashCode = 0;
    }

    @Deprecated
    public static <T> void addAll(Iterable<T> r2, Collection<? super T> r3) {
        AbstractC0207a.a((Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.preCheckCast((Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin"), List.class, "com.obric.memorydata.plugin"));
    }

    public static <T> void addAll(Iterable<T> r2, List<? super T> r3) {
        AbstractC0207a.a((Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
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

    int getSerializedSize(bl r3) {
        bl r4 = (bl) ZeusTransformUtils.wrapperContextForParams(r3, bl.class, "com.obric.memorydata.plugin");
        int r0 = getMemoizedSerializedSize();
        if (r0 != (-1)) goto L6;
        int r1 = r4.b(this);
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

    @Override // com.google.crypto.tink.shaded.protobuf.at
    public byte[] toByteArray() {
        byte[] r0 = new byte[getSerializedSize()];     // Catch: IOException -> L4
        CodedOutputStream r1 = CodedOutputStream.a(r0);     // Catch: IOException -> L4
        writeTo(r1);     // Catch: IOException -> L4
        r1.d();     // Catch: IOException -> L4
        return r0;
    L4:
        e = move-exception;
        throw new RuntimeException(getSerializingExceptionMessage("byte array"), e);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.at
    public ByteString toByteString() {
        ByteString.e r0 = ByteString.newCodedBuilder(getSerializedSize());     // Catch: IOException -> L4
        writeTo(r0.b());     // Catch: IOException -> L4
        return r0.a();
    L4:
        e = move-exception;
        throw new RuntimeException(getSerializingExceptionMessage("ByteString"), e);
    }

    public void writeDelimitedTo(OutputStream r3) {
        int r0 = getSerializedSize();
        CodedOutputStream r4 = CodedOutputStream.a(r3, CodedOutputStream.a(CodedOutputStream.j(r0) + r0));
        r4.c(r0);
        writeTo(r4);
        r4.b();
    }

    public void writeTo(OutputStream r2) {
        CodedOutputStream r3 = CodedOutputStream.a(r2, CodedOutputStream.a(getSerializedSize()));
        writeTo(r3);
        r3.b();
    }
}
