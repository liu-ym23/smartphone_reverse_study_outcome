package com.ss.android.lark.integrator.security.compliance.screen_audit;

import android.app.Activity;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.ss.android.lark.log.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d {
    public final com.ss.android.lark.integrator.security.compliance.screen_audit.a a;
    public final WeakHashMap<Activity, Activity.ScreenCaptureCallback> b;
    public long c;

    public static final class a {
    }

    static {
    }

    public final void a() {
        if (Build.VERSION.SDK_INT >= 34) goto L5;
        return;
    L5:
        Iterator r0 = new HashMap(this.b).entrySet().iterator();
    L7:
        if (r0.hasNext() == false) goto L13;
        Map.Entry r1 = (Map.Entry) r0.next();
        Activity r2 = (Activity) r1.getKey();
        Activity.ScreenCaptureCallback r3 = (Activity.ScreenCaptureCallback) r1.getValue();
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L11
        r2.unregisterScreenCaptureCallback(r3);     // Catch: Throwable -> L11
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    L13:
        this.b.clear();
        Log.i("OfficeSDKScreenAudit", "all screenshot callbacks cleaned");
    }

    public d(com.ss.android.lark.integrator.security.compliance.screen_audit.a r2) {
        Intrinsics.checkNotNullParameter(r2, "reporter");
        this.a = r2;
        this.b = new WeakHashMap();
    }

    public final void b(Activity r5) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        int r0 = Build.VERSION.SDK_INT;
        if (r0 >= 34) goto L7;
        Log.i("OfficeSDKScreenAudit", "skip onActivityStarted, device sdk=" + r0 + " < 34 (Android 14)");
        return;
    L7:
        if (this.b.containsKey(r5) == true) goto L17;
        Executor r1 = ContextCompat.getMainExecutor(r5);
        e r3 = new e(this, r5);
        r5.registerScreenCaptureCallback(r1, r3);     // Catch: Throwable -> L12
        this.b.put(r5, r3);     // Catch: Throwable -> L12
        Log.i("OfficeSDKScreenAudit", "screenshot callback registered for ".concat(r5.getClass().getSimpleName()));     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        Log.e("OfficeSDKScreenAudit", "registerScreenCaptureCallback failed", th);
        return;
    }

    public final void c(Activity r4) {
        Intrinsics.checkNotNullParameter(r4, "activity");
        if (Build.VERSION.SDK_INT >= 34) goto L5;
        return;
    L5:
        Activity.ScreenCaptureCallback r2 = this.b.remove(r4);
        if (r2 == null) goto L15;
        r4.unregisterScreenCaptureCallback(r2);     // Catch: Throwable -> L10
        Log.i("OfficeSDKScreenAudit", "screenshot callback unregistered for ".concat(r4.getClass().getSimpleName()));     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        Log.e("OfficeSDKScreenAudit", "unregisterScreenCaptureCallback failed", th);
        return;
    }
}
