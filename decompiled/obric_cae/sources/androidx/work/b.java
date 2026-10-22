package androidx.work;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class b implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f2794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f2795b;

    public b(boolean r8) {
        this.f2795b = r8;
        this.f2794a = new AtomicInteger(0);
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r8) {
        if (this.f2795b == false) goto L5;
        String r10 = "WM.task-";
    L6:
        StringBuilder r11 = android.aimedia.a.j(r10);
        r11.append(this.f2794a.incrementAndGet());
        return new Thread(r8, r11.toString());
    L5:
        r10 = "androidx.work-";
        goto L6
    }
}
