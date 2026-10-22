package go1;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.livesdk.a5;
import com.bytedance.android.livesdk.config.dq0;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class o extends e70.a<com.bytedance.android.livesdk.widgetdescriptor.e0> implements e70.h<com.bytedance.android.livesdk.widgetdescriptor.e0>, e70.e<com.bytedance.android.livesdk.widgetdescriptor.e0>, e70.i<com.bytedance.android.livesdk.widgetdescriptor.e0> {
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

    public o() {
    }

    public final f70.b getLayerType() {
        return mg2.e.a;
    }

    public final Widget l(h70.b r5) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r6 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r5;
        Intrinsics.checkNotNullParameter(r6, "layerContext");
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = ho1.a.d(r6);
        if (r0 == null) goto L20;
        com.bytedance.android.livesdk.chatroom.ui.framework.a r7 = ho1.a.c(r6);
        if (r7 == null) goto L21;
        com.bytedance.android.livesdk.chatroom.ui.framework.d r2 = r0.Gg();
        if (r2 == null) goto L11;
        View r3 = r2.getRootView();
    L13:
        if ((r3 instanceof ViewGroup) == true) goto L15;
        r3 = null;
    L15:
        ViewGroup r4 = (ViewGroup) r3;
        n r8 = new n(r0, r7);
        IBroadcastService r9 = (IBroadcastService) va1.b.a.a.a(IBroadcastService.class);
        if (r9 != null) goto L18;
        return null;
    L18:
        return r9.createScreenControlWidget(r8, r4, null);
    L11:
        r3 = null;
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
        return com.bytedance.android.livesdk.chatroom.ui.framework.f.L;
    }

    public final boolean r(h70.b r2) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r3 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        com.bytedance.android.livesdk.chatroom.ui.framework.c r4 = (com.bytedance.android.livesdk.chatroom.ui.framework.c) r3.m.getAbility(com.bytedance.android.livesdk.chatroom.ui.framework.c.class);
        if (r4 != null) goto L6;
    L12:
        return false;
    L6:
        if (r4.getLiveMode() != LiveMode.SCREEN_RECORD) goto L12;
        if (dq0.a.getValue().a() == false) goto L12;
        if (((Boolean) a5.a.getValue()).booleanValue() == true) goto L12;
        return true;
    }

    public final Integer w(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return 2131375533;
    }
}
