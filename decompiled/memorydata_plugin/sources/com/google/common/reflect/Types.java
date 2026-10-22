package com.google.common.reflect;

import com.google.common.base.Predicates;
import com.google.common.base.h;
import com.google.common.base.k;
import com.google.common.base.n;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.aj;
import com.google.common.collect.bj;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.security.AccessControlException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.text.Typography;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
final class Types {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final h f4779a = null;

    private static abstract enum ClassOwnership extends Enum<ClassOwnership> {
        private static final /* synthetic */ ClassOwnership[] $VALUES = null;
        static final ClassOwnership JVM_BEHAVIOR = null;
        public static final ClassOwnership LOCAL_CLASS_HAS_NO_OWNER = null;
        public static final ClassOwnership OWNED_BY_ENCLOSING_CLASS = null;

        class a<T> {
            a() {
            }
        }

        private static /* synthetic */ ClassOwnership[] $values() {
            return new ClassOwnership[]{OWNED_BY_ENCLOSING_CLASS, LOCAL_CLASS_HAS_NO_OWNER};
        }

        static {
            final String r1 = "OWNED_BY_ENCLOSING_CLASS";
            final int r2 = 0;
            OWNED_BY_ENCLOSING_CLASS = new AnonymousClass1(r1, r2);
            final String r3 = "LOCAL_CLASS_HAS_NO_OWNER";
            final int r4 = 1;
            LOCAL_CLASS_HAS_NO_OWNER = new AnonymousClass2(r3, r4);
            $VALUES = $values();
            JVM_BEHAVIOR = detectJvmBehavior();
        }

        private ClassOwnership(String r1, int r2) {
            super(r1, r2);
        }

        /* synthetic */ ClassOwnership(String r1, int r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        private static ClassOwnership detectJvmBehavior() {
            ParameterizedType r0 = (ParameterizedType) ZeusTransformUtils.preCheckCast(Objects.requireNonNull((ParameterizedType) ZeusTransformUtils.preCheckCast(new AnonymousClass3().getClass().getGenericSuperclass(), ParameterizedType.class, "com.obric.memorydata.plugin")), ParameterizedType.class, "com.obric.memorydata.plugin");
            ClassOwnership[] r1 = values();
            int r2 = r1.length;
            int r3 = 0;
        L3:
            if (r3 >= r2) goto L9;
            ClassOwnership r4 = r1[r3];
            if (r4.getOwnerType(a.class) == r0.getOwnerType()) goto L6;
            r3 = r3 + 1;
            goto L3
        L6:
            return r4;
        L9:
            throw new AssertionError();
        }

        public static ClassOwnership valueOf(String r2) {
            return (ClassOwnership) ZeusTransformUtils.preCheckCast(Enum.valueOf(ClassOwnership.class, r2), ClassOwnership.class, "com.obric.memorydata.plugin");
        }

        public static ClassOwnership[] values() {
            return (ClassOwnership[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ClassOwnership[].class, "com.obric.memorydata.plugin");
        }

        abstract Class<?> getOwnerType(Class<?> r1);
    }

    private static final class GenericArrayTypeImpl implements Serializable, GenericArrayType {
        private static final long serialVersionUID = 0;
        private final Type componentType;

        GenericArrayTypeImpl(Type r3) {
            Type r4 = (Type) ZeusTransformUtils.wrapperContextForParams(r3, Type.class, "com.obric.memorydata.plugin");
            this.componentType = JavaVersion.CURRENT.usedInGenericType(r4);
        }

        public boolean equals(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, GenericArrayType.class) == false) goto L6;
            GenericArrayType r4 = (GenericArrayType) ZeusTransformUtils.preCheckCast(r3, GenericArrayType.class, "com.obric.memorydata.plugin");
            return k.a(getGenericComponentType(), r4.getGenericComponentType());
        L6:
            return false;
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.componentType;
        }

        public int hashCode() {
            return this.componentType.hashCode();
        }

        public String toString() {
            return Types.d(this.componentType) + HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
    }

    static abstract enum JavaVersion extends Enum<JavaVersion> {
        private static final /* synthetic */ JavaVersion[] $VALUES = null;
        static final JavaVersion CURRENT = null;
        public static final JavaVersion JAVA6 = null;
        public static final JavaVersion JAVA7 = null;
        public static final JavaVersion JAVA8 = null;
        public static final JavaVersion JAVA9 = null;

