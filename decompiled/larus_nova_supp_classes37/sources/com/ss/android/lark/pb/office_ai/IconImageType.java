package com.ss.android.lark.pb.office_ai;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum IconImageType extends Enum<IconImageType> implements WireEnum {
    private static final /* synthetic */ IconImageType[] $VALUES = null;
    public static final ProtoAdapter<IconImageType> ADAPTER = null;
    public static final IconImageType IconImageType_IMAGE = null;
    public static final IconImageType IconImageType_UD = null;
    private final int value;

    static {
        IconImageType r0 = new IconImageType("IconImageType_UD", 0, 1);
        IconImageType_UD = r0;
        IconImageType r1 = new IconImageType("IconImageType_IMAGE", 1, 2);
        IconImageType_IMAGE = r1;
        $VALUES = new IconImageType[]{r0, r1};
        ADAPTER = ProtoAdapter.newEnumAdapter(IconImageType.class);
    }

    public static IconImageType[] values() {
        return (IconImageType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static IconImageType fromValue(int r1) {
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L9;
        return null;
    L9:
        return IconImageType_IMAGE;
    L11:
        return IconImageType_UD;
    }

    public static IconImageType valueOf(String r1) {
        return (IconImageType) a.a(IconImageType.class, r1);
    }

    private IconImageType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
