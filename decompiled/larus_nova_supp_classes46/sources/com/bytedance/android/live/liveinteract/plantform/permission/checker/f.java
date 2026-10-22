package com.bytedance.android.live.liveinteract.plantform.permission.checker;

import android.app.Activity;
import android.os.Build;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.bpea.cert.token.TokenCert;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f implements Runnable {
    public final /* synthetic */ Activity a;
    public final /* synthetic */ Cert b;

    public f(Activity r1, qh0.d r2, TokenCert r3) {
        this.a = r1;
        this.b = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    L13:
        return;
    L3:
        if (Intrinsics.areEqual("SO-04J", Build.MODEL) == false) goto L9;
        this.a.recreate();     // Catch: Throwable -> L6
        return;
    }
}
