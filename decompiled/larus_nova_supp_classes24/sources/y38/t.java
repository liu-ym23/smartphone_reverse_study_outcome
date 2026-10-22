package y38;

import android.app.Activity;
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
import com.larus.account.saas.jsb.core.FlowAccountThirdPartyAuthCore;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@XBridgeMethod(name = "doubaoAccount.thirdPartyAuth", owner = "fengjingzhe")
public final class t extends XCoreIDLBridgeMethod<a, b> {

    @XBridgeMethodName(name = "doubaoAccount.thirdPartyAuth")
    public final String a;
    public final IDLXBridgeMethod.Access b;

    @XBridgeParamModel
    public interface a extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "needRawData", required = false)
        Boolean getNeedRawData();

        @XBridgeParamField(isGetter = true, keyPath = "platform", required = true)
        String getPlatform();
    }

    @XBridgeResultModel
    public interface b extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "accessToken", required = false)
        String getAccessToken();

        @XBridgeParamField(isGetter = true, keyPath = "accessTokenSecret", required = false)
        String getAccessTokenSecret();

        @XBridgeParamField(isGetter = true, keyPath = "code", required = false)
        String getCode();

        @XBridgeParamField(isGetter = true, keyPath = "errorCode", required = false)
        Number getErrorCode();

        @XBridgeParamField(isGetter = true, keyPath = "expiresIn", required = false)
        String getExpiresIn();

        @XBridgeParamField(isGetter = true, keyPath = "openId", required = false)
        String getOpenId();

        @XBridgeParamField(isGetter = true, keyPath = "platform", required = false)
        String getPlatform();

        @XBridgeParamField(isGetter = true, keyPath = "platformAppId", required = false)
        String getPlatformAppId();

        @XBridgeParamField(isGetter = true, keyPath = "rawData", required = false)
        String getRawData();

        @XBridgeParamField(isGetter = false, keyPath = "accessToken", required = false)
        void setAccessToken(String r1);

        @XBridgeParamField(isGetter = false, keyPath = "accessTokenSecret", required = false)
        void setAccessTokenSecret(String r1);

        @XBridgeParamField(isGetter = false, keyPath = "code", required = false)
        void setCode(String r1);

        @XBridgeParamField(isGetter = false, keyPath = "errorCode", required = false)
        void setErrorCode(Number r1);

        @XBridgeParamField(isGetter = false, keyPath = "expiresIn", required = false)
        void setExpiresIn(String r1);

        @XBridgeParamField(isGetter = false, keyPath = "openId", required = false)
        void setOpenId(String r1);

        @XBridgeParamField(isGetter = false, keyPath = "platform", required = false)
        void setPlatform(String r1);

        @XBridgeParamField(isGetter = false, keyPath = "platformAppId", required = false)
        void setPlatformAppId(String r1);

        @XBridgeParamField(isGetter = false, keyPath = "rawData", required = false)
        void setRawData(String r1);
    }

    public t() {
        this.a = "doubaoAccount.thirdPartyAuth";
        this.b = IDLXBridgeMethod.Access.SECURE;
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
        int r1 = FlowAccountThirdPartyAuthCore.a;
        Activity r9 = r5.getOwnerActivity();
        String r10 = r8.getPlatform();
        u r2 = new u(r7);
        Intrinsics.checkNotNullParameter(r2, "callback");
        if (r9 != null) goto L5;
        com.larus.account.saas.runtime.internal.delegate.a.a.a("FlowAccountThirdPartyAuthCore", "owner activity is null, abort third party auth.");
        FlowAccountThirdPartyAuthCore.Error r11 = FlowAccountThirdPartyAuthCore.Error.ACTIVITY_NULL;
        r2.a(new x38.a(r11.getCode(), r11.getMessage(), null));
        return;
    L5:
        b48.d r3 = FlowAccountSdk.g().getConfig();
        if (r3 == null) goto L8;
        b48.i r4 = r3.b;
    L9:
        if (r10 != null) goto L11;
    L52:
        FlowAccountThirdPartyAuthCore.Error r12 = FlowAccountThirdPartyAuthCore.Error.UNSUPPORTED_PLATFORM;
        r2.a(new x38.a(r12.getCode(), r12.getMessage(), null));
        return;
    L11:
        switch(r10.hashCode()) {
            case -1325936172: goto L41;
            case -1240244679: goto L32;
            case 3321844: goto L23;
            case 497130182: goto L14;
            default: goto L52;
        };
    L14:
        if (r10.equals("facebook") == false) goto L52;
        if (r4 == null) goto L18;
        b48.i.b r13 = r4.c;
    L19:
        if (r13 != null) goto L21;
        FlowAccountThirdPartyAuthCore.Error r14 = FlowAccountThirdPartyAuthCore.Error.CONFIG_MISSING;
        r2.a(new x38.a(r14.getCode(), r14.getMessage(), null));
        return;
    L21:
        com.larus.account.saas.jsb.core.auth.d.a(r9, r13, r2);
        return;
    L18:
        r13 = null;
        goto L19
    L23:
        if (r10.equals("line") == false) goto L52;
        if (r4 == null) goto L27;
        b48.i.b r15 = r4.d;
    L28:
        if (r15 != null) goto L30;
        FlowAccountThirdPartyAuthCore.Error r16 = FlowAccountThirdPartyAuthCore.Error.CONFIG_MISSING;
        r2.a(new x38.a(r16.getCode(), r16.getMessage(), null));
        return;
    L30:
        com.larus.account.saas.jsb.core.auth.g.a(r9, r15, r2);
        return;
    L27:
        r15 = null;
        goto L28
    L32:
        if (r10.equals("google") == false) goto L52;
        if (r4 == null) goto L36;
        b48.i.b r17 = r4.b;
    L37:
        if (r17 != null) goto L39;
        FlowAccountThirdPartyAuthCore.Error r19 = FlowAccountThirdPartyAuthCore.Error.CONFIG_MISSING;
        r2.a(new x38.a(r19.getCode(), r19.getMessage(), null));
        return;
    L39:
        com.larus.account.saas.jsb.core.auth.f.a(r9, r17, r2);
        return;
    L36:
        r17 = null;
        goto L37
    L41:
        if (r10.equals("douyin") == false) goto L52;
        if (r4 == null) goto L45;
        b48.i.a r20 = r4.a;
    L46:
        if (r20 != null) goto L54;
        FlowAccountThirdPartyAuthCore.Error r21 = FlowAccountThirdPartyAuthCore.Error.CONFIG_MISSING;
        r2.a(new x38.a(r21.getCode(), r21.getMessage(), null));
        return;
    L54:
        com.larus.account.saas.jsb.core.auth.c.a(r9, r20, r2);     // Catch: LinkageError -> L50
        return;
    L50:
        e = move-exception;
        com.larus.account.saas.runtime.internal.delegate.a.a.b("FlowAccountThirdPartyAuthCore", "douyin authorize service dependency is unavailable.", e);
        FlowAccountThirdPartyAuthCore.Error r22 = FlowAccountThirdPartyAuthCore.Error.SERVICE_UNAVAILABLE;
        r2.a(new x38.a(r22.getCode(), r22.getMessage(), e));
        return;
    L45:
        r20 = null;
        goto L46
    L8:
        r4 = null;
        goto L9
    }
}
