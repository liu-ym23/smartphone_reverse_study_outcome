package org.msgpack.core;

import org.msgpack.core.annotations.VisibleForTesting;
import org.msgpack.value.ValueType;

/* JADX INFO: loaded from: classes3.dex */
public final enum MessageFormat extends Enum<MessageFormat> {
    private static final /* synthetic */ MessageFormat[] $VALUES = null;
    public static final MessageFormat ARRAY16 = null;
    public static final MessageFormat ARRAY32 = null;
    public static final MessageFormat BIN16 = null;
    public static final MessageFormat BIN32 = null;
    public static final MessageFormat BIN8 = null;
    public static final MessageFormat BOOLEAN = null;
    public static final MessageFormat EXT16 = null;
    public static final MessageFormat EXT32 = null;
    public static final MessageFormat EXT8 = null;
    public static final MessageFormat FIXARRAY = null;
    public static final MessageFormat FIXEXT1 = null;
    public static final MessageFormat FIXEXT16 = null;
    public static final MessageFormat FIXEXT2 = null;
    public static final MessageFormat FIXEXT4 = null;
    public static final MessageFormat FIXEXT8 = null;
    public static final MessageFormat FIXMAP = null;
    public static final MessageFormat FIXSTR = null;
    public static final MessageFormat FLOAT32 = null;
    public static final MessageFormat FLOAT64 = null;
    public static final MessageFormat INT16 = null;
    public static final MessageFormat INT32 = null;
    public static final MessageFormat INT64 = null;
    public static final MessageFormat INT8 = null;
    public static final MessageFormat MAP16 = null;
    public static final MessageFormat MAP32 = null;
    public static final MessageFormat NEGFIXINT = null;
    public static final MessageFormat NEVER_USED = null;
    public static final MessageFormat NIL = null;
    public static final MessageFormat POSFIXINT = null;
    public static final MessageFormat STR16 = null;
    public static final MessageFormat STR32 = null;
    public static final MessageFormat STR8 = null;
    public static final MessageFormat UINT16 = null;
    public static final MessageFormat UINT32 = null;
    public static final MessageFormat UINT64 = null;
    public static final MessageFormat UINT8 = null;
    private static final MessageFormat[] formatTable = null;
    private final ValueType valueType;

    static {
        ValueType r10 = ValueType.INTEGER;
        MessageFormat r11 = new MessageFormat("POSFIXINT", 0, r10);
        POSFIXINT = r11;
        ValueType r12 = ValueType.MAP;
        MessageFormat r13 = new MessageFormat("FIXMAP", 1, r12);
        FIXMAP = r13;
        ValueType r14 = ValueType.ARRAY;
        MessageFormat r15 = new MessageFormat("FIXARRAY", 2, r14);
        FIXARRAY = r15;
        ValueType r16 = ValueType.STRING;
        MessageFormat r17 = new MessageFormat("FIXSTR", 3, r16);
        FIXSTR = r17;
        MessageFormat r18 = new MessageFormat("NIL", 4, ValueType.NIL);
        NIL = r18;
        MessageFormat r19 = new MessageFormat("NEVER_USED", 5, null);
        NEVER_USED = r19;
        MessageFormat r110 = new MessageFormat("BOOLEAN", 6, ValueType.BOOLEAN);
        BOOLEAN = r110;
        ValueType r111 = ValueType.BINARY;
        MessageFormat r112 = new MessageFormat("BIN8", 7, r111);
        BIN8 = r112;
        MessageFormat r20 = new MessageFormat("BIN16", 8, r111);
        BIN16 = r20;
        MessageFormat r21 = new MessageFormat("BIN32", 9, r111);
        BIN32 = r21;
        ValueType r113 = ValueType.EXTENSION;
        MessageFormat r22 = new MessageFormat("EXT8", 10, r113);
        EXT8 = r22;
        MessageFormat r23 = new MessageFormat("EXT16", 11, r113);
        EXT16 = r23;
        MessageFormat r24 = new MessageFormat("EXT32", 12, r113);
        EXT32 = r24;
        ValueType r25 = ValueType.FLOAT;
        MessageFormat r26 = new MessageFormat("FLOAT32", 13, r25);
        FLOAT32 = r26;
        MessageFormat r27 = new MessageFormat("FLOAT64", 14, r25);
        FLOAT64 = r27;
        MessageFormat r28 = new MessageFormat("UINT8", 15, r10);
        UINT8 = r28;
        MessageFormat r114 = new MessageFormat("UINT16", 16, r10);
        UINT16 = r114;
        MessageFormat r29 = new MessageFormat("UINT32", 17, r10);
        UINT32 = r29;
        MessageFormat r30 = new MessageFormat("UINT64", 18, r10);
        UINT64 = r30;
        MessageFormat r115 = new MessageFormat("INT8", 19, r10);
        INT8 = r115;
        MessageFormat r31 = new MessageFormat("INT16", 20, r10);
        INT16 = r31;
        MessageFormat r32 = new MessageFormat("INT32", 21, r10);
        INT32 = r32;
        MessageFormat r116 = new MessageFormat("INT64", 22, r10);
        INT64 = r116;
        MessageFormat r33 = new MessageFormat("FIXEXT1", 23, r113);
        FIXEXT1 = r33;
        MessageFormat r34 = new MessageFormat("FIXEXT2", 24, r113);
        FIXEXT2 = r34;
        MessageFormat r35 = new MessageFormat("FIXEXT4", 25, r113);
        FIXEXT4 = r35;
        MessageFormat r36 = new MessageFormat("FIXEXT8", 26, r113);
        FIXEXT8 = r36;
        MessageFormat r37 = new MessageFormat("FIXEXT16", 27, r113);
        FIXEXT16 = r37;
        MessageFormat r38 = new MessageFormat("STR8", 28, r16);
        STR8 = r38;
        MessageFormat r117 = new MessageFormat("STR16", 29, r16);
        STR16 = r117;
        MessageFormat r39 = new MessageFormat("STR32", 30, r16);
        STR32 = r39;
        MessageFormat r118 = new MessageFormat("ARRAY16", 31, r14);
        ARRAY16 = r118;
        MessageFormat r119 = new MessageFormat("ARRAY32", 32, r14);
        ARRAY32 = r119;
        MessageFormat r40 = new MessageFormat("MAP16", 33, r12);
        MAP16 = r40;
        MessageFormat r120 = new MessageFormat("MAP32", 34, r12);
        MAP32 = r120;
        MessageFormat r41 = new MessageFormat("NEGFIXINT", 35, r10);
        NEGFIXINT = r41;
        $VALUES = new MessageFormat[]{r11, r13, r15, r17, r18, r19, r110, r112, r20, r21, r22, r23, r24, r26, r27, r28, r114, r29, r30, r115, r31, r32, r116, r33, r34, r35, r36, r37, r38, r117, r39, r118, r119, r40, r120, r41};
        formatTable = new MessageFormat[256];
        int r42 = 0;
    L4:
        if (r42 > 255) goto L6;
        formatTable[r42] = toMessageFormat((byte) r42);
        r42 = r42 + 1;
        goto L4
    }

