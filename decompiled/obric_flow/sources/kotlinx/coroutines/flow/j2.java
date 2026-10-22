package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes3.dex */
public final class j2 extends kotlinx.coroutines.flow.internal.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f18891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public kotlinx.coroutines.l f18892b;

    @Override // kotlinx.coroutines.flow.internal.c
    public final boolean a(kotlinx.coroutines.flow.internal.a r5) {
        i2 r10 = (i2) r5;
        if (this.f18891a < 0) goto L5;
        return false;
    L5:
        long r11 = r10.f18855i;
        if (r11 >= r10.f18856j) goto L8;
        r10.f18856j = r11;
    L8:
        this.f18891a = r11;
        return true;
    }

    @Override // kotlinx.coroutines.flow.internal.c
    public final Continuation[] b(kotlinx.coroutines.flow.internal.a r5) {
        long r10 = this.f18891a;
        this.f18891a = -1;
        this.f18892b = null;
        return ((i2) r5).u(r10);
    }
}
