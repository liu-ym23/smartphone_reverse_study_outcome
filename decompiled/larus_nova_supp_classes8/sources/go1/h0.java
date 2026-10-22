package go1;

import com.bytedance.android.live.plugin_api.LivePluginSPIManager;
import com.bytedance.android.livesdk.chatroom.ui.framework.widget.ScreenLinkTriggerWidget;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h0 extends e70.b<com.bytedance.android.livesdk.widgetdescriptor.e0> implements e70.h<com.bytedance.android.livesdk.widgetdescriptor.e0>, e70.e<com.bytedance.android.livesdk.widgetdescriptor.e0> {
    public final e70.e N() {
        return this;
    }

    public final e70.f O() {
        return this;
    }

    public final Class<? extends Widget> m() {
        return null;
    }

    public final void s(h70.b r2) {
        Intrinsics.checkNotNullParameter(r2, "layerContext");
    }

    public final /* synthetic */ void u() {
    }

    public h0() {
    }

    public final Widget l(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return new ScreenLinkTriggerWidget();
    }

    public final boolean o(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return true;
    }

    public final j70.f p(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return com.bytedance.android.livesdk.chatroom.ui.framework.f.M;
    }

    public final boolean r(h70.b r3) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r4 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r3;
        Intrinsics.checkNotNullParameter(r4, "layerContext");
        if (rf2.a.a() == true) goto L18;
        int r0 = f0.c;
        LivePluginSPIManager.e.getClass();
        if (LivePluginSPIManager.b() == true) goto L8;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == true) goto L19;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r5 = ho1.a.d(r4);
        if (r5 != null) goto L16;
        return false;
    L16:
        return f0.a.a(r5);
    L19:
        return false;
    L8:
        if (LivePluginSPIManager.c() == true) goto L10;
        r1 = false;
        goto L11
    L18:
        return false;
    }
}
