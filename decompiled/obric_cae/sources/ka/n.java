package ka;

import ha.c0;
import ha.d0;
import ha.y;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class n implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ja.i f9022a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ha.d f9023b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ja.p f9024m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final e f9025n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List<y> f9026o;

    public static abstract class a<T, A> extends c0<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<String, b> f9027a;

        public a(LinkedHashMap r8) {
            this.f9027a = r8;
        }

        @Override // ha.c0
        public final T a(pa.a r8) {
            if (r8.h0() != pa.b.f9974s) goto L6;
            r8.V();
            return null;
        L6:
            A r10 = c();
            r8.i();     // Catch: IllegalAccessException -> L20 IllegalStateException -> L23
        L8:
            if (r8.B() == false) goto L18;
            String r11 = r8.J();     // Catch: IllegalAccessException -> L20 IllegalStateException -> L23
            b r12 = this.f9027a.get(r11);     // Catch: IllegalAccessException -> L20 IllegalStateException -> L23
            if (r12 == null) goto L16;
            if (r12.f9032e == false) goto L16;
            e(r10, r8, r12);     // Catch: IllegalAccessException -> L20 IllegalStateException -> L23
        L16:
            r8.u0();     // Catch: IllegalAccessException -> L20 IllegalStateException -> L23
            goto L8
        L18:
            r8.v();
            return d(r10);
        L20:
            e = move-exception;
            ma.a.AbstractC0115a r13 = ma.a.f9316a;
            throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.10.1). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", e);
        L23:
            e = move-exception;
            throw new ha.q(e);
        }

        @Override // ha.c0
        public final void b(pa.c r8, T r10) {
            if (r10 != null) goto L5;
            r8.z();
            return;
        L5:
            r8.k();
            Iterator<b> r11 = this.f9027a.values().iterator();     // Catch: IllegalAccessException -> L13
        L8:
            if (r11.hasNext() == false) goto L11;
            r11.next().c(r8, r10);     // Catch: IllegalAccessException -> L13
            goto L8
        L11:
            r8.v();
            return;
        L13:
            e = move-exception;
            ma.a.AbstractC0115a r12 = ma.a.f9316a;
            throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.10.1). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", e);
        }

        public abstract A c();

        public abstract T d(A r8);

        public abstract void e(A r8, pa.a r10, b r11);
    }

    public static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f9028a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Field f9029b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f9030c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f9031d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f9032e;

        public b(String r8, Field r10, boolean r11, boolean r12) {
            this.f9028a = r8;
            this.f9029b = r10;
            this.f9030c = r10.getName();
            this.f9031d = r11;
            this.f9032e = r12;
        }

        public abstract void a(pa.a r8, int r10, Object[] r11);

        public abstract void b(pa.a r8, Object r10);

        public abstract void c(pa.c r8, Object r10);
    }

    public static final class c<T> extends a<T, T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ja.t<T> f9033b;

        public c(ja.t r8, LinkedHashMap r10) {
            super(r10);
            this.f9033b = r8;
        }

        @Override // ka.n.a
        public final T c() {
            return this.f9033b.b();
        }

        @Override // ka.n.a
        public final T d(T r8) {
            return r8;
        }

        @Override // ka.n.a
        public final void e(T r8, pa.a r10, b r11) {
            r11.b(r10, r8);
        }
    }

    public static final class d<T> extends a<T, Object[]> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final HashMap f9034e = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Constructor<T> f9035b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Object[] f9036c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final HashMap f9037d;

        static {
            HashMap r8 = new HashMap();
            r8.put(Byte.TYPE, (byte) 0);
            r8.put(Short.TYPE, (short) 0);
            r8.put(Integer.TYPE, 0);
            r8.put(Long.TYPE, 0L);
            r8.put(Float.TYPE, Float.valueOf(0.0f));
            r8.put(Double.TYPE, Double.valueOf(0.0d));
            r8.put(Character.TYPE, (char) 0);
            r8.put(Boolean.TYPE, Boolean.FALSE);
            f9034e = r8;
        }

        public d(Class r8, LinkedHashMap r10, boolean r11) {
            super(r10);
            this.f9037d = new HashMap();
            ma.a.AbstractC0115a r12 = ma.a.f9316a;
            Constructor<T> r13 = r12.b(r8);
            this.f9035b = r13;
            if (r11 == false) goto L5;
            n.b(null, r13);
        L6:
            String[] r14 = r12.c(r8);
            int r15 = 0;
            int r16 = 0;
        L8:
            if (r16 >= r14.length) goto L10;
            this.f9037d.put(r14[r16], Integer.valueOf(r16));
            r16 = r16 + 1;
            goto L8
        L10:
            Class<?>[] r17 = this.f9035b.getParameterTypes();
            this.f9036c = new Object[r17.length];
        L12:
            if (r15 >= r17.length) goto L14;
            this.f9036c[r15] = f9034e.get(r17[r15]);
            r15 = r15 + 1;
            goto L12
        L14:
            return;
        L5:
            ma.a.e(r13);
            goto L6
        }

        @Override // ka.n.a
        public final Object[] c() {
            return (Object[]) this.f9036c.clone();
        }

        @Override // ka.n.a
        public final Object d(Object[] r8) {
            Object[] r10 = r8;
            Constructor<T> r11 = this.f9035b;
            return r11.newInstance(r10);
        L11:
            e = move-exception;
            ma.a.AbstractC0115a r12 = ma.a.f9316a;
            throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.10.1). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", e);
        L8:
            e = move-exception;
            throw new RuntimeException("Failed to invoke constructor '" + ma.a.b(r11) + "' with args " + Arrays.toString(r10), e);
        L5:
            e = move-exception;
            throw new RuntimeException("Failed to invoke constructor '" + ma.a.b(r11) + "' with args " + Arrays.toString(r10), e.getCause());
        }

        @Override // ka.n.a
        public final void e(Object[] r8, pa.a r10, b r11) {
            Object[] r12 = r8;
            HashMap r13 = this.f9037d;
            String r14 = r11.f9030c;
            Integer r15 = (Integer) r13.get(r14);
            if (r15 == null) goto L7;
            r11.a(r10, r15.intValue(), r12);
            return;
        L7:
            throw new IllegalStateException("Could not find the index in the constructor '" + ma.a.b(this.f9035b) + "' for field with name '" + r14 + "', unable to determine which argument in the constructor the field corresponds to. This is unexpected behavior, as we expect the RecordComponents to have the same names as the fields in the Java class, and that the order of the RecordComponents is the same as the order of the canonical constructor parameters.");
        }
    }

    public n(ja.i r8, ha.c.a r10, ja.p r11, e r12, List r13) {
        this.f9022a = r8;
        this.f9023b = r10;
        this.f9024m = r11;
        this.f9025n = r12;
        this.f9026o = r13;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void b(Object r8, AccessibleObject r10) {
        if (Modifier.isStatic(((Member) r10).getModifiers()) == false) goto L6;
        r8 = null;
    L6:
        if (ja.u.a.f8808a.a(r8, r10) == false) goto L9;
        return;
    L9:
        throw new ha.q(defpackage.a.e(ma.a.d(r10, true), " is not accessible and ReflectionAccessFilter does not permit making it accessible. Register a TypeAdapter for the declaring type, adjust the access filter or increase the visibility of the element and its declaring type."));
    }

    @Override // ha.d0
    public final <T> c0<T> a(ha.j r11, oa.a<T> r12) {
        Class<? super T> r8 = r12.getRawType();
        if (Object.class.isAssignableFrom(r8) == true) goto L6;
        return null;
    L6:
        y.a r10 = ja.u.a(r8, this.f9026o);
        if (r10 == y.a.f8010n) goto L19;
        if (r10 != y.a.f8009m) goto L11;
        boolean r13 = true;
    L12:
        boolean r14 = r13;
        if (ma.a.f9316a.d(r8) == false) goto L17;
        return new d(r8, c(r11, r12, r8, r14, true), r14);
    L17:
        return new c(this.f9022a.b(r12), c(r11, r12, r8, r14, false));
    L11:
        r13 = false;
        goto L12
    L19:
        throw new ha.q("ReflectionAccessFilter does not permit using reflection for " + r8 + ". Register a TypeAdapter for this type or adjust the access filter.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r30v0 */
    /* JADX WARN: Type inference failed for: r32v0 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [int] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r6v9, types: [ma.a$a] */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v7 */
    public final LinkedHashMap c(ha.j r36, oa.a r37, Class r38, boolean r39, boolean r40) {
        Class r15 = r38;
        LinkedHashMap r13 = new LinkedHashMap();
        if (r38.isInterface() == false) goto L5;
        return r13;
    L5:
        oa.a r16 = r37;
        boolean r8 = r39;
        Class r12 = r15;
    L7:
        if (r12 == Object.class) goto L95;
        Field[] r11 = r12.getDeclaredFields();
        boolean r10 = false;
        boolean r14 = true;
        if (r12 != r15) goto L11;
    L20:
        boolean r17 = r8;
    L21:
        int r18 = r11.length;
        int r19 = 0;
    L22:
        if (r19 >= r18) goto L93;
        Field r20 = r11[r19];
        boolean r21 = this.d(r20, r14);
        boolean r22 = this.d(r20, r10);
        if (r21 == true) goto L28;
        if (r22 == true) goto L28;
        int r25 = r19;
        int r26 = r18;
        Field[] r34 = r11;
        Class r310 = r12;
        LinkedHashMap r110 = r13;
    L90:
        r19 = r25 + 1;
        n this = this;
        r12 = r310;
        r13 = r110;
        r18 = r26;
        r11 = r34;
        r36 = r36;
    L28:
        if (r40 == true) goto L30;
    L43:
        boolean r111 = r22;
        Method r23 = null;
    L44:
        if (r17 == true) goto L47;
        if (r23 != null) goto L47;
        ma.a.e(r20);
    L47:
        Type r24 = ja.a.g(r16.getType(), r12, r20.getGenericType(), new HashMap());
        ia.b r27 = (ia.b) r20.getAnnotation(ia.b.class);
        if (r27 != null) goto L50;
        List r28 = Collections.singletonList(this.f9023b.a(r20));
    L53:
        List r29 = r28;
    L55:
        int r30 = r29.size();
        ?? r31 = r10;
        b r32 = null;
        ?? r33 = r29;
    L56:
        if (r31 >= r30) goto L88;
        String r35 = (String) r33.get(r31);
        if (r31 == 0) goto L60;
        boolean r210 = r10;
    L61:
        oa.a<?> r41 = oa.a.get(r24);
        Class<? super Object> r42 = r41.getRawType();
        b r311 = r32;
        if ((r42 instanceof Class) == true) goto L64;
    L66:
        boolean r43 = false;
    L67:
        boolean r211 = r43;
        int r44 = r20.getModifiers();
        if (Modifier.isStatic(r44) == true) goto L70;
    L72:
        boolean r45 = false;
    L73:
        boolean r212 = r45;
        ia.a r46 = (ia.a) r20.getAnnotation(ia.a.class);
        if (r46 == null) goto L76;
        this.f9025n.getClass();
        c0 r47 = e.b(this.f9022a, r36, r41, r46);
    L77:
        if (r47 == null) goto L79;
        boolean r48 = true;
    L80:
        boolean r213 = r48;
        if (r47 != null) goto L83;
        r47 = r36.f(r41);
    L83:
        ?? r312 = r31;
        int r313 = r30;
        ?? r314 = r33;
        Field r315 = r20;
        int r214 = r19;
        int r215 = r18;
        Field[] r316 = r11;
        Class r317 = r12;
        LinkedHashMap r112 = r13;
        r32 = (b) r112.put(r35, new m(r35, r20, r210, r111, r17, r23, r213, r47, r36, r41, r211, r212));
        if (r311 == null) goto L87;
        r32 = r311;
    L87:
        this = this;
        r12 = r317;
        r13 = r112;
        r21 = r210;
        r19 = r214;
        r18 = r215;
        r14 = true;
        r10 = false;
        r30 = r313;
        r33 = r314;
        r20 = r315;
        r11 = r316;
        r36 = r36;
        r31 = (r312 == true ? 1 : 0) + 1;
        goto L56
    L79:
        r48 = false;
        goto L80
    L76:
        r47 = null;
        goto L77
    L70:
        if (Modifier.isFinal(r44) == false) goto L72;
        r45 = true;
        goto L73
    L64:
        if (r42.isPrimitive() == false) goto L66;
        r43 = true;
        goto L67
    L60:
        r210 = r21;
        goto L61
    L88:
        b r318 = r32;
        Field r319 = r20;
        r25 = r19;
        r26 = r18;
        r34 = r11;
        r310 = r12;
        r110 = r13;
        if (r318 == null) goto L90;
        throw new IllegalArgumentException("Class " + r38.getName() + " declares multiple JSON fields named '" + r318.f9028a + "'; conflict is caused by fields " + ma.a.c(r318.f9029b) + " and " + ma.a.c(r319));
    L50:
        String r49 = r27.value();
        String[] r50 = r27.alternate();
        if (r50.length != 0) goto L54;
        r28 = Collections.singletonList(r49);
        goto L53
    L54:
        ArrayList r51 = new ArrayList(r50.length + (r14 ? 1 : 0));
        r51.add(r49);
        Collections.addAll(r51, r50);
        r29 = r51;
        goto L55
    L30:
        if (Modifier.isStatic(r20.getModifiers()) == false) goto L32;
        r22 = r10;
        goto L43
    L32:
        Method r52 = ma.a.f9316a.a(r12, r20);
        if (r17 == true) goto L36;
        ma.a.e(r52);
    L36:
        if (r52.getAnnotation(ia.b.class) != null) goto L38;
    L42:
        r111 = r22;
        r23 = r52;
        goto L44
    L38:
        if (r20.getAnnotation(ia.b.class) != null) goto L42;
        throw new ha.q(defpackage.b.d("@SerializedName on ", ma.a.d(r52, r10), " is not supported"));
    L93:
        Class r320 = r12;
        r16 = oa.a.get(ja.a.g(r16.getType(), r320, r320.getGenericSuperclass(), new HashMap()));
        r12 = r16.getRawType();
        r15 = r38;
        r8 = r17;
        goto L7
    L11:
        if (r11.length <= 0) goto L20;
        y.a r53 = ja.u.a(r12, this.f9026o);
        if (r53 == y.a.f8010n) goto L19;
        if (r53 != y.a.f8009m) goto L17;
        r17 = true;
        goto L21
    L17:
        r17 = false;
        goto L21
    L19:
        throw new ha.q("ReflectionAccessFilter does not permit using reflection for " + r12 + " (supertype of " + r15 + "). Register a TypeAdapter for this type or adjust the access filter.");
    L95:
        return r13;
    }

    public final boolean d(Field r8, boolean r10) {
        Class<?> r11 = r8.getType();
        ja.p r12 = this.f9024m;
        if (r12.b(r11) == false) goto L5;
    L8:
        boolean r13 = true;
    L9:
        if (r13 == false) goto L11;
        return false;
    L11:
        if ((r8.getModifiers() & r12.f8772b) == 0) goto L14;
    L47:
        boolean r14 = true;
    L49:
        if (r14 == false) goto L51;
        return false;
    L51:
        return true;
    L14:
        if (r12.f8771a == (-1.0d)) goto L19;
        if (r12.e((ia.c) r8.getAnnotation(ia.c.class), (ia.d) r8.getAnnotation(ia.d.class)) == false) goto L47;
    L19:
        if (r8.isSynthetic() == true) goto L47;
        if (r12.f8773m == true) goto L35;
        Class<?> r15 = r8.getType();
        if (r15.isMemberClass() == true) goto L26;
    L31:
        boolean r16 = false;
    L32:
        if (r16 == false) goto L35;
    L26:
        if ((r15.getModifiers() & 8) == 0) goto L28;
        boolean r17 = true;
    L29:
        if (r17 == true) goto L31;
        r16 = true;
        goto L32
    L28:
        r17 = false;
    L35:
        if (ja.p.d(r8.getType()) == true) goto L47;
        if (r10 == false) goto L39;
        List<ha.a> r18 = r12.f8774n;
    L41:
        if (r18.isEmpty() == true) goto L48;
        ha.b r19 = new ha.b(r8);
        Iterator<ha.a> r20 = r18.iterator();
    L44:
        if (r20.hasNext() == false) goto L48;
        if (r20.next().shouldSkipField(r19) == false) goto L44;
    L48:
        r14 = false;
        goto L49
    L39:
        r18 = r12.f8775o;
        goto L41
    L5:
        if (r12.c(r11, r10) == true) goto L8;
        r13 = false;
        goto L9
    }
}
