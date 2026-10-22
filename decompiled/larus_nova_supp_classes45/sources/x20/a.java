package x20;

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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class a extends XCoreIDLBridgeMethod<b, c> {

    @XBridgeModelExtension
    public static final Map<String, Object> c = null;

    @XBridgeMethodName(name = "live.sendByteLinkApiRequest", params = {"serviceID", "queryParams", "headers", "uri", "payload", "timeout", "method", "httpURL"}, results = {"serviceID", "headers", "payload", "statusCode", "statusMsg"})
    public final String a;

    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access b;

    /* JADX INFO: renamed from: x20.a$a, reason: collision with other inner class name */
    public static final class C0293a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "headers", required = false)
        Map<String, Object> getHeaders();

        @XBridgeParamField(isGetter = true, keyPath = "httpURL", required = false)
        String getHttpURL();

        @XBridgeParamField(isGetter = true, keyPath = "method", required = true)
        Number getMethod();

        @XBridgeParamField(isGetter = true, keyPath = "payload", required = false)
        String getPayload();

        @XBridgeParamField(isGetter = true, keyPath = "queryParams", required = false)
        Map<String, Object> getQueryParams();

        @XBridgeParamField(isGetter = true, keyPath = "serviceID", required = true)
        Number getServiceID();

        @XBridgeParamField(isGetter = true, keyPath = "timeout", required = false)
        Number getTimeout();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "headers", required = false)
        Map<String, Object> getHeaders();

        @XBridgeParamField(isGetter = true, keyPath = "payload", required = false)
        String getPayload();

        @XBridgeParamField(isGetter = true, keyPath = "serviceID", required = true)
        Number getServiceID();

        @XBridgeParamField(isGetter = true, keyPath = "statusCode", required = false)
        Number getStatusCode();

        @XBridgeParamField(isGetter = true, keyPath = "statusMsg", required = false)
        String getStatusMsg();

        @XBridgeParamField(isGetter = false, keyPath = "headers", required = false)
        void setHeaders(Map<String, ? extends Object> r1);

        @XBridgeParamField(isGetter = false, keyPath = "payload", required = false)
        void setPayload(String r1);

        @XBridgeParamField(isGetter = false, keyPath = "serviceID", required = true)
        void setServiceID(Number r1);

        @XBridgeParamField(isGetter = false, keyPath = "statusCode", required = false)
        void setStatusCode(Number r1);

        @XBridgeParamField(isGetter = false, keyPath = "statusMsg", required = false)
        void setStatusMsg(String r1);
    }

    static {
        c = MapsKt.mapOf(TuplesKt.to("TicketID", "39109"));
    }

    public a() {
        this.a = "live.sendByteLinkApiRequest";
        this.b = IDLXBridgeMethod.Access.PRIVATE;
    }

    public final IDLXBridgeMethod.Access getAccess() {
        return this.b;
    }

    public final String getName() {
        return this.a;
    }
}
