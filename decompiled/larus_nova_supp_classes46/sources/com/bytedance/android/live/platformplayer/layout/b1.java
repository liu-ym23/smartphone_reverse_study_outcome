package com.bytedance.android.live.platformplayer.layout;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.ui.VideoViewParams;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.config.it0;
import com.bytedance.android.livesdk.config.yh0;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.e6;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b1 implements IRenderView.MeasureListener {
    public final /* synthetic */ LivePlayerWidget a;

    public b1(LivePlayerWidget r1) {
        this.a = r1;
    }

    public final void onMeasureReady(int r8, int r9, int r10, int r11) {
        if (this.a.R8().getRenderView().getSelfView() != null) goto L5;
        return;
    L5:
        DataCenter r12 = ((Widget) this.a).dataCenter;
        String r13 = null;
        if (r12 == null) goto L8;
        VideoViewParams r14 = (VideoViewParams) r12.get("live_render_view_params", null);
    L9:
        ViewGroup.LayoutParams r1 = this.a.R8().getRenderView().getLayoutParams();
        if ((r1 instanceof FrameLayout.LayoutParams) == true) goto L12;
        r1 = null;
    L12:
        FrameLayout.LayoutParams r2 = (FrameLayout.LayoutParams) r1;
        if (r2 != null) goto L15;
        return;
    L15:
        int r3 = r2.topMargin;
        int r4 = 0;
        if (this.a.Rq(null) == false) goto L23;
        if (r8 <= r9) goto L19;
    L22:
        boolean r5 = true;
    L24:
        String r6 = jc1.k.n(IMiddlewareUserService.class).user().n();
        Room r7 = this.a.U2.w();
        if (r7 == null) goto L27;
        r13 = r7.getAnchorId();
    L27:
        boolean r15 = Intrinsics.areEqual(r6, r13);
        if (StatusBarUtil.STATUS_BAR_ADAPT_ENABLE == true) goto L30;
    L45:
        VideoViewParams r16 = new VideoViewParams(r8, r9, r3, this.a.R8().getRenderView().getSelfView().getX());
        if ((!Intrinsics.areEqual(r16, r14)) == false) goto L77;
        e6.b("live-onMeasureReady", r16);
        DataCenter r17 = ((Widget) this.a).dataCenter;
        if (r17 == null) goto L51;
        r17.put("live_render_view_params", r16);
    L51:
        if (((Boolean) it0.a.getValue()).booleanValue() == false) goto L69;
        if (PadConfigUtils.c() == true) goto L69;
        if (VrUtils.d(((Widget) this.a).dataCenter) == false) goto L58;
        this.a.getClass();
        r9 = LivePlayerWidget.fr();
    L61:
        if (VrUtils.d(((Widget) this.a).dataCenter) == true) goto L64;
        r4 = (int) this.a.R8().getRenderView().getSelfView().getY();
    L64:
        DataCenter r18 = ((Widget) this.a).dataCenter;
        if (r18 == null) goto L67;
        r18.put("data_video_size", TuplesKt.to(Integer.valueOf(r9), Integer.valueOf(r4)));
    L67:
        boolean r19 = com.bytedance.android.live.revenue.core.util.h.a;
        com.bytedance.android.live.revenue.core.util.h.d(kc0.j.class).updateVideoHeight(this.a.V0, r9, r4);
        goto L69
    L58:
        if (this.a.R8().getHeight() < r9) goto L61;
        r9 = this.a.R8().getHeight();
    L69:
        if (this.a.ur() == false) goto L78;
        boolean r20 = com.bytedance.android.live.revenue.core.util.h.a;
        com.bytedance.android.live.revenue.core.util.h.d(kc0.j.class).notifyPkRenderWidth(r8);
        DataCenter r21 = ((Widget) this.a).dataCenter;
        if (r21 == null) goto L73;
        r21.put("data_pk_renderview_width", Integer.valueOf(r8));
    L73:
        DataCenter r22 = ((Widget) this.a).dataCenter;
        if (r22 == null) goto L79;
        r22.put("fold_container_width", Integer.valueOf(r8));
        return;
    L79:
        return;
    L78:
        return;
    L77:
        return;
    L30:
        if (StatusBarUtil.JUMP_FROM_LIVE_PLAY_ACTIVITY == false) goto L45;
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L45;
        if (r15 == true) goto L45;
        if (r8 <= r9) goto L45;
        if (r5 == false) goto L45;
        if (((Boolean) yh0.a.getValue()).booleanValue() == true) goto L45;
        DataCenter r110 = ((Widget) this.a).dataCenter;
        if (r110 == null) goto L43;
        Integer r111 = (Integer) r110.get("interaction_layer_margin_top", 0);
        if (r111 == null) goto L43;
        int r112 = r111.intValue();
    L44:
        r3 = r3 - r112;
    L43:
        r112 = 0;
        goto L44
    L19:
        if (this.a.U2.getInPkMode() == true) goto L22;
        if (this.a.U2.f == true) goto L22;
    L23:
        r5 = false;
        goto L24
    L8:
        r14 = null;
        goto L9
    }
}
