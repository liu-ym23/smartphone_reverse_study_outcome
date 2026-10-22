package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.FieldDescriptorLite;

/* JADX INFO: loaded from: classes3.dex */
final class FieldSet<FieldDescriptorType extends FieldDescriptorLite<FieldDescriptorType>> {
    private static final FieldSet DEFAULT_INSTANCE = null;
    private final SmallSortedMap<FieldDescriptorType, Object> fields;
    private boolean hasLazyField;
    private boolean isImmutable;

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.protobuf.FieldSet$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType = null;
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$JavaType = null;

        static {
            int[] r10 = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = r10;
            r10[WireFormat.FieldType.DOUBLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L40
        L81:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L41
        L97:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 3;     // Catch: NoSuchFieldError -> L42
        L105:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 4;     // Catch: NoSuchFieldError -> L43
        L109:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 5;     // Catch: NoSuchFieldError -> L44
        L69:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 6;     // Catch: NoSuchFieldError -> L45
        L71:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 7;     // Catch: NoSuchFieldError -> L46
        L89:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BOOL.ordinal()] = 8;     // Catch: NoSuchFieldError -> L47
        L91:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 9;     // Catch: NoSuchFieldError -> L48
        L111:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 10;     // Catch: NoSuchFieldError -> L49
        L115:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 11;     // Catch: NoSuchFieldError -> L50
        L73:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 12;     // Catch: NoSuchFieldError -> L51
        L79:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 13;     // Catch: NoSuchFieldError -> L52
        L95:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 14;     // Catch: NoSuchFieldError -> L53
        L101:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 15;     // Catch: NoSuchFieldError -> L54
        L119:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.GROUP.ordinal()] = 16;     // Catch: NoSuchFieldError -> L55
        L67:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 17;     // Catch: NoSuchFieldError -> L56
        L83:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 18;     // Catch: NoSuchFieldError -> L57
        L29:
            int[] r11 = new int[WireFormat.JavaType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$JavaType = r11;
            r11[WireFormat.JavaType.INT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L58
        L103:
            $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.LONG.ordinal()] = 2;     // Catch: NoSuchFieldError -> L59
        L107:
            $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.FLOAT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L60
        L117:
            $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.DOUBLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L61
        L75:
            $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.BOOLEAN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L62
        L85:
            $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.STRING.ordinal()] = 6;     // Catch: NoSuchFieldError -> L63
        L87:
            $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.BYTE_STRING.ordinal()] = 7;     // Catch: NoSuchFieldError -> L64
        L93:
            $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.ENUM.ordinal()] = 8;     // Catch: NoSuchFieldError -> L65
        L113:
            $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.MESSAGE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L66
            return;
        }
    }

    public interface FieldDescriptorLite<T extends FieldDescriptorLite<T>> extends Comparable<T> {
        WireFormat.JavaType getLiteJavaType();

        WireFormat.FieldType getLiteType();

        int getNumber();

        MessageLite.Builder internalMergeFrom(MessageLite.Builder r10, MessageLite r11);

        boolean isPacked();

        boolean isRepeated();
    }

    static {
        DEFAULT_INSTANCE = new FieldSet(true);
    }

    private FieldSet() {
        this.hasLazyField = false;
        this.fields = SmallSortedMap.newFieldMap(16);
    }

    private FieldSet(boolean r10) {
        this.hasLazyField = false;
        this.fields = SmallSortedMap.newFieldMap(0);
        makeImmutable();
    }

    private Object cloneIfMutable(Object r10) {
        if ((r10 instanceof byte[]) == false) goto L6;
        byte[] r11 = (byte[]) r10;
        byte[] r12 = new byte[r11.length];
        System.arraycopy(r11, 0, r12, 0, r11.length);
        return r12;
    L6:
        return r10;
    }

    private static int computeElementSize(WireFormat.FieldType r10, int r11, Object r12) {
        int r13 = CodedOutputStream.computeTagSize(r11);
        if (r10 != WireFormat.FieldType.GROUP) goto L6;
        r13 = r13 * 2;
    L6:
        return r13 + computeElementSizeNoTag(r10, r12);
    }

    private static int computeElementSizeNoTag(WireFormat.FieldType r10, Object r11) {
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r10.ordinal()]) {
            case 1: goto L53;
            case 2: goto L51;
            case 3: goto L49;
            case 4: goto L47;
            case 5: goto L45;
            case 6: goto L43;
            case 7: goto L41;
            case 8: goto L39;
            case 9: goto L37;
            case 10: goto L31;
            case 11: goto L29;
            case 12: goto L27;
            case 13: goto L25;
            case 14: goto L23;
            case 15: goto L21;
            case 16: goto L19;
            case 17: goto L13;
            case 18: goto L7;
            default: goto L5;
        };
    L5:
        throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
    L7:
        if ((r11 instanceof Internal.EnumLite) == false) goto L11;
        return CodedOutputStream.computeEnumSizeNoTag(((Internal.EnumLite) r11).getNumber());
    L11:
        return CodedOutputStream.computeEnumSizeNoTag(((Integer) r11).intValue());
    L13:
        if ((r11 instanceof LazyField) == false) goto L17;
        return CodedOutputStream.computeLazyFieldSizeNoTag((LazyField) r11);
    L17:
        return CodedOutputStream.computeMessageSizeNoTag((MessageLite) r11);
    L19:
        return CodedOutputStream.computeGroupSizeNoTag((MessageLite) r11);
    L21:
        return CodedOutputStream.computeSInt64SizeNoTag(((Long) r11).longValue());
    L23:
        return CodedOutputStream.computeSInt32SizeNoTag(((Integer) r11).intValue());
    L25:
        return CodedOutputStream.computeSFixed64SizeNoTag(((Long) r11).longValue());
    L27:
        return CodedOutputStream.computeSFixed32SizeNoTag(((Integer) r11).intValue());
    L29:
        return CodedOutputStream.computeUInt32SizeNoTag(((Integer) r11).intValue());
    L31:
        if ((r11 instanceof ByteString) == false) goto L35;
        return CodedOutputStream.computeBytesSizeNoTag((ByteString) r11);
    L35:
        return CodedOutputStream.computeByteArraySizeNoTag((byte[]) r11);
    L37:
        return CodedOutputStream.computeStringSizeNoTag((String) r11);
    L39:
        return CodedOutputStream.computeBoolSizeNoTag(((Boolean) r11).booleanValue());
    L41:
        return CodedOutputStream.computeFixed32SizeNoTag(((Integer) r11).intValue());
    L43:
        return CodedOutputStream.computeFixed64SizeNoTag(((Long) r11).longValue());
    L45:
        return CodedOutputStream.computeInt32SizeNoTag(((Integer) r11).intValue());
    L47:
        return CodedOutputStream.computeUInt64SizeNoTag(((Long) r11).longValue());
    L49:
        return CodedOutputStream.computeInt64SizeNoTag(((Long) r11).longValue());
    L51:
        return CodedOutputStream.computeFloatSizeNoTag(((Float) r11).floatValue());
    L53:
        return CodedOutputStream.computeDoubleSizeNoTag(((Double) r11).doubleValue());
    }

    public static int computeFieldSize(FieldDescriptorLite<?> r10, Object r11) {
        WireFormat.FieldType r12 = r10.getLiteType();
        int r13 = r10.getNumber();
        if (r10.isRepeated() == false) goto L18;
        int r14 = 0;
        List r15 = (List) r11;
        if (r10.isPacked() == false) goto L12;
        Iterator r16 = r15.iterator();
    L8:
        if (r16.hasNext() == false) goto L11;
        r14 = r14 + computeElementSizeNoTag(r12, r16.next());
        goto L8
    L11:
        return (CodedOutputStream.computeTagSize(r13) + r14) + CodedOutputStream.computeRawVarint32Size(r14);
    L12:
        Iterator r17 = r15.iterator();
    L14:
        if (r17.hasNext() == false) goto L16;
        r14 = r14 + computeElementSize(r12, r13, r17.next());
        goto L14
    L16:
        return r14;
    L18:
        return computeElementSize(r12, r13, r11);
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet<T> emptySet() {
        return DEFAULT_INSTANCE;
    }

    static int getWireFormatForFieldType(WireFormat.FieldType r10, boolean r11) {
        if (r11 == false) goto L6;
        return 2;
    L6:
        return r10.getWireType();
    }

    private boolean isInitialized(Map.Entry<FieldDescriptorType, Object> r10) {
        FieldDescriptorType r11 = r10.getKey();
        if (r11.getLiteJavaType() == WireFormat.JavaType.MESSAGE) goto L5;
    L22:
        return true;
    L5:
        if (r11.isRepeated() == false) goto L12;
        Iterator r12 = ((List) r10.getValue()).iterator();
    L8:
        if (r12.hasNext() == false) goto L22;
        if (((MessageLite) r12.next()).isInitialized() == true) goto L8;
        return false;
    L12:
        Object r13 = r10.getValue();
        if ((r13 instanceof MessageLite) == false) goto L18;
        if (((MessageLite) r13).isInitialized() == true) goto L22;
        return false;
    L18:
        if ((r13 instanceof LazyField) == false) goto L21;
        return true;
    L21:
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private void mergeFromField(Map.Entry<FieldDescriptorType, Object> r10) {
        FieldDescriptorType r11 = r10.getKey();
        Object r12 = r10.getValue();
        if ((r12 instanceof LazyField) == false) goto L6;
        r12 = ((LazyField) r12).getValue();
    L6:
        if (r11.isRepeated() == false) goto L16;
        Object r13 = getField(r11);
        if (r13 != null) goto L10;
        r13 = new ArrayList();
    L10:
        Iterator r14 = ((List) r12).iterator();
    L12:
        if (r14.hasNext() == false) goto L14;
        ((List) r13).add(cloneIfMutable(r14.next()));
        goto L12
    L14:
        this.fields.put(r11, r13);
        return;
    L16:
        if (r11.getLiteJavaType() != WireFormat.JavaType.MESSAGE) goto L21;
        Object r15 = getField(r11);
        if (r15 == null) goto L21;
        MessageLite r16 = r11.internalMergeFrom(((MessageLite) r15).toBuilder(), (MessageLite) r12).build();
        this.fields.put(r11, r16);
        return;
    L21:
        this.fields.put(r11, cloneIfMutable(r12));
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet<T> newFieldSet() {
        return new FieldSet();
    }

    public static Object readPrimitiveField(CodedInputStream r10, WireFormat.FieldType r11, boolean r12) {
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r11.ordinal()]) {
            case 1: goto L44;
            case 2: goto L42;
            case 3: goto L40;
            case 4: goto L38;
            case 5: goto L36;
            case 6: goto L34;
            case 7: goto L32;
            case 8: goto L30;
            case 9: goto L24;
            case 10: goto L23;
            case 11: goto L21;
            case 12: goto L19;
            case 13: goto L17;
            case 14: goto L15;
            case 15: goto L13;
            case 16: goto L11;
            case 17: goto L9;
            case 18: goto L7;
            default: goto L5;
        };
    L24:
        if (r12 == false) goto L28;
        return r10.readStringRequireUtf8();
    L28:
        return r10.readString();
    L5:
        throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
    L7:
        throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
    L9:
        throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
    L11:
        throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
    L13:
        return Long.valueOf(r10.readSInt64());
    L15:
        return Integer.valueOf(r10.readSInt32());
    L17:
        return Long.valueOf(r10.readSFixed64());
    L19:
        return Integer.valueOf(r10.readSFixed32());
    L21:
        return Integer.valueOf(r10.readUInt32());
    L23:
        return r10.readBytes();
    L30:
        return Boolean.valueOf(r10.readBool());
    L32:
        return Integer.valueOf(r10.readFixed32());
    L34:
        return Long.valueOf(r10.readFixed64());
    L36:
        return Integer.valueOf(r10.readInt32());
    L38:
        return Long.valueOf(r10.readUInt64());
    L40:
        return Long.valueOf(r10.readInt64());
    L42:
        return Float.valueOf(r10.readFloat());
    L44:
        return Double.valueOf(r10.readDouble());
    }

    private static void verifyType(WireFormat.FieldType r10, Object r11) {
        Objects.requireNonNull(r11);
        boolean r12 = true;
        boolean r13 = false;
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$JavaType[r10.getJavaType().ordinal()]) {
            case 1: goto L27;
            case 2: goto L26;
            case 3: goto L25;
            case 4: goto L24;
            case 5: goto L23;
            case 6: goto L22;
            case 7: goto L16;
            case 8: goto L11;
            case 9: goto L6;
            default: goto L28;
        };
    L22:
        r13 = r11 instanceof String;
        goto L28
    L23:
        r13 = r11 instanceof Boolean;
        goto L28
    L24:
        r13 = r11 instanceof Double;
        goto L28
    L25:
        r13 = r11 instanceof Float;
        goto L28
    L26:
        r13 = r11 instanceof Long;
        goto L28
    L27:
        r13 = r11 instanceof Integer;
    L28:
        if (r13 == false) goto L31;
        return;
    L31:
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    L6:
        if ((r11 instanceof MessageLite) == false) goto L8;
    L21:
        r13 = r12;
        goto L28
    L8:
        if ((r11 instanceof LazyField) == true) goto L21;
    L20:
        r12 = false;
        goto L21
    L11:
        if ((r11 instanceof Integer) == true) goto L21;
        if ((r11 instanceof Internal.EnumLite) == false) goto L20;
    L16:
        if ((r11 instanceof ByteString) == true) goto L21;
        if ((r11 instanceof byte[]) == false) goto L20;
        goto L20
    }

    private static void writeElement(CodedOutputStream r10, WireFormat.FieldType r11, int r12, Object r13) {
        if (r11 != WireFormat.FieldType.GROUP) goto L5;
        r10.writeGroup(r12, (MessageLite) r13);
        return;
    L5:
        r10.writeTag(r12, getWireFormatForFieldType(r11, false));
        writeElementNoTag(r10, r11, r13);
    }

    private static void writeElementNoTag(CodedOutputStream r10, WireFormat.FieldType r11, Object r12) {
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r11.ordinal()]) {
            case 1: goto L29;
            case 2: goto L28;
            case 3: goto L27;
            case 4: goto L26;
            case 5: goto L25;
            case 6: goto L24;
            case 7: goto L23;
            case 8: goto L22;
            case 9: goto L21;
            case 10: goto L18;
            case 11: goto L16;
            case 12: goto L15;
            case 13: goto L14;
            case 14: goto L13;
            case 15: goto L12;
            case 16: goto L11;
            case 17: goto L10;
            case 18: goto L6;
            default: goto L49;
        };
    L10:
        r10.writeMessageNoTag((MessageLite) r12);
        return;
    L11:
        r10.writeGroupNoTag((MessageLite) r12);
        return;
    L12:
        r10.writeSInt64NoTag(((Long) r12).longValue());
        return;
    L13:
        r10.writeSInt32NoTag(((Integer) r12).intValue());
        return;
    L14:
        r10.writeSFixed64NoTag(((Long) r12).longValue());
        return;
    L15:
        r10.writeSFixed32NoTag(((Integer) r12).intValue());
        return;
    L16:
        r10.writeUInt32NoTag(((Integer) r12).intValue());
        return;
    L21:
        r10.writeStringNoTag((String) r12);
        return;
    L22:
        r10.writeBoolNoTag(((Boolean) r12).booleanValue());
        return;
    L23:
        r10.writeFixed32NoTag(((Integer) r12).intValue());
        return;
    L24:
        r10.writeFixed64NoTag(((Long) r12).longValue());
        return;
    L25:
        r10.writeInt32NoTag(((Integer) r12).intValue());
        return;
    L26:
        r10.writeUInt64NoTag(((Long) r12).longValue());
        return;
    L27:
        r10.writeInt64NoTag(((Long) r12).longValue());
        return;
    L28:
        r10.writeFloatNoTag(((Float) r12).floatValue());
        return;
    L29:
        r10.writeDoubleNoTag(((Double) r12).doubleValue());
        return;
    L49:
        return;
    L6:
        if ((r12 instanceof Internal.EnumLite) == false) goto L8;
        int r13 = ((Internal.EnumLite) r12).getNumber();
    L9:
        r10.writeEnumNoTag(r13);
        return;
    L8:
        r13 = ((Integer) r12).intValue();
        goto L9
    L18:
        if ((r12 instanceof ByteString) == false) goto L20;
        r10.writeBytesNoTag((ByteString) r12);
        return;
    L20:
        r10.writeByteArrayNoTag((byte[]) r12);
    }

    public static void writeField(FieldDescriptorLite<?> r10, Object r11, CodedOutputStream r12) {
        WireFormat.FieldType r13 = r10.getLiteType();
        int r14 = r10.getNumber();
        if (r10.isRepeated() == false) goto L19;
        List r15 = (List) r11;
        if (r10.isPacked() == false) goto L14;
        r12.writeTag(r14, 2);
        int r16 = 0;
        Iterator r17 = r15.iterator();
    L8:
        if (r17.hasNext() == false) goto L10;
        r16 = r16 + computeElementSizeNoTag(r13, r17.next());
        goto L8
    L10:
        r12.writeRawVarint32(r16);
        Iterator r18 = r15.iterator();
    L12:
        if (r18.hasNext() == false) goto L27;
        writeElementNoTag(r12, r13, r18.next());
        goto L12
    L27:
        return;
    L14:
        Iterator r19 = r15.iterator();
    L16:
        if (r19.hasNext() == false) goto L28;
        writeElement(r12, r13, r14, r19.next());
        goto L16
    L28:
        return;
    L19:
        if ((r11 instanceof LazyField) == false) goto L21;
        writeElement(r12, r13, r14, ((LazyField) r11).getValue());
        return;
    L21:
        writeElement(r12, r13, r14, r11);
    }

    public void addRepeatedField(FieldDescriptorType r10, Object r11) {
        if (r10.isRepeated() == false) goto L11;
        verifyType(r10.getLiteType(), r11);
        Object r12 = getField(r10);
        if (r12 != null) goto L7;
        List r13 = new ArrayList();
        this.fields.put(r10, r13);
    L8:
        r13.add(r11);
        return;
    L7:
        r13 = (List) r12;
        goto L8
    L11:
        throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }

    public /* bridge */ /* synthetic */ Object clone() {
        return m1322clone();
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public FieldSet<FieldDescriptorType> m1322clone() {
        FieldSet<FieldDescriptorType> r10 = newFieldSet();
        int r11 = 0;
    L4:
        if (r11 >= this.fields.getNumArrayEntries()) goto L6;
        Map.Entry<K, Object> r12 = this.fields.getArrayEntryAt(r11);
        r10.setField((FieldDescriptorLite) r12.getKey(), r12.getValue());
        r11 = r11 + 1;
        goto L4
    L6:
        Iterator r13 = this.fields.getOverflowEntries().iterator();
    L8:
        if (r13.hasNext() == false) goto L10;
        Map.Entry r14 = (Map.Entry) r13.next();
        r10.setField((FieldDescriptorLite) r14.getKey(), r14.getValue());
        goto L8
    L10:
        r10.hasLazyField = this.hasLazyField;
        return r10;
    }

    public Object getField(FieldDescriptorType r10) {
        Object r11 = this.fields.get(r10);
        if ((r11 instanceof LazyField) == true) goto L5;
        return r11;
    L5:
        return ((LazyField) r11).getValue();
    }

    public Object getRepeatedField(FieldDescriptorType r10, int r11) {
        if (r10.isRepeated() == false) goto L11;
        Object r12 = getField(r10);
        if (r12 == null) goto L9;
        return ((List) r12).get(r11);
    L9:
        throw new IndexOutOfBoundsException();
    L11:
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public int getRepeatedFieldCount(FieldDescriptorType r10) {
        if (r10.isRepeated() == false) goto L11;
        Object r11 = getField(r10);
        if (r11 != null) goto L9;
        return 0;
    L9:
        return ((List) r11).size();
    L11:
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public int getSerializedSize() {
        int r10 = 0;
        int r11 = 0;
    L4:
        if (r10 >= this.fields.getNumArrayEntries()) goto L6;
        Map.Entry<K, Object> r12 = this.fields.getArrayEntryAt(r10);
        r11 = r11 + computeFieldSize((FieldDescriptorLite) r12.getKey(), r12.getValue());
        r10 = r10 + 1;
        goto L4
    L6:
        Iterator r13 = this.fields.getOverflowEntries().iterator();
    L8:
        if (r13.hasNext() == false) goto L10;
        Map.Entry r14 = (Map.Entry) r13.next();
        r11 = r11 + computeFieldSize((FieldDescriptorLite) r14.getKey(), r14.getValue());
        goto L8
    L10:
        return r11;
    }

    public boolean hasField(FieldDescriptorType r10) {
        if (r10.isRepeated() == true) goto L10;
        if (this.fields.get(r10) == null) goto L7;
        return true;
    L7:
        return false;
    L10:
        throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
    }

    public boolean isInitialized() {
        int r10 = 0;
    L4:
        if (r10 >= this.fields.getNumArrayEntries()) goto L9;
        if (isInitialized(this.fields.getArrayEntryAt(r10)) == false) goto L7;
        r10 = r10 + 1;
        goto L4
    L7:
        return false;
    L9:
        Iterator r11 = this.fields.getOverflowEntries().iterator();
    L11:
        if (r11.hasNext() == false) goto L15;
        if (isInitialized((Map.Entry) r11.next()) == true) goto L11;
        return false;
    L15:
        return true;
    }

    public Iterator<Map.Entry<FieldDescriptorType, Object>> iterator() {
        if (this.hasLazyField == false) goto L7;
        return new LazyField.LazyIterator(this.fields.entrySet().iterator());
    L7:
        return this.fields.entrySet().iterator();
    }

    public void makeImmutable() {
        if (this.isImmutable == false) goto L5;
        return;
    L5:
        this.fields.makeImmutable();
        this.isImmutable = true;
    }

    public void mergeFrom(FieldSet<FieldDescriptorType> r10) {
        int r11 = 0;
    L4:
        if (r11 >= r10.fields.getNumArrayEntries()) goto L6;
        mergeFromField(r10.fields.getArrayEntryAt(r11));
        r11 = r11 + 1;
        goto L4
    L6:
        Iterator r12 = r10.fields.getOverflowEntries().iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        mergeFromField((Map.Entry) r12.next());
        goto L8
    }

    public void setField(FieldDescriptorType r10, Object r11) {
        if (r10.isRepeated() == true) goto L5;
        verifyType(r10.getLiteType(), r11);
    L15:
        if ((r11 instanceof LazyField) == false) goto L17;
        this.hasLazyField = true;
    L17:
        this.fields.put(r10, r11);
        return;
    L5:
        if ((r11 instanceof List) == false) goto L12;
        ArrayList r12 = new ArrayList();
        r12.addAll((List) r11);
        Iterator r13 = r12.iterator();
    L8:
        if (r13.hasNext() == false) goto L10;
        Object r14 = r13.next();
        verifyType(r10.getLiteType(), r14);
        goto L8
    L10:
        r11 = r12;
        goto L15
    L12:
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }
}
