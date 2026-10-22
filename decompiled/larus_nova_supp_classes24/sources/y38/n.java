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
import com.larus.account.saas.jsb.core.FlowAccountMobileSmsLoginCore;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@XBridgeMethod(name = "doubaoAccount.mobileSmsLogin", owner = "yangya.yjnull")
public final class n extends XCoreIDLBridgeMethod<a, b> {

    @XBridgeMethodName(name = "doubaoAccount.mobileSmsLogin")
    public final String a;
    public final IDLXBridgeMethod.Access b;

    @XBridgeParamModel
    public interface a extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "captcha", required = true)
        String getCaptcha();

        @XBridgeParamField(isGetter = true, keyPath = "mobile", required = true)
        String getMobile();

        @XBridgeParamField(isGetter = true, keyPath = "smsCode", required = true)
        String getSmsCode();
    }

    @XBridgeResultModel
    public interface b extends XBaseResultModel {
    }

    public n() {
        this.a = "doubaoAccount.mobileSmsLogin";
        this.b = IDLXBridgeMethod.Access.PRIVATE;
    }

    public final IDLXBridgeMethod.Access getAccess() {
        return this.b;
    }

    public final String getName() {
        return this.a;
    }

    public final void handle(IBDXBridgeContext r5, XBaseParamModel r6, CompletionBlock r7) {
        a r8 = (a) r6;
        Intrinsics.checkNotNullParameter(r5, "bridgeContext");
        Intrinsics.checkNotNullParameter(r8, "params");
        Intrinsics.checkNotNullParameter(r7, "callback");
        String r0 = r8.getMobile();
        String r1 = "";
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        String r2 = r8.getSmsCode();
        if (r2 == null) goto L10;
        r1 = r2;
    L10:
        if (StringsKt.isBlank(r0) == false) goto L13;
        r7.onFailure(-3, "mobile is empty", ne7.e.b(b.class));
        return;
    L13:
        if (StringsKt.isBlank(r1) == false) goto L15;
        r7.onFailure(-3, "smsCode is empty", ne7.e.b(b.class));
        return;
    L15:
        int r3 = FlowAccountMobileSmsLoginCore.a;
        String r9 = r8.getCaptcha();
        o r4 = new o(r7);
        Intrinsics.checkNotNullParameter(r0, "mobile");
        Intrinsics.checkNotNullParameter(r1, "smsCode");
        Intrinsics.checkNotNullParameter(r4, "callback");
        FlowAccountSdk.c().a(r0, r1, r9, new com.larus.account.saas.jsb.core.f(r4));
    }
}
