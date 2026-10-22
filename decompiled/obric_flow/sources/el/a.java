package el;

import android.animation.ValueAnimator;
import com.github.rahatarmanahmed.cpv.CircularProgressView;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16829a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CircularProgressView f16830b;

    public /* synthetic */ a(CircularProgressView r5, int r10) {
        this.f16829a = r10;
        this.f16830b = r5;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r5) {
        switch(this.f16829a) {
            case 0: goto L14;
            case 1: goto L12;
            case 2: goto L10;
            case 3: goto L8;
            case 4: goto L6;
            default: goto L4;
        };
    L4:
        this.f16830b.f8497i = ((Float) r5.getAnimatedValue()).floatValue();
        return;
    L6:
        this.f16830b.f8497i = ((Float) r5.getAnimatedValue()).floatValue();
        return;
    L8:
        float r10 = ((Float) r5.getAnimatedValue()).floatValue();
        CircularProgressView r11 = this.f16830b;
        r11.f8496h = r10;
        r11.invalidate();
        return;
    L10:
        float r12 = ((Float) r5.getAnimatedValue()).floatValue();
        CircularProgressView r13 = this.f16830b;
        r13.f8506r = r12;
        r13.invalidate();
        return;
    L12:
        float r14 = ((Float) r5.getAnimatedValue()).floatValue();
        CircularProgressView r15 = this.f16830b;
        r15.f8505q = r14;
        r15.invalidate();
        return;
    L14:
        float r16 = ((Float) r5.getAnimatedValue()).floatValue();
        CircularProgressView r17 = this.f16830b;
        r17.f8506r = r16;
        r17.invalidate();
    }
}
