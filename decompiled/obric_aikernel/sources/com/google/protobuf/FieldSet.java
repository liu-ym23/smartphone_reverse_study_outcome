package com.google.protobuf;

import com.google.protobuf.FieldSet.FieldDescriptorLite;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class FieldSet<T extends FieldDescriptorLite<T>> {
    private static final FieldSet<?> DEFAULT_INSTANCE = null;
    private final SmallSortedMap<T, Object> fields;
    private boolean hasLazyField;
    private boolean isImmutable;

    /* JADX INFO: renamed from: com.google.protobuf.FieldSet$1, reason: invalid class name */
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

    static final class Builder<T extends FieldDescriptorLite<T>> {
        private SmallSortedMap<T, Object> fields;
        private boolean hasLazyField;
        private boolean hasNestedBuilders;
        private boolean isMutable;

        private Builder() {
            this(SmallSortedMap.newFieldMap());
        }

        /* synthetic */ Builder(AnonymousClass1 r10) {
            this();
        }

        private Builder(SmallSortedMap<T, Object> r10) {
            this.fields = r10;
            this.isMutable = true;
        }

        private FieldSet<T> buildImpl(boolean r10) {
            if (this.fields.isEmpty() == true) goto L5;
            this.isMutable = false;
            SmallSortedMap<T, Object> r11 = this.fields;
            if (this.hasNestedBuilders == false) goto L9;
            r11 = FieldSet.access$100(r11, false, false);
            replaceBuilders(r11, r10);
        L9:
            FieldSet<T> r12 = new FieldSet(r11, null);
            FieldSet.access$302(r12, this.hasLazyField);
            return r12;
        L5:
            return FieldSet.emptySet();
        }

        private void ensureIsMutable() {
            if (this.isMutable == true) goto L6;
            this.fields = FieldSet.access$100(this.fields, true, false);
            this.isMutable = true;
            return;
        }

        public static <T extends FieldDescriptorLite<T>> Builder<T> fromFieldSet(FieldSet<T> r10) {
            Builder<T> r11 = new Builder(FieldSet.access$100(FieldSet.access$400(r10), true, false));
            ((Builder) r11).hasLazyField = FieldSet.access$300(r10);
            return r11;
        }

        private void mergeFromField(Map.Entry<T, Object> r10) {
            T r11 = r10.getKey();
            Object r12 = r10.getValue();
            boolean r13 = r12 instanceof LazyField;
            if (r11.isRepeated() == false) goto L14;
            if (r13 == true) goto L12;
            List r14 = (List) getFieldAllowBuilders(r11);
            List r15 = (List) r12;
            int r16 = r15.size();
            if (r14 != null) goto L8;
            r14 = new ArrayList(r16);
            this.fields.put(r11, r14);
        L8:
            int r17 = 0;
        L9:
            if (r17 >= r16) goto L36;
            r14.add(FieldSet.access$700(r15.get(r17)));
            r17 = r17 + 1;
            goto L9
        L36:
            return;
        L12:
            throw new IllegalStateException("Lazy fields can not be repeated");
        L14:
            if (r11.getLiteJavaType() != WireFormat.JavaType.MESSAGE) goto L26;
            Object r18 = getFieldAllowBuilders(r11);
            if (r18 != null) goto L20;
            this.fields.put(r11, FieldSet.access$700(r12));
            if (r13 == false) goto L33;
            this.hasLazyField = true;
            return;
        L33:
            return;
        L20:
            if (r13 == false) goto L23;
            r12 = ((LazyField) r12).getValue();
        L23:
            if ((r18 instanceof MessageLite.Builder) == false) goto L25;
            r11.internalMergeFrom((MessageLite.Builder) r18, (MessageLite) r12);
            return;
        L25:
            Object r19 = r11.internalMergeFrom(((MessageLite) r18).toBuilder(), (MessageLite) r12).build();
            SmallSortedMap<T, Object> r20 = this.fields;
        L28:
            r20.put(r11, r19);
            return;
        L26:
            if (r13 == true) goto L31;
            r20 = this.fields;
            r19 = FieldSet.access$700(r12);
            goto L28
        L31:
            throw new IllegalStateException("Lazy fields must be message-valued");
        }

        private static Object replaceBuilder(Object r10, boolean r11) {
            if ((r10 instanceof MessageLite.Builder) == true) goto L5;
            return r10;
        L5:
            MessageLite.Builder r12 = (MessageLite.Builder) r10;
            if (r11 == false) goto L10;
            return r12.buildPartial();
        L10:
            return r12.build();
        }

        private static <T extends FieldDescriptorLite<T>> Object replaceBuilders(T r10, Object r11, boolean r12) {
            if (r11 != null) goto L5;
            return r11;
        L5:
            if (r10.getLiteJavaType() == WireFormat.JavaType.MESSAGE) goto L7;
            return r11;
        L7:
            if (r10.isRepeated() == false) goto L23;
            if ((r11 instanceof List) == false) goto L21;
            List r13 = (List) r11;
            int r14 = 0;
        L12:
            if (r14 >= r13.size()) goto L19;
            Object r15 = r13.get(r14);
            Object r16 = replaceBuilder(r15, r12);
            if (r16 == r15) goto L18;
            if (r13 != r11) goto L17;
            r13 = new ArrayList(r13);
        L17:
            r13.set(r14, r16);
        L18:
            r14 = r14 + 1;
            goto L12
        L19:
            return r13;
        L21:
            throw new IllegalStateException("Repeated field should contains a List but actually contains type: " + r11.getClass());
        L23:
            return replaceBuilder(r11, r12);
        }

        private static <T extends FieldDescriptorLite<T>> void replaceBuilders(SmallSortedMap<T, Object> r10, boolean r11) {
            int r12 = r10.getNumArrayEntries();
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L5;
            replaceBuilders(r10.getArrayEntryAt(r13), r11);
            r13 = r13 + 1;
            goto L3
        L5:
            Iterator r14 = r10.getOverflowEntries().iterator();
        L7:
            if (r14.hasNext() == false) goto L9;
            replaceBuilders((Map.Entry) r14.next(), r11);
            goto L7
        }

        private static <T extends FieldDescriptorLite<T>> void replaceBuilders(Map.Entry<T, Object> r10, boolean r11) {
            r10.setValue(replaceBuilders(r10.getKey(), r10.getValue(), r11));
        }

        private void verifyType(T r10, Object r11) {
            if (FieldSet.access$500(r10.getLiteType(), r11) == false) goto L5;
            return;
        L5:
            if (r10.getLiteType().getJavaType() != WireFormat.JavaType.MESSAGE) goto L10;
            if ((r11 instanceof MessageLite.Builder) == false) goto L10;
            return;
        L10:
            throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(r10.getNumber()), r10.getLiteType().getJavaType(), r11.getClass().getName()}));
        }

        public void addRepeatedField(T r10, Object r11) {
            ensureIsMutable();
            if (r10.isRepeated() == false) goto L18;
            if (this.hasNestedBuilders == false) goto L7;
        L10:
            boolean r12 = true;
        L11:
            this.hasNestedBuilders = r12;
            verifyType(r10, r11);
            Object r13 = getFieldAllowBuilders(r10);
            if (r13 != null) goto L14;
            List r14 = new ArrayList();
            this.fields.put(r10, r14);
        L15:
            r14.add(r11);
            return;
        L14:
            r14 = (List) r13;
            goto L15
        L7:
            if ((r11 instanceof MessageLite.Builder) == true) goto L10;
            r12 = false;
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

        public void clearField(T r10) {
            ensureIsMutable();
            this.fields.remove(r10);
            if (this.fields.isEmpty() == false) goto L6;
            this.hasLazyField = false;
            return;
        }

        public Map<T, Object> getAllFields() {
            if (this.hasLazyField == false) goto L9;
            SmallSortedMap r10 = FieldSet.access$100(this.fields, false, true);
            if (this.fields.isImmutable() == false) goto L7;
            r10.makeImmutable();
        L8:
            return r10;
        L7:
            replaceBuilders(r10, true);
            goto L8
        L9:
            boolean r11 = this.fields.isImmutable();
            SmallSortedMap<T, Object> r12 = this.fields;
            if (r11 == false) goto L13;
            return r12;
        L13:
            return Collections.unmodifiableMap(r12);
        }

        public Object getField(T r10) {
            return replaceBuilders(r10, getFieldAllowBuilders(r10), true);
        }

        Object getFieldAllowBuilders(T r10) {
            Object r11 = this.fields.get(r10);
            if ((r11 instanceof LazyField) == true) goto L5;
            return r11;
        L5:
            return ((LazyField) r11).getValue();
        }

        public Object getRepeatedField(T r10, int r11) {
            if (this.hasNestedBuilders == false) goto L6;
            ensureIsMutable();
        L6:
            return replaceBuilder(getRepeatedFieldAllowBuilders(r10, r11), true);
        }

        Object getRepeatedFieldAllowBuilders(T r10, int r11) {
            if (r10.isRepeated() == false) goto L11;
            Object r12 = getFieldAllowBuilders(r10);
            if (r12 == null) goto L9;
            return ((List) r12).get(r11);
        L9:
            throw new IndexOutOfBoundsException();
        L11:
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }

        public int getRepeatedFieldCount(T r10) {
            if (r10.isRepeated() == false) goto L11;
            Object r11 = getFieldAllowBuilders(r10);
            if (r11 != null) goto L9;
            return 0;
        L9:
            return ((List) r11).size();
        L11:
            throw new IllegalArgumentException("getRepeatedFieldCount() can only be called on repeated fields.");
        }

        public boolean hasField(T r10) {
            if (r10.isRepeated() == true) goto L10;
            if (this.fields.get(r10) == null) goto L7;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
        }

        public boolean isInitialized() {
            int r10 = this.fields.getNumArrayEntries();
            int r11 = 0;
        L3:
            if (r11 >= r10) goto L8;
            if (FieldSet.access$600(this.fields.getArrayEntryAt(r11)) == false) goto L6;
            r11 = r11 + 1;
            goto L3
        L6:
            return false;
        L8:
            Iterator r12 = this.fields.getOverflowEntries().iterator();
        L10:
            if (r12.hasNext() == false) goto L14;
            if (FieldSet.access$600((Map.Entry) r12.next()) == true) goto L10;
            return false;
        L14:
            return true;
        }

        public void mergeFrom(FieldSet<T> r10) {
            ensureIsMutable();
            int r11 = FieldSet.access$400(r10).getNumArrayEntries();
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L5;
            mergeFromField(FieldSet.access$400(r10).getArrayEntryAt(r12));
            r12 = r12 + 1;
            goto L3
        L5:
            Iterator r13 = FieldSet.access$400(r10).getOverflowEntries().iterator();
        L7:
            if (r13.hasNext() == false) goto L9;
            mergeFromField((Map.Entry) r13.next());
            goto L7
        }

        public void setField(T r10, Object r11) {
            ensureIsMutable();
            boolean r12 = false;
            if (r10.isRepeated() == true) goto L5;
            verifyType(r10, r11);
        L21:
            if ((r11 instanceof LazyField) == false) goto L24;
            this.hasLazyField = true;
        L24:
            if (this.hasNestedBuilders == false) goto L26;
        L27:
            r12 = true;
        L28:
            this.hasNestedBuilders = r12;
            this.fields.put(r10, r11);
            return;
        L26:
            if ((r11 instanceof MessageLite.Builder) == false) goto L28;
        L5:
            if ((r11 instanceof List) == false) goto L18;
            ArrayList r13 = new ArrayList((List) r11);
            int r14 = r13.size();
            int r15 = 0;
        L7:
            if (r15 >= r14) goto L16;
            Object r16 = r13.get(r15);
            verifyType(r10, r16);
            if (this.hasNestedBuilders == false) goto L11;
        L14:
            boolean r17 = true;
        L15:
            this.hasNestedBuilders = r17;
            r15 = r15 + 1;
            goto L7
        L11:
            if ((r16 instanceof MessageLite.Builder) == true) goto L14;
            r17 = false;
            goto L15
        L16:
            r11 = r13;
            goto L21
        L18:
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }

        public void setRepeatedField(T r10, int r11, Object r12) {
            ensureIsMutable();
            if (r10.isRepeated() == false) goto L18;
            if (this.hasNestedBuilders == false) goto L7;
        L10:
            boolean r13 = true;
        L11:
            this.hasNestedBuilders = r13;
            Object r14 = getFieldAllowBuilders(r10);
            if (r14 == null) goto L16;
            verifyType(r10, r12);
            ((List) r14).set(r11, r12);
            return;
        L16:
            throw new IndexOutOfBoundsException();
        L7:
            if ((r12 instanceof MessageLite.Builder) == true) goto L10;
            r13 = false;
            goto L11
        L18:
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
    }

    public interface FieldDescriptorLite<T extends FieldDescriptorLite<T>> extends Comparable<T> {
        Internal.EnumLiteMap<?> getEnumType();

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
        this.fields = SmallSortedMap.newFieldMap();
    }

    private FieldSet(SmallSortedMap<T, Object> r10) {
        this.fields = r10;
        makeImmutable();
    }

    /* synthetic */ FieldSet(SmallSortedMap r10, AnonymousClass1 r11) {
        this(r10);
    }

    private FieldSet(boolean r10) {
        this(SmallSortedMap.newFieldMap());
        makeImmutable();
    }

    static /* synthetic */ SmallSortedMap access$100(SmallSortedMap r10, boolean r11, boolean r12) {
        return cloneAllFieldsMap(r10, r11, r12);
    }

    static /* synthetic */ boolean access$300(FieldSet r10) {
        return r10.hasLazyField;
    }

    static /* synthetic */ boolean access$302(FieldSet r10, boolean r11) {
        r10.hasLazyField = r11;
        return r11;
    }

    static /* synthetic */ SmallSortedMap access$400(FieldSet r10) {
        return r10.fields;
    }

    static /* synthetic */ boolean access$500(WireFormat.FieldType r10, Object r11) {
        return isValidType(r10, r11);
    }

    static /* synthetic */ boolean access$600(Map.Entry r10) {
        return isInitialized(r10);
    }

    static /* synthetic */ Object access$700(Object r10) {
        return cloneIfMutable(r10);
    }

    private static <T extends FieldDescriptorLite<T>> SmallSortedMap<T, Object> cloneAllFieldsMap(SmallSortedMap<T, Object> r10, boolean r11, boolean r12) {
        SmallSortedMap<T, Object> r13 = SmallSortedMap.newFieldMap();
        int r14 = r10.getNumArrayEntries();
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L5;
        cloneFieldEntry(r13, r10.getArrayEntryAt(r15), r11, r12);
        r15 = r15 + 1;
        goto L3
    L5:
        Iterator r16 = r10.getOverflowEntries().iterator();
    L7:
        if (r16.hasNext() == false) goto L9;
        cloneFieldEntry(r13, (Map.Entry) r16.next(), r11, r12);
        goto L7
    L9:
        return r13;
    }

    private static <T extends FieldDescriptorLite<T>> void cloneFieldEntry(Map<T, Object> r10, Map.Entry<T, Object> r11, boolean r12, boolean r13) {
        T r14 = r11.getKey();
        Object r15 = r11.getValue();
        if (r13 == true) goto L5;
    L7:
        if (r12 == true) goto L9;
    L11:
        r10.put(r14, r15);
        return;
    L9:
        if ((r15 instanceof List) == false) goto L11;
        r10.put(r14, new ArrayList((List) r15));
        return;
    L5:
        if ((r15 instanceof LazyField) == false) goto L7;
        r15 = ((LazyField) r15).getValue();
        goto L11
    }

    private static Object cloneIfMutable(Object r10) {
        if ((r10 instanceof byte[]) == false) goto L6;
        byte[] r11 = (byte[]) r10;
        byte[] r12 = new byte[r11.length];
        System.arraycopy(r11, 0, r12, 0, r11.length);
        return r12;
    L6:
        return r10;
    }

    static int computeElementSize(WireFormat.FieldType r10, int r11, Object r12) {
        int r13 = CodedOutputStream.computeTagSize(r11);
        if (r10 != WireFormat.FieldType.GROUP) goto L6;
        r13 = r13 * 2;
    L6:
        return r13 + computeElementSizeNoTag(r10, r12);
    }

    static int computeElementSizeNoTag(WireFormat.FieldType r10, Object r11) {
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r10.ordinal()]) {
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
        if ((r11 instanceof Internal.EnumLite) == false) goto L11;
        return CodedOutputStream.computeEnumSizeNoTag(((Internal.EnumLite) r11).getNumber());
    L11:
        return CodedOutputStream.computeEnumSizeNoTag(((Integer) r11).intValue());
    L13:
        return CodedOutputStream.computeSInt64SizeNoTag(((Long) r11).longValue());
    L15:
        return CodedOutputStream.computeSInt32SizeNoTag(((Integer) r11).intValue());
    L17:
        return CodedOutputStream.computeSFixed64SizeNoTag(((Long) r11).longValue());
    L19:
        return CodedOutputStream.computeSFixed32SizeNoTag(((Integer) r11).intValue());
    L21:
        return CodedOutputStream.computeUInt32SizeNoTag(((Integer) r11).intValue());
    L23:
        if ((r11 instanceof ByteString) == false) goto L27;
        return CodedOutputStream.computeBytesSizeNoTag((ByteString) r11);
    L27:
        return CodedOutputStream.computeByteArraySizeNoTag((byte[]) r11);
    L29:
        if ((r11 instanceof ByteString) == false) goto L33;
        return CodedOutputStream.computeBytesSizeNoTag((ByteString) r11);
    L33:
        return CodedOutputStream.computeStringSizeNoTag((String) r11);
    L35:
        if ((r11 instanceof LazyField) == false) goto L39;
        return CodedOutputStream.computeLazyFieldSizeNoTag((LazyField) r11);
    L39:
        return CodedOutputStream.computeMessageSizeNoTag((MessageLite) r11);
    L41:
        return CodedOutputStream.computeGroupSizeNoTag((MessageLite) r11);
    L43:
        return CodedOutputStream.computeBoolSizeNoTag(((Boolean) r11).booleanValue());
    L45:
        return CodedOutputStream.computeFixed32SizeNoTag(((Integer) r11).intValue());
    L47:
        return CodedOutputStream.computeFixed64SizeNoTag(((Long) r11).longValue());
    L49:
        return CodedOutputStream.computeInt32SizeNoTag(((Integer) r11).intValue());
    L51:
        return CodedOutputStream.computeUInt64SizeNoTag(((Long) r11).longValue());
    L53:
        return CodedOutputStream.computeInt64SizeNoTag(((Long) r11).longValue());
    L55:
        return CodedOutputStream.computeFloatSizeNoTag(((Float) r11).floatValue());
    L57:
        return CodedOutputStream.computeDoubleSizeNoTag(((Double) r11).doubleValue());
    }

    public static int computeFieldSize(FieldDescriptorLite<?> r10, Object r11) {
        WireFormat.FieldType r12 = r10.getLiteType();
        int r13 = r10.getNumber();
        if (r10.isRepeated() == false) goto L19;
        List r14 = (List) r11;
        int r15 = r14.size();
        int r16 = 0;
        if (r10.isPacked() == true) goto L7;
        int r17 = 0;
    L15:
        if (r16 >= r15) goto L17;
        r17 = r17 + computeElementSize(r12, r13, r14.get(r16));
        r16 = r16 + 1;
        goto L15
    L17:
        return r17;
    L7:
        if (r14.isEmpty() == false) goto L9;
        return 0;
    L9:
        int r18 = 0;
    L10:
        if (r16 >= r15) goto L13;
        r18 = r18 + computeElementSizeNoTag(r12, r14.get(r16));
        r16 = r16 + 1;
        goto L10
    L13:
        return (CodedOutputStream.computeTagSize(r13) + r18) + CodedOutputStream.computeUInt32SizeNoTag(r18);
    L19:
        return computeElementSize(r12, r13, r11);
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet<T> emptySet() {
        return (FieldSet<T>) DEFAULT_INSTANCE;
    }

    private int getMessageSetSerializedSize(Map.Entry<T, Object> r10) {
        T r11 = r10.getKey();
        Object r12 = r10.getValue();
        if (r11.getLiteJavaType() != WireFormat.JavaType.MESSAGE) goto L15;
        if (r11.isRepeated() == true) goto L15;
        if (r11.isPacked() == true) goto L15;
        if ((r12 instanceof LazyField) == false) goto L13;
        return CodedOutputStream.computeLazyFieldMessageSetExtensionSize(r10.getKey().getNumber(), (LazyField) r12);
    L13:
        return CodedOutputStream.computeMessageSetExtensionSize(r10.getKey().getNumber(), (MessageLite) r12);
    L15:
        return computeFieldSize(r11, r12);
    }

    static int getWireFormatForFieldType(WireFormat.FieldType r10, boolean r11) {
        if (r11 == false) goto L6;
        return 2;
    L6:
        return r10.getWireType();
    }

    private static <T extends FieldDescriptorLite<T>> boolean isInitialized(Map.Entry<T, Object> r10) {
        T r11 = r10.getKey();
        if (r11.getLiteJavaType() != WireFormat.JavaType.MESSAGE) goto L14;
        boolean r12 = r11.isRepeated();
        Object r13 = r10.getValue();
        if (r12 == false) goto L13;
        List r14 = (List) r13;
        int r15 = r14.size();
        int r16 = 0;
    L7:
        if (r16 >= r15) goto L18;
        if (isMessageFieldValueInitialized(r14.get(r16)) == false) goto L10;
        r16 = r16 + 1;
        goto L7
    L10:
        return false;
    L18:
        return true;
    L13:
        return isMessageFieldValueInitialized(r13);
    L14:
        return true;
    }

    private static boolean isMessageFieldValueInitialized(Object r10) {
        if ((r10 instanceof MessageLiteOrBuilder) == false) goto L7;
        return ((MessageLiteOrBuilder) r10).isInitialized();
    L7:
        if ((r10 instanceof LazyField) == false) goto L11;
        return true;
    L11:
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static boolean isValidType(WireFormat.FieldType r10, Object r11) {
        Internal.checkNotNull(r11);
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$JavaType[r10.getJavaType().ordinal()]) {
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
        if ((r11 instanceof MessageLite) == false) goto L8;
        return true;
    L8:
        if ((r11 instanceof LazyField) == false) goto L11;
        return true;
    L11:
        return false;
    L13:
        if ((r11 instanceof Integer) == false) goto L15;
        return true;
    L15:
        if ((r11 instanceof Internal.EnumLite) == false) goto L18;
        return true;
    L18:
        return false;
    L20:
        if ((r11 instanceof ByteString) == false) goto L22;
        return true;
    L22:
        if ((r11 instanceof byte[]) == false) goto L25;
        return true;
    L25:
        return false;
    L27:
        return r11 instanceof String;
    L29:
        return r11 instanceof Boolean;
    L31:
        return r11 instanceof Double;
    L33:
        return r11 instanceof Float;
    L35:
        return r11 instanceof Long;
    L37:
        return r11 instanceof Integer;
    }

    private void mergeFromField(Map.Entry<T, Object> r10) {
        T r11 = r10.getKey();
        Object r12 = r10.getValue();
        boolean r13 = r12 instanceof LazyField;
        if (r11.isRepeated() == false) goto L15;
        if (r13 == true) goto L13;
        Object r14 = getField(r11);
        List r15 = (List) r12;
        int r16 = r15.size();
        if (r14 != null) goto L8;
        r14 = new ArrayList(r16);
    L8:
        List r17 = (List) r14;
        int r18 = 0;
    L9:
        if (r18 >= r16) goto L11;
        r17.add(cloneIfMutable(r15.get(r18)));
        r18 = r18 + 1;
        goto L9
    L11:
        this.fields.put(r11, r14);
        return;
    L13:
        throw new IllegalStateException("Lazy fields can not be repeated");
    L15:
        if (r11.getLiteJavaType() != WireFormat.JavaType.MESSAGE) goto L24;
        Object r19 = getField(r11);
        if (r19 != null) goto L21;
        this.fields.put(r11, cloneIfMutable(r12));
        if (r13 == false) goto L32;
        this.hasLazyField = true;
        return;
    L32:
        return;
    L21:
        if (r13 == false) goto L23;
        r12 = ((LazyField) r12).getValue();
    L23:
        Object r20 = r11.internalMergeFrom(((MessageLite) r19).toBuilder(), (MessageLite) r12).build();
        SmallSortedMap<T, Object> r21 = this.fields;
    L26:
        r21.put(r11, r20);
        return;
    L24:
        if (r13 == true) goto L29;
        r21 = this.fields;
        r20 = cloneIfMutable(r12);
        goto L26
    L29:
        throw new IllegalStateException("Lazy fields must be message-valued");
    }

    public static <T extends FieldDescriptorLite<T>> Builder<T> newBuilder() {
        return new Builder(null);
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet<T> newFieldSet() {
        return new FieldSet();
    }

    public static Object readPrimitiveField(CodedInputStream r10, WireFormat.FieldType r11, boolean r12) {
        if (r12 == false) goto L6;
        WireFormat.Utf8Validation r13 = WireFormat.Utf8Validation.STRICT;
    L5:
        return WireFormat.readPrimitiveField(r10, r11, r13);
    L6:
        r13 = WireFormat.Utf8Validation.LOOSE;
        goto L5
    }

    private void verifyType(T r10, Object r11) {
        if (isValidType(r10.getLiteType(), r11) == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(r10.getNumber()), r10.getLiteType().getJavaType(), r11.getClass().getName()}));
    }

    static void writeElement(CodedOutputStream r10, WireFormat.FieldType r11, int r12, Object r13) {
        if (r11 != WireFormat.FieldType.GROUP) goto L5;
        r10.writeGroup(r12, (MessageLite) r13);
        return;
    L5:
        r10.writeTag(r12, getWireFormatForFieldType(r11, false));
        writeElementNoTag(r10, r11, r13);
    }

    static void writeElementNoTag(CodedOutputStream r10, WireFormat.FieldType r11, Object r12) {
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r11.ordinal()]) {
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
        r10.writeSInt64NoTag(((Long) r12).longValue());
        return;
    L11:
        r10.writeSInt32NoTag(((Integer) r12).intValue());
        return;
    L12:
        r10.writeSFixed64NoTag(((Long) r12).longValue());
        return;
    L13:
        r10.writeSFixed32NoTag(((Integer) r12).intValue());
        return;
    L14:
        r10.writeUInt32NoTag(((Integer) r12).intValue());
        return;
    L23:
        r10.writeMessageNoTag((MessageLite) r12);
        return;
    L24:
        r10.writeGroupNoTag((MessageLite) r12);
        return;
    L25:
        r10.writeBoolNoTag(((Boolean) r12).booleanValue());
        return;
    L26:
        r10.writeFixed32NoTag(((Integer) r12).intValue());
        return;
    L27:
        r10.writeFixed64NoTag(((Long) r12).longValue());
        return;
    L28:
        r10.writeInt32NoTag(((Integer) r12).intValue());
        return;
    L29:
        r10.writeUInt64NoTag(((Long) r12).longValue());
        return;
    L30:
        r10.writeInt64NoTag(((Long) r12).longValue());
        return;
    L31:
        r10.writeFloatNoTag(((Float) r12).floatValue());
        return;
    L32:
        r10.writeDoubleNoTag(((Double) r12).doubleValue());
        return;
    L52:
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
    L16:
        if ((r12 instanceof ByteString) == true) goto L21;
        r10.writeByteArrayNoTag((byte[]) r12);
        return;
    L21:
        r10.writeBytesNoTag((ByteString) r12);
        return;
    L20:
        if ((r12 instanceof ByteString) == true) goto L21;
        r10.writeStringNoTag((String) r12);
    }

    public static void writeField(FieldDescriptorLite<?> r10, Object r11, CodedOutputStream r12) {
        WireFormat.FieldType r13 = r10.getLiteType();
        int r14 = r10.getNumber();
        if (r10.isRepeated() == false) goto L18;
        List r15 = (List) r11;
        int r16 = r15.size();
        int r17 = 0;
        if (r10.isPacked() == true) goto L7;
    L15:
        if (r17 >= r16) goto L27;
        writeElement(r12, r13, r14, r15.get(r17));
        r17 = r17 + 1;
        goto L15
    L27:
        return;
    L7:
        if (r15.isEmpty() == false) goto L9;
        return;
    L9:
        r12.writeTag(r14, 2);
        int r18 = 0;
        int r19 = 0;
    L10:
        if (r18 >= r16) goto L12;
        r19 = r19 + computeElementSizeNoTag(r13, r15.get(r18));
        r18 = r18 + 1;
        goto L10
    L12:
        r12.writeUInt32NoTag(r19);
    L13:
        if (r17 >= r16) goto L26;
        writeElementNoTag(r12, r13, r15.get(r17));
        r17 = r17 + 1;
        goto L13
    L26:
        return;
    L18:
        if ((r11 instanceof LazyField) == false) goto L20;
        writeElement(r12, r13, r14, ((LazyField) r11).getValue());
        return;
    L20:
        writeElement(r12, r13, r14, r11);
    }

    private void writeMessageSetTo(Map.Entry<T, Object> r10, CodedOutputStream r11) {
        T r12 = r10.getKey();
        if (r12.getLiteJavaType() == WireFormat.JavaType.MESSAGE) goto L5;
    L12:
        writeField(r12, r10.getValue(), r11);
        return;
    L5:
        if (r12.isRepeated() == true) goto L12;
        if (r12.isPacked() == true) goto L12;
        Object r13 = r10.getValue();
        if ((r13 instanceof LazyField) == false) goto L11;
        ByteString r14 = ((LazyField) r13).toByteString();
        r11.writeRawMessageSetExtension(r10.getKey().getNumber(), r14);
        return;
    L11:
        r11.writeMessageSetExtension(r10.getKey().getNumber(), (MessageLite) r13);
    }

    public void addRepeatedField(T r10, Object r11) {
        if (r10.isRepeated() == false) goto L11;
        verifyType(r10, r11);
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

    public void clear() {
        this.fields.clear();
        this.hasLazyField = false;
    }

    public void clearField(T r10) {
        this.fields.remove(r10);
        if (this.fields.isEmpty() == false) goto L6;
        this.hasLazyField = false;
        return;
    }

    public FieldSet<T> clone() {
        FieldSet<T> r10 = newFieldSet();
        int r11 = this.fields.getNumArrayEntries();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        Map.Entry<K, Object> r13 = this.fields.getArrayEntryAt(r12);
        r10.setField((FieldDescriptorLite) r13.getKey(), r13.getValue());
        r12 = r12 + 1;
        goto L3
    L5:
        Iterator r14 = this.fields.getOverflowEntries().iterator();
    L7:
        if (r14.hasNext() == false) goto L9;
        Map.Entry r15 = (Map.Entry) r14.next();
        r10.setField((FieldDescriptorLite) r15.getKey(), r15.getValue());
        goto L7
    L9:
        r10.hasLazyField = this.hasLazyField;
        return r10;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m14clone() {
        return clone();
    }

    Iterator<Map.Entry<T, Object>> descendingIterator() {
        if (isEmpty() == false) goto L7;
        return Collections.emptyIterator();
    L7:
        if (this.hasLazyField == false) goto L11;
        return new LazyField.LazyIterator(this.fields.descendingEntrySet().iterator());
    L11:
        return this.fields.descendingEntrySet().iterator();
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof FieldSet) == true) goto L10;
        return false;
    L10:
        return this.fields.equals(((FieldSet) r10).fields);
    }

    public Map<T, Object> getAllFields() {
        if (this.hasLazyField == false) goto L8;
        SmallSortedMap r10 = cloneAllFieldsMap(this.fields, false, true);
        if (this.fields.isImmutable() == false) goto L7;
        r10.makeImmutable();
    L7:
        return r10;
    L8:
        boolean r11 = this.fields.isImmutable();
        SmallSortedMap<T, Object> r12 = this.fields;
        if (r11 == false) goto L12;
        return r12;
    L12:
        return Collections.unmodifiableMap(r12);
    }

    public Object getField(T r10) {
        Object r11 = this.fields.get(r10);
        if ((r11 instanceof LazyField) == true) goto L5;
        return r11;
    L5:
        return ((LazyField) r11).getValue();
    }

    public int getMessageSetSerializedSize() {
        int r10 = this.fields.getNumArrayEntries();
        int r11 = 0;
        int r12 = 0;
    L3:
        if (r11 >= r10) goto L5;
        r12 = r12 + getMessageSetSerializedSize(this.fields.getArrayEntryAt(r11));
        r11 = r11 + 1;
        goto L3
    L5:
        Iterator r13 = this.fields.getOverflowEntries().iterator();
    L7:
        if (r13.hasNext() == false) goto L9;
        r12 = r12 + getMessageSetSerializedSize((Map.Entry) r13.next());
        goto L7
    L9:
        return r12;
    }

    public Object getRepeatedField(T r10, int r11) {
        if (r10.isRepeated() == false) goto L11;
        Object r12 = getField(r10);
        if (r12 == null) goto L9;
        return ((List) r12).get(r11);
    L9:
        throw new IndexOutOfBoundsException();
    L11:
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public int getRepeatedFieldCount(T r10) {
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
        int r10 = this.fields.getNumArrayEntries();
        int r11 = 0;
        int r12 = 0;
    L3:
        if (r11 >= r10) goto L5;
        Map.Entry<K, Object> r13 = this.fields.getArrayEntryAt(r11);
        r12 = r12 + computeFieldSize((FieldDescriptorLite) r13.getKey(), r13.getValue());
        r11 = r11 + 1;
        goto L3
    L5:
        Iterator r14 = this.fields.getOverflowEntries().iterator();
    L7:
        if (r14.hasNext() == false) goto L9;
        Map.Entry r15 = (Map.Entry) r14.next();
        r12 = r12 + computeFieldSize((FieldDescriptorLite) r15.getKey(), r15.getValue());
        goto L7
    L9:
        return r12;
    }

    public boolean hasField(T r10) {
        if (r10.isRepeated() == true) goto L10;
        if (this.fields.get(r10) == null) goto L7;
        return true;
    L7:
        return false;
    L10:
        throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
    }

    public int hashCode() {
        return this.fields.hashCode();
    }

    boolean isEmpty() {
        return this.fields.isEmpty();
    }

    public boolean isImmutable() {
        return this.isImmutable;
    }

    public boolean isInitialized() {
        int r10 = this.fields.getNumArrayEntries();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L8;
        if (isInitialized(this.fields.getArrayEntryAt(r11)) == false) goto L6;
        r11 = r11 + 1;
        goto L3
    L6:
        return false;
    L8:
        Iterator r12 = this.fields.getOverflowEntries().iterator();
    L10:
        if (r12.hasNext() == false) goto L14;
        if (isInitialized((Map.Entry) r12.next()) == true) goto L10;
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

    boolean lazyFieldCorrupted(T r10) {
        Object r11 = this.fields.get(r10);
        if ((r11 instanceof LazyField) == true) goto L5;
    L7:
        return false;
    L5:
        if (((LazyField) r11).isCorrupted() == false) goto L7;
        return true;
    }

    public void makeImmutable() {
        if (this.isImmutable == false) goto L5;
        return;
    L5:
        int r10 = this.fields.getNumArrayEntries();
        int r11 = 0;
    L6:
        if (r11 >= r10) goto L11;
        Object r12 = this.fields.getArrayEntryAt(r11).getValue();
        if ((r12 instanceof GeneratedMessageLite) == false) goto L10;
        ((GeneratedMessageLite) r12).makeImmutable();
    L10:
        r11 = r11 + 1;
        goto L6
    L11:
        Iterator r13 = this.fields.getOverflowEntries().iterator();
    L13:
        if (r13.hasNext() == false) goto L17;
        Object r14 = ((Map.Entry) r13.next()).getValue();
        if ((r14 instanceof GeneratedMessageLite) == false) goto L13;
        ((GeneratedMessageLite) r14).makeImmutable();
        goto L13
    L17:
        this.fields.makeImmutable();
        this.isImmutable = true;
    }

    public void mergeFrom(FieldSet<T> r10) {
        int r11 = r10.fields.getNumArrayEntries();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        mergeFromField(r10.fields.getArrayEntryAt(r12));
        r12 = r12 + 1;
        goto L3
    L5:
        Iterator r13 = r10.fields.getOverflowEntries().iterator();
    L7:
        if (r13.hasNext() == false) goto L9;
        mergeFromField((Map.Entry) r13.next());
        goto L7
    }

    public void setField(T r10, Object r11) {
        if (r10.isRepeated() == true) goto L5;
        verifyType(r10, r11);
    L14:
        if ((r11 instanceof LazyField) == false) goto L16;
        this.hasLazyField = true;
    L16:
        this.fields.put(r10, r11);
        return;
    L5:
        if ((r11 instanceof List) == false) goto L11;
        List r12 = (List) r11;
        int r13 = r12.size();
        ArrayList r14 = new ArrayList(r13);
        int r15 = 0;
    L7:
        if (r15 >= r13) goto L9;
        Object r16 = r12.get(r15);
        verifyType(r10, r16);
        r14.add(r16);
        r15 = r15 + 1;
        goto L7
    L9:
        r11 = r14;
        goto L14
    L11:
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    public void setRepeatedField(T r10, int r11, Object r12) {
        if (r10.isRepeated() == false) goto L11;
        Object r13 = getField(r10);
        if (r13 == null) goto L9;
        verifyType(r10, r12);
        ((List) r13).set(r11, r12);
        return;
    L9:
        throw new IndexOutOfBoundsException();
    L11:
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public void writeMessageSetTo(CodedOutputStream r10) {
        int r11 = this.fields.getNumArrayEntries();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        writeMessageSetTo(this.fields.getArrayEntryAt(r12), r10);
        r12 = r12 + 1;
        goto L3
    L5:
        Iterator r13 = this.fields.getOverflowEntries().iterator();
    L7:
        if (r13.hasNext() == false) goto L9;
        writeMessageSetTo((Map.Entry) r13.next(), r10);
        goto L7
    }

    public void writeTo(CodedOutputStream r10) {
        int r11 = this.fields.getNumArrayEntries();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        Map.Entry<K, Object> r13 = this.fields.getArrayEntryAt(r12);
        writeField((FieldDescriptorLite) r13.getKey(), r13.getValue(), r10);
        r12 = r12 + 1;
        goto L3
    L5:
        Iterator r14 = this.fields.getOverflowEntries().iterator();
    L7:
        if (r14.hasNext() == false) goto L9;
        Map.Entry r15 = (Map.Entry) r14.next();
        writeField((FieldDescriptorLite) r15.getKey(), r15.getValue(), r10);
        goto L7
    }
}
