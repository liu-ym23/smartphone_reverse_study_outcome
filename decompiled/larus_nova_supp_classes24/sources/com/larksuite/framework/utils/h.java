package com.larksuite.framework.utils;

import android.os.Build;
import com.ss.android.lark.log.Log;
import java.util.Locale;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class h {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(String r3, String r4) {
        if (r3 == null) goto L10;
        String r5 = r3.toLowerCase(Locale.ROOT);
        if (r5 != null) goto L7;
        return false;
    L7:
        if (StringsKt.contains$default(r5, r4, false, 2, null) != true) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    @JvmStatic
    public static final boolean b(String r4, boolean r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r4, "reason");
        if (r5 == false) goto L5;
    L36:
        boolean r7 = false;
    L37:
        if (r7 == false) goto L40;
        Log.e("ExplicitGcGuard", "skip explicit gc for OPPO-family Android 15, reason=".concat(r4));
        return false;
    L40:
        System.gc();
        if (r6 == false) goto L43;
        System.runFinalization();
    L43:
        return true;
    L5:
        if (Build.VERSION.SDK_INT >= 35) goto L8;
    L32:
        boolean r8 = false;
    L34:
        if (r8 == false) goto L36;
        r7 = true;
        goto L37
    L8:
        if (RomUtils.d[0].equals(RomUtils.e().a) == false) goto L10;
    L33:
        r8 = true;
        goto L34
    L10:
        if (RomUtils.h[0].equals(RomUtils.e().a) == true) goto L33;
        String r9 = Build.BRAND;
        if (a(r9, "realme") == false) goto L14;
    L17:
        boolean r2 = true;
    L18:
        if (r2 == true) goto L33;
        if (a(r9, "oppo") == false) goto L22;
    L29:
        boolean r10 = true;
    L30:
        if (r10 == false) goto L32;
    L22:
        if (a(r9, "oneplus") == true) goto L29;
        String r11 = Build.MANUFACTURER;
        if (a(r11, "oppo") == true) goto L29;
        if (a(r11, "oneplus") == true) goto L29;
        r10 = false;
        goto L30
    L14:
        if (a(Build.MANUFACTURER, "realme") == true) goto L17;
        r2 = false;
        goto L18
    }
}
