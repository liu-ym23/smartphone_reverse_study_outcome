package com.google.protobuf;

/* JADX INFO: loaded from: classes.dex */
public final enum Syntax extends java.lang.Enum<Syntax> implements ProtocolMessageEnum {
    private static final /* synthetic */ Syntax[] $VALUES = null;
    public static final Syntax SYNTAX_EDITIONS = null;
    public static final int SYNTAX_EDITIONS_VALUE = 2;
    public static final Syntax SYNTAX_PROTO2 = null;
    public static final int SYNTAX_PROTO2_VALUE = 0;
    public static final Syntax SYNTAX_PROTO3 = null;
    public static final int SYNTAX_PROTO3_VALUE = 1;
    public static final Syntax UNRECOGNIZED = null;
    private static final Syntax[] VALUES = null;
    private static final Internal.EnumLiteMap<Syntax> internalValueMap = null;
    private final int value;

    private static /* synthetic */ Syntax[] $values() {
        return new Syntax[]{SYNTAX_PROTO2, SYNTAX_PROTO3, SYNTAX_EDITIONS, UNRECOGNIZED};
    }

    static {
        SYNTAX_PROTO2 = new Syntax("SYNTAX_PROTO2", 0, 0);
        SYNTAX_PROTO3 = new Syntax("SYNTAX_PROTO3", 1, 1);
        SYNTAX_EDITIONS = new Syntax("SYNTAX_EDITIONS", 2, 2);
        UNRECOGNIZED = new Syntax("UNRECOGNIZED", 3, -1);
        $VALUES = $values();
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 33, 4, "", "Syntax");
        internalValueMap = new AnonymousClass1();
        VALUES = values();
    }

    private Syntax(String r8, int r10, int r11) {
        super(r8, r10);
        this.value = r11;
    }

    public static Syntax forNumber(int r8) {
        if (r8 == 0) goto L14;
        if (r8 == 1) goto L12;
        if (r8 == 2) goto L10;
        return null;
    L10:
        return SYNTAX_EDITIONS;
    L12:
        return SYNTAX_PROTO3;
    L14:
        return SYNTAX_PROTO2;
    }

    public static Descriptors.EnumDescriptor getDescriptor() {
        return TypeProto.getDescriptor().getEnumTypes().get(0);
    }

    public static Internal.EnumLiteMap<Syntax> internalGetValueMap() {
        return internalValueMap;
    }

    @Deprecated
    public static Syntax valueOf(int r8) {
        return forNumber(r8);
    }

    public static Syntax[] values() {
        return (Syntax[]) $VALUES.clone();
    }

    @Override // com.google.protobuf.ProtocolMessageEnum
    public final Descriptors.EnumDescriptor getDescriptorForType() {
        return getDescriptor();
    }

    @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this == UNRECOGNIZED) goto L7;
        return this.value;
    L7:
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Override // com.google.protobuf.ProtocolMessageEnum
    public final Descriptors.EnumValueDescriptor getValueDescriptor() {
        if (this == UNRECOGNIZED) goto L7;
        return getDescriptor().getValues().get(ordinal());
    L7:
        throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
    }

    public static Syntax valueOf(Descriptors.EnumValueDescriptor r8) {
        if (r8.getType() != getDescriptor()) goto L11;
        if (r8.getIndex() != (-1)) goto L9;
        return UNRECOGNIZED;
    L9:
        return VALUES[r8.getIndex()];
    L11:
        throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
    }

    public static Syntax valueOf(String r8) {
        return (Syntax) java.lang.Enum.valueOf(Syntax.class, r8);
    }
}
