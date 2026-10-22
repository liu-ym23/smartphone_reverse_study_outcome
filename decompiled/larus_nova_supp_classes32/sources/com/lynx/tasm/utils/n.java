package com.lynx.tasm.utils;

import android.util.DisplayMetrics;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.lynx.tasm.base.LLog;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class n {
    public n() {
    }

    public static float a(String r7, float r8) {
        return b(r7, 0.0f, 0.0f, 0.0f, 0.0f, r8, DisplayMetricsHolder.getScreenDisplayMetrics());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [float] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v9 */
    public static float e(String r9, float r10, DisplayMetrics r11) {
        ?? r7 = 0;
        if (android.text.TextUtils.isEmpty(r9) == false) goto L5;
        int r0 = 0;
    L7:
        if (r0 > 1) goto L15;
    L11:
        r9 = b(r9, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, r11);     // Catch: Throwable -> L13
    L12:
        r7 = r9;
        return r7 == true ? 1.0f : 0.0f;
    L13:
        LLog.w("lynx", "Number parse error from value = " + r9 + " to px!");
        return r7;
    L15:
        if (r9.endsWith("%") == false) goto L11;
        r9 = (CastFloatProtector.parseFloat(r9.substring(0, r0 - 1)) * r10) / 100.0f;     // Catch: Throwable -> L13
        goto L12
    L5:
        r0 = r9.length();
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static float d(String r7, float r8, float r9, DisplayMetrics r10) {
        if (android.text.TextUtils.isEmpty(r7) == false) goto L5;
        int r0 = 0;
    L7:
        if (r0 > 1) goto L15;
    L11:
        r7 = b(r7, 0.0f, 0.0f, 0.0f, 0.0f, r9, r10);     // Catch: Throwable -> L13
    L12:
        r9 = r7;
        return r9;
    L13:
        LLog.w("lynx", "Number parse error from value = " + r7 + " to px!");
        return r9;
    L15:
        if (r7.endsWith("%") == false) goto L11;
        r7 = (CastFloatProtector.parseFloat(r7.substring(0, r0 - 1)) * r8) / 100.0f;     // Catch: Throwable -> L13
        goto L12
    L5:
        r0 = r7.length();
        goto L7
    }

    public static float c(String r7, float r8, float r9, float r10, float r11, DisplayMetrics r12) {
        return b(r7, r8, r9, r10, r11, 0.0f, r12);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v10, types: [float] */
    /* JADX WARN: Type inference failed for: r6v11, types: [float] */
    /* JADX WARN: Type inference failed for: r6v12, types: [float] */
    /* JADX WARN: Type inference failed for: r6v3, types: [float] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8, types: [float] */
    /* JADX WARN: Type inference failed for: r6v9, types: [float] */
    public static float b(String r6, float r7, float r8, float r9, float r10, float r11, DisplayMetrics r12) {
        if (android.text.TextUtils.isEmpty(r6) == false) goto L5;
        int r0 = 0;
    L7:
        if (r0 > 3) goto L47;
    L11:
        if (r0 <= 3) goto L16;
        if (r6.endsWith("ppx") == false) goto L16;
        r11 = CastFloatProtector.parseFloat(r6.substring(0, r0 - 3));     // Catch: Throwable -> L44
    L46:
    L45:
        return r11;
    L44:
        LLog.w("lynx", "Number parse error from value = " + r6 + " to px!");
    L16:
        if (r0 <= 2) goto L21;
        if (r6.endsWith("px") == false) goto L21;
        r11 = i.b(CastFloatProtector.parseFloat(r6.substring(0, r0 - 2)), 0.0f);     // Catch: Throwable -> L44
    L21:
        if (r0 > 1) goto L23;
    L25:
        if (r0 > 3) goto L27;
    L29:
        if (r0 > 2) goto L31;
    L33:
        if (r0 > 2) goto L35;
    L37:
        if (r0 > 2) goto L39;
    L41:
        if (r0 <= 0) goto L46;
        r11 = CastFloatProtector.parseFloat(r6);     // Catch: Throwable -> L44
        goto L46
    L39:
        if (r6.endsWith("vh") == false) goto L41;
        r6 = CastFloatProtector.parseFloat(r6.substring(0, r0 - 2));     // Catch: Throwable -> L44
        r11 = (r10 * r6) / 100.0f;     // Catch: Throwable -> L44
        goto L46
    L35:
        if (r6.endsWith("vw") == false) goto L37;
        r6 = CastFloatProtector.parseFloat(r6.substring(0, r0 - 2));     // Catch: Throwable -> L44
        r11 = (r9 * r6) / 100.0f;     // Catch: Throwable -> L44
        goto L46
    L31:
        if (r6.endsWith("em") == false) goto L33;
        r6 = CastFloatProtector.parseFloat(r6.substring(0, r0 - 2));     // Catch: Throwable -> L44
        r11 = r8 * r6;     // Catch: Throwable -> L44
        goto L46
    L27:
        if (r6.endsWith("rem") == false) goto L29;
        r6 = CastFloatProtector.parseFloat(r6.substring(0, r0 - 3));     // Catch: Throwable -> L44
        r11 = r7 * r6;     // Catch: Throwable -> L44
        goto L46
    L23:
        if (r6.endsWith("%") == false) goto L25;
        r6 = CastFloatProtector.parseFloat(r6.substring(0, r0 - 1));     // Catch: Throwable -> L44
        r11 = r6 / 100.0f;     // Catch: Throwable -> L44
        goto L46
    L47:
        if (r6.endsWith("rpx") == false) goto L11;
        r6 = r12.widthPixels * CastFloatProtector.parseFloat(r6.substring(0, r0 - 3));     // Catch: Throwable -> L44
        r11 = r6 / 750.0f;     // Catch: Throwable -> L44
        goto L46
    L5:
        r0 = r6.length();
        goto L7
    }
}
