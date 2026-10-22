package kotlinx.coroutines;

import com.ttnet.org.chromium.base.TimeUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class j1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final kotlinx.coroutines.internal.i0 f10601a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final kotlinx.coroutines.internal.i0 f10602b = null;

    static {
        f10601a = new kotlinx.coroutines.internal.i0("REMOVED_TASK");
        f10602b = new kotlinx.coroutines.internal.i0("CLOSED_EMPTY");
    }

    public static final /* synthetic */ kotlinx.coroutines.internal.i0 a() {
        return f10602b;
    }

    public static final /* synthetic */ kotlinx.coroutines.internal.i0 b() {
        return f10601a;
    }

    public static final long c(long r10) {
        return r10 / TimeUtils.NANOSECONDS_PER_MILLISECOND;
    }

    public static final long d(long r10) {
        if (r10 > 0) goto L6;
        return 0;
    L6:
        if (r10 < 9223372036854L) goto L9;
        return Long.MAX_VALUE;
    L9:
        return TimeUtils.NANOSECONDS_PER_MILLISECOND * r10;
    }
}
