package com.larus.uaigc.createpage.utils;

import com.larus.im.bean.message.Message;
import com.tencent.open.log.TraceLevel;
import ic8.n0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public /* synthetic */ class ImageEditSendMessageStrategy$sendImageAndTextMessage$1$2$1$submitRequest$5 extends FunctionReferenceImpl implements Function1<mr9.l, Unit> {
    final /* synthetic */ String $curUploadTaskId;
    final /* synthetic */ String $filePath;
    final /* synthetic */ Message $imageMsg;
    final /* synthetic */ int $instructionType;
    final /* synthetic */ boolean $pipelineEnabled;
    final /* synthetic */ Ref.ObjectRef<n0> $preprocessResult;
    final /* synthetic */ Message $textMsg;
    final /* synthetic */ hy9.f $this_run;
    final /* synthetic */ Function1<hy9.j, Unit> $uploadSuccessCallback;
    final /* synthetic */ ImageEditSendMessageStrategy this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public ImageEditSendMessageStrategy$sendImageAndTextMessage$1$2$1$submitRequest$5(boolean r1, String r2, ImageEditSendMessageStrategy r3, String r4, Message r5, hy9.f r6, Function1<? super hy9.j, Unit> r7, Message r8, int r9, Ref.ObjectRef<n0> r10) {
        this.$pipelineEnabled = r1;
        this.$curUploadTaskId = r2;
        this.this$0 = r3;
        this.$filePath = r4;
        this.$imageMsg = r5;
        this.$this_run = r6;
        this.$uploadSuccessCallback = r7;
        this.$textMsg = r8;
        this.$instructionType = r9;
        this.$preprocessResult = r10;
        super(1, Intrinsics.Kotlin.class, "onUploadSuccess", "invokeSuspend$onUploadSuccess(ZLjava/lang/String;Lcom/larus/uaigc/createpage/utils/ImageEditSendMessageStrategy;Ljava/lang/String;Lcom/larus/im/bean/message/Message;Lcom/larus/uaigc/bean/ImageEditSendMessageStrategyConfig;Lkotlin/jvm/functions/Function1;Lcom/larus/im/bean/message/Message;ILkotlin/jvm/internal/Ref$ObjectRef;Lcom/larus/platform/model/upload/ResourceUploadResult;)V", 0);
    }

    public final void invoke(mr9.l r13) {
        Intrinsics.checkNotNullParameter(r13, "p0");
        ImageEditSendMessageStrategy$sendImageAndTextMessage$1$2$1.access$invokeSuspend$onUploadSuccess(this.$pipelineEnabled, this.$curUploadTaskId, this.this$0, this.$filePath, this.$imageMsg, this.$this_run, this.$uploadSuccessCallback, this.$textMsg, this.$instructionType, this.$preprocessResult, r13);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((mr9.l) r1);
        return Unit.INSTANCE;
    }
}
