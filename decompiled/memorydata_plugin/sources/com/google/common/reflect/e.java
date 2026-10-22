package com.google.common.reflect;

import com.google.common.base.h;
import com.google.common.base.k;
import com.google.common.base.n;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f4791a;

    private static final class a extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map<c, Type> f4794a;

        private a() {
            this.f4794a = Maps.c();
        }

        static ImmutableMap<c, Type> a(Type r3) {
            Type r4 = (Type) ZeusTransformUtils.wrapperContextForParams(r3, Type.class, "com.obric.memorydata.plugin");
            n.a(r4);
            a r0 = new a();
            r0.a(new Type[]{r4});
            return ImmutableMap.copyOf(r0.f4794a);
        }

        private void a(c r4, Type r5) {
            Type r6 = (Type) ZeusTransformUtils.wrapperContextForParams(r5, Type.class, "com.obric.memorydata.plugin");
            if (this.f4794a.containsKey(r4) == false) goto L5;
            return;
        L5:
            Type r0 = r6;
        L6:
            if (r0 == null) goto L13;
            if (r4.b(r0) == true) goto L9;
            r0 = (Type) ZeusTransformUtils.preCheckCast(this.f4794a.get(c.a(r0)), Type.class, "com.obric.memorydata.plugin");
        L9:
            if (r6 == null) goto L11;
            r6 = (Type) ZeusTransformUtils.preCheckCast(this.f4794a.remove(c.a(r6)), Type.class, "com.obric.memorydata.plugin");
            goto L9
        L11:
            return;
        L13:
            this.f4794a.put(r4, r6);
        }

        @Override // com.google.common.reflect.f
        void a(Class<?> r4) {
            a(new Type[]{r4.getGenericSuperclass()});
            a(r4.getGenericInterfaces());
        }

        @Override // com.google.common.reflect.f
        void a(ParameterizedType r9) {
            ParameterizedType r10 = (ParameterizedType) ZeusTransformUtils.wrapperContextForParams(r9, ParameterizedType.class, "com.obric.memorydata.plugin");
            Class r0 = (Class) ZeusTransformUtils.preCheckCast(r10.getRawType(), Class.class, "com.obric.memorydata.plugin");
            TypeVariable[] r1 = r0.getTypeParameters();
            Type[] r2 = r10.getActualTypeArguments();
            if (r1.length != r2.length) goto L5;
            boolean r3 = true;
        L6:
            n.b(r3);
            int r4 = 0;
        L8:
            if (r4 >= r1.length) goto L10;
            a(new c(r1[r4]), r2[r4]);
            r4 = r4 + 1;
            goto L8
        L10:
            a(new Type[]{r0});
            a(new Type[]{r10.getOwnerType()});
            return;
        L5:
            r3 = false;
            goto L6
        }

        @Override // com.google.common.reflect.f
        void a(TypeVariable<?> r3) {
            a(((TypeVariable) ZeusTransformUtils.wrapperContextForParams(r3, TypeVariable.class, "com.obric.memorydata.plugin")).getBounds());
        }

        @Override // com.google.common.reflect.f
        void a(WildcardType r3) {
            a(((WildcardType) ZeusTransformUtils.wrapperContextForParams(r3, WildcardType.class, "com.obric.memorydata.plugin")).getUpperBounds());
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ImmutableMap<c, Type> f4795a;

        b() {
            this.f4795a = ImmutableMap.of();
        }

        private b(ImmutableMap<c, Type> r1) {
            this.f4795a = r1;
        }

        final b a(Map<c, ? extends Type> r6) {
            Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
            ImmutableMap.a r0 = ImmutableMap.builder();
            r0.b(this.f4795a);
            Iterator r5 = r7.entrySet().iterator();
        L4:
            if (r5.hasNext() == false) goto L7;
            Map.Entry r8 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            c r2 = (c) ZeusTransformUtils.preCheckCast(r8.getKey(), c.class, "com.obric.memorydata.plugin");
            Type r9 = (Type) ZeusTransformUtils.preCheckCast(r8.getValue(), Type.class, "com.obric.memorydata.plugin");
            n.a(!r2.b(r9), "Type variable %s bound to itself", r2);
            r0.b(r2, r9);
            goto L4
        L7:
            return new b(r0.e());
        }

        final Type a(TypeVariable<?> r3) {
            final TypeVariable<?> r4 = (TypeVariable) ZeusTransformUtils.wrapperContextForParams(r3, TypeVariable.class, "com.obric.memorydata.plugin");
            return a(r4, new AnonymousClass1(this, r4, this));
        }

        Type a(TypeVariable<?> r3, b r4) {
            TypeVariable r5 = (TypeVariable) ZeusTransformUtils.wrapperContextForParams(r3, TypeVariable.class, "com.obric.memorydata.plugin");
            Type r2 = (Type) ZeusTransformUtils.preCheckCast(this.f4795a.get(new c(r5)), Type.class, "com.obric.memorydata.plugin");
            AnonymousClass1 r0 = null;
            if (r2 != null) goto L15;
            Type[] r6 = r5.getBounds();
            if (r6.length != 0) goto L7;
            return r5;
        L7:
            Type[] r7 = e.a(new e(r4, r0), r6);
            if (Types.a.f4781a == false) goto L13;
            if (Arrays.equals(r6, r7) == false) goto L13;
            return r5;
        L13:
            return Types.a(r5.getGenericDeclaration(), r5.getName(), r7);
        L15:
            return new e(r4, r0).c(r2);
        }
    }

    static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TypeVariable<?> f4798a;

        c(TypeVariable<?> r3) {
            this.f4798a = (TypeVariable) ZeusTransformUtils.preCheckCast(n.a((TypeVariable) ZeusTransformUtils.wrapperContextForParams(r3, TypeVariable.class, "com.obric.memorydata.plugin")), TypeVariable.class, "com.obric.memorydata.plugin");
        }

        static c a(Type r3) {
            Type r4 = (Type) ZeusTransformUtils.wrapperContextForParams(r3, Type.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r4, TypeVariable.class) == true) goto L5;
            return null;
        L5:
            return new c((TypeVariable) ZeusTransformUtils.preCheckCast(r4, TypeVariable.class, "com.obric.memorydata.plugin"));
        }

        private boolean a(TypeVariable<?> r3) {
            TypeVariable r4 = (TypeVariable) ZeusTransformUtils.wrapperContextForParams(r3, TypeVariable.class, "com.obric.memorydata.plugin");
            if (this.f4798a.getGenericDeclaration().equals(r4.getGenericDeclaration()) == true) goto L5;
        L7:
            return false;
        L5:
            if (this.f4798a.getName().equals(r4.getName()) == false) goto L7;
            return true;
        }

        boolean b(Type r3) {
            Type r4 = (Type) ZeusTransformUtils.wrapperContextForParams(r3, Type.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r4, TypeVariable.class) == true) goto L5;
            return false;
        L5:
            return a((TypeVariable) ZeusTransformUtils.preCheckCast(r4, TypeVariable.class, "com.obric.memorydata.plugin"));
        }

        public boolean equals(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, c.class) == true) goto L5;
            return false;
        L5:
            return a(((c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.memorydata.plugin")).f4798a);
        }

        public int hashCode() {
            return k.a(new Object[]{this.f4798a.getGenericDeclaration(), this.f4798a.getName()});
        }

        public String toString() {
            return this.f4798a.toString();
        }
    }

    private static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final d f4799a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AtomicInteger f4800b;

        static {
            f4799a = new d();
        }

        private d() {
            this(new AtomicInteger());
        }

        private d(AtomicInteger r1) {
            this.f4800b = r1;
        }

        /* synthetic */ d(AtomicInteger r1, AnonymousClass1 r2) {
            this(r1);
        }

        private d a() {
            return new d(this.f4800b);
        }

        private d a(TypeVariable<?> r3) {
            final TypeVariable r4 = (TypeVariable) ZeusTransformUtils.wrapperContextForParams(r3, TypeVariable.class, "com.obric.memorydata.plugin");
            final AtomicInteger r1 = this.f4800b;
            return new AnonymousClass1(this, r1, r4);
        }

        private Type b(Type r3) {
            Type r4 = (Type) ZeusTransformUtils.wrapperContextForParams(r3, Type.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L7;
            return null;
        L7:
            return a(r4);
        }

        final Type a(Type r7) {
            Type r8 = (Type) ZeusTransformUtils.wrapperContextForParams(r7, Type.class, "com.obric.memorydata.plugin");
            n.a(r8);
            if (ZeusTransformUtils.instanceOf(r8, Class.class) == false) goto L6;
            return r8;
        L6:
            if (ZeusTransformUtils.instanceOf(r8, TypeVariable.class) == false) goto L9;
            return r8;
        L9:
            if (ZeusTransformUtils.instanceOf(r8, GenericArrayType.class) == false) goto L13;
            GenericArrayType r9 = (GenericArrayType) ZeusTransformUtils.preCheckCast(r8, GenericArrayType.class, "com.obric.memorydata.plugin");
            return Types.a(a().a(r9.getGenericComponentType()));
        L13:
            if (ZeusTransformUtils.instanceOf(r8, ParameterizedType.class) == false) goto L21;
            ParameterizedType r10 = (ParameterizedType) ZeusTransformUtils.preCheckCast(r8, ParameterizedType.class, "com.obric.memorydata.plugin");
            Class r0 = (Class) ZeusTransformUtils.preCheckCast(r10.getRawType(), Class.class, "com.obric.memorydata.plugin");
            TypeVariable<?>[] r1 = r0.getTypeParameters();
            Type[] r2 = r10.getActualTypeArguments();
            int r3 = 0;
        L16:
            if (r3 >= r2.length) goto L19;
            r2[r3] = a(r1[r3]).a(r2[r3]);
            r3 = r3 + 1;
            goto L16
        L19:
            return Types.a(a().b(r10.getOwnerType()), r0, r2);
        L21:
            if (ZeusTransformUtils.instanceOf(r8, WildcardType.class) == false) goto L28;
            WildcardType r4 = (WildcardType) ZeusTransformUtils.preCheckCast(r8, WildcardType.class, "com.obric.memorydata.plugin");
            if (r4.getLowerBounds().length == 0) goto L25;
            return r8;
        L25:
            return a(r4.getUpperBounds());
        L28:
            throw new AssertionError("must have been one of the known types");
        }

        TypeVariable<?> a(Type[] r3) {
            return Types.a(d.class, "capture#" + this.f4800b.incrementAndGet() + "-of ? extends " + h.a(Typography.amp).a(r3), r3);
        }
    }

    public e() {
        this.f4791a = new b();
    }

    private e(b r1) {
        this.f4791a = r1;
    }

    /* synthetic */ e(b r1, AnonymousClass1 r2) {
        this(r1);
    }

    static e a(Type r2) {
        Type r3 = (Type) ZeusTransformUtils.wrapperContextForParams(r2, Type.class, "com.obric.memorydata.plugin");
        return new e().a(a.a(r3));
    }

    static /* synthetic */ Object a(Class r0, Object r1) {
        return b(r0, r1);
    }

    private ParameterizedType a(ParameterizedType r4) {
        ParameterizedType r5 = (ParameterizedType) ZeusTransformUtils.wrapperContextForParams(r4, ParameterizedType.class, "com.obric.memorydata.plugin");
        Type r0 = r5.getOwnerType();
        if (r0 != null) goto L5;
        Type r1 = null;
    L6:
        Type r2 = c(r5.getRawType());
        Type[] r3 = b(r5.getActualTypeArguments());
        return Types.a(r1, (Class) ZeusTransformUtils.preCheckCast(r2, Class.class, "com.obric.memorydata.plugin"), r3);
    L5:
        r1 = c(r0);
        goto L6
    }

    private Type a(GenericArrayType r3) {
        return Types.a(c(((GenericArrayType) ZeusTransformUtils.wrapperContextForParams(r3, GenericArrayType.class, "com.obric.memorydata.plugin")).getGenericComponentType()));
    }

    private WildcardType a(WildcardType r3) {
        WildcardType r4 = (WildcardType) ZeusTransformUtils.wrapperContextForParams(r3, WildcardType.class, "com.obric.memorydata.plugin");
        Type[] r0 = r4.getLowerBounds();
        Type[] r5 = r4.getUpperBounds();
        return new Types.WildcardTypeImpl(b(r0), b(r5));
    }

    static /* synthetic */ void a(Map r2, Type r3, Type r4) {
        b((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin"), (Type) ZeusTransformUtils.wrapperContextForParams(r3, Type.class, "com.obric.memorydata.plugin"), (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ Type[] a(e r0, Type[] r1) {
        return r0.b(r1);
    }

    static e b(Type r2) {
        Type r3 = (Type) ZeusTransformUtils.wrapperContextForParams(r2, Type.class, "com.obric.memorydata.plugin");
        Type r4 = d.f4799a.a(r3);
        return new e().a(a.a(r4));
    }

    private static <T> T b(Class<T> r2, Object r3) {
        return r2.cast(r3);
    L5:
        throw new IllegalArgumentException(r3 + " is not a " + r2.getSimpleName());
    }

    private static void b(Map<c, Type> r2, Type r3, Type r4) {
        final Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        Type r6 = (Type) ZeusTransformUtils.wrapperContextForParams(r3, Type.class, "com.obric.memorydata.plugin");
        final Type r7 = (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.memorydata.plugin");
        if (r6.equals(r7) == false) goto L5;
        return;
    L5:
        new AnonymousClass1(r5, r7).a(new Type[]{r6});
    }

    private Type[] b(Type[] r4) {
        Type[] r0 = new Type[r4.length];
        int r1 = 0;
    L4:
        if (r1 >= r4.length) goto L6;
        r0[r1] = c(r4[r1]);
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    public e a(Type r4, Type r5) {
        Type r6 = (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.memorydata.plugin");
        Type r7 = (Type) ZeusTransformUtils.wrapperContextForParams(r5, Type.class, "com.obric.memorydata.plugin");
        HashMap r0 = Maps.c();
        b(r0, (Type) ZeusTransformUtils.preCheckCast(n.a(r6), Type.class, "com.obric.memorydata.plugin"), (Type) ZeusTransformUtils.preCheckCast(n.a(r7), Type.class, "com.obric.memorydata.plugin"));
        return a(r0);
    }

    e a(Map<c, ? extends Type> r3) {
        Map<c, ? extends Type> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        return new e(this.f4791a.a(r4));
    }

    Type[] a(Type[] r3) {
        int r0 = 0;
    L4:
        if (r0 >= r3.length) goto L6;
        r3[r0] = c(r3[r0]);
        r0 = r0 + 1;
        goto L4
    L6:
        return r3;
    }

    public Type c(Type r3) {
        Type r4 = (Type) ZeusTransformUtils.wrapperContextForParams(r3, Type.class, "com.obric.memorydata.plugin");
        n.a(r4);
        if (ZeusTransformUtils.instanceOf(r4, TypeVariable.class) == false) goto L7;
        return this.f4791a.a((TypeVariable) ZeusTransformUtils.preCheckCast(r4, TypeVariable.class, "com.obric.memorydata.plugin"));
    L7:
        if (ZeusTransformUtils.instanceOf(r4, ParameterizedType.class) == false) goto L11;
        return a((ParameterizedType) ZeusTransformUtils.preCheckCast(r4, ParameterizedType.class, "com.obric.memorydata.plugin"));
    L11:
        if (ZeusTransformUtils.instanceOf(r4, GenericArrayType.class) == false) goto L15;
        return a((GenericArrayType) ZeusTransformUtils.preCheckCast(r4, GenericArrayType.class, "com.obric.memorydata.plugin"));
    L15:
        if (ZeusTransformUtils.instanceOf(r4, WildcardType.class) == true) goto L17;
        return r4;
    L17:
        return a((WildcardType) ZeusTransformUtils.preCheckCast(r4, WildcardType.class, "com.obric.memorydata.plugin"));
    }
}
