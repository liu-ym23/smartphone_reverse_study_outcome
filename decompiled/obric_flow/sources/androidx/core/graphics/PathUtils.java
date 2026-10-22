package androidx.core.graphics;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.DoNotInline;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
public final class PathUtils {

    @RequiresApi(26)
    public static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        public static float[] approximate(Path r5, float r10) {
            return r5.approximate(r10);
        }
    }

    private PathUtils() {
    }

    @NonNull
    @RequiresApi(26)
    public static Collection<PathSegment> flatten(@NonNull Path r5) {
        return flatten(r5, 0.5f);
    }

    @NonNull
    @RequiresApi(26)
    public static Collection<PathSegment> flatten(@NonNull Path r10, @FloatRange(from = 0.0d) float r11) {
        float[] r12 = Api26Impl.approximate(r10, r11);
        int r13 = r12.length / 3;
        ArrayList r5 = new ArrayList(r13);
        int r14 = 1;
    L3:
        if (r14 >= r13) goto L12;
        int r15 = r14 * 3;
        int r16 = (r14 - 1) * 3;
        float r17 = r12[r15];
        float r18 = r12[r15 + 1];
        float r19 = r12[r15 + 2];
        float r20 = r12[r16];
        float r21 = r12[r16 + 1];
        float r22 = r12[r16 + 2];
        if (r17 == r20) goto L11;
        if (r18 == r21) goto L9;
    L10:
        r5.add(new PathSegment(new PointF(r21, r22), r20, new PointF(r18, r19), r17));
        goto L11
    L9:
        if (r19 != r22) goto L10;
    L11:
        r14 = r14 + 1;
        goto L3
    L12:
        return r5;
    }
}
