package com.obric.aikernel.init.tasks.obric;

import com.obric.aikernel.middleware.api.obric.IAssistantStateService;
import m3.d;
import r7.a;

/* JADX INFO: loaded from: classes2.dex */
public final class ProcessServiceInitTask extends d {
    public ProcessServiceInitTask() {
    }

    @Override // java.lang.Runnable
    public void run() {
        IAssistantStateService r10 = a.a();
        if (r10 == null) goto L6;
        r10.init();
        return;
    }
}
