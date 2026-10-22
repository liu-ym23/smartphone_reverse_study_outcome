package com.obric.aikernel.init.tasks.npth;

import com.bytedance.applog.a;
import com.obric.aikernel.middleware.api.npth.NpthInit;
import m3.d;

/* JADX INFO: loaded from: classes2.dex */
public final class NpthInitTask extends d {
    public NpthInitTask() {
    }

    @Override // java.lang.Runnable
    public void run() {
        String r10 = a.d();
        boolean r11 = true;
        if (r10 != null) goto L5;
    L10:
        r11 = false;
    L11:
        if (r11 == false) goto L14;
        NpthInit.INSTANCE.init();
        return;
    L14:
        return;
    L5:
        if (r10.length() <= 0) goto L7;
        boolean r12 = true;
    L8:
        if (r12 != true) goto L10;
    L7:
        r12 = false;
        goto L8
    }
}
