package androidx.emoji2.text;

import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes.dex */
public final class h extends f.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f.h f1768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ThreadPoolExecutor f1769b;

    public h(f.h r8, ThreadPoolExecutor r10) {
        this.f1768a = r8;
        this.f1769b = r10;
    }

    @Override // androidx.emoji2.text.f.h
    public final void a(Throwable r8) {
        ThreadPoolExecutor r10 = this.f1769b;
        this.f1768a.a(r8);     // Catch: Throwable -> L6
        r10.shutdown();
        return;
    L6:
        th = move-exception;
        r10.shutdown();
        throw th;
    }

    @Override // androidx.emoji2.text.f.h
    public final void b(n r8) {
        ThreadPoolExecutor r10 = this.f1769b;
        this.f1768a.b(r8);     // Catch: Throwable -> L6
        r10.shutdown();
        return;
    L6:
        th = move-exception;
        r10.shutdown();
        throw th;
    }
}
