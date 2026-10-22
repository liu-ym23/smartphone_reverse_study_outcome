package j5;

import android.content.Context;
import com.bytedance.ai.model.AppletJSModule;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.o;
import com.bytedance.ai.model.p;
import com.bytedance.ai.utils.m;
import com.bytedance.vmsdk.jsbridge.JSModuleManager;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import com.bytedance.vmsdk.worker.JsWorker;
import f2.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d extends g<JsWorker> {
    public final JsWorker b;

    @Override // j5.g
    public final void a() {
        this.a = false;
        this.b.terminate();
    }

    @Override // j5.g
    public final String d() {
        return String.valueOf(this.b.id());
    }

    @Override // j5.g
    public final JsWorker c() {
        return this.b;
    }

    @Override // j5.g
    public final boolean e() {
        return this.a;
    }

    @Override // j5.g
    public final void f(final Function0<Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "block");
        this.b.postOnWorkerRunner(new b(r10));
    }

    @Override // j5.g
    public final void g(final JavaOnlyMap r10) {
        Intrinsics.checkNotNullParameter(r10, "param");
        this.b.postOnJSRunner(new c(this, r10));
    }

    public d(Context r10, AppletRuntime r11) {
        Intrinsics.checkNotNullParameter(r10, "application");
        Intrinsics.checkNotNullParameter(r11, "runtime");
    L9:
        e = move-exception;
        throw new RuntimeException("Failed to initialize JSWorker", e);
    L4:
        if (JsWorker.isIsInitialised() == true) goto L6;
        JsWorker.initialize();     // Catch: Exception -> L9
    L6:
        JSModuleManager r0 = new JSModuleManager(r10);     // Catch: Exception -> L9
        r0.b(AppletJSModule.NAME, AppletJSModule.class, r11);     // Catch: Exception -> L9
        JsWorker.EngineType r12 = JsWorker.EngineType.QUICKJS;     // Catch: Exception -> L9
        com.bytedance.vmsdk.worker.a.a r13 = new com.bytedance.vmsdk.worker.a.a();     // Catch: Exception -> L9
        r13.b = "BotUI_Applet";     // Catch: Exception -> L9
        r13.f = r0;     // Catch: Exception -> L9
        r13.a = r12;     // Catch: Exception -> L9
        r13.c = null;     // Catch: Exception -> L9
        r13.d = k.b;     // Catch: Exception -> L9
        com.bytedance.vmsdk.worker.a r14 = new com.bytedance.vmsdk.worker.a(r13);     // Catch: Exception -> L9
        int r15 = b6.a.a;     // Catch: Exception -> L9
        Intrinsics.checkNotNull(r14);     // Catch: Exception -> L9
        Intrinsics.checkNotNullParameter(r14, "params");     // Catch: Exception -> L9
        JsWorker r16 = new JsWorker(r14);     // Catch: Exception -> L9
        JavaOnlyMap r17 = new JavaOnlyMap();     // Catch: Exception -> L9
        r17.put("__AI_SDK_VERSION__", "1.15.0-rc.7");     // Catch: Exception -> L9
        r16.setGlobalProperties(r17);     // Catch: Exception -> L9
        this.a = true;     // Catch: Exception -> L9
        this.b = r16;
    }

    @Override // j5.g
    public final void b(m r10, String r11, o r12, final p r13) {
        Intrinsics.checkNotNullParameter(r10, "script");
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r12, "onSuccess");
        Intrinsics.checkNotNullParameter(r13, "onFailure");
        if (this.a == false) goto L8;
        this.b.evaluateJavaScript(((m.b) r10).a, r11);
        final Ref.BooleanRef r14 = new Ref.BooleanRef();
        r14.element = true;
        this.b.setOnErrorCallback(new a(r13, r14));
        if (r14.element == false) goto L10;
        r12.invoke();
        return;
    L10:
        return;
    L8:
        r13.invoke("JSWorker not initialized");
        throw new IllegalStateException("JSWorker not initialized");
    }
}
