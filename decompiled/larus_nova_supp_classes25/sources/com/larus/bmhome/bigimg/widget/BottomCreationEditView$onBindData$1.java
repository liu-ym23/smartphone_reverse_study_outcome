package com.larus.bmhome.bigimg.widget;

import com.larus.bmhome.bigimg.download.ImageDownloadLoadingMgr;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
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
@DebugMetadata(c = "com.larus.bmhome.bigimg.widget.BottomCreationEditView$onBindData$1", f = "BottomCreationEditView.kt", i = {}, l = {79}, m = "invokeSuspend", n = {}, s = {})
public final class BottomCreationEditView$onBindData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $imageUrl;
    int label;
    final /* synthetic */ BottomCreationEditView this$0;

    public BottomCreationEditView$onBindData$1(String r1, BottomCreationEditView r2, Continuation<? super BottomCreationEditView$onBindData$1> r3) {
        this.$imageUrl = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new BottomCreationEditView$onBindData$1(this.$imageUrl, this.this$0, r4);
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
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        ImageDownloadLoadingMgr r7 = ImageDownloadLoadingMgr.a;
        String r2 = this.$imageUrl;
        final BottomCreationEditView r3 = this.this$0;
        Function1<? super Boolean, Unit> r4 = new h(r3);
        this.label = 1;
        if (r7.a(r2, r4, this) != r0) goto L12;
        return r0;
    }
}
