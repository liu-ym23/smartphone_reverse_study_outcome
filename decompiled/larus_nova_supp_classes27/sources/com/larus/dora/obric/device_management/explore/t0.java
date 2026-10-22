package com.larus.dora.obric.device_management.explore;

import android.content.Context;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class t0 {
    public static final t0 a = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DoraObricGlassesImagePageType.values().length];
            r0[DoraObricGlassesImagePageType.EXPLORE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[DoraObricGlassesImagePageType.DETAIL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[DoraObricGlassesImagePageType.BASIC_DETAIL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
        a = new t0();
    }

    public t0() {
    }

    public static Object a(Context r2, d1 r3) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r4 = Result.constructor-impl(r2.getString(r3.a));     // Catch: Throwable -> L4
    L7:
        if (Result.exceptionOrNull-impl(r4) == null) goto L10;
        g49.d.e("DoraObricGlassesExploreResourceProvider", "resolve local string failed: resId=" + r3.a);
    L10:
        if (Result.isFailure-impl(r4) == false) goto L15;
        return "";
    L15:
        return r4;
    L4:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }
}
