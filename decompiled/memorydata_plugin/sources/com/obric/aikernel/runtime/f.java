package com.obric.aikernel.runtime;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0002\u0010\u0005\u001a\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0001H\u0000¨\u0006\b"}, d2 = {"resolveAdditionalQuotaCompensationRuns", "", "executionStarted", "", "engineRunCount", "(ZLjava/lang/Integer;)I", "shouldStartVmExecution", "quotaDecision", "infer_runtime_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class f {
    public static final int a(boolean r1, Integer r2) {
        if (r1 == true) goto L5;
        return 0;
    L5:
        if (r2 == null) goto L7;
        int r3 = r2.intValue();
    L9:
        if (r3 > 1) goto L11;
        return 0;
    L11:
        return r3 - 1;
    L7:
        r3 = 0;
        goto L9
    }

    public static final boolean a(int r1) {
        if (r1 >= 4) goto L5;
        return true;
    L5:
        return false;
    }
}
