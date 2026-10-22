package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class DeferredReleaserConcurrentImpl extends DeferredReleaser {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f7751b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f7752c;
    public ArrayList d;
    public ArrayList e;
    public final Runnable f;

    public DeferredReleaserConcurrentImpl() {
        this.f7751b = new Object();
        this.f = new AnonymousClass1(this);
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f7752c = new Handler(Looper.getMainLooper());
    }

    public final void a(DeferredReleaser.Releasable r5) {
        Object r10 = this.f7751b;
        monitor-enter(r10);
        this.d.remove(r5);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
