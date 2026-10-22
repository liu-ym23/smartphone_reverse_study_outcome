package com.bytedance.android.live.broadcastgame;

import android.os.SystemClock;
import com.bytedance.android.live.broadcastgame.api.openplatform.OpenPlatformMonitorUtils;
import com.bytedance.android.livesdk.utils.o1;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class t<T> implements Consumer {
    public final /* synthetic */ AudienceMagicBoxBehavior a;
    public final /* synthetic */ long b;
    public final /* synthetic */ Function1 c;

    public t(AudienceMagicBoxBehavior r1, long r2, Function1 r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }

    public final void accept(Object r15) {
        Throwable r16 = (Throwable) r15;
        long r8 = SystemClock.elapsedRealtime() - this.b;
        OpenPlatformMonitorUtils r0 = OpenPlatformMonitorUtils.c;
        AudienceMagicBoxBehavior r1 = this.a;
        OpenPlatformMonitorUtils.i(r1.c(r1.c), this.a.d(), 1, false, r8, Integer.valueOf(com.bytedance.android.live.broadcastgame.api.openplatform.h.a(r16)), o1.a(r16), null, 128);
        this.c.invoke(r16);
    }
}
