package y81;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class n<T> implements Consumer {
    public final /* synthetic */ l a;

    public n(l r1) {
        this.a = r1;
    }

    public final void accept(Object r8) {
        l r9 = (l) r8;
        Integer r10 = this.a.P;
        if (r10 != null) goto L6;
    L38:
        this.a.i(0);
        return;
    L6:
        if (r10.intValue() != 2) goto L38;
        l r12 = this.a;
        if (r12.c == false) goto L38;
        if (r12.g.getVisibility() != 0) goto L38;
        l r13 = this.a;
        ValueAnimator r2 = r13.w;
        if (r2 == null) goto L14;
        r2.cancel();
    L14:
        ValueAnimator r3 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r13.w = r3;
        if (r3 == null) goto L17;
        r3.addListener(new r(r13));
        r3.addUpdateListener(new s(r3, r13));
        r3.setStartDelay(200);
        r3.setDuration(500);
    L17:
        ValueAnimator r4 = r13.w;
        if (r4 == null) goto L20;
        r4.start();
    L20:
        ValueAnimator r5 = r13.y;
        if (r5 == null) goto L23;
        r5.cancel();
    L23:
        ValueAnimator r0 = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(ColorProtector.parseColor("#80000000")), Integer.valueOf(ColorProtector.parseColor("#26000000"))});
        r13.y = r0;
        if (r0 == null) goto L26;
        r0.addListener(new t(r13));
        r0.addUpdateListener(new u(r0, r13));
        r0.setStartDelay(200);
        r0.setDuration(300);
    L26:
        ValueAnimator r1 = r13.y;
        if (r1 == null) goto L29;
        r1.start();
    L29:
        ValueAnimator r6 = r13.x;
        if (r6 == null) goto L32;
        r6.cancel();
    L32:
        ValueAnimator r7 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r13.x = r7;
        if (r7 == null) goto L35;
        r7.addListener(new v(r13));
        r7.addUpdateListener(new w(r7, r13));
        r7.setDuration(200);
    L35:
        ValueAnimator r14 = r13.x;
        if (r14 == null) goto L40;
        r14.start();
        return;
    }
}
