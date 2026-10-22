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
import com.larus.account.saas.jsb.core.FlowAccountLoadingCore;
import com.larus.account.saas.ui.IAccountLoadingUiService;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@XBridgeMethod(name = "doubaoAccount.loading", owner = "fengjingzhe")
public final class h extends XCoreIDLBridgeMethod<a, b> {

    @XBridgeMethodName(name = "doubaoAccount.loading")
    public final String a;
    public final IDLXBridgeMethod.Access b;

    @XBridgeParamModel
    public interface a extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "show", required = true)
        Number getShow();
    }

    @XBridgeResultModel
    public interface b extends XBaseResultModel {
    }

    public h() {
        this.a = "doubaoAccount.loading";
        this.b = IDLXBridgeMethod.Access.PRIVATE;
    }

    public final IDLXBridgeMethod.Access getAccess() {
        return this.b;
    }

    public final String getName() {
        return this.a;
    }

    public final void handle(IBDXBridgeContext r4, XBaseParamModel r5, CompletionBlock r6) {
        a r7 = (a) r5;
        Intrinsics.checkNotNullParameter(r4, "bridgeContext");
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r6, "callback");
        int r1 = FlowAccountLoadingCore.a;
        Activity r8 = r4.getOwnerActivity();
        boolean r2 = false;
        boolean r3 = true;
        if (r7.getShow().intValue() == 1) goto L6;
        r3 = false;
    L6:
        i r9 = new i(r6);
        Intrinsics.checkNotNullParameter(r9, "callback");
        if (r8 == null) goto L12;
        if (r3 == false) goto L11;
        r2 = IAccountLoadingUiService.c.showLoading(r8);
        goto L12
    L11:
        r2 = IAccountLoadingUiService.c.d(r8);
    L12:
        if (r2 == false) goto L14;
        r9.onSuccess(Unit.INSTANCE);
        return;
    L14:
        com.larus.account.saas.runtime.internal.delegate.a.a.a("FlowAccountLoadingCore", "current activity " + r8 + " is illegal, Abort.");
        FlowAccountLoadingCore.Error r10 = FlowAccountLoadingCore.Error.NOT_HANDLED;
        int r11 = r10.getCode();
        c48.a.a().a();
        String r0 = com.larus.init.task.accountsdk.a.a.getApplication().getString(2131899106);
        if (StringsKt.isBlank(r0) == false) goto L17;
        r0 = r10.getMessage();
    L17:
        r9.a(new x38.a(r11, r0, null));
    }
}
