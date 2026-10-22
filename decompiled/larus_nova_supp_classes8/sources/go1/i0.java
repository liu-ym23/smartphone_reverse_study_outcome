package go1;

import android.view.ViewGroup;
import com.bytedance.android.live.broadcast.api.AnchorInteractionData;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.widgt.AudioSceneBasicBusinessContentWidget;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i0 extends e70.a<com.bytedance.android.livesdk.widgetdescriptor.e0> implements e70.h<com.bytedance.android.livesdk.widgetdescriptor.e0>, e70.e<com.bytedance.android.livesdk.widgetdescriptor.e0>, e70.i<com.bytedance.android.livesdk.widgetdescriptor.e0> {
    public final e70.d<com.bytedance.android.livesdk.widgetdescriptor.e0> N() {
        return this;
    }

    public final e70.e<com.bytedance.android.livesdk.widgetdescriptor.e0> O() {
        return this;
    }

    public final e70.f<com.bytedance.android.livesdk.widgetdescriptor.e0> P() {
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

    public i0() {
    }

    public final f70.b getLayerType() {
        return mg2.e.a;
    }

    public final Widget l(h70.b r6) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r7 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r6;
        Intrinsics.checkNotNullParameter(r7, "layerContext");
        AudioSceneBasicBusinessContentWidget r0 = jc1.k.n(IInteractService.class).createAudioSceneBasicWidget();
        com.bytedance.android.livesdk.chatroom.ui.framework.c r1 = ho1.a.d(r7);
        if (r1 != null) goto L5;
    L19:
        AudioSceneBasicBusinessContentWidget r2 = r0;
        r2.getClass();
        return r2;
    L5:
        if (r1.V9() != true) goto L19;
        if (MultiLinkLoadWidgetUtils.f() == false) goto L19;
        r0.q = true;
        MiddlewareRoomContext r8 = ((d90.d) r7).e;
        if (r8 == null) goto L15;
        com.bytedance.live.datacontext.j r9 = r8.getAnchorRoomScopeViewModel();
        if (r9 == null) goto L15;
        nz.l r10 = (nz.l) r9.getValue();
        if (r10 == null) goto L15;
        nz.w r11 = (nz.w) r10.a();
    L16:
        nz.f0.c r3 = nz.f0.c.b;
        int r4 = nz.a.a.a;
        new AnchorInteractionData("", 7L, 20L, "");
        if (r11 == null) goto L19;
        int r5 = nz.b.a.a;
        r11.a();
    L15:
        r11 = null;
        goto L16
    }

    public final boolean o(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return false;
    }

    public final j70.f p(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return com.bytedance.android.livesdk.chatroom.ui.framework.f.Y;
    }

    public final boolean r(h70.b r2) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r3 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        if (rf2.a.a() == true) goto L10;
        Room r4 = d90.c.q(r3);
        if (r4 == null) goto L10;
        if (r4.isLiveTypeAudio() != true) goto L10;
        return true;
    L10:
        return false;
    }

    public final Integer w(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return 2131363493;
    }
}
