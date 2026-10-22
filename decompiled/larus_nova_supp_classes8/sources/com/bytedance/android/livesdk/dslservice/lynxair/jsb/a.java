package com.bytedance.android.livesdk.dslservice.lynxair.jsb;

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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public abstract class a extends XCoreIDLBridgeMethod<b, c> {

    @XBridgeModelExtension
    public static final Map<String, Object> c = null;

    @XBridgeMethodName(name = "liveDSLAction", params = {"type", "fields"})
    public final String a;

    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access b;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.dslservice.lynxair.jsb.a$a, reason: collision with other inner class name */
    public static final class C0301a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "fields", required = true)
        Map<String, Object> getFields();

        @XBridgeParamField(isGetter = true, keyPath = "type", required = true)
        String getType();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
    }

    static {
        c = MapsKt.mapOf(TuplesKt.to("TicketID", "30831"));
    }

    public a() {
        this.a = "liveDSLAction";
        this.b = IDLXBridgeMethod.Access.PRIVATE;
    }

    public final IDLXBridgeMethod.Access getAccess() {
        return this.b;
    }

    public final String getName() {
        return this.a;
    }
}
