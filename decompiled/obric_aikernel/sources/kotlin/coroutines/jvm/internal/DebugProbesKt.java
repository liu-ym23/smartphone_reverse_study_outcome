package kotlin.coroutines.jvm.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.SinceKotlin;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Classes with same name are omitted, all sources:
  classes2.dex
  com.obric.aikernel.apk:DebugProbesKt.bin
 */
/* JADX INFO: loaded from: classes2.dex */
public final class DebugProbesKt {
    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    public static final <T> Continuation<T> probeCoroutineCreated(Continuation<? super T> r10) {
        Intrinsics.checkNotNullParameter(r10, "completion");
        return r10;
    }

    @SinceKotlin(version = "1.3")
    public static final void probeCoroutineResumed(Continuation<?> r10) {
        Intrinsics.checkNotNullParameter(r10, TypedValues.AttributesType.S_FRAME);
    }

    @SinceKotlin(version = "1.3")
    public static final void probeCoroutineSuspended(Continuation<?> r10) {
        Intrinsics.checkNotNullParameter(r10, TypedValues.AttributesType.S_FRAME);
    }
}
