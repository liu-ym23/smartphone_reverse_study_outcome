package com.bytedance.android.ec.core.hybrid.bridges;

import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeModelExtension;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgePermission;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class a extends XCoreIDLBridgeMethod<b, Object> {

    @XBridgeModelExtension
    public static final Map<String, Object> c = null;

    @XBridgeMethodName(name = "ec.anniePrerender", params = {"expiredTime", "strategy", com.bytedance.android.ec.core.event.a.KEY_SCHEMA})
    public final String a;

    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access b;

    /* JADX INFO: renamed from: com.bytedance.android.ec.core.hybrid.bridges.a$a, reason: collision with other inner class name */
    public static final class C0133a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "expiredTime", required = false)
        Number getExpiredTime();

        @XBridgeParamField(isGetter = true, keyPath = com.bytedance.android.ec.core.event.a.KEY_SCHEMA, required = true)
        String getSchema();

        @XBridgeParamField(isGetter = true, keyPath = "strategy", required = true)
        String getStrategy();
    }

    static {
        c = MapsKt.mapOf(TuplesKt.to("TicketID", "28252"));
    }

    public a() {
        this.a = "ec.anniePrerender";
        this.b = IDLXBridgeMethod.Access.PRIVATE;
    }

    public final IDLXBridgeMethod.Access getAccess() {
        return this.b;
    }

    public final String getName() {
        return this.a;
    }
}
