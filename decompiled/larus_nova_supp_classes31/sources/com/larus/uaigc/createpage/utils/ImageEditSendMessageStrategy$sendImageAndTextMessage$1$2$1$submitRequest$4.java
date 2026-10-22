package com.larus.uaigc.createpage.utils;

import com.larus.im.bean.message.Message;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public /* synthetic */ class ImageEditSendMessageStrategy$sendImageAndTextMessage$1$2$1$submitRequest$4 extends FunctionReferenceImpl implements Function1<mr9.k, Unit> {
    final /* synthetic */ Message $imageMsg;
    final /* synthetic */ boolean $pipelineEnabled;
    final /* synthetic */ ImageEditSendMessageStrategy this$0;

    public ImageEditSendMessageStrategy$sendImageAndTextMessage$1$2$1$submitRequest$4(boolean r7, ImageEditSendMessageStrategy r8, Message r9) {
        this.$pipelineEnabled = r7;
        this.this$0 = r8;
        this.$imageMsg = r9;
        super(1, Intrinsics.Kotlin.class, "onUploadProgress", "invokeSuspend$onUploadProgress(ZLcom/larus/uaigc/createpage/utils/ImageEditSendMessageStrategy;Lcom/larus/im/bean/message/Message;Lcom/larus/platform/model/upload/ResourceUploadProgressResult;)V", 0);
    }

    public final void invoke(mr9.k r4) {
        Intrinsics.checkNotNullParameter(r4, "p0");
        ImageEditSendMessageStrategy$sendImageAndTextMessage$1$2$1.access$invokeSuspend$onUploadProgress(this.$pipelineEnabled, this.this$0, this.$imageMsg, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((mr9.k) r1);
        return Unit.INSTANCE;
    }
}
