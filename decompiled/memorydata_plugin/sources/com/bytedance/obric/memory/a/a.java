package com.bytedance.obric.memory.a;

import com.bytedance.obric.memory.model.AddressInputRequest;
import com.bytedance.obric.memory.model.AddressInputResponse;
import com.bytedance.obric.memory.model.BatchSyncOMemoryRequest;
import com.bytedance.obric.memory.model.BatchSyncOMemoryResponse;
import com.bytedance.obric.memory.model.ClearMemoryRequest;
import com.bytedance.obric.memory.model.ClearMemoryResponse;
import com.bytedance.obric.memory.model.DelMemoryRequest;
import com.bytedance.obric.memory.model.DelMemoryResponse;
import com.bytedance.obric.memory.model.GetImageUploadTokenRequest;
import com.bytedance.obric.memory.model.GetImageUploadTokenResponse;
import com.bytedance.obric.memory.model.GetLocationRequest;
import com.bytedance.obric.memory.model.GetLocationResponse;
import com.bytedance.obric.memory.model.GetUserProfileListRequest;
import com.bytedance.obric.memory.model.GetUserProfileListResponse;
import com.bytedance.obric.memory.model.GetUserProfileMemoryListRequest;
import com.bytedance.obric.memory.model.GetUserProfileMemoryListResponse;
import com.bytedance.obric.memory.model.GetUserTodoListRequest;
import com.bytedance.obric.memory.model.GetUserTodoListResponse;
import com.bytedance.obric.memory.model.ProactiveAgentUserFeedbackReq;
import com.bytedance.obric.memory.model.ProactiveAgentUserFeedbackResp;
import com.bytedance.obric.memory.model.UpdateOMemorySettingsRequest;
import com.bytedance.obric.memory.model.UpdateOMemorySettingsResponse;
import com.bytedance.rpc.RpcService;
import com.bytedance.rpc.annotation.RpcOperation;
import com.bytedance.rpc.annotation.RpcParams;
import com.bytedance.rpc.annotation.RpcSerializer;
import com.bytedance.rpc.callback.RpcCallback;
import com.bytedance.rpc.serialize.SerializeType;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: com.bytedance.obric.memory.a.a$a, reason: collision with other inner class name */
    private interface InterfaceC0148a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Class f2965a = null;

        static {
            f2965a = SerializeType.class;
        }

        @RpcOperation("$POST /explore/poi/address_input")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        AddressInputResponse a(AddressInputRequest r1);

        @RpcOperation("$POST /explore/api/o_memory/batch_sync")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        BatchSyncOMemoryResponse a(BatchSyncOMemoryRequest r1);

        @RpcOperation("$POST /explore/clear_memory")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        ClearMemoryResponse a(ClearMemoryRequest r1);

        @RpcOperation("$POST /explore/del_memory")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        DelMemoryResponse a(DelMemoryRequest r1);

        @RpcOperation("$POST /explore/upload_auth")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        GetImageUploadTokenResponse a(GetImageUploadTokenRequest r1);

        @RpcOperation("$POST /explore/location")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        GetLocationResponse a(GetLocationRequest r1);

        @RpcOperation("$POST /explore/list/user_profile")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        GetUserProfileListResponse a(GetUserProfileListRequest r1);

        @RpcOperation("$POST /explore/list/user_profile_memory")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        GetUserProfileMemoryListResponse a(GetUserProfileMemoryListRequest r1);

        @RpcOperation("$POST /explore/list/user_todo")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        GetUserTodoListResponse a(GetUserTodoListRequest r1);

        @RpcOperation("$POST /explore/proactive/user_feedback")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        ProactiveAgentUserFeedbackResp a(ProactiveAgentUserFeedbackReq r1);

        @RpcOperation("$POST /explore/api/o_memory/settings/update")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        UpdateOMemorySettingsResponse a(UpdateOMemorySettingsRequest r1);

        @RpcOperation("$POST /explore/location")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        void a(GetLocationRequest r1, RpcCallback<GetLocationResponse> r2);
    }

    private static InterfaceC0148a a() {
        return (InterfaceC0148a) ZeusTransformUtils.preCheckCast(RpcService.getProxy(InterfaceC0148a.class), InterfaceC0148a.class, "com.obric.memorydata.plugin");
    }

    public static AddressInputResponse a(AddressInputRequest r1) {
        return a().a(r1);
    }

    public static BatchSyncOMemoryResponse a(BatchSyncOMemoryRequest r1) {
        return a().a(r1);
    }

    public static ClearMemoryResponse a(ClearMemoryRequest r1) {
        return a().a(r1);
    }

    public static DelMemoryResponse a(DelMemoryRequest r1) {
        return a().a(r1);
    }

    public static GetImageUploadTokenResponse a(GetImageUploadTokenRequest r1) {
        return a().a(r1);
    }

    public static GetLocationResponse a(GetLocationRequest r1) {
        return a().a(r1);
    }

    public static GetUserProfileListResponse a(GetUserProfileListRequest r1) {
        return a().a(r1);
    }

    public static GetUserProfileMemoryListResponse a(GetUserProfileMemoryListRequest r1) {
        return a().a(r1);
    }

    public static GetUserTodoListResponse a(GetUserTodoListRequest r1) {
        return a().a(r1);
    }

    public static ProactiveAgentUserFeedbackResp a(ProactiveAgentUserFeedbackReq r1) {
        return a().a(r1);
    }

    public static UpdateOMemorySettingsResponse a(UpdateOMemorySettingsRequest r1) {
        return a().a(r1);
    }

    public static void a(GetLocationRequest r2, RpcCallback<GetLocationResponse> r3) {
        RpcCallback<GetLocationResponse> r4 = (RpcCallback) ZeusTransformUtils.wrapperContextForParams(r3, RpcCallback.class, "com.obric.memorydata.plugin");
        a().a(r2, r4);
    }
}
