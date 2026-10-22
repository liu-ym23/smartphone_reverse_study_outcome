package e6;

import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.ReflectionAccessFilter;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.q;
import com.google.gson.r;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonToken;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
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

/* JADX INFO: loaded from: classes2.dex */
public final class k implements r {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.google.gson.internal.b f8673c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.google.gson.c f8674g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final com.google.gson.internal.c f8675h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final e6.e f8676i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final List<ReflectionAccessFilter> f8677j;

    class a extends c {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f8678f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Method f8679g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f8680h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ q f8681i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ com.google.gson.d f8682j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ TypeToken f8683k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ boolean f8684l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final /* synthetic */ boolean f8685m;

        a(k r10, String r11, Field r12, boolean r13, boolean r14, boolean r15, Method r16, boolean r17, q r18, com.google.gson.d r19, TypeToken r110, boolean r111, boolean r112) {
            this.f8678f = r15;
            this.f8679g = r16;
            this.f8680h = r17;
            this.f8681i = r18;
            this.f8682j = r19;
            this.f8683k = r110;
            this.f8684l = r111;
            this.f8685m = r112;
            super(r11, r12, r13, r14);
        }

        @Override // e6.k.c
        void a(i6.a r10, int r11, Object[] r12) {
            Object r13 = this.f8681i.b(r10);
            if (r13 == null) goto L5;
        L9:
            r12[r11] = r13;
            return;
        L5:
            if (this.f8684l == false) goto L9;
            throw new JsonParseException("null is not allowed as value for record component '" + this.f8689c + "' of primitive type; at path " + r10.getPath());
        }

        @Override // e6.k.c
        void b(i6.a r10, Object r11) {
            Object r12 = this.f8681i.b(r10);
            if (r12 != null) goto L7;
            if (this.f8684l == false) goto L7;
            return;
        L7:
            if (this.f8678f == false) goto L10;
            k.a(r11, this.f8688b);
        L11:
            this.f8688b.set(r11, r12);
            return;
        L10:
            if (this.f8685m == false) goto L11;
            throw new JsonIOException("Cannot set value of 'static final' " + g6.a.g(this.f8688b, false));
        }

        @Override // e6.k.c
        void c(com.google.gson.stream.a r10, Object r11) {
            if (this.f8690d == true) goto L6;
            return;
        L6:
            if (this.f8678f == false) goto L11;
            AccessibleObject r12 = this.f8679g;
            if (r12 != null) goto L10;
            r12 = this.f8688b;
        L10:
            k.a(r11, r12);
        L11:
            Method r13 = this.f8679g;
            if (r13 != null) goto L28;
            Object r14 = this.f8688b.get(r11);
        L20:
            if (r14 != r11) goto L22;
            return;
        L22:
            r10.v(this.f8687a);
            if (this.f8680h == false) goto L25;
            q r15 = this.f8681i;
        L26:
            r15.d(r10, r14);
            return;
        L25:
            r15 = new n(this.f8682j, this.f8681i, this.f8683k.getType());
            goto L26
        L28:
            r14 = r13.invoke(r11, new Object[0]);     // Catch: InvocationTargetException -> L16
        L16:
            e = move-exception;
            throw new JsonIOException("Accessor " + g6.a.g(this.f8679g, false) + " threw exception", e.getCause());
        }
    }

    public static abstract class b<T, A> extends q<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Map<String, c> f8686a;

        b(Map<String, c> r10) {
            this.f8686a = r10;
        }

        @Override // com.google.gson.q
        public T b(i6.a r10) {
            if (r10.Q() != JsonToken.NULL) goto L6;
            r10.K();
            return null;
        L6:
            A r11 = e();
            r10.c();     // Catch: IllegalAccessException -> L20 IllegalStateException -> L23
        L8:
            if (r10.u() == false) goto L18;
            String r12 = r10.I();     // Catch: IllegalAccessException -> L20 IllegalStateException -> L23
            c r13 = this.f8686a.get(r12);     // Catch: IllegalAccessException -> L20 IllegalStateException -> L23
            if (r13 == null) goto L16;
            if (r13.f8691e == false) goto L16;
            g(r11, r10, r13);     // Catch: IllegalAccessException -> L20 IllegalStateException -> L23
        L16:
            r10.i0();     // Catch: IllegalAccessException -> L20 IllegalStateException -> L23
            goto L8
        L18:
            r10.o();
            return f(r11);
        L20:
            e = move-exception;
            throw g6.a.e(e);
        L23:
            e = move-exception;
            throw new JsonSyntaxException(e);
        }

