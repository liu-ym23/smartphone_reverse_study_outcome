package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.FieldDescriptorLite;

/* JADX INFO: loaded from: classes3.dex */
final class FieldSet<FieldDescriptorType extends FieldDescriptorLite<FieldDescriptorType>> {
    private static final FieldSet DEFAULT_INSTANCE = null;
    private final SmallSortedMap<FieldDescriptorType, Object> fields;
    private boolean hasLazyField;
    private boolean isImmutable;

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.protobuf.FieldSet$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType = null;
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$JavaType = null;

        static {
            int[] r5 = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = r5;
            r5[WireFormat.FieldType.DOUBLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L40
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
            int[] r10 = new int[WireFormat.JavaType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$JavaType = r10;
            r10[WireFormat.JavaType.INT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L58
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

        MessageLite.Builder internalMergeFrom(MessageLite.Builder r5, MessageLite r10);

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

    private Object cloneIfMutable(Object r5) {
        if ((r5 instanceof byte[]) == false) goto L6;
        byte[] r10 = (byte[]) r5;
        byte[] r11 = new byte[r10.length];
        System.arraycopy(r10, 0, r11, 0, r10.length);
        return r11;
    L6:
        return r5;
    }

    private static int computeElementSize(WireFormat.FieldType r5, int r10, Object r11) {
        int r12 = CodedOutputStream.computeTagSize(r10);
        if (r5 != WireFormat.FieldType.GROUP) goto L6;
        r12 = r12 * 2;
    L6:
        return r12 + computeElementSizeNoTag(r5, r11);
    }

    private static int computeElementSizeNoTag(WireFormat.FieldType r5, Object r10) {
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r5.ordinal()]) {
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
        if ((r10 instanceof Internal.EnumLite) == false) goto L11;
        return CodedOutputStream.computeEnumSizeNoTag(((Internal.EnumLite) r10).getNumber());
    L11:
        return CodedOutputStream.computeEnumSizeNoTag(((Integer) r10).intValue());
    L13:
        if ((r10 instanceof LazyField) == false) goto L17;
        return CodedOutputStream.computeLazyFieldSizeNoTag((LazyField) r10);
    L17:
        return CodedOutputStream.computeMessageSizeNoTag((MessageLite) r10);
    L19:
        return CodedOutputStream.computeGroupSizeNoTag((MessageLite) r10);
    L21:
        return CodedOutputStream.computeSInt64SizeNoTag(((Long) r10).longValue());
    L23:
        return CodedOutputStream.computeSInt32SizeNoTag(((Integer) r10).intValue());
    L25:
        return CodedOutputStream.computeSFixed64SizeNoTag(((Long) r10).longValue());
    L27:
        return CodedOutputStream.computeSFixed32SizeNoTag(((Integer) r10).intValue());
    L29:
        return CodedOutputStream.computeUInt32SizeNoTag(((Integer) r10).intValue());
    L31:
        if ((r10 instanceof ByteString) == false) goto L35;
        return CodedOutputStream.computeBytesSizeNoTag((ByteString) r10);
    L35:
        return CodedOutputStream.computeByteArraySizeNoTag((byte[]) r10);
    L37:
        return CodedOutputStream.computeStringSizeNoTag((String) r10);
    L39:
        return CodedOutputStream.computeBoolSizeNoTag(((Boolean) r10).booleanValue());
    L41:
        return CodedOutputStream.computeFixed32SizeNoTag(((Integer) r10).intValue());
    L43:
        return CodedOutputStream.computeFixed64SizeNoTag(((Long) r10).longValue());
    L45:
        return CodedOutputStream.computeInt32SizeNoTag(((Integer) r10).intValue());
    L47:
        return CodedOutputStream.computeUInt64SizeNoTag(((Long) r10).longValue());
    L49:
        return CodedOutputStream.computeInt64SizeNoTag(((Long) r10).longValue());
    L51:
        return CodedOutputStream.computeFloatSizeNoTag(((Float) r10).floatValue());
    L53:
        return CodedOutputStream.computeDoubleSizeNoTag(((Double) r10).doubleValue());
    }

    public static int computeFieldSize(FieldDescriptorLite<?> r5, Object r10) {
        WireFormat.FieldType r11 = r5.getLiteType();
        int r12 = r5.getNumber();
        if (r5.isRepeated() == false) goto L18;
        int r13 = 0;
        if (r5.isPacked() == false) goto L12;
        Iterator r14 = ((List) r10).iterator();
    L8:
        if (r14.hasNext() == false) goto L10;
        r13 = r13 + computeElementSizeNoTag(r11, r14.next());
        goto L8
    L10:
        int r15 = CodedOutputStream.computeTagSize(r12) + r13;
        return CodedOutputStream.computeRawVarint32Size(r13) + r15;
    L12:
        Iterator r16 = ((List) r10).iterator();
    L14:
        if (r16.hasNext() == false) goto L16;
        r13 = r13 + computeElementSize(r11, r12, r16.next());
        goto L14
    L16:
        return r13;
    L18:
        return computeElementSize(r11, r12, r10);
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet<T> emptySet() {
        return DEFAULT_INSTANCE;
    }

    public static int getWireFormatForFieldType(WireFormat.FieldType r5, boolean r10) {
        if (r10 == false) goto L6;
        return 2;
    L6:
        return r5.getWireType();
    }

    private void mergeFromField(Map.Entry<FieldDescriptorType, Object> r5) {
        FieldDescriptorType r10 = r5.getKey();
        Object r11 = r5.getValue();
        if ((r11 instanceof LazyField) == false) goto L6;
        r11 = ((LazyField) r11).getValue();
    L6:
        if (r10.isRepeated() == false) goto L16;
        Object r12 = getField(r10);
        if (r12 != null) goto L10;
        r12 = new ArrayList();
    L10:
        Iterator r13 = ((List) r11).iterator();
    L12:
        if (r13.hasNext() == false) goto L14;
        ((List) r12).add(cloneIfMutable(r13.next()));
        goto L12
    L14:
        this.fields.put(r10, r12);
        return;
    L16:
        if (r10.getLiteJavaType() != WireFormat.JavaType.MESSAGE) goto L21;
        Object r14 = getField(r10);
        if (r14 != null) goto L20;
        this.fields.put(r10, cloneIfMutable(r11));
        return;
    L20:
        MessageLite r15 = r10.internalMergeFrom(((MessageLite) r14).toBuilder(), (MessageLite) r11).build();
        this.fields.put(r10, r15);
        return;
    L21:
        this.fields.put(r10, cloneIfMutable(r11));
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet<T> newFieldSet() {
        return new FieldSet();
    }

    public static Object readPrimitiveField(CodedInputStream r5, WireFormat.FieldType r10, boolean r11) throws IOException {
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r10.ordinal()]) {
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
        if (r11 == false) goto L28;
        return r5.readStringRequireUtf8();
    L28:
        return r5.readString();
    L5:
        throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
    L7:
        throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
    L9:
        throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
    L11:
        throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
    L13:
        return Long.valueOf(r5.readSInt64());
    L15:
        return Integer.valueOf(r5.readSInt32());
    L17:
        return Long.valueOf(r5.readSFixed64());
    L19:
        return Integer.valueOf(r5.readSFixed32());
    L21:
        return Integer.valueOf(r5.readUInt32());
    L23:
        return r5.readBytes();
    L30:
        return Boolean.valueOf(r5.readBool());
    L32:
        return Integer.valueOf(r5.readFixed32());
    L34:
        return Long.valueOf(r5.readFixed64());
    L36:
        return Integer.valueOf(r5.readInt32());
    L38:
        return Long.valueOf(r5.readUInt64());
    L40:
        return Long.valueOf(r5.readInt64());
    L42:
        return Float.valueOf(r5.readFloat());
    L44:
        return Double.valueOf(r5.readDouble());
    }

    private static void verifyType(WireFormat.FieldType r5, Object r10) {
        r10.getClass();
        boolean r11 = true;
        boolean r12 = false;
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$JavaType[r5.getJavaType().ordinal()]) {
            case 1: goto L27;
            case 2: goto L26;
            case 3: goto L25;
            case 4: goto L24;
            case 5: goto L23;
            case 6: goto L22;
            case 7: goto L18;
            case 8: goto L13;
            case 9: goto L6;
            default: goto L28;
        };
    L22:
        r12 = r10 instanceof String;
        goto L28
    L23:
        r12 = r10 instanceof Boolean;
        goto L28
    L24:
        r12 = r10 instanceof Double;
        goto L28
    L25:
        r12 = r10 instanceof Float;
        goto L28
    L26:
        r12 = r10 instanceof Long;
        goto L28
    L27:
        r12 = r10 instanceof Integer;
    L28:
        if (r12 == false) goto L31;
        return;
    L31:
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    L6:
        if ((r10 instanceof MessageLite) == false) goto L8;
    L11:
        r12 = r11;
        goto L28
    L8:
        if ((r10 instanceof LazyField) == true) goto L11;
    L10:
        r11 = false;
        goto L11
    L13:
        if ((r10 instanceof Integer) == true) goto L11;
        if ((r10 instanceof Internal.EnumLite) == false) goto L10;
    L18:
        if ((r10 instanceof ByteString) == true) goto L11;
        if ((r10 instanceof byte[]) == false) goto L10;
        goto L10
    }

    private static void writeElement(CodedOutputStream r5, WireFormat.FieldType r10, int r11, Object r12) throws IOException {
        if (r10 != WireFormat.FieldType.GROUP) goto L5;
        r5.writeGroup(r11, (MessageLite) r12);
        return;
    L5:
        r5.writeTag(r11, getWireFormatForFieldType(r10, false));
        writeElementNoTag(r5, r10, r12);
    }

    private static void writeElementNoTag(CodedOutputStream r5, WireFormat.FieldType r10, Object r11) throws IOException {
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r10.ordinal()]) {
            case 1: goto L28;
            case 2: goto L27;
            case 3: goto L26;
            case 4: goto L25;
            case 5: goto L24;
            case 6: goto L23;
            case 7: goto L22;
            case 8: goto L21;
            case 9: goto L20;
            case 10: goto L17;
            case 11: goto L15;
            case 12: goto L14;
            case 13: goto L13;
            case 14: goto L12;
            case 15: goto L11;
            case 16: goto L10;
            case 17: goto L9;
            case 18: goto L6;
            default: goto L49;
        };
    L9:
        r5.writeMessageNoTag((MessageLite) r11);
        return;
    L10:
        r5.writeGroupNoTag((MessageLite) r11);
        return;
    L11:
        r5.writeSInt64NoTag(((Long) r11).longValue());
        return;
    L12:
        r5.writeSInt32NoTag(((Integer) r11).intValue());
        return;
    L13:
        r5.writeSFixed64NoTag(((Long) r11).longValue());
        return;
    L14:
        r5.writeSFixed32NoTag(((Integer) r11).intValue());
        return;
    L15:
        r5.writeUInt32NoTag(((Integer) r11).intValue());
        return;
    L20:
        r5.writeStringNoTag((String) r11);
        return;
    L21:
        r5.writeBoolNoTag(((Boolean) r11).booleanValue());
        return;
    L22:
        r5.writeFixed32NoTag(((Integer) r11).intValue());
        return;
    L23:
        r5.writeFixed64NoTag(((Long) r11).longValue());
        return;
    L24:
        r5.writeInt32NoTag(((Integer) r11).intValue());
        return;
    L25:
        r5.writeUInt64NoTag(((Long) r11).longValue());
        return;
    L26:
        r5.writeInt64NoTag(((Long) r11).longValue());
        return;
    L27:
        r5.writeFloatNoTag(((Float) r11).floatValue());
        return;
    L28:
        r5.writeDoubleNoTag(((Double) r11).doubleValue());
        return;
    L49:
        return;
    L6:
        if ((r11 instanceof Internal.EnumLite) == false) goto L8;
        r5.writeEnumNoTag(((Internal.EnumLite) r11).getNumber());
        return;
    L8:
        r5.writeEnumNoTag(((Integer) r11).intValue());
        return;
    L17:
        if ((r11 instanceof ByteString) == false) goto L19;
        r5.writeBytesNoTag((ByteString) r11);
        return;
    L19:
        r5.writeByteArrayNoTag((byte[]) r11);
    }

    public static void writeField(FieldDescriptorLite<?> r5, Object r10, CodedOutputStream r11) throws IOException {
        WireFormat.FieldType r12 = r5.getLiteType();
        int r13 = r5.getNumber();
        if (r5.isRepeated() == false) goto L19;
        List r14 = (List) r10;
        if (r5.isPacked() == false) goto L14;
        r11.writeTag(r13, 2);
        Iterator r15 = r14.iterator();
        int r16 = 0;
    L8:
        if (r15.hasNext() == false) goto L10;
        r16 = r16 + computeElementSizeNoTag(r12, r15.next());
        goto L8
    L10:
        r11.writeRawVarint32(r16);
        Iterator r17 = r14.iterator();
    L12:
        if (r17.hasNext() == false) goto L27;
        writeElementNoTag(r11, r12, r17.next());
        goto L12
    L27:
        return;
    L14:
        Iterator r18 = r14.iterator();
    L16:
        if (r18.hasNext() == false) goto L28;
        writeElement(r11, r12, r13, r18.next());
        goto L16
    L28:
        return;
    L19:
        if ((r10 instanceof LazyField) == false) goto L21;
        writeElement(r11, r12, r13, ((LazyField) r10).getValue());
        return;
    L21:
        writeElement(r11, r12, r13, r10);
    }

    public void addRepeatedField(FieldDescriptorType r5, Object r10) {
        if (r5.isRepeated() == false) goto L11;
        verifyType(r5.getLiteType(), r10);
        Object r11 = getField(r5);
        if (r11 != null) goto L7;
        List r12 = new ArrayList();
        this.fields.put(r5, r12);
    L8:
        r12.add(r10);
        return;
    L7:
        r12 = (List) r11;
        goto L8
    L11:
        throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }

    public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        return m1401clone();
    }

