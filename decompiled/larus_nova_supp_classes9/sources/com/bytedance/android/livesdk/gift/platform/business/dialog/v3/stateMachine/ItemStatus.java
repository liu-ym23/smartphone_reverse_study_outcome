package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ItemStatus;", BuildConfig.FLAVOR, "(Ljava/lang/String;I)V", "IDLE", "SELECTED", "GONE", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ItemStatus extends Enum<ItemStatus> {
    private static final /* synthetic */ ItemStatus[] $VALUES = null;
    public static final ItemStatus GONE = null;
    public static final ItemStatus IDLE = null;
    public static final ItemStatus SELECTED = null;

    static {
        ItemStatus r1 = new ItemStatus("IDLE", 0);
        IDLE = r1;
        ItemStatus r2 = new ItemStatus("SELECTED", 1);
        SELECTED = r2;
        ItemStatus r3 = new ItemStatus("GONE", 2);
        GONE = r3;
        $VALUES = new ItemStatus[]{r1, r2, r3};
    }

    public static ItemStatus valueOf(String r1) {
        return (ItemStatus) a.a(ItemStatus.class, r1);
    }

    public static ItemStatus[] values() {
        return (ItemStatus[]) $VALUES.clone();
    }

    private ItemStatus(String r1, int r2) {
        super(r1, r2);
    }
}
