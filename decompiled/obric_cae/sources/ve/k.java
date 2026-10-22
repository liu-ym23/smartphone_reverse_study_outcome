package ve;

import java.util.concurrent.TimeUnit;
import ue.v;

/* JADX INFO: loaded from: classes2.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f12882a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f12883b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f12884c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f12885d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f12886e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final e f12887f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final i f12888g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final i f12889h = null;

    static {
        int r8 = v.f12626a;
        String r10 = System.getProperty("kotlinx.coroutines.scheduler.default.name");     // Catch: SecurityException -> L5
    L6:
        if (r10 != null) goto L8;
        r10 = "DefaultDispatcher";
    L8:
        f12882a = r10;
        f12883b = l6.a.R0(100000, "kotlinx.coroutines.scheduler.resolution.ns", 1, Long.MAX_VALUE);
        int r11 = v.f12626a;
        if (r11 >= 2) goto L11;
        r11 = 2;
    L11:
        f12884c = l6.a.S0("kotlinx.coroutines.scheduler.core.pool.size", r11, 1, 0, 8);
        f12885d = l6.a.S0("kotlinx.coroutines.scheduler.max.pool.size", 2097150, 0, 2097150, 4);
        f12886e = TimeUnit.SECONDS.toNanos(l6.a.R0(60, "kotlinx.coroutines.scheduler.keep.alive.sec", 1, Long.MAX_VALUE));
        f12887f = e.f12876c;
        f12888g = new i(0);
        f12889h = new i(1);
        return;
    L5:
        r10 = null;
        goto L6
    }
}
