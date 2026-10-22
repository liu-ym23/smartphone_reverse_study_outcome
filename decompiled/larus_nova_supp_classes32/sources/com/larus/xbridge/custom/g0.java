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
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@XBridgeMethod(name = "app.switchAccount")
public final class g0 extends XCoreIDLBridgeMethod<c, a> {

    @XBridgeMethodName(name = "app.switchAccount", params = {"secUid", "trackInfo"})
    public final String a;

    @XBridgePermission(permission = IDLXBridgeMethod.Access.PROTECT)
    public final IDLXBridgeMethod.Access b;

    @XBridgeResultModel
    public interface a extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "success", required = true)
        boolean getSuccess();

        @XBridgeParamField(isGetter = false, keyPath = "success", required = true)
        void setSuccess(boolean r1);
    }

    public static final class b {
    }

    @XBridgeParamModel
    public interface c extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "secUid", required = true)
        String getSecUid();

        @XBridgeParamField(isGetter = true, keyPath = "trackInfo", required = false)
        Map<String, Object> getTrackInfo();
    }

    static {
    }

    public g0() {
        this.a = "app.switchAccount";
        this.b = IDLXBridgeMethod.Access.PROTECT;
    }

    public final IDLXBridgeMethod.Access getAccess() {
        return this.b;
    }

    public final String getName() {
        return this.a;
    }

    public final void handle(final IBDXBridgeContext r13, XBaseParamModel r14, final CompletionBlock r15) {
        final c r5 = (c) r14;
        Intrinsics.checkNotNullParameter(r13, "bridgeContext");
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r15, "callback");
        String r16 = r5.getSecUid();
        FragmentActivity r1 = null;
        if ((!StringsKt.isBlank(r16)) == false) goto L5;
        final String r4 = r16;
    L6:
        if (r4 != null) goto L8;
        CompletionBlock.DefaultImpls.onFailure$default(r15, -3, "secUid is required", null, 4, null);
        return;
    L8:
        Activity r17 = r13.getOwnerActivity();
        if (r17 != null) goto L12;
        gd9.i r18 = com.larus.im.b.a;
        Intrinsics.checkNotNull(r18);
        r17 = r18.a().e();
    L12:
        if ((r17 instanceof FragmentActivity) == false) goto L14;
        r1 = (FragmentActivity) r17;
    L14:
        final FragmentActivity r19 = r1;
        if (r19 != null) goto L17;
        CompletionBlock.DefaultImpls.onFailure$default(r15, 0, "host activity is unavailable", null, 4, null);
        return;
    L17:
        r19.runOnUiThread(new e0(r13, r19, r15, r4, r5));
        return;
    L5:
        r4 = null;
        goto L6
    }
}
