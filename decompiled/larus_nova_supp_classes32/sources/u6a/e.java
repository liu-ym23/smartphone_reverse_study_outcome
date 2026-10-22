package u6a;

import android.animation.ValueAnimator;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIShadowProxy;
import com.lynx.tasm.behavior.ui.utils.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class e implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ float a;
    public final /* synthetic */ m b;
    public final /* synthetic */ LynxUI c;
    public final /* synthetic */ float d;
    public final /* synthetic */ float e;
    public final /* synthetic */ float f;
    public final /* synthetic */ float g;
    public final /* synthetic */ float h;
    public final /* synthetic */ float i;
    public final /* synthetic */ float j;

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r4) {
        float r5 = r4.getAnimatedFraction();
        float r0 = this.a + ((this.b.h() - this.a) * r5);
        this.c.getView().setTranslationX(r0);
        float r1 = this.d + ((this.b.i() - this.d) * r5);
        this.c.getView().setTranslationY(r1);
        float r2 = this.e + ((this.b.j() - this.e) * r5);
        this.c.getView().setTranslationZ(r2);
        float r3 = this.f + ((this.b.c() - this.f) * r5);
        this.c.getView().setRotation(r3);
        float r6 = this.g + ((this.b.d() - this.g) * r5);
        this.c.getView().setRotationX(r6);
        float r7 = this.h + ((this.b.e() - this.h) * r5);
        this.c.getView().setRotationY(r7);
        float r8 = this.i + ((this.b.f() - this.i) * r5);
        this.c.getView().setScaleX(r8);
        float r9 = this.j + (r5 * (this.b.g() - this.j));
        this.c.getView().setScaleY(r9);
        if ((this.c.getParent() instanceof UIShadowProxy) == false) goto L6;
        ((UIShadowProxy) this.c.getParent()).N();
        return;
    }

    public e(float r1, m r2, LynxUI r3, float r4, float r5, float r6, float r7, float r8, float r9, float r10) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
    }
}
