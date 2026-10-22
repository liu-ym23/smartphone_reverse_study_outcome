package com.bytedance.ai.bridge.method.performance;

import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.app.foundation.performance.c;
import com.bytedance.ai.applet.app.foundation.v;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.bridge.core.a;
import com.bytedance.ai.bridge.core.b;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.performance.AbsSetPerformanceBufferSizeMethodIDL;
import d3.a0;
import e3.d;
import f3.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J&\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0012H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ai/bridge/method/performance/SetPerformanceBufferSizeMethod;", "Lcom/bytedance/ai/bridge/performance/AbsSetPerformanceBufferSizeMethodIDL;", "<init>", "()V", "supportSyncCall", "", "getSupportSyncCall", "()Z", "handleSync", "Lcom/bytedance/ai/bridge/core/BridgeMethodResult;", "Lcom/bytedance/ai/bridge/performance/AbsSetPerformanceBufferSizeMethodIDL$EmptyMessageModel;", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/performance/AbsSetPerformanceBufferSizeMethodIDL$SetPerformanceBufferSizeParamModel;", "handle", "", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SetPerformanceBufferSizeMethod extends AbsSetPerformanceBufferSizeMethodIDL {
    public final boolean b;

    public SetPerformanceBufferSizeMethod() {
        this.b = true;
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean getSupportSyncCall() {
        return this.b;
    }

    public static a b(d r13, AbsSetPerformanceBufferSizeMethodIDL.b r14) {
        Intrinsics.checkNotNullParameter(r13, "bridgeContext");
        Intrinsics.checkNotNullParameter(r14, "params");
        int r0 = r14.getSize();
        boolean r10 = false;
        if (1 > r0) goto L6;
        if (r0 >= 1001) goto L6;
        boolean r1 = true;
    L7:
        if (r1 == false) goto L9;
        a0 r15 = r13.getContainerContext();
        if (r15 == null) goto L53;
        String r16 = r15.getAppletId();
        if (r16 == null) goto L53;
        AppletAppManagerService.INSTANCE.getClass();
        AppletApplication r17 = AppletAppManagerService.a(r16);
        if (r17 == null) goto L51;
        v r18 = r17.h();
        if (r18 == null) goto L51;
        c r19 = r18.c();
        if (r19 == null) goto L51;
        int r110 = r14.getSize();
        if (1 > r110) goto L25;
        if (r110 >= 1001) goto L25;
        boolean r11 = true;
    L26:
        if (r11 == true) goto L28;
        c.k("setBufferSize", "size must be between 1 and 1000: " + r110);
    L42:
        if (r10 == false) goto L44;
        Intrinsics.checkNotNullParameter(AbsSetPerformanceBufferSizeMethodIDL.a.class, "<this>");
        return new a.c(k3.c.a(AbsSetPerformanceBufferSizeMethodIDL.a.class));
    L44:
        return new a.b(0, "failed to set performance buffer size", null, null, 29);
    L28:
        Object r12 = r19.c;
        monitor-enter(r12);
    L47:
        th = move-exception;
        throw th;
    L31:
        if (r19.i == true) goto L39;
        r19.f = r110;     // Catch: Throwable -> L47
    L35:
        if (r19.d.size() <= r19.f) goto L38;
        r19.d.removeFirst();     // Catch: Throwable -> L47
        goto L35
    L38:
        r10 = true;
    L39:
        monitor-exit(r12);
        if (r10 == true) goto L42;
        c.k("setBufferSize", "component has been destroyed");
    L25:
        r11 = false;
    L51:
        return new a.b(0, "application is not found", null, null, 29);
    L53:
        return new a.b(0, "appId is null", null, null, 29);
    L9:
        return new a.b(0, "size must be between 1 and 1000", null, null, 29);
    L6:
        r1 = false;
        goto L7
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final /* bridge */ /* synthetic */ a handleSync(d r1, ParamModel r10) {
        return b(r1, (AbsSetPerformanceBufferSizeMethodIDL.b) r10);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        AbsSetPerformanceBufferSizeMethodIDL.b r13 = (AbsSetPerformanceBufferSizeMethodIDL.b) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        b.a(b(r10, r13), r12);
    }
}
