package com.larus.bmhome.chat.component.bottom.attachment;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.multimodal.upload.FileUploader;
import com.larus.bmhome.nestedfile.NestedFileCacheManagerService;
import com.larus.bmhome.rc.FlowResourceScene;
import com.larus.bmhome.rc.ResourceCenter;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.UplinkFileEntity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import yc9.l1;
import yc9.n1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.attachment.AttachmentPanelComponent$showAttachmentPanel$1$onClick$4$1", f = "AttachmentPanelComponent.kt", i = {}, l = {3328, 3330}, m = "invokeSuspend", n = {}, s = {})
public final class AttachmentPanelComponent$showAttachmentPanel$1$onClick$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $actionBarTemplateName;
    final /* synthetic */ String $clickFrom;
    final /* synthetic */ UplinkFileEntity $entity;
    final /* synthetic */ String $fromScene;
    final /* synthetic */ UplinkFileEntity $it;
    final /* synthetic */ String $key;
    final /* synthetic */ String $localMsgId;
    int label;
    final /* synthetic */ AttachmentPanelComponent this$0;

    public AttachmentPanelComponent$showAttachmentPanel$1$onClick$4$1(UplinkFileEntity r1, AttachmentPanelComponent r2, UplinkFileEntity r3, String r4, String r5, String r6, String r7, String r8, Continuation<? super AttachmentPanelComponent$showAttachmentPanel$1$onClick$4$1> r9) {
        this.$it = r1;
        this.this$0 = r2;
        this.$entity = r3;
        this.$fromScene = r4;
        this.$clickFrom = r5;
        this.$actionBarTemplateName = r6;
        this.$localMsgId = r7;
        this.$key = r8;
        super(2, r9);
    }

    public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
        return new AttachmentPanelComponent$showAttachmentPanel$1$onClick$4$1(this.$it, this.this$0, this.$entity, this.$fromScene, this.$clickFrom, this.$actionBarTemplateName, this.$localMsgId, this.$key, r12);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r26) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 == 2) goto L9;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r26);
    L41:
        return Unit.INSTANCE;
    L10:
        ResultKt.throwOnFailure(r26);
        boolean r6 = n1.d(this.$it);
        String r3 = l1.d(this.$it);
        if (r3 != null) goto L13;
    L16:
        boolean r5 = true;
    L17:
        if (r5 == true) goto L19;
        String r14 = l1.a(this.$it);
        x0 r11 = AttachmentPanelComponent.h4(this.this$0, r6, this.$entity, this.$fromScene, this.$clickFrom, null, this.$actionBarTemplateName, this.$localMsgId, 48);
        r11.a(0, this.$key);
        UplinkFileEntity r12 = this.$it;
        String r13 = this.this$0.K();
        BotModel r7 = this.this$0.W3();
        String r8 = null;
        if (r7 == null) goto L23;
        String r9 = r7.getBotId();
    L24:
        wc9.e r10 = this.this$0.H3();
        if (r10 == null) goto L27;
        r8 = r10.B;
    L27:
        com.larus.bmhome.chat.component.bottom.multimodal.upload.d r15 = new com.larus.bmhome.chat.component.bottom.multimodal.upload.d(true, r3, r14, r11, r12, r13, r9, r8, this.$localMsgId, false, false, null, null, null, null, null, 65024);
        String r16 = "";
        if (n1.e(this.$entity) == false) goto L33;
        ResourceCenter r4 = ResourceCenter.a;
        String r17 = this.$entity.getFileIdentifier();
        if (r17 != null) goto L32;
        r17 = "";
    L32:
        FlowResourceScene r18 = FlowResourceScene.VideoUpload;
        r4.getClass();
        ResourceCenter.k(r17, r18);
    L33:
        NestedFileCacheManagerService r19 = NestedFileCacheManagerService.b;
        String r20 = this.$localMsgId;
        String r21 = this.$entity.getFileIdentifier();
        if (r21 == null) goto L37;
        r16 = r21;
    L37:
        r19.m(r20, r16, 1);
        this.this$0.getClass();
        FileUploader r22 = FileUploader.a;
        this.label = 2;
        if (FileUploader.k(r15, this) != r1) goto L41;
        return r1;
    L23:
        r9 = null;
        goto L24
    L19:
        return Unit.INSTANCE;
    L13:
        if (r3.length() == 0) goto L16;
        r5 = false;
        goto L17
    }
}
