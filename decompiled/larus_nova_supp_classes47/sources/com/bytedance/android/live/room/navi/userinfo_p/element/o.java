package com.bytedance.android.live.room.navi.userinfo_p.element;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.animation.DecelerateInterpolator;
import com.bytedance.android.livesdk.chatroom.r;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class o<T> implements Consumer {
    public final /* synthetic */ UserinfoWidthServiceElement a;
    public final /* synthetic */ int b;

    public o(UserinfoWidthServiceElement r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        Long r5 = (Long) r4;
        final UserinfoWidthServiceElement r6 = this.a;
        int r0 = this.b;
        r r1 = z51.a.e(r6.getDataCenter());
        if (r1 == null) goto L7;
        com.bytedance.live.datacontext.m r2 = r1.w();
        if (r2 == null) goto L7;
        r2.setValue(Boolean.TRUE);
    L7:
        Animator r3 = r6.j;
        if (r3 != null) goto L10;
    L15:
        ValueAnimator r7 = ValueAnimator.ofInt(new int[]{r0, r6.f});
        r7.addUpdateListener(new p(r6));
        com.bytedance.android.live.ktv.common.midi.v2.a.a(r7, new UserinfoWidthServiceElement$startTempWidthShrinkAnim$$inlined$apply$lambda$2(r6));
        r7.setDuration(300);
        r7.setInterpolator(new DecelerateInterpolator());
        r6.j = r7;
        r7.start();
        return;
    L10:
        if (r3.isRunning() == true) goto L13;
        r3 = null;
    L13:
        if (r3 == null) goto L15;
        r3.cancel();
        goto L15
    }
}
