package com.ss.android.lark.movable.utils;

import android.content.Context;
import android.content.res.Resources;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public static final com.ss.android.lark.movable.attatchment.b a(com.ss.android.lark.movable.attatchment.b r9, Context r10) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        Intrinsics.checkNotNullParameter(r10, "context");
        float r4 = d(r9.c, r10);
        float r5 = d(r9.d, r10);
        float r6 = d(r9.e, r10);
        float r7 = d(r9.f, r10);
        int r2 = r9.a;
        int r3 = r9.b;
        Map<String, String> r8 = r9.g;
        Intrinsics.checkNotNullParameter(r8, "property");
        return new com.ss.android.lark.movable.attatchment.b(r2, r3, r4, r5, r6, r7, r8);
    }

    public static final com.ss.android.lark.movable.attatchment.g b(com.ss.android.lark.movable.attatchment.g r1, Context r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "context");
        return new com.ss.android.lark.movable.attatchment.g(d(r1.b(), r2), d(r1.a(), r2));
    }

    public static final jsb.a c(jsb.a r9, Context r10) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        Intrinsics.checkNotNullParameter(r10, "context");
        float r3 = d(r9.b, r10);
        float r4 = d(r9.c, r10);
        float r5 = d(r9.d, r10);
        float r6 = d(r9.e, r10);
        float r7 = d(r9.f, r10);
        float r8 = d(r9.g, r10);
        return new jsb.a(r9.a, r3, r4, r5, r6, r7, r8);
    }

    public static final float d(float r1, Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Resources r3 = r2.getResources();
        return r1 * WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).density;
    }

    public static final int e(int r1, Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Resources r3 = r2.getResources();
        return (int) ((r1 * WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).density) + 0.5f);
    }

    public static final float f(float r1, Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Resources r3 = r2.getResources();
        return r1 / WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).density;
    }

    public static final int g(int r1, Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Resources r3 = r2.getResources();
        return (int) ((r1 / WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).density) + 0.5f);
    }
}
