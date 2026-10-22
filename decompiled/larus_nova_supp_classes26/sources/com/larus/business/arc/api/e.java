package com.larus.business.arc.api;

import kotlin.NoWhenBranchMatchedException;
import kotlin.time.TimeSource;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e {
    public static final long a = 0;
    public static final d b = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ArcStage.values().length];
            r0[ArcStage.PREPARE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ArcStage.EXECUTE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ArcStage.FINALIZE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.business.arc.api.d] */
    static {
        a = TimeSource.Monotonic.INSTANCE.markNow-z9LOYto();
        b = new d();
    }

    public static final ArcFrameworkFailure a(ArcStage r1) {
        int r2 = a.a[r1.ordinal()];
        if (r2 == 1) goto L13;
        if (r2 == 2) goto L15;
        if (r2 != 3) goto L10;
        return ArcFrameworkFailure.FINALIZE_INTERNAL_ERROR;
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return ArcFrameworkFailure.EXECUTE_INTERNAL_ERROR;
    L13:
        return ArcFrameworkFailure.PREPARE_INTERNAL_ERROR;
    }
}
