package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
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
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 31, 1, "", Syntax.class.getName());
        internalValueMap = new AnonymousClass1();
        VALUES = values();
    }

    private Syntax(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static Syntax forNumber(int r1) {
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L10;
        return null;
    L10:
        return SYNTAX_EDITIONS;
    L12:
        return SYNTAX_PROTO3;
    L14:
        return SYNTAX_PROTO2;
    }

    public static Descriptors.EnumDescriptor getDescriptor() {
        return (Descriptors.EnumDescriptor) ZeusTransformUtils.preCheckCast(TypeProto.getDescriptor().getEnumTypes().get(0), Descriptors.EnumDescriptor.class, "com.obric.memorydata.plugin");
    }

    public static Internal.EnumLiteMap<Syntax> internalGetValueMap() {
        return internalValueMap;
    }

    @Deprecated
    public static Syntax valueOf(int r0) {
        return forNumber(r0);
    }

    public static Syntax valueOf(Descriptors.EnumValueDescriptor r2) {
        if (r2.getType() != getDescriptor()) goto L11;
        if (r2.getIndex() != (-1)) goto L9;
        return UNRECOGNIZED;
    L9:
        return VALUES[r2.getIndex()];
    L11:
        throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
    }

    public static Syntax valueOf(String r2) {
        return (Syntax) ZeusTransformUtils.preCheckCast(java.lang.Enum.valueOf(Syntax.class, r2), Syntax.class, "com.obric.memorydata.plugin");
    }

    public static Syntax[] values() {
        return (Syntax[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Syntax[].class, "com.obric.memorydata.plugin");
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
        return (Descriptors.EnumValueDescriptor) ZeusTransformUtils.preCheckCast(getDescriptor().getValues().get(ordinal()), Descriptors.EnumValueDescriptor.class, "com.obric.memorydata.plugin");
    L7:
        throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
    }
}
