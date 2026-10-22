package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f18927a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f18928b = null;
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ Object _prev$volatile;

    static {
        f18927a = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_next$volatile");
        f18928b = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_prev$volatile");
    }

    public b(s r5) {
        this._prev$volatile = r5;
    }

    public final void a() {
        f18928b.set(this, null);
    }

    public final b c() {
        Object r5 = f18927a.get(this);
        if (r5 != a.f18926a) goto L7;
        return null;
    L7:
        return (b) r5;
    }

    public abstract boolean d();

    public final void e() {
        if (c() != null) goto L5;
        return;
    L5:
        AtomicReferenceFieldUpdater r5 = f18928b;
        b r10 = (b) r5.get(this);
    L6:
        if (r10 == null) goto L10;
        if (r10.d() == false) goto L10;
        r10 = (b) r5.get(r10);
    L10:
        b r11 = c();
        Intrinsics.checkNotNull(r11);
    L12:
        if (r11.d() == false) goto L17;
        b r12 = r11.c();
        if (r12 == null) goto L17;
        r11 = r12;
    L17:
        Object r13 = r5.get(r11);
        if (((b) r13) != null) goto L20;
        b r14 = null;
    L22:
        if (r5.compareAndSet(r11, r13, r14) == true) goto L23;
        if (r5.get(r11) == r13) goto L22;
    L23:
        if (r10 == null) goto L26;
        f18927a.set(r10, r11);
    L26:
        if (r11.d() == false) goto L29;
        if (r11.c() != null) goto L5;
    L29:
        if (r10 == null) goto L32;
        if (r10.d() == true) goto L5;
        return;
    L32:
        return;
    L20:
        r14 = r10;
        goto L22
    }
}
