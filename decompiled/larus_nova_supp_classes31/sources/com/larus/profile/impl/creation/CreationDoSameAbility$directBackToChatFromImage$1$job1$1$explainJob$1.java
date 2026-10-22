package com.larus.profile.impl.creation;

import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/http/Async;", "Lcom/larus/uaigc/api/ResourceUrlsExplainResults;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.profile.impl.creation.CreationDoSameAbility$directBackToChatFromImage$1$job1$1$explainJob$1", f = "CreationDoSameAbility.kt", i = {}, l = {2210}, m = "invokeSuspend", n = {}, s = {})
public final class CreationDoSameAbility$directBackToChatFromImage$1$job1$1$explainJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.larus.network.http.a<? extends com.larus.uaigc.api.s>>, Object> {
    final /* synthetic */ String $url;
    int label;

    public CreationDoSameAbility$directBackToChatFromImage$1$job1$1$explainJob$1(String r1, Continuation<? super CreationDoSameAbility$directBackToChatFromImage$1$job1$1$explainJob$1> r2) {
        this.$url = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CreationDoSameAbility$directBackToChatFromImage$1$job1$1$explainJob$1(this.$url, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super com.larus.network.http.a<com.larus.uaigc.api.s>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        return r4;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        List r5 = CollectionsKt.listOf(this.$url);
        this.label = 1;
        r4 = com.larus.uaigc.api.o.a(r5, true, this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
