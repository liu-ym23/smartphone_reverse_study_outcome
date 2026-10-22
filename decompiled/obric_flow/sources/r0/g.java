package r0;

import androidx.core.util.Pools;

/* JADX INFO: loaded from: classes.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final sj.e f21638a = null;

    static {
        f21638a = new sj.e();
    }

    public static d a(int r5, c r10) {
        return new d(new Pools.SynchronizedPool(r5), r10, f21638a);
    }
}
