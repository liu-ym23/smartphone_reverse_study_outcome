package com.bytedance.ai.bridge.method.router;

import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.app.base.ApplicationRouter;
import com.bytedance.ai.applet.app.base.RouteOptions;
import com.bytedance.ai.applet.app.foundation.performance.AppletPerformanceNavigationType;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import d3.a0;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u000e\u0010\r\u001a\u00020\u000e*\u0004\u0018\u00010\u000fH\u0002¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ai/bridge/method/router/OpenPageRouteMethod;", "Lcom/bytedance/ai/bridge/router/AbsOpenPageMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/router/AbsOpenPageMethodIDL$OpenPageRequestModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/router/AbsOpenPageMethodIDL$EmptyMessageModel;", "toRouterMode", "Lcom/bytedance/ai/applet/app/base/ApplicationRouter$OpenPageMode;", "Lcom/bytedance/ai/bridge/router/AbsOpenPageMethodIDL$OpenPageMode;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenPageRouteMethod extends com.bytedance.ai.bridge.router.AbsOpenPageMethodIDL {

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[com.bytedance.ai.bridge.router.AbsOpenPageMethodIDL.OpenPageMode.values().length];
            r0[com.bytedance.ai.bridge.router.AbsOpenPageMethodIDL.OpenPageMode.PUSH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[com.bytedance.ai.bridge.router.AbsOpenPageMethodIDL.OpenPageMode.REPLACE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[com.bytedance.ai.bridge.router.AbsOpenPageMethodIDL.OpenPageMode.NAVIGATE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[com.bytedance.ai.bridge.router.AbsOpenPageMethodIDL.OpenPageMode.POP_TO.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    static {
    }

    public OpenPageRouteMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r26, ParamModel r27, f3.h r28) {
        com.bytedance.ai.bridge.router.AbsOpenPageMethodIDL.b r10 = (com.bytedance.ai.bridge.router.AbsOpenPageMethodIDL.b) r27;
        Intrinsics.checkNotNullParameter(r26, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r28, "callback");
        long r14 = System.currentTimeMillis();
        com.bytedance.ai.bridge.router.AbsOpenPageMethodIDL.OpenPageMode r0 = r10.getMode();
        if (r0 != null) goto L5;
        int r1 = -1;
    L7:
        if (r1 == (-1)) goto L19;
        if (r1 == 1) goto L19;
        if (r1 != 2) goto L11;
        ApplicationRouter.OpenPageMode r11 = ApplicationRouter.OpenPageMode.REPLACE;
    L20:
        ApplicationRouter.OpenPageMode r12 = r11;
        com.bytedance.ai.utils.g r13 = com.bytedance.ai.utils.g.a;
        r13.i("AISDK_JSB_OpenPageRouteMethod", "call start, path=" + StringsKt.substringBefore$default(r10.getUrl(), "?", null, 2, null) + ", mode=" + r12);
        a0 r15 = r26.getContainerContext();
        if (r15 != null) goto L23;
        StringBuilder r16 = new StringBuilder("call failed, errNo=");
        f3.a r17 = f3.a.f;
        r16.append(r17.a);
        r16.append(", msg=appId is null");
        r13.e("AISDK_JSB_OpenPageRouteMethod", r16.toString());
        f3.h.a.a(r28, "appId is null", r17, null, 10);
        return;
    L23:
        String r18 = r15.getAppletId();
        if (r18 != null) goto L26;
        StringBuilder r19 = new StringBuilder("call failed, errNo=");
        f3.a r20 = f3.a.f;
        r19.append(r20.a);
        r19.append(", msg=appId is null");
        r13.e("AISDK_JSB_OpenPageRouteMethod", r19.toString());
        f3.h.a.a(r28, "appId is null", r20, null, 10);
        return;
    L26:
        String r21 = r15.getConversationId();
        if (r15.getContainerType() != ContainerType.WIDGET) goto L29;
        boolean r22 = true;
    L30:
        AppletAppManagerService.INSTANCE.getClass();
        AppletApplication r23 = AppletAppManagerService.a(r18);
        if (r23 == null) goto L43;
        if (r22 == true) goto L34;
    L36:
        boolean r24 = false;
    L37:
        if (r24 == false) goto L39;
        AppletPerformanceNavigationType r110 = AppletPerformanceNavigationType.RE_LAUNCH;
    L40:
        com.bytedance.ai.applet.app.foundation.performance.r r111 = r23.h().c().b(new com.bytedance.ai.applet.app.foundation.performance.p(r14, t2.c.a(r10.getUrl()), r110, r15.getPath(), r15.getTraceId()));
        String r25 = r18;
        if (BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r23), null, null, new OpenPageRouteMethod$handle$1$1(r22, r23, r26, r21, r24, r10, new RouteOptions(r21, Long.valueOf(r111.c)), r12, r28, r111, null), 3, null) != null) goto L48;
    L44:
        StringBuilder r29 = new StringBuilder("call failed, errNo=");
        f3.a r30 = f3.a.f;
        r29.append(r30.a);
        r29.append(", msg=app ");
        String r31 = r25;
        r29.append(r31);
        r29.append(" not found");
        r13.e("AISDK_JSB_OpenPageRouteMethod", r29.toString());
        f3.h.a.a(r28, "app " + r31 + " not found", r30, null, 10);
        Unit r32 = Unit.INSTANCE;
        return;
    L48:
        return;
    L39:
        r110 = AppletPerformanceNavigationType.OPEN_PAGE;
        goto L40
    L34:
        if (r23.m() == true) goto L36;
        r24 = true;
        goto L37
    L43:
        r25 = r18;
        goto L44
    L29:
        r22 = false;
        goto L30
    L11:
        if (r1 != 3) goto L13;
        r11 = ApplicationRouter.OpenPageMode.NAVIGATE;
        goto L20
    L13:
        if (r1 != 4) goto L16;
        r11 = ApplicationRouter.OpenPageMode.POP_TO;
        goto L20
    L16:
        throw new NoWhenBranchMatchedException();
    L19:
        r11 = ApplicationRouter.OpenPageMode.PUSH;
        goto L20
    L5:
        r1 = b.a[r0.ordinal()];
        goto L7
    }
}
