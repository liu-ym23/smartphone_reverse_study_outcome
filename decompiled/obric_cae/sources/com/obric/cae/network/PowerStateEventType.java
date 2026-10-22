package com.obric.cae.network;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* JADX INFO: loaded from: classes.dex */
public final enum PowerStateEventType extends Enum<PowerStateEventType> implements ProtocolMessageEnum {
    private static final /* synthetic */ PowerStateEventType[] $VALUES = null;
    public static final PowerStateEventType POWER_STATE_EVENT_TYPE_DOZE_MODE = null;
    public static final int POWER_STATE_EVENT_TYPE_DOZE_MODE_VALUE = 2;
    public static final PowerStateEventType POWER_STATE_EVENT_TYPE_POWER_SAVE_MODE = null;
    public static final int POWER_STATE_EVENT_TYPE_POWER_SAVE_MODE_VALUE = 1;
    public static final PowerStateEventType POWER_STATE_EVENT_TYPE_SCREEN_STATE = null;
    public static final int POWER_STATE_EVENT_TYPE_SCREEN_STATE_VALUE = 3;
    public static final PowerStateEventType POWER_STATE_EVENT_TYPE_UNSPECIFIED = null;
    public static final int POWER_STATE_EVENT_TYPE_UNSPECIFIED_VALUE = 0;
    private static final PowerStateEventType[] VALUES = null;
    private static final Internal.EnumLiteMap<PowerStateEventType> internalValueMap = null;
    private final int value;

    private static /* synthetic */ PowerStateEventType[] $values() {
        return new PowerStateEventType[]{POWER_STATE_EVENT_TYPE_UNSPECIFIED, POWER_STATE_EVENT_TYPE_POWER_SAVE_MODE, POWER_STATE_EVENT_TYPE_DOZE_MODE, POWER_STATE_EVENT_TYPE_SCREEN_STATE};
    }

    static {
        POWER_STATE_EVENT_TYPE_UNSPECIFIED = new PowerStateEventType("POWER_STATE_EVENT_TYPE_UNSPECIFIED", 0, 0);
        POWER_STATE_EVENT_TYPE_POWER_SAVE_MODE = new PowerStateEventType("POWER_STATE_EVENT_TYPE_POWER_SAVE_MODE", 1, 1);
        POWER_STATE_EVENT_TYPE_DOZE_MODE = new PowerStateEventType("POWER_STATE_EVENT_TYPE_DOZE_MODE", 2, 2);
        POWER_STATE_EVENT_TYPE_SCREEN_STATE = new PowerStateEventType("POWER_STATE_EVENT_TYPE_SCREEN_STATE", 3, 3);
        $VALUES = $values();
        internalValueMap = new AnonymousClass1();
        VALUES = values();
    }

    private PowerStateEventType(String r8, int r10, int r11) {
        super(r8, r10);
        this.value = r11;
    }

    public static PowerStateEventType forNumber(int r8) {
        if (r8 == 0) goto L18;
        if (r8 == 1) goto L16;
        if (r8 == 2) goto L14;
        if (r8 == 3) goto L12;
        return null;
    L12:
        return POWER_STATE_EVENT_TYPE_SCREEN_STATE;
    L14:
        return POWER_STATE_EVENT_TYPE_DOZE_MODE;
    L16:
        return POWER_STATE_EVENT_TYPE_POWER_SAVE_MODE;
    L18:
        return POWER_STATE_EVENT_TYPE_UNSPECIFIED;
    }

    public static final Descriptors.EnumDescriptor getDescriptor() {
        return CaeNetpolicyEvent.getDescriptor().getEnumTypes().get(5);
    }

    public static Internal.EnumLiteMap<PowerStateEventType> internalGetValueMap() {
        return internalValueMap;
    }

    @Deprecated
    public static PowerStateEventType valueOf(int r8) {
        return forNumber(r8);
    }

    public static PowerStateEventType[] values() {
        return (PowerStateEventType[]) $VALUES.clone();
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

    public static PowerStateEventType valueOf(Descriptors.EnumValueDescriptor r8) {
        if (r8.getType() != getDescriptor()) goto L7;
        return VALUES[r8.getIndex()];
    L7:
        throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
    }

    public static PowerStateEventType valueOf(String r8) {
        return (PowerStateEventType) Enum.valueOf(PowerStateEventType.class, r8);
    }
}
