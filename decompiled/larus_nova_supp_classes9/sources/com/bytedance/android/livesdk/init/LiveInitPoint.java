package com.bytedance.android.livesdk.init;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/init/LiveInitPoint;", BuildConfig.FLAVOR, "PRE_INIT", "COMPLETE_INIT", "COMPLETE_AFTER", "ENTER_ROOM", "LAZY", "live-spi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveInitPoint extends Enum<LiveInitPoint> {
    public static final LiveInitPoint COMPLETE_AFTER = null;
    public static final LiveInitPoint COMPLETE_INIT = null;
    public static final LiveInitPoint ENTER_ROOM = null;
    public static final LiveInitPoint LAZY = null;
    public static final LiveInitPoint PRE_INIT = null;
    public static final /* synthetic */ LiveInitPoint[] a = null;

    static {
        LiveInitPoint r1 = new LiveInitPoint("PRE_INIT", 0);
        PRE_INIT = r1;
        LiveInitPoint r2 = new LiveInitPoint("COMPLETE_INIT", 1);
        COMPLETE_INIT = r2;
        LiveInitPoint r3 = new LiveInitPoint("COMPLETE_AFTER", 2);
        COMPLETE_AFTER = r3;
        LiveInitPoint r4 = new LiveInitPoint("ENTER_ROOM", 3);
        ENTER_ROOM = r4;
        LiveInitPoint r5 = new LiveInitPoint("LAZY", 4);
        LAZY = r5;
        a = new LiveInitPoint[]{r1, r2, r3, r4, r5};
    }

    public static LiveInitPoint valueOf(String r1) {
        return (LiveInitPoint) r27.a.a(LiveInitPoint.class, r1);
    }

    public static LiveInitPoint[] values() {
        return (LiveInitPoint[]) a.clone();
    }

    public LiveInitPoint(String r1, int r2) {
        super(r1, r2);
    }
}
