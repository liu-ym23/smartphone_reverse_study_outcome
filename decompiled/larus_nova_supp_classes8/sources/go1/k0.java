package go1;

import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k0 extends e70.b<com.bytedance.android.livesdk.widgetdescriptor.e0> implements e70.h<com.bytedance.android.livesdk.widgetdescriptor.e0>, e70.e<com.bytedance.android.livesdk.widgetdescriptor.e0> {
    public final e70.e N() {
        return this;
    }

    public final e70.f O() {
        return this;
    }

    public final Widget l(h70.b r2) {
        Intrinsics.checkNotNullParameter(r2, "layerContext");
        return null;
    }

    public final void s(h70.b r2) {
        Intrinsics.checkNotNullParameter(r2, "layerContext");
    }

    public final /* synthetic */ void u() {
    }

    public final Class<? extends Widget> m() {
        IBrowserService r0 = jc1.k.f(IBrowserService.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.provideBridgeSupportWidgetClass();
    }

    public k0() {
    }

    public final boolean o(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return true;
    }

    public final j70.f p(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return com.bytedance.android.livesdk.chatroom.ui.framework.f.R0;
    }

    public final boolean r(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        IBrowserService r3 = jc1.k.f(IBrowserService.class);
        if (r3 == null) goto L5;
        Class r4 = r3.provideBridgeSupportWidgetClass();
    L6:
        if (r4 == null) goto L8;
        return true;
    L8:
        return false;
    L5:
        r4 = null;
        goto L6
    }
}
