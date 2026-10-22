package nc0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c implements gy.c {
    public final com.bytedance.android.live.revenuelink.rtc.f a;

    @Override // gy.c
    public final gy.f getRtcManager() {
        com.bytedance.android.live.revenuelink.rtc.i r0 = this.a.getRtcManager();
        if (r0 != null) goto L7;
        return null;
    L7:
        return new e(r0);
    }

    public c(com.bytedance.android.live.revenuelink.rtc.f r2) {
        Intrinsics.checkNotNullParameter(r2, "real");
        this.a = r2;
    }
}
