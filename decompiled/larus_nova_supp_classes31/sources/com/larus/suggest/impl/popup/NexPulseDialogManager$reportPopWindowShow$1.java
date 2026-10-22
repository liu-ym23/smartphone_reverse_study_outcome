package com.larus.suggest.impl.popup;

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
@DebugMetadata(c = "com.larus.suggest.impl.popup.NexPulseDialogManager$reportPopWindowShow$1", f = "NexPulseDialogManager.kt", i = {}, l = {200}, m = "invokeSuspend", n = {}, s = {})
final class NexPulseDialogManager$reportPopWindowShow$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $activityId;
    final /* synthetic */ Long $expireTime;
    final /* synthetic */ String $groupId;
    int label;

    public NexPulseDialogManager$reportPopWindowShow$1(String r1, String r2, Long r3, Continuation<? super NexPulseDialogManager$reportPopWindowShow$1> r4) {
        this.$activityId = r1;
        this.$groupId = r2;
        this.$expireTime = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new NexPulseDialogManager$reportPopWindowShow$1(this.$activityId, this.$groupId, this.$expireTime, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        b r8 = new b(this.$activityId, this.$groupId, Boxing.boxInt(3), this.$expireTime);
        PopWindowRepo r2 = PopWindowRepo.a;
        this.label = 1;
        if (r2.b(r8, this) != r0) goto L12;
        return r0;
    }
}
