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
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@XBridgeMethod(name = "doubaoAccount.getLoginContext", owner = "yangya.yjnull")
public final class c extends XCoreIDLBridgeMethod<a, b> {

    @XBridgeMethodName(name = "doubaoAccount.getLoginContext")
    public final String a;
    public final IDLXBridgeMethod.Access b;

    @XBridgeParamModel
    public interface a extends XBaseParamModel {
    }

    @XBridgeResultModel
    public interface b extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "clientAppName", required = true)
        String getClientAppName();

        @XBridgeParamField(isGetter = true, keyPath = "privacyPolicyUrl", required = true)
        String getPrivacyPolicyUrl();

        @XBridgeParamField(isGetter = true, keyPath = "serviceAgreementUrl", required = true)
        String getServiceAgreementUrl();

        @XBridgeParamField(isGetter = false, keyPath = "clientAppName", required = true)
        void setClientAppName(String r1);

        @XBridgeParamField(isGetter = false, keyPath = "privacyPolicyUrl", required = true)
        void setPrivacyPolicyUrl(String r1);

        @XBridgeParamField(isGetter = false, keyPath = "serviceAgreementUrl", required = true)
        void setServiceAgreementUrl(String r1);
    }

    public c() {
        this.a = "doubaoAccount.getLoginContext";
        this.b = IDLXBridgeMethod.Access.PRIVATE;
    }

    public final IDLXBridgeMethod.Access getAccess() {
        return this.b;
    }

    public final String getName() {
        return this.a;
    }

    public final void handle(IBDXBridgeContext r6, XBaseParamModel r7, CompletionBlock r8) {
        Intrinsics.checkNotNullParameter(r6, "bridgeContext");
        Intrinsics.checkNotNullParameter((a) r7, "params");
        Intrinsics.checkNotNullParameter(r8, "callback");
        int r9 = com.larus.account.saas.jsb.core.a.a;
        com.larus.account.saas.runtime.internal.delegate.b r10 = com.larus.account.saas.runtime.internal.delegate.c.a;
        com.larus.account.saas.runtime.internal.delegate.b r11 = com.larus.account.saas.runtime.internal.delegate.c.a;
        if (r11 != null) goto L24;
        d48.d r12 = c48.a.a;
        d48.d r13 = c48.a.a;
        if (r13 == null) goto L8;
        r13.a();
        String r14 = Integer.valueOf(com.larus.init.task.accountsdk.a.a.a()).toString();
    L10:
        if (Intrinsics.areEqual(r14, "401734") == false) goto L22;
        d48.d r15 = c48.a.a;
        if (r15 == null) goto L15;
        r15.f();
        d48.f.b r16 = com.larus.init.task.accountsdk.d.b.a("account_saas_login_context");
    L16:
        String r0 = r16.getString("app_name");
        String r1 = r16.getString("service_agreement_url");
        String r17 = r16.getString("privacy_policy_url");
        if (StringsKt.isBlank(r0) == true) goto L19;
    L23:
        com.larus.account.saas.runtime.internal.delegate.b r2 = new com.larus.account.saas.runtime.internal.delegate.b(r0, new com.larus.account.saas.runtime.internal.delegate.d("服务协议", r1), new com.larus.account.saas.runtime.internal.delegate.d("隐私政策", r17));
        com.larus.account.saas.runtime.internal.delegate.c.a = r2;
        r11 = r2;
        goto L24
    L19:
        if (StringsKt.isBlank(r1) == false) goto L23;
        if (StringsKt.isBlank(r17) == false) goto L23;
    L15:
        d48.f.a.getClass();
        d48.f.a r19 = d48.f.a.a;
        Intrinsics.checkNotNullParameter("account_saas_login_context", "repoName");
        r16 = d48.f.a.b.a;
    L22:
        r11 = null;
        goto L24
    L8:
        r14 = null;
    L24:
        String r3 = "";
        if (r11 == null) goto L33;
        String r4 = r11.a;
        if (r4 == null) goto L33;
        if ((!StringsKt.isBlank(r4)) == true) goto L32;
        r4 = null;
    L32:
        if (r4 == null) goto L33;
    L41:
        if (r11 == null) goto L46;
        com.larus.account.saas.runtime.internal.delegate.d r5 = r11.b;
        if (r5 == null) goto L46;
        String r20 = r5.b;
        if (r20 == null) goto L46;
    L47:
        if (r11 == null) goto L54;
        com.larus.account.saas.runtime.internal.delegate.d r21 = r11.c;
        if (r21 == null) goto L54;
        String r22 = r21.b;
        if (r22 == null) goto L54;
        r3 = r22;
    L54:
        Intrinsics.checkNotNullParameter(r4, "clientAppName");
        Intrinsics.checkNotNullParameter(r20, "serviceAgreementUrl");
        Intrinsics.checkNotNullParameter(r3, "privacyPolicyUrl");
        b r23 = ne7.e.b(b.class);
        b r24 = r23;
        r24.setClientAppName(r4);
        r24.setServiceAgreementUrl(r20);
        r24.setPrivacyPolicyUrl(r3);
        CompletionBlock.DefaultImpls.onSuccess$default(r8, r23, null, 2, null);
        return;
    L46:
        r20 = "";
    L33:
        b48.d r25 = FlowAccountSdk.g().getConfig();
        if (r25 == null) goto L38;
        b48.a r26 = r25.a;
        if (r26 == null) goto L38;
        r4 = r26.a;
    L39:
        if (r4 != null) goto L41;
        r4 = "";
    L38:
        r4 = null;
        goto L39
    }
}
