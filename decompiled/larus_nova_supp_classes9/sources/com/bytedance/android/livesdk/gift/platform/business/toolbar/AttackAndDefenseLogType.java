package com.bytedance.android.livesdk.gift.platform.business.toolbar;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/toolbar/AttackAndDefenseLogType;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "eventName", "Ljava/lang/String;", "getEventName", "()Ljava/lang/String;", "SHOW", "CLICK", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum AttackAndDefenseLogType extends Enum<AttackAndDefenseLogType> {
    public static final AttackAndDefenseLogType CLICK = null;
    public static final AttackAndDefenseLogType SHOW = null;
    public static final /* synthetic */ AttackAndDefenseLogType[] a = null;
    private final String eventName;

    static {
        AttackAndDefenseLogType r1 = new AttackAndDefenseLogType("SHOW", 0, "livesdk_gift_game_anchor_entrance_show");
        SHOW = r1;
        AttackAndDefenseLogType r2 = new AttackAndDefenseLogType("CLICK", 1, "livesdk_gift_game_anchor_entrance_click");
        CLICK = r2;
        a = new AttackAndDefenseLogType[]{r1, r2};
    }

    public static AttackAndDefenseLogType valueOf(String r1) {
        return (AttackAndDefenseLogType) r27.a.a(AttackAndDefenseLogType.class, r1);
    }

    public static AttackAndDefenseLogType[] values() {
        return (AttackAndDefenseLogType[]) a.clone();
    }

    public final String getEventName() {
        return this.eventName;
    }

    public AttackAndDefenseLogType(String r1, int r2, String r3) {
        super(r1, r2);
        this.eventName = r3;
    }
}
