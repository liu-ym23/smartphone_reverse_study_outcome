package com.ss.android.lark.integrator.security.compliance.screen_audit;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.view.WindowManager;
import androidx.core.content.ContextCompat;
import com.ss.android.lark.log.Log;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public static final /* synthetic */ int d = 0;
    public final com.ss.android.lark.integrator.security.compliance.screen_audit.a a;
    public c b;
    public int c;

    public static final class a {
    }

    static {
    }

    public b(com.ss.android.lark.integrator.security.compliance.screen_audit.a r2) {
        Intrinsics.checkNotNullParameter(r2, "reporter");
        this.a = r2;
        this.c = -1;
    }

    public final void a(Application r5) {
        if (Build.VERSION.SDK_INT >= 35) goto L5;
        return;
    L5:
        c r0 = this.b;
        if (r0 != null) goto L9;
    L20:
        Log.i("OfficeSDKScreenAudit", "all recording callbacks cleaned");
        return;
    L9:
        if (r5 == null) goto L11;
        WindowManager r6 = (WindowManager) r5.getSystemService(WindowManager.class);
    L13:
        if (r6 != null) goto L27;
        this.b = null;
        this.c = -1;
        Log.w("OfficeSDKScreenAudit", "cannot resolve WindowManager when unregistering");
        goto L20
    L27:
        r6.removeScreenRecordingCallback(r0);     // Catch: Throwable -> L17
        Log.i("OfficeSDKScreenAudit", "recording callback unregistered");     // Catch: Throwable -> L17
    L19:
        this.b = null;
        this.c = -1;
    L17:
        th = move-exception;
        Log.e("OfficeSDKScreenAudit", "removeScreenRecordingCallback failed", th);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        this.b = null;
        this.c = -1;
        throw th;
    L11:
        r6 = null;
        goto L13
    }

    public final void b(Activity r6) {
        Intrinsics.checkNotNullParameter(r6, "activity");
        int r0 = Build.VERSION.SDK_INT;
        if (r0 >= 35) goto L7;
        Log.i("OfficeSDKScreenAudit", "skip onActivityStarted, device sdk=" + r0 + " < 35 (Android 15)");
        return;
    L7:
        if (this.b == null) goto L9;
        return;
    L9:
        WindowManager r1 = (WindowManager) r6.getSystemService(WindowManager.class);
        if (r1 == null) goto L20;
        Executor r3 = ContextCompat.getMainExecutor(r6);
        c r4 = new c(this);
        r1.addScreenRecordingCallback(r3, r4);     // Catch: Throwable -> L15
        this.b = r4;     // Catch: Throwable -> L15
        this.c = -1;     // Catch: Throwable -> L15
        Log.i("OfficeSDKScreenAudit", "recording callback registered via ".concat(r6.getClass().getSimpleName()));     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        Log.e("OfficeSDKScreenAudit", "addScreenRecordingCallback failed", th);
        return;
    }
}
