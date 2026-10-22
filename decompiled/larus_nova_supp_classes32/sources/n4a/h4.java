package n4a;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.loc.em;
import com.obric.aivoice.core.data.NameKeys;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class h4 {
    public static final List<r0> g = null;
    public static JSONArray h;
    public static AMapLocation i;
    public static boolean j;
    public final SparseArray<Long> a;
    public int b;
    public long c;
    public final String[] d;
    public int e;
    public long f;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[AMapLocationClientOption.AMapLocationMode.values().length];
            a = r0;
            r0[AMapLocationClientOption.AMapLocationMode.Battery_Saving.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            a[AMapLocationClientOption.AMapLocationMode.Device_Sensors.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            a[AMapLocationClientOption.AMapLocationMode.Hight_Accuracy.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    static {
        g = new ArrayList();
        h = null;
        i = null;
        j = false;
    }

    public h4() {
        this.a = new SparseArray();
        this.b = -1;
        this.c = 0;
        this.d = new String[]{"ol", "cl", "gl", "ha", "bs", "ds"};
        this.e = -1;
        this.f = -1;
    }

    public static void j(AMapLocation r8, AMapLocation r9) {
        if (i != null) goto L11;
        if (j4.l(r8) == true) goto L9;
        i = r9;     // Catch: Throwable -> L51
        return;
    L9:
        i = r8.clone();     // Catch: Throwable -> L51
    L11:
        if (j4.l(i) == true) goto L13;
        return;
    L13:
        if (j4.l(r9) == false) goto L54;
        AMapLocation r10 = r9.clone();     // Catch: Throwable -> L51
        if (i.getLocationType() != 1) goto L17;
    L49:
        i = r10;     // Catch: Throwable -> L51
        return;
    L17:
        if (i.getLocationType() == 9) goto L49;
        if ("gps".equalsIgnoreCase(i.getProvider()) == true) goto L49;
        if (i.getLocationType() == 7) goto L49;
        if (r10.getLocationType() == 1) goto L49;
        if (r10.getLocationType() == 9) goto L49;
        if ("gps".equalsIgnoreCase(r10.getProvider()) == true) goto L49;
        if (r10.getLocationType() == 7) goto L49;
        long r2 = Math.abs(r10.getTime() - i.getTime()) / 1000;     // Catch: Throwable -> L51
        if (r2 > 0) goto L34;
        r2 = 1;
    L34:
        if (r2 > 1800) goto L49;
        float r0 = j4.a(i, r10);     // Catch: Throwable -> L51
        float r3 = r0 / r2;     // Catch: Throwable -> L51
        if (r0 <= 30000.0f) goto L49;
        if (r3 <= 1000.0f) goto L49;
        StringBuilder r1 = new StringBuilder();     // Catch: Throwable -> L51
        r1.append(i.getLatitude());     // Catch: Throwable -> L51
        r1.append(",");     // Catch: Throwable -> L51
        r1.append(i.getLongitude());     // Catch: Throwable -> L51
        r1.append(",");     // Catch: Throwable -> L51
        r1.append(i.getAccuracy());     // Catch: Throwable -> L51
        r1.append(",");     // Catch: Throwable -> L51
        r1.append(i.getLocationType());     // Catch: Throwable -> L51
        r1.append(",");     // Catch: Throwable -> L51
        if (r8.getTime() == 0) goto L43;
        r1.append(j4.f(i.getTime(), "yyyyMMdd_HH:mm:ss:SS"));     // Catch: Throwable -> L51
    L44:
        r1.append("#");     // Catch: Throwable -> L51
        r1.append(r10.getLatitude());     // Catch: Throwable -> L51
        r1.append(",");     // Catch: Throwable -> L51
        r1.append(r10.getLongitude());     // Catch: Throwable -> L51
        r1.append(",");     // Catch: Throwable -> L51
        r1.append(r10.getAccuracy());     // Catch: Throwable -> L51
        r1.append(",");     // Catch: Throwable -> L51
        r1.append(r10.getLocationType());     // Catch: Throwable -> L51
        r1.append(",");     // Catch: Throwable -> L51
        if (r10.getTime() == 0) goto L47;
        r1.append(j4.f(r10.getTime(), "yyyyMMdd_HH:mm:ss:SS"));     // Catch: Throwable -> L51
    L48:
        l("bigshiftstatistics", r1.toString());     // Catch: Throwable -> L51
        r1.delete(0, r1.length());     // Catch: Throwable -> L51
        goto L49
    L47:
        r1.append(r10.getTime());     // Catch: Throwable -> L51
        goto L48
    L43:
        r1.append(i.getTime());     // Catch: Throwable -> L51
        goto L44
    L54:
        return;
    }

    public static synchronized void b(Context r3) {
        monitor-enter(h4.class);
        if (r3 != null) goto L27;
    L23:
        monitor-exit(h4.class);
        return;
    L27:
    L16:
        th = move-exception;
        c4.g(th, "ReportUtil", "destroy");     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        throw th;
    L6:
        if (com.loc.h.b == false) goto L23;
        List<r0> r1 = g;     // Catch: Throwable -> L16
        if (r1 != null) goto L11;
    L13:
        n(r3);     // Catch: Throwable -> L16
        monitor-exit(h4.class);
        return;
    L11:
        if (((ArrayList) r1).size() <= 0) goto L13;
        ArrayList r2 = new ArrayList();     // Catch: Throwable -> L16
        r2.addAll(r1);     // Catch: Throwable -> L16
        s0.d(r2, r3);     // Catch: Throwable -> L16
        ((ArrayList) r1).clear();     // Catch: Throwable -> L16
        goto L13
    }

    public static void n(Context r4) {
        JSONArray r0 = h;     // Catch: Throwable -> L15
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.length() <= 0) goto L21;
        p0 r1 = new p0(r4, c4.k(), h.toString());     // Catch: Throwable -> L15
        monitor-enter(q0.class);     // Catch: Throwable -> L15
        k1.d.b(new q0.a(r4, r1));     // Catch: Throwable -> L11
        monitor-exit(q0.class);     // Catch: Throwable -> L15
        h = null;     // Catch: Throwable -> L15
        return;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L21:
        return;
    L15:
        th = move-exception;
        c4.g(th, "ReportUtil", "writeOfflineLocLog");
    }

    public final void m(Context r11) {
        long r1 = SystemClock.elapsedRealtime() - this.c;     // Catch: Throwable -> L20
        int r3 = this.b;     // Catch: Throwable -> L20
        if (r3 == (-1)) goto L6;
        long r7 = this.a.get(r3, 0L).longValue();     // Catch: Throwable -> L20
        this.a.append(this.b, Long.valueOf(r1 + r7));     // Catch: Throwable -> L20
    L6:
        long r2 = SystemClock.elapsedRealtime() - this.f;     // Catch: Throwable -> L20
        int r4 = this.e;     // Catch: Throwable -> L20
        if (r4 == (-1)) goto L9;
        long r5 = this.a.get(r4, 0L).longValue();     // Catch: Throwable -> L20
        this.a.append(this.e, Long.valueOf(r2 + r5));     // Catch: Throwable -> L20
    L9:
        int r6 = 0;
        SharedPreferences.Editor r8 = r11.getSharedPreferences("pref1", 0).edit();     // Catch: Throwable -> L20
    L11:
        if (r6 >= this.d.length) goto L18;
        long r9 = this.a.get(r6, 0L).longValue();     // Catch: Throwable -> L20
        if (r9 <= 0) goto L17;
        if (r9 <= i4.b(r11, "pref1", this.d[r6], 0)) goto L17;
        i4.g(r8, this.d[r6], r9);     // Catch: Throwable -> L20
    L17:
        r6 = r6 + 1;     // Catch: Throwable -> L20
        goto L11
    L18:
        i4.e(r8);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        c4.g(th, "ReportUtil", "saveLocationTypeAndMode");
    }

    public static void a(long r6, long r8) {
        if (j == false) goto L6;
        return;
    L6:
        StringBuffer r3 = new StringBuffer();     // Catch: Throwable -> L16
        r3.append("gpsTime:");     // Catch: Throwable -> L16
        r3.append(j4.f(r6, "yyyy-MM-dd HH:mm:ss.SSS"));     // Catch: Throwable -> L16
        r3.append(",sysTime:");     // Catch: Throwable -> L16
        r3.append(j4.f(r8, "yyyy-MM-dd HH:mm:ss.SSS"));     // Catch: Throwable -> L16
        r3.append(",serverTime:");     // Catch: Throwable -> L16
        long r9 = com.loc.h.C;     // Catch: Throwable -> L16
        String r1 = "0";
        if (0 == r9) goto L9;
        r1 = j4.f(r9, "yyyy-MM-dd HH:mm:ss.SSS");     // Catch: Throwable -> L16
    L9:
        r3.append(r1);     // Catch: Throwable -> L16
        l("checkgpstime", r3.toString());     // Catch: Throwable -> L16
        if (0 != r9) goto L12;
    L14:
        r3.delete(0, r3.length());     // Catch: Throwable -> L16
        j = true;     // Catch: Throwable -> L16
        return;
    L12:
        if (Math.abs(r6 - r9) >= 31536000000L) goto L14;
        r3.append(", correctError");     // Catch: Throwable -> L16
        l("checkgpstimeerror", r3.toString());     // Catch: Throwable -> L16
    }

    public static synchronized void f(Context r8, AMapLocation r9) {
        monitor-enter(h4.class);
    L54:
        th = move-exception;
        c4.g(th, "ReportUtil", "recordOfflineLocLog");     // Catch: Throwable -> L58
        return;
    L58:
        th = move-exception;
        throw th;
    L5:
        if (j4.l(r9) == true) goto L8;
        monitor-exit(h4.class);
        return;
    L8:
        int r1 = r9.getLocationType();     // Catch: Throwable -> L54
        if (r1 == 1) goto L23;
        if (r1 == 2) goto L22;
        if (r1 == 4) goto L22;
        if (r1 != 11) goto L15;
        int r2 = 4;
    L24:
        boolean r6 = true;
    L25:
        if (r6 == true) goto L27;
    L52:
        monitor-exit(h4.class);
        return;
    L27:
        if (com.loc.h.h >= 0) goto L29;
        com.loc.h.h = 0;     // Catch: Throwable -> L54
    L29:
        int r5 = com.loc.h.h;     // Catch: Throwable -> L54
        if (r5 == 0) goto L41;
        if (r2 == 0) goto L37;
        if (r2 == 4) goto L37;
        if (r5 != 1) goto L41;
        monitor-exit(h4.class);
        return;
    L37:
        if (r5 != 2) goto L41;
        monitor-exit(h4.class);
        return;
    L41:
        if (h != null) goto L43;
        h = new JSONArray();     // Catch: Throwable -> L54
    L43:
        JSONObject r3 = new JSONObject();     // Catch: Throwable -> L54
        r3.put("lon", j4.s(r9.getLongitude()));     // Catch: Throwable -> L54
        r3.put("lat", j4.s(r9.getLatitude()));     // Catch: Throwable -> L54
        r3.put("type", r2);     // Catch: Throwable -> L54
        r3.put("timestamp", System.currentTimeMillis());     // Catch: Throwable -> L54
        if (r9.getCoordType().equalsIgnoreCase("WGS84") == false) goto L46;
        r3.put("coordType", 1);     // Catch: Throwable -> L54
    L47:
        if (r2 != 0) goto L49;
        JSONObject r4 = new JSONObject();     // Catch: Throwable -> L54
        r4.put("accuracy", ((long) (((double) r9.getAccuracy()) * 100.0d)) / 100.0d);     // Catch: Throwable -> L54
        r4.put("altitude", ((long) (r9.getAltitude() * 100.0d)) / 100.0d);     // Catch: Throwable -> L54
        r4.put("bearing", ((long) (((double) r9.getBearing()) * 100.0d)) / 100.0d);     // Catch: Throwable -> L54
        r4.put("speed", ((long) (((double) r9.getSpeed()) * 100.0d)) / 100.0d);     // Catch: Throwable -> L54
        r3.put("extension", r4);     // Catch: Throwable -> L54
    L49:
        JSONArray r10 = h.put(r3);     // Catch: Throwable -> L54
        h = r10;     // Catch: Throwable -> L54
        if (r10.length() < com.loc.h.d) goto L52;
        n(r8);     // Catch: Throwable -> L54
        goto L52
    L46:
        r3.put("coordType", 2);     // Catch: Throwable -> L54
        goto L47
    L15:
        if (r1 != 8) goto L17;
        r2 = 3;
        goto L24
    L17:
        if (r1 == 9) goto L19;
        r2 = 0;
        r6 = false;
        goto L25
    L19:
        r2 = 2;
    L22:
        r2 = 1;
        goto L24
    L23:
        r2 = 0;
        goto L24
    }

    public static void k(String r6, int r7) {
        String r5 = String.valueOf(r7);
        if (r7 != 2011) goto L5;
        String r8 = "ContextIsNull";
    L57:
        String r2 = r8;
        r.d(c4.k(), "/mobile/binary", r2, r6, NameKeys.UnloadStrategy_No_Strategy, r5);     // Catch: Throwable -> L60
        return;
    L63:
        return;
    L5:
        if (r7 != 2031) goto L7;
        r8 = "CreateApsReqException";
        goto L57
    L7:
        if (r7 != 2041) goto L9;
        r8 = "ResponseResultIsNull";
        goto L57
    L9:
        if (r7 != 2081) goto L11;
        r8 = "LocalLocException";
        goto L57
    L11:
        if (r7 != 2091) goto L13;
        r8 = "InitException";
        goto L57
    L13:
        if (r7 != 2111) goto L15;
        r8 = "ErrorCgiInfo";
        goto L57
    L15:
        if (r7 != 2121) goto L17;
        r8 = "NotLocPermission";
        goto L57
    L17:
        if (r7 != 2141) goto L19;
        r8 = "NoEnoughStatellites";
        goto L57
    L19:
        if (r7 != 2021) goto L21;
        r8 = "OnlyMainWifi";
        goto L57
    L21:
        if (r7 != 2022) goto L23;
        r8 = "OnlyOneWifiButNotMain";
        goto L57
    L23:
        if (r7 != 2061) goto L25;
        r8 = "ServerRetypeError";
        goto L57
    L25:
        if (r7 == 2062) goto L45;
        switch(r7) {
            case 2051: goto L34;
            case 2052: goto L33;
            case 2053: goto L32;
            case 2054: goto L31;
            default: goto L27;
        };
    L27:
        switch(r7) {
            case 2101: goto L37;
            case 2102: goto L36;
            case 2103: goto L35;
            default: goto L28;
        };
    L28:
        switch(r7) {
            case 2131: goto L40;
            case 2132: goto L39;
            case 2133: goto L38;
            default: goto L29;
        };
    L29:
        switch(r7) {
            case 2151: goto L44;
            case 2152: goto L43;
            case 2153: goto L42;
            case 2154: goto L41;
            default: goto L30;
        };
    L30:
        r8 = NameKeys.UnloadStrategy_No_Strategy;
        goto L57
    L41:
        r8 = "UNSUPPORT_CONTINUE_LOC";
        goto L57
    L42:
        r8 = "UNSUPPORT_COARSE_LBSLOC";
        goto L57
    L43:
        r8 = "MaybeMockGPSLoc";
        goto L57
    L44:
        r8 = "MaybeMockNetLoc";
        goto L57
    L38:
        r8 = "NoCgiAndWifiOff";
        goto L57
    L39:
        r8 = "AirPlaneModeAndWifiOff";
        goto L57
    L40:
        r8 = "NoCgiOAndWifiInfo";
        goto L57
    L35:
        r8 = "NotConfigAPSService";
        goto L57
    L36:
        r8 = "AuthClientScodeFail";
        goto L57
    L37:
        r8 = "BindAPSServiceException";
        goto L57
    L31:
        r8 = "ParserDataException";
        goto L57
    L32:
        r8 = "DecryptResponseException";
        goto L57
    L33:
        r8 = "MaybeIntercepted";
        goto L57
    L34:
        r8 = "NeedLoginNetWork\t";
        goto L57
    L45:
        r8 = "ServerLocFail";
        goto L57
    }

    public static void l(String r5, String r6) {
        e5 r0 = c4.k();     // Catch: Throwable -> L20
        Set<Integer> r1 = r.e;     // Catch: Throwable -> L20
        r r2 = n.c;     // Catch: Throwable -> L23
        if (r2 == null) goto L28;
        Context r3 = r2.d;     // Catch: Throwable -> L23
        boolean r4 = false;
        if (r0 != null) goto L8;
    L13:
        if (r4 == true) goto L16;
        return;
    L16:
        if (NameKeys.UnloadStrategy_No_Strategy.equals(r5) == true) goto L30;
        t.b(r3, r0, 1, r5, r6);     // Catch: Throwable -> L23
        return;
    L30:
        return;
    L8:
        if (r0.c != 1) goto L10;
        boolean r7 = true;
    L11:
        if (r7 == false) goto L13;
        r4 = true;
        goto L13
    L10:
        r7 = false;
        goto L11
    L28:
        return;
    L31:
        return;
    L20:
        th = move-exception;
        c4.g(th, "ReportUtil", "reportLog");
    }

    public final void c(Context r9, int r10) {
        int r0 = this.b;     // Catch: Throwable -> L11
        if (r0 != r10) goto L6;
        return;
    L6:
        if (r0 == (-1)) goto L9;
        if (r0 == r10) goto L9;
        long r1 = SystemClock.elapsedRealtime() - this.c;     // Catch: Throwable -> L11
        long r4 = this.a.get(this.b, 0L).longValue();     // Catch: Throwable -> L11
        this.a.append(this.b, Long.valueOf(r1 + r4));     // Catch: Throwable -> L11
    L9:
        long r2 = i4.b(r9, "pref1", this.d[r10], 0);     // Catch: Throwable -> L11
        this.c = SystemClock.elapsedRealtime() - r2;     // Catch: Throwable -> L11
        this.b = r10;     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        c4.g(th, "ReportUtil", "setLocationType");
    }

    public static void g(Context r8, AMapLocation r9, em r10) {
    L38:
        th = move-exception;
        c4.g(th, "ReportUtil", "reportBatting");
        return;
    L3:
        if ("gps".equalsIgnoreCase(r9.getProvider()) == false) goto L5;
        return;
    L5:
        if (r9.getLocationType() == 1) goto L44;
        String r0 = "domestic";
        int r3 = 0;
        if (j4.l(r9) == false) goto L13;
        if (c4.h(r9.getLatitude(), r9.getLongitude()) == true) goto L15;
    L14:
        boolean r2 = true;
    L16:
        if (r2 == false) goto L18;
        r0 = "abroad";
    L18:
        String r4 = r0;
        String r5 = "cache";
        if (r9.getErrorCode() == 0) goto L30;
        int r1 = r9.getErrorCode();     // Catch: Throwable -> L38
        if (r1 == 4) goto L28;
        if (r1 == 5) goto L28;
        if (r1 == 6) goto L28;
        if (r1 == 11) goto L28;
    L29:
        String r6 = r5;
    L36:
        h(r8, r6, r4, r3, r9.getErrorCode(), r10);     // Catch: Throwable -> L38
        return;
    L28:
        r5 = "net";
        goto L29
    L30:
        int r7 = r9.getLocationType();     // Catch: Throwable -> L38
        if (r7 == 5) goto L34;
        if (r7 == 6) goto L34;
    L35:
        r6 = r5;
        r3 = 1;
    L34:
        r5 = "net";
    L15:
        r2 = false;
        goto L16
    L13:
        if ("http://abroad.apilocate.amap.com/mobile/binary".equals(c4.c) == false) goto L15;
    }

    public static synchronized void i(Context r4, String r5, JSONObject r6) {
        monitor-enter(h4.class);
        if (r4 != null) goto L25;
    L23:
        monitor-exit(h4.class);
        return;
    L25:
    L16:
        th = move-exception;
        c4.g(th, "ReportUtil", "applyStatistics");     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        throw th;
    L6:
        if (com.loc.h.b == false) goto L23;
        r0 r1 = new r0(r4, "loc", "6.4.8", r5);     // Catch: Throwable -> L16
        if (r6 == null) goto L11;
        r1.a(r6.toString());     // Catch: Throwable -> L16
    L11:
        List<r0> r7 = g;     // Catch: Throwable -> L16
        ((ArrayList) r7).add(r1);     // Catch: Throwable -> L16
        if (((ArrayList) r7).size() < 30) goto L14;
        ArrayList r8 = new ArrayList();     // Catch: Throwable -> L16
        r8.addAll(r7);     // Catch: Throwable -> L16
        s0.d(r8, r4);     // Catch: Throwable -> L16
        ((ArrayList) r7).clear();     // Catch: Throwable -> L16
    L14:
        monitor-exit(h4.class);
    }

    public static void e(Context r1, long r2, boolean r4, String r5) {
        int r3 = Long.valueOf(r2).intValue();
        if (r4 == true) goto L5;
        String r6 = "abroad";
    L6:
        if (r1 == null) goto L26;
    L21:
        th = move-exception;
        c4.g(th, "ReportUtil", "applyStatisticsEx");
        return;
    L8:
        if (com.loc.h.b == false) goto L27;
        JSONObject r7 = new JSONObject();     // Catch: Throwable -> L21
        if (TextUtils.isEmpty(r6) == true) goto L14;
        r7.put("param_string_first", r6);     // Catch: Throwable -> L21
    L14:
        if (TextUtils.isEmpty(null) == true) goto L17;
        r7.put("param_string_second", null);     // Catch: Throwable -> L21
    L17:
        if (r3 == Integer.MAX_VALUE) goto L19;
        r7.put("param_int_first", r3);     // Catch: Throwable -> L21
    L19:
        i(r1, r5, r7);     // Catch: Throwable -> L21
        return;
    L27:
        return;
    L26:
        return;
    L5:
        r6 = "domestic";
        goto L6
    }

    public static void d(Context r3, int r4, int r5, long r6, long r8) {
        if (r3 == null) goto L14;
    L9:
        th = move-exception;
        c4.g(th, "ReportUtil", "applyStatisticsEx");
        return;
    L5:
        if (com.loc.h.b == false) goto L15;
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L9
        r1.put("param_int_first", r4);     // Catch: Throwable -> L9
        r1.put("param_int_second", r5);     // Catch: Throwable -> L9
        r1.put("param_long_first", r6);     // Catch: Throwable -> L9
        r1.put("param_long_second", r8);     // Catch: Throwable -> L9
        i(r3, "O012", r1);     // Catch: Throwable -> L9
        return;
    L15:
        return;
    }

    public static void h(Context r7, String r8, String r9, int r10, int r11, em r12) {
        if (r7 == null) goto L65;
    L60:
        th = move-exception;
        c4.g(th, "ReportUtil", "applyStatisticsEx");
        return;
    L5:
        if (com.loc.h.b == false) goto L66;
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L60
        if (TextUtils.isEmpty(r8) == true) goto L11;
        r1.put("param_string_first", r8);     // Catch: Throwable -> L60
    L11:
        if (TextUtils.isEmpty(r9) == true) goto L14;
        r1.put("param_string_second", r9);     // Catch: Throwable -> L60
    L14:
        if (r10 == Integer.MAX_VALUE) goto L16;
        r1.put("param_int_first", r10);     // Catch: Throwable -> L60
    L16:
        if (r11 == Integer.MAX_VALUE) goto L18;
        r1.put("param_int_second", r11);     // Catch: Throwable -> L60
    L18:
        if (r12 != null) goto L20;
    L58:
        i(r7, "O016", r1);     // Catch: Throwable -> L60
        return;
    L20:
        if (TextUtils.isEmpty(r12.e) == true) goto L23;
        r1.put("dns", r12.e);     // Catch: Throwable -> L60
    L23:
        if (TextUtils.isEmpty(r12.f) == true) goto L26;
        r1.put("domain", r12.f);     // Catch: Throwable -> L60
    L26:
        if (TextUtils.isEmpty(r12.g) == true) goto L29;
        r1.put("type", r12.g);     // Catch: Throwable -> L60
    L29:
        if (TextUtils.isEmpty(r12.h) == true) goto L32;
        r1.put("reason", r12.h);     // Catch: Throwable -> L60
    L32:
        if (TextUtils.isEmpty(r12.j) == true) goto L35;
        r1.put("ip", r12.j);     // Catch: Throwable -> L60
    L35:
        if (TextUtils.isEmpty(r12.i) == true) goto L37;
        r1.put("stack", r12.i);     // Catch: Throwable -> L60
    L37:
        long r13 = r12.b;     // Catch: Throwable -> L60
        long r14 = r12.a;     // Catch: Throwable -> L60
        long r2 = 0;
        if (r13 > r14) goto L40;
        long r4 = 0;
    L42:
        if (r4 > 0) goto L44;
    L48:
        long r15 = r12.d;     // Catch: Throwable -> L60
        long r16 = r12.c;     // Catch: Throwable -> L60
        long r5 = r15 - r16;     // Catch: Throwable -> L60
        if (r5 > 0) goto L52;
        r5 = 0;
    L52:
        if (r5 <= 0) goto L58;
        long r17 = r15 - r16;     // Catch: Throwable -> L60
        if (r17 <= 0) goto L57;
        r2 = r17;
    L57:
        r1.put("ntime", String.valueOf(r2));     // Catch: Throwable -> L60
        goto L58
    L44:
        if (r13 > r14) goto L46;
        long r18 = 0;
    L47:
        r1.put("ctime", String.valueOf(r18));     // Catch: Throwable -> L60
        goto L48
    L46:
        r18 = r13 - r14;     // Catch: Throwable -> L60
        goto L47
    L40:
        r4 = r13 - r14;     // Catch: Throwable -> L60
        goto L42
    L66:
        return;
    }
}
