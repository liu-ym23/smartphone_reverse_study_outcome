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
import com.larus.account.saas.jsb.core.FlowAccountMobileSendCodeCore;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@XBridgeMethod(name = "doubaoAccount.mobileSendCode", owner = "yangya.yjnull")
public final class l extends XCoreIDLBridgeMethod<a, b> {

    @XBridgeMethodName(name = "doubaoAccount.mobileSendCode")
    public final String a;
    public final IDLXBridgeMethod.Access b;

    @XBridgeParamModel
    public interface a extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "mobile", required = true)
        String getMobile();
    }

    @XBridgeResultModel
    public interface b extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "errorCode", required = false)
        Number getXErrorCode();

        @XBridgeParamField(isGetter = true, keyPath = "errorMessage", required = false)
        String getXErrorMessage();

        @XBridgeParamField(isGetter = false, keyPath = "errorCode", required = false)
        void setXErrorCode(Number r1);

        @XBridgeParamField(isGetter = false, keyPath = "errorMessage", required = false)
        void setXErrorMessage(String r1);
    }

    public l() {
        this.a = "doubaoAccount.mobileSendCode";
        this.b = IDLXBridgeMethod.Access.PRIVATE;
    }

    public final IDLXBridgeMethod.Access getAccess() {
        return this.b;
    }

    public final String getName() {
        return this.a;
    }

    public final void handle(IBDXBridgeContext r7, XBaseParamModel r8, CompletionBlock r9) {
        a r10 = (a) r8;
        Intrinsics.checkNotNullParameter(r7, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r9, "callback");
        String r11 = r10.getMobile();
        if (r11 != null) goto L5;
        r11 = "";
    L5:
        String r1 = r11;
        if (StringsKt.isBlank(r1) == false) goto L8;
        r9.onFailure(-3, "mobile is empty", ne7.e.b(b.class));
        return;
    L8:
        int r12 = FlowAccountMobileSendCodeCore.a;
        m r13 = new m(r9);
        Intrinsics.checkNotNullParameter(r1, "mobile");
        Intrinsics.checkNotNullParameter(r13, "callback");
        FlowAccountSdk.c().b(r1, new com.larus.account.saas.jsb.core.e(r13), false, false, true);
    }
}
