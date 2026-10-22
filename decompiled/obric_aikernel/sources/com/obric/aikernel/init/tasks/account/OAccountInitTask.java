package com.obric.aikernel.init.tasks.account;

import com.obric.aikernel.middleware.api.account.IOAccountManager;
import d4.a;
import kotlin.jvm.internal.Reflection;
import m3.d;

/* JADX INFO: loaded from: classes2.dex */
public final class OAccountInitTask extends d {
    public OAccountInitTask() {
    }

    @Override // java.lang.Runnable
    public void run() {
        IOAccountManager r10 = (IOAccountManager) a.a(Reflection.getOrCreateKotlinClass(IOAccountManager.class));
        if (r10 == null) goto L6;
        r10.init();
        return;
    }
}
