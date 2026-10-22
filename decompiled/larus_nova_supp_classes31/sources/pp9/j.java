package pp9;

import android.animation.TypeEvaluator;
import android.graphics.Rect;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class j implements TypeEvaluator<Rect> {
    public final Rect a;

    public j(Rect r1) {
        this.a = r1;
    }

    public final Rect a(float r5, Rect r6, Rect r7) {
        Intrinsics.checkNotNull(r6);
        int r0 = r6.left;
        Intrinsics.checkNotNull(r7);
        int r1 = r0 + ((int) ((r7.left - r6.left) * r5));
        int r2 = r6.top;
        int r3 = r2 + ((int) ((r7.top - r2) * r5));
        int r4 = r6.right;
        int r8 = r4 + ((int) ((r7.right - r4) * r5));
        int r9 = r6.bottom;
        int r10 = r9 + ((int) ((r7.bottom - r9) * r5));
        Rect r11 = this.a;
        if (r11 == null) goto L7;
        Intrinsics.checkNotNull(r11);
        r11.set(r1, r3, r8, r10);
        return this.a;
    L7:
        return new Rect(r1, r3, r8, r10);
    }

    @Override // android.animation.TypeEvaluator
    public final /* bridge */ /* synthetic */ Rect evaluate(float r1, Rect r2, Rect r3) {
        return a(r1, r2, r3);
    }
}
