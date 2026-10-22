package com.ss.android.lark.pb.section;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum ModifierType extends Enum<ModifierType> implements WireEnum {
    private static final /* synthetic */ ModifierType[] $VALUES = null;
    public static final ModifierType ACTION = null;
    public static final ProtoAdapter<ModifierType> ADAPTER = null;
    public static final ModifierType EMPHASIS = null;
    public static final ModifierType HIGHLIGHT = null;
    public static final ModifierType TOOLTIPS = null;
    public static final ModifierType UNKNOWN = null;
    private final int value;

    static {
        ModifierType r0 = new ModifierType("UNKNOWN", 0, 0);
        UNKNOWN = r0;
        ModifierType r1 = new ModifierType("ACTION", 1, 1);
        ACTION = r1;
        ModifierType r3 = new ModifierType("HIGHLIGHT", 2, 2);
        HIGHLIGHT = r3;
        ModifierType r5 = new ModifierType("EMPHASIS", 3, 3);
        EMPHASIS = r5;
        ModifierType r7 = new ModifierType("TOOLTIPS", 4, 4);
        TOOLTIPS = r7;
        $VALUES = new ModifierType[]{r0, r1, r3, r5, r7};
        ADAPTER = ProtoAdapter.newEnumAdapter(ModifierType.class);
    }

    public static ModifierType[] values() {
        return (ModifierType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ModifierType fromValue(int r1) {
        if (r1 == 0) goto L22;
        if (r1 == 1) goto L20;
        if (r1 == 2) goto L18;
        if (r1 == 3) goto L16;
        if (r1 == 4) goto L14;
        return null;
    L14:
        return TOOLTIPS;
    L16:
        return EMPHASIS;
    L18:
        return HIGHLIGHT;
    L20:
        return ACTION;
    L22:
        return UNKNOWN;
    }

    public static ModifierType valueOf(String r1) {
        return (ModifierType) a.a(ModifierType.class, r1);
    }

    private ModifierType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
