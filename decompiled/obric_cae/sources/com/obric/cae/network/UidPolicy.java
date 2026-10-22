package com.obric.cae.network;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* JADX INFO: loaded from: classes.dex */
public final enum UidPolicy extends Enum<UidPolicy> implements ProtocolMessageEnum {
    private static final /* synthetic */ UidPolicy[] $VALUES = null;
    public static final UidPolicy POLICY_ALLOW_METERED_BACKGROUND = null;
    public static final int POLICY_ALLOW_METERED_BACKGROUND_VALUE = 4;
    public static final UidPolicy POLICY_NONE = null;
    public static final int POLICY_NONE_VALUE = 0;
    public static final UidPolicy POLICY_REJECT_ALL_BACKGROUND = null;
    public static final UidPolicy POLICY_REJECT_ALL_BACKGROUND_SCREEN_OFF = null;
    public static final int POLICY_REJECT_ALL_BACKGROUND_SCREEN_OFF_VALUE = 8;
    public static final int POLICY_REJECT_ALL_BACKGROUND_VALUE = 16;
    public static final UidPolicy POLICY_REJECT_METERED_BACKGROUND = null;
    public static final int POLICY_REJECT_METERED_BACKGROUND_VALUE = 1;
    private static final UidPolicy[] VALUES = null;
    private static final Internal.EnumLiteMap<UidPolicy> internalValueMap = null;
    private final int value;

    private static /* synthetic */ UidPolicy[] $values() {
        return new UidPolicy[]{POLICY_NONE, POLICY_REJECT_METERED_BACKGROUND, POLICY_ALLOW_METERED_BACKGROUND, POLICY_REJECT_ALL_BACKGROUND_SCREEN_OFF, POLICY_REJECT_ALL_BACKGROUND};
    }

    static {
        POLICY_NONE = new UidPolicy("POLICY_NONE", 0, 0);
        POLICY_REJECT_METERED_BACKGROUND = new UidPolicy("POLICY_REJECT_METERED_BACKGROUND", 1, 1);
        POLICY_ALLOW_METERED_BACKGROUND = new UidPolicy("POLICY_ALLOW_METERED_BACKGROUND", 2, 4);
        POLICY_REJECT_ALL_BACKGROUND_SCREEN_OFF = new UidPolicy("POLICY_REJECT_ALL_BACKGROUND_SCREEN_OFF", 3, 8);
        POLICY_REJECT_ALL_BACKGROUND = new UidPolicy("POLICY_REJECT_ALL_BACKGROUND", 4, 16);
        $VALUES = $values();
        internalValueMap = new AnonymousClass1();
        VALUES = values();
    }

    private UidPolicy(String r8, int r10, int r11) {
        super(r8, r10);
        this.value = r11;
    }

    public static UidPolicy forNumber(int r8) {
        if (r8 == 0) goto L22;
        if (r8 == 1) goto L20;
        if (r8 == 4) goto L18;
        if (r8 == 8) goto L16;
        if (r8 == 16) goto L14;
        return null;
    L14:
        return POLICY_REJECT_ALL_BACKGROUND;
    L16:
        return POLICY_REJECT_ALL_BACKGROUND_SCREEN_OFF;
    L18:
        return POLICY_ALLOW_METERED_BACKGROUND;
    L20:
        return POLICY_REJECT_METERED_BACKGROUND;
    L22:
        return POLICY_NONE;
    }

    public static final Descriptors.EnumDescriptor getDescriptor() {
        return CaeNetpolicyEvent.getDescriptor().getEnumTypes().get(1);
    }

    public static Internal.EnumLiteMap<UidPolicy> internalGetValueMap() {
        return internalValueMap;
    }

    @Deprecated
    public static UidPolicy valueOf(int r8) {
        return forNumber(r8);
    }

    public static UidPolicy[] values() {
        return (UidPolicy[]) $VALUES.clone();
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

    public static UidPolicy valueOf(Descriptors.EnumValueDescriptor r8) {
        if (r8.getType() != getDescriptor()) goto L7;
        return VALUES[r8.getIndex()];
    L7:
        throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
    }

    public static UidPolicy valueOf(String r8) {
        return (UidPolicy) Enum.valueOf(UidPolicy.class, r8);
    }
}
