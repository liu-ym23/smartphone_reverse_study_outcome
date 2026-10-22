package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
public final class j1 extends m1 {
    public static final /* synthetic */ AtomicIntegerFieldUpdater f = null;
    private volatile /* synthetic */ int _invoked$volatile;
    public final Function1 e;

    static {
        f = AtomicIntegerFieldUpdater.newUpdater(j1.class, "_invoked$volatile");
    }

    public j1(Function1 r5) {
        this.e = r5;
        this._invoked$volatile = 0;
    }

    @Override // kotlinx.coroutines.m1
    public final boolean i() {
        return true;
    }

    @Override // kotlinx.coroutines.m1
    public final void j(Throwable r5) {
        if (f.compareAndSet(this, 0, 1) == false) goto L6;
        this.e.invoke(r5);
        return;
    }
}
