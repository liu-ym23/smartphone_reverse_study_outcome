package p5a;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import c5a.c;
import o5a.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public static Layout a(CharSequence r27, d r28, int r29) {
        Layout.Alignment r0 = Layout.Alignment.ALIGN_NORMAL;
        int r1 = r28.getGravity();
        if (r1 == 3) goto L10;
        if (r1 != 5) goto L6;
        Layout.Alignment r2 = Layout.Alignment.ALIGN_OPPOSITE;
    L11:
        Layout.Alignment r7 = r2;
        int r3 = Build.VERSION.SDK_INT;
        if (r3 < 23) goto L26;
        int r5 = r28.getTextDirection();
        if (r5 == 3) goto L20;
        if (r5 == 4) goto L19;
        if (r5 == 5) goto L18;
        TextDirectionHeuristic r4 = TextDirectionHeuristics.LTR;
    L21:
        StaticLayout.Builder r6 = StaticLayout.Builder.obtain(r27, 0, r27.length(), r28.getPaint(), r29).setAlignment(r7).setTextDirection(r4).setLineSpacing(r28.getLineSpacingExtra(), r28.getLineSpacingMultiplier()).setIncludePad(r28.getIncludeFontPadding());
        if (r3 < 28) goto L25;
        r6.setUseLineSpacingFromFallbacks(true);
    L25:
        return r6.build();
    L18:
        r4 = TextDirectionHeuristics.LOCALE;
        goto L21
    L19:
        r4 = TextDirectionHeuristics.RTL;
        goto L21
    L20:
        r4 = TextDirectionHeuristics.LTR;
        goto L21
    L26:
        int r8 = r28.getTextDirection();
        if (r8 == 3) goto L33;
        if (r8 == 4) goto L32;
        if (r8 == 5) goto L31;
        TextDirectionHeuristic r9 = TextDirectionHeuristics.LTR;
    L34:
        int r10 = r27.length();
        TextPaint r11 = r28.getPaint();
        float r12 = r28.getLineSpacingMultiplier();
        float r13 = r28.getLineSpacingExtra();
        boolean r14 = r28.getIncludeFontPadding();
        TextUtils.TruncateAt r15 = TextUtils.TruncateAt.END;
        if (r9 == TextDirectionHeuristics.FIRSTSTRONG_LTR) goto L41;
        Class r18 = Integer.TYPE;     // Catch: Throwable -> L38
        Class r20 = Float.TYPE;     // Catch: Throwable -> L38
        return (StaticLayout) StaticLayout.class.getConstructor(new Class[]{CharSequence.class, r18, r18, TextPaint.class, r18, Layout.Alignment.class, TextDirectionHeuristic.class, r20, r20, Boolean.TYPE, TextUtils.TruncateAt.class, r18, r18}).newInstance(new Object[]{r27, 0, Integer.valueOf(r10), r11, Integer.valueOf(r29), r7, r9, Float.valueOf(r12), Float.valueOf(r13), Boolean.valueOf(r14), r15, Integer.valueOf(r29), Integer.MAX_VALUE});
    L38:
        th = move-exception;
        c.b("Lynx", "create StaticLayout failed!", th);
        return new StaticLayout(r27, 0, r10, r11, r29, r7, r12, r13, r14);
    L41:
        return new StaticLayout(r27, 0, r10, r11, r29, r7, r12, r13, r14);
    L31:
        r9 = TextDirectionHeuristics.LOCALE;
        goto L34
    L32:
        r9 = TextDirectionHeuristics.RTL;
        goto L34
    L33:
        r9 = TextDirectionHeuristics.LTR;
        goto L34
    L6:
        if (r1 == 17) goto L8;
        r2 = Layout.Alignment.ALIGN_NORMAL;
        goto L11
    L8:
        r2 = Layout.Alignment.ALIGN_CENTER;
        goto L11
    L10:
        r2 = Layout.Alignment.ALIGN_NORMAL;
        goto L11
    }
}
