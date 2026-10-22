package gc;

import java.util.concurrent.Executor;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.scheduling.CoroutineScheduler;

/* JADX INFO: loaded from: classes3.dex */
public class e extends ExecutorCoroutineDispatcher {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f9101c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f9102g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final long f9103h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f9104i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private CoroutineScheduler f9105j;

    public e(int r10, int r11, long r12, String r13) {
        this.f9101c = r10;
        this.f9102g = r11;
        this.f9103h = r12;
        this.f9104i = r13;
        this.f9105j = d0();
    }

    private final CoroutineScheduler d0() {
        return new CoroutineScheduler(this.f9101c, this.f9102g, this.f9103h, this.f9104i);
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    public Executor c0() {
        return this.f9105j;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext r10, Runnable r11) {
        CoroutineScheduler.o(this.f9105j, r11, null, false, 6, null);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatchYield(CoroutineContext r10, Runnable r11) {
        CoroutineScheduler.o(this.f9105j, r11, null, true, 2, null);
    }

    public final void e0(Runnable r10, h r11, boolean r12) {
        this.f9105j.l(r10, r11, r12);
    }
}
