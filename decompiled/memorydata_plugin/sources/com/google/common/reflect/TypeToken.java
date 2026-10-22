package com.google.common.reflect;

import com.google.common.base.n;
import com.google.common.base.o;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.common.collect.ae;
import com.google.common.collect.bj;
import com.google.common.collect.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public abstract class TypeToken<T> extends c<T> implements Serializable {
    private static final long serialVersionUID = 3637540370352322684L;
    private transient e covariantTypeResolver;
    private transient e invariantTypeResolver;
    private final Type runtimeType;

    private final class ClassSet extends TypeToken<T>.TypeSet {
        private static final long serialVersionUID = 0;
        private transient ImmutableSet<TypeToken<? super T>> classes;
        final /* synthetic */ TypeToken this$0;

        private ClassSet(TypeToken r1) {
            this.this$0 = r1;
            super(r1);
        }

        /* synthetic */ ClassSet(TypeToken r1, AnonymousClass1 r2) {
            this(r1);
        }

        private Object readResolve() {
            return this.this$0.getTypes().classes();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet classes() {
            return this;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet, com.google.common.collect.ae, com.google.common.collect.v, com.google.common.collect.ac
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet, com.google.common.collect.ae, com.google.common.collect.v, com.google.common.collect.ac
        public /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet, com.google.common.collect.ae, com.google.common.collect.v, com.google.common.collect.ac
        public Set<TypeToken<? super T>> delegate() {
            ImmutableSet<TypeToken<? super T>> r0 = this.classes;
            if (r0 != null) goto L6;
            ImmutableSet<TypeToken<? super T>> r1 = u.a(b.f4775a.a().a(this.this$0)).a(TypeFilter.IGNORE_TYPE_VARIABLE_OR_WILDCARD).a();
            this.classes = r1;
            return r1;
        L6:
            return r0;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet interfaces() {
            throw new UnsupportedOperationException("classes().interfaces() not supported.");
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public Set<Class<? super T>> rawTypes() {
            return ImmutableSet.copyOf(b.f4776b.a().a(TypeToken.access$300(this.this$0)));
        }
    }

    private final class InterfaceSet extends TypeToken<T>.TypeSet {
        private static final long serialVersionUID = 0;
        private final transient TypeToken<T>.TypeSet allTypes;
        private transient ImmutableSet<TypeToken<? super T>> interfaces;
        final /* synthetic */ TypeToken this$0;

        InterfaceSet(TypeToken r1, TypeToken<T>.TypeSet r2) {
            this.this$0 = r1;
            super(r1);
            this.allTypes = r2;
        }

        public static /* synthetic */ boolean lambda$_F0wdax4z54q90FkwbNHslwUsQo(Class r0) {
            return r0.isInterface();
        }

        private Object readResolve() {
            return this.this$0.getTypes().interfaces();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet classes() {
            throw new UnsupportedOperationException("interfaces().classes() not supported.");
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet, com.google.common.collect.ae, com.google.common.collect.v, com.google.common.collect.ac
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet, com.google.common.collect.ae, com.google.common.collect.v, com.google.common.collect.ac
        public /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet, com.google.common.collect.ae, com.google.common.collect.v, com.google.common.collect.ac
        public Set<TypeToken<? super T>> delegate() {
            ImmutableSet<TypeToken<? super T>> r0 = this.interfaces;
            if (r0 != null) goto L6;
            ImmutableSet<TypeToken<? super T>> r1 = u.a(this.allTypes).a(TypeFilter.INTERFACE_ONLY).a();
            this.interfaces = r1;
            return r1;
        L6:
            return r0;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet interfaces() {
            return this;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public Set<Class<? super T>> rawTypes() {
            return u.a(b.f4776b.a(TypeToken.access$300(this.this$0))).a($$Lambda$TypeToken$InterfaceSet$_F0wdax4z54q90FkwbNHslwUsQo.INSTANCE).a();
        }
    }

    private static final class SimpleTypeToken<T> extends TypeToken<T> {
        private static final long serialVersionUID = 0;

        SimpleTypeToken(Type r3) {
            super((Type) ZeusTransformUtils.wrapperContextForParams(r3, Type.class, "com.obric.memorydata.plugin"), null);
        }
    }

    private static abstract enum TypeFilter extends Enum<TypeFilter> implements o<TypeToken<?>> {
        private static final /* synthetic */ TypeFilter[] $VALUES = null;
        public static final TypeFilter IGNORE_TYPE_VARIABLE_OR_WILDCARD = null;
        public static final TypeFilter INTERFACE_ONLY = null;

        private static /* synthetic */ TypeFilter[] $values() {
            return new TypeFilter[]{IGNORE_TYPE_VARIABLE_OR_WILDCARD, INTERFACE_ONLY};
        }

        static {
            final String r1 = "IGNORE_TYPE_VARIABLE_OR_WILDCARD";
            final int r2 = 0;
            IGNORE_TYPE_VARIABLE_OR_WILDCARD = new AnonymousClass1(r1, r2);
            final String r3 = "INTERFACE_ONLY";
            final int r4 = 1;
            INTERFACE_ONLY = new AnonymousClass2(r3, r4);
            $VALUES = $values();
        }

        private TypeFilter(String r1, int r2) {
            super(r1, r2);
        }

        /* synthetic */ TypeFilter(String r1, int r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        public static TypeFilter valueOf(String r2) {
            return (TypeFilter) ZeusTransformUtils.preCheckCast(Enum.valueOf(TypeFilter.class, r2), TypeFilter.class, "com.obric.memorydata.plugin");
        }

        public static TypeFilter[] values() {
            return (TypeFilter[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TypeFilter[].class, "com.obric.memorydata.plugin");
        }
    }

    public class TypeSet extends ae<TypeToken<? super T>> implements Serializable {
        private static final long serialVersionUID = 0;
        final /* synthetic */ TypeToken this$0;
        private transient ImmutableSet<TypeToken<? super T>> types;

        TypeSet(TypeToken r1) {
            this.this$0 = r1;
        }

        public TypeToken<T>.TypeSet classes() {
            return new ClassSet(this.this$0, null);
        }

        @Override // com.google.common.collect.ae, com.google.common.collect.v, com.google.common.collect.ac
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ae, com.google.common.collect.v, com.google.common.collect.ac
        public /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ae, com.google.common.collect.v, com.google.common.collect.ac
        public Set<TypeToken<? super T>> delegate() {
            ImmutableSet<TypeToken<? super T>> r0 = this.types;
            if (r0 != null) goto L6;
            ImmutableSet<TypeToken<? super T>> r1 = u.a(b.f4775a.a(this.this$0)).a(TypeFilter.IGNORE_TYPE_VARIABLE_OR_WILDCARD).a();
            this.types = r1;
            return r1;
        L6:
            return r0;
        }

        public TypeToken<T>.TypeSet interfaces() {
            return new InterfaceSet(this.this$0, this);
        }

        public Set<Class<? super T>> rawTypes() {
            return ImmutableSet.copyOf(b.f4776b.a(TypeToken.access$300(this.this$0)));
        }
    }

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Type[] f4773a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f4774b;

        a(Type[] r1, boolean r2) {
            this.f4773a = r1;
            this.f4774b = r2;
        }

        boolean a(Type r6) {
            Type r7 = (Type) ZeusTransformUtils.wrapperContextForParams(r6, Type.class, "com.obric.memorydata.plugin");
            Type[] r0 = this.f4773a;
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L9;
            boolean r3 = TypeToken.of(r0[r2]).isSubtypeOf(r7);
            boolean r4 = this.f4774b;
            if (r3 == r4) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r4;
        L9:
            return !this.f4774b;
        }

        boolean b(Type r6) {
            TypeToken<?> r7 = TypeToken.of((Type) ZeusTransformUtils.wrapperContextForParams(r6, Type.class, "com.obric.memorydata.plugin"));
            Type[] r0 = this.f4773a;
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L9;
            boolean r3 = r7.isSubtypeOf(r0[r2]);
            boolean r4 = this.f4774b;
            if (r3 == r4) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r4;
        L9:
            return !this.f4774b;
        }
    }

    private static abstract class b<K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final b<TypeToken<?>> f4775a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final b<Class<?>> f4776b = null;

        private static class a<K> extends b<K> {
            private final b<K> c;

            a(b<K> r2) {
                super(null);
                this.c = r2;
            }

            @Override // com.google.common.reflect.TypeToken.b
            Class<?> b(K r1) {
                return this.c.b(r1);
            }

            @Override // com.google.common.reflect.TypeToken.b
            Iterable<? extends K> c(K r1) {
                return this.c.c(r1);
            }

            @Override // com.google.common.reflect.TypeToken.b
            K d(K r1) {
                return this.c.d(r1);
            }
        }

        static {
            f4775a = new AnonymousClass1();
            f4776b = new AnonymousClass2();
        }

        private b() {
        }

        /* synthetic */ b(AnonymousClass1 r1) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        private int a(K r4, Map<? super K, Integer> r5) {
            Map<? super K, Integer> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
            Integer r0 = (Integer) ZeusTransformUtils.preCheckCast(r6.get(r4), Integer.class, "com.obric.memorydata.plugin");
            if (r0 != null) goto L5;
            boolean r1 = b(r4).isInterface();
            Iterator<? extends K> r2 = c(r4).iterator();
            int r3 = r1;
        L8:
            if (r2.hasNext() == false) goto L10;
            r3 = Math.max(r3, a(r2.next(), r6));
            goto L8
        L10:
            K r7 = d(r4);
            int r8 = r3;
            if (r7 == null) goto L13;
            r8 = Math.max(r3, a(r7, r6));
        L13:
            int r9 = r8 + 1;
            r6.put(r4, Integer.valueOf(r9));
            return r9;
        L5:
            return r0.intValue();
        }

        private static <K, V> ImmutableList<K> a(Map<K, V> r2, Comparator<? super V> r3) {
            final Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
            final Comparator r5 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
            return (ImmutableList<K>) new AnonymousClass4(r5, r4).immutableSortedCopy(r4.keySet());
        }

        ImmutableList<K> a(Iterable<? extends K> r3) {
            Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin");
            Map<? super K, Integer> r0 = Maps.c();
            Iterator<T> r5 = r4.iterator();
        L4:
            if (r5.hasNext() == false) goto L7;
            a(r5.next(), r0);
            goto L4
        L7:
            return a(r0, Ordering.natural().reverse());
        }

        final ImmutableList<K> a(K r1) {
            return a(ImmutableList.of(r1));
        }

        final b<K> a() {
            return new AnonymousClass3(this, this);
        }

        abstract Class<?> b(K r1);

        abstract Iterable<? extends K> c(K r1);

        abstract K d(K r1);
    }

    public TypeToken() {
        Type r0 = capture();
        this.runtimeType = r0;
        n.b(!ZeusTransformUtils.instanceOf(r0, TypeVariable.class), "Cannot construct a TypeToken for a type variable.\nYou probably meant to call new TypeToken<%s>(getClass()) that can resolve the type variable for you.\nIf you do need to create a TypeToken of a type variable, please use TypeToken.of() instead.", r0);
    }

    public TypeToken(Class<?> r3) {
        Type r0 = super.capture();
        if (ZeusTransformUtils.instanceOf(r0, Class.class) == false) goto L5;
        this.runtimeType = r0;
        return;
    L5:
        this.runtimeType = e.a(r3).c(r0);
    }

    private TypeToken(Type r3) {
        this.runtimeType = (Type) ZeusTransformUtils.preCheckCast(n.a((Type) ZeusTransformUtils.wrapperContextForParams(r3, Type.class, "com.obric.memorydata.plugin")), Type.class, "com.obric.memorydata.plugin");
    }

    /* synthetic */ TypeToken(Type r2, AnonymousClass1 r3) {
        this((Type) ZeusTransformUtils.wrapperContextForParams(r2, Type.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ e access$000(TypeToken r0) {
        return r0.getCovariantTypeResolver();
    }

    static /* synthetic */ e access$100(TypeToken r0) {
        return r0.getInvariantTypeResolver();
    }

    static /* synthetic */ ImmutableSet access$300(TypeToken r0) {
        return r0.getRawTypes();
    }

    static /* synthetic */ Type access$500(TypeToken r0) {
        return r0.runtimeType;
    }

    private static a any(Type[] r2) {
        return new a(r2, true);
    }

    private TypeToken<? super T> boundAsSuperclass(Type r2) {
        TypeToken<? super T> r1 = (TypeToken<? super T>) of((Type) ZeusTransformUtils.wrapperContextForParams(r2, Type.class, "com.obric.memorydata.plugin"));
        if (r1.getRawType().isInterface() == false) goto L6;
        return null;
    L6:
        return r1;
    }

    private ImmutableList<TypeToken<? super T>> boundsAsInterfaces(Type[] r5) {
        ImmutableList.a r4 = ImmutableList.builder();
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        TypeToken<?> r2 = of(r5[r1]);
        if (r2.getRawType().isInterface() == false) goto L7;
        r4.b(r2);
    L7:
        r1 = r1 + 1;
        goto L3
    L9:
        return r4.a();
    }

    private static Type canonicalizeTypeArg(TypeVariable<?> r2, Type r3) {
        TypeVariable r4 = (TypeVariable) ZeusTransformUtils.wrapperContextForParams(r2, TypeVariable.class, "com.obric.memorydata.plugin");
        Type r5 = (Type) ZeusTransformUtils.wrapperContextForParams(r3, Type.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, WildcardType.class) == false) goto L6;
        return canonicalizeWildcardType(r4, (WildcardType) ZeusTransformUtils.preCheckCast(r5, WildcardType.class, "com.obric.memorydata.plugin"));
    L6:
        return canonicalizeWildcardsInType(r5);
    }

    private static WildcardType canonicalizeWildcardType(TypeVariable<?> r8, WildcardType r9) {
        TypeVariable r10 = (TypeVariable) ZeusTransformUtils.wrapperContextForParams(r8, TypeVariable.class, "com.obric.memorydata.plugin");
        WildcardType r11 = (WildcardType) ZeusTransformUtils.wrapperContextForParams(r9, WildcardType.class, "com.obric.memorydata.plugin");
        Type[] r12 = r10.getBounds();
        ArrayList r0 = new ArrayList();
        Type[] r2 = r11.getUpperBounds();
        int r3 = r2.length;
        int r5 = 0;
    L3:
        if (r5 >= r3) goto L9;
        Type r6 = r2[r5];
        if (any(r12).a(r6) == true) goto L7;
        r0.add(canonicalizeWildcardsInType(r6));
    L7:
        r5 = r5 + 1;
        goto L3
    L9:
        return new Types.WildcardTypeImpl(r11.getLowerBounds(), (Type[]) ZeusTransformUtils.preCheckCast(r0.toArray(new Type[0]), Type[].class, "com.obric.memorydata.plugin"));
    }

    private static ParameterizedType canonicalizeWildcardsInParameterizedType(ParameterizedType r6) {
        ParameterizedType r7 = (ParameterizedType) ZeusTransformUtils.wrapperContextForParams(r6, ParameterizedType.class, "com.obric.memorydata.plugin");
        Class r0 = (Class) ZeusTransformUtils.preCheckCast(r7.getRawType(), Class.class, "com.obric.memorydata.plugin");
        TypeVariable<Class<T>>[] r1 = r0.getTypeParameters();
        Type[] r2 = r7.getActualTypeArguments();
        int r3 = 0;
    L4:
        if (r3 >= r2.length) goto L7;
        r2[r3] = canonicalizeTypeArg(r1[r3], r2[r3]);
        r3 = r3 + 1;
        goto L4
    L7:
        return Types.a(r7.getOwnerType(), r0, r2);
    }

    private static Type canonicalizeWildcardsInType(Type r2) {
        Type r3 = (Type) ZeusTransformUtils.wrapperContextForParams(r2, Type.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, ParameterizedType.class) == false) goto L7;
        return canonicalizeWildcardsInParameterizedType((ParameterizedType) ZeusTransformUtils.preCheckCast(r3, ParameterizedType.class, "com.obric.memorydata.plugin"));
    L7:
        if (ZeusTransformUtils.instanceOf(r3, GenericArrayType.class) == true) goto L9;
        return r3;
    L9:
        return Types.a(canonicalizeWildcardsInType(((GenericArrayType) ZeusTransformUtils.preCheckCast(r3, GenericArrayType.class, "com.obric.memorydata.plugin")).getGenericComponentType()));
    }

    private static a every(Type[] r2) {
        return new a(r2, false);
    }

    private TypeToken<? extends T> getArraySubtype(Class<?> r3) {
        Class<?> r0 = r3.getComponentType();
        if (r0 == null) goto L7;
        return (TypeToken<? extends T>) of(newArrayClassOrGenericArrayType(((TypeToken) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(getComponentType()), TypeToken.class, "com.obric.memorydata.plugin")).getSubtype(r0).runtimeType));
    L7:
        throw new IllegalArgumentException(r3 + " does not appear to be a subtype of " + this);
    }

    private TypeToken<? super T> getArraySupertype(Class<? super T> r3) {
        TypeToken<?> r0 = getComponentType();
        if (r0 == null) goto L7;
        return (TypeToken<? super T>) of(newArrayClassOrGenericArrayType(r0.getSupertype((Class) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r3.getComponentType()), Class.class, "com.obric.memorydata.plugin")).runtimeType));
    L7:
        throw new IllegalArgumentException(r3 + " isn't a super type of " + this);
    }

    private e getCovariantTypeResolver() {
        e r0 = this.covariantTypeResolver;
        if (r0 != null) goto L6;
        e r1 = e.a(this.runtimeType);
        this.covariantTypeResolver = r1;
        return r1;
    L6:
        return r0;
    }

    private e getInvariantTypeResolver() {
        e r0 = this.invariantTypeResolver;
        if (r0 != null) goto L6;
        e r1 = e.b(this.runtimeType);
        this.invariantTypeResolver = r1;
        return r1;
    L6:
        return r0;
    }

    private Type getOwnerTypeIfPresent() {
        if (ZeusTransformUtils.instanceOf(this.runtimeType, ParameterizedType.class) == false) goto L7;
        return ((ParameterizedType) ZeusTransformUtils.preCheckCast(this.runtimeType, ParameterizedType.class, "com.obric.memorydata.plugin")).getOwnerType();
    L7:
        if (ZeusTransformUtils.instanceOf(this.runtimeType, Class.class) == true) goto L9;
        return null;
    L9:
        return ((Class) ZeusTransformUtils.preCheckCast(this.runtimeType, Class.class, "com.obric.memorydata.plugin")).getEnclosingClass();
    }

    private ImmutableSet<Class<? super T>> getRawTypes() {
        final ImmutableSet.a r0 = ImmutableSet.builder();
        new AnonymousClass4(this, r0).a(new Type[]{this.runtimeType});
        return r0.c();
    }

    private TypeToken<? extends T> getSubtypeFromLowerBounds(Class<?> r2, Type[] r3) {
        if (r3.length <= 0) goto L7;
        return (TypeToken<? extends T>) of(r3[0]).getSubtype(r2);
    L7:
        throw new IllegalArgumentException(r2 + " isn't a subclass of " + this);
    }

    private TypeToken<? super T> getSupertypeFromUpperBounds(Class<? super T> r5, Type[] r6) {
        int r0 = r6.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L10;
        TypeToken<?> r2 = of(r6[r1]);
        if (r2.isSubtypeOf(r5) == true) goto L7;
        r1 = r1 + 1;
        goto L3
    L7:
        return (TypeToken<? super T>) r2.getSupertype(r5);
    L10:
        throw new IllegalArgumentException(r5 + " isn't a super type of " + this);
    }

    private boolean is(Type r4, TypeVariable<?> r5) {
        Type r6 = (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.memorydata.plugin");
        TypeVariable r7 = (TypeVariable) ZeusTransformUtils.wrapperContextForParams(r5, TypeVariable.class, "com.obric.memorydata.plugin");
        if (this.runtimeType.equals(r6) == false) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r6, WildcardType.class) == false) goto L15;
        WildcardType r8 = canonicalizeWildcardType(r7, (WildcardType) ZeusTransformUtils.preCheckCast(r6, WildcardType.class, "com.obric.memorydata.plugin"));
        if (every(r8.getUpperBounds()).b(this.runtimeType) == true) goto L10;
    L12:
        return false;
    L10:
        if (every(r8.getLowerBounds()).a(this.runtimeType) == false) goto L12;
        return true;
    L15:
        return canonicalizeWildcardsInType(this.runtimeType).equals(canonicalizeWildcardsInType(r6));
    }

    private boolean isOwnedBySubtypeOf(Type r4) {
        Type r5 = (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.memorydata.plugin");
        Iterator<TypeToken<? super T>> r3 = getTypes().iterator();
    L4:
        if (r3.hasNext() == false) goto L11;
        Type r0 = ((TypeToken) ZeusTransformUtils.preCheckCast(r3.next(), TypeToken.class, "com.obric.memorydata.plugin")).getOwnerTypeIfPresent();
        if (r0 == null) goto L4;
        if (of(r0).isSubtypeOf(r5) == false) goto L4;
        return true;
    L11:
        return false;
    }

    private boolean isSubtypeOfArrayType(GenericArrayType r5) {
        GenericArrayType r6 = (GenericArrayType) ZeusTransformUtils.wrapperContextForParams(r5, GenericArrayType.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(this.runtimeType, Class.class) == false) goto L11;
        Class r4 = (Class) ZeusTransformUtils.preCheckCast(this.runtimeType, Class.class, "com.obric.memorydata.plugin");
        if (r4.isArray() == true) goto L7;
        return false;
    L7:
        TypeToken<?> r7 = of(r4.getComponentType());
    L9:
        return r7.isSubtypeOf(r6.getGenericComponentType());
    L11:
        if (ZeusTransformUtils.instanceOf(this.runtimeType, GenericArrayType.class) == false) goto L13;
        r7 = of(((GenericArrayType) ZeusTransformUtils.preCheckCast(this.runtimeType, GenericArrayType.class, "com.obric.memorydata.plugin")).getGenericComponentType());
        goto L9
    L13:
        return false;
    }

    private boolean isSubtypeOfParameterizedType(ParameterizedType r9) {
        ParameterizedType r10 = (ParameterizedType) ZeusTransformUtils.wrapperContextForParams(r9, ParameterizedType.class, "com.obric.memorydata.plugin");
        Class<? super Object> r0 = of(r10).getRawType();
        if (someRawTypeIsSubclassOf(r0) == true) goto L5;
        return false;
    L5:
        TypeVariable<Class<? super Object>>[] r1 = r0.getTypeParameters();
        Type[] r2 = r10.getActualTypeArguments();
        int r4 = 0;
    L7:
        if (r4 >= r1.length) goto L13;
        if (of(getCovariantTypeResolver().c(r1[r4])).is(r2[r4], r1[r4]) == false) goto L10;
        r4 = r4 + 1;
        goto L7
    L10:
        return false;
    L13:
        if (Modifier.isStatic(((Class) ZeusTransformUtils.preCheckCast(r10.getRawType(), Class.class, "com.obric.memorydata.plugin")).getModifiers()) == false) goto L15;
    L18:
        return true;
    L15:
        if (r10.getOwnerType() == null) goto L18;
        if (isOwnedBySubtypeOf(r10.getOwnerType()) == true) goto L18;
        return false;
    }

    private boolean isSupertypeOfArray(GenericArrayType r4) {
        GenericArrayType r5 = (GenericArrayType) ZeusTransformUtils.wrapperContextForParams(r4, GenericArrayType.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(this.runtimeType, Class.class) == false) goto L11;
        Class r3 = (Class) ZeusTransformUtils.preCheckCast(this.runtimeType, Class.class, "com.obric.memorydata.plugin");
        if (r3.isArray() == true) goto L9;
        return r3.isAssignableFrom(Object[].class);
    L9:
        return of(r5.getGenericComponentType()).isSubtypeOf(r3.getComponentType());
    L11:
        if (ZeusTransformUtils.instanceOf(this.runtimeType, GenericArrayType.class) == true) goto L13;
        return false;
    L13:
        return of(r5.getGenericComponentType()).isSubtypeOf(((GenericArrayType) ZeusTransformUtils.preCheckCast(this.runtimeType, GenericArrayType.class, "com.obric.memorydata.plugin")).getGenericComponentType());
    }

    private boolean isWrapper() {
        return com.google.common.primitives.d.a().contains(this.runtimeType);
    }

    private static Type newArrayClassOrGenericArrayType(Type r2) {
        Type r3 = (Type) ZeusTransformUtils.wrapperContextForParams(r2, Type.class, "com.obric.memorydata.plugin");
        return Types.JavaVersion.JAVA7.newArrayType(r3);
    }

    public static <T> TypeToken<T> of(Class<T> r1) {
        return new SimpleTypeToken(r1);
    }

    public static TypeToken<?> of(Type r2) {
        return new SimpleTypeToken((Type) ZeusTransformUtils.wrapperContextForParams(r2, Type.class, "com.obric.memorydata.plugin"));
    }

    private TypeToken<?> resolveSupertype(Type r3) {
        Type r4 = (Type) ZeusTransformUtils.wrapperContextForParams(r3, Type.class, "com.obric.memorydata.plugin");
        TypeToken<?> r5 = of(getCovariantTypeResolver().c(r4));
        r5.covariantTypeResolver = this.covariantTypeResolver;
        r5.invariantTypeResolver = this.invariantTypeResolver;
        return r5;
    }

    private Type resolveTypeArgsForSubclass(Class<?> r3) {
        if (ZeusTransformUtils.instanceOf(this.runtimeType, Class.class) == true) goto L5;
    L9:
        TypeToken r4 = toGenericType(r3);
        Type r0 = r4.getSupertype(getRawType()).runtimeType;
        return new e().a(r0, this.runtimeType).c(r4.runtimeType);
    L5:
        if (r3.getTypeParameters().length != 0) goto L7;
    L8:
        return r3;
    L7:
        if (getRawType().getTypeParameters().length == 0) goto L9;
        goto L8
    }

    private boolean someRawTypeIsSubclassOf(Class<?> r4) {
        bj<Class<? super T>> r3 = getRawTypes().iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        if (r4.isAssignableFrom((Class) ZeusTransformUtils.preCheckCast(r3.next(), Class.class, "com.obric.memorydata.plugin")) == false) goto L4;
        return true;
    L9:
        return false;
    }

    static <T> TypeToken<? extends T> toGenericType(Class<T> r3) {
        if (r3.isArray() == false) goto L7;
        Type r4 = Types.a(toGenericType(r3.getComponentType()).runtimeType);
    L6:
        return (TypeToken<? extends T>) of(r4);
    L7:
        TypeVariable<Class<T>>[] r0 = r3.getTypeParameters();
        if (r3.isMemberClass() == true) goto L10;
    L12:
        Type r1 = null;
    L14:
        if (r0.length > 0) goto L21;
        if (r1 == null) goto L20;
        if (r1 != r3.getEnclosingClass()) goto L21;
    L20:
        return of(r3);
    L21:
        r4 = Types.a(r1, r3, r0);
        goto L6
    L10:
        if (Modifier.isStatic(r3.getModifiers()) == true) goto L12;
        r1 = toGenericType(r3.getEnclosingClass()).runtimeType;
        goto L14
    }

    public final com.google.common.reflect.a<T, T> constructor(final Constructor<?> r4) {
        if (r4.getDeclaringClass() != getRawType()) goto L5;
        boolean r0 = true;
    L6:
        n.a(r0, "%s not declared by %s", r4, getRawType());
        return new AnonymousClass2(this, r4);
    L5:
        r0 = false;
        goto L6
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, TypeToken.class) == false) goto L6;
        TypeToken r4 = (TypeToken) ZeusTransformUtils.preCheckCast(r3, TypeToken.class, "com.obric.memorydata.plugin");
        return this.runtimeType.equals(r4.runtimeType);
    L6:
        return false;
    }

    public final TypeToken<?> getComponentType() {
        Type r0 = Types.e(this.runtimeType);
        if (r0 != null) goto L7;
        return null;
    L7:
        return of(r0);
    }

    final ImmutableList<TypeToken<? super T>> getGenericInterfaces() {
        if (ZeusTransformUtils.instanceOf(this.runtimeType, TypeVariable.class) == false) goto L7;
        return boundsAsInterfaces(((TypeVariable) ZeusTransformUtils.preCheckCast(this.runtimeType, TypeVariable.class, "com.obric.memorydata.plugin")).getBounds());
    L7:
        if (ZeusTransformUtils.instanceOf(this.runtimeType, WildcardType.class) == true) goto L9;
        ImmutableList.a r0 = ImmutableList.builder();
        Type[] r1 = getRawType().getGenericInterfaces();
        int r2 = r1.length;
        int r3 = 0;
    L11:
        if (r3 >= r2) goto L14;
        r0.b(resolveSupertype(r1[r3]));
        r3 = r3 + 1;
        goto L11
    L14:
        return r0.a();
    L9:
        return boundsAsInterfaces(((WildcardType) ZeusTransformUtils.preCheckCast(this.runtimeType, WildcardType.class, "com.obric.memorydata.plugin")).getUpperBounds());
    }

    final TypeToken<? super T> getGenericSuperclass() {
        if (ZeusTransformUtils.instanceOf(this.runtimeType, TypeVariable.class) == false) goto L8;
        Type r0 = ((TypeVariable) ZeusTransformUtils.preCheckCast(this.runtimeType, TypeVariable.class, "com.obric.memorydata.plugin")).getBounds()[0];
    L6:
        return boundAsSuperclass(r0);
    L8:
        if (ZeusTransformUtils.instanceOf(this.runtimeType, WildcardType.class) == false) goto L10;
        r0 = ((WildcardType) ZeusTransformUtils.preCheckCast(this.runtimeType, WildcardType.class, "com.obric.memorydata.plugin")).getUpperBounds()[0];
        goto L6
    L10:
        Type r1 = getRawType().getGenericSuperclass();
        if (r1 != null) goto L15;
        return null;
    L15:
        return (TypeToken<? super T>) resolveSupertype(r1);
    }

    public final Class<? super T> getRawType() {
        return (Class) ZeusTransformUtils.preCheckCast(getRawTypes().iterator().next(), Class.class, "com.obric.memorydata.plugin");
    }

    public final TypeToken<? extends T> getSubtype(Class<?> r4) {
        n.a(!ZeusTransformUtils.instanceOf(this.runtimeType, TypeVariable.class), "Cannot get subtype of type variable <%s>", this);
        if (ZeusTransformUtils.instanceOf(this.runtimeType, WildcardType.class) == false) goto L7;
        return getSubtypeFromLowerBounds(r4, ((WildcardType) ZeusTransformUtils.preCheckCast(this.runtimeType, WildcardType.class, "com.obric.memorydata.plugin")).getLowerBounds());
    L7:
        if (isArray() == true) goto L9;
        n.a(getRawType().isAssignableFrom(r4), "%s isn't a subclass of %s", r4, this);
        TypeToken<? extends T> r5 = (TypeToken<? extends T>) of(resolveTypeArgsForSubclass(r4));
        n.a(r5.isSubtypeOf(this), "%s does not appear to be a subtype of %s", r5, this);
        return r5;
    L9:
        return getArraySubtype(r4);
    }

    public final TypeToken<? super T> getSupertype(Class<? super T> r4) {
        n.a(someRawTypeIsSubclassOf(r4), "%s is not a super class of %s", r4, this);
        if (ZeusTransformUtils.instanceOf(this.runtimeType, TypeVariable.class) == false) goto L7;
        return getSupertypeFromUpperBounds(r4, ((TypeVariable) ZeusTransformUtils.preCheckCast(this.runtimeType, TypeVariable.class, "com.obric.memorydata.plugin")).getBounds());
    L7:
        if (ZeusTransformUtils.instanceOf(this.runtimeType, WildcardType.class) == false) goto L11;
        return getSupertypeFromUpperBounds(r4, ((WildcardType) ZeusTransformUtils.preCheckCast(this.runtimeType, WildcardType.class, "com.obric.memorydata.plugin")).getUpperBounds());
    L11:
        if (r4.isArray() == false) goto L15;
        return getArraySupertype(r4);
    L15:
        return (TypeToken<? super T>) resolveSupertype(toGenericType(r4).runtimeType);
    }

    public final Type getType() {
        return this.runtimeType;
    }

    public final TypeToken<T>.TypeSet getTypes() {
        return new TypeSet(this);
    }

    public int hashCode() {
        return this.runtimeType.hashCode();
    }

    public final boolean isArray() {
        if (getComponentType() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isPrimitive() {
        if (ZeusTransformUtils.instanceOf(this.runtimeType, Class.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (((Class) ZeusTransformUtils.preCheckCast(this.runtimeType, Class.class, "com.obric.memorydata.plugin")).isPrimitive() == false) goto L7;
        return true;
    }

    public final boolean isSubtypeOf(TypeToken<?> r1) {
        return isSubtypeOf(r1.getType());
    }

    public final boolean isSubtypeOf(Type r5) {
        Type r6 = (Type) ZeusTransformUtils.wrapperContextForParams(r5, Type.class, "com.obric.memorydata.plugin");
        n.a(r6);
        if (ZeusTransformUtils.instanceOf(r6, WildcardType.class) == false) goto L7;
        return any(((WildcardType) ZeusTransformUtils.preCheckCast(r6, WildcardType.class, "com.obric.memorydata.plugin")).getLowerBounds()).b(this.runtimeType);
    L7:
        if (ZeusTransformUtils.instanceOf(this.runtimeType, WildcardType.class) == false) goto L11;
        return any(((WildcardType) ZeusTransformUtils.preCheckCast(this.runtimeType, WildcardType.class, "com.obric.memorydata.plugin")).getUpperBounds()).a(r6);
    L11:
        if (ZeusTransformUtils.instanceOf(this.runtimeType, TypeVariable.class) == false) goto L19;
        if (this.runtimeType.equals(r6) == false) goto L15;
    L16:
        return true;
    L15:
        if (any(((TypeVariable) ZeusTransformUtils.preCheckCast(this.runtimeType, TypeVariable.class, "com.obric.memorydata.plugin")).getBounds()).a(r6) == true) goto L16;
        return false;
    L19:
        if (ZeusTransformUtils.instanceOf(this.runtimeType, GenericArrayType.class) == false) goto L23;
        return of(r6).isSupertypeOfArray((GenericArrayType) ZeusTransformUtils.preCheckCast(this.runtimeType, GenericArrayType.class, "com.obric.memorydata.plugin"));
    L23:
        if (ZeusTransformUtils.instanceOf(r6, Class.class) == false) goto L27;
        return someRawTypeIsSubclassOf((Class) ZeusTransformUtils.preCheckCast(r6, Class.class, "com.obric.memorydata.plugin"));
    L27:
        if (ZeusTransformUtils.instanceOf(r6, ParameterizedType.class) == false) goto L31;
        return isSubtypeOfParameterizedType((ParameterizedType) ZeusTransformUtils.preCheckCast(r6, ParameterizedType.class, "com.obric.memorydata.plugin"));
    L31:
        if (ZeusTransformUtils.instanceOf(r6, GenericArrayType.class) == true) goto L33;
        return false;
    L33:
        return isSubtypeOfArrayType((GenericArrayType) ZeusTransformUtils.preCheckCast(r6, GenericArrayType.class, "com.obric.memorydata.plugin"));
    }

    public final boolean isSupertypeOf(TypeToken<?> r1) {
        return r1.isSubtypeOf(getType());
    }

    public final boolean isSupertypeOf(Type r3) {
        return of((Type) ZeusTransformUtils.wrapperContextForParams(r3, Type.class, "com.obric.memorydata.plugin")).isSubtypeOf(getType());
    }

    public final com.google.common.reflect.a<T, Object> method(final Method r3) {
        n.a(someRawTypeIsSubclassOf(r3.getDeclaringClass()), "%s not declared by %s", r3, this);
        return new AnonymousClass1(this, r3);
    }

    final TypeToken<T> rejectTypeVariables() {
        new AnonymousClass3(this).a(new Type[]{this.runtimeType});
        return this;
    }

    public final TypeToken<?> resolveType(Type r3) {
        Type r4 = (Type) ZeusTransformUtils.wrapperContextForParams(r3, Type.class, "com.obric.memorydata.plugin");
        n.a(r4);
        return of(getInvariantTypeResolver().c(r4));
    }

    public String toString() {
        return Types.d(this.runtimeType);
    }

    public final TypeToken<T> unwrap() {
        if (isWrapper() == true) goto L5;
        return this;
    L5:
        return of(com.google.common.primitives.d.b((Class) ZeusTransformUtils.preCheckCast(this.runtimeType, Class.class, "com.obric.memorydata.plugin")));
    }

    public final <X> TypeToken<T> where(d<X> r3, TypeToken<X> r4) {
        return new SimpleTypeToken(new e().a(ImmutableMap.of(new e.c(r3.f4790a), r4.runtimeType)).c(this.runtimeType));
    }

    public final <X> TypeToken<T> where(d<X> r1, Class<X> r2) {
        return where(r1, of(r2));
    }

    public final TypeToken<T> wrap() {
        if (isPrimitive() == true) goto L5;
        return this;
    L5:
        return of(com.google.common.primitives.d.a((Class) ZeusTransformUtils.preCheckCast(this.runtimeType, Class.class, "com.obric.memorydata.plugin")));
    }

    public Object writeReplace() {
        return of(new e().c(this.runtimeType));
    }
}
