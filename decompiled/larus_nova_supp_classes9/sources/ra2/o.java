package ra2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.graphics.drawable.Animatable;
import android.view.ViewGroup;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.ui.MatchHotMsgView;
import com.bytedance.android.livesdk.utils.q4;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class o extends AnimatorListenerAdapter {
    public final /* synthetic */ MatchHotMsgView a;

    public o(MatchHotMsgView r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r25) {
        Intrinsics.checkNotNullParameter(r25, "animation");
        MatchHotMsgView r1 = this.a;
        if (r1.F == false) goto L97;
        ViewGroup r2 = r1.e;
        if (r2 == null) goto L7;
        r2.setPivotX(0.0f);
    L7:
        ViewGroup r3 = this.a.e;
        if (r3 == null) goto L10;
        r3.setPivotY(r3.getHeight() / 2.0f);
    L10:
        ViewGroup r4 = this.a.g;
        if (r4 == null) goto L13;
        r4.setPivotX(0.0f);
    L13:
        ViewGroup r5 = this.a.g;
        if (r5 == null) goto L16;
        r5.setPivotY(r5.getHeight());
    L16:
        MatchHotMsgView r6 = this.a;
        r6.getClass();
        if (m.a.a(r6) == true) goto L98;
        MatchHotMsgView r7 = this.a;
        r7.getClass();
        r7.C = new AnimatorSet();
        AnimatorSet r8 = new AnimatorSet();
        Animator[] r9 = new Animator[2];
        int r10 = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.a;
        ViewGroup r11 = r7.e;
        if (r11 == null) goto L100;
        r9[0] = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.b(r11, "scaleX", 0.99f, 1.0f, 100, 0.0f, 0.0f, 0.58f, 1.0f);
        ViewGroup r13 = r7.e;
        if (r13 == null) goto L101;
        Animator r14 = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.b(r13, "scaleY", 0.99f, 1.0f, 100, 0.0f, 0.0f, 0.58f, 1.0f);
        int r15 = 1;
        r9[1] = r14;
        r8.playTogether(r9);
        AnimatorSet r16 = new AnimatorSet();
        Animator[] r17 = new Animator[1];
        ViewGroup r18 = r7.e;
        if (r18 == null) goto L102;
        r17[0] = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.b(r18, "scaleX", 1.0f, 1.0f, 300, 0.0f, 0.0f, 0.58f, 1.0f);
        r16.playSequentially(r17);
        AnimatorSet r19 = new AnimatorSet();
        Animator[] r20 = new Animator[2];
        ViewGroup r21 = r7.e;
        if (r21 == null) goto L103;
        r20[0] = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.b(r21, "scaleX", 1.0f, 1.01f, 100, 0.0f, 0.0f, 0.58f, 1.0f);
        ViewGroup r110 = r7.e;
        if (r110 == null) goto L104;
        r20[1] = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.b(r110, "scaleY", 1.0f, 1.01f, 100, 0.0f, 0.0f, 0.58f, 1.0f);
        r19.playTogether(r20);
        AnimatorSet r23 = new AnimatorSet();
        Animator[] r24 = new Animator[1];
        ViewGroup r111 = r7.e;
        if (r111 == null) goto L105;
        r24[0] = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.b(r111, "scaleX", 1.01f, 1.01f, 300, 0.0f, 0.0f, 0.58f, 1.0f);
        r23.playSequentially(r24);
        AnimatorSet r26 = new AnimatorSet();
        AnimatorSet r112 = new AnimatorSet();
        Animator[] r113 = new Animator[2];
        ViewGroup r114 = r7.e;
        if (r114 == null) goto L106;
        r113[0] = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.b(r114, "scaleX", 1.01f, 0.95f, 100, 0.26f, 0.0f, 0.6f, 0.2f);
        ViewGroup r115 = r7.e;
        if (r115 == null) goto L107;
        r113[1] = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.b(r115, "scaleY", 1.01f, 0.95f, 100, 0.26f, 0.0f, 0.6f, 0.2f);
        r112.playTogether(r113);
        AnimatorSet r116 = new AnimatorSet();
        Animator[] r117 = new Animator[2];
        ViewGroup r118 = r7.e;
        if (r118 == null) goto L108;
        r117[0] = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.b(r118, "scaleX", 0.95f, 0.99f, 300, 0.4f, 0.8f, 0.74f, 1.0f);
        ViewGroup r119 = r7.e;
        if (r119 == null) goto L109;
        r117[1] = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.b(r119, "scaleY", 0.95f, 0.99f, 300, 0.4f, 0.8f, 0.74f, 1.0f);
        r116.playTogether(r117);
        r26.playSequentially(new Animator[]{r112, r116});
        AnimatorSet r120 = new AnimatorSet();
        Animator[] r121 = new Animator[1];
        ViewGroup r122 = r7.e;
        if (r122 == null) goto L110;
        Intrinsics.checkNotNullParameter(r122, "view");
        Intrinsics.checkNotNullParameter("scaleX", "propertyName");
        q4.j.getClass();
        ValueAnimator r123 = q4.a.b(r122, "scaleX", new float[]{0.99f, 0.99f});
        r123.setDuration(300);
        r121[0] = r123;
        r120.playTogether(r121);
        AnimatorSet r124 = r7.C;
        if (r124 == null) goto L54;
        r124.playSequentially(new Animator[]{r8, r16, r19, r23, r26, r120});
    L54:
        AnimatorSet r27 = r7.C;
        if (r27 == null) goto L57;
        r27.addListener(new w(r7));
    L57:
        AnimatorSet r28 = r7.C;
        if (r28 == null) goto L60;
        r28.start();
    L60:
        HSImageView r29 = r7.c;
        Animatable r30 = null;
        if (r29 == null) goto L65;
        DraweeController r31 = r29.getController();
        if (r31 == null) goto L65;
        Animatable r33 = r31.getAnimatable();
    L67:
        if ((r33 instanceof AnimatedDrawable2) == true) goto L69;
        r33 = null;
    L69:
        r7.q = (AnimatedDrawable2) r33;
        HSImageView r34 = r7.b;
        if (r34 == null) goto L74;
        DraweeController r35 = r34.getController();
        if (r35 == null) goto L74;
        Animatable r36 = r35.getAnimatable();
    L76:
        if ((r36 instanceof AnimatedDrawable2) == false) goto L79;
        r30 = r36;
    L79:
        r7.r = (AnimatedDrawable2) r30;
        AnimatedDrawable2 r37 = r7.q;
        long r38 = 50;
        if (r37 == null) goto L86;
        long r39 = r37.getLoopDurationMs();
        AnimatedDrawable2 r40 = r7.q;
        if (r40 == null) goto L84;
        int r41 = r40.getFrameCount();
    L85:
        long r43 = r39 / ((long) r41);
    L87:
        r7.s = r43;
        AnimatedDrawable2 r44 = r7.r;
        if (r44 == null) goto L93;
        long r45 = r44.getLoopDurationMs();
        AnimatedDrawable2 r46 = r7.r;
        if (r46 == null) goto L92;
        r15 = r46.getFrameCount();
    L92:
        r38 = r45 / ((long) r15);
    L93:
        r7.t = r38;
        r7.post(r7.o);
        AnimatedDrawable2 r47 = r7.r;
        if (r47 == null) goto L99;
        r47.start();
        return;
    L99:
        return;
    L84:
        r41 = 1;
        goto L85
    L86:
        r43 = 50;
    L74:
        r36 = null;
    L65:
        r33 = null;
        goto L67
    L110:
        return;
    L109:
        return;
    L108:
        return;
    L107:
        return;
    L106:
        return;
    L105:
        return;
    L104:
        return;
    L103:
        return;
    L102:
        return;
    L101:
        return;
    L100:
        return;
    L98:
        return;
    }
}
