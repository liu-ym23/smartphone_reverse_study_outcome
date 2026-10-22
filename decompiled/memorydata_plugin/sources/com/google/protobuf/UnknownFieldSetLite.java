package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
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

    private UnknownFieldSetLite(int r2, int[] r3, Object[] r4, boolean r5) {
        this.memoizedSerializedSize = -1;
        this.count = r2;
        this.tags = r3;
        this.objects = r4;
        this.isMutable = r5;
    }

    private void ensureCapacity(int r4) {
        int[] r0 = this.tags;
        if (r4 <= r0.length) goto L13;
        int r1 = this.count;
        int r2 = r1 + (r1 / 2);
        if (r2 < r4) goto L9;
        r4 = r2;
    L9:
        if (r4 >= 8) goto L11;
        r4 = 8;
    L11:
        this.tags = Arrays.copyOf(r0, r4);
        this.objects = Arrays.copyOf(this.objects, r4);
        return;
    }

    public static UnknownFieldSetLite getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private static int hashCode(int[] r3, int r4) {
        int r0 = 17;
        int r1 = 0;
    L3:
        if (r1 >= r4) goto L5;
        r0 = (r0 * 31) + r3[r1];
        r1 = r1 + 1;
        goto L3
    L5:
        return r0;
    }

    private static int hashCode(Object[] r3, int r4) {
        int r0 = 17;
        int r1 = 0;
    L3:
        if (r1 >= r4) goto L5;
        r0 = (r0 * 31) + r3[r1].hashCode();
        r1 = r1 + 1;
        goto L3
    L5:
        return r0;
    }

    private UnknownFieldSetLite mergeFrom(CodedInputStream r2) {
    L2:
        int r0 = r2.readTag();
        if (r0 == 0) goto L6;
        if (mergeFieldFrom(r0, r2) == true) goto L2;
    L6:
        return this;
    }

    static UnknownFieldSetLite mutableCopyOf(UnknownFieldSetLite r6, UnknownFieldSetLite r7) {
        int r0 = r6.count + r7.count;
        int[] r1 = Arrays.copyOf(r6.tags, r0);
        System.arraycopy(r7.tags, 0, r1, r6.count, r7.count);
        Object[] r2 = Arrays.copyOf(r6.objects, r0);
        System.arraycopy(r7.objects, 0, r2, r6.count, r7.count);
        return new UnknownFieldSetLite(r0, r1, r2, true);
    }

    static UnknownFieldSetLite newInstance() {
        return new UnknownFieldSetLite();
    }

    private static boolean objectsEquals(Object[] r4, Object[] r5, int r6) {
        int r1 = 0;
    L3:
        if (r1 >= r6) goto L8;
        if (r4[r1].equals(r5[r1]) == false) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    private static boolean tagsEquals(int[] r4, int[] r5, int r6) {
        int r1 = 0;
    L3:
        if (r1 >= r6) goto L8;
        if (r4[r1] != r5[r1]) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    private static void writeField(int r4, Object r5, Writer r6) {
        Writer r7 = (Writer) ZeusTransformUtils.wrapperContextForParams(r6, Writer.class, "com.obric.memorydata.plugin");
        int r1 = WireFormat.getTagFieldNumber(r4);
        int r8 = WireFormat.getTagWireType(r4);
        if (r8 != 0) goto L5;
        r7.writeInt64(r1, ((Long) ZeusTransformUtils.preCheckCast(r5, Long.class, "com.obric.memorydata.plugin")).longValue());
        return;
    L5:
        if (r8 != 1) goto L7;
        r7.writeFixed64(r1, ((Long) ZeusTransformUtils.preCheckCast(r5, Long.class, "com.obric.memorydata.plugin")).longValue());
        return;
    L7:
        if (r8 != 2) goto L9;
        r7.writeBytes(r1, (ByteString) ZeusTransformUtils.preCheckCast(r5, ByteString.class, "com.obric.memorydata.plugin"));
        return;
    L9:
        if (r8 == 3) goto L16;
        if (r8 != 5) goto L14;
        r7.writeFixed32(r1, ((Integer) ZeusTransformUtils.preCheckCast(r5, Integer.class, "com.obric.memorydata.plugin")).intValue());
        return;
    L14:
        throw new RuntimeException(InvalidProtocolBufferException.invalidWireType());
    L16:
        if (r7.fieldOrder() != Writer.FieldOrder.ASCENDING) goto L18;
        r7.writeStartGroup(r1);
        ((UnknownFieldSetLite) ZeusTransformUtils.preCheckCast(r5, UnknownFieldSetLite.class, "com.obric.memorydata.plugin")).writeTo(r7);
        r7.writeEndGroup(r1);
        return;
    L18:
        r7.writeEndGroup(r1);
        ((UnknownFieldSetLite) ZeusTransformUtils.preCheckCast(r5, UnknownFieldSetLite.class, "com.obric.memorydata.plugin")).writeTo(r7);
        r7.writeStartGroup(r1);
    }

    void checkMutable() {
        if (this.isMutable == false) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException();
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L6;
        return true;
    L6:
        if (r6 != null) goto L9;
        return false;
    L9:
        if (ZeusTransformUtils.instanceOf(r6, UnknownFieldSetLite.class) == true) goto L11;
        return false;
    L11:
        UnknownFieldSetLite r7 = (UnknownFieldSetLite) ZeusTransformUtils.preCheckCast(r6, UnknownFieldSetLite.class, "com.obric.memorydata.plugin");
        int r0 = this.count;
        if (r0 == r7.count) goto L14;
    L19:
        return false;
    L14:
        if (tagsEquals(this.tags, r7.tags, r0) == false) goto L19;
        if (objectsEquals(this.objects, r7.objects, this.count) == false) goto L19;
        return true;
    }

    public int getSerializedSize() {
        int r0 = this.memoizedSerializedSize;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r1 = 0;
        int r2 = 0;
    L7:
        if (r1 >= this.count) goto L26;
        int r3 = this.tags[r1];
        int r4 = WireFormat.getTagFieldNumber(r3);
        int r5 = WireFormat.getTagWireType(r3);
        if (r5 != 0) goto L11;
        int r6 = CodedOutputStream.computeUInt64Size(r4, ((Long) ZeusTransformUtils.preCheckCast(this.objects[r1], Long.class, "com.obric.memorydata.plugin")).longValue());
    L25:
        r2 = r2 + r6;
        r1 = r1 + 1;
        goto L7
    L11:
        if (r5 != 1) goto L13;
        r6 = CodedOutputStream.computeFixed64Size(r4, ((Long) ZeusTransformUtils.preCheckCast(this.objects[r1], Long.class, "com.obric.memorydata.plugin")).longValue());
        goto L25
    L13:
        if (r5 != 2) goto L15;
        r6 = CodedOutputStream.computeBytesSize(r4, (ByteString) ZeusTransformUtils.preCheckCast(this.objects[r1], ByteString.class, "com.obric.memorydata.plugin"));
        goto L25
    L15:
        if (r5 != 3) goto L17;
        r6 = (CodedOutputStream.computeTagSize(r4) * 2) + ((UnknownFieldSetLite) ZeusTransformUtils.preCheckCast(this.objects[r1], UnknownFieldSetLite.class, "com.obric.memorydata.plugin")).getSerializedSize();
        goto L25
    L17:
        if (r5 != 5) goto L20;
        r6 = CodedOutputStream.computeFixed32Size(r4, ((Integer) ZeusTransformUtils.preCheckCast(this.objects[r1], Integer.class, "com.obric.memorydata.plugin")).intValue());
        goto L25
    L20:
        throw new IllegalStateException(InvalidProtocolBufferException.invalidWireType());
    L26:
        this.memoizedSerializedSize = r2;
        return r2;
    }

    public int getSerializedSizeAsMessageSet() {
        int r0 = this.memoizedSerializedSize;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r1 = 0;
        int r2 = 0;
    L7:
        if (r1 >= this.count) goto L9;
        r2 = r2 + CodedOutputStream.computeRawMessageSetExtensionSize(WireFormat.getTagFieldNumber(this.tags[r1]), (ByteString) ZeusTransformUtils.preCheckCast(this.objects[r1], ByteString.class, "com.obric.memorydata.plugin"));
        r1 = r1 + 1;
        goto L7
    L9:
        this.memoizedSerializedSize = r2;
        return r2;
    }

    public int hashCode() {
        int r0 = this.count;
        return ((((527 + r0) * 31) + hashCode(this.tags, r0)) * 31) + hashCode(this.objects, this.count);
    }

    public void makeImmutable() {
        if (this.isMutable == false) goto L6;
        this.isMutable = false;
        return;
    }

    boolean mergeFieldFrom(int r6, CodedInputStream r7) {
        checkMutable();
        int r0 = WireFormat.getTagFieldNumber(r6);
        int r1 = WireFormat.getTagWireType(r6);
        if (r1 == 0) goto L24;
        if (r1 != 1) goto L6;
        storeField(r6, Long.valueOf(r7.readFixed64()));
        return true;
    L6:
        if (r1 != 2) goto L8;
        storeField(r6, r7.readBytes());
        return true;
    L8:
        if (r1 == 3) goto L18;
        if (r1 != 4) goto L11;
        r7.checkValidEndTag();
        return false;
    L11:
        if (r1 != 5) goto L15;
        storeField(r6, Integer.valueOf(r7.readFixed32()));
        return true;
    L15:
        throw InvalidProtocolBufferException.invalidWireType();
    L18:
        UnknownFieldSetLite r2 = new UnknownFieldSetLite();
        r2.mergeFrom(r7);
        r7.checkLastTagWas(WireFormat.makeTag(r0, 4));
        storeField(r6, r2);
        return true;
    L24:
        storeField(r6, Long.valueOf(r7.readInt64()));
        return true;
    }

    UnknownFieldSetLite mergeFrom(UnknownFieldSetLite r7) {
        if (r7.equals(getDefaultInstance()) == false) goto L5;
        return this;
    L5:
        checkMutable();
        int r0 = this.count + r7.count;
        ensureCapacity(r0);
        System.arraycopy(r7.tags, 0, this.tags, this.count, r7.count);
        System.arraycopy(r7.objects, 0, this.objects, this.count, r7.count);
        this.count = r0;
        return this;
    }

    UnknownFieldSetLite mergeLengthDelimitedField(int r2, ByteString r3) {
        checkMutable();
        if (r2 == 0) goto L7;
        storeField(WireFormat.makeTag(r2, 2), r3);
        return this;
    L7:
        throw new IllegalArgumentException("Zero is not a valid field number.");
    }

    UnknownFieldSetLite mergeVarintField(int r3, int r4) {
        checkMutable();
        if (r3 == 0) goto L7;
        storeField(WireFormat.makeTag(r3, 0), Long.valueOf(r4));
        return this;
    L7:
        throw new IllegalArgumentException("Zero is not a valid field number.");
    }

    final void printWithIndent(StringBuilder r4, int r5) {
        int r0 = 0;
    L4:
        if (r0 >= this.count) goto L6;
        MessageLiteToString.printField(r4, r5, String.valueOf(WireFormat.getTagFieldNumber(this.tags[r0])), this.objects[r0]);
        r0 = r0 + 1;
        goto L4
    }

    void storeField(int r3, Object r4) {
        checkMutable();
        ensureCapacity(this.count + 1);
        int[] r0 = this.tags;
        int r1 = this.count;
        r0[r1] = r3;
        this.objects[r1] = r4;
        this.count = r1 + 1;
    }

    public void writeAsMessageSetTo(CodedOutputStream r6) {
        int r0 = 0;
    L4:
        if (r0 >= this.count) goto L6;
        r6.writeRawMessageSetExtension(WireFormat.getTagFieldNumber(this.tags[r0]), (ByteString) ZeusTransformUtils.preCheckCast(this.objects[r0], ByteString.class, "com.obric.memorydata.plugin"));
        r0 = r0 + 1;
        goto L4
    }

    void writeAsMessageSetTo(Writer r4) {
        Writer r5 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        if (r5.fieldOrder() != Writer.FieldOrder.DESCENDING) goto L7;
        int r0 = this.count - 1;
    L5:
        if (r0 < 0) goto L11;
        r5.writeMessageSetItem(WireFormat.getTagFieldNumber(this.tags[r0]), this.objects[r0]);
        r0 = r0 - 1;
        goto L5
    L11:
        return;
    L7:
        int r1 = 0;
    L9:
        if (r1 >= this.count) goto L14;
        r5.writeMessageSetItem(WireFormat.getTagFieldNumber(this.tags[r1]), this.objects[r1]);
        r1 = r1 + 1;
        goto L9
    }

    public void writeTo(CodedOutputStream r6) {
        int r0 = 0;
    L4:
        if (r0 >= this.count) goto L23;
        int r1 = this.tags[r0];
        int r2 = WireFormat.getTagFieldNumber(r1);
        int r3 = WireFormat.getTagWireType(r1);
        if (r3 != 0) goto L8;
        r6.writeUInt64(r2, ((Long) ZeusTransformUtils.preCheckCast(this.objects[r0], Long.class, "com.obric.memorydata.plugin")).longValue());
    L22:
        r0 = r0 + 1;
        goto L4
    L8:
        if (r3 != 1) goto L10;
        r6.writeFixed64(r2, ((Long) ZeusTransformUtils.preCheckCast(this.objects[r0], Long.class, "com.obric.memorydata.plugin")).longValue());
        goto L22
    L10:
        if (r3 != 2) goto L12;
        r6.writeBytes(r2, (ByteString) ZeusTransformUtils.preCheckCast(this.objects[r0], ByteString.class, "com.obric.memorydata.plugin"));
        goto L22
    L12:
        if (r3 != 3) goto L14;
        r6.writeTag(r2, 3);
        ((UnknownFieldSetLite) ZeusTransformUtils.preCheckCast(this.objects[r0], UnknownFieldSetLite.class, "com.obric.memorydata.plugin")).writeTo(r6);
        r6.writeTag(r2, 4);
        goto L22
    L14:
        if (r3 != 5) goto L17;
        r6.writeFixed32(r2, ((Integer) ZeusTransformUtils.preCheckCast(this.objects[r0], Integer.class, "com.obric.memorydata.plugin")).intValue());
        goto L22
    L17:
        throw InvalidProtocolBufferException.invalidWireType();
    }

    public void writeTo(Writer r4) {
        Writer r5 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        if (this.count != 0) goto L6;
        return;
    L6:
        if (r5.fieldOrder() != Writer.FieldOrder.ASCENDING) goto L11;
        int r0 = 0;
    L9:
        if (r0 >= this.count) goto L14;
        writeField(this.tags[r0], this.objects[r0], r5);
        r0 = r0 + 1;
        goto L9
    L14:
        return;
    L11:
        int r1 = this.count - 1;
    L12:
        if (r1 < 0) goto L17;
        writeField(this.tags[r1], this.objects[r1], r5);
        r1 = r1 - 1;
        goto L12
    }
}
