package com.obric.cae.network;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* JADX INFO: loaded from: classes.dex */
public final enum UidRule extends Enum<UidRule> implements ProtocolMessageEnum {
    private static final /* synthetic */ UidRule[] $VALUES = null;
    public static final UidRule RULE_ALLOW_ALL = null;
    public static final int RULE_ALLOW_ALL_VALUE = 32;
    public static final UidRule RULE_ALLOW_METERED = null;
    public static final int RULE_ALLOW_METERED_VALUE = 1;
    public static final UidRule RULE_NONE = null;
    public static final int RULE_NONE_VALUE = 0;
    public static final UidRule RULE_REJECT_ALL = null;
    public static final UidRule RULE_REJECT_ALL_BG = null;
    public static final int RULE_REJECT_ALL_BG_VALUE = 128;
    public static final int RULE_REJECT_ALL_VALUE = 64;
    public static final UidRule RULE_REJECT_METERED = null;
    public static final int RULE_REJECT_METERED_VALUE = 4;
    public static final UidRule RULE_REJECT_RESTRICTED_MODE = null;
    public static final int RULE_REJECT_RESTRICTED_MODE_VALUE = 1024;
    public static final UidRule RULE_TEMPORARY_ALLOW_METERED = null;
    public static final int RULE_TEMPORARY_ALLOW_METERED_VALUE = 2;
    private static final UidRule[] VALUES = null;
    private static final Internal.EnumLiteMap<UidRule> internalValueMap = null;
    private final int value;

    private static /* synthetic */ UidRule[] $values() {
        return new UidRule[]{RULE_NONE, RULE_ALLOW_METERED, RULE_TEMPORARY_ALLOW_METERED, RULE_REJECT_METERED, RULE_ALLOW_ALL, RULE_REJECT_ALL, RULE_REJECT_ALL_BG, RULE_REJECT_RESTRICTED_MODE};
    }

    static {
        RULE_NONE = new UidRule("RULE_NONE", 0, 0);
        RULE_ALLOW_METERED = new UidRule("RULE_ALLOW_METERED", 1, 1);
        RULE_TEMPORARY_ALLOW_METERED = new UidRule("RULE_TEMPORARY_ALLOW_METERED", 2, 2);
        RULE_REJECT_METERED = new UidRule("RULE_REJECT_METERED", 3, 4);
        RULE_ALLOW_ALL = new UidRule("RULE_ALLOW_ALL", 4, 32);
        RULE_REJECT_ALL = new UidRule("RULE_REJECT_ALL", 5, 64);
        RULE_REJECT_ALL_BG = new UidRule("RULE_REJECT_ALL_BG", 6, 128);
        RULE_REJECT_RESTRICTED_MODE = new UidRule("RULE_REJECT_RESTRICTED_MODE", 7, 1024);
        $VALUES = $values();
        internalValueMap = new AnonymousClass1();
        VALUES = values();
    }

    private UidRule(String r8, int r10, int r11) {
        super(r8, r10);
        this.value = r11;
    }

    public static UidRule forNumber(int r8) {
        if (r8 == 0) goto L34;
        if (r8 == 1) goto L32;
        if (r8 == 2) goto L30;
        if (r8 == 4) goto L28;
        if (r8 == 32) goto L26;
        if (r8 == 64) goto L24;
        if (r8 == 128) goto L22;
        if (r8 == 1024) goto L20;
        return null;
    L20:
        return RULE_REJECT_RESTRICTED_MODE;
    L22:
        return RULE_REJECT_ALL_BG;
    L24:
        return RULE_REJECT_ALL;
    L26:
        return RULE_ALLOW_ALL;
    L28:
        return RULE_REJECT_METERED;
    L30:
        return RULE_TEMPORARY_ALLOW_METERED;
    L32:
        return RULE_ALLOW_METERED;
    L34:
        return RULE_NONE;
    }

    public static final Descriptors.EnumDescriptor getDescriptor() {
        return CaeNetpolicyEvent.getDescriptor().getEnumTypes().get(0);
    }

    public static Internal.EnumLiteMap<UidRule> internalGetValueMap() {
        return internalValueMap;
    }

    @Deprecated
    public static UidRule valueOf(int r8) {
        return forNumber(r8);
    }

    public static UidRule[] values() {
        return (UidRule[]) $VALUES.clone();
    }

    @Override // com.google.protobuf.ProtocolMessageEnum
    public final Descriptors.EnumDescriptor getDescriptorForType() {
        return getDescriptor();
    }

    @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Override // com.google.protobuf.ProtocolMessageEnum
    public final Descriptors.EnumValueDescriptor getValueDescriptor() {
        return getDescriptor().getValues().get(ordinal());
    }

    public static UidRule valueOf(Descriptors.EnumValueDescriptor r8) {
        if (r8.getType() != getDescriptor()) goto L7;
        return VALUES[r8.getIndex()];
    L7:
        throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
    }

    public static UidRule valueOf(String r8) {
        return (UidRule) Enum.valueOf(UidRule.class, r8);
    }
}
