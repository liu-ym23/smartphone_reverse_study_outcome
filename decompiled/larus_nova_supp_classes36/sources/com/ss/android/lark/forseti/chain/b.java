package com.ss.android.lark.forseti.chain;

import android.view.ViewGroup;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiViewModel;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.forseti.widget.ForsetiNormalChainViewGroupCompat;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements Runnable {
    public final /* synthetic */ ForsetiChainFragment a;
    public final /* synthetic */ com.ss.android.lark.api.ui.f b;

    public b(ForsetiChainFragment r1, ForsetiViewModel.b r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ForsetiChainFragment r0 = this.a;     // Catch: Throwable -> L16
        if (r0.f == null) goto L19;
        ViewGroup r1 = r0.g;     // Catch: Throwable -> L16
        ForsetiNormalChainViewGroupCompat r2 = null;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("parentViewGroup");     // Catch: Throwable -> L16
        r1 = null;
    L8:
        if ((r1 instanceof ForsetiNormalChainViewGroupCompat) == false) goto L10;
        r2 = (ForsetiNormalChainViewGroupCompat) r1;     // Catch: Throwable -> L16
    L10:
        if (r2 == null) goto L23;
        com.ss.android.lark.api.ui.f r3 = this.b;     // Catch: Throwable -> L16
        Intrinsics.checkNotNullParameter(r3, "listener");     // Catch: Throwable -> L16
        if (r2.c == false) goto L24;
        ((ArrayList) r2.g).add(r3);     // Catch: Throwable -> L16
        return;
    L24:
        return;
    L23:
        return;
    L19:
        return;
    L16:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L25;
        throw th;
    }
}
