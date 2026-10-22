package c3;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile boolean f3319f = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f3320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f3321b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<String, r2.a> f3322c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f3323d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f3324e;

    public d() {
        this.f3322c = new ConcurrentHashMap(4);
        this.f3323d = "start_trace";
        this.f3324e = "launch_stats";
    }

    public final boolean a() {
        return "start_trace".equals(this.f3323d);
    }
}
