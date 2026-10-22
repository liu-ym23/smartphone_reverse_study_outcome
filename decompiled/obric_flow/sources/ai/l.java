package ai;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class l implements c, n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f261a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f262b;

    public l(Executor r5, c r10) {
        this.f261a = r5;
        this.f262b = r10;
    }

    @Override // ai.c
    public final void cancel() {
        this.f262b.cancel();
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m0clone() {
        return clone();
    }

    @Override // ai.n
    public final void doCollect() {
        c r5 = this.f262b;
        if ((r5 instanceof n) == false) goto L6;
        ((n) r5).doCollect();
        return;
    }

    @Override // ai.c
    public final q0 execute() {
        return this.f262b.execute();
    }

    @Override // ai.c
    public final boolean isCanceled() {
        return this.f262b.isCanceled();
    }

    @Override // ai.c
    public final c clone() {
        c r5 = this.f262b.clone();
        return new l(this.f261a, r5);
    }
}
