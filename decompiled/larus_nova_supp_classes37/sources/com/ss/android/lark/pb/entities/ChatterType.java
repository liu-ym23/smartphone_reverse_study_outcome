package com.ss.android.lark.pb.entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum ChatterType extends Enum<ChatterType> implements WireEnum {
    private static final /* synthetic */ ChatterType[] $VALUES = null;
    public static final ProtoAdapter<ChatterType> ADAPTER = null;
    public static final ChatterType AI = null;
    public static final ChatterType BOT = null;
    public static final ChatterType DOUBAO = null;
    public static final ChatterType UNKNOWN_CHATTER = null;
    public static final ChatterType USER = null;
    private final int value;

    static {
        ChatterType r0 = new ChatterType("UNKNOWN_CHATTER", 0, 0);
        UNKNOWN_CHATTER = r0;
        ChatterType r1 = new ChatterType("USER", 1, 1);
        USER = r1;
        ChatterType r3 = new ChatterType("BOT", 2, 2);
        BOT = r3;
        ChatterType r5 = new ChatterType("AI", 3, 3);
        AI = r5;
        ChatterType r7 = new ChatterType("DOUBAO", 4, 4);
        DOUBAO = r7;
        $VALUES = new ChatterType[]{r0, r1, r3, r5, r7};
        ADAPTER = ProtoAdapter.newEnumAdapter(ChatterType.class);
    }

    public static ChatterType[] values() {
        return (ChatterType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ChatterType fromValue(int r1) {
        if (r1 == 0) goto L22;
        if (r1 == 1) goto L20;
        if (r1 == 2) goto L18;
        if (r1 == 3) goto L16;
        if (r1 == 4) goto L14;
        return null;
    L14:
        return DOUBAO;
    L16:
        return AI;
    L18:
        return BOT;
    L20:
        return USER;
    L22:
        return UNKNOWN_CHATTER;
    }

    public static ChatterType valueOf(String r1) {
        return (ChatterType) a.a(ChatterType.class, r1);
    }

    private ChatterType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
