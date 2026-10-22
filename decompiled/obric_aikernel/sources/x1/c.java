package x1;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class c extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f13483c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f13484d;

    public c(Context r10) {
        this(r10, 4);
    }

    c(Context r10, int r11) {
        super(r10);
        if (r11 >= 0) goto L5;
        r11 = 4;
    L5:
        this.f13483c = r11;
    }

    @Override // x1.a
    public long c() {
        if (this.f13484d >= this.f13483c) goto L5;
        long r10 = super.c();
    L7:
        if (r10 == (-1)) goto L9;
        this.f13484d++;
    L9:
        return r10;
    L5:
        r10 = -1;
        goto L7
    }

    @Override // x1.a, x1.b
    public void reset() {
        super.reset();
        this.f13484d = 0;
    }

    public String toString() {
        return "RetryTimesPolicy{mMaxRetryTime=" + this.f13483c + ", mCurrRetryTime=" + this.f13484d + '}';
    }
}
