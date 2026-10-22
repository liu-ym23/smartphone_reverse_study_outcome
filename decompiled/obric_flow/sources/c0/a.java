package c0;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public final class a implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1094a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f1095b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1096c;

    public a(String r5, boolean r10) {
        this.f1094a = r5;
        this.f1095b = r10;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final synchronized Thread newThread(Runnable r5) {
        monitor-enter(this);
        b9.a r10 = new b9.a(this, r5, "glide-" + this.f1094a + "-thread-" + this.f1096c);     // Catch: Throwable -> L7
        this.f1096c = this.f1096c + 1;     // Catch: Throwable -> L7
        monitor-exit(this);
        return r10;
    L7:
        th = move-exception;
        throw th;
    }
}
