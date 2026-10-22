package com.bytedance.android.live.liveinteract.chatroom.chatroom.seat;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.LinkSucAnimationView;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdkapi.depend.model.live.linker.IMatchEffect;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.view.DraweeView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class LinkSucAnimTask extends d {
    public final f b;
    public final LinkSucAnimationView c;

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.d
    public final void b(final w r9) {
        Intrinsics.checkNotNullParameter(r9, "event");
        if ((r9 instanceof i) == false) goto L59;
        i r0 = (i) r9;
        Intrinsics.checkNotNullParameter(r0, "$this$canShowLinkSucAnim");
        final j r1 = r0.b;
        if (r1 != null) goto L7;
    L9:
        boolean r3 = false;
    L10:
        if (r3 == false) goto L59;
        if (r1 == null) goto L63;
        IMatchEffect r4 = r1.d;
        if (r4 == null) goto L64;
        this.b.a(SeatAnimTaskState.LINK_SUC_ANIM);
        DraweeView r5 = this.c;
        if (r5 == null) goto L65;
        String r6 = r1.b;
        py.k r7 = r1.c;
        Function0<Unit> r8 = new LinkSucAnimTask$handle$$inlined$let$lambda$1(r1, this, r9);
        Intrinsics.checkNotNullParameter(r4, "matchEffect");
        Intrinsics.checkNotNullParameter(r8, "taskEnd");
        ALogger.i("LinkSucAnimationView", "startAnimation, linkSucAnimationView=" + r5 + ", viewDetached=" + r5.h + ", isLinkSucAnimFinished=" + r5.i + ", guestName=" + r5.b);
        if (r5.h == false) goto L19;
    L56:
        r8.invoke();
        LinkSucAnimationView.a r10 = r5.f;
        if (r10 == null) goto L67;
        r10.h();
        return;
    L67:
        return;
    L19:
        if (r5.i == true) goto L56;
        if (r5.b == null) goto L56;
        r5.c = r4;
        if (r6 != null) goto L26;
        r6 = "";
    L26:
        r5.d = r6;
        r5.e = r7;
        r5.g = r8;
        LinkSucAnimationView.a r11 = r5.f;
        if (r11 == null) goto L29;
        r11.g();
    L29:
        ALogger.i("LinkSucAnimationView", "startMatchingAnimation, viewDetached=" + r5.h + ", guestAvatar=" + r5.a + ", matchEffect=" + r5.c);
        if (r5.h == true) goto L46;
        ImageView r12 = r5.a;
        if (r12 == null) goto L46;
        if (r5.c == null) goto L46;
        r12.setVisibility(4);
        ImageView r13 = r5.a;
        if (r13 == null) goto L39;
        r13.setBackgroundResource(0);
    L39:
        ImageView r14 = r5.a;
        py.k r2 = null;
        if (r14 == null) goto L42;
        r14.setBackground(null);
    L42:
        PipelineDraweeControllerBuilder r15 = Fresco.newDraweeControllerBuilder();
        IMatchEffect r16 = r5.c;
        if (r16 == null) goto L45;
        r2 = r16.getMatchEffect();
    L45:
        r5.setController(r15.setFirstAvailableImageRequests(a1.b(r2, -1)).setAutoPlayAnimations(true).setControllerListener(new com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.g(r5)).build());
        r5.setVisibility(0);
    L52:
        TextView r17 = r5.b;
        if (r17 == null) goto L55;
        r17.setText(2131919833);
    L55:
        TextView r18 = r5.b;
        Intrinsics.checkNotNull(r18);
        ObjectAnimator r19 = ObjectAnimator.ofFloat(r18, "alpha", new float[]{0.5f, 0.0f});
        TextView r20 = r5.b;
        Intrinsics.checkNotNull(r20);
        ObjectAnimator r21 = ObjectAnimator.ofFloat(r20, "translationY", new float[]{0.0f, 30.0f});
        AnimatorSet r22 = new AnimatorSet();
        r22.playTogether(new Animator[]{r19, r21});
        r22.setDuration(300);
        r22.start();
        r22.addListener(new com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.d(r5));
        return;
    L46:
        Function0<Unit> r23 = r5.g;
        if (r23 == null) goto L49;
        r23.invoke();
    L49:
        LinkSucAnimationView.a r24 = r5.f;
        if (r24 == null) goto L52;
        r24.h();
        goto L52
    L65:
        return;
    L64:
        return;
    L63:
        return;
    L7:
        if (r1.d == null) goto L9;
        r3 = true;
    L59:
        d r25 = this.a;
        if (r25 == null) goto L69;
        r25.b(r9);
        return;
    }

    public LinkSucAnimTask(f r2, LinkSucAnimationView r3) {
        Intrinsics.checkNotNullParameter(r2, "taskStateListener");
        this.b = r2;
        this.c = r3;
    }
}
