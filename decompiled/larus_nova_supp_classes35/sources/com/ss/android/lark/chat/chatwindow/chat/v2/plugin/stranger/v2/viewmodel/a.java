package com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v2.viewmodel;

import com.bytedance.lark.pb.contact.v2.GetUserBlockStatusRequest;
import com.bytedance.lark.pb.contact.v2.GetUserBlockStatusResponse;
import com.bytedance.lark.pb.contact.v2.PushUserBlockStatusChangeEvent;
import com.bytedance.lark.pb.im.v1.GetCanSetStrangerRequest;
import com.bytedance.lark.pb.im.v1.GetCanSetStrangerResponse;
import com.bytedance.lark.pb.im.v1.GetUserStrangerRelationRequest;
import com.bytedance.lark.pb.im.v1.GetUserStrangerRelationResponse;
import com.bytedance.lark.pb.im.v1.PushUserStrangerRelation;
import com.bytedance.lark.pb.settings.v1.GetUniversalUserSettingRequest;
import com.bytedance.lark.pb.settings.v1.GetUniversalUserSettingResponse;
import com.bytedance.lark.pb.settings.v1.PushUniversalUserSetting;
import com.larksuite.rucket.impl.sdkimpl.annotation.SdkCall;
import com.larksuite.rucket.impl.sdkimpl.annotation.SdkPush;
import com.larksuite.rucket.job.RucketJob;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface a {
    @SdkCall(1104007)
    RucketJob<GetCanSetStrangerResponse> fetchCanSetStranger(GetCanSetStrangerRequest r1);

    @SdkCall(110328)
    RucketJob<GetUserBlockStatusResponse> fetchUserBlockStatus(GetUserBlockStatusRequest r1);

    @SdkCall(4301)
    RucketJob<GetUniversalUserSettingResponse> fetchUserStrangerRelationSetting(GetUniversalUserSettingRequest r1);

    @SdkCall(1104004)
    RucketJob<GetUserStrangerRelationResponse> getUserStrangerRelation(GetUserStrangerRelationRequest r1);

    @SdkPush(110333)
    RucketJob<PushUserBlockStatusChangeEvent> pushUserBlockStatus();

    @SdkPush(1104006)
    RucketJob<PushUserStrangerRelation> pushUserStrangerRelation();

    @SdkPush(4302)
    RucketJob<PushUniversalUserSetting> pushUserStrangerRelationSetting();
}
