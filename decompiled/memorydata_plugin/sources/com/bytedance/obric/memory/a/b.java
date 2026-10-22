package com.bytedance.obric.memory.a;

import com.bytedance.obric.memory.model.WeatherInfoReq;
import com.bytedance.obric.memory.model.WeatherInfoResp;
import com.bytedance.rpc.RpcService;
import com.bytedance.rpc.annotation.RpcOperation;
import com.bytedance.rpc.annotation.RpcParams;
import com.bytedance.rpc.annotation.RpcSerializer;
import com.bytedance.rpc.serialize.SerializeType;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    private interface a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Class f2966a = null;

        static {
            f2966a = SerializeType.class;
        }

        @RpcOperation("$POST /mcp_hub_proxy/api/v1/weather/info")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        WeatherInfoResp a(WeatherInfoReq r1);
    }

    private static a a() {
        return (a) ZeusTransformUtils.preCheckCast(RpcService.getProxy(a.class), a.class, "com.obric.memorydata.plugin");
    }

    public static WeatherInfoResp a(WeatherInfoReq r1) {
        return a().a(r1);
    }
}
