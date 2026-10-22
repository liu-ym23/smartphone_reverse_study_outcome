package com.bytedance.ai.bridge.method.router;

import androidx.collection.LruCache;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.s;
import com.lynx.jsbridge.LynxResourceModule;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ai/bridge/method/router/ReplyLocalPluginMethod;", "Lcom/bytedance/ai/bridge/method/router/AbsReplyLocalPluginMethodIDL;", "<init>", "()V", "Ln1/c;", "bridgeContext", "Lcom/bytedance/ai/bridge/method/router/AbsReplyLocalPluginMethodIDL$ReplyLocalPluginParamModel;", LynxResourceModule.PARAMS_KEY, "Lo1/f;", "Lcom/bytedance/ai/bridge/method/router/AbsReplyLocalPluginMethodIDL$ReplyLocalPluginResultModel;", "callback", "", "handle", "(Ln1/c;Lcom/bytedance/ai/bridge/method/router/AbsReplyLocalPluginMethodIDL$ReplyLocalPluginParamModel;Lo1/f;)V", "Companion", "com/bytedance/ai/bridge/method/router/m", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ReplyLocalPluginMethod extends AbsReplyLocalPluginMethodIDL {
    public static final m Companion = null;
    private static final String TAG = "ReplyLocalPluginMethod";

    static {
        Companion = new m();
    }

    public ReplyLocalPluginMethod() {
    }

    public static /* synthetic */ Unit b(o1.f r10, String r11, AbsReplyLocalPluginMethodIDL.ReplyLocalPluginParamModel r12, String r13, AppletRuntime r14) {
        return handle$lambda$0(null, r10, r11, r12, r13, r14);
    }

    private static final Unit handle$lambda$0(com.bytedance.ai.utils.d r5, o1.f r10, String r11, AbsReplyLocalPluginMethodIDL.ReplyLocalPluginParamModel r12, String r13, AppletRuntime r14) {
        if (r14 != null) goto L9;
        Intrinsics.checkNotNullParameter(TAG, "tag");
        t0.d r15 = com.bytedance.ai.utils.c.f2846a;
        if (r15 == null) goto L7;
        r15.e(TAG, "applet runtime is null");
    L7:
        r10.a("applet runtime is null");
        return Unit.INSTANCE;
    L9:
        Intrinsics.checkNotNull(r11);
        r12.getSuccess();
        r12.getMessage();
        JSONObject r16 = r12.getData();
        if (r16 == null) goto L12;
        r16.toString();
    L12:
        Intrinsics.checkNotNull(r13);
        Intrinsics.checkNotNullParameter(r11, "botId");
        Intrinsics.checkNotNullParameter(r13, "callbackID");
        LruCache r17 = com.bytedance.ai.utils.e.f2847a;
        if (r13 == null) goto L18;
        if (com.bytedance.ai.utils.e.f2848b.get(r13) == null) goto L18;
        throw new ClassCastException();
    L18:
        if (r14.f2208t.remove(r13) != null) goto L25;
        Intrinsics.checkNotNullParameter("WorkerRuntime", "tag");
        t0.d r18 = com.bytedance.ai.utils.c.f2846a;
        if (r18 == null) goto L22;
        r18.e("WorkerRuntime", "CreateWidget error, No found callback.");
    L22:
        Intrinsics.checkNotNullParameter("No found callback.", "message");
        r10.a("No found callback.");
        return Unit.INSTANCE;
    L25:
        throw new ClassCastException();
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(n1.c r5, ParamModel r10, o1.f r11) {
        handle(r5, (AbsReplyLocalPluginMethodIDL.ReplyLocalPluginParamModel) r10, r11);
    }

    public void handle(n1.c r10, AbsReplyLocalPluginMethodIDL.ReplyLocalPluginParamModel r11, o1.f r12) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r12, "callback");
        JSONObject r13 = r11.getContext();
        String r14 = r13.optString("callbackId");
        LruCache r5 = com.bytedance.ai.utils.e.f2847a;
        if (r14 != null) goto L6;
    L7:
        String r15 = r13.optString("botId");
        s r16 = (s) ((n1.a) r10).b(s.class);
        if (r16 != null) goto L14;
        Intrinsics.checkNotNullParameter(TAG, "tag");
        t0.d r17 = com.bytedance.ai.utils.c.f2846a;
        if (r17 == null) goto L12;
        r17.e(TAG, "appletRuntimeProvider is null");
    L12:
        r12.a("appletRuntimeProvider is null");
        return;
    L14:
        r16.a(new a2.c(3, r12, r15, r11, r14));
        return;
    L6:
        if (com.bytedance.ai.utils.e.f2848b.get(r14) == null) goto L7;
        throw new ClassCastException();
    }
}
