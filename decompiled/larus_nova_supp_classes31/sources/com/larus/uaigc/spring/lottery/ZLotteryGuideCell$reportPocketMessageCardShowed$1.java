package com.larus.uaigc.spring.lottery;

import com.larus.im.bean.message.Message;
import com.larus.uaigc.service.IZLotteryService;
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
@DebugMetadata(c = "com.larus.uaigc.spring.lottery.ZLotteryGuideCell$reportPocketMessageCardShowed$1", f = "ZLotteryGuideCell.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ZLotteryGuideCell$reportPocketMessageCardShowed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $errorCode;
    final /* synthetic */ String $errorMsg;
    final /* synthetic */ boolean $lynxViewLoadSuccess;
    int label;
    final /* synthetic */ ZLotteryGuideCell this$0;

    public ZLotteryGuideCell$reportPocketMessageCardShowed$1(ZLotteryGuideCell r1, boolean r2, int r3, String r4, Continuation<? super ZLotteryGuideCell$reportPocketMessageCardShowed$1> r5) {
        this.this$0 = r1;
        this.$lynxViewLoadSuccess = r2;
        this.$errorCode = r3;
        this.$errorMsg = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ZLotteryGuideCell$reportPocketMessageCardShowed$1(this.this$0, this.$lynxViewLoadSuccess, this.$errorCode, this.$errorMsg, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r12);
        IZLotteryService.Companion r1 = IZLotteryService.a;
        Message r13 = this.this$0.i;
        if (r13 == null) goto L7;
        String r14 = r13.getLocalMessageId();
    L8:
        if (r14 != null) goto L10;
        r14 = "";
    L10:
        IZLotteryService.a.a(r1, r14, this.$lynxViewLoadSuccess, System.currentTimeMillis() - this.this$0.k, "2", this.$errorCode, this.$errorMsg, null, 64);
        return Unit.INSTANCE;
    L7:
        r14 = null;
        goto L8
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
