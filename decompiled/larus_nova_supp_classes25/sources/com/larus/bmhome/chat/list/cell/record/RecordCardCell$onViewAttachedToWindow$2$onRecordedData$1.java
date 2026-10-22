package com.larus.bmhome.chat.list.cell.record;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.layout.item.RecordStatus;
import com.larus.bmhome.chat.layout.item.u3;
import com.larus.common_ui.SoundWaveView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.list.cell.record.RecordCardCell$onViewAttachedToWindow$2$onRecordedData$1", f = "RecordCardCell.kt", i = {}, l = {751}, m = "invokeSuspend", n = {}, s = {})
public final class RecordCardCell$onViewAttachedToWindow$2$onRecordedData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ byte[] $data;
    int label;
    final /* synthetic */ RecordCardCell this$0;

    public RecordCardCell$onViewAttachedToWindow$2$onRecordedData$1(RecordCardCell r1, byte[] r2, Continuation<? super RecordCardCell$onViewAttachedToWindow$2$onRecordedData$1> r3) {
        this.this$0 = r1;
        this.$data = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new RecordCardCell$onViewAttachedToWindow$2$onRecordedData$1(this.this$0, this.$data, r4);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L22:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        u3 r6 = this.this$0.e;
        if (r6 == null) goto L22;
        byte[] r2 = this.$data;
        this.label = 1;
        if (r6.E != RecordStatus.RECORDING) goto L18;
        SoundWaveView r7 = r6.s;
        if (r7 == null) goto L18;
        Object r8 = r7.c(r2, this);
        if (r8 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L19;
        r8 = Unit.INSTANCE;
    L19:
        if (r8 != r0) goto L22;
        return r0;
    L18:
        r8 = Unit.INSTANCE;
        goto L19
    }
}
