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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.block.holder.content.lynx.SpringLynxBlockHolder$reportPocketMessageCardShowed$1", f = "SpringLynxBlockHolder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SpringLynxBlockHolder$reportPocketMessageCardShowed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $errorCode;
    final /* synthetic */ String $errorMsg;
    final /* synthetic */ boolean $lynxViewLoadSuccess;
    int label;
    final /* synthetic */ SpringLynxBlockHolder this$0;

    public SpringLynxBlockHolder$reportPocketMessageCardShowed$1(SpringLynxBlockHolder r1, boolean r2, int r3, String r4, Continuation<? super SpringLynxBlockHolder$reportPocketMessageCardShowed$1> r5) {
        this.this$0 = r1;
        this.$lynxViewLoadSuccess = r2;
        this.$errorCode = r3;
        this.$errorMsg = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new SpringLynxBlockHolder$reportPocketMessageCardShowed$1(this.this$0, this.$lynxViewLoadSuccess, this.$errorCode, this.$errorMsg, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L24;
        ResultKt.throwOnFailure(r11);
        IZLotteryService.Companion r1 = IZLotteryService.a;
        fb8.k r12 = this.this$0.m;
        Message r0 = null;
        if (r12 == null) goto L7;
        String r13 = r12.j().getMessageId();
    L8:
        if (r13 != null) goto L10;
        r13 = "";
    L10:
        String r2 = r13;
        boolean r3 = this.$lynxViewLoadSuccess;
        long r4 = System.currentTimeMillis();
        SpringLynxBlockHolder r14 = this.this$0;
        long r5 = r4 - r14.q;
        int r7 = this.$errorCode;
        String r8 = this.$errorMsg;
        kc8.b r9 = r14.u;
        if (r9 == null) goto L20;
        h0 r10 = r9.q;
        if (r10 == null) goto L20;
        Function1<Message, Boolean> r15 = r10.b;
        if (r15 == null) goto L20;
        fb8.k r16 = r14.m;
        if (r16 == null) goto L19;
        r0 = r16.j();
    L19:
        Boolean r17 = (Boolean) r15.invoke(r0);
    L21:
        r1.i(r2, r3, r5, "1", r7, r8, r17);
        return Unit.INSTANCE;
    L20:
        r17 = null;
        goto L21
    L7:
        r13 = null;
        goto L8
    L24:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
