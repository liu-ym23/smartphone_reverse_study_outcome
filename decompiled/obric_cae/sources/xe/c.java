package xe;

import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import java.io.Closeable;
import java.io.InterruptedIOException;
import java.lang.reflect.Method;
import java.net.IDN;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import jf.f;
import jf.g;
import jf.w;
import jf.x;
import we.b0;
import we.q;
import we.r;
import we.v;
import we.z;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f13880a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f13881b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b0 f13882c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final g f13883d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final g f13884e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final g f13885f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final g f13886g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final g f13887h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Charset f13888i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Charset f13889j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Charset f13890k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Charset f13891l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Charset f13892m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final TimeZone f13893n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final a f13894o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Method f13895p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Pattern f13896q = null;

    public static class a implements Comparator<String> {
        @Override // java.util.Comparator
        public final int compare(String r8, String r10) {
            return r8.compareTo(r10);
        }
    }

    static {
        byte[] r8 = new byte[0];
        f13880a = r8;
        f13881b = new String[0];
        jf.d r10 = new jf.d();
        r10.m15write(r8);
        f13882c = new b0(0, r10);
        Method r11 = null;
        z.create(null, r8);
        f13883d = g.b("efbbbf");
        f13884e = g.b("feff");
        f13885f = g.b("fffe");
        f13886g = g.b("0000ffff");
        f13887h = g.b("ffff0000");
        f13888i = Charset.forName("UTF-8");
        Charset.forName("ISO-8859-1");
        f13889j = Charset.forName("UTF-16BE");
        f13890k = Charset.forName("UTF-16LE");
        f13891l = Charset.forName("UTF-32BE");
        f13892m = Charset.forName("UTF-32LE");
        f13893n = TimeZone.getTimeZone("GMT");
        f13894o = new a();
        r11 = Throwable.class.getDeclaredMethod("addSuppressed", new Class[]{Throwable.class});     // Catch: Exception -> L6
    L4:
        f13895p = r11;
        f13896q = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    }

    public static AssertionError a(String r8, Exception r10) {
        AssertionError r11 = new AssertionError(r8);
        r11.initCause(r10);     // Catch: IllegalStateException -> L5
    L4:
        return r11;
    }

    public static Charset b(f r8, Charset r10) {
        g r11 = f13883d;
        if (r8.j(r11) == false) goto L6;
        r8.skip(r11.f8842a.length);
        return f13888i;
    L6:
        g r12 = f13884e;
        if (r8.j(r12) == false) goto L10;
        r8.skip(r12.f8842a.length);
        return f13889j;
    L10:
        g r13 = f13885f;
        if (r8.j(r13) == false) goto L14;
        r8.skip(r13.f8842a.length);
        return f13890k;
    L14:
        g r14 = f13886g;
        if (r8.j(r14) == false) goto L18;
        r8.skip(r14.f8842a.length);
        return f13891l;
    L18:
        g r15 = f13887h;
        if (r8.j(r15) == false) goto L22;
        r8.skip(r15.f8842a.length);
        return f13892m;
    L22:
        return r10;
    }

    public static String c(String r8) {
        int r10 = -1;
        int r11 = 0;
        if (r8.contains(BdimCategoryConstants.SEPARATOR_COLON) == true) goto L5;
        String r12 = IDN.toASCII(r8).toLowerCase(Locale.US);     // Catch: IllegalArgumentException -> L64
        if (r12.isEmpty() == false) goto L48;
        return null;
    L48:
        int r13 = 0;
    L50:
        if (r13 >= r12.length()) goto L61;
        char r14 = r12.charAt(r13);     // Catch: IllegalArgumentException -> L64
        if (r14 <= 31) goto L60;
        if (r14 >= 127) goto L60;
        if (" #%/:?@[\\]".indexOf(r14) != (-1)) goto L60;
        r13 = r13 + 1;
    L60:
        r11 = 1;
    L61:
        if (r11 == 0) goto L63;
        return null;
    L63:
        return r12;
    L64:
        return null;
    L5:
        if (r8.startsWith("[") == true) goto L7;
    L9:
        InetAddress r15 = i(0, r8.length(), r8);
    L10:
        if (r15 != null) goto L12;
        return null;
    L12:
        byte[] r16 = r15.getAddress();
        if (r16.length != 16) goto L44;
        int r17 = 0;
        int r18 = 0;
    L16:
        if (r17 >= r16.length) goto L30;
        int r19 = r17;
    L18:
        if (r19 >= 16) goto L24;
        if (r16[r19] != 0) goto L24;
        if (r16[r19 + 1] != 0) goto L24;
        r19 = r19 + 2;
    L24:
        int r20 = r19 - r17;
        if (r20 <= r18) goto L29;
        if (r20 < 4) goto L29;
        r10 = r17;
        r18 = r20;
    L29:
        r17 = r19 + 2;
        goto L16
    L30:
        jf.d r21 = new jf.d();
    L32:
        if (r11 >= r16.length) goto L42;
        if (r11 == r10) goto L35;
        if (r11 <= 0) goto L40;
        r21.G(58);
    L40:
        r21.I(((r16[r11] & 255) << 8) | (r16[r11 + 1] & 255));
        r11 = r11 + 2;
        goto L32
    L35:
        r21.G(58);
        r11 = r11 + r18;
        if (r11 != 16) goto L32;
        r21.G(58);
        goto L32
    L42:
        return r21.A();
    L44:
        throw new AssertionError(defpackage.b.d("Invalid IPv6 address: '", r8, "'"));
    L7:
        if (r8.endsWith("]") == false) goto L9;
        r15 = i(1, r8.length() - 1, r8);
        goto L10
    }

    public static int d(long r8, TimeUnit r10) {
        if (r8 < 0) goto L20;
        if (r10 == null) goto L18;
        long r11 = r10.toMillis(r8);
        if (r11 > 2147483647L) goto L16;
        if (r11 != 0) goto L14;
        if (r8 <= 0) goto L14;
        throw new IllegalArgumentException("timeout too small.");
    L14:
        return (int) r11;
    L16:
        throw new IllegalArgumentException("timeout too large.");
    L18:
        throw new NullPointerException("unit == null");
    L20:
        throw new IllegalArgumentException("timeout < 0");
    }

    public static void e(long r8, long r10, long r11) {
        if ((r10 | r11) < 0) goto L10;
        if (r10 > r8) goto L10;
        if ((r8 - r10) < r11) goto L10;
        return;
    L10:
        throw new ArrayIndexOutOfBoundsException();
    }

    public static void f(Closeable r8) {
        if (r8 != null) goto L9;
        return;
    L9:
        r8.close();     // Catch: RuntimeException -> L5 Exception -> L8
        goto L12
    L11:
        return;
    L5:
        e = move-exception;
        throw e;
    }

    public static void g(Socket r8) {
        if (r8 != null) goto L17;
        return;
    L17:
        r8.close();     // Catch: RuntimeException -> L5 AssertionError -> L10 Exception -> L16
        goto L21
    L19:
        return;
    L10:
        e = move-exception;
        if (s(e) == true) goto L20;
        throw e;
    L20:
        return;
    L5:
        e = move-exception;
        if ("bio == null".equals(e.getMessage()) == false) goto L9;
        return;
    L9:
        throw e;
    }

    public static int h(char r8) {
        if (r8 >= '0') goto L5;
    L8:
        char r10 = 'a';
        if (r8 >= 'a') goto L11;
    L14:
        r10 = 'A';
        if (r8 >= 'A') goto L17;
        return -1;
    L17:
        if (r8 <= 'F') goto L13;
        return -1;
    L13:
        return (r8 - r10) + 10;
    L11:
        if (r8 > 'f') goto L14;
    L5:
        if (r8 > '9') goto L8;
        return r8 - '0';
    }

    @Nullable
    public static InetAddress i(int r16, int r17, String r18) {
        int r8 = 16;
        byte[] r10 = new byte[16];
        int r11 = 0;
        int r12 = -1;
        int r13 = r16;
        int r14 = 0;
        int r15 = -1;
        int r19 = -1;
    L4:
        if (r13 >= r17) goto L71;
        if (r14 == r8) goto L6;
        int r110 = r13 + 2;
        if (r110 <= r17) goto L10;
    L17:
        if (r14 != 0) goto L19;
    L58:
        r19 = r13;
    L59:
        r13 = r19;
        int r20 = 0;
    L60:
        if (r13 >= r17) goto L65;
        int r21 = h(r18.charAt(r13));
        if (r21 == (-1)) goto L65;
        r20 = (r20 << 4) + r21;
        r13 = r13 + 1;
    L65:
        int r22 = r13 - r19;
        if (r22 == 0) goto L70;
        if (r22 > 4) goto L70;
        int r23 = r14 + 1;
        r10[r14] = (byte) ((r20 >>> 8) & 255);
        r14 = r23 + 1;
        r10[r23] = (byte) (r20 & 255);
        r8 = 16;
        r11 = 0;
        r12 = -1;
    L70:
        return null;
    L19:
        if (r18.regionMatches(r13, BdimCategoryConstants.SEPARATOR_COLON, r11, 1) == false) goto L22;
        r13 = r13 + 1;
        goto L58
    L22:
        if (r18.regionMatches(r13, ".", r11, 1) == false) goto L57;
        int r24 = r14 - 2;
        int r111 = r24;
    L24:
        if (r19 >= r17) goto L51;
        if (r111 == r8) goto L26;
        if (r111 != r24) goto L29;
    L32:
        int r112 = r11;
        int r113 = r19;
    L33:
        if (r113 >= r17) goto L47;
        char r25 = r18.charAt(r113);
        if (r25 < '0') goto L47;
        if (r25 > '9') goto L47;
        if (r112 != 0) goto L42;
        if (r19 == r113) goto L42;
    L52:
        int r114 = 0;
    L54:
        if (r114 != 0) goto L56;
        return null;
    L56:
        r14 = r14 + 2;
        int r26 = 16;
    L72:
        if (r14 != r26) goto L74;
    L81:
        return InetAddress.getByAddress(r10);
    L80:
        throw new AssertionError();
    L74:
        if (r15 != (-1)) goto L76;
        return null;
    L76:
        int r27 = r14 - r15;
        System.arraycopy(r10, r15, r10, 16 - r27, r27);
        Arrays.fill(r10, r15, (16 - r14) + r15, (byte) 0);
    L42:
        r112 = ((r112 * 10) + r25) - 48;
        if (r112 > 255) goto L52;
        r113 = r113 + 1;
    L47:
        if ((r113 - r19) == 0) goto L52;
        r10[r111] = (byte) r112;
        r111 = r111 + 1;
        r19 = r113;
        r8 = 16;
        r11 = 0;
        goto L24
    L29:
        if (r18.charAt(r19) != '.') goto L26;
        r19 = r19 + 1;
    L26:
        r114 = r11;
        goto L54
    L51:
        if (r111 != (r24 + 4)) goto L52;
        r114 = 1;
        goto L54
    L57:
        return null;
    L10:
        if (r18.regionMatches(r13, "::", r11, 2) == false) goto L17;
        if (r15 != r12) goto L12;
        r14 = r14 + 2;
        if (r110 == r17) goto L15;
        r15 = r14;
        r19 = r110;
        goto L59
    L15:
        r26 = r8;
        r15 = r14;
        goto L72
    L12:
        return null;
    L6:
        return null;
    L71:
        r26 = r8;
        goto L72
    }

    public static int j(int r8, int r10, String r11, String r12) {
    L2:
        if (r8 >= r10) goto L7;
        if (r12.indexOf(r11.charAt(r8)) != (-1)) goto L5;
        r8 = r8 + 1;
        goto L2
    L5:
        return r8;
    L7:
        return r10;
    }

    public static int k(String r8, int r10, int r11, char r12) {
    L2:
        if (r10 >= r11) goto L7;
        if (r8.charAt(r10) == r12) goto L5;
        r10 = r10 + 1;
        goto L2
    L5:
        return r10;
    L7:
        return r11;
    }

    public static boolean l(w r8, TimeUnit r10) {
        return u(r8, 100, r10);
    L5:
        return false;
    }

    public static boolean m(Object r8, Object r10) {
        if (r8 == r10) goto L8;
        if (r8 != null) goto L5;
    L7:
        return false;
    L5:
        if (r8.equals(r10) == false) goto L7;
    L8:
        return true;
    }

    public static String n(String r8, Object... r10) {
        return String.format(Locale.US, r8, r10);
    }

    public static String o(r r8, boolean r10) {
        boolean r11 = r8.f13244d.contains(BdimCategoryConstants.SEPARATOR_COLON);
        String r12 = r8.f13244d;
        if (r11 == false) goto L5;
        r12 = defpackage.b.d("[", r12, "]");
    L5:
        int r13 = r8.f13245e;
        if (r10 == true) goto L10;
        if (r13 != r.c(r8.f13241a)) goto L10;
        return r12;
    L10:
        return r12 + BdimCategoryConstants.SEPARATOR_COLON + r13;
    }

    public static <T> List<T> p(List<T> r8) {
        return Collections.unmodifiableList(new ArrayList(r8));
    }

    public static <T> List<T> q(T... r8) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) r8.clone()));
    }

    public static String[] r(Comparator<? super String> r8, String[] r10, String[] r11) {
        ArrayList r12 = new ArrayList();
        int r13 = r10.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L12;
        String r15 = r10[r14];
        int r16 = r11.length;
        int r17 = 0;
    L5:
        if (r17 >= r16) goto L10;
        if (r8.compare(r15, r11[r17]) == 0) goto L8;
        r17 = r17 + 1;
        goto L5
    L8:
        r12.add(r15);
    L10:
        r14 = r14 + 1;
        goto L3
    L12:
        return (String[]) r12.toArray(new String[r12.size()]);
    }

    public static boolean s(AssertionError r8) {
        if (r8.getCause() != null) goto L5;
    L9:
        return false;
    L5:
        if (r8.getMessage() == null) goto L9;
        if (r8.getMessage().contains("getsockname failed") == false) goto L9;
        return true;
    }

    public static boolean t(Comparator<String> r8, String[] r10, String[] r11) {
        if (r10 == null) goto L20;
        if (r11 == null) goto L20;
        if (r10.length == 0) goto L20;
        if (r11.length == 0) goto L20;
        int r12 = r10.length;
        int r13 = 0;
    L11:
        if (r13 >= r12) goto L20;
        String r14 = r10[r13];
        int r15 = r11.length;
        int r16 = 0;
    L13:
        if (r16 >= r15) goto L19;
        if (r8.compare(r14, r11[r16]) == 0) goto L16;
        r16 = r16 + 1;
        goto L13
    L16:
        return true;
    L19:
        r13 = r13 + 1;
    L20:
        return false;
    }

    public static boolean u(w r11, int r12, TimeUnit r13) {
        long r8 = System.nanoTime();
        if (r11.timeout().e() == false) goto L5;
        long r10 = r11.timeout().c() - r8;
    L6:
        r11.timeout().d(Math.min(r10, r13.toNanos(r12)) + r8);
        jf.d r14 = new jf.d();     // Catch: Throwable -> L18 InterruptedIOException -> L24
    L9:
        if (r11.u(r14, 8192) == (-1)) goto L12;
        r14.a();     // Catch: Throwable -> L18 InterruptedIOException -> L24
    L12:
        x r15 = r11.timeout();
        if (r10 != Long.MAX_VALUE) goto L15;
        r15.a();
        return true;
    L15:
        r15.d(r8 + r10);
        return true;
    L24:
        x r16 = r11.timeout();
        if (r10 != Long.MAX_VALUE) goto L27;
        r16.a();
        return false;
    L27:
        r16.d(r8 + r10);
        return false;
    L18:
        th = move-exception;
        x r17 = r11.timeout();
        if (r10 != Long.MAX_VALUE) goto L22;
        r17.a();
    L23:
        throw th;
    L22:
        r17.d(r8 + r10);
        goto L23
    L5:
        r10 = Long.MAX_VALUE;
        goto L6
    }

    public static int v(int r8, int r10, String r11) {
    L2:
        if (r8 >= r10) goto L15;
        char r12 = r11.charAt(r8);
        if (r12 == '\t') goto L14;
        if (r12 == '\n') goto L14;
        if (r12 == '\f') goto L14;
        if (r12 == '\r') goto L14;
        if (r12 == ' ') goto L14;
        return r8;
    L14:
        r8 = r8 + 1;
        goto L2
    L15:
        return r10;
    }

    public static int w(int r8, int r10, String r11) {
        int r12 = r10 - 1;
    L3:
        if (r12 < r8) goto L17;
        char r13 = r11.charAt(r12);
        if (r13 == '\t') goto L16;
        if (r13 == '\n') goto L16;
        if (r13 == '\f') goto L16;
        if (r13 == '\r') goto L16;
        if (r13 == ' ') goto L16;
        return r12 + 1;
    L16:
        r12 = r12 - 1;
        goto L3
    L17:
        return r8;
    }

    public static q x(ArrayList r8) {
        q.a r10 = new q.a();
        Iterator r11 = r8.iterator();
    L4:
        if (r11.hasNext() == false) goto L7;
        cf.c r12 = (cf.c) r11.next();
        v.a r13 = xe.a.f13878a;
        String r14 = r12.f3464a.p();
        String r15 = r12.f3465b.p();
        r13.getClass();
        r10.b(r14, r15);
        goto L4
    L7:
        return new q(r10);
    }

    public static String y(int r8, int r10, String r11) {
        int r12 = v(r8, r10, r11);
        return r11.substring(r12, w(r12, r10, r11));
    }
}
