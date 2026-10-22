package l5;

import com.bytedance.ai.debug.IAISDKDebugService;
import com.bytedance.ai.monitor.AppletMonitorableEvent;
import com.bytedance.ai.monitor.bridge.BridgeType;
import com.bytedance.ai.resource.AIManager;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class y implements k5.j {
    public final /* synthetic */ String a;
    public final /* synthetic */ BridgeType b;
    public final /* synthetic */ String c;
    public final /* synthetic */ com.ivy.ivykit.api.bridge.c d;

    @Override // k5.j
    public final void a(AppletMonitorableEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        r10.f(com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, this.a);
        r10.f("bridge_type", this.b.getValue());
        String r0 = this.c;
        Object r1 = null;
        if (r0 == null) goto L19;
        r10.f("packageId", r0);
        AIManager r11 = AIManager.a;
        Intrinsics.checkNotNullParameter(r0, "packageId");
        com.bytedance.ai.resource.d0 r12 = IAISDKDebugService.a.v(r0);
        if (r12 == null) goto L9;
        String r13 = r12.j;
        if (r13 == null) goto L9;
    L17:
        if (r13 == null) goto L19;
        r10.f("scmVersion", r13);
    L9:
        if (AIManager.g(r0) == false) goto L13;
        com.bytedance.ai.resource.d0 r14 = AIManager.f.get(r0);
        if (r14 == null) goto L16;
        r13 = r14.j;
    L16:
        r13 = null;
        goto L17
    L13:
        com.bytedance.ai.resource.d0 r15 = AIManager.g.get(r0);
        if (r15 == null) goto L16;
        r13 = r15.j;
    L19:
        com.ivy.ivykit.api.bridge.c r16 = this.d;
        if (r16 == null) goto L46;
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L27
        Map r18 = r16.d;     // Catch: Throwable -> L27
        if (r18 == null) goto L24;
        String r19 = com.bytedance.ai.applet.base.gson.e.c(r18);     // Catch: Throwable -> L27
    L25:
        Object r20 = Result.constructor-impl(r19);     // Catch: Throwable -> L27
    L30:
        if (Result.isFailure-impl(r20) == true) goto L33;
        r1 = r20;
    L33:
        String r21 = (String) r1;
        if (r21 == null) goto L36;
        r10.f("params", r21);
    L36:
        String r22 = r16.h;
        if (r22 == null) goto L39;
        r10.f(com.bytedance.android.ec.core.event.a.KEY_URL, r22);
    L39:
        r10.e("timestamp", r16.i);
        String r23 = r16.f;
        if (r23 == null) goto L42;
        r10.f(com.bytedance.android.ec.core.event.a.KEY_MSG, r23);
    L42:
        r10.f("platformType", r16.j);
        return;
    L24:
        r19 = null;
    L27:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r20 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L30
    }

    public y(String r1, BridgeType r10, String r11, com.ivy.ivykit.api.bridge.c r12) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
    }
}
