package org.msgpack.core;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.msgpack.value.ValueType;

/* JADX INFO: loaded from: classes7.dex */
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
        MessageFormat r0 = new MessageFormat("POSFIXINT", 0, ValueType.INTEGER);
        POSFIXINT = r0;
        MessageFormat r1 = new MessageFormat("FIXMAP", 1, ValueType.MAP);
        FIXMAP = r1;
        MessageFormat r2 = new MessageFormat("FIXARRAY", 2, ValueType.ARRAY);
        FIXARRAY = r2;
        MessageFormat r4 = new MessageFormat("FIXSTR", 3, ValueType.STRING);
        FIXSTR = r4;
        MessageFormat r6 = new MessageFormat("NIL", 4, ValueType.NIL);
        NIL = r6;
        MessageFormat r8 = new MessageFormat("NEVER_USED", 5, null);
        NEVER_USED = r8;
        MessageFormat r10 = new MessageFormat("BOOLEAN", 6, ValueType.BOOLEAN);
        BOOLEAN = r10;
        MessageFormat r13 = new MessageFormat("BIN8", 7, ValueType.BINARY);
        BIN8 = r13;
        MessageFormat r14 = new MessageFormat("BIN16", 8, ValueType.BINARY);
        BIN16 = r14;
        MessageFormat r12 = new MessageFormat("BIN32", 9, ValueType.BINARY);
        BIN32 = r12;
        MessageFormat r11 = new MessageFormat("EXT8", 10, ValueType.EXTENSION);
        EXT8 = r11;
        MessageFormat r9 = new MessageFormat("EXT16", 11, ValueType.EXTENSION);
        EXT16 = r9;
        MessageFormat r7 = new MessageFormat("EXT32", 12, ValueType.EXTENSION);
        EXT32 = r7;
        MessageFormat r5 = new MessageFormat("FLOAT32", 13, ValueType.FLOAT);
        FLOAT32 = r5;
        MessageFormat r3 = new MessageFormat("FLOAT64", 14, ValueType.FLOAT);
        FLOAT64 = r3;
        MessageFormat r15 = new MessageFormat("UINT8", 15, ValueType.INTEGER);
        UINT8 = r15;
        MessageFormat r16 = new MessageFormat("UINT16", 16, ValueType.INTEGER);
        UINT16 = r16;
        MessageFormat r17 = new MessageFormat("UINT32", 17, ValueType.INTEGER);
        UINT32 = r17;
        MessageFormat r18 = new MessageFormat("UINT64", 18, ValueType.INTEGER);
        UINT64 = r18;
        MessageFormat r19 = new MessageFormat("INT8", 19, ValueType.INTEGER);
        INT8 = r19;
        MessageFormat r20 = new MessageFormat("INT16", 20, ValueType.INTEGER);
        INT16 = r20;
        MessageFormat r21 = new MessageFormat("INT32", 21, ValueType.INTEGER);
        INT32 = r21;
        MessageFormat r22 = new MessageFormat("INT64", 22, ValueType.INTEGER);
        INT64 = r22;
        MessageFormat r23 = new MessageFormat("FIXEXT1", 23, ValueType.EXTENSION);
        FIXEXT1 = r23;
        MessageFormat r24 = new MessageFormat("FIXEXT2", 24, ValueType.EXTENSION);
        FIXEXT2 = r24;
        MessageFormat r25 = new MessageFormat("FIXEXT4", 25, ValueType.EXTENSION);
        FIXEXT4 = r25;
        MessageFormat r26 = new MessageFormat("FIXEXT8", 26, ValueType.EXTENSION);
        FIXEXT8 = r26;
        MessageFormat r27 = new MessageFormat("FIXEXT16", 27, ValueType.EXTENSION);
        FIXEXT16 = r27;
        MessageFormat r28 = new MessageFormat("STR8", 28, ValueType.STRING);
        STR8 = r28;
        MessageFormat r29 = new MessageFormat("STR16", 29, ValueType.STRING);
        STR16 = r29;
        MessageFormat r30 = new MessageFormat("STR32", 30, ValueType.STRING);
        STR32 = r30;
        MessageFormat r31 = new MessageFormat("ARRAY16", 31, ValueType.ARRAY);
        ARRAY16 = r31;
        MessageFormat r32 = new MessageFormat("ARRAY32", 32, ValueType.ARRAY);
        ARRAY32 = r32;
        MessageFormat r33 = new MessageFormat("MAP16", 33, ValueType.MAP);
        MAP16 = r33;
        MessageFormat r34 = new MessageFormat("MAP32", 34, ValueType.MAP);
        MAP32 = r34;
        MessageFormat r35 = new MessageFormat("NEGFIXINT", 35, ValueType.INTEGER);
        NEGFIXINT = r35;
        $VALUES = new MessageFormat[]{r0, r1, r2, r4, r6, r8, r10, r13, r14, r12, r11, r9, r7, r5, r3, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35};
        formatTable = new MessageFormat[256];
        int r36 = 0;
    L4:
        if (r36 > 255) goto L6;
        formatTable[r36] = toMessageFormat((byte) r36);
        r36 = r36 + 1;
        goto L4
    }

    private MessageFormat(String r1, int r2, ValueType r3) {
        super(r1, r2);
        this.valueType = r3;
    }

    static MessageFormat toMessageFormat(byte r1) {
        if (MessagePack.Code.isPosFixInt(r1) == false) goto L7;
        return POSFIXINT;
    L7:
        if (MessagePack.Code.isNegFixInt(r1) == false) goto L11;
        return NEGFIXINT;
    L11:
        if (MessagePack.Code.isFixStr(r1) == false) goto L15;
        return FIXSTR;
    L15:
        if (MessagePack.Code.isFixedArray(r1) == false) goto L19;
        return FIXARRAY;
    L19:
        if (MessagePack.Code.isFixedMap(r1) == true) goto L21;
        switch(r1) {
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

    public static MessageFormat valueOf(byte r1) {
        return formatTable[r1 & 255];
    }

    public static MessageFormat valueOf(String r2) {
        return (MessageFormat) ZeusTransformUtils.preCheckCast(Enum.valueOf(MessageFormat.class, r2), MessageFormat.class, "com.obric.memorydata.plugin");
    }

    public static MessageFormat[] values() {
        return (MessageFormat[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MessageFormat[].class, "com.obric.memorydata.plugin");
    }

    public ValueType getValueType() {
        if (this == NEVER_USED) goto L7;
        return this.valueType;
    L7:
        throw new MessageFormatException("Cannot convert NEVER_USED to ValueType");
    }
}
