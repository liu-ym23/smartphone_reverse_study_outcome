package kotlinx.coroutines;

import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes3.dex */
public final class d2 extends kotlinx.coroutines.internal.r implements Runnable {
    public final long e;

    public d2(long r5, ContinuationImpl r10) {
        super(r10, r10.getContext());
        this.e = r5;
    }

    @Override // kotlinx.coroutines.r1
    public final String P() {
        StringBuilder r5 = new StringBuilder();
        r5.append(super.P());
        r5.append("(timeMillis=");
        return androidx.room.jarjarred.org.antlr.runtime.a.t(r5, this.e, ')');
    }

    @Override // java.lang.Runnable
    public final void run() {
        DelayKt.getDelay(this.f18767c);
        w(new TimeoutCancellationException("Timed out waiting for " + this.e + " ms", this));
    }
}
