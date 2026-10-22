package com.bytedance.android.live.platformplayer.init;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.w51;
import com.bytedance.android.livesdkapi.host.ILivePlayerALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements ILivePlayerALogger {
    public a() {
    }

    public final void d(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        int r0 = w51.a;
        pm0.b r1 = om0.c.f();
        if (r1 == null) goto L5;
        r1.i(r2, r3);
        return;
    L5:
        ALogger.i(r2, r3);
    }

    public final void e(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        int r0 = w51.a;
        pm0.b r1 = om0.c.f();
        if (r1 == null) goto L5;
        r1.e(r2, r3);
        return;
    L5:
        ALogger.e(r2, r3);
    }

    public final void i(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        int r0 = w51.a;
        pm0.b r1 = om0.c.f();
        if (r1 == null) goto L5;
        r1.i(r2, r3);
        return;
    L5:
        ALogger.i(r2, r3);
    }

    public final void w(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        int r0 = w51.a;
        pm0.b r1 = om0.c.f();
        if (r1 == null) goto L5;
        r1.w(r2, r3);
        return;
    L5:
        ALogger.w(r2, r3);
    }
}
