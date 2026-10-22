package com.larus.bmhome.chat.component.bottom.core;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.bot.BotModel;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.core.CoreInputComponent$trackOnActionBarShow$1", f = "CoreInputComponent.kt", i = {}, l = {4260}, m = "invokeSuspend", n = {}, s = {})
final class CoreInputComponent$trackOnActionBarShow$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CoreInputComponent this$0;

    public CoreInputComponent$trackOnActionBarShow$1(CoreInputComponent r1, Continuation<? super CoreInputComponent$trackOnActionBarShow$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CoreInputComponent$trackOnActionBarShow$1(this.this$0, r3);
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
        com.larus.bmhome.actionbar.model.z0 r2 = null;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L27:
        CoreInputComponent r8 = this.this$0;
        int r3 = CoreInputComponent.d3;
        com.larus.bmhome.instruction.g r9 = r8.vc();
        if (r9 == null) goto L32;
        List r10 = r9.tq();
        if (r10 == null) goto L32;
        r2 = (com.larus.bmhome.actionbar.model.z0) CollectionsKt.firstOrNull(r10);
    L32:
        this.this$0.F4().trackOnceOnActionBarShow(this.this$0.k4().q(), this.this$0.k4().h(), r2);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        CoreInputComponent r11 = this.this$0;
        int r4 = CoreInputComponent.d3;
        String r12 = r11.k4().getBotId();
        CoreInputComponent r5 = this.this$0;
        boolean r6 = false;
        if (r12.length() != 0) goto L11;
        boolean r13 = true;
    L12:
        if (r13 == false) goto L17;
        BotModel r14 = r5.k4().q();
        if (r14 == null) goto L16;
        r12 = r14.getBotId();
        goto L17
    L16:
        r12 = null;
    L17:
        if (r12 != null) goto L19;
    L20:
        r6 = true;
    L21:
        if (r6 == true) goto L23;
        this.label = 1;
        if (DelayKt.delay(500, this) != r0) goto L27;
        return r0;
    L23:
        return Unit.INSTANCE;
    L19:
        if (StringsKt.isBlank(r12) == false) goto L21;
    L11:
        r13 = false;
        goto L12
    }
}
