package com.ss.android.lark.pb.urecommend;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum IconStyle extends Enum<IconStyle> implements WireEnum {
    private static final /* synthetic */ IconStyle[] $VALUES = null;
    public static final ProtoAdapter<IconStyle> ADAPTER = null;
    public static final IconStyle CIRCLE = null;
    public static final IconStyle RECTANGLE = null;
    private final int value;

    static {
        IconStyle r0 = new IconStyle("RECTANGLE", 0, 0);
        RECTANGLE = r0;
        IconStyle r1 = new IconStyle("CIRCLE", 1, 1);
        CIRCLE = r1;
        $VALUES = new IconStyle[]{r0, r1};
        ADAPTER = ProtoAdapter.newEnumAdapter(IconStyle.class);
    }

    public static IconStyle[] values() {
        return (IconStyle[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static IconStyle fromValue(int r1) {
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L8;
        return null;
    L8:
        return CIRCLE;
    L10:
        return RECTANGLE;
    }

    public static IconStyle valueOf(String r1) {
        return (IconStyle) a.a(IconStyle.class, r1);
    }

    private IconStyle(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
