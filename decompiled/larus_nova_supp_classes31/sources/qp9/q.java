package qp9;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.graphics.Rect;
import com.larus.photopicker.v2.impl.others.scale.ScaleGestureLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class q implements Runnable {
    public final /* synthetic */ ScaleGestureLayout a;
    public final /* synthetic */ Rect b;
    public final /* synthetic */ Rect c;
    public final /* synthetic */ pp9.b d;
    public final /* synthetic */ a e;
    public final /* synthetic */ float f;
    public final /* synthetic */ int[] g;

    public /* synthetic */ q(ScaleGestureLayout r1, Rect r2, Rect r3, pp9.a r4, a r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = 0.0f;
        this.g = null;
    }

    @Override // java.lang.Runnable
    public final void run() {
        final ScaleGestureLayout r1 = this.a;
        Rect r2 = this.b;
        Rect r3 = this.c;
        pp9.b r4 = this.d;
        a r5 = this.e;
        float r6 = this.f;
        int[] r7 = this.g;
        Rect r8 = r1.p;
        if (r8 == null) goto L5;
        boolean r9 = r8.isEmpty();
    L6:
        if (r2 == null) goto L8;
        boolean r10 = r2.isEmpty();
    L9:
        if (r3 == null) goto L11;
        boolean r11 = r3.isEmpty();
    L13:
        if (r9 == true) goto L32;
        if (r10 == true) goto L32;
        if (r11 == true) goto L32;
        if (r2 == null) goto L35;
        if (r3 == null) goto L36;
        int[] r12 = new int[2];
        r1.getLocationOnScreen(r12);
        r2.offset(-r12[0], -r12[1]);
        r3.offset(-r12[0], -r12[1]);
        AnimatorSet r13 = sp9.a.b(new Matrix(sp9.a.a(r2, r1.getWidth(), r1.getHeight(), r1.p, r4)), new Matrix(), r1.p, r5, new s(r1));
        ValueAnimator r14 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r14.addUpdateListener(new t(r1));
        r14.setDuration(r5.h);
        r14.setInterpolator(r5.d);
        Rect r15 = new Rect(r2);
        if (r7 != null) goto L24;
    L31:
        Animator r16 = r1.b(r15, r3, r6, false);
        r16.setDuration(r5.g);
        r16.setInterpolator(r5.c);
        AnimatorSet r17 = new AnimatorSet();
        r1.v = r17;
        r17.addListener(new v(r1));
        r17.playTogether(new Animator[]{r13, r16, r14});
        r17.setInterpolator(r1.B);
        r17.setDuration(200);
        r17.start();
        return;
    L24:
        if (r7.length != 4) goto L26;
        boolean r18 = true;
    L27:
        if (r18 == false) goto L30;
        r15.left += r7[0];
        r15.top += r7[1];
        r15.right -= r7[2];
        r15.bottom -= r7[3];
        goto L31
    L30:
        throw new IllegalArgumentException("maskInsetPixel length must equal 4".toString());
    L26:
        r18 = false;
        goto L27
    L36:
        return;
    L35:
        return;
    L32:
        ValueAnimator r19 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r19.addUpdateListener(new r(r1));
        AnimatorSet r20 = new AnimatorSet();
        r1.v = r20;
        r20.addListener(new u(r1));
        r20.playTogether(new Animator[]{r19});
        r20.setInterpolator(r1.B);
        r20.setDuration(200);
        r20.start();
        return;
    L11:
        r11 = true;
        goto L13
    L8:
        r10 = true;
        goto L9
    L5:
        r9 = true;
        goto L6
    }
}
