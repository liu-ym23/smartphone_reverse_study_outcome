package com.larus.xbridge.custom;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgePermission;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@XBridgeMethod(name = "app.addAccount")
public final class d extends XCoreIDLBridgeMethod<a, g0.a> {

    @XBridgeMethodName(name = "app.addAccount", params = {"trackInfo"})
    public final String a;

    @XBridgePermission(permission = IDLXBridgeMethod.Access.PROTECT)
    public final IDLXBridgeMethod.Access b;

    @XBridgeParamModel
    public interface a extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "trackInfo", required = false)
        Map<String, Object> getTrackInfo();
    }

    public static final class b {
    }

    static {
    }

    public d() {
        this.a = "app.addAccount";
        this.b = IDLXBridgeMethod.Access.PROTECT;
    }

    public final IDLXBridgeMethod.Access getAccess() {
        return this.b;
    }

    public final String getName() {
        return this.a;
    }

    public final void handle(IBDXBridgeContext r7, XBaseParamModel r8, final CompletionBlock r9) {
        final a r10 = (a) r8;
        Intrinsics.checkNotNullParameter(r7, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r9, "callback");
        Activity r11 = r7.getOwnerActivity();
        if (r11 != null) goto L6;
        gd9.i r12 = com.larus.im.b.a;
        Intrinsics.checkNotNull(r12);
        r11 = r12.a().e();
    L6:
        if ((r11 instanceof FragmentActivity) == false) goto L8;
        final FragmentActivity r13 = (FragmentActivity) r11;
    L9:
        if (r13 != null) goto L11;
        CompletionBlock.DefaultImpls.onFailure$default(r9, 0, "host activity is unavailable", null, 4, null);
        return;
    L11:
        r13.runOnUiThread(new c(r9, r13, r10));
        return;
    L8:
        r13 = null;
        goto L9
    }
}
