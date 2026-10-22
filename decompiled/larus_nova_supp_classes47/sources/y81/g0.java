package y81;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import com.bytedance.android.live.room.incentiveinfo.model.BizStatus;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g0<T> implements Consumer {
    public final /* synthetic */ d0 a;

    public g0(d0 r1) {
        this.a = r1;
    }

    public final void accept(Object r9) {
        d0 r10 = (d0) r9;
        if (this.a.Z != BizStatus.END.getValue()) goto L35;
        d0 r0 = this.a;
        if (r0.c == false) goto L35;
        if (r0.g.getVisibility() != 0) goto L35;
        d0 r1 = this.a;
        r1.e0 = true;
        ValueAnimator r2 = r1.G;
        if (r2 == null) goto L11;
        r2.cancel();
    L11:
        ValueAnimator r3 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r1.G = r3;
        if (r3 == null) goto L14;
        r3.addListener(new j0(r1));
        r3.addUpdateListener(new k0(r3, r1));
        r3.setStartDelay(200);
        r3.setDuration(500);
    L14:
        ValueAnimator r4 = r1.G;
        if (r4 == null) goto L17;
        r4.start();
    L17:
        ValueAnimator r5 = r1.I;
        if (r5 == null) goto L20;
        r5.cancel();
    L20:
        ValueAnimator r12 = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(ColorProtector.parseColor("#80000000")), Integer.valueOf(ColorProtector.parseColor("#26000000"))});
        r1.I = r12;
        if (r12 == null) goto L23;
        r12.addListener(new l0(r1));
        r12.addUpdateListener(new m0(r12, r1));
        r12.setStartDelay(200);
        r12.setDuration(300);
    L23:
        ValueAnimator r13 = r1.I;
        if (r13 == null) goto L26;
        r13.start();
    L26:
        ValueAnimator r14 = r1.H;
        if (r14 == null) goto L29;
        r14.cancel();
    L29:
        ValueAnimator r15 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r1.H = r15;
        if (r15 == null) goto L32;
        r15.addListener(new n0(r1));
        r15.addUpdateListener(new o0(r15, r1));
        r15.setDuration(200);
    L32:
        ValueAnimator r16 = r1.H;
        if (r16 == null) goto L37;
        r16.start();
        return;
    L37:
        return;
    L35:
        this.a.i(0);
    }
}
