package com.bytedance.android.livesdk.gift.platform.business.pkTray;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/pkTray/TrayStatus;", BuildConfig.FLAVOR, "Idle", "Busy", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum TrayStatus extends Enum<TrayStatus> {
    public static final TrayStatus Busy = null;
    public static final TrayStatus Idle = null;
    public static final /* synthetic */ TrayStatus[] a = null;

    static {
        TrayStatus r1 = new TrayStatus("Idle", 0);
        Idle = r1;
        TrayStatus r2 = new TrayStatus("Busy", 1);
        Busy = r2;
        a = new TrayStatus[]{r1, r2};
    }

    public static TrayStatus valueOf(String r1) {
        return (TrayStatus) r27.a.a(TrayStatus.class, r1);
    }

    public static TrayStatus[] values() {
        return (TrayStatus[]) a.clone();
    }

    public TrayStatus(String r1, int r2) {
        super(r1, r2);
    }
}
