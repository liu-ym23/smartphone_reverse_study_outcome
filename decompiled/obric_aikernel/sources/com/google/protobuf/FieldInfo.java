package com.google.protobuf;

/* JADX INFO: loaded from: classes2.dex */
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
            int[] r10 = new int[FieldType.values().length];
            $SwitchMap$com$google$protobuf$FieldType = r10;
            r10[FieldType.MESSAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
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

        /* synthetic */ Builder(AnonymousClass1 r10) {
            this();
        }

        public FieldInfo build() {
            OneofInfo r10 = this.oneof;
            if (r10 != null) goto L5;
            Object r11 = this.mapDefaultEntry;
            if (r11 != null) goto L9;
            java.lang.reflect.Field r12 = this.presenceField;
            if (r12 != null) goto L13;
            Internal.EnumVerifier r13 = this.enumVerifier;
            if (r13 == null) goto L26;
            java.lang.reflect.Field r14 = this.cachedSizeField;
            if (r14 != null) goto L25;
            return FieldInfo.forFieldWithEnumVerifier(this.field, this.fieldNumber, this.type, r13);
        L25:
            return FieldInfo.forPackedFieldWithEnumVerifier(this.field, this.fieldNumber, this.type, r13, r14);
        L26:
            java.lang.reflect.Field r15 = this.cachedSizeField;
            if (r15 != null) goto L31;
            return FieldInfo.forField(this.field, this.fieldNumber, this.type, this.enforceUtf8);
        L31:
            return FieldInfo.forPackedField(this.field, this.fieldNumber, this.type, r15);
        L13:
            if (this.required == false) goto L17;
            return FieldInfo.forLegacyRequiredField(this.field, this.fieldNumber, this.type, r12, this.presenceMask, this.enforceUtf8, this.enumVerifier);
        L17:
            return FieldInfo.forExplicitPresenceField(this.field, this.fieldNumber, this.type, r12, this.presenceMask, this.enforceUtf8, this.enumVerifier);
        L9:
            return FieldInfo.forMapField(this.field, this.fieldNumber, r11, this.enumVerifier);
        L5:
            return FieldInfo.forOneofMemberField(this.fieldNumber, this.type, r10, this.oneofStoredType, this.enforceUtf8, this.enumVerifier);
        }

        public Builder withCachedSizeField(java.lang.reflect.Field r10) {
            this.cachedSizeField = r10;
            return this;
        }

        public Builder withEnforceUtf8(boolean r10) {
            this.enforceUtf8 = r10;
            return this;
        }

        public Builder withEnumVerifier(Internal.EnumVerifier r10) {
            this.enumVerifier = r10;
            return this;
        }

        public Builder withField(java.lang.reflect.Field r10) {
            if (this.oneof != null) goto L7;
            this.field = r10;
            return this;
        L7:
            throw new IllegalStateException("Cannot set field when building a oneof.");
        }

        public Builder withFieldNumber(int r10) {
            this.fieldNumber = r10;
            return this;
        }

        public Builder withMapDefaultEntry(Object r10) {
            this.mapDefaultEntry = r10;
            return this;
        }

        public Builder withOneof(OneofInfo r10, Class<?> r11) {
            if (this.field != null) goto L9;
            if (this.presenceField != null) goto L9;
            this.oneof = r10;
            this.oneofStoredType = r11;
            return this;
        L9:
            throw new IllegalStateException("Cannot set oneof when field or presenceField have been provided");
        }

        public Builder withPresence(java.lang.reflect.Field r10, int r11) {
            this.presenceField = (java.lang.reflect.Field) Internal.checkNotNull(r10, "presenceField");
            this.presenceMask = r11;
            return this;
        }

        public Builder withRequired(boolean r10) {
            this.required = r10;
            return this;
        }

        public Builder withType(FieldType r10) {
            this.type = r10;
            return this;
        }
    }

    private FieldInfo(java.lang.reflect.Field r10, int r11, FieldType r12, Class<?> r13, java.lang.reflect.Field r14, int r15, boolean r16, boolean r17, OneofInfo r18, Class<?> r19, Object r110, Internal.EnumVerifier r111, java.lang.reflect.Field r112) {
        this.field = r10;
        this.type = r12;
        this.messageClass = r13;
        this.fieldNumber = r11;
        this.presenceField = r14;
        this.presenceMask = r15;
        this.required = r16;
        this.enforceUtf8 = r17;
        this.oneof = r18;
        this.oneofStoredType = r19;
        this.mapDefaultEntry = r110;
        this.enumVerifier = r111;
        this.cachedSizeField = r112;
    }

    private static void checkFieldNumber(int r10) {
        if (r10 <= 0) goto L5;
        return;
    L5:
        throw new IllegalArgumentException("fieldNumber must be positive: " + r10);
    }

    public static FieldInfo forExplicitPresenceField(java.lang.reflect.Field r15, int r16, FieldType r17, java.lang.reflect.Field r18, int r19, boolean r20, Internal.EnumVerifier r21) {
        checkFieldNumber(r16);
        Internal.checkNotNull(r15, "field");
        Internal.checkNotNull(r17, "fieldType");
        Internal.checkNotNull(r18, "presenceField");
        if (r18 == null) goto L10;
        if (isExactlyOneBitSet(r19) == true) goto L10;
        throw new IllegalArgumentException("presenceMask must have exactly one bit set: " + r19);
    L10:
        return new FieldInfo(r15, r16, r17, null, r18, r19, false, r20, null, null, null, r21, null);
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
        checkFieldNumber(r16);
        Internal.checkNotNull(r15, "field");
        return new FieldInfo(r15, r16, r17, null, null, 0, false, false, null, null, null, r18, null);
    }

    public static FieldInfo forLegacyRequiredField(java.lang.reflect.Field r15, int r16, FieldType r17, java.lang.reflect.Field r18, int r19, boolean r20, Internal.EnumVerifier r21) {
        checkFieldNumber(r16);
        Internal.checkNotNull(r15, "field");
        Internal.checkNotNull(r17, "fieldType");
        Internal.checkNotNull(r18, "presenceField");
        if (r18 == null) goto L10;
        if (isExactlyOneBitSet(r19) == true) goto L10;
        throw new IllegalArgumentException("presenceMask must have exactly one bit set: " + r19);
    L10:
        return new FieldInfo(r15, r16, r17, null, r18, r19, true, r20, null, null, null, r21, null);
    }

    public static FieldInfo forMapField(java.lang.reflect.Field r15, int r16, Object r17, Internal.EnumVerifier r18) {
        Internal.checkNotNull(r17, "mapDefaultEntry");
        checkFieldNumber(r16);
        Internal.checkNotNull(r15, "field");
        return new FieldInfo(r15, r16, FieldType.MAP, null, null, 0, false, true, null, null, r17, r18, null);
    }

    public static FieldInfo forOneofMemberField(int r15, FieldType r16, OneofInfo r17, Class<?> r18, boolean r19, Internal.EnumVerifier r20) {
        checkFieldNumber(r15);
        Internal.checkNotNull(r16, "fieldType");
        Internal.checkNotNull(r17, "oneof");
        Internal.checkNotNull(r18, "oneofStoredType");
        if (r16.isScalar() == false) goto L7;
        return new FieldInfo(null, r15, r16, null, null, 0, false, r19, r17, r18, null, r20, null);
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
        checkFieldNumber(r16);
        Internal.checkNotNull(r15, "field");
        return new FieldInfo(r15, r16, r17, null, null, 0, false, false, null, null, null, r18, r19);
    }

    public static FieldInfo forRepeatedMessageField(java.lang.reflect.Field r15, int r16, FieldType r17, Class<?> r18) {
        checkFieldNumber(r16);
        Internal.checkNotNull(r15, "field");
        Internal.checkNotNull(r17, "fieldType");
        Internal.checkNotNull(r18, "messageClass");
        return new FieldInfo(r15, r16, r17, r18, null, 0, false, false, null, null, null, null, null);
    }

    private static boolean isExactlyOneBitSet(int r10) {
        if (r10 != 0) goto L4;
    L6:
        return false;
    L4:
        if ((r10 & (r10 - 1)) != 0) goto L6;
        return true;
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(FieldInfo r10) {
        return this.fieldNumber - r10.fieldNumber;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(FieldInfo r10) {
        return compareTo2(r10);
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
        int r10 = AnonymousClass1.$SwitchMap$com$google$protobuf$FieldType[this.type.ordinal()];
        if (r10 != 1) goto L5;
    L14:
        java.lang.reflect.Field r11 = this.field;
        if (r11 == null) goto L18;
        return r11.getType();
    L18:
        return this.oneofStoredType;
    L5:
        if (r10 == 2) goto L14;
        if (r10 == 3) goto L13;
        if (r10 == 4) goto L13;
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
