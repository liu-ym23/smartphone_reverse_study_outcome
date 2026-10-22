package kotlinx.coroutines.internal;

import kotlin.KotlinNothingValueException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.b1;
import kotlinx.coroutines.g2;
import kotlinx.coroutines.t0;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nMainDispatchers.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MainDispatchers.kt\nkotlinx/coroutines/internal/MissingMainCoroutineDispatcher\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,134:1\n1#2:135\n*E\n"})
final class a0 extends g2 implements t0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Throwable f10538c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f10539g;

    public a0(Throwable r10, String r11) {
        this.f10538c = r10;
        this.f10539g = r11;
    }

    private final Void f0() {
        if (this.f10538c == null) goto L11;
        StringBuilder r10 = new StringBuilder();
        r10.append("Module with the Main dispatcher had failed to initialize");
        String r11 = this.f10539g;
        if (r11 == null) goto L8;
        String r12 = ". " + r11;
        if (r12 == null) goto L8;
    L9:
        r10.append(r12);
        throw new IllegalStateException(r10.toString(), this.f10538c);
    L8:
        r12 = "";
        goto L9
    L11:
        z.d();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.t0
    public b1 B(long r10, Runnable r11, CoroutineContext r12) {
        f0();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.g2
    public g2 c0() {
        return this;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public /* bridge */ /* synthetic */ void dispatch(CoroutineContext r10, Runnable r11) {
        e0(r10, r11);
    }

    public Void e0(CoroutineContext r10, Runnable r11) {
        f0();
        throw new KotlinNothingValueException();
    }

    public Void g0(long r10, kotlinx.coroutines.n<? super Unit> r11) {
        f0();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean isDispatchNeeded(CoroutineContext r10) {
        f0();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.t0
    public /* bridge */ /* synthetic */ void k(long r10, kotlinx.coroutines.n r11) {
        g0(r10, r11);
    }

    @Override // kotlinx.coroutines.g2, kotlinx.coroutines.CoroutineDispatcher
    public CoroutineDispatcher limitedParallelism(int r10) {
        f0();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.g2, kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        StringBuilder r10 = new StringBuilder();
        r10.append("Dispatchers.Main[missing");
        if (this.f10538c == null) goto L5;
        String r11 = ", cause=" + this.f10538c;
    L6:
        r10.append(r11);
        r10.append(']');
        return r10.toString();
    L5:
        r11 = "";
        goto L6
    }
}
