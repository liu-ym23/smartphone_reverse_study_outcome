package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nAtomic.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Atomic.kt\nkotlinx/coroutines/internal/AtomicOp\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,79:1\n1#2:80\n*E\n"})
public abstract class b<T> extends b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f10540a = null;

    @Volatile
    private volatile Object _consensus;

    static {
        f10540a = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_consensus");
    }

    public b() {
        this._consensus = a.f10537a;
    }

    private final Object c(Object r10) {
        if (kotlinx.coroutines.n0.a() == true) goto L5;
    L12:
        AtomicReferenceFieldUpdater r11 = f10540a;
        Object r12 = r11.get(this);
        Object r13 = a.f10537a;
        if (r12 == r13) goto L16;
        return r12;
    L16:
        if (r11.compareAndSet(this, r13, r10) == false) goto L19;
        return r10;
    L19:
        return r11.get(this);
    L5:
        if (r10 == a.f10537a) goto L7;
        boolean r14 = true;
    L8:
        if (r14 == true) goto L12;
        throw new AssertionError();
    L7:
        r14 = false;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.internal.b0
    public final Object a(Object r10) {
        Object r11 = f10540a.get(this);
        if (r11 != a.f10537a) goto L5;
        r11 = c(d(r10));
    L5:
        b(r10, r11);
        return r11;
    }

    public abstract void b(T r10, Object r11);

    public abstract Object d(T r10);
}
