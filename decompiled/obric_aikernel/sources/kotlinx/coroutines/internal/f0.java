package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.internal.f0;
import kotlinx.coroutines.j2;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nConcurrentLinkedList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/Segment\n+ 2 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListKt\n*L\n1#1,269:1\n252#2,4:270\n*S KotlinDebug\n*F\n+ 1 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/Segment\n*L\n225#1:270,4\n*E\n"})
public abstract class f0<S extends f0<S>> extends f<S> implements j2 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f10549i = null;

    @Volatile
    private volatile int cleanedAndPointers;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @JvmField
    public final long f10550h;

    static {
        f10549i = AtomicIntegerFieldUpdater.newUpdater(f0.class, "cleanedAndPointers");
    }

    public f0(long r10, S r11, int r12) {
        super(r11);
        this.f10550h = r10;
        this.cleanedAndPointers = r12 << 16;
    }

    @Override // kotlinx.coroutines.internal.f
    public boolean h() {
        if (f10549i.get(this) == n()) goto L5;
    L7:
        return false;
    L5:
        if (i() == true) goto L7;
        return true;
    }

    public final boolean m() {
        if (f10549i.addAndGet(this, -65536) == n()) goto L5;
    L7:
        return false;
    L5:
        if (i() == true) goto L7;
        return true;
    }

    public abstract int n();

    public abstract void o(int r10, Throwable r11, CoroutineContext r12);

    public final void p() {
        if (f10549i.incrementAndGet(this) != n()) goto L6;
        k();
        return;
    }

    public final boolean q() {
        AtomicIntegerFieldUpdater r10 = f10549i;
    L3:
        int r11 = r10.get(this);
        if (r11 == n()) goto L6;
    L9:
        boolean r12 = true;
    L10:
        if (r12 == false) goto L19;
        if (r10.compareAndSet(this, r11, 65536 + r11) == false) goto L3;
        return true;
    L19:
        return false;
    L6:
        if (i() == true) goto L9;
        r12 = false;
        goto L10
    }
}
