package qa;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.loc.em;
import com.obric.cae.cloud.CloudServiceConstants;
import java.util.ArrayList;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class w3 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ArrayList f11182g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static JSONArray f11183h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static AMapLocation f11184i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static boolean f11185j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray<Long> f11186a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f11187b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f11188c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String[] f11189d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f11190e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f11191f;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11192a = null;

        static {
            int[] r8 = new int[AMapLocationClientOption.b.values().length];
            f11192a = r8;
            AMapLocationClientOption.b r10 = AMapLocationClientOption.b.f3666a;     // Catch: NoSuchFieldError -> L8
            r8[0] = 1;     // Catch: NoSuchFieldError -> L8
        L15:
            int[] r11 = f11192a;     // Catch: NoSuchFieldError -> L9
            AMapLocationClientOption.b r12 = AMapLocationClientOption.b.f3666a;     // Catch: NoSuchFieldError -> L9
            r11[1] = 2;     // Catch: NoSuchFieldError -> L9
        L11:
            int[] r13 = f11192a;     // Catch: NoSuchFieldError -> L10
            AMapLocationClientOption.b r14 = AMapLocationClientOption.b.f3666a;     // Catch: NoSuchFieldError -> L10
            r13[2] = 3;     // Catch: NoSuchFieldError -> L10
            return;
        }
    }

    static {
        f11182g = new ArrayList();
        f11183h = null;
        f11184i = null;
        f11185j = false;
    }

    public w3() {
        this.f11186a = new SparseArray();
        this.f11187b = -1;
        this.f11188c = 0;
        this.f11189d = new String[]{"ol", "cl", "gl", "ha", "bs", "ds"};
        this.f11190e = -1;
        this.f11191f = -1;
    }

    public static void a(int r8, String r10) {
        String r11 = String.valueOf(r8);
        if (r8 != 2011) goto L5;
        String r12 = "ContextIsNull";
    L57:
        String r13 = r12;
        q.d(t3.j(), "/mobile/binary", r13, r10, "", r11);     // Catch: Throwable -> L60
        return;
    L63:
        return;
    L5:
        if (r8 != 2031) goto L7;
        r12 = "CreateApsReqException";
        goto L57
    L7:
        if (r8 != 2041) goto L9;
        r12 = "ResponseResultIsNull";
        goto L57
    L9:
        if (r8 != 2081) goto L11;
        r12 = "LocalLocException";
        goto L57
    L11:
        if (r8 != 2091) goto L13;
        r12 = "InitException";
        goto L57
    L13:
        if (r8 != 2111) goto L15;
        r12 = "ErrorCgiInfo";
        goto L57
    L15:
        if (r8 != 2121) goto L17;
        r12 = "NotLocPermission";
        goto L57
    L17:
        if (r8 != 2141) goto L19;
        r12 = "NoEnoughStatellites";
        goto L57
    L19:
        if (r8 != 2021) goto L21;
        r12 = "OnlyMainWifi";
        goto L57
    L21:
        if (r8 != 2022) goto L23;
        r12 = "OnlyOneWifiButNotMain";
        goto L57
    L23:
        if (r8 != 2061) goto L25;
        r12 = "ServerRetypeError";
        goto L57
    L25:
        if (r8 == 2062) goto L45;
        switch(r8) {
            case 2051: goto L34;
            case 2052: goto L33;
            case 2053: goto L32;
            case 2054: goto L31;
            default: goto L27;
        };
    L27:
        switch(r8) {
            case 2101: goto L37;
            case 2102: goto L36;
            case 2103: goto L35;
            default: goto L28;
        };
    L28:
        switch(r8) {
            case 2131: goto L40;
            case 2132: goto L39;
            case 2133: goto L38;
            default: goto L29;
        };
    L29:
        switch(r8) {
            case 2151: goto L44;
            case 2152: goto L43;
            case 2153: goto L42;
            case 2154: goto L41;
            default: goto L30;
        };
    L30:
        r12 = "";
        goto L57
    L41:
        r12 = "UNSUPPORT_CONTINUE_LOC";
        goto L57
    L42:
        r12 = "UNSUPPORT_COARSE_LBSLOC";
        goto L57
    L43:
        r12 = "MaybeMockGPSLoc";
        goto L57
    L44:
        r12 = "MaybeMockNetLoc";
        goto L57
    L38:
        r12 = "NoCgiAndWifiOff";
        goto L57
    L39:
        r12 = "AirPlaneModeAndWifiOff";
        goto L57
    L40:
        r12 = "NoCgiOAndWifiInfo";
        goto L57
    L35:
        r12 = "NotConfigAPSService";
        goto L57
    L36:
        r12 = "AuthClientScodeFail";
        goto L57
    L37:
        r12 = "BindAPSServiceException";
        goto L57
    L31:
        r12 = "ParserDataException";
        goto L57
    L32:
        r12 = "DecryptResponseException";
        goto L57
    L33:
        r12 = "MaybeIntercepted";
        goto L57
    L34:
        r12 = "NeedLoginNetWork\t";
        goto L57
    L45:
        r12 = "ServerLocFail";
        goto L57
    }

    public static void b(long r8, long r10) {
        if (f11185j == false) goto L6;
        return;
    L6:
        StringBuffer r11 = new StringBuffer();     // Catch: Throwable -> L16
        r11.append("gpsTime:");     // Catch: Throwable -> L16
        r11.append(y3.e(r8, "yyyy-MM-dd HH:mm:ss.SSS"));     // Catch: Throwable -> L16
        r11.append(",sysTime:");     // Catch: Throwable -> L16
        r11.append(y3.e(r10, "yyyy-MM-dd HH:mm:ss.SSS"));     // Catch: Throwable -> L16
        r11.append(",serverTime:");     // Catch: Throwable -> L16
        long r12 = s3.C;     // Catch: Throwable -> L16
        String r13 = "0";
        if (0 == r12) goto L9;
        r13 = y3.e(r12, "yyyy-MM-dd HH:mm:ss.SSS");     // Catch: Throwable -> L16
    L9:
        r11.append(r13);     // Catch: Throwable -> L16
        l("checkgpstime", r11.toString());     // Catch: Throwable -> L16
        if (0 != r12) goto L12;
    L14:
        r11.delete(0, r11.length());     // Catch: Throwable -> L16
        f11185j = true;     // Catch: Throwable -> L16
        return;
    L12:
        if (Math.abs(r8 - r12) >= 31536000000L) goto L14;
        r11.append(", correctError");     // Catch: Throwable -> L16
        l("checkgpstimeerror", r11.toString());     // Catch: Throwable -> L16
    }

    public static synchronized void c(Context r8) {
        monitor-enter(w3.class);
        if (r8 != null) goto L43;
    L36:
        monitor-exit(w3.class);
        return;
    L43:
    L25:
        th = move-exception;
        t3.g("ReportUtil", "destroy", th);     // Catch: Throwable -> L33
        return;
    L33:
        th = move-exception;
        throw th;
    L6:
        if (s3.f11065b == false) goto L36;
        ArrayList r10 = f11182g;     // Catch: Throwable -> L25
        if (r10 != null) goto L11;
    L27:
        m(r8);     // Catch: Throwable -> L25
        monitor-exit(w3.class);
        return;
    L11:
        if (r10.size() <= 0) goto L27;
        ArrayList r11 = new ArrayList();     // Catch: Throwable -> L25
        r11.addAll(r10);     // Catch: Throwable -> L25
        monitor-enter(u0.class);     // Catch: Throwable -> L25
        ArrayList r12 = j0.l();     // Catch: Throwable -> L38
        if (r12 == null) goto L39;
        if (r12.size() <= 0) goto L39;
        r11.addAll(r12);     // Catch: Throwable -> L38
    L39:
        u0.a(r8, r11);     // Catch: Throwable -> L22
        monitor-exit(u0.class);     // Catch: Throwable -> L25
        r10.clear();     // Catch: Throwable -> L25
        goto L27
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    }

    public static void e(Context r8, int r10, int r11, long r12, long r13) {
        if (r8 == null) goto L14;
    L9:
        th = move-exception;
        t3.g("ReportUtil", "applyStatisticsEx", th);
        return;
    L5:
        if (s3.f11065b == false) goto L15;
        JSONObject r14 = new JSONObject();     // Catch: Throwable -> L9
        r14.put("param_int_first", r10);     // Catch: Throwable -> L9
        r14.put("param_int_second", r11);     // Catch: Throwable -> L9
        r14.put("param_long_first", r12);     // Catch: Throwable -> L9
        r14.put("param_long_second", r13);     // Catch: Throwable -> L9
        j(r8, "O012", r14);     // Catch: Throwable -> L9
        return;
    L15:
        return;
    }

    public static void f(Context r8, long r10, boolean r11, String r12) {
        int r13 = Long.valueOf(r10).intValue();
        if (r11 == true) goto L5;
        String r14 = "abroad";
    L6:
        if (r8 == null) goto L26;
    L21:
        th = move-exception;
        t3.g("ReportUtil", "applyStatisticsEx", th);
        return;
    L8:
        if (s3.f11065b == false) goto L27;
        JSONObject r15 = new JSONObject();     // Catch: Throwable -> L21
        if (TextUtils.isEmpty(r14) == true) goto L14;
        r15.put("param_string_first", r14);     // Catch: Throwable -> L21
    L14:
        if (TextUtils.isEmpty(null) == true) goto L17;
        r15.put("param_string_second", null);     // Catch: Throwable -> L21
    L17:
        if (r13 == Integer.MAX_VALUE) goto L19;
        r15.put("param_int_first", r13);     // Catch: Throwable -> L21
    L19:
        j(r8, r12, r15);     // Catch: Throwable -> L21
        return;
    L27:
        return;
    L26:
        return;
    L5:
        r14 = "domestic";
        goto L6
    }

    public static synchronized void g(Context r11, AMapLocation r12) {
        monitor-enter(w3.class);
    L55:
        th = move-exception;
        t3.g("ReportUtil", "recordOfflineLocLog", th);     // Catch: Throwable -> L59
        return;
    L59:
        th = move-exception;
        throw th;
    L5:
        if (y3.k(r12) == true) goto L8;
        monitor-exit(w3.class);
        return;
    L8:
        int r8 = r12.f3649z;     // Catch: Throwable -> L55
        if (r8 == 1) goto L24;
        if (r8 == 2) goto L22;
        if (r8 == 4) goto L22;
        if (r8 != 11) goto L15;
        int r10 = 4;
    L25:
        int r13 = r10;
        int r14 = 1;
    L26:
        if (r14 != 0) goto L28;
    L53:
        monitor-exit(w3.class);
        return;
    L28:
        if (s3.f11071h >= 0) goto L30;
        s3.f11071h = 0;     // Catch: Throwable -> L55
    L30:
        int r15 = s3.f11071h;     // Catch: Throwable -> L55
        if (r15 == 0) goto L42;
        if (r13 == 0) goto L38;
        if (r13 == 4) goto L38;
        if (r15 != 1) goto L42;
        monitor-exit(w3.class);
        return;
    L38:
        if (r15 != 2) goto L42;
        monitor-exit(w3.class);
        return;
    L42:
        if (f11183h != null) goto L44;
        f11183h = new JSONArray();     // Catch: Throwable -> L55
    L44:
        JSONObject r16 = new JSONObject();     // Catch: Throwable -> L55
        r16.put("lon", ((long) (r12.getLongitude() * 1000000.0d)) / 1000000.0d);     // Catch: Throwable -> L55
        r16.put("lat", ((long) (r12.getLatitude() * 1000000.0d)) / 1000000.0d);     // Catch: Throwable -> L55
        r16.put("type", r13);     // Catch: Throwable -> L55
        r16.put("timestamp", System.currentTimeMillis());     // Catch: Throwable -> L55
        if (r12.Q.equalsIgnoreCase("WGS84") == false) goto L47;
        r16.put("coordType", 1);     // Catch: Throwable -> L55
    L48:
        if (r13 != 0) goto L50;
        JSONObject r17 = new JSONObject();     // Catch: Throwable -> L55
        r17.put(LocationMonitorConst.ACCURACY, ((long) (((double) r12.getAccuracy()) * 100.0d)) / 100.0d);     // Catch: Throwable -> L55
        r17.put("altitude", ((long) (r12.getAltitude() * 100.0d)) / 100.0d);     // Catch: Throwable -> L55
        r17.put("bearing", ((long) (((double) r12.getBearing()) * 100.0d)) / 100.0d);     // Catch: Throwable -> L55
        r17.put("speed", ((long) (((double) r12.getSpeed()) * 100.0d)) / 100.0d);     // Catch: Throwable -> L55
        r16.put("extension", r17);     // Catch: Throwable -> L55
    L50:
        JSONArray r18 = f11183h.put(r16);     // Catch: Throwable -> L55
        f11183h = r18;     // Catch: Throwable -> L55
        if (r18.length() < s3.f11067d) goto L53;
        m(r11);     // Catch: Throwable -> L55
        goto L53
    L47:
        r16.put("coordType", 2);     // Catch: Throwable -> L55
        goto L48
    L15:
        if (r8 != 8) goto L17;
        r10 = 3;
        goto L25
    L17:
        if (r8 == 9) goto L19;
        r14 = 0;
    L23:
        r13 = r14;
        goto L26
    L19:
        r10 = 2;
    L22:
        r14 = 1;
        goto L23
    L24:
        r10 = 0;
        goto L25
    }

    public static void h(Context r8, AMapLocation r10, em r11) {
    L38:
        th = move-exception;
        t3.g("ReportUtil", "reportBatting", th);
        return;
    L3:
        if (CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS.equalsIgnoreCase(r10.getProvider()) == false) goto L5;
        return;
    L5:
        if (r10.f3649z == 1) goto L44;
        String r12 = "domestic";
        int r13 = 0;
        if (y3.k(r10) == false) goto L13;
        if (t3.h(r10.getLatitude(), r10.getLongitude()) == true) goto L15;
    L14:
        boolean r14 = true;
    L16:
        if (r14 == false) goto L18;
        r12 = "abroad";
    L18:
        String r15 = r12;
        int r16 = r10.f3646w;     // Catch: Throwable -> L38
        String r17 = LocationMonitorConst.CACHE;
        if (r16 != 0) goto L22;
        int r18 = r10.f3649z;     // Catch: Throwable -> L38
        if (r18 == 5) goto L34;
        if (r18 == 6) goto L34;
    L35:
        r13 = 1;
    L36:
        i(r8, r17, r15, r13, r16, r11);     // Catch: Throwable -> L38
        return;
    L34:
        r17 = "net";
        goto L35
    L22:
        if (r16 == 4) goto L28;
        if (r16 == 5) goto L28;
        if (r16 == 6) goto L28;
        if (r16 != 11) goto L36;
    L28:
        r17 = "net";
    L15:
        r14 = false;
        goto L16
    L13:
        if ("http://abroad.apilocate.amap.com/mobile/binary".equals(t3.f11116c) == false) goto L15;
    }

    public static void i(Context r8, String r10, String r11, int r12, int r13, em r14) {
        if (r8 == null) goto L65;
    L60:
        th = move-exception;
        t3.g("ReportUtil", "applyStatisticsEx", th);
        return;
    L5:
        if (s3.f11065b == false) goto L66;
        JSONObject r15 = new JSONObject();     // Catch: Throwable -> L60
        if (TextUtils.isEmpty(r10) == true) goto L11;
        r15.put("param_string_first", r10);     // Catch: Throwable -> L60
    L11:
        if (TextUtils.isEmpty(r11) == true) goto L14;
        r15.put("param_string_second", r11);     // Catch: Throwable -> L60
    L14:
        if (r12 == Integer.MAX_VALUE) goto L16;
        r15.put("param_int_first", r12);     // Catch: Throwable -> L60
    L16:
        if (r13 == Integer.MAX_VALUE) goto L18;
        r15.put("param_int_second", r13);     // Catch: Throwable -> L60
    L18:
        if (r14 != null) goto L20;
    L58:
        j(r8, "O016", r15);     // Catch: Throwable -> L60
        return;
    L20:
        if (TextUtils.isEmpty(r14.f5201o) == true) goto L23;
        r15.put("dns", r14.f5201o);     // Catch: Throwable -> L60
    L23:
        if (TextUtils.isEmpty(r14.f5202p) == true) goto L26;
        r15.put("domain", r14.f5202p);     // Catch: Throwable -> L60
    L26:
        if (TextUtils.isEmpty(r14.f5203q) == true) goto L29;
        r15.put("type", r14.f5203q);     // Catch: Throwable -> L60
    L29:
        if (TextUtils.isEmpty(r14.f5204r) == true) goto L32;
        r15.put("reason", r14.f5204r);     // Catch: Throwable -> L60
    L32:
        if (TextUtils.isEmpty(r14.f5206t) == true) goto L35;
        r15.put("ip", r14.f5206t);     // Catch: Throwable -> L60
    L35:
        if (TextUtils.isEmpty(r14.f5205s) == true) goto L37;
        r15.put("stack", r14.f5205s);     // Catch: Throwable -> L60
    L37:
        long r16 = r14.f5198b;     // Catch: Throwable -> L60
        long r17 = r14.f5197a;     // Catch: Throwable -> L60
        long r18 = 0;
        if (r16 > r17) goto L40;
        long r19 = 0;
    L42:
        if (r19 > 0) goto L44;
    L48:
        long r20 = r14.f5200n;     // Catch: Throwable -> L60
        long r110 = r14.f5199m;     // Catch: Throwable -> L60
        long r21 = r20 - r110;     // Catch: Throwable -> L60
        if (r21 > 0) goto L52;
        r21 = 0;
    L52:
        if (r21 <= 0) goto L58;
        long r22 = r20 - r110;     // Catch: Throwable -> L60
        if (r22 <= 0) goto L57;
        r18 = r22;
    L57:
        r15.put("ntime", String.valueOf(r18));     // Catch: Throwable -> L60
        goto L58
    L44:
        if (r16 > r17) goto L46;
        long r23 = 0;
    L47:
        r15.put("ctime", String.valueOf(r23));     // Catch: Throwable -> L60
        goto L48
    L46:
        r23 = r16 - r17;     // Catch: Throwable -> L60
        goto L47
    L40:
        r19 = r16 - r17;     // Catch: Throwable -> L60
        goto L42
    L66:
        return;
    }

    public static synchronized void j(Context r8, String r10, JSONObject r11) {
        monitor-enter(w3.class);
        if (r8 != null) goto L42;
    L33:
        monitor-exit(w3.class);
        return;
    L42:
    L23:
        th = move-exception;
        t3.g("ReportUtil", "applyStatistics", th);     // Catch: Throwable -> L30
        return;
    L30:
        th = move-exception;
        throw th;
    L6:
        if (s3.f11065b == false) goto L33;
        t0 r12 = new t0(r8, "loc", "6.4.8", r10);     // Catch: Throwable -> L23
        r12.a(r11.toString());     // Catch: Throwable -> L23
        ArrayList r13 = f11182g;     // Catch: Throwable -> L23
        r13.add(r12);     // Catch: Throwable -> L23
        if (r13.size() < 30) goto L25;
        ArrayList r14 = new ArrayList();     // Catch: Throwable -> L23
        r14.addAll(r13);     // Catch: Throwable -> L23
        monitor-enter(u0.class);     // Catch: Throwable -> L23
        ArrayList r15 = j0.l();     // Catch: Throwable -> L35
        if (r15 == null) goto L40;
        if (r15.size() <= 0) goto L40;
        r14.addAll(r15);     // Catch: Throwable -> L35
    L40:
        u0.a(r8, r14);     // Catch: Throwable -> L20
        monitor-exit(u0.class);     // Catch: Throwable -> L23
        r13.clear();     // Catch: Throwable -> L23
        goto L25
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L25:
        monitor-exit(w3.class);
    }

    public static void k(AMapLocation r8, AMapLocation r10) {
        if (f11184i != null) goto L11;
        if (y3.k(r8) == true) goto L9;
        f11184i = r10;     // Catch: Throwable -> L50
        return;
    L9:
        f11184i = r8.t();     // Catch: Throwable -> L50
    L11:
        if (y3.k(f11184i) == true) goto L13;
        return;
    L13:
        if (y3.k(r10) == false) goto L53;
        AMapLocation r11 = r10.t();     // Catch: Throwable -> L50
        AMapLocation r12 = f11184i;     // Catch: Throwable -> L50
        int r13 = r12.f3649z;     // Catch: Throwable -> L50
        if (r13 != 1) goto L17;
    L48:
        f11184i = r11;     // Catch: Throwable -> L50
        return;
    L17:
        if (r13 == 9) goto L48;
        if (CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS.equalsIgnoreCase(r12.getProvider()) == true) goto L48;
        if (f11184i.f3649z == 7) goto L48;
        int r14 = r11.f3649z;     // Catch: Throwable -> L50
        if (r14 == 1) goto L48;
        if (r14 == 9) goto L48;
        if (CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS.equalsIgnoreCase(r11.G) == true) goto L48;
        if (r11.f3649z == 7) goto L48;
        long r15 = Math.abs(r11.getTime() - f11184i.getTime()) / 1000;     // Catch: Throwable -> L50
        if (r15 > 0) goto L33;
        r15 = 1;
    L33:
        if (r15 > 1800) goto L48;
        float r16 = y3.a(f11184i, r11);     // Catch: Throwable -> L50
        float r17 = r16 / r15;     // Catch: Throwable -> L50
        if (r16 <= 30000.0f) goto L48;
        if (r17 <= 1000.0f) goto L48;
        StringBuilder r18 = new StringBuilder();     // Catch: Throwable -> L50
        r18.append(f11184i.getLatitude());     // Catch: Throwable -> L50
        r18.append(",");     // Catch: Throwable -> L50
        r18.append(f11184i.getLongitude());     // Catch: Throwable -> L50
        r18.append(",");     // Catch: Throwable -> L50
        r18.append(f11184i.getAccuracy());     // Catch: Throwable -> L50
        r18.append(",");     // Catch: Throwable -> L50
        r18.append(f11184i.f3649z);     // Catch: Throwable -> L50
        r18.append(",");     // Catch: Throwable -> L50
        if (r8.getTime() == 0) goto L42;
        r18.append(y3.e(f11184i.getTime(), "yyyyMMdd_HH:mm:ss:SS"));     // Catch: Throwable -> L50
    L43:
        r18.append("#");     // Catch: Throwable -> L50
        r18.append(r11.A);     // Catch: Throwable -> L50
        r18.append(",");     // Catch: Throwable -> L50
        r18.append(r11.B);     // Catch: Throwable -> L50
        r18.append(",");     // Catch: Throwable -> L50
        r18.append(r11.getAccuracy());     // Catch: Throwable -> L50
        r18.append(",");     // Catch: Throwable -> L50
        r18.append(r11.f3649z);     // Catch: Throwable -> L50
        r18.append(",");     // Catch: Throwable -> L50
        if (r11.getTime() == 0) goto L46;
        r18.append(y3.e(r11.getTime(), "yyyyMMdd_HH:mm:ss:SS"));     // Catch: Throwable -> L50
    L47:
        l("bigshiftstatistics", r18.toString());     // Catch: Throwable -> L50
        r18.delete(0, r18.length());     // Catch: Throwable -> L50
        goto L48
    L46:
        r18.append(r11.getTime());     // Catch: Throwable -> L50
        goto L47
    L42:
        r18.append(f11184i.getTime());     // Catch: Throwable -> L50
        goto L43
    L53:
        return;
    }

    public static void l(String r8, String r10) {
        s4 r11 = t3.j();     // Catch: Throwable -> L20
        Set<Integer> r12 = q.f10946e;     // Catch: Throwable -> L20
        q r13 = l.f10778c;     // Catch: Throwable -> L23
        if (r13 == null) goto L28;
        boolean r14 = false;
        if (r11 != null) goto L8;
    L13:
        if (r14 == true) goto L16;
        return;
    L16:
        if ("".equals(r8) == true) goto L30;
        s.b(r13.f10947d, r11, 1, r8, r10);     // Catch: Throwable -> L23
        return;
    L30:
        return;
    L8:
        if (r11.f11093c != 1) goto L10;
        boolean r15 = true;
    L11:
        if (r15 == false) goto L13;
        r14 = true;
        goto L13
    L10:
        r15 = false;
        goto L11
    L28:
        return;
    L31:
        return;
    L20:
        th = move-exception;
        t3.g("ReportUtil", "reportLog", th);
    }

    public static void m(Context r8) {
        JSONArray r10 = f11183h;     // Catch: Throwable -> L15
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.length() <= 0) goto L21;
        r0 r11 = new r0(r8, t3.j(), f11183h.toString());     // Catch: Throwable -> L15
        monitor-enter(s0.class);     // Catch: Throwable -> L15
        l1.f10784d.a(new s0.a(r8, r11));     // Catch: Throwable -> L11
        monitor-exit(s0.class);     // Catch: Throwable -> L15
        f11183h = null;     // Catch: Throwable -> L15
        return;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L21:
        return;
    L15:
        th = move-exception;
        t3.g("ReportUtil", "writeOfflineLocLog", th);
    }

    public final void d(Context r10, int r11) {
        int r8 = this.f11187b;     // Catch: Throwable -> L13
        if (r8 != r11) goto L6;
        return;
    L6:
        if (r8 == (-1)) goto L11;
        if (r8 == r11) goto L11;
        long r12 = SystemClock.elapsedRealtime() - this.f11188c;
        SparseArray<Long> r13 = this.f11186a;
        long r14 = r13.get(this.f11187b, 0L).longValue();     // Catch: Throwable -> L13
        r13.append(this.f11187b, Long.valueOf(r12 + r14));     // Catch: Throwable -> L13
    L11:
        long r15 = x3.b(r10, "pref1", this.f11189d[r11], 0);     // Catch: Throwable -> L13
        this.f11188c = SystemClock.elapsedRealtime() - r15;     // Catch: Throwable -> L13
        this.f11187b = r11;     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        t3.g("ReportUtil", "setLocationType", th);
    }
}
