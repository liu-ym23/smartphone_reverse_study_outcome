package com.ss.android.lark.forseti.node;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements Runnable {
    public final /* synthetic */ ForsetiNode a;
    public final /* synthetic */ Fragment b;
    public final /* synthetic */ String c;
    public final /* synthetic */ uua.a d;

    public b(ForsetiNode r1, Fragment r2, String r3, FragmentManager.FragmentLifecycleCallbacks r4, uua.a r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ForsetiNodeFragment r0 = this.a.c;     // Catch: Throwable -> L7
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("nodeContainerFragment");     // Catch: Throwable -> L7
        r0 = null;
    L5:
        r0.getChildFragmentManager();     // Catch: Throwable -> L7
        this.a.b(this.b, this.c, this.d);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
