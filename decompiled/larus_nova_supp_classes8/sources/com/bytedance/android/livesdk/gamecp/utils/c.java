package com.bytedance.android.livesdk.gamecp.utils;

import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.LiveSettingKeys;
import com.bytedance.android.livesdk.config.e6;
import com.bytedance.android.livesdk.gecko.n;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c implements Runnable {
    public final /* synthetic */ Context a;

    public c(Context r1) {
        this.a = r1;
    }

    public final void a() {
        String r1 = n.b.b();     // Catch: Throwable -> L8
        List<String> r2 = ((e6) LiveSettingKeys.LIVE_GAME_PROMOTE_GECKO_ACTIVATE_CONFIG.getValue()).a();     // Catch: Throwable -> L8
        uy5.c r3 = new uy5.c(this.a, r1);     // Catch: Throwable -> L8
        d.a(r3, r2);     // Catch: Throwable -> L6
    L15:
        r3.b();
        return;
    L6:
        th = th;
    L23:
        String r4 = th.getMessage();     // Catch: Throwable -> L17
        if (r4 != null) goto L13;
        r4 = "";
    L13:
        ALogger.e("GPGeckoHelper", "fail to activate GameCP gecko Resource, error msg: ".concat(r4));     // Catch: Throwable -> L17
        if (r3 != null) goto L15;
        return;
    L17:
        th = move-exception;
        if (r3 == null) goto L20;
        r3.b();
    L20:
        throw th;
    L8:
        th = th;
        r3 = null;
        goto L23
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
