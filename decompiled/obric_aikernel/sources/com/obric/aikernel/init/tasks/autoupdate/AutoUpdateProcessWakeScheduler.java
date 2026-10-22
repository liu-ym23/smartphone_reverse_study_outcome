package com.obric.aikernel.init.tasks.autoupdate;

import android.content.Context;
import androidx.work.Constraints;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.PeriodicWorkRequest;
import com.obric.aikernel.utils.m;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class AutoUpdateProcessWakeScheduler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AutoUpdateProcessWakeScheduler f4482a = null;

    static {
        f4482a = new AutoUpdateProcessWakeScheduler();
    }

    private AutoUpdateProcessWakeScheduler() {
    }

    public final Constraints a() {
        return new Constraints.Builder().setRequiredNetworkType(NetworkType.UNMETERED).setRequiresCharging(true).setRequiresBatteryNotLow(true).build();
    }

    public final PeriodicWorkRequest b() {
        return new PeriodicWorkRequest.Builder(AutoUpdateProcessWakeWorker.class, a.b(), TimeUnit.MILLISECONDS).setConstraints(a()).build();
    }

    public final void c(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        d(r10, new AutoUpdateProcessWakeScheduler$sync$1(m.f5603a), new c(r10));
    }

    public final void d(Context r10, Function1<? super Context, Boolean> r11, b r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "isMainProcess");
        Intrinsics.checkNotNullParameter(r12, "enqueuer");
        if (r11.invoke(r10).booleanValue() == true) goto L7;
        String r13 = "sync skip non-main process";
    L5:
        a.a("AutoUpdateProcessWakeScheduler", r13);
        return;
    L7:
        ExistingPeriodicWorkPolicy r14 = ExistingPeriodicWorkPolicy.UPDATE;
        r12.a("AIKERNEL_AUTO_UPDATE_PROCESS_WAKE_WORK", r14, b());
        r13 = "sync enqueued uniqueWorkName=AIKERNEL_AUTO_UPDATE_PROCESS_WAKE_WORK intervalMillis=" + a.b() + " policy=" + r14;
        goto L5
    }
}
