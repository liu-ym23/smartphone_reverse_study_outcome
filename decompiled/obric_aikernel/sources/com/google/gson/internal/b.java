package com.google.gson.internal;

import com.google.gson.JsonIOException;
import com.google.gson.ReflectionAccessFilter;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<Type, com.google.gson.e<?>> f4230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f4231b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<ReflectionAccessFilter> f4232c;

    /* JADX INFO: Add missing generic type declarations: [T] */
    class a<T> implements com.google.gson.internal.f<T> {
        a() {
        }

        @Override // com.google.gson.internal.f
        public T a() {
            return (T) new TreeSet();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.google.gson.internal.b$b, reason: collision with other inner class name */
    class C0091b<T> implements com.google.gson.internal.f<T> {
        C0091b() {
        }

        @Override // com.google.gson.internal.f
        public T a() {
            return (T) new LinkedHashSet();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class c<T> implements com.google.gson.internal.f<T> {
        c() {
        }

        @Override // com.google.gson.internal.f
        public T a() {
            return (T) new ArrayDeque();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class d<T> implements com.google.gson.internal.f<T> {
        d() {
        }

        @Override // com.google.gson.internal.f
        public T a() {
            return (T) new ArrayList();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class e<T> implements com.google.gson.internal.f<T> {
        e() {
        }

        @Override // com.google.gson.internal.f
        public T a() {
            return (T) new ConcurrentSkipListMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class f<T> implements com.google.gson.internal.f<T> {
        f() {
        }

        @Override // com.google.gson.internal.f
        public T a() {
            return (T) new ConcurrentHashMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class g<T> implements com.google.gson.internal.f<T> {
        g() {
        }

        @Override // com.google.gson.internal.f
        public T a() {
            return (T) new TreeMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class h<T> implements com.google.gson.internal.f<T> {
        h() {
        }

        @Override // com.google.gson.internal.f
        public T a() {
            return (T) new LinkedHashMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class i<T> implements com.google.gson.internal.f<T> {
        i() {
        }

        @Override // com.google.gson.internal.f
        public T a() {
            return (T) new LinkedTreeMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class j<T> implements com.google.gson.internal.f<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Class f4233a;

        j(b r10, Class r11) {
            this.f4233a = r11;
        }

        @Override // com.google.gson.internal.f
        public T a() {
            return (T) com.google.gson.internal.k.f4267a.d(this.f4233a);
        L4:
            e = move-exception;
            throw new RuntimeException("Unable to create instance of " + this.f4233a + ". Registering an InstanceCreator or a TypeAdapter for this type, or adding a no-args constructor may fix this problem.", e);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class k<T> implements com.google.gson.internal.f<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.google.gson.e f4234a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Type f4235b;

        k(b r10, com.google.gson.e r11, Type r12) {
            this.f4234a = r11;
            this.f4235b = r12;
        }

        @Override // com.google.gson.internal.f
        public T a() {
            return (T) this.f4234a.a(this.f4235b);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class l<T> implements com.google.gson.internal.f<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4236a;

        l(b r10, String r11) {
            this.f4236a = r11;
        }

        @Override // com.google.gson.internal.f
        public T a() {
            throw new JsonIOException(this.f4236a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class m<T> implements com.google.gson.internal.f<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.google.gson.e f4237a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Type f4238b;

        m(b r10, com.google.gson.e r11, Type r12) {
            this.f4237a = r11;
            this.f4238b = r12;
        }

        @Override // com.google.gson.internal.f
        public T a() {
            return (T) this.f4237a.a(this.f4238b);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class n<T> implements com.google.gson.internal.f<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4239a;

        n(b r10, String r11) {
            this.f4239a = r11;
        }

        @Override // com.google.gson.internal.f
        public T a() {
            throw new JsonIOException(this.f4239a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class o<T> implements com.google.gson.internal.f<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4240a;

        o(b r10, String r11) {
            this.f4240a = r11;
        }

        @Override // com.google.gson.internal.f
        public T a() {
            throw new JsonIOException(this.f4240a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class p<T> implements com.google.gson.internal.f<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Type f4241a;

        p(Type r10) {
            this.f4241a = r10;
        }

        @Override // com.google.gson.internal.f
        public T a() {
            Type r10 = this.f4241a;
            if ((r10 instanceof ParameterizedType) == false) goto L11;
            Type r11 = ((ParameterizedType) r10).getActualTypeArguments()[0];
            if ((r11 instanceof Class) == false) goto L9;
            return (T) EnumSet.noneOf((Class) r11);
        L9:
            throw new JsonIOException("Invalid EnumSet type: " + this.f4241a.toString());
        L11:
            throw new JsonIOException("Invalid EnumSet type: " + this.f4241a.toString());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class q<T> implements com.google.gson.internal.f<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Type f4242a;

        q(Type r10) {
            this.f4242a = r10;
        }

        @Override // com.google.gson.internal.f
        public T a() {
            Type r10 = this.f4242a;
            if ((r10 instanceof ParameterizedType) == false) goto L11;
            Type r11 = ((ParameterizedType) r10).getActualTypeArguments()[0];
            if ((r11 instanceof Class) == false) goto L9;
            return (T) new EnumMap((Class) r11);
        L9:
            throw new JsonIOException("Invalid EnumMap type: " + this.f4242a.toString());
        L11:
            throw new JsonIOException("Invalid EnumMap type: " + this.f4242a.toString());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class r<T> implements com.google.gson.internal.f<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4243a;

        r(String r10) {
            this.f4243a = r10;
        }

        @Override // com.google.gson.internal.f
        public T a() {
            throw new JsonIOException(this.f4243a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class s<T> implements com.google.gson.internal.f<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4244a;

        s(String r10) {
            this.f4244a = r10;
        }

        @Override // com.google.gson.internal.f
        public T a() {
            throw new JsonIOException(this.f4244a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class t<T> implements com.google.gson.internal.f<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Constructor f4245a;

        t(Constructor r10) {
            this.f4245a = r10;
        }

        @Override // com.google.gson.internal.f
        public T a() {
            return (T) this.f4245a.newInstance(new Object[0]);
        L5:
            e = move-exception;
            throw g6.a.e(e);
        L11:
            e = move-exception;
            throw new RuntimeException("Failed to invoke constructor '" + g6.a.c(this.f4245a) + "' with no args", e);
        L8:
            e = move-exception;
            throw new RuntimeException("Failed to invoke constructor '" + g6.a.c(this.f4245a) + "' with no args", e.getCause());
        }
    }

    public b(Map<Type, com.google.gson.e<?>> r10, boolean r11, List<ReflectionAccessFilter> r12) {
        this.f4230a = r10;
        this.f4231b = r11;
        this.f4232c = r12;
    }

    static String a(Class<?> r10) {
        int r11 = r10.getModifiers();
        if (Modifier.isInterface(r11) == false) goto L8;
        StringBuilder r12 = new StringBuilder();
        String r13 = "Interfaces can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Interface name: ";
    L5:
        r12.append(r13);
        r12.append(r10.getName());
        return r12.toString();
    L8:
        if (Modifier.isAbstract(r11) == false) goto L10;
        r12 = new StringBuilder();
        r13 = "Abstract classes can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Class name: ";
        goto L5
    L10:
        return null;
    }

    private static <T> com.google.gson.internal.f<T> c(Class<? super T> r10, ReflectionAccessFilter.FilterResult r11) {
        if (Modifier.isAbstract(r10.getModifiers()) == false) goto L5;
        return null;
    L5:
        boolean r12 = false;
        Constructor<? super T> r13 = r10.getDeclaredConstructor(new Class[0]);     // Catch: NoSuchMethodException -> L26
        ReflectionAccessFilter.FilterResult r14 = ReflectionAccessFilter.FilterResult.ALLOW;
        if (r11 != r14) goto L10;
    L15:
        r12 = true;
    L16:
        if (r12 == false) goto L18;
        if (r11 != r14) goto L25;
        String r15 = g6.a.m(r13);
        if (r15 == null) goto L25;
        return new s(r15);
    L25:
        return new t(r13);
    L18:
        return new r("Unable to invoke no-args constructor of " + r10 + "; constructor is not accessible and ReflectionAccessFilter does not permit making it accessible. Register an InstanceCreator or a TypeAdapter for this type, change the visibility of the constructor or adjust the access filter.");
    L10:
        if (com.google.gson.internal.i.a(r13, null) == false) goto L16;
        if (r11 != ReflectionAccessFilter.FilterResult.BLOCK_ALL) goto L15;
        if (Modifier.isPublic(r13.getModifiers()) == false) goto L16;
    L26:
        return null;
    }

    private static <T> com.google.gson.internal.f<T> d(Type r10, Class<? super T> r11) {
        if (Collection.class.isAssignableFrom(r11) == false) goto L19;
        if (SortedSet.class.isAssignableFrom(r11) == false) goto L9;
        return new a();
    L9:
        if (Set.class.isAssignableFrom(r11) == false) goto L13;
        return new C0091b();
    L13:
        if (Queue.class.isAssignableFrom(r11) == false) goto L17;
        return new c();
    L17:
        return new d();
    L19:
        if (Map.class.isAssignableFrom(r11) == true) goto L21;
        return null;
    L21:
        if (ConcurrentNavigableMap.class.isAssignableFrom(r11) == false) goto L25;
        return new e();
    L25:
        if (ConcurrentMap.class.isAssignableFrom(r11) == false) goto L29;
        return new f();
    L29:
        if (SortedMap.class.isAssignableFrom(r11) == false) goto L33;
        return new g();
    L33:
        if ((r10 instanceof ParameterizedType) == false) goto L39;
        if (String.class.isAssignableFrom(TypeToken.get(((ParameterizedType) r10).getActualTypeArguments()[0]).getRawType()) == true) goto L39;
        return new h();
    L39:
        return new i();
    }

    private static <T> com.google.gson.internal.f<T> e(Type r10, Class<? super T> r11) {
        if (EnumSet.class.isAssignableFrom(r11) == false) goto L7;
        return new p(r10);
    L7:
        if (r11 == EnumMap.class) goto L9;
        return null;
    L9:
        return new q(r10);
    }

    private <T> com.google.gson.internal.f<T> f(Class<? super T> r10) {
        if (this.f4231b == false) goto L7;
        return new j(this, r10);
    L7:
        return new l(this, "Unable to create instance of " + r10 + "; usage of JDK Unsafe is disabled. Registering an InstanceCreator or a TypeAdapter for this type, adding a no-args constructor, or enabling usage of JDK Unsafe may fix this problem.");
    }

    public <T> com.google.gson.internal.f<T> b(TypeToken<T> r10) {
        Type r11 = r10.getType();
        Class<? super T> r12 = r10.getRawType();
        com.google.gson.e<?> r13 = this.f4230a.get(r11);
        if (r13 != null) goto L5;
        com.google.gson.e<?> r14 = this.f4230a.get(r12);
        if (r14 != null) goto L9;
        com.google.gson.internal.f<T> r15 = e(r11, r12);
        if (r15 == null) goto L13;
        return r15;
    L13:
        ReflectionAccessFilter.FilterResult r16 = com.google.gson.internal.i.b(this.f4232c, r12);
        com.google.gson.internal.f<T> r17 = c(r12, r16);
        if (r17 == null) goto L16;
        return r17;
    L16:
        com.google.gson.internal.f<T> r18 = d(r11, r12);
        if (r18 == null) goto L19;
        return r18;
    L19:
        String r19 = a(r12);
        if (r19 == null) goto L24;
        return new n(this, r19);
    L24:
        if (r16 != ReflectionAccessFilter.FilterResult.ALLOW) goto L28;
        return f(r12);
    L28:
        return new o(this, "Unable to create instance of " + r12 + "; ReflectionAccessFilter does not permit using reflection or Unsafe. Register an InstanceCreator or a TypeAdapter for this type or adjust the access filter to allow using reflection.");
    L9:
        return new m(this, r14, r11);
    L5:
        return new k(this, r13, r11);
    }

    public String toString() {
        return this.f4230a.toString();
    }
}
