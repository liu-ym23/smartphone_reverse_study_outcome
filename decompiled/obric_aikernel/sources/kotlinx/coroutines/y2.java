package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmField;

/* JADX INFO: loaded from: classes3.dex */
final class y2<U, T extends U> extends kotlinx.coroutines.internal.e0<T> implements Runnable {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @JvmField
    public final long f10735j;

    public y2(long r10, Continuation<? super U> r11) {
        super(r11.getContext(), r11);
        this.f10735j = r10;
    }

    @Override // kotlinx.coroutines.a, kotlinx.coroutines.c2
    public String H0() {
        return super.H0() + "(timeMillis=" + this.f10735j + ')';
    }

    @Override // java.lang.Runnable
    public void run() {
        d0(TimeoutKt.a(this.f10735j, DelayKt.c(getContext()), this));
    }
}
