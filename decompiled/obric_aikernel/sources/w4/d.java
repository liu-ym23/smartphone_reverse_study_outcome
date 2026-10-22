package w4;

import android.content.Context;
import android.content.SharedPreferences;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile d f13366f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Object f13367g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile SharedPreferences f13368h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile Context f13369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile int f13370b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile long f13371c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile int f13372d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile int f13373e;

    static {
        f13367g = new Object();
    }

    private d(Context r10) {
        if (r10 == null) goto L5;
        this.f13369a = r10.getApplicationContext();
    L5:
        d();
    }

    public static d a(Context r10) {
        if (f13366f != null) goto L15;
        Object r11 = f13367g;
        monitor-enter(r11);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f13366f != null) goto L9;
        f13366f = new d(r10);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r11);     // Catch: Throwable -> L11
    L15:
        return f13366f;
    }

    public static d b() {
        return f13366f;
    }

    private SharedPreferences c() {
        if (f13368h != null) goto L6;
        f13368h = this.f13369a.getSharedPreferences("image_opt_table", 0);
    L6:
        return f13368h;
    }

    private void d() {
        SharedPreferences r10 = c();     // Catch: Throwable -> L4
        this.f13370b = r10.getInt("image_opt_switch", 0);     // Catch: Throwable -> L4
        this.f13371c = r10.getLong("image_opt_black_interval", 0);     // Catch: Throwable -> L4
        this.f13372d = r10.getInt("image_opt_failed_times", 0);     // Catch: Throwable -> L4
        this.f13373e = r10.getInt("image_opt_limit_count", 0);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void e(JSONObject r12) {
        if (r12 == null) goto L26;
    L21:
        th = move-exception;
        th.printStackTrace();
        return;
    L5:
        if (r12.length() <= 0) goto L27;
        int r10 = r12.optInt("image_opt_switch", 0);     // Catch: Throwable -> L21
        long r11 = r12.optLong("image_opt_black_interval", 0);     // Catch: Throwable -> L21
        int r13 = r12.optInt("image_opt_failed_times", 0);     // Catch: Throwable -> L21
        int r14 = r12.optInt("image_opt_limit_count", 0);     // Catch: Throwable -> L21
        SharedPreferences.Editor r15 = c().edit();     // Catch: Throwable -> L21
        if (r10 == this.f13370b) goto L11;
        r15.putInt("image_opt_switch", r10);     // Catch: Throwable -> L21
    L11:
        if (r11 == this.f13371c) goto L14;
        r15.putLong("image_opt_black_interval", r11);     // Catch: Throwable -> L21
    L14:
        if (r13 == this.f13372d) goto L17;
        r15.putInt("image_opt_failed_times", r13);     // Catch: Throwable -> L21
    L17:
        if (r14 == this.f13373e) goto L19;
        r15.putInt("image_opt_limit_count", r14);     // Catch: Throwable -> L21
    L19:
        r15.apply();     // Catch: Throwable -> L21
        this.f13370b = r10;     // Catch: Throwable -> L21
        this.f13371c = r11;     // Catch: Throwable -> L21
        this.f13372d = r13;     // Catch: Throwable -> L21
        this.f13373e = r14;     // Catch: Throwable -> L21
        return;
    L27:
        return;
    }
}
