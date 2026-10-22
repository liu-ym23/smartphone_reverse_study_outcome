package ic;

import android.animation.ValueAnimator;
import android.widget.TextView;
import com.obric.oui.forms.OInputView;

/* JADX INFO: loaded from: classes2.dex */
public final class j implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OInputView f8318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f8319b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ int f8320m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ int f8321n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ float f8322o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final /* synthetic */ TextView f8323p;

    public j(OInputView r8, float r10, int r11, int r12, float r13, TextView r14) {
        this.f8318a = r8;
        this.f8319b = r10;
        this.f8320m = r11;
        this.f8321n = r12;
        this.f8322o = r13;
        this.f8323p = r14;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r8) {
        he.i.f(r8, "animation");
        Object r10 = r8.getAnimatedValue();
        if (r10 == null) goto L7;
        float r11 = ((Float) r10).floatValue();
        float r12 = 0;
        float r13 = defpackage.a.a(this.f8319b, r12, r11, r12);
        int r14 = OInputView.f6291v0;
        this.f8318a.getClass();
        int r15 = a0.a.b(l6.a.w(r11), this.f8320m, this.f8321n);
        float r16 = defpackage.a.a(this.f8322o, 1.0f, r11, 1.0f);
        TextView r17 = this.f8323p;
        r17.setTextColor(r15);
        r17.setScaleX(r16);
        r17.setScaleY(r16);
        r17.setTranslationY(r13);
        zc.b.g("OInputView", "progress: " + r11 + ", transY: " + r13 + ", scale: " + r16);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
