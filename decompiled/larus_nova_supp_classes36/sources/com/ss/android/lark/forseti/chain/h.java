package com.ss.android.lark.forseti.chain;

import androidx.fragment.app.Fragment;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.forseti.node.ForsetiNode;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h implements Runnable {
    public final /* synthetic */ Fragment a;
    public final /* synthetic */ ForsetiChainFragment b;

    public h(Fragment r1, ForsetiChainFragment r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        Log.i("Forseti_ChainFragment", "remove fragment now, f: " + cib.e.a(this.a));
        ForsetiChainHelper r0 = this.b.j;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("chainHelper");
        r0 = null;
    L5:
        Fragment r1 = this.a;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "f");
        ForsetiNode r2 = r0.c(r1);
        if (r2 == null) goto L9;
        r2.h(r1);
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
