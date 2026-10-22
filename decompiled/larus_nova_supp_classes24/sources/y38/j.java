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
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.larus.account.saas.FlowAccountSdk;
import com.larus.account.saas.jsb.core.FlowAccountLogoutCore;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@XBridgeMethod(name = "doubaoAccount.logout", owner = "fengjingzhe")
public final class j extends XCoreIDLBridgeMethod<b, c> {

    @XBridgeMethodName(name = "doubaoAccount.logout")
    public final String a;
    public final IDLXBridgeMethod.Access b;

    public interface a extends XBaseModel {
        @XBridgeParamField(isGetter = true, keyPath = "scene", required = false)
        String getScene();
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "context", required = true)
        a getContext();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
    }

    public j() {
        this.a = "doubaoAccount.logout";
        this.b = IDLXBridgeMethod.Access.PRIVATE;
    }

    public final IDLXBridgeMethod.Access getAccess() {
        return this.b;
    }

    public final String getName() {
        return this.a;
    }

    public final void handle(IBDXBridgeContext r2, XBaseParamModel r3, CompletionBlock r4) {
        Intrinsics.checkNotNullParameter(r2, "bridgeContext");
        Intrinsics.checkNotNullParameter((b) r3, "params");
        Intrinsics.checkNotNullParameter(r4, "callback");
        int r5 = FlowAccountLogoutCore.a;
        k r6 = new k(r4);
        Intrinsics.checkNotNullParameter(r6, "callback");
        FlowAccountSdk.f().a("account_setting", new com.larus.account.saas.jsb.core.d(r6));
    }
}
