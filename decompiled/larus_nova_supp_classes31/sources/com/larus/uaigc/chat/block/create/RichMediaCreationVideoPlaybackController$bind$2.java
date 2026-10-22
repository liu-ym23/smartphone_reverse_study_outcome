package com.larus.uaigc.chat.block.create;

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
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.block.create.RichMediaCreationVideoPlaybackController$bind$2", f = "RichMediaCreationClickServiceImpl.kt", i = {}, l = {872, 873}, m = "invokeSuspend", n = {}, s = {})
final class RichMediaCreationVideoPlaybackController$bind$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ RichMediaCreationVideoPlaybackController this$0;

    public RichMediaCreationVideoPlaybackController$bind$2(RichMediaCreationVideoPlaybackController r1, Continuation<? super RichMediaCreationVideoPlaybackController$bind$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new RichMediaCreationVideoPlaybackController$bind$2(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r6);
    L19:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r6);
    L13:
        kh8.a r7 = this.this$0.c();
        if (r7 == null) goto L19;
        this.label = 2;
        if (r7.f(this) != r0) goto L19;
        return r0;
    L10:
        ResultKt.throwOnFailure(r6);
        this.label = 1;
        if (DelayKt.delay(100, this) != r0) goto L13;
        return r0;
    }
}
