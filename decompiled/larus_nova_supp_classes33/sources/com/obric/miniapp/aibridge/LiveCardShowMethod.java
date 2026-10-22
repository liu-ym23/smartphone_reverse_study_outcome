package com.obric.miniapp.aibridge;

import android.content.Context;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016¨\u0006\u000f"}, d2 = {"Lcom/obric/miniapp/aibridge/LiveCardShowMethod;", "Lcom/obric/miniapp/aibridge/AbsLiveCardShowMethodIDL;", "<init>", "()V", "mustRunInMain", "", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/obric/miniapp/aibridge/AbsLiveCardShowMethodIDL$ShowParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/obric/miniapp/aibridge/AbsLiveCardShowMethodIDL$ShowResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LiveCardShowMethod extends AbsLiveCardShowMethodIDL {
    public final boolean mustRunInMain() {
        return true;
    }

    public LiveCardShowMethod() {
    }

    public final void handle(e3.d r18, ParamModel r19, f3.h r20) {
        AbsLiveCardShowMethodIDL.a r1 = (AbsLiveCardShowMethodIDL.a) r19;
        Intrinsics.checkNotNullParameter(r18, "bridgeContext");
        Intrinsics.checkNotNullParameter(r1, "params");
        Intrinsics.checkNotNullParameter(r20, "callback");
        String r2 = r1.getSessionKey();
        LiveCardJsbSessionManager r3 = LiveCardJsbSessionManager.a;
        r3.getClass();
        String r4 = LiveCardJsbSessionManager.o(r2);
        String r9 = null;
        if (r4 == null) goto L12;
        Intrinsics.checkNotNullParameter(AbsLiveCardShowMethodIDL.b.class, "<this>");
        AbsLiveCardShowMethodIDL.b r5 = k3.c.a(AbsLiveCardShowMethodIDL.b.class);
        AbsLiveCardShowMethodIDL.b r6 = r5;
        r6.setOk(false);
        if (r2 != null) goto L7;
        String r8 = "";
    L8:
        r6.setSessionKey(r8);
        if (r2 == null) goto L11;
        r9 = LiveCardJsbSessionManager.b(r2);
    L11:
        r6.setSessionTag(r9);
        JSONObject r7 = new JSONObject();
        r7.put("code", "INVALID_PARAM");
        r7.put("message", r4);
        r6.setError(r7);
        r20.b(r5, "");
        return;
    L7:
        r8 = r2;
        goto L8
    L12:
        if (r2 == null) goto L14;
        String r10 = StringsKt.trim(r2).toString();
    L15:
        if (r10 != null) goto L17;
        String r11 = "";
    L18:
        JSONObject r13 = r1.getCollapse();
        JSONObject r14 = r1.getExpand();
        if (r13 == null) goto L23;
        if (r14 == null) goto L23;
        Context r12 = AppHost.a.getApplication().getApplicationContext();
        long r15 = System.currentTimeMillis();
        Intrinsics.checkNotNull(r12);
        t r16 = r3.k(r12, r11, r1.getCanFrontShow(), r13, r14, r1.getTrace(), r1.getAutoDismissDurationMs());
        long r17 = System.currentTimeMillis() - r15;
        FLogger.a.i("LiveCardJSB", "op=show sessionKey=" + r16.b + " tag=" + r16.c + " ok=" + r16.a + " cost=" + r17 + "ms");
        Intrinsics.checkNotNullParameter(AbsLiveCardShowMethodIDL.b.class, "<this>");
        AbsLiveCardShowMethodIDL.b r21 = k3.c.a(AbsLiveCardShowMethodIDL.b.class);
        AbsLiveCardShowMethodIDL.b r22 = r21;
        r22.setOk(r16.a);
        r22.setSessionKey(r16.b);
        r22.setSessionTag(r16.c);
        r22.setError(r16.d);
        r20.b(r21, "");
        return;
    L23:
        Intrinsics.checkNotNullParameter(AbsLiveCardShowMethodIDL.b.class, "<this>");
        AbsLiveCardShowMethodIDL.b r23 = k3.c.a(AbsLiveCardShowMethodIDL.b.class);
        AbsLiveCardShowMethodIDL.b r24 = r23;
        r24.setOk(false);
        if (r2 != null) goto L26;
        String r25 = "";
    L27:
        r24.setSessionKey(r25);
        if (r2 == null) goto L30;
        r9 = LiveCardJsbSessionManager.b(r2);
    L30:
        r24.setSessionTag(r9);
        JSONObject r26 = new JSONObject();
        r26.put("code", "INVALID_PARAM");
        r26.put("message", "collapse/expand is required");
        r24.setError(r26);
        r20.b(r23, "");
        return;
    L26:
        r25 = r2;
        goto L27
    L17:
        r11 = r10;
        goto L18
    L14:
        r10 = null;
        goto L15
    }
}
