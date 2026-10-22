package com.ss.android.lark.pb.videochat_my_ai;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum CustomType extends Enum<CustomType> implements WireEnum {
    private static final /* synthetic */ CustomType[] $VALUES = null;
    public static final ProtoAdapter<CustomType> ADAPTER = null;
    public static final CustomType CUSTOM_PULL_SUMMARY = null;
    public static final CustomType CUSTOM_PULL_TABS = null;
    public static final CustomType CUSTOM_PULL_TITLE = null;
    public static final CustomType CUSTOM_UNKNOWN = null;
    private final int value;

    static {
        CustomType r0 = new CustomType("CUSTOM_UNKNOWN", 0, 0);
        CUSTOM_UNKNOWN = r0;
        CustomType r1 = new CustomType("CUSTOM_PULL_SUMMARY", 1, 1);
        CUSTOM_PULL_SUMMARY = r1;
        CustomType r3 = new CustomType("CUSTOM_PULL_TABS", 2, 2);
        CUSTOM_PULL_TABS = r3;
        CustomType r5 = new CustomType("CUSTOM_PULL_TITLE", 3, 3);
        CUSTOM_PULL_TITLE = r5;
        $VALUES = new CustomType[]{r0, r1, r3, r5};
        ADAPTER = ProtoAdapter.newEnumAdapter(CustomType.class);
    }

    public static CustomType[] values() {
        return (CustomType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static CustomType fromValue(int r1) {
        if (r1 == 0) goto L18;
        if (r1 == 1) goto L16;
        if (r1 == 2) goto L14;
        if (r1 == 3) goto L12;
        return null;
    L12:
        return CUSTOM_PULL_TITLE;
    L14:
        return CUSTOM_PULL_TABS;
    L16:
        return CUSTOM_PULL_SUMMARY;
    L18:
        return CUSTOM_UNKNOWN;
    }

    public static CustomType valueOf(String r1) {
        return (CustomType) a.a(CustomType.class, r1);
    }

    private CustomType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
