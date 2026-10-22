package j5;

import android.content.Context;
import com.bytedance.ai.debug.IAISDKDebugService;
import com.bytedance.ai.debug.IAISDKDebugService$d;
import com.bytedance.ai.lynx.u;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.o;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.p;
import com.bytedance.ai.utils.m;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import com.lynx.tasm.LynxBackgroundRuntime;
import com.lynx.tasm.LynxGroup;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.q;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f extends g<LynxBackgroundRuntime> {
    public final Context b;
    public final AppletRuntime c;
    public final LynxBackgroundRuntime d;
    public final IAISDKDebugService$d e;

    public static final class a {
    }

    static {
    }

    @Override // j5.g
    public final void a() {
        this.a = false;
        IAISDKDebugService.a.D(this.e);
        this.d.b();
    }

    @Override // j5.g
    public final void g(JavaOnlyMap r10) {
        Intrinsics.checkNotNullParameter(r10, "param");
    }

    @Override // j5.g
    public final String d() {
        return String.valueOf(this.d.hashCode());
    }

    @Override // j5.g
    public final LynxBackgroundRuntime c() {
        return this.d;
    }

    @Override // j5.g
    public final boolean e() {
        return this.a;
    }

    @Override // j5.g
    public final void f(Function0<Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "block");
        r10.invoke();
    }

    public f(Context r10, AppletRuntime r11, LynxGroup r12) {
        Intrinsics.checkNotNullParameter(r10, "application");
        Intrinsics.checkNotNullParameter(r11, "runtime");
        Intrinsics.checkNotNullParameter(r12, "lynxGroup");
        this.b = r10;
        this.c = r11;
        q r0 = new q();
        r0.c = r12;
        r0.j = new u(r10, null);
        LynxBackgroundRuntime r13 = new LynxBackgroundRuntime(this.b, r0, r11.h.A);
        this.a = true;
        this.d = r13;
        IAISDKDebugService.Companion r14 = IAISDKDebugService.a;
        IAISDKDebugService$d r1 = r14.f(new e(this));
        this.e = r1;
        r14.i(r1, r13, r11.h.K);
    }

    @Override // j5.g
    public final void b(m r10, String r11, o r12, p r13) {
        Intrinsics.checkNotNullParameter(r10, "script");
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r12, "onSuccess");
        Intrinsics.checkNotNullParameter(r13, "onFailure");
        if (this.a == false) goto L31;
        boolean r1 = false;
        if (StringsKt.startsWith$default(r11, "/", false, 2, null) == true) goto L33;
        r11 = "/" + r11;
    L33:
    L28:
        e = move-exception;
        com.bytedance.ai.utils.g.a.e("LynxWorkerWrapper", "failed to load worker script", e);
        r13.invoke(e.toString());
        return;
    L9:
        if ((r10 instanceof m.b) == false) goto L12;
        this.d.c(r11, ((m.b) r10).a);     // Catch: Exception -> L28
    L21:
        r12.invoke();     // Catch: Exception -> L28
        return;
    L12:
        if ((r10 instanceof m.a) == false) goto L27;
        if (((m.a) r10).a == null) goto L25;
        Applet r0 = this.c.h;     // Catch: Exception -> L28
        if (r0.E != 1) goto L18;
        r1 = true;
    L18:
        String r14 = r0.b;     // Catch: Exception -> L28
        com.bytedance.ai.resource.security.e r15 = com.bytedance.ai.resource.security.e.a;     // Catch: Exception -> L28
        byte[] r16 = ((m.a) r10).a;     // Catch: Exception -> L28
        r15.getClass();     // Catch: Exception -> L28
        TemplateBundle r17 = com.bytedance.ai.resource.security.e.g(r16, r1, r14, "");     // Catch: Exception -> L28
        if (r17 == null) goto L23;
        this.d.d(r11, r17, "base/app");     // Catch: Exception -> L28
        goto L21
    L23:
        throw new IllegalStateException("TemplateBundle is invalid");     // Catch: Exception -> L28
    L25:
        throw new IllegalStateException("template data is NULL");     // Catch: Exception -> L28
    L27:
        throw new NoWhenBranchMatchedException();     // Catch: Exception -> L28
    L31:
        r13.invoke("JSWorker not initialized");
        throw new IllegalStateException("JSWorker not initialized");
    }
}
