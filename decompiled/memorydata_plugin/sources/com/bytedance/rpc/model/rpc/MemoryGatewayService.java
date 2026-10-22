package com.bytedance.rpc.model.rpc;

import com.bytedance.rpc.RpcService;
import com.bytedance.rpc.annotation.RpcOperation;
import com.bytedance.rpc.annotation.RpcParams;
import com.bytedance.rpc.annotation.RpcSerializer;
import com.bytedance.rpc.callback.RpcCallback;
import com.bytedance.rpc.model.GetImageUploadTokenRequest;
import com.bytedance.rpc.model.GetImageUploadTokenResponse;
import com.bytedance.rpc.model.UploadMemoryRequest;
import com.bytedance.rpc.model.UploadMemoryResponse;
import com.bytedance.rpc.serialize.SerializeType;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class MemoryGatewayService {

    private interface MemoryGatewayServiceApi {
        public static final Class clazz = null;

        static {
            clazz = SerializeType.class;
        }

        @RpcOperation("$POST /memory/upload_token")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        void getImageUploadTokenAsync(GetImageUploadTokenRequest r1, RpcCallback<GetImageUploadTokenResponse> r2);

        @RpcOperation("$POST /memory/upload_token_doubao")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        void getImageUploadTokenDoubaoAsync(GetImageUploadTokenRequest r1, RpcCallback<GetImageUploadTokenResponse> r2);

        @RpcOperation("$POST /memory/upload_token_doubao")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        GetImageUploadTokenResponse getImageUploadTokenDoubaoSync(GetImageUploadTokenRequest r1);

        @RpcOperation("$POST /memory/upload_token")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        GetImageUploadTokenResponse getImageUploadTokenSync(GetImageUploadTokenRequest r1);

        @RpcOperation("$POST /memory/upload")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        void uploadMemoryAsync(UploadMemoryRequest r1, RpcCallback<UploadMemoryResponse> r2);

        @RpcOperation("$POST /memory/upload")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        UploadMemoryResponse uploadMemorySync(UploadMemoryRequest r1);
    }

    public MemoryGatewayService() {
    }

    private static MemoryGatewayServiceApi getApi() {
        return (MemoryGatewayServiceApi) ZeusTransformUtils.preCheckCast(RpcService.getProxy(MemoryGatewayServiceApi.class), MemoryGatewayServiceApi.class, "com.obric.memorydata.plugin");
    }

    public static Class<?> getApiClass() {
        return MemoryGatewayServiceApi.class;
    }

    public static void getImageUploadTokenAsync(GetImageUploadTokenRequest r2, RpcCallback<GetImageUploadTokenResponse> r3) {
        RpcCallback<GetImageUploadTokenResponse> r4 = (RpcCallback) ZeusTransformUtils.wrapperContextForParams(r3, RpcCallback.class, "com.obric.memorydata.plugin");
        getApi().getImageUploadTokenAsync(r2, r4);
    }

    public static void getImageUploadTokenDoubaoAsync(GetImageUploadTokenRequest r2, RpcCallback<GetImageUploadTokenResponse> r3) {
        RpcCallback<GetImageUploadTokenResponse> r4 = (RpcCallback) ZeusTransformUtils.wrapperContextForParams(r3, RpcCallback.class, "com.obric.memorydata.plugin");
        getApi().getImageUploadTokenDoubaoAsync(r2, r4);
    }

    public static GetImageUploadTokenResponse getImageUploadTokenDoubaoSync(GetImageUploadTokenRequest r1) {
        return getApi().getImageUploadTokenDoubaoSync(r1);
    }

    public static GetImageUploadTokenResponse getImageUploadTokenSync(GetImageUploadTokenRequest r1) {
        return getApi().getImageUploadTokenSync(r1);
    }

    public static void uploadMemoryAsync(UploadMemoryRequest r2, RpcCallback<UploadMemoryResponse> r3) {
        RpcCallback<UploadMemoryResponse> r4 = (RpcCallback) ZeusTransformUtils.wrapperContextForParams(r3, RpcCallback.class, "com.obric.memorydata.plugin");
        getApi().uploadMemoryAsync(r2, r4);
    }

    public static UploadMemoryResponse uploadMemorySync(UploadMemoryRequest r1) {
        return getApi().uploadMemorySync(r1);
    }
}
