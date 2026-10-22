package qa;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.spec.X509EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class t4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f11124a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f11125b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f11126c = null;

    static {
        f11124a = new String[]{"arm64-v8a", "x86_64"};
        f11125b = new String[]{"arm", "x86"};
        StringBuilder r8 = new StringBuilder();
        int r10 = 0;
    L4:
        if (r10 >= 80) goto L6;
        r8.append("=");
        r10 = r10 + 1;
        goto L4
    L6:
        f11126c = r8.toString();
    }

    public static String a(long r8, String r10) {
        return new SimpleDateFormat(r10, Locale.CHINA).format(new Date(r8));
    L4:
        th = move-exception;
        l.a("ut", "ctt", th);
        return null;
    }

    public static String b(Context r8) {
        String r10 = "";
        String[] r11 = (String[]) Build.class.getDeclaredField("SUPPORTED_ABIS").get(null);     // Catch: Throwable -> L22
        if (r11 == null) goto L9;
        if (r11.length <= 0) goto L9;
        r10 = r11[0];     // Catch: Throwable -> L22
    L9:
        if (TextUtils.isEmpty(r10) == true) goto L25;
        if (Arrays.asList(f11124a).contains(r10) == false) goto L25;
        String r12 = r8.getApplicationInfo().nativeLibraryDir;     // Catch: Throwable -> L22
        if (TextUtils.isEmpty(r12) == true) goto L25;
        String r13 = r12.substring(r12.lastIndexOf(File.separator) + 1);     // Catch: Throwable -> L22
        if (Arrays.asList(f11125b).contains(r13) == false) goto L25;
        String[] r14 = (String[]) Build.class.getDeclaredField("SUPPORTED_32_BIT_ABIS").get(null);     // Catch: Throwable -> L22
        if (r14 == null) goto L25;
        if (r14.length <= 0) goto L25;
        r10 = r14[0];     // Catch: Throwable -> L22
    L25:
        if (TextUtils.isEmpty(r10) == true) goto L27;
        return r10;
    L27:
        return Build.CPU_ABI;
    L22:
        th = move-exception;
        l.a("ut", "gct_p", th);
        goto L25
    }

    public static String c(byte[] r8) {
        if (r8 != null) goto L4;
        return "";
    L4:
        if (r8.length == 0) goto L14;
        return new String(r8, "UTF-8");
    L9:
        return new String(r8);
    L14:
        return "";
    }

    public static void d(Context r10, String r11, String r12, JSONObject r13) {
        String r8 = "";
        String r14 = h4.f(r10);
        String r15 = l6.a.j(r14);
        String r16 = h4.h(r10);     // Catch: Throwable -> L5
    L45:
        if (r13.has(LocationMonitorConst.INFO) == false) goto L11;
        String r17 = r13.getString(LocationMonitorConst.INFO);     // Catch: Throwable -> L41
        String r18 = "请在高德开放平台官网中搜索\"" + r17 + "\"相关内容进行解决";     // Catch: Throwable -> L41
    L44:
    L37:
        r8 = r18;
        goto L38
    L13:
        if ("INVALID_USER_SCODE".equals(r17) == false) goto L27;
        if (r13.has("sec_code") == false) goto L17;
        String r19 = r13.getString("sec_code");     // Catch: Throwable -> L37
    L19:
        if (r13.has("sec_code_debug") == false) goto L22;
        r8 = r13.getString("sec_code_debug");     // Catch: Throwable -> L37
    L22:
        if (r15.equals(r19) == false) goto L24;
    L25:
        String r20 = n("C6K+35Zyo6auY5b635byA5pS+5bmz5Y+w5a6Y572R5Lit5pCc57Si").concat("\"请求内容过长导致业务调用失败\"相关内容进行解决");     // Catch: Throwable -> L37
    L39:
        String r21 = f11126c;
        Log.i("authErrLog", r21);
        Log.i("authErrLog", "                                   鉴权错误信息                                  ");
        Log.i("authErrLog", r21);
        q("SHA1Package:".concat(String.valueOf(r14)));
        q("key:".concat(String.valueOf(r16)));
        q("csid:".concat(String.valueOf(r11)));
        q("gsid:".concat(String.valueOf(r12)));
        q("json:" + r13.toString());
        Log.i("authErrLog", "                                                                               ");
        Log.i("authErrLog", r20);
        Log.i("authErrLog", r21);
        return;
    L24:
        if (r15.equals(r8) == true) goto L25;
    L36:
        r20 = r18;
        goto L39
    L17:
        r19 = "";
        goto L19
    L27:
        if ("INVALID_USER_KEY".equals(r17) == false) goto L36;
        if (r13.has("key") == false) goto L32;
        r8 = r13.getString("key");     // Catch: Throwable -> L37
    L32:
        if (r8.length() <= 0) goto L36;
        if (r16.equals(r8) == true) goto L36;
        r18 = n("C6K+35Zyo6auY5b635byA5pS+5bmz5Y+w5a6Y572R5LiK5Y+R6LW35oqA5pyv5ZKo6K+i5bel5Y2V4oCUPui0puWPt+S4jktleemXrumimO+8jOWSqOivoklOVkFMSURfVVNFUl9LRVnlpoLkvZXop6PlhrM=");     // Catch: Throwable -> L37
        goto L36
    L11:
        r17 = "";
        r18 = r17;
    L38:
        r20 = r8;
    L5:
        th = move-exception;
        th.printStackTrace();
        r16 = h4.f10509d;
        goto L45
    }

    public static void e(ByteArrayOutputStream r8, byte r10, byte[] r11) {
        r8.write(new byte[]{r10});     // Catch: IOException -> L11
        int r12 = r10 & 255;     // Catch: IOException -> L11
        if (r12 >= 255) goto L8;
        if (r12 <= 0) goto L8;
        r8.write(r11);     // Catch: IOException -> L11
        return;
    L8:
        if (r12 != 255) goto L15;
        r8.write(r11, 0, 255);     // Catch: IOException -> L11
        return;
    L15:
        return;
    L11:
        e = move-exception;
        l.a("ut", "wFie", e);
    }

    public static void f(ByteArrayOutputStream r8, String r10) {
        if (TextUtils.isEmpty(r10) == true) goto L15;
        int r11 = r10.length();
        if (r11 <= 255) goto L13;
        r11 = 255;
    L13:
        e(r8, (byte) r11, i(r10));
        return;
    L15:
        r8.write(new byte[]{0});     // Catch: IOException -> L7
        return;
    L7:
        e = move-exception;
        l.a("ut", "wsf", e);
    }

    public static boolean g(String r8, JSONObject r10) {
        if (r10 != null) goto L4;
        return false;
    L4:
        if (r10.has(r8) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public static byte[] h(int r8) {
        return new byte[]{(byte) (r8 / 256), (byte) (r8 % 256)};
    }

    public static byte[] i(String r8) {
        if (TextUtils.isEmpty(r8) == true) goto L5;
        return r8.getBytes("UTF-8");
    L9:
        return r8.getBytes();
    L5:
        return new byte[0];
    }

    public static String j(String r8) {
        String r10 = null;
        if (r8 != null) goto L17;
        return null;
    L17:
        r10 = l4.g(i(r8));     // Catch: Throwable -> L8
    L15:
        return ((char) ((r10.length() % 26) + 65)) + r10;
    L12:
        th = move-exception;
        l.a("ut", "tsfb64", th);
        return "";
    L8:
        th = move-exception;
        th.printStackTrace();
        goto L15
    }

    public static String k(HashMap r8) {
        StringBuilder r10 = new StringBuilder();
        Iterator r11 = r8.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        Map.Entry r12 = (Map.Entry) r11.next();
        if (r10.length() <= 0) goto L8;
        r10.append("&");
    L8:
        r10.append((String) r12.getKey());
        r10.append("=");
        r10.append((String) r12.getValue());
        goto L4
    L9:
        String r13 = r10.toString();
    L23:
        th = move-exception;
        l.a("ut", "sPa", th);
        return r13;
    L11:
        if (TextUtils.isEmpty(r13) == true) goto L34;
        String[] r14 = r13.split("&");     // Catch: Throwable -> L23
        Arrays.sort(r14);     // Catch: Throwable -> L23
        StringBuffer r15 = new StringBuffer();     // Catch: Throwable -> L23
        int r16 = r14.length;     // Catch: Throwable -> L23
        int r17 = 0;
    L14:
        if (r17 >= r16) goto L19;
        String r18 = r14[r17];     // Catch: Throwable -> L23
        if (TextUtils.isEmpty(r18) == true) goto L18;
        r15.append(r18);     // Catch: Throwable -> L23
        r15.append("&");     // Catch: Throwable -> L23
    L18:
        r17 = r17 + 1;     // Catch: Throwable -> L23
        goto L14
    L19:
        String r19 = r15.toString();     // Catch: Throwable -> L23
        if (r19.length() <= 1) goto L35;
        return (String) r19.subSequence(0, r19.length() - 1);
    L35:
        return r13;
    L34:
        return "";
    }

    public static boolean l(Context r8) {
        if (r8 != null) goto L6;
        return false;
    L6:
        if (TextUtils.isEmpty(t2.b.E) == false) goto L20;
        TelephonyManager r10 = (TelephonyManager) r8.getSystemService("phone");     // Catch: Throwable -> L26
        if (r10 == null) goto L17;
        String r11 = r10.getNetworkOperator();     // Catch: Throwable -> L26
        if (TextUtils.isEmpty(r11) == true) goto L17;
        if (r11.length() < 3) goto L17;
        String r12 = r11.substring(0, 3);     // Catch: Throwable -> L26
    L18:
        t2.b.E = r12;
    L17:
        r12 = "";
    L20:
        if (TextUtils.isEmpty(t2.b.E) == false) goto L22;
        return false;
    L22:
        if (TextUtils.isDigitsOnly(t2.b.E) == true) goto L25;
        return false;
    L25:
        return ",202,204,206,208,212,213,214,216,218,219,220,222,225,226,228,230,231,232,234,235,238,240,242,244,246,247,248,250,255,257,259,260,262,266,268,270,272,274,276,278,280,282,283,284,286,288,289,290,292,293,294,295,297,302,308,310,311,312,313,314,315,316,310,330,332,334,338,340,342,344,346,348,350,352,354,356,358,360,362,363,364,365,366,368,370,372,374,376,400,401,402,404,405,406,410,412,413,414,415,416,417,418,419,420,421,422,424,425,426,427,428,429,430,431,432,434,436,437,438,440,441,450,452,454,455,456,457,466,467,470,472,502,505,510,514,515,520,525,528,530,534,535,536,537,539,540,541,542,543,544,545,546,547,548,549,550,551,552,553,555,602,603,604,605,606,607,608,609,610,611,612,613,614,615,616,617,618,619,620,621,622,623,624,625,626,627,628,629,630,631,632,633,634,635,636,637,638,639,640,641,642,643,645,646,647,648,649,650,651,652,653,654,655,657,659,702,704,706,708,710,712,714,716,722,724,730,732,734,736,738,740,742,744,746,748,750,901,".contains("," + t2.b.E + ",");
    }

    public static byte[] m(byte[] r8) {
        return s(r8);
    L4:
        th = move-exception;
        l.a("ut", "gZp", th);
        return new byte[0];
    }

    public static String n(String r8) {
        if (r8.length() >= 2) goto L7;
        return "";
    L7:
        return c(l4.e(r8.substring(1)));
    }

    public static byte[] o() {
        String[] r8 = new StringBuffer("16,16,18,77,15,911,121,77,121,911,38,77,911,99,86,67,611,96,48,77,84,911,38,67,021,301,86,67,611,98,48,77,511,77,48,97,511,58,48,97,511,84,501,87,511,96,48,77,221,911,38,77,121,37,86,67,25,301,86,67,021,96,86,67,021,701,86,67,35,56,86,67,611,37,221,87").reverse().toString().split(",");     // Catch: Throwable -> L13
        byte[] r10 = new byte[r8.length];     // Catch: Throwable -> L13
        int r11 = 0;
        int r12 = 0;
    L5:
        if (r12 >= r8.length) goto L7;
        r10[r12] = Byte.parseByte(r8[r12]);     // Catch: Throwable -> L13
        r12 = r12 + 1;     // Catch: Throwable -> L13
        goto L5
    L7:
        String[] r13 = new StringBuffer(new String(l4.e(new String(r10)))).reverse().toString().split(",");     // Catch: Throwable -> L13
        byte[] r14 = new byte[r13.length];     // Catch: Throwable -> L13
    L8:
        if (r11 >= r13.length) goto L12;
        r14[r11] = Byte.parseByte(r13[r11]);     // Catch: Throwable -> L13
        r11 = r11 + 1;
        goto L8
    L12:
        return r14;
    L13:
        th = move-exception;
        l.a("ut", "gIV", th);
        return new byte[16];
    }

    public static PublicKey p() {
        ByteArrayInputStream r8 = new ByteArrayInputStream(l4.e("MIICnjCCAgegAwIBAgIJAJ0Pdzos7ZfYMA0GCSqGSIb3DQEBBQUAMGgxCzAJBgNVBAYTAkNOMRMwEQYDVQQIDApTb21lLVN0YXRlMRAwDgYDVQQHDAdCZWlqaW5nMREwDwYDVQQKDAhBdXRvbmF2aTEfMB0GA1UEAwwWY29tLmF1dG9uYXZpLmFwaXNlcnZlcjAeFw0xMzA4MTUwNzU2NTVaFw0yMzA4MTMwNzU2NTVaMGgxCzAJBgNVBAYTAkNOMRMwEQYDVQQIDApTb21lLVN0YXRlMRAwDgYDVQQHDAdCZWlqaW5nMREwDwYDVQQKDAhBdXRvbmF2aTEfMB0GA1UEAwwWY29tLmF1dG9uYXZpLmFwaXNlcnZlcjCBnzANBgkqhkiG9w0BAQEFAAOBjQAwgYkCgYEA8eWAyHbFPoFPfdx5AD+D4nYFq4dbJ1p7SIKt19Oz1oivF/6H43v5Fo7s50pD1UF8+Qu4JoUQxlAgOt8OCyQ8DYdkaeB74XKb1wxkIYg/foUwN1CMHPZ9O9ehgna6K4EJXZxR7Y7XVZnbjHZIVn3VpPU/Rdr2v37LjTw+qrABJxMCAwEAAaNQME4wHQYDVR0OBBYEFOM/MLGP8xpVFuVd+3qZkw7uBvOTMB8GA1UdIwQYMBaAFOM/MLGP8xpVFuVd+3qZkw7uBvOTMAwGA1UdEwQFMAMBAf8wDQYJKoZIhvcNAQEFBQADgYEA4LY3g8aAD8JkxAOqUXDDyLuCCGOc2pTIhn0TwMNaVdH4hZlpTeC/wuRD5LJ0z3j+IQ0vLvuQA5uDjVyEOlBrvVIGwSem/1XGUo13DfzgAJ5k1161S5l+sFUo5TxpHOXr8Z5nqJMjieXmhnE/I99GFyHpQmw4cC6rhYUhdhtg+Zk="));     // Catch: Throwable -> L19
        CertificateFactory r10 = CertificateFactory.getInstance(n("IWC41MDk"));     // Catch: Throwable -> L26
        KeyFactory r11 = KeyFactory.getInstance(n("EUlNB"));     // Catch: Throwable -> L26
        Certificate r12 = r10.generateCertificate(r8);     // Catch: Throwable -> L26
        if (r12 == null) goto L29;
        if (r11 == null) goto L29;
        PublicKey r13 = r11.generatePublic(new X509EncodedKeySpec(r12.getPublicKey().getEncoded()));     // Catch: Throwable -> L26
        r8.close();     // Catch: Throwable -> L11
    L13:
        return r13;
    L11:
        th = move-exception;
        th.printStackTrace();
    L29:
        r8.close();     // Catch: Throwable -> L16
    L18:
        return null;
    L16:
        th = move-exception;
        th.printStackTrace();
    L20:
        if (r8 != null) goto L27;
    L25:
        return null;
    L27:
        r8.close();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        th.printStackTrace();
    L19:
        r8 = null;
        goto L20
    }

    public static void q(String r8) {
    L2:
        int r10 = 0;
        if (r8.length() < 78) goto L4;
        Log.i("authErrLog", "|" + r8.substring(0, 78) + "|");
        r8 = r8.substring(78);
        goto L2
    L4:
        StringBuilder r11 = new StringBuilder("|");
        r11.append(r8);
    L6:
        if (r10 >= (78 - r8.length())) goto L8;
        r11.append(" ");
        r10 = r10 + 1;
        goto L6
    L8:
        r11.append("|");
        Log.i("authErrLog", r11.toString());
    }

    public static String r(byte[] r8) {
        StringBuilder r10 = new StringBuilder();
        if (r8 != null) goto L6;
        return null;
    L6:
        int r11 = 0;
    L8:
        if (r11 >= r8.length) goto L14;
        String r12 = Integer.toHexString(r8[r11] & 255);
        if (r12.length() != 1) goto L12;
        r12 = "0".concat(r12);
    L12:
        r10.append(r12);
        r11 = r11 + 1;
        goto L8
    L14:
        return r10.toString();
    }

    public static byte[] s(byte[] r8) {
        GZIPOutputStream r10 = null;
        if (r8 != null) goto L25;
        return null;
    L25:
        ByteArrayOutputStream r11 = new ByteArrayOutputStream();     // Catch: Throwable -> L14
        GZIPOutputStream r12 = new GZIPOutputStream(r11);     // Catch: Throwable -> L12
        r12.write(r8);     // Catch: Throwable -> L10
        r12.finish();     // Catch: Throwable -> L10
        byte[] r13 = r11.toByteArray();     // Catch: Throwable -> L10
        r12.close();
        r11.close();
        return r13;
    L10:
        th = th;
        r10 = r12;
    L27:
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        if (r10 == null) goto L20;
        r10.close();
    L20:
        if (r11 == null) goto L22;
        r11.close();
    L22:
        throw th;
    L12:
        th = th;
    L14:
        th = th;
        r11 = null;
        goto L27
    }
}
