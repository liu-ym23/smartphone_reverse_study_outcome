package com.bytedance.ai.bridge.method.system;

import android.content.Context;
import android.view.View;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.system.window.AbsGetWindowInfoMethodIDL;
import com.bytedance.ai.utils.g;
import d3.a0;
import f3.h;
import f4.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J&\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0012H\u0016J\f\u0010\u0013\u001a\u00020\n*\u00020\u0014H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ai/bridge/method/system/GetWindowInfoMethod;", "Lcom/bytedance/ai/bridge/system/window/AbsGetWindowInfoMethodIDL;", "<init>", "()V", "supportSyncCall", "", "getSupportSyncCall", "()Z", "handleSync", "Lcom/bytedance/ai/bridge/core/BridgeMethodResult;", "Lcom/bytedance/ai/bridge/system/window/AbsGetWindowInfoMethodIDL$GetWindowInfoResultModel;", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/system/window/AbsGetWindowInfoMethodIDL$EmptyMessageModel;", "handle", "", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "toResultModel", "Lcom/bytedance/ai/bridge/method/system/WindowInfoHelper$WindowInfo;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetWindowInfoMethod extends AbsGetWindowInfoMethodIDL {
    public static final /* synthetic */ int c = 0;
    public final boolean b;

    public static final class a {
    }

    static {
    }

    public GetWindowInfoMethod() {
        this.b = true;
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean getSupportSyncCall() {
        return this.b;
    }

    public static AbsGetWindowInfoMethodIDL.b b(c.C0037c r10) {
        Intrinsics.checkNotNullParameter(AbsGetWindowInfoMethodIDL.b.class, "<this>");
        AbsGetWindowInfoMethodIDL.b r0 = (AbsGetWindowInfoMethodIDL.b) k3.c.a(AbsGetWindowInfoMethodIDL.b.class);
        r0.setPixelRatio(r10.a);
        r0.setScreenWidth(r10.b);
        r0.setScreenHeight(r10.c);
        r0.setWindowWidth(r10.d);
        r0.setWindowHeight(r10.e);
        r0.setStatusBarHeight(r10.f);
        c.b r11 = r10.g;
        r0.setSafeArea(new AbsGetWindowInfoMethodIDL.WindowSafeArea(r11.a, r11.b, r11.c, r11.d, r11.e, r11.f));
        r0.setScreenTop(r10.h);
        return r0;
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final com.bytedance.ai.bridge.core.a handleSync(e3.d r10, ParamModel r11) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsGetWindowInfoMethodIDL.a) r11, "params");
        g r12 = g.a;
        StringBuilder r0 = new StringBuilder("call start, appletId=");
        a0 r1 = r10.getContainerContext();
        Context r13 = null;
        if (r1 == null) goto L5;
        String r14 = r1.getAppletId();
    L6:
        r0.append(r14);
        r12.i("AISDK_JSB_GetWindowInfoMethod", r0.toString());
        int r15 = c.a;
        View r16 = r10.getEngineView();
        if (r16 == null) goto L9;
        r13 = r16.getContext();
    L9:
        c.C0037c r17 = c.d(r13);
        if (r17 != null) goto L12;
        StringBuilder r18 = new StringBuilder("call failed, errNo=");
        f3.a r19 = f3.a.f;
        r18.append(r19.a);
        r18.append(", msg=context not provided in host");
        r12.e("AISDK_JSB_GetWindowInfoMethod", r18.toString());
        return new com.bytedance.ai.bridge.core.a.b(0, "context not provided in host", null, r19, 21);
    L12:
        r12.i("AISDK_JSB_GetWindowInfoMethod", "call success");
        return new com.bytedance.ai.bridge.core.a.c(b(r17));
    L5:
        r14 = null;
        goto L6
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r10, ParamModel r11, final h r12) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsGetWindowInfoMethodIDL.a) r11, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        g r13 = g.a;
        StringBuilder r0 = new StringBuilder("call start, appletId=");
        a0 r1 = r10.getContainerContext();
        Context r14 = null;
        if (r1 == null) goto L5;
        String r15 = r1.getAppletId();
    L6:
        r0.append(r15);
        r13.i("AISDK_JSB_GetWindowInfoMethod", r0.toString());
        int r16 = c.a;
        View r17 = r10.getEngineView();
        if (r17 == null) goto L9;
        r14 = r17.getContext();
    L9:
        c.c(r14, new f(r12, this));
        return;
    L5:
        r15 = null;
        goto L6
    }
}
