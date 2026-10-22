package com.larus.bmhome.chat.component.bottom.attachment;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.utils.c4;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.platform.spi.IAIChatService;
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
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.attachment.AttachmentPanelComponent$onClickVideoItem$1", f = "AttachmentPanelComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AttachmentPanelComponent$onClickVideoItem$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ UplinkFileEntity $entity;
    final /* synthetic */ c4 $eventParam;
    int label;
    final /* synthetic */ AttachmentPanelComponent this$0;

    public AttachmentPanelComponent$onClickVideoItem$1(AttachmentPanelComponent r1, UplinkFileEntity r2, c4 r3, Continuation<? super AttachmentPanelComponent$onClickVideoItem$1> r4) {
        this.this$0 = r1;
        this.$entity = r2;
        this.$eventParam = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new AttachmentPanelComponent$onClickVideoItem$1(this.this$0, this.$entity, this.$eventParam, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r4);
        IAIChatService.a.K7(s1a.a.getActivity(this.this$0).getSupportFragmentManager(), os8.a.a(this.$entity), this.$eventParam);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
