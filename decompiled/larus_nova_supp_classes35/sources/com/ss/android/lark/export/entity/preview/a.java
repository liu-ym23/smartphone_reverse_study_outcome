package com.ss.android.lark.export.entity.preview;

import android.content.Context;
import android.graphics.Color;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.ss.ttvideoengine.utils.ScreenUtils;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    static {
    }

    public static int b(int r3) {
        int r0 = (r3 >> 24) & ScreenUtils.MAX_SYSTEM_BRIGHTNESS;
        int r1 = (r3 >> 16) & ScreenUtils.MAX_SYSTEM_BRIGHTNESS;
        int r2 = (r3 >> 8) & ScreenUtils.MAX_SYSTEM_BRIGHTNESS;
        return Color.argb(r3 & ScreenUtils.MAX_SYSTEM_BRIGHTNESS, r0, r1, r2);
    }

    @JvmStatic
    public static final int a(ThemeColor r5, Context r6, ycb.a r7) {
        Intrinsics.checkNotNullParameter(r5, "themeColor");
        Intrinsics.checkNotNullParameter(r6, "context");
        String r0 = r5.getToken();
        if (r0 == null) goto L8;
        int r1 = c(r6, r0, r7);
        if (r1 <= 0) goto L8;
        return UDColorUtils.getColor(r6, r1);
    L8:
        int r2 = 0;
        if (r5.getKey().getType() == null) goto L31;
        ThemeColor.Key r3 = r5.getKey();
        if (r3.getType() != ThemeColor.KeyType.STATIC_WHITE) goto L19;
        int r8 = c(r6, "static_white", r7);
        if (r8 != 0) goto L36;
        Integer r9 = r5.getValue();
        if (r9 == null) goto L37;
        r2 = r9.intValue();
    L37:
        return b(r2);
    L36:
        return UDColorUtils.getAlphaColor(r6, r8, r3.getAlpha() / 100.0f);
    L19:
        StringBuilder r4 = new StringBuilder("ud_");
        ThemeColor.KeyType r10 = r3.getType();
        if (r10 == null) goto L22;
        String r11 = r10.name();
    L23:
        r4.append(r11);
        r4.append(r3.getValue());
        int r12 = c(r6, r4.toString(), r7);
        if (r12 != 0) goto L38;
        Integer r13 = r5.getValue();
        if (r13 == null) goto L30;
        r2 = r13.intValue();
    L30:
        return b(r2);
    L38:
        return UDColorUtils.getAlphaColor(r6, r12, r3.getAlpha() / 100.0f);
    L22:
        r11 = null;
        goto L23
    L31:
        Integer r14 = r5.getValue();
        if (r14 == null) goto L35;
        r2 = r14.intValue();
    L35:
        return b(r2);
    }

    public static int c(Context r0, String r1, ycb.a r2) {
        if (r2 == null) goto L6;
        Integer r3 = r2.a(r1);
        if (r3 == null) goto L6;
        int r4 = r3.intValue();
    L7:
        if (r4 <= 0) goto L10;
        return r4;
    L10:
        return UDColorUtils.getColorIdByToken(r0, r1);
    L6:
        r4 = 0;
        goto L7
    }
}
