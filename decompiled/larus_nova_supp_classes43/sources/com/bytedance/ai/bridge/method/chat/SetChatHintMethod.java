package com.bytedance.ai.bridge.method.chat;

import com.bytedance.ai.applet.app.AppletAppActivity;
import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.components.input.AppletChatInputController;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.doubao.chat.AbsSetChatHintMethodIDL;
import com.bytedance.ai.utils.g;
import d3.a0;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J&\u0010\r\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ai/bridge/method/chat/SetChatHintMethod;", "Lcom/bytedance/ai/bridge/doubao/chat/AbsSetChatHintMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/doubao/chat/AbsSetChatHintMethodIDL$SetChatHintParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/doubao/chat/AbsSetChatHintMethodIDL$EmptyMessageModel;", "fail", "errNo", "Lcom/bytedance/ai/bridge/core/AIBridgeApiErr;", com.bytedance.android.ec.core.event.a.KEY_MSG, "", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SetChatHintMethod extends AbsSetChatHintMethodIDL {

    public static final class a {
    }

    static {
    }

    public SetChatHintMethod() {
    }

    public final void b(h<AbsSetChatHintMethodIDL.a> r10, f3.a r11, String r12) {
        g.a.e("AISDK_JSB_SetChatHintMethod", "call failed, errNo=" + r11.a + ", msg=" + r12);
        h.a.a(r10, r12, r11, null, 10);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        AbsSetChatHintMethodIDL.b r13 = (AbsSetChatHintMethodIDL.b) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        a0 r14 = r10.getContainerContext();
        if (r14 == null) goto L5;
        String r15 = r14.getAppletId();
    L6:
        int r0 = 0;
        if (r15 != null) goto L9;
    L12:
        boolean r1 = true;
    L13:
        if (r1 == false) goto L15;
        b(r12, f3.a.f, "appId is empty");
        return;
    L15:
        AppletAppManagerService.INSTANCE.getClass();
        AppletApplication r16 = AppletAppManagerService.a(r15);
        if (r16 != null) goto L18;
        b(r12, f3.a.q, "app " + r15 + " not found");
        return;
    L18:
        com.bytedance.ai.applet.app.foundation.a r17 = r16.h().b();
        String r18 = r13.getInputHint();
        String r19 = r13.getSpeakHint();
        r17.c = r18;
        r17.d = r19;
        AppletAppActivity r20 = r17.a.d;
        if (r20 == null) goto L23;
        AppletChatInputController r21 = r20.H1();
        if (r21 == null) goto L23;
        r21.x7(r18, r19);
    L23:
        g r22 = g.a;
        StringBuilder r23 = new StringBuilder("call success, appletId=");
        r23.append(r15);
        r23.append(", inputHintLength=");
        String r24 = r13.getInputHint();
        if (r24 == null) goto L26;
        int r25 = r24.length();
    L27:
        r23.append(r25);
        r23.append(", speakHintLength=");
        String r26 = r13.getSpeakHint();
        if (r26 == null) goto L30;
        r0 = r26.length();
    L30:
        r23.append(r0);
        r22.i("AISDK_JSB_SetChatHintMethod", r23.toString());
        Intrinsics.checkNotNullParameter(AbsSetChatHintMethodIDL.a.class, "<this>");
        r12.b((ResultModel) c.a(AbsSetChatHintMethodIDL.a.class), "");
        return;
    L26:
        r25 = 0;
        goto L27
    L9:
        if (r15.length() == 0) goto L12;
        r1 = false;
        goto L13
    L5:
        r15 = null;
        goto L6
    }
}
