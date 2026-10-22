package ofb;

import com.bytedance.lark.pb.media.v1.CancelExtractPackagePollRequest;
import com.bytedance.lark.pb.media.v1.CancelExtractPackagePollResponse;
import com.bytedance.lark.pb.media.v1.ExtractPackageRequest;
import com.bytedance.lark.pb.media.v1.ExtractPackageResponse;
import com.bytedance.lark.pb.media.v1.PushExtractPackageStatus;
import com.larksuite.rucket.impl.sdkimpl.annotation.SdkCall;
import com.larksuite.rucket.impl.sdkimpl.annotation.SdkPush;
import com.larksuite.rucket.job.RucketJob;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface c {
    @SdkCall(4156)
    RucketJob<CancelExtractPackagePollResponse> cancelExtractPackagePoll(CancelExtractPackagePollRequest r1);

    @SdkPush(4155)
    RucketJob<PushExtractPackageStatus> pushExtractPackageStatus();

    @SdkCall(4154)
    RucketJob<ExtractPackageResponse> sendExtractPackageRequest(ExtractPackageRequest r1);
}
