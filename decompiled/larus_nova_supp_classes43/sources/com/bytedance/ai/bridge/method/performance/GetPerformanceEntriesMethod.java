package com.bytedance.ai.bridge.method.performance;

import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.app.foundation.performance.c;
import com.bytedance.ai.applet.app.foundation.performance.f;
import com.bytedance.ai.applet.app.foundation.v;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.bridge.core.a;
import com.bytedance.ai.bridge.core.b;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.performance.AbsGetPerformanceEntriesMethodIDL;
import d3.a0;
import e3.d;
import f3.h;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J&\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0012H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ai/bridge/method/performance/GetPerformanceEntriesMethod;", "Lcom/bytedance/ai/bridge/performance/AbsGetPerformanceEntriesMethodIDL;", "<init>", "()V", "supportSyncCall", "", "getSupportSyncCall", "()Z", "handleSync", "Lcom/bytedance/ai/bridge/core/BridgeMethodResult;", "Lcom/bytedance/ai/bridge/performance/AbsGetPerformanceEntriesMethodIDL$GetPerformanceEntriesResultModel;", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/performance/AbsGetPerformanceEntriesMethodIDL$GetPerformanceEntriesParamModel;", "handle", "", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetPerformanceEntriesMethod extends AbsGetPerformanceEntriesMethodIDL {
    public final boolean b;

    public GetPerformanceEntriesMethod() {
        this.b = true;
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean getSupportSyncCall() {
        return this.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.util.ArrayList] */
    public static a b(d r12, AbsGetPerformanceEntriesMethodIDL.a r13) {
        Intrinsics.checkNotNullParameter(r12, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        a0 r14 = r12.getContainerContext();
        if (r14 == null) goto L47;
        String r15 = r14.getAppletId();
        if (r15 == null) goto L47;
        AppletAppManagerService.INSTANCE.getClass();
        AppletApplication r16 = AppletAppManagerService.a(r15);
        if (r16 == null) goto L45;
        v r17 = r16.h();
        if (r17 == null) goto L45;
        c r18 = r17.c();
        if (r18 == null) goto L45;
        String r0 = r13.getEntryType();
        String r19 = r13.getName();
        if (r19 == null) goto L35;
        Intrinsics.checkNotNullParameter(r19, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Object r1 = r18.c;
        monitor-enter(r1);
        ArrayDeque<f> r110 = r18.d;     // Catch: Throwable -> L32
        ?? r10 = new ArrayList();     // Catch: Throwable -> L32
        Iterator<f> r111 = r110.iterator();     // Catch: Throwable -> L32
    L18:
        if (r111.hasNext() == false) goto L30;
        f r11 = r111.next();     // Catch: Throwable -> L32
        f r20 = r11;     // Catch: Throwable -> L32
        if (Intrinsics.areEqual(r20.a().getValue(), r19) == false) goto L26;
        if (r0 != null) goto L24;
    L25:
        boolean r21 = true;
    L27:
        if (r21 == false) goto L18;
        r10.add(r11);     // Catch: Throwable -> L32
        goto L18
    L24:
        if (Intrinsics.areEqual(r20.a().getEntryType().getValue(), r0) == true) goto L25;
    L26:
        r21 = false;
        goto L27
    L30:
        monitor-exit(r1);
    L38:
        Intrinsics.checkNotNullParameter(AbsGetPerformanceEntriesMethodIDL.b.class, "<this>");
        BaseModel r112 = k3.c.a(AbsGetPerformanceEntriesMethodIDL.b.class);
        AbsGetPerformanceEntriesMethodIDL.b r113 = (AbsGetPerformanceEntriesMethodIDL.b) r112;
        ArrayList r22 = new ArrayList(r10.size());
        Iterator r23 = ((Iterable) r10).iterator();
    L40:
        if (r23.hasNext() == false) goto L42;
        r22.add(e4.a.b((f) r23.next()));
        goto L40
    L42:
        r113.setEntries(r22);
        return new a.c(r112);
    L32:
        th = move-exception;
        throw th;
    L35:
        if (r0 == null) goto L37;
        r10 = r18.e(r0);
        goto L38
    L37:
        r10 = r18.c();
    L45:
        return new a.b(0, "application is not found", null, null, 29);
    L47:
        return new a.b(0, "appId is null", null, null, 29);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final /* bridge */ /* synthetic */ a handleSync(d r1, ParamModel r10) {
        return b(r1, (AbsGetPerformanceEntriesMethodIDL.a) r10);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        AbsGetPerformanceEntriesMethodIDL.a r13 = (AbsGetPerformanceEntriesMethodIDL.a) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        b.a(b(r10, r13), r12);
    }
}
