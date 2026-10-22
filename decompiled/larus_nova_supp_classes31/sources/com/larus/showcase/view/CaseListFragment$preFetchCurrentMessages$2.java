package com.larus.showcase.view;

import com.larus.showcase.api.ICaseService;
import com.tencent.open.log.TraceLevel;
import java.util.List;
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
@DebugMetadata(c = "com.larus.showcase.view.CaseListFragment$preFetchCurrentMessages$2", f = "CaseListFragment.kt", i = {}, l = {217}, m = "invokeSuspend", n = {}, s = {})
final class CaseListFragment$preFetchCurrentMessages$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<String> $idList;
    int label;
    final /* synthetic */ CaseListFragment this$0;

    public CaseListFragment$preFetchCurrentMessages$2(List<String> r1, CaseListFragment r2, Continuation<? super CaseListFragment$preFetchCurrentMessages$2> r3) {
        this.$idList = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CaseListFragment$preFetchCurrentMessages$2(this.$idList, this.this$0, r4);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        ICaseService.Companion r6 = ICaseService.a;
        List<String> r2 = this.$idList;
        this.this$0.getClass();
        this.label = 1;
        if (r6.h(r2, this) != r0) goto L12;
        return r0;
    }
}
