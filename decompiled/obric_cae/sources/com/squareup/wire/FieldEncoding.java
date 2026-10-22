package com.squareup.wire;

import defpackage.a;
import java.net.ProtocolException;

/* JADX INFO: loaded from: classes2.dex */
public final enum FieldEncoding extends Enum<FieldEncoding> {
    private static final /* synthetic */ FieldEncoding[] $VALUES = null;
    public static final FieldEncoding FIXED32 = null;
    public static final FieldEncoding FIXED64 = null;
    public static final FieldEncoding LENGTH_DELIMITED = null;
    public static final FieldEncoding VARINT = null;
    final int value;

    /* JADX INFO: renamed from: com.squareup.wire.FieldEncoding$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$squareup$wire$FieldEncoding = null;

        static {
            int[] r8 = new int[FieldEncoding.values().length];
            $SwitchMap$com$squareup$wire$FieldEncoding = r8;
            r8[FieldEncoding.VARINT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$squareup$wire$FieldEncoding[FieldEncoding.FIXED32.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$squareup$wire$FieldEncoding[FieldEncoding.FIXED64.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$squareup$wire$FieldEncoding[FieldEncoding.LENGTH_DELIMITED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    static {
        FieldEncoding r8 = new FieldEncoding("VARINT", 0, 0);
        VARINT = r8;
        FieldEncoding r10 = new FieldEncoding("FIXED64", 1, 1);
        FIXED64 = r10;
        FieldEncoding r11 = new FieldEncoding("LENGTH_DELIMITED", 2, 2);
        LENGTH_DELIMITED = r11;
        FieldEncoding r12 = new FieldEncoding("FIXED32", 3, 5);
        FIXED32 = r12;
        $VALUES = new FieldEncoding[]{r8, r10, r11, r12};
    }

    private FieldEncoding(String r8, int r10, int r11) {
        super(r8, r10);
        this.value = r11;
    }

    public static FieldEncoding get(int r8) {
        if (r8 == 0) goto L18;
        if (r8 == 1) goto L16;
        if (r8 == 2) goto L14;
        if (r8 != 5) goto L12;
        return FIXED32;
    L12:
        throw new ProtocolException(a.d("Unexpected FieldEncoding: ", r8));
    L14:
        return LENGTH_DELIMITED;
    L16:
        return FIXED64;
    L18:
        return VARINT;
    }

    public static FieldEncoding valueOf(String r8) {
        return (FieldEncoding) Enum.valueOf(FieldEncoding.class, r8);
    }

    public static FieldEncoding[] values() {
        return (FieldEncoding[]) $VALUES.clone();
    }

    public ProtoAdapter<?> rawProtoAdapter() {
        int r8 = AnonymousClass1.$SwitchMap$com$squareup$wire$FieldEncoding[ordinal()];
        if (r8 == 1) goto L19;
        if (r8 == 2) goto L17;
        if (r8 == 3) goto L15;
        if (r8 != 4) goto L13;
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
}
