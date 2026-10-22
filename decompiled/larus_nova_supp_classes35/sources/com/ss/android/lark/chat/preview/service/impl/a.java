package com.ss.android.lark.chat.preview.service.impl;

import com.bytedance.lark.pb.url.v1.DeletePreviewsByIdsRequest;
import com.bytedance.lark.pb.url.v1.DeletePreviewsByIdsResponse;
import com.bytedance.lark.pb.url.v1.GetInlinePreviewRequest;
import com.bytedance.lark.pb.url.v1.GetInlinePreviewResponse;
import com.bytedance.lark.pb.url.v1.GetPreviewByHangPointsRequest;
import com.bytedance.lark.pb.url.v1.GetPreviewByHangPointsResponse;
import com.bytedance.lark.pb.url.v1.GetPreviewRequest;
import com.bytedance.lark.pb.url.v1.GetPreviewResponse;
import com.bytedance.lark.pb.url.v1.GetTempPreviewByBatchRequest;
import com.bytedance.lark.pb.url.v1.GetTempPreviewByBatchResponse;
import com.bytedance.lark.pb.url.v1.GetTempPreviewRequest;
import com.bytedance.lark.pb.url.v1.GetTempPreviewResponse;
import com.larksuite.rucket.impl.sdkimpl.annotation.SdkCall;
import com.larksuite.rucket.job.RucketJob;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface a {
    @SdkCall(3847)
    RucketJob<DeletePreviewsByIdsResponse> deletePreviewsByIds(DeletePreviewsByIdsRequest r1);

    @SdkCall(3841)
    RucketJob<GetInlinePreviewResponse> getInlinePreview(GetInlinePreviewRequest r1);

    @SdkCall(3845)
    RucketJob<GetPreviewByHangPointsResponse> getPreviewByHangPoints(GetPreviewByHangPointsRequest r1);

    @SdkCall(3842)
    RucketJob<GetPreviewResponse> getPreviewEntity(GetPreviewRequest r1);

    @SdkCall(3840)
    RucketJob<GetTempPreviewResponse> getTempPreview(GetTempPreviewRequest r1);

    @SdkCall(3846)
    RucketJob<GetTempPreviewByBatchResponse> getTempPreviewByBatch(GetTempPreviewByBatchRequest r1);
}
