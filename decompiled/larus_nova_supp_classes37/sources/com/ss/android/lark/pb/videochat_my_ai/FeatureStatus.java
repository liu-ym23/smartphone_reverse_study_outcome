package com.ss.android.lark.pb.videochat_my_ai;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum FeatureStatus extends Enum<FeatureStatus> implements WireEnum {
    private static final /* synthetic */ FeatureStatus[] $VALUES = null;
    public static final ProtoAdapter<FeatureStatus> ADAPTER = null;
    public static final FeatureStatus FEATURE_STATUS_DISABLED = null;
    public static final FeatureStatus FEATURE_STATUS_OFF = null;
    public static final FeatureStatus FEATURE_STATUS_ON = null;
    public static final FeatureStatus FEATURE_STATUS_UNKNOWN = null;
    private final int value;

    static {
        FeatureStatus r0 = new FeatureStatus("FEATURE_STATUS_UNKNOWN", 0, 0);
        FEATURE_STATUS_UNKNOWN = r0;
        FeatureStatus r1 = new FeatureStatus("FEATURE_STATUS_DISABLED", 1, 1);
        FEATURE_STATUS_DISABLED = r1;
        FeatureStatus r3 = new FeatureStatus("FEATURE_STATUS_ON", 2, 2);
        FEATURE_STATUS_ON = r3;
        FeatureStatus r5 = new FeatureStatus("FEATURE_STATUS_OFF", 3, 3);
        FEATURE_STATUS_OFF = r5;
        $VALUES = new FeatureStatus[]{r0, r1, r3, r5};
        ADAPTER = ProtoAdapter.newEnumAdapter(FeatureStatus.class);
    }

    public static FeatureStatus[] values() {
        return (FeatureStatus[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static FeatureStatus fromValue(int r1) {
        if (r1 == 0) goto L18;
        if (r1 == 1) goto L16;
        if (r1 == 2) goto L14;
        if (r1 == 3) goto L12;
        return null;
    L12:
        return FEATURE_STATUS_OFF;
    L14:
        return FEATURE_STATUS_ON;
    L16:
        return FEATURE_STATUS_DISABLED;
    L18:
        return FEATURE_STATUS_UNKNOWN;
    }

    public static FeatureStatus valueOf(String r1) {
        return (FeatureStatus) a.a(FeatureStatus.class, r1);
    }

    private FeatureStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
