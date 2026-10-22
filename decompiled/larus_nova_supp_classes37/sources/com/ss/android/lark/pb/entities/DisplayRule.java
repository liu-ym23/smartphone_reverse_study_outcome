package com.ss.android.lark.pb.entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum DisplayRule extends Enum<DisplayRule> implements WireEnum {
    private static final /* synthetic */ DisplayRule[] $VALUES = null;
    public static final ProtoAdapter<DisplayRule> ADAPTER = null;
    public static final DisplayRule NOT_DISPLAY = null;
    public static final DisplayRule ONLY_TRANSLATION = null;
    public static final DisplayRule UNKNOWN_RULE = null;
    public static final DisplayRule WITH_ORIGINAL = null;
    private final int value;

    static {
        DisplayRule r0 = new DisplayRule("UNKNOWN_RULE", 0, 0);
        UNKNOWN_RULE = r0;
        DisplayRule r1 = new DisplayRule("NOT_DISPLAY", 1, 1);
        NOT_DISPLAY = r1;
        DisplayRule r3 = new DisplayRule("ONLY_TRANSLATION", 2, 2);
        ONLY_TRANSLATION = r3;
        DisplayRule r5 = new DisplayRule("WITH_ORIGINAL", 3, 3);
        WITH_ORIGINAL = r5;
        $VALUES = new DisplayRule[]{r0, r1, r3, r5};
        ADAPTER = ProtoAdapter.newEnumAdapter(DisplayRule.class);
    }

    public static DisplayRule[] values() {
        return (DisplayRule[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static DisplayRule fromValue(int r1) {
        if (r1 == 0) goto L18;
        if (r1 == 1) goto L16;
        if (r1 == 2) goto L14;
        if (r1 == 3) goto L12;
        return null;
    L12:
        return WITH_ORIGINAL;
    L14:
        return ONLY_TRANSLATION;
    L16:
        return NOT_DISPLAY;
    L18:
        return UNKNOWN_RULE;
    }

    public static DisplayRule valueOf(String r1) {
        return (DisplayRule) a.a(DisplayRule.class, r1);
    }

    private DisplayRule(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
