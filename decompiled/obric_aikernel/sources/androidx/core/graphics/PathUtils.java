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
    static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        static float[] approximate(Path r10, float r11) {
            return r10.approximate(r11);
        }
    }

    private PathUtils() {
    }

    @NonNull
    @RequiresApi(26)
    public static Collection<PathSegment> flatten(@NonNull Path r10) {
        return flatten(r10, 0.5f);
    }

    @NonNull
    @RequiresApi(26)
    public static Collection<PathSegment> flatten(@NonNull Path r10, @FloatRange(from = 0.0d) float r11) {
        float[] r12 = Api26Impl.approximate(r10, r11);
        int r13 = r12.length / 3;
        ArrayList r14 = new ArrayList(r13);
        int r15 = 1;
    L3:
        if (r15 >= r13) goto L12;
        int r16 = r15 * 3;
        int r17 = (r15 - 1) * 3;
        float r18 = r12[r16];
        float r19 = r12[r16 + 1];
        float r20 = r12[r16 + 2];
        float r21 = r12[r17];
        float r22 = r12[r17 + 1];
        float r23 = r12[r17 + 2];
        if (r18 == r21) goto L11;
        if (r19 == r22) goto L9;
    L10:
        r14.add(new PathSegment(new PointF(r22, r23), r21, new PointF(r19, r20), r18));
        goto L11
    L9:
        if (r20 != r23) goto L10;
    L11:
        r15 = r15 + 1;
        goto L3
    L12:
        return r14;
    }
}
