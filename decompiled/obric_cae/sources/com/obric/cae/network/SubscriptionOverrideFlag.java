package com.obric.cae.network;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* JADX INFO: loaded from: classes.dex */
public final enum SubscriptionOverrideFlag extends Enum<SubscriptionOverrideFlag> implements ProtocolMessageEnum {
    private static final /* synthetic */ SubscriptionOverrideFlag[] $VALUES = null;
    public static final SubscriptionOverrideFlag SUBSCRIPTION_OVERRIDE_CONGESTED = null;
    public static final int SUBSCRIPTION_OVERRIDE_CONGESTED_VALUE = 2;
    public static final SubscriptionOverrideFlag SUBSCRIPTION_OVERRIDE_FLAG_UNSPECIFIED = null;
    public static final int SUBSCRIPTION_OVERRIDE_FLAG_UNSPECIFIED_VALUE = 0;
    public static final SubscriptionOverrideFlag SUBSCRIPTION_OVERRIDE_UNMETERED = null;
    public static final int SUBSCRIPTION_OVERRIDE_UNMETERED_VALUE = 1;
    private static final SubscriptionOverrideFlag[] VALUES = null;
    private static final Internal.EnumLiteMap<SubscriptionOverrideFlag> internalValueMap = null;
    private final int value;

    private static /* synthetic */ SubscriptionOverrideFlag[] $values() {
        return new SubscriptionOverrideFlag[]{SUBSCRIPTION_OVERRIDE_FLAG_UNSPECIFIED, SUBSCRIPTION_OVERRIDE_UNMETERED, SUBSCRIPTION_OVERRIDE_CONGESTED};
    }

    static {
        SUBSCRIPTION_OVERRIDE_FLAG_UNSPECIFIED = new SubscriptionOverrideFlag("SUBSCRIPTION_OVERRIDE_FLAG_UNSPECIFIED", 0, 0);
        SUBSCRIPTION_OVERRIDE_UNMETERED = new SubscriptionOverrideFlag("SUBSCRIPTION_OVERRIDE_UNMETERED", 1, 1);
        SUBSCRIPTION_OVERRIDE_CONGESTED = new SubscriptionOverrideFlag("SUBSCRIPTION_OVERRIDE_CONGESTED", 2, 2);
        $VALUES = $values();
        internalValueMap = new AnonymousClass1();
        VALUES = values();
    }

    private SubscriptionOverrideFlag(String r8, int r10, int r11) {
        super(r8, r10);
        this.value = r11;
    }

    public static SubscriptionOverrideFlag forNumber(int r8) {
        if (r8 == 0) goto L14;
        if (r8 == 1) goto L12;
        if (r8 == 2) goto L10;
        return null;
    L10:
        return SUBSCRIPTION_OVERRIDE_CONGESTED;
    L12:
        return SUBSCRIPTION_OVERRIDE_UNMETERED;
    L14:
        return SUBSCRIPTION_OVERRIDE_FLAG_UNSPECIFIED;
    }

    public static final Descriptors.EnumDescriptor getDescriptor() {
        return CaeNetpolicyEvent.getDescriptor().getEnumTypes().get(2);
    }

    public static Internal.EnumLiteMap<SubscriptionOverrideFlag> internalGetValueMap() {
        return internalValueMap;
    }

    @Deprecated
    public static SubscriptionOverrideFlag valueOf(int r8) {
        return forNumber(r8);
    }

    public static SubscriptionOverrideFlag[] values() {
        return (SubscriptionOverrideFlag[]) $VALUES.clone();
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

    public static SubscriptionOverrideFlag valueOf(Descriptors.EnumValueDescriptor r8) {
        if (r8.getType() != getDescriptor()) goto L7;
        return VALUES[r8.getIndex()];
    L7:
        throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
    }

    public static SubscriptionOverrideFlag valueOf(String r8) {
        return (SubscriptionOverrideFlag) Enum.valueOf(SubscriptionOverrideFlag.class, r8);
    }
}
