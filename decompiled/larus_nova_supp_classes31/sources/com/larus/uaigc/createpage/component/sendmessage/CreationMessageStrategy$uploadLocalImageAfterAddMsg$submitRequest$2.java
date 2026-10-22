package com.larus.uaigc.createpage.component.sendmessage;

import com.larus.bmhome.view.AttachmentInfo;
import com.larus.im.bean.message.Message;
import com.larus.uaigc.bean.createpage.CreationSendMessageConfig;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public /* synthetic */ class CreationMessageStrategy$uploadLocalImageAfterAddMsg$submitRequest$2 extends FunctionReferenceImpl implements Function1<mr9.l, Unit> {
    final /* synthetic */ CreationSendMessageConfig $config;
    final /* synthetic */ Message $imageMsg;
    final /* synthetic */ boolean $pipelineEnabled;
    final /* synthetic */ CreationMessageStrategy.b $preparedUploadPath;
    final /* synthetic */ AttachmentInfo $sourceAttachment;
    final /* synthetic */ Message $textMsg;
    final /* synthetic */ String $uploadIdentifier;
    final /* synthetic */ String $uploadPath;
    final /* synthetic */ CreationMessageStrategy this$0;

    public CreationMessageStrategy$uploadLocalImageAfterAddMsg$submitRequest$2(boolean r1, CreationMessageStrategy r2, String r3, String r4, Message r5, CreationSendMessageConfig r6, AttachmentInfo r7, Message r8, CreationMessageStrategy.b r9) {
        this.$pipelineEnabled = r1;
        this.this$0 = r2;
        this.$uploadIdentifier = r3;
        this.$uploadPath = r4;
        this.$imageMsg = r5;
        this.$config = r6;
        this.$sourceAttachment = r7;
        this.$textMsg = r8;
        this.$preparedUploadPath = r9;
        super(1, Intrinsics.Kotlin.class, "onUploadSuccess", "uploadLocalImageAfterAddMsg$onUploadSuccess(ZLcom/larus/uaigc/createpage/component/sendmessage/CreationMessageStrategy;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/message/Message;Lcom/larus/uaigc/bean/createpage/CreationSendMessageConfig;Lcom/larus/bmhome/view/AttachmentInfo;Lcom/larus/im/bean/message/Message;Lcom/larus/uaigc/createpage/component/sendmessage/CreationMessageStrategy$PreparedUploadPath;Lcom/larus/platform/model/upload/ResourceUploadResult;)V", 0);
    }

    public final void invoke(mr9.l r12) {
        Intrinsics.checkNotNullParameter(r12, "p0");
        CreationMessageStrategy.f(this.$pipelineEnabled, this.this$0, this.$uploadIdentifier, this.$uploadPath, this.$imageMsg, this.$config, this.$sourceAttachment, this.$textMsg, this.$preparedUploadPath, r12);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((mr9.l) r1);
        return Unit.INSTANCE;
    }
}
