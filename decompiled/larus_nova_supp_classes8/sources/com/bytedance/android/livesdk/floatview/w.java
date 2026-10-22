package com.bytedance.android.livesdk.floatview;

import android.os.SystemClock;
import android.view.View;
import com.bytedance.android.livesdk.utils.i4;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import java.util.HashMap;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class w implements View.OnClickListener {
    public final /* synthetic */ VideoFloatWindowView a;

    public w(VideoFloatWindowView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r9) {
        this.a.a(2131372953).setSelected(!this.a.a(2131372953).isSelected());
        if (this.a.a(2131372953).isSelected() == false) goto L9;
        LivePlayerView r10 = this.a.getMLivePlayerView$livesdk_saasRelease();
        if (r10 == null) goto L14;
        ILivePlayerClient r11 = r10.getClient();
        if (r11 == null) goto L14;
        r11.mute("VideoFloatWindowView.float_mute");
    L14:
        VideoFloatWindowView r12 = this.a;
        e r1 = r12.b;
        if (r1 == null) goto L17;
        r1.onMuteButtonClick(r12.a(2131372953).isSelected());
    L17:
        VideoFloatWindowView r13 = this.a;
        r13.t = Boolean.valueOf(r13.a(2131372953).isSelected());
        if (this.a.a(2131372953).isSelected() == false) goto L25;
        com.bytedance.android.livesdk.floatview.mob.b r14 = this.a.n;
        if (r14 == null) goto L22;
        r14.b = SystemClock.elapsedRealtime();
    L22:
        VideoFloatWindowView r15 = this.a;
        com.bytedance.android.livesdk.floatview.mob.b r0 = r15.n;
        if (r0 == null) goto L32;
        r0.i(r15.getContainContext(), this.a.h);
        return;
    L32:
        return;
    L25:
        VideoFloatWindowView r16 = this.a;
        com.bytedance.android.livesdk.floatview.mob.b r2 = r16.n;
        if (r2 == null) goto L28;
        r2.h(r16.getContainContext(), this.a.h);
    L28:
        VideoFloatWindowView r17 = this.a;
        com.bytedance.android.livesdk.floatview.mob.b r3 = r17.n;
        if (r3 == null) goto L34;
        r17.getContainContext();
        Room r18 = this.a.h;
        com.bytedance.android.livesdk.log.g r4 = com.bytedance.android.livesdk.log.u.l();
        HashMap r5 = new HashMap();
        com.bytedance.android.livesdk.floatview.mob.b.d(r5);
        i4.a(r5);
        i4.b(r5);
        r3.c(r5, !com.bytedance.android.livesdk.floatview.mob.b.a.a(r18));
        Unit r19 = Unit.INSTANCE;
        am2.x r6 = new am2.x();
        r6.a = "live_view";
        r6.b = "live_detail";
        r4.sendLog("livesdk_mini_window_silent_close", r5, new Object[]{r6, new am2.r(r3.e, r3.f, r3.h, r3.i), Room.class});
        return;
    L34:
        return;
    L9:
        LivePlayerView r20 = this.a.getMLivePlayerView$livesdk_saasRelease();
        if (r20 == null) goto L14;
        ILivePlayerClient r21 = r20.getClient();
        if (r21 == null) goto L14;
        r21.unmute("VideoFloatWindowView.float_mute");
        goto L14
    }
}
