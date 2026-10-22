package go1;

import android.view.ViewGroup;
import com.bytedance.android.livesdk.castscreen.leboController.bytecast.ui.LiveByteCastUIManager;
import com.bytedance.android.livesdk.castscreen.views.bytecast.GameCastScreenLiveConnectWidgetForByteCast;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneEnum;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class n1 extends e70.a<com.bytedance.android.livesdk.widgetdescriptor.e0> implements e70.h<com.bytedance.android.livesdk.widgetdescriptor.e0>, e70.e<com.bytedance.android.livesdk.widgetdescriptor.e0>, e70.i<com.bytedance.android.livesdk.widgetdescriptor.e0> {
    public final e70.d N() {
        return this;
    }

    public final e70.e O() {
        return this;
    }

    public final e70.f P() {
        return this;
    }

    public final Widget l(h70.b r2) {
        Intrinsics.checkNotNullParameter(r2, "layerContext");
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

    public final Class<? extends Widget> m() {
        int r0 = com.bytedance.android.livesdk.castscreen.api.b.a;
        String r1 = LiveByteCastUIManager.a;
        if (LiveByteCastUIManager.r() == false) goto L5;
        return GameCastScreenLiveConnectWidgetForByteCast.class;
    L5:
        return null;
    }

    public n1() {
    }

    public final f70.b getLayerType() {
        return mg2.e.b;
    }

    public final boolean o(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return false;
    }

    public final j70.f p(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return com.bytedance.android.livesdk.chatroom.ui.framework.f.x;
    }

    public final boolean r(h70.b r3) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r4 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r3;
        Intrinsics.checkNotNullParameter(r4, "layerContext");
        Room r0 = d90.c.q(r4);
        if (r0 == null) goto L20;
        DataCenter r5 = ((d90.d) r4).h;
        if (r5 == null) goto L20;
        int r1 = com.bytedance.android.livesdk.castscreen.api.b.a;
        String r2 = LiveByteCastUIManager.a;
        if (LiveByteCastUIManager.r() == false) goto L11;
        Class<GameCastScreenLiveConnectWidgetForByteCast> r6 = GameCastScreenLiveConnectWidgetForByteCast.class;
    L12:
        if (r6 == null) goto L20;
        if (r0.isThirdParty() == false) goto L16;
    L19:
        return true;
    L16:
        if (r0.isScreenshot() == true) goto L19;
        if (com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(r5).e1(PaidSceneEnum.PAID_ROOM) == false) goto L20;
    L11:
        r6 = null;
    L20:
        return false;
    }

    public final Integer w(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return 2131365275;
    }
}
