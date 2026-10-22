package com.bytedance.android.ec.core.utils;

import android.graphics.Color;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class s {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Integer b(String r10) {
        if (r10 != null) goto L5;
    L8:
        boolean r11 = true;
    L10:
        if (r11 == false) goto L22;
        return null;
    L22:
    L19:
        e = move-exception;
        ECExceptionMonitor.f(e, "an error occurs when parsing color " + r10);
        return null;
    L14:
        if (StringsKt.startsWith$default(r10, "#", false, 2, null) == true) goto L16;
        String r0 = "#" + r10;     // Catch: Exception -> L19
    L17:
        return Integer.valueOf(Color.parseColor(r0));
    L16:
        r0 = r10;
        goto L17
    L5:
        if (StringsKt.isBlank(r10) == true) goto L8;
        r11 = false;
        goto L10
    }

    public static int a(String r10, int r11) {
        if (r10 != null) goto L5;
    L8:
        boolean r12 = true;
    L9:
        if (r12 == false) goto L21;
        return r11;
    L21:
    L18:
        e = move-exception;
        ECExceptionMonitor.f(e, "an error occurs when parsing color " + r10);
        return r11;
    L13:
        if (StringsKt.startsWith$default(r10, "#", false, 2, null) == true) goto L15;
        String r0 = "#" + r10;     // Catch: Exception -> L18
    L16:
        return Color.parseColor(r0);
    L15:
        r0 = r10;
        goto L16
    L5:
        if (StringsKt.isBlank(r10) == true) goto L8;
        r12 = false;
        goto L9
    }
}
