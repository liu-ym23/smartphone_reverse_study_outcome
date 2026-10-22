package com.ss.android.lark.pb.meeting_object;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum FeatureUpgradeType extends Enum<FeatureUpgradeType> implements WireEnum {
    private static final /* synthetic */ FeatureUpgradeType[] $VALUES = null;
    public static final ProtoAdapter<FeatureUpgradeType> ADAPTER = null;
    public static final FeatureUpgradeType FeatureUpgradeType_AI = null;
    public static final FeatureUpgradeType FeatureUpgradeType_ASR = null;
    public static final FeatureUpgradeType FeatureUpgradeType_Unknown = null;
    private final int value;

    static {
        FeatureUpgradeType r0 = new FeatureUpgradeType("FeatureUpgradeType_Unknown", 0, 0);
        FeatureUpgradeType_Unknown = r0;
        FeatureUpgradeType r1 = new FeatureUpgradeType("FeatureUpgradeType_ASR", 1, 1);
        FeatureUpgradeType_ASR = r1;
        FeatureUpgradeType r3 = new FeatureUpgradeType("FeatureUpgradeType_AI", 2, 2);
        FeatureUpgradeType_AI = r3;
        $VALUES = new FeatureUpgradeType[]{r0, r1, r3};
        ADAPTER = ProtoAdapter.newEnumAdapter(FeatureUpgradeType.class);
    }

    public static FeatureUpgradeType[] values() {
        return (FeatureUpgradeType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static FeatureUpgradeType fromValue(int r1) {
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L10;
        return null;
    L10:
        return FeatureUpgradeType_AI;
    L12:
        return FeatureUpgradeType_ASR;
    L14:
        return FeatureUpgradeType_Unknown;
    }

    public static FeatureUpgradeType valueOf(String r1) {
        return (FeatureUpgradeType) a.a(FeatureUpgradeType.class, r1);
    }

    private FeatureUpgradeType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
