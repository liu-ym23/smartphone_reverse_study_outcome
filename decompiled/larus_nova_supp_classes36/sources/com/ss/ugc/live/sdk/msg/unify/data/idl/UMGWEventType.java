package com.ss.ugc.live.sdk.msg.unify.data.idl;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final enum UMGWEventType extends Enum<UMGWEventType> implements WireEnum {
    private static final /* synthetic */ UMGWEventType[] $VALUES = null;
    public static final ProtoAdapter<UMGWEventType> ADAPTER = null;
    public static final UMGWEventType DOWNLINK_ACK = null;
    public static final UMGWEventType DOWNLINK_MSG = null;
    public static final UMGWEventType FETCH = null;
    public static final UMGWEventType UPLINK_ACK = null;
    public static final UMGWEventType UPLINK_HB = null;
    public static final UMGWEventType UPLINK_REGISTER = null;
    public static final UMGWEventType UPLINK_UNREGISTER = null;
    private final int value;

    static {
        UMGWEventType r0 = new UMGWEventType("FETCH", 0, 0);
        FETCH = r0;
        UMGWEventType r1 = new UMGWEventType("UPLINK_REGISTER", 1, 1);
        UPLINK_REGISTER = r1;
        UMGWEventType r3 = new UMGWEventType("UPLINK_UNREGISTER", 2, 2);
        UPLINK_UNREGISTER = r3;
        UMGWEventType r5 = new UMGWEventType("UPLINK_HB", 3, 3);
        UPLINK_HB = r5;
        UMGWEventType r7 = new UMGWEventType("UPLINK_ACK", 4, 4);
        UPLINK_ACK = r7;
        UMGWEventType r9 = new UMGWEventType("DOWNLINK_ACK", 5, 5);
        DOWNLINK_ACK = r9;
        UMGWEventType r11 = new UMGWEventType("DOWNLINK_MSG", 6, 6);
        DOWNLINK_MSG = r11;
        $VALUES = new UMGWEventType[]{r0, r1, r3, r5, r7, r9, r11};
        ADAPTER = new ProtoAdapter_UMGWEventType();
    }

    public static UMGWEventType[] values() {
        return (UMGWEventType[]) $VALUES.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static UMGWEventType fromValue(int r0) {
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
        return DOWNLINK_MSG;
    L8:
        return DOWNLINK_ACK;
    L10:
        return UPLINK_ACK;
    L12:
        return UPLINK_HB;
    L14:
        return UPLINK_UNREGISTER;
    L16:
        return UPLINK_REGISTER;
    L18:
        return FETCH;
    }

    public static UMGWEventType valueOf(String r1) {
        return (UMGWEventType) a.a(UMGWEventType.class, r1);
    }

    private UMGWEventType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
