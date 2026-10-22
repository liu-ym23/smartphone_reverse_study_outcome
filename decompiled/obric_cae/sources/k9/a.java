package k9;

import aa.f;
import android.animation.ValueAnimator;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* JADX INFO: loaded from: classes.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BottomSheetBehavior f8974a;

    public a(BottomSheetBehavior r8) {
        this.f8974a = r8;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r8) {
        float r10 = ((Float) r8.getAnimatedValue()).floatValue();
        f r11 = this.f8974a.f4416i;
        if (r11 == null) goto L8;
        f.b r12 = r11.f139a;
        if (r12.f165j == r10) goto L9;
        r12.f165j = r10;
        r11.f143o = true;
        r11.invalidateSelf();
        return;
    L9:
        return;
    }
}
