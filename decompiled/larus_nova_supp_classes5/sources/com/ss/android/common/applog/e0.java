package com.ss.android.common.applog;

import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.applog.k;
import com.bytedance.applog.m;
import com.bytedance.applog.q;
import com.bytedance.applog.r;
import com.bytedance.applog.util.UriConstants;
import com.bytedance.bdinstall.i;
import com.bytedance.bdinstall.r0;
import com.bytedance.bdinstall.t;
import com.bytedance.bdinstall.u;
import com.bytedance.common.utility.Logger;
import com.obric.sva.sdk.applog.InteractorAppLogLogger;
import com.ss.android.common.lib.AppLogNewUtils;
import iqa.a;
import ita.h;
import ita.j;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import jta.g;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class e0 implements n {
    public static volatile boolean b = false;
    public static volatile q c = null;
    public static volatile eta.b d = null;
    public static volatile AppLog.f e = null;
    public static volatile String f = null;
    public static volatile a g = null;
    public static volatile String h = null;
    public static volatile String i = null;
    public static volatile String j = "";
    public static volatile boolean k = false;
    public static volatile boolean l = true;
    public static m m;
    public static final Bundle n = null;
    public h a;

    public class b implements k {
        public b() {
        }

        public final void a(JSONObject r2) {
            if (e0.g == null) goto L6;
            e0.g.a(r2);
            return;
        }
    }

    @Override // com.ss.android.common.applog.n
    public final void A() {
        com.bytedance.applog.AppLog.setTouristMode(false);
    }

    @Override // com.ss.android.common.applog.n
    public final void B() {
        com.bytedance.applog.AppLog.setAdjustTerminate(true);
    }

    @Override // com.ss.android.common.applog.n
    public final void D() {
    }

    @Override // com.ss.android.common.applog.n
    public final void G() {
    }

    @Override // com.ss.android.common.applog.n
    public final int H() {
        return 0;
    }

    @Override // com.ss.android.common.applog.n
    public final void k() {
    }

    @Override // com.ss.android.common.applog.n
    public final void l(a0.a r1) {
    }

    @Override // com.ss.android.common.applog.n
    public final void p() {
    }

    @Override // com.ss.android.common.applog.n
    public final void q() {
        com.bytedance.applog.AppLog.setEnableEventUserId(true);
    }

    @Override // com.ss.android.common.applog.n
    public final void r() {
        l = true;
    }

    @Override // com.ss.android.common.applog.n
    public final void t(String r1) {
    }

    static {
        n = new Bundle();
        new ConcurrentHashMap();
    }

    public static void I() {
        Bundle r0 = n;
        if (r0.size() <= 0) goto L16;
        Bundle r1 = new Bundle();
        monitor-enter(r0);
        r1.putAll(r0);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        HashMap r2 = new HashMap();
        Iterator<String> r3 = r1.keySet().iterator();
    L10:
        if (r3.hasNext() == false) goto L12;
        String r4 = r3.next();
        r2.put(r4, r1.get(r4));
        goto L10
    L12:
        com.bytedance.applog.AppLog.setHeaderInfo(r2);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public e0() {
        new ArrayList();
        this.a = null;
    }

    @Override // com.ss.android.common.applog.n
    public final JSONObject C() {
        return com.bytedance.applog.AppLog.getInstance().f.a;
    }

    @Override // com.ss.android.common.applog.n
    public final String getCurrentSessionId() {
        return com.bytedance.applog.AppLog.getSessionId();
    }

    @Override // com.ss.android.common.applog.n
    public final String getInstallId() {
        return com.bytedance.applog.AppLog.getIid();
    }

    @Override // com.ss.android.common.applog.n
    public final String getServerDeviceId() {
        return com.bytedance.applog.AppLog.getDid();
    }

    @Override // com.ss.android.common.applog.n
    public final String getUserId() {
        return com.bytedance.applog.AppLog.getUserID();
    }

    @Override // com.ss.android.common.applog.n
    public final m h() {
        return com.bytedance.applog.AppLog.getLogCompressor();
    }

    @Override // com.ss.android.common.applog.n
    public final JSONObject m() {
        return com.bytedance.applog.AppLog.getHeader();
    }

    @Override // com.ss.android.common.applog.n
    public final String w() {
        String r0 = com.bytedance.applog.AppLog.getAbSdkVersion();
        if (TextUtils.isEmpty(r0) == true) goto L6;
        return r0;
    L6:
        return f;
    }

    @Override // com.ss.android.common.applog.n
    public final a E() {
        return g;
    }

    @Override // com.ss.android.common.applog.n
    public final String getSessionKey() {
        return j;
    }

    @Override // com.ss.android.common.applog.n
    public final void a(String r1) {
        f = r1;
        com.bytedance.applog.AppLog.setExternalAbVersion(r1);
    }

    @Override // com.ss.android.common.applog.n
    public final void b(eta.b r3) {
        d = r3;
        i.b.b = new c(r3);
        g.h(r3);
    }

    @Override // com.ss.android.common.applog.n
    public final void c(boolean r1) {
        k = r1;
    }

    @Override // com.ss.android.common.applog.n
    public final void d(Bundle r5) {
        if (r5.size() <= 0) goto L29;
    L20:
        th = move-exception;
        j.c("NewAppLogBdtrackerImpl setCustomerHeader", th);
        return;
    L6:
        if (com.bytedance.applog.AppLog.hasStarted() == false) goto L12;
        HashMap r0 = new HashMap();     // Catch: Throwable -> L20
        Iterator<String> r1 = r5.keySet().iterator();     // Catch: Throwable -> L20
    L9:
        if (r1.hasNext() == false) goto L11;
        String r2 = r1.next();     // Catch: Throwable -> L20
        r0.put(r2, r5.get(r2));     // Catch: Throwable -> L20
        goto L9
    L11:
        com.bytedance.applog.AppLog.setHeaderInfo(r0);     // Catch: Throwable -> L20
        return;
    L12:
        Bundle r3 = n;     // Catch: Throwable -> L20
        monitor-enter(r3);     // Catch: Throwable -> L20
        r3.putAll(r5);     // Catch: Throwable -> L17
        monitor-exit(r3);     // Catch: Throwable -> L17
    L28:
        return;
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    }

    @Override // com.ss.android.common.applog.n
    public final AppLog e(Context r4) {
        Object r1 = AppLog.r0;
        monitor-enter(r1);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (AppLog.s0 != null) goto L9;
        AppLog.s0 = new AppLog(r4);     // Catch: Throwable -> L12
        if (Logger.debug() == false) goto L9;
        j.g("AppLog Process AppLog = " + AppLog.s0.toString() + " pid = " + String.valueOf(Process.myPid()), null);     // Catch: Throwable -> L12
    L9:
        monitor-exit(r1);     // Catch: Throwable -> L12
        return AppLog.s0;
    }

    @Override // com.ss.android.common.applog.n
    public final void f(boolean r1) {
        com.bytedance.applog.AppLog.setNewMonitorEnabled(r1);
    }

    @Override // com.ss.android.common.applog.n
    public final void g(Map<String, String> r3) {
        com.bytedance.applog.AppLog.getSsidGroup(r3);
        String r0 = com.bytedance.applog.AppLog.getUserID();
        if (r0 == null) goto L6;
        ((HashMap) r3).put("user_id", r0);
        return;
    }

    @Override // com.ss.android.common.applog.n
    public final void j(boolean r1) {
        com.bytedance.applog.AppLog.setEventSamplingEnable(r1);
    }

    @Override // com.ss.android.common.applog.n
    public final void n(InteractorAppLogLogger r1) {
        this.a = r1;
    }

    @Override // com.ss.android.common.applog.n
    public final void o(com.obric.sva.sdk.applog.a r1) {
        com.bytedance.applog.AppLog.setBDAccountCallback(r1);
    }

    @Override // com.ss.android.common.applog.n
    public final void onPause(Context r1) {
        com.bytedance.applog.AppLog.onPause(r1);
    }

    @Override // com.ss.android.common.applog.n
    public final void onResume(Context r1) {
        com.bytedance.applog.AppLog.onResume(r1);
    }

    @Override // com.ss.android.common.applog.n
    public final void registerHeaderCustomCallback(a r1) {
        g = r1;
        com.bytedance.applog.AppLog.registerHeaderCustomCallback(new b());
    }

    @Override // com.ss.android.common.applog.n
    public final void setAnonymous(boolean r2) {
        if (b == false) goto L5;
        return;
    L5:
        g.j.setAnonymous(r2);
    }

    @Override // com.ss.android.common.applog.n
    public final void setSessionKey(String r1) {
        j = r1;
    }

    @Override // com.ss.android.common.applog.n
    public final void setUserId(long r1) {
        com.bytedance.applog.AppLog.setUserID(r1);
    }

    @Override // com.ss.android.common.applog.n
    public final void u(AppLog.f r2) {
        if (b == false) goto L5;
        return;
    L5:
        e = r2;
    }

    @Override // com.ss.android.common.applog.n
    public final void v(String r1) {
        h = r1;
    }

    @Override // com.ss.android.common.applog.n
    public final void x(String r1) {
        i = r1;
    }

    @Override // com.ss.android.common.applog.n
    public final boolean y(String r1) {
        return !nx3.k.a(r1);
    }

    @Override // com.ss.android.common.applog.n
    public final void z(m r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (m == null) goto L7;
        boolean r0 = true;
    L8:
        m = r2;
        if (r0 == false) goto L11;
        return;
    L11:
        com.bytedance.applog.AppLog.addEventObserver(new a());
        return;
    L7:
        r0 = false;
        goto L8
    }

    @Override // com.ss.android.common.applog.n
    public final void i(String r1, JSONObject r2) {
        com.bytedance.applog.AppLog.onMiscEvent(r1, r2);
    }

    @Override // com.ss.android.common.applog.n
    public final void F(Context r12, boolean r13, m0 r14) {
        if (d == null) goto L151;
        com.bytedance.applog.AppLog.setBgSessionTaskEnabled(false);
        long r1 = AppLog.t0.get();
        if (r1 > 0) goto L7;
    L9:
        int r2 = g.c();
        c = new q(String.valueOf(r2), g.j.getChannel(r12));
        c.b = true;
        q r3 = c;
        if (r14 != null) goto L12;
        r3.getClass();
        r3.l = UriConstants.a;
    L63:
        c.v = r13;
        if (e != null) goto L154;
        boolean r15 = true;
    L74:
        boolean r16 = true;
    L75:
        com.bytedance.applog.AppLog.setEncryptAndCompress(r15);
        c.x = r16;
        c.g = jta.b.d;
        c.B = false;
        g.j.z();
        if (TextUtils.isEmpty(null) == true) goto L78;
        c.s = null;
    L78:
        c.getClass();
        c.r = "";
        if (TextUtils.isEmpty(h) == true) goto L84;
        q r17 = c;
        String r18 = h;
        r17.getClass();
        if (TextUtils.isEmpty(r18) == true) goto L84;
        r17.y = r18;
    L84:
        if (TextUtils.isEmpty(i) == true) goto L88;
        q r19 = c;
        String r110 = i;
        r19.getClass();
        if (TextUtils.isEmpty(r110) == true) goto L88;
        r19.z = r110;
    L88:
        g.j.i();
        if (TextUtils.isEmpty(null) == true) goto L92;
        c.m = null;
    L95:
        if (TextUtils.isEmpty(null) == true) goto L98;
        c.d = null;
    L98:
        if (TextUtils.isEmpty(null) == true) goto L100;
        c.f = null;
    L100:
        String r111 = jta.b.g;
        if (TextUtils.isEmpty(r111) == true) goto L103;
        c.j = r111;
    L103:
        q r112 = c;
        boolean r113 = AppLog.L;
        r112.F = null;
        q r114 = c;
        g.j.isLocalTest();
        r114.h = false;
        if (TextUtils.isEmpty(d.getAppName()) == true) goto L107;
        c.k = d.getAppName();
    L107:
        if (d.getVersionCode() == 0) goto L110;
        c.o = d.getVersionCode();
    L110:
        if (d.getUpdateVersionCode() == 0) goto L113;
        c.p = d.getUpdateVersionCode();
    L113:
        if (TextUtils.isEmpty(d.getTweakedChannel()) == true) goto L116;
        c.n = d.getTweakedChannel();
    L116:
        if (d.getManifestVersionCode() == 0) goto L119;
        c.q = d.getManifestVersionCode();
    L119:
        if (TextUtils.isEmpty(d.getManifestVersion()) == true) goto L121;
        q r115 = c;
        d.getManifestVersion();
        r115.getClass();
    L121:
        c.C = new d();
        c.t = new e();
        if (this.a == null) goto L124;
        c.E = true;
        f r116 = new f(this);
        c.e = r116;
        j74.a r117 = i.a;
        t.b = r116;
    L125:
        c.D = com.bytedance.applog.AppLog.isTouristMode();
        c.getClass();
        c.u = AppLog.c0;
        q r118 = c;
        boolean r119 = l;
        r118.getClass();
        if (r119 == false) goto L128;
        int r120 = 1;
    L129:
        r118.i = r120;
        c.G = false;
        c.H = true;
        c.I = null;
        com.bytedance.applog.AppLog.init(r12, c);
        if (TextUtils.isEmpty(f) == true) goto L133;
        com.bytedance.applog.AppLog.setExternalAbVersion(f);
    L136:
        if (g != null) goto L141;
        if (AppLog.S == null) goto L141;
        registerHeaderCustomCallback(AppLog.S);
    L141:
        if (m == null) goto L143;
    L145:
        com.bytedance.applog.AppLog.removeHeaderInfo("_debug_flag");
        if (TextUtils.isEmpty(null) == true) goto L148;
        com.bytedance.applog.AppLog.setUserUniqueID(null);
    L148:
        b = true;
        I();
        ApplogServiceImpl.isServicePrepared = true;
        ApplogServiceImpl.handleCachedData();
        j.e("wrapper bdtracker init!");
        return;
    L143:
        if (AppLog.R == null) goto L145;
        z(AppLog.R);
        goto L145
    L133:
        if (TextUtils.isEmpty(AppLog.N) == true) goto L136;
        a(AppLog.N);
        goto L136
    L128:
        r120 = 2;
        goto L129
    L124:
        c.E = false;
        goto L125
    L92:
        if (TextUtils.isEmpty(d.getVersion()) == true) goto L95;
        c.m = d.getVersion();
        goto L95
    L154:
        r15 = e.getEncryptSwitch();     // Catch: Throwable -> L67
    L152:
        r16 = e.getRecoverySwitch();     // Catch: Throwable -> L71
    L71:
        th = move-exception;
        j.c("NewAppLogBdtrackerImpl getRecoverySwitch", th);
    L67:
        th = move-exception;
        j.c("NewAppLogBdtrackerImpl getEncryptSwitch", th);
        r15 = true;
        goto L152
    L12:
        r.a r4 = new r.a();
        String[] r5 = jta.b.e;
        if (r5 != null) goto L15;
    L22:
        String r8 = null;
    L24:
        if (TextUtils.isEmpty(r8) == false) goto L35;
        String[] r6 = r14.e;
        if (r6 == null) goto L35;
        if (r6.length <= 0) goto L35;
        int r7 = r6.length;
        int r9 = 0;
    L30:
        if (r9 >= r7) goto L35;
        String r10 = r6[r9];
        if (TextUtils.isEmpty(r10) == false) goto L33;
        r9 = r9 + 1;
        goto L30
    L33:
        r8 = r10;
    L35:
        String r11 = jta.b.f;
        if (TextUtils.isEmpty(r11) == false) goto L38;
        r11 = r14.d[0];
    L38:
        r4.e = new u(new r0(r8, r11), false, false, k);
        ArrayList r20 = new ArrayList();
        String[] r21 = r14.a;
        if (r21 != null) goto L41;
    L48:
        String[] r22 = r14.f;
        if (r22 != null) goto L51;
    L58:
        r4.a = (String[]) r20.toArray(new String[r20.size()]);
        r4.b = r14.c;
        if (TextUtils.isEmpty(r14.b) == true) goto L61;
        r4.c = r14.b;
    L62:
        r3.l = new r(r4);
        goto L63
    L61:
        r4.c = r14.g;
        goto L62
    L51:
        if (r22.length <= 0) goto L58;
        int r23 = r22.length;
        int r24 = 0;
    L53:
        if (r24 >= r23) goto L58;
        String r25 = r22[r24];
        if (TextUtils.isEmpty(r25) == true) goto L57;
        r20.add(r25);
    L57:
        r24 = r24 + 1;
        goto L53
    L41:
        if (r21.length <= 0) goto L48;
        int r26 = r21.length;
        int r27 = 0;
    L43:
        if (r27 >= r26) goto L48;
        String r28 = r21[r27];
        if (TextUtils.isEmpty(r28) == true) goto L47;
        r20.add(r28);
    L47:
        r27 = r27 + 1;
        goto L43
    L15:
        if (r5.length <= 0) goto L22;
        int r29 = r5.length;
        int r30 = 0;
    L17:
        if (r30 >= r29) goto L22;
        r8 = r5[r30];
        if (TextUtils.isEmpty(r8) == false) goto L24;
        r30 = r30 + 1;
        goto L17
    L7:
        if (com.bytedance.applog.AppLog.getUserID() != null) goto L9;
        com.bytedance.applog.AppLog.setUserID(r1);
        goto L9
    L151:
        throw new IllegalStateException("wrapper AppContext should be set before init!");
    }

    @Override // com.ss.android.common.applog.n
    public final void s(String r12, String r13, String r14, long r15, long r17, boolean r19, JSONObject r20) {
        String r1 = null;
        if (r20 == null) goto L23;
        if (r20.optInt(AppLogNewUtils.EVENT_SIGN) != 1) goto L23;
        r20.remove(AppLogNewUtils.EVENT_SIGN);
        r20.remove(AppLogNewUtils.EVENT_RESERVED_FIELD_TIME_STAMP);
        r20.remove("ab_sdk_version");
        r1 = r20.toString();     // Catch: ConcurrentModificationException -> L9 Throwable -> L20
    L27:
        goto L11
    L11:
        com.bytedance.applog.AppLog.getInstance().m(r13, r1);
        return;
    L10:
        r1 = AppLogNewUtils.copyJson(r20).toString();     // Catch: Throwable -> L20
    L23:
        if (r20 == null) goto L18;
        r1 = r20.toString();     // Catch: ConcurrentModificationException -> L16 Throwable -> L21
    L22:
        goto L18
    L17:
        r1 = AppLogNewUtils.copyJson(r20).toString();     // Catch: Throwable -> L21
    L18:
        com.bytedance.applog.g r2 = com.bytedance.applog.AppLog.getInstance();
        r2.y0(r12, r13, r14, r15, r17, r1);
    }
}
