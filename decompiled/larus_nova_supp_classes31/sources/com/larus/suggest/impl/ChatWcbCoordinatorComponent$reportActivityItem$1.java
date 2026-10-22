package com.larus.suggest.impl;

import com.larus.suggest.impl.popup.model.PopWindowRepo;
import com.larus.suggest.impl.popup.model.b;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.suggest.impl.ChatWcbCoordinatorComponent$reportActivityItem$1", f = "ChatWcbCoordinatorComponent.kt", i = {}, l = {334}, m = "invokeSuspend", n = {}, s = {})
public final class ChatWcbCoordinatorComponent$reportActivityItem$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $activityId;
    final /* synthetic */ int $activityScene;
    final /* synthetic */ long $expireTime;
    final /* synthetic */ String $itemId;
    int label;

    public ChatWcbCoordinatorComponent$reportActivityItem$1(String r1, String r2, int r3, long r4, Continuation<? super ChatWcbCoordinatorComponent$reportActivityItem$1> r6) {
        this.$activityId = r1;
        this.$itemId = r2;
        this.$activityScene = r3;
        this.$expireTime = r4;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new ChatWcbCoordinatorComponent$reportActivityItem$1(this.$activityId, this.$itemId, this.$activityScene, this.$expireTime, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r9);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        PopWindowRepo r10 = PopWindowRepo.a;
        b r2 = new b(this.$activityId, this.$itemId, Boxing.boxInt(this.$activityScene), Boxing.boxLong(this.$expireTime));
        this.label = 1;
        if (r10.b(r2, this) != r0) goto L12;
        return r0;
    }
}
