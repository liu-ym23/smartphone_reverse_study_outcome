package com.larus.avlink.record.util;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/avlink/record/util/RetryDecision;", "ctx", "Lcom/larus/avlink/record/util/RetryContext;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.record.util.LarkRecordMinutesManager$pushCardRetrier$3", f = "LarkRecordMinutesManager.kt", i = {}, l = {197}, m = "invokeSuspend", n = {}, s = {})
public final class LarkRecordMinutesManager$pushCardRetrier$3 extends SuspendLambda implements Function2<s, Continuation<? super RetryDecision>, Object> {
    /* synthetic */ Object L$0;
    int label;

    public LarkRecordMinutesManager$pushCardRetrier$3(Continuation<? super LarkRecordMinutesManager$pushCardRetrier$3> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        LarkRecordMinutesManager$pushCardRetrier$3 r0 = new LarkRecordMinutesManager$pushCardRetrier$3(r3);
        r0.L$0 = r2;
        return r0;
    }

    public final Object invoke(s r1, Continuation<? super RetryDecision> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((s) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        return r4;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        s r5 = (s) this.L$0;
        LarkRecordMinutesManager r2 = LarkRecordMinutesManager.a;
        this.label = 1;
        r4 = LarkRecordMinutesManager.a(r2, r5, this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
