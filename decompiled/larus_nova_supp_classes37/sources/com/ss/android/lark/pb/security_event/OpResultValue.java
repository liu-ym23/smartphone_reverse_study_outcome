package com.ss.android.lark.pb.security_event;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum OpResultValue extends Enum<OpResultValue> implements WireEnum {
    private static final /* synthetic */ OpResultValue[] $VALUES = null;
    public static final ProtoAdapter<OpResultValue> ADAPTER = null;
    public static final OpResultValue OpFailed = null;
    public static final OpResultValue OpSuccess = null;
    private final int value;

    static {
        OpResultValue r0 = new OpResultValue("OpSuccess", 0, 0);
        OpSuccess = r0;
        OpResultValue r1 = new OpResultValue("OpFailed", 1, 1);
        OpFailed = r1;
        $VALUES = new OpResultValue[]{r0, r1};
        ADAPTER = ProtoAdapter.newEnumAdapter(OpResultValue.class);
    }

    public static OpResultValue[] values() {
        return (OpResultValue[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static OpResultValue fromValue(int r1) {
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L8;
        return null;
    L8:
        return OpFailed;
    L10:
        return OpSuccess;
    }

    public static OpResultValue valueOf(String r1) {
        return (OpResultValue) a.a(OpResultValue.class, r1);
    }

    private OpResultValue(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
