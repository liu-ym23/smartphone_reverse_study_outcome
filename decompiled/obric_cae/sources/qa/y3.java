package qa;

import android.annotation.SuppressLint;
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
import com.bytedance.bdlocation.utils.DimLocationCheckUtil;
import com.loc.es;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class y3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String[] f11242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static WifiManager f11243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f11244c;

    public static boolean A(Context r8) {
        if (r8.getApplicationInfo().targetSdkVersion >= 29) goto L11;
        return true;
    L11:
        int r10 = ((Integer) l6.a.g(((Application) r8).getBaseContext(), "checkSelfPermission", new Object[]{"android.permission.ACCESS_BACKGROUND_LOCATION"})).intValue();     // Catch: Throwable -> L7
    L8:
        if (r10 != 0) goto L10;
        return true;
    L10:
        return false;
    L7:
        r10 = 0;
        goto L8
    }

    public static byte B() {
        return Byte.parseByte("1");
    }

    @SuppressLint({"NewApi"})
    public static boolean C(Context r8) {
        if (r8 != null) goto L6;
        return true;
    L6:
        if (f11243b != null) goto L21;
        f11243b = (WifiManager) d(r8, "wifi");
    L21:
        if (y(r8, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF") == false) goto L12;
        boolean r10 = f11243b.isWifiEnabled();     // Catch: Throwable -> L20
    L14:
        if (r10 == false) goto L16;
        return r10;
    L16:
        if (w() <= 17) goto L25;
        return "true".equals(String.valueOf(l6.a.g(f11243b, "isScanAlwaysAvailable", new Object[0])));
    L26:
        return r10;
    L25:
        return r10;
    L12:
        t3.g("OPENSDK_UTS", "iwfal_n_aws", new Exception("n_aws"));     // Catch: Throwable -> L20
    L13:
        r10 = false;
        goto L14
    }

    public static String D(Context r8) {
        NetworkInfo r10 = k4.o(r8);     // Catch: Throwable -> L4
    L6:
        if (r10 != null) goto L8;
        return "DISCONNECTED";
    L8:
        if (r10.isConnectedOrConnecting() == false) goto L41;
        int r11 = r10.getType();
        if (r11 != 1) goto L13;
        return "WIFI";
    L13:
        if (r11 != 0) goto L30;
        String r12 = r10.getSubtypeName();
        switch(r10.getSubtype()) {
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
        if ("GSM".equalsIgnoreCase(r12) == true) goto L20;
        if ("TD-SCDMA".equalsIgnoreCase(r12) == true) goto L29;
        if ("WCDMA".equalsIgnoreCase(r12) == true) goto L29;
        if ("CDMA2000".equalsIgnoreCase(r12) == true) goto L29;
        return r12;
    L30:
        return BdimCategoryConstants.VALUE_UNKNOWN;
    L41:
        return "DISCONNECTED";
    L4:
        th = move-exception;
        t3.g("Utils", "getNetWorkInfo", th);
        r10 = null;
        goto L6
    }

    public static String E(Context r8) {
        if (f11244c != null) goto L6;
        f11244c = h3.a("MD5", h4.d(r8));
    L6:
        return f11244c;
    }

    public static boolean F(Context r8) {
        boolean r10 = true;
        if (r8 != null) goto L40;
    L9:
        boolean r11 = false;
    L10:
        if (r11 == true) goto L35;
        if (G(r8) == true) goto L35;
        String r12 = Build.MANUFACTURER;     // Catch: Throwable -> L37
        String r13 = Build.BRAND;     // Catch: Throwable -> L37
        if (r12.equalsIgnoreCase("huawei") == true) goto L18;
        if (r13.toLowerCase().contains("huawei") == false) goto L19;
    L18:
        boolean r14 = true;
    L20:
        if (r14 == false) goto L30;
        if (H(r8) == false) goto L30;
        if (r8 != null) goto L46;
    L27:
        boolean r15 = false;
    L28:
        if (r15 == false) goto L30;
        boolean r16 = true;
    L31:
        if (r16 == true) goto L35;
        r10 = false;
        goto L35
    L46:
        if (r8.checkSelfPermission("com.huawei.permission.ACCESS_APPROXIMATELY_LOCATION") != 0) goto L27;
        r15 = true;
    L30:
        r16 = false;
    L19:
        r14 = false;
    L48:
        return false;
    L35:
        return r10;
    L40:
        if (r8.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) goto L9;
        if (r8.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0) goto L9;
        r11 = true;
        goto L10
    }

    public static boolean G(Context r10) {
        String r8 = Build.MANUFACTURER;     // Catch: Throwable -> L31
        String r11 = Build.BRAND;     // Catch: Throwable -> L31
        if (r8.equalsIgnoreCase(DimLocationCheckUtil.VIVO) == true) goto L7;
        if (r11.toLowerCase().contains(DimLocationCheckUtil.VIVO) == false) goto L8;
    L7:
        boolean r12 = true;
    L9:
        if (r12 == true) goto L11;
    L29:
        return false;
    L11:
        if (H(r10) == false) goto L29;
        Cursor r13 = r10.getContentResolver().query(Uri.parse("content://com.vivo.permissionmanager.provider.permission/fuzzy_location_apps"), new String[]{"package_name", "selected_fuzzy"}, "package_name=?", new String[]{r10.getPackageName()}, null);     // Catch: Throwable -> L24
        boolean r14 = false;
    L14:
        if (r13 == null) goto L22;
        if (r13.moveToNext() == false) goto L22;
        if (r13.getString(0) == null) goto L14;
        if (r13.getInt(1) != 1) goto L14;
        r14 = true;
    L25:
        if (r13 == null) goto L27;
    L26:
        r13.close();
    L27:
        if (r14 == false) goto L29;
        return true;
    L22:
        if (r13 == null) goto L27;
    L24:
        r13 = null;
        r14 = false;
    L8:
        r12 = false;
        goto L9
    }

    public static boolean H(Context r8) {
        int r10 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L21
        int r11 = r8.getApplicationInfo().targetSdkVersion;     // Catch: Throwable -> L21
        if (r10 != 31) goto L7;
        boolean r12 = true;
    L9:
        if (r11 <= 30) goto L11;
    L13:
        boolean r13 = false;
    L14:
        if (r12 == false) goto L17;
        if (r13 == false) goto L17;
        boolean r14 = true;
    L18:
        if (r14 == true) goto L20;
        return false;
    L20:
        return true;
    L17:
        r14 = false;
        goto L18
    L11:
        if (r11 < 23) goto L13;
        r13 = true;
        goto L14
    L7:
        r12 = false;
    L25:
        return false;
    }

    public static float a(AMapLocation r8, AMapLocation r10) {
        return b(new double[]{r8.getLatitude(), r8.getLongitude(), r10.getLatitude(), r10.getLongitude()});
    }

    public static float b(double[] r12) {
        float[] r10 = new float[1];
        Location.distanceBetween(r12[0], r12[1], r12[2], r12[3], r10);
        return r10[0];
    }

    public static int c(NetworkInfo r8) {
        if (r8 != null) goto L6;
        return -1;
    L6:
        if (r8.isAvailable() == true) goto L9;
        return -1;
    L9:
        if (r8.isConnected() == true) goto L12;
        return -1;
    L12:
        return r8.getType();
    }

    public static Object d(Context r8, String r10) {
        if (r8 != null) goto L10;
        return null;
    L10:
        return r8.getApplicationContext().getSystemService(r10);
    L7:
        th = move-exception;
        t3.g("Utils", "getServ", th);
        return null;
    }

    public static String e(long r8, String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L23;
        r10 = "yyyy-MM-dd HH:mm:ss";
    L23:
        SimpleDateFormat r11 = new SimpleDateFormat(r10, Locale.CHINA);     // Catch: Throwable -> L10
        r11.applyPattern(r10);     // Catch: Throwable -> L8
    L14:
        if (r8 > 0) goto L16;
        r8 = System.currentTimeMillis();
    L16:
        if (r11 != null) goto L20;
        return "NULL";
    L20:
        return r11.format(Long.valueOf(r8));
    L8:
        th = th;
    L12:
        t3.g("Utils", "formatUTC", th);
    L10:
        th = th;
        r11 = null;
        goto L12
    }

    public static ArrayList f(File r8) {
        ArrayList r10 = new ArrayList();
        BufferedReader r11 = null;
        FileInputStream r12 = r(r8);     // Catch: Throwable -> L14
        InputStreamReader r13 = new InputStreamReader(r12, Charset.defaultCharset());     // Catch: Throwable -> L13
        BufferedReader r14 = new BufferedReader(r13);     // Catch: Throwable -> L25
    L32:
        String r15 = r14.readLine();     // Catch: Throwable -> L12
        if (r15 == null) goto L10;
        r10.add(r15);     // Catch: Throwable -> L12
        goto L32
    L10:
        r14.close();     // Catch: IOException -> L17
        r13.close();     // Catch: IOException -> L17
    L11:
        r12.close();     // Catch: IOException -> L17
    L24:
        return r10;
    L12:
        r11 = r14;
    L15:
        if (r11 == null) goto L19;
        r11.close();     // Catch: IOException -> L17
    L19:
        if (r13 == null) goto L21;
        r13.close();     // Catch: IOException -> L17
    L21:
        if (r12 == null) goto L24;
    L13:
        r13 = null;
    L14:
        r12 = null;
        r13 = null;
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L24
    }

    public static void g(File r8, String r10) {
        FileOutputStream r11 = null;
        r11 = x(r8);     // Catch: Throwable -> L11 IOException -> L13
        if (r10 == null) goto L32;
        r11.write(r10.getBytes());     // Catch: Throwable -> L11 IOException -> L13
    L32:
        r11.close();     // Catch: IOException -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    L13:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L11
        if (r11 == null) goto L36;
        r11.close();     // Catch: IOException -> L18
        return;
    L18:
        e = move-exception;
        e.printStackTrace();
        return;
    L36:
        return;
    L11:
        th = move-exception;
        if (r11 != null) goto L34;
    L26:
        throw th;
    L34:
        r11.close();     // Catch: IOException -> L24
    L24:
        e = move-exception;
        e.printStackTrace();
        goto L26
    }

    public static boolean h(Context r8) {
        if (r8 != null) goto L12;
        return false;
    L12:
    L11:
        return false;
    L6:
        if (w() >= 17) goto L10;
        return z(r8, "android.provider.Settings$System");
    L10:
        return z(r8, "android.provider.Settings$Global");
    }

    public static boolean i(SQLiteDatabase r13) {
        boolean r8 = false;
        if (TextUtils.isEmpty("hist") == false) goto L5;
        return false;
    L5:
        String r10 = "2.0.201501131131".replace(".", "");
        if (r13 != null) goto L27;
    L25:
        return false;
    L27:
    L21:
        Cursor r14 = null;
    L22:
        if (r14 == null) goto L32;
        r14.close();
        return true;
    L32:
        return true;
    L9:
        if (r13.isOpen() == false) goto L25;
        r14 = r13.query("sqlite_master", new String[]{"count(*) as c"}, "type = 'table' AND name = 'hist" + r10 + "'", null, null, null, null);     // Catch: Throwable -> L21
        if (r14 != null) goto L29;
    L18:
        if (r14 == null) goto L31;
        r14.close();
    L31:
        return r8;
    L29:
        if (r14.moveToFirst() == false) goto L18;
        if (r14.getInt(0) <= 0) goto L18;
        r8 = true;
        goto L18
    }

    public static boolean j(Location r8, int r10) {
        boolean r11 = r8.isFromMockProvider();     // Catch: Throwable -> L5
    L7:
        if (r11 == false) goto L28;
        return true;
    L28:
        Bundle r12 = r8.getExtras();     // Catch: Throwable -> L25
        if (r12 == null) goto L12;
        int r13 = r12.getInt("satellites");     // Catch: Throwable -> L25
    L13:
        if (r13 > 0) goto L15;
        return true;
    L15:
        if (r10 != 0) goto L24;
        if (r8.getAltitude() != 0.0d) goto L24;
        if (r8.getBearing() != 0.0f) goto L24;
        if (r8.getSpeed() != 0.0f) goto L24;
        return true;
    L12:
        r13 = 0;
    L24:
        return false;
    L5:
        r11 = false;
        goto L7
    }

    public static boolean k(AMapLocation r8) {
        if (r8 != null) goto L6;
        return false;
    L6:
        if (r8.f3646w == 0) goto L9;
        return false;
    L9:
        return u(r8);
    }

    public static boolean l(es r8) {
        if (r8 != null) goto L6;
        return false;
    L6:
        if ("8".equals(r8.X) == false) goto L9;
        return false;
    L9:
        if ("5".equals(r8.X) == false) goto L12;
        return false;
    L12:
        if ("6".equals(r8.X) == false) goto L15;
        return false;
    L15:
        return u(r8);
    }

    public static boolean m(String r8) {
        if (TextUtils.isEmpty(r8) == false) goto L6;
        return false;
    L6:
        if ("00:00:00:00:00:00".equals(r8) == false) goto L8;
        return false;
    L8:
        if ("02:00:00:00:00:00".equals(r8) == false) goto L11;
        return false;
    L11:
        if (r8.contains(" :") == true) goto L18;
        return true;
    L18:
        return false;
    }

    public static boolean n(String r8, String r10) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
    L22:
        return false;
    L5:
        if (TextUtils.isEmpty(r10) == true) goto L22;
        ArrayList<String> r11 = t(r8);
        String[] r12 = r10.toString().split("#");
        int r13 = 0;
        int r14 = 0;
        int r15 = 0;
    L9:
        if (r13 >= r12.length) goto L19;
        if (r12[r13].contains(",nb") == false) goto L13;
    L14:
        r14 = r14 + 1;
        if (r11.contains(r12[r13]) == false) goto L17;
        r15 = r15 + 1;
    L17:
        r13 = r13 + 1;
        goto L9
    L13:
        if (r12[r13].contains(",access") == false) goto L17;
    L19:
        if ((r15 * 2) < (((double) (r11.size() + r14)) * 0.618d)) goto L22;
        return true;
    }

    public static byte[] o(int r8, byte[] r10) {
        if (r10 != null) goto L5;
    L6:
        r10 = new byte[2];
    L7:
        r10[0] = (byte) (r8 & 255);
        r10[1] = (byte) ((r8 & 65280) >> 8);
        return r10;
    L5:
        if (r10.length >= 2) goto L7;
        goto L6
    }

    public static byte[] p(long r8) {
        byte[] r10 = new byte[8];
        int r11 = 0;
    L3:
        if (r11 >= 8) goto L5;
        r10[r11] = (byte) ((r8 >> (r11 * 8)) & 255);
        r11 = r11 + 1;
        goto L3
    L5:
        return r10;
    }

    public static String[] q(TelephonyManager r8) {
        if (r8 == null) goto L4;
        String r10 = r8.getNetworkOperator();
    L5:
        String[] r11 = {"0", "0"};
        if (TextUtils.isEmpty(r10) == false) goto L9;
    L7:
        boolean r12 = false;
    L15:
        if (r12 == false) goto L42;
        r11[0] = r10.substring(0, 3);
        char[] r13 = r10.substring(3).toCharArray();
        int r14 = 0;
    L18:
        if (r14 >= r13.length) goto L22;
        if (Character.isDigit(r13[r14]) == false) goto L22;
        r14 = r14 + 1;
    L22:
        r11[1] = r10.substring(3, r14 + 3);
    L42:
        int r15 = Integer.parseInt(r11[0]);     // Catch: Throwable -> L25
    L27:
        if (r15 != 0) goto L30;
        r11[0] = "0";
    L30:
        if ("0".equals(r11[0]) == true) goto L35;
        if ("0".equals(r11[1]) == true) goto L35;
        f11242a = r11;
        return r11;
    L35:
        if ("0".equals(r11[0]) == true) goto L37;
        return r11;
    L37:
        if ("0".equals(r11[1]) == false) goto L48;
        String[] r16 = f11242a;
        if (r16 != null) goto L41;
        return r11;
    L41:
        return r16;
    L48:
        return r11;
    L25:
        th = move-exception;
        t3.g("Utils", "getMccMnc", th);
        r15 = 0;
        goto L27
    L9:
        if (TextUtils.isDigitsOnly(r10) == false) goto L7;
        if (r10.length() <= 4) goto L7;
        r12 = true;
        goto L15
    L4:
        r10 = null;
        goto L5
    }

    public static FileInputStream r(File r8) {
        if (r8.exists() == false) goto L15;
        if (r8.isDirectory() == true) goto L13;
        if (r8.canRead() == false) goto L11;
        return new FileInputStream(r8);
    L11:
        throw new IOException("File '" + r8 + "' cannot be read");
    L13:
        throw new IOException("File '" + r8 + "' exists but is a directory");
    L15:
        throw new FileNotFoundException("File '" + r8 + "' does not exist");
    }

    public static String s(Context r8) {
        if (TextUtils.isEmpty(t3.f11121h) == true) goto L7;
        return t3.f11121h;
    L7:
        if (r8 != null) goto L37;
        return null;
    L37:
        PackageInfo r10 = r8.getPackageManager().getPackageInfo(h4.d(r8), 64);     // Catch: Throwable -> L12
    L39:
        TextUtils.isEmpty(null);     // Catch: Throwable -> L16
    L18:
        StringBuilder r11 = new StringBuilder();
        if (r10 == null) goto L29;
        ApplicationInfo r12 = r10.applicationInfo;
        if (r12 == null) goto L23;
        CharSequence r13 = r12.loadLabel(r8.getPackageManager());
    L24:
        if (r13 == null) goto L27;
        r11.append(r13.toString());
    L27:
        if (TextUtils.isEmpty(r10.versionName) == true) goto L29;
        r11.append(r10.versionName);
        goto L29
    L23:
        r13 = null;
    L29:
        String r14 = h4.d(r8);
        if (TextUtils.isEmpty(r14) == true) goto L33;
        r11.append(",");
        r11.append(r14);
    L33:
        if (TextUtils.isEmpty(null) == true) goto L35;
        r11.append(",null");
    L35:
        String r15 = r11.toString();
        t3.f11121h = r15;
        return r15;
    L16:
        th = move-exception;
        t3.g("Utils", "getAppName", th);
    L12:
        th = move-exception;
        t3.g("Utils", "getAppName part", th);
        r10 = null;
        goto L39
    }

    public static ArrayList<String> t(String r8) {
        ArrayList<String> r10 = new ArrayList();
        if (TextUtils.isEmpty(r8) == true) goto L13;
        String[] r11 = r8.split("#");
        int r12 = 0;
    L6:
        if (r12 >= r11.length) goto L13;
        if (r11[r12].contains(",nb") == false) goto L10;
    L11:
        r10.add(r11[r12]);
    L12:
        r12 = r12 + 1;
        goto L6
    L10:
        if (r11[r12].contains(",access") == false) goto L12;
    L13:
        return r10;
    }

    public static boolean u(AMapLocation r8) {
        double r10 = r8.getLongitude();
        double r11 = r8.getLatitude();
        if (r10 != 0.0d) goto L8;
        if (r11 != 0.0d) goto L8;
        return false;
    L8:
        if (r10 <= 180.0d) goto L10;
    L19:
        return false;
    L10:
        if (r11 > 90.0d) goto L19;
        if (r10 < (-180.0d)) goto L19;
        if (r11 < (-90.0d)) goto L19;
        return true;
    }

    public static byte[] v(int r8, byte[] r10) {
        if (r10 != null) goto L5;
    L6:
        r10 = new byte[4];
    L7:
        int r11 = 0;
    L9:
        if (r11 >= r10.length) goto L11;
        r10[r11] = (byte) ((r8 >> (r11 * 8)) & 255);
        r11 = r11 + 1;
        goto L9
    L11:
        return r10;
    L5:
        if (r10.length >= 4) goto L7;
        goto L6
    }

    public static int w() {
        return ((Integer) l6.a.h("android.os.Build$VERSION", "SDK_INT")).intValue();
    L5:
        return Integer.parseInt(l6.a.h("android.os.Build$VERSION", "SDK").toString());
    L7:
        return 0;
    }

    public static FileOutputStream x(File r8) {
        if (r8.exists() == true) goto L5;
        File r10 = r8.getParentFile();
        if (r10 != null) goto L16;
    L24:
        return new FileOutputStream(r8, false);
    L16:
        if (r10.mkdirs() == false) goto L18;
    L22:
        r8.createNewFile();
        goto L24
    L18:
        if (r10.isDirectory() == true) goto L22;
        throw new IOException("Directory '" + r10 + "' could not be created");
    L5:
        if (r8.isDirectory() == true) goto L12;
        if (r8.canWrite() == true) goto L24;
        throw new IOException("File '" + r8 + "' cannot be written to");
    L12:
        throw new IOException("File '" + r8 + "' exists but is a directory");
    }

    public static boolean y(Context r8, String r10) {
        if (r8 != null) goto L9;
    L6:
        return false;
    L9:
        if (r8.checkSelfPermission(t4.n(r10)) != 0) goto L6;
        return true;
    }

    public static boolean z(Context r8, String r10) {
        if (((Integer) l6.a.i(r10, "getInt", new Object[]{r8.getContentResolver(), ((String) l6.a.h(r10, "AIRPLANE_MODE_ON")).toString()}, new Class[]{ContentResolver.class, String.class})).intValue() != 1) goto L5;
        return true;
    L5:
        return false;
    }
}
