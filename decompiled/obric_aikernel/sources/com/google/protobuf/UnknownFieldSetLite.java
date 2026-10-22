package com.google.protobuf;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class UnknownFieldSetLite {
    private static final UnknownFieldSetLite DEFAULT_INSTANCE = null;
    private static final int MIN_CAPACITY = 8;
    private int count;
    private boolean isMutable;
    private int memoizedSerializedSize;
    private Object[] objects;
    private int[] tags;

    static {
        DEFAULT_INSTANCE = new UnknownFieldSetLite(0, new int[0], new Object[0], false);
    }

    private UnknownFieldSetLite() {
        this(0, new int[8], new Object[8], true);
    }

    private UnknownFieldSetLite(int r10, int[] r11, Object[] r12, boolean r13) {
        this.memoizedSerializedSize = -1;
        this.count = r10;
        this.tags = r11;
        this.objects = r12;
        this.isMutable = r13;
    }

    private void ensureCapacity(int r10) {
        int[] r11 = this.tags;
        if (r10 <= r11.length) goto L13;
        int r12 = this.count;
        int r13 = r12 + (r12 / 2);
        if (r13 < r10) goto L9;
        r10 = r13;
    L9:
        if (r10 >= 8) goto L11;
        r10 = 8;
    L11:
        this.tags = Arrays.copyOf(r11, r10);
        this.objects = Arrays.copyOf(this.objects, r10);
        return;
    }

    public static UnknownFieldSetLite getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private static int hashCode(int[] r10, int r11) {
        int r12 = 17;
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L5;
        r12 = (r12 * 31) + r10[r13];
        r13 = r13 + 1;
        goto L3
    L5:
        return r12;
    }

    private static int hashCode(Object[] r10, int r11) {
        int r12 = 17;
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L5;
        r12 = (r12 * 31) + r10[r13].hashCode();
        r13 = r13 + 1;
        goto L3
    L5:
        return r12;
    }

    private UnknownFieldSetLite mergeFrom(CodedInputStream r10) {
    L2:
        int r11 = r10.readTag();
        if (r11 == 0) goto L6;
        if (mergeFieldFrom(r11, r10) == true) goto L2;
    L6:
        return this;
    }

    static UnknownFieldSetLite mutableCopyOf(UnknownFieldSetLite r10, UnknownFieldSetLite r11) {
        int r12 = r10.count + r11.count;
        int[] r13 = Arrays.copyOf(r10.tags, r12);
        System.arraycopy(r11.tags, 0, r13, r10.count, r11.count);
        Object[] r14 = Arrays.copyOf(r10.objects, r12);
        System.arraycopy(r11.objects, 0, r14, r10.count, r11.count);
        return new UnknownFieldSetLite(r12, r13, r14, true);
    }

    static UnknownFieldSetLite newInstance() {
        return new UnknownFieldSetLite();
    }

    private static boolean objectsEquals(Object[] r10, Object[] r11, int r12) {
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        if (r10[r13].equals(r11[r13]) == false) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    private static boolean tagsEquals(int[] r10, int[] r11, int r12) {
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        if (r10[r13] != r11[r13]) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    private static void writeField(int r10, Object r11, Writer r12) {
        int r13 = WireFormat.getTagFieldNumber(r10);
        int r14 = WireFormat.getTagWireType(r10);
        if (r14 != 0) goto L5;
        r12.writeInt64(r13, ((Long) r11).longValue());
        return;
    L5:
        if (r14 != 1) goto L7;
        r12.writeFixed64(r13, ((Long) r11).longValue());
        return;
    L7:
        if (r14 != 2) goto L9;
        r12.writeBytes(r13, (ByteString) r11);
        return;
    L9:
        if (r14 == 3) goto L16;
        if (r14 != 5) goto L14;
        r12.writeFixed32(r13, ((Integer) r11).intValue());
        return;
    L14:
        throw new RuntimeException(InvalidProtocolBufferException.invalidWireType());
    L16:
        if (r12.fieldOrder() != Writer.FieldOrder.ASCENDING) goto L18;
        r12.writeStartGroup(r13);
        ((UnknownFieldSetLite) r11).writeTo(r12);
        r12.writeEndGroup(r13);
        return;
    L18:
        r12.writeEndGroup(r13);
        ((UnknownFieldSetLite) r11).writeTo(r12);
        r12.writeStartGroup(r13);
    }

    void checkMutable() {
        if (this.isMutable == false) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException();
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if (r10 != null) goto L9;
        return false;
    L9:
        if ((r10 instanceof UnknownFieldSetLite) == true) goto L11;
        return false;
    L11:
        UnknownFieldSetLite r11 = (UnknownFieldSetLite) r10;
        int r12 = this.count;
        if (r12 == r11.count) goto L14;
    L19:
        return false;
    L14:
        if (tagsEquals(this.tags, r11.tags, r12) == false) goto L19;
        if (objectsEquals(this.objects, r11.objects, this.count) == false) goto L19;
        return true;
    }

    public int getSerializedSize() {
        int r10 = this.memoizedSerializedSize;
        if (r10 == (-1)) goto L5;
        return r10;
    L5:
        int r11 = 0;
        int r12 = 0;
    L7:
        if (r11 >= this.count) goto L26;
        int r13 = this.tags[r11];
        int r14 = WireFormat.getTagFieldNumber(r13);
        int r15 = WireFormat.getTagWireType(r13);
        if (r15 != 0) goto L11;
        int r16 = CodedOutputStream.computeUInt64Size(r14, ((Long) this.objects[r11]).longValue());
    L25:
        r12 = r12 + r16;
        r11 = r11 + 1;
        goto L7
    L11:
        if (r15 != 1) goto L13;
        r16 = CodedOutputStream.computeFixed64Size(r14, ((Long) this.objects[r11]).longValue());
        goto L25
    L13:
        if (r15 != 2) goto L15;
        r16 = CodedOutputStream.computeBytesSize(r14, (ByteString) this.objects[r11]);
        goto L25
    L15:
        if (r15 != 3) goto L17;
        r16 = (CodedOutputStream.computeTagSize(r14) * 2) + ((UnknownFieldSetLite) this.objects[r11]).getSerializedSize();
        goto L25
    L17:
        if (r15 != 5) goto L20;
        r16 = CodedOutputStream.computeFixed32Size(r14, ((Integer) this.objects[r11]).intValue());
        goto L25
    L20:
        throw new IllegalStateException(InvalidProtocolBufferException.invalidWireType());
    L26:
        this.memoizedSerializedSize = r12;
        return r12;
    }

    public int getSerializedSizeAsMessageSet() {
        int r10 = this.memoizedSerializedSize;
        if (r10 == (-1)) goto L5;
        return r10;
    L5:
        int r11 = 0;
        int r12 = 0;
    L7:
        if (r11 >= this.count) goto L9;
        r12 = r12 + CodedOutputStream.computeRawMessageSetExtensionSize(WireFormat.getTagFieldNumber(this.tags[r11]), (ByteString) this.objects[r11]);
        r11 = r11 + 1;
        goto L7
    L9:
        this.memoizedSerializedSize = r12;
        return r12;
    }

    public int hashCode() {
        int r10 = this.count;
        return ((((527 + r10) * 31) + hashCode(this.tags, r10)) * 31) + hashCode(this.objects, this.count);
    }

    public void makeImmutable() {
        if (this.isMutable == false) goto L6;
        this.isMutable = false;
        return;
    }

    boolean mergeFieldFrom(int r10, CodedInputStream r11) {
        checkMutable();
        int r12 = WireFormat.getTagFieldNumber(r10);
        int r13 = WireFormat.getTagWireType(r10);
        if (r13 == 0) goto L24;
        if (r13 != 1) goto L6;
        storeField(r10, Long.valueOf(r11.readFixed64()));
        return true;
    L6:
        if (r13 != 2) goto L8;
        storeField(r10, r11.readBytes());
        return true;
    L8:
        if (r13 == 3) goto L18;
        if (r13 != 4) goto L11;
        r11.checkValidEndTag();
        return false;
    L11:
        if (r13 != 5) goto L15;
        storeField(r10, Integer.valueOf(r11.readFixed32()));
        return true;
    L15:
        throw InvalidProtocolBufferException.invalidWireType();
    L18:
        UnknownFieldSetLite r14 = new UnknownFieldSetLite();
        r14.mergeFrom(r11);
        r11.checkLastTagWas(WireFormat.makeTag(r12, 4));
        storeField(r10, r14);
        return true;
    L24:
        storeField(r10, Long.valueOf(r11.readInt64()));
        return true;
    }

    @CanIgnoreReturnValue
    UnknownFieldSetLite mergeFrom(UnknownFieldSetLite r10) {
        if (r10.equals(getDefaultInstance()) == false) goto L5;
        return this;
    L5:
        checkMutable();
        int r11 = this.count + r10.count;
        ensureCapacity(r11);
        System.arraycopy(r10.tags, 0, this.tags, this.count, r10.count);
        System.arraycopy(r10.objects, 0, this.objects, this.count, r10.count);
        this.count = r11;
        return this;
    }

    UnknownFieldSetLite mergeLengthDelimitedField(int r10, ByteString r11) {
        checkMutable();
        if (r10 == 0) goto L7;
        storeField(WireFormat.makeTag(r10, 2), r11);
        return this;
    L7:
        throw new IllegalArgumentException("Zero is not a valid field number.");
    }

    UnknownFieldSetLite mergeVarintField(int r10, int r11) {
        checkMutable();
        if (r10 == 0) goto L7;
        storeField(WireFormat.makeTag(r10, 0), Long.valueOf(r11));
        return this;
    L7:
        throw new IllegalArgumentException("Zero is not a valid field number.");
    }

    final void printWithIndent(StringBuilder r10, int r11) {
        int r12 = 0;
    L4:
        if (r12 >= this.count) goto L6;
        MessageLiteToString.printField(r10, r11, String.valueOf(WireFormat.getTagFieldNumber(this.tags[r12])), this.objects[r12]);
        r12 = r12 + 1;
        goto L4
    }

    void storeField(int r10, Object r11) {
        checkMutable();
        ensureCapacity(this.count + 1);
        int[] r12 = this.tags;
        int r13 = this.count;
        r12[r13] = r10;
        this.objects[r13] = r11;
        this.count = r13 + 1;
    }

    public void writeAsMessageSetTo(CodedOutputStream r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.count) goto L6;
        r10.writeRawMessageSetExtension(WireFormat.getTagFieldNumber(this.tags[r11]), (ByteString) this.objects[r11]);
        r11 = r11 + 1;
        goto L4
    }

    void writeAsMessageSetTo(Writer r10) {
        if (r10.fieldOrder() != Writer.FieldOrder.DESCENDING) goto L7;
        int r11 = this.count - 1;
    L5:
        if (r11 < 0) goto L11;
        r10.writeMessageSetItem(WireFormat.getTagFieldNumber(this.tags[r11]), this.objects[r11]);
        r11 = r11 - 1;
        goto L5
    L11:
        return;
    L7:
        int r12 = 0;
    L9:
        if (r12 >= this.count) goto L14;
        r10.writeMessageSetItem(WireFormat.getTagFieldNumber(this.tags[r12]), this.objects[r12]);
        r12 = r12 + 1;
        goto L9
    }

    public void writeTo(CodedOutputStream r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.count) goto L23;
        int r12 = this.tags[r11];
        int r13 = WireFormat.getTagFieldNumber(r12);
        int r14 = WireFormat.getTagWireType(r12);
        if (r14 != 0) goto L8;
        r10.writeUInt64(r13, ((Long) this.objects[r11]).longValue());
    L22:
        r11 = r11 + 1;
        goto L4
    L8:
        if (r14 != 1) goto L10;
        r10.writeFixed64(r13, ((Long) this.objects[r11]).longValue());
        goto L22
    L10:
        if (r14 != 2) goto L12;
        r10.writeBytes(r13, (ByteString) this.objects[r11]);
        goto L22
    L12:
        if (r14 != 3) goto L14;
        r10.writeTag(r13, 3);
        ((UnknownFieldSetLite) this.objects[r11]).writeTo(r10);
        r10.writeTag(r13, 4);
        goto L22
    L14:
        if (r14 != 5) goto L17;
        r10.writeFixed32(r13, ((Integer) this.objects[r11]).intValue());
        goto L22
    L17:
        throw InvalidProtocolBufferException.invalidWireType();
    }

    public void writeTo(Writer r10) {
        if (this.count != 0) goto L6;
        return;
    L6:
        if (r10.fieldOrder() != Writer.FieldOrder.ASCENDING) goto L11;
        int r11 = 0;
    L9:
        if (r11 >= this.count) goto L14;
        writeField(this.tags[r11], this.objects[r11], r10);
        r11 = r11 + 1;
        goto L9
    L14:
        return;
    L11:
        int r12 = this.count - 1;
    L12:
        if (r12 < 0) goto L17;
        writeField(this.tags[r12], this.objects[r12], r10);
        r12 = r12 - 1;
        goto L12
    }
}
