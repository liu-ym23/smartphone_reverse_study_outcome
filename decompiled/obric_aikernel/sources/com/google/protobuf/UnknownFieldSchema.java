package com.google.protobuf;

/* JADX INFO: loaded from: classes2.dex */
@CheckReturnValue
abstract class UnknownFieldSchema<T, B> {
    static final int DEFAULT_RECURSION_LIMIT = 100;
    private static volatile int recursionLimit = 100;

    static {
    }

    UnknownFieldSchema() {
    }

    private final void mergeFrom(B r10, Reader r11, int r12) {
    L3:
        if (r11.getFieldNumber() == Integer.MAX_VALUE) goto L6;
        if (mergeOneFieldFrom(r10, r11, r12) == true) goto L3;
        return;
    }

    abstract void addFixed32(B r10, int r11, int r12);

    abstract void addFixed64(B r10, int r11, long r12);

    abstract void addGroup(B r10, int r11, T r12);

    abstract void addLengthDelimited(B r10, int r11, ByteString r12);

    abstract void addVarint(B r10, int r11, long r12);

    abstract B getBuilderFromMessage(Object r10);

    abstract T getFromMessage(Object r10);

    abstract int getSerializedSize(T r10);

    abstract int getSerializedSizeAsMessageSet(T r10);

    abstract void makeImmutable(Object r10);

    abstract T merge(T r10, T r11);

    final boolean mergeOneFieldFrom(B r10, Reader r11, int r12) {
        int r13 = r11.getTag();
        int r14 = WireFormat.getTagFieldNumber(r13);
        int r15 = WireFormat.getTagWireType(r13);
        if (r15 == 0) goto L35;
        if (r15 != 1) goto L6;
        addFixed64(r10, r14, r11.readFixed64());
        return true;
    L6:
        if (r15 != 2) goto L8;
        addLengthDelimited(r10, r14, r11.readBytes());
        return true;
    L8:
        if (r15 == 3) goto L21;
        if (r15 != 4) goto L11;
        if (r12 == 0) goto L20;
        return false;
    L20:
        throw InvalidProtocolBufferException.invalidEndTag();
    L11:
        if (r15 != 5) goto L15;
        addFixed32(r10, r14, r11.readFixed32());
        return true;
    L15:
        throw InvalidProtocolBufferException.invalidWireType();
    L21:
        B r16 = newBuilder();
        int r17 = WireFormat.makeTag(r14, 4);
        int r18 = r12 + 1;
        if (r18 >= recursionLimit) goto L30;
        mergeFrom(r16, r11, r18);
        if (r17 != r11.getTag()) goto L28;
        addGroup(r10, r14, toImmutable(r16));
        return true;
    L28:
        throw InvalidProtocolBufferException.invalidEndTag();
    L30:
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    L35:
        addVarint(r10, r14, r11.readInt64());
        return true;
    }

    abstract B newBuilder();

    abstract void setBuilderToMessage(Object r10, B r11);

    public void setRecursionLimit(int r10) {
        recursionLimit = r10;
    }

    abstract void setToMessage(Object r10, T r11);

    abstract boolean shouldDiscardUnknownFields(Reader r10);

    abstract T toImmutable(B r10);

    abstract void writeAsMessageSetTo(T r10, Writer r11);

    abstract void writeTo(T r10, Writer r11);
}
