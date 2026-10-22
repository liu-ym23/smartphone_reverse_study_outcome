package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ItemDataType;", BuildConfig.FLAVOR, "(Ljava/lang/String;I)V", "NORMAL_ITEM", "MOSTLY_USED_HEADER", "BOTTOM_LOADING", "BOTTOM_SEARCH_GUIDE", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ItemDataType extends Enum<ItemDataType> {
    private static final /* synthetic */ ItemDataType[] $VALUES = null;
    public static final ItemDataType BOTTOM_LOADING = null;
    public static final ItemDataType BOTTOM_SEARCH_GUIDE = null;
    public static final ItemDataType MOSTLY_USED_HEADER = null;
    public static final ItemDataType NORMAL_ITEM = null;

    static {
        ItemDataType r1 = new ItemDataType("NORMAL_ITEM", 0);
        NORMAL_ITEM = r1;
        ItemDataType r2 = new ItemDataType("MOSTLY_USED_HEADER", 1);
        MOSTLY_USED_HEADER = r2;
        ItemDataType r3 = new ItemDataType("BOTTOM_LOADING", 2);
        BOTTOM_LOADING = r3;
        ItemDataType r4 = new ItemDataType("BOTTOM_SEARCH_GUIDE", 3);
        BOTTOM_SEARCH_GUIDE = r4;
        $VALUES = new ItemDataType[]{r1, r2, r3, r4};
    }

    public static ItemDataType valueOf(String r1) {
        return (ItemDataType) a.a(ItemDataType.class, r1);
    }

    public static ItemDataType[] values() {
        return (ItemDataType[]) $VALUES.clone();
    }

    private ItemDataType(String r1, int r2) {
        super(r1, r2);
    }
}
