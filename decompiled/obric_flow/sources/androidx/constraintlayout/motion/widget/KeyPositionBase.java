package androidx.constraintlayout.motion.widget;

import android.graphics.RectF;
import android.view.View;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
abstract class KeyPositionBase extends Key {
    protected static final float SELECTION_SLOPE = 20.0f;
    int mCurveFit;

    public KeyPositionBase() {
        this.mCurveFit = Key.UNSET;
    }

    public abstract void calcPosition(int r5, int r10, float r11, float r12, float r13, float r14);

    @Override // androidx.constraintlayout.motion.widget.Key
    public void getAttributeNames(HashSet<String> r5) {
    }

    public abstract float getPositionX();

    public abstract float getPositionY();

    public abstract boolean intersects(int r5, int r10, RectF r11, RectF r12, float r13, float r14);

    public abstract void positionAttributes(View r5, RectF r10, RectF r11, float r12, float r13, String[] r14, float[] r15);
}
