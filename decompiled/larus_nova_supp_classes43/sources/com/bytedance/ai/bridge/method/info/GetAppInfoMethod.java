package com.bytedance.ai.bridge.method.info;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.view.View;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.service.IHostContextDepend;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import e3.d;
import f2.k;
import f3.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r4.a;
import z3.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ai/bridge/method/info/GetAppInfoMethod;", "Lcom/bytedance/ai/bridge/method/info/AbsGetAppInfoMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/method/info/AbsGetAppInfoMethodIDL$GetAppInfoParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/method/info/AbsGetAppInfoMethodIDL$GetAppInfoResultModel;", "getContextDependInstance", "Lcom/bytedance/ai/bridge/service/IHostContextDepend;", "getLogDependInstance", "Lcom/bytedance/ai/bridge/service/IHostLogDepend;", "getScreenOrientation", "", "context", "Landroid/content/Context;", "is32Bit", "", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetAppInfoMethod extends AbsGetAppInfoMethodIDL {
    public GetAppInfoMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r22, ParamModel r23, final h r24) {
        Intrinsics.checkNotNullParameter(r22, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsGetAppInfoMethodIDL.a) r23, "params");
        Intrinsics.checkNotNullParameter(r24, "callback");
        final IHostContextDepend r10 = a.a;
        Activity r0 = null;
        if (r10 == null) goto L27;
        final Context r11 = r10.getApplicationContext();
        final s4.a.C0194a r12 = s4.a.a(r11);
        Intrinsics.checkNotNullParameter(r11, "context");
        int r13 = s4.a.b(r11, false);
        Resources r14 = r11.getResources();
        final int r16 = s4.a.c(r13, WindowDisplayMetricsOverride.apply(r14, r14.getDisplayMetrics()).density);
        int r17 = s4.a.b(r11, false);
        View r15 = r22.getEngineView();
        if (r15 == null) goto L7;
        Context r18 = r15.getContext();
    L8:
        if (r18 == null) goto L15;
        if ((r18 instanceof Activity) == true) goto L11;
        if ((r18 instanceof ContextWrapper) == false) goto L15;
        r18 = ((ContextWrapper) r18).getBaseContext();
        goto L8
    L11:
        r0 = (Activity) r18;
    L15:
        if (r0 != null) goto L17;
        r0 = k.b();
    L17:
        final Activity r19 = r0;
        int r1 = com.bytedance.ai.bridge.method.system.d.a;
        int r110 = r12.b;
        int r111 = r12.c;
        int r112 = r12.e;
        Resources r20 = r11.getResources();
        double r113 = WindowDisplayMetricsOverride.apply(r20, r20.getDisplayMetrics()).density;
        if (r19 == null) goto L21;
        Resources r21 = r19.getResources();
        if (r21 == null) goto L21;
    L23:
        if (r21.getConfiguration().orientation != 2) goto L25;
        boolean r114 = true;
    L26:
        com.bytedance.ai.bridge.method.system.d.c(r19, r110, r111, r112, r113, r16, r17, r114, false, new c(r24, r10, r19, r11, this, r16, r12));
        return;
    L25:
        r114 = false;
    L21:
        r21 = r11.getResources();
        goto L23
    L7:
        r18 = null;
        goto L8
    L27:
        h.a.a(r24, "context dependency is not binded", null, null, 14);
    }
}
