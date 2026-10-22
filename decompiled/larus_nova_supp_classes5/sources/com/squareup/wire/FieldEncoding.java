package com.squareup.wire;

import java.io.IOException;
import java.net.ProtocolException;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final enum FieldEncoding extends Enum<FieldEncoding> {
    private static final /* synthetic */ FieldEncoding[] $VALUES = null;
    public static final FieldEncoding FIXED32 = null;
    public static final FieldEncoding FIXED64 = null;
    public static final FieldEncoding LENGTH_DELIMITED = null;
    public static final FieldEncoding VARINT = null;
    final int value;

    static {
        FieldEncoding r0 = new FieldEncoding("VARINT", 0, 0);
        VARINT = r0;
        FieldEncoding r1 = new FieldEncoding("FIXED64", 1, 1);
        FIXED64 = r1;
        FieldEncoding r3 = new FieldEncoding("LENGTH_DELIMITED", 2, 2);
        LENGTH_DELIMITED = r3;
        FieldEncoding r5 = new FieldEncoding("FIXED32", 3, 5);
        FIXED32 = r5;
        $VALUES = new FieldEncoding[]{r0, r1, r3, r5};
    }

    public static FieldEncoding[] values() {
        return (FieldEncoding[]) $VALUES.clone();
    }

    public ProtoAdapter<?> rawProtoAdapter() {
        int r0 = 1.$SwitchMap$com$squareup$wire$FieldEncoding[ordinal()];
        if (r0 == 1) goto L19;
        if (r0 == 2) goto L17;
        if (r0 == 3) goto L15;
        if (r0 != 4) goto L13;
        return ProtoAdapter.BYTES;
    L13:
        throw new AssertionError();
    L15:
        return ProtoAdapter.FIXED64;
    L17:
        return ProtoAdapter.FIXED32;
    L19:
        return ProtoAdapter.UINT64;
    }

    public static FieldEncoding get(int r3) throws IOException {
        if (r3 == 0) goto L18;
        if (r3 == 1) goto L16;
        if (r3 == 2) goto L14;
        if (r3 != 5) goto L12;
        return FIXED32;
    L12:
        throw new ProtocolException("Unexpected FieldEncoding: " + r3);
    L14:
        return LENGTH_DELIMITED;
    L16:
        return FIXED64;
    L18:
        return VARINT;
    }

    public static FieldEncoding valueOf(String r1) {
        return (FieldEncoding) a.a(FieldEncoding.class, r1);
    }

    private FieldEncoding(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
