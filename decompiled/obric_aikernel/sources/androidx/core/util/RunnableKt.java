package androidx.core.util;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class RunnableKt {
    public static final Runnable asRunnable(Continuation<? super Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new ContinuationRunnable(r10);
    }
}
