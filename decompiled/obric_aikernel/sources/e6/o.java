package e6;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonToken;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* JADX INFO: loaded from: classes2.dex */
public final class o {
    public static final com.google.gson.q<BigInteger> A = null;
    public static final com.google.gson.q<LazilyParsedNumber> B = null;
    public static final com.google.gson.r C = null;
    public static final com.google.gson.q<StringBuilder> D = null;
    public static final com.google.gson.r E = null;
    public static final com.google.gson.q<StringBuffer> F = null;
    public static final com.google.gson.r G = null;
    public static final com.google.gson.q<URL> H = null;
    public static final com.google.gson.r I = null;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final com.google.gson.q<URI> f8708J = null;
    public static final com.google.gson.r K = null;
    public static final com.google.gson.q<InetAddress> L = null;
    public static final com.google.gson.r M = null;
    public static final com.google.gson.q<UUID> N = null;
    public static final com.google.gson.r O = null;
    public static final com.google.gson.q<Currency> P = null;
    public static final com.google.gson.r Q = null;
    public static final com.google.gson.q<Calendar> R = null;
    public static final com.google.gson.r S = null;
    public static final com.google.gson.q<Locale> T = null;
    public static final com.google.gson.r U = null;
    public static final com.google.gson.q<com.google.gson.i> V = null;
    public static final com.google.gson.r W = null;
    public static final com.google.gson.r X = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.google.gson.q<Class> f8709a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.google.gson.r f8710b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final com.google.gson.q<BitSet> f8711c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final com.google.gson.r f8712d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final com.google.gson.q<Boolean> f8713e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final com.google.gson.q<Boolean> f8714f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final com.google.gson.r f8715g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final com.google.gson.q<Number> f8716h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final com.google.gson.r f8717i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final com.google.gson.q<Number> f8718j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final com.google.gson.r f8719k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final com.google.gson.q<Number> f8720l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final com.google.gson.r f8721m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final com.google.gson.q<AtomicInteger> f8722n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final com.google.gson.r f8723o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final com.google.gson.q<AtomicBoolean> f8724p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final com.google.gson.r f8725q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final com.google.gson.q<AtomicIntegerArray> f8726r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final com.google.gson.r f8727s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final com.google.gson.q<Number> f8728t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final com.google.gson.q<Number> f8729u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final com.google.gson.q<Number> f8730v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final com.google.gson.q<Character> f8731w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final com.google.gson.r f8732x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final com.google.gson.q<String> f8733y = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final com.google.gson.q<BigDecimal> f8734z = null;

