package kotlinx.coroutines;

import java.util.concurrent.ScheduledFuture;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f18921b;

    public /* synthetic */ h(Object r5, int r10) {
        this.f18920a = r10;
        this.f18921b = r5;
    }

    @Override // kotlinx.coroutines.i
    public final void b(Throwable r5) {
        switch(this.f18920a) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        ((t0) this.f18921b).dispose();
        return;
    L6:
        ((Function1) this.f18921b).invoke(r5);
        return;
    L8:
        ((ScheduledFuture) this.f18921b).cancel(false);
    }

    public final String toString() {
        switch(this.f18920a) {
            case 0: goto L9;
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return "DisposeOnCancel[" + ((t0) this.f18921b) + ']';
    L7:
        return "CancelHandler.UserSupplied[" + ((Function1) this.f18921b).getClass().getSimpleName() + '@' + j0.f(this) + ']';
    L9:
        return "CancelFutureOnCancel[" + ((ScheduledFuture) this.f18921b) + ']';
    }
}
