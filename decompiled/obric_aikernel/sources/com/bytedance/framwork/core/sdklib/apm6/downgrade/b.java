package com.bytedance.framwork.core.sdklib.apm6.downgrade;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import com.bytedance.framwork.core.sdklib.apm6.j;
import com.bytedance.framwork.core.sdkmonitor.e;
import j3.c;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SharedPreferences f1919a;

    public b(Context r10) {
        if (this.f1919a != null) goto L13;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f1919a != null) goto L8;
        this.f1919a = r10.getSharedPreferences("monitor_downgrade" + e.a(r10), 0);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    }

    @Nullable
    public DowngradeInfo a() {
        String r10 = this.f1919a.getString("rule", null);
        if (r10 != null) goto L14;
    L13:
        return null;
    L14:
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L13
    L5:
        if (j.f() == false) goto L7;
        c.d("SDK-Downgrade", "DowngradeData-load-" + r10);     // Catch: JSONException -> L11
    L7:
        DowngradeInfo r11 = DowngradeInfo.a(new JSONObject(r10));     // Catch: JSONException -> L11
        if (System.currentTimeMillis() >= r11.f1912a) goto L13;
        return r11;
    }

    public void b(DowngradeInfo r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (this.f1919a == null) goto L13;
        JSONObject r11 = r10.b();
        if (r11 == null) goto L14;
        String r12 = r11.toString();
        if (j.f() == false) goto L10;
        c.d("SDK-Downgrade", "DowngradeData-save-" + r12);
    L10:
        this.f1919a.edit().putString("rule", r12).apply();
        return;
    L14:
        return;
    }
}
