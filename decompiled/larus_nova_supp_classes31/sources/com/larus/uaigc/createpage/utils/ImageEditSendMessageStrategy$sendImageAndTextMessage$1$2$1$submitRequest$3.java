package com.larus.uaigc.createpage.utils;

import com.larus.im.bean.message.Message;
import com.larus.platform.model.upload.ResourceUploadError;
import com.tencent.open.log.TraceLevel;
import ic8.n0;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public /* synthetic */ class ImageEditSendMessageStrategy$sendImageAndTextMessage$1$2$1$submitRequest$3 extends FunctionReferenceImpl implements Function1<ResourceUploadError, Unit> {
    final /* synthetic */ String $curUploadTaskId;
    final /* synthetic */ String $filePath;
    final /* synthetic */ Message $imageMsg;
    final /* synthetic */ List<Message> $localMessageList;
    final /* synthetic */ boolean $pipelineEnabled;
    final /* synthetic */ Ref.ObjectRef<n0> $preprocessResult;
    final /* synthetic */ hy9.f $this_run;
    final /* synthetic */ ImageEditSendMessageStrategy this$0;

    public ImageEditSendMessageStrategy$sendImageAndTextMessage$1$2$1$submitRequest$3(boolean r1, String r2, ImageEditSendMessageStrategy r3, Message r4, List<Message> r5, hy9.f r6, Ref.ObjectRef<n0> r7, String r8) {
        this.$pipelineEnabled = r1;
        this.$curUploadTaskId = r2;
        this.this$0 = r3;
        this.$imageMsg = r4;
        this.$localMessageList = r5;
        this.$this_run = r6;
        this.$preprocessResult = r7;
        this.$filePath = r8;
        super(1, Intrinsics.Kotlin.class, "onUploadFailed", "invokeSuspend$onUploadFailed(ZLjava/lang/String;Lcom/larus/uaigc/createpage/utils/ImageEditSendMessageStrategy;Lcom/larus/im/bean/message/Message;Ljava/util/List;Lcom/larus/uaigc/bean/ImageEditSendMessageStrategyConfig;Lkotlin/jvm/internal/Ref$ObjectRef;Ljava/lang/String;Lcom/larus/platform/model/upload/ResourceUploadError;)V", 0);
    }

    public final void invoke(ResourceUploadError r11) {
        Intrinsics.checkNotNullParameter(r11, "p0");
        ImageEditSendMessageStrategy$sendImageAndTextMessage$1$2$1.access$invokeSuspend$onUploadFailed(this.$pipelineEnabled, this.$curUploadTaskId, this.this$0, this.$imageMsg, this.$localMessageList, this.$this_run, this.$preprocessResult, this.$filePath, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((ResourceUploadError) r1);
        return Unit.INSTANCE;
    }
}
