package x8;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile e f13697f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Object f13698g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile SharedPreferences f13699h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Context f13700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile int f13701b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile long f13702c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile int f13703d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile int f13704e;

    static {
        f13698g = new Object();
    }

    public e(Context r8) {
        if (r8 == null) goto L13;
        this.f13700a = r8.getApplicationContext();
    L13:
    L10:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (f13699h != null) goto L8;
        f13699h = this.f13700a.getSharedPreferences("image_opt_table", 0);     // Catch: Throwable -> L10
    L8:
        SharedPreferences r10 = f13699h;     // Catch: Throwable -> L10
        this.f13701b = r10.getInt("image_opt_switch", 0);     // Catch: Throwable -> L10
        this.f13702c = r10.getLong("image_opt_black_interval", 0);     // Catch: Throwable -> L10
        this.f13703d = r10.getInt("image_opt_failed_times", 0);     // Catch: Throwable -> L10
        this.f13704e = r10.getInt("image_opt_limit_count", 0);     // Catch: Throwable -> L10
    }
}
