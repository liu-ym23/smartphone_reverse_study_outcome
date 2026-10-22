package com.larus.dora.impl.device.settings.lab.env;

import androidx.lifecycle.ProcessLifecycleOwner;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class d implements Runnable {
    public /* synthetic */ d() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        ProcessLifecycleOwner.Companion.get().getLifecycle().addObserver(new DoraEnvObserveManager$init$3$1());
    }
}
