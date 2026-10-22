package com.bytedance.ai.model;

import android.content.Context;
import com.bytedance.ai.bridge.context.RefType;
import com.bytedance.ai.bridge.method.router.ReplyLocalPluginMethod;
import com.bytedance.ai.jsb.lynx.LynxWorkerModule;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.worker.WorkerType;
import com.lynx.jsbridge.LynxModule;
import com.lynx.tasm.LynxBackgroundRuntime;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ai/model/LynxWorkerRuntime;", "Lcom/bytedance/ai/model/AppletRuntime;", "Lcom/bytedance/ai/model/WorkerRuntime;", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LynxWorkerRuntime extends AppletRuntime {
    public static final /* synthetic */ int B = 0;
    public m1.i A;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final com.lynx.tasm.u f2226y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public y2.b f2227z;

    public LynxWorkerRuntime(Context r5, Applet r10, Map r11, com.lynx.tasm.u r12) {
        Intrinsics.checkNotNullParameter(r5, "app");
        Intrinsics.checkNotNullParameter(r10, "applet");
        Intrinsics.checkNotNullParameter(r12, "lynxGroup");
        super(r5, r10, r11);
        this.f2226y = r12;
    }

    @Override // com.bytedance.ai.model.AppletRuntime, com.bytedance.ai.core.base.d
    public final void j() {
        v();
    }

    @Override // com.bytedance.ai.model.AppletRuntime
    public final void m(com.bytedance.ai.bridge.method.net.e r5) {
        Intrinsics.checkNotNullParameter(r5, "succeed");
        com.lynx.tasm.u r10 = this.f2226y;
        y2.b r11 = new y2.b(this.g, this, r10);
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        this.f2227z = r11;
        r5.invoke(Boolean.valueOf(((y2.b) t()).f23234a));
    }

    @Override // com.bytedance.ai.model.AppletRuntime
    public final m1.i r() {
        return this.A;
    }

    @Override // com.bytedance.ai.model.AppletRuntime
    public final WorkerType s() {
        return WorkerType.f2375c;
    }

    @Override // com.bytedance.ai.model.AppletRuntime
    public final y2.e t() {
        y2.b r5 = this.f2227z;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("workerWrapper");
        return null;
    }

    @Override // com.bytedance.ai.model.AppletRuntime
    public final void u() {
        LynxBackgroundRuntime r5 = ((y2.b) t()).f23231b;
        r5.f9959a.c(LynxWorkerModule.class, r5, "AppletBridgeModule");
        LynxModule r10 = r5.f9959a.a("AppletBridgeModule").getModule();
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.bytedance.ai.jsb.lynx.LynxWorkerModule");
        i2.d r11 = new i2.d((LynxWorkerModule) r10);
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
        s r17 = new s(this, 1);
        r15.getClass();
        Intrinsics.checkNotNullParameter(s.class, "clazz");
        r15.c(s.class, r17, r16);
        Intrinsics.checkNotNullParameter(r12, "aiBridge");
        Intrinsics.checkNotNullParameter(ReplyLocalPluginMethod.class, "clazz");
        r12.f19973b.b(ReplyLocalPluginMethod.class);
        r12.d(r11);
        this.A = r12;
    }
}
