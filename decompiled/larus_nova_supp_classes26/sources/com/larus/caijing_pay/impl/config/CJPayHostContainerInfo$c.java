package com.larus.caijing_pay.impl.config;

import com.bytedance.ies.bullet.service.base.PoolResult;
import com.bytedance.ies.bullet.service.base.y;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class CJPayHostContainerInfo$c implements y {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[PoolResult.values().length];
            r0[PoolResult.SUCCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[PoolResult.FAIL_EXISTS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[PoolResult.FAIL_LOAD_ERROR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[PoolResult.FAIL_INVALID.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[PoolResult.FAIL_EXCEPTION.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    public CJPayHostContainerInfo$c() {
    }

    public final void onSuccess(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sessionId");
        throw null;
    }

    public final void a(PoolResult r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "result");
        int r3 = a.a[r1.ordinal()];
        if (r3 == 1) goto L15;
        if (r3 == 2) goto L15;
        if (r3 == 3) goto L15;
        if (r3 == 4) goto L15;
        if (r3 == 5) goto L15;
        throw new NoWhenBranchMatchedException();
    L15:
        throw null;
    }
}
