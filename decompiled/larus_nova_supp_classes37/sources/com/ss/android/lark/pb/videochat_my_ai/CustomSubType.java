package com.ss.android.lark.pb.videochat_my_ai;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum CustomSubType extends Enum<CustomSubType> implements WireEnum {
    private static final /* synthetic */ CustomSubType[] $VALUES = null;
    public static final ProtoAdapter<CustomSubType> ADAPTER = null;
    public static final CustomSubType CUSTOM_GOLDEN_SENTENCES = null;
    public static final CustomSubType CUSTOM_KEY_POINT = null;
    public static final CustomSubType CUSTOM_MY_TODO = null;
    public static final CustomSubType CUSTOM_SELF_PERFORMANCE = null;
    public static final CustomSubType CUSTOM_SPEAKER_SUMMARY = null;
    public static final CustomSubType CUSTOM_SUB_UNKNOWN = null;
    private final int value;

    static {
        CustomSubType r0 = new CustomSubType("CUSTOM_SUB_UNKNOWN", 0, 0);
        CUSTOM_SUB_UNKNOWN = r0;
        CustomSubType r1 = new CustomSubType("CUSTOM_MY_TODO", 1, 1);
        CUSTOM_MY_TODO = r1;
        CustomSubType r3 = new CustomSubType("CUSTOM_KEY_POINT", 2, 2);
        CUSTOM_KEY_POINT = r3;
        CustomSubType r5 = new CustomSubType("CUSTOM_SPEAKER_SUMMARY", 3, 3);
        CUSTOM_SPEAKER_SUMMARY = r5;
        CustomSubType r7 = new CustomSubType("CUSTOM_GOLDEN_SENTENCES", 4, 4);
        CUSTOM_GOLDEN_SENTENCES = r7;
        CustomSubType r9 = new CustomSubType("CUSTOM_SELF_PERFORMANCE", 5, 5);
        CUSTOM_SELF_PERFORMANCE = r9;
        $VALUES = new CustomSubType[]{r0, r1, r3, r5, r7, r9};
        ADAPTER = ProtoAdapter.newEnumAdapter(CustomSubType.class);
    }

    public static CustomSubType[] values() {
        return (CustomSubType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static CustomSubType fromValue(int r1) {
        if (r1 == 0) goto L26;
        if (r1 == 1) goto L24;
        if (r1 == 2) goto L22;
        if (r1 == 3) goto L20;
        if (r1 == 4) goto L18;
        if (r1 == 5) goto L16;
        return null;
    L16:
        return CUSTOM_SELF_PERFORMANCE;
    L18:
        return CUSTOM_GOLDEN_SENTENCES;
    L20:
        return CUSTOM_SPEAKER_SUMMARY;
    L22:
        return CUSTOM_KEY_POINT;
    L24:
        return CUSTOM_MY_TODO;
    L26:
        return CUSTOM_SUB_UNKNOWN;
    }

    public static CustomSubType valueOf(String r1) {
        return (CustomSubType) a.a(CustomSubType.class, r1);
    }

    private CustomSubType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
