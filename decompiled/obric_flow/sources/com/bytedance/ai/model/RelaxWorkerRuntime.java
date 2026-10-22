package com.bytedance.ai.model;

import com.bytedance.ai.applet.render.core.relax.RelaxBridgeModule;
import com.bytedance.ai.bridge.context.RefType;
import com.bytedance.ai.bridge.method.router.ReplyLocalPluginMethod;
import com.bytedance.ai.bridge.protocol.RelaxWorkerAIBridgePort$RTSInterface;
import com.bytedance.ai.model.worker.WorkerType;
import com.relax.BackendWorker;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ai/model/RelaxWorkerRuntime;", "Lcom/bytedance/ai/model/AppletRuntime;", "Lcom/bytedance/ai/model/WorkerRuntime;", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RelaxWorkerRuntime extends AppletRuntime {
    public static final /* synthetic */ int A = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public y2.d f2228y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public m1.i f2229z;

    @Override // com.bytedance.ai.model.AppletRuntime
    public final void m(com.bytedance.ai.bridge.method.net.e r5) {
        Intrinsics.checkNotNullParameter(r5, "succeed");
        String r10 = ug.a.c(new StringBuilder(), this.f2197h.F, " using Relax", "WorkerRuntime");
        t0.d r11 = com.bytedance.ai.utils.c.f2846a;
        if (r11 == null) goto L5;
        r11.d("WorkerRuntime", r10);
    L5:
        y2.d r12 = new y2.d(this.g);
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        this.f2228y = r12;
        r5.invoke(Boolean.valueOf(((y2.d) t()).f23234a));
    }

    @Override // com.bytedance.ai.model.AppletRuntime
    public final m1.i r() {
        return this.f2229z;
    }

    @Override // com.bytedance.ai.model.AppletRuntime
    public final WorkerType s() {
        return WorkerType.f2373a;
    }

    @Override // com.bytedance.ai.model.AppletRuntime
    public final y2.e t() {
        y2.d r5 = this.f2228y;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("workerWrapper");
        return null;
    }

    @Override // com.bytedance.ai.model.AppletRuntime
    public final void u() {
        BackendWorker r5 = ((y2.d) t()).f23233b;
        Intrinsics.checkNotNullParameter(r5, "relaxWorker");
        RelaxWorkerAIBridgePort$RTSInterface.initialize(r5);
        RelaxBridgeModule r10 = RelaxWorkerAIBridgePort$RTSInterface.INSTANCE.getRelaxWorkerToRelaxBridgeModule().get(r5);
        i2.i r11 = null;
        if (r10 != null) goto L5;
        Intrinsics.checkNotNullParameter("ai_bridge", "tag");
        Intrinsics.checkNotNullParameter("[RelaxViewAIBridgePort] must call JSInterface::initialize before create RelaxViewAIBridgePort", "msg");
        a1.a.f43a.e("ai_bridge", "[RelaxViewAIBridgePort] must call JSInterface::initialize before create RelaxViewAIBridgePort", null);
    L9:
        m1.i r12 = new m1.i();
        o1.b r13 = new o1.b(1);
        Intrinsics.checkNotNullParameter(r13, "methodSeeker");
        r12.f19974c.add(r13);
        t r14 = new t(this);
        n1.a r15 = r12.g;
        r15.getClass();
        Intrinsics.checkNotNullParameter(m1.j.class, "clazz");
        RefType r16 = RefType.f1803a;
        r15.c(m1.j.class, r14, r16);
        r15.c(AppletRuntime.class, this, RefType.f1804b);
        s r17 = new s(this, 2);
        Intrinsics.checkNotNullParameter(s.class, "clazz");
        r15.c(s.class, r17, r16);
        Intrinsics.checkNotNullParameter(r12, "aiBridge");
        Intrinsics.checkNotNullParameter(ReplyLocalPluginMethod.class, "clazz");
        r12.f19973b.b(ReplyLocalPluginMethod.class);
        Intrinsics.checkNotNull(r11);
        r12.d(r11);
        this.f2229z = r12;
        return;
    L5:
        l2.a r18 = r10.getNext();
        if (r18 == null) goto L9;
        r11 = new i2.i(new WeakReference(r5), r18);
        goto L9
    }
}
