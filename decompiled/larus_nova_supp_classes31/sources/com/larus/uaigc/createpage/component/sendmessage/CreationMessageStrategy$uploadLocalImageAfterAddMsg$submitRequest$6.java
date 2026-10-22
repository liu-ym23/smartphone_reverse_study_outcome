package com.larus.uaigc.createpage.component.sendmessage;

import com.larus.im.bean.message.Message;
import com.larus.platform.model.upload.ResourceUploadError;
import com.larus.uaigc.bean.createpage.CreationSendMessageConfig;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public /* synthetic */ class CreationMessageStrategy$uploadLocalImageAfterAddMsg$submitRequest$6 extends FunctionReferenceImpl implements Function1<ResourceUploadError, Unit> {
    final /* synthetic */ CreationSendMessageConfig $config;
    final /* synthetic */ Message $imageMsg;
    final /* synthetic */ boolean $pipelineEnabled;
    final /* synthetic */ CreationMessageStrategy.b $preparedUploadPath;
    final /* synthetic */ Message $textMsg;
    final /* synthetic */ String $uploadIdentifier;
    final /* synthetic */ CreationMessageStrategy this$0;

    public CreationMessageStrategy$uploadLocalImageAfterAddMsg$submitRequest$6(CreationMessageStrategy.b r1, boolean r2, String r3, CreationMessageStrategy r4, Message r5, Message r6, CreationSendMessageConfig r7) {
        this.$preparedUploadPath = r1;
        this.$pipelineEnabled = r2;
        this.$uploadIdentifier = r3;
        this.this$0 = r4;
        this.$imageMsg = r5;
        this.$textMsg = r6;
        this.$config = r7;
        super(1, Intrinsics.Kotlin.class, "onUploadFailed", "uploadLocalImageAfterAddMsg$onUploadFailed(Lcom/larus/uaigc/createpage/component/sendmessage/CreationMessageStrategy$PreparedUploadPath;ZLjava/lang/String;Lcom/larus/uaigc/createpage/component/sendmessage/CreationMessageStrategy;Lcom/larus/im/bean/message/Message;Lcom/larus/im/bean/message/Message;Lcom/larus/uaigc/bean/createpage/CreationSendMessageConfig;Lcom/larus/platform/model/upload/ResourceUploadError;)V", 0);
    }

    public final void invoke(ResourceUploadError r10) {
        Intrinsics.checkNotNullParameter(r10, "p0");
        CreationMessageStrategy.d(this.$preparedUploadPath, this.$pipelineEnabled, this.$uploadIdentifier, this.this$0, this.$imageMsg, this.$textMsg, this.$config, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((ResourceUploadError) r1);
        return Unit.INSTANCE;
    }
}
