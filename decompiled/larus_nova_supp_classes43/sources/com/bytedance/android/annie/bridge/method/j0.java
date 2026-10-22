package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.bridge.JSBridgeManager;
import com.bytedance.android.annie.bridge.method.permission.OpenPermissionSettingsMethod;
import com.bytedance.android.annie.bridge.method.permission.RequestPermissionMethod;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j0 {
    public static final /* synthetic */ int a = 0;

    public static final class a implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final com.bytedance.ies.web.jsbridge2.f a() {
            return new v2();
        }
    }

    public static final class a0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final a0 a = null;

        static {
            a = new a0();
        }

        public a0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f a() {
            return new s1();
        }
    }

    public static final class b implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final com.bytedance.ies.web.jsbridge2.f a() {
            return new com.bytedance.android.annie.bridge.method.w();
        }
    }

    public static final class b0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ JSBridgeManager a;

        public b0(JSBridgeManager r1) {
            this.a = r1;
        }

        public final com.bytedance.ies.web.jsbridge2.f a() {
            return new w0(new WeakReference(this.a.getActivity()), null);
        }
    }

    public static final class c implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final com.bytedance.ies.web.jsbridge2.f a() {
            return new StorageMethods.SetStorageItemMethod();
        }
    }

    public static final class c0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ JSBridgeManager a;

        public c0(JSBridgeManager r1) {
            this.a = r1;
        }

        public final com.bytedance.ies.web.jsbridge2.f a() {
            return new y0(new WeakReference(this.a.getActivity()));
        }
    }

    public static final class d implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final com.bytedance.ies.web.jsbridge2.f a() {
            return new StorageMethods.GetStorageItemMethod();
        }
    }

    public static final class d0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final d0 a = null;

        static {
            a = new d0();
        }

        public d0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f a() {
            return new m2();
        }
    }

    public static final class e implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final com.bytedance.ies.web.jsbridge2.f a() {
            return new StorageMethods.RemoveStorageItemMethod();
        }
    }

    public static final class e0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final e0 a = null;

        static {
            a = new e0();
        }

        public e0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f a() {
            return new com.bytedance.android.annie.bridge.method.g();
        }
    }

    public static final class f implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final com.bytedance.ies.web.jsbridge2.f a() {
            return new n2();
        }
    }

    public static final class f0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final f0 a = null;

        static {
            a = new f0();
        }

        public f0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f a() {
            return new t2();
        }
    }

    public static final class g implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ IHybridComponent a;

        public g(IHybridComponent r1) {
            this.a = r1;
        }

        public final com.bytedance.ies.web.jsbridge2.f a() {
            return new DownloadFileMethod(this.a);
        }
    }

    public static final class g0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final g0 a = null;

        static {
            a = new g0();
        }

        public g0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f a() {
            return new com.bytedance.android.annie.bridge.method.f();
        }
    }

    public static final class h implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ IHybridComponent a;

        public h(IHybridComponent r1) {
            this.a = r1;
        }

        public final com.bytedance.ies.web.jsbridge2.f a() {
            return new SaveDataURLMethod(this.a);
        }
    }

    public static final class h0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final h0 a = null;

        static {
            a = new h0();
        }

        public h0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f a() {
            return new com.bytedance.android.annie.bridge.method.f0();
        }
    }

    public static final class i implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final i a = null;

        static {
            a = new i();
        }

        public i() {
        }

        public final com.bytedance.ies.web.jsbridge2.f a() {
            return new n1();
        }
    }

    public static final class i0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final i0 a = null;

        static {
            a = new i0();
        }

        public i0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f a() {
            return new com.bytedance.android.annie.bridge.method.permission.a();
        }
    }

    public static final class j implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final j a = null;

        static {
            a = new j();
        }

        public j() {
        }

        public final com.bytedance.ies.web.jsbridge2.f a() {
            return new com.bytedance.android.annie.bridge.method.y();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.annie.bridge.method.j0$j0, reason: collision with other inner class name */
    public static final class C0062j0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final C0062j0 a = null;

        static {
            a = new C0062j0();
        }

        public C0062j0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f a() {
            return new RequestPermissionMethod(null);
        }
    }

    public static final class k implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ IHybridComponent a;

        public k(IHybridComponent r1) {
            this.a = r1;
        }

        public final com.bytedance.ies.web.jsbridge2.f a() {
            return new com.bytedance.android.annie.bridge.method.x(this.a);
        }
    }

    public static final class k0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final k0 a = null;

        static {
            a = new k0();
        }

        public k0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f a() {
            return new com.bytedance.android.annie.bridge.method.calendar.g(null);
        }
    }

    public static final class l implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final l a = null;

        static {
            a = new l();
        }

        public l() {
        }

        public final com.bytedance.ies.web.jsbridge2.f a() {
            return new com.bytedance.android.annie.bridge.method.d0();
        }
    }

    public static final class l0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final l0 a = null;

        static {
            a = new l0();
        }

        public l0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f a() {
            return new com.bytedance.android.annie.bridge.method.calendar.o(null);
        }
    }

    public static final class m implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ IHybridComponent a;

        public m(IHybridComponent r1) {
            this.a = r1;
        }

        public final com.bytedance.ies.web.jsbridge2.f a() {
            return new SaveTemplateMethod(this.a);
        }
    }

    public static final class m0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final m0 a = null;

        static {
            a = new m0();
        }

        public m0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f a() {
            return new com.bytedance.android.annie.bridge.method.calendar.r(null);
        }
    }

    public static final class n implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final n a = null;

        static {
            a = new n();
        }

        public n() {
        }

        public final com.bytedance.ies.web.jsbridge2.f a() {
            return new p1();
        }
    }

    public static final class n0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final n0 a = null;

        static {
            a = new n0();
        }

        public n0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f a() {
            return new a1();
        }
    }

    public static final class o implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final o a = null;

        static {
            a = new o();
        }

        public o() {
        }

        public final com.bytedance.ies.web.jsbridge2.f a() {
            return new g1();
        }
    }

    public static final class o0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final o0 a = null;

        static {
            a = new o0();
        }

        public o0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f a() {
            return new a2();
        }
    }

    public static final class p implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ JSBridgeManager a;

        public p(JSBridgeManager r1) {
            this.a = r1;
        }

        public final com.bytedance.ies.web.jsbridge2.f a() {
            return new com.bytedance.android.annie.bridge.method.audio.e(this.a);
        }
    }

    public static final class p0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final p0 a = null;

        static {
            a = new p0();
        }

        public p0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f a() {
            return new r1();
        }
    }

    public static final class q implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final q a = null;

        static {
            a = new q();
        }

        public q() {
        }

        public final com.bytedance.ies.web.jsbridge2.f a() {
            return new com.bytedance.android.annie.bridge.method.audio.f();
        }
    }

    public static final class q0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final q0 a = null;

        static {
            a = new q0();
        }

        public q0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f a() {
            return new com.bytedance.android.annie.bridge.method.g0();
        }
    }

    public static final class r implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final r a = null;

        static {
            a = new r();
        }

        public r() {
        }

        public final com.bytedance.ies.web.jsbridge2.f a() {
            return new OpenPermissionSettingsMethod();
        }
    }

    public static final class s implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ JSBridgeManager a;

        public s(JSBridgeManager r1) {
            this.a = r1;
        }

        public final com.bytedance.ies.web.jsbridge2.f a() {
            return new com.bytedance.android.annie.bridge.method.j(new WeakReference(this.a.getActivity()));
        }
    }

    public static final class t implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ JSBridgeManager a;

        public t(JSBridgeManager r1) {
            this.a = r1;
        }

        public final com.bytedance.ies.web.jsbridge2.f a() {
            return new com.bytedance.android.annie.bridge.method.d(this.a);
        }
    }

    public static final class u implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final u a = null;

        static {
            a = new u();
        }

        public u() {
        }

        public final com.bytedance.ies.web.jsbridge2.f a() {
            return new com.bytedance.android.annie.bridge.method.s();
        }
    }

    public static final class v implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final v a = null;

        static {
            a = new v();
        }

        public v() {
        }

        public final com.bytedance.ies.web.jsbridge2.f a() {
            return new com.bytedance.android.annie.bridge.method.b();
        }
    }

    public static final class w implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ IHybridComponent a;

        public w(IHybridComponent r1) {
            this.a = r1;
        }

        public final com.bytedance.ies.web.jsbridge2.f a() {
            return new com.bytedance.android.annie.bridge.method.l(this.a);
        }
    }

    public static final class x implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ IHybridComponent a;

        public x(IHybridComponent r1) {
            this.a = r1;
        }

        public final com.bytedance.ies.web.jsbridge2.f a() {
            return new com.bytedance.android.annie.bridge.method.k(this.a);
        }
    }

    public static final class y implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ IHybridComponent a;

        public y(IHybridComponent r1) {
            this.a = r1;
        }

        public final com.bytedance.ies.web.jsbridge2.f a() {
            return new d2(this.a);
        }
    }

    public static final class z implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ IHybridComponent a;

        public z(IHybridComponent r1) {
            this.a = r1;
        }

        public final com.bytedance.ies.web.jsbridge2.f a() {
            return new d1(this.a);
        }
    }

    static {
    }

    @JvmStatic
    public static final Map<String, n56.c> a(JSBridgeManager r1, IHybridComponent r10) {
        Intrinsics.checkNotNullParameter(r1, "manager");
        Intrinsics.checkNotNullParameter(r10, "mHybridComponent");
        return MapsKt.mapOf(TuplesKt.to("openLive", new c1(new WeakReference(r1.getActivity()))));
    }

    @JvmStatic
    public static final Map<String, com.bytedance.ies.web.jsbridge2.f.b> b(JSBridgeManager r16, IHybridComponent r17) {
        Intrinsics.checkNotNullParameter(r16, "jsBridgeManager");
        Intrinsics.checkNotNullParameter(r17, "component");
        Map<String, com.bytedance.ies.web.jsbridge2.f.b> r10 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("getContainerID", new k(r17)), TuplesKt.to("canIUse", new t(r16)), TuplesKt.to("fetch", u.a), TuplesKt.to("appInfo", v.a), TuplesKt.to("connectSocket", new w(r17)), TuplesKt.to("closeSocket", new x(r17)), TuplesKt.to("sendSocketData", new y(r17)), TuplesKt.to(com.bytedance.android.ec.core.event.a.VALUE_OPEN, new z(r17)), TuplesKt.to("request", a0.a), TuplesKt.to("vibrate", a.a), TuplesKt.to("getAppInfo", b.a), TuplesKt.to("setStorageItem", c.a), TuplesKt.to("getStorageItem", d.a), TuplesKt.to("removeStorageItem", e.a), TuplesKt.to("showToast", f.a), TuplesKt.to("downloadFile", new g(r17)), TuplesKt.to("saveDataURL", new h(r17)), TuplesKt.to("preloadResource", i.a), TuplesKt.to("getCurrentTime", j.a), TuplesKt.to("getDeviceStats", l.a), TuplesKt.to("saveTemplate", new m(r17)), TuplesKt.to("prerender", n.a), TuplesKt.to("pia.rendering.execute", o.a), TuplesKt.to("startSpeechRecognition", new p(r16)), TuplesKt.to("stopSpeechRecognition", q.a), TuplesKt.to("openPermissionSettings", r.a)});
        if (r17.isPopup() == true) goto L5;
        r10.put(com.bytedance.android.ec.core.event.a.VALUE_CLOSE, new s(r16));
    L5:
        Map r0 = MapsKt.mapOf(new Pair[]{TuplesKt.to("checkPermission", i0.a), TuplesKt.to("requestPermission", C0062j0.a), TuplesKt.to("createCalendarEvent", k0.a), TuplesKt.to("deleteCalendarEvent", l0.a), TuplesKt.to("readCalendarEvent", m0.a), TuplesKt.to("makePhoneCall", n0.a), TuplesKt.to("scanCode", o0.a), TuplesKt.to("reportALog", p0.a), TuplesKt.to("getUserInfo", q0.a), TuplesKt.to("login", new b0(r16)), TuplesKt.to("logout", new c0(r16)), TuplesKt.to("showModal", d0.a), TuplesKt.to("chooseMedia", e0.a), TuplesKt.to("uploadFile", f0.a), TuplesKt.to("chooseAndUpload", g0.a), TuplesKt.to("getSettings", h0.a)});
        if (Intrinsics.areEqual(r17.getBizKey(), "webcast") == false) goto L9;
        return r10;
    L9:
        return MapsKt.plus(r10, r0);
    }

    @JvmStatic
    public static final Map<String, com.bytedance.ies.web.jsbridge2.g<?, ?>> c(JSBridgeManager r1, IHybridComponent r10) {
        Intrinsics.checkNotNullParameter(r1, "jsBridgeManager");
        Intrinsics.checkNotNullParameter(r10, "component");
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("closeAndOpen", new com.bytedance.android.annie.bridge.method.i(r1.getActivity())), TuplesKt.to("sendLogV3", new b2()), TuplesKt.to(com.bytedance.android.ec.core.event.a.VALUE_SHOW_TOAST, new p2()), TuplesKt.to("reportAppLog", new b2())});
    }
}
