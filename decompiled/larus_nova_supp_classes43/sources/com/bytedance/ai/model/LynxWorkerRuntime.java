package com.bytedance.ai.model;

import android.content.Context;
import com.bytedance.ai.applet.render.core.lynx.AppletBridgeModule;
import com.bytedance.ai.applet.render.core.lynx.LynxAppletBridgeSyncModule;
import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.method.router.ReplyLocalPluginMethod;
import com.bytedance.ai.bridge.protocol.LynxWorkerAIBridgePort;
import com.bytedance.ai.model.objects.Applet;
import com.lynx.jsbridge.LynxModule;
import com.lynx.tasm.LynxBackgroundRuntime;
import com.lynx.tasm.LynxGroup;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B7\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u001c\u0010\"\u001a\u00020#2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020#0%H\u0014J\b\u0010'\u001a\u00020#H\u0014J\b\u0010(\u001a\u00020#H\u0014R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006)"}, d2 = {"Lcom/bytedance/ai/model/LynxWorkerRuntime;", "Lcom/bytedance/ai/model/AppletRuntime;", "Lcom/bytedance/ai/model/WorkerRuntime;", "app", "Landroid/content/Context;", "applet", "Lcom/bytedance/ai/model/objects/Applet;", "traceInfo", "", "", "", "lynxGroup", "Lcom/lynx/tasm/LynxGroup;", "<init>", "(Landroid/content/Context;Lcom/bytedance/ai/model/objects/Applet;Ljava/util/Map;Lcom/lynx/tasm/LynxGroup;)V", "getLynxGroup", "()Lcom/lynx/tasm/LynxGroup;", "workerType", "Lcom/bytedance/ai/model/worker/WorkerType;", "getWorkerType", "()Lcom/bytedance/ai/model/worker/WorkerType;", "workerWrapper", "Lcom/bytedance/ai/model/worker/WorkerWrapper;", "Lcom/lynx/tasm/LynxBackgroundRuntime;", "getWorkerWrapper", "()Lcom/bytedance/ai/model/worker/WorkerWrapper;", "setWorkerWrapper", "(Lcom/bytedance/ai/model/worker/WorkerWrapper;)V", "aiBridge", "Lcom/bytedance/ai/bridge/AIBridge;", "getAiBridge", "()Lcom/bytedance/ai/bridge/AIBridge;", "setAiBridge", "(Lcom/bytedance/ai/bridge/AIBridge;)V", "initializeWorker", "", "succeed", "Lkotlin/Function1;", "", "initializeAIBridge", "cleanup", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LynxWorkerRuntime extends AppletRuntime {
    public static final /* synthetic */ int C = 0;
    public j5.g<LynxBackgroundRuntime> A;
    public d3.w B;
    public final LynxGroup z;

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

        public a(LynxWorkerRuntime r10) {
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
    public final j5.g<LynxBackgroundRuntime> v() {
        j5.g<LynxBackgroundRuntime> r0 = this.A;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("workerWrapper");
        return null;
    }

    @Override // com.bytedance.ai.model.AppletRuntime
    public final void w() {
        final LynxBackgroundRuntime r0 = v().c();
        r0.b.c("AppletBridgeModule", AppletBridgeModule.class, new AppletBridgeModule.b(new s4.c(), new LynxWorkerRuntime$initializeAIBridge$modelParams$1(s4.d.a), new j0(this), ContainerType.WORKER, new k0(r0)));
        LynxModule r1 = r0.b.b("AppletBridgeModule").getModule();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.bytedance.ai.applet.render.core.lynx.AppletBridgeModule");
        r0.b.c(LynxAppletBridgeSyncModule.NAME, LynxAppletBridgeSyncModule.class, CollectionsKt.arrayListOf(new LynxAppletBridgeSyncModule.b[]{new LynxAppletBridgeSyncModule.b(new l0(this))}));
        LynxWorkerAIBridgePort r10 = new LynxWorkerAIBridgePort((AppletBridgeModule) r1);
        r10.setRemoteReadyListener(new m0(r0));
        d3.w r11 = new d3.w();
        r11.d(new q4.a());
        r11.d(new o4.b());
        r11.d(new k4.a());
        g3.b r12 = new g3.b();
        Intrinsics.checkNotNullParameter(r12, "methodSeeker");
        r11.c.add(r12);
        r11.i.e(d3.a0.class, new a(this));
        e3.d.a.a(r11.i, AppletRuntime.class, this);
        r11.i.e(d3.z.class, new n0(this));
        Intrinsics.checkNotNullParameter(r11, "aiBridge");
        Intrinsics.checkNotNullParameter(ReplyLocalPluginMethod.class, "clazz");
        r11.b.b(ReplyLocalPluginMethod.class);
        r11.k(r10);
        this.B = r11;
    }

    @Override // com.bytedance.ai.model.AppletRuntime, com.bytedance.ai.core.base.d
    public final void k() {
        G();
    }

    @Override // com.bytedance.ai.model.AppletRuntime
    public final d3.w u() {
        return this.B;
    }

    @Override // com.bytedance.ai.model.AppletRuntime
    public final void y(l r10) {
        Intrinsics.checkNotNullParameter(r10, "succeed");
        j5.f r0 = new j5.f(this.g, this, this.z);
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        this.A = r0;
        r10.invoke(Boolean.valueOf(v().e()));
    }

    public LynxWorkerRuntime(Context r10, Applet r11, Map<String, Object> r12, LynxGroup r13) {
        Intrinsics.checkNotNullParameter(r10, "app");
        Intrinsics.checkNotNullParameter(r11, "applet");
        Intrinsics.checkNotNullParameter(r13, "lynxGroup");
        super(r10, r11, r12);
        this.z = r13;
    }
}
