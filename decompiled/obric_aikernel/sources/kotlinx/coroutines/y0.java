package kotlinx.coroutines;

import java.util.concurrent.Executor;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.JvmField;

/* JADX INFO: loaded from: classes3.dex */
final class y0 implements Executor {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @JvmField
    public final CoroutineDispatcher f10734c;

    public y0(CoroutineDispatcher r10) {
        this.f10734c = r10;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r10) {
        CoroutineDispatcher r11 = this.f10734c;
        EmptyCoroutineContext r12 = EmptyCoroutineContext.INSTANCE;
        if (r11.isDispatchNeeded(r12) == false) goto L5;
        this.f10734c.dispatch(r12, r10);
        return;
    L5:
        r10.run();
    }

    public String toString() {
        return this.f10734c.toString();
    }
}
