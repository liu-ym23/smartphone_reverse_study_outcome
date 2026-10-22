package com.larus.suggest.impl.wcb.request;

import com.larus.bmhome.chat.bean.NexPulseResponseData;
import com.larus.platform.service.AccountService;
import com.larus.suggest.impl.wcb.policy.z;
import com.tencent.open.log.TraceLevel;
import ic8.k0;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "Lcom/larus/bmhome/chat/bean/NexPulseResponseData;", "Lcom/larus/suggest/impl/repo/NexPulseRepo$ErrorInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.suggest.impl.wcb.request.WcbNetworkRequester$fetch$2", f = "WcbNetworkRequester.kt", i = {}, l = {85}, m = "invokeSuspend", n = {}, s = {})
final class WcbNetworkRequester$fetch$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends NexPulseResponseData, ? extends com.larus.suggest.impl.repo.a.C0035a>>, Object> {
    final /* synthetic */ z $policy;
    final /* synthetic */ f $snapshot;
    int label;

    public WcbNetworkRequester$fetch$2(f r1, z r2, Continuation<? super WcbNetworkRequester$fetch$2> r3) {
        this.$snapshot = r1;
        this.$policy = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new WcbNetworkRequester$fetch$2(this.$snapshot, this.$policy, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Pair<NexPulseResponseData, com.larus.suggest.impl.repo.a.C0035a>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
    L13:
        return r13;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        if (Intrinsics.areEqual(this.$snapshot.a, AccountService.a.getUserId()) == false) goto L15;
        com.larus.suggest.impl.repo.a r3 = com.larus.suggest.impl.repo.a.a;
        f r14 = this.$snapshot;
        String r4 = r14.c;
        String r5 = r14.b;
        c r15 = r14.f;
        int r6 = r15.f;
        k0 r8 = r15.c;
        String r7 = this.$policy.h().b(this.$snapshot);
        String r9 = this.$snapshot.f.d;
        boolean r10 = this.$policy.c().a(this.$snapshot);
        this.label = 1;
        r13 = r3.a(r4, r5, r6, r7, r8, r9, r10, this);
        if (r13 != r0) goto L13;
        return r0;
    L15:
        throw new CancellationException("wcb request account changed before dispatch");
    }
}
