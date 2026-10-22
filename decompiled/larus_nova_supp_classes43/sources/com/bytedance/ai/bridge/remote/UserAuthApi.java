package com.bytedance.ai.bridge.remote;

import com.bytedance.ai.bridge.remote.model.BatchGetAppMetaRequest;
import com.bytedance.ai.bridge.remote.model.BatchGetAppMetaResponse;
import com.bytedance.ai.bridge.remote.model.CheckPrivacyOrLoginStatusRequest;
import com.bytedance.ai.bridge.remote.model.CheckPrivacyOrLoginStatusResponse;
import com.bytedance.ai.bridge.remote.model.ExchangeCodeRequest;
import com.bytedance.ai.bridge.remote.model.ExchangeCodeResponse;
import com.bytedance.ai.bridge.remote.model.FetchDomainPolicyResponse;
import com.bytedance.ai.bridge.remote.model.GetUserAppsPermissionDetailRequest;
import com.bytedance.ai.bridge.remote.model.GetUserAppsPermissionDetailResponse;
import com.bytedance.ai.bridge.remote.model.LoginCodeResponse;
import com.bytedance.ai.bridge.remote.model.PhoneMaskRequest;
import com.bytedance.ai.bridge.remote.model.PhoneMaskResponse;
import com.bytedance.ai.bridge.remote.model.PostUserAppsPermissionRequest;
import com.bytedance.ai.bridge.remote.model.PostUserAppsPermissionResponse;
import com.bytedance.ai.bridge.remote.model.PrivacyAcceptRequest;
import com.bytedance.ai.bridge.remote.model.PrivacyAcceptResponse;
import com.bytedance.ai.bridge.remote.model.PrivacyCheckRequest;
import com.bytedance.ai.bridge.remote.model.PrivacyCheckResponse;
import com.bytedance.ai.bridge.remote.model.UploadModelContextRequest;
import com.bytedance.ai.bridge.remote.model.UploadModelContextResponse;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Headers;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Path;
import kotlin.Metadata;
import p4.f;
import p4.g;
import p4.k;
import p4.l;
import p4.m;
import p4.n;
import p4.o;
import p4.p;
import p4.s;
import p4.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'J\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\tH'J\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\fH'JB\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\b\b\u0001\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u0011\u001a\u00020\u00102\b\b\u0001\u0010\u0012\u001a\u00020\u00102\b\b\u0001\u0010\u0013\u001a\u00020\u00102\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u0010H'J\u0018\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0017H'J\u0018\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u001aH'J\u0018\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u001dH'J\u0018\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00032\b\b\u0001\u0010\u0005\u001a\u00020 H'J\u0018\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u00032\b\b\u0001\u0010\u0005\u001a\u00020#H'J\u0018\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u00032\b\b\u0001\u0010\u0005\u001a\u00020&H'J\u0018\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u00032\b\b\u0001\u0010\u0005\u001a\u00020)H'J\u0018\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u00032\b\b\u0001\u0010\u0005\u001a\u00020,H'J\u0018\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\u00032\b\b\u0001\u0010\u0005\u001a\u00020/H'J\u0018\u00100\u001a\b\u0012\u0004\u0012\u0002010\u00032\b\b\u0001\u0010\u0005\u001a\u000202H'J\u0018\u00103\u001a\b\u0012\u0004\u0012\u00020+0\u00032\b\b\u0001\u0010\u0005\u001a\u000204H'J\u0018\u00105\u001a\b\u0012\u0004\u0012\u0002060\u00032\b\b\u0001\u0010\u0005\u001a\u000207H'J\u0018\u00108\u001a\b\u0012\u0004\u0012\u0002090\u00032\b\b\u0001\u0010:\u001a\u00020\u0010H'¨\u0006;"}, d2 = {"Lcom/bytedance/ai/bridge/remote/UserAuthApi;", "", "checkPrivacy", "Lcom/bytedance/retrofit2/Call;", "Lcom/bytedance/ai/bridge/remote/model/PrivacyCheckResponse;", "request", "Lcom/bytedance/ai/bridge/remote/model/PrivacyCheckRequest;", "acceptPrivacy", "Lcom/bytedance/ai/bridge/remote/model/PrivacyAcceptResponse;", "Lcom/bytedance/ai/bridge/remote/model/PrivacyAcceptRequest;", "getPhoneMask", "Lcom/bytedance/ai/bridge/remote/model/PhoneMaskResponse;", "Lcom/bytedance/ai/bridge/remote/model/PhoneMaskRequest;", "getLoginCode", "Lcom/bytedance/ai/bridge/remote/model/LoginCodeResponse;", "clientKey", "", "aid", "scope", "source", "exchangeType", "exchangeCode", "Lcom/bytedance/ai/bridge/remote/model/ExchangeCodeResponse;", "Lcom/bytedance/ai/bridge/remote/model/ExchangeCodeRequest;", "batchGetAppletAppMeta", "Lcom/bytedance/ai/bridge/remote/model/BatchGetAppMetaResponse;", "Lcom/bytedance/ai/bridge/remote/model/BatchGetAppMetaRequest;", "getUserAppsPermissionDetail", "Lcom/bytedance/ai/bridge/remote/model/GetUserAppsPermissionDetailResponse;", "Lcom/bytedance/ai/bridge/remote/model/GetUserAppsPermissionDetailRequest;", "postUserAppsPermission", "Lcom/bytedance/ai/bridge/remote/model/PostUserAppsPermissionResponse;", "Lcom/bytedance/ai/bridge/remote/model/PostUserAppsPermissionRequest;", "checkPrivacyOrLoginStatus", "Lcom/bytedance/ai/bridge/remote/model/CheckPrivacyOrLoginStatusResponse;", "Lcom/bytedance/ai/bridge/remote/model/CheckPrivacyOrLoginStatusRequest;", "getAwemeCommonLoginInfo", "Lcom/bytedance/ai/bridge/remote/model/GetAwemeCommonLoginInfoResponse;", "Lcom/bytedance/ai/bridge/remote/model/GetAwemeCommonLoginInfoRequest;", "uploadModelContext", "Lcom/bytedance/ai/bridge/remote/model/UploadModelContextResponse;", "Lcom/bytedance/ai/bridge/remote/model/UploadModelContextRequest;", "uploadScreenshot", "Lcom/bytedance/ai/bridge/remote/model/BaseApiResponse;", "Lcom/bytedance/ai/bridge/remote/model/UploadScreenshotRequest;", "createRemoteTask", "Lcom/bytedance/ai/bridge/remote/model/CreateRemoteTaskResponse;", "Lcom/bytedance/ai/bridge/remote/model/CreateRemoteTaskRequest;", "getMessageInfoByCardId", "Lcom/bytedance/ai/bridge/remote/model/GetMessageInfoByCardIdResponse;", "Lcom/bytedance/ai/bridge/remote/model/GetMessageInfoByCardIdRequest;", "updateWidgetMessageData", "Lcom/bytedance/ai/bridge/remote/model/UpdateWidgetMessageDataRequest;", "callMcpTool", "Lcom/bytedance/ai/bridge/remote/model/CallMcpToolResponse;", "Lcom/bytedance/ai/bridge/remote/model/CallMcpToolRequest;", "fetchDomainPolicy", "Lcom/bytedance/ai/bridge/remote/model/FetchDomainPolicyResponse;", "appKey", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface UserAuthApi {
    @POST("/user/privacy/accept")
    Call<PrivacyAcceptResponse> acceptPrivacy(@Body PrivacyAcceptRequest r1);

    @Headers({"Content-Type: application/json"})
    @POST("/api/v1/app_meta/batch_get")
    Call<BatchGetAppMetaResponse> batchGetAppletAppMeta(@Body BatchGetAppMetaRequest r1);

    @POST("/message/card/call_mcp_tool")
    Call<g> callMcpTool(@Body f r1);

    @POST("/user/privacy/check")
    Call<PrivacyCheckResponse> checkPrivacy(@Body PrivacyCheckRequest r1);

    @POST("/user/privacy_login/check")
    Call<CheckPrivacyOrLoginStatusResponse> checkPrivacyOrLoginStatus(@Body CheckPrivacyOrLoginStatusRequest r1);

    @POST("/task/create_remote_task")
    Call<l> createRemoteTask(@Body k r1);

    @POST("/oauth/token")
    Call<ExchangeCodeResponse> exchangeCode(@Body ExchangeCodeRequest r1);

    @GET("/developer/public/api/apps/{app_key}/domain/fetch")
    Call<FetchDomainPolicyResponse> fetchDomainPolicy(@Path("app_key") String r1);

    @Headers({"Content-Type: application/json"})
    @POST("/auth/app/get_aweme_common_login_info")
    Call<n> getAwemeCommonLoginInfo(@Body m r1);

    @FormUrlEncoded
    @POST("/passport/open/auth/")
    Call<LoginCodeResponse> getLoginCode(@Field("client_key") String r1, @Field("aid") String r10, @Field("scope") String r11, @Field("source") String r12, @Field("exchange_type") String r13);

    @POST("/message/card/get_msg_by_cardid")
    Call<p> getMessageInfoByCardId(@Body o r1);

    @POST("/user/phone_mask")
    Call<PhoneMaskResponse> getPhoneMask(@Body PhoneMaskRequest r1);

    @POST("/user/miniapp_permission/detail")
    Call<GetUserAppsPermissionDetailResponse> getUserAppsPermissionDetail(@Body GetUserAppsPermissionDetailRequest r1);

    @POST("/user/miniapp_permission/post")
    Call<PostUserAppsPermissionResponse> postUserAppsPermission(@Body PostUserAppsPermissionRequest r1);

    @POST("/message/card/update_card")
    Call<p4.a> updateWidgetMessageData(@Body s r1);

    @POST("/alice/mini_program/upload_context_event")
    Call<UploadModelContextResponse> uploadModelContext(@Body UploadModelContextRequest r1);

    @POST("/alice/mini_program/upload_screenshot")
    Call<p4.a> uploadScreenshot(@Body t r1);
}
