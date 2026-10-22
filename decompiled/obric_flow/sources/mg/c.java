package mg;

import com.bytedance.monitor.util.thread.AsyncTaskType;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AsyncTaskType f20086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Runnable f20087b;

    public c(String r5, AsyncTaskType r10, Runnable r11) {
        this.f20086a = r10;
        this.f20087b = r11;
    }

    @Override // mg.d
    public final AsyncTaskType p() {
        return this.f20086a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable r5 = this.f20087b;     // Catch: Throwable -> L6
        if (r5 == null) goto L10;
        r5.run();     // Catch: Throwable -> L6
        b r10 = a.f20082a;     // Catch: Throwable -> L6
        return;
    L10:
        return;
    L6:
        a.f20082a.getClass();
    }
}
