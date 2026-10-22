package kotlinx.coroutines.internal;

import androidx.core.internal.view.SupportMenu;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.w1;

/* JADX INFO: loaded from: classes3.dex */
public abstract class s extends b implements w1 {
    public static final /* synthetic */ AtomicIntegerFieldUpdater d = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f18950c;
    private volatile /* synthetic */ int cleanedAndPointers$volatile;

    static {
        d = AtomicIntegerFieldUpdater.newUpdater(s.class, "cleanedAndPointers$volatile");
    }

    public s(long r5, s r10, int r11) {
        super(r10);
        this.f18950c = r5;
        this.cleanedAndPointers$volatile = r11 << 16;
    }

    @Override // kotlinx.coroutines.internal.b
    public final boolean d() {
        if (d.get(this) == g()) goto L5;
    L8:
        return false;
    L5:
        if (c() == null) goto L8;
        return true;
    }

    public final boolean f() {
        if (d.addAndGet(this, SupportMenu.CATEGORY_MASK) == g()) goto L5;
    L8:
        return false;
    L5:
        if (c() == null) goto L8;
        return true;
    }

    public abstract int g();

    public abstract void h(int r5, CoroutineContext r10);

    public final void i() {
        if (d.incrementAndGet(this) != g()) goto L6;
        e();
        return;
    }

    public final boolean j() {
    L2:
        AtomicIntegerFieldUpdater r5 = d;
        int r10 = r5.get(this);
        if (r10 != g()) goto L9;
        if (c() == null) goto L9;
        return false;
    L9:
        if (r5.compareAndSet(this, r10, 65536 + r10) == false) goto L2;
        return true;
    }
}
