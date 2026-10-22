package m6b;

import com.bytedance.lark.pb.im.v1.GetMessageFoldDetailRequest;
import com.bytedance.lark.pb.im.v1.GetMessageFoldFollowListRequest;
import com.bytedance.lark.pb.im.v1.GetMessageFoldFollowListResponse;
import com.larksuite.rucket.impl.sdkimpl.annotation.SdkCall;
import com.larksuite.rucket.impl.serverimpl.annotation.ServerCall;
import com.larksuite.rucket.job.RucketJob;
import com.ss.android.lark.pb.messages.PutMessageFoldFollowRequest;
import com.ss.android.lark.pb.messages.PutMessageFoldFollowResponse;
import com.ss.android.lark.pb.messages.RecallMessageFoldRequest;
import com.ss.android.lark.pb.messages.RecallMessageFoldResponse;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface i {
    @SdkCall(2721)
    RucketJob<GetMessageFoldFollowListResponse> getFoldDetailById(GetMessageFoldDetailRequest r1);

    @SdkCall(2722)
    RucketJob<GetMessageFoldFollowListResponse> getFoldFollowList(GetMessageFoldFollowListRequest r1);

    @ServerCall(900018)
    RucketJob<PutMessageFoldFollowResponse> putMessageFoldFollow(PutMessageFoldFollowRequest r1);

    @ServerCall(900020)
    RucketJob<RecallMessageFoldResponse> recallFoldMessage(RecallMessageFoldRequest r1);
}
