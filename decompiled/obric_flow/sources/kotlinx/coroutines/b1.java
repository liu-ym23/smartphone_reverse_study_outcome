package kotlinx.coroutines;

import kotlin.collections.ArrayDeque;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b1 extends z {
    public static final /* synthetic */ int d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f18770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f18771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ArrayDeque f18772c;

    public final void J(q0 r5) {
        ArrayDeque r10 = this.f18772c;
        if (r10 != null) goto L5;
        r10 = new ArrayDeque();
        this.f18772c = r10;
    L5:
        r10.addLast(r5);
    }

    public abstract Thread K();

    public final void L(boolean r5) {
        long r10 = this.f18770a;
        if (r5 == false) goto L5;
        long r11 = 4294967296L;
    L6:
        this.f18770a = r11 + r10;
        if (r5 == true) goto L10;
        this.f18771b = true;
        return;
    L10:
        return;
    L5:
        r11 = 1;
        goto L6
    }

    public final boolean M() {
        if (this.f18770a < 4294967296L) goto L5;
        return true;
    L5:
        return false;
    }

    public abstract long N();

    public final boolean O() {
        ArrayDeque r5 = this.f18772c;
        if (r5 != null) goto L5;
        return false;
    L5:
        q0 r10 = (q0) r5.removeFirstOrNull();
        if (r10 != null) goto L8;
        return false;
    L8:
        r10.run();
        return true;
    }

    public void P(long r5, y0 r10) {
        k0.f18973h.U(r5, r10);
    }

    public final void g(boolean r5) {
        long r10 = this.f18770a;
        if (r5 == false) goto L5;
        long r11 = 4294967296L;
    L6:
        long r12 = r10 - r11;
        this.f18770a = r12;
        if (r12 <= 0) goto L10;
        return;
    L10:
        if (this.f18771b == false) goto L13;
        shutdown();
        return;
    L13:
        return;
    L5:
        r11 = 1;
        goto L6
    }

    @Override // kotlinx.coroutines.z
    public final z limitedParallelism(int r5, String r10) {
        kotlinx.coroutines.internal.f.c(r5);
        if (r10 != null) goto L5;
        return this;
    L5:
        return new kotlinx.coroutines.internal.o(this, r10);
    }

    public abstract void shutdown();
}
