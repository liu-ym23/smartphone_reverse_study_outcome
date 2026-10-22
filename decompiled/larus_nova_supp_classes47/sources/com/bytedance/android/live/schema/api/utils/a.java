package com.bytedance.android.live.schema.api.utils;

import com.bytedance.badger.collect.impl.constants.Constants;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import om0.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    static {
    }

    public static String e(String r2) {
        if (r2 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L11;
        return "WebcastRedirect";
    L11:
        return "WebcastRedirect_" + r2;
    L4:
        if (r2.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    @JvmStatic
    public static final void a(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, Constants.OperatorKey.MSG);
        pm0.a r0 = c.c();
        if (r0 == null) goto L6;
        r0.d(e(r1), r2);
        return;
    }

    @JvmStatic
    public static final void c(String r1, Throwable r2) {
        pm0.a r0 = c.c();
        if (r0 == null) goto L9;
        String r3 = e(r1);
        if (r2 != null) goto L7;
        r2 = new Exception();
    L7:
        r0.e(r3, r2);
        return;
    }

    @JvmStatic
    public static final void d(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, Constants.OperatorKey.MSG);
        pm0.a r0 = c.c();
        if (r0 == null) goto L6;
        r0.i(e(r1), r2);
        return;
    }

    @JvmStatic
    public static final void b(String r1, String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r2, Constants.OperatorKey.MSG);
        pm0.a r0 = c.c();
        if (r0 == null) goto L9;
        String r4 = e(r1);
        if (r3 != null) goto L7;
        r3 = new Exception();
    L7:
        r0.e(r4, r2, r3);
        return;
    }
}
