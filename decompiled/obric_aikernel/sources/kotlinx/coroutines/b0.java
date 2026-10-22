package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.JvmField;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
public class b0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f10243b = null;

    @Volatile
    private volatile int _handled;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @JvmField
    public final Throwable f10244a;

    static {
        f10243b = AtomicIntegerFieldUpdater.newUpdater(b0.class, "_handled");
    }

    public b0(Throwable r10, boolean r11) {
        this.f10244a = r10;
        this._handled = r11 ? 1 : 0;
    }

    public /* synthetic */ b0(Throwable r10, boolean r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = false;
    L5:
        this(r10, r11);
    }

    public final boolean a() {
        if (f10243b.get(this) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean b() {
        return f10243b.compareAndSet(this, 0, 1);
    }

    public String toString() {
        return o0.a(this) + '[' + this.f10244a + ']';
    }
}
