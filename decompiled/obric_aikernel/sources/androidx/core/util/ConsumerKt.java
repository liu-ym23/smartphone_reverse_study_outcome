package androidx.core.util;

import androidx.annotation.RequiresApi;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(24)
public final class ConsumerKt {
    @RequiresApi(24)
    public static final <T> java.util.function.Consumer<T> asConsumer(Continuation<? super T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new ContinuationConsumer(r10);
    }
}
