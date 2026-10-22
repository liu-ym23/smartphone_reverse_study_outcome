package com.obric.aikernel.init.tasks.service;

import android.annotation.SuppressLint;
import android.os.Process;
import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.middleware.api.service.AIInferRuntime;
import m3.d;

/* JADX INFO: loaded from: classes2.dex */
public final class AIInferRuntimeInitTask extends d {
    public AIInferRuntimeInitTask() {
    }

    @Override // java.lang.Runnable
    @SuppressLint({"NewApi"})
    public void run() {
        AIKLog.INSTANCE.i("AIInferRuntimeInitTask", "vm_init run in " + Process.myProcessName());
        AIInferRuntime.INSTANCE.init();
    }
}
