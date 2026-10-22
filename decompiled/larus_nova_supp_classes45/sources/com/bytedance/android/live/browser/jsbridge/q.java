package com.bytedance.android.live.browser.jsbridge;

import android.app.Activity;
import android.webkit.WebView;
import com.bytedance.android.live.browser.jsbridge.newmethods.AlertMethod;
import com.bytedance.android.live.browser.jsbridge.newmethods.CallPhoneMethod;
import com.bytedance.android.live.browser.jsbridge.newmethods.DialogMethod;
import com.bytedance.android.live.browser.jsbridge.newmethods.FetchV3Method;
import com.bytedance.android.live.browser.jsbridge.newmethods.a3;
import com.bytedance.android.live.browser.jsbridge.newmethods.a8;
import com.bytedance.android.live.browser.jsbridge.newmethods.ae;
import com.bytedance.android.live.browser.jsbridge.newmethods.b4;
import com.bytedance.android.live.browser.jsbridge.newmethods.be;
import com.bytedance.android.live.browser.jsbridge.newmethods.ce;
import com.bytedance.android.live.browser.jsbridge.newmethods.d2;
import com.bytedance.android.live.browser.jsbridge.newmethods.d3;
import com.bytedance.android.live.browser.jsbridge.newmethods.de;
import com.bytedance.android.live.browser.jsbridge.newmethods.e2;
import com.bytedance.android.live.browser.jsbridge.newmethods.e3;
import com.bytedance.android.live.browser.jsbridge.newmethods.e8;
import com.bytedance.android.live.browser.jsbridge.newmethods.ed;
import com.bytedance.android.live.browser.jsbridge.newmethods.f2;
import com.bytedance.android.live.browser.jsbridge.newmethods.h5;
import com.bytedance.android.live.browser.jsbridge.newmethods.jc;
import com.bytedance.android.live.browser.jsbridge.newmethods.l5;
import com.bytedance.android.live.browser.jsbridge.newmethods.m5;
import com.bytedance.android.live.browser.jsbridge.newmethods.n1;
import com.bytedance.android.live.browser.jsbridge.newmethods.p8;
import com.bytedance.android.live.browser.jsbridge.newmethods.q1;
import com.bytedance.android.live.browser.jsbridge.newmethods.rc;
import com.bytedance.android.live.browser.jsbridge.newmethods.t3;
import com.bytedance.android.live.browser.jsbridge.newmethods.u0;
import com.bytedance.android.live.browser.jsbridge.newmethods.u5;
import com.bytedance.android.live.browser.jsbridge.newmethods.ub;
import com.bytedance.android.live.browser.jsbridge.newmethods.v5;
import com.bytedance.android.live.browser.jsbridge.newmethods.vb;
import com.bytedance.android.live.browser.jsbridge.newmethods.xa;
import com.bytedance.android.live.browser.jsbridge.newmethods.xc;
import com.bytedance.android.live.browser.jsbridge.newmethods.y7;
import com.bytedance.android.live.browser.jsbridge.newmethods.zc;
import com.bytedance.android.livesdk.config.ni1;
import com.bytedance.android.livesdk.config.pi1;
import com.bytedance.android.livesdk.config.w30;
import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager;
import com.bytedance.android.livesdkapi.hybridapi.ILiveHybridContainer;
import com.bytedance.android.livesdkapi.hybridapi.IMiddlewareJsBridgeManager;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import w20.td;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class q implements IMiddlewareJsBridgeManager {

    public static final class a implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new v5.d();
        }
    }

    public static final class b implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new q1();
        }
    }

    public static final class c implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new ae();
        }
    }

    public static final class d implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new h30.f.a();
        }
    }

    public static final class e implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new h30.f.b();
        }
    }

    public static final class f implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new td();
        }
    }

    public static final class g implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final g a = null;

        static {
            a = new g();
        }

        public g() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new AlertMethod();
        }
    }

    public static final class h implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final h a = null;

        static {
            a = new h();
        }

        public h() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new AlertMethod();
        }
    }

    public static final class i implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final i a = null;

        static {
            a = new i();
        }

        public i() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new xc();
        }
    }

    public static final class j implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final j a = null;

        static {
            a = new j();
        }

        public j() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new DialogMethod();
        }
    }

    public static final class k implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final k a = null;

        static {
            a = new k();
        }

        public k() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new p8();
        }
    }

    public static final class l implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ com.bytedance.ies.web.jsbridge2.d0 a;

        public l(com.bytedance.ies.web.jsbridge2.d0 r1) {
            this.a = r1;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            com.bytedance.ies.web.jsbridge2.d0 r1 = this.a;
            if (r1 == null) goto L5;
            WebView r2 = r1.b;
        L7:
            return new com.bytedance.android.livesdk.jsbridge.methods.z(r2);
        L5:
            r2 = null;
            goto L7
        }
    }

    public static final class m implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final m a = null;

        static {
            a = new m();
        }

        public m() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new vb();
        }
    }

    public static final class n implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final n a = null;

        static {
            a = new n();
        }

        public n() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new f2();
        }
    }

    public static final class o implements com.bytedance.ies.web.jsbridge2.f.b {
        public o(com.bytedance.ies.web.jsbridge2.d0 r1) {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new t3();
        }
    }

    public static final class p implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final p a = null;

        static {
            a = new p();
        }

        public p() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new d3();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.browser.jsbridge.q$q, reason: collision with other inner class name */
    public static final class C0124q implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ com.bytedance.ies.web.jsbridge2.d0 a;

        public C0124q(com.bytedance.ies.web.jsbridge2.d0 r1) {
            this.a = r1;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            if (((Boolean) ni1.a.getValue()).booleanValue() == false) goto L6;
            return new FetchV3Method();
        L6:
            if (((Boolean) pi1.a.getValue()).booleanValue() == true) goto L15;
            com.bytedance.ies.web.jsbridge2.d0 r1 = this.a;
            if (r1 == null) goto L11;
            WebView r2 = r1.b;
        L13:
            return new a3(r2);
        L11:
            r2 = null;
            goto L13
        L15:
            return new e3();
        }
    }

    public static final class r implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final r a = null;

        static {
            a = new r();
        }

        public r() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new h5();
        }
    }

    public static final class s implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ IJsBridgeManager a;

        public s(IJsBridgeManager r1) {
            this.a = r1;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new n1(this.a);
        }
    }

    public static final class t implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final t a = null;

        static {
            a = new t();
        }

        public t() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new CallPhoneMethod();
        }
    }

    public static final class u implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final u a = null;

        static {
            a = new u();
        }

        public u() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new zc();
        }
    }

    public static final class v implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final v a = null;

        static {
            a = new v();
        }

        public v() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new l5();
        }
    }

    public static final class w implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final w a = null;

        static {
            a = new w();
        }

        public w() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new CallPhoneMethod();
        }
    }

    public static final class x implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ ILiveHybridContainer a;

        public x(ILiveHybridContainer r1) {
            this.a = r1;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new b4(this.a);
        }
    }

    public static final class y implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final y a = null;

        static {
            a = new y();
        }

        public y() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new m5();
        }
    }

    public static final class z implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final z a = null;

        static {
            a = new z();
        }

        public z() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new e8();
        }
    }

    public q() {
    }

    public final Map<String, com.bytedance.ies.web.jsbridge2.f.b> registerDefaultStatefulMethods(ILiveHybridContainer r3, Activity r4, com.bytedance.ies.web.jsbridge2.d0 r5, IJsBridgeManager r6) {
        Intrinsics.checkNotNullParameter(r4, "activity");
        Intrinsics.checkNotNullParameter(r5, "jsBridge2");
        Intrinsics.checkNotNullParameter(r6, "jsBridgeManager");
        Map<String, com.bytedance.ies.web.jsbridge2.f.b> r7 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("appInfo", new l(r5)), TuplesKt.to("canIUse", new s(r6)), TuplesKt.to("callPhone", t.a), TuplesKt.to("showLoading", u.a), TuplesKt.to("hideLoading", v.a), TuplesKt.to("makePhoneCall", w.a), TuplesKt.to("getContainerID", new x(r3)), TuplesKt.to("imageToast", y.a), TuplesKt.to("handleNotificationSettings", z.a), TuplesKt.to("changePpeEnv", b.a), TuplesKt.to("vibrate", c.a), TuplesKt.to("checkPermission", d.a), TuplesKt.to("requestPermission", e.a), TuplesKt.to("screenShotLocalTest", f.a), TuplesKt.to("app.showModal", g.a), TuplesKt.to("showModal", h.a), TuplesKt.to("showLeaveRoomDialog", i.a), TuplesKt.to("dialog", j.a), TuplesKt.to("openCommentPanel", k.a), TuplesKt.to("sendPublicScreenTextMessage", m.a), TuplesKt.to("comment", n.a), TuplesKt.to("getAppInfo", new o(r5)), TuplesKt.to("fetchPb", p.a), TuplesKt.to("fetch", new C0124q(r5)), TuplesKt.to("getStrategyFactor", r.a)});
        if (((Boolean) w30.a.getValue()).booleanValue() == false) goto L5;
        r7.put("setStorage", a.a);
    L5:
        sl2.a.b.provideStatefulMethods(r7);
        return r7;
    }

    public final Map<String, com.bytedance.ies.web.jsbridge2.g<?, ?>> registerDefaultStatelessMethods(ILiveHybridContainer r3, Activity r4, com.bytedance.ies.web.jsbridge2.d0 r5, IJsBridgeManager r6) {
        Intrinsics.checkNotNullParameter(r4, "activity");
        Intrinsics.checkNotNullParameter(r5, "jsBridge2");
        Intrinsics.checkNotNullParameter(r6, "jsBridgeManager");
        Map<String, com.bytedance.ies.web.jsbridge2.g<?, ?>> r7 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("getStorage", new v5.a()), TuplesKt.to("removeStorage", new v5.b()), TuplesKt.to("webviewNavigation", new de(r5.b)), TuplesKt.to("toast", new ed()), TuplesKt.to("close", new d2(r4)), TuplesKt.to("closeAndOpen", new e2(r4, null)), TuplesKt.to("handleSharedKv", new rc()), TuplesKt.to("isTeenMode", new u5()), TuplesKt.to("sendMonitor", new a8()), TuplesKt.to("sendLogV1", new ub()), TuplesKt.to("reportADLog", new xa()), TuplesKt.to("setSideslip", new jc(r3)), TuplesKt.to("pull_down_height", new ce()), TuplesKt.to("dialogPullDownClose", new be()), TuplesKt.to("monitorLynx", new y7()), TuplesKt.to("setBottomBannerVisibility", new u0())});
        if (((Boolean) w30.a.getValue()).booleanValue() == true) goto L5;
        r7.put("setStorage", new v5.c());
    L5:
        return r7;
    }
}
