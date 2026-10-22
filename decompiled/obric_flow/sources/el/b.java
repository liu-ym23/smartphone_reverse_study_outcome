package el;

import android.animation.ValueAnimator;
import com.github.rahatarmanahmed.cpv.CircularProgressView;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ float f16831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f16832b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CircularProgressView f16833c;

    public b(CircularProgressView r5, float r10, float r11) {
        this.f16833c = r5;
        this.f16831a = r10;
        this.f16832b = r11;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r5) {
        float r10 = ((Float) r5.getAnimatedValue()).floatValue();
        CircularProgressView r11 = this.f16833c;
        r11.f8505q = r10;
        float r12 = r11.f8505q;
        r11.f8496h = (this.f16831a - r12) + this.f16832b;
        r11.invalidate();
    }
}
