package com.larus.xbridge.custom;

import android.app.Activity;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
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
import com.google.gson.Gson;
import com.larus.caijing_pay.api.ICJPayService;
import com.larus.commercemembership.api.ICommerceMembershipService;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxResourceModule;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@XBridgeMethod(name = "flow.openMembershipCJPay", owner = "river.li")
public final class h1 extends XCoreIDLBridgeMethod<b, c> {

    @XBridgeMethodName(name = "flow.openMembershipCJPay")
    public final String a;

    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access b;
    public boolean c;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "productID", required = true)
        String getProductID();

        @XBridgeParamField(isGetter = true, keyPath = "sdkParams", required = true)
        String getSdkParams();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "resultCode", required = true)
        String getResultCode();

        @XBridgeParamField(isGetter = true, keyPath = "resultMessage", required = true)
        String getResultMessage();

        @XBridgeParamField(isGetter = false, keyPath = "resultCode", required = true)
        void setResultCode(String r1);

        @XBridgeParamField(isGetter = false, keyPath = "resultMessage", required = true)
        void setResultMessage(String r1);
    }

    static {
    }

    public h1() {
        this.a = "flow.openMembershipCJPay";
        this.b = IDLXBridgeMethod.Access.PRIVATE;
    }

    public final IDLXBridgeMethod.Access getAccess() {
        return this.b;
    }

    public final String getName() {
        return this.a;
    }

    public final void handle(IBDXBridgeContext r16, XBaseParamModel r17, final CompletionBlock r18) {
        b r0 = (b) r17;
        Intrinsics.checkNotNullParameter(r16, "bridgeContext");
        Intrinsics.checkNotNullParameter(r0, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r18, "callback");
        final String r1 = r0.getSdkParams();
        boolean r3 = false;
        if (r1 != null) goto L5;
    L8:
        boolean r5 = true;
    L10:
        if (r5 == false) goto L12;
        FLogger.a.e("FlowOpenMembershipCJPayMethod", "sdkParams is empty");
        CompletionBlock.DefaultImpls.onFailure$default(r18, 0, "fail, sdkParams is empty", null, 4, null);
        return;
    L12:
        Activity r14 = r16.getOwnerActivity();
        if (r14 != null) goto L15;
        FLogger.a.e("FlowOpenMembershipCJPayMethod", "activity is null");
        CompletionBlock.DefaultImpls.onFailure$default(r18, 0, "fail, activity is null", null, 4, null);
        return;
    L15:
        String r2 = r0.getProductID();
        int r4 = StringsKt.indexOf$default(r2, '_', 0, false, 6, null);
        if (r4 <= 0) goto L18;
        String r6 = r2.substring(0, r4);
    L19:
        Object r8 = null;
        Integer r9 = null;
        if (r4 <= 0) goto L26;
        String r7 = r2.substring(r4 + 1);
        if (r7.length() <= 0) goto L24;
        r3 = true;
    L24:
        if (r3 == false) goto L26;
        final String r10 = r7;
    L27:
        FLogger r11 = FLogger.a;
        r11.i("FlowOpenMembershipCJPayMethod", "[handle] pay productId=" + r2 + " orderId=" + r6 + " subscriptionId=" + r10 + " activity=" + r14.getLocalClassName());
        StringBuilder r12 = new StringBuilder("[handle] pay sdkParams=");
        r12.append(r1);
        r11.d("FlowOpenMembershipCJPayMethod", r12.toString());
        r1 r13 = new r1("1");
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L40
        JSONObject r19 = new JSONObject(r1);     // Catch: Throwable -> L40
        if (r19.has("service") == false) goto L47;
        Object r20 = r19.opt("service");     // Catch: Throwable -> L40
        if ((r20 instanceof Number) == false) goto L35;
        Integer r21 = Integer.valueOf(((Number) r20).intValue());     // Catch: Throwable -> L40
    L38:
        Object r22 = Result.constructor-impl(r21);     // Catch: Throwable -> L40
    L43:
        if (Result.isFailure-impl(r22) == true) goto L46;
        r8 = r22;
    L46:
        r9 = (Integer) r8;
        goto L47
    L35:
        if ((r20 instanceof String) == false) goto L37;
        r21 = StringsKt.toIntOrNull((String) r20);     // Catch: Throwable -> L40
        goto L38
    L37:
        r21 = null;
    L47:
        if (r9 == null) goto L49;
        int r23 = r9.intValue();
    L50:
        ICommerceMembershipService r24 = (ICommerceMembershipService) ServiceManager.get().getService(ICommerceMembershipService.class);
        if (r24 == null) goto L53;
        r24.B(r6, r10, String.valueOf(r23), r1, "cj_pay_jsb");
    L53:
        ICJPayService r25 = (ICJPayService) ServiceManager.get().getService(ICJPayService.class);
        if (r25 == null) goto L61;
        final String r26 = r6;
        final int r27 = r23;
        r25.e(r14, r23, r1, GsonProtectorUtils.toJson(new Gson(), r13), new g1(r26, r10, r27, r1, r18, this));
        return;
    L61:
        return;
    L49:
        r23 = 20;
    L40:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        r22 = Result.constructor-impl(ResultKt.createFailure(th));
    L26:
        r10 = null;
        goto L27
    L18:
        r6 = r2;
        goto L19
    L5:
        if (r1.length() == 0) goto L8;
        r5 = false;
        goto L10
    }
}
