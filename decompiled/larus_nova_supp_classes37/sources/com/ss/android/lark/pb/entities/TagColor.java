package com.ss.android.lark.pb.entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum TagColor extends Enum<TagColor> implements WireEnum {
    private static final /* synthetic */ TagColor[] $VALUES = null;
    public static final ProtoAdapter<TagColor> ADAPTER = null;
    public static final TagColor BLUE = null;
    public static final TagColor CARMINE = null;
    public static final TagColor GRAY = null;
    public static final TagColor GREEN = null;
    public static final TagColor INDIGO = null;
    public static final TagColor LIME = null;
    public static final TagColor ORANGE = null;
    public static final TagColor PURPLE = null;
    public static final TagColor RED = null;
    public static final TagColor TURQUOISE = null;
    public static final TagColor VIOLET = null;
    public static final TagColor WATHET = null;
    public static final TagColor YELLOW = null;
    private final int value;

    static {
        TagColor r0 = new TagColor("BLUE", 0, 0);
        BLUE = r0;
        TagColor r1 = new TagColor("GRAY", 1, 1);
        GRAY = r1;
        TagColor r3 = new TagColor("INDIGO", 2, 2);
        INDIGO = r3;
        TagColor r5 = new TagColor("WATHET", 3, 3);
        WATHET = r5;
        TagColor r7 = new TagColor("GREEN", 4, 4);
        GREEN = r7;
        TagColor r9 = new TagColor("TURQUOISE", 5, 5);
        TURQUOISE = r9;
        TagColor r11 = new TagColor("YELLOW", 6, 6);
        YELLOW = r11;
        TagColor r13 = new TagColor("LIME", 7, 7);
        LIME = r13;
        TagColor r15 = new TagColor("RED", 8, 8);
        RED = r15;
        TagColor r14 = new TagColor("ORANGE", 9, 9);
        ORANGE = r14;
        TagColor r12 = new TagColor("PURPLE", 10, 10);
        PURPLE = r12;
        TagColor r10 = new TagColor("VIOLET", 11, 11);
        VIOLET = r10;
        TagColor r8 = new TagColor("CARMINE", 12, 12);
        CARMINE = r8;
        $VALUES = new TagColor[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8};
        ADAPTER = ProtoAdapter.newEnumAdapter(TagColor.class);
    }

    public static TagColor[] values() {
        return (TagColor[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static TagColor fromValue(int r0) {
        switch(r0) {
            case 0: goto L30;
            case 1: goto L28;
            case 2: goto L26;
            case 3: goto L24;
            case 4: goto L22;
            case 5: goto L20;
            case 6: goto L18;
            case 7: goto L16;
            case 8: goto L14;
            case 9: goto L12;
            case 10: goto L10;
            case 11: goto L8;
            case 12: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return CARMINE;
    L8:
        return VIOLET;
    L10:
        return PURPLE;
    L12:
        return ORANGE;
    L14:
        return RED;
    L16:
        return LIME;
    L18:
        return YELLOW;
    L20:
        return TURQUOISE;
    L22:
        return GREEN;
    L24:
        return WATHET;
    L26:
        return INDIGO;
    L28:
        return GRAY;
    L30:
        return BLUE;
    }

    public static TagColor valueOf(String r1) {
        return (TagColor) a.a(TagColor.class, r1);
    }

    private TagColor(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
