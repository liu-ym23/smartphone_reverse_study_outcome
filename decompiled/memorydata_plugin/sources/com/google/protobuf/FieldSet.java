package com.google.protobuf;

import com.google.protobuf.FieldSet.FieldDescriptorLite;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
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

    static final class Builder<T extends FieldDescriptorLite<T>> {
        private SmallSortedMap<T, Object> fields;
        private boolean hasLazyField;
        private boolean hasNestedBuilders;
        private boolean isMutable;

        private Builder() {
            this(SmallSortedMap.newFieldMap());
        }

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder(SmallSortedMap<T, Object> r1) {
            this.fields = r1;
            this.isMutable = true;
        }

        private FieldSet<T> buildImpl(boolean r4) {
            if (this.fields.isEmpty() == true) goto L5;
            this.isMutable = false;
            SmallSortedMap<T, Object> r1 = this.fields;
            if (this.hasNestedBuilders == false) goto L9;
            r1 = FieldSet.access$100(r1, false, false);
            replaceBuilders(r1, r4);
        L9:
            FieldSet<T> r5 = new FieldSet(r1, null);
            FieldSet.access$302(r5, this.hasLazyField);
            return r5;
        L5:
            return FieldSet.emptySet();
        }

        private void ensureIsMutable() {
            if (this.isMutable == true) goto L6;
            this.fields = FieldSet.access$100(this.fields, true, false);
            this.isMutable = true;
            return;
        }

        public static <T extends FieldDescriptorLite<T>> Builder<T> fromFieldSet(FieldSet<T> r4) {
            Builder<T> r0 = new Builder(FieldSet.access$100(FieldSet.access$400(r4), true, false));
            ((Builder) r0).hasLazyField = FieldSet.access$300(r4);
            return r0;
        }

        private void mergeFromField(Map.Entry<T, Object> r6) {
            Map.Entry r7 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r6, Map.Entry.class, "com.obric.memorydata.plugin");
            FieldDescriptorLite r0 = (FieldDescriptorLite) ZeusTransformUtils.preCheckCast(r7.getKey(), FieldDescriptorLite.class, "com.obric.memorydata.plugin");
            Object r8 = r7.getValue();
            boolean r2 = ZeusTransformUtils.instanceOf(r8, LazyField.class);
            if (r0.isRepeated() == false) goto L14;
            if (r2 == true) goto L12;
            List r3 = (List) ZeusTransformUtils.preCheckCast(getFieldAllowBuilders(r0), List.class, "com.obric.memorydata.plugin");
            List r9 = (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin");
            int r1 = r9.size();
            if (r3 != null) goto L8;
            r3 = new ArrayList(r1);
            this.fields.put(r0, r3);
        L8:
            int r5 = 0;
        L9:
            if (r5 >= r1) goto L37;
            r3.add(FieldSet.access$700(r9.get(r5)));
            r5 = r5 + 1;
            goto L9
        L37:
            return;
        L12:
            throw new IllegalStateException("Lazy fields can not be repeated");
        L14:
            if (r0.getLiteJavaType() != WireFormat.JavaType.MESSAGE) goto L27;
            Object r4 = getFieldAllowBuilders(r0);
            if (r4 != null) goto L21;
            this.fields.put(r0, FieldSet.access$700(r8));
            if (r2 == false) goto L34;
            this.hasLazyField = true;
            return;
        L34:
            return;
        L21:
            if (ZeusTransformUtils.instanceOf(r8, LazyField.class) == false) goto L24;
            r8 = ((LazyField) ZeusTransformUtils.preCheckCast(r8, LazyField.class, "com.obric.memorydata.plugin")).getValue();
        L24:
            if (ZeusTransformUtils.instanceOf(r4, MessageLite.Builder.class) == false) goto L26;
            r0.internalMergeFrom((MessageLite.Builder) ZeusTransformUtils.preCheckCast(r4, MessageLite.Builder.class, "com.obric.memorydata.plugin"), (MessageLite) ZeusTransformUtils.preCheckCast(r8, MessageLite.class, "com.obric.memorydata.plugin"));
            return;
        L26:
            Object r10 = r0.internalMergeFrom(((MessageLite) ZeusTransformUtils.preCheckCast(r4, MessageLite.class, "com.obric.memorydata.plugin")).toBuilder(), (MessageLite) ZeusTransformUtils.preCheckCast(r8, MessageLite.class, "com.obric.memorydata.plugin")).build();
            SmallSortedMap<T, Object> r11 = this.fields;
        L29:
            r11.put(r0, r10);
            return;
        L27:
            if (r2 == true) goto L32;
            r11 = this.fields;
            r10 = FieldSet.access$700(r8);
            goto L29
        L32:
            throw new IllegalStateException("Lazy fields must be message-valued");
        }

        private static Object replaceBuilder(Object r2, boolean r3) {
            if (ZeusTransformUtils.instanceOf(r2, MessageLite.Builder.class) == true) goto L5;
            return r2;
        L5:
            MessageLite.Builder r4 = (MessageLite.Builder) ZeusTransformUtils.preCheckCast(r2, MessageLite.Builder.class, "com.obric.memorydata.plugin");
            if (r3 == false) goto L10;
            return r4.buildPartial();
        L10:
            return r4.build();
        }

        private static <T extends FieldDescriptorLite<T>> Object replaceBuilders(T r3, Object r4, boolean r5) {
            FieldDescriptorLite r6 = (FieldDescriptorLite) ZeusTransformUtils.wrapperContextForParams(r3, FieldDescriptorLite.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return r4;
        L6:
            if (r6.getLiteJavaType() == WireFormat.JavaType.MESSAGE) goto L8;
            return r4;
        L8:
            if (r6.isRepeated() == false) goto L24;
            if (ZeusTransformUtils.instanceOf(r4, List.class) == false) goto L22;
            List r7 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin");
            int r0 = 0;
        L13:
            if (r0 >= r7.size()) goto L20;
            Object r1 = r7.get(r0);
            Object r2 = replaceBuilder(r1, r5);
            if (r2 == r1) goto L19;
            if (r7 != r4) goto L18;
            r7 = new ArrayList(r7);
        L18:
            r7.set(r0, r2);
        L19:
            r0 = r0 + 1;
            goto L13
        L20:
            return r7;
        L22:
            throw new IllegalStateException("Repeated field should contains a List but actually contains type: " + r4.getClass());
        L24:
            return replaceBuilder(r4, r5);
        }

        private static <T extends FieldDescriptorLite<T>> void replaceBuilders(SmallSortedMap<T, Object> r3, boolean r4) {
            int r0 = r3.getNumArrayEntries();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            replaceBuilders(r3.getArrayEntryAt(r1), r4);
            r1 = r1 + 1;
            goto L3
        L5:
            Iterator r5 = r3.getOverflowEntries().iterator();
        L7:
            if (r5.hasNext() == false) goto L9;
            replaceBuilders((Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.memorydata.plugin"), r4);
            goto L7
        }

        private static <T extends FieldDescriptorLite<T>> void replaceBuilders(Map.Entry<T, Object> r3, boolean r4) {
            Map.Entry r5 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.memorydata.plugin");
            r5.setValue(replaceBuilders((FieldDescriptorLite) ZeusTransformUtils.preCheckCast(r5.getKey(), FieldDescriptorLite.class, "com.obric.memorydata.plugin"), r5.getValue(), r4));
        }

        private void verifyType(T r4, Object r5) {
            FieldDescriptorLite r3 = (FieldDescriptorLite) ZeusTransformUtils.wrapperContextForParams(r4, FieldDescriptorLite.class, "com.obric.memorydata.plugin");
            if (FieldSet.access$500(r3.getLiteType(), r5) == false) goto L5;
            return;
        L5:
            if (r3.getLiteType().getJavaType() != WireFormat.JavaType.MESSAGE) goto L10;
            if (ZeusTransformUtils.instanceOf(r5, MessageLite.Builder.class) == false) goto L10;
            return;
        L10:
            throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(r3.getNumber()), r3.getLiteType().getJavaType(), r5.getClass().getName()}));
        }

        public void addRepeatedField(T r3, Object r4) {
            FieldDescriptorLite r5 = (FieldDescriptorLite) ZeusTransformUtils.wrapperContextForParams(r3, FieldDescriptorLite.class, "com.obric.memorydata.plugin");
            ensureIsMutable();
            if (r5.isRepeated() == false) goto L18;
            if (this.hasNestedBuilders == false) goto L7;
        L10:
            boolean r0 = true;
        L11:
            this.hasNestedBuilders = r0;
            verifyType(r5, r4);
            Object r1 = getFieldAllowBuilders(r5);
            if (r1 != null) goto L14;
            List r2 = new ArrayList();
            this.fields.put(r5, r2);
        L15:
            r2.add(r4);
            return;
        L14:
            r2 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
            goto L15
        L7:
            if (ZeusTransformUtils.instanceOf(r4, MessageLite.Builder.class) == true) goto L10;
            r0 = false;
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

        public void clearField(T r3) {
            FieldDescriptorLite r4 = (FieldDescriptorLite) ZeusTransformUtils.wrapperContextForParams(r3, FieldDescriptorLite.class, "com.obric.memorydata.plugin");
            ensureIsMutable();
            this.fields.remove(r4);
            if (this.fields.isEmpty() == false) goto L6;
            this.hasLazyField = false;
            return;
        }

        public Map<T, Object> getAllFields() {
            if (this.hasLazyField == false) goto L9;
            SmallSortedMap r0 = FieldSet.access$100(this.fields, false, true);
            if (this.fields.isImmutable() == false) goto L7;
            r0.makeImmutable();
        L8:
            return r0;
        L7:
            replaceBuilders(r0, true);
            goto L8
        L9:
            boolean r1 = this.fields.isImmutable();
            SmallSortedMap<T, Object> r3 = this.fields;
            if (r1 == false) goto L13;
            return r3;
        L13:
            return Collections.unmodifiableMap(r3);
        }

        public Object getField(T r3) {
            FieldDescriptorLite r4 = (FieldDescriptorLite) ZeusTransformUtils.wrapperContextForParams(r3, FieldDescriptorLite.class, "com.obric.memorydata.plugin");
            return replaceBuilders(r4, getFieldAllowBuilders(r4), true);
        }

        Object getFieldAllowBuilders(T r3) {
            FieldDescriptorLite r4 = (FieldDescriptorLite) ZeusTransformUtils.wrapperContextForParams(r3, FieldDescriptorLite.class, "com.obric.memorydata.plugin");
            Object r2 = this.fields.get(r4);
            if (ZeusTransformUtils.instanceOf(r2, LazyField.class) == true) goto L5;
            return r2;
        L5:
            return ((LazyField) ZeusTransformUtils.preCheckCast(r2, LazyField.class, "com.obric.memorydata.plugin")).getValue();
        }

        public Object getRepeatedField(T r3, int r4) {
            FieldDescriptorLite r5 = (FieldDescriptorLite) ZeusTransformUtils.wrapperContextForParams(r3, FieldDescriptorLite.class, "com.obric.memorydata.plugin");
            if (this.hasNestedBuilders == false) goto L6;
            ensureIsMutable();
        L6:
            return replaceBuilder(getRepeatedFieldAllowBuilders(r5, r4), true);
        }

        Object getRepeatedFieldAllowBuilders(T r3, int r4) {
            FieldDescriptorLite r5 = (FieldDescriptorLite) ZeusTransformUtils.wrapperContextForParams(r3, FieldDescriptorLite.class, "com.obric.memorydata.plugin");
            if (r5.isRepeated() == false) goto L11;
            Object r2 = getFieldAllowBuilders(r5);
            if (r2 == null) goto L9;
            return ((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin")).get(r4);
        L9:
            throw new IndexOutOfBoundsException();
        L11:
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }

        public int getRepeatedFieldCount(T r3) {
            FieldDescriptorLite r4 = (FieldDescriptorLite) ZeusTransformUtils.wrapperContextForParams(r3, FieldDescriptorLite.class, "com.obric.memorydata.plugin");
            if (r4.isRepeated() == false) goto L11;
            Object r2 = getFieldAllowBuilders(r4);
            if (r2 != null) goto L9;
            return 0;
        L9:
            return ((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin")).size();
        L11:
            throw new IllegalArgumentException("getRepeatedFieldCount() can only be called on repeated fields.");
        }

        public boolean hasField(T r3) {
            FieldDescriptorLite r4 = (FieldDescriptorLite) ZeusTransformUtils.wrapperContextForParams(r3, FieldDescriptorLite.class, "com.obric.memorydata.plugin");
            if (r4.isRepeated() == true) goto L10;
            if (this.fields.get(r4) == null) goto L7;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
        }

        public boolean isInitialized() {
            int r0 = this.fields.getNumArrayEntries();
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L8;
            if (FieldSet.access$600(this.fields.getArrayEntryAt(r2)) == false) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return false;
        L8:
            Iterator r4 = this.fields.getOverflowEntries().iterator();
        L10:
            if (r4.hasNext() == false) goto L14;
            if (FieldSet.access$600((Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.memorydata.plugin")) == true) goto L10;
            return false;
        L14:
            return true;
        }

        public void mergeFrom(FieldSet<T> r4) {
            ensureIsMutable();
            int r0 = FieldSet.access$400(r4).getNumArrayEntries();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            mergeFromField(FieldSet.access$400(r4).getArrayEntryAt(r1));
            r1 = r1 + 1;
            goto L3
        L5:
            Iterator r5 = FieldSet.access$400(r4).getOverflowEntries().iterator();
        L7:
            if (r5.hasNext() == false) goto L9;
            mergeFromField((Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.memorydata.plugin"));
            goto L7
        }

        public void setField(T r7, Object r8) {
            FieldDescriptorLite r9 = (FieldDescriptorLite) ZeusTransformUtils.wrapperContextForParams(r7, FieldDescriptorLite.class, "com.obric.memorydata.plugin");
            ensureIsMutable();
            boolean r2 = false;
            if (r9.isRepeated() == true) goto L5;
            verifyType(r9, r8);
        L21:
            if (ZeusTransformUtils.instanceOf(r8, LazyField.class) == false) goto L24;
            this.hasLazyField = true;
        L24:
            if (this.hasNestedBuilders == false) goto L26;
        L27:
            r2 = true;
        L28:
            this.hasNestedBuilders = r2;
            this.fields.put(r9, r8);
            return;
        L26:
            if (ZeusTransformUtils.instanceOf(r8, MessageLite.Builder.class) == false) goto L28;
        L5:
            if (ZeusTransformUtils.instanceOf(r8, List.class) == false) goto L18;
            ArrayList r0 = new ArrayList((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin"));
            int r10 = r0.size();
            int r1 = 0;
        L7:
            if (r1 >= r10) goto L16;
            Object r4 = r0.get(r1);
            verifyType(r9, r4);
            if (this.hasNestedBuilders == false) goto L11;
        L14:
            boolean r5 = true;
        L15:
            this.hasNestedBuilders = r5;
            r1 = r1 + 1;
            goto L7
        L11:
            if (ZeusTransformUtils.instanceOf(r4, MessageLite.Builder.class) == true) goto L14;
            r5 = false;
            goto L15
        L16:
            r8 = r0;
            goto L21
        L18:
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }

        public void setRepeatedField(T r3, int r4, Object r5) {
            FieldDescriptorLite r6 = (FieldDescriptorLite) ZeusTransformUtils.wrapperContextForParams(r3, FieldDescriptorLite.class, "com.obric.memorydata.plugin");
            ensureIsMutable();
            if (r6.isRepeated() == false) goto L18;
            if (this.hasNestedBuilders == false) goto L7;
        L10:
            boolean r0 = true;
        L11:
            this.hasNestedBuilders = r0;
            Object r1 = getFieldAllowBuilders(r6);
            if (r1 == null) goto L16;
            verifyType(r6, r5);
            ((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin")).set(r4, r5);
            return;
        L16:
            throw new IndexOutOfBoundsException();
        L7:
            if (ZeusTransformUtils.instanceOf(r5, MessageLite.Builder.class) == true) goto L10;
            r0 = false;
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

        MessageLite.Builder internalMergeFrom(MessageLite.Builder r1, MessageLite r2);

        boolean isPacked();

        boolean isRepeated();
    }

    static {
        DEFAULT_INSTANCE = new FieldSet(true);
    }

    private FieldSet() {
        this.fields = SmallSortedMap.newFieldMap();
    }

    private FieldSet(SmallSortedMap<T, Object> r1) {
        this.fields = r1;
        makeImmutable();
    }

    /* synthetic */ FieldSet(SmallSortedMap r1, AnonymousClass1 r2) {
        this(r1);
    }

    private FieldSet(boolean r1) {
        this(SmallSortedMap.newFieldMap());
        makeImmutable();
    }

    static /* synthetic */ SmallSortedMap access$100(SmallSortedMap r0, boolean r1, boolean r2) {
        return cloneAllFieldsMap(r0, r1, r2);
    }

    static /* synthetic */ boolean access$300(FieldSet r0) {
        return r0.hasLazyField;
    }

    static /* synthetic */ boolean access$302(FieldSet r0, boolean r1) {
        r0.hasLazyField = r1;
        return r1;
    }

    static /* synthetic */ SmallSortedMap access$400(FieldSet r0) {
        return r0.fields;
    }

    static /* synthetic */ boolean access$500(WireFormat.FieldType r0, Object r1) {
        return isValidType(r0, r1);
    }

    static /* synthetic */ boolean access$600(Map.Entry r2) {
        return isInitialized((Map.Entry) ZeusTransformUtils.wrapperContextForParams(r2, Map.Entry.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ Object access$700(Object r0) {
        return cloneIfMutable(r0);
    }

    private static <T extends FieldDescriptorLite<T>> SmallSortedMap<T, Object> cloneAllFieldsMap(SmallSortedMap<T, Object> r4, boolean r5, boolean r6) {
        SmallSortedMap<T, Object> r0 = SmallSortedMap.newFieldMap();
        int r1 = r4.getNumArrayEntries();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        cloneFieldEntry(r0, r4.getArrayEntryAt(r2), r5, r6);
        r2 = r2 + 1;
        goto L3
    L5:
        Iterator r7 = r4.getOverflowEntries().iterator();
    L7:
        if (r7.hasNext() == false) goto L9;
        cloneFieldEntry(r0, (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin"), r5, r6);
        goto L7
    L9:
        return r0;
    }

    private static <T extends FieldDescriptorLite<T>> void cloneFieldEntry(Map<T, Object> r3, Map.Entry<T, Object> r4, boolean r5, boolean r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Map.Entry r8 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r4, Map.Entry.class, "com.obric.memorydata.plugin");
        FieldDescriptorLite r0 = (FieldDescriptorLite) ZeusTransformUtils.preCheckCast(r8.getKey(), FieldDescriptorLite.class, "com.obric.memorydata.plugin");
        Object r9 = r8.getValue();
        if (r6 == true) goto L5;
    L7:
        if (r5 == true) goto L9;
    L11:
        r7.put(r0, r9);
        return;
    L9:
        if (ZeusTransformUtils.instanceOf(r9, List.class) == false) goto L11;
        r7.put(r0, new ArrayList((List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin")));
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r9, LazyField.class) == false) goto L7;
        r9 = ((LazyField) ZeusTransformUtils.preCheckCast(r9, LazyField.class, "com.obric.memorydata.plugin")).getValue();
        goto L11
    }

    private static Object cloneIfMutable(Object r3) {
        if ((r3 instanceof byte[]) == false) goto L6;
        byte[] r4 = (byte[]) ZeusTransformUtils.preCheckCast(r3, byte[].class, "com.obric.memorydata.plugin");
        byte[] r0 = new byte[r4.length];
        System.arraycopy(r4, 0, r0, 0, r4.length);
        return r0;
    L6:
        return r3;
    }

    static int computeElementSize(WireFormat.FieldType r1, int r2, Object r3) {
        int r4 = CodedOutputStream.computeTagSize(r2);
        if (r1 != WireFormat.FieldType.GROUP) goto L6;
        r4 = r4 * 2;
    L6:
        return r4 + computeElementSizeNoTag(r1, r3);
    }

    static int computeElementSizeNoTag(WireFormat.FieldType r1, Object r2) {
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r1.ordinal()]) {
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
        if (ZeusTransformUtils.instanceOf(r2, Internal.EnumLite.class) == false) goto L11;
        return CodedOutputStream.computeEnumSizeNoTag(((Internal.EnumLite) ZeusTransformUtils.preCheckCast(r2, Internal.EnumLite.class, "com.obric.memorydata.plugin")).getNumber());
    L11:
        return CodedOutputStream.computeEnumSizeNoTag(((Integer) ZeusTransformUtils.preCheckCast(r2, Integer.class, "com.obric.memorydata.plugin")).intValue());
    L13:
        return CodedOutputStream.computeSInt64SizeNoTag(((Long) ZeusTransformUtils.preCheckCast(r2, Long.class, "com.obric.memorydata.plugin")).longValue());
    L15:
        return CodedOutputStream.computeSInt32SizeNoTag(((Integer) ZeusTransformUtils.preCheckCast(r2, Integer.class, "com.obric.memorydata.plugin")).intValue());
    L17:
        return CodedOutputStream.computeSFixed64SizeNoTag(((Long) ZeusTransformUtils.preCheckCast(r2, Long.class, "com.obric.memorydata.plugin")).longValue());
    L19:
        return CodedOutputStream.computeSFixed32SizeNoTag(((Integer) ZeusTransformUtils.preCheckCast(r2, Integer.class, "com.obric.memorydata.plugin")).intValue());
    L21:
        return CodedOutputStream.computeUInt32SizeNoTag(((Integer) ZeusTransformUtils.preCheckCast(r2, Integer.class, "com.obric.memorydata.plugin")).intValue());
    L23:
        if (ZeusTransformUtils.instanceOf(r2, ByteString.class) == false) goto L27;
        return CodedOutputStream.computeBytesSizeNoTag((ByteString) ZeusTransformUtils.preCheckCast(r2, ByteString.class, "com.obric.memorydata.plugin"));
    L27:
        return CodedOutputStream.computeByteArraySizeNoTag((byte[]) ZeusTransformUtils.preCheckCast(r2, byte[].class, "com.obric.memorydata.plugin"));
    L29:
        if (ZeusTransformUtils.instanceOf(r2, ByteString.class) == false) goto L33;
        return CodedOutputStream.computeBytesSizeNoTag((ByteString) ZeusTransformUtils.preCheckCast(r2, ByteString.class, "com.obric.memorydata.plugin"));
    L33:
        return CodedOutputStream.computeStringSizeNoTag((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin"));
    L35:
        if (ZeusTransformUtils.instanceOf(r2, LazyField.class) == false) goto L39;
        return CodedOutputStream.computeLazyFieldSizeNoTag((LazyField) ZeusTransformUtils.preCheckCast(r2, LazyField.class, "com.obric.memorydata.plugin"));
    L39:
        return CodedOutputStream.computeMessageSizeNoTag((MessageLite) ZeusTransformUtils.preCheckCast(r2, MessageLite.class, "com.obric.memorydata.plugin"));
    L41:
        return CodedOutputStream.computeGroupSizeNoTag((MessageLite) ZeusTransformUtils.preCheckCast(r2, MessageLite.class, "com.obric.memorydata.plugin"));
    L43:
        return CodedOutputStream.computeBoolSizeNoTag(((Boolean) ZeusTransformUtils.preCheckCast(r2, Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
    L45:
        return CodedOutputStream.computeFixed32SizeNoTag(((Integer) ZeusTransformUtils.preCheckCast(r2, Integer.class, "com.obric.memorydata.plugin")).intValue());
    L47:
        return CodedOutputStream.computeFixed64SizeNoTag(((Long) ZeusTransformUtils.preCheckCast(r2, Long.class, "com.obric.memorydata.plugin")).longValue());
    L49:
        return CodedOutputStream.computeInt32SizeNoTag(((Integer) ZeusTransformUtils.preCheckCast(r2, Integer.class, "com.obric.memorydata.plugin")).intValue());
    L51:
        return CodedOutputStream.computeUInt64SizeNoTag(((Long) ZeusTransformUtils.preCheckCast(r2, Long.class, "com.obric.memorydata.plugin")).longValue());
    L53:
        return CodedOutputStream.computeInt64SizeNoTag(((Long) ZeusTransformUtils.preCheckCast(r2, Long.class, "com.obric.memorydata.plugin")).longValue());
    L55:
        return CodedOutputStream.computeFloatSizeNoTag(((Float) ZeusTransformUtils.preCheckCast(r2, Float.class, "com.obric.memorydata.plugin")).floatValue());
    L57:
        return CodedOutputStream.computeDoubleSizeNoTag(((Double) ZeusTransformUtils.preCheckCast(r2, Double.class, "com.obric.memorydata.plugin")).doubleValue());
    }

    public static int computeFieldSize(FieldDescriptorLite<?> r5, Object r6) {
        FieldDescriptorLite r7 = (FieldDescriptorLite) ZeusTransformUtils.wrapperContextForParams(r5, FieldDescriptorLite.class, "com.obric.memorydata.plugin");
        WireFormat.FieldType r0 = r7.getLiteType();
        int r2 = r7.getNumber();
        if (r7.isRepeated() == false) goto L19;
        List r8 = (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin");
        int r1 = r8.size();
        int r3 = 0;
        if (r7.isPacked() == true) goto L7;
        int r9 = 0;
    L15:
        if (r3 >= r1) goto L17;
        r9 = r9 + computeElementSize(r0, r2, r8.get(r3));
        r3 = r3 + 1;
        goto L15
    L17:
        return r9;
    L7:
        if (r8.isEmpty() == false) goto L9;
        return 0;
    L9:
        int r10 = 0;
    L10:
        if (r3 >= r1) goto L13;
        r10 = r10 + computeElementSizeNoTag(r0, r8.get(r3));
        r3 = r3 + 1;
        goto L10
    L13:
        return (CodedOutputStream.computeTagSize(r2) + r10) + CodedOutputStream.computeUInt32SizeNoTag(r10);
    L19:
        return computeElementSize(r0, r2, r6);
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet<T> emptySet() {
        return (FieldSet<T>) DEFAULT_INSTANCE;
    }

    private int getMessageSetSerializedSize(Map.Entry<T, Object> r5) {
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r5, Map.Entry.class, "com.obric.memorydata.plugin");
        FieldDescriptorLite r6 = (FieldDescriptorLite) ZeusTransformUtils.preCheckCast(r4.getKey(), FieldDescriptorLite.class, "com.obric.memorydata.plugin");
        Object r1 = r4.getValue();
        if (r6.getLiteJavaType() != WireFormat.JavaType.MESSAGE) goto L15;
        if (r6.isRepeated() == true) goto L15;
        if (r6.isPacked() == true) goto L15;
        boolean r7 = ZeusTransformUtils.instanceOf(r1, LazyField.class);
        Object r8 = r4.getKey();
        if (r7 == false) goto L13;
        return CodedOutputStream.computeLazyFieldMessageSetExtensionSize(((FieldDescriptorLite) ZeusTransformUtils.preCheckCast(r8, FieldDescriptorLite.class, "com.obric.memorydata.plugin")).getNumber(), (LazyField) ZeusTransformUtils.preCheckCast(r1, LazyField.class, "com.obric.memorydata.plugin"));
    L13:
        return CodedOutputStream.computeMessageSetExtensionSize(((FieldDescriptorLite) ZeusTransformUtils.preCheckCast(r8, FieldDescriptorLite.class, "com.obric.memorydata.plugin")).getNumber(), (MessageLite) ZeusTransformUtils.preCheckCast(r1, MessageLite.class, "com.obric.memorydata.plugin"));
    L15:
        return computeFieldSize(r6, r1);
    }

    static int getWireFormatForFieldType(WireFormat.FieldType r0, boolean r1) {
        if (r1 == false) goto L6;
        return 2;
    L6:
        return r0.getWireType();
    }

    private static <T extends FieldDescriptorLite<T>> boolean isInitialized(Map.Entry<T, Object> r4) {
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r4, Map.Entry.class, "com.obric.memorydata.plugin");
        FieldDescriptorLite r0 = (FieldDescriptorLite) ZeusTransformUtils.preCheckCast(r5.getKey(), FieldDescriptorLite.class, "com.obric.memorydata.plugin");
        if (r0.getLiteJavaType() != WireFormat.JavaType.MESSAGE) goto L14;
        boolean r1 = r0.isRepeated();
        Object r6 = r5.getValue();
        if (r1 == false) goto L13;
        List r7 = (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin");
        int r2 = r7.size();
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L18;
        if (isMessageFieldValueInitialized(r7.get(r3)) == false) goto L10;
        r3 = r3 + 1;
        goto L7
    L10:
        return false;
    L18:
        return true;
    L13:
        return isMessageFieldValueInitialized(r6);
    L14:
        return true;
    }

    private static boolean isMessageFieldValueInitialized(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, MessageLiteOrBuilder.class) == false) goto L7;
        return ((MessageLiteOrBuilder) ZeusTransformUtils.preCheckCast(r2, MessageLiteOrBuilder.class, "com.obric.memorydata.plugin")).isInitialized();
    L7:
        if (ZeusTransformUtils.instanceOf(r2, LazyField.class) == false) goto L11;
        return true;
    L11:
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static boolean isValidType(WireFormat.FieldType r2, Object r3) {
        Internal.checkNotNull(r3);
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$JavaType[r2.getJavaType().ordinal()]) {
            case 1: goto L33;
            case 2: goto L32;
            case 3: goto L31;
            case 4: goto L30;
            case 5: goto L29;
            case 6: goto L26;
            case 7: goto L20;
            case 8: goto L13;
            case 9: goto L6;
            default: goto L4;
        };
    L4:
        return false;
    L26:
        Class r4 = String.class;
    L28:
        return ZeusTransformUtils.instanceOf(r3, r4);
    L29:
        r4 = Boolean.class;
        goto L28
    L30:
        r4 = Double.class;
        goto L28
    L31:
        r4 = Float.class;
        goto L28
    L32:
        r4 = Long.class;
        goto L28
    L33:
        r4 = Integer.class;
        goto L28
    L6:
        if (ZeusTransformUtils.instanceOf(r3, MessageLite.class) == false) goto L8;
        return true;
    L8:
        if (ZeusTransformUtils.instanceOf(r3, LazyField.class) == false) goto L11;
        return true;
    L11:
        return false;
    L13:
        if (ZeusTransformUtils.instanceOf(r3, Integer.class) == false) goto L15;
        return true;
    L15:
        if (ZeusTransformUtils.instanceOf(r3, Internal.EnumLite.class) == false) goto L18;
        return true;
    L18:
        return false;
    L20:
        if (ZeusTransformUtils.instanceOf(r3, ByteString.class) == false) goto L22;
        return true;
    L22:
        if ((r3 instanceof byte[]) == false) goto L25;
        return true;
    L25:
        return false;
    }

    private void mergeFromField(Map.Entry<T, Object> r7) {
        Map.Entry r8 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r7, Map.Entry.class, "com.obric.memorydata.plugin");
        FieldDescriptorLite r0 = (FieldDescriptorLite) ZeusTransformUtils.preCheckCast(r8.getKey(), FieldDescriptorLite.class, "com.obric.memorydata.plugin");
        Object r9 = r8.getValue();
        boolean r2 = ZeusTransformUtils.instanceOf(r9, LazyField.class);
        if (r0.isRepeated() == false) goto L15;
        if (r2 == true) goto L13;
        Object r3 = getField(r0);
        List r10 = (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin");
        int r4 = r10.size();
        if (r3 != null) goto L8;
        r3 = new ArrayList(r4);
    L8:
        List r1 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin");
        int r5 = 0;
    L9:
        if (r5 >= r4) goto L11;
        r1.add(cloneIfMutable(r10.get(r5)));
        r5 = r5 + 1;
        goto L9
    L11:
        this.fields.put(r0, r3);
        return;
    L13:
        throw new IllegalStateException("Lazy fields can not be repeated");
    L15:
        if (r0.getLiteJavaType() != WireFormat.JavaType.MESSAGE) goto L25;
        Object r6 = getField(r0);
        if (r6 != null) goto L22;
        this.fields.put(r0, cloneIfMutable(r9));
        if (r2 == false) goto L33;
        this.hasLazyField = true;
        return;
    L33:
        return;
    L22:
        if (ZeusTransformUtils.instanceOf(r9, LazyField.class) == false) goto L24;
        r9 = ((LazyField) ZeusTransformUtils.preCheckCast(r9, LazyField.class, "com.obric.memorydata.plugin")).getValue();
    L24:
        Object r11 = r0.internalMergeFrom(((MessageLite) ZeusTransformUtils.preCheckCast(r6, MessageLite.class, "com.obric.memorydata.plugin")).toBuilder(), (MessageLite) ZeusTransformUtils.preCheckCast(r9, MessageLite.class, "com.obric.memorydata.plugin")).build();
        SmallSortedMap<T, Object> r12 = this.fields;
    L27:
        r12.put(r0, r11);
        return;
    L25:
        if (r2 == true) goto L30;
        r12 = this.fields;
        r11 = cloneIfMutable(r9);
        goto L27
    L30:
        throw new IllegalStateException("Lazy fields must be message-valued");
    }

    public static <T extends FieldDescriptorLite<T>> Builder<T> newBuilder() {
        return new Builder(null);
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet<T> newFieldSet() {
        return new FieldSet();
    }

    public static Object readPrimitiveField(CodedInputStream r0, WireFormat.FieldType r1, boolean r2) {
        if (r2 == false) goto L6;
        WireFormat.Utf8Validation r3 = WireFormat.Utf8Validation.STRICT;
    L5:
        return WireFormat.readPrimitiveField(r0, r1, r3);
    L6:
        r3 = WireFormat.Utf8Validation.LOOSE;
        goto L5
    }

    private void verifyType(T r4, Object r5) {
        FieldDescriptorLite r3 = (FieldDescriptorLite) ZeusTransformUtils.wrapperContextForParams(r4, FieldDescriptorLite.class, "com.obric.memorydata.plugin");
        if (isValidType(r3.getLiteType(), r5) == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(r3.getNumber()), r3.getLiteType().getJavaType(), r5.getClass().getName()}));
    }

    static void writeElement(CodedOutputStream r1, WireFormat.FieldType r2, int r3, Object r4) {
        if (r2 != WireFormat.FieldType.GROUP) goto L5;
        r1.writeGroup(r3, (MessageLite) ZeusTransformUtils.preCheckCast(r4, MessageLite.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        r1.writeTag(r3, getWireFormatForFieldType(r2, false));
        writeElementNoTag(r1, r2, r4);
    }

    static void writeElementNoTag(CodedOutputStream r1, WireFormat.FieldType r2, Object r3) {
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r2.ordinal()]) {
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
        r1.writeSInt64NoTag(((Long) ZeusTransformUtils.preCheckCast(r3, Long.class, "com.obric.memorydata.plugin")).longValue());
        return;
    L11:
        r1.writeSInt32NoTag(((Integer) ZeusTransformUtils.preCheckCast(r3, Integer.class, "com.obric.memorydata.plugin")).intValue());
        return;
    L12:
        r1.writeSFixed64NoTag(((Long) ZeusTransformUtils.preCheckCast(r3, Long.class, "com.obric.memorydata.plugin")).longValue());
        return;
    L13:
        r1.writeSFixed32NoTag(((Integer) ZeusTransformUtils.preCheckCast(r3, Integer.class, "com.obric.memorydata.plugin")).intValue());
        return;
    L14:
        r1.writeUInt32NoTag(((Integer) ZeusTransformUtils.preCheckCast(r3, Integer.class, "com.obric.memorydata.plugin")).intValue());
        return;
    L23:
        r1.writeMessageNoTag((MessageLite) ZeusTransformUtils.preCheckCast(r3, MessageLite.class, "com.obric.memorydata.plugin"));
        return;
    L24:
        r1.writeGroupNoTag((MessageLite) ZeusTransformUtils.preCheckCast(r3, MessageLite.class, "com.obric.memorydata.plugin"));
        return;
    L25:
        r1.writeBoolNoTag(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
        return;
    L26:
        r1.writeFixed32NoTag(((Integer) ZeusTransformUtils.preCheckCast(r3, Integer.class, "com.obric.memorydata.plugin")).intValue());
        return;
    L27:
        r1.writeFixed64NoTag(((Long) ZeusTransformUtils.preCheckCast(r3, Long.class, "com.obric.memorydata.plugin")).longValue());
        return;
    L28:
        r1.writeInt32NoTag(((Integer) ZeusTransformUtils.preCheckCast(r3, Integer.class, "com.obric.memorydata.plugin")).intValue());
        return;
    L29:
        r1.writeUInt64NoTag(((Long) ZeusTransformUtils.preCheckCast(r3, Long.class, "com.obric.memorydata.plugin")).longValue());
        return;
    L30:
        r1.writeInt64NoTag(((Long) ZeusTransformUtils.preCheckCast(r3, Long.class, "com.obric.memorydata.plugin")).longValue());
        return;
    L31:
        r1.writeFloatNoTag(((Float) ZeusTransformUtils.preCheckCast(r3, Float.class, "com.obric.memorydata.plugin")).floatValue());
        return;
    L32:
        r1.writeDoubleNoTag(((Double) ZeusTransformUtils.preCheckCast(r3, Double.class, "com.obric.memorydata.plugin")).doubleValue());
        return;
    L52:
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r3, Internal.EnumLite.class) == false) goto L8;
        int r4 = ((Internal.EnumLite) ZeusTransformUtils.preCheckCast(r3, Internal.EnumLite.class, "com.obric.memorydata.plugin")).getNumber();
    L9:
        r1.writeEnumNoTag(r4);
        return;
    L8:
        r4 = ((Integer) ZeusTransformUtils.preCheckCast(r3, Integer.class, "com.obric.memorydata.plugin")).intValue();
        goto L9
    L16:
        if (ZeusTransformUtils.instanceOf(r3, ByteString.class) == true) goto L21;
        r1.writeByteArrayNoTag((byte[]) ZeusTransformUtils.preCheckCast(r3, byte[].class, "com.obric.memorydata.plugin"));
        return;
    L21:
        r1.writeBytesNoTag((ByteString) ZeusTransformUtils.preCheckCast(r3, ByteString.class, "com.obric.memorydata.plugin"));
        return;
    L20:
        if (ZeusTransformUtils.instanceOf(r3, ByteString.class) == true) goto L21;
        r1.writeStringNoTag((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
    }

    public static void writeField(FieldDescriptorLite<?> r5, Object r6, CodedOutputStream r7) {
        FieldDescriptorLite r8 = (FieldDescriptorLite) ZeusTransformUtils.wrapperContextForParams(r5, FieldDescriptorLite.class, "com.obric.memorydata.plugin");
        WireFormat.FieldType r0 = r8.getLiteType();
        int r2 = r8.getNumber();
        if (r8.isRepeated() == false) goto L18;
        List r9 = (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin");
        int r1 = r9.size();
        int r3 = 0;
        if (r8.isPacked() == true) goto L7;
    L15:
        if (r3 >= r1) goto L27;
        writeElement(r7, r0, r2, r9.get(r3));
        r3 = r3 + 1;
        goto L15
    L27:
        return;
    L7:
        if (r9.isEmpty() == false) goto L9;
        return;
    L9:
        r7.writeTag(r2, 2);
        int r10 = 0;
        int r4 = 0;
    L10:
        if (r10 >= r1) goto L12;
        r4 = r4 + computeElementSizeNoTag(r0, r9.get(r10));
        r10 = r10 + 1;
        goto L10
    L12:
        r7.writeUInt32NoTag(r4);
    L13:
        if (r3 >= r1) goto L26;
        writeElementNoTag(r7, r0, r9.get(r3));
        r3 = r3 + 1;
        goto L13
    L26:
        return;
    L18:
        if (ZeusTransformUtils.instanceOf(r6, LazyField.class) == false) goto L20;
        writeElement(r7, r0, r2, ((LazyField) ZeusTransformUtils.preCheckCast(r6, LazyField.class, "com.obric.memorydata.plugin")).getValue());
        return;
    L20:
        writeElement(r7, r0, r2, r6);
    }

    private void writeMessageSetTo(Map.Entry<T, Object> r4, CodedOutputStream r5) {
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r4, Map.Entry.class, "com.obric.memorydata.plugin");
        FieldDescriptorLite r6 = (FieldDescriptorLite) ZeusTransformUtils.preCheckCast(r3.getKey(), FieldDescriptorLite.class, "com.obric.memorydata.plugin");
        if (r6.getLiteJavaType() == WireFormat.JavaType.MESSAGE) goto L5;
    L12:
        writeField(r6, r3.getValue(), r5);
        return;
    L5:
        if (r6.isRepeated() == true) goto L12;
        if (r6.isPacked() == true) goto L12;
        Object r7 = r3.getValue();
        if (ZeusTransformUtils.instanceOf(r7, LazyField.class) == false) goto L11;
        ByteString r8 = ((LazyField) ZeusTransformUtils.preCheckCast(r7, LazyField.class, "com.obric.memorydata.plugin")).toByteString();
        r5.writeRawMessageSetExtension(((FieldDescriptorLite) ZeusTransformUtils.preCheckCast(r3.getKey(), FieldDescriptorLite.class, "com.obric.memorydata.plugin")).getNumber(), r8);
        return;
    L11:
        r5.writeMessageSetExtension(((FieldDescriptorLite) ZeusTransformUtils.preCheckCast(r3.getKey(), FieldDescriptorLite.class, "com.obric.memorydata.plugin")).getNumber(), (MessageLite) ZeusTransformUtils.preCheckCast(r7, MessageLite.class, "com.obric.memorydata.plugin"));
    }

    public void addRepeatedField(T r3, Object r4) {
        FieldDescriptorLite r5 = (FieldDescriptorLite) ZeusTransformUtils.wrapperContextForParams(r3, FieldDescriptorLite.class, "com.obric.memorydata.plugin");
        if (r5.isRepeated() == false) goto L11;
        verifyType(r5, r4);
        Object r0 = getField(r5);
        if (r0 != null) goto L7;
        List r1 = new ArrayList();
        this.fields.put(r5, r1);
    L8:
        r1.add(r4);
        return;
    L7:
        r1 = (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
        goto L8
    L11:
        throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }

    public void clear() {
        this.fields.clear();
        this.hasLazyField = false;
    }

    public void clearField(T r3) {
        FieldDescriptorLite r4 = (FieldDescriptorLite) ZeusTransformUtils.wrapperContextForParams(r3, FieldDescriptorLite.class, "com.obric.memorydata.plugin");
        this.fields.remove(r4);
        if (this.fields.isEmpty() == false) goto L6;
        this.hasLazyField = false;
        return;
    }

    public FieldSet<T> clone() {
        FieldSet<T> r0 = newFieldSet();
        int r1 = this.fields.getNumArrayEntries();
        int r2 = 0;
    L4:
        if (r2 >= r1) goto L6;
        Map.Entry<K, Object> r4 = this.fields.getArrayEntryAt(r2);
        r0.setField((FieldDescriptorLite) ZeusTransformUtils.preCheckCast(r4.getKey(), FieldDescriptorLite.class, "com.obric.memorydata.plugin"), r4.getValue());
        r2 = r2 + 1;
        goto L4
    L6:
        Iterator r3 = this.fields.getOverflowEntries().iterator();
    L8:
        if (r3.hasNext() == false) goto L10;
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r0.setField((FieldDescriptorLite) ZeusTransformUtils.preCheckCast(r5.getKey(), FieldDescriptorLite.class, "com.obric.memorydata.plugin"), r5.getValue());
        goto L8
    L10:
        r0.hasLazyField = this.hasLazyField;
        return r0;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m142clone() {
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

    public boolean equals(Object r3) {
        if (this != r3) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, FieldSet.class) == true) goto L10;
        return false;
    L10:
        FieldSet r4 = (FieldSet) ZeusTransformUtils.preCheckCast(r3, FieldSet.class, "com.obric.memorydata.plugin");
        return this.fields.equals(r4.fields);
    }

    public Map<T, Object> getAllFields() {
        if (this.hasLazyField == false) goto L8;
        SmallSortedMap r0 = cloneAllFieldsMap(this.fields, false, true);
        if (this.fields.isImmutable() == false) goto L7;
        r0.makeImmutable();
    L7:
        return r0;
    L8:
        boolean r1 = this.fields.isImmutable();
        SmallSortedMap<T, Object> r3 = this.fields;
        if (r1 == false) goto L12;
        return r3;
    L12:
        return Collections.unmodifiableMap(r3);
    }

    public Object getField(T r3) {
        FieldDescriptorLite r4 = (FieldDescriptorLite) ZeusTransformUtils.wrapperContextForParams(r3, FieldDescriptorLite.class, "com.obric.memorydata.plugin");
        Object r2 = this.fields.get(r4);
        if (ZeusTransformUtils.instanceOf(r2, LazyField.class) == true) goto L5;
        return r2;
    L5:
        return ((LazyField) ZeusTransformUtils.preCheckCast(r2, LazyField.class, "com.obric.memorydata.plugin")).getValue();
    }

    public int getMessageSetSerializedSize() {
        int r0 = this.fields.getNumArrayEntries();
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r2 = r2 + getMessageSetSerializedSize(this.fields.getArrayEntryAt(r1));
        r1 = r1 + 1;
        goto L3
    L5:
        Iterator r3 = this.fields.getOverflowEntries().iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        r2 = r2 + getMessageSetSerializedSize((Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.memorydata.plugin"));
        goto L7
    L9:
        return r2;
    }

    public Object getRepeatedField(T r3, int r4) {
        FieldDescriptorLite r5 = (FieldDescriptorLite) ZeusTransformUtils.wrapperContextForParams(r3, FieldDescriptorLite.class, "com.obric.memorydata.plugin");
        if (r5.isRepeated() == false) goto L11;
        Object r2 = getField(r5);
        if (r2 == null) goto L9;
        return ((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin")).get(r4);
    L9:
        throw new IndexOutOfBoundsException();
    L11:
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public int getRepeatedFieldCount(T r3) {
        FieldDescriptorLite r4 = (FieldDescriptorLite) ZeusTransformUtils.wrapperContextForParams(r3, FieldDescriptorLite.class, "com.obric.memorydata.plugin");
        if (r4.isRepeated() == false) goto L11;
        Object r2 = getField(r4);
        if (r2 != null) goto L9;
        return 0;
    L9:
        return ((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin")).size();
    L11:
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public int getSerializedSize() {
        int r0 = this.fields.getNumArrayEntries();
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r1 >= r0) goto L6;
        Map.Entry<K, Object> r4 = this.fields.getArrayEntryAt(r1);
        r2 = r2 + computeFieldSize((FieldDescriptorLite) ZeusTransformUtils.preCheckCast(r4.getKey(), FieldDescriptorLite.class, "com.obric.memorydata.plugin"), r4.getValue());
        r1 = r1 + 1;
        goto L4
    L6:
        Iterator r7 = this.fields.getOverflowEntries().iterator();
    L8:
        if (r7.hasNext() == false) goto L10;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r2 = r2 + computeFieldSize((FieldDescriptorLite) ZeusTransformUtils.preCheckCast(r3.getKey(), FieldDescriptorLite.class, "com.obric.memorydata.plugin"), r3.getValue());
        goto L8
    L10:
        return r2;
    }

    public boolean hasField(T r3) {
        FieldDescriptorLite r4 = (FieldDescriptorLite) ZeusTransformUtils.wrapperContextForParams(r3, FieldDescriptorLite.class, "com.obric.memorydata.plugin");
        if (r4.isRepeated() == true) goto L10;
        if (this.fields.get(r4) == null) goto L7;
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
        int r0 = this.fields.getNumArrayEntries();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        if (isInitialized(this.fields.getArrayEntryAt(r2)) == false) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return false;
    L8:
        Iterator r4 = this.fields.getOverflowEntries().iterator();
    L10:
        if (r4.hasNext() == false) goto L14;
        if (isInitialized((Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.memorydata.plugin")) == true) goto L10;
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

    boolean lazyFieldCorrupted(T r3) {
        FieldDescriptorLite r4 = (FieldDescriptorLite) ZeusTransformUtils.wrapperContextForParams(r3, FieldDescriptorLite.class, "com.obric.memorydata.plugin");
        Object r2 = this.fields.get(r4);
        if (ZeusTransformUtils.instanceOf(r2, LazyField.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (((LazyField) ZeusTransformUtils.preCheckCast(r2, LazyField.class, "com.obric.memorydata.plugin")).isCorrupted() == false) goto L7;
        return true;
    }

    public void makeImmutable() {
        if (this.isImmutable == false) goto L5;
        return;
    L5:
        int r0 = this.fields.getNumArrayEntries();
        int r1 = 0;
    L7:
        if (r1 >= r0) goto L12;
        Object r3 = this.fields.getArrayEntryAt(r1).getValue();
        if (ZeusTransformUtils.instanceOf(r3, GeneratedMessageLite.class) == false) goto L11;
        ((GeneratedMessageLite) ZeusTransformUtils.preCheckCast(r3, GeneratedMessageLite.class, "com.obric.memorydata.plugin")).makeImmutable();
    L11:
        r1 = r1 + 1;
        goto L7
    L12:
        Iterator r2 = this.fields.getOverflowEntries().iterator();
    L14:
        if (r2.hasNext() == false) goto L18;
        Object r4 = ((Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getValue();
        if (ZeusTransformUtils.instanceOf(r4, GeneratedMessageLite.class) == false) goto L14;
        ((GeneratedMessageLite) ZeusTransformUtils.preCheckCast(r4, GeneratedMessageLite.class, "com.obric.memorydata.plugin")).makeImmutable();
        goto L14
    L18:
        this.fields.makeImmutable();
        this.isImmutable = true;
    }

    public void mergeFrom(FieldSet<T> r4) {
        int r0 = r4.fields.getNumArrayEntries();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        mergeFromField(r4.fields.getArrayEntryAt(r1));
        r1 = r1 + 1;
        goto L3
    L5:
        Iterator r5 = r4.fields.getOverflowEntries().iterator();
    L7:
        if (r5.hasNext() == false) goto L9;
        mergeFromField((Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.memorydata.plugin"));
        goto L7
    }

    public void setField(T r5, Object r6) {
        FieldDescriptorLite r7 = (FieldDescriptorLite) ZeusTransformUtils.wrapperContextForParams(r5, FieldDescriptorLite.class, "com.obric.memorydata.plugin");
        if (r7.isRepeated() == true) goto L5;
        verifyType(r7, r6);
    L14:
        if (ZeusTransformUtils.instanceOf(r6, LazyField.class) == false) goto L16;
        this.hasLazyField = true;
    L16:
        this.fields.put(r7, r6);
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r6, List.class) == false) goto L11;
        List r8 = (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin");
        int r0 = r8.size();
        ArrayList r1 = new ArrayList(r0);
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L9;
        Object r3 = r8.get(r2);
        verifyType(r7, r3);
        r1.add(r3);
        r2 = r2 + 1;
        goto L7
    L9:
        r6 = r1;
        goto L14
    L11:
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    public void setRepeatedField(T r3, int r4, Object r5) {
        FieldDescriptorLite r6 = (FieldDescriptorLite) ZeusTransformUtils.wrapperContextForParams(r3, FieldDescriptorLite.class, "com.obric.memorydata.plugin");
        if (r6.isRepeated() == false) goto L11;
        Object r0 = getField(r6);
        if (r0 == null) goto L9;
        verifyType(r6, r5);
        ((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin")).set(r4, r5);
        return;
    L9:
        throw new IndexOutOfBoundsException();
    L11:
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public void writeMessageSetTo(CodedOutputStream r5) {
        int r0 = this.fields.getNumArrayEntries();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        writeMessageSetTo(this.fields.getArrayEntryAt(r1), r5);
        r1 = r1 + 1;
        goto L3
    L5:
        Iterator r2 = this.fields.getOverflowEntries().iterator();
    L7:
        if (r2.hasNext() == false) goto L9;
        writeMessageSetTo((Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.memorydata.plugin"), r5);
        goto L7
    }

    public void writeTo(CodedOutputStream r7) {
        int r0 = this.fields.getNumArrayEntries();
        int r1 = 0;
    L4:
        if (r1 >= r0) goto L6;
        Map.Entry<K, Object> r3 = this.fields.getArrayEntryAt(r1);
        writeField((FieldDescriptorLite) ZeusTransformUtils.preCheckCast(r3.getKey(), FieldDescriptorLite.class, "com.obric.memorydata.plugin"), r3.getValue(), r7);
        r1 = r1 + 1;
        goto L4
    L6:
        Iterator r6 = this.fields.getOverflowEntries().iterator();
    L8:
        if (r6.hasNext() == false) goto L10;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        writeField((FieldDescriptorLite) ZeusTransformUtils.preCheckCast(r2.getKey(), FieldDescriptorLite.class, "com.obric.memorydata.plugin"), r2.getValue(), r7);
        goto L8
    }
}
