package com.ss.android.lark.jsruntime.vmsdk;

import android.content.Context;
import com.bytedance.vmsdk.jsbridge.JSModule;
import com.bytedance.vmsdk.jsbridge.JSModuleManager;
import com.bytedance.vmsdk.jsbridge.JSModuleWrapper;
import com.bytedance.vmsdk.worker.JsWorker;
import com.ss.android.lark.jsruntime.vmsdk.module.VMConsoleLogModule;
import com.ss.android.lark.jsruntime.vmsdk.module.VMPlatformModule;
import com.ss.android.lark.jsruntime.vmsdk.module.VmSDKRequestDelegate;
import com.ss.android.lark.jsruntime.vmsdk.module.VmSdkEventEmitterModule;
import com.ss.android.lark.jsruntime.vmsdk.module.VmSdkJsToNativeBridgeModule;
import com.ss.android.lark.jsruntime.vmsdk.module.VmsdkWebSocketModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class j implements tnb.a, tnb.f, tb5.f.b {
    public final Context a;
    public final String b;
    public JsWorker c;
    public final Lazy d;
    public final List<tnb.e> e;
    public boolean f;
    public final List<tnb.c> g;
    public final List<tnb.d> h;
    public final List<tnb.f> i;
    public boolean j;
    public e k;

    public static final class a {
    }

    static {
    }

    public final JSModuleManager h() {
        return (JSModuleManager) this.d.getValue();
    }

    public final VmSdkEventEmitterModule g() {
        JSModuleWrapper r0 = h().a(VmSdkEventEmitterModule.NAME);
        if (r0 == null) goto L5;
        JSModule r1 = r0.getModule();
    L7:
        if ((r1 instanceof VmSdkEventEmitterModule) == true) goto L11;
        rnb.c.b("VMSDK_VMSDKEngine", "getNativeToJsModule: module is not VmSdkEventEmitterModule");
        return null;
    L11:
        return (VmSdkEventEmitterModule) r1;
    L5:
        r1 = null;
        goto L7
    }

    public final void i() {
        h().b(VMConsoleLogModule.NAME, VMConsoleLogModule.class, null);
        h().b(VMPlatformModule.NAME, VMPlatformModule.class, null);
        h().b(VmSdkEventEmitterModule.NAME, VmSdkEventEmitterModule.class, this);
        h().b(VmSdkJsToNativeBridgeModule.NAME, VmSdkJsToNativeBridgeModule.class, this);
        h().b(VmsdkWebSocketModule.NAME, VmsdkWebSocketModule.class, g());
    }

    public final Context getContext() {
        return this.a;
    }

    public final void b(String r2) {
        JsWorker r0 = this.c;
        if (r0 == null) goto L6;
        r0.evaluateJavaScript(r2);
        return;
    }

    @Override // tnb.f
    public final void c(String r3) {
        Intrinsics.checkNotNullParameter(r3, "jsonString");
        Iterator<T> r0 = this.i.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((tnb.f) r0.next()).c(r3);
        goto L4
    }

    @Override // tnb.f
    public final void d(String r3) {
        Intrinsics.checkNotNullParameter(r3, "dataString");
        Iterator<T> r0 = this.i.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((tnb.f) r0.next()).d(r3);
        goto L4
    }

    public final void e(nnb.c.a r3) {
        Intrinsics.checkNotNullParameter(r3, "handler");
        rnb.c.c("VMSDK_VMSDKEngine", "addExceptionHandler() called with: handler = " + r3);
        ((ArrayList) this.g).add(r3);
    }

    public final void f(pnb.a r3) {
        Intrinsics.checkNotNullParameter(r3, "delegate");
        rnb.c.c("VMSDK_VMSDKEngine", "addJSRuntimeToNativeBridgeDelegate() called with: delegate = " + r3);
        ((ArrayList) this.i).add(r3);
    }

    @Override // tnb.a
    public final void a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter(r3, "data");
        VmSdkEventEmitterModule r0 = g();
        if (r0 == null) goto L5;
        r0.sendEvent(r2, r3);
        return;
    L5:
        rnb.c.b("VMSDK_VMSDKEngine", "sendDataToJSEngine:error: getJSRuntimeDataSender() is null");
    }

    public j(Context r6, JsWorker.EngineType r7, String r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "engineType");
        Intrinsics.checkNotNullParameter(r8, "jsFilePath");
        Intrinsics.checkNotNullParameter("CCM_VMSDK", "bizName");
        this.a = r6;
        this.b = r8;
        this.d = LazyKt.lazy(new VMSDKEngine$moduleManager$2(this));
        this.e = new ArrayList();
        this.g = new ArrayList();
        this.h = new ArrayList();
        ArrayList r10 = new ArrayList();
        this.i = r10;
        Intrinsics.checkNotNullParameter(r8, "jsFilePath");
    L17:
        e = move-exception;
        rnb.c.b("VMSDK_VMSDKEngine", "Error:VMSDK init error! " + e);
        return;
    L4:
        if (this.j == false) goto L6;
        rnb.c.b("VMSDK_VMSDKEngine", "Error:VMSDK hasinit!");     // Catch: Exception -> L17
    L6:
        this.j = true;     // Catch: Exception -> L17
        rnb.c.c("VMSDK_VMSDKEngine", "init() called VMSDKEngine start with: jsFilePath = " + r8 + "  ");     // Catch: Exception -> L17
        com.bytedance.vmsdk.worker.a.a r3 = new com.bytedance.vmsdk.worker.a.a();     // Catch: Exception -> L17
        r3.b = "CCM_VMSDK";     // Catch: Exception -> L17
        r3.f = h();     // Catch: Exception -> L17
        r3.a = r7;     // Catch: Exception -> L17
        r3.e = true;     // Catch: Exception -> L17
        r3.d = r9;     // Catch: Exception -> L17
        this.c = new JsWorker(new com.bytedance.vmsdk.worker.a(r3));     // Catch: Exception -> L17
        i();     // Catch: Exception -> L17
        JsWorker r11 = this.c;     // Catch: Exception -> L17
        if (r11 == null) goto L9;
        r11.setWorkerDelegate(new VmSDKRequestDelegate());     // Catch: Exception -> L17
    L9:
        JsWorker r12 = this.c;     // Catch: Exception -> L17
        if (r12 == null) goto L12;
        r12.setOnErrorCallback(new VMSDKEngine$init$1(this));     // Catch: Exception -> L17
    L12:
        JsWorker r13 = this.c;     // Catch: Exception -> L17
        if (r13 == null) goto L15;
        r13.setOnMessageCallback(new VMSDKEngine$init$2(this));     // Catch: Exception -> L17
    L15:
        this.k = new e(this);     // Catch: Exception -> L17
        r10.add(new l(this));     // Catch: Exception -> L17
    }
}
