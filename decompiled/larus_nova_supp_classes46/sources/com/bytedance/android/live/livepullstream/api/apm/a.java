package com.bytedance.android.live.livepullstream.api.apm;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static APMEvent a(APMEvent.Level r1, String r2) {
        APMEvent r0 = new APMEvent();
        r0.d(r2);
        r0.e(r1);
        r0.g(System.currentTimeMillis());
        return r0;
    }

    public static APMEvent b(APMEvent.Level r1, String r2, long r3) {
        APMEvent r0 = new APMEvent();
        r0.d(r2);
        r0.e(r1);
        r0.g(r3);
        return r0;
    }

    public static APMEvent c(APMEvent.Level r1, String r2, String r3) {
        APMEvent r0 = new APMEvent();
        r0.d(r2);
        r0.e(r1);
        r0.f(r3);
        r0.g(System.currentTimeMillis());
        return r0;
    }
}
