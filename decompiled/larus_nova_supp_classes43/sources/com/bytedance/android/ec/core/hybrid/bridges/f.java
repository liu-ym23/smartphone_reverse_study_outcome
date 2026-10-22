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
public abstract class f extends XCoreIDLBridgeMethod<b, c> {

    @XBridgeModelExtension
    public static final Map<String, Object> c = null;

    @XBridgeMethodName(name = "mall.deliveryRecord", params = {"sessionID", "actionType", "isSuccess", "deliveryRecord", "timestamp", "deliveryStage"}, results = {"deliveryInfo"})
    public final String a;

    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access b;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "actionType", required = true)
        String getActionType();

        @XBridgeParamField(isGetter = true, keyPath = "deliveryRecord", required = false)
        Object getDeliveryRecord();

        @XBridgeParamField(isGetter = true, keyPath = "deliveryStage", required = false)
        String getDeliveryStage();

        @XBridgeParamField(isGetter = true, keyPath = "sessionID", required = true)
        String getSessionID();

        @XBridgeParamField(isGetter = true, keyPath = "timestamp", required = false)
        Long getTimestamp();

        @XBridgeParamField(isGetter = true, keyPath = "isSuccess", required = false)
        Boolean isSuccess();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "deliveryInfo", required = false)
        Object getDeliveryInfo();

        @XBridgeParamField(isGetter = false, keyPath = "deliveryInfo", required = false)
        void setDeliveryInfo(Object r1);
    }

    static {
        c = MapsKt.mapOf(TuplesKt.to("TicketID", "35868"));
    }

    public f() {
        this.a = "mall.deliveryRecord";
        this.b = IDLXBridgeMethod.Access.PRIVATE;
    }

    public final IDLXBridgeMethod.Access getAccess() {
        return this.b;
    }

    public final String getName() {
        return this.a;
    }
}
