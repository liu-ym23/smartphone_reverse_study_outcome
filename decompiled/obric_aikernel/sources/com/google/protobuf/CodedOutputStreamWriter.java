package com.google.protobuf;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@CheckReturnValue
final class CodedOutputStreamWriter implements Writer {
    private final CodedOutputStream output;

    /* JADX INFO: renamed from: com.google.protobuf.CodedOutputStreamWriter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType = null;

        static {
            int[] r10 = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = r10;
            r10[WireFormat.FieldType.BOOL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
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

    private CodedOutputStreamWriter(CodedOutputStream r10) {
        CodedOutputStream r11 = (CodedOutputStream) Internal.checkNotNull(r10, "output");
        this.output = r11;
        r11.wrapper = this;
    }

    public static CodedOutputStreamWriter forCodedOutput(CodedOutputStream r10) {
        CodedOutputStreamWriter r11 = r10.wrapper;
        if (r11 == null) goto L6;
        return r11;
    L6:
        return new CodedOutputStreamWriter(r10);
    }

    private void writeBoolListInternal(int r10, BooleanArrayList r11, boolean r12) {
        int r13 = 0;
        if (r12 == false) goto L13;
        this.output.writeTag(r10, 2);
        int r14 = 0;
        int r15 = 0;
    L6:
        if (r14 >= r11.size()) goto L8;
        r15 = r15 + CodedOutputStream.computeBoolSizeNoTag(r11.getBoolean(r14));
        r14 = r14 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r15);
    L10:
        if (r13 >= r11.size()) goto L15;
        this.output.writeBoolNoTag(r11.getBoolean(r13));
        r13 = r13 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r13 >= r11.size()) goto L19;
        this.output.writeBool(r10, r11.getBoolean(r13));
        r13 = r13 + 1;
        goto L13
    }

    private void writeBoolListInternal(int r10, List<Boolean> r11, boolean r12) {
        int r13 = 0;
        if (r12 == false) goto L13;
        this.output.writeTag(r10, 2);
        int r14 = 0;
        int r15 = 0;
    L6:
        if (r14 >= r11.size()) goto L8;
        r15 = r15 + CodedOutputStream.computeBoolSizeNoTag(r11.get(r14).booleanValue());
        r14 = r14 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r15);
    L10:
        if (r13 >= r11.size()) goto L15;
        this.output.writeBoolNoTag(r11.get(r13).booleanValue());
        r13 = r13 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r13 >= r11.size()) goto L19;
        this.output.writeBool(r10, r11.get(r13).booleanValue());
        r13 = r13 + 1;
        goto L13
    }

    private <V> void writeDeterministicBooleanMapEntry(int r10, boolean r11, V r12, MapEntryLite.Metadata<Boolean, V> r13) {
        this.output.writeTag(r10, 2);
        this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(r13, Boolean.valueOf(r11), r12));
        MapEntryLite.writeTo(this.output, r13, Boolean.valueOf(r11), r12);
    }

    private <V> void writeDeterministicIntegerMap(int r10, MapEntryLite.Metadata<Integer, V> r11, Map<Integer, V> r12) {
        int r13 = r12.size();
        int[] r14 = new int[r13];
        Iterator<Integer> r15 = r12.keySet().iterator();
        int r16 = 0;
        int r17 = 0;
    L4:
        if (r15.hasNext() == false) goto L6;
        r14[r17] = r15.next().intValue();
        r17 = r17 + 1;
        goto L4
    L6:
        Arrays.sort(r14);
    L7:
        if (r16 >= r13) goto L9;
        int r18 = r14[r16];
        V r19 = r12.get(Integer.valueOf(r18));
        this.output.writeTag(r10, 2);
        this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(r11, Integer.valueOf(r18), r19));
        MapEntryLite.writeTo(this.output, r11, Integer.valueOf(r18), r19);
        r16 = r16 + 1;
        goto L7
    }

    private <V> void writeDeterministicLongMap(int r10, MapEntryLite.Metadata<Long, V> r11, Map<Long, V> r12) {
        int r13 = r12.size();
        long[] r14 = new long[r13];
        Iterator<Long> r15 = r12.keySet().iterator();
        int r16 = 0;
        int r17 = 0;
    L4:
        if (r15.hasNext() == false) goto L6;
        r14[r17] = r15.next().longValue();
        r17 = r17 + 1;
        goto L4
    L6:
        Arrays.sort(r14);
    L7:
        if (r16 >= r13) goto L9;
        long r18 = r14[r16];
        V r19 = r12.get(Long.valueOf(r18));
        this.output.writeTag(r10, 2);
        this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(r11, Long.valueOf(r18), r19));
        MapEntryLite.writeTo(this.output, r11, Long.valueOf(r18), r19);
        r16 = r16 + 1;
        goto L7
    }

    private <K, V> void writeDeterministicMap(int r10, MapEntryLite.Metadata<K, V> r11, Map<K, V> r12) {
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r11.keyType.ordinal()]) {
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
        writeDeterministicStringMap(r10, r11, r12);
        return;
    L7:
        writeDeterministicLongMap(r10, r11, r12);
        return;
    L8:
        writeDeterministicIntegerMap(r10, r11, r12);
        return;
    L9:
        V r13 = r12.get(Boolean.FALSE);
        if (r13 == null) goto L12;
        writeDeterministicBooleanMapEntry(r10, false, r13, r11);
    L12:
        V r14 = r12.get(Boolean.TRUE);
        if (r14 == null) goto L19;
        writeDeterministicBooleanMapEntry(r10, true, r14, r11);
        return;
    L19:
        return;
    L5:
        throw new IllegalArgumentException("does not support key type: " + r11.keyType);
    }

    private <V> void writeDeterministicStringMap(int r10, MapEntryLite.Metadata<String, V> r11, Map<String, V> r12) {
        int r13 = r12.size();
        String[] r14 = new String[r13];
        Iterator<String> r15 = r12.keySet().iterator();
        int r16 = 0;
        int r17 = 0;
    L4:
        if (r15.hasNext() == false) goto L6;
        r14[r17] = r15.next();
        r17 = r17 + 1;
        goto L4
    L6:
        Arrays.sort(r14);
    L7:
        if (r16 >= r13) goto L9;
        String r18 = r14[r16];
        V r19 = r12.get(r18);
        this.output.writeTag(r10, 2);
        this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(r11, r18, r19));
        MapEntryLite.writeTo(this.output, r11, r18, r19);
        r16 = r16 + 1;
        goto L7
    }

    private void writeDoubleListInternal(int r10, DoubleArrayList r11, boolean r12) {
        int r13 = 0;
        if (r12 == false) goto L13;
        this.output.writeTag(r10, 2);
        int r14 = 0;
        int r15 = 0;
    L6:
        if (r14 >= r11.size()) goto L8;
        r15 = r15 + CodedOutputStream.computeDoubleSizeNoTag(r11.getDouble(r14));
        r14 = r14 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r15);
    L10:
        if (r13 >= r11.size()) goto L15;
        this.output.writeDoubleNoTag(r11.getDouble(r13));
        r13 = r13 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r13 >= r11.size()) goto L19;
        this.output.writeDouble(r10, r11.getDouble(r13));
        r13 = r13 + 1;
        goto L13
    }

    private void writeDoubleListInternal(int r10, List<Double> r11, boolean r12) {
        int r13 = 0;
        if (r12 == false) goto L13;
        this.output.writeTag(r10, 2);
        int r14 = 0;
        int r15 = 0;
    L6:
        if (r14 >= r11.size()) goto L8;
        r15 = r15 + CodedOutputStream.computeDoubleSizeNoTag(r11.get(r14).doubleValue());
        r14 = r14 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r15);
    L10:
        if (r13 >= r11.size()) goto L15;
        this.output.writeDoubleNoTag(r11.get(r13).doubleValue());
        r13 = r13 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r13 >= r11.size()) goto L19;
        this.output.writeDouble(r10, r11.get(r13).doubleValue());
        r13 = r13 + 1;
        goto L13
    }

    private void writeEnumListInternal(int r10, IntArrayList r11, boolean r12) {
        int r13 = 0;
        if (r12 == false) goto L13;
        this.output.writeTag(r10, 2);
        int r14 = 0;
        int r15 = 0;
    L6:
        if (r14 >= r11.size()) goto L8;
        r15 = r15 + CodedOutputStream.computeEnumSizeNoTag(r11.getInt(r14));
        r14 = r14 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r15);
    L10:
        if (r13 >= r11.size()) goto L15;
        this.output.writeEnumNoTag(r11.getInt(r13));
        r13 = r13 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r13 >= r11.size()) goto L19;
        this.output.writeEnum(r10, r11.getInt(r13));
        r13 = r13 + 1;
        goto L13
    }

    private void writeEnumListInternal(int r10, List<Integer> r11, boolean r12) {
        int r13 = 0;
        if (r12 == false) goto L13;
        this.output.writeTag(r10, 2);
        int r14 = 0;
        int r15 = 0;
    L6:
        if (r14 >= r11.size()) goto L8;
        r15 = r15 + CodedOutputStream.computeEnumSizeNoTag(r11.get(r14).intValue());
        r14 = r14 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r15);
    L10:
        if (r13 >= r11.size()) goto L15;
        this.output.writeEnumNoTag(r11.get(r13).intValue());
        r13 = r13 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r13 >= r11.size()) goto L19;
        this.output.writeEnum(r10, r11.get(r13).intValue());
        r13 = r13 + 1;
        goto L13
    }

    private void writeFixed32ListInternal(int r10, IntArrayList r11, boolean r12) {
        int r13 = 0;
        if (r12 == false) goto L13;
        this.output.writeTag(r10, 2);
        int r14 = 0;
        int r15 = 0;
    L6:
        if (r14 >= r11.size()) goto L8;
        r15 = r15 + CodedOutputStream.computeFixed32SizeNoTag(r11.getInt(r14));
        r14 = r14 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r15);
    L10:
        if (r13 >= r11.size()) goto L15;
        this.output.writeFixed32NoTag(r11.getInt(r13));
        r13 = r13 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r13 >= r11.size()) goto L19;
        this.output.writeFixed32(r10, r11.getInt(r13));
        r13 = r13 + 1;
        goto L13
    }

    private void writeFixed32ListInternal(int r10, List<Integer> r11, boolean r12) {
        int r13 = 0;
        if (r12 == false) goto L13;
        this.output.writeTag(r10, 2);
        int r14 = 0;
        int r15 = 0;
    L6:
        if (r14 >= r11.size()) goto L8;
        r15 = r15 + CodedOutputStream.computeFixed32SizeNoTag(r11.get(r14).intValue());
        r14 = r14 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r15);
    L10:
        if (r13 >= r11.size()) goto L15;
        this.output.writeFixed32NoTag(r11.get(r13).intValue());
        r13 = r13 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r13 >= r11.size()) goto L19;
        this.output.writeFixed32(r10, r11.get(r13).intValue());
        r13 = r13 + 1;
        goto L13
    }

    private void writeFixed64ListInternal(int r10, LongArrayList r11, boolean r12) {
        int r13 = 0;
        if (r12 == false) goto L13;
        this.output.writeTag(r10, 2);
        int r14 = 0;
        int r15 = 0;
    L6:
        if (r14 >= r11.size()) goto L8;
        r15 = r15 + CodedOutputStream.computeFixed64SizeNoTag(r11.getLong(r14));
        r14 = r14 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r15);
    L10:
        if (r13 >= r11.size()) goto L15;
        this.output.writeFixed64NoTag(r11.getLong(r13));
        r13 = r13 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r13 >= r11.size()) goto L19;
        this.output.writeFixed64(r10, r11.getLong(r13));
        r13 = r13 + 1;
        goto L13
    }

    private void writeFixed64ListInternal(int r10, List<Long> r11, boolean r12) {
        int r13 = 0;
        if (r12 == false) goto L13;
        this.output.writeTag(r10, 2);
        int r14 = 0;
        int r15 = 0;
    L6:
        if (r14 >= r11.size()) goto L8;
        r15 = r15 + CodedOutputStream.computeFixed64SizeNoTag(r11.get(r14).longValue());
        r14 = r14 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r15);
    L10:
        if (r13 >= r11.size()) goto L15;
        this.output.writeFixed64NoTag(r11.get(r13).longValue());
        r13 = r13 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r13 >= r11.size()) goto L19;
        this.output.writeFixed64(r10, r11.get(r13).longValue());
        r13 = r13 + 1;
        goto L13
    }

    private void writeFloatListInternal(int r10, FloatArrayList r11, boolean r12) {
        int r13 = 0;
        if (r12 == false) goto L13;
        this.output.writeTag(r10, 2);
        int r14 = 0;
        int r15 = 0;
    L6:
        if (r14 >= r11.size()) goto L8;
        r15 = r15 + CodedOutputStream.computeFloatSizeNoTag(r11.getFloat(r14));
        r14 = r14 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r15);
    L10:
        if (r13 >= r11.size()) goto L15;
        this.output.writeFloatNoTag(r11.getFloat(r13));
        r13 = r13 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r13 >= r11.size()) goto L19;
        this.output.writeFloat(r10, r11.getFloat(r13));
        r13 = r13 + 1;
        goto L13
    }

    private void writeFloatListInternal(int r10, List<Float> r11, boolean r12) {
        int r13 = 0;
        if (r12 == false) goto L13;
        this.output.writeTag(r10, 2);
        int r14 = 0;
        int r15 = 0;
    L6:
        if (r14 >= r11.size()) goto L8;
        r15 = r15 + CodedOutputStream.computeFloatSizeNoTag(r11.get(r14).floatValue());
        r14 = r14 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r15);
    L10:
        if (r13 >= r11.size()) goto L15;
        this.output.writeFloatNoTag(r11.get(r13).floatValue());
        r13 = r13 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r13 >= r11.size()) goto L19;
        this.output.writeFloat(r10, r11.get(r13).floatValue());
        r13 = r13 + 1;
        goto L13
    }

    private void writeInt32ListInternal(int r10, IntArrayList r11, boolean r12) {
        int r13 = 0;
        if (r12 == false) goto L13;
        this.output.writeTag(r10, 2);
        int r14 = 0;
        int r15 = 0;
    L6:
        if (r14 >= r11.size()) goto L8;
        r15 = r15 + CodedOutputStream.computeInt32SizeNoTag(r11.getInt(r14));
        r14 = r14 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r15);
    L10:
        if (r13 >= r11.size()) goto L15;
        this.output.writeInt32NoTag(r11.getInt(r13));
        r13 = r13 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r13 >= r11.size()) goto L19;
        this.output.writeInt32(r10, r11.getInt(r13));
        r13 = r13 + 1;
        goto L13
    }

    private void writeInt32ListInternal(int r10, List<Integer> r11, boolean r12) {
        int r13 = 0;
        if (r12 == false) goto L13;
        this.output.writeTag(r10, 2);
        int r14 = 0;
        int r15 = 0;
    L6:
        if (r14 >= r11.size()) goto L8;
        r15 = r15 + CodedOutputStream.computeInt32SizeNoTag(r11.get(r14).intValue());
        r14 = r14 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r15);
    L10:
        if (r13 >= r11.size()) goto L15;
        this.output.writeInt32NoTag(r11.get(r13).intValue());
        r13 = r13 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r13 >= r11.size()) goto L19;
        this.output.writeInt32(r10, r11.get(r13).intValue());
        r13 = r13 + 1;
        goto L13
    }

    private void writeInt64ListInternal(int r10, LongArrayList r11, boolean r12) {
        int r13 = 0;
        if (r12 == false) goto L13;
        this.output.writeTag(r10, 2);
        int r14 = 0;
        int r15 = 0;
    L6:
        if (r14 >= r11.size()) goto L8;
        r15 = r15 + CodedOutputStream.computeInt64SizeNoTag(r11.getLong(r14));
        r14 = r14 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r15);
    L10:
        if (r13 >= r11.size()) goto L15;
        this.output.writeInt64NoTag(r11.getLong(r13));
        r13 = r13 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r13 >= r11.size()) goto L19;
        this.output.writeInt64(r10, r11.getLong(r13));
        r13 = r13 + 1;
        goto L13
    }

    private void writeInt64ListInternal(int r10, List<Long> r11, boolean r12) {
        int r13 = 0;
        if (r12 == false) goto L13;
        this.output.writeTag(r10, 2);
        int r14 = 0;
        int r15 = 0;
    L6:
        if (r14 >= r11.size()) goto L8;
        r15 = r15 + CodedOutputStream.computeInt64SizeNoTag(r11.get(r14).longValue());
        r14 = r14 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r15);
    L10:
        if (r13 >= r11.size()) goto L15;
        this.output.writeInt64NoTag(r11.get(r13).longValue());
        r13 = r13 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r13 >= r11.size()) goto L19;
        this.output.writeInt64(r10, r11.get(r13).longValue());
        r13 = r13 + 1;
        goto L13
    }

    private void writeLazyString(int r10, Object r11) {
        boolean r12 = r11 instanceof String;
        CodedOutputStream r13 = this.output;
        if (r12 == false) goto L5;
        r13.writeString(r10, (String) r11);
        return;
    L5:
        r13.writeBytes(r10, (ByteString) r11);
    }

    private void writeSFixed32ListInternal(int r10, IntArrayList r11, boolean r12) {
        int r13 = 0;
        if (r12 == false) goto L13;
        this.output.writeTag(r10, 2);
        int r14 = 0;
        int r15 = 0;
    L6:
        if (r14 >= r11.size()) goto L8;
        r15 = r15 + CodedOutputStream.computeSFixed32SizeNoTag(r11.getInt(r14));
        r14 = r14 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r15);
    L10:
        if (r13 >= r11.size()) goto L15;
        this.output.writeSFixed32NoTag(r11.getInt(r13));
        r13 = r13 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r13 >= r11.size()) goto L19;
        this.output.writeSFixed32(r10, r11.getInt(r13));
        r13 = r13 + 1;
        goto L13
    }

    private void writeSFixed32ListInternal(int r10, List<Integer> r11, boolean r12) {
        int r13 = 0;
        if (r12 == false) goto L13;
        this.output.writeTag(r10, 2);
        int r14 = 0;
        int r15 = 0;
    L6:
        if (r14 >= r11.size()) goto L8;
        r15 = r15 + CodedOutputStream.computeSFixed32SizeNoTag(r11.get(r14).intValue());
        r14 = r14 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r15);
    L10:
        if (r13 >= r11.size()) goto L15;
        this.output.writeSFixed32NoTag(r11.get(r13).intValue());
        r13 = r13 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r13 >= r11.size()) goto L19;
        this.output.writeSFixed32(r10, r11.get(r13).intValue());
        r13 = r13 + 1;
        goto L13
    }

    private void writeSFixed64ListInternal(int r10, LongArrayList r11, boolean r12) {
        int r13 = 0;
        if (r12 == false) goto L13;
        this.output.writeTag(r10, 2);
        int r14 = 0;
        int r15 = 0;
    L6:
        if (r14 >= r11.size()) goto L8;
        r15 = r15 + CodedOutputStream.computeSFixed64SizeNoTag(r11.getLong(r14));
        r14 = r14 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r15);
    L10:
        if (r13 >= r11.size()) goto L15;
        this.output.writeSFixed64NoTag(r11.getLong(r13));
        r13 = r13 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r13 >= r11.size()) goto L19;
        this.output.writeSFixed64(r10, r11.getLong(r13));
        r13 = r13 + 1;
        goto L13
    }

    private void writeSFixed64ListInternal(int r10, List<Long> r11, boolean r12) {
        int r13 = 0;
        if (r12 == false) goto L13;
        this.output.writeTag(r10, 2);
        int r14 = 0;
        int r15 = 0;
    L6:
        if (r14 >= r11.size()) goto L8;
        r15 = r15 + CodedOutputStream.computeSFixed64SizeNoTag(r11.get(r14).longValue());
        r14 = r14 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r15);
    L10:
        if (r13 >= r11.size()) goto L15;
        this.output.writeSFixed64NoTag(r11.get(r13).longValue());
        r13 = r13 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r13 >= r11.size()) goto L19;
        this.output.writeSFixed64(r10, r11.get(r13).longValue());
        r13 = r13 + 1;
        goto L13
    }

    private void writeSInt32ListInternal(int r10, IntArrayList r11, boolean r12) {
        int r13 = 0;
        if (r12 == false) goto L13;
        this.output.writeTag(r10, 2);
        int r14 = 0;
        int r15 = 0;
    L6:
        if (r14 >= r11.size()) goto L8;
        r15 = r15 + CodedOutputStream.computeSInt32SizeNoTag(r11.getInt(r14));
        r14 = r14 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r15);
    L10:
        if (r13 >= r11.size()) goto L15;
        this.output.writeSInt32NoTag(r11.getInt(r13));
        r13 = r13 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r13 >= r11.size()) goto L19;
        this.output.writeSInt32(r10, r11.getInt(r13));
        r13 = r13 + 1;
        goto L13
    }

    private void writeSInt64ListInternal(int r10, LongArrayList r11, boolean r12) {
        int r13 = 0;
        if (r12 == false) goto L13;
        this.output.writeTag(r10, 2);
        int r14 = 0;
        int r15 = 0;
    L6:
        if (r14 >= r11.size()) goto L8;
        r15 = r15 + CodedOutputStream.computeSInt64SizeNoTag(r11.getLong(r14));
        r14 = r14 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r15);
    L10:
        if (r13 >= r11.size()) goto L15;
        this.output.writeSInt64NoTag(r11.getLong(r13));
        r13 = r13 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r13 >= r11.size()) goto L19;
        this.output.writeSInt64(r10, r11.getLong(r13));
        r13 = r13 + 1;
        goto L13
    }

    private void writeSInt64ListInternal(int r10, List<Long> r11, boolean r12) {
        int r13 = 0;
        if (r12 == false) goto L13;
        this.output.writeTag(r10, 2);
        int r14 = 0;
        int r15 = 0;
    L6:
        if (r14 >= r11.size()) goto L8;
        r15 = r15 + CodedOutputStream.computeSInt64SizeNoTag(r11.get(r14).longValue());
        r14 = r14 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r15);
    L10:
        if (r13 >= r11.size()) goto L15;
        this.output.writeSInt64NoTag(r11.get(r13).longValue());
        r13 = r13 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r13 >= r11.size()) goto L19;
        this.output.writeSInt64(r10, r11.get(r13).longValue());
        r13 = r13 + 1;
        goto L13
    }

    private void writeUInt32ListInternal(int r10, IntArrayList r11, boolean r12) {
        int r13 = 0;
        if (r12 == false) goto L13;
        this.output.writeTag(r10, 2);
        int r14 = 0;
        int r15 = 0;
    L6:
        if (r14 >= r11.size()) goto L8;
        r15 = r15 + CodedOutputStream.computeUInt32SizeNoTag(r11.getInt(r14));
        r14 = r14 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r15);
    L10:
        if (r13 >= r11.size()) goto L15;
        this.output.writeUInt32NoTag(r11.getInt(r13));
        r13 = r13 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r13 >= r11.size()) goto L19;
        this.output.writeUInt32(r10, r11.getInt(r13));
        r13 = r13 + 1;
        goto L13
    }

    private void writeUInt64ListInternal(int r10, LongArrayList r11, boolean r12) {
        int r13 = 0;
        if (r12 == false) goto L13;
        this.output.writeTag(r10, 2);
        int r14 = 0;
        int r15 = 0;
    L6:
        if (r14 >= r11.size()) goto L8;
        r15 = r15 + CodedOutputStream.computeUInt64SizeNoTag(r11.getLong(r14));
        r14 = r14 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r15);
    L10:
        if (r13 >= r11.size()) goto L15;
        this.output.writeUInt64NoTag(r11.getLong(r13));
        r13 = r13 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r13 >= r11.size()) goto L19;
        this.output.writeUInt64(r10, r11.getLong(r13));
        r13 = r13 + 1;
        goto L13
    }

    private void writeUInt64ListInternal(int r10, List<Long> r11, boolean r12) {
        int r13 = 0;
        if (r12 == false) goto L13;
        this.output.writeTag(r10, 2);
        int r14 = 0;
        int r15 = 0;
    L6:
        if (r14 >= r11.size()) goto L8;
        r15 = r15 + CodedOutputStream.computeUInt64SizeNoTag(r11.get(r14).longValue());
        r14 = r14 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r15);
    L10:
        if (r13 >= r11.size()) goto L15;
        this.output.writeUInt64NoTag(r11.get(r13).longValue());
        r13 = r13 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r13 >= r11.size()) goto L19;
        this.output.writeUInt64(r10, r11.get(r13).longValue());
        r13 = r13 + 1;
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
    public void writeBool(int r10, boolean r11) {
        this.output.writeBool(r10, r11);
    }

    @Override // com.google.protobuf.Writer
    public void writeBoolList(int r10, List<Boolean> r11, boolean r12) {
        if ((r11 instanceof BooleanArrayList) == false) goto L5;
        writeBoolListInternal(r10, (BooleanArrayList) r11, r12);
        return;
    L5:
        writeBoolListInternal(r10, r11, r12);
    }

    @Override // com.google.protobuf.Writer
    public void writeBytes(int r10, ByteString r11) {
        this.output.writeBytes(r10, r11);
    }

    @Override // com.google.protobuf.Writer
    public void writeBytesList(int r10, List<ByteString> r11) {
        int r12 = 0;
    L4:
        if (r12 >= r11.size()) goto L6;
        this.output.writeBytes(r10, r11.get(r12));
        r12 = r12 + 1;
        goto L4
    }

    @Override // com.google.protobuf.Writer
    public void writeDouble(int r10, double r11) {
        this.output.writeDouble(r10, r11);
    }

    @Override // com.google.protobuf.Writer
    public void writeDoubleList(int r10, List<Double> r11, boolean r12) {
        if ((r11 instanceof DoubleArrayList) == false) goto L5;
        writeDoubleListInternal(r10, (DoubleArrayList) r11, r12);
        return;
    L5:
        writeDoubleListInternal(r10, r11, r12);
    }

    @Override // com.google.protobuf.Writer
    @Deprecated
    public void writeEndGroup(int r10) {
        this.output.writeTag(r10, 4);
    }

    @Override // com.google.protobuf.Writer
    public void writeEnum(int r10, int r11) {
        this.output.writeEnum(r10, r11);
    }

    @Override // com.google.protobuf.Writer
    public void writeEnumList(int r10, List<Integer> r11, boolean r12) {
        if ((r11 instanceof IntArrayList) == false) goto L5;
        writeEnumListInternal(r10, (IntArrayList) r11, r12);
        return;
    L5:
        writeEnumListInternal(r10, r11, r12);
    }

    @Override // com.google.protobuf.Writer
    public void writeFixed32(int r10, int r11) {
        this.output.writeFixed32(r10, r11);
    }

    @Override // com.google.protobuf.Writer
    public void writeFixed32List(int r10, List<Integer> r11, boolean r12) {
        if ((r11 instanceof IntArrayList) == false) goto L5;
        writeFixed32ListInternal(r10, (IntArrayList) r11, r12);
        return;
    L5:
        writeFixed32ListInternal(r10, r11, r12);
    }

    @Override // com.google.protobuf.Writer
    public void writeFixed64(int r10, long r11) {
        this.output.writeFixed64(r10, r11);
    }

    @Override // com.google.protobuf.Writer
    public void writeFixed64List(int r10, List<Long> r11, boolean r12) {
        if ((r11 instanceof LongArrayList) == false) goto L5;
        writeFixed64ListInternal(r10, (LongArrayList) r11, r12);
        return;
    L5:
        writeFixed64ListInternal(r10, r11, r12);
    }

    @Override // com.google.protobuf.Writer
    public void writeFloat(int r10, float r11) {
        this.output.writeFloat(r10, r11);
    }

    @Override // com.google.protobuf.Writer
    public void writeFloatList(int r10, List<Float> r11, boolean r12) {
        if ((r11 instanceof FloatArrayList) == false) goto L5;
        writeFloatListInternal(r10, (FloatArrayList) r11, r12);
        return;
    L5:
        writeFloatListInternal(r10, r11, r12);
    }

    @Override // com.google.protobuf.Writer
    @Deprecated
    public void writeGroup(int r10, Object r11) {
        this.output.writeGroup(r10, (MessageLite) r11);
    }

    @Override // com.google.protobuf.Writer
    public void writeGroup(int r10, Object r11, Schema r12) {
        this.output.writeGroup(r10, (MessageLite) r11, r12);
    }

    @Override // com.google.protobuf.Writer
    @Deprecated
    public void writeGroupList(int r10, List<?> r11) {
        int r12 = 0;
    L4:
        if (r12 >= r11.size()) goto L6;
        writeGroup(r10, r11.get(r12));
        r12 = r12 + 1;
        goto L4
    }

    @Override // com.google.protobuf.Writer
    public void writeGroupList(int r10, List<?> r11, Schema r12) {
        int r13 = 0;
    L4:
        if (r13 >= r11.size()) goto L6;
        writeGroup(r10, r11.get(r13), r12);
        r13 = r13 + 1;
        goto L4
    }

    @Override // com.google.protobuf.Writer
    public void writeInt32(int r10, int r11) {
        this.output.writeInt32(r10, r11);
    }

    @Override // com.google.protobuf.Writer
    public void writeInt32List(int r10, List<Integer> r11, boolean r12) {
        if ((r11 instanceof IntArrayList) == false) goto L5;
        writeInt32ListInternal(r10, (IntArrayList) r11, r12);
        return;
    L5:
        writeInt32ListInternal(r10, r11, r12);
    }

    @Override // com.google.protobuf.Writer
    public void writeInt64(int r10, long r11) {
        this.output.writeInt64(r10, r11);
    }

    @Override // com.google.protobuf.Writer
    public void writeInt64List(int r10, List<Long> r11, boolean r12) {
        if ((r11 instanceof LongArrayList) == false) goto L5;
        writeInt64ListInternal(r10, (LongArrayList) r11, r12);
        return;
    L5:
        writeInt64ListInternal(r10, r11, r12);
    }

    @Override // com.google.protobuf.Writer
    public <K, V> void writeMap(int r10, MapEntryLite.Metadata<K, V> r11, Map<K, V> r12) {
        if (this.output.isSerializationDeterministic() == false) goto L6;
        writeDeterministicMap(r10, r11, r12);
        return;
    L6:
        Iterator<Map.Entry<K, V>> r13 = r12.entrySet().iterator();
    L8:
        if (r13.hasNext() == false) goto L10;
        Map.Entry<K, V> r14 = r13.next();
        this.output.writeTag(r10, 2);
        this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(r11, r14.getKey(), r14.getValue()));
        MapEntryLite.writeTo(this.output, r11, r14.getKey(), r14.getValue());
        goto L8
    }

    @Override // com.google.protobuf.Writer
    public void writeMessage(int r10, Object r11) {
        this.output.writeMessage(r10, (MessageLite) r11);
    }

    @Override // com.google.protobuf.Writer
    public void writeMessage(int r10, Object r11, Schema r12) {
        this.output.writeMessage(r10, (MessageLite) r11, r12);
    }

    @Override // com.google.protobuf.Writer
    public void writeMessageList(int r10, List<?> r11) {
        int r12 = 0;
    L4:
        if (r12 >= r11.size()) goto L6;
        writeMessage(r10, r11.get(r12));
        r12 = r12 + 1;
        goto L4
    }

    @Override // com.google.protobuf.Writer
    public void writeMessageList(int r10, List<?> r11, Schema r12) {
        int r13 = 0;
    L4:
        if (r13 >= r11.size()) goto L6;
        writeMessage(r10, r11.get(r13), r12);
        r13 = r13 + 1;
        goto L4
    }

    @Override // com.google.protobuf.Writer
    public final void writeMessageSetItem(int r10, Object r11) {
        boolean r12 = r11 instanceof ByteString;
        CodedOutputStream r13 = this.output;
        if (r12 == false) goto L5;
        r13.writeRawMessageSetExtension(r10, (ByteString) r11);
        return;
    L5:
        r13.writeMessageSetExtension(r10, (MessageLite) r11);
    }

    @Override // com.google.protobuf.Writer
    public void writeSFixed32(int r10, int r11) {
        this.output.writeSFixed32(r10, r11);
    }

    @Override // com.google.protobuf.Writer
    public void writeSFixed32List(int r10, List<Integer> r11, boolean r12) {
        if ((r11 instanceof IntArrayList) == false) goto L5;
        writeSFixed32ListInternal(r10, (IntArrayList) r11, r12);
        return;
    L5:
        writeSFixed32ListInternal(r10, r11, r12);
    }

    @Override // com.google.protobuf.Writer
    public void writeSFixed64(int r10, long r11) {
        this.output.writeSFixed64(r10, r11);
    }

    @Override // com.google.protobuf.Writer
    public void writeSFixed64List(int r10, List<Long> r11, boolean r12) {
        if ((r11 instanceof LongArrayList) == false) goto L5;
        writeSFixed64ListInternal(r10, (LongArrayList) r11, r12);
        return;
    L5:
        writeSFixed64ListInternal(r10, r11, r12);
    }

    @Override // com.google.protobuf.Writer
    public void writeSInt32(int r10, int r11) {
        this.output.writeSInt32(r10, r11);
    }

    @Override // com.google.protobuf.Writer
    public void writeSInt32List(int r10, List<Integer> r11, boolean r12) {
        if ((r11 instanceof IntArrayList) == false) goto L5;
        writeSInt32ListInternal(r10, (IntArrayList) r11, r12);
        return;
    L5:
        writeSInt32ListInternal(r10, r11, r12);
    }

    public void writeSInt32ListInternal(int r10, List<Integer> r11, boolean r12) {
        int r13 = 0;
        if (r12 == false) goto L13;
        this.output.writeTag(r10, 2);
        int r14 = 0;
        int r15 = 0;
    L6:
        if (r14 >= r11.size()) goto L8;
        r15 = r15 + CodedOutputStream.computeSInt32SizeNoTag(r11.get(r14).intValue());
        r14 = r14 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r15);
    L10:
        if (r13 >= r11.size()) goto L15;
        this.output.writeSInt32NoTag(r11.get(r13).intValue());
        r13 = r13 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r13 >= r11.size()) goto L19;
        this.output.writeSInt32(r10, r11.get(r13).intValue());
        r13 = r13 + 1;
        goto L13
    }

    @Override // com.google.protobuf.Writer
    public void writeSInt64(int r10, long r11) {
        this.output.writeSInt64(r10, r11);
    }

    @Override // com.google.protobuf.Writer
    public void writeSInt64List(int r10, List<Long> r11, boolean r12) {
        if ((r11 instanceof LongArrayList) == false) goto L5;
        writeSInt64ListInternal(r10, (LongArrayList) r11, r12);
        return;
    L5:
        writeSInt64ListInternal(r10, r11, r12);
    }

    @Override // com.google.protobuf.Writer
    @Deprecated
    public void writeStartGroup(int r10) {
        this.output.writeTag(r10, 3);
    }

    @Override // com.google.protobuf.Writer
    public void writeString(int r10, String r11) {
        this.output.writeString(r10, r11);
    }

    @Override // com.google.protobuf.Writer
    public void writeStringList(int r10, List<String> r11) {
        int r12 = 0;
        if ((r11 instanceof LazyStringList) == false) goto L9;
        LazyStringList r13 = (LazyStringList) r11;
    L6:
        if (r12 >= r11.size()) goto L11;
        writeLazyString(r10, r13.getRaw(r12));
        r12 = r12 + 1;
        goto L6
    L11:
        return;
    L9:
        if (r12 >= r11.size()) goto L14;
        this.output.writeString(r10, r11.get(r12));
        r12 = r12 + 1;
        goto L9
    }

    @Override // com.google.protobuf.Writer
    public void writeUInt32(int r10, int r11) {
        this.output.writeUInt32(r10, r11);
    }

    @Override // com.google.protobuf.Writer
    public void writeUInt32List(int r10, List<Integer> r11, boolean r12) {
        if ((r11 instanceof IntArrayList) == false) goto L5;
        writeUInt32ListInternal(r10, (IntArrayList) r11, r12);
        return;
    L5:
        writeUInt32ListInternal(r10, r11, r12);
    }

    public void writeUInt32ListInternal(int r10, List<Integer> r11, boolean r12) {
        int r13 = 0;
        if (r12 == false) goto L13;
        this.output.writeTag(r10, 2);
        int r14 = 0;
        int r15 = 0;
    L6:
        if (r14 >= r11.size()) goto L8;
        r15 = r15 + CodedOutputStream.computeUInt32SizeNoTag(r11.get(r14).intValue());
        r14 = r14 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r15);
    L10:
        if (r13 >= r11.size()) goto L15;
        this.output.writeUInt32NoTag(r11.get(r13).intValue());
        r13 = r13 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r13 >= r11.size()) goto L19;
        this.output.writeUInt32(r10, r11.get(r13).intValue());
        r13 = r13 + 1;
        goto L13
    }

    @Override // com.google.protobuf.Writer
    public void writeUInt64(int r10, long r11) {
        this.output.writeUInt64(r10, r11);
    }

    @Override // com.google.protobuf.Writer
    public void writeUInt64List(int r10, List<Long> r11, boolean r12) {
        if ((r11 instanceof LongArrayList) == false) goto L5;
        writeUInt64ListInternal(r10, (LongArrayList) r11, r12);
        return;
    L5:
        writeUInt64ListInternal(r10, r11, r12);
    }
}
