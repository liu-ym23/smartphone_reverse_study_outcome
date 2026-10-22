package com.ss.android.lark.pb.entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum IconType extends Enum<IconType> implements WireEnum {
    private static final /* synthetic */ IconType[] $VALUES = null;
    public static final ProtoAdapter<IconType> ADAPTER = null;
    public static final IconType EMOJI = null;
    public static final IconType IMAGE = null;
    public static final IconType UNKNOWN_ICON_TYPE = null;
    private final int value;

    static {
        IconType r0 = new IconType("UNKNOWN_ICON_TYPE", 0, 0);
        UNKNOWN_ICON_TYPE = r0;
        IconType r1 = new IconType("EMOJI", 1, 1);
        EMOJI = r1;
        IconType r3 = new IconType("IMAGE", 2, 2);
        IMAGE = r3;
        $VALUES = new IconType[]{r0, r1, r3};
        ADAPTER = ProtoAdapter.newEnumAdapter(IconType.class);
    }

    public static IconType[] values() {
        return (IconType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static IconType fromValue(int r1) {
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L10;
        return null;
    L10:
        return IMAGE;
    L12:
        return EMOJI;
    L14:
        return UNKNOWN_ICON_TYPE;
    }

    public static IconType valueOf(String r1) {
        return (IconType) a.a(IconType.class, r1);
    }

    private IconType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
