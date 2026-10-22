package com.google.protobuf;

import com.google.protobuf.FieldSet.FieldDescriptorLite;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class FieldSet<T extends FieldDescriptorLite<T>> {
    private static final FieldSet<?> DEFAULT_INSTANCE = null;
    private final SmallSortedMap<T, Object> fields;
    private boolean hasLazyField;
    private boolean isImmutable;

    /* JADX INFO: renamed from: com.google.protobuf.FieldSet$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType = null;
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$JavaType = null;

        static {
            int[] r8 = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = r8;
            r8[WireFormat.FieldType.DOUBLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L40
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
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.GROUP.ordinal()] = 9;     // Catch: NoSuchFieldError -> L48
        L111:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 10;     // Catch: NoSuchFieldError -> L49
        L115:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 11;     // Catch: NoSuchFieldError -> L50
        L73:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 12;     // Catch: NoSuchFieldError -> L51
        L79:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 13;     // Catch: NoSuchFieldError -> L52
        L95:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 14;     // Catch: NoSuchFieldError -> L53
        L101:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 15;     // Catch: NoSuchFieldError -> L54
        L119:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 16;     // Catch: NoSuchFieldError -> L55
        L67:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 17;     // Catch: NoSuchFieldError -> L56
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

    public static final class Builder<T extends FieldDescriptorLite<T>> {
        private SmallSortedMap<T, Object> fields;
        private boolean hasLazyField;
        private boolean hasNestedBuilders;
        private boolean isMutable;

        private Builder() {
            this(SmallSortedMap.newFieldMap());
        }

        private FieldSet<T> buildImpl(boolean r8) {
            if (this.fields.isEmpty() == true) goto L5;
            this.isMutable = false;
            SmallSortedMap<T, Object> r10 = this.fields;
            if (this.hasNestedBuilders == false) goto L9;
            r10 = FieldSet.access$100(r10, false, false);
            replaceBuilders(r10, r8);
        L9:
            FieldSet<T> r11 = new FieldSet(r10, null);
            FieldSet.access$302(r11, this.hasLazyField);
            return r11;
        L5:
            return FieldSet.emptySet();
        }

        private void ensureIsMutable() {
            if (this.isMutable == true) goto L6;
            this.fields = FieldSet.access$100(this.fields, true, false);
            this.isMutable = true;
            return;
        }

        public static <T extends FieldDescriptorLite<T>> Builder<T> fromFieldSet(FieldSet<T> r8) {
            Builder<T> r10 = new Builder(FieldSet.access$100(FieldSet.access$400(r8), true, false));
            ((Builder) r10).hasLazyField = FieldSet.access$300(r8);
            return r10;
        }

        private void mergeFromField(Map.Entry<T, Object> r8) {
            T r10 = r8.getKey();
            Object r11 = r8.getValue();
            boolean r12 = r11 instanceof LazyField;
            if (r10.isRepeated() == false) goto L14;
            if (r12 == true) goto L12;
            List r13 = (List) getFieldAllowBuilders(r10);
            List r14 = (List) r11;
            int r15 = r14.size();
            if (r13 != null) goto L8;
            r13 = new ArrayList(r15);
            this.fields.put(r10, r13);
        L8:
            int r16 = 0;
        L9:
            if (r16 >= r15) goto L36;
            r13.add(FieldSet.access$700(r14.get(r16)));
            r16 = r16 + 1;
            goto L9
        L36:
            return;
        L12:
            throw new IllegalStateException("Lazy fields can not be repeated");
        L14:
            if (r10.getLiteJavaType() != WireFormat.JavaType.MESSAGE) goto L26;
            Object r17 = getFieldAllowBuilders(r10);
            if (r17 != null) goto L20;
            this.fields.put(r10, FieldSet.access$700(r11));
            if (r12 == false) goto L33;
            this.hasLazyField = true;
            return;
        L33:
            return;
        L20:
            if (r12 == false) goto L23;
            r11 = ((LazyField) r11).getValue();
        L23:
            if (r10.internalMessageIsImmutable(r17) == false) goto L25;
            MessageLite.Builder r18 = ((MessageLite) r17).toBuilder();
            r10.internalMergeFrom(r18, r11);
            Object r19 = r18.build();
            SmallSortedMap<T, Object> r20 = this.fields;
        L28:
            r20.put(r10, r19);
            return;
        L25:
            r10.internalMergeFrom(r17, r11);
            return;
        L26:
            if (r12 == true) goto L31;
            r20 = this.fields;
            r19 = FieldSet.access$700(r11);
            goto L28
        L31:
            throw new IllegalStateException("Lazy fields must be message-valued");
        }

        private static Object replaceBuilder(Object r8, boolean r10) {
            if ((r8 instanceof MessageLite.Builder) == true) goto L5;
            return r8;
        L5:
            MessageLite.Builder r11 = (MessageLite.Builder) r8;
            if (r10 == false) goto L10;
            return r11.buildPartial();
        L10:
            return r11.build();
        }

        private static <T extends FieldDescriptorLite<T>> Object replaceBuilders(T r8, Object r10, boolean r11) {
            if (r10 != null) goto L5;
            return r10;
        L5:
            if (r8.getLiteJavaType() == WireFormat.JavaType.MESSAGE) goto L7;
            return r10;
        L7:
            if (r8.isRepeated() == false) goto L23;
            if ((r10 instanceof List) == false) goto L21;
            List r12 = (List) r10;
            int r13 = 0;
        L12:
            if (r13 >= r12.size()) goto L19;
            Object r14 = r12.get(r13);
            Object r15 = replaceBuilder(r14, r11);
            if (r15 == r14) goto L18;
            if (r12 != r10) goto L17;
            r12 = new ArrayList(r12);
        L17:
            r12.set(r13, r15);
        L18:
            r13 = r13 + 1;
            goto L12
        L19:
            return r12;
        L21:
            throw new IllegalStateException("Repeated field should contains a List but actually contains type: " + r10.getClass());
        L23:
            return replaceBuilder(r10, r11);
        }

        private void verifyType(T r8, Object r10) {
            if (FieldSet.access$500(r8.getLiteType(), r10) == false) goto L5;
            return;
        L5:
            if (r8.getLiteType().getJavaType() != WireFormat.JavaType.MESSAGE) goto L10;
            if ((r10 instanceof MessageLite.Builder) == false) goto L10;
            return;
        L10:
            throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(r8.getNumber()), r8.getLiteType().getJavaType(), r10.getClass().getName()}));
        }

        public void addRepeatedField(T r8, Object r10) {
            ensureIsMutable();
            if (r8.isRepeated() == false) goto L18;
            if (this.hasNestedBuilders == false) goto L7;
        L10:
            boolean r11 = true;
        L11:
            this.hasNestedBuilders = r11;
            verifyType(r8, r10);
            Object r12 = getFieldAllowBuilders(r8);
            if (r12 != null) goto L14;
            List r13 = new ArrayList();
            this.fields.put(r8, r13);
        L15:
            r13.add(r10);
            return;
        L14:
            r13 = (List) r12;
            goto L15
        L7:
            if ((r10 instanceof MessageLite.Builder) == true) goto L10;
            r11 = false;
            goto L11
        L18:
            throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
        }

        public FieldSet<T> build() {
            return buildImpl(false);
        }

        public FieldSet<T> buildPartial() {
            return buildImpl(true);
        }

        public void clearField(T r8) {
            ensureIsMutable();
            this.fields.remove(r8);
            if (this.fields.isEmpty() == false) goto L6;
            this.hasLazyField = false;
            return;
        }

        public Map<T, Object> getAllFields() {
            if (this.hasLazyField == false) goto L9;
            SmallSortedMap r8 = FieldSet.access$100(this.fields, false, true);
            if (this.fields.isImmutable() == false) goto L7;
            r8.makeImmutable();
        L8:
            return r8;
        L7:
            replaceBuilders(r8, true);
            goto L8
        L9:
            boolean r10 = this.fields.isImmutable();
            SmallSortedMap<T, Object> r11 = this.fields;
            if (r10 == false) goto L13;
            return r11;
        L13:
            return Collections.unmodifiableMap(r11);
        }

        public Object getField(T r8) {
            return replaceBuilders(r8, getFieldAllowBuilders(r8), true);
        }

        public Object getFieldAllowBuilders(T r8) {
            Object r10 = this.fields.get(r8);
            if ((r10 instanceof LazyField) == true) goto L5;
            return r10;
        L5:
            return ((LazyField) r10).getValue();
        }

        public Object getRepeatedField(T r8, int r10) {
            if (this.hasNestedBuilders == false) goto L6;
            ensureIsMutable();
        L6:
            return replaceBuilder(getRepeatedFieldAllowBuilders(r8, r10), true);
        }

        public Object getRepeatedFieldAllowBuilders(T r8, int r10) {
            if (r8.isRepeated() == false) goto L11;
            Object r11 = getFieldAllowBuilders(r8);
            if (r11 == null) goto L9;
            return ((List) r11).get(r10);
        L9:
            throw new IndexOutOfBoundsException();
        L11:
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }

        public int getRepeatedFieldCount(T r8) {
            if (r8.isRepeated() == false) goto L11;
            Object r10 = getFieldAllowBuilders(r8);
            if (r10 != null) goto L9;
            return 0;
        L9:
            return ((List) r10).size();
        L11:
            throw new IllegalArgumentException("getRepeatedFieldCount() can only be called on repeated fields.");
        }

        public boolean hasField(T r8) {
            if (r8.isRepeated() == true) goto L10;
            if (this.fields.get(r8) == null) goto L7;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
        }

        public boolean isInitialized() {
            int r8 = this.fields.getNumArrayEntries();
            int r10 = 0;
        L3:
            if (r10 >= r8) goto L8;
            if (FieldSet.access$600(this.fields.getArrayEntryAt(r10)) == false) goto L6;
            r10 = r10 + 1;
            goto L3
        L6:
            return false;
        L8:
            Iterator r11 = this.fields.getOverflowEntries().iterator();
        L10:
            if (r11.hasNext() == false) goto L14;
            if (FieldSet.access$600((Map.Entry) r11.next()) == true) goto L10;
            return false;
        L14:
            return true;
        }

        public void mergeFrom(FieldSet<T> r8) {
            ensureIsMutable();
            int r10 = FieldSet.access$400(r8).getNumArrayEntries();
            int r11 = 0;
        L3:
            if (r11 >= r10) goto L5;
            mergeFromField(FieldSet.access$400(r8).getArrayEntryAt(r11));
            r11 = r11 + 1;
            goto L3
        L5:
            Iterator r12 = FieldSet.access$400(r8).getOverflowEntries().iterator();
        L7:
            if (r12.hasNext() == false) goto L9;
            mergeFromField((Map.Entry) r12.next());
            goto L7
        }

        public void setField(T r8, Object r10) {
            ensureIsMutable();
            boolean r11 = false;
            if (r8.isRepeated() == true) goto L5;
            verifyType(r8, r10);
        L21:
            if ((r10 instanceof LazyField) == false) goto L24;
            this.hasLazyField = true;
        L24:
            if (this.hasNestedBuilders == false) goto L26;
        L27:
            r11 = true;
        L28:
            this.hasNestedBuilders = r11;
            this.fields.put(r8, r10);
            return;
        L26:
            if ((r10 instanceof MessageLite.Builder) == false) goto L28;
        L5:
            if ((r10 instanceof List) == false) goto L18;
            ArrayList r12 = new ArrayList((List) r10);
            int r13 = r12.size();
            int r14 = 0;
        L7:
            if (r14 >= r13) goto L16;
            Object r15 = r12.get(r14);
            verifyType(r8, r15);
            if (this.hasNestedBuilders == false) goto L11;
        L14:
            boolean r16 = true;
        L15:
            this.hasNestedBuilders = r16;
            r14 = r14 + 1;
            goto L7
        L11:
            if ((r15 instanceof MessageLite.Builder) == true) goto L14;
            r16 = false;
            goto L15
        L16:
            r10 = r12;
            goto L21
        L18:
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }

        public void setRepeatedField(T r8, int r10, Object r11) {
            ensureIsMutable();
            if (r8.isRepeated() == false) goto L18;
            if (this.hasNestedBuilders == false) goto L7;
        L10:
            boolean r12 = true;
        L11:
            this.hasNestedBuilders = r12;
            Object r13 = getFieldAllowBuilders(r8);
            if (r13 == null) goto L16;
            verifyType(r8, r11);
            ((List) r13).set(r10, r11);
            return;
        L16:
            throw new IndexOutOfBoundsException();
        L7:
            if ((r11 instanceof MessageLite.Builder) == true) goto L10;
            r12 = false;
            goto L11
        L18:
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }

        public /* synthetic */ Builder(AnonymousClass1 r8) {
            this();
        }

        private static <T extends FieldDescriptorLite<T>> void replaceBuilders(SmallSortedMap<T, Object> r8, boolean r10) {
            int r11 = r8.getNumArrayEntries();
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L5;
            replaceBuilders(r8.getArrayEntryAt(r12), r10);
            r12 = r12 + 1;
            goto L3
        L5:
            Iterator r13 = r8.getOverflowEntries().iterator();
        L7:
            if (r13.hasNext() == false) goto L9;
            replaceBuilders((Map.Entry) r13.next(), r10);
            goto L7
        }

        private Builder(SmallSortedMap<T, Object> r8) {
            this.fields = r8;
            this.isMutable = true;
        }

        private static <T extends FieldDescriptorLite<T>> void replaceBuilders(Map.Entry<T, Object> r8, boolean r10) {
            r8.setValue(replaceBuilders(r8.getKey(), r8.getValue(), r10));
        }
    }

    public interface FieldDescriptorLite<T extends FieldDescriptorLite<T>> extends Comparable<T> {
        Internal.EnumLiteMap<?> getEnumType();

        WireFormat.JavaType getLiteJavaType();

        WireFormat.FieldType getLiteType();

        int getNumber();

        void internalMergeFrom(Object r8, Object r10);

        boolean internalMessageIsImmutable(Object r8);

        boolean isPacked();

        boolean isRepeated();
    }

    static {
        DEFAULT_INSTANCE = new FieldSet(true);
    }

    private FieldSet() {
        this.fields = SmallSortedMap.newFieldMap();
    }

    public static /* synthetic */ SmallSortedMap access$100(SmallSortedMap r8, boolean r10, boolean r11) {
        return cloneAllFieldsMap(r8, r10, r11);
    }

    public static /* synthetic */ boolean access$300(FieldSet r8) {
        return r8.hasLazyField;
    }

    public static /* synthetic */ boolean access$302(FieldSet r8, boolean r10) {
        r8.hasLazyField = r10;
        return r10;
    }

    public static /* synthetic */ SmallSortedMap access$400(FieldSet r8) {
        return r8.fields;
    }

    public static /* synthetic */ boolean access$500(WireFormat.FieldType r8, Object r10) {
        return isValidType(r8, r10);
    }

    public static /* synthetic */ boolean access$600(Map.Entry r8) {
        return isInitialized(r8);
    }

    public static /* synthetic */ Object access$700(Object r8) {
        return cloneIfMutable(r8);
    }

    private static <T extends FieldDescriptorLite<T>> SmallSortedMap<T, Object> cloneAllFieldsMap(SmallSortedMap<T, Object> r8, boolean r10, boolean r11) {
        SmallSortedMap<T, Object> r12 = SmallSortedMap.newFieldMap();
        int r13 = r8.getNumArrayEntries();
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        cloneFieldEntry(r12, r8.getArrayEntryAt(r14), r10, r11);
        r14 = r14 + 1;
        goto L3
    L5:
        Iterator r15 = r8.getOverflowEntries().iterator();
    L7:
        if (r15.hasNext() == false) goto L9;
        cloneFieldEntry(r12, (Map.Entry) r15.next(), r10, r11);
        goto L7
    L9:
        return r12;
    }

    private static <T extends FieldDescriptorLite<T>> void cloneFieldEntry(Map<T, Object> r8, Map.Entry<T, Object> r10, boolean r11, boolean r12) {
        T r13 = r10.getKey();
        Object r14 = r10.getValue();
        if (r12 == true) goto L5;
    L7:
        if (r11 == true) goto L9;
    L11:
        r8.put(r13, r14);
        return;
    L9:
        if ((r14 instanceof List) == false) goto L11;
        r8.put(r13, new ArrayList((List) r14));
        return;
    L5:
        if ((r14 instanceof LazyField) == false) goto L7;
        r14 = ((LazyField) r14).getValue();
        goto L11
    }

    private static Object cloneIfMutable(Object r8) {
        if ((r8 instanceof byte[]) == false) goto L6;
        byte[] r10 = (byte[]) r8;
        byte[] r11 = new byte[r10.length];
        System.arraycopy(r10, 0, r11, 0, r10.length);
        return r11;
    L6:
        return r8;
    }

    public static int computeElementSize(WireFormat.FieldType r8, int r10, Object r11) {
        int r12 = CodedOutputStream.computeTagSize(r10);
        if (r8 != WireFormat.FieldType.GROUP) goto L6;
        r12 = r12 * 2;
    L6:
        return r12 + computeElementSizeNoTag(r8, r11);
    }

    public static int computeElementSizeNoTag(WireFormat.FieldType r8, Object r10) {
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r8.ordinal()]) {
            case 1: goto L57;
            case 2: goto L55;
            case 3: goto L53;
            case 4: goto L51;
            case 5: goto L49;
            case 6: goto L47;
            case 7: goto L45;
            case 8: goto L43;
            case 9: goto L41;
            case 10: goto L35;
            case 11: goto L29;
            case 12: goto L23;
            case 13: goto L21;
            case 14: goto L19;
            case 15: goto L17;
            case 16: goto L15;
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
        return CodedOutputStream.computeSInt64SizeNoTag(((Long) r10).longValue());
    L15:
        return CodedOutputStream.computeSInt32SizeNoTag(((Integer) r10).intValue());
    L17:
        return CodedOutputStream.computeSFixed64SizeNoTag(((Long) r10).longValue());
    L19:
        return CodedOutputStream.computeSFixed32SizeNoTag(((Integer) r10).intValue());
    L21:
        return CodedOutputStream.computeUInt32SizeNoTag(((Integer) r10).intValue());
    L23:
        if ((r10 instanceof ByteString) == false) goto L27;
        return CodedOutputStream.computeBytesSizeNoTag((ByteString) r10);
    L27:
        return CodedOutputStream.computeByteArraySizeNoTag((byte[]) r10);
    L29:
        if ((r10 instanceof ByteString) == false) goto L33;
        return CodedOutputStream.computeBytesSizeNoTag((ByteString) r10);
    L33:
        return CodedOutputStream.computeStringSizeNoTag((String) r10);
    L35:
        if ((r10 instanceof LazyField) == false) goto L39;
        return ((LazyField) r10).computeSizeNoTag();
    L39:
        return CodedOutputStream.computeMessageSizeNoTag((MessageLite) r10);
    L41:
        return ((MessageLite) r10).getSerializedSize();
    L43:
        return CodedOutputStream.computeBoolSizeNoTag(((Boolean) r10).booleanValue());
    L45:
        return CodedOutputStream.computeFixed32SizeNoTag(((Integer) r10).intValue());
    L47:
        return CodedOutputStream.computeFixed64SizeNoTag(((Long) r10).longValue());
    L49:
        return CodedOutputStream.computeInt32SizeNoTag(((Integer) r10).intValue());
    L51:
        return CodedOutputStream.computeUInt64SizeNoTag(((Long) r10).longValue());
    L53:
        return CodedOutputStream.computeInt64SizeNoTag(((Long) r10).longValue());
    L55:
        return CodedOutputStream.computeFloatSizeNoTag(((Float) r10).floatValue());
    L57:
        return CodedOutputStream.computeDoubleSizeNoTag(((Double) r10).doubleValue());
    }

    public static int computeFieldSize(FieldDescriptorLite<?> r8, Object r10) {
        WireFormat.FieldType r11 = r8.getLiteType();
        int r12 = r8.getNumber();
        if (r8.isRepeated() == false) goto L19;
        List r13 = (List) r10;
        int r14 = r13.size();
        int r15 = 0;
        if (r8.isPacked() == true) goto L7;
        int r16 = 0;
    L15:
        if (r15 >= r14) goto L17;
        r16 = r16 + computeElementSize(r11, r12, r13.get(r15));
        r15 = r15 + 1;
        goto L15
    L17:
        return r16;
    L7:
        if (r13.isEmpty() == false) goto L9;
        return 0;
    L9:
        int r17 = 0;
    L10:
        if (r15 >= r14) goto L13;
        r17 = r17 + computeElementSizeNoTag(r11, r13.get(r15));
        r15 = r15 + 1;
        goto L10
    L13:
        return CodedOutputStream.computeUInt32SizeNoTag(r17) + (CodedOutputStream.computeTagSize(r12) + r17);
    L19:
        return computeElementSize(r11, r12, r10);
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet<T> emptySet() {
        return (FieldSet<T>) DEFAULT_INSTANCE;
    }

    public static int getWireFormatForFieldType(WireFormat.FieldType r8, boolean r10) {
        if (r10 == false) goto L6;
        return 2;
    L6:
        return r8.getWireType();
    }

    private static boolean isMessageFieldValueInitialized(Object r8) {
        if ((r8 instanceof MessageLiteOrBuilder) == false) goto L7;
        return ((MessageLiteOrBuilder) r8).isInitialized();
    L7:
        if ((r8 instanceof LazyField) == false) goto L11;
        return true;
    L11:
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static boolean isValidType(WireFormat.FieldType r8, Object r10) {
        Internal.checkNotNull(r10);
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$JavaType[r8.getJavaType().ordinal()]) {
            case 1: goto L37;
            case 2: goto L35;
            case 3: goto L33;
            case 4: goto L31;
            case 5: goto L29;
            case 6: goto L27;
            case 7: goto L20;
            case 8: goto L13;
            case 9: goto L6;
            default: goto L4;
        };
    L4:
        return false;
    L6:
        if ((r10 instanceof MessageLite) == false) goto L8;
        return true;
    L8:
        if ((r10 instanceof LazyField) == false) goto L11;
        return true;
    L11:
        return false;
    L13:
        if ((r10 instanceof Integer) == false) goto L15;
        return true;
    L15:
        if ((r10 instanceof Internal.EnumLite) == false) goto L18;
        return true;
    L18:
        return false;
    L20:
        if ((r10 instanceof ByteString) == false) goto L22;
        return true;
    L22:
        if ((r10 instanceof byte[]) == false) goto L25;
        return true;
    L25:
        return false;
    L27:
        return r10 instanceof String;
    L29:
        return r10 instanceof Boolean;
    L31:
        return r10 instanceof Double;
    L33:
        return r10 instanceof Float;
    L35:
        return r10 instanceof Long;
    L37:
        return r10 instanceof Integer;
    }

    private void mergeFromField(Map.Entry<T, Object> r8) {
        T r10 = r8.getKey();
        Object r11 = r8.getValue();
        boolean r12 = r11 instanceof LazyField;
        if (r10.isRepeated() == false) goto L15;
        if (r12 == true) goto L13;
        Object r13 = getField(r10);
        List r14 = (List) r11;
        int r15 = r14.size();
        if (r13 != null) goto L8;
        r13 = new ArrayList(r15);
    L8:
        List r16 = (List) r13;
        int r17 = 0;
    L9:
        if (r17 >= r15) goto L11;
        r16.add(cloneIfMutable(r14.get(r17)));
        r17 = r17 + 1;
        goto L9
    L11:
        this.fields.put(r10, r13);
        return;
    L13:
        throw new IllegalStateException("Lazy fields can not be repeated");
    L15:
        if (r10.getLiteJavaType() != WireFormat.JavaType.MESSAGE) goto L27;
        Object r18 = getField(r10);
        if (r18 != null) goto L21;
        this.fields.put(r10, cloneIfMutable(r11));
        if (r12 == false) goto L35;
        this.hasLazyField = true;
        return;
    L35:
        return;
    L21:
        if (r12 == false) goto L24;
        r11 = ((LazyField) r11).getValue();
    L24:
        if (r10.internalMessageIsImmutable(r18) == false) goto L26;
        MessageLite.Builder r19 = ((MessageLite) r18).toBuilder();
        r10.internalMergeFrom(r19, r11);
        SmallSortedMap<T, Object> r20 = this.fields;
        Object r21 = r19.build();
    L29:
        r20.put(r10, r21);
        return;
    L26:
        r10.internalMergeFrom(r18, r11);
        return;
    L27:
        if (r12 == true) goto L32;
        r20 = this.fields;
        r21 = cloneIfMutable(r11);
        goto L29
    L32:
        throw new IllegalStateException("Lazy fields must be message-valued");
    }

    public static <T extends FieldDescriptorLite<T>> Builder<T> newBuilder() {
        return new Builder(null);
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet<T> newFieldSet() {
        return new FieldSet();
    }

    public static Object readPrimitiveField(CodedInputStream r8, WireFormat.FieldType r10, boolean r11) {
        if (r11 == false) goto L6;
        WireFormat.Utf8Validation r12 = WireFormat.Utf8Validation.STRICT;
    L5:
        return r8.readPrimitiveField(r10, r12);
    L6:
        r12 = WireFormat.Utf8Validation.LOOSE;
        goto L5
    }

    private void verifyType(T r8, Object r10) {
        if (isValidType(r8.getLiteType(), r10) == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(r8.getNumber()), r8.getLiteType().getJavaType(), r10.getClass().getName()}));
    }

    public static void writeElement(CodedOutputStream r8, WireFormat.FieldType r10, int r11, Object r12) {
        if (r10 != WireFormat.FieldType.GROUP) goto L5;
        r8.writeGroup(r11, (MessageLite) r12);
        return;
    L5:
        r8.writeTag(r11, getWireFormatForFieldType(r10, false));
        writeElementNoTag(r8, r10, r12);
    }

    public static void writeElementNoTag(CodedOutputStream r8, WireFormat.FieldType r10, Object r11) {
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r10.ordinal()]) {
            case 1: goto L32;
            case 2: goto L31;
            case 3: goto L30;
            case 4: goto L29;
            case 5: goto L28;
            case 6: goto L27;
            case 7: goto L26;
            case 8: goto L25;
            case 9: goto L24;
            case 10: goto L23;
            case 11: goto L20;
            case 12: goto L16;
            case 13: goto L14;
            case 14: goto L13;
            case 15: goto L12;
            case 16: goto L11;
            case 17: goto L10;
            case 18: goto L6;
            default: goto L52;
        };
    L10:
        r8.writeSInt64NoTag(((Long) r11).longValue());
        return;
    L11:
        r8.writeSInt32NoTag(((Integer) r11).intValue());
        return;
    L12:
        r8.writeSFixed64NoTag(((Long) r11).longValue());
        return;
    L13:
        r8.writeSFixed32NoTag(((Integer) r11).intValue());
        return;
    L14:
        r8.writeUInt32NoTag(((Integer) r11).intValue());
        return;
    L23:
        r8.writeMessageNoTag((MessageLite) r11);
        return;
    L24:
        r8.writeGroupNoTag((MessageLite) r11);
        return;
    L25:
        r8.writeBoolNoTag(((Boolean) r11).booleanValue());
        return;
    L26:
        r8.writeFixed32NoTag(((Integer) r11).intValue());
        return;
    L27:
        r8.writeFixed64NoTag(((Long) r11).longValue());
        return;
    L28:
        r8.writeInt32NoTag(((Integer) r11).intValue());
        return;
    L29:
        r8.writeUInt64NoTag(((Long) r11).longValue());
        return;
    L30:
        r8.writeInt64NoTag(((Long) r11).longValue());
        return;
    L31:
        r8.writeFloatNoTag(((Float) r11).floatValue());
        return;
    L32:
        r8.writeDoubleNoTag(((Double) r11).doubleValue());
        return;
    L52:
        return;
    L6:
        if ((r11 instanceof Internal.EnumLite) == false) goto L8;
        int r12 = ((Internal.EnumLite) r11).getNumber();
    L9:
        r8.writeEnumNoTag(r12);
        return;
    L8:
        r12 = ((Integer) r11).intValue();
        goto L9
    L16:
        if ((r11 instanceof ByteString) == true) goto L21;
        r8.writeByteArrayNoTag((byte[]) r11);
        return;
    L21:
        r8.writeBytesNoTag((ByteString) r11);
        return;
    L20:
        if ((r11 instanceof ByteString) == true) goto L21;
        r8.writeStringNoTag((String) r11);
    }

    public static void writeField(FieldDescriptorLite<?> r8, Object r10, CodedOutputStream r11) {
        WireFormat.FieldType r12 = r8.getLiteType();
        int r13 = r8.getNumber();
        if (r8.isRepeated() == false) goto L18;
        List r14 = (List) r10;
        int r15 = r14.size();
        int r16 = 0;
        if (r8.isPacked() == true) goto L7;
    L15:
        if (r16 >= r15) goto L27;
        writeElement(r11, r12, r13, r14.get(r16));
        r16 = r16 + 1;
        goto L15
    L27:
        return;
    L7:
        if (r14.isEmpty() == false) goto L9;
        return;
    L9:
        r11.writeTag(r13, 2);
        int r17 = 0;
        int r18 = 0;
    L10:
        if (r17 >= r15) goto L12;
        r18 = r18 + computeElementSizeNoTag(r12, r14.get(r17));
        r17 = r17 + 1;
        goto L10
    L12:
        r11.writeUInt32NoTag(r18);
    L13:
        if (r16 >= r15) goto L26;
        writeElementNoTag(r11, r12, r14.get(r16));
        r16 = r16 + 1;
        goto L13
    L26:
        return;
    L18:
        if ((r10 instanceof LazyField) == false) goto L20;
        writeElement(r11, r12, r13, ((LazyField) r10).getValue());
        return;
    L20:
        writeElement(r11, r12, r13, r10);
    }

    public void addRepeatedField(T r8, Object r10) {
        if (r8.isRepeated() == false) goto L11;
        verifyType(r8, r10);
        Object r11 = getField(r8);
        if (r11 != null) goto L7;
        List r12 = new ArrayList();
        this.fields.put(r8, r12);
    L8:
        r12.add(r10);
        return;
    L7:
        r12 = (List) r11;
        goto L8
    L11:
        throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }

    public void clear() {
        this.fields.clear();
        this.hasLazyField = false;
    }

    public void clearField(T r8) {
        this.fields.remove(r8);
        if (this.fields.isEmpty() == false) goto L6;
        this.hasLazyField = false;
        return;
    }

    public FieldSet<T> clone() {
        FieldSet<T> r8 = newFieldSet();
        int r10 = this.fields.getNumArrayEntries();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        Map.Entry<K, Object> r12 = this.fields.getArrayEntryAt(r11);
        r8.setField((FieldDescriptorLite) r12.getKey(), r12.getValue());
        r11 = r11 + 1;
        goto L3
    L5:
        Iterator r13 = this.fields.getOverflowEntries().iterator();
    L7:
        if (r13.hasNext() == false) goto L9;
        Map.Entry r14 = (Map.Entry) r13.next();
        r8.setField((FieldDescriptorLite) r14.getKey(), r14.getValue());
        goto L7
    L9:
        r8.hasLazyField = this.hasLazyField;
        return r8;
    }

    public Iterator<Map.Entry<T, Object>> descendingIterator() {
        if (isEmpty() == false) goto L7;
        return Collections.emptyIterator();
    L7:
        if (this.hasLazyField == false) goto L11;
        return new LazyField.LazyIterator(this.fields.descendingEntrySet().iterator());
    L11:
        return this.fields.descendingEntrySet().iterator();
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof FieldSet) == true) goto L10;
        return false;
    L10:
        return this.fields.equals(((FieldSet) r8).fields);
    }

    public Map<T, Object> getAllFields() {
        if (this.hasLazyField == false) goto L8;
        SmallSortedMap r8 = cloneAllFieldsMap(this.fields, false, true);
        if (this.fields.isImmutable() == false) goto L7;
        r8.makeImmutable();
    L7:
        return r8;
    L8:
        boolean r10 = this.fields.isImmutable();
        SmallSortedMap<T, Object> r11 = this.fields;
        if (r10 == false) goto L12;
        return r11;
    L12:
        return Collections.unmodifiableMap(r11);
    }

    public Object getField(T r8) {
        Object r10 = this.fields.get(r8);
        if ((r10 instanceof LazyField) == true) goto L5;
        return r10;
    L5:
        return ((LazyField) r10).getValue();
    }

    public int getMessageSetSerializedSize() {
        int r8 = this.fields.getNumArrayEntries();
        int r10 = 0;
        int r11 = 0;
    L3:
        if (r10 >= r8) goto L5;
        r11 = r11 + getMessageSetSerializedSize(this.fields.getArrayEntryAt(r10));
        r10 = r10 + 1;
        goto L3
    L5:
        Iterator r12 = this.fields.getOverflowEntries().iterator();
    L7:
        if (r12.hasNext() == false) goto L9;
        r11 = r11 + getMessageSetSerializedSize((Map.Entry) r12.next());
        goto L7
    L9:
        return r11;
    }

    public Object getRepeatedField(T r8, int r10) {
        if (r8.isRepeated() == false) goto L11;
        Object r11 = getField(r8);
        if (r11 == null) goto L9;
        return ((List) r11).get(r10);
    L9:
        throw new IndexOutOfBoundsException();
    L11:
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public int getRepeatedFieldCount(T r8) {
        if (r8.isRepeated() == false) goto L11;
        Object r10 = getField(r8);
        if (r10 != null) goto L9;
        return 0;
    L9:
        return ((List) r10).size();
    L11:
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public int getSerializedSize() {
        int r8 = this.fields.getNumArrayEntries();
        int r10 = 0;
        int r11 = 0;
    L3:
        if (r10 >= r8) goto L5;
        Map.Entry<K, Object> r12 = this.fields.getArrayEntryAt(r10);
        r11 = r11 + computeFieldSize((FieldDescriptorLite) r12.getKey(), r12.getValue());
        r10 = r10 + 1;
        goto L3
    L5:
        Iterator r13 = this.fields.getOverflowEntries().iterator();
    L7:
        if (r13.hasNext() == false) goto L9;
        Map.Entry r14 = (Map.Entry) r13.next();
        r11 = r11 + computeFieldSize((FieldDescriptorLite) r14.getKey(), r14.getValue());
        goto L7
    L9:
        return r11;
    }

    public boolean hasField(T r8) {
        if (r8.isRepeated() == true) goto L10;
        if (this.fields.get(r8) == null) goto L7;
        return true;
    L7:
        return false;
    L10:
        throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
    }

    public int hashCode() {
        return this.fields.hashCode();
    }

    public boolean isEmpty() {
        return this.fields.isEmpty();
    }

    public boolean isImmutable() {
        return this.isImmutable;
    }

    public boolean isInitialized() {
        int r8 = this.fields.getNumArrayEntries();
        int r10 = 0;
    L3:
        if (r10 >= r8) goto L8;
        if (isInitialized(this.fields.getArrayEntryAt(r10)) == false) goto L6;
        r10 = r10 + 1;
        goto L3
    L6:
        return false;
    L8:
        Iterator r11 = this.fields.getOverflowEntries().iterator();
    L10:
        if (r11.hasNext() == false) goto L14;
        if (isInitialized((Map.Entry) r11.next()) == true) goto L10;
        return false;
    L14:
        return true;
    }

    public Iterator<Map.Entry<T, Object>> iterator() {
        if (isEmpty() == false) goto L7;
        return Collections.emptyIterator();
    L7:
        if (this.hasLazyField == false) goto L11;
        return new LazyField.LazyIterator(this.fields.entrySet().iterator());
    L11:
        return this.fields.entrySet().iterator();
    }

    public boolean lazyFieldCorrupted(T r8) {
        Object r10 = this.fields.get(r8);
        if ((r10 instanceof LazyField) == true) goto L5;
    L7:
        return false;
    L5:
        if (((LazyField) r10).isCorrupted() == false) goto L7;
        return true;
    }

    public void makeImmutable() {
        if (this.isImmutable == false) goto L5;
        return;
    L5:
        int r8 = this.fields.getNumArrayEntries();
        int r10 = 0;
    L6:
        if (r10 >= r8) goto L11;
        Object r11 = this.fields.getArrayEntryAt(r10).getValue();
        if ((r11 instanceof GeneratedMessageLite) == false) goto L10;
        ((GeneratedMessageLite) r11).makeImmutable();
    L10:
        r10 = r10 + 1;
        goto L6
    L11:
        Iterator r12 = this.fields.getOverflowEntries().iterator();
    L13:
        if (r12.hasNext() == false) goto L17;
        Object r13 = ((Map.Entry) r12.next()).getValue();
        if ((r13 instanceof GeneratedMessageLite) == false) goto L13;
        ((GeneratedMessageLite) r13).makeImmutable();
        goto L13
    L17:
        this.fields.makeImmutable();
        this.isImmutable = true;
    }

    public void mergeFrom(FieldSet<T> r8) {
        int r10 = r8.fields.getNumArrayEntries();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        mergeFromField(r8.fields.getArrayEntryAt(r11));
        r11 = r11 + 1;
        goto L3
    L5:
        Iterator r12 = r8.fields.getOverflowEntries().iterator();
    L7:
        if (r12.hasNext() == false) goto L9;
        mergeFromField((Map.Entry) r12.next());
        goto L7
    }

    public void setField(T r8, Object r10) {
        if (r8.isRepeated() == true) goto L5;
        verifyType(r8, r10);
    L14:
        if ((r10 instanceof LazyField) == false) goto L16;
        this.hasLazyField = true;
    L16:
        this.fields.put(r8, r10);
        return;
    L5:
        if ((r10 instanceof List) == false) goto L11;
        List r11 = (List) r10;
        int r12 = r11.size();
        ArrayList r13 = new ArrayList(r12);
        int r14 = 0;
    L7:
        if (r14 >= r12) goto L9;
        Object r15 = r11.get(r14);
        verifyType(r8, r15);
        r13.add(r15);
        r14 = r14 + 1;
        goto L7
    L9:
        r10 = r13;
        goto L14
    L11:
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    public void setRepeatedField(T r8, int r10, Object r11) {
        if (r8.isRepeated() == false) goto L11;
        Object r12 = getField(r8);
        if (r12 == null) goto L9;
        verifyType(r8, r11);
        ((List) r12).set(r10, r11);
        return;
    L9:
        throw new IndexOutOfBoundsException();
    L11:
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public void writeMessageSetTo(CodedOutputStream r8) {
        int r10 = this.fields.getNumArrayEntries();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        writeMessageSetTo(this.fields.getArrayEntryAt(r11), r8);
        r11 = r11 + 1;
        goto L3
    L5:
        Iterator r12 = this.fields.getOverflowEntries().iterator();
    L7:
        if (r12.hasNext() == false) goto L9;
        writeMessageSetTo((Map.Entry) r12.next(), r8);
        goto L7
    }

    public void writeTo(CodedOutputStream r8) {
        int r10 = this.fields.getNumArrayEntries();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        Map.Entry<K, Object> r12 = this.fields.getArrayEntryAt(r11);
        writeField((FieldDescriptorLite) r12.getKey(), r12.getValue(), r8);
        r11 = r11 + 1;
        goto L3
    L5:
        Iterator r13 = this.fields.getOverflowEntries().iterator();
    L7:
        if (r13.hasNext() == false) goto L9;
        Map.Entry r14 = (Map.Entry) r13.next();
        writeField((FieldDescriptorLite) r14.getKey(), r14.getValue(), r8);
        goto L7
    }

    private FieldSet(SmallSortedMap<T, Object> r8) {
        this.fields = r8;
        makeImmutable();
    }

    private int getMessageSetSerializedSize(Map.Entry<T, Object> r8) {
        T r10 = r8.getKey();
        Object r11 = r8.getValue();
        if (r10.getLiteJavaType() != WireFormat.JavaType.MESSAGE) goto L15;
        if (r10.isRepeated() == true) goto L15;
        if (r10.isPacked() == true) goto L15;
        if ((r11 instanceof LazyField) == false) goto L13;
        return ((LazyField) r11).computeMessageSetExtensionSize(r8.getKey().getNumber());
    L13:
        return CodedOutputStream.computeMessageSetExtensionSize(r8.getKey().getNumber(), (MessageLite) r11);
    L15:
        return computeFieldSize(r10, r11);
    }

    private static <T extends FieldDescriptorLite<T>> boolean isInitialized(Map.Entry<T, Object> r8) {
        T r10 = r8.getKey();
        if (r10.getLiteJavaType() != WireFormat.JavaType.MESSAGE) goto L14;
        boolean r11 = r10.isRepeated();
        Object r12 = r8.getValue();
        if (r11 == false) goto L13;
        List r13 = (List) r12;
        int r14 = r13.size();
        int r15 = 0;
    L7:
        if (r15 >= r14) goto L18;
        if (isMessageFieldValueInitialized(r13.get(r15)) == false) goto L10;
        r15 = r15 + 1;
        goto L7
    L10:
        return false;
    L18:
        return true;
    L13:
        return isMessageFieldValueInitialized(r12);
    L14:
        return true;
    }

    private void writeMessageSetTo(Map.Entry<T, Object> r8, CodedOutputStream r10) {
        T r11 = r8.getKey();
        if (r11.getLiteJavaType() == WireFormat.JavaType.MESSAGE) goto L5;
    L12:
        writeField(r11, r8.getValue(), r10);
        return;
    L5:
        if (r11.isRepeated() == true) goto L12;
        if (r11.isPacked() == true) goto L12;
        Object r12 = r8.getValue();
        if ((r12 instanceof LazyField) == false) goto L11;
        ByteString r13 = ((LazyField) r12).toByteString();
        r10.writeRawMessageSetExtension(r8.getKey().getNumber(), r13);
        return;
    L11:
        r10.writeMessageSetExtension(r8.getKey().getNumber(), (MessageLite) r12);
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m6clone() {
        return clone();
    }

    public /* synthetic */ FieldSet(SmallSortedMap r8, AnonymousClass1 r10) {
        this(r8);
    }

    private FieldSet(boolean r8) {
        this(SmallSortedMap.newFieldMap());
        makeImmutable();
    }
}
