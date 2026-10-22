package com.bytedance.ai.bridge.method.chat;

import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.bridge.core.b;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.doubao.chat.AbsGetChatConversationMethodIDL;
import com.bytedance.ai.utils.g;
import d3.a0;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J&\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ai/bridge/method/chat/GetChatConversationMethod;", "Lcom/bytedance/ai/bridge/doubao/chat/AbsGetChatConversationMethodIDL;", "<init>", "()V", "supportSyncCall", "", "getSupportSyncCall", "()Z", "handleSync", "Lcom/bytedance/ai/bridge/core/BridgeMethodResult;", "Lcom/bytedance/ai/bridge/doubao/chat/AbsGetChatConversationMethodIDL$GetChatConversationResultModel;", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/doubao/chat/AbsGetChatConversationMethodIDL$EmptyMessageModel;", "handle", "", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "failure", "Lcom/bytedance/ai/bridge/core/BridgeMethodResult$Failure;", "errNo", "Lcom/bytedance/ai/bridge/core/AIBridgeApiErr;", com.bytedance.android.ec.core.event.a.KEY_MSG, "", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetChatConversationMethod extends AbsGetChatConversationMethodIDL {
    public final boolean b;

    public static final class a {
    }

    static {
    }

    public GetChatConversationMethod() {
        this.b = true;
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean getSupportSyncCall() {
        return this.b;
    }

    public static com.bytedance.ai.bridge.core.a.b b(f3.a r10, String r11) {
        g.a.e("AISDK_JSB_GetChatConversationMethod", "call failed, errNo=" + r10.a + ", msg=" + r11);
        return new com.bytedance.ai.bridge.core.a.b(0, r11, null, r10, 21);
    }

    public static com.bytedance.ai.bridge.core.a c(d r10, AbsGetChatConversationMethodIDL.a r11) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, "params");
        a0 r12 = r10.getContainerContext();
        if (r12 == null) goto L5;
        String r13 = r12.getAppletId();
    L6:
        if (r13 != null) goto L8;
    L11:
        boolean r14 = true;
    L12:
        if (r14 == true) goto L14;
        AppletAppManagerService.INSTANCE.getClass();
        AppletApplication r15 = AppletAppManagerService.a(r13);
        if (r15 == null) goto L18;
        String r16 = r15.h().b().b;
        g.a.i("AISDK_JSB_GetChatConversationMethod", "call success, appId=" + r13 + ", conversationId=" + r16);
        Intrinsics.checkNotNullParameter(AbsGetChatConversationMethodIDL.b.class, "<this>");
        BaseModel r17 = c.a(AbsGetChatConversationMethodIDL.b.class);
        AbsGetChatConversationMethodIDL.b r0 = (AbsGetChatConversationMethodIDL.b) r17;
        if (r16 != null) goto L22;
        r16 = "";
    L22:
        r0.setConversationId(r16);
        return new com.bytedance.ai.bridge.core.a.c(r17);
    L18:
        return b(f3.a.q, "app " + r13 + " not found");
    L14:
        return b(f3.a.f, "app id is empty");
    L8:
        if (r13.length() == 0) goto L11;
        r14 = false;
        goto L12
    L5:
        r13 = null;
        goto L6
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final /* bridge */ /* synthetic */ com.bytedance.ai.bridge.core.a handleSync(d r1, ParamModel r10) {
        return c(r1, (AbsGetChatConversationMethodIDL.a) r10);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        AbsGetChatConversationMethodIDL.a r13 = (AbsGetChatConversationMethodIDL.a) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        b.a(c(r10, r13), r12);
    }
}
