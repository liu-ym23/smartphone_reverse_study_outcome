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
public abstract class b extends XCoreIDLBridgeMethod<InterfaceC0134b, c> {

    @XBridgeModelExtension
    public static final Map<String, Object> c = null;

    @XBridgeMethodName(name = "ec.preloadPdpFull", params = {com.bytedance.android.ec.core.event.a.KEY_SCHEMA})
    public final String a;

    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access b;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.ec.core.hybrid.bridges.b$b, reason: collision with other inner class name */
    @XBridgeParamModel
    public interface InterfaceC0134b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = com.bytedance.android.ec.core.event.a.KEY_SCHEMA, required = true)
        String getSchema();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
    }

    static {
        c = MapsKt.mapOf(TuplesKt.to("TicketID", "38778"));
    }

    public b() {
        this.a = "ec.preloadPdpFull";
        this.b = IDLXBridgeMethod.Access.PRIVATE;
    }

    public final IDLXBridgeMethod.Access getAccess() {
        return this.b;
    }

    public final String getName() {
        return this.a;
    }
}
