package go1;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class y0 extends e70.a<com.bytedance.android.livesdk.widgetdescriptor.e0> implements e70.h<com.bytedance.android.livesdk.widgetdescriptor.e0>, e70.e<com.bytedance.android.livesdk.widgetdescriptor.e0>, e70.i<com.bytedance.android.livesdk.widgetdescriptor.e0> {
    public final e70.d N() {
        return this;
    }

    public final e70.e O() {
        return this;
    }

    public final e70.f P() {
        return this;
    }

    public final Class<? extends Widget> m() {
        return null;
    }

    public final ViewGroup q(h70.b r2) {
        Intrinsics.checkNotNullParameter(r2, "layerContext");
        return null;
    }

    public final void s(h70.b r2) {
        Intrinsics.checkNotNullParameter(r2, "layerContext");
    }

    public final /* synthetic */ void u() {
    }

    public y0() {
    }

    public final f70.b getLayerType() {
        return mg2.e.a;
    }

    public final Widget l(h70.b r3) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r4 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r3;
        Intrinsics.checkNotNullParameter(r4, "layerContext");
        com.bytedance.android.livesdk.chatroom.ui.framework.d r5 = ho1.a.i(r4);
        ih0.b r0 = null;
        if (r5 == null) goto L5;
        View r6 = r5.getRootView();
    L7:
        if ((r6 instanceof ViewGroup) == true) goto L9;
        r6 = null;
    L9:
        ViewGroup r7 = (ViewGroup) r6;
        if (r7 == null) goto L22;
        IInteractService r1 = jc1.k.f(IInteractService.class);
        if (r1 == null) goto L15;
        ih0.b r8 = r1.createDynamicWidget(r7);
    L17:
        if ((r8 instanceof Widget) == false) goto L21;
        r0 = r8;
    L21:
        return (Widget) r0;
    L15:
        r8 = null;
        goto L17
    L22:
        return null;
    L5:
        r6 = null;
        goto L7
    }

    public final boolean o(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return false;
    }

    public final j70.f p(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return com.bytedance.android.livesdk.chatroom.ui.framework.f.Q0;
    }

    public final boolean r(h70.b r3) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r4 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r3;
        Intrinsics.checkNotNullParameter(r4, "layerContext");
        if (com.bytedance.android.live.liveinteract.utils.w0.c(null) == true) goto L6;
    L19:
        return false;
    L6:
        if (jc1.k.f(IInteractService.class) == null) goto L19;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r5 = ho1.a.d(r4);
        if (r5 == null) goto L19;
        if (r5.dg() == false) goto L15;
    L18:
        return true;
    L15:
        if (com.bytedance.android.live.liveinteract.utils.w0.c(null) == false) goto L19;
        if (r5.getLiveMode() == LiveMode.MEDIA) goto L19;
        goto L18
    }

    public final Integer w(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return 2131383618;
    }
}
