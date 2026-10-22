package kotlin.reflect.jvm.internal.impl.protobuf;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.FieldDescriptorLite;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
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
            int[] r0 = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = r0;
            r0[WireFormat.FieldType.DOUBLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L40
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
            int[] r9 = new int[WireFormat.JavaType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$JavaType = r9;
            r9[WireFormat.JavaType.INT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L58
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

        MessageLite.Builder internalMergeFrom(MessageLite.Builder r1, MessageLite r2);

        boolean isPacked();

        boolean isRepeated();
    }

    public int getSerializedSize() {
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r0 >= this.fields.getNumArrayEntries()) goto L6;
        Map.Entry<K, Object> r2 = this.fields.getArrayEntryAt(r0);
        r1 = r1 + computeFieldSize((FieldDescriptorLite) r2.getKey(), r2.getValue());
        r0 = r0 + 1;
        goto L4
    L6:
        Iterator r3 = this.fields.getOverflowEntries().iterator();
    L8:
        if (r3.hasNext() == false) goto L10;
        Map.Entry r4 = (Map.Entry) r3.next();
        r1 = r1 + computeFieldSize((FieldDescriptorLite) r4.getKey(), r4.getValue());
        goto L8
    L10:
        return r1;
    }

    public boolean isInitialized() {
        int r1 = 0;
    L4:
        if (r1 >= this.fields.getNumArrayEntries()) goto L9;
        if (isInitialized(this.fields.getArrayEntryAt(r1)) == false) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        return false;
    L9:
        Iterator r2 = this.fields.getOverflowEntries().iterator();
    L11:
        if (r2.hasNext() == false) goto L15;
        if (isInitialized((Map.Entry) r2.next()) == true) goto L11;
        return false;
    L15:
        return true;
    }

    static {
        DEFAULT_INSTANCE = new FieldSet(true);
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet<T> newFieldSet() {
        return new FieldSet();
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

    private FieldSet() {
        this.hasLazyField = false;
        this.fields = SmallSortedMap.newFieldMap(16);
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public FieldSet<FieldDescriptorType> m382clone() {
        FieldSet<FieldDescriptorType> r0 = newFieldSet();
        int r1 = 0;
    L4:
        if (r1 >= this.fields.getNumArrayEntries()) goto L6;
        Map.Entry<K, Object> r2 = this.fields.getArrayEntryAt(r1);
        r0.setField((FieldDescriptorLite) r2.getKey(), r2.getValue());
        r1 = r1 + 1;
        goto L4
    L6:
        Iterator r3 = this.fields.getOverflowEntries().iterator();
    L8:
        if (r3.hasNext() == false) goto L10;
        Map.Entry r4 = (Map.Entry) r3.next();
        r0.setField((FieldDescriptorLite) r4.getKey(), r4.getValue());
        goto L8
    L10:
        r0.hasLazyField = this.hasLazyField;
        return r0;
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet<T> emptySet() {
        return DEFAULT_INSTANCE;
    }

    public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        return m382clone();
    }

    private FieldSet(boolean r1) {
        this.hasLazyField = false;
        this.fields = SmallSortedMap.newFieldMap(0);
        makeImmutable();
    }

    private Object cloneIfMutable(Object r4) {
        if ((r4 instanceof byte[]) == false) goto L6;
        byte[] r5 = (byte[]) r4;
        byte[] r0 = new byte[r5.length];
        System.arraycopy(r5, 0, r0, 0, r5.length);
        return r0;
    L6:
        return r4;
    }

    private boolean isInitialized(Map.Entry<FieldDescriptorType, Object> r5) {
        FieldDescriptorType r0 = r5.getKey();
        if (r0.getLiteJavaType() == WireFormat.JavaType.MESSAGE) goto L5;
    L22:
        return true;
    L5:
        if (r0.isRepeated() == false) goto L12;
        Iterator r6 = ((List) r5.getValue()).iterator();
    L8:
        if (r6.hasNext() == false) goto L22;
        if (((MessageLite) r6.next()).isInitialized() == true) goto L8;
        return false;
    L12:
        Object r7 = r5.getValue();
        if ((r7 instanceof MessageLite) == false) goto L18;
        if (((MessageLite) r7).isInitialized() == true) goto L22;
        return false;
    L18:
        if ((r7 instanceof LazyField) == false) goto L21;
        return true;
    L21:
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private void mergeFromField(Map.Entry<FieldDescriptorType, Object> r5) {
        FieldDescriptorType r0 = r5.getKey();
        Object r6 = r5.getValue();
        if ((r6 instanceof LazyField) == false) goto L6;
        r6 = ((LazyField) r6).getValue();
    L6:
        if (r0.isRepeated() == false) goto L16;
        Object r1 = getField(r0);
        if (r1 != null) goto L10;
        r1 = new ArrayList();
    L10:
        Iterator r7 = ((List) r6).iterator();
    L12:
        if (r7.hasNext() == false) goto L14;
        ((List) r1).add(cloneIfMutable(r7.next()));
        goto L12
    L14:
        this.fields.put(r0, r1);
        return;
    L16:
        if (r0.getLiteJavaType() != WireFormat.JavaType.MESSAGE) goto L21;
        Object r2 = getField(r0);
        if (r2 != null) goto L20;
        this.fields.put(r0, cloneIfMutable(r6));
        return;
    L20:
        MessageLite r8 = r0.internalMergeFrom(((MessageLite) r2).mo380toBuilder(), (MessageLite) r6).build();
        this.fields.put(r0, r8);
        return;
    L21:
        this.fields.put(r0, cloneIfMutable(r6));
    }

    public Object getField(FieldDescriptorType r2) {
        Object r3 = this.fields.get(r2);
        if ((r3 instanceof LazyField) == true) goto L5;
        return r3;
    L5:
        return ((LazyField) r3).getValue();
    }

    public int getRepeatedFieldCount(FieldDescriptorType r2) {
        if (r2.isRepeated() == false) goto L11;
        Object r3 = getField(r2);
        if (r3 != null) goto L9;
        return 0;
    L9:
        return ((List) r3).size();
    L11:
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public boolean hasField(FieldDescriptorType r2) {
        if (r2.isRepeated() == true) goto L10;
        if (this.fields.get(r2) == null) goto L7;
        return true;
    L7:
        return false;
    L10:
        throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
    }

    public void mergeFrom(FieldSet<FieldDescriptorType> r3) {
        int r0 = 0;
    L4:
        if (r0 >= r3.fields.getNumArrayEntries()) goto L6;
        mergeFromField(r3.fields.getArrayEntryAt(r0));
        r0 = r0 + 1;
        goto L4
    L6:
        Iterator r4 = r3.fields.getOverflowEntries().iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        mergeFromField((Map.Entry) r4.next());
        goto L8
    }

    private static int computeElementSizeNoTag(WireFormat.FieldType r1, Object r2) {
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r1.ordinal()]) {
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
        if ((r2 instanceof Internal$EnumLite) == false) goto L11;
        return CodedOutputStream.computeEnumSizeNoTag(((Internal$EnumLite) r2).getNumber());
    L11:
        return CodedOutputStream.computeEnumSizeNoTag(((Integer) r2).intValue());
    L13:
        if ((r2 instanceof LazyField) == false) goto L17;
        return CodedOutputStream.computeLazyFieldSizeNoTag((LazyField) r2);
    L17:
        return CodedOutputStream.computeMessageSizeNoTag((MessageLite) r2);
    L19:
        return CodedOutputStream.computeGroupSizeNoTag((MessageLite) r2);
    L21:
        return CodedOutputStream.computeSInt64SizeNoTag(((Long) r2).longValue());
    L23:
        return CodedOutputStream.computeSInt32SizeNoTag(((Integer) r2).intValue());
    L25:
        return CodedOutputStream.computeSFixed64SizeNoTag(((Long) r2).longValue());
    L27:
        return CodedOutputStream.computeSFixed32SizeNoTag(((Integer) r2).intValue());
    L29:
        return CodedOutputStream.computeUInt32SizeNoTag(((Integer) r2).intValue());
    L31:
        if ((r2 instanceof ByteString) == false) goto L35;
        return CodedOutputStream.computeBytesSizeNoTag((ByteString) r2);
    L35:
        return CodedOutputStream.computeByteArraySizeNoTag((byte[]) r2);
    L37:
        return CodedOutputStream.computeStringSizeNoTag((String) r2);
    L39:
        return CodedOutputStream.computeBoolSizeNoTag(((Boolean) r2).booleanValue());
    L41:
        return CodedOutputStream.computeFixed32SizeNoTag(((Integer) r2).intValue());
    L43:
        return CodedOutputStream.computeFixed64SizeNoTag(((Long) r2).longValue());
    L45:
        return CodedOutputStream.computeInt32SizeNoTag(((Integer) r2).intValue());
    L47:
        return CodedOutputStream.computeUInt64SizeNoTag(((Long) r2).longValue());
    L49:
        return CodedOutputStream.computeInt64SizeNoTag(((Long) r2).longValue());
    L51:
        return CodedOutputStream.computeFloatSizeNoTag(((Float) r2).floatValue());
    L53:
        return CodedOutputStream.computeDoubleSizeNoTag(((Double) r2).doubleValue());
    }

    public static int computeFieldSize(FieldDescriptorLite<?> r3, Object r4) {
        WireFormat.FieldType r0 = r3.getLiteType();
        int r1 = r3.getNumber();
        if (r3.isRepeated() == false) goto L18;
        int r2 = 0;
        if (r3.isPacked() == false) goto L12;
        Iterator r5 = ((List) r4).iterator();
    L8:
        if (r5.hasNext() == false) goto L11;
        r2 = r2 + computeElementSizeNoTag(r0, r5.next());
        goto L8
    L11:
        return (CodedOutputStream.computeTagSize(r1) + r2) + CodedOutputStream.computeRawVarint32Size(r2);
    L12:
        Iterator r6 = ((List) r4).iterator();
    L14:
        if (r6.hasNext() == false) goto L16;
        r2 = r2 + computeElementSize(r0, r1, r6.next());
        goto L14
    L16:
        return r2;
    L18:
        return computeElementSize(r0, r1, r4);
    }

    public static int getWireFormatForFieldType(WireFormat.FieldType r0, boolean r1) {
        if (r1 == false) goto L6;
        return 2;
    L6:
        return r0.getWireType();
    }

    private static void verifyType(WireFormat.FieldType r2, Object r3) {
        if (r3 == null) goto L34;
        boolean r0 = true;
        boolean r1 = false;
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$JavaType[r2.getJavaType().ordinal()]) {
            case 1: goto L28;
            case 2: goto L27;
            case 3: goto L26;
            case 4: goto L25;
            case 5: goto L24;
            case 6: goto L23;
            case 7: goto L17;
            case 8: goto L12;
            case 9: goto L7;
            default: goto L29;
        };
    L23:
        r1 = r3 instanceof String;
        goto L29
    L24:
        r1 = r3 instanceof Boolean;
        goto L29
    L25:
        r1 = r3 instanceof Double;
        goto L29
    L26:
        r1 = r3 instanceof Float;
        goto L29
    L27:
        r1 = r3 instanceof Long;
        goto L29
    L28:
        r1 = r3 instanceof Integer;
    L29:
        if (r1 == false) goto L32;
        return;
    L32:
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    L7:
        if ((r3 instanceof MessageLite) == false) goto L9;
    L22:
        r1 = r0;
        goto L29
    L9:
        if ((r3 instanceof LazyField) == true) goto L22;
    L21:
        r0 = false;
        goto L22
    L12:
        if ((r3 instanceof Integer) == true) goto L22;
        if ((r3 instanceof Internal$EnumLite) == false) goto L21;
    L17:
        if ((r3 instanceof ByteString) == true) goto L22;
        if ((r3 instanceof byte[]) == false) goto L21;
    L34:
        throw null;
    }

    public void addRepeatedField(FieldDescriptorType r3, Object r4) {
        if (r3.isRepeated() == false) goto L11;
        verifyType(r3.getLiteType(), r4);
        Object r0 = getField(r3);
        if (r0 != null) goto L7;
        List r1 = new ArrayList();
        this.fields.put(r3, r1);
    L8:
        r1.add(r4);
        return;
    L7:
        r1 = (List) r0;
        goto L8
    L11:
        throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }

    public Object getRepeatedField(FieldDescriptorType r2, int r3) {
        if (r2.isRepeated() == false) goto L11;
        Object r4 = getField(r2);
        if (r4 == null) goto L9;
        return ListProtector.get((List) r4, r3);
    L9:
        throw new IndexOutOfBoundsException();
    L11:
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public void setField(FieldDescriptorType r4, Object r5) {
        if (r4.isRepeated() == true) goto L5;
        verifyType(r4.getLiteType(), r5);
    L15:
        if ((r5 instanceof LazyField) == false) goto L17;
        this.hasLazyField = true;
    L17:
        this.fields.put(r4, r5);
        return;
    L5:
        if ((r5 instanceof List) == false) goto L12;
        ArrayList r0 = new ArrayList();
        r0.addAll((List) r5);
        Iterator r6 = r0.iterator();
    L8:
        if (r6.hasNext() == false) goto L10;
        Object r1 = r6.next();
        verifyType(r4.getLiteType(), r1);
        goto L8
    L10:
        r5 = r0;
        goto L15
    L12:
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static int computeElementSize(WireFormat.FieldType r1, int r2, Object r3) {
        int r4 = CodedOutputStream.computeTagSize(r2);
        if (r1 != WireFormat.FieldType.GROUP) goto L6;
        r4 = r4 * 2;
    L6:
        return r4 + computeElementSizeNoTag(r1, r3);
    }

    public static Object readPrimitiveField(CodedInputStream r1, WireFormat.FieldType r2, boolean r3) throws IOException {
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r2.ordinal()]) {
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
        if (r3 == false) goto L28;
        return r1.readStringRequireUtf8();
    L28:
        return r1.readString();
    L5:
        throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
    L7:
        throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
    L9:
        throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
    L11:
        throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
    L13:
        return Long.valueOf(r1.readSInt64());
    L15:
        return Integer.valueOf(r1.readSInt32());
    L17:
        return Long.valueOf(r1.readSFixed64());
    L19:
        return Integer.valueOf(r1.readSFixed32());
    L21:
        return Integer.valueOf(r1.readUInt32());
    L23:
        return r1.readBytes();
    L30:
        return Boolean.valueOf(r1.readBool());
    L32:
        return Integer.valueOf(r1.readFixed32());
    L34:
        return Long.valueOf(r1.readFixed64());
    L36:
        return Integer.valueOf(r1.readInt32());
    L38:
        return Long.valueOf(r1.readUInt64());
    L40:
        return Long.valueOf(r1.readInt64());
    L42:
        return Float.valueOf(r1.readFloat());
    L44:
        return Double.valueOf(r1.readDouble());
    }

    private static void writeElementNoTag(CodedOutputStream r1, WireFormat.FieldType r2, Object r3) throws IOException {
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r2.ordinal()]) {
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
        r1.writeMessageNoTag((MessageLite) r3);
        return;
    L10:
        r1.writeGroupNoTag((MessageLite) r3);
        return;
    L11:
        r1.writeSInt64NoTag(((Long) r3).longValue());
        return;
    L12:
        r1.writeSInt32NoTag(((Integer) r3).intValue());
        return;
    L13:
        r1.writeSFixed64NoTag(((Long) r3).longValue());
        return;
    L14:
        r1.writeSFixed32NoTag(((Integer) r3).intValue());
        return;
    L15:
        r1.writeUInt32NoTag(((Integer) r3).intValue());
        return;
    L20:
        r1.writeStringNoTag((String) r3);
        return;
    L21:
        r1.writeBoolNoTag(((Boolean) r3).booleanValue());
        return;
    L22:
        r1.writeFixed32NoTag(((Integer) r3).intValue());
        return;
    L23:
        r1.writeFixed64NoTag(((Long) r3).longValue());
        return;
    L24:
        r1.writeInt32NoTag(((Integer) r3).intValue());
        return;
    L25:
        r1.writeUInt64NoTag(((Long) r3).longValue());
        return;
    L26:
        r1.writeInt64NoTag(((Long) r3).longValue());
        return;
    L27:
        r1.writeFloatNoTag(((Float) r3).floatValue());
        return;
    L28:
        r1.writeDoubleNoTag(((Double) r3).doubleValue());
        return;
    L49:
        return;
    L6:
        if ((r3 instanceof Internal$EnumLite) == false) goto L8;
        r1.writeEnumNoTag(((Internal$EnumLite) r3).getNumber());
        return;
    L8:
        r1.writeEnumNoTag(((Integer) r3).intValue());
        return;
    L17:
        if ((r3 instanceof ByteString) == false) goto L19;
        r1.writeBytesNoTag((ByteString) r3);
        return;
    L19:
        r1.writeByteArrayNoTag((byte[]) r3);
    }

    public static void writeField(FieldDescriptorLite<?> r3, Object r4, CodedOutputStream r5) throws IOException {
        WireFormat.FieldType r0 = r3.getLiteType();
        int r1 = r3.getNumber();
        if (r3.isRepeated() == false) goto L19;
        List r6 = (List) r4;
        if (r3.isPacked() == false) goto L14;
        r5.writeTag(r1, 2);
        Iterator r7 = r6.iterator();
        int r2 = 0;
    L8:
        if (r7.hasNext() == false) goto L10;
        r2 = r2 + computeElementSizeNoTag(r0, r7.next());
        goto L8
    L10:
        r5.writeRawVarint32(r2);
        Iterator r8 = r6.iterator();
    L12:
        if (r8.hasNext() == false) goto L27;
        writeElementNoTag(r5, r0, r8.next());
        goto L12
    L27:
        return;
    L14:
        Iterator r9 = r6.iterator();
    L16:
        if (r9.hasNext() == false) goto L28;
        writeElement(r5, r0, r1, r9.next());
        goto L16
    L28:
        return;
    L19:
        if ((r4 instanceof LazyField) == false) goto L21;
        writeElement(r5, r0, r1, ((LazyField) r4).getValue());
        return;
    L21:
        writeElement(r5, r0, r1, r4);
    }

    private static void writeElement(CodedOutputStream r1, WireFormat.FieldType r2, int r3, Object r4) throws IOException {
        if (r2 != WireFormat.FieldType.GROUP) goto L5;
        r1.writeGroup(r3, (MessageLite) r4);
        return;
    L5:
        r1.writeTag(r3, getWireFormatForFieldType(r2, false));
        writeElementNoTag(r1, r2, r4);
    }
}
