package com.google.protobuf;

/* JADX INFO: loaded from: classes.dex */
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
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$FieldType = null;

        static {
            int[] r8 = new int[FieldType.values().length];
            $SwitchMap$com$google$protobuf$FieldType = r8;
            r8[FieldType.MESSAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
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

        public /* synthetic */ Builder(AnonymousClass1 r8) {
            this();
        }

        public FieldInfo build() {
            OneofInfo r8 = this.oneof;
            if (r8 != null) goto L5;
            Object r10 = this.mapDefaultEntry;
            if (r10 != null) goto L9;
            java.lang.reflect.Field r11 = this.presenceField;
            if (r11 != null) goto L13;
            Internal.EnumVerifier r12 = this.enumVerifier;
            if (r12 == null) goto L26;
            java.lang.reflect.Field r13 = this.cachedSizeField;
            if (r13 != null) goto L25;
            return FieldInfo.forFieldWithEnumVerifier(this.field, this.fieldNumber, this.type, r12);
        L25:
            return FieldInfo.forPackedFieldWithEnumVerifier(this.field, this.fieldNumber, this.type, r12, r13);
        L26:
            java.lang.reflect.Field r14 = this.cachedSizeField;
            if (r14 != null) goto L31;
            return FieldInfo.forField(this.field, this.fieldNumber, this.type, this.enforceUtf8);
        L31:
            return FieldInfo.forPackedField(this.field, this.fieldNumber, this.type, r14);
        L13:
            if (this.required == false) goto L17;
            return FieldInfo.forLegacyRequiredField(this.field, this.fieldNumber, this.type, r11, this.presenceMask, this.enforceUtf8, this.enumVerifier);
        L17:
            return FieldInfo.forExplicitPresenceField(this.field, this.fieldNumber, this.type, r11, this.presenceMask, this.enforceUtf8, this.enumVerifier);
        L9:
            return FieldInfo.forMapField(this.field, this.fieldNumber, r10, this.enumVerifier);
        L5:
            return FieldInfo.forOneofMemberField(this.fieldNumber, this.type, r8, this.oneofStoredType, this.enforceUtf8, this.enumVerifier);
        }

        public Builder withCachedSizeField(java.lang.reflect.Field r8) {
            this.cachedSizeField = r8;
            return this;
        }

        public Builder withEnforceUtf8(boolean r8) {
            this.enforceUtf8 = r8;
            return this;
        }

        public Builder withEnumVerifier(Internal.EnumVerifier r8) {
            this.enumVerifier = r8;
            return this;
        }

        public Builder withField(java.lang.reflect.Field r8) {
            if (this.oneof != null) goto L7;
            this.field = r8;
            return this;
        L7:
            throw new IllegalStateException("Cannot set field when building a oneof.");
        }

        public Builder withFieldNumber(int r8) {
            this.fieldNumber = r8;
            return this;
        }

        public Builder withMapDefaultEntry(Object r8) {
            this.mapDefaultEntry = r8;
            return this;
        }

        public Builder withOneof(OneofInfo r8, Class<?> r10) {
            if (this.field != null) goto L9;
            if (this.presenceField != null) goto L9;
            this.oneof = r8;
            this.oneofStoredType = r10;
            return this;
        L9:
            throw new IllegalStateException("Cannot set oneof when field or presenceField have been provided");
        }

        public Builder withPresence(java.lang.reflect.Field r8, int r10) {
            this.presenceField = (java.lang.reflect.Field) Internal.checkNotNull(r8, "presenceField");
            this.presenceMask = r10;
            return this;
        }

        public Builder withRequired(boolean r8) {
            this.required = r8;
            return this;
        }

        public Builder withType(FieldType r8) {
            this.type = r8;
            return this;
        }
    }

    private FieldInfo(java.lang.reflect.Field r8, int r10, FieldType r11, Class<?> r12, java.lang.reflect.Field r13, int r14, boolean r15, boolean r16, OneofInfo r17, Class<?> r18, Object r19, Internal.EnumVerifier r110, java.lang.reflect.Field r111) {
        this.field = r8;
        this.type = r11;
        this.messageClass = r12;
        this.fieldNumber = r10;
        this.presenceField = r13;
        this.presenceMask = r14;
        this.required = r15;
        this.enforceUtf8 = r16;
        this.oneof = r17;
        this.oneofStoredType = r18;
        this.mapDefaultEntry = r19;
        this.enumVerifier = r110;
        this.cachedSizeField = r111;
    }

    private static void checkFieldNumber(int r8) {
        if (r8 <= 0) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(defpackage.a.d("fieldNumber must be positive: ", r8));
    }

    public static FieldInfo forExplicitPresenceField(java.lang.reflect.Field r15, int r16, FieldType r17, java.lang.reflect.Field r18, int r19, boolean r20, Internal.EnumVerifier r21) {
        checkFieldNumber(r16);
        Internal.checkNotNull(r15, "field");
        Internal.checkNotNull(r17, "fieldType");
        Internal.checkNotNull(r18, "presenceField");
        if (r18 == null) goto L10;
        if (isExactlyOneBitSet(r19) == true) goto L10;
        throw new IllegalArgumentException(defpackage.a.d("presenceMask must have exactly one bit set: ", r19));
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
        throw new IllegalArgumentException(defpackage.a.d("presenceMask must have exactly one bit set: ", r19));
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

    private static boolean isExactlyOneBitSet(int r8) {
        if (r8 != 0) goto L4;
    L6:
        return false;
    L4:
        if ((r8 & (r8 - 1)) != 0) goto L6;
        return true;
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(FieldInfo r8) {
        return this.fieldNumber - r8.fieldNumber;
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
        int r8 = AnonymousClass1.$SwitchMap$com$google$protobuf$FieldType[this.type.ordinal()];
        if (r8 != 1) goto L5;
    L14:
        java.lang.reflect.Field r10 = this.field;
        if (r10 == null) goto L18;
        return r10.getType();
    L18:
        return this.oneofStoredType;
    L5:
        if (r8 == 2) goto L14;
        if (r8 == 3) goto L13;
        if (r8 == 4) goto L13;
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

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(FieldInfo r8) {
        return compareTo2(r8);
    }
}
