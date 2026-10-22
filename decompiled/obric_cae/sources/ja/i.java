package ja;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Type, ha.l<?>> f8757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f8758b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<ha.y> f8759c;

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class a<T> implements t<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ha.l f8760a;

        public a(ha.l r8, Type r10) {
            this.f8760a = r8;
        }

        @Override // ja.t
        public final T b() {
            return (T) this.f8760a.a();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class b<T> implements t<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ha.l f8761a;

        public b(ha.l r8, Type r10) {
            this.f8761a = r8;
        }

        @Override // ja.t
        public final T b() {
            return (T) this.f8761a.a();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class c<T> implements t<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f8762a;

        public c(String r8) {
            this.f8762a = r8;
        }

        @Override // ja.t
        public final T b() {
            throw new ha.q(this.f8762a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class d<T> implements t<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f8763a;

        public d(String r8) {
            this.f8763a = r8;
        }

        @Override // ja.t
        public final T b() {
            throw new ha.q(this.f8763a);
        }
    }

    public i(boolean r8, List r10, Map r11) {
        this.f8757a = r11;
        this.f8758b = r8;
        this.f8759c = r10;
    }

    public static String a(Class<?> r8) {
        int r10 = r8.getModifiers();
        if (Modifier.isInterface(r10) == false) goto L8;
        String r11 = r8.getName();
        String r12 = "Interfaces can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Interface name: ";
    L6:
        return r12.concat(r11);
    L8:
        if (Modifier.isAbstract(r10) == false) goto L10;
        r11 = r8.getName();
        r12 = "Abstract classes can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Class name: ";
        goto L6
    L10:
        return null;
    }

    public final <T> t<T> b(oa.a<T> r10) {
        Type r8 = r10.getType();
        Class<? super T> r11 = r10.getRawType();
        Map<Type, ha.l<?>> r12 = this.f8757a;
        ha.l<?> r13 = r12.get(r8);
        if (r13 != null) goto L5;
        ha.l<?> r14 = r12.get(r11);
        if (r14 != null) goto L9;
        t<T> r15 = null;
        if (EnumSet.class.isAssignableFrom(r11) == false) goto L14;
        t<T> r16 = new k(r8);
    L17:
        if (r16 == null) goto L19;
        return r16;
    L19:
        ha.y.a r17 = u.a(r11, this.f8759c);
        if (Modifier.isAbstract(r11.getModifiers()) == false) goto L95;
    L45:
        t<T> r18 = null;
    L46:
        if (r18 == null) goto L49;
        return r18;
    L49:
        if (Collection.class.isAssignableFrom(r11) == false) goto L61;
        if (SortedSet.class.isAssignableFrom(r11) == false) goto L54;
        r15 = new defpackage.c();
    L77:
        if (r15 == null) goto L79;
        return r15;
    L79:
        String r19 = a(r11);
        if (r19 == null) goto L84;
        return new c(r19);
    L84:
        if (r17 != ha.y.a.f8007a) goto L91;
        if (this.f8758b == false) goto L89;
        return new h(r11);
    L89:
        return new j("Unable to create instance of " + r11 + "; usage of JDK Unsafe is disabled. Registering an InstanceCreator or a TypeAdapter for this type, adding a no-args constructor, or enabling usage of JDK Unsafe may fix this problem.");
    L91:
        return new d("Unable to create instance of " + r11 + "; ReflectionAccessFilter does not permit using reflection or Unsafe. Register an InstanceCreator or a TypeAdapter for this type or adjust the access filter to allow using reflection.");
    L54:
        if (Set.class.isAssignableFrom(r11) == false) goto L57;
        r15 = new l6.a();
        goto L77
    L57:
        if (Queue.class.isAssignableFrom(r11) == false) goto L59;
        r15 = new t2.b();
        goto L77
    L59:
        r15 = new ja.b();
        goto L77
    L61:
        if (Map.class.isAssignableFrom(r11) == false) goto L77;
        if (ConcurrentNavigableMap.class.isAssignableFrom(r11) == false) goto L66;
        r15 = new ja.c();
        goto L77
    L66:
        if (ConcurrentMap.class.isAssignableFrom(r11) == false) goto L69;
        r15 = new ja.d();
        goto L77
    L69:
        if (SortedMap.class.isAssignableFrom(r11) == false) goto L72;
        r15 = new e();
        goto L77
    L72:
        if ((r8 instanceof ParameterizedType) == true) goto L74;
    L76:
        r15 = new g();
        goto L77
    L74:
        if (String.class.isAssignableFrom(oa.a.get(((ParameterizedType) r8).getActualTypeArguments()[0]).getRawType()) == true) goto L76;
        r15 = new f();
        goto L77
    L95:
        Constructor<? super T> r20 = r11.getDeclaredConstructor(new Class[0]);     // Catch: NoSuchMethodException -> L92
        ha.y.a r21 = ha.y.a.f8007a;
        if (r17 != r21) goto L26;
    L33:
        boolean r22 = true;
    L34:
        if (r22 == true) goto L36;
        r18 = new m("Unable to invoke no-args constructor of " + r11 + "; constructor is not accessible and ReflectionAccessFilter does not permit making it accessible. Register an InstanceCreator or a TypeAdapter for this type, change the visibility of the constructor or adjust the access filter.");
        goto L46
    L36:
        if (r17 != r21) goto L44;
        ma.a.AbstractC0115a r23 = ma.a.f9316a;
        r20.setAccessible(true);     // Catch: Exception -> L40
        String r24 = null;
    L42:
        if (r24 == null) goto L44;
        r18 = new n(r24);
    L40:
        e = move-exception;
        r24 = "Failed making constructor '" + ma.a.b(r20) + "' accessible; either increase its visibility or write a custom InstanceCreator or TypeAdapter for its declaring type: " + e.getMessage();
    L44:
        r18 = new o(r20);
        goto L46
    L26:
        if (u.a.f8808a.a(null, r20) == true) goto L28;
    L32:
        r22 = false;
        goto L34
    L28:
        if (r17 != ha.y.a.f8010n) goto L33;
        if (Modifier.isPublic(r20.getModifiers()) == false) goto L32;
    L14:
        if (r11 != EnumMap.class) goto L16;
        r16 = new l(r8);
        goto L17
    L16:
        r16 = null;
        goto L17
    L9:
        return new b(r14, r8);
    L5:
        return new a(r13, r8);
    }

    public final String toString() {
        return this.f8757a.toString();
    }
}
