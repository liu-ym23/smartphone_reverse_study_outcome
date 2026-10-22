package com.loc;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.rpc.internal.RpcUtils;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Locale;
import org.apache.logging.log4j.message.StructuredDataId;

/* JADX INFO: loaded from: classes3.dex */
public final class dl {
    static int A = -1;
    public static String[] D = null;
    public static String E = null;
    private static boolean K = false;
    private static volatile boolean Q;
    dp B;
    String C;
    boolean F;
    IntentFilter G;
    LocationManager H;
    private int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private String f5441J;
    private String L;
    private boolean M;
    private Handler N;
    private eb O;
    private String P;
    private dm R;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Context f5442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    ConnectivityManager f5443b;
    eg c;
    du d;
    ei e;
    eq f;
    ArrayList<db> g;
    a h;
    AMapLocationClientOption i;
    es j;
    long k;
    er l;
    boolean m;
    eo n;
    StringBuilder o;
    boolean p;
    boolean q;
    AMapLocationClientOption.GeoLanguage r;
    boolean s;
    boolean t;
    StringBuilder u;
    boolean v;
    public boolean w;
    int x;
    dr y;
    boolean z;

    /* JADX INFO: renamed from: com.loc.dl$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f5444a = null;

        static {
            int[] r0 = new int[AMapLocationClientOption.GeoLanguage.values().length];
            f5444a = r0;
            r0[AMapLocationClientOption.GeoLanguage.DEFAULT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f5444a[AMapLocationClientOption.GeoLanguage.ZH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f5444a[AMapLocationClientOption.GeoLanguage.EN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    class a extends PluginBroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ dl f5445a;

        a(dl r1) {
            this.f5445a = r1;
        }

        public final void onReceive(Context r3, Intent r4) {
            if (((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin")) == null) goto L48;
            if (r4 == null) goto L49;
            String r5 = r4.getAction();     // Catch: Throwable -> L34
            if (TextUtils.isEmpty(r5) == false) goto L10;
            return;
        L10:
            if (r5.equals("android.net.wifi.SCAN_RESULTS") == false) goto L23;
            if (this.f5445a.c == null) goto L38;
            this.f5445a.c.j();     // Catch: Throwable -> L34
        L38:
            if (r4.getExtras() != null) goto L17;
            return;
        L17:
            if (r4.getExtras().getBoolean("resultsUpdated", true) == true) goto L19;
            return;
        L19:
            if (this.f5445a.c == null) goto L43;
            this.f5445a.c.i();     // Catch: Throwable -> L37
            return;
        L43:
            return;
        L44:
            return;
        L23:
            if (r5.equals("android.net.wifi.WIFI_STATE_CHANGED") == false) goto L29;
            if (this.f5445a.c == null) goto L45;
            this.f5445a.c.k();     // Catch: Throwable -> L34
            return;
        L45:
            return;
        L29:
            if (r5.equals("android.net.wifi.STATE_CHANGE") == true) goto L31;
            return;
        L31:
            if (this.f5445a.c == null) goto L47;
            this.f5445a.c.h();     // Catch: Throwable -> L34
            return;
        L47:
            return;
        L34:
            th = move-exception;
            ev.a(th, "Aps", "onReceive");
            return;
        L49:
            return;
        }
    }

    static {
        D = new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"};
        E = "android.permission.ACCESS_BACKGROUND_LOCATION";
        Q = false;
    }

    public dl(boolean r5) {
        this.f5442a = ZeusTransformUtils.wrapperContext(null, "com.obric.memorydata.plugin");
        this.f5443b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = new ArrayList();
        this.h = null;
        this.i = new AMapLocationClientOption();
        this.j = null;
        this.k = 0;
        this.I = 0;
        this.l = null;
        this.m = false;
        this.f5441J = null;
        this.n = null;
        this.o = new StringBuilder();
        this.p = true;
        this.q = true;
        this.r = AMapLocationClientOption.GeoLanguage.DEFAULT;
        this.s = true;
        this.t = false;
        this.L = null;
        this.u = null;
        this.v = false;
        this.w = false;
        this.x = 12;
        this.M = true;
        this.y = null;
        this.z = false;
        this.B = null;
        this.C = null;
        this.F = false;
        this.G = null;
        this.H = null;
        this.F = r5;
    }

    private static es a(int r2, String r3) {
        es r0 = new es("");
        r0.setErrorCode(r2);
        r0.setLocationDetail(r3);
        if (r2 != 15) goto L5;
        fb.a(null, 2151);
    L5:
        return r0;
    }

    private es a(es r7, aq r8, em r9) {
        if (r8 != null) goto L31;
    L24:
        r7.setErrorCode(4);     // Catch: Throwable -> L28
        this.o.append("网络异常,请求异常#0403");     // Catch: Throwable -> L28
        r9.f("#0403");     // Catch: Throwable -> L28
        r7.h(this.u.toString());     // Catch: Throwable -> L28
        r7.setLocationDetail(this.o.toString());     // Catch: Throwable -> L28
        if (r8 == null) goto L27;
        fb.a(r8.d, 2041);     // Catch: Throwable -> L28
    L27:
        return r7;
    L31:
    L28:
        th = move-exception;
        r7.setErrorCode(4);
        ev.a(th, "Aps", "checkResponseEntity");
        r9.f("#0403");
        this.o.append("check response exception ex is" + th.getMessage() + "#0403");
        r7.setLocationDetail(this.o.toString());
        return r7;
    L5:
        if (r8.f5322a == null) goto L24;
        if (r8.f5322a.length == 0) goto L24;
        eq r2 = new eq();     // Catch: Throwable -> L28
        String r3 = new String(r8.f5322a, RpcUtils.CHARSET_UTF8);     // Catch: Throwable -> L28
        if (r3.contains("\"status\":\"0\"") == false) goto L14;
        es r10 = r2.a(r3, this.f5442a, r8, r9);     // Catch: Throwable -> L28
        r10.h(this.u.toString());     // Catch: Throwable -> L28
        return r10;
    L14:
        if (r3.contains("</body></html>") == false) goto L23;
        r7.setErrorCode(5);     // Catch: Throwable -> L28
        eg r11 = this.c;     // Catch: Throwable -> L28
        if (r11 != null) goto L18;
    L20:
        r9.f("#0502");     // Catch: Throwable -> L28
        this.o.append("请求可能被劫持了#0502");     // Catch: Throwable -> L28
        fb.a(null, 2052);     // Catch: Throwable -> L28
    L21:
        r7.setLocationDetail(this.o.toString());     // Catch: Throwable -> L28
        return r7;
    L18:
        if (r11.a(this.f5443b) == false) goto L20;
        r9.f("#0501");     // Catch: Throwable -> L28
        this.o.append("您连接的是一个需要登录的网络，请确认已经登入网络#0501");     // Catch: Throwable -> L28
        fb.a(null, 2051);     // Catch: Throwable -> L28
        goto L21
    L23:
        return null;
    }

    private StringBuilder a(StringBuilder r3) {
        if (r3 != null) goto L4;
        r3 = new StringBuilder(TypedValues.TransitionType.TYPE_DURATION);
    L5:
        du r0 = this.d;
        if (r0 != null) goto L8;
    L10:
        return r3;
    L8:
        if (this.c == null) goto L10;
        r3.append(r0.m());
        r3.append(this.c.p());
        goto L10
    L4:
        r3.delete(0, r3.length());
        goto L5
    }

    private boolean a(long r6) {
        if (this.M == true) goto L7;
        this.M = true;
        return false;
    L7:
        if ((fd.b() - r6) >= 800) goto L15;
        long r7 = 0;
        if (fd.a(this.j) == false) goto L12;
        r7 = fd.a() - this.j.getTime();
    L12:
        if (r7 > 10000) goto L15;
        return true;
    L15:
        return false;
    }

    private es b(boolean r12, em r13) {
        if (TextUtils.isEmpty(this.P) == false) goto L6;
        this.P = fx.b(fp.a(this.f5442a) + "," + fp.f(this.f5442a));     // Catch: Throwable -> L99
    L6:
        this.o.append("#id:").append(this.P);     // Catch: Throwable -> L99
    L7:
        String r2 = "";
        es r1 = new es("");
        String r3 = null;
        byte[] r6 = n();     // Catch: Throwable -> L96
        long r4 = fd.b();
        this.k = r4;
        r13.a(r4);
        ev.c(this.f5442a);     // Catch: Throwable -> L75
        ep r14 = this.n.a(this.f5442a, r6, ev.a(), ev.b(), r12);     // Catch: Throwable -> L75
        r14.c();     // Catch: Throwable -> L75
        String r5 = r14.p();     // Catch: Throwable -> L75
        fn.a(this.f5442a);     // Catch: Throwable -> L75
        if (TextUtils.isEmpty(r5) == false) goto L13;
    L15:
        boolean r7 = false;
    L16:
        int r8 = el.f5495a;     // Catch: Throwable -> L75
        if (fn.a() == false) goto L23;
        if (fn.c() == false) goto L23;
        if (r7 == false) goto L23;
        r8 = el.f5496b;     // Catch: Throwable -> L75
    L23:
        if (fn.b() == true) goto L26;
        r3 = el.a(this.f5442a).a(r14, r8);     // Catch: Throwable -> L75
    L26:
        if (r8 != el.f5496b) goto L28;
        String r9 = "v6";
    L29:
        r13.a(r9);     // Catch: Throwable -> L75
        aq r15 = this.n.a(r14);     // Catch: Throwable -> L75
        long r10 = fd.b();     // Catch: Throwable -> L75
        if (TextUtils.isEmpty(r3) == true) goto L36;
        if (r15.f == true) goto L34;
        el.a(this.f5442a).a(true, r8);     // Catch: Throwable -> L75
        goto L36
    L34:
        el.a(this.f5442a).a(false, r8);     // Catch: Throwable -> L75
        el.a(this.f5442a).a(r8);     // Catch: Throwable -> L75
    L36:
        if (r15 != null) goto L38;
    L43:
        r13.d("SUCCESS");     // Catch: Throwable -> L75
    L44:
        dm r11 = this.R;     // Catch: Throwable -> L75
        if (r11 == null) goto L47;
        r11.d();     // Catch: Throwable -> L75
    L47:
        r13.b(r10);
        if (r15 != null) goto L50;
        String r0 = "";
    L54:
        es r16 = a(r1, r15, r13);
        if (r16 == null) goto L57;
        return r16;
    L57:
        byte[] r17 = eh.b(r15.f5322a);
        if (r17 != null) goto L61;
        r1.setErrorCode(5);
        r13.f("#0503");
        this.o.append("解密数据失败#0503");
        r1.setLocationDetail(this.o.toString());
        fb.a(r0, 2053);
        return r1;
    L61:
        es r18 = this.f.a(r1, r17, r13);
        if (fd.a(r18) == true) goto L73;
        String r19 = r18.b();
        this.f5441J = r19;
        if (TextUtils.isEmpty(r19) == true) goto L66;
        int r20 = 2062;
    L67:
        fb.a(r0, r20);
        r18.setErrorCode(6);
        r13.f("#0601");
        StringBuilder r110 = this.o;
        StringBuilder r21 = new StringBuilder("location faile retype:").append(r18.d()).append(" rdesc:");
        if (TextUtils.isEmpty(this.f5441J) == true) goto L71;
        r2 = this.f5441J;
    L71:
        r110.append(r21.append(r2).append("#0601").toString());
        r18.h(this.u.toString());
        r18.setLocationDetail(this.o.toString());
        return r18;
    L66:
        r20 = 2061;
        goto L67
    L73:
        c(r18);
        r18.setOffset(this.q);
        r18.a(this.p);
        r18.f(String.valueOf(this.r));
        r18.e("new");
        r18.setLocationDetail(this.o.toString());
        this.C = r18.a();
        return r18;
    L50:
        if (TextUtils.isEmpty(r15.c) == true) goto L52;
        this.o.append("#csid:" + r15.c);
    L52:
        r0 = r15.d;
        r1.h(this.u.toString());
        goto L54
    L38:
        if (TextUtils.isEmpty(r3) == true) goto L43;
        if (r15.f == true) goto L42;
        r13.b(r3);     // Catch: Throwable -> L75
        r13.c("SUCCESS");     // Catch: Throwable -> L75
        goto L44
    L42:
        r13.b(r3);     // Catch: Throwable -> L75
        r13.c("FAIL");     // Catch: Throwable -> L75
        goto L43
    L28:
        r9 = "v4";
        goto L29
    L13:
        if (r5.contains("dualstack") == false) goto L15;
        r7 = true;
    L75:
        th = move-exception;
        fd.b();
        r13.d("FAIL");
        el.a(this.f5442a).a(false, el.f5495a);
        ev.a(th, "Aps", "getApsLoc req");
        fb.a("/mobile/binary", th);
        if (fd.d(this.f5442a) == true) goto L81;
        r13.f("#0401");
        StringBuilder r111 = this.o;
        String r112 = "网络异常，未连接到网络，请连接网络#0401";
    L79:
        r111.append(r112);
    L94:
        es r113 = a(4, this.o.toString());
        r113.h(this.u.toString());
        return r113;
    L81:
        if (ZeusTransformUtils.instanceOf(th, l.class) == true) goto L83;
        StringBuilder r22 = new StringBuilder("#0403,");
    L93:
        r13.f(r22.append(th.getMessage()).toString());
        this.o.append("网络异常,请求异常#0403");
        goto L94
    L83:
        if (((l) ZeusTransformUtils.preCheckCast(th, l.class, "com.obric.memorydata.plugin")).a().contains("网络异常状态码") == false) goto L86;
        r13.f("#0404");
        this.o.append("网络异常，状态码错误#0404").append(((l) ZeusTransformUtils.preCheckCast(th, l.class, "com.obric.memorydata.plugin")).f());
        goto L94
    L86:
        if (((l) ZeusTransformUtils.preCheckCast(th, l.class, "com.obric.memorydata.plugin")).f() != 23) goto L88;
    L91:
        r13.f("#0402");
        r111 = this.o;
        r112 = "网络异常，连接超时#0402";
        goto L79
    L88:
        if (Math.abs((fd.b() - this.k) - this.i.getHttpTimeOut()) < 500) goto L91;
        r22 = new StringBuilder("#0403,");
    L96:
        th = move-exception;
        r13.f("#0301");
        this.o.append("get parames error:" + th.getMessage() + "#0301");
        fb.a(null, 2031);
        es r114 = a(3, this.o.toString());
        r114.h(this.u.toString());
        return r114;
    }

    private void b(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (r4.checkCallingOrSelfPermission(fx.c("EYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFQ1VSRV9TRVRUSU5HUw==")) != 0) goto L10;
        this.m = true;     // Catch: Throwable -> L7
        return;
    L10:
        return;
    }

    private String c(em r17) {
        du r2 = this.d;
        String r3 = "";
        if (r2 != null) goto L5;
        return "";
    L5:
        if (this.c == null) goto L154;
        int r4 = r2.h();
        dt r5 = this.d.e();
        dt r6 = this.d.f();
        ArrayList<db> r7 = this.g;
        if (r7 != null) goto L10;
    L13:
        boolean r8 = true;
    L15:
        if (r5 != null) goto L89;
        if (r6 != null) goto L89;
        if (r8 == false) goto L89;
        if (this.f5443b != null) goto L22;
        this.f5443b = (ConnectivityManager) ZeusTransformUtils.preCheckCast(fd.a(this.f5442a, "connectivity"), ConnectivityManager.class, "com.obric.memorydata.plugin");
    L22:
        if (fd.c() < 31) goto L30;
        if (fd.a(this.f5442a) == false) goto L36;
        if (this.c.m() == true) goto L36;
        this.x = 18;
        this.o.append("飞行模式下关闭了WIFI开关，请关闭飞行模式或者打开WIFI开关#1802");
        fb.a(null, 2132);
        r17.f("#1802");
        return "";
    L36:
        if (fd.c() < 28) goto L45;
        if (this.H != null) goto L41;
        this.H = (LocationManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f5442a.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("location"), LocationManager.class, "com.obric.memorydata.plugin");
    L41:
        if (((Boolean) ZeusTransformUtils.preCheckCast(ez.a(this.H, "isLocationEnabled", new Object[0]), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L45;
        this.x = 12;
        this.o.append("定位服务没有开启，请在设置中打开定位服务开关#1206");
        r17.f("#1206");
        fb.a(null, 2121);
        return "";
    L45:
        if (fd.e(this.f5442a) == true) goto L49;
        this.x = 12;
        this.o.append("定位权限被禁用,请授予应用定位权限#1201");
        r17.f("#1201");
        fb.a(null, 2121);
        return "";
    L49:
        if (fd.c() >= 24) goto L51;
    L56:
        String r9 = this.d.k();
        String r10 = this.c.d();
        if (this.c.a(this.f5443b) == false) goto L61;
        if (r10 == null) goto L61;
        this.x = 12;
        r17.f("#1202");
        this.o.append("获取基站与获取WIFI的权限都被禁用，请在安全软件中打开应用的定位权限#1202");
        fb.a(null, 2121);
        return "";
    L61:
        if (r9 == null) goto L69;
        this.x = 12;
        if (this.c.l() == true) goto L65;
        r17.f("#1204");
        StringBuilder r0 = this.o;
        String r1 = "WIFI开关关闭，并且获取基站权限被禁用，请在安全软件中打开应用的定位权限或者打开WIFI开关#1204";
    L66:
        r0.append(r1);
        fb.a(null, 2121);
        return "";
    L65:
        r17.f("#1205");
        r0 = this.o;
        r1 = "获取的WIFI列表为空，并且获取基站权限被禁用，请在安全软件中打开应用的定位权限#1205";
        goto L66
    L69:
        if (this.c.l() == true) goto L75;
        if (this.d.n() == true) goto L75;
        this.x = 19;
        r17.f("#1901");
        this.o.append("没有检查到SIM卡，并且WIFI开关关闭，请打开WIFI开关或者插入SIM卡#1901");
        fb.a(null, 2133);
        return "";
    L75:
        if (this.c.l() == true) goto L78;
        r17.f("#1301");
        StringBuilder r11 = this.o;
        String r12 = "获取到的基站为空，并且关闭了WIFI开关，请您打开WIFI开关再发起定位#1301";
    L77:
        r11.append(r12);
        this.x = 13;
        fb.a(null, 2131);
        return "";
    L78:
        r12 = "#1302";
        r17.f("#1302");
        if (this.c.c() == null) goto L83;
        this.o.append("获取到的基站和WIFI信息均为空，请检查是否授予APP定位权限");
        if (fd.f(this.f5442a) == false) goto L85;
    L86:
        r11 = this.o;
    L85:
        this.o.append("或后台运行没有后台定位权限");
        goto L86
    L83:
        this.o.append("获取到的基站和WIFI信息均为空，请移动到有WIFI的区域，若确定当前区域有WIFI，请检查是否授予APP定位权限");
        if (fd.f(this.f5442a) == true) goto L86;
    L51:
        if (fd.c() >= 28) goto L56;
        if (Settings.Secure.getInt(this.f5442a.getContentResolver(), LocationMonitorConst.LOCATION_MODE, 0) != 0) goto L56;
        this.x = 12;
        r17.f("#1206");
        this.o.append("定位服务没有开启，请在设置中打开定位服务开关#1206");
        fb.a(null, 2121);
        return "";
    L30:
        if (fd.a(this.f5442a) == false) goto L36;
        if (this.c.l() == true) goto L36;
        this.x = 18;
        this.o.append("飞行模式下关闭了WIFI开关，请关闭飞行模式或者打开WIFI开关#1801");
        fb.a(null, 2132);
        r17.f("#1801");
        return "";
    L89:
        boolean r13 = eg.a(this.c.n());
        String r14 = "cgi";
        if (r4 == 0) goto L106;
        if (r4 == 1) goto L99;
        if (r4 == 2) goto L94;
        this.x = 11;
        fb.a(null, 2111);
        r17.f("#1101");
        this.o.append("get cgi failure#1101");
    L146:
        if (TextUtils.isEmpty(r3) == false) goto L148;
        return r3;
    L148:
        if (r3.startsWith("#") == true) goto L151;
        r3 = "#" + r3;
    L151:
        return fd.e() + r3;
    L94:
        if (r5 == null) goto L146;
        StringBuilder r15 = new StringBuilder();
        r15.append(r5.f5466a).append("#");
        r15.append(r5.f5467b).append("#");
        r15.append(r5.h).append("#");
        r15.append(r5.i).append("#");
        r15.append(r5.j).append("#");
        r15.append("network").append("#");
        if (this.g.isEmpty() == false) goto L98;
        if (r13 == true) goto L98;
    L104:
        r15.append(r14);
        r3 = r15.toString();
    L98:
        r14 = "cgiwifi";
        goto L104
    L99:
        if (r5 == null) goto L146;
        r15 = new StringBuilder();
        r15.append(r5.f5466a).append("#");
        r15.append(r5.f5467b).append("#");
        r15.append(r5.c).append("#");
        r15.append(r5.d).append("#");
        r15.append("network").append("#");
        if (this.g.isEmpty() == false) goto L98;
        if (r13 == false) goto L104;
    L106:
        if (this.g.isEmpty() == false) goto L110;
        if (r13 == true) goto L110;
        boolean r16 = false;
    L111:
        if (r6 == null) goto L113;
        boolean r18 = true;
    L114:
        if (r18 == false) goto L116;
    L131:
        String r19 = String.format(Locale.US, "#%s#", new Object[]{"network"});
        if (r18 == false) goto L138;
        r15 = new StringBuilder();
        r15.append(r6.b());
        if (this.g.isEmpty() == false) goto L136;
        if (r13 == true) goto L136;
    L137:
        r15.append("network").append("#");
    L136:
        r14 = "cgiwifi";
        goto L137
    L138:
        if (r16 == false) goto L140;
        r3 = r19 + LocationAnnotation.LightLocationType.LIGHT_LOCATION_WIFI;
        goto L146
    L140:
        this.x = 2;
        if (this.c.l() == true) goto L143;
        r17.f("#0203");
        StringBuilder r20 = this.o;
        String r21 = "当前基站为伪基站,并且关闭了WIFI开关，请在设置中打开WIFI开关#0203";
    L144:
        r20.append(r21);
        fb.a(null, 2022);
        goto L146
    L143:
        r17.f("#0204");
        r20 = this.o;
        r21 = "当前基站为伪基站,并且没有搜索到WIFI，请移动到WIFI比较丰富的区域#0204";
        goto L144
    L116:
        if (r13 == false) goto L122;
        if (this.g.isEmpty() == false) goto L122;
        this.x = 2;
        r17.f("#0201");
        this.o.append("当前基站为伪基站，并且WIFI权限被禁用，请在安全软件中打开应用的定位权限#0201");
        fb.a(null, 2021);
        return "";
    L122:
        if (this.g.size() != 1) goto L131;
        this.x = 2;
        if (r13 == true) goto L128;
        r17.f("#0202");
        this.o.append("当前基站为伪基站，并且搜到的WIFI数量不足，请移动到WIFI比较丰富的区域#0202");
        fb.a(null, 2022);
        return "";
    L128:
        if (((db) ZeusTransformUtils.preCheckCast(this.g.get(0), db.class, "com.obric.memorydata.plugin")).h == false) goto L131;
        r17.f("#0202");
        this.o.append("当前基站为伪基站，并且搜到的WIFI数量不足，请移动到WIFI比较丰富的区域#0202");
        fb.a(null, 2021);
        return "";
    L113:
        r18 = false;
    L110:
        r16 = true;
        goto L111
    L10:
        if (r7.isEmpty() == true) goto L13;
        r8 = false;
        goto L15
    L154:
        return "";
    }

    private static void c(es r2) {
        if (r2.getErrorCode() == 0) goto L5;
        return;
    L5:
        if (r2.getLocationType() == 0) goto L7;
        return;
    L7:
        if ("-5".equals(r2.d()) == false) goto L9;
    L20:
        r2.setLocationType(5);
        return;
    L9:
        if ("1".equals(r2.d()) == true) goto L20;
        if ("2".equals(r2.d()) == true) goto L20;
        if ("14".equals(r2.d()) == true) goto L20;
        if (BDLocationException.ERROR_UNKNOWN.equals(r2.d()) == true) goto L20;
        if (StructuredDataId.RESERVED.equals(r2.d()) == true) goto L20;
        r2.setLocationType(6);
    }

    private void d(es r1) {
        if (r1 == null) goto L5;
        this.j = r1;
        return;
    }

    private void i() {
        if (this.n == null) goto L16;
        if (this.i != null) goto L7;
        this.i = new AMapLocationClientOption();     // Catch: Throwable -> L13
    L7:
        int r0 = j();     // Catch: Throwable -> L13
        eo r1 = this.n;     // Catch: Throwable -> L13
        long r2 = this.i.getHttpTimeOut();     // Catch: Throwable -> L13
        if (this.i.getLocationProtocol().equals(AMapLocationClientOption.AMapLocationProtocol.HTTPS) == false) goto L10;
        boolean r5 = true;
    L11:
        r1.a(r2, r5, r0);     // Catch: Throwable -> L13
        return;
    L10:
        r5 = false;
    L17:
        return;
    }

    private int j() {
        if (this.i.getGeoLanguage() == null) goto L12;
        int r4 = AnonymousClass1.f5444a[this.i.getGeoLanguage().ordinal()];
        if (r4 == 1) goto L12;
        if (r4 == 2) goto L14;
        if (r4 != 3) goto L12;
        return 2;
    L14:
        return 1;
    L12:
        return 0;
    }

    private void k() {
        AMapLocationClientOption.GeoLanguage r0 = AMapLocationClientOption.GeoLanguage.DEFAULT;
        boolean r1 = true;
        r0 = this.i.getGeoLanguage();     // Catch: Throwable -> L17
        boolean r2 = this.i.isNeedAddress();     // Catch: Throwable -> L17
        boolean r3 = this.i.isOffset();     // Catch: Throwable -> L16
        r1 = this.i.isLocationCacheEnable();     // Catch: Throwable -> L15
        this.t = this.i.isOnceLocationLatest();     // Catch: Throwable -> L15
        this.z = this.i.isSensorEnable();     // Catch: Throwable -> L15
        if (r3 == this.q) goto L8;
    L13:
        s();     // Catch: Throwable -> L15
    L19:
        this.q = r3;
        this.p = r2;
        this.s = r1;
        this.r = r0;
        return;
    L8:
        if (r2 != this.p) goto L13;
        if (r1 != this.s) goto L13;
        if (r0 == this.r) goto L19;
    L15:
        boolean r4 = r1;
        r1 = r3;
    L18:
        boolean r5 = r4;
        r3 = r1;
        r1 = r5;
    L16:
        r4 = true;
    L17:
        r2 = true;
        r4 = true;
        goto L18
    }

    private void l() {
        Context r1 = this.f5442a;     // Catch: Throwable -> L9
        if (r1 == null) goto L8;
        a r2 = this.h;     // Catch: Throwable -> L9
        if (r2 == null) goto L8;
        ZeusTransformUtils.unregisterReceiver(r1, r2, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
    L8:
        this.h = null;
        du r0 = this.d;
        if (r0 == null) goto L15;
        r0.a(this.F);
    L15:
        eg r3 = this.c;
        if (r3 == null) goto L26;
        r3.c(this.F);
        return;
    L26:
        return;
    L9:
        th = move-exception;
        ev.a(th, "Aps", "destroy");     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        this.h = null;
        throw th;
    }

    private void m() {
    L10:
        th = move-exception;
        ev.a(th, "Aps", "initBroadcastListener");
        return;
    L3:
        if (this.h != null) goto L6;
        this.h = new a(this);     // Catch: Throwable -> L10
    L6:
        if (this.G != null) goto L8;
        IntentFilter r0 = new IntentFilter();     // Catch: Throwable -> L10
        this.G = r0;     // Catch: Throwable -> L10
        r0.addAction("android.net.wifi.WIFI_STATE_CHANGED");     // Catch: Throwable -> L10
        this.G.addAction("android.net.wifi.SCAN_RESULTS");     // Catch: Throwable -> L10
        this.G.addAction("android.net.wifi.STATE_CHANGE");     // Catch: Throwable -> L10
    L8:
        ZeusTransformUtils.registerReceiver(this.f5442a, this.h, this.G, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    }

    private byte[] n() {
        if (this.l != null) goto L6;
        this.l = new er();
    L6:
        if (this.i != null) goto L9;
        this.i = new AMapLocationClientOption();
    L9:
        if (this.d == null) goto L14;
        if (this.c == null) goto L14;
        this.l.a(this.f5442a, this.i.isNeedAddress(), this.i.isOffset(), this.d, this.c, this.f5443b, this.C, this.O);
    L14:
        return this.l.a();
    }

    private boolean o() {
        if (this.k != 0) goto L6;
        return true;
    L6:
        if ((fd.b() - this.k) <= 20000) goto L8;
        return true;
    L8:
        return false;
    }

    private void p() {
        eg r0 = this.c;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a(this.m);
    }

    private boolean q() {
        eg r0 = this.c;
        if (r0 == null) goto L5;
        this.g = r0.e();
    L5:
        ArrayList<db> r1 = this.g;
        if (r1 != null) goto L8;
    L10:
        return true;
    L8:
        if (r1.size() <= 0) goto L10;
        return false;
    }

    private void r() {
        if (this.L == null) goto L5;
        this.L = null;
    L5:
        StringBuilder r2 = this.u;
        if (r2 == null) goto L9;
        r2.delete(0, r2.length());
        return;
    }

    private void s() {
        ei r0 = this.e;     // Catch: Throwable -> L9
        if (r0 == null) goto L5;
        r0.a();     // Catch: Throwable -> L9
    L5:
        d(null);     // Catch: Throwable -> L9
        this.M = false;     // Catch: Throwable -> L9
        dp r2 = this.B;     // Catch: Throwable -> L9
        if (r2 == null) goto L14;
        r2.a();     // Catch: Throwable -> L9
        return;
    L14:
        return;
    L9:
        th = move-exception;
        ev.a(th, "Aps", "cleanCache");
    }

    public final es a(double r7, double r9) {
        String r0 = this.n.a(this.f5442a, r7, r9);     // Catch: Throwable -> L8
        if (r0.contains("\"status\":\"1\"") == false) goto L6;
        es r6 = this.f.a(r0);     // Catch: Throwable -> L8
        r6.setLatitude(r7);     // Catch: Throwable -> L8
        r6.setLongitude(r9);     // Catch: Throwable -> L8
        return r6;
    L6:
        return null;
    L11:
        return null;
    }

    public final es a(em r18) {
        d();
        r18.e("conitue");
        if (this.f5442a != null) goto L6;
        r18.f("#0101");
        this.o.append("context is null#0101");
        return a(1, this.o.toString());
    L6:
        int r0 = this.I + 1;
        this.I = r0;
        if (r0 != 1) goto L10;
        p();
    L10:
        if (a(this.k) == true) goto L12;
    L20:
        dr r1 = this.y;
        if (r1 == null) goto L104;
        if (this.z == false) goto L25;
        r1.a();
        goto L104
    L25:
        r1.b();
    L104:
    L38:
        th = move-exception;
        ev.a(th, "Aps", "getLocation getScanResultsParam");
    L107:
        du r2 = this.d;     // Catch: Throwable -> L44
        if (r2 == null) goto L46;
        r2.a(false, q());     // Catch: Throwable -> L44
    L46:
        String r3 = c(r18);
        this.L = r3;
        if (TextUtils.isEmpty(r3) == true) goto L49;
        this.u = a(this.u);
        eg r4 = this.c;
        if (r4 != null) goto L53;
    L56:
        boolean r9 = o();
        du r8 = this.d;
        es r5 = null;
        if (r8 == null) goto L61;
        eg r11 = this.c;
        if (r11 == null) goto L61;
        es r7 = this.e.a(r8, r9, this.j, r11, this.u, this.L, this.f5442a, false);
    L63:
        if (fd.a(r7) == false) goto L66;
        r7.setTrustedLevel(2);
    L65:
        d(r7);
    L106:
        if (this.c == null) goto L92;
        if (r7 == null) goto L92;
        long r10 = eg.b();     // Catch: Throwable -> L103
        if (r10 > 15) goto L86;
        r7.setTrustedLevel(1);     // Catch: Throwable -> L103
        goto L92
    L86:
        if (r10 > 120) goto L89;
        r7.setTrustedLevel(2);     // Catch: Throwable -> L103
        goto L92
    L89:
        if (r10 > 600) goto L91;
        r7.setTrustedLevel(3);     // Catch: Throwable -> L103
        goto L92
    L91:
        r7.setTrustedLevel(4);     // Catch: Throwable -> L103
    L92:
        this.e.a(this.L, this.u, r7, this.f5442a, true);
        fd.a(r7);
        StringBuilder r6 = this.u;
        r6.delete(0, r6.length());
        if (r7 != null) goto L95;
    L101:
        d(r7);
        return this.j;
    L95:
        if (this.z == false) goto L99;
        dr r12 = this.y;
        if (r12 == null) goto L99;
        r7.setAltitude(r12.c());
        r7.setBearing(this.y.d());
        float r13 = (float) this.y.e();
    L100:
        r7.setSpeed(r13);
    L99:
        r7.setAltitude(0.0d);
        r13 = 0.0f;
        r7.setBearing(0.0f);
        goto L100
    L66:
        r7 = b(true, r18);
        if (fd.a(r7) == false) goto L71;
        r7.e("new");
        this.e.a(this.u.toString());
        du r14 = this.d;
        if (r14 == null) goto L65;
        this.e.a(r14.e());
        goto L65
    L71:
        du r15 = this.d;
        if (r15 == null) goto L77;
        eg r16 = this.c;
        if (r16 == null) goto L77;
        r5 = this.e.a(r15, false, this.j, r16, this.u, this.L, this.f5442a, true);
    L77:
        if (fd.a(r5) == false) goto L106;
        r18.f("#0001");
        r5.setTrustedLevel(2);
        d(r5);
        r7 = r5;
    L61:
        r7 = null;
        goto L63
    L53:
        if (r4.o() == false) goto L56;
        es r17 = a(15, "networkLocation has been mocked!#1502");
        r18.f("#1502");
        r17.setMock(true);
        r17.setTrustedLevel(4);
        return r17;
    L49:
        return a(this.x, this.o.toString());
    L44:
        th = move-exception;
        ev.a(th, "Aps", "getLocation getCgiListParam");
        goto L46
    L28:
        if (this.i.isOnceLocationLatest() == false) goto L30;
    L33:
        boolean r19 = true;
    L34:
        eg r20 = this.c;     // Catch: Throwable -> L38
        if (r20 == null) goto L107;
        r20.b(r19);     // Catch: Throwable -> L38
        this.g = this.c.e();     // Catch: Throwable -> L38
        goto L107
    L30:
        if (this.i.isOnceLocation() == false) goto L33;
        r19 = false;
        goto L34
    L12:
        if (fd.a(this.j) == false) goto L20;
        if (this.s == false) goto L19;
        if (eu.a(this.j.getTime()) == false) goto L19;
        this.j.setLocationType(2);
    L19:
        return this.j;
    }

    public final es a(es r3) {
        this.B.a(this.s);
        return this.B.a(r3);
    }

    public final es a(boolean r3, em r4) {
        if (r3 == false) goto L4;
        String r0 = "statics";
    L5:
        r4.e(r0);
        if (this.f5442a != null) goto L9;
        r4.f("#0101");
        this.o.append("context is null#0101");
        fb.a(null, 2011);
        return a(1, this.o.toString());
    L9:
        eg r1 = this.c;
        if (r1 != null) goto L12;
    L15:
        b();
        if (TextUtils.isEmpty(this.L) == true) goto L18;
        es r5 = b(r3, r4);
        if (fd.a(r5) == true) goto L22;
    L27:
        Q = true;
        return r5;
    L22:
        if (Q == true) goto L27;
        this.e.a(this.u.toString());
        du r6 = this.d;
        if (r6 == null) goto L26;
        this.e.a(r6.e());
    L26:
        d(r5);
        goto L27
    L18:
        return a(this.x, this.o.toString());
    L12:
        if (r1.o() == false) goto L15;
        r4.f("#1502");
        return a(15, "networkLocation has been mocked!#1502");
    L4:
        r0 = "first";
        goto L5
    }

    public final void a() {
        du r0 = this.d;
        if (r0 == null) goto L6;
        r0.b();
        return;
    }

    public final void a(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
    L19:
        th = move-exception;
        th.printStackTrace();
        ev.a(th, "Aps", "initBase");
        return;
    L4:
        if (this.f5442a == null) goto L6;
        return;
    L6:
        this.B = new dp();     // Catch: Throwable -> L19
        Context r0 = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        this.f5442a = r0;     // Catch: Throwable -> L19
        fd.b(r0);     // Catch: Throwable -> L19
        if (this.c != null) goto L10;
        WifiManager r1 = (WifiManager) ZeusTransformUtils.preCheckCast(fd.a(this.f5442a, LocationAnnotation.LightLocationType.LIGHT_LOCATION_WIFI), WifiManager.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        this.c = new eg(this.f5442a, r1, this.N);     // Catch: Throwable -> L19
    L10:
        if (this.d != null) goto L12;
        this.d = new du(this.f5442a, this.N);     // Catch: Throwable -> L19
    L12:
        this.O = new eb(r6, this.N);     // Catch: Throwable -> L19
        if (this.e != null) goto L16;
        this.e = new ei();     // Catch: Throwable -> L19
    L16:
        if (this.f != null) goto L24;
        this.f = new eq();     // Catch: Throwable -> L19
        return;
    }

    public final void a(Handler r1) {
        this.N = r1;
    }

    public final void a(AMapLocation r4) {
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.getErrorCode() == 0) goto L7;
        return;
    L7:
        ea r0 = new ea();
        r0.f5476a = r4.getLocationType();
        r0.d = r4.getTime();
        r0.e = (int) r4.getAccuracy();
        r0.f5477b = r4.getLatitude();
        r0.c = r4.getLongitude();
        if (r4.getLocationType() != 1) goto L11;
        this.O.a(r0);
    L11:
        if (r4.getLocationType() != 12) goto L14;
        this.O.b(r0);
        return;
    }

    public final void a(AMapLocationClientOption r8) {
        this.i = r8;
        if (r8 != null) goto L5;
        this.i = new AMapLocationClientOption();
    L5:
        eg r1 = this.c;
        if (r1 == null) goto L8;
        this.i.isWifiActiveScan();
        r1.a(this.i.isWifiScan(), this.i.isMockEnable(), AMapLocationClientOption.isOpenAlwaysScanWifi(), r8.getScanWifiInterval());
    L8:
        i();
        ei r9 = this.e;
        if (r9 == null) goto L11;
        r9.a(this.i);
    L11:
        eq r10 = this.f;
        if (r10 == null) goto L14;
        r10.a(this.i);
    L14:
        du r11 = this.d;
        if (r11 == null) goto L17;
        r11.c(this.i.isNoLocReqCgiEnable());
    L17:
        k();
    }

    public final void a(es r4, int r5) {
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.getErrorCode() == 0) goto L7;
        return;
    L7:
        ea r0 = new ea();
        r0.d = r4.getTime();
        r0.e = (int) r4.getAccuracy();
        r0.f5477b = r4.getLatitude();
        r0.c = r4.getLongitude();
        r0.f5476a = r5;
        r0.g = Integer.parseInt(r4.d());
        r0.h = r4.l();
        this.O.c(r0);
    }

    public final void a(boolean r1) {
        du r0 = this.d;
        if (r0 == null) goto L6;
        r0.b(r1);
        return;
    }

    public final es b(boolean r7) {
        eg r0 = this.c;
        if (r0 == null) goto L9;
        if (r0.o() == false) goto L9;
        return a(15, "networkLocation has been mocked!#1502");
    L9:
        if (TextUtils.isEmpty(this.L) == true) goto L11;
        es r8 = this.e.a(this.f5442a, this.L, this.u, true, r7);
        if (fd.a(r8) == false) goto L15;
        d(r8);
    L15:
        return r8;
    L11:
        return a(this.x, this.o.toString());
    }

    public final void b() {
        this.n = eo.a(this.f5442a);
        i();
        if (this.f5443b != null) goto L6;
        this.f5443b = (ConnectivityManager) ZeusTransformUtils.preCheckCast(fd.a(this.f5442a, "connectivity"), ConnectivityManager.class, "com.obric.memorydata.plugin");
    L6:
        if (this.l != null) goto L9;
        this.l = new er();
        return;
    }

    public final void b(em r4) {
    L19:
        th = move-exception;
        ev.a(th, "Aps", "initFirstLocateParam");
    L21:
        this.v = true;
        return;
    L4:
        if (this.v == false) goto L6;
        return;
    L6:
        r();     // Catch: Throwable -> L19
        if (this.t == false) goto L9;
        m();     // Catch: Throwable -> L19
    L9:
        eg r1 = this.c;     // Catch: Throwable -> L19
        if (r1 == null) goto L12;
        r1.b(this.t);     // Catch: Throwable -> L19
        this.g = this.c.e();     // Catch: Throwable -> L19
    L12:
        du r2 = this.d;     // Catch: Throwable -> L19
        if (r2 == null) goto L15;
        r2.a(true, q());     // Catch: Throwable -> L19
    L15:
        String r5 = c(r4);     // Catch: Throwable -> L19
        this.L = r5;     // Catch: Throwable -> L19
        if (TextUtils.isEmpty(r5) == true) goto L21;
        this.u = a(this.u);     // Catch: Throwable -> L19
        goto L21
    }

    public final void b(es r8) {
        if (fd.a(r8) == false) goto L6;
        this.e.a(this.L, this.u, r8, this.f5442a, true);
        return;
    }

    public final void c() {
        if (this.y != null) goto L5;
        this.y = new dr(this.f5442a);
    L5:
        m();
        eg r0 = this.c;
        if (r0 == null) goto L8;
        r0.b(false);
        this.g = this.c.e();
    L8:
        du r1 = this.d;
        if (r1 == null) goto L11;
        r1.a(false, q());
    L11:
        this.e.a(this.f5442a);
        b(this.f5442a);
        this.w = true;
    }

    public final void d() {
        if (this.o.length() <= 0) goto L6;
        StringBuilder r2 = this.o;
        r2.delete(0, r2.length());
        return;
    }

    public final void e() {
        this.C = null;
        this.v = false;
        this.w = false;
        ei r1 = this.e;
        if (r1 == null) goto L5;
        r1.b(this.f5442a);
    L5:
        dp r2 = this.B;
        if (r2 == null) goto L9;
        r2.a();
    L9:
        if (this.f == null) goto L11;
        this.f = null;
    L11:
        eb r3 = this.O;
        if (r3 == null) goto L14;
        r3.a(this.F);
    L14:
        l();
        ArrayList<db> r4 = this.g;
        if (r4 == null) goto L17;
        r4.clear();
    L17:
        dr r5 = this.y;
        if (r5 == null) goto L20;
        r5.f();
    L20:
        this.j = null;
        this.f5442a = ZeusTransformUtils.wrapperContext(null, "com.obric.memorydata.plugin");
        this.u = null;
        this.H = null;
    }

    public final void f() {
        dm r0 = this.R;
        if (r0 == null) goto L6;
        r0.d();
        return;
    }

    public final void g() {
    L14:
        th = move-exception;
        q.b(th, "as", "stc");
        return;
    L3:
        if (this.f5442a != null) goto L6;
        return;
    L6:
        if (this.R != null) goto L8;
        this.R = new dm(this.f5442a);     // Catch: Throwable -> L14
    L8:
        du r0 = this.d;     // Catch: Throwable -> L14
        if (r0 == null) goto L19;
        eg r1 = this.c;     // Catch: Throwable -> L14
        if (r1 == null) goto L20;
        this.R.a(r0, r1, this.N);     // Catch: Throwable -> L14
        return;
    L20:
        return;
    }

    public final void h() {
        dm r0 = this.R;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }
}
