package com.bytedance.android.ec.core.hybrid.bridges;

import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeModelExtension;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgePermission;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class e extends XCoreIDLBridgeMethod<b, c> {

    @XBridgeModelExtension
    public static final Map<String, Object> c = null;

    @XBridgeMethodName(name = "ec.writePerfSession", params = {com.bytedance.android.ec.core.event.a.KEY_SESSION_ID, "stage", "stage_type", "timestamp", "stage_data"})
    public final String a;

    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access b;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = com.bytedance.android.ec.core.event.a.KEY_SESSION_ID, required = true)
        String getSessionId();

        @XBridgeParamField(isGetter = true, keyPath = "stage", required = true)
        String getStage();

        @XBridgeParamField(isGetter = true, keyPath = "stage_data", required = true)
        Map<String, Object> getStageData();

        @XBridgeParamField(isGetter = true, keyPath = "stage_type", required = false)
        String getStageType();

        @XBridgeParamField(isGetter = true, keyPath = "timestamp", required = false)
        String getTimestamp();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
    }

    static {
        c = MapsKt.mapOf(TuplesKt.to("TicketID", "36928"));
    }

    public e() {
        this.a = "ec.writePerfSession";
        this.b = IDLXBridgeMethod.Access.PRIVATE;
    }

    public final IDLXBridgeMethod.Access getAccess() {
        return this.b;
    }

    public final String getName() {
        return this.a;
    }
}
