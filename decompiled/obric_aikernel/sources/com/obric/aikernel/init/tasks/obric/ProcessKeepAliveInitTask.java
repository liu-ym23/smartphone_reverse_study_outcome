package com.obric.aikernel.init.tasks.obric;

import com.obric.aikernel.middleware.api.obric.IProcessService;
import com.obric.aikernel.middleware.api.obric.ProcessService;
import m3.d;

/* JADX INFO: loaded from: classes2.dex */
public final class ProcessKeepAliveInitTask extends d {
    public ProcessKeepAliveInitTask() {
    }

    @Override // java.lang.Runnable
    public void run() {
        IProcessService.a.a(ProcessService.INSTANCE, null, 1, null);
    }
}
