package g4;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile a f8959b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SharedPreferences f8960a;

    private a(Context r10) {
        this.f8960a = r10.getSharedPreferences("__ctx_info.sp", 0);
    }

    public static a b(Context r10) {
        if (f8959b != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f8959b != null) goto L9;
        f8959b = new a(r10);     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f8959b;
    }

    public String a() {
        SharedPreferences r10 = this.f8960a;
        if (r10 != null) goto L6;
        return "";
    L6:
        return r10.getString("key_ctx_info", "");
    }

    public synchronized void c(@Nullable String r10) {
        monitor-enter(this);
        this.f8960a.edit().putString("key_ctx_info", r10).apply();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void d(long r10) {
        monitor-enter(this);
        this.f8960a.edit().putLong("key_settings_time", r10).apply();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
