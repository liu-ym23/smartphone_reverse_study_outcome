package y38;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.larus.account.saas.jsb.core.FlowAccountVerifyCore;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@XBridgeMethod(name = "doubaoAccount.getVerifyDecision", owner = "fengjingzhe")
public final class g extends rc7.a {

    @XBridgeMethodName(name = "doubaoAccount.getVerifyDecision", params = {""}, results = {"verifyDecision"})
    public final String c;

    public g() {
        this.c = "doubaoAccount.getVerifyDecision";
    }

    public final String getName() {
        return this.c;
    }

    public final void handle(IBDXBridgeContext r7, XBaseParamModel r8, CompletionBlock r9) {
        rc7.a.a r10 = (rc7.a.a) r8;
        Intrinsics.checkNotNullParameter(r7, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r9, "callback");
        int r0 = FlowAccountVerifyCore.a;
        Number r11 = r10.getAfid();
        f r1 = new f(r9);
        Intrinsics.checkNotNullParameter(r1, "callback");
        if (r11 == null) goto L5;
        int r12 = r11.intValue();
    L6:
        JSONObject r13 = pc7.e.c().b(r12);
        if (r13 == null) goto L11;
        JSONObject r2 = r13.optJSONObject("event_params");
        if (r2 == null) goto L11;
        String r3 = r2.optString("verify_scene");
    L12:
        if (r3 != null) goto L14;
        r3 = "";
    L14:
        if (r13 != null) goto L34;
        FlowAccountVerifyCore.a(r12, r3, 0);
        FlowAccountVerifyCore.Error r14 = FlowAccountVerifyCore.Error.DECISION_NOT_FOUND;
        r1.a(new x38.a(r14.getCode(), r14.getMessage(), null));
        return;
    L34:
        Map<String, Object> r15 = com.larus.account.saas.jsb.core.h.b(r13);     // Catch: Exception -> L31
        LinkedHashMap r4 = new LinkedHashMap();     // Catch: Exception -> L31
        Iterator r16 = ((LinkedHashMap) r15).entrySet().iterator();     // Catch: Exception -> L31
    L17:
        boolean r5 = true;
        if (r16.hasNext() == false) goto L25;
        Map.Entry r6 = (Map.Entry) r16.next();     // Catch: Exception -> L31
        if (r6.getValue() != null) goto L23;
        r5 = false;
    L23:
        if (r5 == false) goto L17;
        r4.put(r6.getKey(), r6.getValue());     // Catch: Exception -> L31
        goto L17
    L25:
        LinkedHashMap r17 = new LinkedHashMap(MapsKt.mapCapacity(r4.size()));     // Catch: Exception -> L31
        Iterator r19 = r4.entrySet().iterator();     // Catch: Exception -> L31
    L27:
        if (r19.hasNext() == false) goto L29;
        Object r20 = r19.next();     // Catch: Exception -> L31
        Object r21 = ((Map.Entry) r20).getKey();     // Catch: Exception -> L31
        Object r22 = ((Map.Entry) r20).getValue();     // Catch: Exception -> L31
        Intrinsics.checkNotNull(r22);     // Catch: Exception -> L31
        r17.put(r21, r22);     // Catch: Exception -> L31
        goto L27
    L29:
        FlowAccountVerifyCore.a(r12, r3, 1);     // Catch: Exception -> L31
        r1.onSuccess(r17);     // Catch: Exception -> L31
        return;
    L31:
        e = move-exception;
        com.larus.account.saas.runtime.internal.delegate.a.a.g("FlowAccountVerifyCore", "catch exception while parsing decisions", e);
        FlowAccountVerifyCore.a(r12, r3, 0);
        FlowAccountVerifyCore.Error r23 = FlowAccountVerifyCore.Error.DECISION_PARSE_FAILED;
        r1.a(new x38.a(r23.getCode(), r23.getMessage(), e));
        return;
    L11:
        r3 = null;
        goto L12
    L5:
        r12 = 0;
        goto L6
    }
}
