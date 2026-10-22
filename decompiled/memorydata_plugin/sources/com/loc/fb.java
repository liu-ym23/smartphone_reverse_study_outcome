package com.loc;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.SparseArray;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class fb {
    static AMapLocation g;
    static boolean h;
    private static List<aw> i;
    private static JSONArray j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SparseArray<Long> f5523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5524b;
    public long c;
    String[] d;
    public int e;
    public long f;

    /* JADX INFO: renamed from: com.loc.fb$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f5525a = null;

        static {
            int[] r0 = new int[AMapLocationClientOption.AMapLocationMode.values().length];
            f5525a = r0;
            r0[AMapLocationClientOption.AMapLocationMode.Battery_Saving.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f5525a[AMapLocationClientOption.AMapLocationMode.Device_Sensors.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f5525a[AMapLocationClientOption.AMapLocationMode.Hight_Accuracy.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    static {
        i = new ArrayList();
        j = null;
        g = null;
        h = false;
    }

    public fb() {
        this.f5523a = new SparseArray();
        this.f5524b = -1;
        this.c = 0;
        this.d = new String[]{"ol", "cl", "gl", "ha", "bs", "ds"};
        this.e = -1;
        this.f = -1;
    }

    private static String a(int r1) {
        if (r1 != 2011) goto L5;
        return "ContextIsNull";
    L5:
        if (r1 != 2031) goto L7;
        return "CreateApsReqException";
    L7:
        if (r1 != 2041) goto L9;
        return "ResponseResultIsNull";
    L9:
        if (r1 != 2081) goto L11;
        return "LocalLocException";
    L11:
        if (r1 != 2091) goto L13;
        return "InitException";
    L13:
        if (r1 != 2111) goto L15;
        return "ErrorCgiInfo";
    L15:
        if (r1 != 2121) goto L17;
        return "NotLocPermission";
    L17:
        if (r1 != 2141) goto L19;
        return "NoEnoughStatellites";
    L19:
        if (r1 != 2021) goto L21;
        return "OnlyMainWifi";
    L21:
        if (r1 != 2022) goto L23;
        return "OnlyOneWifiButNotMain";
    L23:
        if (r1 != 2061) goto L25;
        return "ServerRetypeError";
    L25:
        if (r1 == 2062) goto L45;
        switch(r1) {
            case 2051: goto L44;
            case 2052: goto L43;
            case 2053: goto L42;
            case 2054: goto L41;
            default: goto L27;
        };
    L27:
        switch(r1) {
            case 2101: goto L40;
            case 2102: goto L39;
            case 2103: goto L38;
            default: goto L28;
        };
    L28:
        switch(r1) {
            case 2131: goto L37;
            case 2132: goto L36;
            case 2133: goto L35;
            default: goto L29;
        };
    L29:
        switch(r1) {
            case 2151: goto L34;
            case 2152: goto L33;
            case 2153: goto L32;
            case 2154: goto L31;
            default: goto L30;
        };
    L30:
        return "";
    L31:
        return "UNSUPPORT_CONTINUE_LOC";
    L32:
        return "UNSUPPORT_COARSE_LBSLOC";
    L33:
        return "MaybeMockGPSLoc";
    L34:
        return "MaybeMockNetLoc";
    L35:
        return "NoCgiAndWifiOff";
    L36:
        return "AirPlaneModeAndWifiOff";
    L37:
        return "NoCgiOAndWifiInfo";
    L38:
        return "NotConfigAPSService";
    L39:
        return "AuthClientScodeFail";
    L40:
        return "BindAPSServiceException";
    L41:
        return "ParserDataException";
    L42:
        return "DecryptResponseException";
    L43:
        return "MaybeIntercepted";
    L44:
        return "NeedLoginNetWork\t";
    L45:
        return "ServerLocFail";
    }

    public static void a(long r5, long r7) {
        if (h == false) goto L6;
        return;
    L6:
        StringBuffer r2 = new StringBuffer();     // Catch: Throwable -> L16
        r2.append("gpsTime:").append(fd.a(r5, "yyyy-MM-dd HH:mm:ss.SSS")).append(",");     // Catch: Throwable -> L16
        r2.append("sysTime:").append(fd.a(r7, "yyyy-MM-dd HH:mm:ss.SSS")).append(",");     // Catch: Throwable -> L16
        long r8 = eu.u();     // Catch: Throwable -> L16
        String r0 = "0";
        if (0 == r8) goto L9;
        r0 = fd.a(r8, "yyyy-MM-dd HH:mm:ss.SSS");     // Catch: Throwable -> L16
    L9:
        r2.append("serverTime:").append(r0);     // Catch: Throwable -> L16
        a("checkgpstime", r2.toString());     // Catch: Throwable -> L16
        if (0 != r8) goto L12;
    L14:
        r2.delete(0, r2.length());     // Catch: Throwable -> L16
        h = true;     // Catch: Throwable -> L16
        return;
    L12:
        if (Math.abs(r5 - r8) >= 31536000000L) goto L14;
        r2.append(", correctError");     // Catch: Throwable -> L16
        a("checkgpstimeerror", r2.toString());     // Catch: Throwable -> L16
    }

    public static synchronized void a(Context r3) {
        monitor-enter(fb.class);
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        if (r4 != null) goto L27;
    L21:
        monitor-exit(fb.class);
        return;
    L27:
    L17:
        th = move-exception;
        ev.a(th, "ReportUtil", "destroy");     // Catch: Throwable -> L23
        return;
    L7:
        if (eu.a() == false) goto L21;
        List<aw> r1 = i;     // Catch: Throwable -> L17
        if (r1 != null) goto L12;
    L14:
        f(r4);     // Catch: Throwable -> L17
        monitor-exit(fb.class);
        return;
    L12:
        if (r1.size() <= 0) goto L14;
        ArrayList r2 = new ArrayList();     // Catch: Throwable -> L17
        r2.addAll(i);     // Catch: Throwable -> L17
        ax.b(r2, r4);     // Catch: Throwable -> L17
        i.clear();     // Catch: Throwable -> L17
    L23:
        th = move-exception;
        throw th;
    }

    public static void a(Context r8, int r9, int r10, long r11, long r13) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        if (r9 == (-1)) goto L13;
        if (r10 == (-1)) goto L14;
        a(r0, "O012", r9, r10, r11, r13);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        ev.a(th, "ReportUtil", "reportServiceAliveTime");
        return;
    L14:
        return;
    }

    public static void a(Context r2, long r3, boolean r5) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L14;
    L9:
        th = move-exception;
        ev.a(th, "ReportUtil", "reportGPSLocUseTime");
        return;
    L5:
        if (eu.a() == false) goto L15;
        a(r4, r3, r5, "O015");     // Catch: Throwable -> L9
        return;
    L15:
        return;
    }

    private static void a(Context r2, long r3, boolean r5, String r6) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        int r7 = Long.valueOf(r3).intValue();
        if (r5 == true) goto L5;
        String r8 = "abroad";
    L6:
        a(r4, r6, r8, r7);
        return;
    L5:
        r8 = "domestic";
        goto L6
    }

    public static synchronized void a(Context r8, AMapLocation r9) {
        monitor-enter(fb.class);
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L56
    L52:
        th = move-exception;
        ev.a(th, "ReportUtil", "recordOfflineLocLog");     // Catch: Throwable -> L56
        return;
    L6:
        if (fd.a(r9) == true) goto L9;
        monitor-exit(fb.class);
        return;
    L9:
        int r1 = r9.getLocationType();     // Catch: Throwable -> L52
        int r3 = 0;
        if (r1 == 1) goto L24;
        if (r1 == 2) goto L23;
        if (r1 == 4) goto L23;
        if (r1 != 11) goto L16;
        int r2 = 4;
    L25:
        r3 = 1;
    L26:
        if (r3 == 0) goto L50;
        int r4 = eu.c();     // Catch: Throwable -> L52
        if (r4 == 0) goto L39;
        if (r2 == 0) goto L35;
        if (r2 == 4) goto L35;
        if (r4 != 1) goto L39;
        monitor-exit(fb.class);
        return;
    L35:
        if (r4 != 2) goto L39;
        monitor-exit(fb.class);
        return;
    L39:
        if (j != null) goto L41;
        j = new JSONArray();     // Catch: Throwable -> L52
    L41:
        JSONObject r5 = new JSONObject();     // Catch: Throwable -> L52
        r5.put("lon", fd.b(r9.getLongitude()));     // Catch: Throwable -> L52
        r5.put("lat", fd.b(r9.getLatitude()));     // Catch: Throwable -> L52
        r5.put("type", r2);     // Catch: Throwable -> L52
        r5.put("timestamp", fd.a());     // Catch: Throwable -> L52
        if (r9.getCoordType().equalsIgnoreCase(AMapLocation.COORD_TYPE_WGS84) == false) goto L44;
        r5.put("coordType", 1);     // Catch: Throwable -> L52
    L45:
        if (r2 != 0) goto L47;
        JSONObject r6 = new JSONObject();     // Catch: Throwable -> L52
        r6.put(LocationMonitorConst.ACCURACY, fd.c(r9.getAccuracy()));     // Catch: Throwable -> L52
        r6.put("altitude", fd.c(r9.getAltitude()));     // Catch: Throwable -> L52
        r6.put("bearing", fd.c(r9.getBearing()));     // Catch: Throwable -> L52
        r6.put("speed", fd.c(r9.getSpeed()));     // Catch: Throwable -> L52
        r5.put("extension", r6);     // Catch: Throwable -> L52
    L47:
        JSONArray r11 = j.put(r5);     // Catch: Throwable -> L52
        j = r11;     // Catch: Throwable -> L52
        if (r11.length() < eu.b()) goto L50;
        f(r10);     // Catch: Throwable -> L52
    L44:
        r5.put("coordType", 2);     // Catch: Throwable -> L52
    L50:
        monitor-exit(fb.class);
        return;
    L16:
        if (r1 != 8) goto L18;
        r3 = 3;
        goto L24
    L18:
        if (r1 == 9) goto L20;
        r2 = 0;
        goto L26
    L20:
        r2 = 2;
    L23:
        r2 = 1;
        r3 = 1;
    L24:
        r2 = r3;
    L56:
        th = move-exception;
        throw th;
    }

    public static void a(Context r8, AMapLocation r9, em r10) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L36;
        return;
    L36:
    L33:
        th = move-exception;
        ev.a(th, "ReportUtil", "reportBatting");
        return;
    L6:
        if ("gps".equalsIgnoreCase(r9.getProvider()) == false) goto L8;
        return;
    L8:
        if (r9.getLocationType() == 1) goto L39;
        String r11 = "domestic";
        if (a(r9) == false) goto L13;
        r11 = "abroad";
    L13:
        String r3 = r11;
        String r2 = "cache";
        if (r9.getErrorCode() == 0) goto L25;
        int r12 = r9.getErrorCode();     // Catch: Throwable -> L33
        if (r12 == 4) goto L23;
        if (r12 == 5) goto L23;
        if (r12 == 6) goto L23;
        if (r12 == 11) goto L23;
    L24:
        int r4 = 0;
    L31:
        a(r0, "O016", r2, r3, r4, r9.getErrorCode(), r10);     // Catch: Throwable -> L33
        return;
    L23:
        r2 = "net";
        goto L24
    L25:
        int r13 = r9.getLocationType();     // Catch: Throwable -> L33
        if (r13 == 5) goto L29;
        if (r13 == 6) goto L29;
    L30:
        r4 = 1;
    L29:
        r2 = "net";
        goto L30
    }

    private static void a(Context r2, String r3, int r4, int r5, long r6, long r8) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L14;
    L9:
        th = move-exception;
        ev.a(th, "ReportUtil", "applyStatisticsEx");
        return;
    L5:
        if (eu.a() == false) goto L15;
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L9
        r0.put("param_int_first", r4);     // Catch: Throwable -> L9
        r0.put("param_int_second", r5);     // Catch: Throwable -> L9
        r0.put("param_long_first", r6);     // Catch: Throwable -> L9
        r0.put("param_long_second", r8);     // Catch: Throwable -> L9
        a(r7, r3, r0);     // Catch: Throwable -> L9
        return;
    L15:
        return;
    }

    private static void a(Context r2, String r3, String r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L23;
    L18:
        th = move-exception;
        ev.a(th, "ReportUtil", "applyStatisticsEx");
        return;
    L5:
        if (eu.a() == false) goto L24;
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L18
        if (TextUtils.isEmpty(r4) == true) goto L11;
        r0.put("param_string_first", r4);     // Catch: Throwable -> L18
    L11:
        if (TextUtils.isEmpty(null) == true) goto L14;
        r0.put("param_string_second", null);     // Catch: Throwable -> L18
    L14:
        if (r5 == Integer.MAX_VALUE) goto L16;
        r0.put("param_int_first", r5);     // Catch: Throwable -> L18
    L16:
        a(r6, r3, r0);     // Catch: Throwable -> L18
        return;
    L24:
        return;
    }

    private static void a(Context r3, String r4, String r5, String r6, int r7, int r8, em r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L50;
    L45:
        th = move-exception;
        ev.a(th, "ReportUtil", "applyStatisticsEx");
        return;
    L5:
        if (eu.a() == false) goto L51;
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L45
        if (TextUtils.isEmpty(r5) == true) goto L11;
        r0.put("param_string_first", r5);     // Catch: Throwable -> L45
    L11:
        if (TextUtils.isEmpty(r6) == true) goto L14;
        r0.put("param_string_second", r6);     // Catch: Throwable -> L45
    L14:
        if (r7 == Integer.MAX_VALUE) goto L16;
        r0.put("param_int_first", r7);     // Catch: Throwable -> L45
    L16:
        if (r8 == Integer.MAX_VALUE) goto L18;
        r0.put("param_int_second", r8);     // Catch: Throwable -> L45
    L18:
        if (r9 != null) goto L20;
    L43:
        a(r10, r4, r0);     // Catch: Throwable -> L45
        return;
    L20:
        if (TextUtils.isEmpty(r9.d()) == true) goto L23;
        r0.put("dns", r9.d());     // Catch: Throwable -> L45
    L23:
        if (TextUtils.isEmpty(r9.e()) == true) goto L26;
        r0.put("domain", r9.e());     // Catch: Throwable -> L45
    L26:
        if (TextUtils.isEmpty(r9.f()) == true) goto L29;
        r0.put("type", r9.f());     // Catch: Throwable -> L45
    L29:
        if (TextUtils.isEmpty(r9.g()) == true) goto L32;
        r0.put(InfoRequestQPSOptTraceLogger.REASON, r9.g());     // Catch: Throwable -> L45
    L32:
        if (TextUtils.isEmpty(r9.c()) == true) goto L35;
        r0.put("ip", r9.c());     // Catch: Throwable -> L45
    L35:
        if (TextUtils.isEmpty(r9.b()) == true) goto L38;
        r0.put("stack", r9.b());     // Catch: Throwable -> L45
    L38:
        if (r9.h() <= 0) goto L41;
        r0.put("ctime", String.valueOf(r9.h()));     // Catch: Throwable -> L45
    L41:
        if (r9.a() <= 0) goto L43;
        r0.put("ntime", String.valueOf(r9.a()));     // Catch: Throwable -> L45
        goto L43
    L51:
        return;
    }

    public static synchronized void a(Context r4, String r5, JSONObject r6) {
        monitor-enter(fb.class);
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        if (r7 != null) goto L27;
    L21:
        monitor-exit(fb.class);
        return;
    L27:
    L17:
        th = move-exception;
        ev.a(th, "ReportUtil", "applyStatistics");     // Catch: Throwable -> L23
        return;
    L7:
        if (eu.a() == false) goto L21;
        aw r1 = new aw(r7, "loc", "6.4.8", r5);     // Catch: Throwable -> L17
        if (r6 == null) goto L12;
        r1.a(r6.toString());     // Catch: Throwable -> L17
    L12:
        i.add(r1);     // Catch: Throwable -> L17
        if (i.size() < 30) goto L15;
        ArrayList r8 = new ArrayList();     // Catch: Throwable -> L17
        r8.addAll(i);     // Catch: Throwable -> L17
        ax.b(r8, r7);     // Catch: Throwable -> L17
        i.clear();     // Catch: Throwable -> L17
    L15:
        monitor-exit(fb.class);
        return;
    L23:
        th = move-exception;
        throw th;
    }

    public static void a(AMapLocation r8, AMapLocation r9) {
        if (g != null) goto L11;
        if (fd.a(r8) == true) goto L9;
        g = r9;     // Catch: Throwable -> L51
        return;
    L9:
        g = r8.clone();     // Catch: Throwable -> L51
    L11:
        if (fd.a(g) == true) goto L13;
        return;
    L13:
        if (fd.a(r9) == false) goto L54;
        AMapLocation r10 = r9.clone();     // Catch: Throwable -> L51
        if (g.getLocationType() != 1) goto L17;
    L49:
        g = r10;     // Catch: Throwable -> L51
        return;
    L17:
        if (g.getLocationType() == 9) goto L49;
        if ("gps".equalsIgnoreCase(g.getProvider()) == true) goto L49;
        if (g.getLocationType() == 7) goto L49;
        if (r10.getLocationType() == 1) goto L49;
        if (r10.getLocationType() == 9) goto L49;
        if ("gps".equalsIgnoreCase(r10.getProvider()) == true) goto L49;
        if (r10.getLocationType() == 7) goto L49;
        long r2 = Math.abs(r10.getTime() - g.getTime()) / 1000;     // Catch: Throwable -> L51
        if (r2 > 0) goto L34;
        r2 = 1;
    L34:
        if (r2 > 1800) goto L49;
        float r0 = fd.a(g, r10);     // Catch: Throwable -> L51
        float r3 = r0 / r2;     // Catch: Throwable -> L51
        if (r0 <= 30000.0f) goto L49;
        if (r3 <= 1000.0f) goto L49;
        StringBuilder r1 = new StringBuilder();     // Catch: Throwable -> L51
        r1.append(g.getLatitude()).append(",");     // Catch: Throwable -> L51
        r1.append(g.getLongitude()).append(",");     // Catch: Throwable -> L51
        r1.append(g.getAccuracy()).append(",");     // Catch: Throwable -> L51
        r1.append(g.getLocationType()).append(",");     // Catch: Throwable -> L51
        if (r8.getTime() == 0) goto L43;
        r1.append(fd.a(g.getTime(), "yyyyMMdd_HH:mm:ss:SS"));     // Catch: Throwable -> L51
    L44:
        r1.append("#");     // Catch: Throwable -> L51
        r1.append(r10.getLatitude()).append(",");     // Catch: Throwable -> L51
        r1.append(r10.getLongitude()).append(",");     // Catch: Throwable -> L51
        r1.append(r10.getAccuracy()).append(",");     // Catch: Throwable -> L51
        r1.append(r10.getLocationType()).append(",");     // Catch: Throwable -> L51
        if (r10.getTime() == 0) goto L47;
        r1.append(fd.a(r10.getTime(), "yyyyMMdd_HH:mm:ss:SS"));     // Catch: Throwable -> L51
    L48:
        a("bigshiftstatistics", r1.toString());     // Catch: Throwable -> L51
        r1.delete(0, r1.length());     // Catch: Throwable -> L51
        goto L49
    L47:
        r1.append(r10.getTime());     // Catch: Throwable -> L51
        goto L48
    L43:
        r1.append(g.getTime());     // Catch: Throwable -> L51
        goto L44
    L54:
        return;
    }

    public static void a(String r1, int r2) {
        a(r1, String.valueOf(r2), a(r2));
    }

    public static void a(String r1, String r2) {
        q.b(ev.c(), r2, r1);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        ev.a(th, "ReportUtil", "reportLog");
    }

    public static void a(String r2, String r3, String r4) {
        q.a(ev.c(), "/mobile/binary", r4, r2, r3);     // Catch: Throwable -> L4
        return;
    }

    public static void a(String r3, Throwable r4) {
        if (ZeusTransformUtils.instanceOf(r4, l.class) == false) goto L9;
        q.a(ev.c(), r3, (l) ZeusTransformUtils.preCheckCast(r4, l.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    private static boolean a(AMapLocation r7) {
        if (fd.a(r7) == false) goto L9;
        if (ev.a(r7.getLatitude(), r7.getLongitude()) == false) goto L7;
        return false;
    L7:
        return true;
    L9:
        if ("http://abroad.apilocate.amap.com/mobile/binary".equals(ev.c) == false) goto L11;
        return true;
    L11:
        return false;
    }

    public static void b(Context r2, long r3, boolean r5) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L14;
    L9:
        th = move-exception;
        ev.a(th, "ReportUtil", "reportCoarseLocUseTime");
        return;
    L5:
        if (eu.a() == false) goto L15;
        a(r4, r3, r5, "O024");     // Catch: Throwable -> L9
        return;
    L15:
        return;
    }

    private static void f(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        JSONArray r0 = j;     // Catch: Throwable -> L9
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.length() <= 0) goto L15;
        av.a(new au(r4, ev.c(), j.toString()), r4);     // Catch: Throwable -> L9
        j = null;     // Catch: Throwable -> L9
        return;
    L15:
        return;
    L9:
        th = move-exception;
        ev.a(th, "ReportUtil", "writeOfflineLocLog");
    }

    public final void a(Context r10, int r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        int r0 = this.f5524b;     // Catch: Throwable -> L12
        if (r0 != r11) goto L7;
        return;
    L7:
        if (r0 == (-1)) goto L10;
        if (r0 == r11) goto L10;
        long r5 = fd.b() - this.c;     // Catch: Throwable -> L12
        long r1 = ((Long) ZeusTransformUtils.preCheckCast(this.f5523a.get(this.f5524b, 0L), Long.class, "com.obric.memorydata.plugin")).longValue();     // Catch: Throwable -> L12
        this.f5523a.append(this.f5524b, Long.valueOf(r5 + r1));     // Catch: Throwable -> L12
    L10:
        long r2 = fc.a(r12, "pref1", this.d[r11], 0);     // Catch: Throwable -> L12
        this.c = fd.b() - r2;     // Catch: Throwable -> L12
        this.f5524b = r11;     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        ev.a(th, "ReportUtil", "setLocationType");
    }

    public final void a(Context r11, AMapLocationClientOption r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        int r14 = AnonymousClass1.f5525a[r12.getLocationMode().ordinal()];     // Catch: Throwable -> L20
        int r2 = 3;
        if (r14 != 1) goto L6;
        r2 = 4;
    L11:
        int r15 = this.e;     // Catch: Throwable -> L20
        if (r15 != r2) goto L15;
        return;
    L15:
        if (r15 == (-1)) goto L18;
        if (r15 == r2) goto L18;
        this.f5523a.append(this.e, Long.valueOf((fd.b() - this.f) + ((Long) ZeusTransformUtils.preCheckCast(this.f5523a.get(this.e, 0L), Long.class, "com.obric.memorydata.plugin")).longValue()));     // Catch: Throwable -> L20
    L18:
        this.f = fd.b() - fc.a(r13, "pref1", this.d[r2], 0);     // Catch: Throwable -> L20
        this.e = r2;     // Catch: Throwable -> L20
        return;
    L6:
        if (r14 == 2) goto L9;
        if (r14 == 3) goto L11;
        r2 = -1;
        goto L11
    L9:
        r2 = 5;
    L20:
        th = move-exception;
        ev.a(th, "ReportUtil", "setLocationMode");
    }

    public final void b(Context r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.memorydata.plugin");
        long r3 = fd.b() - this.c;     // Catch: Throwable -> L20
        int r1 = this.f5524b;     // Catch: Throwable -> L20
        if (r1 == (-1)) goto L6;
        long r8 = ((Long) ZeusTransformUtils.preCheckCast(this.f5523a.get(r1, 0L), Long.class, "com.obric.memorydata.plugin")).longValue();     // Catch: Throwable -> L20
        this.f5523a.append(this.f5524b, Long.valueOf(r3 + r8));     // Catch: Throwable -> L20
    L6:
        long r4 = fd.b() - this.f;     // Catch: Throwable -> L20
        int r2 = this.e;     // Catch: Throwable -> L20
        if (r2 == (-1)) goto L9;
        long r9 = ((Long) ZeusTransformUtils.preCheckCast(this.f5523a.get(r2, 0L), Long.class, "com.obric.memorydata.plugin")).longValue();     // Catch: Throwable -> L20
        this.f5523a.append(this.e, Long.valueOf(r4 + r9));     // Catch: Throwable -> L20
    L9:
        SharedPreferences.Editor r5 = fc.a(r13, "pref1");     // Catch: Throwable -> L20
        int r6 = 0;
    L11:
        if (r6 >= this.d.length) goto L18;
        long r7 = ((Long) ZeusTransformUtils.preCheckCast(this.f5523a.get(r6, 0L), Long.class, "com.obric.memorydata.plugin")).longValue();     // Catch: Throwable -> L20
        if (r7 <= 0) goto L17;
        if (r7 <= fc.a(r13, "pref1", this.d[r6], 0)) goto L17;
        fc.a(r5, this.d[r6], r7);     // Catch: Throwable -> L20
    L17:
        r6 = r6 + 1;     // Catch: Throwable -> L20
        goto L11
    L18:
        fc.a(r5);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        ev.a(th, "ReportUtil", "saveLocationTypeAndMode");
    }

    public final int c(Context r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.memorydata.plugin");
        long r6 = fc.a(r13, "pref1", this.d[2], 0);     // Catch: Throwable -> L21
        long r9 = fc.a(r13, "pref1", this.d[0], 0);     // Catch: Throwable -> L21
        long r11 = fc.a(r13, "pref1", this.d[1], 0);     // Catch: Throwable -> L21
        if (r6 == 0) goto L7;
    L11:
        long r10 = r9 - r6;
        long r14 = r11 - r6;
        if (r6 <= r10) goto L18;
        if (r6 <= r14) goto L16;
        return 2;
    L16:
        return 1;
    L18:
        if (r10 <= r14) goto L20;
        return 0;
    L20:
        return 1;
    L7:
        if (r9 != 0) goto L11;
        if (r11 != 0) goto L11;
        return -1;
    L21:
        return -1;
    }

    public final int d(Context r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.memorydata.plugin");
        long r6 = fc.a(r13, "pref1", this.d[3], 0);     // Catch: Throwable -> L21
        long r9 = fc.a(r13, "pref1", this.d[4], 0);     // Catch: Throwable -> L21
        long r11 = fc.a(r13, "pref1", this.d[5], 0);     // Catch: Throwable -> L21
        if (r6 != 0) goto L12;
        if (r9 != 0) goto L12;
        if (r11 != 0) goto L12;
        return -1;
    L12:
        if (r6 <= r9) goto L18;
        if (r6 <= r11) goto L16;
        return 3;
    L16:
        return 5;
    L18:
        if (r9 <= r11) goto L20;
        return 4;
    L20:
        return 5;
    L21:
        return -1;
    }

    public final void e(Context r5) {
        SharedPreferences.Editor r6 = fc.a((Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin"), "pref1");     // Catch: Throwable -> L9
        int r0 = 0;
    L4:
        String[] r1 = this.d;     // Catch: Throwable -> L9
        if (r0 >= r1.length) goto L7;
        fc.a(r6, r1[r0], 0);     // Catch: Throwable -> L9
        r0 = r0 + 1;     // Catch: Throwable -> L9
        goto L4
    L7:
        fc.a(r6);     // Catch: Throwable -> L9
        return;
    }
}
