package com.obric.aikernel.res.metadata.config;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static final Boolean a(k r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, ActivityLifecycle.NAME);
        if (r10.w(r11) == true) goto L7;
        return null;
    L7:
        return Boolean.valueOf(r10.s(r11).a());
    }

    public static final Integer b(k r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, ActivityLifecycle.NAME);
        if (r10.w(r11) == true) goto L7;
        return null;
    L7:
        return Integer.valueOf(r10.s(r11).c());
    }

    public static final String c(k r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, ActivityLifecycle.NAME);
        String r12 = r10.s(r11).h();
        Intrinsics.checkNotNullExpressionValue(r12, "get(name).asString");
        return r12;
    }

    public static final String d(k r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, ActivityLifecycle.NAME);
        if (r10.w(r11) == true) goto L7;
        return null;
    L7:
        return r10.s(r11).h();
    }
}
