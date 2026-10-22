package com.obric.matrix.proto;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;

/* JADX INFO: loaded from: classes3.dex */
public final enum NETWORK_METHOD extends Enum<NETWORK_METHOD> implements WireEnum {
    private static final /* synthetic */ NETWORK_METHOD[] $VALUES = null;
    public static final ProtoAdapter<NETWORK_METHOD> ADAPTER = null;
    public static final NETWORK_METHOD METHOD_GET = null;
    public static final NETWORK_METHOD METHOD_POST = null;
    private final int value;

    static {
        NETWORK_METHOD r5 = new NETWORK_METHOD("METHOD_GET", 0, 0);
        METHOD_GET = r5;
        NETWORK_METHOD r10 = new NETWORK_METHOD("METHOD_POST", 1, 1);
        METHOD_POST = r10;
        $VALUES = new NETWORK_METHOD[]{r5, r10};
        ADAPTER = new ProtoAdapter_NETWORK_METHOD();
    }

    private NETWORK_METHOD(String r5, int r10, int r11) {
        super(r5, r10);
        this.value = r11;
    }

    public static NETWORK_METHOD fromValue(int r5) {
        if (r5 == 0) goto L10;
        if (r5 == 1) goto L8;
        return null;
    L8:
        return METHOD_POST;
    L10:
        return METHOD_GET;
    }

    public static NETWORK_METHOD valueOf(String r5) {
        return (NETWORK_METHOD) Enum.valueOf(NETWORK_METHOD.class, r5);
    }

    public static NETWORK_METHOD[] values() {
        return (NETWORK_METHOD[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }
}
