package com.ss.android.lark.pb.entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum SpecialURL extends Enum<SpecialURL> implements WireEnum {
    private static final /* synthetic */ SpecialURL[] $VALUES = null;
    public static final ProtoAdapter<SpecialURL> ADAPTER = null;
    public static final SpecialURL BEAR = null;
    public static final SpecialURL ENTITY_NUM = null;
    public static final SpecialURL UNKNOWN_URL = null;
    private final int value;

    static {
        SpecialURL r0 = new SpecialURL("UNKNOWN_URL", 0, 0);
        UNKNOWN_URL = r0;
        SpecialURL r1 = new SpecialURL("BEAR", 1, 1);
        BEAR = r1;
        SpecialURL r3 = new SpecialURL("ENTITY_NUM", 2, 2);
        ENTITY_NUM = r3;
        $VALUES = new SpecialURL[]{r0, r1, r3};
        ADAPTER = ProtoAdapter.newEnumAdapter(SpecialURL.class);
    }

    public static SpecialURL[] values() {
        return (SpecialURL[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static SpecialURL fromValue(int r1) {
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L10;
        return null;
    L10:
        return ENTITY_NUM;
    L12:
        return BEAR;
    L14:
        return UNKNOWN_URL;
    }

    public static SpecialURL valueOf(String r1) {
        return (SpecialURL) a.a(SpecialURL.class, r1);
    }

    private SpecialURL(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
