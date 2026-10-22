package com.bytedance.android.live.browser.jsbridge;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import androidx.fragment.app.Fragment;
import com.bytedance.android.annie.api.bridge.RegisterPolicy;
import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.annie.bridge.JSBridgeManager;
import com.bytedance.android.live.browser.jsbridge.newmethods.AlertMethod;
import com.bytedance.android.live.browser.jsbridge.newmethods.CallPhoneMethod;
import com.bytedance.android.live.browser.jsbridge.newmethods.DialogMethod;
import com.bytedance.android.live.browser.jsbridge.newmethods.FetchV3Method;
import com.bytedance.android.live.browser.jsbridge.newmethods.a3;
import com.bytedance.android.live.browser.jsbridge.newmethods.a8;
import com.bytedance.android.live.browser.jsbridge.newmethods.ae;
import com.bytedance.android.live.browser.jsbridge.newmethods.be;
import com.bytedance.android.live.browser.jsbridge.newmethods.ca;
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
import com.bytedance.android.live.browser.jsbridge.newmethods.l5;
import com.bytedance.android.live.browser.jsbridge.newmethods.m5;
import com.bytedance.android.live.browser.jsbridge.newmethods.mc;
import com.bytedance.android.live.browser.jsbridge.newmethods.n5;
import com.bytedance.android.live.browser.jsbridge.newmethods.o5;
import com.bytedance.android.live.browser.jsbridge.newmethods.p8;
import com.bytedance.android.live.browser.jsbridge.newmethods.q1;
import com.bytedance.android.live.browser.jsbridge.newmethods.r8;
import com.bytedance.android.live.browser.jsbridge.newmethods.rc;
import com.bytedance.android.live.browser.jsbridge.newmethods.t3;
import com.bytedance.android.live.browser.jsbridge.newmethods.u0;
import com.bytedance.android.live.browser.jsbridge.newmethods.u4;
import com.bytedance.android.live.browser.jsbridge.newmethods.u5;
import com.bytedance.android.live.browser.jsbridge.newmethods.ub;
import com.bytedance.android.live.browser.jsbridge.newmethods.v5;
import com.bytedance.android.live.browser.jsbridge.newmethods.vb;
import com.bytedance.android.live.browser.jsbridge.newmethods.xa;
import com.bytedance.android.live.browser.jsbridge.newmethods.xc;
import com.bytedance.android.live.browser.jsbridge.newmethods.y7;
import com.bytedance.android.live.browser.jsbridge.newmethods.zc;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdk.config.ni1;
import com.bytedance.android.livesdk.config.pi1;
import com.bytedance.android.livesdk.config.w30;
import com.bytedance.android.livesdkapi.hybridapi.BaseJsBridgeMethodFactory;
import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager;
import com.bytedance.android.livesdkapi.hybridapi.ILiveHybridContainer;
import com.bytedance.android.livesdkapi.hybridapi.SubscriberJsEvent;
import com.bytedance.android.livesdkapi.service.MessageHub;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import w20.td;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class JsBridgeService implements com.bytedance.android.live.browser.v {
    public final Lazy a;

    public static final class a implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new ae();
        }
    }

    public static final class a0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final a0 a = null;

        static {
            a = new a0();
        }

        public a0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new m5();
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
            return new h30.f.a();
        }
    }

    public static final class b0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final b0 a = null;

        static {
            a = new b0();
        }

        public b0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new e8();
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
            return new h30.f.b();
        }
    }

    public static final class c0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final c0 a = null;

        static {
            a = new c0();
        }

        public c0() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new q1();
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
            return new td();
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
            return new AlertMethod();
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
            return new AlertMethod();
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
            return new xc();
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
            return new DialogMethod();
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
            return new p8();
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
            return new vb();
        }
    }

    public static final class k implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ com.bytedance.ies.web.jsbridge2.d0 a;

        public k(com.bytedance.ies.web.jsbridge2.d0 r1) {
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

    public static final class l implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final l a = null;

        static {
            a = new l();
        }

        public l() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new n5();
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
            return new o5();
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
            return new r8();
        }
    }

    public static final class o implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final o a = null;

        static {
            a = new o();
        }

        public o() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new f2();
        }
    }

    public static final class p implements com.bytedance.ies.web.jsbridge2.f.b {
        public p(com.bytedance.ies.web.jsbridge2.d0 r1) {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new t3();
        }
    }

    public static final class q implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final q a = null;

        static {
            a = new q();
        }

        public q() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new d3();
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
            return new ca();
        }
    }

    public static final class s implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final s a = null;

        static {
            a = new s();
        }

        public s() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new h5();
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
            return new mc();
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
            return new v5.d();
        }
    }

    public static final class v implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ com.bytedance.ies.web.jsbridge2.d0 a;

        public v(com.bytedance.ies.web.jsbridge2.d0 r1) {
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
        public static final x a = null;

        static {
            a = new x();
        }

        public x() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new CallPhoneMethod();
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
            return new zc();
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
            return new l5();
        }
    }

    public final IJsBridgeAssistService f() {
        return (IJsBridgeAssistService) this.a.getValue();
    }

    public JsBridgeService() {
        this.a = LazyKt.lazy(JsBridgeService$jsBridgeAssistService$2.INSTANCE);
    }

    @Override // com.bytedance.android.live.browser.v
    public final Collection<BaseJsBridgeMethodFactory> getFactoryCollection() {
        return f().getFactoryCollection();
    }

    @Override // com.bytedance.android.live.browser.v
    public final List<String> getSafeHostList() {
        return f().getSafeHostList();
    }

    @Override // com.bytedance.android.live.browser.v
    public final void initPermissionCheck() {
        f().initPermissionCheck();
    }

    @Override // com.bytedance.android.live.browser.v
    public final void initTTLiveSdkJsb() {
        f().initTTLiveSdkJsb();
    }

    @Override // com.bytedance.android.live.browser.v
    public final <T extends LiveRecyclableWidget> Class<T> provideBridgeSupportWidgetClass() {
        return f().provideBridgeSupportWidgetClass();
    }

    @Override // com.bytedance.android.live.browser.v
    public final void registerDataShare() {
        f().registerDataShare();
    }

    @Override // com.bytedance.android.live.browser.v
    public final void registerMatchShareMethods() {
        f().registerMatchShareMethods();
    }

    @Override // com.bytedance.android.live.browser.v
    public final void registerState() {
        f().registerState();
    }

    @Override // com.bytedance.android.live.browser.v
    public final Observable b(com.bytedance.android.live.browser.a0 r2) {
        Intrinsics.checkNotNullParameter(r2, "annieFactory");
        return f().registerAnnieFactory(r2);
    }

    @Override // com.bytedance.android.live.browser.v
    public final d2 d(HybridDialog r2) {
        Intrinsics.checkNotNullParameter(r2, "dialogFragment");
        return new d2(r2);
    }

    @Override // com.bytedance.android.live.browser.v
    public final e2 e(HybridDialog r3) {
        Intrinsics.checkNotNullParameter(r3, "dialogFragment");
        return new e2(null, r3);
    }

    @Override // com.bytedance.android.live.browser.v
    public final w30.a getStorageProcessor(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return f().getStorageProcessor(r2);
    }

    @Override // com.bytedance.android.live.browser.v
    public final com.bytedance.ies.web.jsbridge2.f<?, ?> provideClipMethod(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        return f().provideClipMethod(r2);
    }

    @Override // com.bytedance.android.live.browser.v
    public final com.bytedance.ies.web.jsbridge2.f<?, ?> provideDynamicUnRegisterWRDSMethod(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        return f().provideDynamicUnRegisterWRDSMethod(r2);
    }

    @Override // com.bytedance.android.live.browser.v
    public final u4 provideGetLiveNtpTimeMethod(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        return new u4();
    }

    @Override // com.bytedance.android.live.browser.v
    public final com.bytedance.ies.web.jsbridge2.f<?, ?> provideRegisterMessageLatchMethod(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        return f().provideRegisterMessageLatchMethod(r2);
    }

    @Override // com.bytedance.android.live.browser.v
    public final Map<String, com.bytedance.ies.web.jsbridge2.f.b> provideRegisterMessageMethodInFeed(MessageHub r2) {
        return f().provideRegisterMessageMethodInFeed(r2);
    }

    @Override // com.bytedance.android.live.browser.v
    public final com.bytedance.ies.web.jsbridge2.f<?, ?> provideRegisterWRDSMethod(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        return f().provideRegisterWRDSMethod(r2);
    }

    @Override // com.bytedance.android.live.browser.v
    public final Map<String, y6.b<? extends com.bytedance.ies.web.jsbridge2.f<?, ?>>> provideStateFulFragmentMethods(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        return f().provideStateFulFragmentMethods(r2);
    }

    @Override // com.bytedance.android.live.browser.v
    public final Observable<Unit> registerExternalMethodFactory(BaseJsBridgeMethodFactory r2) {
        Intrinsics.checkNotNullParameter(r2, "factory");
        return f().registerExternalMethodFactory(r2);
    }

    @Override // com.bytedance.android.live.browser.v
    public final Observable<SubscriberJsEvent> registerJsEventSubscriber(String r2) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        return f().registerJsEventSubscriber(r2);
    }

    @Override // com.bytedance.android.live.browser.v
    public final com.bytedance.android.live.browser.jsbridge.i.d a(String r2, JSBridgeManager r3) {
        Intrinsics.checkNotNullParameter(r2, LiveSlardarConstants.EXTRA_KEY_URL);
        Intrinsics.checkNotNullParameter(r3, "jsBridgeManager");
        return f().getNewCurrentState(r2, r3);
    }

    @Override // com.bytedance.android.live.browser.v
    public final IJsBridgeManager c(ILiveHybridContainer r3, kl0.c r4) {
        Intrinsics.checkNotNullParameter(r3, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r4, "bridgeImpl");
        return f().createJsBridgeManager(r3, r4, 2);
    }

    @Override // com.bytedance.android.live.browser.v
    public final Map<String, com.bytedance.ies.web.jsbridge2.f.b> provideDefaultStatefulMethods(com.bytedance.ies.web.jsbridge2.d0 r5, RegisterPolicy r6) {
        Intrinsics.checkNotNullParameter(r6, "registerPolicy");
        LinkedHashMap r0 = new LinkedHashMap();
        RegisterPolicy r1 = RegisterPolicy.DEFAULT;
        r0.putAll(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("appInfo", new k(r5)), TuplesKt.to("fetch", new v(r5))}));
        r0.put("callPhone", w.a);
        r0.put("makePhoneCall", x.a);
        r0.put("showLoading", y.a);
        r0.put("hideLoading", z.a);
        r0.put("imageToast", a0.a);
        r0.put("handleNotificationSettings", b0.a);
        r0.put("changePpeEnv", c0.a);
        r0.put("vibrate", a.a);
        r0.put("checkPermission", b.a);
        r0.put("requestPermission", c.a);
        r0.put("screenShotLocalTest", d.a);
        r0.put("app.showModal", e.a);
        r0.put("showModal", f.a);
        r0.put("showLeaveRoomDialog", g.a);
        r0.put("dialog", h.a);
        r0.put("openCommentPanel", i.a);
        r0.put("sendPublicScreenTextMessage", j.a);
        r0.put("inputActivityEmoji", l.a);
        r0.put("inputFusionEmoji", m.a);
        r0.put("openEmojiPanel", n.a);
        r0.put("comment", o.a);
        r0.put("getAppInfo", new p(r5));
        r0.put("fetchPb", q.a);
        r0.put("getClientSetting", r.a);
        r0.put("getStrategyFactor", s.a);
        r0.put("shareItem", t.a);
        if (((Boolean) w30.a.getValue()).booleanValue() == false) goto L5;
        r0.put("setStorage", u.a);
    L5:
        r0.putAll(f().provideDefaultStatefulMethods(r5, r6));
        return r0;
    }

    @Override // com.bytedance.android.live.browser.v
    public final Map<String, com.bytedance.ies.web.jsbridge2.g<?, ?>> provideDefaultStatelessMethods(com.bytedance.ies.web.jsbridge2.d0 r5, RegisterPolicy r6) {
        Intrinsics.checkNotNullParameter(r6, "registerPolicy");
        LinkedHashMap r0 = new LinkedHashMap();
        RegisterPolicy r1 = RegisterPolicy.DEFAULT;
        Pair[] r2 = new Pair[1];
        if (r5 == null) goto L5;
        WebView r3 = r5.b;
    L6:
        r2[0] = TuplesKt.to("webviewNavigation", new de(r3));
        r0.putAll(MapsKt.mutableMapOf(r2));
        r0.put("getStorage", new v5.a());
        r0.put("removeStorage", new v5.b());
        r0.put("toast", new ed());
        r0.put("handleSharedKv", new rc());
        r0.put("isTeenMode", new u5());
        r0.put("sendMonitor", new a8());
        r0.put("sendLogV1", new ub());
        r0.put("reportADLog", new xa());
        r0.put("monitorLynx", new y7());
        r0.put("setBottomBannerVisibility", new u0());
        r0.put("pull_down_height", new ce());
        r0.put("dialogPullDownClose", new be());
        if (((Boolean) w30.a.getValue()).booleanValue() == true) goto L9;
        r0.put("setStorage", new v5.c());
    L9:
        r0.putAll(f().provideDefaultStatelessMethods(r5, r6));
        return r0;
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.browser.v
    public final void registerXBridgeMethods(y6.c r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "jsBridgeManager");
        Intrinsics.checkNotNullParameter(r3, "xBridgeRegisterStrategy");
        f().registerXBridgeMethods(r2, r3);
    }

    @Override // com.bytedance.android.live.browser.v
    public final <T> void sendEventToAllJsBridges(String r2, T r3) {
        Intrinsics.checkNotNullParameter(r2, "event");
        f().sendEventToAllJsBridges(r2, r3);
    }

    @Override // com.bytedance.android.live.browser.v
    public final IJsBridgeManager createJsBridgeManager(Activity r2, com.bytedance.ies.web.jsbridge2.b r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "bridgeImpl");
        return f().createJsBridgeManager(r2, r3, r4);
    }
}
