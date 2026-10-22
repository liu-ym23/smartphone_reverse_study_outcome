package com.larus.bmhome.chat.component.bottom.attachment;

import com.larus.bmhome.chat.api.ChatApi;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.j1;
import com.larus.bmhome.nestedfile.INestedFileCacheManagerService;
import com.larus.bmhome.rc.ResourceCenter;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
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
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.attachment.AttachmentPanelComponent$fileEntityObserver$2$1$4", f = "AttachmentPanelComponent.kt", i = {}, l = {550}, m = "invokeSuspend", n = {}, s = {})
public final class AttachmentPanelComponent$fileEntityObserver$2$1$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $draftLocalMsgId;
    final /* synthetic */ Pair<INestedFileCacheManagerService.FileEvent, UplinkFileEntity> $it;
    int label;
    final /* synthetic */ AttachmentPanelComponent this$0;

    public AttachmentPanelComponent$fileEntityObserver$2$1$4(AttachmentPanelComponent r1, String r2, Pair<? extends INestedFileCacheManagerService.FileEvent, UplinkFileEntity> r3, Continuation<? super AttachmentPanelComponent$fileEntityObserver$2$1$4> r4) {
        this.this$0 = r1;
        this.$draftLocalMsgId = r2;
        this.$it = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new AttachmentPanelComponent$fileEntityObserver$2$1$4(this.this$0, this.$draftLocalMsgId, this.$it, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r21) {
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r21);
        Object r1 = r21;
    L24:
        FLogger.a.i("AttachmentPanelComponent", "requestMessagePreHandleV2 result:" + ((com.larus.network.http.a) r1));
    L26:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r21);
        AttachmentPanelComponent r2 = this.this$0;
        int r3 = AttachmentPanelComponent.g2;
        j1 r9 = r2.Y3();
        if (r9 == null) goto L11;
        Boxing.boxBoolean(j1.a.a(r9, this.$draftLocalMsgId, (UplinkFileEntity) this.$it.getSecond(), null, false, false, null, null, null, null, 508));
    L11:
        ResourceCenter.a.getClass();
        if (ResourceCenter.c() == false) goto L14;
        FLogger.a.i("AttachmentPanelComponent", "[requestMessagePreHandleV2] via resource center, skip");
        goto L26
    L14:
        Lazy<ChatApi> r4 = ChatApi.a;
        ChatApi r5 = ChatApi.a.a();
        UplinkFileEntity r6 = (UplinkFileEntity) this.$it.getSecond();
        String r8 = this.this$0.K();
        BotModel r10 = this.this$0.W3();
        String r11 = null;
        if (r10 == null) goto L17;
        String r12 = r10.getBotId();
    L18:
        wc9.e r13 = this.this$0.H3();
        if (r13 == null) goto L21;
        r11 = r13.B;
    L21:
        String r14 = this.$draftLocalMsgId;
        this.label = 1;
        r5.getClass();
        r1 = ChatApi.b(r6, r8, r12, r11, r14, this);
        if (r1 != r7) goto L24;
        return r7;
    L17:
        r12 = null;
        goto L18
    }
}