        private static /* synthetic */ JavaVersion[] $values() {
            return new JavaVersion[]{JAVA6, JAVA7, JAVA8, JAVA9};
        }

        static {
            final String r1 = "JAVA6";
            final int r2 = 0;
            JavaVersion r0 = new AnonymousClass1(r1, r2);
            JAVA6 = r0;
            final String r3 = "JAVA7";
            final int r4 = 1;
            JavaVersion r5 = new AnonymousClass2(r3, r4);
            JAVA7 = r5;
            final String r6 = "JAVA8";
            final int r7 = 2;
            JavaVersion r8 = new AnonymousClass3(r6, r7);
            JAVA8 = r8;
            final String r9 = "JAVA9";
            final int r10 = 3;
            JavaVersion r11 = new AnonymousClass4(r9, r10);
            JAVA9 = r11;
            $VALUES = $values();
            if (AnnotatedElement.class.isAssignableFrom(TypeVariable.class) == false) goto L9;
            if (new AnonymousClass5().capture().toString().contains("java.util.Map.java.util.Map") == false) goto L7;
            CURRENT = r8;
            return;
        L7:
            CURRENT = r11;
            return;
        L9:
            if (ZeusTransformUtils.instanceOf(new AnonymousClass6().capture(), Class.class) == false) goto L11;
            CURRENT = r5;
            return;
        L11:
            CURRENT = r0;
        }

        private JavaVersion(String r1, int r2) {
            super(r1, r2);
        }

        /* synthetic */ JavaVersion(String r1, int r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        public static JavaVersion valueOf(String r2) {
            return (JavaVersion) ZeusTransformUtils.preCheckCast(Enum.valueOf(JavaVersion.class, r2), JavaVersion.class, "com.obric.memorydata.plugin");
        }

        public static JavaVersion[] values() {
            return (JavaVersion[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), JavaVersion[].class, "com.obric.memorydata.plugin");
        }

        boolean jdkTypeDuplicatesOwnerName() {
            return true;
        }

        abstract Type newArrayType(Type r1);

        String typeName(Type r2) {
            return Types.d((Type) ZeusTransformUtils.wrapperContextForParams(r2, Type.class, "com.obric.memorydata.plugin"));
        }

        final ImmutableList<Type> usedInGenericType(Type[] r5) {
            ImmutableList.a r0 = ImmutableList.builder();
            int r1 = r5.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L6;
            r0.b(usedInGenericType(r5[r2]));
            r2 = r2 + 1;
            goto L3
        L6:
            return r0.a();
        }

        abstract Type usedInGenericType(Type r1);
    }

    private static final class ParameterizedTypeImpl implements Serializable, ParameterizedType {
        private static final long serialVersionUID = 0;
        private final ImmutableList<Type> argumentsList;
        private final Type ownerType;
        private final Class<?> rawType;

        ParameterizedTypeImpl(Type r3, Class<?> r4, Type[] r5) {
            Type r6 = (Type) ZeusTransformUtils.wrapperContextForParams(r3, Type.class, "com.obric.memorydata.plugin");
            n.a(r4);
            if (r5.length != r4.getTypeParameters().length) goto L5;
            boolean r0 = true;
        L6:
            n.a(r0);
            Types.a(r5, "type parameter");
            this.ownerType = r6;
            this.rawType = r4;
            this.argumentsList = JavaVersion.CURRENT.usedInGenericType(r5);
            return;
        L5:
            r0 = false;
            goto L6
        }

        public boolean equals(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, ParameterizedType.class) == true) goto L5;
            return false;
        L5:
            ParameterizedType r5 = (ParameterizedType) ZeusTransformUtils.preCheckCast(r4, ParameterizedType.class, "com.obric.memorydata.plugin");
            if (getRawType().equals(r5.getRawType()) == true) goto L8;
            return false;
        L8:
            if (k.a(getOwnerType(), r5.getOwnerType()) == true) goto L10;
            return false;
        L10:
            if (Arrays.equals(getActualTypeArguments(), r5.getActualTypeArguments()) == false) goto L15;
            return true;
        L15:
            return false;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return Types.a(this.argumentsList);
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.ownerType;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.rawType;
        }

