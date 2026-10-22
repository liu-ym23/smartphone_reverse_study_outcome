package go1;

import android.view.ViewGroup;
import com.bytedance.android.live.broadcast.api.AnchorInteractionData;
import com.bytedance.android.live.liveinteract.radio.impl.RadioWidget;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e3 extends e70.a<com.bytedance.android.livesdk.widgetdescriptor.e0> implements e70.h<com.bytedance.android.livesdk.widgetdescriptor.e0>, e70.e<com.bytedance.android.livesdk.widgetdescriptor.e0>, e70.i<com.bytedance.android.livesdk.widgetdescriptor.e0> {
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

    public e3() {
    }

    public final f70.b getLayerType() {
        return mg2.e.a;
    }

    public final Widget l(h70.b r6) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r7 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r6;
        Intrinsics.checkNotNullParameter(r7, "layerContext");
        RadioWidget r0 = new RadioWidget();
        com.bytedance.android.livesdk.chatroom.ui.framework.c r1 = ho1.a.d(r7);
        if (r1 != null) goto L5;
    L19:
        return r0;
    L5:
        if (r1.V9() != true) goto L19;
        if (MultiLinkLoadWidgetUtils.f() == false) goto L19;
        r0.k0 = true;
        MiddlewareRoomContext r8 = ((d90.d) r7).e;
        if (r8 == null) goto L15;
        com.bytedance.live.datacontext.j r9 = r8.getAnchorRoomScopeViewModel();
        if (r9 == null) goto L15;
        nz.l r10 = (nz.l) r9.getValue();
        if (r10 == null) goto L15;
        nz.w r11 = (nz.w) r10.a();
    L16:
        nz.f0.c r2 = nz.f0.c.b;
        int r3 = nz.a.a.a;
        new AnchorInteractionData("", 7L, 20L, "");
        if (r11 == null) goto L19;
        int r4 = nz.b.a.a;
        r11.a();
    L15:
        r11 = null;
        goto L16
    }

    public final boolean o(h70.b r2) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r3 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        return d90.c.c(r3);
    }

    public final j70.f p(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return com.bytedance.android.livesdk.chatroom.ui.framework.f.V;
    }

    public final boolean r(h70.b r2) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r3 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        if (rf2.a.a() == true) goto L12;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r4 = ho1.a.d(r3);
        if (r4 == null) goto L8;
        LiveMode r5 = r4.getLiveMode();
    L10:
        if (r5 != LiveMode.AUDIO) goto L12;
        return true;
    L8:
        r5 = null;
    L12:
        return false;
    }

    public final Integer w(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return 2131383618;
    }
}
