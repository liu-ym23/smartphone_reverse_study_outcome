package t6a;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class h extends Animation {
    public final View a;
    public final float b;
    public final float c;

    @Override // android.view.animation.Animation
    public final boolean willChangeBounds() {
        return false;
    }

    @Override // android.view.animation.Animation
    public final void applyTransformation(float r3, Transformation r4) {
        this.a.setAlpha(this.b + (this.c * r3));
    }

    public h(View r1, float r2, float r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3 - r2;
    }
}
