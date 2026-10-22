package androidx.core.graphics;

import android.graphics.Matrix;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u0014\n\u0000\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u001a\u001a\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003\u001a\u001a\u0010\t\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u001a\u0015\u0010\f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0086\n\u001a\r\u0010\u000e\u001a\u00020\u000f*\u00020\u0001H\u0086\b¨\u0006\u0010"}, d2 = {"rotationMatrix", "Landroid/graphics/Matrix;", "degrees", "", "px", "py", "scaleMatrix", "sx", "sy", "translationMatrix", "tx", "ty", "times", "m", "values", "", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMatrix.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Matrix.kt\nandroidx/core/graphics/MatrixKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,54:1\n1#2:55\n*E\n"})
public final class MatrixKt {
    public static final Matrix rotationMatrix(float r5, float r10, float r11) {
        Matrix r12 = new Matrix();
        r12.setRotate(r5, r10, r11);
        return r12;
    }

    public static /* synthetic */ Matrix rotationMatrix$default(float r5, float r10, float r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L6;
        r10 = 0.0f;
    L6:
        if ((r12 & 4) == 0) goto L9;
        r11 = 0.0f;
    L9:
        return rotationMatrix(r5, r10, r11);
    }

    public static final Matrix scaleMatrix(float r5, float r10) {
        Matrix r11 = new Matrix();
        r11.setScale(r5, r10);
        return r11;
    }

    public static /* synthetic */ Matrix scaleMatrix$default(float r5, float r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = 1.0f;
    L6:
        if ((r11 & 2) == 0) goto L9;
        r10 = 1.0f;
    L9:
        return scaleMatrix(r5, r10);
    }

    public static final Matrix times(Matrix r5, Matrix r10) {
        Matrix r11 = new Matrix(r5);
        r11.preConcat(r10);
        return r11;
    }

    public static final Matrix translationMatrix(float r5, float r10) {
        Matrix r11 = new Matrix();
        r11.setTranslate(r5, r10);
        return r11;
    }

    public static /* synthetic */ Matrix translationMatrix$default(float r5, float r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = 0.0f;
    L6:
        if ((r11 & 2) == 0) goto L9;
        r10 = 0.0f;
    L9:
        return translationMatrix(r5, r10);
    }

    public static final float[] values(Matrix r5) {
        float[] r10 = new float[9];
        r5.getValues(r10);
        return r10;
    }
}
