package y38;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.larus.account.saas.jsb.core.FlowAccountVerifyCore;
import com.larus.account.saas.runtime.internal.delegate.SaasTracking;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@XBridgeMethod(name = "doubaoAccount.setVerifyStatus", owner = "fengjingzhe")
public final class s extends rc7.b {

    @XBridgeMethodName(name = "doubaoAccount.setVerifyStatus", params = {"status", "verifyWay", "verifyTicket", "verifyExtraParams", "extraBizParams"})
    public final String c;

    public s() {
        this.c = "doubaoAccount.setVerifyStatus";
    }

    public final String getName() {
        return this.c;
    }

    public final void handle(IBDXBridgeContext r17, XBaseParamModel r19, CompletionBlock r110) {
        rc7.b.a r1 = (rc7.b.a) r19;
        Intrinsics.checkNotNullParameter(r17, "bridgeContext");
        Intrinsics.checkNotNullParameter(r1, "params");
        Intrinsics.checkNotNullParameter(r110, "callback");
        int r3 = FlowAccountVerifyCore.a;
        Number r4 = r1.getAfid();
        Number r5 = r1.getStatus();
        String r7 = r1.getVerifyWay();
        String r8 = r1.getVerifyTicket();
        Map r9 = r1.getVerifyExtraParams();
        Map r10 = r1.getExtraBizParams();
        r r2 = new r(r110);
        Intrinsics.checkNotNullParameter(r2, "callback");
        int r0 = 0;
        if (r4 == null) goto L5;
        int r6 = r4.intValue();
    L6:
        if (r5 == null) goto L8;
        int r11 = r5.intValue();
    L9:
        JSONObject r12 = pc7.e.c().b(r6);
        if (r12 == null) goto L14;
        JSONObject r13 = r12.optJSONObject("event_params");
        if (r13 == null) goto L14;
        String r14 = r13.optString("verify_scene");
    L15:
        if (r14 != null) goto L17;
        r14 = "";
    L17:
        SaasTracking r15 = SaasTracking.a;
        JSONObject r16 = new JSONObject();
        r16.put("flow_scene", "mfa_explicit_jsb_set_status");
        r16.put("afid", String.valueOf(r6));
        r16.put("verify_scene", r14);
        if (r7 == null) goto L20;
        r16.put("verify_way", r7);
    L20:
        r16.put("status", r11);
        if (r8 != null) goto L23;
    L24:
        r0 = 1;
    L25:
        r16.put("has_token", r0 ^ 1);
        Unit r20 = Unit.INSTANCE;
        r15.reportEvent("doubao_account_mfa_explicit_flow", r16);
        if (r11 == 0) goto L30;
        if (r11 == 1) goto L29;
        FlowAccountVerifyCore.Error r21 = FlowAccountVerifyCore.Error.INVALID_STATUS;
        r2.a(new x38.a(r21.getCode(), r21.getMessage(), null));
        pc7.e.c().d(r6, 1, "status=" + r5);
        return;
    L29:
        r2.onSuccess(Unit.INSTANCE);
        pc7.e.c().d(r6, 1, "status=1");
        return;
    L30:
        r2.onSuccess(Unit.INSTANCE);
        pc7.e.c().e(r6, r7, r8, r9, r10);
        return;
    L23:
        if (r8.length() != 0) goto L25;
    L14:
        r14 = null;
        goto L15
    L8:
        r11 = -1;
        goto L9
    L5:
        r6 = 0;
        goto L6
    }
}
