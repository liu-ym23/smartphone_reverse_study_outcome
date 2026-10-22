package nnb;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.vmsdk.worker.JsWorker;
import com.ss.android.lark.jsruntime.EngineType;
import com.ss.android.lark.jsruntime.vmsdk.g;
import com.ss.android.lark.jsruntime.vmsdk.j;
import com.ss.android.lark.jsruntime.vmsdk.k;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.util.HashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import wl5.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c {
    public final j a;
    public pnb.b b;

    public class a implements tnb.c {
        public final /* synthetic */ C0302c a;

        public a(C0302c r1) {
            this.a = r1;
        }

        @Override // tnb.c
        public final void a(String r6) {
            wl5.c r0 = this.a.d;
            if (r0 == null) goto L12;
            Exception r1 = new Exception(r6);
            f r7 = r0.a;
            r7.getClass();
            if (r1.getStackTrace() != null) goto L7;
            return;
        L7:
            if (r1.getMessage() == null) goto L15;
            StringWriter r2 = new StringWriter();
            PrintWriter r3 = new PrintWriter(r2);
            r1.printStackTrace(r3);
            r3.flush();
            String r4 = r2.toString();
            HashMap r5 = new HashMap();
            r5.put("crash_message", r1.getMessage());
            r5.put("trace", r4);
            int r8 = unb.a.a;
            r5.put("runtime", "vmsdk");
            com.bytedance.ee.bear.contract.d r9 = r7.e;
            if (r9 == null) goto L11;
            r9.v("rn_exception", r5);
        L11:
            tt5.a.f("JSModelService-Docs", r1, false);
            return;
        L15:
            return;
        L12:
            rnb.c.b("BridgeEngine", r6);
        }
    }

    public interface b {
    }

    /* JADX INFO: renamed from: nnb.c$c, reason: collision with other inner class name */
    public static class C0302c {
        public boolean a;
        public Application b;
        public String c;
        public d d;
        public String e;

        public C0302c() {
        }
    }

    public c(C0302c r10) {
        Context r0 = r10.b.getApplicationContext();
        EngineType r1 = com.ss.android.lark.jsruntime.vmsdk.f.a;
        String r2 = r10.c;
        int r3 = mnb.a.a;
        Intrinsics.checkNotNullParameter(r0, "context");
        Intrinsics.checkNotNullParameter(r1, "engineType");
        Intrinsics.checkNotNullParameter(r2, "jsFilePath");
        Intrinsics.checkNotNullParameter("CCM_VMSDK", "bizName");
        if (r1 != EngineType.AHA_V8) goto L5;
        rnb.c.c("ccm_JSRuntimeFactory", "normalizeEngineType: AHA is unsupported in OfficeSDK, fallback to VMSDK_V8");
        r1 = EngineType.VMSDK_V8;
    L5:
        int r4 = mnb.a.C0297a.a[r1.ordinal()];
        if (r4 != 1) goto L8;
        j r5 = new j(r0, JsWorker.EngineType.QUICKJS, r2, mnb.a.a());
    L16:
        String r6 = "globalThis.__appInfo = " + r10.e;
        Intrinsics.checkNotNullParameter("const originalConsole = globalThis.console || {};\nconst logPolyfill = function(...args) {\n};\nconst consolePolyfill = {\n    log: logPolyfill,\n    warn: logPolyfill,\n    error: logPolyfill,\n    info: logPolyfill,\n    debug: logPolyfill,\n    assert: logPolyfill\n};\nglobalThis.console = consolePolyfill;", "script");
        rnb.c.c("VMSDK_VMSDKEngine", "evaluateScript: ");
        JsWorker r7 = r5.c;
        if (r7 == null) goto L19;
        r7.evaluateJavaScript("const originalConsole = globalThis.console || {};\nconst logPolyfill = function(...args) {\n};\nconst consolePolyfill = {\n    log: logPolyfill,\n    warn: logPolyfill,\n    error: logPolyfill,\n    info: logPolyfill,\n    debug: logPolyfill,\n    assert: logPolyfill\n};\nglobalThis.console = consolePolyfill;", "evaluateScript");
    L19:
        Intrinsics.checkNotNullParameter(r6, "script");
        rnb.c.c("VMSDK_VMSDKEngine", "evaluateScript: ");
        JsWorker r8 = r5.c;
        if (r8 == null) goto L22;
        r8.evaluateJavaScript(r6, "evaluateScript");
    L22:
        rnb.c.c("VMSDK_VMSDKEngine", "startRunJsFile: ");
        String r9 = r5.b;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L46
        xx4.a r12 = g.b;     // Catch: Throwable -> L46
        if (r12 == null) goto L32;
        String r13 = r12.a(r9);     // Catch: Throwable -> L46
        if (r13 == null) goto L32;
        if ((true ^ TextUtils.isEmpty(r13)) == true) goto L31;
        r13 = null;
    L31:
        if (r13 == null) goto L32;
    L39:
        Object r14 = Result.constructor-impl(r13);     // Catch: Throwable -> L46
    L49:
        if (Result.isSuccess-impl(r14) == false) goto L53;
        String r15 = (String) r14;
        rnb.c.c("VMSDK_VMSDKEngine", "evaluateJSBundle:" + r15.length());
        JsWorker r16 = r5.c;
        if (r16 == null) goto L53;
        r16.postOnJSRunner(new k(r5, r15));
    L53:
        Throwable r17 = Result.exceptionOrNull-impl(r14);
        if (r17 == null) goto L56;
        rnb.c.b("VMSDK_VMSDKEngine", "loadJSBundleFromFile: " + r17.getMessage());
    L56:
        this.a = r5;
        r5.e(new a(r10));
        boolean r18 = r10.a;
        pnb.c.a = r18;
        pnb.c.b = r18;
        pnb.c.c = r18;
        return;
    L32:
        Reader r19 = new InputStreamReader(r5.a.getAssets().open(r9), Charsets.UTF_8);     // Catch: Throwable -> L46
        if ((r19 instanceof BufferedReader) == false) goto L36;
        BufferedReader r20 = (BufferedReader) r19;     // Catch: Throwable -> L46
    L58:
        r13 = TextStreamsKt.readText(r20);     // Catch: Throwable -> L41
        CloseableKt.closeFinally(r20, null);     // Catch: Throwable -> L46
        goto L39
    L41:
        th = move-exception;
        throw th;     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        CloseableKt.closeFinally(r20, th);     // Catch: Throwable -> L46
        throw th;     // Catch: Throwable -> L46
    L36:
        r20 = new BufferedReader(r19, 8192);     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L49
    L8:
        if (r4 != 2) goto L10;
    L14:
        r5 = new j(r0, JsWorker.EngineType.V8, r2, mnb.a.a());
        goto L16
    L10:
        if (r4 == 3) goto L14;
        throw new NoWhenBranchMatchedException();
    }
}
