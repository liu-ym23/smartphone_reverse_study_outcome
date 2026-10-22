package com.lynx.tasm.utils;

import android.text.StaticLayout;
import com.lynx.tasm.base.CalledByNative;
import java.nio.ByteBuffer;
import java.text.DecimalFormat;
import zm.t;

/* JADX INFO: loaded from: classes2.dex */
class TextUtils {
    @CalledByNative
    private static String getFirstLineText(String r10, String r11, String r12, String r13) {
        if (r10.isEmpty() == false) goto L5;
        return "";
    L5:
        if (r11.isEmpty() == true) goto L23;
        DecimalFormat r5 = t.f23539a;
        float r14 = k.c(r11, 0.0f, 0.0f, 0.0f, 0.0f, g.a(14.0f, 0.0f), DisplayMetricsHolder.a());
        if (android.text.TextUtils.isEmpty(r13) == false) goto L10;
        float r15 = 0.0f;
    L12:
        if (r14 > 0.0f) goto L14;
        return "";
    L14:
        if (r15 < 1.0f) goto L24;
        StaticLayout.Builder r16 = StaticLayout.Builder.obtain(r10, 0, r10.length(), t.b(r14, r12), (int) Math.floor(r15));
        r16.setMaxLines(1);
        StaticLayout r17 = r16.build();
        if (r17.getLineCount() > 0) goto L19;
        return "";
    L19:
        return r10.substring(r17.getLineStart(0), r17.getLineEnd(0));
    L24:
        return "";
    L10:
        r15 = k.c(r13, 0.0f, 0.0f, 0.0f, 0.0f, g.a(0.0f, 0.0f), DisplayMetricsHolder.a());
        goto L12
    L23:
        return "";
    }

    @CalledByNative
    private static ByteBuffer getTextInfo(String r5, String r10, String r11, String r12, int r13) {
        return kn.b.b(t.d(r5, r10, r11, r12, r13));
    }

    @CalledByNative
    private static double getTextWidth(String r11, String r12, String r13) {
        if (r11.isEmpty() == false) goto L5;
    L12:
        return 0.0d;
    L5:
        if (r12.isEmpty() == true) goto L12;
        DecimalFormat r5 = t.f23539a;
        float r14 = k.c(r12, 0.0f, 0.0f, 0.0f, 0.0f, g.a(14.0f, 0.0f), DisplayMetricsHolder.a());
        if (r14 > 0.0f) goto L11;
        return 0.0d;
    L11:
        return t.b(r14, r13).measureText(r11) / DisplayMetricsHolder.a().density;
    }
}
