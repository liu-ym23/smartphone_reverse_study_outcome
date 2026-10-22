package com.obric.update.impl.v2.handler;

import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.UpdateSettingsConfig;
import com.obric.assistant.t1;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class ObricScheduledUpdateHandler implements f09.a.b {
    public final Function0<Unit> a;
    public final CoroutineScope b;
    public Job c;
    public boolean d;
    public final SimpleDateFormat e;

    public static final class a {
    }

    static {
    }

    public final void onAllActivityDestroyed() {
    }

    public final void b() {
        if (this.d == false) goto L6;
        FLogger.a.d("ObricScheduledUpdateHandler", "App is in foreground, do not start scheduled check");
        return;
    L6:
        Job r0 = this.c;
        boolean r2 = false;
        if (r0 != null) goto L9;
    L11:
        if (r2 == false) goto L14;
        FLogger.a.d("ObricScheduledUpdateHandler", "Scheduled check already running");
        return;
    L14:
        this.c = BuildersKt.launch$default(this.b, null, null, new ObricScheduledUpdateHandler$startScheduledCheck$1(this, null), 3, null);
        FLogger.a.i("ObricScheduledUpdateHandler", "Scheduled update check started");
        return;
    L9:
        if (r0.isActive() != true) goto L11;
        r2 = true;
        goto L11
    }

    public final void onAppBackground() {
        FLogger.a.i("ObricScheduledUpdateHandler", "onAppBackground: start scheduled check");
        this.d = false;
        b();
    }

    public final void onAppForeground() {
        FLogger.a.i("ObricScheduledUpdateHandler", "onAppForeground: cancel scheduled check");
        this.d = true;
        Job r1 = this.c;
        if (r1 == null) goto L5;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L5:
        this.c = null;
    }

    public ObricScheduledUpdateHandler(com.obric.update.impl.v2.f r4) {
        Intrinsics.checkNotNullParameter(r4, "onCheckUpdate");
        this.a = r4;
        this.b = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(JobKt.Job$default(null, 1, null)));
        AppHost.Companion r5 = AppHost.a;
        this.d = !r5.a().isAppBackground();
        this.e = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
        r5.a().j(this);
    }

    public static final boolean a(ObricScheduledUpdateHandler r2) {
        r2.getClass();
        int r3 = Calendar.getInstance().get(11);
        UpdateSettingsConfig r0 = t1.a.L0();
        int r1 = r0.getObricUpdateScheduledCheckStartHour();
        if (r3 >= r0.getObricUpdateScheduledCheckEndHour()) goto L6;
        if (r1 > r3) goto L6;
        return true;
    L6:
        return false;
    }
}
