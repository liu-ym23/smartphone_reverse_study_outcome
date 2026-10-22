package com.larus.bmhome.chat.component.bottom.multimodal;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.multimodal.preprocess.b;
import com.larus.bmhome.chat.component.bottom.multimodal.upload.FileUploader;
import com.larus.bmhome.nestedfile.NestedFileCacheManagerService;
import com.larus.bmhome.rc.FlowResourceScene;
import com.larus.bmhome.rc.ResourceCenter;
import com.larus.im.bean.message.Message;
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
import yc9.n1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.multimodal.DirectSendFileHelper$retryDirectSendMultiFile$2$1$1", f = "DirectSendFileHelper.kt", i = {}, l = {642}, m = "invokeSuspend", n = {}, s = {})
final class DirectSendFileHelper$retryDirectSendMultiFile$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ UplinkFileEntity $entity;
    final /* synthetic */ com.larus.bmhome.chat.component.bottom.multimodal.upload.d $fileUploadParam;
    final /* synthetic */ Message $result;
    int label;

    public DirectSendFileHelper$retryDirectSendMultiFile$2$1$1(UplinkFileEntity r1, Message r2, com.larus.bmhome.chat.component.bottom.multimodal.upload.d r3, Continuation<? super DirectSendFileHelper$retryDirectSendMultiFile$2$1$1> r4) {
        this.$entity = r1;
        this.$result = r2;
        this.$fileUploadParam = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DirectSendFileHelper$retryDirectSendMultiFile$2$1$1(this.$entity, this.$result, this.$fileUploadParam, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r9);
    L30:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        String r10 = this.$entity.getFileIdentifier();
        if (r10 == null) goto L30;
        String r11 = com.larus.utils.p0.a(r10);
        if (r11 == null) goto L30;
        Message r2 = this.$result;
        UplinkFileEntity r3 = this.$entity;
        com.larus.bmhome.chat.component.bottom.multimodal.upload.d r4 = this.$fileUploadParam;
        NestedFileCacheManagerService r5 = NestedFileCacheManagerService.b;
        String r6 = r2.getLocalMessageId();
        String r7 = "";
        if (r6 != null) goto L15;
        r6 = "";
    L15:
        String r8 = r3.getFileIdentifier();
        if (r8 == null) goto L19;
        r7 = r8;
    L19:
        r5.m(r6, r7, 1);
        if (n1.e(r3) == false) goto L26;
        ResourceCenter r12 = ResourceCenter.a;
        FlowResourceScene r13 = FlowResourceScene.VideoUpload;
        r12.getClass();
        ResourceCenter.k(r11, r13);
        if (com.larus.bmhome.upload.h.a.query(r11) != null) goto L26;
        mr9.e r14 = new b().o(r3);
        if (r14 == null) goto L26;
        com.larus.bmhome.upload.h.a(r11, r14, "DirectSendFileHelper#retryDirectSendMultiFile");
    L26:
        FileUploader r15 = FileUploader.a;
        this.label = 1;
        if (FileUploader.k(r4, this) != r0) goto L30;
        return r0;
    }
}
