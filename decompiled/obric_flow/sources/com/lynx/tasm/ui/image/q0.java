package com.lynx.tasm.ui.image;

import android.os.Looper;
import com.facebook.common.internal.Objects;
import com.facebook.drawee.interfaces.DraweeHierarchy;

/* JADX INFO: loaded from: classes2.dex */
public final class q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f11096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f11097b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DraweeHierarchy f11098c;
    public n0 d;

    public q0(DraweeHierarchy r5) {
        this.f11096a = false;
        this.f11097b = false;
        this.d = null;
        if (r5 == null) goto L6;
        this.f11098c = r5;
        return;
    }

    public final void a() {
        if (this.f11096a == true) goto L5;
        return;
    L5:
        this.f11096a = false;
        p0 r5 = new p0(this, 1);
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) goto L8;
        r5.run();
        return;
    L8:
        mn.h.j().execute(r5);
    }

    public final String toString() {
        return new Objects.ToStringHelper(q0.class.getSimpleName()).a("controllerAttached", String.valueOf(this.f11096a)).a("holderAttached", String.valueOf(this.f11097b)).a("drawableVisible", String.valueOf(true)).toString();
    }
}
