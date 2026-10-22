package com.ss.android.lark.pb.entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum MuteWay extends Enum<MuteWay> implements WireEnum {
    private static final /* synthetic */ MuteWay[] $VALUES = null;
    public static final ProtoAdapter<MuteWay> ADAPTER = null;
    public static final MuteWay AUTO_MUTE_WAY = null;
    public static final MuteWay MANUAL_MUTE_WAY = null;
    public static final MuteWay UNKNOWN_MUTE_WAY = null;
    private final int value;

    static {
        MuteWay r0 = new MuteWay("UNKNOWN_MUTE_WAY", 0, 0);
        UNKNOWN_MUTE_WAY = r0;
        MuteWay r1 = new MuteWay("AUTO_MUTE_WAY", 1, 1);
        AUTO_MUTE_WAY = r1;
        MuteWay r3 = new MuteWay("MANUAL_MUTE_WAY", 2, 2);
        MANUAL_MUTE_WAY = r3;
        $VALUES = new MuteWay[]{r0, r1, r3};
        ADAPTER = ProtoAdapter.newEnumAdapter(MuteWay.class);
    }

    public static MuteWay[] values() {
        return (MuteWay[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static MuteWay fromValue(int r1) {
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L10;
        return null;
    L10:
        return MANUAL_MUTE_WAY;
    L12:
        return AUTO_MUTE_WAY;
    L14:
        return UNKNOWN_MUTE_WAY;
    }

    public static MuteWay valueOf(String r1) {
        return (MuteWay) a.a(MuteWay.class, r1);
    }

    private MuteWay(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
