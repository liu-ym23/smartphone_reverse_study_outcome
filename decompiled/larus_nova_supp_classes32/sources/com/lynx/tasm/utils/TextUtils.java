package com.lynx.tasm.utils;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import com.lynx.react.bridge.JavaOnlyMap;
import com.obric.aivoice.core.data.NameKeys;
import java.nio.ByteBuffer;
import java.text.DecimalFormat;
import z6a.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
class TextUtils {
    public TextUtils() {
    }

    private static double getTextWidth(String r2, String r3, String r4) {
        if (r2.isEmpty() == false) goto L5;
    L11:
        return 0.0d;
    L5:
        if (r3.isEmpty() == true) goto L11;
        DecimalFormat r0 = com.lynx.tasm.behavior.shadow.text.b.a;
        float r5 = n.a(r3, i.b(14.0f, 0.0f));
        if (r5 <= 0.0f) goto L11;
        return i.c(com.lynx.tasm.behavior.shadow.text.b.k(r5, r4).measureText(r2));
    }

    private static String getFirstLineText(String r12, String r13, String r14, String r15) {
        if (r12.isEmpty() == false) goto L5;
    L23:
        return NameKeys.UnloadStrategy_No_Strategy;
    L5:
        if (r13.isEmpty() == true) goto L23;
        DecimalFormat r0 = com.lynx.tasm.behavior.shadow.text.b.a;
        float r16 = n.a(r13, i.b(14.0f, 0.0f));
        if (android.text.TextUtils.isEmpty(r15) == false) goto L10;
        float r17 = 0.0f;
    L12:
        if (r16 <= 0.0f) goto L23;
        if (r17 < 1.0f) goto L23;
        TextPaint r3 = com.lynx.tasm.behavior.shadow.text.b.k(r16, r14);
        if (Build.VERSION.SDK_INT < 23) goto L19;
        StaticLayout.Builder r18 = StaticLayout.Builder.obtain(r12, 0, r12.length(), r3, (int) Math.floor(r17));
        r18.setMaxLines(1);
        StaticLayout r19 = r18.build();
    L21:
        if (r19.getLineCount() <= 0) goto L23;
        return r12.substring(r19.getLineStart(0), r19.getLineEnd(0));
    L19:
        r19 = p.a(r12, r12.length(), r3, (int) Math.floor(r17), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false, null, 1, TextDirectionHeuristics.FIRSTSTRONG_LTR);
        goto L21
    L10:
        r17 = n.a(r15, i.b(0.0f, 0.0f));
        goto L12
    }

    private static ByteBuffer getTextInfo(String r0, String r1, String r2, String r3, int r4) {
        JavaOnlyMap r5 = com.lynx.tasm.behavior.shadow.text.b.i(r0, r1, r2, r3, r4);
        j7a.a.a.getClass();
        return j7a.a.b(r5);
    }
}
