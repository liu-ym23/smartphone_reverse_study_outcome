package com.bytedance.android.live.browser;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.annie.api.container.HybridFragment;
import com.bytedance.android.annie.bridge.JSBridgeManager;
import com.bytedance.android.annie.business.container.AnnieXLiveFragment;
import com.bytedance.android.live.browser.jsbridge.newmethods.UploadScreenMethod;
import com.bytedance.android.live.browser.jsbridge.newmethods.b8;
import com.bytedance.android.live.browser.jsbridge.newmethods.k5;
import com.bytedance.android.live.browser.jsbridge.newmethods.t5;
import com.bytedance.android.live.browser.jsbridge.newmethods.x5;
import com.bytedance.android.live.browser.jsbridge.newmethods.yc;
import com.bytedance.android.live.browser.webview.fragment.LiveAnnieFragment;
import com.bytedance.android.live.browser.webview.fragment.LiveAnnieXFragment;
import com.bytedance.android.live.room.api.ILiveShareService;
import com.bytedance.android.livesdkapi.jsb.ExternalJsBridgeMethodInjector;
import com.bytedance.android.livesdkapi.jsb.IExternalActivityResultListener;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a0 extends y6.a {
    public static final String b = null;
    public static final a0 c = null;

    public static final class a implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return jc1.k.n(ILiveShareService.class).getShareFullParamsMethod();
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
            return new UploadScreenMethod();
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
            return new x5();
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
            return new com.bytedance.android.live.browser.jsbridge.newmethods.c0();
        }
    }

    public static final class e implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ LiveAnnieFragment a;

        public e(LiveAnnieFragment r1) {
            this.a = r1;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new b8(this.a);
        }
    }

    public static final class f implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ LiveAnnieXFragment a;

        public f(LiveAnnieXFragment r1) {
            this.a = r1;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new b8(this.a);
        }
    }

    public static final class g implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ y6.c a;

        public g(y6.c r1) {
            this.a = r1;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return jc1.k.n(ILiveShareService.class).getShareInfoMethod(this.a.t);
        }
    }

    public static final class h implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ y6.c a;

        public h(y6.c r1) {
            this.a = r1;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return jc1.k.n(ILiveShareService.class).getSharePanelMethod(this.a.t);
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
            return jc1.k.n(ILiveShareService.class).getShareLiveMethod();
        }
    }

    static {
        c = new a0();
        b = "JsBridgeFactoryForAnnie";
    }

    public a0() {
    }

    public final String a() {
        return b;
    }

    public final Map<String, n56.c> e(y6.c r5) {
        Intrinsics.checkNotNullParameter(r5, "manager");
        LinkedHashMap r0 = new LinkedHashMap();
        if ((r5 instanceof JSBridgeManager) == false) goto L7;
        Activity r1 = r5.getActivity();
        if (r1 == null) goto L7;
        r0.put("share", jc1.k.n(ILiveShareService.class).getShareMethod(new WeakReference(r1), ((JSBridgeManager) r5).t));
    L7:
        return r0;
    }

    public final Map<String, com.bytedance.ies.web.jsbridge2.f.b> h(HybridFragment r6) {
        Intrinsics.checkNotNullParameter(r6, "fragment");
        Map<String, com.bytedance.ies.web.jsbridge2.f.b> r0 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("fullParamsSharePanel", a.a), TuplesKt.to("uploadScreenshot", b.a), TuplesKt.to("addAnchor", c.a), TuplesKt.to("addTopicToPublish", d.a)});
        if ((r6 instanceof LiveAnnieFragment) == true) goto L5;
        HybridFragment r1 = null;
    L6:
        LiveAnnieFragment r2 = (LiveAnnieFragment) r1;
        if (r2 == null) goto L10;
        com.bytedance.ies.web.jsbridge2.f.b r3 = r0.put("muteLiveRoom", new e(r2));
    L10:
        if ((r6 instanceof LiveAnnieXFragment) == true) goto L12;
        r6 = null;
    L12:
        LiveAnnieXFragment r7 = (LiveAnnieXFragment) r6;
        if (r7 == null) goto L15;
        r0.put("muteLiveRoom", new f(r7));
    L15:
        return r0;
    L5:
        r1 = r6;
        goto L6
    }

    public final Map<String, com.bytedance.ies.web.jsbridge2.g<?, ?>> i(HybridFragment r5) {
        Intrinsics.checkNotNullParameter(r5, "fragment");
    L11:
        e = move-exception;
        e.getMessage();
    L14:
        if ((r5 instanceof LiveAnnieFragment) == true) goto L16;
        r5 = null;
    L16:
        LiveAnnieFragment r6 = (LiveAnnieFragment) r5;
        if (r6 == null) goto L21;
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("showLiveFloatWindow", new yc(r6)), TuplesKt.to("hideLiveFloatWindow", new k5(r6)), TuplesKt.to("isLiveFloatWindowShow", new t5(r6))});
    L21:
        return MapsKt.emptyMap();
    L4:
        if ((r5 instanceof AnnieXLiveFragment) == true) goto L6;
        HybridFragment r1 = null;
    L7:
        AnnieXLiveFragment r2 = (AnnieXLiveFragment) r1;     // Catch: Exception -> L11
        if (r2 == null) goto L14;
        r2.registerWeakHolder(com.bytedance.android.live.browser.webview.fragment.l.class, (com.bytedance.android.live.browser.webview.fragment.l) r5);     // Catch: Exception -> L11
        goto L14
    L6:
        r1 = r5;
        goto L7
    }

    public final Map<String, com.bytedance.ies.web.jsbridge2.f.b> l(y6.c r4) {
        Intrinsics.checkNotNullParameter(r4, "manager");
        LinkedHashMap r0 = new LinkedHashMap();
        if ((r4 instanceof JSBridgeManager) == false) goto L5;
        r0.put("shareInfo", new g(r4));
        r0.put("sharePanel", new h(r4));
        r0.put("shareLive", i.a);
    L5:
        return r0;
    }

    public final Map<String, com.bytedance.ies.web.jsbridge2.g<?, ?>> n(y6.c r2) {
        Intrinsics.checkNotNullParameter(r2, "manager");
        return MapsKt.emptyMap();
    }

    public final Map b(FragmentActivity r3, HybridDialog r4) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        Intrinsics.checkNotNullParameter(r4, "dialogFragment");
        return MapsKt.mapOf(TuplesKt.to("open_live", new com.bytedance.android.live.browser.jsbridge.method.dialog.a(new WeakReference(r3), r4)));
    }

    public final Map f(FragmentActivity r6, Fragment r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "fragment");
        Map r8 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("phoneNumberPicker", new y(r7, r6)), TuplesKt.to("ocrTakePhoto", new z(r7))});
        Iterator r0 = ExternalJsBridgeMethodInjector.INSTANCE.getStatefulMethodsProvidersForFragmentScene().iterator();
    L4:
        if (r0.hasNext() == false) goto L17;
        Iterator r1 = ((Map) ((Function0) r0.next()).invoke()).entrySet().iterator();
    L7:
        if (r1.hasNext() == false) goto L4;
        Map.Entry r2 = (Map.Entry) r1.next();
        if ((((com.bytedance.ies.web.jsbridge2.f.b) r2.getValue()).a() instanceof IExternalActivityResultListener) == false) goto L7;
        com.bytedance.ies.web.jsbridge2.f r3 = ((com.bytedance.ies.web.jsbridge2.f.b) r2.getValue()).a();
        if ((r3 instanceof IExternalActivityResultListener) == true) goto L13;
        r3 = null;
    L13:
        IExternalActivityResultListener r4 = (IExternalActivityResultListener) r3;
        if (r4 == null) goto L16;
        r4.setFragment(r7);
    L16:
        r8.put(r2.getKey(), new x(r2));
        goto L7
    L17:
        return r8;
    }

    public final Map g(FragmentActivity r2, HybridFragment r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "fragment");
        return f(r2, r3);
    }
}
