package i2;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long[] f8088a;

    public a() {
        this.f8088a = new long[4];
    }

    public final void a(long r8) {
        long[] r10 = this.f8088a;
        if (r10[0] != 0) goto L5;
        r10[0] = SystemClock.uptimeMillis();
    L5:
        r10[1] = r10[1] + 1;
        if (r8 >= r10[2]) goto L9;
        r10[2] = r8;
    L9:
        if (r8 <= r10[3]) goto L12;
        r10[3] = r8;
        return;
    }
}
