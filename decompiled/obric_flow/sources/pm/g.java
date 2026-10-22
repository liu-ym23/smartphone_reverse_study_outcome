package pm;

import com.lynx.tasm.b0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.lynx.tasm.behavior.f f21367a;

    public g(com.lynx.tasm.behavior.f r5) {
        this.f21367a = r5;
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: RuntimeException -> L4
        return;
    L4:
        e = move-exception;
        ((b0) this.f21367a).o(e);
    }
}
