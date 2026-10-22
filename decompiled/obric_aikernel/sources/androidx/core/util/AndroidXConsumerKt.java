package androidx.core.util;

import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidXConsumerKt {
    public static final <T> Consumer<T> asAndroidXConsumer(Continuation<? super T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new AndroidXContinuationConsumer(r10);
    }
}
