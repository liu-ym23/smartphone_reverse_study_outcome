package com.google.protobuf;

/* JADX INFO: loaded from: classes.dex */
@CheckReturnValue
abstract class UnknownFieldSchema<T, B> {
    static final int DEFAULT_RECURSION_LIMIT = 100;
    private static volatile int recursionLimit = 100;

    public UnknownFieldSchema() {
    }

    private final void mergeFrom(B r8, Reader r10, int r11) {
    L3:
        if (r10.getFieldNumber() == Integer.MAX_VALUE) goto L6;
        if (mergeOneFieldFrom(r8, r10, r11) == true) goto L3;
        return;
    }

    public abstract void addFixed32(B r8, int r10, int r11);

    public abstract void addFixed64(B r8, int r10, long r11);

    public abstract void addGroup(B r8, int r10, T r11);

    public abstract void addLengthDelimited(B r8, int r10, ByteString r11);

    public abstract void addVarint(B r8, int r10, long r11);

    public abstract B getBuilderFromMessage(Object r8);

    public abstract T getFromMessage(Object r8);

    public abstract int getSerializedSize(T r8);

    public abstract int getSerializedSizeAsMessageSet(T r8);

    public abstract void makeImmutable(Object r8);

    public abstract T merge(T r8, T r10);

    public final boolean mergeOneFieldFrom(B r8, Reader r10, int r11) {
        int r12 = r10.getTag();
        int r13 = WireFormat.getTagFieldNumber(r12);
        int r14 = WireFormat.getTagWireType(r12);
        if (r14 == 0) goto L35;
        if (r14 != 1) goto L6;
        addFixed64(r8, r13, r10.readFixed64());
        return true;
    L6:
        if (r14 != 2) goto L8;
        addLengthDelimited(r8, r13, r10.readBytes());
        return true;
    L8:
        if (r14 == 3) goto L21;
        if (r14 != 4) goto L11;
        if (r11 == 0) goto L20;
        return false;
    L20:
        throw InvalidProtocolBufferException.invalidEndTag();
    L11:
        if (r14 != 5) goto L15;
        addFixed32(r8, r13, r10.readFixed32());
        return true;
    L15:
        throw InvalidProtocolBufferException.invalidWireType();
    L21:
        B r15 = newBuilder();
        int r16 = WireFormat.makeTag(r13, 4);
        int r17 = r11 + 1;
        if (r17 >= recursionLimit) goto L30;
        mergeFrom(r15, r10, r17);
        if (r16 != r10.getTag()) goto L28;
        addGroup(r8, r13, toImmutable(r15));
        return true;
    L28:
        throw InvalidProtocolBufferException.invalidEndTag();
    L30:
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    L35:
        addVarint(r8, r13, r10.readInt64());
        return true;
    }

    public abstract B newBuilder();

    public abstract void setBuilderToMessage(Object r8, B r10);

    public void setRecursionLimit(int r8) {
        recursionLimit = r8;
    }

    public abstract void setToMessage(Object r8, T r10);

    public abstract boolean shouldDiscardUnknownFields(Reader r8);

    public abstract T toImmutable(B r8);

    public abstract void writeAsMessageSetTo(T r8, Writer r10);

    public abstract void writeTo(T r8, Writer r10);
}
