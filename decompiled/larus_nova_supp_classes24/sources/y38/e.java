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
import com.larus.account.saas.runtime.internal.delegate.SaasSettings;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@XBridgeMethod(name = "doubaoAccount.getSdkSettings", owner = "fengjingzhe")
public final class e extends XCoreIDLBridgeMethod<a, b> {

    @XBridgeMethodName(name = "doubaoAccount.getSdkSettings")
    public final String a;
    public final IDLXBridgeMethod.Access b;

    @XBridgeParamModel
    public interface a extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "settingKey", required = true)
        String getSettingsKey();
    }

    @XBridgeResultModel
    public interface b extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "value", required = true)
        Object getValue();

        @XBridgeParamField(isGetter = false, keyPath = "value", required = true)
        void setValue(Object r1);
    }

    public e() {
        this.a = "doubaoAccount.getSdkSettings";
        this.b = IDLXBridgeMethod.Access.PRIVATE;
    }

    public final IDLXBridgeMethod.Access getAccess() {
        return this.b;
    }

    public final String getName() {
        return this.a;
    }

    public final void handle(IBDXBridgeContext r8, XBaseParamModel r9, CompletionBlock r10) {
        a r11 = (a) r9;
        Intrinsics.checkNotNullParameter(r8, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, "params");
        Intrinsics.checkNotNullParameter(r10, "callback");
        b r12 = ne7.e.b(b.class);
        b r0 = r12;
        int r1 = com.larus.account.saas.jsb.core.c.a;
        String r13 = r11.getSettingsKey();
        Intrinsics.checkNotNullParameter(r13, "settingsKey");
        SaasSettings r2 = SaasSettings.a;
        Lazy r3 = SaasSettings.b;
        Object r4 = ((d48.e) r3.getValue()).a("sdk_key_flow_account", new JSONObject()).optJSONObject(r13);
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        com.larus.account.saas.runtime.internal.delegate.a.a.d("FlowAccountGetSettingsCore", "[doubaoAccount.getSdkSettings] params.settingsKey=" + r13 + ", value=" + r4 + ", SaasSettings.getSdkSettings()=" + ((d48.e) r3.getValue()).a("sdk_key_flow_account", new JSONObject()));
        r0.setValue(r4);
        CompletionBlock.DefaultImpls.onSuccess$default(r10, r12, null, 2, null);
    }
}
