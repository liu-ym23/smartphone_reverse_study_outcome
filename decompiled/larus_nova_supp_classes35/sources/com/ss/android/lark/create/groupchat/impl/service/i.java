package com.ss.android.lark.create.groupchat.impl.service;

import com.bytedance.lark.pb.im.v1.CreateChatRequest;
import com.bytedance.lark.pb.im.v1.CreateChatResponse;
import com.bytedance.lark.pb.im.v1.CreateDepartmentChatRequest;
import com.bytedance.lark.pb.im.v1.CreateDepartmentChatResponse;
import com.larksuite.rucket.impl.sdkimpl.annotation.SdkCall;
import com.larksuite.rucket.impl.serverimpl.annotation.ServerCall;
import com.larksuite.rucket.job.RucketJob;
import com.ss.android.lark.pb.chats.PullChangeGroupMemberAuthorizationRequest;
import com.ss.android.lark.pb.chats.PullChangeGroupMemberAuthorizationResponse;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface i {
    @SdkCall(2153)
    RucketJob<CreateDepartmentChatResponse> createDepartmentChat(CreateDepartmentChatRequest r1);

    @SdkCall(2008)
    RucketJob<CreateChatResponse> createGroupChat(CreateChatRequest r1, Function1<? super com.larksuite.rucket.impl.base.request.b, Unit> r2);

    @ServerCall(405)
    RucketJob<PullChangeGroupMemberAuthorizationResponse> pullCreateGroupAuthorization(PullChangeGroupMemberAuthorizationRequest r1);
}
