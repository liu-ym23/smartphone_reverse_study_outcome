package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.text.Typography;

/* JADX WARN: Unexpected interfaces in signature: [kotlinx.coroutines.l0] */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a<T> extends c2 implements v1, Continuation<T> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final CoroutineContext f10227h;

    public a(CoroutineContext r10, boolean r11, boolean r12) {
        super(r12);
        if (r11 == false) goto L5;
        z0((v1) r10.get(v1.f10723e));
    L5:
        this.f10227h = r10.plus(this);
    }

    @Override // kotlinx.coroutines.c2
    public String H0() {
        String r10 = CoroutineContextKt.b(this.f10227h);
        if (r10 != null) goto L7;
        return super.H0();
    L7:
        return Typography.quote + r10 + "\":" + super.H0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.c2
    protected final void O0(Object r10) {
        if ((r10 instanceof b0) == false) goto L5;
        b0 r11 = (b0) r10;
        g1(r11.f10244a, r11.a());
        return;
    L5:
        h1(r10);
    }

    protected void f1(Object r10) {
        Z(r10);
    }

    protected void g1(Throwable r10, boolean r11) {
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        return this.f10227h;
    }

    public CoroutineContext getCoroutineContext() {
        return this.f10227h;
    }

    protected void h1(T r10) {
    }

    @Override // kotlinx.coroutines.c2
    protected String i0() {
        return o0.a(this) + " was cancelled";
    }

    public final <R> void i1(CoroutineStart r10, R r11, Function2<? super R, ? super Continuation<? super T>, ? extends Object> r12) {
        r10.invoke(r12, r11, this);
    }

    @Override // kotlinx.coroutines.c2, kotlinx.coroutines.v1
    public boolean isActive() {
        return super.isActive();
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object r10) {
        Object r11 = F0(e0.d(r10, null, 1, null));
        if (r11 != d2.f10331b) goto L5;
        return;
    L5:
        f1(r11);
    }

    @Override // kotlinx.coroutines.c2
    public final void y0(Throwable r10) {
        i0.a(this.f10227h, r10);
    }
}
