package com.larus.bmhome.chat.cotdetail.component;

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
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "isStreaming", ""}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.cotdetail.component.CotDetailMessageListComponent$observeViewModel$2", f = "CotDetailMessageListComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CotDetailMessageListComponent$observeViewModel$2 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ CotDetailMessageListComponent this$0;

    public CotDetailMessageListComponent$observeViewModel$2(CotDetailMessageListComponent r1, Continuation<? super CotDetailMessageListComponent$observeViewModel$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        CotDetailMessageListComponent$observeViewModel$2 r0 = new CotDetailMessageListComponent$observeViewModel$2(this.this$0, r4);
        r0.Z$0 = ((Boolean) r3).booleanValue();
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(((Boolean) r1).booleanValue(), (Continuation) r2);
    }

    public final Object invoke(boolean r1, Continuation<? super Unit> r2) {
        return create(Boolean.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r2);
        boolean r3 = this.Z$0;
        fe8.e r0 = (fe8.e) this.this$0.s.getValue();
        if (r0 == null) goto L11;
        if (r3 == false) goto L8;
        TitleBarState r4 = TitleBarState.STREAMING;
    L9:
        r0.QC(r4);
        goto L11
    L8:
        r4 = TitleBarState.SHARE;
    L11:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
