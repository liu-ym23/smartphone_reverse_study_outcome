package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public abstract class h0 {
    public static final kotlinx.coroutines.internal.c a(CoroutineContext r5) {
        if (r5.get(Job.Key) != null) goto L7;
        r5 = r5.plus(new l1(null));
    L7:
        return new kotlinx.coroutines.internal.c(r5);
    }

    public static final kotlinx.coroutines.internal.c b() {
        return new kotlinx.coroutines.internal.c(CoroutineContext.Element.DefaultImpls.plus(j0.b(), Dispatchers.getMain()));
    }

    public static final void c(CoroutineScope r5, CancellationException r10) {
        Job r11 = (Job) r5.getCoroutineContext().get(Job.Key);
        if (r11 == null) goto L7;
        r11.cancel(r10);
        return;
    L7:
        throw new IllegalStateException(("Scope cannot be cancelled because it does not have a job: " + r5).toString());
    }

    public static final Object d(Function2 r5, Continuation r10) {
        kotlinx.coroutines.internal.r r11 = new kotlinx.coroutines.internal.r(r10, r10.getContext());
        Object r12 = com.lynx.tasm.utils.a.z(r11, r11, r5);
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r10);
    L5:
        return r12;
    }
}
