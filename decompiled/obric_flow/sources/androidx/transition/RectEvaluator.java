package androidx.transition;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

/* JADX INFO: loaded from: classes.dex */
class RectEvaluator implements TypeEvaluator<Rect> {
    private Rect mRect;

    public RectEvaluator() {
    }

    @Override // android.animation.TypeEvaluator
    public /* bridge */ /* synthetic */ Rect evaluate(float r5, Rect r10, Rect r11) {
        return evaluate2(r5, r10, r11);
    }

    public RectEvaluator(Rect r5) {
        this.mRect = r5;
    }

    /* JADX INFO: renamed from: evaluate, reason: avoid collision after fix types in other method */
    public Rect evaluate2(float r5, Rect r10, Rect r11) {
        int r12 = r10.left;
        int r13 = r12 + ((int) ((r11.left - r12) * r5));
        int r14 = r10.top;
        int r15 = r14 + ((int) ((r11.top - r14) * r5));
        int r16 = r10.right;
        int r17 = r16 + ((int) ((r11.right - r16) * r5));
        int r18 = r10.bottom;
        int r19 = r18 + ((int) ((r11.bottom - r18) * r5));
        Rect r20 = this.mRect;
        if (r20 == null) goto L5;
        r20.set(r13, r15, r17, r19);
        return this.mRect;
    L5:
        return new Rect(r13, r15, r17, r19);
    }
}
