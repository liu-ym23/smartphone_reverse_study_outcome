package com.larus.project;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class u implements Runnable {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ TaskProjectFragment b;
    public final /* synthetic */ RecyclerView c;

    public u(boolean r1, TaskProjectFragment r2, RecyclerView r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L12:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L22;
        throw th;
    L22:
        return;
    L3:
        if (this.a == false) goto L15;
        TaskProjectFragment r0 = this.b;     // Catch: Throwable -> L12
        if (r0.k == true) goto L7;
        return;
    L7:
        if (r0.l == false) goto L9;
        return;
    L9:
        if (this.c.canScrollVertically(1) == true) goto L21;
        this.b.Z90();     // Catch: Throwable -> L12
        return;
    L21:
        return;
    }
}
