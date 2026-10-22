package r5;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class g implements TypeEvaluator<Matrix> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float[] f12683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float[] f12684b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Matrix f12685c;

    public g() {
        this.f12683a = new float[9];
        this.f12684b = new float[9];
        this.f12685c = new Matrix();
    }

    @NonNull
    public Matrix a(float r10, @NonNull Matrix r11, @NonNull Matrix r12) {
        r11.getValues(this.f12683a);
        r12.getValues(this.f12684b);
        int r13 = 0;
    L4:
        if (r13 >= 9) goto L6;
        float[] r14 = this.f12684b;
        float r15 = r14[r13];
        float[] r16 = this.f12683a;
        float r17 = r15 - r16[r13];
        r14[r13] = r16[r13] + (r17 * r10);
        r13 = r13 + 1;
        goto L4
    L6:
        this.f12685c.setValues(this.f12684b);
        return this.f12685c;
    }
}
