package com.obric.aikernel.init.tasks.settings;

import com.obric.aikernel.middleware.api.settings.AppSettingsManager;
import m3.d;

/* JADX INFO: loaded from: classes2.dex */
public final class InitSettingsTask extends d {
    public InitSettingsTask() {
    }

    @Override // java.lang.Runnable
    public void run() {
        AppSettingsManager.INSTANCE.init();
    }
}
