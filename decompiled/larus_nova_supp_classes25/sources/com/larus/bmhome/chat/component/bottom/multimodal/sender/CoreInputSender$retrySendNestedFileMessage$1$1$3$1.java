package com.larus.bmhome.chat.component.bottom.multimodal.sender;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.multimodal.upload.FileUploader;
import com.larus.bmhome.nestedfile.NestedFileCacheManagerService;
import com.larus.bmhome.rc.FlowResourceScene;
import com.larus.bmhome.rc.ResourceCenter;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.utils.p0;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import yc9.n1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.multimodal.sender.CoreInputSender$retrySendNestedFileMessage$1$1$3$1", f = "CoreInputSender.kt", i = {}, l = {535}, m = "invokeSuspend", n = {}, s = {})
public final class CoreInputSender$retrySendNestedFileMessage$1$1$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ UplinkFileEntity $entity;
    final /* synthetic */ com.larus.bmhome.chat.component.bottom.multimodal.upload.d $fileUploadParam;
    final /* synthetic */ Message $message;
    int label;
    final /* synthetic */ f this$0;

    public CoreInputSender$retrySendNestedFileMessage$1$1$3$1(UplinkFileEntity r1, Message r2, f r3, com.larus.bmhome.chat.component.bottom.multimodal.upload.d r4, Continuation<? super CoreInputSender$retrySendNestedFileMessage$1$1$3$1> r5) {
        this.$entity = r1;
        this.$message = r2;
        this.this$0 = r3;
        this.$fileUploadParam = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new CoreInputSender$retrySendNestedFileMessage$1$1$3$1(this.$entity, this.$message, this.this$0, this.$fileUploadParam, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L44:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        String r12 = this.$entity.getFileIdentifier();
        if (r12 == null) goto L44;
        String r13 = p0.a(r12);
        if (r13 == null) goto L44;
        Message r2 = this.$message;
        UplinkFileEntity r3 = this.$entity;
        f r4 = this.this$0;
        com.larus.bmhome.chat.component.bottom.multimodal.upload.d r5 = this.$fileUploadParam;
        NestedFileCacheManagerService r6 = NestedFileCacheManagerService.b;
        String r7 = r2.getLocalMessageId();
        String r8 = "";
        if (r7 != null) goto L15;
        r7 = "";
    L15:
        String r9 = r3.getFileIdentifier();
        if (r9 == null) goto L19;
        r8 = r9;
    L19:
        r6.m(r7, r8, 1);
        if (n1.e(r3) == false) goto L27;
        ResourceCenter r10 = ResourceCenter.a;
        FlowResourceScene r14 = FlowResourceScene.VideoUpload;
        r10.getClass();
        ResourceCenter.k(r13, r14);
        if (com.larus.bmhome.upload.h.a.query(r13) != null) goto L40;
        mr9.e r15 = new com.larus.bmhome.chat.component.bottom.multimodal.preprocess.b().o(r3);
        if (r15 == null) goto L40;
        com.larus.bmhome.upload.h.a(r13, r15, "CoreInputSender#retrySendNestedFileMessage");
    L40:
        FileUploader r16 = FileUploader.a;
        this.label = 1;
        if (FileUploader.k(r5, this) != r0) goto L44;
        return r0;
    L27:
        if (n1.b(r3) == false) goto L30;
        ResourceCenter r17 = ResourceCenter.a;
        FlowResourceScene r18 = FlowResourceScene.FileUpload;
        r17.getClass();
        ResourceCenter.k(r13, r18);
        goto L40
    L30:
        if (n1.d(r3) == false) goto L40;
        int r19 = f.d;
        r4.getClass();
        Map r20 = r2.getExt();
        if (r20 != null) goto L34;
    L36:
        boolean r21 = false;
    L37:
        if (r21 == false) goto L39;
        ResourceCenter r22 = ResourceCenter.a;
        FlowResourceScene r23 = FlowResourceScene.SpringMainVenue;
        r22.getClass();
        ResourceCenter.k(r13, r23);
        goto L40
    L39:
        ResourceCenter r24 = ResourceCenter.a;
        FlowResourceScene r25 = FlowResourceScene.ImageVLM;
        r24.getClass();
        ResourceCenter.k(r13, r25);
        goto L40
    L34:
        if (Intrinsics.areEqual(r20.get("chat_raf_option"), "1") == false) goto L36;
        r21 = true;
        goto L37
    }
}
