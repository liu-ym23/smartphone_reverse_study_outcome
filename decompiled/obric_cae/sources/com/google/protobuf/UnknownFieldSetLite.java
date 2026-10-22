package com.google.protobuf;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
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

    private void ensureCapacity(int r8) {
        int[] r10 = this.tags;
        if (r8 <= r10.length) goto L13;
        int r11 = this.count;
        int r12 = (r11 / 2) + r11;
        if (r12 < r8) goto L9;
        r8 = r12;
    L9:
        if (r8 >= 8) goto L11;
        r8 = 8;
    L11:
        this.tags = Arrays.copyOf(r10, r8);
        this.objects = Arrays.copyOf(this.objects, r8);
        return;
    }

    public static UnknownFieldSetLite getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private UnknownFieldSetLite mergeFrom(CodedInputStream r8) {
    L2:
        int r10 = r8.readTag();
        if (r10 == 0) goto L6;
        if (mergeFieldFrom(r10, r8) == true) goto L2;
    L6:
        return this;
    }

    public static UnknownFieldSetLite mutableCopyOf(UnknownFieldSetLite r8, UnknownFieldSetLite r10) {
        int r11 = r8.count + r10.count;
        int[] r12 = Arrays.copyOf(r8.tags, r11);
        System.arraycopy(r10.tags, 0, r12, r8.count, r10.count);
        Object[] r13 = Arrays.copyOf(r8.objects, r11);
        System.arraycopy(r10.objects, 0, r13, r8.count, r10.count);
        return new UnknownFieldSetLite(r11, r12, r13, true);
    }

    public static UnknownFieldSetLite newInstance() {
        return new UnknownFieldSetLite();
    }

    private static boolean objectsEquals(Object[] r8, Object[] r10, int r11) {
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L8;
        if (r8[r12].equals(r10[r12]) == false) goto L6;
        r12 = r12 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    private static boolean tagsEquals(int[] r8, int[] r10, int r11) {
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L8;
        if (r8[r12] != r10[r12]) goto L6;
        r12 = r12 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    private static void writeField(int r8, Object r10, Writer r11) {
        int r12 = WireFormat.getTagFieldNumber(r8);
        int r13 = WireFormat.getTagWireType(r8);
        if (r13 != 0) goto L5;
        r11.writeInt64(r12, ((Long) r10).longValue());
        return;
    L5:
        if (r13 != 1) goto L7;
        r11.writeFixed64(r12, ((Long) r10).longValue());
        return;
    L7:
        if (r13 != 2) goto L9;
        r11.writeBytes(r12, (ByteString) r10);
        return;
    L9:
        if (r13 == 3) goto L16;
        if (r13 != 5) goto L14;
        r11.writeFixed32(r12, ((Integer) r10).intValue());
        return;
    L14:
        throw new RuntimeException(InvalidProtocolBufferException.invalidWireType());
    L16:
        if (r11.fieldOrder() != Writer.FieldOrder.ASCENDING) goto L18;
        r11.writeStartGroup(r12);
        ((UnknownFieldSetLite) r10).writeTo(r11);
        r11.writeEndGroup(r12);
        return;
    L18:
        r11.writeEndGroup(r12);
        ((UnknownFieldSetLite) r10).writeTo(r11);
        r11.writeStartGroup(r12);
    }

    public void checkMutable() {
        if (this.isMutable == false) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException();
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if (r8 != null) goto L9;
        return false;
    L9:
        if ((r8 instanceof UnknownFieldSetLite) == true) goto L11;
        return false;
    L11:
        UnknownFieldSetLite r10 = (UnknownFieldSetLite) r8;
        int r11 = this.count;
        if (r11 == r10.count) goto L14;
    L19:
        return false;
    L14:
        if (tagsEquals(this.tags, r10.tags, r11) == false) goto L19;
        if (objectsEquals(this.objects, r10.objects, this.count) == false) goto L19;
        return true;
    }

    public int getSerializedSize() {
        int r8 = this.memoizedSerializedSize;
        if (r8 == (-1)) goto L5;
        return r8;
    L5:
        int r10 = 0;
        int r11 = 0;
    L7:
        if (r10 >= this.count) goto L27;
        int r12 = this.tags[r10];
        int r13 = WireFormat.getTagFieldNumber(r12);
        int r14 = WireFormat.getTagWireType(r12);
        if (r14 != 0) goto L11;
        int r15 = CodedOutputStream.computeUInt64Size(r13, ((Long) this.objects[r10]).longValue());
    L25:
        r11 = r15 + r11;
    L26:
        r10 = r10 + 1;
        goto L7
    L11:
        if (r14 != 1) goto L13;
        r15 = CodedOutputStream.computeFixed64Size(r13, ((Long) this.objects[r10]).longValue());
        goto L25
    L13:
        if (r14 != 2) goto L15;
        r15 = CodedOutputStream.computeBytesSize(r13, (ByteString) this.objects[r10]);
        goto L25
    L15:
        if (r14 != 3) goto L17;
        r11 = (((UnknownFieldSetLite) this.objects[r10]).getSerializedSize() + (CodedOutputStream.computeTagSize(r13) * 2)) + r11;
        goto L26
    L17:
        if (r14 != 5) goto L20;
        r15 = CodedOutputStream.computeFixed32Size(r13, ((Integer) this.objects[r10]).intValue());
        goto L25
    L20:
        throw new IllegalStateException(InvalidProtocolBufferException.invalidWireType());
    L27:
        this.memoizedSerializedSize = r11;
        return r11;
    }

    public int getSerializedSizeAsMessageSet() {
        int r8 = this.memoizedSerializedSize;
        if (r8 == (-1)) goto L5;
        return r8;
    L5:
        int r10 = 0;
        int r11 = 0;
    L7:
        if (r10 >= this.count) goto L9;
        r11 = r11 + CodedOutputStream.computeRawMessageSetExtensionSize(WireFormat.getTagFieldNumber(this.tags[r10]), (ByteString) this.objects[r10]);
        r10 = r10 + 1;
        goto L7
    L9:
        this.memoizedSerializedSize = r11;
        return r11;
    }

    public int hashCode() {
        int r8 = this.count;
        return ((((527 + r8) * 31) + hashCode(this.tags, r8)) * 31) + hashCode(this.objects, this.count);
    }

    public void makeImmutable() {
        if (this.isMutable == false) goto L6;
        this.isMutable = false;
        return;
    }

    public boolean mergeFieldFrom(int r8, CodedInputStream r10) {
        checkMutable();
        int r11 = WireFormat.getTagFieldNumber(r8);
        int r12 = WireFormat.getTagWireType(r8);
        if (r12 == 0) goto L24;
        if (r12 != 1) goto L6;
        storeField(r8, Long.valueOf(r10.readFixed64()));
        return true;
    L6:
        if (r12 != 2) goto L8;
        storeField(r8, r10.readBytes());
        return true;
    L8:
        if (r12 == 3) goto L18;
        if (r12 != 4) goto L11;
        r10.checkValidEndTag();
        return false;
    L11:
        if (r12 != 5) goto L15;
        storeField(r8, Integer.valueOf(r10.readFixed32()));
        return true;
    L15:
        throw InvalidProtocolBufferException.invalidWireType();
    L18:
        UnknownFieldSetLite r13 = new UnknownFieldSetLite();
        r13.mergeFrom(r10);
        r10.checkLastTagWas(WireFormat.makeTag(r11, 4));
        storeField(r8, r13);
        return true;
    L24:
        storeField(r8, Long.valueOf(r10.readInt64()));
        return true;
    }

    public UnknownFieldSetLite mergeLengthDelimitedField(int r8, ByteString r10) {
        checkMutable();
        if (r8 == 0) goto L7;
        storeField(WireFormat.makeTag(r8, 2), r10);
        return this;
    L7:
        throw new IllegalArgumentException("Zero is not a valid field number.");
    }

    public UnknownFieldSetLite mergeVarintField(int r8, int r10) {
        checkMutable();
        if (r8 == 0) goto L7;
        storeField(WireFormat.makeTag(r8, 0), Long.valueOf(r10));
        return this;
    L7:
        throw new IllegalArgumentException("Zero is not a valid field number.");
    }

    public final void printWithIndent(StringBuilder r8, int r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.count) goto L6;
        MessageLiteToString.printField(r8, r10, String.valueOf(WireFormat.getTagFieldNumber(this.tags[r11])), this.objects[r11]);
        r11 = r11 + 1;
        goto L4
    }

    public void storeField(int r8, Object r10) {
        checkMutable();
        ensureCapacity(this.count + 1);
        int[] r11 = this.tags;
        int r12 = this.count;
        r11[r12] = r8;
        this.objects[r12] = r10;
        this.count = r12 + 1;
    }

    public void writeAsMessageSetTo(CodedOutputStream r8) {
        int r10 = 0;
    L4:
        if (r10 >= this.count) goto L6;
        r8.writeRawMessageSetExtension(WireFormat.getTagFieldNumber(this.tags[r10]), (ByteString) this.objects[r10]);
        r10 = r10 + 1;
        goto L4
    }

    public void writeTo(CodedOutputStream r8) {
        int r10 = 0;
    L4:
        if (r10 >= this.count) goto L23;
        int r11 = this.tags[r10];
        int r12 = WireFormat.getTagFieldNumber(r11);
        int r13 = WireFormat.getTagWireType(r11);
        if (r13 != 0) goto L8;
        r8.writeUInt64(r12, ((Long) this.objects[r10]).longValue());
    L22:
        r10 = r10 + 1;
        goto L4
    L8:
        if (r13 != 1) goto L10;
        r8.writeFixed64(r12, ((Long) this.objects[r10]).longValue());
        goto L22
    L10:
        if (r13 != 2) goto L12;
        r8.writeBytes(r12, (ByteString) this.objects[r10]);
        goto L22
    L12:
        if (r13 != 3) goto L14;
        r8.writeTag(r12, 3);
        ((UnknownFieldSetLite) this.objects[r10]).writeTo(r8);
        r8.writeTag(r12, 4);
        goto L22
    L14:
        if (r13 != 5) goto L17;
        r8.writeFixed32(r12, ((Integer) this.objects[r10]).intValue());
        goto L22
    L17:
        throw InvalidProtocolBufferException.invalidWireType();
    }

    private UnknownFieldSetLite(int r8, int[] r10, Object[] r11, boolean r12) {
        this.memoizedSerializedSize = -1;
        this.count = r8;
        this.tags = r10;
        this.objects = r11;
        this.isMutable = r12;
    }

    private static int hashCode(int[] r8, int r10) {
        int r11 = 17;
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L5;
        r11 = (r11 * 31) + r8[r12];
        r12 = r12 + 1;
        goto L3
    L5:
        return r11;
    }

    @CanIgnoreReturnValue
    public UnknownFieldSetLite mergeFrom(UnknownFieldSetLite r8) {
        if (r8.equals(getDefaultInstance()) == false) goto L5;
        return this;
    L5:
        checkMutable();
        int r10 = this.count + r8.count;
        ensureCapacity(r10);
        System.arraycopy(r8.tags, 0, this.tags, this.count, r8.count);
        System.arraycopy(r8.objects, 0, this.objects, this.count, r8.count);
        this.count = r10;
        return this;
    }

    public void writeAsMessageSetTo(Writer r8) {
        if (r8.fieldOrder() != Writer.FieldOrder.DESCENDING) goto L7;
        int r10 = this.count - 1;
    L5:
        if (r10 < 0) goto L11;
        r8.writeMessageSetItem(WireFormat.getTagFieldNumber(this.tags[r10]), this.objects[r10]);
        r10 = r10 - 1;
        goto L5
    L11:
        return;
    L7:
        int r11 = 0;
    L9:
        if (r11 >= this.count) goto L14;
        r8.writeMessageSetItem(WireFormat.getTagFieldNumber(this.tags[r11]), this.objects[r11]);
        r11 = r11 + 1;
        goto L9
    }

    public void writeTo(Writer r8) {
        if (this.count != 0) goto L6;
        return;
    L6:
        if (r8.fieldOrder() != Writer.FieldOrder.ASCENDING) goto L11;
        int r10 = 0;
    L9:
        if (r10 >= this.count) goto L14;
        writeField(this.tags[r10], this.objects[r10], r8);
        r10 = r10 + 1;
        goto L9
    L14:
        return;
    L11:
        int r11 = this.count - 1;
    L12:
        if (r11 < 0) goto L17;
        writeField(this.tags[r11], this.objects[r11], r8);
        r11 = r11 - 1;
        goto L12
    }

    private static int hashCode(Object[] r8, int r10) {
        int r11 = 17;
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L5;
        r11 = (r11 * 31) + r8[r12].hashCode();
        r12 = r12 + 1;
        goto L3
    L5:
        return r11;
    }
}
