package com.bytedance.ai.model;

import android.content.Context;
import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.method.router.ReplyLocalPluginMethod;
import com.bytedance.ai.bridge.protocol.WorkerAIBridgePort;
import com.bytedance.ai.bridge.protocol.WorkerModule;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.vmsdk.jsbridge.JSModule;
import com.bytedance.vmsdk.jsbridge.utils.WritableMap;
import com.bytedance.vmsdk.worker.JsWorker;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0002$%B/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fJ\u001c\u0010\u001e\u001a\u00020\u001f2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u001f0!H\u0014J\b\u0010#\u001a\u00020\u001fH\u0014R\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006&"}, d2 = {"Lcom/bytedance/ai/model/JSWorkerRuntime;", "Lcom/bytedance/ai/model/AppletRuntime;", "Lcom/bytedance/ai/model/WorkerRuntime;", "app", "Landroid/content/Context;", "applet", "Lcom/bytedance/ai/model/objects/Applet;", "traceInfo", "", "", "", "<init>", "(Landroid/content/Context;Lcom/bytedance/ai/model/objects/Applet;Ljava/util/Map;)V", "workerType", "Lcom/bytedance/ai/model/worker/WorkerType;", "getWorkerType", "()Lcom/bytedance/ai/model/worker/WorkerType;", "workerWrapper", "Lcom/bytedance/ai/model/worker/WorkerWrapper;", "Lcom/bytedance/vmsdk/worker/JsWorker;", "getWorkerWrapper", "()Lcom/bytedance/ai/model/worker/WorkerWrapper;", "setWorkerWrapper", "(Lcom/bytedance/ai/model/worker/WorkerWrapper;)V", "aiBridge", "Lcom/bytedance/ai/bridge/AIBridge;", "getAiBridge", "()Lcom/bytedance/ai/bridge/AIBridge;", "setAiBridge", "(Lcom/bytedance/ai/bridge/AIBridge;)V", "initializeWorker", "", "succeed", "Lkotlin/Function1;", "", "initializeAIBridge", "AppletReceiveMessageFunc", "AppletOnMessageFunc", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class JSWorkerRuntime extends AppletRuntime {
    public static final /* synthetic */ int B = 0;
    public d3.w A;
    public j5.g<JsWorker> z;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ai/model/JSWorkerRuntime$AppletOnMessageFunc;", "Lcom/bytedance/vmsdk/registry/JavaScriptFunction;", "appletOnMessage", "", "param", "Lcom/bytedance/vmsdk/jsbridge/utils/WritableMap;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface AppletOnMessageFunc extends com.bytedance.vmsdk.registry.a {
        void appletOnMessage(WritableMap r1);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ai/model/JSWorkerRuntime$AppletReceiveMessageFunc;", "Lcom/bytedance/vmsdk/registry/JavaScriptFunction;", "appletReceiveMessage", "", "param", "Lcom/bytedance/vmsdk/jsbridge/utils/WritableMap;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface AppletReceiveMessageFunc extends com.bytedance.vmsdk.registry.a {
        void appletReceiveMessage(WritableMap r1);
    }

    public static final class a extends d3.a0 {
        public final String a;
        public final String b;
        public final ContainerType c;
        public final String d;
        public final int e;

        @Override // d3.a0
        public final Integer getAppSourceType() {
            return Integer.valueOf(this.e);
        }

        @Override // d3.a0
        public final String getAppId() {
            return this.b;
        }

        @Override // d3.a0
        public final String getAppletId() {
            return this.a;
        }

        @Override // d3.a0
        public final String getContainerId() {
            return this.d;
        }

        @Override // d3.a0
        public final ContainerType getContainerType() {
            return this.c;
        }

        public a(JSWorkerRuntime r10) {
            Applet r0 = r10.h;
            String r1 = r0.K;
            this.a = r1;
            this.b = r1;
            this.c = ContainerType.WORKER;
            this.d = r10.f;
            this.e = r0.G;
        }
    }

    @Override // com.bytedance.ai.model.AppletRuntime
    public final j5.g<JsWorker> v() {
        j5.g<JsWorker> r0 = this.z;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("workerWrapper");
        return null;
    }

    @Override // com.bytedance.ai.model.AppletRuntime
    public final void w() {
        JsWorker r0 = v().c();
        r0.getModuleManager().b("AppletBridgeModule", WorkerModule.class, r0);
        JSModule r1 = r0.getModuleManager().a("AppletBridgeModule").getModule();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.bytedance.ai.bridge.protocol.WorkerModule");
        WorkerAIBridgePort r10 = new WorkerAIBridgePort((WorkerModule) r1);
        d3.w r11 = new d3.w();
        g3.b r12 = new g3.b();
        Intrinsics.checkNotNullParameter(r12, "methodSeeker");
        r11.c.add(r12);
        r11.i.e(d3.a0.class, new a(this));
        e3.d.a.a(r11.i, AppletRuntime.class, this);
        r11.i.e(d3.z.class, new i0(this));
        Intrinsics.checkNotNullParameter(r11, "aiBridge");
        Intrinsics.checkNotNullParameter(ReplyLocalPluginMethod.class, "clazz");
        r11.b.b(ReplyLocalPluginMethod.class);
        r11.k(r10);
        this.A = r11;
    }

    @Override // com.bytedance.ai.model.AppletRuntime
    public final d3.w u() {
        return this.A;
    }

    @Override // com.bytedance.ai.model.AppletRuntime
    public final void y(l r10) {
        Intrinsics.checkNotNullParameter(r10, "succeed");
        com.bytedance.ai.utils.g.a.d("WorkerRuntime", this.h.K + " using JSWorker");
        j5.d r0 = new j5.d(this.g, this);
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        this.z = r0;
        r10.invoke(Boolean.valueOf(v().e()));
    }

    public JSWorkerRuntime(Context r10, Applet r11, Map<String, Object> r12) {
        Intrinsics.checkNotNullParameter(r10, "app");
        Intrinsics.checkNotNullParameter(r11, "applet");
        super(r10, r11, r12);
    }
}