    class a extends com.google.gson.q<AtomicIntegerArray> {
        a() {
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ AtomicIntegerArray b(i6.a r10) {
            return e(r10);
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ void d(com.google.gson.stream.a r10, AtomicIntegerArray r11) {
            f(r10, r11);
        }

        public AtomicIntegerArray e(i6.a r10) {
            ArrayList r11 = new ArrayList();
            r10.a();
        L4:
            if (r10.u() == false) goto L10;
            r11.add(Integer.valueOf(r10.F()));     // Catch: NumberFormatException -> L7
        L7:
            e = move-exception;
            throw new JsonSyntaxException(e);
        L10:
            r10.l();
            int r12 = r11.size();
            AtomicIntegerArray r13 = new AtomicIntegerArray(r12);
            int r14 = 0;
        L11:
            if (r14 >= r12) goto L13;
            r13.set(r14, ((Integer) r11.get(r14)).intValue());
            r14 = r14 + 1;
            goto L11
        L13:
            return r13;
        }

        public void f(com.google.gson.stream.a r10, AtomicIntegerArray r11) {
            r10.f();
            int r12 = r11.length();
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L5;
            r10.Q(r11.get(r13));
            r13 = r13 + 1;
            goto L3
        L5:
            r10.l();
        }
    }

    static /* synthetic */ class a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f8735a = null;

        static {
            int[] r10 = new int[JsonToken.values().length];
            f8735a = r10;
            r10[JsonToken.NUMBER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            f8735a[JsonToken.STRING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            f8735a[JsonToken.BOOLEAN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            f8735a[JsonToken.BEGIN_ARRAY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            f8735a[JsonToken.BEGIN_OBJECT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            f8735a[JsonToken.NULL.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    class b extends com.google.gson.q<Number> {
        b() {
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ Number b(i6.a r10) {
            return e(r10);
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ void d(com.google.gson.stream.a r10, Number r11) {
            f(r10, r11);
        }

        public Number e(i6.a r10) {
            if (r10.Q() != JsonToken.NULL) goto L11;
            r10.K();
            return null;
        L11:
            return Long.valueOf(r10.G());
        L8:
            e = move-exception;
            throw new JsonSyntaxException(e);
        }

        public void f(com.google.gson.stream.a r10, Number r11) {
            if (r11 != null) goto L4;
            r10.B();
            return;
        L4:
            r10.Q(r11.longValue());
        }
    }

    class b0 extends com.google.gson.q<Boolean> {
        b0() {
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ Boolean b(i6.a r10) {
            return e(r10);
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ void d(com.google.gson.stream.a r10, Boolean r11) {
            f(r10, r11);
        }

        public Boolean e(i6.a r10) {
            JsonToken r11 = r10.Q();
            if (r11 != JsonToken.NULL) goto L7;
            r10.K();
            return null;
        L7:
            if (r11 != JsonToken.STRING) goto L11;
            return Boolean.valueOf(Boolean.parseBoolean(r10.N()));
        L11:
            return Boolean.valueOf(r10.C());
        }

        public void f(com.google.gson.stream.a r10, Boolean r11) {
            r10.V(r11);
        }
    }

    class c extends com.google.gson.q<Number> {
        c() {
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ Number b(i6.a r10) {
            return e(r10);
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ void d(com.google.gson.stream.a r10, Number r11) {
            f(r10, r11);
        }

        public Number e(i6.a r10) {
            if (r10.Q() != JsonToken.NULL) goto L7;
            r10.K();
            return null;
        L7:
            return Float.valueOf((float) r10.D());
        }

        public void f(com.google.gson.stream.a r10, Number r11) {
            if (r11 != null) goto L5;
            r10.B();
            return;
        L5:
            if ((r11 instanceof Float) == true) goto L8;
            r11 = Float.valueOf(r11.floatValue());
        L8:
            r10.X(r11);
        }
    }

    class c0 extends com.google.gson.q<Boolean> {
        c0() {
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ Boolean b(i6.a r10) {
            return e(r10);
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ void d(com.google.gson.stream.a r10, Boolean r11) {
            f(r10, r11);
        }

        public Boolean e(i6.a r10) {
            if (r10.Q() != JsonToken.NULL) goto L7;
            r10.K();
            return null;
        L7:
            return Boolean.valueOf(r10.N());
        }

        public void f(com.google.gson.stream.a r10, Boolean r11) {
            if (r11 != null) goto L4;
            String r12 = "null";
        L5:
            r10.a0(r12);
            return;
        L4:
            r12 = r11.toString();
            goto L5
        }
    }

    class d extends com.google.gson.q<Number> {
        d() {
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ Number b(i6.a r10) {
            return e(r10);
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ void d(com.google.gson.stream.a r10, Number r11) {
            f(r10, r11);
        }

        public Number e(i6.a r10) {
            if (r10.Q() != JsonToken.NULL) goto L7;
            r10.K();
            return null;
        L7:
            return Double.valueOf(r10.D());
        }

        public void f(com.google.gson.stream.a r10, Number r11) {
            if (r11 != null) goto L4;
            r10.B();
            return;
        L4:
            r10.P(r11.doubleValue());
        }
    }

    class d0 extends com.google.gson.q<Number> {
        d0() {
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ Number b(i6.a r10) {
            return e(r10);
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ void d(com.google.gson.stream.a r10, Number r11) {
            f(r10, r11);
        }

        public Number e(i6.a r10) {
            if (r10.Q() != JsonToken.NULL) goto L18;
            r10.K();
            return null;
        L18:
            int r11 = r10.F();     // Catch: NumberFormatException -> L15
            if (r11 > 255) goto L14;
            if (r11 < (-128)) goto L14;
            return Byte.valueOf((byte) r11);
        L14:
            throw new JsonSyntaxException("Lossy conversion from " + r11 + " to byte; at path " + r10.s());
        L15:
            e = move-exception;
            throw new JsonSyntaxException(e);
        }

        public void f(com.google.gson.stream.a r10, Number r11) {
            if (r11 != null) goto L4;
            r10.B();
            return;
        L4:
            r10.Q(r11.byteValue());
        }
    }

    class e extends com.google.gson.q<Character> {
        e() {
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ Character b(i6.a r10) {
            return e(r10);
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ void d(com.google.gson.stream.a r10, Character r11) {
            f(r10, r11);
        }

        public Character e(i6.a r10) {
            if (r10.Q() != JsonToken.NULL) goto L6;
            r10.K();
            return null;
        L6:
            String r11 = r10.N();
            if (r11.length() != 1) goto L11;
            return Character.valueOf(r11.charAt(0));
        L11:
            throw new JsonSyntaxException("Expecting character, got: " + r11 + "; at " + r10.s());
        }

        public void f(com.google.gson.stream.a r10, Character r11) {
            if (r11 != null) goto L4;
            String r12 = null;
        L5:
            r10.a0(r12);
            return;
        L4:
            r12 = String.valueOf(r11);
            goto L5
        }
    }

    class e0 extends com.google.gson.q<Number> {
        e0() {
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ Number b(i6.a r10) {
            return e(r10);
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ void d(com.google.gson.stream.a r10, Number r11) {
            f(r10, r11);
        }

        public Number e(i6.a r10) {
            if (r10.Q() != JsonToken.NULL) goto L18;
            r10.K();
            return null;
        L18:
            int r11 = r10.F();     // Catch: NumberFormatException -> L15
            if (r11 > 65535) goto L14;
            if (r11 < (-32768)) goto L14;
            return Short.valueOf((short) r11);
        L14:
            throw new JsonSyntaxException("Lossy conversion from " + r11 + " to short; at path " + r10.s());
        L15:
            e = move-exception;
            throw new JsonSyntaxException(e);
        }

        public void f(com.google.gson.stream.a r10, Number r11) {
            if (r11 != null) goto L4;
            r10.B();
            return;
        L4:
            r10.Q(r11.shortValue());
        }
    }

    class f extends com.google.gson.q<String> {
        f() {
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ String b(i6.a r10) {
            return e(r10);
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ void d(com.google.gson.stream.a r10, String r11) {
            f(r10, r11);
        }

        public String e(i6.a r10) {
            JsonToken r11 = r10.Q();
            if (r11 != JsonToken.NULL) goto L7;
            r10.K();
            return null;
        L7:
            if (r11 != JsonToken.BOOLEAN) goto L11;
            return Boolean.toString(r10.C());
        L11:
            return r10.N();
        }

        public void f(com.google.gson.stream.a r10, String r11) {
            r10.a0(r11);
        }
    }

    class f0 extends com.google.gson.q<Number> {
        f0() {
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ Number b(i6.a r10) {
            return e(r10);
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ void d(com.google.gson.stream.a r10, Number r11) {
            f(r10, r11);
        }

        public Number e(i6.a r10) {
            if (r10.Q() != JsonToken.NULL) goto L11;
            r10.K();
            return null;
        L11:
            return Integer.valueOf(r10.F());
        L8:
            e = move-exception;
            throw new JsonSyntaxException(e);
        }

        public void f(com.google.gson.stream.a r10, Number r11) {
            if (r11 != null) goto L4;
            r10.B();
            return;
        L4:
            r10.Q(r11.intValue());
        }
    }

    class g extends com.google.gson.q<BigDecimal> {
        g() {
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ BigDecimal b(i6.a r10) {
            return e(r10);
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ void d(com.google.gson.stream.a r10, BigDecimal r11) {
            f(r10, r11);
        }

        public BigDecimal e(i6.a r10) {
            if (r10.Q() != JsonToken.NULL) goto L6;
            r10.K();
            return null;
        L6:
            String r11 = r10.N();
            return new BigDecimal(r11);
        L9:
            e = move-exception;
            throw new JsonSyntaxException("Failed parsing '" + r11 + "' as BigDecimal; at path " + r10.s(), e);
        }

        public void f(com.google.gson.stream.a r10, BigDecimal r11) {
            r10.X(r11);
        }
    }

    class g0 extends com.google.gson.q<AtomicInteger> {
        g0() {
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ AtomicInteger b(i6.a r10) {
            return e(r10);
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ void d(com.google.gson.stream.a r10, AtomicInteger r11) {
            f(r10, r11);
        }

        public AtomicInteger e(i6.a r10) {
            return new AtomicInteger(r10.F());
        L4:
            e = move-exception;
            throw new JsonSyntaxException(e);
        }

        public void f(com.google.gson.stream.a r10, AtomicInteger r11) {
            r10.Q(r11.get());
        }
    }

    class h extends com.google.gson.q<BigInteger> {
        h() {
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ BigInteger b(i6.a r10) {
            return e(r10);
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ void d(com.google.gson.stream.a r10, BigInteger r11) {
            f(r10, r11);
        }

        public BigInteger e(i6.a r10) {
            if (r10.Q() != JsonToken.NULL) goto L6;
            r10.K();
            return null;
        L6:
            String r11 = r10.N();
            return new BigInteger(r11);
        L9:
            e = move-exception;
            throw new JsonSyntaxException("Failed parsing '" + r11 + "' as BigInteger; at path " + r10.s(), e);
        }

        public void f(com.google.gson.stream.a r10, BigInteger r11) {
            r10.X(r11);
        }
    }

    class h0 extends com.google.gson.q<AtomicBoolean> {
        h0() {
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ AtomicBoolean b(i6.a r10) {
            return e(r10);
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ void d(com.google.gson.stream.a r10, AtomicBoolean r11) {
            f(r10, r11);
        }

        public AtomicBoolean e(i6.a r10) {
            return new AtomicBoolean(r10.C());
        }

        public void f(com.google.gson.stream.a r10, AtomicBoolean r11) {
            r10.c0(r11.get());
        }
    }

    class i extends com.google.gson.q<LazilyParsedNumber> {
        i() {
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ LazilyParsedNumber b(i6.a r10) {
            return e(r10);
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ void d(com.google.gson.stream.a r10, LazilyParsedNumber r11) {
            f(r10, r11);
        }

        public LazilyParsedNumber e(i6.a r10) {
            if (r10.Q() != JsonToken.NULL) goto L7;
            r10.K();
            return null;
        L7:
            return new LazilyParsedNumber(r10.N());
        }

        public void f(com.google.gson.stream.a r10, LazilyParsedNumber r11) {
            r10.X(r11);
        }
    }

    private static final class i0<T extends Enum<T>> extends com.google.gson.q<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map<String, T> f8736a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map<String, T> f8737b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Map<T, String> f8738c;

        class a implements PrivilegedAction<Field[]> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Class f8739a;

            a(i0 r10, Class r11) {
                this.f8739a = r11;
            }

            public Field[] a() {
                Field[] r10 = this.f8739a.getDeclaredFields();
                ArrayList r11 = new ArrayList(r10.length);
                int r12 = r10.length;
                int r13 = 0;
            L3:
                if (r13 >= r12) goto L8;
                Field r14 = r10[r13];
                if (r14.isEnumConstant() == false) goto L7;
                r11.add(r14);
            L7:
                r13 = r13 + 1;
                goto L3
            L8:
                Field[] r15 = (Field[]) r11.toArray(new Field[0]);
                AccessibleObject.setAccessible(r15, true);
                return r15;
            }

            @Override // java.security.PrivilegedAction
            public /* bridge */ /* synthetic */ Field[] run() {
                return a();
            }
        }

        public i0(Class<T> r12) {
            this.f8736a = new HashMap();
            this.f8737b = new HashMap();
            this.f8738c = new HashMap();
            Field[] r13 = (Field[]) AccessController.doPrivileged(new a(this, r12));     // Catch: IllegalAccessException -> L13
            int r10 = r13.length;     // Catch: IllegalAccessException -> L13
            int r11 = 0;
        L4:
            if (r11 >= r10) goto L12;
            Field r14 = r13[r11];     // Catch: IllegalAccessException -> L13
            Enum r15 = (Enum) r14.get(null);     // Catch: IllegalAccessException -> L13
            String r16 = r15.name();     // Catch: IllegalAccessException -> L13
            String r17 = r15.toString();     // Catch: IllegalAccessException -> L13
            d6.c r18 = (d6.c) r14.getAnnotation(d6.c.class);     // Catch: IllegalAccessException -> L13
            if (r18 == null) goto L10;
            r16 = r18.value();     // Catch: IllegalAccessException -> L13
            String[] r19 = r18.alternate();     // Catch: IllegalAccessException -> L13
            int r20 = r19.length;     // Catch: IllegalAccessException -> L13
            int r21 = 0;
        L8:
            if (r21 >= r20) goto L10;
            this.f8736a.put(r19[r21], (T) r15);     // Catch: IllegalAccessException -> L13
            r21 = r21 + 1;     // Catch: IllegalAccessException -> L13
        L10:
            this.f8736a.put(r16, (T) r15);     // Catch: IllegalAccessException -> L13
            this.f8737b.put(r17, (T) r15);     // Catch: IllegalAccessException -> L13
            this.f8738c.put((T) r15, r16);     // Catch: IllegalAccessException -> L13
            r11 = r11 + 1;
            goto L4
        L12:
            return;
        L13:
            e = move-exception;
            throw new AssertionError(e);
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ Object b(i6.a r10) {
            return e(r10);
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ void d(com.google.gson.stream.a r10, Object r11) {
            f(r10, (Enum) r11);
        }

        public T e(i6.a r10) {
            if (r10.Q() != JsonToken.NULL) goto L6;
            r10.K();
            return null;
        L6:
            String r11 = r10.N();
            T r12 = this.f8736a.get(r11);
            if (r12 == null) goto L9;
            return r12;
        L9:
            return this.f8737b.get(r11);
        }

        public void f(com.google.gson.stream.a r10, T r11) {
            if (r11 != null) goto L4;
            String r12 = null;
        L5:
            r10.a0(r12);
            return;
        L4:
            r12 = this.f8738c.get(r11);
            goto L5
        }
    }

    class j extends com.google.gson.q<StringBuilder> {
        j() {
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ StringBuilder b(i6.a r10) {
            return e(r10);
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ void d(com.google.gson.stream.a r10, StringBuilder r11) {
            f(r10, r11);
        }

        public StringBuilder e(i6.a r10) {
            if (r10.Q() != JsonToken.NULL) goto L7;
            r10.K();
            return null;
        L7:
            return new StringBuilder(r10.N());
        }

        public void f(com.google.gson.stream.a r10, StringBuilder r11) {
            if (r11 != null) goto L4;
            String r12 = null;
        L5:
            r10.a0(r12);
            return;
        L4:
            r12 = r11.toString();
            goto L5
        }
    }

    class k extends com.google.gson.q<Class> {
        k() {
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ Class b(i6.a r10) {
            return e(r10);
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ void d(com.google.gson.stream.a r10, Class r11) {
            f(r10, r11);
        }

        public Class e(i6.a r10) {
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }

        public void f(com.google.gson.stream.a r10, Class r11) {
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + r11.getName() + ". Forgot to register a type adapter?");
        }
    }

    class l extends com.google.gson.q<StringBuffer> {
        l() {
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ StringBuffer b(i6.a r10) {
            return e(r10);
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ void d(com.google.gson.stream.a r10, StringBuffer r11) {
            f(r10, r11);
        }

        public StringBuffer e(i6.a r10) {
            if (r10.Q() != JsonToken.NULL) goto L7;
            r10.K();
            return null;
        L7:
            return new StringBuffer(r10.N());
        }

        public void f(com.google.gson.stream.a r10, StringBuffer r11) {
            if (r11 != null) goto L4;
            String r12 = null;
        L5:
            r10.a0(r12);
            return;
        L4:
            r12 = r11.toString();
            goto L5
        }
    }

    class m extends com.google.gson.q<URL> {
        m() {
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ URL b(i6.a r10) {
            return e(r10);
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ void d(com.google.gson.stream.a r10, URL r11) {
            f(r10, r11);
        }

        public URL e(i6.a r10) {
            if (r10.Q() != JsonToken.NULL) goto L6;
            r10.K();
            return null;
        L6:
            String r11 = r10.N();
            if ("null".equals(r11) == false) goto L10;
            return null;
        L10:
            return new URL(r11);
        }

        public void f(com.google.gson.stream.a r10, URL r11) {
            if (r11 != null) goto L4;
            String r12 = null;
        L5:
            r10.a0(r12);
            return;
        L4:
            r12 = r11.toExternalForm();
            goto L5
        }
    }

    class n extends com.google.gson.q<URI> {
        n() {
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ URI b(i6.a r10) {
            return e(r10);
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ void d(com.google.gson.stream.a r10, URI r11) {
            f(r10, r11);
        }

        public URI e(i6.a r10) {
            if (r10.Q() != JsonToken.NULL) goto L14;
            r10.K();
            return null;
        L14:
            String r11 = r10.N();     // Catch: URISyntaxException -> L11
            if ("null".equals(r11) == true) goto L16;
            return new URI(r11);
        L16:
            return null;
        L11:
            e = move-exception;
            throw new JsonIOException(e);
        }

        public void f(com.google.gson.stream.a r10, URI r11) {
            if (r11 != null) goto L4;
            String r12 = null;
        L5:
            r10.a0(r12);
            return;
        L4:
            r12 = r11.toASCIIString();
            goto L5
        }
    }

    /* JADX INFO: renamed from: e6.o$o, reason: collision with other inner class name */
    class C0163o extends com.google.gson.q<InetAddress> {
        C0163o() {
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ InetAddress b(i6.a r10) {
            return e(r10);
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ void d(com.google.gson.stream.a r10, InetAddress r11) {
            f(r10, r11);
        }

        public InetAddress e(i6.a r10) {
            if (r10.Q() != JsonToken.NULL) goto L7;
            r10.K();
            return null;
        L7:
            return InetAddress.getByName(r10.N());
        }

        public void f(com.google.gson.stream.a r10, InetAddress r11) {
            if (r11 != null) goto L4;
            String r12 = null;
        L5:
            r10.a0(r12);
            return;
        L4:
            r12 = r11.getHostAddress();
            goto L5
        }
    }

    class p extends com.google.gson.q<UUID> {
        p() {
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ UUID b(i6.a r10) {
            return e(r10);
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ void d(com.google.gson.stream.a r10, UUID r11) {
            f(r10, r11);
        }

        public UUID e(i6.a r10) {
            if (r10.Q() != JsonToken.NULL) goto L6;
            r10.K();
            return null;
        L6:
            String r11 = r10.N();
            return UUID.fromString(r11);
        L9:
            e = move-exception;
            throw new JsonSyntaxException("Failed parsing '" + r11 + "' as UUID; at path " + r10.s(), e);
        }

        public void f(com.google.gson.stream.a r10, UUID r11) {
            if (r11 != null) goto L4;
            String r12 = null;
        L5:
            r10.a0(r12);
            return;
        L4:
            r12 = r11.toString();
            goto L5
        }
    }

    class q extends com.google.gson.q<Currency> {
        q() {
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ Currency b(i6.a r10) {
            return e(r10);
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ void d(com.google.gson.stream.a r10, Currency r11) {
            f(r10, r11);
        }

        public Currency e(i6.a r10) {
            String r11 = r10.N();
            return Currency.getInstance(r11);
        L5:
            e = move-exception;
            throw new JsonSyntaxException("Failed parsing '" + r11 + "' as Currency; at path " + r10.s(), e);
        }

        public void f(com.google.gson.stream.a r10, Currency r11) {
            r10.a0(r11.getCurrencyCode());
        }
    }

    class r extends com.google.gson.q<Calendar> {
        r() {
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ Calendar b(i6.a r10) {
            return e(r10);
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ void d(com.google.gson.stream.a r10, Calendar r11) {
            f(r10, r11);
        }

        public Calendar e(i6.a r10) {
            if (r10.Q() != JsonToken.NULL) goto L6;
            r10.K();
            return null;
        L6:
            r10.c();
            int r11 = 0;
            int r12 = 0;
            int r13 = 0;
            int r14 = 0;
            int r15 = 0;
            int r16 = 0;
        L8:
            if (r10.Q() == JsonToken.END_OBJECT) goto L27;
            String r17 = r10.I();
            int r18 = r10.F();
            if ("year".equals(r17) == true) goto L11;
            if ("month".equals(r17) == true) goto L14;
            if ("dayOfMonth".equals(r17) == true) goto L17;
            if ("hourOfDay".equals(r17) == true) goto L20;
            if ("minute".equals(r17) == true) goto L23;
            if ("second".equals(r17) == false) goto L8;
            r16 = r18;
            goto L8
        L23:
            r15 = r18;
            goto L8
        L20:
            r14 = r18;
            goto L8
        L17:
            r13 = r18;
            goto L8
        L14:
            r12 = r18;
            goto L8
        L11:
            r11 = r18;
            goto L8
        L27:
            r10.o();
            return new GregorianCalendar(r11, r12, r13, r14, r15, r16);
        }

        public void f(com.google.gson.stream.a r10, Calendar r11) {
            if (r11 != null) goto L5;
            r10.B();
            return;
        L5:
            r10.i();
            r10.v("year");
            r10.Q(r11.get(1));
            r10.v("month");
            r10.Q(r11.get(2));
            r10.v("dayOfMonth");
            r10.Q(r11.get(5));
            r10.v("hourOfDay");
            r10.Q(r11.get(11));
            r10.v("minute");
            r10.Q(r11.get(12));
            r10.v("second");
            r10.Q(r11.get(13));
            r10.o();
        }
    }

    class s extends com.google.gson.q<Locale> {
        s() {
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ Locale b(i6.a r10) {
            return e(r10);
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ void d(com.google.gson.stream.a r10, Locale r11) {
            f(r10, r11);
        }

        public Locale e(i6.a r10) {
            String r11 = null;
            if (r10.Q() != JsonToken.NULL) goto L6;
            r10.K();
            return null;
        L6:
            StringTokenizer r12 = new StringTokenizer(r10.N(), "_");
            if (r12.hasMoreElements() == false) goto L9;
            String r13 = r12.nextToken();
        L11:
            if (r12.hasMoreElements() == false) goto L13;
            String r14 = r12.nextToken();
        L15:
            if (r12.hasMoreElements() == false) goto L17;
            r11 = r12.nextToken();
        L17:
            if (r14 != null) goto L22;
            if (r11 != null) goto L22;
            return new Locale(r13);
        L22:
            if (r11 != null) goto L26;
            return new Locale(r13, r14);
        L26:
            return new Locale(r13, r14, r11);
        L13:
            r14 = null;
            goto L15
        L9:
            r13 = null;
            goto L11
        }

        public void f(com.google.gson.stream.a r10, Locale r11) {
            if (r11 != null) goto L4;
            String r12 = null;
        L5:
            r10.a0(r12);
            return;
        L4:
            r12 = r11.toString();
            goto L5
        }
    }

    class t extends com.google.gson.q<com.google.gson.i> {
        t() {
        }

        private com.google.gson.i f(i6.a r10, JsonToken r11) {
            int r12 = a0.f8735a[r11.ordinal()];
            if (r12 == 1) goto L19;
            if (r12 == 2) goto L17;
            if (r12 == 3) goto L15;
            if (r12 != 6) goto L13;
            r10.K();
            return com.google.gson.j.f4273a;
        L13:
            throw new IllegalStateException("Unexpected token: " + r11);
        L15:
            return new com.google.gson.m(Boolean.valueOf(r10.C()));
        L17:
            return new com.google.gson.m(r10.N());
        L19:
            return new com.google.gson.m(new LazilyParsedNumber(r10.N()));
        }

        private com.google.gson.i g(i6.a r10, JsonToken r11) {
            int r12 = a0.f8735a[r11.ordinal()];
            if (r12 != 4) goto L5;
            r10.a();
            return new com.google.gson.f();
        L5:
            if (r12 == 5) goto L8;
            return null;
        L8:
            r10.c();
            return new com.google.gson.k();
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ com.google.gson.i b(i6.a r10) {
            return e(r10);
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ void d(com.google.gson.stream.a r10, com.google.gson.i r11) {
            h(r10, r11);
        }

        public com.google.gson.i e(i6.a r10) {
            if ((r10 instanceof e6.f) == true) goto L5;
            JsonToken r11 = r10.Q();
            com.google.gson.i r12 = g(r10, r11);
            if (r12 == null) goto L9;
            ArrayDeque r13 = new ArrayDeque();
        L12:
            if (r10.u() == true) goto L13;
            if ((r12 instanceof com.google.gson.f) == false) goto L31;
            r10.l();
        L33:
            if (r13.isEmpty() == true) goto L34;
            r12 = (com.google.gson.i) r13.removeLast();
            goto L12
        L34:
            return r12;
        L31:
            r10.o();
            goto L33
        L13:
            String r14 = null;
            if ((r12 instanceof com.google.gson.k) == false) goto L16;
            r14 = r10.I();
        L16:
            JsonToken r15 = r10.Q();
            com.google.gson.i r16 = g(r10, r15);
            if (r16 == null) goto L19;
            boolean r17 = true;
        L20:
            if (r16 != null) goto L23;
            r16 = f(r10, r15);
        L23:
            if ((r12 instanceof com.google.gson.f) == false) goto L25;
            ((com.google.gson.f) r12).m(r16);
        L26:
            if (r17 == false) goto L12;
            r13.addLast(r12);
            r12 = r16;
            goto L12
        L25:
            ((com.google.gson.k) r12).m(r14, r16);
            goto L26
        L19:
            r17 = false;
            goto L20
        L9:
            return f(r10, r11);
        L5:
            return ((e6.f) r10).l0();
        }

        public void h(com.google.gson.stream.a r10, com.google.gson.i r11) {
            if (r11 != null) goto L4;
        L31:
            r10.B();
            return;
        L4:
            if (r11.j() == true) goto L31;
            if (r11.l() == false) goto L16;
            com.google.gson.m r12 = r11.f();
            if (r12.p() == false) goto L12;
            r10.X(r12.m());
            return;
        L12:
            if (r12.n() == false) goto L14;
            r10.c0(r12.a());
            return;
        L14:
            r10.a0(r12.h());
            return;
        L16:
            if (r11.i() == false) goto L23;
            r10.f();
            Iterator<com.google.gson.i> r13 = r11.d().iterator();
        L19:
            if (r13.hasNext() == false) goto L21;
            h(r10, r13.next());
            goto L19
        L21:
            r10.l();
            return;
        L23:
            if (r11.k() == false) goto L30;
            r10.i();
            Iterator<Map.Entry<String, com.google.gson.i>> r14 = r11.e().r().iterator();
        L26:
            if (r14.hasNext() == false) goto L28;
            Map.Entry<String, com.google.gson.i> r15 = r14.next();
            r10.v(r15.getKey());
            h(r10, r15.getValue());
            goto L26
        L28:
            r10.o();
            return;
        L30:
            throw new IllegalArgumentException("Couldn't write " + r11.getClass());
        }
    }

    class u implements com.google.gson.r {
        u() {
        }

        @Override // com.google.gson.r
        public <T> com.google.gson.q<T> b(com.google.gson.d r10, TypeToken<T> r11) {
            Class<? super T> r12 = r11.getRawType();
            if (Enum.class.isAssignableFrom(r12) == false) goto L11;
            if (r12 != Enum.class) goto L7;
            return null;
        L7:
            if (r12.isEnum() == true) goto L10;
            r12 = r12.getSuperclass();
        L10:
            return new i0(r12);
        L11:
            return null;
        }
    }

    class v extends com.google.gson.q<BitSet> {
        v() {
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ BitSet b(i6.a r10) {
            return e(r10);
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ void d(com.google.gson.stream.a r10, BitSet r11) {
            f(r10, r11);
        }

        public BitSet e(i6.a r10) {
            BitSet r11 = new BitSet();
            r10.a();
            JsonToken r12 = r10.Q();
            int r13 = 0;
        L4:
            if (r12 == JsonToken.END_ARRAY) goto L23;
            int r14 = a0.f8735a[r12.ordinal()];
            boolean r15 = true;
            if (r14 != 1) goto L8;
        L14:
            int r16 = r10.F();
            if (r16 != 0) goto L17;
            r15 = false;
        L18:
            if (r15 == false) goto L20;
            r11.set(r13);
        L20:
            r13 = r13 + 1;
            r12 = r10.Q();
            goto L4
        L17:
            if (r16 == 1) goto L18;
            throw new JsonSyntaxException("Invalid bitset value " + r16 + ", expected 0 or 1; at path " + r10.s());
        L8:
            if (r14 == 2) goto L14;
            if (r14 != 3) goto L13;
            r15 = r10.C();
            goto L18
        L13:
            throw new JsonSyntaxException("Invalid bitset value type: " + r12 + "; at path " + r10.getPath());
        L23:
            r10.l();
            return r11;
        }

        public void f(com.google.gson.stream.a r10, BitSet r11) {
            r10.f();
            int r12 = r11.length();
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L5;
            r10.Q(r11.get(r13) ? 1 : 0);
            r13 = r13 + 1;
            goto L3
        L5:
            r10.l();
        }
    }

    class w implements com.google.gson.r {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Class f8740c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.google.gson.q f8741g;

        w(Class r10, com.google.gson.q r11) {
            this.f8740c = r10;
            this.f8741g = r11;
        }

        @Override // com.google.gson.r
        public <T> com.google.gson.q<T> b(com.google.gson.d r10, TypeToken<T> r11) {
            if (r11.getRawType() == this.f8740c) goto L7;
            return null;
        L7:
            return this.f8741g;
        }

        public String toString() {
            return "Factory[type=" + this.f8740c.getName() + ",adapter=" + this.f8741g + "]";
        }
    }

    class x implements com.google.gson.r {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Class f8742c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Class f8743g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ com.google.gson.q f8744h;

        x(Class r10, Class r11, com.google.gson.q r12) {
            this.f8742c = r10;
            this.f8743g = r11;
            this.f8744h = r12;
        }

        @Override // com.google.gson.r
        public <T> com.google.gson.q<T> b(com.google.gson.d r10, TypeToken<T> r11) {
            Class<? super T> r12 = r11.getRawType();
            if (r12 == this.f8742c) goto L9;
            if (r12 == this.f8743g) goto L9;
            return null;
        L9:
            return this.f8744h;
        }

        public String toString() {
            return "Factory[type=" + this.f8743g.getName() + "+" + this.f8742c.getName() + ",adapter=" + this.f8744h + "]";
        }
    }

    class y implements com.google.gson.r {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Class f8745c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Class f8746g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ com.google.gson.q f8747h;

        y(Class r10, Class r11, com.google.gson.q r12) {
            this.f8745c = r10;
            this.f8746g = r11;
            this.f8747h = r12;
        }

        @Override // com.google.gson.r
        public <T> com.google.gson.q<T> b(com.google.gson.d r10, TypeToken<T> r11) {
            Class<? super T> r12 = r11.getRawType();
            if (r12 == this.f8745c) goto L9;
            if (r12 == this.f8746g) goto L9;
            return null;
        L9:
            return this.f8747h;
        }

        public String toString() {
            return "Factory[type=" + this.f8745c.getName() + "+" + this.f8746g.getName() + ",adapter=" + this.f8747h + "]";
        }
    }

    class z implements com.google.gson.r {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Class f8748c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.google.gson.q f8749g;

        /* JADX INFO: Add missing generic type declarations: [T1] */
        class a<T1> extends com.google.gson.q<T1> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Class f8750a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ z f8751b;

            a(z r10, Class r11) {
                this.f8751b = r10;
                this.f8750a = r11;
            }

            @Override // com.google.gson.q
            public T1 b(i6.a r10) {
                T1 r11 = (T1) this.f8751b.f8749g.b(r10);
                if (r11 != null) goto L5;
            L9:
                return r11;
            L5:
                if (this.f8750a.isInstance(r11) == true) goto L9;
                throw new JsonSyntaxException("Expected a " + this.f8750a.getName() + " but was " + r11.getClass().getName() + "; at path " + r10.s());
            }

            @Override // com.google.gson.q
            public void d(com.google.gson.stream.a r10, T1 r11) {
                this.f8751b.f8749g.d(r10, r11);
            }
        }

        z(Class r10, com.google.gson.q r11) {
            this.f8748c = r10;
            this.f8749g = r11;
        }

        @Override // com.google.gson.r
        public <T2> com.google.gson.q<T2> b(com.google.gson.d r10, TypeToken<T2> r11) {
            Class<? super T2> r12 = r11.getRawType();
            if (this.f8748c.isAssignableFrom(r12) == true) goto L7;
            return null;
        L7:
            return new a(this, r12);
        }

        public String toString() {
            return "Factory[typeHierarchy=" + this.f8748c.getName() + ",adapter=" + this.f8749g + "]";
        }
    }

    static {
        com.google.gson.q<Class> r10 = new k().a();
        f8709a = r10;
        f8710b = a(Class.class, r10);
        com.google.gson.q<BitSet> r11 = new v().a();
        f8711c = r11;
        f8712d = a(BitSet.class, r11);
        b0 r12 = new b0();
        f8713e = r12;
        f8714f = new c0();
        f8715g = b(Boolean.TYPE, Boolean.class, r12);
        d0 r13 = new d0();
        f8716h = r13;
        f8717i = b(Byte.TYPE, Byte.class, r13);
        e0 r14 = new e0();
        f8718j = r14;
        f8719k = b(Short.TYPE, Short.class, r14);
        f0 r15 = new f0();
        f8720l = r15;
        f8721m = b(Integer.TYPE, Integer.class, r15);
        com.google.gson.q<AtomicInteger> r16 = new g0().a();
        f8722n = r16;
        f8723o = a(AtomicInteger.class, r16);
        com.google.gson.q<AtomicBoolean> r17 = new h0().a();
        f8724p = r17;
        f8725q = a(AtomicBoolean.class, r17);
        com.google.gson.q<AtomicIntegerArray> r18 = new a().a();
        f8726r = r18;
        f8727s = a(AtomicIntegerArray.class, r18);
        f8728t = new b();
        f8729u = new c();
        f8730v = new d();
        e r19 = new e();
        f8731w = r19;
        f8732x = b(Character.TYPE, Character.class, r19);
        f r20 = new f();
        f8733y = r20;
        f8734z = new g();
        A = new h();
        B = new i();
        C = a(String.class, r20);
        j r21 = new j();
        D = r21;
        E = a(StringBuilder.class, r21);
        l r22 = new l();
        F = r22;
        G = a(StringBuffer.class, r22);
        m r23 = new m();
        H = r23;
        I = a(URL.class, r23);
        n r24 = new n();
        f8708J = r24;
        K = a(URI.class, r24);
        C0163o r25 = new C0163o();
        L = r25;
        M = d(InetAddress.class, r25);
        p r26 = new p();
        N = r26;
        O = a(UUID.class, r26);
        com.google.gson.q<Currency> r27 = new q().a();
        P = r27;
        Q = a(Currency.class, r27);
        r r28 = new r();
        R = r28;
        S = c(Calendar.class, GregorianCalendar.class, r28);
        s r29 = new s();
        T = r29;
        U = a(Locale.class, r29);
        t r30 = new t();
        V = r30;
        W = d(com.google.gson.i.class, r30);
        X = new u();
    }

    public static <TT> com.google.gson.r a(Class<TT> r10, com.google.gson.q<TT> r11) {
        return new w(r10, r11);
    }

    public static <TT> com.google.gson.r b(Class<TT> r10, Class<TT> r11, com.google.gson.q<? super TT> r12) {
        return new x(r10, r11, r12);
    }

    public static <TT> com.google.gson.r c(Class<TT> r10, Class<? extends TT> r11, com.google.gson.q<? super TT> r12) {
        return new y(r10, r11, r12);
    }

    public static <T1> com.google.gson.r d(Class<T1> r10, com.google.gson.q<T1> r11) {
        return new z(r10, r11);
    }
}
