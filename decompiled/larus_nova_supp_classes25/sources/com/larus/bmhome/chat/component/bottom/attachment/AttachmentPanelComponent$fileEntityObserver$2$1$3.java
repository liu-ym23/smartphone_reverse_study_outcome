package com.larus.bmhome.chat.component.bottom.attachment;

import com.larus.bmhome.chat.api.ChatApi;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.j1;
import com.larus.bmhome.nestedfile.INestedFileCacheManagerService;
import com.larus.bmhome.nestedfile.NestedFileCacheManagerService;
import com.larus.bmhome.rc.ResourceCenter;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.attachment.AttachmentPanelComponent$fileEntityObserver$2$1$3", f = "AttachmentPanelComponent.kt", i = {}, l = {530}, m = "invokeSuspend", n = {}, s = {})
public final class AttachmentPanelComponent$fileEntityObserver$2$1$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $draftBotId;
    final /* synthetic */ String $draftConversationId;
    final /* synthetic */ String $draftLocalMsgId;
    final /* synthetic */ String $draftSectionId;
    final /* synthetic */ Pair<INestedFileCacheManagerService.FileEvent, UplinkFileEntity> $it;
    int label;
    final /* synthetic */ AttachmentPanelComponent this$0;

    public AttachmentPanelComponent$fileEntityObserver$2$1$3(AttachmentPanelComponent r1, String r2, Pair<? extends INestedFileCacheManagerService.FileEvent, UplinkFileEntity> r3, String r4, String r5, String r6, Continuation<? super AttachmentPanelComponent$fileEntityObserver$2$1$3> r7) {
        this.this$0 = r1;
        this.$draftLocalMsgId = r2;
        this.$it = r3;
        this.$draftConversationId = r4;
        this.$draftBotId = r5;
        this.$draftSectionId = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new AttachmentPanelComponent$fileEntityObserver$2$1$3(this.this$0, this.$draftLocalMsgId, this.$it, this.$draftConversationId, this.$draftBotId, this.$draftSectionId, r10);
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
    L23:
        FLogger.a.i("AttachmentPanelComponent", "requestMessagePreHandleV2 result:" + ((com.larus.network.http.a) r1));
    L25:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r21);
        AttachmentPanelComponent r2 = this.this$0;
        int r3 = AttachmentPanelComponent.g2;
        j1 r9 = r2.Y3();
        if (r9 == null) goto L17;
        String r10 = this.$draftLocalMsgId;
        NestedFileContent r4 = NestedFileCacheManagerService.b.b6(r10);
        if (r4 == null) goto L13;
        List r5 = r4.getEntities();
    L14:
        if (r5 != null) goto L16;
        r5 = CollectionsKt.emptyList();
    L16:
        Boxing.boxBoolean(j1.a.a(r9, r10, null, r5, true, false, null, null, null, ((UplinkFileEntity) this.$it.getSecond()).getFileIdentifier(), 242));
        goto L17
    L13:
        r5 = null;
    L17:
        ResourceCenter.a.getClass();
        if (ResourceCenter.c() == false) goto L20;
        FLogger.a.i("AttachmentPanelComponent", "[requestMessagePreHandleV2] via resource center, skip");
        goto L25
    L20:
        Lazy<ChatApi> r6 = ChatApi.a;
        ChatApi r8 = ChatApi.a.a();
        UplinkFileEntity r11 = (UplinkFileEntity) this.$it.getSecond();
        String r12 = this.$draftConversationId;
        String r13 = this.$draftBotId;
        String r14 = this.$draftSectionId;
        String r15 = this.$draftLocalMsgId;
        this.label = 1;
        r8.getClass();
        r1 = ChatApi.b(r11, r12, r13, r14, r15, this);
        if (r1 != r7) goto L23;
        return r7;
    }
}