    public Object getField(FieldDescriptorType r5) {
        Object r10 = this.fields.get(r5);
        if ((r10 instanceof LazyField) == true) goto L5;
        return r10;
    L5:
        return ((LazyField) r10).getValue();
    }

    public Object getRepeatedField(FieldDescriptorType r5, int r10) {
        if (r5.isRepeated() == false) goto L11;
        Object r11 = getField(r5);
        if (r11 == null) goto L9;
        return ((List) r11).get(r10);
    L9:
        throw new IndexOutOfBoundsException();
    L11:
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public int getRepeatedFieldCount(FieldDescriptorType r5) {
        if (r5.isRepeated() == false) goto L11;
        Object r10 = getField(r5);
        if (r10 != null) goto L9;
        return 0;
    L9:
        return ((List) r10).size();
    L11:
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public int getSerializedSize() {
        int r5 = 0;
        int r10 = 0;
    L4:
        if (r5 >= this.fields.getNumArrayEntries()) goto L6;
        Map.Entry<K, Object> r11 = this.fields.getArrayEntryAt(r5);
        r10 = r10 + computeFieldSize((FieldDescriptorLite) r11.getKey(), r11.getValue());
        r5 = r5 + 1;
        goto L4
    L6:
        Iterator r12 = this.fields.getOverflowEntries().iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        Map.Entry r13 = (Map.Entry) r12.next();
        r10 = r10 + computeFieldSize((FieldDescriptorLite) r13.getKey(), r13.getValue());
        goto L8
    L10:
        return r10;
    }

    public boolean hasField(FieldDescriptorType r5) {
        if (r5.isRepeated() == true) goto L10;
        if (this.fields.get(r5) == null) goto L7;
        return true;
    L7:
        return false;
    L10:
        throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
    }

    public boolean isInitialized() {
        int r5 = 0;
    L4:
        if (r5 >= this.fields.getNumArrayEntries()) goto L9;
        if (isInitialized(this.fields.getArrayEntryAt(r5)) == false) goto L7;
        r5 = r5 + 1;
        goto L4
    L7:
        return false;
    L9:
        Iterator r10 = this.fields.getOverflowEntries().iterator();
    L11:
        if (r10.hasNext() == false) goto L15;
        if (isInitialized((Map.Entry) r10.next()) == true) goto L11;
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

    public void mergeFrom(FieldSet<FieldDescriptorType> r5) {
        int r10 = 0;
    L4:
        if (r10 >= r5.fields.getNumArrayEntries()) goto L6;
        mergeFromField(r5.fields.getArrayEntryAt(r10));
        r10 = r10 + 1;
        goto L4
    L6:
        Iterator r11 = r5.fields.getOverflowEntries().iterator();
    L8:
        if (r11.hasNext() == false) goto L10;
        mergeFromField((Map.Entry) r11.next());
        goto L8
    }

    public void setField(FieldDescriptorType r5, Object r10) {
        if (r5.isRepeated() == true) goto L5;
        verifyType(r5.getLiteType(), r10);
    L15:
        if ((r10 instanceof LazyField) == false) goto L17;
        this.hasLazyField = true;
    L17:
        this.fields.put(r5, r10);
        return;
    L5:
        if ((r10 instanceof List) == false) goto L12;
        ArrayList r11 = new ArrayList();
        r11.addAll((List) r10);
        Iterator r12 = r11.iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        Object r13 = r12.next();
        verifyType(r5.getLiteType(), r13);
        goto L8
    L10:
        r10 = r11;
        goto L15
    L12:
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public FieldSet<FieldDescriptorType> m1401clone() {
        FieldSet<FieldDescriptorType> r5 = newFieldSet();
        int r10 = 0;
    L4:
        if (r10 >= this.fields.getNumArrayEntries()) goto L6;
        Map.Entry<K, Object> r11 = this.fields.getArrayEntryAt(r10);
        r5.setField((FieldDescriptorLite) r11.getKey(), r11.getValue());
        r10 = r10 + 1;
        goto L4
    L6:
        Iterator r12 = this.fields.getOverflowEntries().iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        Map.Entry r13 = (Map.Entry) r12.next();
        r5.setField((FieldDescriptorLite) r13.getKey(), r13.getValue());
        goto L8
    L10:
        r5.hasLazyField = this.hasLazyField;
        return r5;
    }

    private FieldSet(boolean r5) {
        this.hasLazyField = false;
        this.fields = SmallSortedMap.newFieldMap(0);
        makeImmutable();
    }

    private boolean isInitialized(Map.Entry<FieldDescriptorType, Object> r5) {
        FieldDescriptorType r10 = r5.getKey();
        if (r10.getLiteJavaType() == WireFormat.JavaType.MESSAGE) goto L5;
    L22:
        return true;
    L5:
        if (r10.isRepeated() == false) goto L12;
        Iterator r11 = ((List) r5.getValue()).iterator();
    L8:
        if (r11.hasNext() == false) goto L22;
        if (((MessageLite) r11.next()).isInitialized() == true) goto L8;
        return false;
    L12:
        Object r12 = r5.getValue();
        if ((r12 instanceof MessageLite) == false) goto L18;
        if (((MessageLite) r12).isInitialized() == true) goto L22;
        return false;
    L18:
        if ((r12 instanceof LazyField) == false) goto L21;
        return true;
    L21:
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }
}
