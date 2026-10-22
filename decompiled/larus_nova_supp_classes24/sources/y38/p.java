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
import com.larus.account.saas.FlowAccountSdk;
import com.larus.account.saas.jsb.core.FlowAccountPostLoginEventCore;
import com.larus.account.saas.runtime.internal.delegate.SaasTracking;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@XBridgeMethod(name = "doubaoAccount.postLoginEvent", owner = "yangya.yjnull")
public final class p extends XCoreIDLBridgeMethod<a, b> {

    @XBridgeMethodName(name = "doubaoAccount.postLoginEvent")
    public final String a;
    public final IDLXBridgeMethod.Access b;

    @XBridgeParamModel
    public interface a extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "event", required = true)
        String getEvent();

        @XBridgeParamField(isGetter = true, keyPath = "payload", required = false)
        Map<String, Object> getPayload();
    }

    @XBridgeResultModel
    public interface b extends XBaseResultModel {
    }

    public p() {
        this.a = "doubaoAccount.postLoginEvent";
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
        int r0 = FlowAccountPostLoginEventCore.a;
        String r1 = r6.getEvent();
        Map<String, Object> r7 = r6.getPayload();
        q r2 = new q(r5);
        Intrinsics.checkNotNullParameter(r2, "callback");
        if (r1 != null) goto L5;
    L7:
        r1 = null;
    L8:
        if (r1 != null) goto L10;
        FlowAccountPostLoginEventCore.Error r8 = FlowAccountPostLoginEventCore.Error.INVALID_EVENT;
        r2.a(new x38.a(r8.getCode(), r8.getMessage(), null));
        return;
    L10:
        SaasTracking r9 = SaasTracking.a;
        if (r7 != null) goto L13;
        r7 = MapsKt.emptyMap();
    L13:
        r9.reportEvent(r1, new JSONObject(r7));
        if (Intrinsics.areEqual(r1, "profile_updated") == false) goto L16;
        FlowAccountSdk.e().a();
    L16:
        r2.onSuccess(Unit.INSTANCE);
        return;
    L5:
        if ((!StringsKt.isBlank(r1)) == false) goto L7;
        goto L7
    }
}
