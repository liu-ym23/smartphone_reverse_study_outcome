package com.larus.xbridge.custom;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxResourceModule;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@XBridgeMethod(name = "flow.fetchCommonVenuePocketPageData", owner = "daitianji")
public final class d1 extends XCoreIDLBridgeMethod<b, c> {

    @XBridgeMethodName(name = "flow.fetchCommonVenuePocketPageData")
    public final String a;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "biz_scene", required = false)
        Integer getBizScene();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = LynxResourceModule.DATA_KEY, required = true)
        Map<String, Object> getData();

        @XBridgeParamField(isGetter = false, keyPath = LynxResourceModule.DATA_KEY, required = true)
        void setData(Map<String, ? extends Object> r1);
    }

    static {
    }

    public d1() {
        this.a = "flow.fetchCommonVenuePocketPageData";
    }

    public final String getName() {
        return this.a;
    }

    public final void handle(IBDXBridgeContext r9, XBaseParamModel r10, CompletionBlock r11) {
        b r12 = (b) r10;
        Intrinsics.checkNotNullParameter(r9, "bridgeContext");
        Intrinsics.checkNotNullParameter(r12, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r11, "callback");
        FLogger r13 = FLogger.a;
        r13.i("FlowCommonVenueFetchPocketPageData", "[handle] start, currentThread: " + ThreadMethodProxy.currentThread().getName());
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new FlowCommonVenueFetchPocketPageData$handle$1(r12, r11, null), 2, null);
        r13.i("FlowCommonVenueFetchPocketPageData", "[handle] end");
    }
}
