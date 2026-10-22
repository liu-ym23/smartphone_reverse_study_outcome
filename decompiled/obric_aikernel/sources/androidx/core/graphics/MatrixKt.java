package androidx.core.graphics;

import android.graphics.Matrix;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@SourceDebugExtension({"SMAP\nMatrix.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Matrix.kt\nandroidx/core/graphics/MatrixKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,54:1\n1#2:55\n*E\n"})
public final class MatrixKt {
    public static final Matrix rotationMatrix(float r10, float r11, float r12) {
        Matrix r13 = new Matrix();
        r13.setRotate(r10, r11, r12);
        return r13;
    }

    public static /* synthetic */ Matrix rotationMatrix$default(float r10, float r11, float r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = 0.0f;
    L6:
        if ((r13 & 4) == 0) goto L9;
        r12 = 0.0f;
    L9:
        return rotationMatrix(r10, r11, r12);
    }

    public static final Matrix scaleMatrix(float r10, float r11) {
        Matrix r12 = new Matrix();
        r12.setScale(r10, r11);
        return r12;
    }

    public static /* synthetic */ Matrix scaleMatrix$default(float r10, float r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = 1.0f;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r11 = 1.0f;
    L9:
        return scaleMatrix(r10, r11);
    }

    public static final Matrix times(Matrix r10, Matrix r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "m");
        Matrix r12 = new Matrix(r10);
        r12.preConcat(r11);
        return r12;
    }

    public static final Matrix translationMatrix(float r10, float r11) {
        Matrix r12 = new Matrix();
        r12.setTranslate(r10, r11);
        return r12;
    }

    public static /* synthetic */ Matrix translationMatrix$default(float r10, float r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = 0.0f;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r11 = 0.0f;
    L9:
        return translationMatrix(r10, r11);
    }

    public static final float[] values(Matrix r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        float[] r11 = new float[9];
        r10.getValues(r11);
        return r11;
    }
}
