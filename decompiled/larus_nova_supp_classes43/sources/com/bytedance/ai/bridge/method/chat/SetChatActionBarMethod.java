package com.bytedance.ai.bridge.method.chat;

import com.bytedance.ai.applet.app.AppletAppActivity;
import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.components.input.AppletChatInputController;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.doubao.chat.AbsSetChatActionBarMethodIDL;
import com.bytedance.ai.utils.g;
import d3.a0;
import e3.d;
import f3.h;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import r2.c;
import r3.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J&\u0010\r\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ai/bridge/method/chat/SetChatActionBarMethod;", "Lcom/bytedance/ai/bridge/doubao/chat/AbsSetChatActionBarMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/doubao/chat/AbsSetChatActionBarMethodIDL$SetChatActionBarParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/doubao/chat/AbsSetChatActionBarMethodIDL$EmptyMessageModel;", "fail", "errNo", "Lcom/bytedance/ai/bridge/core/AIBridgeApiErr;", com.bytedance.android.ec.core.event.a.KEY_MSG, "", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SetChatActionBarMethod extends AbsSetChatActionBarMethodIDL {

    public static final class a {
    }

    static {
    }

    public SetChatActionBarMethod() {
    }

    public final void b(h<AbsSetChatActionBarMethodIDL.a> r10, f3.a r11, String r12) {
        g.a.e("AISDK_JSB_SetChatActionBarMethod", "call failed, errNo=" + r11.a + ", msg=" + r12);
        h.a.a(r10, r12, r11, null, 10);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        AbsSetChatActionBarMethodIDL.b r13 = (AbsSetChatActionBarMethodIDL.b) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        a0 r14 = r10.getContainerContext();
        if (r14 == null) goto L5;
        String r15 = r14.getAppletId();
    L6:
        if (r15 != null) goto L8;
    L11:
        boolean r0 = true;
    L12:
        if (r0 == false) goto L14;
        b(r12, f3.a.f, "appletId is empty");
        return;
    L14:
        AppletAppManagerService.INSTANCE.getClass();
        AppletApplication r1 = AppletAppManagerService.a(r15);
        if (r1 != null) goto L34;
        b(r12, f3.a.q, "app " + r15 + " not found");
        return;
    L34:
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L19
        Object r17 = Result.constructor-impl(b.a(CollectionsKt.toList(r13.getItems())));     // Catch: Throwable -> L19
    L21:
        Throwable r18 = Result.exceptionOrNull-impl(r17);
        if (r18 != null) goto L29;
        c r19 = (c) r17;
        com.bytedance.ai.applet.app.foundation.a r20 = r1.h().b();
        r20.getClass();
        Intrinsics.checkNotNullParameter(r19, "config");
        AppletAppActivity r21 = r20.a.d;
        if (r21 == null) goto L28;
        AppletChatInputController r22 = r21.H1();
        if (r22 == null) goto L28;
        r22.v7(r19);
    L28:
        g.a.i("AISDK_JSB_SetChatActionBarMethod", "call success, appletId=" + r15 + ", itemCount=" + r19.a.size());
        Intrinsics.checkNotNullParameter(AbsSetChatActionBarMethodIDL.a.class, "<this>");
        r12.b((ResultModel) k3.c.a(AbsSetChatActionBarMethodIDL.a.class), "");
        return;
    L29:
        f3.a r23 = f3.a.h;
        String r24 = r18.getMessage();
        if (r24 != null) goto L32;
        r24 = "invalid action bar config";
    L32:
        b(r12, r23, r24);
        return;
    L19:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L21
    L8:
        if (r15.length() == 0) goto L11;
        r0 = false;
        goto L12
    L5:
        r15 = null;
        goto L6
    }
}
