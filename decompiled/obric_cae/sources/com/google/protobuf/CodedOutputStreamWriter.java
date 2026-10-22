package com.google.protobuf;

import com.qualcomm.qti.qesdk.QesdkUtils;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@CheckReturnValue
final class CodedOutputStreamWriter implements Writer {
    private final CodedOutputStream output;

    /* JADX INFO: renamed from: com.google.protobuf.CodedOutputStreamWriter$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType = null;

        static {
            int[] r8 = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = r8;
            r8[WireFormat.FieldType.BOOL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L30:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L36:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
        L50:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 4;     // Catch: NoSuchFieldError -> L19
        L32:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 5;     // Catch: NoSuchFieldError -> L20
        L38:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 6;     // Catch: NoSuchFieldError -> L21
        L42:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 7;     // Catch: NoSuchFieldError -> L22
        L46:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 8;     // Catch: NoSuchFieldError -> L23
        L28:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 9;     // Catch: NoSuchFieldError -> L24
        L34:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 10;     // Catch: NoSuchFieldError -> L25
        L40:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 11;     // Catch: NoSuchFieldError -> L26
        L44:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 12;     // Catch: NoSuchFieldError -> L27
            return;
        }
    }

    private CodedOutputStreamWriter(CodedOutputStream r8) {
        CodedOutputStream r10 = (CodedOutputStream) Internal.checkNotNull(r8, QesdkUtils.TAGS.TAG_OUTPUT);
        this.output = r10;
        r10.wrapper = this;
    }

    public static CodedOutputStreamWriter forCodedOutput(CodedOutputStream r8) {
        Object r10 = r8.wrapper;
        if (r10 == null) goto L7;
        return (CodedOutputStreamWriter) r10;
    L7:
        return new CodedOutputStreamWriter(r8);
    }

    private void writeBoolListInternal(int r8, BooleanArrayList r10, boolean r11) {
        int r12 = 0;
        if (r11 == false) goto L13;
        this.output.writeTag(r8, 2);
        int r13 = 0;
        int r14 = 0;
    L6:
        if (r13 >= r10.size()) goto L8;
        r14 = r14 + CodedOutputStream.computeBoolSizeNoTag(r10.getBoolean(r13));
        r13 = r13 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r14);
    L10:
        if (r12 >= r10.size()) goto L15;
        this.output.writeBoolNoTag(r10.getBoolean(r12));
        r12 = r12 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r12 >= r10.size()) goto L19;
        this.output.writeBool(r8, r10.getBoolean(r12));
        r12 = r12 + 1;
        goto L13
    }

    private <V> void writeDeterministicBooleanMapEntry(int r8, boolean r10, V r11, MapEntryLite.Metadata<Boolean, V> r12) {
        this.output.writeTag(r8, 2);
        this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(r12, Boolean.valueOf(r10), r11));
        MapEntryLite.writeTo(this.output, r12, Boolean.valueOf(r10), r11);
    }

    private <V> void writeDeterministicIntegerMap(int r8, MapEntryLite.Metadata<Integer, V> r10, Map<Integer, V> r11) {
        int r12 = r11.size();
        int[] r13 = new int[r12];
        Iterator<Integer> r14 = r11.keySet().iterator();
        int r15 = 0;
        int r16 = 0;
    L4:
        if (r14.hasNext() == false) goto L6;
        r13[r16] = r14.next().intValue();
        r16 = r16 + 1;
        goto L4
    L6:
        Arrays.sort(r13);
    L7:
        if (r15 >= r12) goto L9;
        int r17 = r13[r15];
        V r18 = r11.get(Integer.valueOf(r17));
        this.output.writeTag(r8, 2);
        this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(r10, Integer.valueOf(r17), r18));
        MapEntryLite.writeTo(this.output, r10, Integer.valueOf(r17), r18);
        r15 = r15 + 1;
        goto L7
    }

    private <V> void writeDeterministicLongMap(int r10, MapEntryLite.Metadata<Long, V> r11, Map<Long, V> r12) {
        int r8 = r12.size();
        long[] r13 = new long[r8];
        Iterator<Long> r14 = r12.keySet().iterator();
        int r15 = 0;
        int r16 = 0;
    L4:
        if (r14.hasNext() == false) goto L6;
        r13[r16] = r14.next().longValue();
        r16 = r16 + 1;
        goto L4
    L6:
        Arrays.sort(r13);
    L7:
        if (r15 >= r8) goto L9;
        long r17 = r13[r15];
        V r18 = r12.get(Long.valueOf(r17));
        this.output.writeTag(r10, 2);
        this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(r11, Long.valueOf(r17), r18));
        MapEntryLite.writeTo(this.output, r11, Long.valueOf(r17), r18);
        r15 = r15 + 1;
        goto L7
    }

    private <K, V> void writeDeterministicMap(int r8, MapEntryLite.Metadata<K, V> r10, Map<K, V> r11) {
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r10.keyType.ordinal()]) {
            case 1: goto L9;
            case 2: goto L8;
            case 3: goto L8;
            case 4: goto L8;
            case 5: goto L8;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L7;
            case 9: goto L7;
            case 10: goto L7;
            case 11: goto L7;
            case 12: goto L6;
            default: goto L5;
        };
    L6:
        writeDeterministicStringMap(r8, r10, r11);
        return;
    L7:
        writeDeterministicLongMap(r8, r10, r11);
        return;
    L8:
        writeDeterministicIntegerMap(r8, r10, r11);
        return;
    L9:
        V r12 = r11.get(Boolean.FALSE);
        if (r12 == null) goto L12;
        writeDeterministicBooleanMapEntry(r8, false, r12, r10);
    L12:
        V r13 = r11.get(Boolean.TRUE);
        if (r13 == null) goto L19;
        writeDeterministicBooleanMapEntry(r8, true, r13, r10);
        return;
    L19:
        return;
    L5:
        throw new IllegalArgumentException("does not support key type: " + r10.keyType);
    }

    private <V> void writeDeterministicStringMap(int r8, MapEntryLite.Metadata<String, V> r10, Map<String, V> r11) {
        int r12 = r11.size();
        String[] r13 = new String[r12];
        Iterator<String> r14 = r11.keySet().iterator();
        int r15 = 0;
        int r16 = 0;
    L4:
        if (r14.hasNext() == false) goto L6;
        r13[r16] = r14.next();
        r16 = r16 + 1;
        goto L4
    L6:
        Arrays.sort(r13);
    L7:
        if (r15 >= r12) goto L9;
        String r17 = r13[r15];
        V r18 = r11.get(r17);
        this.output.writeTag(r8, 2);
        this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(r10, r17, r18));
        MapEntryLite.writeTo(this.output, r10, r17, r18);
        r15 = r15 + 1;
        goto L7
    }

    private void writeDoubleListInternal(int r8, DoubleArrayList r10, boolean r11) {
        int r12 = 0;
        if (r11 == false) goto L13;
        this.output.writeTag(r8, 2);
        int r13 = 0;
        int r14 = 0;
    L6:
        if (r13 >= r10.size()) goto L8;
        r14 = r14 + CodedOutputStream.computeDoubleSizeNoTag(r10.getDouble(r13));
        r13 = r13 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r14);
    L10:
        if (r12 >= r10.size()) goto L15;
        this.output.writeDoubleNoTag(r10.getDouble(r12));
        r12 = r12 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r12 >= r10.size()) goto L19;
        this.output.writeDouble(r8, r10.getDouble(r12));
        r12 = r12 + 1;
        goto L13
    }

    private void writeEnumListInternal(int r8, IntArrayList r10, boolean r11) {
        int r12 = 0;
        if (r11 == false) goto L13;
        this.output.writeTag(r8, 2);
        int r13 = 0;
        int r14 = 0;
    L6:
        if (r13 >= r10.size()) goto L8;
        r14 = r14 + CodedOutputStream.computeEnumSizeNoTag(r10.getInt(r13));
        r13 = r13 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r14);
    L10:
        if (r12 >= r10.size()) goto L15;
        this.output.writeEnumNoTag(r10.getInt(r12));
        r12 = r12 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r12 >= r10.size()) goto L19;
        this.output.writeEnum(r8, r10.getInt(r12));
        r12 = r12 + 1;
        goto L13
    }

    private void writeFixed32ListInternal(int r8, IntArrayList r10, boolean r11) {
        int r12 = 0;
        if (r11 == false) goto L13;
        this.output.writeTag(r8, 2);
        int r13 = 0;
        int r14 = 0;
    L6:
        if (r13 >= r10.size()) goto L8;
        r14 = r14 + CodedOutputStream.computeFixed32SizeNoTag(r10.getInt(r13));
        r13 = r13 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r14);
    L10:
        if (r12 >= r10.size()) goto L15;
        this.output.writeFixed32NoTag(r10.getInt(r12));
        r12 = r12 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r12 >= r10.size()) goto L19;
        this.output.writeFixed32(r8, r10.getInt(r12));
        r12 = r12 + 1;
        goto L13
    }

    private void writeFixed64ListInternal(int r8, LongArrayList r10, boolean r11) {
        int r12 = 0;
        if (r11 == false) goto L13;
        this.output.writeTag(r8, 2);
        int r13 = 0;
        int r14 = 0;
    L6:
        if (r13 >= r10.size()) goto L8;
        r14 = r14 + CodedOutputStream.computeFixed64SizeNoTag(r10.getLong(r13));
        r13 = r13 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r14);
    L10:
        if (r12 >= r10.size()) goto L15;
        this.output.writeFixed64NoTag(r10.getLong(r12));
        r12 = r12 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r12 >= r10.size()) goto L19;
        this.output.writeFixed64(r8, r10.getLong(r12));
        r12 = r12 + 1;
        goto L13
    }

    private void writeFloatListInternal(int r8, FloatArrayList r10, boolean r11) {
        int r12 = 0;
        if (r11 == false) goto L13;
        this.output.writeTag(r8, 2);
        int r13 = 0;
        int r14 = 0;
    L6:
        if (r13 >= r10.size()) goto L8;
        r14 = r14 + CodedOutputStream.computeFloatSizeNoTag(r10.getFloat(r13));
        r13 = r13 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r14);
    L10:
        if (r12 >= r10.size()) goto L15;
        this.output.writeFloatNoTag(r10.getFloat(r12));
        r12 = r12 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r12 >= r10.size()) goto L19;
        this.output.writeFloat(r8, r10.getFloat(r12));
        r12 = r12 + 1;
        goto L13
    }

    private void writeInt32ListInternal(int r8, IntArrayList r10, boolean r11) {
        int r12 = 0;
        if (r11 == false) goto L13;
        this.output.writeTag(r8, 2);
        int r13 = 0;
        int r14 = 0;
    L6:
        if (r13 >= r10.size()) goto L8;
        r14 = r14 + CodedOutputStream.computeInt32SizeNoTag(r10.getInt(r13));
        r13 = r13 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r14);
    L10:
        if (r12 >= r10.size()) goto L15;
        this.output.writeInt32NoTag(r10.getInt(r12));
        r12 = r12 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r12 >= r10.size()) goto L19;
        this.output.writeInt32(r8, r10.getInt(r12));
        r12 = r12 + 1;
        goto L13
    }

    private void writeInt64ListInternal(int r8, LongArrayList r10, boolean r11) {
        int r12 = 0;
        if (r11 == false) goto L13;
        this.output.writeTag(r8, 2);
        int r13 = 0;
        int r14 = 0;
    L6:
        if (r13 >= r10.size()) goto L8;
        r14 = r14 + CodedOutputStream.computeInt64SizeNoTag(r10.getLong(r13));
        r13 = r13 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r14);
    L10:
        if (r12 >= r10.size()) goto L15;
        this.output.writeInt64NoTag(r10.getLong(r12));
        r12 = r12 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r12 >= r10.size()) goto L19;
        this.output.writeInt64(r8, r10.getLong(r12));
        r12 = r12 + 1;
        goto L13
    }

    private void writeLazyString(int r8, Object r10) {
        boolean r11 = r10 instanceof String;
        CodedOutputStream r12 = this.output;
        if (r11 == false) goto L5;
        r12.writeString(r8, (String) r10);
        return;
    L5:
        r12.writeBytes(r8, (ByteString) r10);
    }

    private void writeSFixed32ListInternal(int r8, IntArrayList r10, boolean r11) {
        int r12 = 0;
        if (r11 == false) goto L13;
        this.output.writeTag(r8, 2);
        int r13 = 0;
        int r14 = 0;
    L6:
        if (r13 >= r10.size()) goto L8;
        r14 = r14 + CodedOutputStream.computeSFixed32SizeNoTag(r10.getInt(r13));
        r13 = r13 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r14);
    L10:
        if (r12 >= r10.size()) goto L15;
        this.output.writeSFixed32NoTag(r10.getInt(r12));
        r12 = r12 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r12 >= r10.size()) goto L19;
        this.output.writeSFixed32(r8, r10.getInt(r12));
        r12 = r12 + 1;
        goto L13
    }

    private void writeSFixed64ListInternal(int r8, LongArrayList r10, boolean r11) {
        int r12 = 0;
        if (r11 == false) goto L13;
        this.output.writeTag(r8, 2);
        int r13 = 0;
        int r14 = 0;
    L6:
        if (r13 >= r10.size()) goto L8;
        r14 = r14 + CodedOutputStream.computeSFixed64SizeNoTag(r10.getLong(r13));
        r13 = r13 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r14);
    L10:
        if (r12 >= r10.size()) goto L15;
        this.output.writeSFixed64NoTag(r10.getLong(r12));
        r12 = r12 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r12 >= r10.size()) goto L19;
        this.output.writeSFixed64(r8, r10.getLong(r12));
        r12 = r12 + 1;
        goto L13
    }

    private void writeSInt32ListInternal(int r8, IntArrayList r10, boolean r11) {
        int r12 = 0;
        if (r11 == false) goto L13;
        this.output.writeTag(r8, 2);
        int r13 = 0;
        int r14 = 0;
    L6:
        if (r13 >= r10.size()) goto L8;
        r14 = r14 + CodedOutputStream.computeSInt32SizeNoTag(r10.getInt(r13));
        r13 = r13 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r14);
    L10:
        if (r12 >= r10.size()) goto L15;
        this.output.writeSInt32NoTag(r10.getInt(r12));
        r12 = r12 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r12 >= r10.size()) goto L19;
        this.output.writeSInt32(r8, r10.getInt(r12));
        r12 = r12 + 1;
        goto L13
    }

    private void writeSInt64ListInternal(int r8, LongArrayList r10, boolean r11) {
        int r12 = 0;
        if (r11 == false) goto L13;
        this.output.writeTag(r8, 2);
        int r13 = 0;
        int r14 = 0;
    L6:
        if (r13 >= r10.size()) goto L8;
        r14 = r14 + CodedOutputStream.computeSInt64SizeNoTag(r10.getLong(r13));
        r13 = r13 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r14);
    L10:
        if (r12 >= r10.size()) goto L15;
        this.output.writeSInt64NoTag(r10.getLong(r12));
        r12 = r12 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r12 >= r10.size()) goto L19;
        this.output.writeSInt64(r8, r10.getLong(r12));
        r12 = r12 + 1;
        goto L13
    }

    private void writeUInt32ListInternal(int r8, IntArrayList r10, boolean r11) {
        int r12 = 0;
        if (r11 == false) goto L13;
        this.output.writeTag(r8, 2);
        int r13 = 0;
        int r14 = 0;
    L6:
        if (r13 >= r10.size()) goto L8;
        r14 = r14 + CodedOutputStream.computeUInt32SizeNoTag(r10.getInt(r13));
        r13 = r13 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r14);
    L10:
        if (r12 >= r10.size()) goto L15;
        this.output.writeUInt32NoTag(r10.getInt(r12));
        r12 = r12 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r12 >= r10.size()) goto L19;
        this.output.writeUInt32(r8, r10.getInt(r12));
        r12 = r12 + 1;
        goto L13
    }

    private void writeUInt64ListInternal(int r8, LongArrayList r10, boolean r11) {
        int r12 = 0;
        if (r11 == false) goto L13;
        this.output.writeTag(r8, 2);
        int r13 = 0;
        int r14 = 0;
    L6:
        if (r13 >= r10.size()) goto L8;
        r14 = r14 + CodedOutputStream.computeUInt64SizeNoTag(r10.getLong(r13));
        r13 = r13 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r14);
    L10:
        if (r12 >= r10.size()) goto L15;
        this.output.writeUInt64NoTag(r10.getLong(r12));
        r12 = r12 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r12 >= r10.size()) goto L19;
        this.output.writeUInt64(r8, r10.getLong(r12));
        r12 = r12 + 1;
        goto L13
    }

    @Override // com.google.protobuf.Writer
    public Writer.FieldOrder fieldOrder() {
        return Writer.FieldOrder.ASCENDING;
    }

    public int getTotalBytesWritten() {
        return this.output.getTotalBytesWritten();
    }

    @Override // com.google.protobuf.Writer
    public void writeBool(int r8, boolean r10) {
        this.output.writeBool(r8, r10);
    }

    @Override // com.google.protobuf.Writer
    public void writeBoolList(int r8, List<Boolean> r10, boolean r11) {
        if ((r10 instanceof BooleanArrayList) == false) goto L5;
        writeBoolListInternal(r8, (BooleanArrayList) r10, r11);
        return;
    L5:
        writeBoolListInternal(r8, r10, r11);
    }

    @Override // com.google.protobuf.Writer
    public void writeBytes(int r8, ByteString r10) {
        this.output.writeBytes(r8, r10);
    }

    @Override // com.google.protobuf.Writer
    public void writeBytesList(int r8, List<ByteString> r10) {
        int r11 = 0;
    L4:
        if (r11 >= r10.size()) goto L6;
        this.output.writeBytes(r8, r10.get(r11));
        r11 = r11 + 1;
        goto L4
    }

    @Override // com.google.protobuf.Writer
    public void writeDouble(int r8, double r10) {
        this.output.writeDouble(r8, r10);
    }

    @Override // com.google.protobuf.Writer
    public void writeDoubleList(int r8, List<Double> r10, boolean r11) {
        if ((r10 instanceof DoubleArrayList) == false) goto L5;
        writeDoubleListInternal(r8, (DoubleArrayList) r10, r11);
        return;
    L5:
        writeDoubleListInternal(r8, r10, r11);
    }

    @Override // com.google.protobuf.Writer
    @Deprecated
    public void writeEndGroup(int r8) {
        this.output.writeTag(r8, 4);
    }

    @Override // com.google.protobuf.Writer
    public void writeEnum(int r8, int r10) {
        this.output.writeEnum(r8, r10);
    }

    @Override // com.google.protobuf.Writer
    public void writeEnumList(int r8, List<Integer> r10, boolean r11) {
        if ((r10 instanceof IntArrayList) == false) goto L5;
        writeEnumListInternal(r8, (IntArrayList) r10, r11);
        return;
    L5:
        writeEnumListInternal(r8, r10, r11);
    }

    @Override // com.google.protobuf.Writer
    public void writeFixed32(int r8, int r10) {
        this.output.writeFixed32(r8, r10);
    }

    @Override // com.google.protobuf.Writer
    public void writeFixed32List(int r8, List<Integer> r10, boolean r11) {
        if ((r10 instanceof IntArrayList) == false) goto L5;
        writeFixed32ListInternal(r8, (IntArrayList) r10, r11);
        return;
    L5:
        writeFixed32ListInternal(r8, r10, r11);
    }

    @Override // com.google.protobuf.Writer
    public void writeFixed64(int r8, long r10) {
        this.output.writeFixed64(r8, r10);
    }

    @Override // com.google.protobuf.Writer
    public void writeFixed64List(int r8, List<Long> r10, boolean r11) {
        if ((r10 instanceof LongArrayList) == false) goto L5;
        writeFixed64ListInternal(r8, (LongArrayList) r10, r11);
        return;
    L5:
        writeFixed64ListInternal(r8, r10, r11);
    }

    @Override // com.google.protobuf.Writer
    public void writeFloat(int r8, float r10) {
        this.output.writeFloat(r8, r10);
    }

    @Override // com.google.protobuf.Writer
    public void writeFloatList(int r8, List<Float> r10, boolean r11) {
        if ((r10 instanceof FloatArrayList) == false) goto L5;
        writeFloatListInternal(r8, (FloatArrayList) r10, r11);
        return;
    L5:
        writeFloatListInternal(r8, r10, r11);
    }

    @Override // com.google.protobuf.Writer
    @Deprecated
    public void writeGroup(int r8, Object r10) {
        this.output.writeGroup(r8, (MessageLite) r10);
    }

    @Override // com.google.protobuf.Writer
    @Deprecated
    public void writeGroupList(int r8, List<?> r10) {
        int r11 = 0;
    L4:
        if (r11 >= r10.size()) goto L6;
        writeGroup(r8, r10.get(r11));
        r11 = r11 + 1;
        goto L4
    }

    @Override // com.google.protobuf.Writer
    public void writeInt32(int r8, int r10) {
        this.output.writeInt32(r8, r10);
    }

    @Override // com.google.protobuf.Writer
    public void writeInt32List(int r8, List<Integer> r10, boolean r11) {
        if ((r10 instanceof IntArrayList) == false) goto L5;
        writeInt32ListInternal(r8, (IntArrayList) r10, r11);
        return;
    L5:
        writeInt32ListInternal(r8, r10, r11);
    }

    @Override // com.google.protobuf.Writer
    public void writeInt64(int r8, long r10) {
        this.output.writeInt64(r8, r10);
    }

    @Override // com.google.protobuf.Writer
    public void writeInt64List(int r8, List<Long> r10, boolean r11) {
        if ((r10 instanceof LongArrayList) == false) goto L5;
        writeInt64ListInternal(r8, (LongArrayList) r10, r11);
        return;
    L5:
        writeInt64ListInternal(r8, r10, r11);
    }

    @Override // com.google.protobuf.Writer
    public <K, V> void writeMap(int r8, MapEntryLite.Metadata<K, V> r10, Map<K, V> r11) {
        if (this.output.isSerializationDeterministic() == false) goto L6;
        writeDeterministicMap(r8, r10, r11);
        return;
    L6:
        Iterator<Map.Entry<K, V>> r12 = r11.entrySet().iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        Map.Entry<K, V> r13 = r12.next();
        this.output.writeTag(r8, 2);
        this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(r10, r13.getKey(), r13.getValue()));
        MapEntryLite.writeTo(this.output, r10, r13.getKey(), r13.getValue());
        goto L8
    }

    @Override // com.google.protobuf.Writer
    public void writeMessage(int r8, Object r10) {
        this.output.writeMessage(r8, (MessageLite) r10);
    }

    @Override // com.google.protobuf.Writer
    public void writeMessageList(int r8, List<?> r10) {
        int r11 = 0;
    L4:
        if (r11 >= r10.size()) goto L6;
        writeMessage(r8, r10.get(r11));
        r11 = r11 + 1;
        goto L4
    }

    @Override // com.google.protobuf.Writer
    public final void writeMessageSetItem(int r8, Object r10) {
        boolean r11 = r10 instanceof ByteString;
        CodedOutputStream r12 = this.output;
        if (r11 == false) goto L5;
        r12.writeRawMessageSetExtension(r8, (ByteString) r10);
        return;
    L5:
        r12.writeMessageSetExtension(r8, (MessageLite) r10);
    }

    @Override // com.google.protobuf.Writer
    public void writeSFixed32(int r8, int r10) {
        this.output.writeSFixed32(r8, r10);
    }

    @Override // com.google.protobuf.Writer
    public void writeSFixed32List(int r8, List<Integer> r10, boolean r11) {
        if ((r10 instanceof IntArrayList) == false) goto L5;
        writeSFixed32ListInternal(r8, (IntArrayList) r10, r11);
        return;
    L5:
        writeSFixed32ListInternal(r8, r10, r11);
    }

    @Override // com.google.protobuf.Writer
    public void writeSFixed64(int r8, long r10) {
        this.output.writeSFixed64(r8, r10);
    }

    @Override // com.google.protobuf.Writer
    public void writeSFixed64List(int r8, List<Long> r10, boolean r11) {
        if ((r10 instanceof LongArrayList) == false) goto L5;
        writeSFixed64ListInternal(r8, (LongArrayList) r10, r11);
        return;
    L5:
        writeSFixed64ListInternal(r8, r10, r11);
    }

    @Override // com.google.protobuf.Writer
    public void writeSInt32(int r8, int r10) {
        this.output.writeSInt32(r8, r10);
    }

    @Override // com.google.protobuf.Writer
    public void writeSInt32List(int r8, List<Integer> r10, boolean r11) {
        if ((r10 instanceof IntArrayList) == false) goto L5;
        writeSInt32ListInternal(r8, (IntArrayList) r10, r11);
        return;
    L5:
        writeSInt32ListInternal(r8, r10, r11);
    }

    @Override // com.google.protobuf.Writer
    public void writeSInt64(int r8, long r10) {
        this.output.writeSInt64(r8, r10);
    }

    @Override // com.google.protobuf.Writer
    public void writeSInt64List(int r8, List<Long> r10, boolean r11) {
        if ((r10 instanceof LongArrayList) == false) goto L5;
        writeSInt64ListInternal(r8, (LongArrayList) r10, r11);
        return;
    L5:
        writeSInt64ListInternal(r8, r10, r11);
    }

    @Override // com.google.protobuf.Writer
    @Deprecated
    public void writeStartGroup(int r8) {
        this.output.writeTag(r8, 3);
    }

    @Override // com.google.protobuf.Writer
    public void writeString(int r8, String r10) {
        this.output.writeString(r8, r10);
    }

    @Override // com.google.protobuf.Writer
    public void writeStringList(int r8, List<String> r10) {
        int r11 = 0;
        if ((r10 instanceof LazyStringList) == false) goto L9;
        LazyStringList r12 = (LazyStringList) r10;
    L6:
        if (r11 >= r10.size()) goto L11;
        writeLazyString(r8, r12.getRaw(r11));
        r11 = r11 + 1;
        goto L6
    L11:
        return;
    L9:
        if (r11 >= r10.size()) goto L14;
        this.output.writeString(r8, r10.get(r11));
        r11 = r11 + 1;
        goto L9
    }

    @Override // com.google.protobuf.Writer
    public void writeUInt32(int r8, int r10) {
        this.output.writeUInt32(r8, r10);
    }

    @Override // com.google.protobuf.Writer
    public void writeUInt32List(int r8, List<Integer> r10, boolean r11) {
        if ((r10 instanceof IntArrayList) == false) goto L5;
        writeUInt32ListInternal(r8, (IntArrayList) r10, r11);
        return;
    L5:
        writeUInt32ListInternal(r8, r10, r11);
    }

    @Override // com.google.protobuf.Writer
    public void writeUInt64(int r8, long r10) {
        this.output.writeUInt64(r8, r10);
    }

    @Override // com.google.protobuf.Writer
    public void writeUInt64List(int r8, List<Long> r10, boolean r11) {
        if ((r10 instanceof LongArrayList) == false) goto L5;
        writeUInt64ListInternal(r8, (LongArrayList) r10, r11);
        return;
    L5:
        writeUInt64ListInternal(r8, r10, r11);
    }

    private void writeBoolListInternal(int r8, List<Boolean> r10, boolean r11) {
        int r12 = 0;
        if (r11 == false) goto L13;
        this.output.writeTag(r8, 2);
        int r13 = 0;
        int r14 = 0;
    L6:
        if (r13 >= r10.size()) goto L8;
        r14 = r14 + CodedOutputStream.computeBoolSizeNoTag(r10.get(r13).booleanValue());
        r13 = r13 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r14);
    L10:
        if (r12 >= r10.size()) goto L15;
        this.output.writeBoolNoTag(r10.get(r12).booleanValue());
        r12 = r12 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r12 >= r10.size()) goto L19;
        this.output.writeBool(r8, r10.get(r12).booleanValue());
        r12 = r12 + 1;
        goto L13
    }

    private void writeDoubleListInternal(int r8, List<Double> r10, boolean r11) {
        int r12 = 0;
        if (r11 == false) goto L13;
        this.output.writeTag(r8, 2);
        int r13 = 0;
        int r14 = 0;
    L6:
        if (r13 >= r10.size()) goto L8;
        r14 = r14 + CodedOutputStream.computeDoubleSizeNoTag(r10.get(r13).doubleValue());
        r13 = r13 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r14);
    L10:
        if (r12 >= r10.size()) goto L15;
        this.output.writeDoubleNoTag(r10.get(r12).doubleValue());
        r12 = r12 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r12 >= r10.size()) goto L19;
        this.output.writeDouble(r8, r10.get(r12).doubleValue());
        r12 = r12 + 1;
        goto L13
    }

    private void writeEnumListInternal(int r8, List<Integer> r10, boolean r11) {
        int r12 = 0;
        if (r11 == false) goto L13;
        this.output.writeTag(r8, 2);
        int r13 = 0;
        int r14 = 0;
    L6:
        if (r13 >= r10.size()) goto L8;
        r14 = r14 + CodedOutputStream.computeEnumSizeNoTag(r10.get(r13).intValue());
        r13 = r13 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r14);
    L10:
        if (r12 >= r10.size()) goto L15;
        this.output.writeEnumNoTag(r10.get(r12).intValue());
        r12 = r12 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r12 >= r10.size()) goto L19;
        this.output.writeEnum(r8, r10.get(r12).intValue());
        r12 = r12 + 1;
        goto L13
    }

    private void writeFixed32ListInternal(int r8, List<Integer> r10, boolean r11) {
        int r12 = 0;
        if (r11 == false) goto L13;
        this.output.writeTag(r8, 2);
        int r13 = 0;
        int r14 = 0;
    L6:
        if (r13 >= r10.size()) goto L8;
        r14 = r14 + CodedOutputStream.computeFixed32SizeNoTag(r10.get(r13).intValue());
        r13 = r13 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r14);
    L10:
        if (r12 >= r10.size()) goto L15;
        this.output.writeFixed32NoTag(r10.get(r12).intValue());
        r12 = r12 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r12 >= r10.size()) goto L19;
        this.output.writeFixed32(r8, r10.get(r12).intValue());
        r12 = r12 + 1;
        goto L13
    }

    private void writeFixed64ListInternal(int r8, List<Long> r10, boolean r11) {
        int r12 = 0;
        if (r11 == false) goto L13;
        this.output.writeTag(r8, 2);
        int r13 = 0;
        int r14 = 0;
    L6:
        if (r13 >= r10.size()) goto L8;
        r14 = r14 + CodedOutputStream.computeFixed64SizeNoTag(r10.get(r13).longValue());
        r13 = r13 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r14);
    L10:
        if (r12 >= r10.size()) goto L15;
        this.output.writeFixed64NoTag(r10.get(r12).longValue());
        r12 = r12 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r12 >= r10.size()) goto L19;
        this.output.writeFixed64(r8, r10.get(r12).longValue());
        r12 = r12 + 1;
        goto L13
    }

    private void writeFloatListInternal(int r8, List<Float> r10, boolean r11) {
        int r12 = 0;
        if (r11 == false) goto L13;
        this.output.writeTag(r8, 2);
        int r13 = 0;
        int r14 = 0;
    L6:
        if (r13 >= r10.size()) goto L8;
        r14 = r14 + CodedOutputStream.computeFloatSizeNoTag(r10.get(r13).floatValue());
        r13 = r13 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r14);
    L10:
        if (r12 >= r10.size()) goto L15;
        this.output.writeFloatNoTag(r10.get(r12).floatValue());
        r12 = r12 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r12 >= r10.size()) goto L19;
        this.output.writeFloat(r8, r10.get(r12).floatValue());
        r12 = r12 + 1;
        goto L13
    }

    private void writeInt32ListInternal(int r8, List<Integer> r10, boolean r11) {
        int r12 = 0;
        if (r11 == false) goto L13;
        this.output.writeTag(r8, 2);
        int r13 = 0;
        int r14 = 0;
    L6:
        if (r13 >= r10.size()) goto L8;
        r14 = r14 + CodedOutputStream.computeInt32SizeNoTag(r10.get(r13).intValue());
        r13 = r13 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r14);
    L10:
        if (r12 >= r10.size()) goto L15;
        this.output.writeInt32NoTag(r10.get(r12).intValue());
        r12 = r12 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r12 >= r10.size()) goto L19;
        this.output.writeInt32(r8, r10.get(r12).intValue());
        r12 = r12 + 1;
        goto L13
    }

    private void writeInt64ListInternal(int r8, List<Long> r10, boolean r11) {
        int r12 = 0;
        if (r11 == false) goto L13;
        this.output.writeTag(r8, 2);
        int r13 = 0;
        int r14 = 0;
    L6:
        if (r13 >= r10.size()) goto L8;
        r14 = r14 + CodedOutputStream.computeInt64SizeNoTag(r10.get(r13).longValue());
        r13 = r13 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r14);
    L10:
        if (r12 >= r10.size()) goto L15;
        this.output.writeInt64NoTag(r10.get(r12).longValue());
        r12 = r12 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r12 >= r10.size()) goto L19;
        this.output.writeInt64(r8, r10.get(r12).longValue());
        r12 = r12 + 1;
        goto L13
    }

    private void writeSFixed32ListInternal(int r8, List<Integer> r10, boolean r11) {
        int r12 = 0;
        if (r11 == false) goto L13;
        this.output.writeTag(r8, 2);
        int r13 = 0;
        int r14 = 0;
    L6:
        if (r13 >= r10.size()) goto L8;
        r14 = r14 + CodedOutputStream.computeSFixed32SizeNoTag(r10.get(r13).intValue());
        r13 = r13 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r14);
    L10:
        if (r12 >= r10.size()) goto L15;
        this.output.writeSFixed32NoTag(r10.get(r12).intValue());
        r12 = r12 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r12 >= r10.size()) goto L19;
        this.output.writeSFixed32(r8, r10.get(r12).intValue());
        r12 = r12 + 1;
        goto L13
    }

    private void writeSFixed64ListInternal(int r8, List<Long> r10, boolean r11) {
        int r12 = 0;
        if (r11 == false) goto L13;
        this.output.writeTag(r8, 2);
        int r13 = 0;
        int r14 = 0;
    L6:
        if (r13 >= r10.size()) goto L8;
        r14 = r14 + CodedOutputStream.computeSFixed64SizeNoTag(r10.get(r13).longValue());
        r13 = r13 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r14);
    L10:
        if (r12 >= r10.size()) goto L15;
        this.output.writeSFixed64NoTag(r10.get(r12).longValue());
        r12 = r12 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r12 >= r10.size()) goto L19;
        this.output.writeSFixed64(r8, r10.get(r12).longValue());
        r12 = r12 + 1;
        goto L13
    }

    private void writeSInt64ListInternal(int r8, List<Long> r10, boolean r11) {
        int r12 = 0;
        if (r11 == false) goto L13;
        this.output.writeTag(r8, 2);
        int r13 = 0;
        int r14 = 0;
    L6:
        if (r13 >= r10.size()) goto L8;
        r14 = r14 + CodedOutputStream.computeSInt64SizeNoTag(r10.get(r13).longValue());
        r13 = r13 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r14);
    L10:
        if (r12 >= r10.size()) goto L15;
        this.output.writeSInt64NoTag(r10.get(r12).longValue());
        r12 = r12 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r12 >= r10.size()) goto L19;
        this.output.writeSInt64(r8, r10.get(r12).longValue());
        r12 = r12 + 1;
        goto L13
    }

    private void writeUInt64ListInternal(int r8, List<Long> r10, boolean r11) {
        int r12 = 0;
        if (r11 == false) goto L13;
        this.output.writeTag(r8, 2);
        int r13 = 0;
        int r14 = 0;
    L6:
        if (r13 >= r10.size()) goto L8;
        r14 = r14 + CodedOutputStream.computeUInt64SizeNoTag(r10.get(r13).longValue());
        r13 = r13 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r14);
    L10:
        if (r12 >= r10.size()) goto L15;
        this.output.writeUInt64NoTag(r10.get(r12).longValue());
        r12 = r12 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r12 >= r10.size()) goto L19;
        this.output.writeUInt64(r8, r10.get(r12).longValue());
        r12 = r12 + 1;
        goto L13
    }

    @Override // com.google.protobuf.Writer
    public void writeGroup(int r8, Object r10, Schema r11) {
        this.output.writeTag(r8, 3);
        r11.writeTo((AbstractMessageLite) r10, this);
        this.output.writeTag(r8, 4);
    }

    @Override // com.google.protobuf.Writer
    public void writeGroupList(int r8, List<?> r10, Schema r11) {
        int r12 = 0;
    L4:
        if (r12 >= r10.size()) goto L6;
        writeGroup(r8, r10.get(r12), r11);
        r12 = r12 + 1;
        goto L4
    }

    @Override // com.google.protobuf.Writer
    public void writeMessage(int r8, Object r10, Schema r11) {
        AbstractMessageLite r12 = (AbstractMessageLite) r10;
        this.output.writeTag(r8, 2);
        this.output.writeUInt32NoTag(r12.getSerializedSize(r11));
        r11.writeTo(r12, this);
    }

    @Override // com.google.protobuf.Writer
    public void writeMessageList(int r8, List<?> r10, Schema r11) {
        int r12 = 0;
    L4:
        if (r12 >= r10.size()) goto L6;
        writeMessage(r8, r10.get(r12), r11);
        r12 = r12 + 1;
        goto L4
    }

    public void writeSInt32ListInternal(int r8, List<Integer> r10, boolean r11) {
        int r12 = 0;
        if (r11 == false) goto L13;
        this.output.writeTag(r8, 2);
        int r13 = 0;
        int r14 = 0;
    L6:
        if (r13 >= r10.size()) goto L8;
        r14 = r14 + CodedOutputStream.computeSInt32SizeNoTag(r10.get(r13).intValue());
        r13 = r13 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r14);
    L10:
        if (r12 >= r10.size()) goto L15;
        this.output.writeSInt32NoTag(r10.get(r12).intValue());
        r12 = r12 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r12 >= r10.size()) goto L19;
        this.output.writeSInt32(r8, r10.get(r12).intValue());
        r12 = r12 + 1;
        goto L13
    }

    public void writeUInt32ListInternal(int r8, List<Integer> r10, boolean r11) {
        int r12 = 0;
        if (r11 == false) goto L13;
        this.output.writeTag(r8, 2);
        int r13 = 0;
        int r14 = 0;
    L6:
        if (r13 >= r10.size()) goto L8;
        r14 = r14 + CodedOutputStream.computeUInt32SizeNoTag(r10.get(r13).intValue());
        r13 = r13 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r14);
    L10:
        if (r12 >= r10.size()) goto L15;
        this.output.writeUInt32NoTag(r10.get(r12).intValue());
        r12 = r12 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r12 >= r10.size()) goto L19;
        this.output.writeUInt32(r8, r10.get(r12).intValue());
        r12 = r12 + 1;
        goto L13
    }
}
