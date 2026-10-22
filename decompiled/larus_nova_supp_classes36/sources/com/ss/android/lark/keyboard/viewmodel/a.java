package com.ss.android.lark.keyboard.viewmodel;

import com.bytedance.lark.pb.contact.v2.PullDoubaoChatterRequest;
import com.bytedance.lark.pb.contact.v2.PullDoubaoChatterResponse;
import com.bytedance.lark.pb.im.v1.CancelAsyncUploadRequest;
import com.bytedance.lark.pb.im.v1.CancelAsyncUploadResponse;
import com.bytedance.lark.pb.im.v1.CloseDoubaoSmartReplyRequest;
import com.bytedance.lark.pb.im.v1.CloseDoubaoSmartReplyResponse;
import com.bytedance.lark.pb.im.v1.PushUploadResourceStatus;
import com.bytedance.lark.pb.im.v1.TransformMarkdownToRichTextRequest;
import com.bytedance.lark.pb.im.v1.TransformMarkdownToRichTextResponse;
import com.bytedance.lark.pb.im.v1.UploadResourceRequest;
import com.bytedance.lark.pb.im.v1.UploadResourceResponse;
import com.larksuite.rucket.impl.sdkimpl.annotation.SdkCall;
import com.larksuite.rucket.impl.sdkimpl.annotation.SdkPush;
import com.larksuite.rucket.job.RucketJob;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface a {
    @SdkCall(4158)
    RucketJob<CancelAsyncUploadResponse> cancelAsyncUpload(CancelAsyncUploadRequest r1);

    @SdkCall(43101)
    RucketJob<CloseDoubaoSmartReplyResponse> closeDoubaoSmartReply(CloseDoubaoSmartReplyRequest r1);

    @SdkCall(50113)
    RucketJob<PullDoubaoChatterResponse> getDoubaoChatter(PullDoubaoChatterRequest r1);

    @SdkPush(4157)
    RucketJob<PushUploadResourceStatus> pushUploadResourceStatus();

    @SdkCall(50508)
    RucketJob<TransformMarkdownToRichTextResponse> transformMarkdownToRichText(TransformMarkdownToRichTextRequest r1);

    @SdkCall(4159)
    RucketJob<UploadResourceResponse> uploadResource(UploadResourceRequest r1);
}
