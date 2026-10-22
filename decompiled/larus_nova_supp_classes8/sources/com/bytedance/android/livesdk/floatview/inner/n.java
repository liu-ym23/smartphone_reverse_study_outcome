package com.bytedance.android.livesdk.floatview.inner;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.floatview.InnerFloatViewTAG;
import com.bytedance.android.livesdkapi.view.ILivePlayerView;
import com.bytedance.common.utility.UIUtils;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class n implements ILivePlayerView.PlayerCallback {
    public final /* synthetic */ k a;

    public final void onBufferingEnd() {
    }

    public final void onBufferingStart() {
    }

    public final void onInteractSeiUpdate(Object r1) {
    }

    public final void onMute(boolean r1) {
    }

    public final void onRoomFinish() {
    }

    public final void onPlayComplete() {
        k.i(this.a);
    }

    public final void onPlayDisplayed() {
        FrameLayout r0 = this.a.e;
        if (r0 == null) goto L6;
        r0.setVisibility(0);
    L6:
        if (Intrinsics.areEqual(this.a.p, InnerFloatViewTAG.TAG_LOTTERY_PREVIEW.getTag()) == false) goto L13;
        k r1 = this.a;
        RelativeLayout r3 = r1.n;
        if (r3 == null) goto L10;
        r3.setVisibility(8);
    L10:
        TextView r2 = r1.m;
        if (r2 == null) goto L13;
        r2.setVisibility(0);
    L13:
        k r4 = this.a;
        HSImageView r5 = r4.i;
        if (r5 == null) goto L16;
        r5.setVisibility(8);
    L16:
        View r6 = r4.j;
        if (r6 == null) goto L19;
        r6.setVisibility(8);
    L19:
        RelativeLayout r7 = r4.k;
        if (r7 == null) goto L22;
        r7.setVisibility(8);
    L22:
        k r8 = this.a;
        com.bytedance.android.livesdk.floatview.mob.b r9 = r8.w;
        if (r9 == null) goto L26;
        boolean r10 = r8.r;
        Room r11 = r8.q;
        int r12 = com.bytedance.android.livesdk.floatview.mob.b.o;
        r9.j(r10, r11, null);
        return;
    }

    public n(k r1) {
        this.a = r1;
    }

    public final void onError(String r1) {
        k.i(this.a);
    }

    public final void onVideoSizeChanged(int r5, int r6) {
        k r0 = this.a;
        Room r1 = r0.q;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.getStreamType() == LiveMode.AUDIO) goto L13;
        float r2 = r6 / r5;
        if (r5 <= r6) goto L9;
        float r7 = UIUtils.dip2Px(r0.getContext(), 178.0f);
    L10:
        int r8 = (int) r7;
        int r9 = (int) (r8 * r2);
        FrameLayout r3 = r0.b;
        if (r3 == null) goto L14;
        ViewGroup.LayoutParams r4 = r3.getLayoutParams();
        r4.width = r8;
        r4.height = r9;
        Unit r10 = Unit.INSTANCE;
        r3.setLayoutParams(r4);
    L14:
        com.bytedance.android.livesdk.floatview.e r11 = r0.v;
        if (r11 == null) goto L19;
        r11.a(r8, r9);
        return;
    L19:
        return;
    L9:
        r7 = UIUtils.dip2Px(r0.getContext(), 100.0f);
        goto L10
    L13:
        r8 = 0;
        r9 = 0;
        goto L14
    }
}
