package com.obric.aikernel.init.tasks.alog;

import com.obric.aikernel.middleware.api.alog.ALogManager;
import m3.d;

/* JADX INFO: loaded from: classes2.dex */
public final class ALogInitTask extends d {
    public ALogInitTask() {
    }

    @Override // java.lang.Runnable
    public void run() {
        ALogManager.INSTANCE.init();
    }
}
