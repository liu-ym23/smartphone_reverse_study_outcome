package com.larus.bmhome.utils;

import com.larus.utils.logger.FLogger;
import java.lang.ref.SoftReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class i2$a implements f2.b {
    public final /* synthetic */ String a;
    public final /* synthetic */ Runnable b;
    public final /* synthetic */ long c;

    public final void b() {
    }

    public final void onFirstFrame() {
    }

    public final void a(String r4) {
        FLogger.a.i("LaunchFirstFeedShowUtils", "launchAfterFirstFeedShow[end]: " + this.a + ", " + r4);
        i2.c.remove(this.a);
        f2.d.remove(this);
        SoftReference r5 = com.larus.utils.y.a;
        Runnable r6 = this.b;
        long r0 = this.c;
        Intrinsics.checkNotNullParameter(r6, "action");
        com.larus.utils.y.d(r6, r0);
    }

    public i2$a(String r1, Runnable r2, long r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
