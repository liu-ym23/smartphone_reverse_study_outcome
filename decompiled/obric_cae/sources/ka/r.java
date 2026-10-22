package ka;

import java.io.Serializable;
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
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* JADX INFO: loaded from: classes.dex */
public final class r {
    public static final ka.v A = null;
    public static final u B = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ka.s f9054a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ka.s f9055b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final x f9056c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ka.t f9057d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ka.t f9058e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ka.t f9059f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ka.t f9060g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ka.s f9061h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ka.s f9062i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ka.s f9063j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final b f9064k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ka.t f9065l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final g f9066m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final h f9067n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final i f9068o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final ka.s f9069p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final ka.s f9070q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final ka.s f9071r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final ka.s f9072s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final ka.s f9073t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final ka.v f9074u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final ka.s f9075v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final ka.s f9076w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final ka.u f9077x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final ka.s f9078y = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final t f9079z = null;

    public class a extends ha.c0<AtomicIntegerArray> {
        @Override // ha.c0
        public final AtomicIntegerArray a(pa.a r8) {
            ArrayList r10 = new ArrayList();
            r8.a();
        L4:
            if (r8.B() == false) goto L10;
            r10.add(Integer.valueOf(r8.H()));     // Catch: NumberFormatException -> L7
        L7:
            e = move-exception;
            throw new ha.q(e);
        L10:
            r8.r();
            int r11 = r10.size();
            AtomicIntegerArray r12 = new AtomicIntegerArray(r11);
            int r13 = 0;
        L11:
            if (r13 >= r11) goto L13;
            r12.set(r13, ((Integer) r10.get(r13)).intValue());
            r13 = r13 + 1;
            goto L11
        L13:
            return r12;
        }

        @Override // ha.c0
        public final void b(pa.c r8, AtomicIntegerArray r10) {
            AtomicIntegerArray r11 = r10;
            r8.i();
            int r12 = r11.length();
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L5;
            r8.D(r11.get(r13));
            r13 = r13 + 1;
            goto L3
        L5:
            r8.r();
        }
    }

    public class a0 extends ha.c0<Number> {
        @Override // ha.c0
        public final Number a(pa.a r8) {
            if (r8.h0() != pa.b.f9974s) goto L10;
            r8.V();
            return null;
        L10:
            return Integer.valueOf(r8.H());
        L7:
            e = move-exception;
            throw new ha.q(e);
        }

        @Override // ha.c0
        public final void b(pa.c r8, Number r10) {
            Number r11 = r10;
            if (r11 != null) goto L5;
            r8.z();
            return;
        L5:
            r8.D(r11.intValue());
        }
    }

    public class b extends ha.c0<Number> {
        @Override // ha.c0
        public final Number a(pa.a r8) {
            if (r8.h0() != pa.b.f9974s) goto L10;
            r8.V();
            return null;
        L10:
            return Long.valueOf(r8.I());
        L7:
            e = move-exception;
            throw new ha.q(e);
        }

        @Override // ha.c0
        public final void b(pa.c r8, Number r10) {
            Number r11 = r10;
            if (r11 != null) goto L5;
            r8.z();
            return;
        L5:
            r8.D(r11.longValue());
        }
    }

    public class b0 extends ha.c0<AtomicInteger> {
        @Override // ha.c0
        public final AtomicInteger a(pa.a r8) {
            return new AtomicInteger(r8.H());
        L4:
            e = move-exception;
            throw new ha.q(e);
        }

        @Override // ha.c0
        public final void b(pa.c r8, AtomicInteger r10) {
            r8.D(r10.get());
        }
    }

    public class c extends ha.c0<Number> {
        @Override // ha.c0
        public final Number a(pa.a r8) {
            if (r8.h0() != pa.b.f9974s) goto L6;
            r8.V();
            return null;
        L6:
            return Float.valueOf((float) r8.G());
        }

