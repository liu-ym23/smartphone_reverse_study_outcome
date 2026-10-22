package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/SelectedStatus;", BuildConfig.FLAVOR, "(Ljava/lang/String;I)V", "IDLE", "CLICK", "GROUP", "LOCATE", "SERIES_CARD", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum SelectedStatus extends Enum<SelectedStatus> {
    private static final /* synthetic */ SelectedStatus[] $VALUES = null;
    public static final SelectedStatus CLICK = null;
    public static final SelectedStatus GROUP = null;
    public static final SelectedStatus IDLE = null;
    public static final SelectedStatus LOCATE = null;
    public static final SelectedStatus SERIES_CARD = null;

    static {
        SelectedStatus r1 = new SelectedStatus("IDLE", 0);
        IDLE = r1;
        SelectedStatus r2 = new SelectedStatus("CLICK", 1);
        CLICK = r2;
        SelectedStatus r3 = new SelectedStatus("GROUP", 2);
        GROUP = r3;
        SelectedStatus r4 = new SelectedStatus("LOCATE", 3);
        LOCATE = r4;
        SelectedStatus r5 = new SelectedStatus("SERIES_CARD", 4);
        SERIES_CARD = r5;
        $VALUES = new SelectedStatus[]{r1, r2, r3, r4, r5};
    }

    public static SelectedStatus valueOf(String r1) {
        return (SelectedStatus) a.a(SelectedStatus.class, r1);
    }

    public static SelectedStatus[] values() {
        return (SelectedStatus[]) $VALUES.clone();
    }

    private SelectedStatus(String r1, int r2) {
        super(r1, r2);
    }
}
