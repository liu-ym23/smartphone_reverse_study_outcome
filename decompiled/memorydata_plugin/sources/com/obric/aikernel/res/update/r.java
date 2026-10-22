package com.obric.aikernel.res.update;

import android.os.SystemClock;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\t\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0000¨\u0006\u0002"}, d2 = {"currentElapsedRealtime", "", "resource_manager_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class r {
    public static final long a() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.m1421constructorimpl(Long.valueOf(SystemClock.elapsedRealtime()));     // Catch: Throwable -> L4
    L7:
        if (Result.m1424exceptionOrNullimpl(r1) == null) goto L11;
        r1 = Long.valueOf(System.currentTimeMillis());
    L11:
        return ((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin")).longValue();
    L4:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r1 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
