package com.bytedance.android.live.ktv.common.model.bean;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/bean/ChallengeChangeType;", "", "", "value", "I", "getValue", "()I", "UNKNOW", "AUTO_TURN_ON", "SWITCH_TURN_ON", "SWITCH_TURN_OFF", "ONLY_CONFIG_CHANGE", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ChallengeChangeType extends Enum<ChallengeChangeType> {
    public static final ChallengeChangeType AUTO_TURN_ON = null;
    public static final ChallengeChangeType ONLY_CONFIG_CHANGE = null;
    public static final ChallengeChangeType SWITCH_TURN_OFF = null;
    public static final ChallengeChangeType SWITCH_TURN_ON = null;
    public static final ChallengeChangeType UNKNOW = null;
    public static final /* synthetic */ ChallengeChangeType[] a = null;
    private final int value;

    static {
        ChallengeChangeType r1 = new ChallengeChangeType("UNKNOW", 0, 0);
        UNKNOW = r1;
        ChallengeChangeType r2 = new ChallengeChangeType("AUTO_TURN_ON", 1, 1);
        AUTO_TURN_ON = r2;
        ChallengeChangeType r3 = new ChallengeChangeType("SWITCH_TURN_ON", 2, 2);
        SWITCH_TURN_ON = r3;
        ChallengeChangeType r4 = new ChallengeChangeType("SWITCH_TURN_OFF", 3, 3);
        SWITCH_TURN_OFF = r4;
        ChallengeChangeType r5 = new ChallengeChangeType("ONLY_CONFIG_CHANGE", 4, 4);
        ONLY_CONFIG_CHANGE = r5;
        a = new ChallengeChangeType[]{r1, r2, r3, r4, r5};
    }

    public static ChallengeChangeType valueOf(String r1) {
        return (ChallengeChangeType) r27.a.a(ChallengeChangeType.class, r1);
    }

    public static ChallengeChangeType[] values() {
        return (ChallengeChangeType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public ChallengeChangeType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
