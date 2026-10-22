package com.ss.android.lark.profile_office.userprofile;

import com.bytedance.lark.pb.contact.v2.GetDoubaoProfileRequest;
import com.bytedance.lark.pb.contact.v2.GetDoubaoProfileResponse;
import com.bytedance.lark.pb.contact.v2.GetUserProfileRequest;
import com.bytedance.lark.pb.contact.v2.GetUserProfileResponse;
import com.bytedance.lark.pb.contact.v2.UpdateDoubaoInfoRequest;
import com.bytedance.lark.pb.contact.v2.UpdateDoubaoInfoResponse;
import com.larksuite.rucket.impl.sdkimpl.annotation.SdkCall;
import com.larksuite.rucket.job.RucketJob;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface b {
    @SdkCall(50107)
    RucketJob<GetDoubaoProfileResponse> getOfficeProfile(GetDoubaoProfileRequest r1);

    @SdkCall(50100)
    RucketJob<GetUserProfileResponse> getUserProfile(GetUserProfileRequest r1);

    @SdkCall(50108)
    RucketJob<UpdateDoubaoInfoResponse> updateDoubaoInfo(UpdateDoubaoInfoRequest r1);
}
