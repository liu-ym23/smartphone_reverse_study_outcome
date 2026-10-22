package com.bytedance.ai.bridge.method.login;

import com.bytedance.ai.applet.granting.GrantingAction;
import com.bytedance.ai.applet.login.LoginProcessor;
import com.bytedance.ai.applet.login.OperationType;
import com.bytedance.ai.bridge.closePrivacyLoginCard.AbsClosePrivacyLoginCardMethodIDL;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import d3.a0;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/login/ClosePrivacyLoginCardMethod;", "Lcom/bytedance/ai/bridge/closePrivacyLoginCard/AbsClosePrivacyLoginCardMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/closePrivacyLoginCard/AbsClosePrivacyLoginCardMethodIDL$ClosePrivacyLoginCardRequestModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/closePrivacyLoginCard/AbsClosePrivacyLoginCardMethodIDL$EmptyMessageModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ClosePrivacyLoginCardMethod extends AbsClosePrivacyLoginCardMethodIDL {
    public static final /* synthetic */ int b = 0;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[OperationType.values().length];
            r0[OperationType.PRIVACY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[OperationType.LOGIN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    public ClosePrivacyLoginCardMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r12, ParamModel r13, final f3.h r14) {
        AbsClosePrivacyLoginCardMethodIDL.a r15 = (AbsClosePrivacyLoginCardMethodIDL.a) r13;
        Intrinsics.checkNotNullParameter(r12, "bridgeContext");
        Intrinsics.checkNotNullParameter(r15, "params");
        Intrinsics.checkNotNullParameter(r14, "callback");
        a0 r0 = r12.getContainerContext();
        a0 r1 = r12.getContainerContext();
        String r10 = null;
        if (r1 == null) goto L5;
        String r11 = r1.getAppId();
    L6:
        a0 r16 = r12.getContainerContext();
        if (r16 == null) goto L9;
        final String r17 = r16.getAppletId();
    L10:
        if (r17 != null) goto L12;
    L15:
        boolean r18 = true;
    L17:
        if (r18 == false) goto L19;
        com.bytedance.ai.utils.g.a.e("ClosePrivacyLoginCardMethod", "appletId is null or empty");
        f3.h.a.a(r14, "Error: appletId is null or empty", null, null, 14);
        return;
    L19:
        com.bytedance.ai.utils.g r19 = com.bytedance.ai.utils.g.a;
        r19.i("ClosePrivacyLoginCardMethod", "handle close privacy/login card: " + r11 + ", applet: " + r17);
        String r20 = r15.getType();
        if (Intrinsics.areEqual(r20, "privacy") == false) goto L23;
        final OperationType r110 = OperationType.PRIVACY;
    L25:
        com.bytedance.ai.applet.moa.k r21 = com.bytedance.ai.applet.moa.k.a;
        if (r0 == null) goto L28;
        String r22 = r0.getConversationId();
    L29:
        if (r0 == null) goto L31;
        r10 = r0.getUrl();
    L31:
        Function1 r23 = new e(r17, r110, r14);
        Function0 r24 = new f(r14);
        r21.getClass();
        if (com.bytedance.ai.applet.moa.k.d(r22, r10, r17, "close-card action", r23, r24) == false) goto L34;
        r19.i("ClosePrivacyLoginCardMethod", "MOA consumed callback, skip normal close-card flow: applet=".concat(r17));
        return;
    L34:
        LoginProcessor r25 = LoginProcessor.a;
        GrantingAction r26 = GrantingAction.DISMISSED;
        r25.getClass();
        LoginProcessor.i(r17, r26, r110);
        Intrinsics.checkNotNullParameter(AbsClosePrivacyLoginCardMethodIDL.b.class, "<this>");
        r14.b((ResultModel) k3.c.a(AbsClosePrivacyLoginCardMethodIDL.b.class), "");
        return;
    L28:
        r22 = null;
        goto L29
    L23:
        if (Intrinsics.areEqual(r20, "login") == false) goto L35;
        r110 = OperationType.LOGIN;
        goto L25
    L35:
        r19.e("ClosePrivacyLoginCardMethod", "Unknown type received: " + r15.getType());
        f3.h.a.a(r14, "Error: Unknown type", null, null, 14);
        return;
    L12:
        if (r17.length() == 0) goto L15;
        r18 = false;
        goto L17
    L9:
        r17 = null;
        goto L10
    L5:
        r11 = null;
        goto L6
    }
}
