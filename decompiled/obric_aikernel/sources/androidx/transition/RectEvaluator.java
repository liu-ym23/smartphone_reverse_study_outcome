package androidx.transition;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

/* JADX INFO: loaded from: classes.dex */
class RectEvaluator implements TypeEvaluator<Rect> {
    private Rect mRect;

    RectEvaluator() {
    }

    RectEvaluator(Rect r10) {
        this.mRect = r10;
    }

    /* JADX INFO: renamed from: evaluate, reason: avoid collision after fix types in other method */
    public Rect evaluate2(float r10, Rect r11, Rect r12) {
        int r13 = r11.left;
        int r14 = r13 + ((int) ((r12.left - r13) * r10));
        int r15 = r11.top;
        int r16 = r15 + ((int) ((r12.top - r15) * r10));
        int r17 = r11.right;
        int r18 = r17 + ((int) ((r12.right - r17) * r10));
        int r19 = r11.bottom;
        int r20 = r19 + ((int) ((r12.bottom - r19) * r10));
        Rect r21 = this.mRect;
        if (r21 == null) goto L5;
        r21.set(r14, r16, r18, r20);
        return this.mRect;
    L5:
        return new Rect(r14, r16, r18, r20);
    }

    @Override // android.animation.TypeEvaluator
    public /* bridge */ /* synthetic */ Rect evaluate(float r10, Rect r11, Rect r12) {
        return evaluate2(r10, r11, r12);
    }
}
