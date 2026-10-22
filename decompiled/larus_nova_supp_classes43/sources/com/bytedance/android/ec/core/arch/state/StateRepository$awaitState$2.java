package com.bytedance.android.ec.core.arch.state;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;

/* JADX INFO: Add missing generic type declarations: [S] */
/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u0000¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/bytedance/android/ec/core/arch/state/b;", "S", "p1", "", "invoke", "(Lcom/bytedance/android/ec/core/arch/state/b;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class StateRepository$awaitState$2<S> extends FunctionReferenceImpl implements Function1<S, Boolean> {
    public StateRepository$awaitState$2(CompletableDeferred r10) {
        super(1, r10, CompletableDeferred.class, "complete", "complete(Ljava/lang/Object;)Z", 0);
    }

    /* JADX WARN: Incorrect types in method signature: (TS;)Z */
    public final boolean invoke(b r10) {
        Intrinsics.checkNotNullParameter(r10, "p1");
        return ((CompletableDeferred) ((CallableReference) this).receiver).complete(r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return Boolean.valueOf(invoke((b) r1));
    }
}
