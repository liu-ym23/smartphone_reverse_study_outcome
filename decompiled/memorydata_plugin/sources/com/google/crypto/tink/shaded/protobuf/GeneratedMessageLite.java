package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class GeneratedMessageLite<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends com.google.crypto.tink.shaded.protobuf.a<MessageType, BuilderType> {
    private static final int MEMOIZED_SERIALIZED_SIZE_MASK = Integer.MAX_VALUE;
    private static final int MUTABLE_FLAG_MASK = Integer.MIN_VALUE;
    static final int UNINITIALIZED_HASH_CODE = 0;
    static final int UNINITIALIZED_SERIALIZED_SIZE = Integer.MAX_VALUE;
    private static Map<Object, GeneratedMessageLite<?, ?>> defaultInstanceMap;
    private int memoizedSerializedSize;
    protected bu unknownFields;

    public static final enum MethodToInvoke extends Enum<MethodToInvoke> {
        private static final /* synthetic */ MethodToInvoke[] $VALUES = null;
        public static final MethodToInvoke BUILD_MESSAGE_INFO = null;
        public static final MethodToInvoke GET_DEFAULT_INSTANCE = null;
        public static final MethodToInvoke GET_MEMOIZED_IS_INITIALIZED = null;
        public static final MethodToInvoke GET_PARSER = null;
        public static final MethodToInvoke NEW_BUILDER = null;
        public static final MethodToInvoke NEW_MUTABLE_INSTANCE = null;
        public static final MethodToInvoke SET_MEMOIZED_IS_INITIALIZED = null;

        static {
            MethodToInvoke r0 = new MethodToInvoke("GET_MEMOIZED_IS_INITIALIZED", 0);
            GET_MEMOIZED_IS_INITIALIZED = r0;
            MethodToInvoke r1 = new MethodToInvoke("SET_MEMOIZED_IS_INITIALIZED", 1);
            SET_MEMOIZED_IS_INITIALIZED = r1;
            MethodToInvoke r3 = new MethodToInvoke("BUILD_MESSAGE_INFO", 2);
            BUILD_MESSAGE_INFO = r3;
            MethodToInvoke r5 = new MethodToInvoke("NEW_MUTABLE_INSTANCE", 3);
            NEW_MUTABLE_INSTANCE = r5;
            MethodToInvoke r7 = new MethodToInvoke("NEW_BUILDER", 4);
            NEW_BUILDER = r7;
            MethodToInvoke r9 = new MethodToInvoke("GET_DEFAULT_INSTANCE", 5);
            GET_DEFAULT_INSTANCE = r9;
            MethodToInvoke r11 = new MethodToInvoke("GET_PARSER", 6);
            GET_PARSER = r11;
            $VALUES = new MethodToInvoke[]{r0, r1, r3, r5, r7, r9, r11};
        }

        private MethodToInvoke(String r1, int r2) {
            super(r1, r2);
        }

        public static MethodToInvoke valueOf(String r2) {
            return (MethodToInvoke) ZeusTransformUtils.preCheckCast(Enum.valueOf(MethodToInvoke.class, r2), MethodToInvoke.class, "com.obric.memorydata.plugin");
        }

        public static MethodToInvoke[] values() {
            return (MethodToInvoke[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MethodToInvoke[].class, "com.obric.memorydata.plugin");
        }
    }

    protected static final class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        private final byte[] asBytes;
        private final Class<?> messageClass;
        private final String messageClassName;

        SerializedForm(at r3) {
            at r4 = (at) ZeusTransformUtils.wrapperContextForParams(r3, at.class, "com.obric.memorydata.plugin");
            this.messageClass = r4.getClass();
            this.messageClassName = r4.getClass().getName();
            this.asBytes = r4.toByteArray();
        }

        public static SerializedForm of(at r2) {
            return new SerializedForm((at) ZeusTransformUtils.wrapperContextForParams(r2, at.class, "com.obric.memorydata.plugin"));
        }

        @Deprecated
        private Object readResolveFallback() {
            java.lang.reflect.Field r0 = resolveMessageClass().getDeclaredField("defaultInstance");     // Catch: InvalidProtocolBufferException -> L4 IllegalAccessException -> L7 SecurityException -> L10 NoSuchFieldException -> L13 ClassNotFoundException -> L16
            r0.setAccessible(true);     // Catch: InvalidProtocolBufferException -> L4 IllegalAccessException -> L7 SecurityException -> L10 NoSuchFieldException -> L13 ClassNotFoundException -> L16
            return ((at) ZeusTransformUtils.preCheckCast(r0.get(null), at.class, "com.obric.memorydata.plugin")).newBuilderForType().a(this.asBytes).b();
        L4:
            e = move-exception;
            throw new RuntimeException("Unable to understand proto buffer", e);
        L16:
            e = move-exception;
            throw new RuntimeException("Unable to find proto buffer class: " + this.messageClassName, e);
        L7:
            e = move-exception;
            throw new RuntimeException("Unable to call parsePartialFrom", e);
        L13:
            e = move-exception;
            throw new RuntimeException("Unable to find defaultInstance in " + this.messageClassName, e);
        L10:
            e = move-exception;
            throw new RuntimeException("Unable to call defaultInstance in " + this.messageClassName, e);
        }

        private Class<?> resolveMessageClass() {
            Class<?> r0 = this.messageClass;
            if (r0 == null) goto L6;
            return r0;
        L6:
            return ZeusTransformUtils.forName(this.messageClassName, "com.obric.memorydata.plugin");
        }

        public Object readResolve() {
            java.lang.reflect.Field r0 = resolveMessageClass().getDeclaredField("DEFAULT_INSTANCE");     // Catch: InvalidProtocolBufferException -> L4 IllegalAccessException -> L7 SecurityException -> L10 NoSuchFieldException -> L13 ClassNotFoundException -> L15
            r0.setAccessible(true);     // Catch: InvalidProtocolBufferException -> L4 IllegalAccessException -> L7 SecurityException -> L10 NoSuchFieldException -> L13 ClassNotFoundException -> L15
            return ((at) ZeusTransformUtils.preCheckCast(r0.get(null), at.class, "com.obric.memorydata.plugin")).newBuilderForType().a(this.asBytes).b();
        L4:
            e = move-exception;
            throw new RuntimeException("Unable to understand proto buffer", e);
        L15:
            e = move-exception;
            throw new RuntimeException("Unable to find proto buffer class: " + this.messageClassName, e);
        L7:
            e = move-exception;
            throw new RuntimeException("Unable to call parsePartialFrom", e);
        L10:
            e = move-exception;
            throw new RuntimeException("Unable to call DEFAULT_INSTANCE in " + this.messageClassName, e);
        L14:
            return readResolveFallback();
        }
    }

    public static abstract class a<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends com.google.crypto.tink.shaded.protobuf.a.AbstractC0207a<MessageType, BuilderType> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected MessageType f4911a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final MessageType f4912b;

        public a(MessageType r1) {
            this.f4912b = r1;
            if (r1.isMutable() == true) goto L7;
            this.f4911a = (MessageType) j();
            return;
        L7:
            throw new IllegalArgumentException("Default instance must be immutable.");
        }

        private static <MessageType> void a(MessageType r1, MessageType r2) {
            bg.a().a(r1).b(r1, r2);
        }

        private MessageType j() {
            return (MessageType) this.f4912b.newMutableInstance();
        }

        public BuilderType a(MessageType r1) {
            return (BuilderType) b(r1);
        }

        public BuilderType a(byte[] r9, int r10, int r11, q r12) {
            d();
            bg.a().a(this.f4911a).a(this.f4911a, r9, r10, r10 + r11, new g.a(r12));     // Catch: IOException -> L5 IndexOutOfBoundsException -> L8 InvalidProtocolBufferException -> L10
            return this;
        L10:
            e = move-exception;
            throw e;
        L5:
            e = move-exception;
            throw new RuntimeException("Reading from byte array should not throw IOException.", e);
        L9:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.a.AbstractC0207a
        public /* synthetic */ com.google.crypto.tink.shaded.protobuf.a.AbstractC0207a a() {
            return f();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.a.AbstractC0207a
        public /* synthetic */ com.google.crypto.tink.shaded.protobuf.a.AbstractC0207a a(com.google.crypto.tink.shaded.protobuf.a r3) {
            return a((GeneratedMessageLite) ZeusTransformUtils.preCheckCast(r3, GeneratedMessageLite.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.a.AbstractC0207a
        public /* synthetic */ com.google.crypto.tink.shaded.protobuf.a.AbstractC0207a a(k r1, q r2) {
            return c(r1, r2);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.a.AbstractC0207a
        public /* synthetic */ com.google.crypto.tink.shaded.protobuf.a.AbstractC0207a a(byte[] r1, int r2, int r3) {
            return b(r1, r2, r3);
        }

        public BuilderType b(MessageType r2) {
            if (i().equals(r2) == false) goto L5;
            return this;
        L5:
            d();
            a(this.f4911a, r2);
            return this;
        }

        public BuilderType b(byte[] r2, int r3, int r4) {
            return (BuilderType) a(r2, r3, r4, q.a());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.a.AbstractC0207a, com.google.crypto.tink.shaded.protobuf.at.a
        public /* synthetic */ at.a b(k r1, q r2) {
            return c(r1, r2);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.at.a
        public /* synthetic */ at b() {
            return g();
        }

        public BuilderType c(k r3, q r4) {
            d();
            bg.a().a(this.f4911a).a(this.f4911a, l.a(r3), r4);     // Catch: RuntimeException -> L5
            return this;
        L5:
            e = move-exception;
            if (ZeusTransformUtils.instanceOf(e.getCause(), IOException.class) == true) goto L9;
            throw e;
        L9:
            throw ((IOException) ZeusTransformUtils.preCheckCast(e.getCause(), IOException.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.at.a
        public /* synthetic */ at c() {
            return h();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.a.AbstractC0207a
        public /* synthetic */ Object clone() {
            return f();
        }

        public final void d() {
            if (this.f4911a.isMutable() == true) goto L6;
            e();
            return;
        }

        public void e() {
            MessageType r0 = (MessageType) j();
            a(r0, this.f4911a);
            this.f4911a = r0;
        }

        public BuilderType f() {
            BuilderType r0 = (BuilderType) i().newBuilderForType();
            r0.f4911a = (MessageType) g();
            return r0;
        }

        public MessageType g() {
            if (this.f4911a.isMutable() == false) goto L5;
            this.f4911a.makeImmutable();
            return this.f4911a;
        L5:
            return this.f4911a;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.au
        public /* synthetic */ at getDefaultInstanceForType() {
            return i();
        }

        public final MessageType h() {
            MessageType r1 = (MessageType) g();
            if (r1.isInitialized() == false) goto L6;
            return r1;
        L6:
            throw c(r1);
        }

        public MessageType i() {
            return this.f4912b;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.au
        public final boolean isInitialized() {
            return GeneratedMessageLite.isInitialized(this.f4911a, false);
        }
    }

    protected static class b<T extends GeneratedMessageLite<T, ?>> extends com.google.crypto.tink.shaded.protobuf.b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final T f4913a;

        public b(T r1) {
            this.f4913a = r1;
        }

        public T a(k r1, q r2) {
            return (T) GeneratedMessageLite.parsePartialFrom(this.f4913a, r1, r2);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.be
        public /* synthetic */ Object b(k r1, q r2) {
            return a(r1, r2);
        }
    }

    public static abstract class c<MessageType extends c<MessageType, BuilderType>, BuilderType extends Object<MessageType, BuilderType>> extends GeneratedMessageLite<MessageType, BuilderType> implements z<MessageType, BuilderType> {
        protected w<d> extensions;

        public c() {
            this.extensions = w.b();
        }

        w<d> a() {
            if (this.extensions.e() == false) goto L6;
            this.extensions = this.extensions.f();
        L6:
            return this.extensions;
        }
    }

    static final class d implements w.a<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ab.d<?> f4914a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f4915b;
        final WireFormat.FieldType c;
        final boolean d;
        final boolean e;

        d(ab.d<?> r3, int r4, WireFormat.FieldType r5, boolean r6, boolean r7) {
            this.f4914a = (ab.d) ZeusTransformUtils.wrapperContextForParams(r3, ab.d.class, "com.obric.memorydata.plugin");
            this.f4915b = r4;
            this.c = r5;
            this.d = r6;
            this.e = r7;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.w.a
        public int a() {
            return this.f4915b;
        }

        public int a(d r1) {
            return this.f4915b - r1.f4915b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.crypto.tink.shaded.protobuf.w.a
        public at.a a(at.a r2, at r3) {
            at.a r1 = (at.a) ZeusTransformUtils.wrapperContextForParams(r2, at.a.class, "com.obric.memorydata.plugin");
            at r4 = (at) ZeusTransformUtils.wrapperContextForParams(r3, at.class, "com.obric.memorydata.plugin");
            return ((a) ZeusTransformUtils.preCheckCast(r1, a.class, "com.obric.memorydata.plugin")).b((GeneratedMessageLite) ZeusTransformUtils.preCheckCast(r4, GeneratedMessageLite.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.w.a
        public WireFormat.FieldType b() {
            return this.c;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.w.a
        public WireFormat.JavaType c() {
            return this.c.getJavaType();
        }

        @Override // java.lang.Comparable
        public /* synthetic */ int compareTo(Object r3) {
            return a((d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.w.a
        public boolean d() {
            return this.d;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.w.a
        public boolean e() {
            return this.e;
        }

        public ab.d<?> f() {
            return this.f4914a;
        }
    }

    public static class e<ContainingType extends at, Type> extends o<ContainingType, Type> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ContainingType f4916a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Type f4917b;
        final at c;
        final d d;

        e(ContainingType r2, Type r3, at r4, d r5, Class r6) {
            ContainingType r7 = (ContainingType) ZeusTransformUtils.wrapperContextForParams(r2, at.class, "com.obric.memorydata.plugin");
            at r8 = (at) ZeusTransformUtils.wrapperContextForParams(r4, at.class, "com.obric.memorydata.plugin");
            if (r7 == null) goto L13;
            if (r5.b() != WireFormat.FieldType.MESSAGE) goto L10;
            if (r8 != null) goto L10;
            throw new IllegalArgumentException("Null messageDefaultInstance");
        L10:
            this.f4916a = r7;
            this.f4917b = r3;
            this.c = r8;
            this.d = r5;
            return;
        L13:
            throw new IllegalArgumentException("Null containingTypeDefaultInstance");
        }

        public int b() {
            return this.d.a();
        }

        public at c() {
            return this.c;
        }

        public WireFormat.FieldType d() {
            return this.d.b();
        }

        public boolean e() {
            return this.d.d;
        }
    }

    static {
        defaultInstanceMap = new ConcurrentHashMap();
    }

    public GeneratedMessageLite() {
        this.memoizedSerializedSize = -1;
        this.unknownFields = bu.a();
    }

    static /* synthetic */ e access$000(o r0) {
        return checkIsLite(r0);
    }

    static /* synthetic */ GeneratedMessageLite access$200(GeneratedMessageLite r0, byte[] r1, int r2, int r3, q r4) {
        return parsePartialFrom(r0, r1, r2, r3, r4);
    }

    private static <MessageType extends c<MessageType, BuilderType>, BuilderType extends Object<MessageType, BuilderType>, T> e<MessageType, T> checkIsLite(o<MessageType, T> r2) {
        if (r2.a() == false) goto L7;
        return (e) ZeusTransformUtils.preCheckCast(r2, e.class, "com.obric.memorydata.plugin");
    L7:
        throw new IllegalArgumentException("Expected a lite extension.");
    }

    private static <T extends GeneratedMessageLite<T, ?>> T checkMessageInitialized(T r1) {
        if (r1 != null) goto L4;
    L8:
        return r1;
    L4:
        if (r1.isInitialized() == true) goto L8;
        throw r1.newUninitializedMessageException().asInvalidProtocolBufferException().setUnfinishedMessage(r1);
    }

    private int computeSerializedSize(bl<?> r3) {
        bl r4 = (bl) ZeusTransformUtils.wrapperContextForParams(r3, bl.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L7;
        return bg.a().a(this).b(this);
    L7:
        return r4.b(this);
    }

    public static ab.a emptyBooleanList() {
        return h.d();
    }

    public static ab.b emptyDoubleList() {
        return n.d();
    }

    public static ab.f emptyFloatList() {
        return x.d();
    }

    public static ab.g emptyIntList() {
        return aa.d();
    }

    public static ab.h emptyLongList() {
        return al.d();
    }

    public static <E> ab.i<E> emptyProtobufList() {
        return bh.d();
    }

    private void ensureUnknownFieldsInitialized() {
        if (this.unknownFields != bu.a()) goto L6;
        this.unknownFields = bu.b();
        return;
    }

    static <T extends GeneratedMessageLite<?, ?>> T getDefaultInstance(Class<T> r5) {
        GeneratedMessageLite<?, ?> r1 = (GeneratedMessageLite) ZeusTransformUtils.preCheckCast(defaultInstanceMap.get(r5), GeneratedMessageLite.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L16;
    L9:
        if (r1 != null) goto L15;
        r1 = (T) ((GeneratedMessageLite) ZeusTransformUtils.preCheckCast(bx.a(r5), GeneratedMessageLite.class, "com.obric.memorydata.plugin")).getDefaultInstanceForType();
        if (r1 == null) goto L14;
        defaultInstanceMap.put(r5, r1);
        goto L15
    L14:
        throw new IllegalStateException();
    L15:
        return (T) r1;
    L16:
        Class.forName(r5.getName(), true, r5.getClassLoader());     // Catch: ClassNotFoundException -> L6
        r1 = (GeneratedMessageLite) ZeusTransformUtils.preCheckCast(defaultInstanceMap.get(r5), GeneratedMessageLite.class, "com.obric.memorydata.plugin");
    L6:
        e = move-exception;
        throw new IllegalStateException("Class initialization cannot fail.", e);
    }

    static Method getMethodOrDie(Class r3, String r4, Class... r5) {
        return r3.getMethod(r4, r5);
    L4:
        e = move-exception;
        throw new RuntimeException("Generated message class \"" + r3.getName() + "\" missing method \"" + r4 + "\".", e);
    }

    static Object invokeOrDie(Method r0, Object r1, Object... r2) {
        return r0.invoke(r1, r2);
    L15:
        e = move-exception;
        throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
    L4:
        e = move-exception;
        Throwable r3 = e.getCause();
        if (ZeusTransformUtils.instanceOf(r3, RuntimeException.class) == true) goto L14;
        if (ZeusTransformUtils.instanceOf(r3, Error.class) == false) goto L12;
        throw ((Error) ZeusTransformUtils.preCheckCast(r3, Error.class, "com.obric.memorydata.plugin"));
    L12:
        throw new RuntimeException("Unexpected exception thrown by generated accessor method.", r3);
    L14:
        throw ((RuntimeException) ZeusTransformUtils.preCheckCast(r3, RuntimeException.class, "com.obric.memorydata.plugin"));
    }

    public static final <T extends GeneratedMessageLite<T, ?>> boolean isInitialized(T r3, boolean r4) {
        byte r0 = ((Byte) ZeusTransformUtils.preCheckCast(r3.dynamicMethod(MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED), Byte.class, "com.obric.memorydata.plugin")).byteValue();
        if (r0 != 1) goto L5;
        return true;
    L5:
        if (r0 != 0) goto L8;
        return false;
    L8:
        boolean r1 = bg.a().a(r3).e(r3);
        if (r4 == false) goto L15;
        MethodToInvoke r5 = MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED;
        if (r1 == false) goto L13;
        Object r2 = r3;
    L14:
        r3.dynamicMethod(r5, r2);
        goto L15
    L13:
        r2 = null;
    L15:
        return r1;
    }

    public static ab.a mutableCopy(ab.a r2) {
        ab.a r3 = (ab.a) ZeusTransformUtils.wrapperContextForParams(r2, ab.a.class, "com.obric.memorydata.plugin");
        int r0 = r3.size();
        if (r0 != 0) goto L5;
        int r1 = 10;
    L7:
        return r3.a(r1);
    L5:
        r1 = r0 * 2;
        goto L7
    }

    public static ab.b mutableCopy(ab.b r2) {
        ab.b r3 = (ab.b) ZeusTransformUtils.wrapperContextForParams(r2, ab.b.class, "com.obric.memorydata.plugin");
        int r0 = r3.size();
        if (r0 != 0) goto L5;
        int r1 = 10;
    L7:
        return r3.a(r1);
    L5:
        r1 = r0 * 2;
        goto L7
    }

    public static ab.f mutableCopy(ab.f r2) {
        ab.f r3 = (ab.f) ZeusTransformUtils.wrapperContextForParams(r2, ab.f.class, "com.obric.memorydata.plugin");
        int r0 = r3.size();
        if (r0 != 0) goto L5;
        int r1 = 10;
    L7:
        return r3.a(r1);
    L5:
        r1 = r0 * 2;
        goto L7
    }

    public static ab.g mutableCopy(ab.g r2) {
        ab.g r3 = (ab.g) ZeusTransformUtils.wrapperContextForParams(r2, ab.g.class, "com.obric.memorydata.plugin");
        int r0 = r3.size();
        if (r0 != 0) goto L5;
        int r1 = 10;
    L7:
        return r3.a(r1);
    L5:
        r1 = r0 * 2;
        goto L7
    }

    public static ab.h mutableCopy(ab.h r2) {
        ab.h r3 = (ab.h) ZeusTransformUtils.wrapperContextForParams(r2, ab.h.class, "com.obric.memorydata.plugin");
        int r0 = r3.size();
        if (r0 != 0) goto L5;
        int r1 = 10;
    L7:
        return r3.a(r1);
    L5:
        r1 = r0 * 2;
        goto L7
    }

    public static <E> ab.i<E> mutableCopy(ab.i<E> r2) {
        ab.i r3 = (ab.i) ZeusTransformUtils.wrapperContextForParams(r2, ab.i.class, "com.obric.memorydata.plugin");
        int r0 = r3.size();
        if (r0 != 0) goto L5;
        int r1 = 10;
    L7:
        return r3.e(r1);
    L5:
        r1 = r0 * 2;
        goto L7
    }

    public static Object newMessageInfo(at r2, String r3, Object[] r4) {
        return new bj((at) ZeusTransformUtils.wrapperContextForParams(r2, at.class, "com.obric.memorydata.plugin"), r3, r4);
    }

    public static <ContainingType extends at, Type> e<ContainingType, Type> newRepeatedGeneratedExtension(ContainingType r11, at r12, ab.d<?> r13, int r14, WireFormat.FieldType r15, boolean r16, Class r17) {
        at r0 = (at) ZeusTransformUtils.wrapperContextForParams(r11, at.class, "com.obric.memorydata.plugin");
        at r2 = (at) ZeusTransformUtils.wrapperContextForParams(r12, at.class, "com.obric.memorydata.plugin");
        ab.d r4 = (ab.d) ZeusTransformUtils.wrapperContextForParams(r13, ab.d.class, "com.obric.memorydata.plugin");
        return new e(r0, Collections.emptyList(), r2, new d(r4, r14, r15, true, r16), r17);
    }

    public static <ContainingType extends at, Type> e<ContainingType, Type> newSingularGeneratedExtension(ContainingType r12, Type r13, at r14, ab.d<?> r15, int r16, WireFormat.FieldType r17, Class r18) {
        return new e((at) ZeusTransformUtils.wrapperContextForParams(r12, at.class, "com.obric.memorydata.plugin"), r13, (at) ZeusTransformUtils.wrapperContextForParams(r14, at.class, "com.obric.memorydata.plugin"), new d((ab.d) ZeusTransformUtils.wrapperContextForParams(r15, ab.d.class, "com.obric.memorydata.plugin"), r16, r17, false, false), r18);
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseDelimitedFrom(T r1, InputStream r2) {
        return (T) checkMessageInitialized(parsePartialDelimitedFrom(r1, r2, q.a()));
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseDelimitedFrom(T r0, InputStream r1, q r2) {
        return (T) checkMessageInitialized(parsePartialDelimitedFrom(r0, r1, r2));
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r1, ByteString r2) {
        return (T) checkMessageInitialized(parseFrom(r1, r2, q.a()));
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r0, ByteString r1, q r2) {
        return (T) checkMessageInitialized(parsePartialFrom(r0, r1, r2));
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r1, k r2) {
        return (T) parseFrom(r1, r2, q.a());
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r0, k r1, q r2) {
        return (T) checkMessageInitialized(parsePartialFrom(r0, r1, r2));
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r1, InputStream r2) {
        return (T) checkMessageInitialized(parsePartialFrom(r1, k.a(r2), q.a()));
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r0, InputStream r1, q r2) {
        return (T) checkMessageInitialized(parsePartialFrom(r0, k.a(r1), r2));
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r1, ByteBuffer r2) {
        return (T) parseFrom(r1, r2, q.a());
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r0, ByteBuffer r1, q r2) {
        return (T) checkMessageInitialized(parseFrom(r0, k.a(r1), r2));
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r3, byte[] r4) {
        return (T) checkMessageInitialized(parsePartialFrom(r3, r4, 0, r4.length, q.a()));
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r2, byte[] r3, q r4) {
        return (T) checkMessageInitialized(parsePartialFrom(r2, r3, 0, r3.length, r4));
    }

    private static <T extends GeneratedMessageLite<T, ?>> T parsePartialDelimitedFrom(T r2, InputStream r3, q r4) {
        int r0 = r3.read();     // Catch: IOException -> L13 InvalidProtocolBufferException -> L16
        if (r0 != (-1)) goto L6;
        return null;
    L6:
        k r5 = k.a(new com.google.crypto.tink.shaded.protobuf.a.AbstractC0207a.C0208a(r3, k.a(r0, r3)));
        T r6 = (T) parsePartialFrom(r2, r5, r4);
        r5.a(0);     // Catch: InvalidProtocolBufferException -> L10
        return r6;
    L10:
        e = move-exception;
        throw e.setUnfinishedMessage(r6);
    L16:
        e = move-exception;
        if (e.getThrownFromInputStream() == true) goto L20;
        throw e;
    L20:
        throw new InvalidProtocolBufferException(e);
    L13:
        e = move-exception;
        throw new InvalidProtocolBufferException(e);
    }

    private static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T r0, ByteString r1, q r2) {
        k r3 = r1.newCodedInput();
        T r4 = (T) parsePartialFrom(r0, r3, r2);
        r3.a(0);     // Catch: InvalidProtocolBufferException -> L5
        return r4;
    L5:
        e = move-exception;
        throw e.setUnfinishedMessage(r4);
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T r1, k r2) {
        return (T) parsePartialFrom(r1, r2, q.a());
    }

    static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T r2, k r3, q r4) {
        T r5 = (T) r2.newMutableInstance();
        bl r1 = bg.a().a(r5);     // Catch: RuntimeException -> L5 IOException -> L11 UninitializedMessageException -> L18 InvalidProtocolBufferException -> L21
        r1.a(r5, l.a(r3), r4);     // Catch: RuntimeException -> L5 IOException -> L11 UninitializedMessageException -> L18 InvalidProtocolBufferException -> L21
        r1.d(r5);     // Catch: RuntimeException -> L5 IOException -> L11 UninitializedMessageException -> L18 InvalidProtocolBufferException -> L21
        return r5;
    L21:
        e = e;
        if (e.getThrownFromInputStream() == false) goto L26;
        e = new InvalidProtocolBufferException(e);
    L26:
        throw e.setUnfinishedMessage(r5);
    L18:
        e = move-exception;
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(r5);
    L11:
        e = move-exception;
        if (ZeusTransformUtils.instanceOf(e.getCause(), InvalidProtocolBufferException.class) == false) goto L17;
        throw ((InvalidProtocolBufferException) ZeusTransformUtils.preCheckCast(e.getCause(), InvalidProtocolBufferException.class, "com.obric.memorydata.plugin"));
    L17:
        throw new InvalidProtocolBufferException(e).setUnfinishedMessage(r5);
    L5:
        e = move-exception;
        if (ZeusTransformUtils.instanceOf(e.getCause(), InvalidProtocolBufferException.class) == true) goto L9;
        throw e;
    L9:
        throw ((InvalidProtocolBufferException) ZeusTransformUtils.preCheckCast(e.getCause(), InvalidProtocolBufferException.class, "com.obric.memorydata.plugin"));
    }

    private static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T r7, byte[] r8, int r9, int r10, q r11) {
        T r12 = (T) r7.newMutableInstance();
        bl r6 = bg.a().a(r12);     // Catch: IndexOutOfBoundsException -> L5 IOException -> L7 UninitializedMessageException -> L14 InvalidProtocolBufferException -> L17
        r6.a(r12, r8, r9, r9 + r10, new g.a(r11));     // Catch: IndexOutOfBoundsException -> L5 IOException -> L7 UninitializedMessageException -> L14 InvalidProtocolBufferException -> L17
        r6.d(r12);     // Catch: IndexOutOfBoundsException -> L5 IOException -> L7 UninitializedMessageException -> L14 InvalidProtocolBufferException -> L17
        return r12;
    L17:
        e = e;
        if (e.getThrownFromInputStream() == false) goto L22;
        e = new InvalidProtocolBufferException(e);
    L22:
        throw e.setUnfinishedMessage(r12);
    L14:
        e = move-exception;
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(r12);
    L7:
        e = move-exception;
        if (ZeusTransformUtils.instanceOf(e.getCause(), InvalidProtocolBufferException.class) == false) goto L13;
        throw ((InvalidProtocolBufferException) ZeusTransformUtils.preCheckCast(e.getCause(), InvalidProtocolBufferException.class, "com.obric.memorydata.plugin"));
    L13:
        throw new InvalidProtocolBufferException(e).setUnfinishedMessage(r12);
    L6:
        throw InvalidProtocolBufferException.truncatedMessage().setUnfinishedMessage(r12);
    }

    public static <T extends GeneratedMessageLite<?, ?>> void registerDefaultInstance(Class<T> r1, T r2) {
        r2.markImmutable();
        defaultInstanceMap.put(r1, r2);
    }

    Object buildMessageInfo() {
        return dynamicMethod(MethodToInvoke.BUILD_MESSAGE_INFO);
    }

    void clearMemoizedHashCode() {
        this.memoizedHashCode = 0;
    }

    void clearMemoizedSerializedSize() {
        setMemoizedSerializedSize(Integer.MAX_VALUE);
    }

    int computeHashCode() {
        return bg.a().a(this).a(this);
    }

    public final <MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> BuilderType createBuilder() {
        return (BuilderType) ZeusTransformUtils.preCheckCast(dynamicMethod(MethodToInvoke.NEW_BUILDER), a.class, "com.obric.memorydata.plugin");
    }

    public final <MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> BuilderType createBuilder(MessageType r1) {
        return (BuilderType) createBuilder().b(r1);
    }

    public Object dynamicMethod(MethodToInvoke r2) {
        return dynamicMethod(r2, null, null);
    }

    public Object dynamicMethod(MethodToInvoke r2, Object r3) {
        return dynamicMethod(r2, r3, null);
    }

    public abstract Object dynamicMethod(MethodToInvoke r1, Object r2, Object r3);

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if (r4 != null) goto L9;
        return false;
    L9:
        if (getClass() == r4.getClass()) goto L12;
        return false;
    L12:
        return bg.a().a(this).a(this, (GeneratedMessageLite) ZeusTransformUtils.preCheckCast(r4, GeneratedMessageLite.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.au
    public final MessageType getDefaultInstanceForType() {
        return (MessageType) ZeusTransformUtils.preCheckCast(dynamicMethod(MethodToInvoke.GET_DEFAULT_INSTANCE), GeneratedMessageLite.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.crypto.tink.shaded.protobuf.au
    public /* bridge */ /* synthetic */ at getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    int getMemoizedHashCode() {
        return this.memoizedHashCode;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.a
    int getMemoizedSerializedSize() {
        return this.memoizedSerializedSize & Integer.MAX_VALUE;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.at
    public final be<MessageType> getParserForType() {
        return (be) ZeusTransformUtils.preCheckCast(dynamicMethod(MethodToInvoke.GET_PARSER), be.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.crypto.tink.shaded.protobuf.at
    public int getSerializedSize() {
        return getSerializedSize(null);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.a
    int getSerializedSize(bl r3) {
        bl<?> r4 = (bl) ZeusTransformUtils.wrapperContextForParams(r3, bl.class, "com.obric.memorydata.plugin");
        if (isMutable() == false) goto L10;
        int r2 = computeSerializedSize(r4);
        if (r2 < 0) goto L8;
        return r2;
    L8:
        throw new IllegalStateException("serialized size must be non-negative, was " + r2);
    L10:
        if (getMemoizedSerializedSize() != Integer.MAX_VALUE) goto L12;
        int r5 = computeSerializedSize(r4);
        setMemoizedSerializedSize(r5);
        return r5;
    L12:
        return getMemoizedSerializedSize();
    }

    public int hashCode() {
        if (isMutable() == false) goto L7;
        return computeHashCode();
    L7:
        if (hashCodeIsNotMemoized() == false) goto L10;
        setMemoizedHashCode(computeHashCode());
    L10:
        return getMemoizedHashCode();
    }

    boolean hashCodeIsNotMemoized() {
        if (getMemoizedHashCode() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.au
    public final boolean isInitialized() {
        return isInitialized(this, Boolean.TRUE.booleanValue());
    }

    boolean isMutable() {
        if ((this.memoizedSerializedSize & Integer.MIN_VALUE) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void makeImmutable() {
        bg.a().a(this).d(this);
        markImmutable();
    }

    void markImmutable() {
        this.memoizedSerializedSize &= Integer.MAX_VALUE;
    }

    public void mergeLengthDelimitedField(int r1, ByteString r2) {
        ensureUnknownFieldsInitialized();
        this.unknownFields.a(r1, r2);
    }

    public final void mergeUnknownFields(bu r2) {
        this.unknownFields = bu.a(this.unknownFields, r2);
    }

    public void mergeVarintField(int r1, int r2) {
        ensureUnknownFieldsInitialized();
        this.unknownFields.a(r1, r2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.at
    public final BuilderType newBuilderForType() {
        return (BuilderType) ZeusTransformUtils.preCheckCast(dynamicMethod(MethodToInvoke.NEW_BUILDER), a.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.crypto.tink.shaded.protobuf.at
    public /* bridge */ /* synthetic */ at.a newBuilderForType() {
        return newBuilderForType();
    }

    MessageType newMutableInstance() {
        return (MessageType) ZeusTransformUtils.preCheckCast(dynamicMethod(MethodToInvoke.NEW_MUTABLE_INSTANCE), GeneratedMessageLite.class, "com.obric.memorydata.plugin");
    }

    public boolean parseUnknownField(int r3, k r4) {
        if (WireFormat.a(r3) != 4) goto L6;
        return false;
    L6:
        ensureUnknownFieldsInitialized();
        return this.unknownFields.a(r3, r4);
    }

    void setMemoizedHashCode(int r1) {
        this.memoizedHashCode = r1;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.a
    void setMemoizedSerializedSize(int r3) {
        if (r3 < 0) goto L6;
        this.memoizedSerializedSize = (r3 & Integer.MAX_VALUE) | (this.memoizedSerializedSize & Integer.MIN_VALUE);
        return;
    L6:
        throw new IllegalStateException("serialized size must be non-negative, was " + r3);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.at
    public final BuilderType toBuilder() {
        return (BuilderType) ((a) ZeusTransformUtils.preCheckCast(dynamicMethod(MethodToInvoke.NEW_BUILDER), a.class, "com.obric.memorydata.plugin")).b(this);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.at
    public /* bridge */ /* synthetic */ at.a toBuilder() {
        return toBuilder();
    }

    public String toString() {
        return av.a(this, super.toString());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.at
    public void writeTo(CodedOutputStream r2) {
        bg.a().a(this).a(this, m.a(r2));
    }
}
