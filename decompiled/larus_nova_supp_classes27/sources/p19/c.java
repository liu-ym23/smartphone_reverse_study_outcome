package p19;

import android.graphics.Path;
import android.graphics.RectF;
import androidx.core.graphics.MatrixKt;
import com.github.alexzhirkevich.customqrgenerator.vector.style.m;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c implements m {
    public final float a;

    public c(float r1) {
        this.a = r1;
    }

    public final Path a(float r8, com.github.alexzhirkevich.customqrgenerator.style.c r9) {
        Intrinsics.checkNotNullParameter(r9, "neighbors");
        Path r10 = new Path();
        float r3 = r8 / 8.0f;
        r10.addRoundRect(new RectF(0.0f, 0.0f, r8, r8), new float[]{r3, r3, r3, r3, r3, r3, r3, r3}, Path.Direction.CW);
        float r0 = 1;
        float r2 = r0 / ((float) Math.sqrt(2.0f));
        r10.transform(MatrixKt.scaleMatrix(r2, r2));
        float r11 = (r8 * (r0 - r2)) / 2;
        r10.transform(MatrixKt.translationMatrix(r11, r11));
        r10.transform(MatrixKt.scaleMatrix(RangesKt.coerceIn(this.a, 0.0f, 1.0f), RangesKt.coerceIn(this.a, 0.0f, 1.0f)));
        return r10;
    }
}
