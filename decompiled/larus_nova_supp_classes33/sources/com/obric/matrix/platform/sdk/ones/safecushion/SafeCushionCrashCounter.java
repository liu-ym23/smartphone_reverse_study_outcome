package com.obric.matrix.platform.sdk.ones.safecushion;

import hka.b;
import hka.c;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class SafeCushionCrashCounter {
    public static final Lazy a = null;
    public static final Lazy b = null;

    static {
        new b();
        Lazy r0 = LazyKt.lazy(SafeCushionCrashCounter$isMainProcess$2.INSTANCE);
        a = r0;
        Lazy r1 = LazyKt.lazy(SafeCushionCrashCounter$isSafeProcess$2.INSTANCE);
        b = r1;
        if (((Boolean) r0.getValue()).booleanValue() == false) goto L12;
        Intrinsics.checkNotNullParameter("supposeCrash", "crashFileNamePrefix");
        c.b("supposeCrash");
        Intrinsics.checkNotNullParameter("crashInfo", "crashFileNamePrefix");
        c.b("crashInfo");
        if (((Boolean) r0.getValue()).booleanValue() == false) goto L12;
        if (((Boolean) r0.getValue()).booleanValue() == false) goto L12;
        int r2 = a.a;
        a.C0040a.a();
        throw null;
    L12:
        if (((Boolean) r1.getValue()).booleanValue() == false) goto L15;
        int r3 = c.a;
        Intrinsics.checkNotNullParameter("safeModeFlag", "fileNamePrefix");
        c.b("safeModeFlag");
        b.a("repair");
        return;
    }
}
