package com.ss.android.lark.pb.entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum Tag extends Enum<Tag> implements WireEnum {
    private static final /* synthetic */ Tag[] $VALUES = null;
    public static final ProtoAdapter<Tag> ADAPTER = null;
    public static final Tag APPROVAL = null;
    public static final Tag EXTERNAL = null;
    public static final Tag EXTERNAL_WARN = null;
    public static final Tag OFFICIAL = null;
    public static final Tag ONCALL = null;
    public static final Tag ONCALL_OFFLINE = null;
    public static final Tag UNKNOWN_TAG = null;
    private final int value;

    static {
        Tag r0 = new Tag("UNKNOWN_TAG", 0, 0);
        UNKNOWN_TAG = r0;
        Tag r1 = new Tag("APPROVAL", 1, 1);
        APPROVAL = r1;
        Tag r3 = new Tag("OFFICIAL", 2, 2);
        OFFICIAL = r3;
        Tag r5 = new Tag("ONCALL", 3, 3);
        ONCALL = r5;
        Tag r7 = new Tag("ONCALL_OFFLINE", 4, 4);
        ONCALL_OFFLINE = r7;
        Tag r9 = new Tag("EXTERNAL", 5, 5);
        EXTERNAL = r9;
        Tag r11 = new Tag("EXTERNAL_WARN", 6, 6);
        EXTERNAL_WARN = r11;
        $VALUES = new Tag[]{r0, r1, r3, r5, r7, r9, r11};
        ADAPTER = ProtoAdapter.newEnumAdapter(Tag.class);
    }

    public static Tag[] values() {
        return (Tag[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static Tag fromValue(int r0) {
        switch(r0) {
            case 0: goto L18;
            case 1: goto L16;
            case 2: goto L14;
            case 3: goto L12;
            case 4: goto L10;
            case 5: goto L8;
            case 6: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return EXTERNAL_WARN;
    L8:
        return EXTERNAL;
    L10:
        return ONCALL_OFFLINE;
    L12:
        return ONCALL;
    L14:
        return OFFICIAL;
    L16:
        return APPROVAL;
    L18:
        return UNKNOWN_TAG;
    }

    public static Tag valueOf(String r1) {
        return (Tag) a.a(Tag.class, r1);
    }

    private Tag(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
