package com.bytedance.apm.internal;

import android.content.SharedPreferences;
import com.bytedance.apm.core.MonitorSharedPreferences;
import com.bytedance.apm.d;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SharedPreferences f993a;

    static /* synthetic */ class a {
    }

    /* JADX INFO: renamed from: com.bytedance.apm.internal.b$b, reason: collision with other inner class name */
    private static class C0036b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f994a = null;

        static {
            f994a = new b(null);
        }

        static /* synthetic */ b a() {
            return f994a;
        }
    }

    private b() {
        this.f993a = MonitorSharedPreferences.getSharedPreferences(d.g(), "monitor_config");
    }

    /* synthetic */ b(a r10) {
        this();
    }

    public static b a() {
        return C0036b.a();
    }

    public int b(String r10) {
        return this.f993a.getInt(r10, -1);
    }

    public long c(String r10) {
        return this.f993a.getLong(r10, 0);
    }

    public String d(String r10) {
        return this.f993a.getString(r10, null);
    }

    public void e(String r10, int r11) {
        this.f993a.edit().putInt(r10, r11).apply();
    }

    public void f(String r10, long r11) {
        this.f993a.edit().putLong(r10, r11).apply();
    }

    public void g(String r10, String r11) {
        this.f993a.edit().putString(r10, r11).apply();
    }
}
