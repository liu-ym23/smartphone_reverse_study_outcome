package gs;

import android.animation.ValueAnimator;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f17182b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f17183c;
    public final /* synthetic */ int d;
    public final /* synthetic */ i e;

    public h(i r5, int r10, int r11, int r12, int r13) {
        this.e = r5;
        this.f17181a = r10;
        this.f17182b = r11;
        this.f17183c = r12;
        this.d = r13;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r5) {
        float r10 = r5.getAnimatedFraction();
        i r11 = this.e;
        r11.getClass();
        int r12 = this.f17182b;
        int r13 = this.f17181a;
        int r14 = Math.round((r12 - r13) * r10) + r13;
        int r15 = this.d;
        int r16 = this.f17183c;
        int r17 = Math.round(r10 * (r15 - r16)) + r16;
        if (r14 == r11.f17188l) goto L5;
    L6:
        r11.f17188l = r14;
        r11.f17189m = r17;
        ViewCompat.postInvalidateOnAnimation(r11);
        return;
    L5:
        if (r17 != r11.f17189m) goto L6;
    }
}
