package gc;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.JvmField;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.internal.j0;

/* JADX INFO: loaded from: classes3.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @JvmField
    public static final String f9110a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @JvmField
    public static final long f9111b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @JvmField
    public static final int f9112c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @JvmField
    public static final int f9113d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @JvmField
    public static final long f9114e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @JvmField
    public static f f9115f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @JvmField
    public static final h f9116g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @JvmField
    public static final h f9117h = null;

    static {
        f9110a = j0.e("kotlinx.coroutines.scheduler.default.name", "DefaultDispatcher");
        f9111b = j0.h("kotlinx.coroutines.scheduler.resolution.ns", 100000, 0, 0, 12, null);
        f9112c = j0.g("kotlinx.coroutines.scheduler.core.pool.size", RangesKt.coerceAtLeast(j0.a(), 2), 1, 0, 8, null);
        f9113d = j0.g("kotlinx.coroutines.scheduler.max.pool.size", 2097150, 0, 2097150, 4, null);
        f9114e = TimeUnit.SECONDS.toNanos(j0.h("kotlinx.coroutines.scheduler.keep.alive.sec", 60, 0, 0, 12, null));
        f9115f = d.f9100a;
        f9116g = new i(0);
        f9117h = new i(1);
    }
}
