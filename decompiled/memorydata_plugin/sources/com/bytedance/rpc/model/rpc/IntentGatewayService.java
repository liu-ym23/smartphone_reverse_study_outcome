package com.bytedance.rpc.model.rpc;

import com.bytedance.rpc.RpcService;
import com.bytedance.rpc.annotation.RpcOperation;
import com.bytedance.rpc.annotation.RpcParams;
import com.bytedance.rpc.annotation.RpcSerializer;
import com.bytedance.rpc.callback.RpcCallback;
import com.bytedance.rpc.model.IntentRequest;
import com.bytedance.rpc.model.IntentResponse;
import com.bytedance.rpc.model.ListAppCategoryMsgReq;
import com.bytedance.rpc.model.ListAppCategoryMsgResp;
import com.bytedance.rpc.model.POISearchReq;
import com.bytedance.rpc.model.POISearchResp;
import com.bytedance.rpc.serialize.SerializeType;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class IntentGatewayService {

    private interface IntentGatewayServiceApi {
        public static final Class clazz = null;

        static {
            clazz = SerializeType.class;
        }

        @RpcOperation("$POST /intent/predict")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        void intentAsync(IntentRequest r1, RpcCallback<IntentResponse> r2);

        @RpcOperation("$POST /intent/predict")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        IntentResponse intentSync(IntentRequest r1);

        @RpcOperation("$POST /intent/app_category/list")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        void listAppCategoryMsgAsync(ListAppCategoryMsgReq r1, RpcCallback<ListAppCategoryMsgResp> r2);

        @RpcOperation("$POST /intent/app_category/list")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        ListAppCategoryMsgResp listAppCategoryMsgSync(ListAppCategoryMsgReq r1);

        @RpcOperation("$POST /intent/poi/search")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        void pOISearchAsync(POISearchReq r1, RpcCallback<POISearchResp> r2);

        @RpcOperation("$POST /intent/poi/search")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        POISearchResp pOISearchSync(POISearchReq r1);
    }

    public IntentGatewayService() {
    }

    private static IntentGatewayServiceApi getApi() {
        return (IntentGatewayServiceApi) ZeusTransformUtils.preCheckCast(RpcService.getProxy(IntentGatewayServiceApi.class), IntentGatewayServiceApi.class, "com.obric.memorydata.plugin");
    }

    public static Class<?> getApiClass() {
        return IntentGatewayServiceApi.class;
    }

    public static void intentAsync(IntentRequest r2, RpcCallback<IntentResponse> r3) {
        RpcCallback<IntentResponse> r4 = (RpcCallback) ZeusTransformUtils.wrapperContextForParams(r3, RpcCallback.class, "com.obric.memorydata.plugin");
        getApi().intentAsync(r2, r4);
    }

    public static IntentResponse intentSync(IntentRequest r1) {
        return getApi().intentSync(r1);
    }

    public static void listAppCategoryMsgAsync(ListAppCategoryMsgReq r2, RpcCallback<ListAppCategoryMsgResp> r3) {
        RpcCallback<ListAppCategoryMsgResp> r4 = (RpcCallback) ZeusTransformUtils.wrapperContextForParams(r3, RpcCallback.class, "com.obric.memorydata.plugin");
        getApi().listAppCategoryMsgAsync(r2, r4);
    }

    public static ListAppCategoryMsgResp listAppCategoryMsgSync(ListAppCategoryMsgReq r1) {
        return getApi().listAppCategoryMsgSync(r1);
    }

    public static void pOISearchAsync(POISearchReq r2, RpcCallback<POISearchResp> r3) {
        RpcCallback<POISearchResp> r4 = (RpcCallback) ZeusTransformUtils.wrapperContextForParams(r3, RpcCallback.class, "com.obric.memorydata.plugin");
        getApi().pOISearchAsync(r2, r4);
    }

    public static POISearchResp pOISearchSync(POISearchReq r1) {
        return getApi().pOISearchSync(r1);
    }
}
