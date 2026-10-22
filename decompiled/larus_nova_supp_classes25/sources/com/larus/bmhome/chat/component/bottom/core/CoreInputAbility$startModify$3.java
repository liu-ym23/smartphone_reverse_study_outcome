package com.larus.bmhome.chat.component.bottom.core;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.core.CoreInputAbility$startModify$3", f = "CoreInputAbility.kt", i = {}, l = {878}, m = "invokeSuspend", n = {}, s = {})
public final class CoreInputAbility$startModify$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Message $message;
    Object L$0;
    int label;
    final /* synthetic */ CoreInputAbility<T> this$0;

    public CoreInputAbility$startModify$3(CoreInputAbility<T> r1, Message r2, Continuation<? super CoreInputAbility$startModify$3> r3) {
        this.this$0 = r1;
        this.$message = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CoreInputAbility$startModify$3(this.this$0, this.$message, r4);
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
        if (r1 == 0) goto L10;
        if (r1 != 1) goto L9;
        CoreInputAbility r2 = (CoreInputAbility) this.L$0;
        ResultKt.throwOnFailure(r5);     // Catch: Throwable -> L22
    L15:
        List<UplinkFileEntity> r6 = (List) r5;     // Catch: Throwable -> L22
        if ((!r6.isEmpty()) == false) goto L20;
        String r3 = CoreInputAbility.U;     // Catch: Throwable -> L22
        com.larus.bmhome.chat.component.bottom.attachment.g1 r4 = r2.A().f70();     // Catch: Throwable -> L22
        if (r4 == null) goto L20;
        Boxing.boxInt(r4.uW(r6, false, "modify_reuse"));     // Catch: Throwable -> L22
    L20:
        Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L22
    L24:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L28;
        FLogger.a.e("CoreInputAbility", "[startModify] appendHistoryAttachments failed", r8);
    L28:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r5);
        CoreInputAbility r9 = this.this$0;
        Message r10 = this.$message;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L22
        this.L$0 = r9;     // Catch: Throwable -> L22
        this.label = 1;     // Catch: Throwable -> L22
        Object r12 = CoreInputAbility.b(r9, r10, this);     // Catch: Throwable -> L22
        if (r12 != r0) goto L14;
        return r0;
    L14:
        r2 = r9;
        r5 = r12;
    L22:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L24
    }
}