        @Override // ha.c0
        public final void b(pa.c r8, Number r10) {
            Number r11 = r10;
            if (r11 != null) goto L6;
            r8.z();
            return;
        L6:
            if ((r11 instanceof Float) == true) goto L9;
            r11 = Float.valueOf(r11.floatValue());
        L9:
            r8.G(r11);
        }
    }

    public class c0 extends ha.c0<AtomicBoolean> {
        @Override // ha.c0
        public final AtomicBoolean a(pa.a r8) {
            return new AtomicBoolean(r8.E());
        }

        @Override // ha.c0
        public final void b(pa.c r8, AtomicBoolean r10) {
            r8.I(r10.get());
        }
    }

    public class d extends ha.c0<Number> {
        @Override // ha.c0
        public final Number a(pa.a r8) {
            if (r8.h0() != pa.b.f9974s) goto L6;
            r8.V();
            return null;
        L6:
            return Double.valueOf(r8.G());
        }

        @Override // ha.c0
        public final void b(pa.c r8, Number r10) {
            Number r11 = r10;
            if (r11 != null) goto L5;
            r8.z();
            return;
        L5:
            r8.C(r11.doubleValue());
        }
    }

    public static final class d0<T extends Enum<T>> extends ha.c0<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final HashMap f9080a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final HashMap f9081b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final HashMap f9082c;

        public class a implements PrivilegedAction<Field[]> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Class f9083a;

            public a(Class r8) {
                this.f9083a = r8;
            }

