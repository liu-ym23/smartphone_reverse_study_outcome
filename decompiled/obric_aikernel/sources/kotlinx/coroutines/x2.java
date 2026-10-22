package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Unit;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
final class x2 implements Function1<Throwable, Unit> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f10730i = null;

    @Volatile
    private volatile int _state;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final v1 f10731c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Thread f10732g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private b1 f10733h;

    static {
        f10730i = AtomicIntegerFieldUpdater.newUpdater(x2.class, "_state");
    }

    public x2(v1 r10) {
        this.f10731c = r10;
        this.f10732g = Thread.currentThread();
    }

    private final Void b(int r10) {
        throw new IllegalStateException(("Illegal state " + r10).toString());
    }

    public final void a() {
        AtomicIntegerFieldUpdater r10 = f10730i;
    L3:
        int r11 = r10.get(this);
        if (r11 != 0) goto L6;
        if (f10730i.compareAndSet(this, r11, 1) == false) goto L3;
        b1 r12 = this.f10733h;
        if (r12 == null) goto L26;
        r12.dispose();
        return;
    L26:
        return;
    L6:
        if (r11 == 2) goto L3;
        if (r11 != 3) goto L11;
        Thread.interrupted();
        return;
    L11:
        b(r11);
        throw new KotlinNothingValueException();
    }

    public void c(Throwable r10) {
        AtomicIntegerFieldUpdater r11 = f10730i;
    L3:
        int r12 = r11.get(this);
        if (r12 != 0) goto L6;
        AtomicIntegerFieldUpdater r13 = f10730i;
        if (r13.compareAndSet(this, r12, 2) == false) goto L3;
        this.f10732g.interrupt();
        r13.set(this, 3);
        return;
    L6:
        if (r12 == 1) goto L12;
        if (r12 == 2) goto L20;
        if (r12 == 3) goto L21;
        b(r12);
        throw new KotlinNothingValueException();
    L21:
        return;
    L20:
        return;
    }

    public final void d() {
        this.f10733h = this.f10731c.o(true, true, this);
        AtomicIntegerFieldUpdater r10 = f10730i;
    L3:
        int r11 = r10.get(this);
        if (r11 != 0) goto L6;
        if (f10730i.compareAndSet(this, r11, 0) == false) goto L3;
        return;
    L6:
        if (r11 != 2) goto L8;
        return;
    L8:
        if (r11 == 3) goto L19;
        b(r11);
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable r10) {
        c(r10);
        return Unit.INSTANCE;
    }
}
