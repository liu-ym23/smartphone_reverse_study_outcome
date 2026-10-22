package com.bytedance.ai.bridge.method.ui;

import android.graphics.Rect;
import com.bytedance.ai.applet.app.AppletAppActivity;
import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.bridge.core.b;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.system.ui.AbsGetMenuButtonBoundingClientRectMethodIDL;
import com.bytedance.ai.utils.g;
import d3.a0;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J&\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0012H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ai/bridge/method/ui/GetMenuButtonBoundingClientRectMethod;", "Lcom/bytedance/ai/bridge/system/ui/AbsGetMenuButtonBoundingClientRectMethodIDL;", "<init>", "()V", "supportSyncCall", "", "getSupportSyncCall", "()Z", "handleSync", "Lcom/bytedance/ai/bridge/core/BridgeMethodResult;", "Lcom/bytedance/ai/bridge/system/ui/AbsGetMenuButtonBoundingClientRectMethodIDL$MenuButtonBoundingClientRectModel;", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/system/ui/AbsGetMenuButtonBoundingClientRectMethodIDL$EmptyMessageModel;", "handle", "", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetMenuButtonBoundingClientRectMethod extends AbsGetMenuButtonBoundingClientRectMethodIDL {
    public final boolean b;

    public static final class a {
    }

    static {
    }

    public GetMenuButtonBoundingClientRectMethod() {
        this.b = true;
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean getSupportSyncCall() {
        return this.b;
    }

    public static com.bytedance.ai.bridge.core.a b(d r10, AbsGetMenuButtonBoundingClientRectMethodIDL.a r11) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, "params");
        a0 r12 = r10.getContainerContext();
        g r13 = g.a;
        StringBuilder r0 = new StringBuilder("call start, appletId=");
        String r1 = null;
        if (r12 == null) goto L5;
        String r14 = r12.getAppletId();
    L6:
        r0.append(r14);
        r0.append(", containerId=");
        if (r12 == null) goto L9;
        String r15 = r12.getContainerId();
    L10:
        r0.append(r15);
        r13.i("AISDK_JSB_GetMenuButtonBoundingClientRectMethod", r0.toString());
        if (r12 == null) goto L13;
        r1 = r12.getAppletId();
    L13:
        if (r1 != null) goto L15;
    L18:
        boolean r16 = true;
    L20:
        if (r16 == false) goto L23;
        StringBuilder r17 = new StringBuilder("call failed, errNo=");
        f3.a r18 = f3.a.f;
        r17.append(r18.a);
        r17.append(", msg=appId is null");
        r13.e("AISDK_JSB_GetMenuButtonBoundingClientRectMethod", r17.toString());
        return new com.bytedance.ai.bridge.core.a.b(0, "appId is null", null, r18, 21);
    L23:
        AppletAppManagerService.INSTANCE.getClass();
        AppletApplication r19 = AppletAppManagerService.a(r1);
        if (r19 == null) goto L30;
        AppletAppActivity r20 = r19.d;
        if (r20 == null) goto L30;
        Rect r21 = r20.K1();
        r13.i("AISDK_JSB_GetMenuButtonBoundingClientRectMethod", "call success");
        Intrinsics.checkNotNullParameter(AbsGetMenuButtonBoundingClientRectMethodIDL.b.class, "<this>");
        BaseModel r110 = c.a(AbsGetMenuButtonBoundingClientRectMethodIDL.b.class);
        AbsGetMenuButtonBoundingClientRectMethodIDL.b r22 = (AbsGetMenuButtonBoundingClientRectMethodIDL.b) r110;
        r22.setWidth(r21.width());
        r22.setHeight(r21.height());
        r22.setTop(r21.top);
        r22.setRight(r21.right);
        r22.setBottom(r21.bottom);
        r22.setLeft(r21.left);
        return new com.bytedance.ai.bridge.core.a.c(r110);
    L30:
        StringBuilder r23 = new StringBuilder("call failed, errNo=");
        f3.a r24 = f3.a.q;
        r23.append(r24.a);
        r23.append(", msg=appActivity is null");
        r13.e("AISDK_JSB_GetMenuButtonBoundingClientRectMethod", r23.toString());
        return new com.bytedance.ai.bridge.core.a.b(0, "appActivity is null", null, r24, 21);
    L15:
        if (r1.length() == 0) goto L18;
        r16 = false;
        goto L20
    L9:
        r15 = null;
        goto L10
    L5:
        r14 = null;
        goto L6
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final /* bridge */ /* synthetic */ com.bytedance.ai.bridge.core.a handleSync(d r1, ParamModel r10) {
        return b(r1, (AbsGetMenuButtonBoundingClientRectMethodIDL.a) r10);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        AbsGetMenuButtonBoundingClientRectMethodIDL.a r13 = (AbsGetMenuButtonBoundingClientRectMethodIDL.a) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        b.a(b(r10, r13), r12);
    }
}
