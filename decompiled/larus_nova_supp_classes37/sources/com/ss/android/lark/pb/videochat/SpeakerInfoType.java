package com.ss.android.lark.pb.videochat;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum SpeakerInfoType extends Enum<SpeakerInfoType> implements WireEnum {
    private static final /* synthetic */ SpeakerInfoType[] $VALUES = null;
    public static final ProtoAdapter<SpeakerInfoType> ADAPTER = null;
    public static final SpeakerInfoType Fake_Lark_User = null;
    public static final SpeakerInfoType Real_Lark_User = null;
    public static final SpeakerInfoType Unknown_Speaker = null;
    private final int value;

    static {
        SpeakerInfoType r0 = new SpeakerInfoType("Unknown_Speaker", 0, 0);
        Unknown_Speaker = r0;
        SpeakerInfoType r1 = new SpeakerInfoType("Real_Lark_User", 1, 1);
        Real_Lark_User = r1;
        SpeakerInfoType r3 = new SpeakerInfoType("Fake_Lark_User", 2, 2);
        Fake_Lark_User = r3;
        $VALUES = new SpeakerInfoType[]{r0, r1, r3};
        ADAPTER = ProtoAdapter.newEnumAdapter(SpeakerInfoType.class);
    }

    public static SpeakerInfoType[] values() {
        return (SpeakerInfoType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static SpeakerInfoType fromValue(int r1) {
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L10;
        return null;
    L10:
        return Fake_Lark_User;
    L12:
        return Real_Lark_User;
    L14:
        return Unknown_Speaker;
    }

    public static SpeakerInfoType valueOf(String r1) {
        return (SpeakerInfoType) a.a(SpeakerInfoType.class, r1);
    }

    private SpeakerInfoType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
