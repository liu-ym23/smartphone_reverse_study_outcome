package com.larus.bmhome.block.holder.content.lynx;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.Message;
import com.larus.uaigc.service.IZLotteryService;
import kc8.h0;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.block.holder.content.lynx.SpringLynxBlockHolder$delayReportPocketMessageCardShowTimeout$1", f = "SpringLynxBlockHolder.kt", i = {}, l = {403}, m = "invokeSuspend", n = {}, s = {})
final class SpringLynxBlockHolder$delayReportPocketMessageCardShowTimeout$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SpringLynxBlockHolder this$0;

    public SpringLynxBlockHolder$delayReportPocketMessageCardShowTimeout$1(SpringLynxBlockHolder r1, Continuation<? super SpringLynxBlockHolder$delayReportPocketMessageCardShowTimeout$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new SpringLynxBlockHolder$delayReportPocketMessageCardShowTimeout$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
    L11:
        IZLotteryService.Companion r2 = IZLotteryService.a;
        fb8.k r13 = this.this$0.m;
        Message r3 = null;
        if (r13 == null) goto L14;
        String r14 = r13.j().getMessageId();
    L15:
        if (r14 != null) goto L17;
        r14 = "";
    L17:
        String r4 = r14;
        long r5 = System.currentTimeMillis();
        SpringLynxBlockHolder r15 = this.this$0;
        long r6 = r5 - r15.q;
        kc8.b r9 = r15.u;
        if (r9 == null) goto L27;
        h0 r10 = r9.q;
        if (r10 == null) goto L27;
        Function1<Message, Boolean> r11 = r10.b;
        if (r11 == null) goto L27;
        fb8.k r16 = r15.m;
        if (r16 == null) goto L26;
        r3 = r16.j();
    L26:
        Boolean r17 = (Boolean) r11.invoke(r3);
    L28:
        IZLotteryService.a.a(r2, r4, false, r6, "1", 202, null, r17, 32);
        return Unit.INSTANCE;
    L27:
        r17 = null;
        goto L28
    L14:
        r14 = null;
        goto L15
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        this.label = 1;
        if (DelayKt.delay(30000, this) != r0) goto L11;
        return r0;
    }
}
