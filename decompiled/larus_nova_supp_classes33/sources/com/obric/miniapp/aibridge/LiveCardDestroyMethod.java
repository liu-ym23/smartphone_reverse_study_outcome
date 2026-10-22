package com.obric.miniapp.aibridge;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016¨\u0006\u000f"}, d2 = {"Lcom/obric/miniapp/aibridge/LiveCardDestroyMethod;", "Lcom/obric/miniapp/aibridge/AbsLiveCardDestroyMethodIDL;", "<init>", "()V", "mustRunInMain", "", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/obric/miniapp/aibridge/AbsLiveCardDestroyMethodIDL$DestroyParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/obric/miniapp/aibridge/AbsLiveCardDestroyMethodIDL$DestroyResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LiveCardDestroyMethod extends AbsLiveCardDestroyMethodIDL {
    public final boolean mustRunInMain() {
        return true;
    }

    public LiveCardDestroyMethod() {
    }

    public final void handle(e3.d r9, ParamModel r10, f3.h r11) {
        AbsLiveCardDestroyMethodIDL.a r12 = (AbsLiveCardDestroyMethodIDL.a) r10;
        Intrinsics.checkNotNullParameter(r9, "bridgeContext");
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r11, "callback");
        String r13 = r12.getSessionKey();
        LiveCardJsbSessionManager r0 = LiveCardJsbSessionManager.a;
        r0.getClass();
        String r1 = LiveCardJsbSessionManager.o(r13);
        String r4 = null;
        if (r1 == null) goto L12;
        Intrinsics.checkNotNullParameter(AbsLiveCardDestroyMethodIDL.b.class, "<this>");
        AbsLiveCardDestroyMethodIDL.b r14 = k3.c.a(AbsLiveCardDestroyMethodIDL.b.class);
        AbsLiveCardDestroyMethodIDL.b r2 = r14;
        r2.setOk(false);
        if (r13 != null) goto L7;
        String r3 = "";
    L8:
        r2.setSessionKey(r3);
        if (r13 == null) goto L11;
        r4 = LiveCardJsbSessionManager.b(r13);
    L11:
        r2.setSessionTag(r4);
        JSONObject r15 = new JSONObject();
        r15.put("code", "INVALID_PARAM");
        r15.put("message", r1);
        r2.setError(r15);
        r11.b(r14, "");
        return;
    L7:
        r3 = r13;
        goto L8
    L12:
        if (r13 == null) goto L14;
        r4 = StringsKt.trim(r13).toString();
    L14:
        if (r4 != null) goto L16;
        r4 = "";
    L16:
        long r5 = System.currentTimeMillis();
        String r16 = r12.getReason();
        Intrinsics.checkNotNullParameter(r4, "sessionKey");
        String r17 = LiveCardJsbSessionManager.b(r4);
        if (r16 != null) goto L19;
        String r6 = "";
    L20:
        LiveCardJsbSessionManager.n("destroyByKey.enter", r4, r17, "reason=".concat(r6));
        if (r0.e(r17, r16) == false) goto L23;
        int r18 = t.e;
        t r19 = t.a.b(r4, r17);
    L24:
        LiveCardJsbSessionManager.n("destroyByKey.exit", r4, r17, "ok=" + r19.a);
        long r7 = System.currentTimeMillis() - r5;
        FLogger.a.i("LiveCardJSB", "op=destroy sessionKey=" + r19.b + " tag=" + r19.c + " ok=" + r19.a + " cost=" + r7 + "ms");
        Intrinsics.checkNotNullParameter(AbsLiveCardDestroyMethodIDL.b.class, "<this>");
        AbsLiveCardDestroyMethodIDL.b r110 = k3.c.a(AbsLiveCardDestroyMethodIDL.b.class);
        AbsLiveCardDestroyMethodIDL.b r8 = r110;
        r8.setOk(r19.a);
        r8.setSessionKey(r19.b);
        r8.setSessionTag(r19.c);
        r8.setError(r19.d);
        r11.b(r110, "");
        return;
    L23:
        int r20 = t.e;
        r19 = t.a.a(r4, r17, "SESSION_NOT_FOUND", "session not found");
        goto L24
    L19:
        r6 = r16;
        goto L20
    }
}