        public int hashCode() {
            Type r0 = this.ownerType;
            if (r0 != null) goto L5;
            int r1 = 0;
        L6:
            int r2 = r1 ^ this.argumentsList.hashCode();
            return this.rawType.hashCode() ^ r2;
        L5:
            r1 = r0.hashCode();
            goto L6
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            if (this.ownerType != null) goto L5;
        L7:
            StringBuilder r1 = r0.append(this.rawType.getName()).append(Typography.less);
            h r2 = Types.a();
            ImmutableList<Type> r4 = this.argumentsList;
            final JavaVersion r3 = JavaVersion.CURRENT;
            Objects.requireNonNull(r3);
            return r1.append(r2.a(aj.a(r4, new $$Lambda$jz0U_jcaptCr3yYotGGf3eRW9NM(r3)))).append(Typography.greater).toString();
        L5:
            if (JavaVersion.CURRENT.jdkTypeDuplicatesOwnerName() == false) goto L7;
            r0.append(JavaVersion.CURRENT.typeName(this.ownerType)).append('.');
            goto L7
        }
    }

    static final class WildcardTypeImpl implements Serializable, WildcardType {
        private static final long serialVersionUID = 0;
        private final ImmutableList<Type> lowerBounds;
        private final ImmutableList<Type> upperBounds;

        WildcardTypeImpl(Type[] r2, Type[] r3) {
            Types.a(r2, "lower bound for wildcard");
            Types.a(r3, "upper bound for wildcard");
            this.lowerBounds = JavaVersion.CURRENT.usedInGenericType(r2);
            this.upperBounds = JavaVersion.CURRENT.usedInGenericType(r3);
        }

        public boolean equals(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, WildcardType.class) == false) goto L10;
            WildcardType r5 = (WildcardType) ZeusTransformUtils.preCheckCast(r4, WildcardType.class, "com.obric.memorydata.plugin");
            if (this.lowerBounds.equals(Arrays.asList(r5.getLowerBounds())) == true) goto L7;
            return false;
        L7:
            if (this.upperBounds.equals(Arrays.asList(r5.getUpperBounds())) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            return Types.a(this.lowerBounds);
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return Types.a(this.upperBounds);
        }

