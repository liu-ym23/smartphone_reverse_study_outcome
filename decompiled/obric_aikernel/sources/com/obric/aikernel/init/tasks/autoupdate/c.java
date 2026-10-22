package com.obric.aikernel.init.tasks.autoupdate;

import android.content.Context;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
final class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f4484a;

    public c(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this.f4484a = r10;
    }

    @Override // com.obric.aikernel.init.tasks.autoupdate.b
    public void a(String r10, ExistingPeriodicWorkPolicy r11, PeriodicWorkRequest r12) {
        Intrinsics.checkNotNullParameter(r10, "uniqueWorkName");
        Intrinsics.checkNotNullParameter(r11, "policy");
        Intrinsics.checkNotNullParameter(r12, "request");
        WorkManager.getInstance(this.f4484a).enqueueUniquePeriodicWork(r10, r11, r12);
    }
}
