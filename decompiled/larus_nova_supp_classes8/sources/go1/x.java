package go1;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.config.y91;
import com.bytedance.android.livesdk.interactivity.api.medialink.IMediaLinkOutService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class x extends e70.a<com.bytedance.android.livesdk.widgetdescriptor.e0> implements e70.h<com.bytedance.android.livesdk.widgetdescriptor.e0>, e70.e<com.bytedance.android.livesdk.widgetdescriptor.e0>, e70.i<com.bytedance.android.livesdk.widgetdescriptor.e0> {
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

    public x() {
    }

    public final f70.b getLayerType() {
        return mg2.e.a;
    }

    public final Widget l(h70.b r6) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r7 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r6;
        Intrinsics.checkNotNullParameter(r7, "layerContext");
        Room r0 = d90.c.q(r7);
        if (r0 == null) goto L23;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r2 = ho1.a.d(r7);
        if (r2 == null) goto L24;
        com.bytedance.android.livesdk.chatroom.ui.framework.a r8 = ho1.a.c(r7);
        if (r8 == null) goto L25;
        com.bytedance.android.livesdk.chatroom.ui.framework.d r3 = r2.Gg();
        if (r3 == null) goto L14;
        View r4 = r3.getRootView();
    L16:
        if ((r4 instanceof ViewGroup) == true) goto L18;
        r4 = null;
    L18:
        ViewGroup r5 = (ViewGroup) r4;
        w r9 = new w(r8, r2);
        IMediaLinkOutService r10 = jc1.k.f(IMediaLinkOutService.class);
        if (r10 != null) goto L21;
        return null;
    L21:
        return r10.createRevMediaControlWidget(r0, r9, r5);
    L14:
        r4 = null;
        goto L16
    L25:
        return null;
    L24:
        return null;
    L23:
        return null;
    }

    public final boolean o(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return true;
    }

    public final j70.f p(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return com.bytedance.android.livesdk.chatroom.ui.framework.f.J;
    }

    public final boolean r(h70.b r2) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r3 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        if (y91.a.getValue().booleanValue() == true) goto L5;
    L7:
        return false;
    L5:
        if (com.bytedance.android.livesdk.config.setting.d.a(d90.c.q(r3), "RevMediaLinkControl") == true) goto L7;
        return true;
    }

    public final Integer w(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return 2131375505;
    }
}
