package c90;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.widget.bubble.LiveBubbleLayout;
import com.bytedance.android.live.core.widget.f;
import com.bytedance.android.live.core.widget.h;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements Runnable {
    public final /* synthetic */ c90.a a;
    public final /* synthetic */ LiveBubbleLayout b;
    public final /* synthetic */ boolean c;

    public static final class a extends AnimatorListenerAdapter {
        public final /* synthetic */ b a;

        public a(b r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            super.onAnimationEnd(r2);
            b r3 = this.a;
            if (r3.c == true) goto L9;
            r3.b.setVisibility(8);
            c90.a.c r4 = this.a.a.D;
            if (r4 == null) goto L7;
            r4.bubbleDismiss();
        L7:
            this.a.a.g();
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            super.onAnimationStart(r2);
            b r3 = this.a;
            if (r3.c == false) goto L9;
            c90.a.d r4 = r3.a.C;
            if (r4 == null) goto L7;
            r4.bubbleShow();
        L7:
            this.a.b.setVisibility(0);
            return;
        }
    }

    public b(c90.a r1, LiveBubbleLayout r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        c90.a r1 = this.a;
        if (r1.z != null) goto L5;
        return;
    L5:
        int r2 = r1.g;
        if (r2 == 3) goto L23;
        if (r2 == 5) goto L19;
        if (r2 == 48) goto L15;
        if (r2 == 80) goto L11;
        int r3 = 0;
        int r7 = 0;
    L30:
        this.b.setPivotY(r7);
        this.b.setPivotX(r3);
        LiveBubbleLayout r4 = this.b;
        float[] r8 = new float[2];
        boolean r9 = this.c;
        float r11 = 1.0f;
        if (r9 == false) goto L33;
        float r12 = 0.0f;
    L34:
        r8[0] = r12;
        if (r9 == false) goto L37;
        float r13 = 1.0f;
    L38:
        r8[1] = r13;
        ObjectAnimator r5 = ObjectAnimator.ofFloat(r4, LiveDegradeFpsAnimator.SCALE_X, r8);
        long r14 = 200;
        r5.setDuration(200);
        LiveBubbleLayout r15 = this.b;
        float[] r16 = new float[2];
        boolean r17 = this.c;
        if (r17 == false) goto L41;
        float r18 = 0.0f;
    L42:
        r16[0] = r18;
        if (r17 == true) goto L46;
        r11 = 0.0f;
    L46:
        r16[1] = r11;
        ObjectAnimator r19 = ObjectAnimator.ofFloat(r15, LiveDegradeFpsAnimator.SCALE_Y, r16);
        r19.setDuration(200);
        ObjectAnimator r110 = ObjectAnimator.ofFloat(this.b, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{0.0f});
        if (this.c == false) goto L49;
        r14 = 500;
    L49:
        r110.setDuration(r14);
        ObjectAnimator r21 = ObjectAnimator.ofFloat(this.b, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{0.0f});
        if (this.c == false) goto L52;
        long r6 = 500;
    L53:
        r21.setDuration(r6);
        ObjectAnimator r22 = ObjectAnimator.ofFloat(this.b, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{0.0f});
        if (this.c == false) goto L56;
        long r23 = 500;
    L57:
        r22.setDuration(r23);
        ObjectAnimator r24 = ObjectAnimator.ofFloat(this.b, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{0.0f});
        if (this.c == false) goto L60;
        long r111 = 500;
    L61:
        r24.setDuration(r111);
        ObjectAnimator r25 = ObjectAnimator.ofFloat(this.b, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{0.0f, 10.0f});
        if (this.c == false) goto L64;
        long r112 = 200;
    L65:
        r25.setDuration(r112);
        ObjectAnimator r113 = ObjectAnimator.ofFloat(this.b, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{0.0f, -10.0f});
        if (this.c == false) goto L68;
        long r114 = 200;
    L69:
        r113.setDuration(r114);
        ObjectAnimator r115 = ObjectAnimator.ofFloat(this.b, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{0.0f, -10.0f});
        if (this.c == false) goto L72;
        long r116 = 200;
    L73:
        r115.setDuration(r116);
        ObjectAnimator r26 = ObjectAnimator.ofFloat(this.b, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{0.0f, 10.0f});
        if (this.c == false) goto L76;
        long r117 = 200;
    L77:
        r26.setDuration(r117);
        this.b.setVisibility(0);
        if (this.c == false) goto L152;
        int r27 = this.a.g;
        if (r27 != 3) goto L82;
        r115.setInterpolator(new h());
        r24.setInterpolator(new AccelerateDecelerateInterpolator());
        c90.a r28 = this.a;
        if (r28.l == false) goto L147;
        AnimatorSet r29 = r28.z;
        if (r29 == null) goto L225;
        AnimatorSet.Builder r31 = r29.play(r5);
        if (r31 == null) goto L225;
        AnimatorSet.Builder r32 = r31.with(r19);
        if (r32 == null) goto L225;
        AnimatorSet.Builder r33 = r32.with(r115);
        if (r33 == null) goto L225;
        r33.before(r24);
    L225:
        AnimatorSet r34 = this.a.z;
        if (r34 == null) goto L228;
        r34.addListener(new a(this));
    L228:
        this.a.getClass();
        AnimatorSet r35 = this.a.z;
        if (r35 == null) goto L232;
        r35.start();
        return;
    L232:
        return;
    L147:
        AnimatorSet r36 = r28.z;
        if (r36 == null) goto L225;
        AnimatorSet.Builder r37 = r36.play(r5);
        if (r37 == null) goto L225;
        r37.with(r19);
        goto L225
    L82:
        if (r27 != 5) goto L84;
        r26.setInterpolator(new h());
        r22.setInterpolator(new AccelerateDecelerateInterpolator());
        c90.a r38 = this.a;
        if (r38.l == false) goto L131;
        AnimatorSet r39 = r38.z;
        if (r39 == null) goto L225;
        AnimatorSet.Builder r41 = r39.play(r5);
        if (r41 == null) goto L225;
        AnimatorSet.Builder r42 = r41.with(r19);
        if (r42 == null) goto L225;
        AnimatorSet.Builder r43 = r42.with(r26);
        if (r43 == null) goto L225;
        r43.before(r22);
        goto L225
    L131:
        AnimatorSet r44 = r38.z;
        if (r44 == null) goto L225;
        AnimatorSet.Builder r45 = r44.play(r5);
        if (r45 == null) goto L225;
        r45.with(r19);
        goto L225
    L84:
        if (r27 != 48) goto L86;
        r113.setInterpolator(new h());
        r110.setInterpolator(new AccelerateDecelerateInterpolator());
        c90.a r46 = this.a;
        if (r46.l == false) goto L115;
        AnimatorSet r47 = r46.z;
        if (r47 == null) goto L225;
        AnimatorSet.Builder r48 = r47.play(r5);
        if (r48 == null) goto L225;
        AnimatorSet.Builder r49 = r48.with(r19);
        if (r49 == null) goto L225;
        AnimatorSet.Builder r51 = r49.with(r113);
        if (r51 == null) goto L225;
        r51.before(r110);
        goto L225
    L115:
        AnimatorSet r52 = r46.z;
        if (r52 == null) goto L225;
        AnimatorSet.Builder r53 = r52.play(r5);
        if (r53 == null) goto L225;
        r53.with(r19);
        goto L225
    L86:
        if (r27 != 80) goto L225;
        r25.setInterpolator(new h());
        r21.setInterpolator(new AccelerateDecelerateInterpolator());
        c90.a r54 = this.a;
        if (r54.l == false) goto L99;
        AnimatorSet r55 = r54.z;
        if (r55 == null) goto L225;
        AnimatorSet.Builder r56 = r55.play(r5);
        if (r56 == null) goto L225;
        AnimatorSet.Builder r57 = r56.with(r19);
        if (r57 == null) goto L225;
        AnimatorSet.Builder r58 = r57.with(r25);
        if (r58 == null) goto L225;
        r58.before(r21);
        goto L225
    L99:
        AnimatorSet r59 = r54.z;
        if (r59 == null) goto L225;
        AnimatorSet.Builder r61 = r59.play(r5);
        if (r61 == null) goto L225;
        r61.with(r19);
        goto L225
    L152:
        int r62 = this.a.g;
        if (r62 != 3) goto L155;
        r24.setInterpolator(new f());
        r115.setInterpolator(new AccelerateDecelerateInterpolator());
        c90.a r63 = this.a;
        if (r63.l == false) goto L220;
        AnimatorSet r64 = r63.z;
        if (r64 == null) goto L225;
        AnimatorSet.Builder r65 = r64.play(r5);
        if (r65 == null) goto L225;
        AnimatorSet.Builder r66 = r65.with(r19);
        if (r66 == null) goto L225;
        AnimatorSet.Builder r67 = r66.with(r24);
        if (r67 == null) goto L225;
        r67.after(r115);
        goto L225
    L220:
        AnimatorSet r68 = r63.z;
        if (r68 == null) goto L225;
        AnimatorSet.Builder r69 = r68.play(r5);
        if (r69 == null) goto L225;
        r69.with(r19);
        goto L225
    L155:
        if (r62 != 5) goto L157;
        r22.setInterpolator(new f());
        r26.setInterpolator(new AccelerateDecelerateInterpolator());
        c90.a r71 = this.a;
        if (r71.l == false) goto L204;
        AnimatorSet r72 = r71.z;
        if (r72 == null) goto L225;
        AnimatorSet.Builder r73 = r72.play(r5);
        if (r73 == null) goto L225;
        AnimatorSet.Builder r74 = r73.with(r19);
        if (r74 == null) goto L225;
        AnimatorSet.Builder r75 = r74.with(r22);
        if (r75 == null) goto L225;
        r75.after(r26);
        goto L225
    L204:
        AnimatorSet r76 = r71.z;
        if (r76 == null) goto L225;
        AnimatorSet.Builder r77 = r76.play(r5);
        if (r77 == null) goto L225;
        r77.with(r19);
        goto L225
    L157:
        if (r62 != 48) goto L159;
        r110.setInterpolator(new f());
        r113.setInterpolator(new AccelerateDecelerateInterpolator());
        c90.a r78 = this.a;
        if (r78.l == false) goto L188;
        AnimatorSet r79 = r78.z;
        if (r79 == null) goto L225;
        AnimatorSet.Builder r81 = r79.play(r5);
        if (r81 == null) goto L225;
        AnimatorSet.Builder r82 = r81.with(r19);
        if (r82 == null) goto L225;
        AnimatorSet.Builder r83 = r82.with(r110);
        if (r83 == null) goto L225;
        r83.after(r113);
        goto L225
    L188:
        AnimatorSet r84 = r78.z;
        if (r84 == null) goto L225;
        AnimatorSet.Builder r85 = r84.play(r5);
        if (r85 == null) goto L225;
        r85.with(r19);
        goto L225
    L159:
        if (r62 != 80) goto L225;
        r21.setInterpolator(new f());
        r25.setInterpolator(new AccelerateDecelerateInterpolator());
        c90.a r86 = this.a;
        if (r86.l == false) goto L172;
        AnimatorSet r87 = r86.z;
        if (r87 == null) goto L225;
        AnimatorSet.Builder r88 = r87.play(r5);
        if (r88 == null) goto L225;
        AnimatorSet.Builder r89 = r88.with(r19);
        if (r89 == null) goto L225;
        AnimatorSet.Builder r91 = r89.with(r21);
        if (r91 == null) goto L225;
        r91.after(r25);
        goto L225
    L172:
        AnimatorSet r92 = r86.z;
        if (r92 == null) goto L225;
        AnimatorSet.Builder r93 = r92.play(r5);
        if (r93 == null) goto L225;
        r93.with(r19);
        goto L225
    L76:
        r117 = 150;
        goto L77
    L72:
        r116 = 150;
        goto L73
    L68:
        r114 = 150;
        goto L69
    L64:
        r112 = 150;
        goto L65
    L60:
        r111 = 200;
        goto L61
    L56:
        r23 = 200;
        goto L57
    L52:
        r6 = 200;
        goto L53
    L41:
        r18 = 1.0f;
        goto L42
    L37:
        r13 = 0.0f;
        goto L38
    L33:
        r12 = 1.0f;
        goto L34
    L11:
        float r94 = this.b.getX();
        LiveBubbleLayout r95 = this.a.v;
        if (r95 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mDmtBubbleLayout");
    L14:
        r3 = (int) (r94 + r95.getBubbleOffset());
        float r96 = this.b.getY();
    L29:
        r7 = (int) r96;
        goto L30
    L15:
        float r97 = this.b.getX();
        LiveBubbleLayout r98 = this.a.v;
        if (r98 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mDmtBubbleLayout");
    L18:
        r3 = (int) (r97 + r98.getBubbleOffset());
        float r99 = this.b.getY();
        float r100 = this.b.getMeasuredHeight();
    L28:
        r96 = r99 + r100;
        goto L29
    L19:
        r3 = (int) this.b.getX();
        float r101 = this.b.getY();
        LiveBubbleLayout r102 = this.a.v;
        if (r102 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mDmtBubbleLayout");
    L22:
        float r103 = r102.getBubbleOffset();
    L27:
        float r118 = r101;
        r100 = r103;
        r99 = r118;
        goto L28
    L23:
        r3 = (int) (this.b.getX() + this.b.getMeasuredWidth());
        r101 = this.b.getY();
        LiveBubbleLayout r104 = this.a.v;
        if (r104 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mDmtBubbleLayout");
    L26:
        r103 = r104.getBubbleOffset();
        goto L27
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
