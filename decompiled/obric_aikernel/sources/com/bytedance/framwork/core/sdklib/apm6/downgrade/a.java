package com.bytedance.framwork.core.sdklib.apm6.downgrade;

import android.content.Context;
import androidx.annotation.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile DowngradeInfo f1916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b f1917b;

    /* JADX INFO: renamed from: com.bytedance.framwork.core.sdklib.apm6.downgrade.a$a, reason: collision with other inner class name */
    private static class C0059a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f1918a = null;

        static {
            f1918a = new a();
        }

        static /* synthetic */ a a() {
            return f1918a;
        }
    }

    public a() {
    }

    public static a a() {
        return C0059a.a();
    }

    public void b(Context r10) {
        b r11 = new b(r10);
        this.f1917b = r11;
        c(r11.a(), false);
    }

    public void c(@Nullable DowngradeInfo r10, boolean r11) {
        if (r10 == null) goto L13;
        monitor-enter(this);
        this.f1916a = r10;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        if (r11 == false) goto L16;
        b r12 = this.f1917b;
        if (r12 == null) goto L17;
        r12.b(r10);
        return;
    L17:
        return;
    L16:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public boolean d(JSONObject r10, int r11) {
        boolean r12 = true;
        if (this.f1916a != null) goto L5;
    L52:
        return true;
    L5:
        if (System.currentTimeMillis() > this.f1916a.f1912a) goto L52;
        String r13 = String.valueOf(r11);
        String r14 = r10.optString("log_type");
        DowngradeInfo.LogType r15 = DowngradeInfo.LogType.SERVICE_MONITOR;
        if (r15.logType.equals(r14) == false) goto L31;
        String r16 = r10.optString("service");
        monitor-enter(this);
        DowngradeInfo.a r17 = this.f1916a.f1913b.get(r15);     // Catch: Throwable -> L28
        if (r17 == null) goto L26;
        JSONObject r18 = r17.f1915b.get(r13);     // Catch: Throwable -> L28
        if (r18 != null) goto L16;
    L23:
        boolean r19 = r17.f1914a;     // Catch: Throwable -> L28
        monitor-exit(this);     // Catch: Throwable -> L28
        return r19;
    L16:
        if (r18.optInt(r16, -1) == (-1)) goto L23;
        if (r18.optInt(r16, -1) == 1) goto L21;
        r12 = false;
    L21:
        monitor-exit(this);     // Catch: Throwable -> L28
        return r12;
    L26:
        monitor-exit(this);     // Catch: Throwable -> L28
    L48:
        return true;
    L28:
        th = move-exception;
        throw th;
    L31:
        monitor-enter(this);
        DowngradeInfo.a r20 = this.f1916a.f1913b.get(DowngradeInfo.LogType.OTHER_LOG_TYPE);     // Catch: Throwable -> L49
        if (r20 == null) goto L47;
        JSONObject r21 = r20.f1915b.get(r13);     // Catch: Throwable -> L49
        if (r21 != null) goto L37;
    L44:
        boolean r22 = r20.f1914a;     // Catch: Throwable -> L49
        monitor-exit(this);     // Catch: Throwable -> L49
        return r22;
    L37:
        if (r21.optInt(r14, -1) == (-1)) goto L44;
        if (r21.optInt(r14, -1) == 1) goto L42;
        r12 = false;
    L42:
        monitor-exit(this);     // Catch: Throwable -> L49
        return r12;
    L47:
        monitor-exit(this);     // Catch: Throwable -> L49
    L49:
        th = move-exception;
        throw th;
    }
}
