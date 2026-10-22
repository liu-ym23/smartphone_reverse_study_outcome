package n4a;

import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.DPoint;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.string2number.CastByteProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.loc.es;
import com.obric.aivoice.core.data.NameKeys;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class j4 {
    public static String[] a;
    public static WifiManager b;
    public static String c;

    public static boolean A(Context r2, String r3) {
        if (Build.VERSION.SDK_INT < 23) goto L8;
        if (r2 != null) goto L6;
    L15:
        goto L12
    L6:
        if (C(r2, f5.o(r3)) != 0) goto L15;
    L11:
        return true;
    L8:
        if (r2 == null) goto L15;
        if (r2.checkCallingOrSelfPermission(f5.o(r3)) != 0) goto L15;
    L12:
        return false;
    }

    public static boolean D(Context r4, String r5) throws Throwable {
        if (((Integer) f4.e(r5, "getInt", new Object[]{r4.getContentResolver(), ((String) f4.d(r5, "AIRPLANE_MODE_ON")).toString()}, new Class[]{ContentResolver.class, String.class})).intValue() != 1) goto L5;
        return true;
    L5:
        return false;
    }

    public static byte F() throws NumberFormatException {
        return CastByteProtector.parseByte("1");
    }

    public static boolean G(Context r3) {
        if (r3 != null) goto L6;
        return true;
    L6:
        if (b != null) goto L22;
        b = (WifiManager) e(r3, "wifi");
    L22:
        if (A(r3, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF") == false) goto L12;
        boolean r4 = b.isWifiEnabled();     // Catch: Throwable -> L14
    L16:
        if (r4 == false) goto L18;
        return r4;
    L18:
        if (y() <= 17) goto L26;
        return "true".equals(String.valueOf(f4.c(b, "isScanAlwaysAvailable", new Object[0])));
    L27:
        return r4;
    L26:
        return r4;
    L12:
        c4.g(new Exception("n_aws"), "OPENSDK_UTS", "iwfal_n_aws");     // Catch: Throwable -> L14
    L15:
        r4 = false;
        goto L16
    }

    public static String I(Context r1) {
        if (c != null) goto L6;
        c = t3.a("MD5", v4.d(r1));
    L6:
        return c;
    }

    public static boolean L(Context r8) {
        int r1 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L32
        int r9 = r8.getApplicationInfo().targetSdkVersion;     // Catch: Throwable -> L32
        if (r1 != 30) goto L7;
        boolean r4 = true;
    L9:
        if (r9 < 23) goto L11;
        boolean r6 = true;
    L13:
        if (r1 != 31) goto L15;
        boolean r2 = true;
    L16:
        if (r9 > 30) goto L19;
        if (r9 < 23) goto L19;
        boolean r10 = true;
    L20:
        if (r4 == false) goto L23;
        if (r6 == false) goto L23;
        boolean r3 = true;
    L24:
        if (r2 == false) goto L27;
        if (r10 == false) goto L27;
        boolean r11 = true;
    L28:
        if (r3 == true) goto L30;
        if (r11 == true) goto L30;
        return false;
    L30:
        return true;
    L27:
        r11 = false;
    L23:
        r3 = false;
    L19:
        r10 = false;
        goto L20
    L15:
        r2 = false;
        goto L16
    L11:
        r6 = false;
        goto L13
    L7:
        r4 = false;
    L36:
        return false;
    }

    public static float a(AMapLocation r4, AMapLocation r5) {
        return c(new double[]{r4.getLatitude(), r4.getLongitude(), r5.getLatitude(), r5.getLongitude()});
    }

    public static float b(DPoint r4, DPoint r5) {
        return c(new double[]{r4.getLatitude(), r4.getLongitude(), r5.getLatitude(), r5.getLongitude()});
    }

    public static float c(double[] r12) {
        float[] r10 = new float[1];
        Location.distanceBetween(r12[0], r12[1], r12[2], r12[3], r10);
        return r10[0];
    }

    public static int d(NetworkInfo r2) {
        if (r2 != null) goto L6;
        return -1;
    L6:
        if (r2.isAvailable() == true) goto L9;
        return -1;
    L9:
        if (r2.isConnected() == true) goto L12;
        return -1;
    L12:
        return r2.getType();
    }

    public static Object e(Context r2, String r3) {
        if (r2 != null) goto L10;
        return null;
    L10:
        return r2.getApplicationContext().getSystemService(r3);
    L7:
        th = move-exception;
        c4.g(th, "Utils", "getServ");
        return null;
    }

    public static List<String> g(File r4) {
        ArrayList r0 = new ArrayList();
        BufferedReader r1 = null;
        PolarisFileInputStreamWrapper r5 = t(r4);     // Catch: Throwable -> L15
        InputStreamReader r2 = new InputStreamReader(r5, Charset.defaultCharset());     // Catch: Throwable -> L14
        BufferedReader r3 = new BufferedReader(r2);     // Catch: Throwable -> L13
    L32:
        String r6 = r3.readLine();     // Catch: Throwable -> L12
        if (r6 == null) goto L10;
        r0.add(r6);     // Catch: Throwable -> L12
        goto L32
    L10:
        r3.close();     // Catch: IOException -> L18
        r2.close();     // Catch: IOException -> L18
    L11:
        r5.close();     // Catch: IOException -> L18
    L25:
        return r0;
    L12:
        r1 = r3;
    L16:
        if (r1 == null) goto L20;
        r1.close();     // Catch: IOException -> L18
    L20:
        if (r2 == null) goto L22;
        r2.close();     // Catch: IOException -> L18
    L22:
        if (r5 == null) goto L25;
    L14:
        r2 = null;
    L15:
        r5 = null;
        r2 = null;
    L18:
        e = move-exception;
        e.printStackTrace();
        goto L25
    }

    public static void h(PolarisFileWrapper r1, String r2) {
        PolarisFileOutputStreamWrapper r0 = null;
        r0 = z(r1);     // Catch: Throwable -> L11 IOException -> L13
        if (r2 == null) goto L32;
        r0.write(r2.getBytes());     // Catch: Throwable -> L11 IOException -> L13
    L32:
        r0.close();     // Catch: IOException -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    L13:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L11
        if (r0 == null) goto L36;
        r0.close();     // Catch: IOException -> L18
        return;
    L18:
        e = move-exception;
        e.printStackTrace();
        return;
    L36:
        return;
    L11:
        th = move-exception;
        if (r0 != null) goto L34;
    L26:
        throw th;
    L34:
        r0.close();     // Catch: IOException -> L24
    L24:
        e = move-exception;
        e.printStackTrace();
        goto L26
    }

    public static boolean i(Context r3) {
        if (r3 != null) goto L12;
        return false;
    L12:
    L11:
        return false;
    L6:
        if (y() >= 17) goto L10;
        return D(r3, "android.provider.Settings$System");
    L10:
        return D(r3, "android.provider.Settings$Global");
    }

    public static boolean j(SQLiteDatabase r13) {
        boolean r2 = false;
        if (TextUtils.isEmpty("hist") == false) goto L5;
        return false;
    L5:
        String r1 = "2.0.201501131131".replace(".", NameKeys.UnloadStrategy_No_Strategy);
        if (r13 != null) goto L29;
    L26:
        return false;
    L29:
    L22:
        Cursor r14 = null;
    L23:
        if (r14 == null) goto L32;
        r14.close();
        return true;
    L32:
        return true;
    L9:
        if (r13.isOpen() == false) goto L26;
        r14 = r13.query("sqlite_master", new String[]{"count(*) as c"}, "type = 'table' AND name = 'hist" + r1 + "'", null, null, null, null);     // Catch: Throwable -> L22
        if (r14 != null) goto L27;
    L19:
        if (r14 == null) goto L31;
        r14.close();
    L31:
        return r2;
    L27:
        if (r14.moveToFirst() == false) goto L19;
        if (r14.getInt(0) <= 0) goto L19;
        r2 = true;
        goto L19
    }

    public static boolean k(Location r7, int r8) {
        boolean r1 = r7.isFromMockProvider();     // Catch: Throwable -> L5
    L7:
        if (r1 == false) goto L28;
        return true;
    L28:
        Bundle r2 = r7.getExtras();     // Catch: Throwable -> L25
        if (r2 == null) goto L12;
        int r3 = r2.getInt("satellites");     // Catch: Throwable -> L25
    L13:
        if (r3 > 0) goto L15;
        return true;
    L15:
        if (r8 != 0) goto L24;
        if (r7.getAltitude() != 0.0d) goto L24;
        if (r7.getBearing() != 0.0f) goto L24;
        if (r7.getSpeed() != 0.0f) goto L24;
        return true;
    L12:
        r3 = 0;
    L24:
        return false;
    L5:
        r1 = false;
        goto L7
    }

    public static boolean l(AMapLocation r2) {
        if (r2 != null) goto L6;
        return false;
    L6:
        if (r2.getErrorCode() == 0) goto L9;
        return false;
    L9:
        return w(r2);
    }

    public static boolean n(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L6;
        return false;
    L6:
        if ("00:00:00:00:00:00".equals(r2) == false) goto L8;
        return false;
    L8:
        if ("02:00:00:00:00:00".equals(r2) == false) goto L11;
        return false;
    L11:
        if (r2.contains(" :") == true) goto L18;
        return true;
    L18:
        return false;
    }

    public static boolean o(String r6, String r7) {
        if (TextUtils.isEmpty(r6) == false) goto L5;
    L22:
        return false;
    L5:
        if (TextUtils.isEmpty(r7) == true) goto L22;
        ArrayList<String> r8 = v(r6);
        String[] r9 = r7.toString().split("#");
        int r0 = 0;
        int r2 = 0;
        int r3 = 0;
    L9:
        if (r0 >= r9.length) goto L19;
        if (r9[r0].contains(",nb") == false) goto L13;
    L14:
        r2 = r2 + 1;
        if (r8.contains(r9[r0]) == false) goto L17;
        r3 = r3 + 1;
    L17:
        r0 = r0 + 1;
        goto L9
    L13:
        if (r9[r0].contains(",access") == false) goto L17;
    L19:
        if ((r3 * 2) < (((double) (r8.size() + r2)) * 0.618d)) goto L22;
        return true;
    }

    public static byte[] p(int r2, byte[] r3) {
        if (r3 != null) goto L5;
    L6:
        r3 = new byte[2];
    L7:
        r3[0] = (byte) (r2 & 255);
        r3[1] = (byte) ((r2 & 65280) >> 8);
        return r3;
    L5:
        if (r3.length >= 2) goto L7;
        goto L6
    }

    public static byte[] q(long r7) {
        byte[] r1 = new byte[8];
        int r2 = 0;
    L3:
        if (r2 >= 8) goto L5;
        r1[r2] = (byte) ((r7 >> (r2 * 8)) & 255);
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    public static String[] r(TelephonyManager r8) {
        if (r8 == null) goto L4;
        String r9 = r8.getNetworkOperator();
    L5:
        String[] r1 = {"0", "0"};
        if (TextUtils.isEmpty(r9) == false) goto L9;
    L7:
        boolean r2 = false;
    L15:
        if (r2 == false) goto L42;
        r1[0] = r9.substring(0, 3);
        char[] r5 = r9.substring(3).toCharArray();
        int r6 = 0;
    L18:
        if (r6 >= r5.length) goto L22;
        if (Character.isDigit(r5[r6]) == false) goto L22;
        r6 = r6 + 1;
    L22:
        r1[1] = r9.substring(3, r6 + 3);
    L42:
        int r10 = CastIntegerProtector.parseInt(r1[0]);     // Catch: Throwable -> L25
    L27:
        if (r10 != 0) goto L30;
        r1[0] = "0";
    L30:
        if ("0".equals(r1[0]) == true) goto L35;
        if ("0".equals(r1[1]) == true) goto L35;
        a = r1;
        return r1;
    L35:
        if ("0".equals(r1[0]) == true) goto L37;
        return r1;
    L37:
        if ("0".equals(r1[1]) == false) goto L48;
        String[] r11 = a;
        if (r11 != null) goto L41;
        return r1;
    L41:
        return r11;
    L48:
        return r1;
    L25:
        th = move-exception;
        c4.g(th, "Utils", "getMccMnc");
        r10 = 0;
        goto L27
    L9:
        if (TextUtils.isDigitsOnly(r9) == false) goto L7;
        if (r9.length() <= 4) goto L7;
        r2 = true;
        goto L15
    L4:
        r9 = null;
        goto L5
    }

    public static double s(double r2) {
        return ((long) (r2 * 1000000.0d)) / 1000000.0d;
    }

    public static PolarisFileInputStreamWrapper t(File r3) throws IOException {
        if (r3.exists() == false) goto L15;
        if (r3.isDirectory() == true) goto L13;
        if (r3.canRead() == false) goto L11;
        return new PolarisFileInputStreamWrapper(r3);
    L11:
        throw new IOException("File '" + r3 + "' cannot be read");
    L13:
        throw new IOException("File '" + r3 + "' exists but is a directory");
    L15:
        throw new FileNotFoundException("File '" + r3 + "' does not exist");
    }

    public static String u(Context r5) {
        if (TextUtils.isEmpty(c4.h) == true) goto L7;
        return c4.h;
    L7:
        if (r5 != null) goto L37;
        return null;
    L37:
        PackageInfo r2 = r5.getPackageManager().getPackageInfo(v4.d(r5), 64);     // Catch: Throwable -> L12
    L39:
        TextUtils.isEmpty(null);     // Catch: Throwable -> L16
    L18:
        StringBuilder r0 = new StringBuilder();
        if (r2 == null) goto L29;
        ApplicationInfo r3 = r2.applicationInfo;
        if (r3 == null) goto L23;
        CharSequence r4 = r3.loadLabel(r5.getPackageManager());
    L24:
        if (r4 == null) goto L27;
        r0.append(r4.toString());
    L27:
        if (TextUtils.isEmpty(r2.versionName) == true) goto L29;
        r0.append(r2.versionName);
        goto L29
    L23:
        r4 = null;
    L29:
        String r6 = v4.d(r5);
        if (TextUtils.isEmpty(r6) == true) goto L33;
        r0.append(",");
        r0.append(r6);
    L33:
        if (TextUtils.isEmpty(null) == true) goto L35;
        r0.append(",null");
    L35:
        String r7 = r0.toString();
        c4.h = r7;
        return r7;
    L16:
        th = move-exception;
        c4.g(th, "Utils", "getAppName");
    L12:
        th = move-exception;
        c4.g(th, "Utils", "getAppName part");
        r2 = null;
        goto L39
    }

    public static ArrayList<String> v(String r4) {
        ArrayList<String> r0 = new ArrayList();
        if (TextUtils.isEmpty(r4) == true) goto L13;
        String[] r5 = r4.split("#");
        int r1 = 0;
    L6:
        if (r1 >= r5.length) goto L13;
        if (r5[r1].contains(",nb") == false) goto L10;
    L11:
        r0.add(r5[r1]);
    L12:
        r1 = r1 + 1;
        goto L6
    L10:
        if (r5[r1].contains(",access") == false) goto L12;
    L13:
        return r0;
    }

    public static boolean w(AMapLocation r7) {
        double r0 = r7.getLongitude();
        double r2 = r7.getLatitude();
        if (r0 != 0.0d) goto L8;
        if (r2 != 0.0d) goto L8;
        return false;
    L8:
        if (r0 <= 180.0d) goto L10;
        return false;
    L10:
        if (r2 <= 90.0d) goto L13;
        return false;
    L13:
        if (r0 >= (-180.0d)) goto L15;
        return false;
    L15:
        if (r2 < (-90.0d)) goto L22;
        return true;
    L22:
        return false;
    }

    public static byte[] x(int r2, byte[] r3) {
        if (r3 != null) goto L5;
    L6:
        r3 = new byte[4];
    L7:
        int r0 = 0;
    L9:
        if (r0 >= r3.length) goto L11;
        r3[r0] = (byte) ((r2 >> (r0 * 8)) & 255);
        r0 = r0 + 1;
        goto L9
    L11:
        return r3;
    L5:
        if (r3.length >= 4) goto L7;
        goto L6
    }

    public static PolarisFileOutputStreamWrapper z(PolarisFileWrapper r3) throws IOException {
        if (r3.exists() == true) goto L5;
        File r0 = r3.getParentFile();
        if (r0 != null) goto L16;
    L24:
        return new PolarisFileOutputStreamWrapper(r3, false);
    L16:
        if (r0.mkdirs() == false) goto L18;
    L22:
        r3.createNewFile();
        goto L24
    L18:
        if (r0.isDirectory() == true) goto L22;
        throw new IOException("Directory '" + r0 + "' could not be created");
    L5:
        if (r3.isDirectory() == true) goto L12;
        if (r3.canWrite() == true) goto L24;
        throw new IOException("File '" + r3 + "' cannot be written to");
    L12:
        throw new IOException("File '" + r3 + "' exists but is a directory");
    }

    public static int y() {
        return ((Integer) f4.d("android.os.Build$VERSION", "SDK_INT")).intValue();
    L5:
        return CastIntegerProtector.parseInt(f4.d("android.os.Build$VERSION", "SDK").toString());
    L7:
        return 0;
    }

    public static boolean E(Context r5) {
        if (r5.getApplicationInfo().targetSdkVersion >= 29) goto L5;
        return true;
    L5:
        if (Build.VERSION.SDK_INT >= 29) goto L13;
        return true;
    L13:
        Context r6 = ((Application) r5).getBaseContext();     // Catch: Throwable -> L9
        String[] r4 = b3.M;     // Catch: Throwable -> L9
        int r7 = ((Integer) f4.c(r6, "checkSelfPermission", new Object[]{"android.permission.ACCESS_BACKGROUND_LOCATION"})).intValue();     // Catch: Throwable -> L9
    L10:
        if (r7 == 0) goto L17;
        return false;
    L17:
        return true;
    L9:
        r7 = 0;
        goto L10
    }

    public static String H(Context r2) {
        NetworkInfo r3 = x4.s(r2);     // Catch: Throwable -> L4
    L6:
        if (r3 != null) goto L8;
        return "DISCONNECTED";
    L8:
        if (r3.isConnectedOrConnecting() == false) goto L41;
        int r0 = r3.getType();
        if (r0 != 1) goto L13;
        return "WIFI";
    L13:
        if (r0 != 0) goto L30;
        String r1 = r3.getSubtypeName();
        switch(r3.getSubtype()) {
            case 1: goto L20;
            case 2: goto L20;
            case 3: goto L29;
            case 4: goto L20;
            case 5: goto L29;
            case 6: goto L29;
            case 7: goto L20;
            case 8: goto L29;
            case 9: goto L29;
            case 10: goto L29;
            case 11: goto L20;
            case 12: goto L29;
            case 13: goto L19;
            case 14: goto L29;
            case 15: goto L29;
            case 16: goto L20;
            case 17: goto L29;
            default: goto L17;
        };
    L19:
        return "4G";
    L20:
        return "2G";
    L29:
        return "3G";
    L17:
        if ("GSM".equalsIgnoreCase(r1) == true) goto L20;
        if ("TD-SCDMA".equalsIgnoreCase(r1) == true) goto L29;
        if ("WCDMA".equalsIgnoreCase(r1) == true) goto L29;
        if ("CDMA2000".equalsIgnoreCase(r1) == true) goto L29;
        return r1;
    L30:
        return "UNKNOWN";
    L41:
        return "DISCONNECTED";
    L4:
        th = move-exception;
        c4.g(th, "Utils", "getNetWorkInfo");
        r3 = null;
        goto L6
    }

    public static boolean J(Context r5) {
        boolean r0 = true;
        if (Build.VERSION.SDK_INT < 31) goto L12;
        if (r5 == null) goto L12;
        if (C(r5, "android.permission.ACCESS_FINE_LOCATION") == 0) goto L12;
        if (C(r5, "android.permission.ACCESS_COARSE_LOCATION") != 0) goto L12;
        boolean r2 = true;
    L13:
        if (r2 == true) goto L47;
        if (K(r5) == true) goto L47;
        String r3 = Build.MANUFACTURER;     // Catch: Throwable -> L48
        String r4 = Build.BRAND;     // Catch: Throwable -> L48
        if (r3.equalsIgnoreCase("huawei") == true) goto L21;
        if (r4.toLowerCase().contains("huawei") == false) goto L22;
    L21:
        boolean r6 = true;
    L23:
        if (r6 == false) goto L42;
        if (L(r5) == false) goto L42;
        if (Build.VERSION.SDK_INT < 23) goto L34;
        if (r5 != null) goto L32;
    L50:
        goto L39
    L32:
        if (C(r5, "com.huawei.permission.ACCESS_APPROXIMATELY_LOCATION") != 0) goto L50;
    L37:
        boolean r7 = true;
    L40:
        if (r7 == false) goto L42;
        boolean r8 = true;
    L43:
        if (r8 == true) goto L47;
        r0 = false;
        goto L47
    L34:
        if (r5 == null) goto L50;
        if (r5.checkCallingOrSelfPermission("com.huawei.permission.ACCESS_APPROXIMATELY_LOCATION") != 0) goto L50;
    L39:
        r7 = false;
    L42:
        r8 = false;
    L22:
        r6 = false;
    L59:
        return false;
    L47:
        return r0;
    L12:
        r2 = false;
        goto L13
    }

    public static boolean K(Context r6) {
        String r3 = Build.MANUFACTURER;     // Catch: Throwable -> L31
        String r4 = Build.BRAND;     // Catch: Throwable -> L31
        if (r3.equalsIgnoreCase("vivo") == true) goto L7;
        if (r4.toLowerCase().contains("vivo") == false) goto L8;
    L7:
        boolean r0 = true;
    L9:
        if (r0 == true) goto L11;
    L30:
        return false;
    L11:
        if (L(r6) == false) goto L30;
        Cursor r7 = B(r6.getContentResolver(), Uri.parse("content://com.vivo.permissionmanager.provider.permission/fuzzy_location_apps"), new String[]{"package_name", "selected_fuzzy"}, new String[]{r6.getPackageName()});     // Catch: Throwable -> L25
        boolean r1 = false;
    L14:
        if (r7 == null) goto L23;
        if (r7.moveToNext() == false) goto L23;
        if (r7.getString(0) == null) goto L14;
        if (r7.getInt(1) != 1) goto L14;
        r1 = true;
    L26:
        if (r7 == null) goto L28;
    L27:
        r7.close();
    L28:
        if (r1 == false) goto L30;
        return true;
    L23:
        if (r7 == null) goto L28;
    L25:
        r7 = null;
        r1 = false;
    L8:
        r0 = false;
        goto L9
    }

    public static boolean m(es r3) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if ("8".equals(r3.N) == false) goto L9;
        return false;
    L9:
        if ("5".equals(r3.N) == false) goto L12;
        return false;
    L12:
        if ("6".equals(r3.N) == false) goto L15;
        return false;
    L15:
        return w(r3);
    }

    public static int C(Context r18, String r19) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19};
        f06.b r11 = new f06.b("auto_cert_com_loc_fy_android_content_Context_checkSelfPermission");
        g06.a r2 = (g06.a) ApiHookConfig.b.get(102608);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        f06.d r4 = r7.preInvoke(102608, "android/content/Context", "checkSelfPermission", r18, r1, "int", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return ((Integer) r4.b).intValue();
    L21:
        return r18.checkSelfPermission(r19);
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    public static String f(long r3, String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L23;
        r5 = "yyyy-MM-dd HH:mm:ss";
    L23:
        SimpleDateFormat r0 = new SimpleDateFormat(r5, Locale.CHINA);     // Catch: Throwable -> L10
        r0.applyPattern(r5);     // Catch: Throwable -> L8
    L14:
        if (r3 > 0) goto L16;
        r3 = System.currentTimeMillis();
    L16:
        if (r0 != null) goto L20;
        return "NULL";
    L20:
        return r0.format(Long.valueOf(r3));
    L8:
        th = th;
    L12:
        c4.g(th, "Utils", "formatUTC");
    L10:
        th = th;
        r0 = null;
        goto L12
    }

    public static Cursor B(ContentResolver r15, Uri r16, String[] r17, String[] r18) {
        f06.c r12 = new f06.c();
        Object[] r13 = {r16, r17, "package_name=?", r18, null};
        f06.b r14 = new f06.b();
        f06.d r0 = r12.b(240004, "android/content/ContentResolver", "query", r15, r13, "android.database.Cursor", r14);
        if (r0.a == false) goto L6;
        r12.a(240004, "android/content/ContentResolver", "query", r15, r13, null, r14, false);
        return (Cursor) r0.b;
    L6:
        Cursor r1 = r15.query(r16, r17, "package_name=?", r18, null);
        r12.a(240004, "android/content/ContentResolver", "query", r15, r13, r1, r14, true);
        return r1;
    }
}
