package com.bytedance.ai.bridge.method.router;

import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.ai.applet.app.OnlineAppletApplication;
import com.bytedance.ai.applet.app.base.RouteOptions;
import com.bytedance.ai.applet.app.foundation.performance.AppletPerformanceNavigationType;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.router.AbsRedirectToMethodIDL;
import d3.a0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/router/RedirectToMethod;", "Lcom/bytedance/ai/bridge/router/AbsRedirectToMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/router/AbsRedirectToMethodIDL$RedirectToRequestModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/router/AbsRedirectToMethodIDL$EmptyMessageModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RedirectToMethod extends AbsRedirectToMethodIDL {

    public static final class a {
    }

    static {
    }

    public RedirectToMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r25, ParamModel r26, f3.h r27) {
        AbsRedirectToMethodIDL.b r10 = (AbsRedirectToMethodIDL.b) r26;
        Intrinsics.checkNotNullParameter(r25, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r27, "callback");
        long r12 = System.currentTimeMillis();
        com.bytedance.ai.utils.g r11 = com.bytedance.ai.utils.g.a;
        r11.i("AISDK_JSB_RedirectToMethod", "call start, path=" + StringsKt.substringBefore$default(r10.getUrl(), "?", null, 2, null));
        a0 r1 = r25.getContainerContext();
        if (r1 != null) goto L5;
        StringBuilder r13 = new StringBuilder("call failed, errNo=");
        f3.a r14 = f3.a.f;
        r13.append(r14.a);
        r13.append(", msg=appId is null");
        r11.e("AISDK_JSB_RedirectToMethod", r13.toString());
        f3.h.a.a(r27, "appId is null", r14, null, 10);
        return;
    L5:
        String r15 = r1.getAppletId();
        if (r15 != null) goto L8;
        StringBuilder r16 = new StringBuilder("call failed, errNo=");
        f3.a r17 = f3.a.f;
        r16.append(r17.a);
        r16.append(", msg=appId is null");
        r11.e("AISDK_JSB_RedirectToMethod", r16.toString());
        f3.h.a.a(r27, "appId is null", r17, null, 10);
        return;
    L8:
        String r18 = r1.getConversationId();
        AppletAppManagerService.INSTANCE.getClass();
        OnlineAppletApplication r19 = AppletAppManagerService.b(r15);
        if (r19 == null) goto L14;
        com.bytedance.ai.applet.app.foundation.performance.r r110 = r19.h().c().b(new com.bytedance.ai.applet.app.foundation.performance.p(r12, t2.c.a(r10.getUrl()), AppletPerformanceNavigationType.REDIRECT_TO, r1.getPath(), r1.getTraceId()));
        if (BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r19), null, null, new RedirectToMethod$handle$1$1(r1, r19, r25, r18, r10, new RouteOptions(r18, Long.valueOf(r110.c)), r27, r110, null), 3, null) == null) goto L14;
        return;
    L14:
        StringBuilder r0 = new StringBuilder("call failed, errNo=");
        f3.a r20 = f3.a.f;
        r0.append(r20.a);
        r0.append(", msg=app ");
        r0.append(r15);
        r0.append(" not found");
        r11.e("AISDK_JSB_RedirectToMethod", r0.toString());
        f3.h.a.a(r27, "app " + r15 + " not found", r20, null, 10);
        Unit r21 = Unit.INSTANCE;
    }
}
