package com.larus.bmhome.taskskill.view;

import android.view.ViewGroup;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class u implements Runnable {
    public final /* synthetic */ v a;
    public final /* synthetic */ ViewGroup b;

    public /* synthetic */ u(v r1, ViewGroup r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.b(this.b, 0);
    }
}
