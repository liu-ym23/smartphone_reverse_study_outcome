package com.bytedance.ai.model;

import com.bytedance.ai.bridge.context.RefType;
import com.bytedance.ai.bridge.method.router.ReplyLocalPluginMethod;
import com.bytedance.ai.bridge.protocol.WorkerModule;
import com.bytedance.ai.model.worker.WorkerType;
import com.bytedance.vmsdk.jsbridge.JSModule;
import com.bytedance.vmsdk.jsbridge.utils.WritableMap;
import com.bytedance.vmsdk.worker.JsWorker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ai/model/JSWorkerRuntime;", "Lcom/bytedance/ai/model/AppletRuntime;", "Lcom/bytedance/ai/model/WorkerRuntime;", "AppletReceiveMessageFunc", "AppletOnMessageFunc", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class JSWorkerRuntime extends AppletRuntime {
    public static final /* synthetic */ int A = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public y2.a f2224y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public m1.i f2225z;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ai/model/JSWorkerRuntime$AppletOnMessageFunc;", "Lcom/bytedance/vmsdk/registry/a;", "Lcom/bytedance/vmsdk/jsbridge/utils/WritableMap;", "param", "", "appletOnMessage", "(Lcom/bytedance/vmsdk/jsbridge/utils/WritableMap;)V", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface AppletOnMessageFunc extends com.bytedance.vmsdk.registry.a {
        void appletOnMessage(WritableMap r5);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ai/model/JSWorkerRuntime$AppletReceiveMessageFunc;", "Lcom/bytedance/vmsdk/registry/a;", "Lcom/bytedance/vmsdk/jsbridge/utils/WritableMap;", "param", "", "appletReceiveMessage", "(Lcom/bytedance/vmsdk/jsbridge/utils/WritableMap;)V", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface AppletReceiveMessageFunc extends com.bytedance.vmsdk.registry.a {
        void appletReceiveMessage(WritableMap r5);
    }

    @Override // com.bytedance.ai.model.AppletRuntime
    public final void m(com.bytedance.ai.bridge.method.net.e r5) {
        Intrinsics.checkNotNullParameter(r5, "succeed");
        String r10 = ug.a.c(new StringBuilder(), this.f2197h.F, " using JSWorker", "WorkerRuntime");
        t0.d r11 = com.bytedance.ai.utils.c.f2846a;
        if (r11 == null) goto L5;
        r11.d("WorkerRuntime", r10);
    L5:
        y2.a r12 = new y2.a(this.g, this);
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        this.f2224y = r12;
        r5.invoke(Boolean.valueOf(((y2.a) t()).f23234a));
    }

    @Override // com.bytedance.ai.model.AppletRuntime
    public final m1.i r() {
        return this.f2225z;
    }

    @Override // com.bytedance.ai.model.AppletRuntime
    public final WorkerType s() {
        return WorkerType.f2374b;
    }

    @Override // com.bytedance.ai.model.AppletRuntime
    public final y2.e t() {
        y2.a r5 = this.f2224y;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("workerWrapper");
        return null;
    }

    @Override // com.bytedance.ai.model.AppletRuntime
    public final void u() {
        JsWorker r5 = ((y2.a) t()).f23230b;
        r5.getModuleManager().b(WorkerModule.class, r5, "AppletBridgeModule");
        JSModule r10 = r5.getModuleManager().a("AppletBridgeModule").getModule();
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.bytedance.ai.bridge.protocol.WorkerModule");
        i2.j r11 = new i2.j((WorkerModule) r10);
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
        s r17 = new s(this, 0);
        r15.getClass();
        Intrinsics.checkNotNullParameter(s.class, "clazz");
        r15.c(s.class, r17, r16);
        Intrinsics.checkNotNullParameter(r12, "aiBridge");
        Intrinsics.checkNotNullParameter(ReplyLocalPluginMethod.class, "clazz");
        r12.f19973b.b(ReplyLocalPluginMethod.class);
        r12.d(r11);
        this.f2225z = r12;
    }
}