    private MessageFormat(String r10, int r11, ValueType r12) {
        super(r10, r11);
        this.valueType = r12;
    }

    @VisibleForTesting
    static MessageFormat toMessageFormat(byte r10) {
        if (MessagePack.Code.isPosFixInt(r10) == false) goto L7;
        return POSFIXINT;
    L7:
        if (MessagePack.Code.isNegFixInt(r10) == false) goto L11;
        return NEGFIXINT;
    L11:
        if (MessagePack.Code.isFixStr(r10) == false) goto L15;
        return FIXSTR;
    L15:
        if (MessagePack.Code.isFixedArray(r10) == false) goto L19;
        return FIXARRAY;
    L19:
        if (MessagePack.Code.isFixedMap(r10) == true) goto L21;
        switch(r10) {
            case -64: goto L84;
            case -63: goto L24;
            case -62: goto L82;
            case -61: goto L82;
            case -60: goto L80;
            case -59: goto L78;
            case -58: goto L76;
            case -57: goto L74;
            case -56: goto L72;
            case -55: goto L70;
            case -54: goto L68;
            case -53: goto L66;
            case -52: goto L64;
            case -51: goto L62;
            case -50: goto L60;
            case -49: goto L58;
            case -48: goto L56;
            case -47: goto L54;
            case -46: goto L52;
            case -45: goto L50;
            case -44: goto L48;
            case -43: goto L46;
            case -42: goto L44;
            case -41: goto L42;
            case -40: goto L40;
            case -39: goto L38;
            case -38: goto L36;
            case -37: goto L34;
            case -36: goto L32;
            case -35: goto L30;
            case -34: goto L28;
            case -33: goto L26;
            default: goto L24;
        };
    L24:
        return NEVER_USED;
    L26:
        return MAP32;
    L28:
        return MAP16;
    L30:
        return ARRAY32;
    L32:
        return ARRAY16;
    L34:
        return STR32;
    L36:
        return STR16;
    L38:
        return STR8;
    L40:
        return FIXEXT16;
    L42:
        return FIXEXT8;
    L44:
        return FIXEXT4;
    L46:
        return FIXEXT2;
    L48:
        return FIXEXT1;
    L50:
        return INT64;
    L52:
        return INT32;
    L54:
        return INT16;
    L56:
        return INT8;
    L58:
        return UINT64;
    L60:
        return UINT32;
    L62:
        return UINT16;
    L64:
        return UINT8;
    L66:
        return FLOAT64;
    L68:
        return FLOAT32;
    L70:
        return EXT32;
    L72:
        return EXT16;
    L74:
        return EXT8;
    L76:
        return BIN32;
    L78:
        return BIN16;
    L80:
        return BIN8;
    L82:
        return BOOLEAN;
    L84:
        return NIL;
    L21:
        return FIXMAP;
    }

    public static MessageFormat valueOf(byte r10) {
        return formatTable[r10 & 255];
    }

    public static MessageFormat valueOf(String r10) {
        return (MessageFormat) Enum.valueOf(MessageFormat.class, r10);
    }

    public static MessageFormat[] values() {
        return (MessageFormat[]) $VALUES.clone();
    }

    public ValueType getValueType() {
        if (this == NEVER_USED) goto L7;
        return this.valueType;
    L7:
        throw new MessageFormatException("Cannot convert NEVER_USED to ValueType");
    }
}
