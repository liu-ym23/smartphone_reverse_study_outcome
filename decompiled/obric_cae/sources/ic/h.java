package ic;

import android.animation.ValueAnimator;
import android.widget.TextView;
import com.obric.oui.forms.OInputView;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OInputView f8310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f8311b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ int f8312m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ int f8313n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ float f8314o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final /* synthetic */ TextView f8315p;

    public h(OInputView r8, float r10, int r11, int r12, float r13, TextView r14) {
        this.f8310a = r8;
        this.f8311b = r10;
        this.f8312m = r11;
        this.f8313n = r12;
        this.f8314o = r13;
        this.f8315p = r14;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r8) {
        he.i.f(r8, "animation");
        Object r10 = r8.getAnimatedValue();
        if (r10 == null) goto L7;
        float r11 = ((Float) r10).floatValue();
        float r12 = this.f8311b;
        float r13 = defpackage.a.a(0, r12, r11, r12);
        int r14 = OInputView.f6291v0;
        this.f8310a.getClass();
        int r15 = a0.a.b(l6.a.w(r11), this.f8312m, this.f8313n);
        float r16 = this.f8314o;
        float r17 = defpackage.a.a(1.0f, r16, r11, r16);
        TextView r18 = this.f8315p;
        r18.setTextColor(r15);
        r18.setScaleX(r17);
        r18.setScaleY(r17);
        r18.setTranslationY(r13);
        zc.b.g("OInputView", "progress: " + r11 + ", transY: " + r13 + ", scale: " + r17);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
