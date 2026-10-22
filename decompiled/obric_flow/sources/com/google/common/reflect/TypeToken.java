package com.google.common.reflect;

import com.google.common.base.b0;
import com.google.common.base.z;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.a5;
import com.google.common.collect.b3;
import com.google.common.collect.ga;
import com.google.common.collect.n4;
import com.google.common.collect.s2;
import com.google.common.collect.u3;
import com.google.common.collect.x3;
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public abstract class TypeToken<T> extends b implements Serializable {
    private static final long serialVersionUID = 3637540370352322684L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient j f9345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient j f9346b;
    private final Type runtimeType;

    public final class ClassSet extends TypeToken<T>.TypeSet {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public transient ImmutableSet f9347b;
        final /* synthetic */ TypeToken this$0;

        public ClassSet(TypeToken r5, k r10) {
            this.this$0 = r5;
            super(r5);
        }

        private Object readResolve() {
            return this.this$0.getTypes().classes();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet classes() {
            return this;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet, com.google.common.collect.b3, com.google.common.collect.z2
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet interfaces() {
            throw new UnsupportedOperationException("classes().interfaces() not supported.");
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public Set<Class<? super T>> rawTypes() {
            return ImmutableSet.copyOf(new o(q.f9371b).b(TypeToken.access$300(this.this$0)));
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet, com.google.common.collect.b3, com.google.common.collect.t2, com.google.common.collect.z2
        public /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet, com.google.common.collect.b3, com.google.common.collect.t2, com.google.common.collect.z2
        public Set<TypeToken<? super T>> delegate() {
            ImmutableSet r5 = this.f9347b;
            if (r5 != null) goto L6;
            s2 r10 = s2.b(new o(q.f9370a).b(ImmutableList.of(this.this$0)));
            TypeFilter r11 = TypeFilter.IGNORE_TYPE_VARIABLE_OR_WILDCARD;
            Iterable r12 = (Iterable) r10.f9155a.or(r10);
            r12.getClass();
            r11.getClass();
            s2 r13 = s2.b(new a5(r12, r11, 0));
            ImmutableSet r14 = ImmutableSet.copyOf((Iterable) r13.f9155a.or(r13));
            this.f9347b = r14;
            return r14;
        L6:
            return r5;
        }
    }

    public final class InterfaceSet extends TypeToken<T>.TypeSet {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final transient TypeSet f9348b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public transient ImmutableSet f9349c;
        final /* synthetic */ TypeToken this$0;

        public InterfaceSet(TypeToken r5, TypeToken<T>.TypeSet r10) {
            this.this$0 = r5;
            super(r5);
            this.f9348b = r10;
        }

        private Object readResolve() {
            return this.this$0.getTypes().interfaces();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet classes() {
            throw new UnsupportedOperationException("interfaces().classes() not supported.");
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet, com.google.common.collect.b3, com.google.common.collect.z2
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet interfaces() {
            return this;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public Set<Class<? super T>> rawTypes() {
            s2 r5 = s2.b(q.f9371b.b(TypeToken.access$300(this.this$0)));
            m r10 = new m();
            Iterable r11 = (Iterable) r5.f9155a.or(r5);
            r11.getClass();
            s2 r12 = s2.b(new a5(r11, r10, 0));
            return ImmutableSet.copyOf((Iterable) r12.f9155a.or(r12));
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet, com.google.common.collect.b3, com.google.common.collect.t2, com.google.common.collect.z2
        public /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet, com.google.common.collect.b3, com.google.common.collect.t2, com.google.common.collect.z2
        public Set<TypeToken<? super T>> delegate() {
            ImmutableSet r5 = this.f9349c;
            if (r5 != null) goto L6;
            s2 r10 = s2.b(this.f9348b);
            TypeFilter r11 = TypeFilter.INTERFACE_ONLY;
            Iterable r12 = (Iterable) r10.f9155a.or(r10);
            r12.getClass();
            r11.getClass();
            s2 r13 = s2.b(new a5(r12, r11, 0));
            ImmutableSet r14 = ImmutableSet.copyOf((Iterable) r13.f9155a.or(r13));
            this.f9349c = r14;
            return r14;
        L6:
            return r5;
        }
    }

    public static final class SimpleTypeToken<T> extends TypeToken<T> {
        private static final long serialVersionUID = 0;

        public SimpleTypeToken(Type r5) {
            super(r5, null);
        }
    }

    public static abstract enum TypeFilter extends Enum<TypeFilter> implements z {
        public static final TypeFilter IGNORE_TYPE_VARIABLE_OR_WILDCARD = null;
        public static final TypeFilter INTERFACE_ONLY = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TypeFilter[] f9350a = null;

        static {
            final String r5 = "IGNORE_TYPE_VARIABLE_OR_WILDCARD";
            final int r10 = 0;
            TypeFilter r11 = new AnonymousClass1(r5, r10);
            IGNORE_TYPE_VARIABLE_OR_WILDCARD = r11;
            final String r12 = "INTERFACE_ONLY";
            final int r13 = 1;
            TypeFilter r14 = new AnonymousClass2(r12, r13);
            INTERFACE_ONLY = r14;
            f9350a = new TypeFilter[]{r11, r14};
        }

        public TypeFilter(String r5, int r10, k r11) {
            super(r5, r10);
        }

        public static TypeFilter valueOf(String r5) {
            return (TypeFilter) Enum.valueOf(TypeFilter.class, r5);
        }

        public static TypeFilter[] values() {
            return (TypeFilter[]) f9350a.clone();
        }

        @Override // com.google.common.base.z
        public abstract /* synthetic */ boolean apply(Object r5);

        @Override // com.google.common.base.z, java.util.function.Predicate
        public boolean test(Object r5) {
            return apply(r5);
        }
    }

    public class TypeSet extends b3 implements Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public transient ImmutableSet f9351a;
        final /* synthetic */ TypeToken this$0;

        public TypeSet(TypeToken r5) {
            this.this$0 = r5;
        }

        public TypeToken<T>.TypeSet classes() {
            return new ClassSet(this.this$0, null);
        }

        @Override // com.google.common.collect.b3, com.google.common.collect.z2
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        public TypeToken<T>.TypeSet interfaces() {
            return new InterfaceSet(this.this$0, this);
        }

        public Set<Class<? super T>> rawTypes() {
            return ImmutableSet.copyOf(q.f9371b.b(TypeToken.access$300(this.this$0)));
        }

        @Override // com.google.common.collect.b3, com.google.common.collect.t2, com.google.common.collect.z2
        public /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.b3, com.google.common.collect.t2, com.google.common.collect.z2
        public Set<TypeToken<? super T>> delegate() {
            ImmutableSet r5 = this.f9351a;
            if (r5 != null) goto L6;
            s2 r10 = s2.b(q.f9370a.b(ImmutableList.of(this.this$0)));
            TypeFilter r11 = TypeFilter.IGNORE_TYPE_VARIABLE_OR_WILDCARD;
            Iterable r12 = (Iterable) r10.f9155a.or(r10);
            r12.getClass();
            r11.getClass();
            s2 r13 = s2.b(new a5(r12, r11, 0));
            ImmutableSet r14 = ImmutableSet.copyOf((Iterable) r13.f9155a.or(r13));
            this.f9351a = r14;
            return r14;
        L6:
            return r5;
        }
    }

    public TypeToken() {
        Type r5 = capture();
        this.runtimeType = r5;
        b0.s("Cannot construct a TypeToken for a type variable.\nYou probably meant to call new TypeToken<%s>(getClass()) that can resolve the type variable for you.\nIf you do need to create a TypeToken of a type variable, please use TypeToken.of() instead.", !(r5 instanceof TypeVariable), r5);
    }

    public static ImmutableList a(Type[] r5) {
        u3 r10 = ImmutableList.builder();
        int r11 = r5.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L9;
        TypeToken<?> r13 = of(r5[r12]);
        if (r13.getRawType().isInterface() == false) goto L7;
        r10.B0(r13);
    L7:
        r12 = r12 + 1;
        goto L3
    L9:
        return r10.D0();
    }

    public static j access$000(TypeToken r10) {
        boolean r5 = false;
        j r11 = r10.f9346b;
        if (r11 != null) goto L17;
        Type r12 = r10.runtimeType;
        ImmutableMap r13 = ImmutableMap.of();
        r12.getClass();
        e r14 = new e();
        r14.z(new Type[]{r12});
        ImmutableMap r15 = ImmutableMap.copyOf((HashMap) r14.d);
        x3 r16 = ImmutableMap.builder();
        r16.i(r13);
        Iterator r17 = r15.entrySet().iterator();
    L6:
        if (r17.hasNext() == false) goto L12;
        Map.Entry r18 = (Map.Entry) r17.next();
        g r19 = (g) r18.getKey();
        Type r20 = (Type) r18.getValue();
        r19.getClass();
        if ((r20 instanceof TypeVariable) == false) goto L10;
        boolean r21 = r19.a((TypeVariable) r20);
    L11:
        b0.h("Type variable %s bound to itself", !r21, r19);
        r16.g(r19, r20);
        goto L6
    L10:
        r21 = false;
        goto L11
    L12:
        j r22 = new j(new sj.k(r16.d(), r5));
        r10.f9346b = r22;
        return r22;
    L17:
        return r11;
    }

    public static /* synthetic */ j access$100(TypeToken r5) {
        return r5.d();
    }

    public static /* synthetic */ ImmutableSet access$300(TypeToken r5) {
        return r5.e();
    }

    public static /* synthetic */ Type access$500(TypeToken r5) {
        return r5.runtimeType;
    }

    public static WildcardType b(TypeVariable r10, WildcardType r11) {
        Type[] r12 = r10.getBounds();
        ArrayList r5 = new ArrayList();
        Type[] r13 = r11.getUpperBounds();
        int r14 = r13.length;
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L16;
        Type r16 = r13[r15];
        int r17 = r12.length;
        int r18 = 0;
    L5:
        boolean r19 = true;
        if (r18 >= r17) goto L11;
        if (of(r12[r18]).isSubtypeOf(r16) == true) goto L12;
        r18 = r18 + 1;
    L12:
        if (r19 == true) goto L14;
        r5.add(c(r16));
    L14:
        r15 = r15 + 1;
        goto L3
    L11:
        r19 = !true;
        goto L12
    L16:
        return new Types$WildcardTypeImpl(r11.getLowerBounds(), (Type[]) r5.toArray(new Type[0]));
    }

    public static Type c(Type r10) {
        if ((r10 instanceof ParameterizedType) == false) goto L15;
        ParameterizedType r11 = (ParameterizedType) r10;
        Class r5 = (Class) r11.getRawType();
        TypeVariable<Class<T>>[] r12 = r5.getTypeParameters();
        Type[] r13 = r11.getActualTypeArguments();
        int r14 = 0;
    L6:
        if (r14 >= r13.length) goto L13;
        TypeVariable<Class<T>> r15 = r12[r14];
        Type r16 = r13[r14];
        if ((r16 instanceof WildcardType) == false) goto L10;
        Type r17 = b(r15, (WildcardType) r16);
    L11:
        r13[r14] = r17;
        r14 = r14 + 1;
        goto L6
    L10:
        r17 = c(r16);
        goto L11
    L13:
        return y.f(r11.getOwnerType(), r5, r13);
    L15:
        if ((r10 instanceof GenericArrayType) == true) goto L17;
        return r10;
    L17:
        return y.d(c(((GenericArrayType) r10).getGenericComponentType()));
    }

    public static <T> TypeToken<T> of(Class<T> r5) {
        return new SimpleTypeToken(r5);
    }

    public static <T> TypeToken<? extends T> toGenericType(Class<T> r5) {
        if (r5.isArray() == true) goto L5;
        TypeVariable<Class<T>>[] r10 = r5.getTypeParameters();
        if (r5.isMemberClass() == true) goto L9;
    L11:
        Type r11 = null;
    L13:
        if (r10.length > 0) goto L21;
        if (r11 == null) goto L19;
        if (r11 != r5.getEnclosingClass()) goto L21;
    L19:
        return of(r5);
    L21:
        return (TypeToken<? extends T>) of(y.f(r11, r5, r10));
    L9:
        if (Modifier.isStatic(r5.getModifiers()) == true) goto L11;
        r11 = toGenericType(r5.getEnclosingClass()).runtimeType;
        goto L13
    L5:
        return (TypeToken<? extends T>) of(y.d(toGenericType(r5.getComponentType()).runtimeType));
    }

    public final a constructor(Constructor<?> r5) {
        if (r5.getDeclaringClass() != getRawType()) goto L5;
        boolean r10 = true;
    L6:
        b0.k(r10, "%s not declared by %s", r5, getRawType());
        return new l(this, r5);
    L5:
        r10 = false;
        goto L6
    }

    public final j d() {
        boolean r5 = false;
        j r10 = this.f9345a;
        if (r10 != null) goto L17;
        Type r11 = i.f9361b.a(this.runtimeType);
        ImmutableMap r12 = ImmutableMap.of();
        r11.getClass();
        e r13 = new e();
        r13.z(new Type[]{r11});
        ImmutableMap r14 = ImmutableMap.copyOf((HashMap) r13.d);
        x3 r15 = ImmutableMap.builder();
        r15.i(r12);
        Iterator r16 = r14.entrySet().iterator();
    L6:
        if (r16.hasNext() == false) goto L12;
        Map.Entry r17 = (Map.Entry) r16.next();
        g r18 = (g) r17.getKey();
        Type r19 = (Type) r17.getValue();
        r18.getClass();
        if ((r19 instanceof TypeVariable) == false) goto L10;
        boolean r20 = r18.a((TypeVariable) r19);
    L11:
        b0.h("Type variable %s bound to itself", !r20, r18);
        r15.g(r18, r19);
        goto L6
    L10:
        r20 = false;
        goto L11
    L12:
        j r21 = new j(new sj.k(r15.d(), r5));
        this.f9345a = r21;
        return r21;
    L17:
        return r10;
    }

    public final ImmutableSet e() {
        n4 r5 = ImmutableSet.builder();
        new e(r5, 2).z(new Type[]{this.runtimeType});
        return r5.C0();
    }

    public boolean equals(Object r5) {
        if ((r5 instanceof TypeToken) == true) goto L5;
        return false;
    L5:
        return this.runtimeType.equals(((TypeToken) r5).runtimeType);
    }

    public final TypeToken f(Class r5, Type[] r10) {
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L9;
        TypeToken<?> r13 = of(r10[r12]);
        if (r13.isSubtypeOf(r5) == true) goto L7;
        r12 = r12 + 1;
        goto L3
    L7:
        return r13.getSupertype(r5);
    L9:
        String r14 = String.valueOf(r5);
        String r15 = String.valueOf(this);
        int r16 = r14.length() + 23;
        throw new IllegalArgumentException(androidx.room.jarjarred.org.antlr.runtime.a.m(r15.length() + r16, r14, " isn't a super type of ", r15));
    }

    public final TypeToken g(Type r10) {
        boolean r5 = false;
        j r11 = this.f9346b;
        if (r11 != null) goto L13;
        Type r12 = this.runtimeType;
        ImmutableMap r13 = ImmutableMap.of();
        r12.getClass();
        e r14 = new e();
        r14.z(new Type[]{r12});
        ImmutableMap r15 = ImmutableMap.copyOf((HashMap) r14.d);
        x3 r16 = ImmutableMap.builder();
        r16.i(r13);
        Iterator r17 = r15.entrySet().iterator();
    L6:
        if (r17.hasNext() == false) goto L12;
        Map.Entry r18 = (Map.Entry) r17.next();
        g r19 = (g) r18.getKey();
        Type r20 = (Type) r18.getValue();
        r19.getClass();
        if ((r20 instanceof TypeVariable) == false) goto L10;
        boolean r21 = r19.a((TypeVariable) r20);
    L11:
        b0.h("Type variable %s bound to itself", !r21, r19);
        r16.g(r19, r20);
        goto L6
    L10:
        r21 = false;
        goto L11
    L12:
        j r22 = new j(new sj.k(r16.d(), r5));
        this.f9346b = r22;
        r11 = r22;
    L13:
        TypeToken<?> r110 = of(r11.b(r10));
        r110.f9346b = this.f9346b;
        r110.f9345a = this.f9345a;
        return r110;
    }

    public final TypeToken<?> getComponentType() {
        Type r5 = y.c(this.runtimeType);
        if (r5 != null) goto L7;
        return null;
    L7:
        return of(r5);
    }

    public final ImmutableList<TypeToken<? super T>> getGenericInterfaces() {
        Type r5 = this.runtimeType;
        if ((r5 instanceof TypeVariable) == false) goto L7;
        return a(((TypeVariable) r5).getBounds());
    L7:
        if ((r5 instanceof WildcardType) == true) goto L9;
        u3 r10 = ImmutableList.builder();
        Type[] r11 = getRawType().getGenericInterfaces();
        int r12 = r11.length;
        int r13 = 0;
    L11:
        if (r13 >= r12) goto L14;
        r10.B0(g(r11[r13]));
        r13 = r13 + 1;
        goto L11
    L14:
        return r10.D0();
    L9:
        return a(((WildcardType) r5).getUpperBounds());
    }

    public final TypeToken<? super T> getGenericSuperclass() {
        Type r5 = this.runtimeType;
        if ((r5 instanceof TypeVariable) == false) goto L10;
        TypeToken<? super T> r10 = (TypeToken<? super T>) of(((TypeVariable) r5).getBounds()[0]);
        if (r10.getRawType().isInterface() == false) goto L8;
        return null;
    L8:
        return r10;
    L10:
        if ((r5 instanceof WildcardType) == false) goto L16;
        TypeToken<? super T> r11 = (TypeToken<? super T>) of(((WildcardType) r5).getUpperBounds()[0]);
        if (r11.getRawType().isInterface() == false) goto L15;
        return null;
    L15:
        return r11;
    L16:
        Type r12 = getRawType().getGenericSuperclass();
        if (r12 != null) goto L20;
        return null;
    L20:
        return g(r12);
    }

    public final Class<? super T> getRawType() {
        return (Class) e().iterator().next();
    }

    public final TypeToken<? extends T> getSubtype(Class<?> r10) {
        b0.h("Cannot get subtype of type variable <%s>", !(this.runtimeType instanceof TypeVariable), this);
        Type r5 = this.runtimeType;
        if ((r5 instanceof WildcardType) == false) goto L11;
        Type[] r11 = ((WildcardType) r5).getLowerBounds();
        if (r11.length > 0) goto L7;
        String r12 = String.valueOf(r10);
        String r13 = String.valueOf(this);
        throw new IllegalArgumentException(androidx.room.jarjarred.org.antlr.runtime.a.m(r13.length() + (r12.length() + 21), r12, " isn't a subclass of ", r13));
    L7:
        return (TypeToken<? extends T>) of(r11[0]).getSubtype(r10);
    L11:
        if (isArray() == false) goto L18;
        Class<?> r14 = r10.getComponentType();
        if (r14 == null) goto L16;
        TypeToken<?> r15 = getComponentType();
        Objects.requireNonNull(r15);
        return (TypeToken<? extends T>) of(Types$JavaVersion.JAVA7.newArrayType(r15.getSubtype(r14).runtimeType));
    L16:
        String r16 = String.valueOf(r10);
        String r17 = String.valueOf(this);
        throw new IllegalArgumentException(androidx.room.jarjarred.org.antlr.runtime.a.m(r17.length() + (r16.length() + 36), r16, " does not appear to be a subtype of ", r17));
    L18:
        b0.k(getRawType().isAssignableFrom(r10), "%s isn't a subclass of %s", r10, this);
        if ((this.runtimeType instanceof Class) == false) goto L25;
        int r18 = r10.getTypeParameters().length;
        Type r19 = r10;
        if (r18 == 0) goto L34;
        r19 = r10;
        if (getRawType().getTypeParameters().length == 0) goto L25;
    L34:
        TypeToken<? extends T> r20 = (TypeToken<? extends T>) of(r19);
        b0.k(r20.isSubtypeOf(this), "%s does not appear to be a subtype of %s", r20, this);
        return r20;
    L25:
        TypeToken r21 = toGenericType(r10);
        Type r22 = r21.getSupertype(getRawType()).runtimeType;
        ImmutableMap r23 = ImmutableMap.of();
        Type r24 = this.runtimeType;
        HashMap r25 = new HashMap();
        r22.getClass();
        r24.getClass();
        j.a(r25, r22, r24);
        x3 r26 = ImmutableMap.builder();
        r26.i(r23);
        Iterator r27 = r25.entrySet().iterator();
    L27:
        if (r27.hasNext() == false) goto L33;
        Map.Entry r28 = (Map.Entry) r27.next();
        g r29 = (g) r28.getKey();
        Type r30 = (Type) r28.getValue();
        r29.getClass();
        if ((r30 instanceof TypeVariable) == false) goto L31;
        boolean r31 = r29.a((TypeVariable) r30);
    L32:
        b0.h("Type variable %s bound to itself", !r31, r29);
        r26.g(r29, r30);
        goto L27
    L31:
        r31 = false;
        goto L32
    L33:
        r19 = new j(new sj.k(r26.d(), false)).b(r21.runtimeType);
        goto L34
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final TypeToken<? super T> getSupertype(Class<? super T> r5) {
        b0.k(h(r5), "%s is not a super class of %s", r5, this);
        Type r10 = this.runtimeType;
        if ((r10 instanceof TypeVariable) == false) goto L7;
        return f(r5, ((TypeVariable) r10).getBounds());
    L7:
        if ((r10 instanceof WildcardType) == false) goto L11;
        return f(r5, ((WildcardType) r10).getUpperBounds());
    L11:
        if (r5.isArray() == false) goto L19;
        TypeToken<?> r11 = getComponentType();
        if (r11 == 0) goto L16;
        Class<?> r12 = r5.getComponentType();
        Objects.requireNonNull(r12);
        Type r13 = r11.getSupertype(r12).runtimeType;
        return (TypeToken<? super T>) of(Types$JavaVersion.JAVA7.newArrayType(r13));
    L16:
        String r14 = String.valueOf(r5);
        String r15 = String.valueOf(this);
        int r16 = r14.length() + 23;
        throw new IllegalArgumentException(androidx.room.jarjarred.org.antlr.runtime.a.m(r15.length() + r16, r14, " isn't a super type of ", r15));
    L19:
        return g(toGenericType(r5).runtimeType);
    }

    public final Type getType() {
        return this.runtimeType;
    }

    public final TypeToken<T>.TypeSet getTypes() {
        return new TypeSet(this);
    }

    public final boolean h(Class r5) {
        ga r10 = e().iterator();
    L4:
        if (r10.hasNext() == false) goto L9;
        if (r5.isAssignableFrom((Class) r10.next()) == false) goto L4;
        return true;
    L9:
        return false;
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
        Type r5 = this.runtimeType;
        if ((r5 instanceof Class) == true) goto L5;
    L7:
        return false;
    L5:
        if (((Class) r5).isPrimitive() == false) goto L7;
        return true;
    }

    public final boolean isSubtypeOf(TypeToken<?> r5) {
        return isSubtypeOf(r5.getType());
    }

    public final boolean isSupertypeOf(TypeToken<?> r5) {
        return r5.isSubtypeOf(getType());
    }

    public final a method(Method r5) {
        b0.k(h(r5.getDeclaringClass()), "%s not declared by %s", r5, this);
        return new k(this, r5);
    }

    public final TypeToken<T> rejectTypeVariables() {
        new e(this, 1).z(new Type[]{this.runtimeType});
        return this;
    }

    public final TypeToken<?> resolveType(Type r5) {
        r5.getClass();
        return of(d().b(r5));
    }

    public String toString() {
        Type r5 = this.runtimeType;
        com.google.common.base.t r10 = y.f9380a;
        if ((r5 instanceof Class) == false) goto L6;
        return ((Class) r5).getName();
    L6:
        return r5.toString();
    }

    public final TypeToken<T> unwrap() {
        Map r5 = com.google.common.primitives.h.f9341b;
        if (r5.keySet().contains(this.runtimeType) == false) goto L10;
        Class r10 = (Class) this.runtimeType;
        r10.getClass();
        Class r11 = (Class) r5.get(r10);
        if (r11 == null) goto L9;
        r10 = r11;
    L9:
        return of(r10);
    L10:
        return this;
    }

    public final <X> TypeToken<T> where(c r5, TypeToken<X> r10) {
        new sj.k(5);
        throw null;
    }

    public final TypeToken<T> wrap() {
        if (isPrimitive() == false) goto L10;
        Class r5 = (Class) this.runtimeType;
        Map r10 = com.google.common.primitives.h.f9340a;
        r5.getClass();
        Class r11 = (Class) com.google.common.primitives.h.f9340a.get(r5);
        if (r11 == null) goto L9;
        r5 = r11;
    L9:
        return of(r5);
    L10:
        return this;
    }

    public Object writeReplace() {
        return of(new j().b(this.runtimeType));
    }

    public static TypeToken<?> of(Type r5) {
        return new SimpleTypeToken(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    public final boolean isSubtypeOf(Type r13) {
        ?? r5 = 0;
        int r10 = 0;
        r13.getClass();
        if ((r13 instanceof WildcardType) == false) goto L12;
        Type[] r14 = ((WildcardType) r13).getLowerBounds();
        TypeToken<?> r12 = of(this.runtimeType);
        int r11 = r14.length;
    L5:
        if (r10 >= r11) goto L11;
        if (r12.isSubtypeOf(r14[r10]) == true) goto L152;
        r10 = r10 + 1;
        goto L5
    L152:
        return true;
    L11:
        return !true;
    L12:
        Type r15 = this.runtimeType;
        if ((r15 instanceof WildcardType) == false) goto L23;
        Type[] r16 = ((WildcardType) r15).getUpperBounds();
        int r17 = r16.length;
    L15:
        if (r5 >= r17) goto L21;
        if (of(r16[r5]).isSubtypeOf(r13) == true) goto L153;
        r5 = r5 + 1;
        goto L15
    L153:
        return true;
    L21:
        return !true;
    L23:
        if ((r15 instanceof TypeVariable) == true) goto L25;
        boolean r18 = r15 instanceof GenericArrayType;
        if (r18 == false) goto L49;
        TypeToken<?> r19 = of(r13);
        GenericArrayType r110 = (GenericArrayType) this.runtimeType;
        Type r20 = r19.runtimeType;
        if ((r20 instanceof Class) == false) goto L45;
        Class r21 = (Class) r20;
        if (r21.isArray() == true) goto L156;
        return r21.isAssignableFrom(Object[].class);
    L156:
        return of(r110.getGenericComponentType()).isSubtypeOf(r21.getComponentType());
    L45:
        if ((r20 instanceof GenericArrayType) == true) goto L47;
        return false;
    L47:
        return of(r110.getGenericComponentType()).isSubtypeOf(((GenericArrayType) r19.runtimeType).getGenericComponentType());
    L49:
        if ((r13 instanceof Class) == false) goto L53;
        return h((Class) r13);
    L53:
        if ((r13 instanceof ParameterizedType) == false) goto L121;
        ParameterizedType r111 = (ParameterizedType) r13;
        Class<? super Object> r22 = of(r111).getRawType();
        if (h(r22) == false) goto L159;
        TypeVariable<Class<? super Object>>[] r23 = r22.getTypeParameters();
        Type[] r24 = r111.getActualTypeArguments();
        int r25 = 0;
    L59:
        if (r25 >= r23.length) goto L99;
        j r26 = this.f9346b;
        if (r26 != null) goto L71;
        Type r27 = this.runtimeType;
        ImmutableMap r28 = ImmutableMap.of();
        r27.getClass();
        e r29 = new e();
        r29.z(new Type[]{r27});
        ImmutableMap r30 = ImmutableMap.copyOf((HashMap) r29.d);
        x3 r31 = ImmutableMap.builder();
        r31.i(r28);
        Iterator r32 = r30.entrySet().iterator();
    L64:
        if (r32.hasNext() == false) goto L70;
        Map.Entry r33 = (Map.Entry) r32.next();
        g r34 = (g) r33.getKey();
        Type r35 = (Type) r33.getValue();
        r34.getClass();
        if ((r35 instanceof TypeVariable) == false) goto L68;
        boolean r112 = r34.a((TypeVariable) r35);
    L69:
        b0.h("Type variable %s bound to itself", !r112, r34);
        r31.g(r34, r35);
        goto L64
    L68:
        r112 = false;
        goto L69
    L70:
        j r36 = new j(new sj.k(r31.d(), r5));
        this.f9346b = r36;
        r26 = r36;
    L71:
        TypeToken<?> r37 = of(r26.b(r23[r25]));
        Type r38 = r24[r25];
        TypeVariable<Class<? super Object>> r39 = r23[r25];
        if (r37.runtimeType.equals(r38) == false) goto L75;
    L73:
        boolean r40 = true;
    L95:
        if (r40 == false) goto L160;
        r25 = r25 + 1;
        goto L59
    L160:
        return false;
    L75:
        if ((r38 instanceof WildcardType) == false) goto L94;
        WildcardType r41 = b(r39, (WildcardType) r38);
        Type[] r42 = r41.getUpperBounds();
        TypeToken<?> r43 = of(r37.runtimeType);
        int r44 = r42.length;
        int r113 = 0;
    L77:
        if (r113 >= r44) goto L82;
        if (r43.isSubtypeOf(r42[r113]) == false) goto L80;
        r113 = r113 + 1;
        goto L77
    L80:
        boolean r45 = false;
    L83:
        if (r45 == false) goto L93;
        Type[] r46 = r41.getLowerBounds();
        Type r47 = r37.runtimeType;
        int r48 = r46.length;
        int r49 = 0;
    L85:
        if (r49 >= r48) goto L90;
        if (of(r46[r49]).isSubtypeOf(r47) == false) goto L88;
        r49 = r49 + 1;
        goto L85
    L88:
        boolean r50 = false;
    L91:
        if (r50 == false) goto L93;
    L90:
        r50 = !false;
    L93:
        r40 = false;
        goto L95
    L82:
        r45 = !false;
        goto L83
    L94:
        r40 = c(r37.runtimeType).equals(c(r38));
        goto L95
    L99:
        if (Modifier.isStatic(((Class) r111.getRawType()).getModifiers()) == true) goto L119;
        if (r111.getOwnerType() == null) goto L119;
        Type r114 = r111.getOwnerType();
        Iterator<Object> r115 = getTypes().iterator();
    L104:
        if (r115.hasNext() == false) goto L116;
        Type r51 = ((TypeToken) r115.next()).runtimeType;
        if ((r51 instanceof ParameterizedType) == false) goto L109;
        Type r52 = ((ParameterizedType) r51).getOwnerType();
    L112:
        if (r52 == null) goto L104;
        if (of(r52).isSubtypeOf(r114) == false) goto L104;
        boolean r116 = true;
    L117:
        if (r116 == true) goto L119;
        return false;
    L109:
        if ((r51 instanceof Class) == false) goto L111;
        r52 = ((Class) r51).getEnclosingClass();
        goto L112
    L111:
        r52 = null;
        goto L112
    L116:
        r116 = false;
    L119:
        return true;
    L159:
        return false;
    L121:
        if ((r13 instanceof GenericArrayType) == false) goto L161;
        GenericArrayType r117 = (GenericArrayType) r13;
        if ((r15 instanceof Class) == false) goto L128;
        Class r53 = (Class) r15;
        if (r53.isArray() == true) goto L162;
        return false;
    L162:
        return of(r53.getComponentType()).isSubtypeOf(r117.getGenericComponentType());
    L128:
        if (r18 == true) goto L130;
        return false;
    L130:
        return of(((GenericArrayType) r15).getGenericComponentType()).isSubtypeOf(r117.getGenericComponentType());
    L161:
        return false;
    L25:
        if (r15.equals(r13) == true) goto L35;
        Type[] r118 = ((TypeVariable) this.runtimeType).getBounds();
        int r54 = r118.length;
        int r55 = 0;
    L27:
        if (r55 >= r54) goto L32;
        if (of(r118[r55]).isSubtypeOf(r13) == true) goto L30;
        r55 = r55 + 1;
        goto L27
    L30:
        boolean r119 = true;
    L33:
        if (r119 == true) goto L35;
        return false;
    L32:
        r119 = !true;
    L35:
        return true;
    }

    public final boolean isSupertypeOf(Type r5) {
        return of(r5).isSubtypeOf(getType());
    }

    public final <X> TypeToken<T> where(c r5, Class<X> r10) {
        return where(r5, of(r10));
    }

    public TypeToken(Class<?> r10) {
        boolean r5 = false;
        Type r11 = capture();
        if ((r11 instanceof Class) == false) goto L5;
        this.runtimeType = r11;
        return;
    L5:
        sj.k r12 = new sj.k(5);
        r10.getClass();
        e r13 = new e();
        r13.z(new Type[]{r10});
        ImmutableMap r14 = ImmutableMap.copyOf((HashMap) r13.d);
        x3 r15 = ImmutableMap.builder();
        r15.i((ImmutableMap) r12.f21937a);
        Iterator r16 = r14.entrySet().iterator();
    L7:
        if (r16.hasNext() == false) goto L13;
        Map.Entry r17 = (Map.Entry) r16.next();
        g r18 = (g) r17.getKey();
        Type r19 = (Type) r17.getValue();
        r18.getClass();
        if ((r19 instanceof TypeVariable) == false) goto L11;
        boolean r20 = r18.a((TypeVariable) r19);
    L12:
        b0.h("Type variable %s bound to itself", !r20, r18);
        r15.g(r18, r19);
        goto L7
    L11:
        r20 = false;
        goto L12
    L13:
        this.runtimeType = new j(new sj.k(r15.d(), r5)).b(r11);
    }

    public TypeToken(Type r5, k r10) {
        r5.getClass();
        this.runtimeType = r5;
    }
}
