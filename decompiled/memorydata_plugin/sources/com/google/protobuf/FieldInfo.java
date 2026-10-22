package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
final class FieldInfo implements Comparable<FieldInfo> {
    private final java.lang.reflect.Field cachedSizeField;
    private final boolean enforceUtf8;
    private final Internal.EnumVerifier enumVerifier;
    private final java.lang.reflect.Field field;
    private final int fieldNumber;
    private final Object mapDefaultEntry;
    private final Class<?> messageClass;
    private final OneofInfo oneof;
    private final Class<?> oneofStoredType;
    private final java.lang.reflect.Field presenceField;
    private final int presenceMask;
    private final boolean required;
    private final FieldType type;

    /* JADX INFO: renamed from: com.google.protobuf.FieldInfo$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$FieldType = null;

        static {
            int[] r0 = new int[FieldType.values().length];
            $SwitchMap$com$google$protobuf$FieldType = r0;
            r0[FieldType.MESSAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$google$protobuf$FieldType[FieldType.GROUP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$google$protobuf$FieldType[FieldType.MESSAGE_LIST.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$google$protobuf$FieldType[FieldType.GROUP_LIST.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public static final class Builder {
        private java.lang.reflect.Field cachedSizeField;
        private boolean enforceUtf8;
        private Internal.EnumVerifier enumVerifier;
        private java.lang.reflect.Field field;
        private int fieldNumber;
        private Object mapDefaultEntry;
        private OneofInfo oneof;
        private Class<?> oneofStoredType;
        private java.lang.reflect.Field presenceField;
        private int presenceMask;
        private boolean required;
        private FieldType type;

        private Builder() {
        }

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        public FieldInfo build() {
            OneofInfo r2 = this.oneof;
            if (r2 != null) goto L5;
            Object r0 = this.mapDefaultEntry;
            if (r0 != null) goto L9;
            java.lang.reflect.Field r3 = this.presenceField;
            if (r3 != null) goto L13;
            Internal.EnumVerifier r1 = this.enumVerifier;
            if (r1 == null) goto L26;
            java.lang.reflect.Field r4 = this.cachedSizeField;
            if (r4 != null) goto L25;
            return FieldInfo.forFieldWithEnumVerifier(this.field, this.fieldNumber, this.type, r1);
        L25:
            return FieldInfo.forPackedFieldWithEnumVerifier(this.field, this.fieldNumber, this.type, r1, r4);
        L26:
            java.lang.reflect.Field r5 = this.cachedSizeField;
            if (r5 != null) goto L31;
            return FieldInfo.forField(this.field, this.fieldNumber, this.type, this.enforceUtf8);
        L31:
            return FieldInfo.forPackedField(this.field, this.fieldNumber, this.type, r5);
        L13:
            if (this.required == false) goto L17;
            return FieldInfo.forLegacyRequiredField(this.field, this.fieldNumber, this.type, r3, this.presenceMask, this.enforceUtf8, this.enumVerifier);
        L17:
            return FieldInfo.forExplicitPresenceField(this.field, this.fieldNumber, this.type, r3, this.presenceMask, this.enforceUtf8, this.enumVerifier);
        L9:
            return FieldInfo.forMapField(this.field, this.fieldNumber, r0, this.enumVerifier);
        L5:
            return FieldInfo.forOneofMemberField(this.fieldNumber, this.type, r2, this.oneofStoredType, this.enforceUtf8, this.enumVerifier);
        }

        public Builder withCachedSizeField(java.lang.reflect.Field r1) {
            this.cachedSizeField = r1;
            return this;
        }

        public Builder withEnforceUtf8(boolean r1) {
            this.enforceUtf8 = r1;
            return this;
        }

        public Builder withEnumVerifier(Internal.EnumVerifier r3) {
            this.enumVerifier = (Internal.EnumVerifier) ZeusTransformUtils.wrapperContextForParams(r3, Internal.EnumVerifier.class, "com.obric.memorydata.plugin");
            return this;
        }

        public Builder withField(java.lang.reflect.Field r2) {
            if (this.oneof != null) goto L7;
            this.field = r2;
            return this;
        L7:
            throw new IllegalStateException("Cannot set field when building a oneof.");
        }

        public Builder withFieldNumber(int r1) {
            this.fieldNumber = r1;
            return this;
        }

        public Builder withMapDefaultEntry(Object r1) {
            this.mapDefaultEntry = r1;
            return this;
        }

        public Builder withOneof(OneofInfo r2, Class<?> r3) {
            if (this.field != null) goto L9;
            if (this.presenceField != null) goto L9;
            this.oneof = r2;
            this.oneofStoredType = r3;
            return this;
        L9:
            throw new IllegalStateException("Cannot set oneof when field or presenceField have been provided");
        }

        public Builder withPresence(java.lang.reflect.Field r3, int r4) {
            this.presenceField = (java.lang.reflect.Field) ZeusTransformUtils.preCheckCast(Internal.checkNotNull(r3, "presenceField"), java.lang.reflect.Field.class, "com.obric.memorydata.plugin");
            this.presenceMask = r4;
            return this;
        }

        public Builder withRequired(boolean r1) {
            this.required = r1;
            return this;
        }

        public Builder withType(FieldType r1) {
            this.type = r1;
            return this;
        }
    }

    private FieldInfo(java.lang.reflect.Field r3, int r4, FieldType r5, Class<?> r6, java.lang.reflect.Field r7, int r8, boolean r9, boolean r10, OneofInfo r11, Class<?> r12, Object r13, Internal.EnumVerifier r14, java.lang.reflect.Field r15) {
        Internal.EnumVerifier r16 = (Internal.EnumVerifier) ZeusTransformUtils.wrapperContextForParams(r14, Internal.EnumVerifier.class, "com.obric.memorydata.plugin");
        this.field = r3;
        this.type = r5;
        this.messageClass = r6;
        this.fieldNumber = r4;
        this.presenceField = r7;
        this.presenceMask = r8;
        this.required = r9;
        this.enforceUtf8 = r10;
        this.oneof = r11;
        this.oneofStoredType = r12;
        this.mapDefaultEntry = r13;
        this.enumVerifier = r16;
        this.cachedSizeField = r15;
    }

    private static void checkFieldNumber(int r3) {
        if (r3 <= 0) goto L5;
        return;
    L5:
        throw new IllegalArgumentException("fieldNumber must be positive: " + r3);
    }

    public static FieldInfo forExplicitPresenceField(java.lang.reflect.Field r15, int r16, FieldType r17, java.lang.reflect.Field r18, int r19, boolean r20, Internal.EnumVerifier r21) {
        Internal.EnumVerifier r12 = (Internal.EnumVerifier) ZeusTransformUtils.wrapperContextForParams(r21, Internal.EnumVerifier.class, "com.obric.memorydata.plugin");
        checkFieldNumber(r16);
        Internal.checkNotNull(r15, "field");
        Internal.checkNotNull(r17, "fieldType");
        Internal.checkNotNull(r18, "presenceField");
        if (r18 == null) goto L10;
        if (isExactlyOneBitSet(r19) == true) goto L10;
        throw new IllegalArgumentException("presenceMask must have exactly one bit set: " + r19);
    L10:
        return new FieldInfo(r15, r16, r17, null, r18, r19, false, r20, null, null, null, r12, null);
    }

    public static FieldInfo forField(java.lang.reflect.Field r15, int r16, FieldType r17, boolean r18) {
        checkFieldNumber(r16);
        Internal.checkNotNull(r15, "field");
        Internal.checkNotNull(r17, "fieldType");
        if (r17 == FieldType.MESSAGE_LIST) goto L9;
        if (r17 == FieldType.GROUP_LIST) goto L9;
        return new FieldInfo(r15, r16, r17, null, null, 0, false, r18, null, null, null, null, null);
    L9:
        throw new IllegalStateException("Shouldn't be called for repeated message fields.");
    }

    public static FieldInfo forFieldWithEnumVerifier(java.lang.reflect.Field r15, int r16, FieldType r17, Internal.EnumVerifier r18) {
        Internal.EnumVerifier r13 = (Internal.EnumVerifier) ZeusTransformUtils.wrapperContextForParams(r18, Internal.EnumVerifier.class, "com.obric.memorydata.plugin");
        checkFieldNumber(r16);
        Internal.checkNotNull(r15, "field");
        return new FieldInfo(r15, r16, r17, null, null, 0, false, false, null, null, null, r13, null);
    }

    public static FieldInfo forLegacyRequiredField(java.lang.reflect.Field r15, int r16, FieldType r17, java.lang.reflect.Field r18, int r19, boolean r20, Internal.EnumVerifier r21) {
        Internal.EnumVerifier r12 = (Internal.EnumVerifier) ZeusTransformUtils.wrapperContextForParams(r21, Internal.EnumVerifier.class, "com.obric.memorydata.plugin");
        checkFieldNumber(r16);
        Internal.checkNotNull(r15, "field");
        Internal.checkNotNull(r17, "fieldType");
        Internal.checkNotNull(r18, "presenceField");
        if (r18 == null) goto L10;
        if (isExactlyOneBitSet(r19) == true) goto L10;
        throw new IllegalArgumentException("presenceMask must have exactly one bit set: " + r19);
    L10:
        return new FieldInfo(r15, r16, r17, null, r18, r19, true, r20, null, null, null, r12, null);
    }

    public static FieldInfo forMapField(java.lang.reflect.Field r15, int r16, Object r17, Internal.EnumVerifier r18) {
        Internal.EnumVerifier r13 = (Internal.EnumVerifier) ZeusTransformUtils.wrapperContextForParams(r18, Internal.EnumVerifier.class, "com.obric.memorydata.plugin");
        Internal.checkNotNull(r17, "mapDefaultEntry");
        checkFieldNumber(r16);
        Internal.checkNotNull(r15, "field");
        return new FieldInfo(r15, r16, FieldType.MAP, null, null, 0, false, true, null, null, r17, r13, null);
    }

    public static FieldInfo forOneofMemberField(int r15, FieldType r16, OneofInfo r17, Class<?> r18, boolean r19, Internal.EnumVerifier r20) {
        Internal.EnumVerifier r12 = (Internal.EnumVerifier) ZeusTransformUtils.wrapperContextForParams(r20, Internal.EnumVerifier.class, "com.obric.memorydata.plugin");
        checkFieldNumber(r15);
        Internal.checkNotNull(r16, "fieldType");
        Internal.checkNotNull(r17, "oneof");
        Internal.checkNotNull(r18, "oneofStoredType");
        if (r16.isScalar() == false) goto L7;
        return new FieldInfo(null, r15, r16, null, null, 0, false, r19, r17, r18, null, r12, null);
    L7:
        throw new IllegalArgumentException("Oneof is only supported for scalar fields. Field " + r15 + " is of type " + r16);
    }

    public static FieldInfo forPackedField(java.lang.reflect.Field r15, int r16, FieldType r17, java.lang.reflect.Field r18) {
        checkFieldNumber(r16);
        Internal.checkNotNull(r15, "field");
        Internal.checkNotNull(r17, "fieldType");
        if (r17 == FieldType.MESSAGE_LIST) goto L9;
        if (r17 == FieldType.GROUP_LIST) goto L9;
        return new FieldInfo(r15, r16, r17, null, null, 0, false, false, null, null, null, null, r18);
    L9:
        throw new IllegalStateException("Shouldn't be called for repeated message fields.");
    }

    public static FieldInfo forPackedFieldWithEnumVerifier(java.lang.reflect.Field r15, int r16, FieldType r17, Internal.EnumVerifier r18, java.lang.reflect.Field r19) {
        Internal.EnumVerifier r13 = (Internal.EnumVerifier) ZeusTransformUtils.wrapperContextForParams(r18, Internal.EnumVerifier.class, "com.obric.memorydata.plugin");
        checkFieldNumber(r16);
        Internal.checkNotNull(r15, "field");
        return new FieldInfo(r15, r16, r17, null, null, 0, false, false, null, null, null, r13, r19);
    }

    public static FieldInfo forRepeatedMessageField(java.lang.reflect.Field r15, int r16, FieldType r17, Class<?> r18) {
        checkFieldNumber(r16);
        Internal.checkNotNull(r15, "field");
        Internal.checkNotNull(r17, "fieldType");
        Internal.checkNotNull(r18, "messageClass");
        return new FieldInfo(r15, r16, r17, r18, null, 0, false, false, null, null, null, null, null);
    }

    private static boolean isExactlyOneBitSet(int r1) {
        if (r1 != 0) goto L4;
    L6:
        return false;
    L4:
        if ((r1 & (r1 - 1)) != 0) goto L6;
        return true;
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(FieldInfo r1) {
        return this.fieldNumber - r1.fieldNumber;
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(FieldInfo r3) {
        return compareTo2((FieldInfo) ZeusTransformUtils.preCheckCast(r3, FieldInfo.class, "com.obric.memorydata.plugin"));
    }

    public java.lang.reflect.Field getCachedSizeField() {
        return this.cachedSizeField;
    }

    public Internal.EnumVerifier getEnumVerifier() {
        return this.enumVerifier;
    }

    public java.lang.reflect.Field getField() {
        return this.field;
    }

    public int getFieldNumber() {
        return this.fieldNumber;
    }

    public Class<?> getListElementType() {
        return this.messageClass;
    }

    public Object getMapDefaultEntry() {
        return this.mapDefaultEntry;
    }

    public Class<?> getMessageFieldClass() {
        int r0 = AnonymousClass1.$SwitchMap$com$google$protobuf$FieldType[this.type.ordinal()];
        if (r0 != 1) goto L5;
    L14:
        java.lang.reflect.Field r1 = this.field;
        if (r1 == null) goto L18;
        return r1.getType();
    L18:
        return this.oneofStoredType;
    L5:
        if (r0 == 2) goto L14;
        if (r0 == 3) goto L13;
        if (r0 == 4) goto L13;
        return null;
    L13:
        return this.messageClass;
    }

    public OneofInfo getOneof() {
        return this.oneof;
    }

    public Class<?> getOneofStoredType() {
        return this.oneofStoredType;
    }

    public java.lang.reflect.Field getPresenceField() {
        return this.presenceField;
    }

    public int getPresenceMask() {
        return this.presenceMask;
    }

    public FieldType getType() {
        return this.type;
    }

    public boolean isEnforceUtf8() {
        return this.enforceUtf8;
    }

    public boolean isRequired() {
        return this.required;
    }
}
