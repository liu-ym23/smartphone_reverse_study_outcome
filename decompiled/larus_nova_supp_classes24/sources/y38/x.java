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
import com.larus.account.saas.jsb.core.FlowAccountUnbindCore;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@XBridgeMethod(name = "doubaoAccount.unbindPlatform", owner = "fengjingzhe")
public final class x extends XCoreIDLBridgeMethod<a, b> {

    @XBridgeMethodName(name = "doubaoAccount.unbindPlatform")
    public final String a;
    public final IDLXBridgeMethod.Access b;

    @XBridgeParamModel
    public interface a extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "platform", required = true)
        String getPlatform();
    }

    @XBridgeResultModel
    public interface b extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "errorCode", required = true)
        Number getErrorCode();

        @XBridgeParamField(isGetter = true, keyPath = "errorMsg", required = true)
        String getErrorMessage();

        @XBridgeParamField(isGetter = true, keyPath = "success", required = true)
        Number getSuccess();

        @XBridgeParamField(isGetter = false, keyPath = "errorCode", required = true)
        void setErrorCode(Number r1);

        @XBridgeParamField(isGetter = false, keyPath = "errorMsg", required = true)
        void setErrorMessage(String r1);

        @XBridgeParamField(isGetter = false, keyPath = "success", required = true)
        void setSuccess(Number r1);
    }

    public x() {
        this.a = "doubaoAccount.unbindPlatform";
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
        int r0 = FlowAccountUnbindCore.a;
        String r7 = r6.getPlatform();
        y r1 = new y(r5);
        Intrinsics.checkNotNullParameter(r1, "callback");
        String r2 = "apple";
        if (Intrinsics.areEqual(r7, "douyin") == true) goto L8;
        if (Intrinsics.areEqual(r7, "apple") == true) goto L8;
        FlowAccountUnbindCore.Error r8 = FlowAccountUnbindCore.Error.UNSUPPORTED_PLATFORM;
        r1.a(new x38.a(r8.getCode(), r8.getMessage(), null));
        return;
    L8:
        if (Intrinsics.areEqual(r7, "douyin") == false) goto L10;
        r2 = "aweme_v2";
    L10:
        FlowAccountSdk.a().a(r2, new com.larus.account.saas.jsb.core.g(r1));
    }
}
