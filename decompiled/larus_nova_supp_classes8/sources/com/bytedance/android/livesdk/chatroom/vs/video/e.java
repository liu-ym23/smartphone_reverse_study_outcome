package com.bytedance.android.livesdk.chatroom.vs.video;

import com.bytedance.android.livesdk.chatroom.progressbar.ui.PlayerSeekBar;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.videoshop.context.VideoContext;
import com.ss.android.videoshop.mediaview.LayerHostMediaLayout;
import com.ss.android.videoshop.mediaview.VideoPatchLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e implements PlayerSeekBar.b {
    public final /* synthetic */ VideoProgressAreaWidget a;

    public final void Jk(PlayerSeekBar r2, com.bytedance.android.livesdk.chatroom.vsplayer.model.e r3) {
        Intrinsics.checkNotNullParameter(r2, "seekBar");
        Intrinsics.checkNotNullParameter(r3, "vsSeekBarMark");
    }

    public final void O3() {
    }

    public final void od(PlayerSeekBar r2) {
        Intrinsics.checkNotNullParameter(r2, "seekBar");
    }

    public e(VideoProgressAreaWidget r1) {
        this.a = r1;
    }

    public final void tq(PlayerSeekBar r3) {
        Intrinsics.checkNotNullParameter(r3, "seekBar");
        int r4 = d.a;
        d.b(((Widget) this.a).dataCenter, "livesdk_vs_right_video_progress_bar_slide", null);
    }

    public final void d7(PlayerSeekBar r5, com.bytedance.android.livesdk.chatroom.vsplayer.model.e r6) {
        Intrinsics.checkNotNullParameter(r5, "seekBar");
        VideoContext r7 = this.a.a;
        if (r7 != null) goto L5;
    L9:
        VideoProgressAreaWidget r8 = this.a;
        VideoContext r9 = r8.a;
        if (r9 == null) goto L18;
        long r0 = r8.f;
        LayerHostMediaLayout r10 = r9.c;
        if (r10 == null) goto L18;
        if (r0 < 0) goto L18;
        qic.a r11 = ((VideoPatchLayout) r10).j;
        if (r11 == null) goto L18;
        r11.seekTo(r0);
    L18:
        this.a.f = -1;
        return;
    L5:
        if (r7.u0() != true) goto L9;
        VideoContext r12 = this.a.a;
        if (r12 == null) goto L9;
        r12.play();
        goto L9
    }

    public final void lg(PlayerSeekBar r1, boolean r2, com.bytedance.android.livesdk.chatroom.vsplayer.model.e r3) {
        Intrinsics.checkNotNullParameter(r1, "seekBar");
        Intrinsics.checkNotNullParameter(r1, "seekBar");
    }

    public final void n8(PlayerSeekBar r1, float r2, boolean r3, float r4) {
        Intrinsics.checkNotNullParameter(r1, "seekBar");
        if (r3 == false) goto L6;
        VideoProgressAreaWidget r5 = this.a;
        long r6 = (long) ((r5.e * r2) / 100);
        r5.f = r6;
        VideoProgressAreaWidget.wq(r5, r6, null);
        return;
    }
}
