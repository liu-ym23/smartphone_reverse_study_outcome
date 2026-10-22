package com.bytedance.android.live.liveinteract.chatroom.chatroom.seat;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.net.Uri;
import android.view.animation.Animation;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.view.MicSeatSponsorView;
import com.facebook.drawee.backends.pipeline.Fresco;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class GuestBattleSeatAnimTask extends d {
    public b b;
    public e c;
    public final f d;
    public final HSImageView e;
    public final MicSeatSponsorView f;

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.d
    public final void b(final w r11) {
        Intrinsics.checkNotNullParameter(r11, "event");
        if ((r11 instanceof b) == false) goto L48;
        b r0 = (b) r11;
        if (r0.a == false) goto L24;
        HSImageView r12 = this.e;
        if (r12 == null) goto L11;
        Animation r13 = r12.getAnimation();
        if (r13 == null) goto L11;
        r13.cancel();
    L11:
        HSImageView r14 = this.e;
        if (r14 == null) goto L14;
        r14.setVisibility(8);
    L14:
        MicSeatSponsorView r15 = this.f;
        if (r15 == null) goto L17;
        r15.setVisibility(8);
    L17:
        ALogger.e("GuestBattleSeatAnimTask", "#GuestBattleDebug# [cancelGuestBattleSeatAnimation] last " + this.b, new Throwable());
        b r16 = this.b;
        if (r16 == null) goto L22;
        Function0<Unit> r17 = r16.i;
        if (r17 == null) goto L22;
        r17.invoke();
    L22:
        this.b = null;
        return;
    L24:
        e r1 = this.c;
        if (r1 == null) goto L27;
        r1.a(r11);
    L27:
        Uri r2 = r0.f;
        Function0<Unit> r3 = new GuestBattleSeatAnimTask$handle$2(this, r11);
        HSImageView r18 = this.e;
        boolean r4 = true;
        if (r18 == null) goto L30;
        r18.setController(Fresco.newDraweeControllerBuilder().setUri(r2).setAutoPlayAnimations(true).setControllerListener(new c(this, r3)).build());
    L30:
        HSImageView r19 = this.e;
        if (r19 == null) goto L33;
        r19.setVisibility(0);
    L33:
        ALogger.d("GuestBattleSeatAnimTask", "#GuestBattleDebug# [playGuestBattleSeatAnimation] " + this.b);
        if (this.f == null) goto L47;
        String r110 = r0.g;
        if (r110 != null) goto L38;
    L41:
        if (r4 == true) goto L47;
        this.f.setVisibility(0);
        MicSeatSponsorView r111 = this.f;
        String r5 = r0.g;
        if (r5 != null) goto L46;
        r5 = "";
    L46:
        r111.a(r5, r0.h);
        AnimatorSet r112 = new AnimatorSet();
        ArrayList r6 = new ArrayList();
        ObjectAnimator r7 = ObjectAnimator.ofFloat(this.f, "alpha", new float[]{0.0f, 1.0f});
        r7.setDuration(300);
        r6.add(r7);
        ObjectAnimator r8 = ObjectAnimator.ofFloat(this.f, "alpha", new float[]{1.0f, 1.0f});
        r8.setDuration(2400);
        r6.add(r8);
        ObjectAnimator r9 = ObjectAnimator.ofFloat(this.f, "alpha", new float[]{1.0f, 0.0f});
        r9.setDuration(300);
        com.bytedance.android.live.ktv.common.midi.v2.a.a(r9, new GuestBattleSeatAnimTask$handelSponsorAnim$1(this));
        r6.add(r9);
        r112.playSequentially(r6);
        r112.start();
        goto L47
    L38:
        if (r110.length() == 0) goto L41;
        r4 = false;
    L47:
        this.b = r0;
        this.d.a(SeatAnimTaskState.REVENUE_DRESS_ANIM);
        return;
    L48:
        d r10 = this.a;
        if (r10 == null) goto L53;
        r10.b(r11);
        return;
    }

    public GuestBattleSeatAnimTask(f r2, HSImageView r3, MicSeatSponsorView r4) {
        Intrinsics.checkNotNullParameter(r2, "taskStateListener");
        this.d = r2;
        this.e = r3;
        this.f = r4;
    }
}
