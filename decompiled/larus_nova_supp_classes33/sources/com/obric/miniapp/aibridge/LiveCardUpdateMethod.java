package com.obric.miniapp.aibridge;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016¨\u0006\u000f"}, d2 = {"Lcom/obric/miniapp/aibridge/LiveCardUpdateMethod;", "Lcom/obric/miniapp/aibridge/AbsLiveCardUpdateMethodIDL;", "<init>", "()V", "mustRunInMain", "", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/obric/miniapp/aibridge/AbsLiveCardUpdateMethodIDL$UpdateParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/obric/miniapp/aibridge/AbsLiveCardUpdateMethodIDL$UpdateResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LiveCardUpdateMethod extends AbsLiveCardUpdateMethodIDL {
    public final boolean mustRunInMain() {
        return true;
    }

    public LiveCardUpdateMethod() {
    }

    public final void handle(e3.d r11, ParamModel r12, f3.h r13) {
        AbsLiveCardUpdateMethodIDL.a r14 = (AbsLiveCardUpdateMethodIDL.a) r12;
        Intrinsics.checkNotNullParameter(r11, "bridgeContext");
        Intrinsics.checkNotNullParameter(r14, "params");
        Intrinsics.checkNotNullParameter(r13, "callback");
        String r15 = r14.getSessionKey();
        LiveCardJsbSessionManager r0 = LiveCardJsbSessionManager.a;
        r0.getClass();
        String r1 = LiveCardJsbSessionManager.o(r15);
        String r8 = null;
        if (r1 == null) goto L12;
        Intrinsics.checkNotNullParameter(AbsLiveCardUpdateMethodIDL.b.class, "<this>");
        AbsLiveCardUpdateMethodIDL.b r16 = k3.c.a(AbsLiveCardUpdateMethodIDL.b.class);
        AbsLiveCardUpdateMethodIDL.b r2 = r16;
        r2.setOk(false);
        if (r15 != null) goto L7;
        String r3 = "";
    L8:
        r2.setSessionKey(r3);
        if (r15 == null) goto L11;
        r8 = LiveCardJsbSessionManager.b(r15);
    L11:
        r2.setSessionTag(r8);
        JSONObject r17 = new JSONObject();
        r17.put("code", "INVALID_PARAM");
        r17.put("message", r1);
        r2.setError(r17);
        r13.b(r16, "");
        return;
    L7:
        r3 = r15;
        goto L8
    L12:
        if (r15 == null) goto L14;
        String r4 = StringsKt.trim(r15).toString();
    L15:
        if (r4 != null) goto L18;
        r4 = "";
    L18:
        if (r14.getCollapseTemplateData() == null) goto L20;
    L29:
        long r5 = System.currentTimeMillis();
        t r18 = r0.update(r4, r14.getCollapseTemplateData(), r14.getExpandTemplateData(), r14.getMode());
        long r6 = System.currentTimeMillis() - r5;
        FLogger.a.i("LiveCardJSB", "op=update sessionKey=" + r18.b + " tag=" + r18.c + " ok=" + r18.a + " cost=" + r6 + "ms");
        Intrinsics.checkNotNullParameter(AbsLiveCardUpdateMethodIDL.b.class, "<this>");
        AbsLiveCardUpdateMethodIDL.b r19 = k3.c.a(AbsLiveCardUpdateMethodIDL.b.class);
        AbsLiveCardUpdateMethodIDL.b r7 = r19;
        r7.setOk(r18.a);
        r7.setSessionKey(r18.b);
        r7.setSessionTag(r18.c);
        r7.setError(r18.d);
        r13.b(r19, "");
        return;
    L20:
        if (r14.getExpandTemplateData() != null) goto L29;
        Intrinsics.checkNotNullParameter(AbsLiveCardUpdateMethodIDL.b.class, "<this>");
        AbsLiveCardUpdateMethodIDL.b r110 = k3.c.a(AbsLiveCardUpdateMethodIDL.b.class);
        AbsLiveCardUpdateMethodIDL.b r9 = r110;
        r9.setOk(false);
        if (r15 != null) goto L24;
        String r10 = "";
    L25:
        r9.setSessionKey(r10);
        if (r15 == null) goto L28;
        r8 = LiveCardJsbSessionManager.b(r15);
    L28:
        r9.setSessionTag(r8);
        JSONObject r111 = new JSONObject();
        r111.put("code", "INVALID_PARAM");
        r111.put("message", "collapseTemplateData/expandTemplateData is required");
        r9.setError(r111);
        r13.b(r110, "");
        return;
    L24:
        r10 = r15;
        goto L25
    L14:
        r4 = null;
        goto L15
    }
}
