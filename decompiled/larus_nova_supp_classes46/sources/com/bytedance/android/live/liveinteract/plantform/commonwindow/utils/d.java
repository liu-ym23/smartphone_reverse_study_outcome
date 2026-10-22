package com.bytedance.android.live.liveinteract.plantform.commonwindow.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d {
    public static final String a(ti6.f r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$toRegionString");
        return "Region(x=" + r3.d + ", y=" + r3.e + ", width=" + r3.f + ", height=" + r3.g + ')';
    }

    public static final h b(pn0.f.a r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$toStreamRect");
        return new h(r10.a, r10.b, r10.c, r10.d);
    }

    public static final h c(pn0.f.b r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$toStreamRect");
        return new h(r10.a, r10.b, r10.c, r10.d);
    }
}