        public int hashCode() {
            int r0 = this.lowerBounds.hashCode();
            return this.upperBounds.hashCode() ^ r0;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder("?");
            bj<Type> r1 = this.lowerBounds.iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            Type r2 = (Type) ZeusTransformUtils.preCheckCast(r1.next(), Type.class, "com.obric.memorydata.plugin");
            r0.append(" super ").append(JavaVersion.CURRENT.typeName(r2));
            goto L4
        L6:
            Iterator r5 = Types.a(this.upperBounds).iterator();
        L8:
            if (r5.hasNext() == false) goto L11;
            Type r3 = (Type) ZeusTransformUtils.preCheckCast(r5.next(), Type.class, "com.obric.memorydata.plugin");
            r0.append(" extends ").append(JavaVersion.CURRENT.typeName(r3));
            goto L8
        L11:
            return r0.toString();
        }
    }

    static final class a<X> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final boolean f4781a = false;

        static {
            f4781a = !a.class.getTypeParameters()[0].equals(Types.a(a.class, "X", new Type[0]));
        }

        a() {
        }
    }

    private static final class b<D extends GenericDeclaration> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final D f4782a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f4783b;
        private final ImmutableList<Type> c;

        b(D r3, String r4, Type[] r5) {
            GenericDeclaration r6 = (GenericDeclaration) ZeusTransformUtils.wrapperContextForParams(r3, GenericDeclaration.class, "com.obric.memorydata.plugin");
            Types.a(r5, "bound for type variable");
            this.f4782a = (D) ZeusTransformUtils.preCheckCast(n.a(r6), GenericDeclaration.class, "com.obric.memorydata.plugin");
            this.f4783b = (String) ZeusTransformUtils.preCheckCast(n.a(r4), String.class, "com.obric.memorydata.plugin");
            this.c = ImmutableList.copyOf(r5);
        }

        public D a() {
            return this.f4782a;
        }

        public String b() {
            return this.f4783b;
        }

        public boolean equals(Object r6) {
            if (a.f4781a == false) goto L20;
            if (r6 != null) goto L6;
        L18:
            return false;
        L6:
            if (Proxy.isProxyClass(r6.getClass()) == false) goto L18;
            if (ZeusTransformUtils.instanceOf(Proxy.getInvocationHandler(r6), c.class) == false) goto L18;
            b r7 = c.a((c) ZeusTransformUtils.preCheckCast(Proxy.getInvocationHandler(r6), c.class, "com.obric.memorydata.plugin"));
            if (this.f4783b.equals(r7.b()) == false) goto L17;
            if (this.f4782a.equals(r7.a()) == false) goto L17;
            if (this.c.equals(r7.c) == false) goto L17;
            return true;
        L17:
            return false;
        L20:
            if (ZeusTransformUtils.instanceOf(r6, TypeVariable.class) == false) goto L28;
            TypeVariable r8 = (TypeVariable) ZeusTransformUtils.preCheckCast(r6, TypeVariable.class, "com.obric.memorydata.plugin");
            if (this.f4783b.equals(r8.getName()) == false) goto L27;
            if (this.f4782a.equals(r8.getGenericDeclaration()) == false) goto L27;
            return true;
        L27:
            return false;
        L28:
            return false;
        }

        public int hashCode() {
            int r0 = this.f4782a.hashCode();
            return this.f4783b.hashCode() ^ r0;
        }

        public String toString() {
            return this.f4783b;
        }
    }

    private static final class c implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final ImmutableMap<String, Method> f4784a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final b<?> f4785b;

        static {
            ImmutableMap.a r0 = ImmutableMap.builder();
            Method[] r1 = b.class.getMethods();
            int r2 = r1.length;
            int r3 = 0;
        L3:
            if (r3 >= r2) goto L10;
            Method r4 = r1[r3];
            if (r4.getDeclaringClass().equals(b.class) == false) goto L9;
            r4.setAccessible(true);     // Catch: AccessControlException -> L12
        L8:
            r0.b(r4.getName(), r4);
        L9:
            r3 = r3 + 1;
            goto L3
        L10:
            f4784a = r0.d();
        }

        c(b<?> r1) {
            this.f4785b = r1;
        }

        static /* synthetic */ b a(c r0) {
            return r0.f4785b;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object r3, Method r4, Object[] r5) {
            String r6 = r4.getName();
            Method r7 = (Method) ZeusTransformUtils.preCheckCast(f4784a.get(r6), Method.class, "com.obric.memorydata.plugin");
            if (r7 == null) goto L10;
            return r7.invoke(this.f4785b, r5);
        L6:
            e = move-exception;
            throw e.getCause();
        L10:
            throw new UnsupportedOperationException(r6);
        }
    }

    static {
        f4779a = h.a(", ").b("null");
    }

    static /* synthetic */ h a() {
        return f4779a;
    }

    static Class<?> a(Class<?> r1) {
        return Array.newInstance(r1, 0).getClass();
    }

    static /* synthetic */ Iterable a(Iterable r2) {
        return b((Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin"));
    }

    static ParameterizedType a(Class<?> r2, Type... r3) {
        return new ParameterizedTypeImpl(ClassOwnership.JVM_BEHAVIOR.getOwnerType(r2), r2, r3);
    }

    static ParameterizedType a(Type r2, Class<?> r3, Type... r4) {
        Type r5 = (Type) ZeusTransformUtils.wrapperContextForParams(r2, Type.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L5;
        n.a(r4);
        if (r3.getEnclosingClass() == null) goto L9;
        boolean r0 = true;
    L10:
        n.a(r0, "Owner type for unenclosed %s", r3);
        return new ParameterizedTypeImpl(r5, r3, r4);
    L9:
        r0 = false;
        goto L10
    L5:
        return a(r3, r4);
    }

    static Type a(Type r5) {
        Type r6 = (Type) ZeusTransformUtils.wrapperContextForParams(r5, Type.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, WildcardType.class) == false) goto L19;
        WildcardType r7 = (WildcardType) ZeusTransformUtils.preCheckCast(r6, WildcardType.class, "com.obric.memorydata.plugin");
        Type[] r0 = r7.getLowerBounds();
        boolean r3 = true;
        if (r0.length > 1) goto L7;
        boolean r1 = true;
    L8:
        n.a(r1, "Wildcard cannot have more than one lower bounds.");
        if (r0.length == 1) goto L11;
        Type[] r8 = r7.getUpperBounds();
        if (r8.length == 1) goto L16;
        r3 = false;
    L16:
        n.a(r3, "Wildcard should have only one upper bound.");
        return b(a(r8[0]));
    L11:
        return c(a(r0[0]));
    L7:
        r1 = false;
        goto L8
    L19:
        return JavaVersion.CURRENT.newArrayType(r6);
    }

    static /* synthetic */ Type a(Type[] r0) {
        return b(r0);
    }

    static <D extends GenericDeclaration> TypeVariable<D> a(D r2, String r3, Type... r4) {
        GenericDeclaration r5 = (GenericDeclaration) ZeusTransformUtils.wrapperContextForParams(r2, GenericDeclaration.class, "com.obric.memorydata.plugin");
        if (r4.length != 0) goto L6;
        r4 = new Type[]{Object.class};
    L6:
        return b(r5, r3, r4);
    }

    static /* synthetic */ void a(Type[] r0, String r1) {
        b(r0, r1);
    }

    static /* synthetic */ Type[] a(Collection r2) {
        return b((Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin"));
    }

    private static Iterable<Type> b(Iterable<Type> r2) {
        return aj.b((Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin"), Predicates.a(Predicates.a(Object.class)));
    }

    private static Type b(Type[] r3) {
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L14;
        Type r2 = e(r3[r1]);
        if (r2 != null) goto L7;
        r1 = r1 + 1;
        goto L3
    L7:
        if (ZeusTransformUtils.instanceOf(r2, Class.class) == false) goto L12;
        Class r4 = (Class) ZeusTransformUtils.preCheckCast(r2, Class.class, "com.obric.memorydata.plugin");
        if (r4.isPrimitive() == false) goto L12;
        return r4;
    L12:
        return b(r2);
    L14:
        return null;
    }

    private static <D extends GenericDeclaration> TypeVariable<D> b(D r2, String r3, Type[] r4) {
        return (TypeVariable) ZeusTransformUtils.preCheckCast(com.google.common.reflect.b.a(TypeVariable.class, new c(new b((GenericDeclaration) ZeusTransformUtils.wrapperContextForParams(r2, GenericDeclaration.class, "com.obric.memorydata.plugin"), r3, r4))), TypeVariable.class, "com.obric.memorydata.plugin");
    }

    static WildcardType b(Type r4) {
        return new WildcardTypeImpl(new Type[0], new Type[]{(Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.memorydata.plugin")});
    }

    private static void b(Type[] r5, String r6) {
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        Type r2 = r5[r1];
        if (ZeusTransformUtils.instanceOf(r2, Class.class) == false) goto L7;
        Class r3 = (Class) ZeusTransformUtils.preCheckCast(r2, Class.class, "com.obric.memorydata.plugin");
        n.a(!r3.isPrimitive(), "Primitive type '%s' used as %s", r3, r6);
    L7:
        r1 = r1 + 1;
        goto L3
    }

    private static Type[] b(Collection<Type> r2) {
        return (Type[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin")).toArray(new Type[0]), Type[].class, "com.obric.memorydata.plugin");
    }

    static WildcardType c(Type r4) {
        return new WildcardTypeImpl(new Type[]{(Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.memorydata.plugin")}, new Type[]{Object.class});
    }

    static String d(Type r2) {
        Type r3 = (Type) ZeusTransformUtils.wrapperContextForParams(r2, Type.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, Class.class) == false) goto L6;
        return ((Class) ZeusTransformUtils.preCheckCast(r3, Class.class, "com.obric.memorydata.plugin")).getName();
    L6:
        return r3.toString();
    }

    static Type e(Type r5) {
        Type r6 = (Type) ZeusTransformUtils.wrapperContextForParams(r5, Type.class, "com.obric.memorydata.plugin");
        n.a(r6);
        final AtomicReference r0 = new AtomicReference();
        new AnonymousClass1(r0).a(new Type[]{r6});
        return (Type) ZeusTransformUtils.preCheckCast(r0.get(), Type.class, "com.obric.memorydata.plugin");
    }
}
