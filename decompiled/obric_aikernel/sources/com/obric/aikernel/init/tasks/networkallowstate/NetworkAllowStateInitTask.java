package com.obric.aikernel.init.tasks.networkallowstate;

import com.obric.aikernel.middleware.api.network.NetworkAllowState;
import m3.d;

/* JADX INFO: loaded from: classes2.dex */
public final class NetworkAllowStateInitTask extends d {
    public NetworkAllowStateInitTask() {
    }

    @Override // java.lang.Runnable
    public void run() {
        NetworkAllowState.INSTANCE.init();
    }
}
