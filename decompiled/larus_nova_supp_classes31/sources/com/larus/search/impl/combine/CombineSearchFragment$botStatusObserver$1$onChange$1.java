package com.larus.search.impl.combine;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.search.impl.combine.CombineSearchFragment$botStatusObserver$1$onChange$1", f = "CombineSearchFragment.kt", i = {}, l = {1321, 1322}, m = "invokeSuspend", n = {}, s = {})
final class CombineSearchFragment$botStatusObserver$1$onChange$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ wc9.e $newConversation;
    int label;
    final /* synthetic */ CombineSearchFragment this$0;

    public CombineSearchFragment$botStatusObserver$1$onChange$1(CombineSearchFragment r1, wc9.e r2, Continuation<? super CombineSearchFragment$botStatusObserver$1$onChange$1> r3) {
        this.this$0 = r1;
        this.$newConversation = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CombineSearchFragment$botStatusObserver$1$onChange$1(this.this$0, this.$newConversation, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r5);
    L17:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r5);
    L13:
        CombineSearchFragment r6 = this.this$0;
        wc9.e r2 = this.$newConversation;
        this.label = 2;
        if (CombineSearchFragment.W90(r6, false, r2, this) != r0) goto L17;
        return r0;
    L10:
        ResultKt.throwOnFailure(r5);
        CombineSearchFragment r7 = this.this$0;
        wc9.e r3 = this.$newConversation;
        this.label = 1;
        if (CombineSearchFragment.W90(r7, true, r3, this) != r0) goto L13;
        return r0;
    }
}
