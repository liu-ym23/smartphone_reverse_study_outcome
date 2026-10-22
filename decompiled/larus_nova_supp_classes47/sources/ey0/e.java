package ey0;

import com.bytedance.live.datacontext.j;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e {
    public static final Object a(j r3, ContinuationImpl r4) {
        Object r0 = r3.getValue();
        if (r3.hasValue() == true) goto L8;
        SafeContinuation r1 = new SafeContinuation(IntrinsicsKt.intercepted(r4));
        r3.b().subscribe(new c(r1, r3));
        r0 = r1.getOrThrow();
        if (r0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        DebugProbesKt.probeCoroutineSuspended(r4);
    L8:
        return r0;
    }
}
