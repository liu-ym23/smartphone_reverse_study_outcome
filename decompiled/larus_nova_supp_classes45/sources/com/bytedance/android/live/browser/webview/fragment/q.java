package com.bytedance.android.live.browser.webview.fragment;

import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.live.browser.jsbridge.newmethods.bc;
import com.bytedance.android.live.browser.jsbridge.newmethods.ec;
import com.bytedance.android.live.browser.jsbridge.newmethods.k5;
import com.bytedance.android.live.browser.jsbridge.newmethods.t5;
import com.bytedance.android.live.browser.jsbridge.newmethods.yc;
import com.bytedance.android.live.browser.v;
import com.bytedance.android.live.room.api.ILiveShareService;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class q implements IHybridComponent.a {
    public final /* synthetic */ WebDialogFragmentForAnnie a;
    public final /* synthetic */ HybridDialog b;

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
        public final /* synthetic */ q a;

        public b(q r1) {
            this.a = r1;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new bc(this.a.a);
        }
    }

    public final void onJSBridgeCreated(y6.c r4) {
        Intrinsics.checkNotNullParameter(r4, "manager");
        v r0 = this.a.k;
        if (r0 == null) goto L5;
        r4.registerMethod("close", r0.d(this.b));
        r4.registerMethod("closeAndOpen", r0.e(this.b));
    L5:
        r4.registerMethod("setHotsoon", new ec(this.a));
        r4.registerMethod("setLive", new ec(this.a));
        r4.registerMethod("open_live", new com.bytedance.android.live.browser.jsbridge.method.dialog.a(new WeakReference(this.a.getActivity()), this.a));
        r4.registerMethod("halfFullSwitch", new com.bytedance.android.live.browser.jsbridge.method.dialog.b(this.a));
        r4.registerMethod("fullParamsSharePanel", a.a);
        r4.registerMethod("showLiveFloatWindow", new yc(this.a));
        r4.registerMethod("hideLiveFloatWindow", new k5(this.a));
        r4.registerMethod("isLiveFloatWindowShow", new t5(this.a));
        r4.registerMethod("setContainer", new b(this));
    }

    public q(WebDialogFragmentForAnnie r1, HybridDialog r2) {
        this.a = r1;
        this.b = r2;
    }
}
