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
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class c extends XCoreIDLBridgeMethod<b, InterfaceC0135c> {

    @XBridgeModelExtension
    public static final Map<String, Object> c = null;

    @XBridgeMethodName(name = "ec.readPerfSession", params = {com.bytedance.android.ec.core.event.a.KEY_SESSION_ID, "stage"}, results = {"common", "stages"})
    public final String a;

    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access b;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = com.bytedance.android.ec.core.event.a.KEY_SESSION_ID, required = true)
        String getSessionId();

        @XBridgeParamField(isGetter = true, keyPath = "stage", required = false)
        String getStage();
    }

    /* JADX INFO: renamed from: com.bytedance.android.ec.core.hybrid.bridges.c$c, reason: collision with other inner class name */
    @XBridgeResultModel
    public interface InterfaceC0135c extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "common", required = false)
        Map<String, Object> getCommon();

        @XBridgeParamField(isGetter = true, keyPath = "stages", required = false)
        List<Object> getStages();

        @XBridgeParamField(isGetter = false, keyPath = "common", required = false)
        void setCommon(Map<String, ? extends Object> r1);

        @XBridgeParamField(isGetter = false, keyPath = "stages", required = false)
        void setStages(List<? extends Object> r1);
    }

    static {
        c = MapsKt.mapOf(TuplesKt.to("TicketID", "36946"));
    }

    public c() {
        this.a = "ec.readPerfSession";
        this.b = IDLXBridgeMethod.Access.PRIVATE;
    }

    public final IDLXBridgeMethod.Access getAccess() {
        return this.b;
    }

    public final String getName() {
        return this.a;
    }
}
