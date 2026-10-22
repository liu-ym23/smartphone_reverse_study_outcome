package com.bytedance.ai.bridge.method.router;

import android.app.Activity;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.DefaultLifecycleObserver;
import com.bytedance.ai.applet.app.AppletAppActivity;
import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.app.AppletEightScreenActivity;
import com.bytedance.ai.applet.app.AppletShowMode;
import com.bytedance.ai.applet.app.OnlineAppletApplication;
import com.bytedance.ai.applet.app.base.RouteOptions;
import com.bytedance.ai.applet.app.foundation.performance.AppletPerformanceNavigationType;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.router.AbsOpenPageInChatMethodIDL;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import d3.a0;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 &2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J2\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00050\u0013H\u0002JF\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020 H\u0002J&\u0010\"\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010#\u001a\u00020\u00142\u0006\u0010$\u001a\u00020%H\u0002¨\u0006'"}, d2 = {"Lcom/bytedance/ai/bridge/method/router/OpenPageInChatMethod;", "Lcom/bytedance/ai/bridge/router/AbsOpenPageInChatMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/router/AbsOpenPageInChatMethodIDL$OpenPageInChatRequestModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/router/AbsOpenPageInChatMethodIDL$EmptyMessageModel;", "closeCurrentPageHost", "currentPageHost", "Lcom/bytedance/ai/applet/app/AppletAppActivity;", "onDestroyed", "Lkotlin/Function0;", "onFailure", "Lkotlin/Function1;", "", "launchEightScreen", "mainActivity", "Landroid/app/Activity;", "app", "Lcom/bytedance/ai/applet/app/OnlineAppletApplication;", com.bytedance.android.ec.core.event.a.KEY_URL, "routeOptions", "Lcom/bytedance/ai/applet/app/base/RouteOptions;", "appLaunchStartTime", "", "launchToken", "", "releaseLaunchGuard", "fail", com.bytedance.android.ec.core.event.a.KEY_MSG, "errNo", "Lcom/bytedance/ai/bridge/core/AIBridgeApiErr;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenPageInChatMethod extends AbsOpenPageInChatMethodIDL {
    public static final AtomicReference<Object> b = null;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ContainerType.values().length];
            r0[ContainerType.PAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[ContainerType.WIDGET.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
        b = new AtomicReference(null);
    }

    public OpenPageInChatMethod() {
    }

    public static void c(Object r10) {
        AtomicReference<Object> r0 = b;
    L4:
        if (r0.compareAndSet(r10, null) == true) goto L5;
        if (r0.get() == r10) goto L4;
        boolean r11 = false;
    L9:
        if (r11 == false) goto L15;
        com.bytedance.ai.utils.g.a.i("AISDK_JSB_OpenPageInChatMethod", "openPageInChat launch guard released");
        return;
    L15:
        return;
    L5:
        r11 = true;
        goto L9
    }

    public final void b(f3.h<AbsOpenPageInChatMethodIDL.a> r10, String r11, f3.a r12) {
        com.bytedance.ai.utils.g.a.e("AISDK_JSB_OpenPageInChatMethod", "call failed, errNo=" + r12.a + ", msg=" + r11);
        f3.h.a.a(r10, r11, r12, null, 10);
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.bytedance.ai.bridge.method.router.h] */
    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r22, ParamModel r23, final f3.h r24) {
        final AbsOpenPageInChatMethodIDL.b r10 = (AbsOpenPageInChatMethodIDL.b) r23;
        Intrinsics.checkNotNullParameter(r22, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r24, "callback");
        final long r11 = System.currentTimeMillis();
        com.bytedance.ai.utils.g.a.i("AISDK_JSB_OpenPageInChatMethod", "call start, path=" + StringsKt.substringBefore$default(r10.getUrl(), "?", null, 2, null));
        a0 r1 = r22.getContainerContext();
        if (r1 != null) goto L5;
        b(r24, "container context is null", f3.a.f);
        return;
    L5:
        String r12 = r1.getAppletId();
        if (r12 != null) goto L8;
        b(r24, "appId is null", f3.a.f);
        return;
    L8:
        final Activity r13 = r22.getOwnerActivity();
        if (r13 != null) goto L11;
        b(r24, "container owner activity is null", f3.a.f);
        return;
    L11:
        AppletAppManagerService.INSTANCE.getClass();
        final OnlineAppletApplication r14 = AppletAppManagerService.b(r12);
        if (r14 != null) goto L14;
        b(r24, "online app " + r12 + " not found", f3.a.f);
        return;
    L14:
        ComponentActivity r15 = ((AppletApplication) r14).d;
        if ((r15 instanceof AppletEightScreenActivity) == true) goto L80;
        if (r15 == null) goto L18;
        AppletShowMode r16 = r15.L1();
    L20:
        if (r16 == AppletShowMode.EIGHT_SCREEN) goto L80;
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r17 = AppletRuntimeManager.d;
        if (r17 == null) goto L25;
        Activity r18 = r17.O();
    L26:
        if (r17 == null) goto L28;
        Activity r19 = r17.z();
    L29:
        if (r17 == null) goto L31;
        Activity r110 = r17.m();
    L32:
        int r20 = b.a[r1.getContainerType().ordinal()];
        boolean r21 = true;
        if (r20 == 1) goto L79;
        if (r20 == 2) goto L37;
        b(r24, "openPageInChat does not support " + r1.getContainerType(), f3.a.l);
        return;
    L37:
        if ((r13 instanceof AppletAppActivity) == false) goto L39;
        b(r24, "openPageInChat cannot be called from a widget inside an applet page", f3.a.l);
        return;
    L39:
        if (r13 == r18) goto L43;
        if (r13 == r19) goto L43;
        if (r13 == r110) goto L43;
        b(r24, "widget is not hosted by the main, chat or applet debugger activity", f3.a.l);
        return;
    L43:
        final RouteOptions r25 = new RouteOptions(r1.getConversationId(), Long.valueOf(r14.h().c().b(new com.bytedance.ai.applet.app.foundation.performance.p(r11, t2.c.a(r10.getUrl()), AppletPerformanceNavigationType.OPEN_PAGE_IN_CHAT, r1.getPath(), r1.getTraceId())).c));
        r14.h().b().b();
        if (r1.getContainerType() != ContainerType.WIDGET) goto L56;
        WidgetContainer r0 = (WidgetContainer) r22.d(WidgetContainer.class);
        com.bytedance.ai.applet.app.foundation.j r26 = r14.h().e();
        if (r0 == null) goto L48;
        String r111 = r0.l();
    L49:
        String r27 = r1.getConversationId();
        if (r0 == null) goto L54;
        com.bytedance.ai.widget.contianer.m r28 = r0.g;
        if (r28 == null) goto L54;
        String r29 = r28.f;
    L55:
        r26.f(r111, r27, r29);
    L54:
        r29 = null;
        goto L55
    L48:
        r111 = null;
    L56:
        final Object r112 = new Object();
        AtomicReference<Object> r30 = b;
    L58:
        if (r30.compareAndSet(null, r112) == true) goto L63;
        if (r30.get() == null) goto L58;
        r21 = false;
    L63:
        if (r21 == true) goto L65;
        b(r24, "openPageInChat is already launching", f3.a.l);
        return;
    L65:
        final ?? r31 = new h(this, r13, r14, r10, r25, r11, r24, r112);
        if (r15 != null) goto L68;
    L78:
        r31.invoke();
        return;
    L68:
        if (r15.isDestroyed() == true) goto L78;
        com.bytedance.ai.utils.g.a.i("AISDK_JSB_OpenPageInChatMethod", "close current page host before launch, host=".concat(r15.getClass().getSimpleName()));
        DefaultLifecycleObserver r32 = new OpenPageInChatMethod$closeCurrentPageHost$observer$1(r31);
        r15.getLifecycle().addObserver(r32);
        Result.Companion r33 = Result.Companion;     // Catch: Throwable -> L73
        r15.finish();     // Catch: Throwable -> L73
        Object r34 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L73
    L75:
        Throwable r35 = Result.exceptionOrNull-impl(r34);
        if (r35 == null) goto L95;
        r15.getLifecycle().removeObserver(r32);
        String r36 = "failed to close current page host: " + r35.getMessage();
        Intrinsics.checkNotNullParameter(r36, com.bytedance.android.ec.core.event.a.KEY_MSG);
        c(r112);
        b(r24, r36, f3.a.f);
        Unit r37 = Unit.INSTANCE;
        return;
    L95:
        return;
    L73:
        th = move-exception;
        Result.Companion r38 = Result.Companion;
        r34 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L75
    L79:
        b(r24, "openPageInChat cannot be called from a page", f3.a.l);
        return;
    L31:
        r110 = null;
        goto L32
    L28:
        r19 = null;
        goto L29
    L25:
        r18 = null;
        goto L26
    L18:
        r16 = null;
    L80:
        b(r24, "an eight-screen page host already exists", f3.a.l);
    }
}
