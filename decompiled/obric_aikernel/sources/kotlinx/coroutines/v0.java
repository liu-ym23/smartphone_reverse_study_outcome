package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.PublishedApi;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.Volatile;

/* JADX INFO: loaded from: classes3.dex */
@PublishedApi
public final class v0<T> extends kotlinx.coroutines.internal.e0<T> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f10722j = null;

    @Volatile
    @JvmField
    private volatile int _decision;

    static {
        f10722j = AtomicIntegerFieldUpdater.newUpdater(v0.class, "_decision");
    }

    public v0(CoroutineContext r10, Continuation<? super T> r11) {
        super(r10, r11);
    }

    private final boolean k1() {
        AtomicIntegerFieldUpdater r10 = f10722j;
    L3:
        int r11 = r10.get(this);
        if (r11 != 0) goto L5;
        if (f10722j.compareAndSet(this, 0, 2) == false) goto L3;
        return true;
    L5:
        if (r11 != 1) goto L8;
        return false;
    L8:
        throw new IllegalStateException("Already resumed".toString());
    }

    private final boolean l1() {
        AtomicIntegerFieldUpdater r10 = f10722j;
    L3:
        int r11 = r10.get(this);
        if (r11 != 0) goto L6;
        if (f10722j.compareAndSet(this, 0, 1) == false) goto L3;
        return true;
    L6:
        if (r11 != 2) goto L9;
        return false;
    L9:
        throw new IllegalStateException("Already suspended".toString());
    }

    @Override // kotlinx.coroutines.internal.e0, kotlinx.coroutines.c2
    protected void Z(Object r10) {
        f1(r10);
    }

    @Override // kotlinx.coroutines.internal.e0, kotlinx.coroutines.a
    protected void f1(Object r10) {
        if (k1() == false) goto L5;
        return;
    L5:
        kotlinx.coroutines.internal.m.c(IntrinsicsKt.intercepted(this.f10546i), e0.a(r10, this.f10546i), null, 2, null);
    }

    public final Object j1() {
        if (l1() == true) goto L5;
        Object r10 = d2.h(w0());
        if ((r10 instanceof b0) == true) goto L10;
        return r10;
    L10:
        throw ((b0) r10).f10244a;
    L5:
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }
}
