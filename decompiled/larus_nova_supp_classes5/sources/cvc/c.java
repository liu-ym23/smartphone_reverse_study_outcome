package cvc;

import com.bytedance.mt.protector.impl.PatternProtector;
import com.ss.android.ugc.effectmanager.common.EffectRequest;
import java.io.Closeable;
import java.io.IOException;
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
import kotlin.KotlinVersion;
import kotlin.UByte;
import kotlin.jvm.internal.LongCompanionObject;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class c {
    public static final byte[] a = null;
    public static final String[] b = null;
    public static final ResponseBody c = null;
    public static final RequestBody d = null;
    public static final ByteString e = null;
    public static final ByteString f = null;
    public static final ByteString g = null;
    public static final ByteString h = null;
    public static final ByteString i = null;
    public static final Charset j = null;
    public static final Charset k = null;
    public static final Charset l = null;
    public static final Charset m = null;
    public static final Charset n = null;
    public static final Charset o = null;
    public static final TimeZone p = null;
    public static final a q = null;
    public static final Method r = null;
    public static final Pattern s = null;

    public static class a implements Comparator<String> {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(String r1, String r2) {
            return r1.compareTo(r2);
        }
    }

    static {
        byte[] r1 = new byte[0];
        a = r1;
        b = new String[0];
        Method r2 = null;
        c = ResponseBody.create(null, r1);
        d = RequestBody.create(null, r1);
        e = ByteString.decodeHex("efbbbf");
        f = ByteString.decodeHex("feff");
        g = ByteString.decodeHex("fffe");
        h = ByteString.decodeHex("0000ffff");
        i = ByteString.decodeHex("ffff0000");
        j = Charset.forName(EffectRequest.DEFAULT_PARAMS_ENCODING);
        k = Charset.forName("ISO-8859-1");
        l = Charset.forName("UTF-16BE");
        m = Charset.forName("UTF-16LE");
        n = Charset.forName("UTF-32BE");
        o = Charset.forName("UTF-32LE");
        p = TimeZone.getTimeZone("GMT");
        q = new a();
        r2 = Throwable.class.getDeclaredMethod("addSuppressed", new Class[]{Throwable.class});     // Catch: Exception -> L6
    L4:
        r = r2;
        s = PatternProtector.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    }

    public static int g(char r2) {
        if (r2 >= '0') goto L5;
    L8:
        char r0 = 'a';
        if (r2 >= 'a') goto L11;
    L14:
        r0 = 'A';
        if (r2 >= 'A') goto L17;
        return -1;
    L17:
        if (r2 <= 'F') goto L13;
        return -1;
    L13:
        return (r2 - r0) + 10;
    L11:
        if (r2 > 'f') goto L14;
    L5:
        if (r2 > '9') goto L8;
        return r2 - '0';
    }

    public static String c(String r8) {
        int r1 = -1;
        boolean r3 = true;
        int r4 = 0;
        if (r8.contains(":") == true) goto L5;
        String r9 = IDN.toASCII(r8).toLowerCase(Locale.US);     // Catch: IllegalArgumentException -> L64
        if (r9.isEmpty() == false) goto L48;
        return null;
    L48:
        int r0 = 0;
    L50:
        if (r0 >= r9.length()) goto L60;
        char r5 = r9.charAt(r0);     // Catch: IllegalArgumentException -> L64
        if (r5 <= 31) goto L61;
        if (r5 >= 127) goto L61;
        if (" #%/:?@[\\]".indexOf(r5) != (-1)) goto L61;
        r0 = r0 + 1;
    L61:
        if (r3 == false) goto L63;
        return null;
    L63:
        return r9;
    L60:
        r3 = false;
    L64:
        return null;
    L5:
        if (r8.startsWith("[") == true) goto L7;
    L9:
        InetAddress r2 = h(r8, 0, r8.length());
    L10:
        if (r2 != null) goto L12;
        return null;
    L12:
        byte[] r6 = r2.getAddress();
        if (r6.length != 16) goto L44;
        int r10 = 0;
        int r7 = 0;
    L16:
        if (r10 >= r6.length) goto L30;
        int r11 = r10;
    L18:
        if (r11 >= 16) goto L24;
        if (r6[r11] != 0) goto L24;
        if (r6[r11 + 1] != 0) goto L24;
        r11 = r11 + 2;
    L24:
        int r12 = r11 - r10;
        if (r12 <= r7) goto L29;
        if (r12 < 4) goto L29;
        r1 = r10;
        r7 = r12;
    L29:
        r10 = r11 + 2;
        goto L16
    L30:
        Buffer r13 = new Buffer();
    L32:
        if (r4 >= r6.length) goto L42;
        if (r4 == r1) goto L35;
        if (r4 <= 0) goto L40;
        r13.writeByte(58);
    L40:
        r13.writeHexadecimalUnsignedLong(((r6[r4] & UByte.MAX_VALUE) << 8) | (r6[r4 + 1] & UByte.MAX_VALUE));
        r4 = r4 + 2;
        goto L32
    L35:
        r13.writeByte(58);
        r4 = r4 + r7;
        if (r4 != 16) goto L32;
        r13.writeByte(58);
        goto L32
    L42:
        return r13.readUtf8();
    L44:
        throw new AssertionError("Invalid IPv6 address: '" + r8 + "'");
    L7:
        if (r8.endsWith("]") == false) goto L9;
        r2 = h(r8, 1, r8.length() - 1);
        goto L10
    }

    public static void e(Closeable r0) {
        if (r0 != null) goto L9;
        return;
    L9:
        r0.close();     // Catch: RuntimeException -> L5 Exception -> L8
        goto L12
    L11:
        return;
    L5:
        e = move-exception;
        throw e;
    }

    public static void f(Socket r2) {
        if (r2 != null) goto L17;
        return;
    L17:
        r2.close();     // Catch: RuntimeException -> L5 AssertionError -> L10 Exception -> L16
        goto L21
    L19:
        return;
    L10:
        e = move-exception;
        if (q(e) == true) goto L20;
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

    public static <T> List<T> n(List<T> r1) {
        return Collections.unmodifiableList(new ArrayList(r1));
    }

    public static <T> List<T> o(T... r0) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) r0.clone()));
    }

    public static boolean q(AssertionError r1) {
        if (r1.getCause() != null) goto L5;
    L9:
        return false;
    L5:
        if (r1.getMessage() == null) goto L9;
        if (r1.getMessage().contains("getsockname failed") == false) goto L9;
        return true;
    }

    public static Headers v(List<gvc.a> r4) {
        Headers.Builder r0 = new Headers.Builder();
        Iterator r5 = ((ArrayList) r4).iterator();
    L4:
        if (r5.hasNext() == false) goto L7;
        gvc.a r1 = (gvc.a) r5.next();
        OkHttpClient.a r2 = cvc.a.a;
        String r3 = r1.a.utf8();
        String r6 = r1.b.utf8();
        r2.getClass();
        r0.addLenient(r3, r6);
        goto L4
    L7:
        return r0.build();
    }

    public static boolean x(String r1) {
        return s.matcher(r1).matches();
    L4:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public static AssertionError a(String r1, Exception r2) {
        AssertionError r0 = new AssertionError(r1);
        r0.initCause(r2);     // Catch: IllegalStateException -> L5
    L4:
        return r0;
    }

    public static Charset b(BufferedSource r4, Charset r5) throws IOException {
        ByteString r0 = e;
        if (r4.rangeEquals(0, r0) == false) goto L6;
        r4.skip(r0.size());
        return j;
    L6:
        ByteString r1 = f;
        if (r4.rangeEquals(0, r1) == false) goto L10;
        r4.skip(r1.size());
        return l;
    L10:
        ByteString r2 = g;
        if (r4.rangeEquals(0, r2) == false) goto L14;
        r4.skip(r2.size());
        return m;
    L14:
        ByteString r3 = h;
        if (r4.rangeEquals(0, r3) == false) goto L18;
        r4.skip(r3.size());
        return n;
    L18:
        ByteString r6 = i;
        if (r4.rangeEquals(0, r6) == false) goto L22;
        r4.skip(r6.size());
        return o;
    L22:
        return r5;
    }

    public static boolean k(Object r0, Object r1) {
        if (r0 == r1) goto L8;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.equals(r1) == false) goto L7;
    L8:
        return true;
    }

    public static String l(String r1, Object... r2) {
        return String.format(Locale.US, r1, r2);
    }

    public static String m(HttpUrl r3, boolean r4) {
        if (r3.host().contains(":") == false) goto L5;
        String r0 = "[" + r3.host() + "]";
    L6:
        if (r4 == true) goto L10;
        if (r3.port() != HttpUrl.defaultPort(r3.scheme())) goto L10;
        return r0;
    L10:
        return r0 + ":" + r3.port();
    L5:
        r0 = r3.host();
        goto L6
    }

    public static int d(String r5, long r6, TimeUnit r8) {
        if (r6 < 0) goto L20;
        if (r8 == null) goto L18;
        long r7 = r8.toMillis(r6);
        if (r7 > 2147483647L) goto L16;
        if (r7 != 0) goto L14;
        if (r6 <= 0) goto L14;
        throw new IllegalArgumentException(r5.concat(" too small."));
    L14:
        return (int) r7;
    L16:
        throw new IllegalArgumentException(r5.concat(" too large."));
    L18:
        throw new NullPointerException("unit == null");
    L20:
        throw new IllegalArgumentException(r5.concat(" < 0"));
    }

    @Nullable
    public static InetAddress h(String r16, int r17, int r18) {
        int r2 = 16;
        byte[] r3 = new byte[16];
        int r4 = 0;
        int r5 = -1;
        int r6 = r17;
        int r7 = 0;
        int r8 = -1;
        int r9 = -1;
    L4:
        if (r6 >= r18) goto L72;
        if (r7 == r2) goto L6;
        int r11 = r6 + 2;
        if (r11 <= r18) goto L10;
    L17:
        if (r7 != 0) goto L19;
    L58:
        r9 = r6;
    L59:
        r6 = r9;
        int r10 = 0;
    L60:
        if (r6 >= r18) goto L65;
        int r12 = g(r16.charAt(r6));
        if (r12 == (-1)) goto L65;
        r10 = (r10 << 4) + r12;
        r6 = r6 + 1;
    L65:
        int r13 = r6 - r9;
        if (r13 == 0) goto L70;
        if (r13 > 4) goto L70;
        int r14 = r7 + 1;
        r3[r7] = (byte) ((r10 >>> 8) & KotlinVersion.MAX_COMPONENT_VALUE);
        r7 = r14 + 1;
        r3[r14] = (byte) (r10 & KotlinVersion.MAX_COMPONENT_VALUE);
        r2 = 16;
        r4 = 0;
        r5 = -1;
    L70:
        return null;
    L19:
        if (r16.regionMatches(r6, ":", r4, 1) == false) goto L22;
        r6 = r6 + 1;
        goto L58
    L22:
        if (r16.regionMatches(r6, ".", r4, 1) == false) goto L57;
        int r15 = r7 - 2;
        int r19 = r15;
    L24:
        if (r9 >= r18) goto L51;
        if (r19 == r2) goto L52;
        if (r19 != r15) goto L29;
    L32:
        int r110 = r9;
        int r111 = 0;
    L33:
        if (r110 >= r18) goto L47;
        char r20 = r16.charAt(r110);
        if (r20 < '0') goto L47;
        if (r20 > '9') goto L47;
        if (r111 != 0) goto L42;
        if (r9 != r110) goto L52;
    L42:
        r111 = ((r111 * 10) + r20) - 48;
        if (r111 > 255) goto L52;
        r110 = r110 + 1;
    L47:
        if ((r110 - r9) == 0) goto L52;
        r3[r19] = (byte) r111;
        r19 = r19 + 1;
        r9 = r110;
        r2 = 16;
        goto L24
    L29:
        if (r16.charAt(r9) != '.') goto L52;
        r9 = r9 + 1;
    L52:
        boolean r112 = false;
    L54:
        if (r112 == true) goto L56;
        return null;
    L56:
        r7 = r7 + 2;
        goto L72
    L51:
        if (r19 != (r15 + 4)) goto L52;
        r112 = true;
        goto L54
    L57:
        return null;
    L10:
        if (r16.regionMatches(r6, "::", r4, 2) == false) goto L17;
        if (r8 != r5) goto L12;
        r7 = r7 + 2;
        r8 = r7;
        if (r11 == r18) goto L72;
        r9 = r11;
        goto L59
    L12:
        return null;
    L6:
        return null;
    L72:
        if (r7 != 16) goto L74;
    L81:
        return InetAddress.getByAddress(r3);
    L80:
        throw new AssertionError();
    L74:
        if (r8 != (-1)) goto L76;
        return null;
    L76:
        int r1 = r7 - r8;
        System.arraycopy(r3, r8, r3, 16 - r1, r1);
        Arrays.fill(r3, r8, (16 - r7) + r8, (byte) 0);
        goto L81
    }

    public static String[] p(Comparator<? super String> r8, String[] r9, String[] r10) {
        ArrayList r0 = new ArrayList();
        int r1 = r9.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L12;
        String r4 = r9[r3];
        int r5 = r10.length;
        int r6 = 0;
    L5:
        if (r6 >= r5) goto L10;
        if (r8.compare(r4, r10[r6]) == 0) goto L8;
        r6 = r6 + 1;
        goto L5
    L8:
        r0.add(r4);
    L10:
        r3 = r3 + 1;
        goto L3
    L12:
        return (String[]) r0.toArray(new String[r0.size()]);
    }

    public static boolean r(Comparator<String> r7, String[] r8, String[] r9) {
        if (r8 == null) goto L20;
        if (r9 == null) goto L20;
        if (r8.length == 0) goto L20;
        if (r9.length == 0) goto L20;
        int r1 = r8.length;
        int r2 = 0;
    L11:
        if (r2 >= r1) goto L20;
        String r3 = r8[r2];
        int r4 = r9.length;
        int r5 = 0;
    L13:
        if (r5 >= r4) goto L19;
        if (r7.compare(r3, r9[r5]) == 0) goto L16;
        r5 = r5 + 1;
        goto L13
    L16:
        return true;
    L19:
        r2 = r2 + 1;
    L20:
        return false;
    }

    public static boolean s(Source r11, int r12, TimeUnit r13) throws IOException {
        long r0 = System.nanoTime();
        if (r11.timeout().f() == false) goto L5;
        long r5 = r11.timeout().d() - r0;
    L6:
        r11.timeout().e(Math.min(r5, r13.toNanos(r12)) + r0);
        Buffer r14 = new Buffer();     // Catch: Throwable -> L18 InterruptedIOException -> L24
    L9:
        if (r11.read(r14, 8192) == (-1)) goto L13;
        r14.clear();     // Catch: Throwable -> L18 InterruptedIOException -> L24
        goto L25
    L13:
        if (r5 != LongCompanionObject.MAX_VALUE) goto L15;
        r11.timeout().b();
        return true;
    L15:
        r11.timeout().e(r0 + r5);
        return true;
    L18:
        th = move-exception;
        if (r5 != LongCompanionObject.MAX_VALUE) goto L22;
        r11.timeout().b();
    L23:
        throw th;
    L22:
        r11.timeout().e(r0 + r5);
    L25:
        if (r5 != LongCompanionObject.MAX_VALUE) goto L27;
        r11.timeout().b();
        return false;
    L27:
        r11.timeout().e(r0 + r5);
        return false;
    L5:
        r5 = Long.MAX_VALUE;
        goto L6
    }

    public static int t(String r2, int r3, int r4) {
    L2:
        if (r3 >= r4) goto L15;
        char r0 = r2.charAt(r3);
        if (r0 == '\t') goto L14;
        if (r0 == '\n') goto L14;
        if (r0 == '\f') goto L14;
        if (r0 == '\r') goto L14;
        if (r0 == ' ') goto L14;
        return r3;
    L14:
        r3 = r3 + 1;
        goto L2
    L15:
        return r4;
    }

    public static int u(String r2, int r3, int r4) {
        int r5 = r4 - 1;
    L3:
        if (r5 < r3) goto L17;
        char r0 = r2.charAt(r5);
        if (r0 == '\t') goto L16;
        if (r0 == '\n') goto L16;
        if (r0 == '\f') goto L16;
        if (r0 == '\r') goto L16;
        if (r0 == ' ') goto L16;
        return r5 + 1;
    L16:
        r5 = r5 - 1;
        goto L3
    L17:
        return r3;
    }

    public static String w(String r0, int r1, int r2) {
        int r3 = t(r0, r1, r2);
        return r0.substring(r3, u(r0, r3, r2));
    }

    public static int i(String r1, int r2, int r3, char r4) {
    L2:
        if (r2 >= r3) goto L7;
        if (r1.charAt(r2) == r4) goto L5;
        r2 = r2 + 1;
        goto L2
    L5:
        return r2;
    L7:
        return r3;
    }

    public static int j(String r2, int r3, int r4, String r5) {
    L2:
        if (r3 >= r4) goto L7;
        if (r5.indexOf(r2.charAt(r3)) != (-1)) goto L5;
        r3 = r3 + 1;
        goto L2
    L5:
        return r3;
    L7:
        return r4;
    }
}
