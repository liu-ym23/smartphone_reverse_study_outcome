package go1;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g extends e70.a<com.bytedance.android.livesdk.widgetdescriptor.e0> implements e70.h<com.bytedance.android.livesdk.widgetdescriptor.e0>, e70.e<com.bytedance.android.livesdk.widgetdescriptor.e0>, e70.i<com.bytedance.android.livesdk.widgetdescriptor.e0> {
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

    public g() {
    }

    public final f70.b getLayerType() {
        return mg2.e.a;
    }

    public final Widget l(h70.b r10) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r5 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r10;
        Intrinsics.checkNotNullParameter(r5, "layerContext");
        com.bytedance.android.livesdk.chatroom.ui.framework.c r4 = ho1.a.d(r5);
        if (r4 == null) goto L24;
        com.bytedance.android.livesdk.chatroom.ui.framework.a r3 = ho1.a.c(r5);
        if (r3 == null) goto L25;
        com.bytedance.android.livesdk.chatroom.ui.framework.d r0 = r4.Gg();
        if (r0 == null) goto L11;
        View r1 = r0.getRootView();
    L13:
        if ((r1 instanceof ViewGroup) == true) goto L15;
        r1 = null;
    L15:
        ViewGroup r6 = (ViewGroup) r1;
        hh1.v0 r2 = r4.getLiveVideoClientFactory();
        Bundle r7 = r4.Wl();
        if (r7 == null) goto L18;
        boolean r8 = r7.getBoolean("data_live_has_continue_room_data", false);
    L19:
        f r9 = new f(this, r2, r3, r4, r5);
        IInteractService r11 = jc1.k.f(IInteractService.class);
        if (r11 != null) goto L22;
        return null;
    L22:
        return r11.createLinkMultiControlWidget(r9, r6, Boolean.valueOf(r8));
    L18:
        r8 = false;
        goto L19
    L11:
        r1 = null;
        goto L13
    L25:
        return null;
    L24:
        return null;
    }

    public final boolean o(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return true;
    }

    public final j70.f p(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return com.bytedance.android.livesdk.chatroom.ui.framework.f.N;
    }

    public final boolean r(h70.b r3) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r4 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r3;
        Intrinsics.checkNotNullParameter(r4, "layerContext");
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = (com.bytedance.android.livesdk.chatroom.ui.framework.c) r4.m.getAbility(com.bytedance.android.livesdk.chatroom.ui.framework.c.class);
        if (r0 == null) goto L10;
        d90.c.q(r4);
        LiveMode r5 = r0.getLiveMode();
        if (r5 != LiveMode.VIDEO) goto L8;
    L11:
        return true;
    L8:
        if (r5 == LiveMode.AUDIO) goto L11;
    L10:
        return false;
    }

    public final Integer w(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return 2131375519;
    }
}
