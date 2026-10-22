package com.ss.android.lark.pb.authorization;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum FeatureGateType extends Enum<FeatureGateType> implements WireEnum {
    private static final /* synthetic */ FeatureGateType[] $VALUES = null;
    public static final ProtoAdapter<FeatureGateType> ADAPTER = null;
    public static final FeatureGateType FEATURE_GATE_FILE = null;
    public static final FeatureGateType FEATURE_GATE_PASTE_PROTECTION = null;
    public static final FeatureGateType FEATURE_GATE_PRIVACY = null;
    public static final FeatureGateType FEATURE_GATE_SCREEN_PROTECTION = null;
    public static final FeatureGateType FEATURE_GATE_UNKNOWN = null;
    private final int value;

    static {
        FeatureGateType r0 = new FeatureGateType("FEATURE_GATE_UNKNOWN", 0, 0);
        FEATURE_GATE_UNKNOWN = r0;
        FeatureGateType r1 = new FeatureGateType("FEATURE_GATE_FILE", 1, 1);
        FEATURE_GATE_FILE = r1;
        FeatureGateType r3 = new FeatureGateType("FEATURE_GATE_PRIVACY", 2, 2);
        FEATURE_GATE_PRIVACY = r3;
        FeatureGateType r5 = new FeatureGateType("FEATURE_GATE_PASTE_PROTECTION", 3, 3);
        FEATURE_GATE_PASTE_PROTECTION = r5;
        FeatureGateType r7 = new FeatureGateType("FEATURE_GATE_SCREEN_PROTECTION", 4, 4);
        FEATURE_GATE_SCREEN_PROTECTION = r7;
        $VALUES = new FeatureGateType[]{r0, r1, r3, r5, r7};
        ADAPTER = ProtoAdapter.newEnumAdapter(FeatureGateType.class);
    }

    public static FeatureGateType[] values() {
        return (FeatureGateType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static FeatureGateType fromValue(int r1) {
        if (r1 == 0) goto L22;
        if (r1 == 1) goto L20;
        if (r1 == 2) goto L18;
        if (r1 == 3) goto L16;
        if (r1 == 4) goto L14;
        return null;
    L14:
        return FEATURE_GATE_SCREEN_PROTECTION;
    L16:
        return FEATURE_GATE_PASTE_PROTECTION;
    L18:
        return FEATURE_GATE_PRIVACY;
    L20:
        return FEATURE_GATE_FILE;
    L22:
        return FEATURE_GATE_UNKNOWN;
    }

    public static FeatureGateType valueOf(String r1) {
        return (FeatureGateType) a.a(FeatureGateType.class, r1);
    }

    private FeatureGateType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
