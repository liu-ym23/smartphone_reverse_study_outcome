package v6;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public abstract class b implements c, Runnable, Comparable<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f12733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f12734b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f12735m;

    public b() {
        new AtomicBoolean(false);
        this.f12733a = new AtomicBoolean(false);
        this.f12734b = 0;
    }

    public final int c() {
        return this.f12734b;
    }

    public final boolean d() {
        return this.f12733a.get();
    }
}
