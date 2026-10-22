package com.lynx.tasm.behavior;

import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes2.dex */
public final class j0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FutureTask f10270a;

    public j0(FutureTask r5) {
        this.f10270a = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f10270a.run();
    }
}
