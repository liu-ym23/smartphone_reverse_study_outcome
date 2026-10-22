package com.bytedance.ai.bridge.method.message;

import com.bytedance.ai.applet.app.AppletAppActivity;
import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.app.AppletEightScreenActivity;
import com.bytedance.ai.applet.app.foundation.v;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.google.gson.JsonObject;
import d3.a0;
import f3.h;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/message/SendFollowUpMessageMethod;", "Lcom/bytedance/ai/bridge/method/message/AbsSendFollowUpMessageMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/method/message/AbsSendFollowUpMessageMethodIDL$SendFollowUpMessageParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/method/message/AbsSendFollowUpMessageMethodIDL$SendFollowUpMessageResultModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SendFollowUpMessageMethod extends AbsSendFollowUpMessageMethodIDL {
    public static final /* synthetic */ int b = 0;

    public static final class a {
    }

    static {
    }

    public SendFollowUpMessageMethod() {
    }

    /* JADX WARN: Type inference failed for: r10v8, types: [com.bytedance.ai.bridge.method.message.b] */
    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r10, ParamModel r11, final h r12) {
        final AbsSendFollowUpMessageMethodIDL.a r13 = (AbsSendFollowUpMessageMethodIDL.a) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        Iterator<T> r14 = r13.getContent().iterator();
    L3:
        final AppletEightScreenActivity r15 = null;
        if (r14.hasNext() == false) goto L8;
        Object r0 = r14.next();
        if (Intrinsics.areEqual(e.a((JsonObject) r0, "type"), "text") == false) goto L3;
    L9:
        JsonObject r1 = (JsonObject) r0;
        if (r1 == null) goto L12;
        final String r16 = e.a(r1, "text");
    L13:
        boolean r17 = false;
        if (r16 != null) goto L16;
    L19:
        boolean r18 = true;
    L21:
        if (r18 == false) goto L23;
        h.a.a(r12, "content must contain a text item", null, null, 14);
        return;
    L23:
        a0 r19 = r10.getContainerContext();
        if (r19 == null) goto L28;
        String r20 = r19.getAppletId();
        if (r20 == null) goto L28;
        AppletAppManagerService.INSTANCE.getClass();
        AppletApplication r21 = AppletAppManagerService.a(r20);
    L29:
        if (r21 == null) goto L44;
        v r22 = r21.h();
        if (r22 == null) goto L44;
        com.bytedance.ai.applet.app.foundation.a r23 = r22.b();
        if (r23 == null) goto L44;
        String r24 = r23.b;
        if (r24 == null) goto L44;
        if (r24.length() <= 0) goto L39;
        r17 = true;
    L39:
        if (r17 == true) goto L42;
        r24 = null;
    L42:
        if (r24 == null) goto L44;
        String r25 = r24;
    L49:
        final r4.h r26 = r4.a.l;
        if (r26 != null) goto L52;
        h.a.a(r12, "hostMessageDepend is null", null, null, 14);
        return;
    L52:
        final String r27 = r25;
        final ?? r110 = new b(r26, r27, r16, r13, r12);
        if (r21 == null) goto L55;
        AppletAppActivity r28 = r21.d;
    L57:
        if ((r28 instanceof AppletEightScreenActivity) == false) goto L59;
        r15 = (AppletEightScreenActivity) r28;
    L59:
        if (r15 == null) goto L61;
        p2.c.d(new c(r15, r110));
        return;
    L61:
        r110.invoke();
        return;
    L55:
        r28 = null;
    L44:
        if (r19 == null) goto L46;
        r25 = r19.getConversationId();
    L47:
        if (r25 != null) goto L49;
        r25 = "";
        goto L49
    L46:
        r25 = null;
    L28:
        r21 = null;
        goto L29
    L16:
        if (r16.length() == 0) goto L19;
        r18 = false;
        goto L21
    L12:
        r16 = null;
        goto L13
    L8:
        r0 = null;
        goto L9
    }
}
