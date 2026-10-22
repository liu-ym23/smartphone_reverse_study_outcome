package androidx.core.graphics;

import android.graphics.Path;
import android.graphics.PointF;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
public final class PathUtils {

    static class Api26Impl {
        private Api26Impl() {
        }

        static float[] approximate(Path r0, float r1) {
            return r0.approximate(r1);
        }
    }

    private PathUtils() {
    }

    public static Collection<PathSegment> flatten(Path r1) {
        return flatten(r1, 0.5f);
    }

    public static Collection<PathSegment> flatten(Path r10, float r11) {
        float[] r12 = Api26Impl.approximate(r10, r11);
        int r13 = r12.length / 3;
        ArrayList r0 = new ArrayList(r13);
        int r1 = 1;
    L3:
        if (r1 >= r13) goto L12;
        int r2 = r1 * 3;
        int r3 = (r1 - 1) * 3;
        float r4 = r12[r2];
        float r5 = r12[r2 + 1];
        float r6 = r12[r2 + 2];
        float r7 = r12[r3];
        float r8 = r12[r3 + 1];
        float r9 = r12[r3 + 2];
        if (r4 == r7) goto L11;
        if (r5 == r8) goto L9;
    L10:
        r0.add(new PathSegment(new PointF(r8, r9), r7, new PointF(r5, r6), r4));
        goto L11
    L9:
        if (r6 != r9) goto L10;
    L11:
        r1 = r1 + 1;
        goto L3
    L12:
        return r0;
    }
}
