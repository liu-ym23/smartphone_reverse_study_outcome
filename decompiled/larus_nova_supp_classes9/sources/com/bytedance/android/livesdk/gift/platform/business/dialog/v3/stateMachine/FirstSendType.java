package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/FirstSendType;", BuildConfig.FLAVOR, "(Ljava/lang/String;I)V", "FALSE", "NORMAL_DIALOG", "INCREASE_CARD_DIALOG", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum FirstSendType extends Enum<FirstSendType> {
    private static final /* synthetic */ FirstSendType[] $VALUES = null;
    public static final FirstSendType FALSE = null;
    public static final FirstSendType INCREASE_CARD_DIALOG = null;
    public static final FirstSendType NORMAL_DIALOG = null;

    static {
        FirstSendType r1 = new FirstSendType("FALSE", 0);
        FALSE = r1;
        FirstSendType r2 = new FirstSendType("NORMAL_DIALOG", 1);
        NORMAL_DIALOG = r2;
        FirstSendType r3 = new FirstSendType("INCREASE_CARD_DIALOG", 2);
        INCREASE_CARD_DIALOG = r3;
        $VALUES = new FirstSendType[]{r1, r2, r3};
    }

    public static FirstSendType valueOf(String r1) {
        return (FirstSendType) a.a(FirstSendType.class, r1);
    }

    public static FirstSendType[] values() {
        return (FirstSendType[]) $VALUES.clone();
    }

    private FirstSendType(String r1, int r2) {
        super(r1, r2);
    }
}
