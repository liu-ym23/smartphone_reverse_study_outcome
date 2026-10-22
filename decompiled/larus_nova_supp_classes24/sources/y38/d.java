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
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@XBridgeMethod(name = "doubaoAccount.getNetworkInfo", owner = "fengjingzhe")
public final class d extends XCoreIDLBridgeMethod<a, b> {

    @XBridgeMethodName(name = "doubaoAccount.getNetworkInfo")
    public final String a;
    public final IDLXBridgeMethod.Access b;

    @XBridgeParamModel
    public interface a extends XBaseParamModel {
    }

    @XBridgeResultModel
    public interface b extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "domain", required = true)
        String getDomain();

        @XBridgeParamField(isGetter = true, keyPath = "sdkParams", required = true)
        Map<String, String> getSdkParams();

        @XBridgeParamField(isGetter = false, keyPath = "domain", required = true)
        void setDomain(String r1);

        @XBridgeParamField(isGetter = false, keyPath = "sdkParams", required = true)
        void setSdkParams(Map<String, String> r1);
    }

    public d() {
        this.a = "doubaoAccount.getNetworkInfo";
        this.b = IDLXBridgeMethod.Access.PRIVATE;
    }

    public final IDLXBridgeMethod.Access getAccess() {
        return this.b;
    }

    public final String getName() {
        return this.a;
    }

    public final void handle(IBDXBridgeContext r5, XBaseParamModel r6, CompletionBlock r7) {
        Intrinsics.checkNotNullParameter(r5, "bridgeContext");
        Intrinsics.checkNotNullParameter((a) r6, "params");
        Intrinsics.checkNotNullParameter(r7, "callback");
        int r8 = com.larus.account.saas.jsb.core.b.a;
        b48.d r9 = FlowAccountSdk.g().getConfig();
        if (r9 == null) goto L12;
        b48.a r10 = r9.a;
        if (r10 == null) goto L12;
        String r11 = r10.b;
        if (r11 == null) goto L12;
        if (StringsKt.startsWith$default(r11, "https://", false, 2, null) == true) goto L13;
        r11 = "https://".concat(r11);
    L13:
        Map<String, String> r1 = FlowAccountSdk.f().getCommonParams();
        b r2 = ne7.e.b(b.class);
        b r3 = r2;
        r3.setDomain(r11);
        r3.setSdkParams(r1);
        CompletionBlock.DefaultImpls.onSuccess$default(r7, r2, null, 2, null);
        return;
    L12:
        r11 = null;
        goto L13
    }
}
