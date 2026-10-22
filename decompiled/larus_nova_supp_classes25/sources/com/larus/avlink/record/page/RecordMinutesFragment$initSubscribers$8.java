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
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/avlink/record/page/DeleteResult;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.record.page.RecordMinutesFragment$initSubscribers$8", f = "RecordMinutesFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class RecordMinutesFragment$initSubscribers$8 extends SuspendLambda implements Function2<c, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ RecordMinutesFragment this$0;

    public RecordMinutesFragment$initSubscribers$8(RecordMinutesFragment r1, Continuation<? super RecordMinutesFragment$initSubscribers$8> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        RecordMinutesFragment$initSubscribers$8 r0 = new RecordMinutesFragment$initSubscribers$8(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(c r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((c) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r14) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r14);
        c r15 = (c) this.L$0;
        if (r15 == null) goto L11;
        RecordMinutesFragment r0 = this.this$0;
        if (r15.a == false) goto L9;
        t19.s.j(t19.s.a, r0.requireContext(), r0.requireContext().getString(2131901589), null, false, 28);
        goto L11
    L9:
        t19.s.j(t19.s.a, r0.requireContext(), r0.requireContext().getString(2131901588), null, false, 28);
    L11:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
