package com.obric.aikernel.init.tasks.autoupdate;

import com.obric.aikernel.middleware.api.appcontext.AppContext;
import m3.d;

/* JADX INFO: loaded from: classes2.dex */
public final class AutoUpdateProcessWakeInitTask extends d {
    public AutoUpdateProcessWakeInitTask() {
    }

    @Override // java.lang.Runnable
    public void run() {
        AutoUpdateProcessWakeScheduler.f4482a.c(AppContext.INSTANCE.getContext());
    }
}
