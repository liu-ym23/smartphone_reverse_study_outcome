package com.bytedance.android.live.liveinteract.linkpanel.view;

import android.view.View;
import com.bytedance.android.livesdk.r3;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements Runnable {
    public final /* synthetic */ Ref.ObjectRef a;

    public c(Ref.ObjectRef r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View r0 = (View) this.a.element;     // Catch: Throwable -> L4
        Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L4
        r3.p(r0);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
