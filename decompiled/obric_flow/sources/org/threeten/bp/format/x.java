package org.threeten.bp.format;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public abstract class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y f21259a = null;

    static {
        AtomicReference r5 = y.f21260a;
        b0 r10 = new b0();
    L4:
        if (r5.compareAndSet(null, r10) == true) goto L8;
        if (r5.get() == null) goto L4;
    L8:
        f21259a = (y) y.f21260a.get();
    }
}
