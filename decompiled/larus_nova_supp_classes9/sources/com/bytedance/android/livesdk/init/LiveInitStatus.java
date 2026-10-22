package com.bytedance.android.livesdk.init;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/init/LiveInitStatus;", BuildConfig.FLAVOR, "NOT_INIT", "INITING", "INITED", "live-spi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveInitStatus extends Enum<LiveInitStatus> {
    public static final LiveInitStatus INITED = null;
    public static final LiveInitStatus INITING = null;
    public static final LiveInitStatus NOT_INIT = null;
    public static final /* synthetic */ LiveInitStatus[] a = null;

    static {
        LiveInitStatus r1 = new LiveInitStatus("NOT_INIT", 0);
        NOT_INIT = r1;
        LiveInitStatus r2 = new LiveInitStatus("INITING", 1);
        INITING = r2;
        LiveInitStatus r3 = new LiveInitStatus("INITED", 2);
        INITED = r3;
        a = new LiveInitStatus[]{r1, r2, r3};
    }

    public static LiveInitStatus valueOf(String r1) {
        return (LiveInitStatus) r27.a.a(LiveInitStatus.class, r1);
    }

    public static LiveInitStatus[] values() {
        return (LiveInitStatus[]) a.clone();
    }

    public LiveInitStatus(String r1, int r2) {
        super(r1, r2);
    }
}
