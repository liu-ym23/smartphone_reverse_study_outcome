package ve;

import pe.d0;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends g {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Runnable f12881m;

    public j(Runnable r8, long r10, h r11) {
        super(r10, r11);
        this.f12881m = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f12881m.run();     // Catch: Throwable -> L5
        this.f12879b.a();
        return;
    L5:
        th = move-exception;
        this.f12879b.a();
        throw th;
    }

    public final String toString() {
        StringBuilder r8 = new StringBuilder("Task[");
        Runnable r10 = this.f12881m;
        r8.append(r10.getClass().getSimpleName());
        r8.append('@');
        r8.append(d0.c(r10));
        r8.append(", ");
        r8.append(this.f12878a);
        r8.append(", ");
        r8.append(this.f12879b);
        r8.append(']');
        return r8.toString();
    }
}
