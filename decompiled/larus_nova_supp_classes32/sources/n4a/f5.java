package n4a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastByteProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.aivoice.core.data.NameKeys;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.GZIPOutputStream;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f5 {
    public static final String[] a = null;
    public static final String[] b = null;

    static {
        a = new String[]{"arm64-v8a", "x86_64"};
        b = new String[]{"arm", "x86"};
        int r0 = 0;
    L4:
        if (r0 >= 80) goto L6;
        r0 = r0 + 1;
        goto L4
    }

    public static String b(long r2, String r4) {
        return new SimpleDateFormat(r4, Locale.CHINA).format(new Date(r2));
    L4:
        th = move-exception;
        n.a(th, "ut", "ctt");
        return null;
    }

    public static String c(Context r7) {
        if (Build.VERSION.SDK_INT < 28) goto L38;
    L8:
        String r0 = NameKeys.UnloadStrategy_No_Strategy;
    L10:
        if (Build.VERSION.SDK_INT < 28) goto L33;
        String[] r3 = (String[]) Build.class.getDeclaredField("SUPPORTED_ABIS").get(null);     // Catch: Throwable -> L30
        if (r3 == null) goto L17;
        if (r3.length <= 0) goto L17;
        r0 = r3[0];     // Catch: Throwable -> L30
    L17:
        if (TextUtils.isEmpty(r0) == true) goto L33;
        if (Arrays.asList(a).contains(r0) == false) goto L33;
        String r8 = r7.getApplicationInfo().nativeLibraryDir;     // Catch: Throwable -> L30
        if (TextUtils.isEmpty(r8) == true) goto L33;
        String r9 = r8.substring(r8.lastIndexOf(File.separator) + 1);     // Catch: Throwable -> L30
        if (Arrays.asList(b).contains(r9) == false) goto L33;
        String[] r10 = (String[]) Build.class.getDeclaredField("SUPPORTED_32_BIT_ABIS").get(null);     // Catch: Throwable -> L30
        if (r10 == null) goto L33;
        if (r10.length <= 0) goto L33;
        r0 = r10[0];     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        n.a(th, "ut", "gct_p");
    L33:
        if (TextUtils.isEmpty(r0) == true) goto L35;
        return r0;
    L35:
        return Build.CPU_ABI;
    L38:
        ApplicationInfo r1 = r7.getApplicationInfo();     // Catch: Throwable -> L6
        Field r4 = a(ApplicationInfo.class.getName()).getDeclaredField("primaryCpuAbi");     // Catch: Throwable -> L6
        r4.setAccessible(true);     // Catch: Throwable -> L6
        r0 = (String) r4.get(r1);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        n.a(th, "ut", "gct");
        goto L8
    }

    public static String d(byte[] r2) {
        if (r2 != null) goto L4;
        return NameKeys.UnloadStrategy_No_Strategy;
    L4:
        if (r2.length == 0) goto L14;
        return new String(r2, "UTF-8");
    L9:
        return new String(r2);
    L14:
        return NameKeys.UnloadStrategy_No_Strategy;
    }

    public static void f(ByteArrayOutputStream r2, byte r3, byte[] r4) {
        r2.write(new byte[]{r3});     // Catch: IOException -> L11
        int r5 = r3 & 255;     // Catch: IOException -> L11
        if (r5 >= 255) goto L8;
        if (r5 <= 0) goto L8;
        r2.write(r4);     // Catch: IOException -> L11
        return;
    L8:
        if (r5 != 255) goto L15;
        r2.write(r4, 0, 255);     // Catch: IOException -> L11
        return;
    L15:
        return;
    L11:
        e = move-exception;
        n.a(e, "ut", "wFie");
    }

    public static void g(ByteArrayOutputStream r2, String r3) {
        if (TextUtils.isEmpty(r3) == true) goto L15;
        int r0 = r3.length();
        if (r0 <= 255) goto L13;
        r0 = 255;
    L13:
        f(r2, (byte) r0, j(r3));
        return;
    L15:
        r2.write(new byte[]{0});     // Catch: IOException -> L7
        return;
    L7:
        e = move-exception;
        n.a(e, "ut", "wsf");
    }

    public static boolean h(JSONObject r0, String r1) {
        if (r0 != null) goto L4;
        return false;
    L4:
        if (r0.has(r1) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public static byte[] i(int r3) {
        return new byte[]{(byte) (r3 / 256), (byte) (r3 % 256)};
    }

    public static byte[] j(String r1) {
        if (TextUtils.isEmpty(r1) == true) goto L5;
        return r1.getBytes("UTF-8");
    L9:
        return r1.getBytes();
    L5:
        return new byte[0];
    }

    public static byte[] n(byte[] r2) {
        return t(r2);
    L4:
        th = move-exception;
        n.a(th, "ut", "gZp");
        return new byte[0];
    }

    public static byte[] p() {
        String[] r1 = new StringBuffer("16,16,18,77,15,911,121,77,121,911,38,77,911,99,86,67,611,96,48,77,84,911,38,67,021,301,86,67,611,98,48,77,511,77,48,97,511,58,48,97,511,84,501,87,511,96,48,77,221,911,38,77,121,37,86,67,25,301,86,67,021,96,86,67,021,701,86,67,35,56,86,67,611,37,221,87").reverse().toString().split(",");     // Catch: Throwable -> L13
        byte[] r2 = new byte[r1.length];     // Catch: Throwable -> L13
        int r3 = 0;
        int r4 = 0;
    L5:
        if (r4 >= r1.length) goto L7;
        r2[r4] = CastByteProtector.parseByte(r1[r4]);     // Catch: Throwable -> L13
        r4 = r4 + 1;     // Catch: Throwable -> L13
        goto L5
    L7:
        String[] r0 = new StringBuffer(new String(y4.e(new String(r2)))).reverse().toString().split(",");     // Catch: Throwable -> L13
        byte[] r5 = new byte[r0.length];     // Catch: Throwable -> L13
    L8:
        if (r3 >= r0.length) goto L12;
        r5[r3] = CastByteProtector.parseByte(r0[r3]);     // Catch: Throwable -> L13
        r3 = r3 + 1;
        goto L8
    L12:
        return r5;
    L13:
        th = move-exception;
        n.a(th, "ut", "gIV");
        return new byte[16];
    }

    public static PublicKey q() throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException {
        ByteArrayInputStream r2 = new ByteArrayInputStream(y4.e("MIICnjCCAgegAwIBAgIJAJ0Pdzos7ZfYMA0GCSqGSIb3DQEBBQUAMGgxCzAJBgNVBAYTAkNOMRMwEQYDVQQIDApTb21lLVN0YXRlMRAwDgYDVQQHDAdCZWlqaW5nMREwDwYDVQQKDAhBdXRvbmF2aTEfMB0GA1UEAwwWY29tLmF1dG9uYXZpLmFwaXNlcnZlcjAeFw0xMzA4MTUwNzU2NTVaFw0yMzA4MTMwNzU2NTVaMGgxCzAJBgNVBAYTAkNOMRMwEQYDVQQIDApTb21lLVN0YXRlMRAwDgYDVQQHDAdCZWlqaW5nMREwDwYDVQQKDAhBdXRvbmF2aTEfMB0GA1UEAwwWY29tLmF1dG9uYXZpLmFwaXNlcnZlcjCBnzANBgkqhkiG9w0BAQEFAAOBjQAwgYkCgYEA8eWAyHbFPoFPfdx5AD+D4nYFq4dbJ1p7SIKt19Oz1oivF/6H43v5Fo7s50pD1UF8+Qu4JoUQxlAgOt8OCyQ8DYdkaeB74XKb1wxkIYg/foUwN1CMHPZ9O9ehgna6K4EJXZxR7Y7XVZnbjHZIVn3VpPU/Rdr2v37LjTw+qrABJxMCAwEAAaNQME4wHQYDVR0OBBYEFOM/MLGP8xpVFuVd+3qZkw7uBvOTMB8GA1UdIwQYMBaAFOM/MLGP8xpVFuVd+3qZkw7uBvOTMAwGA1UdEwQFMAMBAf8wDQYJKoZIhvcNAQEFBQADgYEA4LY3g8aAD8JkxAOqUXDDyLuCCGOc2pTIhn0TwMNaVdH4hZlpTeC/wuRD5LJ0z3j+IQ0vLvuQA5uDjVyEOlBrvVIGwSem/1XGUo13DfzgAJ5k1161S5l+sFUo5TxpHOXr8Z5nqJMjieXmhnE/I99GFyHpQmw4cC6rhYUhdhtg+Zk="));     // Catch: Throwable -> L19
        CertificateFactory r0 = CertificateFactory.getInstance(o("IWC41MDk"));     // Catch: Throwable -> L26
        KeyFactory r3 = KeyFactory.getInstance(o("EUlNB"));     // Catch: Throwable -> L26
        Certificate r1 = r0.generateCertificate(r2);     // Catch: Throwable -> L26
        if (r1 == null) goto L29;
        if (r3 == null) goto L29;
        PublicKey r4 = r3.generatePublic(new X509EncodedKeySpec(r1.getPublicKey().getEncoded()));     // Catch: Throwable -> L26
        r2.close();     // Catch: Throwable -> L11
    L13:
        return r4;
    L11:
        th = move-exception;
        th.printStackTrace();
    L29:
        r2.close();     // Catch: Throwable -> L16
    L18:
        return null;
    L16:
        th = move-exception;
        th.printStackTrace();
    L20:
        if (r2 != null) goto L27;
    L25:
        return null;
    L27:
        r2.close();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        th.printStackTrace();
    L19:
        r2 = null;
        goto L20
    }

    public static void r(String r3) {
    L2:
        int r1 = 0;
        if (r3.length() < 78) goto L6;
        r3.substring(0, 78);
        r3 = r3.substring(78);
    L6:
        if (r1 >= (78 - r3.length())) goto L8;
        r1 = r1 + 1;
        goto L6
    }

    public static String s(byte[] r5) {
        StringBuilder r0 = new StringBuilder();
        if (r5 != null) goto L6;
        return null;
    L6:
        int r1 = 0;
    L8:
        if (r1 >= r5.length) goto L14;
        String r2 = Integer.toHexString(r5[r1] & 255);
        if (r2.length() != 1) goto L12;
        r2 = "0".concat(r2);
    L12:
        r0.append(r2);
        r1 = r1 + 1;
        goto L8
    L14:
        return r0.toString();
    }

    public static byte[] t(byte[] r3) throws IOException, Throwable {
        GZIPOutputStream r0 = null;
        if (r3 != null) goto L42;
        return null;
    L42:
        ByteArrayOutputStream r1 = new ByteArrayOutputStream();     // Catch: Throwable -> L19
        GZIPOutputStream r2 = new GZIPOutputStream(r1);     // Catch: Throwable -> L17
        r2.write(r3);     // Catch: Throwable -> L15
        r2.finish();     // Catch: Throwable -> L15
        byte[] r4 = r1.toByteArray();     // Catch: Throwable -> L15
        r2.close();     // Catch: Throwable -> L13
        r1.close();     // Catch: Throwable -> L11
        return r4;
    L11:
        th = move-exception;
        throw th;
    L13:
        th = move-exception;
        throw th;
    L15:
        th = th;
        r0 = r2;
    L46:
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        if (r0 != null) goto L36;
    L28:
        if (r1 != null) goto L44;
    L33:
        throw th;
    L44:
        r1.close();     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        throw th;
    L36:
        r0.close();     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    L17:
        th = th;
    L19:
        th = th;
        r1 = null;
        goto L46
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class<?> r4 = Class.forName(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    public static String k(String r2) {
        String r0 = null;
        if (r2 != null) goto L17;
        return null;
    L17:
        r0 = y4.g(j(r2));     // Catch: Throwable -> L8
    L15:
        return ((char) ((r0.length() % 26) + 65)) + r0;
    L12:
        th = move-exception;
        n.a(th, "ut", "tsfb64");
        return NameKeys.UnloadStrategy_No_Strategy;
    L8:
        th = move-exception;
        th.printStackTrace();
        goto L15
    }

    public static String l(Map<String, String> r8) {
        StringBuilder r0 = new StringBuilder();
        Iterator r9 = ((HashMap) r8).entrySet().iterator();
    L4:
        if (r9.hasNext() == false) goto L9;
        Map.Entry r1 = (Map.Entry) r9.next();
        if (r0.length() <= 0) goto L8;
        r0.append("&");
    L8:
        r0.append((String) r1.getKey());
        r0.append("=");
        r0.append((String) r1.getValue());
        goto L4
    L9:
        String r10 = r0.toString();
    L23:
        th = move-exception;
        n.a(th, "ut", "sPa");
        return r10;
    L11:
        if (TextUtils.isEmpty(r10) == true) goto L34;
        String[] r2 = r10.split("&");     // Catch: Throwable -> L23
        Arrays.sort(r2);     // Catch: Throwable -> L23
        StringBuffer r3 = new StringBuffer();     // Catch: Throwable -> L23
        int r4 = r2.length;     // Catch: Throwable -> L23
        int r5 = 0;
    L14:
        if (r5 >= r4) goto L19;
        String r6 = r2[r5];     // Catch: Throwable -> L23
        if (TextUtils.isEmpty(r6) == true) goto L18;
        r3.append(r6);     // Catch: Throwable -> L23
        r3.append("&");     // Catch: Throwable -> L23
    L18:
        r5 = r5 + 1;     // Catch: Throwable -> L23
        goto L14
    L19:
        String r7 = r3.toString();     // Catch: Throwable -> L23
        if (r7.length() <= 1) goto L35;
        return (String) r7.subSequence(0, r7.length() - 1);
    L35:
        return r10;
    L34:
        return NameKeys.UnloadStrategy_No_Strategy;
    }

    public static boolean m(Context r3) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if (TextUtils.isEmpty(l.a) == false) goto L20;
        TelephonyManager r4 = (TelephonyManager) r3.getSystemService("phone");     // Catch: Throwable -> L26
        if (r4 == null) goto L17;
        String r5 = r4.getNetworkOperator();     // Catch: Throwable -> L26
        if (TextUtils.isEmpty(r5) == true) goto L17;
        if (r5.length() < 3) goto L17;
        String r6 = r5.substring(0, 3);     // Catch: Throwable -> L26
    L18:
        l.a = r6;
    L17:
        r6 = NameKeys.UnloadStrategy_No_Strategy;
    L20:
        if (TextUtils.isEmpty(l.a) == false) goto L22;
        return false;
    L22:
        if (TextUtils.isDigitsOnly(l.a) == true) goto L25;
        return false;
    L25:
        return ",202,204,206,208,212,213,214,216,218,219,220,222,225,226,228,230,231,232,234,235,238,240,242,244,246,247,248,250,255,257,259,260,262,266,268,270,272,274,276,278,280,282,283,284,286,288,289,290,292,293,294,295,297,302,308,310,311,312,313,314,315,316,310,330,332,334,338,340,342,344,346,348,350,352,354,356,358,360,362,363,364,365,366,368,370,372,374,376,400,401,402,404,405,406,410,412,413,414,415,416,417,418,419,420,421,422,424,425,426,427,428,429,430,431,432,434,436,437,438,440,441,450,452,454,455,456,457,466,467,470,472,502,505,510,514,515,520,525,528,530,534,535,536,537,539,540,541,542,543,544,545,546,547,548,549,550,551,552,553,555,602,603,604,605,606,607,608,609,610,611,612,613,614,615,616,617,618,619,620,621,622,623,624,625,626,627,628,629,630,631,632,633,634,635,636,637,638,639,640,641,642,643,645,646,647,648,649,650,651,652,653,654,655,657,659,702,704,706,708,710,712,714,716,722,724,730,732,734,736,738,740,742,744,746,748,750,901,".contains("," + l.a + ",");
    }

    public static String o(String r2) {
        if (r2.length() >= 2) goto L7;
        return NameKeys.UnloadStrategy_No_Strategy;
    L7:
        return d(y4.e(r2.substring(1)));
    }

    public static void e(Context r8, String r9, String r10, JSONObject r11) {
        String r4 = v4.f(r8);
        String r5 = b5.a(r4);
        String r12 = v4.h(r8);     // Catch: Throwable -> L5
    L42:
        boolean r6 = r11.has("info");     // Catch: Throwable -> L39
        String r7 = NameKeys.UnloadStrategy_No_Strategy;
        if (r6 == false) goto L11;
        String r3 = JSONObjectProtectorUtils.getString(r11, "info");     // Catch: Throwable -> L39
    L13:
        if ("INVALID_USER_SCODE".equals(r3) == false) goto L27;
        if (r11.has("sec_code") == false) goto L17;
        String r1 = JSONObjectProtectorUtils.getString(r11, "sec_code");     // Catch: Throwable -> L39
    L19:
        if (r11.has("sec_code_debug") == false) goto L22;
        r7 = JSONObjectProtectorUtils.getString(r11, "sec_code_debug");     // Catch: Throwable -> L39
    L22:
        if (r5.equals(r1) == false) goto L24;
    L25:
        String r0 = "C6K+35Zyo6auY5b635byA5pS+5bmz5Y+w5a6Y572R5Lit5pCc57Si";
    L36:
        o(r0);     // Catch: Throwable -> L39
        goto L37
    L24:
        if (r5.equals(r7) == false) goto L37;
    L17:
        r1 = NameKeys.UnloadStrategy_No_Strategy;
        goto L19
    L27:
        if ("INVALID_USER_KEY".equals(r3) == false) goto L37;
        if (r11.has("key") == false) goto L32;
        r7 = JSONObjectProtectorUtils.getString(r11, "key");     // Catch: Throwable -> L39
    L32:
        if (r7.length() <= 0) goto L37;
        if (r12.equals(r7) == true) goto L37;
        r0 = "C6K+35Zyo6auY5b635byA5pS+5bmz5Y+w5a6Y572R5LiK5Y+R6LW35oqA5pyv5ZKo6K+i5bel5Y2V4oCUPui0puWPt+S4jktleemXrumimO+8jOWSqOivoklOVkFMSURfVVNFUl9LRVnlpoLkvZXop6PlhrM=";
        goto L36
    L11:
        r3 = NameKeys.UnloadStrategy_No_Strategy;
    L37:
        r("SHA1Package:".concat(String.valueOf(r4)));
        r("key:".concat(String.valueOf(r12)));
        r("csid:".concat(String.valueOf(r9)));
        r("gsid:".concat(String.valueOf(r10)));
        r("json:" + r11.toString());
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
        r12 = v4.d;
        goto L42
    }
}
