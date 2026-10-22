package com.larus.avlink.record.page;

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
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/avlink/record/page/UploadResult;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.record.page.RecordMinutesFragment$initSubscribers$10", f = "RecordMinutesFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class RecordMinutesFragment$initSubscribers$10 extends SuspendLambda implements Function2<o1, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ RecordMinutesFragment this$0;

    public RecordMinutesFragment$initSubscribers$10(RecordMinutesFragment r1, Continuation<? super RecordMinutesFragment$initSubscribers$10> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        RecordMinutesFragment$initSubscribers$10 r0 = new RecordMinutesFragment$initSubscribers$10(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(o1 r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((o1) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r8);
        o1 r9 = (o1) this.L$0;
        if (r9 == null) goto L10;
        RecordMinutesFragment r0 = this.this$0;
        if (r9.a == true) goto L10;
        t19.s.j(t19.s.a, r0.requireContext(), r0.requireContext().getString(2131899639), null, false, 28);
    L10:
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
