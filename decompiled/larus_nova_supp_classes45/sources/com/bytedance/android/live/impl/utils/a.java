package com.bytedance.android.live.impl.utils;

import com.bytedance.common.utility.Logger;
import j40.c0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public static final boolean a = false;
    public static final String b = null;
    public static final String c = null;

    public a() {
    }

    static {
        a = c0.a.getValue().getLogEnable();
        b = "LFM-Feature";
        c = "LFM-";
    }

    public static void a(String r4, Function0 r5) {
        Intrinsics.checkNotNullParameter(r5, "msg");
        if (a == false) goto L12;
        if (r4 != null) goto L6;
        r4 = b;
    L10:
        Logger.d(r4, (String) r5.invoke());
        return;
    L6:
        String r0 = c;
        if (StringsKt.startsWith$default(r4, r0, false, 2, null) == true) goto L10;
        r4 = r0 + r4;
        goto L10
    }

    public static void c(String r4, Function0 r5) {
        Intrinsics.checkNotNullParameter(r5, "msg");
        if (a == false) goto L10;
        String r0 = c;
        if (StringsKt.startsWith$default(r4, r0, false, 2, null) == true) goto L8;
        r4 = r0 + r4;
    L8:
        Logger.i(r4, (String) r5.invoke());
        return;
    }

    public static void d(String r4, Function0 r5) {
        Intrinsics.checkNotNullParameter(r5, "msg");
        if (a == false) goto L12;
        if (r4 != null) goto L6;
        r4 = b;
    L10:
        Logger.w(r4, (String) r5.invoke());
        return;
    L6:
        String r0 = c;
        if (StringsKt.startsWith$default(r4, r0, false, 2, null) == true) goto L10;
        r4 = r0 + r4;
        goto L10
    }

    public static void b(String r4, Function0 r5, Throwable r6) {
        Intrinsics.checkNotNullParameter(r5, "msg");
        if (a == false) goto L12;
        if (r4 != null) goto L6;
        r4 = b;
    L10:
        Logger.e(r4, (String) r5.invoke(), r6);
        return;
    L6:
        String r0 = c;
        if (StringsKt.startsWith$default(r4, r0, false, 2, null) == true) goto L10;
        r4 = r0 + r4;
        goto L10
    }
}
