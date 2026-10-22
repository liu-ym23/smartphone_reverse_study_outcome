package com.bytedance.android.live.browser.jsbridge.answer;

import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.DefaultType;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeDefaultValue;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class a extends XCoreIDLBridgeMethod<b, c> {

    @XBridgeModelExtension
    public static final Map<String, Object> c = null;

    @XBridgeMethodName(name = "live.registerMessage", params = {"normalMessageMethod", "streamMessageMethod", "roomId", "uniqueIdPreview"})
    public final String a;

    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access b;

    /* JADX INFO: renamed from: com.bytedance.android.live.browser.jsbridge.answer.a$a, reason: collision with other inner class name */
    public static final class C0109a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "normalMessageMethod", primitiveClassType = String.class, required = false)
        List<String> getNormalMessageMethod();

        @XBridgeParamField(defaultValue = @XBridgeDefaultValue(stringValue = "0", type = DefaultType.STRING), isGetter = true, keyPath = "roomId", required = true)
        String getRoomId();

        @XBridgeParamField(isGetter = true, keyPath = "streamMessageMethod", primitiveClassType = String.class, required = false)
        List<String> getStreamMessageMethod();

        @XBridgeParamField(isGetter = true, keyPath = "uniqueIdPreview", required = false)
        String getUniqueIdPreview();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
    }

    static {
        c = MapsKt.mapOf(TuplesKt.to("TicketID", "38794"));
    }

    public a() {
        this.a = "live.registerMessage";
        this.b = IDLXBridgeMethod.Access.PRIVATE;
    }

    public final IDLXBridgeMethod.Access getAccess() {
        return this.b;
    }

    public final String getName() {
        return this.a;
    }
}
