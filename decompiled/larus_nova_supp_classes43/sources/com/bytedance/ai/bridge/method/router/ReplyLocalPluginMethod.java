package com.bytedance.ai.bridge.method.router;

import androidx.collection.LruCache;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.model.clienttool.ClientToolRuntime;
import com.google.gson.JsonElement;
import d3.z;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u000e\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u000fH\u0002¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ai/bridge/method/router/ReplyLocalPluginMethod;", "Lcom/bytedance/ai/bridge/method/router/AbsReplyLocalPluginMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/method/router/AbsReplyLocalPluginMethodIDL$ReplyLocalPluginParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/method/router/AbsReplyLocalPluginMethodIDL$ReplyLocalPluginResultModel;", "toReplyLocalPluginData", "", "Lcom/google/gson/JsonElement;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReplyLocalPluginMethod extends AbsReplyLocalPluginMethodIDL {
    public static final /* synthetic */ int b = 0;

    public static final class a {
    }

    static {
    }

    public ReplyLocalPluginMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r17, ParamModel r18, final f3.h r19) {
        final AbsReplyLocalPluginMethodIDL.a r10 = (AbsReplyLocalPluginMethodIDL.a) r18;
        Intrinsics.checkNotNullParameter(r17, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r19, "callback");
        JSONObject r1 = r10.getContext();
        final String r11 = r1.optString("callbackId");
        LruCache<Long, com.bytedance.ai.utils.j.a> r12 = com.bytedance.ai.utils.j.a;
        if (r11 != null) goto L5;
        com.bytedance.ai.utils.j.a r13 = null;
    L6:
        if (r13 == null) goto L10;
        com.bytedance.ai.utils.j.c r14 = r13.q;
        if (r14 == null) goto L10;
        r14.a();
    L10:
        final String r15 = r1.optString("botId");
        ClientToolRuntime r16 = (ClientToolRuntime) r17.d(ClientToolRuntime.class);
        if (r16 == null) goto L70;
        boolean r0 = r10.getSuccess();
        String r110 = r10.getMessage();
        JsonElement r20 = r10.getData();
        Intrinsics.checkNotNullParameter(r1, "context");
        Object r21 = r16.i;
        monitor-enter(r21);
        ClientToolRuntime.d r22 = r16.l;     // Catch: Throwable -> L67
        if ((r22 instanceof ClientToolRuntime.d.e) == false) goto L18;
        ClientToolRuntime.d.e r23 = (ClientToolRuntime.d.e) r22;     // Catch: Throwable -> L67
    L19:
        boolean r24 = false;
        if (r23 != null) goto L23;
        monitor-exit(r21);
    L64:
        if (r24 == false) goto L66;
        Intrinsics.checkNotNullParameter(AbsReplyLocalPluginMethodIDL.b.class, "<this>");
        r19.b((ResultModel) k3.c.a(AbsReplyLocalPluginMethodIDL.b.class), "");
        return;
    L66:
        f3.h.a.a(r19, "Client Tool reply context does not match current request", null, null, 14);
        return;
    L23:
        ClientToolRuntime.a r25 = r23.a;     // Catch: Throwable -> L67
        if (Intrinsics.areEqual(r1.optString("msgId"), r25.i) == false) goto L28;
        if (Intrinsics.areEqual(r1.optString("callbackId"), r25.c) == false) goto L28;
        boolean r26 = true;
    L29:
        if (r26 == true) goto L32;
        r25 = null;
    L32:
        monitor-exit(r21);
        if (r25 != null) goto L36;
        com.bytedance.ai.utils.g.a.w("ClientToolRuntime", "reject mismatched reply runtimeId=" + r16.c);
        goto L64
    L36:
        if (r0 == false) goto L38;
        int r111 = 0;
    L39:
        if (r20 != null) goto L41;
        String r112 = null;
    L55:
        if (r0 == false) goto L57;
        String r113 = null;
    L58:
        if (r0 == false) goto L60;
        String r27 = null;
    L61:
        r24 = r16.c(r25, new ClientToolRuntime.c(r111, r110, r112, r113, r27), true);
        if (r24 == false) goto L64;
        com.bytedance.ai.utils.g.a.i("ClientToolRuntime", "accept reply runtimeId=" + r16.c + " messageId=" + r25.i + " success=" + r0);
        goto L64
    L60:
        r27 = "tool_failed";
        goto L61
    L57:
        r113 = "reply";
        goto L58
    L41:
        if (r20.isJsonNull() == false) goto L44;
        String r28 = null;
    L53:
        r112 = r28;
        goto L55
    L44:
        if (r20.isJsonPrimitive() == false) goto L47;
        r28 = r20.getAsJsonPrimitive().getAsString();
        goto L53
    L47:
        if (r20.isJsonObject() == false) goto L50;
        r28 = new JSONObject(r20.toString()).toString();
        goto L53
    L50:
        if (r20.isJsonArray() == false) goto L52;
        r28 = new JSONArray(r20.toString()).toString();
        goto L53
    L52:
        r28 = r20.toString();
        goto L53
    L38:
        r111 = -1;
    L28:
        r26 = false;
        goto L29
    L18:
        r23 = null;
    L67:
        th = move-exception;
        throw th;
    L70:
        z r29 = (z) r17.d(z.class);
        if (r29 != null) goto L73;
        com.bytedance.ai.utils.g.a.e("ReplyLocalPluginMethod", "appletRuntimeProvider is null");
        f3.h.a.a(r19, "appletRuntimeProvider is null", null, null, 14);
        return;
    L73:
        final com.bytedance.ai.utils.j.a r30 = r13;
        r29.a(new r(r30, r19, r15, r10, this, r11));
        return;
    L5:
        r13 = (com.bytedance.ai.utils.j.a) com.bytedance.ai.utils.j.b.get(r11);
        goto L6
    }
}
