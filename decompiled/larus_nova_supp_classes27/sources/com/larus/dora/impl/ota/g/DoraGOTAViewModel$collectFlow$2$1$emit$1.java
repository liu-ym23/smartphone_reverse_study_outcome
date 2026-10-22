package com.larus.dora.impl.ota.g;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.ota.g.DoraGOTAViewModel$collectFlow$2$1", f = "DoraGOTAViewModel.kt", i = {7, 7, 16, 16, 17, 17}, l = {306, 310, 314, 320, 326, 338, 348, 352, 358, 363, 368, 379, 388, 395, 406, 413, 418, 424, 432}, m = "emit", n = {"otaState", "previousState", "otaState", "previousState", "otaState", "previousState"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
public final class DoraGOTAViewModel$collectFlow$2$1$emit$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraGOTAViewModel.C04322.AnonymousClass1<T> this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public DoraGOTAViewModel$collectFlow$2$1$emit$1(DoraGOTAViewModel.C04322.AnonymousClass1<? super T> r1, Continuation<? super DoraGOTAViewModel$collectFlow$2$1$emit$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, (Continuation<? super Unit>) this);
    }
}
