package com.larus.bmhome.chat.list.cell.record;

import com.larus.audio.j0;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.list.cell.record.RecordCardCell$handleSpecialSituation$1$1", f = "RecordCardCell.kt", i = {}, l = {604}, m = "invokeSuspend", n = {}, s = {})
final class RecordCardCell$handleSpecialSituation$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Message $message;
    int label;
    final /* synthetic */ RecordCardCell this$0;

    public RecordCardCell$handleSpecialSituation$1$1(RecordCardCell r1, Message r2, Continuation<? super RecordCardCell$handleSpecialSituation$1$1> r3) {
        this.this$0 = r1;
        this.$message = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new RecordCardCell$handleSpecialSituation$1$1(this.this$0, this.$message, r4);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L11:
        RecordCardCell r2 = this.this$0;
        r2.h = System.currentTimeMillis();
        j0 r3 = this.this$0.i;
        String r4 = this.$message.getMessageId();
        r3.i(r4, (String) r6);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        FLogger.a.i("RecordCardBox", "getBotId is empty, fallback to cvs");
        CoroutineDispatcher r7 = Dispatchers.getIO();
        RecordCardCell$handleSpecialSituation$1$1$fallbackBotId$1 r5 = new RecordCardCell$handleSpecialSituation$1$1$fallbackBotId$1(this.this$0, null);
        this.label = 1;
        r6 = BuildersKt.withContext(r7, r5, this);
        if (r6 != r0) goto L11;
        return r0;
    }
}
