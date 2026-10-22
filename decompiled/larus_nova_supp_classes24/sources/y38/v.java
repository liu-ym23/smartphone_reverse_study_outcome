package y38;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.larus.account.saas.jsb.core.FlowAccountTrackCore;
import com.larus.account.saas.runtime.internal.delegate.SaasTracking;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@XBridgeMethod(name = "doubaoAccount.track", owner = "fengjingzhe")
public final class v extends XCoreIDLBridgeMethod<a, b> {

    @XBridgeMethodName(name = "doubaoAccount.track")
    public final String a;
    public final IDLXBridgeMethod.Access b;

    @XBridgeParamModel
    public interface a extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "event", required = true)
        String getEvent();

        @XBridgeParamField(isGetter = true, keyPath = "params", required = false)
        Map<String, Object> getParams();
    }

    @XBridgeResultModel
    public interface b extends XBaseResultModel {
    }

    public v() {
        this.a = "doubaoAccount.track";
        this.b = IDLXBridgeMethod.Access.PRIVATE;
    }

    public final IDLXBridgeMethod.Access getAccess() {
        return this.b;
    }

    public final String getName() {
        return this.a;
    }

    public final void handle(IBDXBridgeContext r3, XBaseParamModel r4, CompletionBlock r5) {
        a r6 = (a) r4;
        Intrinsics.checkNotNullParameter(r3, "bridgeContext");
        Intrinsics.checkNotNullParameter(r6, "params");
        Intrinsics.checkNotNullParameter(r5, "callback");
        int r0 = FlowAccountTrackCore.a;
        String r1 = r6.getEvent();
        Map<String, Object> r7 = r6.getParams();
        w r2 = new w(r5);
        Intrinsics.checkNotNullParameter(r2, "callback");
        if (r1 != null) goto L5;
    L8:
        boolean r8 = true;
    L9:
        if (r8 == false) goto L11;
        FlowAccountTrackCore.Error r9 = FlowAccountTrackCore.Error.INVALID_EVENT;
        r2.a(new x38.a(r9.getCode(), r9.getMessage(), null));
        return;
    L11:
        SaasTracking r10 = SaasTracking.a;
        if (r7 != null) goto L14;
        r7 = MapsKt.emptyMap();
    L14:
        r10.reportEvent(r1, new JSONObject(r7));
        r2.onSuccess(Unit.INSTANCE);
        return;
    L5:
        if (StringsKt.isBlank(r1) == true) goto L8;
        r8 = false;
        goto L9
    }
}
