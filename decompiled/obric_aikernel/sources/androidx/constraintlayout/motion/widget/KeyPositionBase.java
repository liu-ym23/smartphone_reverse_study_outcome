package androidx.constraintlayout.motion.widget;

import android.graphics.RectF;
import android.view.View;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
abstract class KeyPositionBase extends Key {
    protected static final float SELECTION_SLOPE = 20.0f;
    int mCurveFit;

    KeyPositionBase() {
        this.mCurveFit = Key.UNSET;
    }

    abstract void calcPosition(int r10, int r11, float r12, float r13, float r14, float r15);

    @Override // androidx.constraintlayout.motion.widget.Key
    void getAttributeNames(HashSet<String> r10) {
    }

    abstract float getPositionX();

    abstract float getPositionY();

    public abstract boolean intersects(int r10, int r11, RectF r12, RectF r13, float r14, float r15);

    abstract void positionAttributes(View r10, RectF r11, RectF r12, float r13, float r14, String[] r15, float[] r16);
}