        @Override // com.google.gson.q
        public void d(com.google.gson.stream.a r10, T r11) {
            if (r11 != null) goto L5;
            r10.B();
            return;
        L5:
            r10.i();
            Iterator<c> r12 = this.f8686a.values().iterator();     // Catch: IllegalAccessException -> L13
        L8:
            if (r12.hasNext() == false) goto L11;
            r12.next().c(r10, r11);     // Catch: IllegalAccessException -> L13
            goto L8
        L11:
            r10.o();
            return;
        L13:
            e = move-exception;
            throw g6.a.e(e);
        }

        abstract A e();

        abstract T f(A r10);

        abstract void g(A r10, i6.a r11, c r12);
    }

    static abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f8687a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Field f8688b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final String f8689c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final boolean f8690d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final boolean f8691e;

        protected c(String r10, Field r11, boolean r12, boolean r13) {
            this.f8687a = r10;
            this.f8688b = r11;
            this.f8689c = r11.getName();
            this.f8690d = r12;
            this.f8691e = r13;
        }

        abstract void a(i6.a r10, int r11, Object[] r12);

        abstract void b(i6.a r10, Object r11);

        abstract void c(com.google.gson.stream.a r10, Object r11);
    }

    private static final class d<T> extends b<T, T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.google.gson.internal.f<T> f8692b;

        d(com.google.gson.internal.f<T> r10, Map<String, c> r11) {
            super(r11);
            this.f8692b = r10;
        }

        @Override // e6.k.b
        T e() {
            return this.f8692b.a();
        }

        @Override // e6.k.b
        T f(T r10) {
            return r10;
        }

        @Override // e6.k.b
        void g(T r10, i6.a r11, c r12) {
            r12.b(r11, r10);
        }
    }

    private static final class e<T> extends b<T, Object[]> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        static final Map<Class<?>, Object> f8693e = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Constructor<T> f8694b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Object[] f8695c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Map<String, Integer> f8696d;

        static {
            f8693e = j();
        }

        e(Class<T> r10, Map<String, c> r11, boolean r12) {
            super(r11);
            this.f8696d = new HashMap();
            Constructor<T> r13 = g6.a.i(r10);
            this.f8694b = r13;
            if (r12 == false) goto L5;
            k.a(null, r13);
        L6:
            String[] r14 = g6.a.j(r10);
            int r15 = 0;
            int r16 = 0;
        L8:
            if (r16 >= r14.length) goto L10;
            this.f8696d.put(r14[r16], Integer.valueOf(r16));
            r16 = r16 + 1;
            goto L8
        L10:
            Class<?>[] r17 = this.f8694b.getParameterTypes();
            this.f8695c = new Object[r17.length];
        L12:
            if (r15 >= r17.length) goto L14;
            this.f8695c[r15] = f8693e.get(r17[r15]);
            r15 = r15 + 1;
            goto L12
        L14:
            return;
        L5:
            g6.a.l(r13);
            goto L6
        }

        private static Map<Class<?>, Object> j() {
            HashMap r10 = new HashMap();
            r10.put(Byte.TYPE, (byte) 0);
            r10.put(Short.TYPE, (short) 0);
            r10.put(Integer.TYPE, 0);
            r10.put(Long.TYPE, 0L);
            r10.put(Float.TYPE, Float.valueOf(0.0f));
            r10.put(Double.TYPE, Double.valueOf(0.0d));
            r10.put(Character.TYPE, (char) 0);
            r10.put(Boolean.TYPE, Boolean.FALSE);
            return r10;
        }

        @Override // e6.k.b
        /* bridge */ /* synthetic */ Object[] e() {
            return h();
        }

        @Override // e6.k.b
        /* bridge */ /* synthetic */ Object f(Object[] r10) {
            return i(r10);
        }

        @Override // e6.k.b
        /* bridge */ /* synthetic */ void g(Object[] r10, i6.a r11, c r12) {
            k(r10, r11, r12);
        }

        Object[] h() {
            return (Object[]) this.f8695c.clone();
        }

        T i(Object[] r10) {
            return this.f8694b.newInstance(r10);
        L11:
            e = move-exception;
            throw g6.a.e(e);
        L8:
            e = move-exception;
            throw new RuntimeException("Failed to invoke constructor '" + g6.a.c(this.f8694b) + "' with args " + Arrays.toString(r10), e);
        L5:
            e = move-exception;
            throw new RuntimeException("Failed to invoke constructor '" + g6.a.c(this.f8694b) + "' with args " + Arrays.toString(r10), e.getCause());
        }

        void k(Object[] r10, i6.a r11, c r12) {
            Integer r13 = this.f8696d.get(r12.f8689c);
            if (r13 == null) goto L7;
            r12.a(r11, r13.intValue(), r10);
            return;
        L7:
            throw new IllegalStateException("Could not find the index in the constructor '" + g6.a.c(this.f8694b) + "' for field with name '" + r12.f8689c + "', unable to determine which argument in the constructor the field corresponds to. This is unexpected behavior, as we expect the RecordComponents to have the same names as the fields in the Java class, and that the order of the RecordComponents is the same as the order of the canonical constructor parameters.");
        }
    }

    public k(com.google.gson.internal.b r10, com.google.gson.c r11, com.google.gson.internal.c r12, e6.e r13, List<ReflectionAccessFilter> r14) {
        this.f8673c = r10;
        this.f8674g = r11;
        this.f8675h = r12;
        this.f8676i = r13;
        this.f8677j = r14;
    }

    static /* synthetic */ void a(Object r10, AccessibleObject r11) {
        c(r10, r11);
    }

    private static <M extends AccessibleObject & Member> void c(Object r10, M r11) {
        if (Modifier.isStatic(r11.getModifiers()) == false) goto L6;
        r10 = null;
    L6:
        if (com.google.gson.internal.i.a(r11, r10) == false) goto L9;
        return;
    L9:
        throw new JsonIOException(g6.a.g(r11, true) + " is not accessible and ReflectionAccessFilter does not permit making it accessible. Register a TypeAdapter for the declaring type, adjust the access filter or increase the visibility of the element and its declaring type.");
    }

    private c d(com.google.gson.d r16, Field r17, Method r18, String r19, TypeToken<?> r20, boolean r21, boolean r22, boolean r23) {
        boolean r12 = com.google.gson.internal.h.a(r20.getRawType());
        int r10 = r17.getModifiers();
        if (Modifier.isStatic(r10) == true) goto L5;
    L7:
        boolean r13 = false;
    L8:
        d6.b r11 = (d6.b) r17.getAnnotation(d6.b.class);
        q<?> r14 = null;
        if (r11 == null) goto L11;
        r14 = this.f8676i.a(this.f8673c, r16, r20, r11);
    L11:
        if (r14 == null) goto L13;
        boolean r15 = true;
    L14:
        if (r14 != null) goto L16;
        q<?> r24 = r16.m(r20);
    L18:
        return new a(this, r19, r17, r21, r22, r23, r18, r15, r24, r16, r20, r12, r13);
    L16:
        r24 = r14;
        goto L18
    L13:
        r15 = false;
        goto L14
    L5:
        if (Modifier.isFinal(r10) == false) goto L7;
        r13 = true;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r22v0 */
    private Map<String, c> e(com.google.gson.d r29, TypeToken<?> r30, Class<?> r31, boolean r32, boolean r33) {
        LinkedHashMap r11 = new LinkedHashMap();
        if (r31.isInterface() == false) goto L5;
        return r11;
    L5:
        TypeToken<?> r12 = r30;
        boolean r10 = r32;
        Class<?> r13 = r31;
    L7:
        if (r13 == Object.class) goto L63;
        Field[] r14 = r13.getDeclaredFields();
        boolean r15 = true;
        boolean r16 = false;
        if (r13 != r31) goto L11;
    L20:
        boolean r17 = r10;
        int r18 = r14.length;
        int r19 = 0;
    L21:
        if (r19 >= r18) goto L62;
        Field r20 = r14[r19];
        boolean r21 = this.g(r20, r15);
        boolean r22 = this.g(r20, r16);
        if (r21 == true) goto L26;
        if (r22 == true) goto L26;
        int r23 = r19;
        int r26 = r18;
        boolean r27 = r16;
    L59:
        r19 = r23 + 1;
        r15 = true;
        k this = this;
        r18 = r26;
        r16 = r27;
    L26:
        c r24 = null;
        if (r33 == true) goto L29;
        boolean r110 = r22;
        Method r111 = null;
    L43:
        if (r17 == true) goto L46;
        if (r111 != null) goto L46;
        g6.a.l(r20);
    L46:
        Type r112 = C$Gson$Types.o(r12.getType(), r13, r20.getGenericType());
        List<String> r25 = this.f(r20);
        int r28 = r25.size();
        ?? r34 = r16;
    L47:
        if (r34 >= r28) goto L57;
        String r113 = r25.get(r34);
        if (r34 == 0) goto L51;
        boolean r210 = r16;
    L52:
        ?? r211 = r34;
        c r35 = r24;
        int r212 = r28;
        List<String> r213 = r25;
        Field r214 = r20;
        int r215 = r19;
        int r216 = r18;
        boolean r217 = r16;
        c r36 = (c) r11.put(r113, d(r29, r20, r111, r113, TypeToken.get(r112), r210, r110, r17));
        if (r35 != null) goto L55;
        r24 = r36;
    L56:
        r21 = r210;
        r19 = r215;
        r28 = r212;
        r25 = r213;
        r20 = r214;
        r18 = r216;
        r16 = r217;
        r34 = (r211 == true ? 1 : 0) + 1;
        goto L47
    L55:
        r24 = r35;
        goto L56
    L51:
        r210 = r21;
        goto L52
    L57:
        c r37 = r24;
        Field r218 = r20;
        r23 = r19;
        r26 = r18;
        r27 = r16;
        if (r37 == null) goto L59;
        throw new IllegalArgumentException("Class " + r31.getName() + " declares multiple JSON fields named '" + r37.f8687a + "'; conflict is caused by fields " + g6.a.f(r37.f8688b) + " and " + g6.a.f(r218));
    L29:
        if (Modifier.isStatic(r20.getModifiers()) == false) goto L31;
        r111 = null;
        r110 = r16;
        goto L43
    L31:
        Method r38 = g6.a.h(r13, r20);
        if (r17 == true) goto L35;
        g6.a.l(r38);
    L35:
        if (r38.getAnnotation(d6.c.class) != null) goto L37;
    L41:
        r110 = r22;
        r111 = r38;
        goto L43
    L37:
        if (r20.getAnnotation(d6.c.class) != null) goto L41;
        throw new JsonIOException("@SerializedName on " + g6.a.g(r38, r16) + " is not supported");
    L62:
        r12 = TypeToken.get(C$Gson$Types.o(r12.getType(), r13, r13.getGenericSuperclass()));
        r13 = r12.getRawType();
        r10 = r17;
        goto L7
    L11:
        if (r14.length <= 0) goto L20;
        ReflectionAccessFilter.FilterResult r39 = com.google.gson.internal.i.b(this.f8677j, r13);
        if (r39 == ReflectionAccessFilter.FilterResult.BLOCK_ALL) goto L19;
        if (r39 != ReflectionAccessFilter.FilterResult.BLOCK_INACCESSIBLE) goto L17;
        r10 = true;
        goto L20
    L17:
        r10 = false;
        goto L20
    L19:
        throw new JsonIOException("ReflectionAccessFilter does not permit using reflection for " + r13 + " (supertype of " + r31 + "). Register a TypeAdapter for this type or adjust the access filter.");
    L63:
        return r11;
    }

    private List<String> f(Field r10) {
        d6.c r11 = (d6.c) r10.getAnnotation(d6.c.class);
        if (r11 == null) goto L5;
        String r12 = r11.value();
        String[] r13 = r11.alternate();
        if (r13.length == 0) goto L9;
        ArrayList r14 = new ArrayList(r13.length + 1);
        r14.add(r12);
        Collections.addAll(r14, r13);
        return r14;
    L9:
        return Collections.singletonList(r12);
    L5:
        return Collections.singletonList(this.f8674g.translateName(r10));
    }

    private boolean g(Field r10, boolean r11) {
        if (this.f8675h.e(r10.getType(), r11) == false) goto L5;
    L7:
        return false;
    L5:
        if (this.f8675h.h(r10, r11) == true) goto L7;
        return true;
    }

    @Override // com.google.gson.r
    public <T> q<T> b(com.google.gson.d r11, TypeToken<T> r12) {
        Class<? super T> r10 = r12.getRawType();
        if (Object.class.isAssignableFrom(r10) == true) goto L6;
        return null;
    L6:
        ReflectionAccessFilter.FilterResult r13 = com.google.gson.internal.i.b(this.f8677j, r10);
        if (r13 == ReflectionAccessFilter.FilterResult.BLOCK_ALL) goto L19;
        if (r13 != ReflectionAccessFilter.FilterResult.BLOCK_INACCESSIBLE) goto L11;
        boolean r14 = true;
    L12:
        boolean r15 = r14;
        if (g6.a.k(r10) == false) goto L17;
        return new e(r10, e(r11, r12, r10, r15, true), r15);
    L17:
        return new d(this.f8673c.b(r12), e(r11, r12, r10, r15, false));
    L11:
        r14 = false;
        goto L12
    L19:
        throw new JsonIOException("ReflectionAccessFilter does not permit using reflection for " + r10 + ". Register a TypeAdapter for this type or adjust the access filter.");
    }
}
