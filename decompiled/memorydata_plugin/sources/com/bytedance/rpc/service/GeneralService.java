package com.bytedance.rpc.service;

import com.bytedance.rpc.RpcInvokeContext;
import com.bytedance.rpc.RpcService;
import com.bytedance.rpc.annotation.RpcOperation;
import com.bytedance.rpc.annotation.RpcPath;
import com.bytedance.rpc.annotation.RpcSerializer;
import com.bytedance.rpc.callback.RpcCallback;
import com.bytedance.rpc.serialize.SerializeType;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class GeneralService {

    private interface GeneralApi {
        @RpcOperation("$POST {url}")
        @RpcSerializer(SerializeType.FORM)
        Object form(@RpcPath("url") String r1, Object r2, Class<?> r3);

        @RpcOperation("$POST {url}")
        @RpcSerializer(SerializeType.FORM)
        void form(@RpcPath("url") String r1, Object r2, RpcCallback<?> r3);

        @RpcOperation("$GET {url}")
        Object get(@RpcPath("url") String r1, Object r2, Class<?> r3);

        @RpcOperation("$GET {url}")
        void get(@RpcPath("url") String r1, Object r2, RpcCallback<?> r3);

        @RpcOperation("$POST {url}")
        Object post(@RpcPath("url") String r1, Object r2, Class<?> r3);

        @RpcOperation("$POST {url}")
        void post(@RpcPath("url") String r1, Object r2, RpcCallback<?> r3);
    }

    public GeneralService() {
    }

    public static <T> T form(String r3, Object r4, Class<T> r5) {
        return (T) ((GeneralApi) ZeusTransformUtils.preCheckCast(RpcService.getProxy(GeneralApi.class), GeneralApi.class, "com.obric.memorydata.plugin")).form(r3, r4, r5);
    }

    public static <T> void form(String r3, Object r4, RpcCallback<T> r5) {
        RpcCallback<?> r6 = (RpcCallback) ZeusTransformUtils.wrapperContextForParams(r5, RpcCallback.class, "com.obric.memorydata.plugin");
        ((GeneralApi) ZeusTransformUtils.preCheckCast(RpcService.getProxy(GeneralApi.class), GeneralApi.class, "com.obric.memorydata.plugin")).form(r3, r4, r6);
    }

    public static <T> T get(String r3, Object r4, Class<T> r5) {
        return (T) ((GeneralApi) ZeusTransformUtils.preCheckCast(RpcService.getProxy(GeneralApi.class), GeneralApi.class, "com.obric.memorydata.plugin")).get(r3, r4, r5);
    }

    public static <T> void get(String r3, Object r4, RpcCallback<T> r5) {
        RpcCallback<?> r6 = (RpcCallback) ZeusTransformUtils.wrapperContextForParams(r5, RpcCallback.class, "com.obric.memorydata.plugin");
        ((GeneralApi) ZeusTransformUtils.preCheckCast(RpcService.getProxy(GeneralApi.class), GeneralApi.class, "com.obric.memorydata.plugin")).get(r3, r4, r6);
    }

    public static RpcInvokeContext getRpcInvokeContext() {
        return RpcService.getRpcInvokeContext(GeneralApi.class);
    }

    public static <T> T post(String r3, Object r4, Class<T> r5) {
        return (T) ((GeneralApi) ZeusTransformUtils.preCheckCast(RpcService.getProxy(GeneralApi.class), GeneralApi.class, "com.obric.memorydata.plugin")).post(r3, r4, r5);
    }

    public static <T> void post(String r3, Object r4, RpcCallback<T> r5) {
        RpcCallback<?> r6 = (RpcCallback) ZeusTransformUtils.wrapperContextForParams(r5, RpcCallback.class, "com.obric.memorydata.plugin");
        ((GeneralApi) ZeusTransformUtils.preCheckCast(RpcService.getProxy(GeneralApi.class), GeneralApi.class, "com.obric.memorydata.plugin")).post(r3, r4, r6);
    }
}
