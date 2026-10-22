package com.bytedance.ai.bridge.method.authorize;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.openSetting.AbsOpenSettingMethodIDL;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import d3.a0;
import e3.d;
import e3.e;
import f3.h;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J&\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ai/bridge/method/authorize/OpenSettingMethod;", "Lcom/bytedance/ai/bridge/openSetting/AbsOpenSettingMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/openSetting/AbsOpenSettingMethodIDL$OpenSettingParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/openSetting/AbsOpenSettingMethodIDL$OpenSettingResultModel;", "resolveLatestSetting", "appletId", "", "callToken", "Ljava/util/UUID;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenSettingMethod extends AbsOpenSettingMethodIDL {
    public static final /* synthetic */ int b = 0;

    public static final class a {
    }

    static {
    }

    public OpenSettingMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        AbsOpenSettingMethodIDL.a r13 = (AbsOpenSettingMethodIDL.a) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        if (r13.getWithSubscriptions() == false) goto L5;
        h.a.a(r12, "subscription templates are not supported yet", null, null, 14);
        return;
    L5:
        a0 r14 = r10.getContainerContext();
        if (r14 == null) goto L8;
        ContainerType r15 = r14.getContainerType();
    L10:
        if (r15 != ContainerType.WORKER) goto L12;
        h.a.a(r12, "openSetting is unavailable in worker", null, null, 14);
        return;
    L12:
        a0 r16 = r10.getContainerContext();
        if (r16 == null) goto L59;
        String r17 = r16.getAppletId();
        if (r17 == null) goto L59;
        LifecycleOwner r18 = e.a(r10);
        if (r18 != null) goto L21;
        h.a.a(r12, "settings presenter is unavailable", null, null, 14);
        return;
    L21:
        if ((r18 instanceof LifecycleOwner) == false) goto L23;
        LifecycleOwner r19 = r18;
    L24:
        if (r19 == null) goto L30;
        Lifecycle r20 = r19.getLifecycle();
        if (r20 == null) goto L30;
        Lifecycle.State r21 = r20.getCurrentState();
        if (r21 == null) goto L30;
        boolean r22 = r21.isAtLeast(Lifecycle.State.RESUMED);
    L36:
        if (r18.isFinishing() == false) goto L38;
    L58:
        h.a.a(r12, "openSetting is unavailable in background", null, null, 14);
        return;
    L38:
        if (r18.isDestroyed() == true) goto L58;
        if (r22 == false) goto L58;
        com.bytedance.ai.bridge.method.authorize.a r23 = com.bytedance.ai.bridge.method.authorize.a.a;
        monitor-enter(r23);
        Intrinsics.checkNotNullParameter(r17, "appletId");     // Catch: Throwable -> L55
        Map<String, UUID> r24 = com.bytedance.ai.bridge.method.authorize.a.b;     // Catch: Throwable -> L55
        if (r24.containsKey(r17) == false) goto L47;
        monitor-exit(r23);
        UUID r25 = null;
    L49:
        if (r25 != null) goto L51;
        h.a.a(r12, "openSetting is already in progress", null, null, 14);
        return;
    L51:
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r26 = AppletRuntimeManager.d;
        if (r26 != null) goto L54;
        r23.a(r17, r25);
        h.a.a(r12, "applet settings host is unavailable", null, null, 14);
        return;
    L54:
        r26.a(r18, r17, new b(r17, r25, r12, this));
        return;
    L47:
        r25 = UUID.randomUUID();     // Catch: Throwable -> L55
        r24.put(r17, r25);     // Catch: Throwable -> L55
        monitor-exit(r23);
    L55:
        th = move-exception;
        throw th;
    L30:
        r22 = r18.hasWindowFocus();
        if (c.e == false) goto L36;
        FLogger.a.i("DecorViewLancet", "hasWindowFocus");
        Thread r27 = ThreadMethodProxy.currentThread();
        if (r27 == c.a) goto L36;
        c.a(r27, "hasWindowFocus");
        goto L36
    L23:
        r19 = null;
    L59:
        h.a.a(r12, "appletId is empty", null, null, 14);
        return;
    L8:
        r15 = null;
        goto L10
    }
}
