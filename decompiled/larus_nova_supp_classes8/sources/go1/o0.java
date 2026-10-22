package go1;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.model.CloudGroupLiveBeInvitedDialogConfig;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class o0 extends e70.a<com.bytedance.android.livesdk.widgetdescriptor.e0> implements e70.h<com.bytedance.android.livesdk.widgetdescriptor.e0>, e70.e<com.bytedance.android.livesdk.widgetdescriptor.e0>, e70.i<com.bytedance.android.livesdk.widgetdescriptor.e0> {
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

    public o0() {
    }

    public final f70.b getLayerType() {
        return mg2.e.a;
    }

    public final Widget l(h70.b r4) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r5 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r4;
        Intrinsics.checkNotNullParameter(r5, "layerContext");
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = ho1.a.d(r5);
        if (r0 == null) goto L20;
        com.bytedance.android.livesdk.chatroom.ui.framework.a r6 = ho1.a.c(r5);
        if (r6 == null) goto L21;
        com.bytedance.android.livesdk.chatroom.ui.framework.d r1 = r0.Gg();
        if (r1 == null) goto L11;
        View r2 = r1.getRootView();
    L13:
        if ((r2 instanceof ViewGroup) == true) goto L15;
        r2 = null;
    L15:
        ViewGroup r3 = (ViewGroup) r2;
        IInteractService r7 = jc1.k.f(IInteractService.class);
        if (r7 != null) goto L18;
        return null;
    L18:
        return r7.createCloudGroupLiveWidget(r3, r6);
    L11:
        r2 = null;
        goto L13
    L21:
        return null;
    L20:
        return null;
    }

    public final boolean o(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return true;
    }

    public final j70.f p(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return com.bytedance.android.livesdk.chatroom.ui.framework.f.P;
    }

    public final boolean r(h70.b r2) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r3 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        if (((CloudGroupLiveBeInvitedDialogConfig) com.bytedance.android.live.core.setting.d0.a.getValue()).getEnable() == false) goto L11;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r4 = ho1.a.d(r3);
        if (r4 == null) goto L7;
        LiveMode r5 = r4.getLiveMode();
    L9:
        if (r5 != LiveMode.VIDEO) goto L11;
        return true;
    L7:
        r5 = null;
    L11:
        return false;
    }

    public final Integer w(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return 2131367019;
    }
}
