package com.bytedance.android.ec.core.anchorv3;

import android.view.Choreographer;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class k implements Runnable {
    public final /* synthetic */ j a;

    public k(j r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Choreographer.getInstance().removeFrameCallback(this.a.s);     // Catch: Throwable -> L7
        Iterator r0 = ((ArrayList) this.a.e).iterator();     // Catch: Throwable -> L7
    L4:
        if (r0.hasNext() == false) goto L16;
        ((Function1) r0.next()).invoke(Boolean.FALSE);     // Catch: Throwable -> L7
        goto L4
    L16:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
