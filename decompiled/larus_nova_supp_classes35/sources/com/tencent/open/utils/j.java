package com.tencent.open.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.open.log.SLog;
import java.lang.ref.WeakReference;
import java.net.URL;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class j {
    private static j a;
    private volatile WeakReference<SharedPreferences> b;

    public static synchronized j a() {
        monitor-enter(j.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (a != null) goto L7;
        a = new j();     // Catch: Throwable -> L10
    L7:
        j r1 = a;     // Catch: Throwable -> L10
        monitor-exit(j.class);
        return r1;
    }

    public j() {
        this.b = null;
    }

    public String a(Context r7, String r8) {
        if (this.b != null) goto L5;
    L6:
        this.b = new WeakReference(r7.getSharedPreferences("ServerPrefs", 0));
    L23:
        String r9 = new URL(r8).getHost();     // Catch: Exception -> L20
        if (r9 != null) goto L11;
        SLog.e("openSDK_LOG.ServerSetting", "Get host error. url=" + r8);     // Catch: Exception -> L20
        return r8;
    L11:
        String r3 = this.b.get().getString(r9, null);     // Catch: Exception -> L20
        if (r3 != null) goto L14;
    L18:
        SLog.v("openSDK_LOG.ServerSetting", "host=" + r9 + ", envHost=" + r3);     // Catch: Exception -> L20
        return r8;
    L14:
        if (r9.equals(r3) == true) goto L18;
        String r10 = r8.replace(r9, r3);     // Catch: Exception -> L20
        SLog.v("openSDK_LOG.ServerSetting", "return environment url : " + r10);     // Catch: Exception -> L20
        return r10;
    L20:
        e = move-exception;
        SLog.e("openSDK_LOG.ServerSetting", "getEnvUrl url=" + r8 + "error.: " + e.getMessage());
        return r8;
    L5:
        if (this.b.get() != null) goto L23;
        goto L6
    }
}
