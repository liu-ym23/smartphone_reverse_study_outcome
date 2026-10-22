package z6a;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import java.lang.reflect.Constructor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class p {
    public p() {
    }

    public static StaticLayout a(CharSequence r30, int r31, TextPaint r32, int r33, Layout.Alignment r34, float r35, float r36, boolean r37, TextUtils.TruncateAt r38, int r39, TextDirectionHeuristic r40) {
        int r0 = r39;
        if (r0 == (-1)) goto L5;
    L16:
        Class r6 = Integer.TYPE;     // Catch: Throwable -> L14
        Class r12 = Float.TYPE;     // Catch: Throwable -> L14
        Constructor r3 = StaticLayout.class.getConstructor(new Class[]{CharSequence.class, r6, r6, TextPaint.class, r6, Layout.Alignment.class, TextDirectionHeuristic.class, r12, r12, Boolean.TYPE, TextUtils.TruncateAt.class, r6, r6});     // Catch: Throwable -> L14
        Object[] r4 = new Object[13];     // Catch: Throwable -> L14
        r4[0] = r30;     // Catch: Throwable -> L14
        r4[1] = 0;     // Catch: Throwable -> L14
        r4[2] = Integer.valueOf(r31);     // Catch: Throwable -> L14
        r4[3] = r32;     // Catch: Throwable -> L14
        r4[4] = Integer.valueOf(r33);     // Catch: Throwable -> L14
        r4[5] = r34;     // Catch: Throwable -> L14
        r4[6] = r40;     // Catch: Throwable -> L14
        r4[7] = Float.valueOf(r35);     // Catch: Throwable -> L14
        r4[8] = Float.valueOf(r36);     // Catch: Throwable -> L14
        r4[9] = Boolean.valueOf(r37);     // Catch: Throwable -> L14
        r4[10] = r38;     // Catch: Throwable -> L14
        r4[11] = Integer.valueOf(r33);     // Catch: Throwable -> L14
        if (r0 != (-1)) goto L12;
        r0 = Integer.MAX_VALUE;
    L12:
        r4[12] = Integer.valueOf(r0);     // Catch: Throwable -> L14
        return (StaticLayout) r3.newInstance(r4);
    L15:
        return new StaticLayout(r30, 0, r31, r32, r33, r34, r35, r36, r37);
    L5:
        if (r40 != TextDirectionHeuristics.FIRSTSTRONG_LTR) goto L16;
        return new StaticLayout(r30, 0, r31, r32, r33, r34, r35, r36, r37);
    }
}
