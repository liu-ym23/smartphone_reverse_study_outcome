package com.bytedance.ai.bridge.method.chat;

import com.bytedance.ai.applet.app.AppletAppActivity;
import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.app.foundation.v;
import com.bytedance.ai.applet.components.input.AppletChatInputController;
import com.bytedance.ai.applet.components.input.AppletChatPanelState;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.doubao.chat.AbsGetChatPanelInfoMethodIDL;
import com.bytedance.ai.utils.g;
import d3.a0;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import r2.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J&\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0012H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ai/bridge/method/chat/GetChatPanelInfoMethod;", "Lcom/bytedance/ai/bridge/doubao/chat/AbsGetChatPanelInfoMethodIDL;", "<init>", "()V", "supportSyncCall", "", "getSupportSyncCall", "()Z", "handleSync", "Lcom/bytedance/ai/bridge/core/BridgeMethodResult;", "Lcom/bytedance/ai/bridge/doubao/chat/AbsGetChatPanelInfoMethodIDL$ChatPanelInfoModel;", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/doubao/chat/AbsGetChatPanelInfoMethodIDL$EmptyMessageModel;", "handle", "", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetChatPanelInfoMethod extends AbsGetChatPanelInfoMethodIDL {
    public final boolean b;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[AppletChatPanelState.values().length];
            r0[AppletChatPanelState.COLLAPSED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[AppletChatPanelState.PREVIEW.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[AppletChatPanelState.EXPANDED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[AppletChatPanelState.INVISIBLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    static {
    }

    public GetChatPanelInfoMethod() {
        this.b = true;
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean getSupportSyncCall() {
        return this.b;
    }

    public static com.bytedance.ai.bridge.core.a b(d r10, AbsGetChatPanelInfoMethodIDL.b r11) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, "params");
        a0 r12 = r10.getContainerContext();
        f r13 = null;
        if (r12 == null) goto L5;
        String r14 = r12.getAppletId();
    L7:
        if (r14 != null) goto L9;
    L12:
        boolean r15 = true;
    L14:
        if (r15 == false) goto L17;
        g.a.e("AISDK_JSB_GetChatPanelInfoMethod", "call failed, appletId is null");
        return new com.bytedance.ai.bridge.core.a.b(0, "appletId is null", null, f3.a.f, 21);
    L17:
        AppletAppManagerService.INSTANCE.getClass();
        AppletApplication r16 = AppletAppManagerService.a(r14);
        if (r16 == null) goto L34;
        v r17 = r16.h();
        if (r17 == null) goto L34;
        com.bytedance.ai.applet.app.foundation.a r18 = r17.b();
        if (r18 == null) goto L34;
        AppletAppActivity r19 = r18.a.d;
        if (r19 == null) goto L32;
        AppletChatInputController r20 = r19.H1();
        if (r20 == null) goto L32;
        if (r20.getVisibility() == false) goto L32;
        r13 = r20.u6();
    L32:
        if (r13 == null) goto L34;
    L35:
        g.a.i("AISDK_JSB_GetChatPanelInfoMethod", "call success, appletId=" + r14 + ", panelInfo=" + r13);
        Intrinsics.checkNotNullParameter(AbsGetChatPanelInfoMethodIDL.a.class, "<this>");
        BaseModel r110 = c.a(AbsGetChatPanelInfoMethodIDL.a.class);
        AbsGetChatPanelInfoMethodIDL.a r1 = (AbsGetChatPanelInfoMethodIDL.a) r110;
        r1.setHeight((int) n2.a.c(Integer.valueOf(r13.a)));
        int r111 = b.a[r13.b.ordinal()];
        if (r111 != 1) goto L38;
        AbsGetChatPanelInfoMethodIDL.ChatPanelState r112 = AbsGetChatPanelInfoMethodIDL.ChatPanelState.COLLAPSED;
    L49:
        r1.setState(r112);
        return new com.bytedance.ai.bridge.core.a.c(r110);
    L38:
        if (r111 != 2) goto L40;
        r112 = AbsGetChatPanelInfoMethodIDL.ChatPanelState.PREVIEW;
        goto L49
    L40:
        if (r111 != 3) goto L42;
        r112 = AbsGetChatPanelInfoMethodIDL.ChatPanelState.EXPANDED;
        goto L49
    L42:
        if (r111 != 4) goto L45;
        r112 = AbsGetChatPanelInfoMethodIDL.ChatPanelState.INVISIBLE;
        goto L49
    L45:
        throw new NoWhenBranchMatchedException();
    L34:
        r13 = new f(0, AppletChatPanelState.INVISIBLE);
        goto L35
    L9:
        if (r14.length() == 0) goto L12;
        r15 = false;
        goto L14
    L5:
        r14 = null;
        goto L7
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final /* bridge */ /* synthetic */ com.bytedance.ai.bridge.core.a handleSync(d r1, ParamModel r10) {
        return b(r1, (AbsGetChatPanelInfoMethodIDL.b) r10);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        AbsGetChatPanelInfoMethodIDL.b r13 = (AbsGetChatPanelInfoMethodIDL.b) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        com.bytedance.ai.bridge.core.b.a(b(r10, r13), r12);
    }
}
