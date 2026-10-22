package com.bytedance.android.live.platformplayer.layout;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.platformplayer.api.ILandSlideService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import zg1.k3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class w0<T> implements Observer {
    public final /* synthetic */ LivePlayerWidget a;

    public w0(LivePlayerWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r10) {
        Pair<Integer, Integer> r11 = (Pair) r10;
        if (r11 != null) goto L6;
        return;
    L6:
        if (((Widget) this.a).isViewValid == false) goto L49;
        int r0 = ((Number) r11.component1()).intValue();
        int r1 = ((Number) r11.component2()).intValue();
        LivePlayerWidget r2 = this.a;
        int r3 = LivePlayerWidget.V2;
        r2.getClass();
        ILandSlideService r4 = (ILandSlideService) LivePlayerWidget.jr(ILandSlideService.class);
        boolean r5 = false;
        if (r4 != null) goto L11;
    L15:
        boolean r6 = false;
    L16:
        if (r6 == false) goto L18;
        ALogger.e("LivePlayerWidget", "checkSizeErrorInLandscape w:" + r0 + "，h:" + r1 + "，room:" + r2.U2.x());
    L18:
        if (r6 == true) goto L50;
        if (r0 == 0) goto L27;
        if (r1 == 0) goto L27;
        ds0.d r7 = this.a.U2;
        if (r0 <= r1) goto L25;
        r5 = true;
    L25:
        r7.setVideoHorizontal(r5);
    L27:
        if (this.a.xr() == false) goto L29;
        this.a.Er("hub.videoSizeChanged screen orientation landscape to portrait");
        this.a.ks();
    L38:
        if (m1.b(this.a) == false) goto L46;
        LivePlayerWidget r8 = this.a;
        Intrinsics.checkNotNullParameter(r8, "$this$handleVideoSizeChange");
        Intrinsics.checkNotNullParameter(r11, "size");
        if (((Number) r11.getFirst()).intValue() > 0) goto L42;
        return;
    L42:
        if (((Number) r11.getSecond()).intValue() <= 0) goto L51;
        r8.P1 = r11;
        ALogger.d("VerticleSrOptimize", "handleVideoSizeChange=" + r11);
        m1.a(r8);
        return;
    L51:
        return;
    L46:
        return;
    L29:
        if (r0 == 0) goto L32;
        if (r1 == 0) goto L32;
        this.a.M30(s1.y(), "onVideoSizeChanged");
        this.a.getClass();
    L32:
        LivePlayerWidget r9 = this.a;
        if (r9.a == null) goto L38;
        DataCenter r12 = ((Widget) r9).dataCenter;
        if (r12 == null) goto L38;
        r12.put("cmd_video_orientation_changed", new k3(r9.U2.isVideoHorizontal(), this.a.U2.getPortraitVideoViewBottom()));
        goto L38
    L50:
        return;
    L11:
        if (r4.isSlideAble() != true) goto L15;
        if (r0 == 0) goto L14;
        if (r1 != 0) goto L15;
    L14:
        r6 = true;
        goto L16
    }
}