            @Override // java.security.PrivilegedAction
            public final Field[] run() {
                Field[] r8 = this.f9083a.getDeclaredFields();
                ArrayList r10 = new ArrayList(r8.length);
                int r11 = r8.length;
                int r12 = 0;
            L3:
                if (r12 >= r11) goto L8;
                Field r13 = r8[r12];
                if (r13.isEnumConstant() == false) goto L7;
                r10.add(r13);
            L7:
                r12 = r12 + 1;
                goto L3
            L8:
                Field[] r14 = (Field[]) r10.toArray(new Field[0]);
                AccessibleObject.setAccessible(r14, true);
                return r14;
            }
        }

        public d0(Class<T> r12) {
            this.f9080a = new HashMap();
            this.f9081b = new HashMap();
            this.f9082c = new HashMap();
            Field[] r13 = (Field[]) AccessController.doPrivileged(new a(r12));     // Catch: IllegalAccessException -> L13
            int r8 = r13.length;     // Catch: IllegalAccessException -> L13
            int r10 = 0;
        L4:
            if (r10 >= r8) goto L12;
            Field r11 = r13[r10];     // Catch: IllegalAccessException -> L13
            Enum r14 = (Enum) r11.get(null);     // Catch: IllegalAccessException -> L13
            String r15 = r14.name();     // Catch: IllegalAccessException -> L13
            String r16 = r14.toString();     // Catch: IllegalAccessException -> L13
            ia.b r17 = (ia.b) r11.getAnnotation(ia.b.class);     // Catch: IllegalAccessException -> L13
            if (r17 == null) goto L10;
            r15 = r17.value();     // Catch: IllegalAccessException -> L13
            String[] r18 = r17.alternate();     // Catch: IllegalAccessException -> L13
            int r19 = r18.length;     // Catch: IllegalAccessException -> L13
            int r20 = 0;
        L8:
            if (r20 >= r19) goto L10;
            this.f9080a.put(r18[r20], r14);     // Catch: IllegalAccessException -> L13
            r20 = r20 + 1;     // Catch: IllegalAccessException -> L13
        L10:
            this.f9080a.put(r15, r14);     // Catch: IllegalAccessException -> L13
            this.f9081b.put(r16, r14);     // Catch: IllegalAccessException -> L13
            this.f9082c.put(r14, r15);     // Catch: IllegalAccessException -> L13
            r10 = r10 + 1;
            goto L4
        L12:
            return;
        L13:
            e = move-exception;
            throw new AssertionError(e);
        }

        @Override // ha.c0
        public final Object a(pa.a r8) {
            if (r8.h0() != pa.b.f9974s) goto L5;
            r8.V();
            return null;
        L5:
            String r10 = r8.e0();
            Enum r11 = (Enum) this.f9080a.get(r10);
            if (r11 != null) goto L9;
            return (Enum) this.f9081b.get(r10);
        L9:
            return r11;
        }

        @Override // ha.c0
        public final void b(pa.c r8, Object r10) {
            Enum r11 = (Enum) r10;
            if (r11 != null) goto L5;
            String r12 = null;
        L6:
            r8.H(r12);
            return;
        L5:
            r12 = (String) this.f9082c.get(r11);
            goto L6
        }
    }

    public class e extends ha.c0<Character> {
        @Override // ha.c0
        public final Character a(pa.a r8) {
            if (r8.h0() != pa.b.f9974s) goto L5;
            r8.V();
            return null;
        L5:
            String r10 = r8.e0();
            if (r10.length() == 1) goto L8;
            StringBuilder r11 = defpackage.b.h("Expecting character, got: ", r10, "; at ");
            r11.append(r8.A());
            throw new ha.q(r11.toString());
        L8:
            return Character.valueOf(r10.charAt(0));
        }

        @Override // ha.c0
        public final void b(pa.c r8, Character r10) {
            Character r11 = r10;
            if (r11 != null) goto L5;
            String r12 = null;
        L6:
            r8.H(r12);
            return;
        L5:
            r12 = String.valueOf(r11);
            goto L6
        }
    }

    public class f extends ha.c0<String> {
        @Override // ha.c0
        public final String a(pa.a r8) {
            pa.b r10 = r8.h0();
            if (r10 != pa.b.f9974s) goto L6;
            r8.V();
            return null;
        L6:
            if (r10 != pa.b.f9973r) goto L9;
            return Boolean.toString(r8.E());
        L9:
            return r8.e0();
        }

        @Override // ha.c0
        public final void b(pa.c r8, String r10) {
            r8.H(r10);
        }
    }

    public class g extends ha.c0<BigDecimal> {
        @Override // ha.c0
        public final BigDecimal a(pa.a r8) {
            if (r8.h0() != pa.b.f9974s) goto L5;
            r8.V();
            return null;
        L5:
            String r10 = r8.e0();
            return new BigDecimal(r10);
        L9:
            e = move-exception;
            StringBuilder r11 = defpackage.b.h("Failed parsing '", r10, "' as BigDecimal; at path ");
            r11.append(r8.A());
            throw new ha.q(r11.toString(), e);
        }

        @Override // ha.c0
        public final void b(pa.c r8, BigDecimal r10) {
            r8.G(r10);
        }
    }

    public class h extends ha.c0<BigInteger> {
        @Override // ha.c0
        public final BigInteger a(pa.a r8) {
            if (r8.h0() != pa.b.f9974s) goto L5;
            r8.V();
            return null;
        L5:
            String r10 = r8.e0();
            return new BigInteger(r10);
        L9:
            e = move-exception;
            StringBuilder r11 = defpackage.b.h("Failed parsing '", r10, "' as BigInteger; at path ");
            r11.append(r8.A());
            throw new ha.q(r11.toString(), e);
        }

        @Override // ha.c0
        public final void b(pa.c r8, BigInteger r10) {
            r8.G(r10);
        }
    }

    public class i extends ha.c0<ja.r> {
        @Override // ha.c0
        public final ja.r a(pa.a r8) {
            if (r8.h0() != pa.b.f9974s) goto L6;
            r8.V();
            return null;
        L6:
            return new ja.r(r8.e0());
        }

        @Override // ha.c0
        public final void b(pa.c r8, ja.r r10) {
            r8.G(r10);
        }
    }

    public class j extends ha.c0<StringBuilder> {
        @Override // ha.c0
        public final StringBuilder a(pa.a r8) {
            if (r8.h0() != pa.b.f9974s) goto L6;
            r8.V();
            return null;
        L6:
            return new StringBuilder(r8.e0());
        }

        @Override // ha.c0
        public final void b(pa.c r8, StringBuilder r10) {
            StringBuilder r11 = r10;
            if (r11 != null) goto L5;
            String r12 = null;
        L6:
            r8.H(r12);
            return;
        L5:
            r12 = r11.toString();
            goto L6
        }
    }

    public class k extends ha.c0<Class> {
        @Override // ha.c0
        public final Class a(pa.a r8) {
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }

        @Override // ha.c0
        public final void b(pa.c r8, Class r10) {
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + r10.getName() + ". Forgot to register a type adapter?");
        }
    }

    public class l extends ha.c0<StringBuffer> {
        @Override // ha.c0
        public final StringBuffer a(pa.a r8) {
            if (r8.h0() != pa.b.f9974s) goto L6;
            r8.V();
            return null;
        L6:
            return new StringBuffer(r8.e0());
        }

        @Override // ha.c0
        public final void b(pa.c r8, StringBuffer r10) {
            StringBuffer r11 = r10;
            if (r11 != null) goto L5;
            String r12 = null;
        L6:
            r8.H(r12);
            return;
        L5:
            r12 = r11.toString();
            goto L6
        }
    }

    public class m extends ha.c0<URL> {
        @Override // ha.c0
        public final URL a(pa.a r8) {
            if (r8.h0() != pa.b.f9974s) goto L5;
            r8.V();
            return null;
        L5:
            String r10 = r8.e0();
            if ("null".equals(r10) == false) goto L9;
            return null;
        L9:
            return new URL(r10);
        }

        @Override // ha.c0
        public final void b(pa.c r8, URL r10) {
            URL r11 = r10;
            if (r11 != null) goto L5;
            String r12 = null;
        L6:
            r8.H(r12);
            return;
        L5:
            r12 = r11.toExternalForm();
            goto L6
        }
    }

    public class n extends ha.c0<URI> {
        @Override // ha.c0
        public final URI a(pa.a r8) {
            if (r8.h0() != pa.b.f9974s) goto L14;
            r8.V();
        L16:
            return null;
        L14:
            String r10 = r8.e0();     // Catch: URISyntaxException -> L11
            if ("null".equals(r10) == true) goto L16;
            return new URI(r10);
        L11:
            e = move-exception;
            throw new ha.q(e);
        }

        @Override // ha.c0
        public final void b(pa.c r8, URI r10) {
            URI r11 = r10;
            if (r11 != null) goto L5;
            String r12 = null;
        L6:
            r8.H(r12);
            return;
        L5:
            r12 = r11.toASCIIString();
            goto L6
        }
    }

    public class o extends ha.c0<InetAddress> {
        @Override // ha.c0
        public final InetAddress a(pa.a r8) {
            if (r8.h0() != pa.b.f9974s) goto L6;
            r8.V();
            return null;
        L6:
            return InetAddress.getByName(r8.e0());
        }

        @Override // ha.c0
        public final void b(pa.c r8, InetAddress r10) {
            InetAddress r11 = r10;
            if (r11 != null) goto L5;
            String r12 = null;
        L6:
            r8.H(r12);
            return;
        L5:
            r12 = r11.getHostAddress();
            goto L6
        }
    }

    public class p extends ha.c0<UUID> {
        @Override // ha.c0
        public final UUID a(pa.a r8) {
            if (r8.h0() != pa.b.f9974s) goto L5;
            r8.V();
            return null;
        L5:
            String r10 = r8.e0();
            return UUID.fromString(r10);
        L8:
            e = move-exception;
            StringBuilder r11 = defpackage.b.h("Failed parsing '", r10, "' as UUID; at path ");
            r11.append(r8.A());
            throw new ha.q(r11.toString(), e);
        }

        @Override // ha.c0
        public final void b(pa.c r8, UUID r10) {
            UUID r11 = r10;
            if (r11 != null) goto L5;
            String r12 = null;
        L6:
            r8.H(r12);
            return;
        L5:
            r12 = r11.toString();
            goto L6
        }
    }

    public class q extends ha.c0<Currency> {
        @Override // ha.c0
        public final Currency a(pa.a r8) {
            String r10 = r8.e0();
            return Currency.getInstance(r10);
        L5:
            e = move-exception;
            StringBuilder r11 = defpackage.b.h("Failed parsing '", r10, "' as Currency; at path ");
            r11.append(r8.A());
            throw new ha.q(r11.toString(), e);
        }

        @Override // ha.c0
        public final void b(pa.c r8, Currency r10) {
            r8.H(r10.getCurrencyCode());
        }
    }

    /* JADX INFO: renamed from: ka.r$r, reason: collision with other inner class name */
    public class C0109r extends ha.c0<Calendar> {
        @Override // ha.c0
        public final Calendar a(pa.a r10) {
            if (r10.h0() != pa.b.f9974s) goto L5;
            r10.V();
            return null;
        L5:
            r10.i();
            int r8 = 0;
            int r11 = 0;
            int r12 = 0;
            int r13 = 0;
            int r14 = 0;
            int r15 = 0;
        L7:
            if (r10.h0() == pa.b.f9969n) goto L26;
            String r16 = r10.J();
            int r17 = r10.H();
            if ("year".equals(r16) == true) goto L10;
            if ("month".equals(r16) == true) goto L13;
            if ("dayOfMonth".equals(r16) == true) goto L16;
            if ("hourOfDay".equals(r16) == true) goto L19;
            if ("minute".equals(r16) == true) goto L22;
            if ("second".equals(r16) == false) goto L7;
            r15 = r17;
            goto L7
        L22:
            r14 = r17;
            goto L7
        L19:
            r13 = r17;
            goto L7
        L16:
            r12 = r17;
            goto L7
        L13:
            r11 = r17;
            goto L7
        L10:
            r8 = r17;
            goto L7
        L26:
            r10.v();
            return new GregorianCalendar(r8, r11, r12, r13, r14, r15);
        }

        @Override // ha.c0
        public final void b(pa.c r8, Calendar r10) {
            Calendar r11 = r10;
            if (r11 != null) goto L5;
            r8.z();
            return;
        L5:
            r8.k();
            r8.w("year");
            r8.D(r11.get(1));
            r8.w("month");
            r8.D(r11.get(2));
            r8.w("dayOfMonth");
            r8.D(r11.get(5));
            r8.w("hourOfDay");
            r8.D(r11.get(11));
            r8.w("minute");
            r8.D(r11.get(12));
            r8.w("second");
            r8.D(r11.get(13));
            r8.v();
        }
    }

    public class s extends ha.c0<Locale> {
        @Override // ha.c0
        public final Locale a(pa.a r8) {
            String r10 = null;
            if (r8.h0() != pa.b.f9974s) goto L5;
            r8.V();
            return null;
        L5:
            StringTokenizer r11 = new StringTokenizer(r8.e0(), "_");
            if (r11.hasMoreElements() == false) goto L8;
            String r12 = r11.nextToken();
        L10:
            if (r11.hasMoreElements() == false) goto L12;
            String r13 = r11.nextToken();
        L14:
            if (r11.hasMoreElements() == false) goto L16;
            r10 = r11.nextToken();
        L16:
            if (r13 != null) goto L20;
            if (r10 != null) goto L20;
            return new Locale(r12);
        L20:
            if (r10 != null) goto L22;
            Locale r14 = new Locale(r12, r13);
        L24:
            return r14;
        L22:
            r14 = new Locale(r12, r13, r10);
            goto L24
        L12:
            r13 = null;
            goto L14
        L8:
            r12 = null;
            goto L10
        }

        @Override // ha.c0
        public final void b(pa.c r8, Locale r10) {
            Locale r11 = r10;
            if (r11 != null) goto L5;
            String r12 = null;
        L6:
            r8.H(r12);
            return;
        L5:
            r12 = r11.toString();
            goto L6
        }
    }

    public class t extends ha.c0<ha.p> {
        public static ha.p c(pa.a r8, pa.b r10) {
            int r11 = r10.ordinal();
            if (r11 == 5) goto L19;
            if (r11 == 6) goto L17;
            if (r11 == 7) goto L15;
            if (r11 != 8) goto L13;
            r8.V();
            return ha.r.f8002a;
        L13:
            throw new IllegalStateException("Unexpected token: " + r10);
        L15:
            return new ha.u(Boolean.valueOf(r8.E()));
        L17:
            return new ha.u(new ja.r(r8.e0()));
        L19:
            return new ha.u(r8.e0());
        }

        public static ha.p d(pa.a r8, pa.b r10) {
            int r11 = r10.ordinal();
            if (r11 != 0) goto L5;
            r8.a();
            return new ha.m();
        L5:
            if (r11 == 2) goto L8;
            return null;
        L8:
            r8.i();
            return new ha.s();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static void e(ha.p r8, pa.c r10) {
            if (r8 != null) goto L4;
        L31:
            r10.z();
            return;
        L4:
            if ((r8 instanceof ha.r) == true) goto L31;
            if ((r8 instanceof ha.u) == false) goto L16;
            ha.u r11 = r8.g();
            Serializable r12 = r11.f8004a;
            if ((r12 instanceof Number) == false) goto L12;
            r10.G(r11.i());
            return;
        L12:
            if ((r12 instanceof Boolean) == false) goto L14;
            r10.I(r11.b());
            return;
        L14:
            r10.H(r11.j());
            return;
        L16:
            if ((r8 instanceof ha.m) == false) goto L23;
            r10.i();
            Iterator<ha.p> r13 = r8.e().iterator();
        L19:
            if (r13.hasNext() == false) goto L21;
            e(r13.next(), r10);
            goto L19
        L21:
            r10.r();
            return;
        L23:
            if ((r8 instanceof ha.s) == false) goto L30;
            r10.k();
            ja.s.b.a r14 = new ja.s.b.a(r8.f().o());
        L26:
            if (r14.hasNext() == false) goto L28;
            ja.s.e<K, V> r15 = r14.a();
            r10.w((String) r15.f8804p);
            e((ha.p) r15.f8806r, r10);
            goto L26
        L28:
            r10.v();
            return;
        L30:
            throw new IllegalArgumentException("Couldn't write " + r8.getClass());
        }

        @Override // ha.c0
        public final ha.p a(pa.a r8) {
            if ((r8 instanceof ka.f) == true) goto L44;
            pa.b r10 = r8.h0();
            ha.p r11 = d(r8, r10);
            if (r11 == null) goto L45;
            ArrayDeque r12 = new ArrayDeque();
        L10:
            if (r8.B() == true) goto L12;
            if ((r11 instanceof ha.m) == false) goto L30;
            r8.r();
        L32:
            if (r12.isEmpty() == true) goto L34;
            r11 = (ha.p) r12.removeLast();
            goto L10
        L34:
            return r11;
        L30:
            r8.v();
            goto L32
        L12:
            if ((r11 instanceof ha.s) == false) goto L14;
            String r13 = r8.J();
        L15:
            pa.b r14 = r8.h0();
            ha.p r15 = d(r8, r14);
            if (r15 == null) goto L18;
            boolean r16 = true;
        L19:
            if (r15 != null) goto L22;
            r15 = c(r8, r14);
        L22:
            if ((r11 instanceof ha.m) == false) goto L24;
            ((ha.m) r11).k(r15);
        L25:
            if (r16 == false) goto L10;
            r12.addLast(r11);
            r11 = r15;
            goto L10
        L24:
            ((ha.s) r11).k(r13, r15);
            goto L25
        L18:
            r16 = false;
            goto L19
        L14:
            r13 = null;
            goto L15
        L45:
            return c(r8, r10);
        L44:
            return ((ka.f) r8).x0();
        }

        @Override // ha.c0
        public final /* bridge */ /* synthetic */ void b(pa.c r8, ha.p r10) {
            e(r10, r8);
        }
    }

    public class u implements ha.d0 {
        @Override // ha.d0
        public final <T> ha.c0<T> a(ha.j r8, oa.a<T> r10) {
            Class<? super T> r11 = r10.getRawType();
            if (Enum.class.isAssignableFrom(r11) == false) goto L11;
            if (r11 != Enum.class) goto L7;
            return null;
        L7:
            if (r11.isEnum() == true) goto L10;
            r11 = r11.getSuperclass();
        L10:
            return new d0(r11);
        L11:
            return null;
        }
    }

    public class v extends ha.c0<BitSet> {
        @Override // ha.c0
        public final BitSet a(pa.a r8) {
            BitSet r10 = new BitSet();
            r8.a();
            pa.b r11 = r8.h0();
            int r12 = 0;
        L4:
            if (r11 == pa.b.f9967b) goto L25;
            int r13 = r11.ordinal();
            if (r13 != 5) goto L8;
        L14:
            int r14 = r8.H();
            if (r14 != 0) goto L18;
            boolean r15 = false;
        L20:
            if (r15 == false) goto L22;
            r10.set(r12);
        L22:
            r12 = r12 + 1;
            r11 = r8.h0();
            goto L4
        L18:
            if (r14 != 1) goto L23;
            r15 = true;
            goto L20
        L23:
            StringBuilder r16 = defpackage.b.f("Invalid bitset value ", r14, ", expected 0 or 1; at path ");
            r16.append(r8.A());
            throw new ha.q(r16.toString());
        L8:
            if (r13 == 6) goto L14;
            if (r13 != 7) goto L13;
            r15 = r8.E();
            goto L20
        L13:
            throw new ha.q("Invalid bitset value type: " + r11 + "; at path " + r8.x());
        L25:
            r8.r();
            return r10;
        }

        @Override // ha.c0
        public final void b(pa.c r8, BitSet r10) {
            BitSet r11 = r10;
            r8.i();
            int r12 = r11.length();
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L5;
            r8.D(r11.get(r13) ? 1 : 0);
            r13 = r13 + 1;
            goto L3
        L5:
            r8.r();
        }
    }

    public class w extends ha.c0<Boolean> {
        @Override // ha.c0
        public final Boolean a(pa.a r8) {
            pa.b r10 = r8.h0();
            if (r10 != pa.b.f9974s) goto L6;
            r8.V();
            return null;
        L6:
            if (r10 != pa.b.f9971p) goto L8;
            boolean r11 = Boolean.parseBoolean(r8.e0());
        L10:
            return Boolean.valueOf(r11);
        L8:
            r11 = r8.E();
            goto L10
        }

        @Override // ha.c0
        public final void b(pa.c r8, Boolean r10) {
            r8.E(r10);
        }
    }

    public class x extends ha.c0<Boolean> {
        @Override // ha.c0
        public final Boolean a(pa.a r8) {
            if (r8.h0() != pa.b.f9974s) goto L6;
            r8.V();
            return null;
        L6:
            return Boolean.valueOf(r8.e0());
        }

        @Override // ha.c0
        public final void b(pa.c r8, Boolean r10) {
            Boolean r11 = r10;
            if (r11 != null) goto L5;
            String r12 = "null";
        L6:
            r8.H(r12);
            return;
        L5:
            r12 = r11.toString();
            goto L6
        }
    }

    public class y extends ha.c0<Number> {
        @Override // ha.c0
        public final Number a(pa.a r8) {
            if (r8.h0() != pa.b.f9974s) goto L17;
            r8.V();
            return null;
        L17:
            int r10 = r8.H();     // Catch: NumberFormatException -> L14
            if (r10 <= 255) goto L9;
        L12:
            StringBuilder r11 = defpackage.b.f("Lossy conversion from ", r10, " to byte; at path ");
            r11.append(r8.A());
            throw new ha.q(r11.toString());
        L9:
            if (r10 < (-128)) goto L12;
            return Byte.valueOf((byte) r10);
        L14:
            e = move-exception;
            throw new ha.q(e);
        }

        @Override // ha.c0
        public final void b(pa.c r8, Number r10) {
            Number r11 = r10;
            if (r11 != null) goto L5;
            r8.z();
            return;
        L5:
            r8.D(r11.byteValue());
        }
    }

    public class z extends ha.c0<Number> {
        @Override // ha.c0
        public final Number a(pa.a r8) {
            if (r8.h0() != pa.b.f9974s) goto L17;
            r8.V();
            return null;
        L17:
            int r10 = r8.H();     // Catch: NumberFormatException -> L14
            if (r10 <= 65535) goto L9;
        L12:
            StringBuilder r11 = defpackage.b.f("Lossy conversion from ", r10, " to short; at path ");
            r11.append(r8.A());
            throw new ha.q(r11.toString());
        L9:
            if (r10 < (-32768)) goto L12;
            return Short.valueOf((short) r10);
        L14:
            e = move-exception;
            throw new ha.q(e);
        }

        @Override // ha.c0
        public final void b(pa.c r8, Number r10) {
            Number r11 = r10;
            if (r11 != null) goto L5;
            r8.z();
            return;
        L5:
            r8.D(r11.shortValue());
        }
    }

    static {
        f9054a = new ka.s(Class.class, new ha.b0(new k()));
        f9055b = new ka.s(BitSet.class, new ha.b0(new v()));
        w r8 = new w();
        f9056c = new x();
        f9057d = new ka.t(Boolean.TYPE, Boolean.class, r8);
        y r10 = new y();
        f9058e = new ka.t(Byte.TYPE, Byte.class, r10);
        z r11 = new z();
        f9059f = new ka.t(Short.TYPE, Short.class, r11);
        a0 r12 = new a0();
        f9060g = new ka.t(Integer.TYPE, Integer.class, r12);
        f9061h = new ka.s(AtomicInteger.class, new ha.b0(new b0()));
        f9062i = new ka.s(AtomicBoolean.class, new ha.b0(new c0()));
        f9063j = new ka.s(AtomicIntegerArray.class, new ha.b0(new a()));
        f9064k = new b();
        new c();
        new d();
        e r13 = new e();
        f9065l = new ka.t(Character.TYPE, Character.class, r13);
        f r14 = new f();
        f9066m = new g();
        f9067n = new h();
        f9068o = new i();
        f9069p = new ka.s(String.class, r14);
        f9070q = new ka.s(StringBuilder.class, new j());
        f9071r = new ka.s(StringBuffer.class, new l());
        f9072s = new ka.s(URL.class, new m());
        f9073t = new ka.s(URI.class, new n());
        f9074u = new ka.v(InetAddress.class, new o());
        f9075v = new ka.s(UUID.class, new p());
        f9076w = new ka.s(Currency.class, new ha.b0(new q()));
        f9077x = new ka.u(new C0109r());
        f9078y = new ka.s(Locale.class, new s());
        t r15 = new t();
        f9079z = r15;
        A = new ka.v(ha.p.class, r15);
        B = new u();
    }
}
