package gc;

import kotlin.jvm.JvmField;
import kotlinx.coroutines.o0;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends g {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @JvmField
    public final Runnable f9109h;

    public j(Runnable r10, long r11, h r12) {
        super(r11, r12);
        this.f9109h = r10;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f9109h.run();     // Catch: Throwable -> L5
        this.f9107g.a();
        return;
    L5:
        th = move-exception;
        this.f9107g.a();
        throw th;
    }

    public String toString() {
        return "Task[" + o0.a(this.f9109h) + '@' + o0.b(this.f9109h) + ", " + this.f9106c + ", " + this.f9107g + ']';
    }
}
