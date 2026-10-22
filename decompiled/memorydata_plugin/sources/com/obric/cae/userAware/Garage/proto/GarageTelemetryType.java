package com.obric.cae.userAware.Garage.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final enum GarageTelemetryType extends Enum<GarageTelemetryType> implements ProtocolMessageEnum {
    private static final /* synthetic */ GarageTelemetryType[] $VALUES = null;
    public static final GarageTelemetryType GARAGE_TELEMETRY_TYPE_RAW_WINDOW = null;
    public static final int GARAGE_TELEMETRY_TYPE_RAW_WINDOW_VALUE = 1;
    public static final GarageTelemetryType GARAGE_TELEMETRY_TYPE_SCAN_FEATURE = null;
    public static final int GARAGE_TELEMETRY_TYPE_SCAN_FEATURE_VALUE = 2;
    public static final GarageTelemetryType GARAGE_TELEMETRY_TYPE_UNKNOWN = null;
    public static final int GARAGE_TELEMETRY_TYPE_UNKNOWN_VALUE = 0;
    private static final GarageTelemetryType[] VALUES = null;
    private static final Internal.EnumLiteMap<GarageTelemetryType> internalValueMap = null;
    private final int value;

    private static /* synthetic */ GarageTelemetryType[] $values() {
        return new GarageTelemetryType[]{GARAGE_TELEMETRY_TYPE_UNKNOWN, GARAGE_TELEMETRY_TYPE_RAW_WINDOW, GARAGE_TELEMETRY_TYPE_SCAN_FEATURE};
    }

    static {
        GARAGE_TELEMETRY_TYPE_UNKNOWN = new GarageTelemetryType("GARAGE_TELEMETRY_TYPE_UNKNOWN", 0, 0);
        GARAGE_TELEMETRY_TYPE_RAW_WINDOW = new GarageTelemetryType("GARAGE_TELEMETRY_TYPE_RAW_WINDOW", 1, 1);
        GARAGE_TELEMETRY_TYPE_SCAN_FEATURE = new GarageTelemetryType("GARAGE_TELEMETRY_TYPE_SCAN_FEATURE", 2, 2);
        $VALUES = $values();
        internalValueMap = new AnonymousClass1();
        VALUES = values();
    }

    private GarageTelemetryType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static GarageTelemetryType forNumber(int r1) {
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L10;
        return null;
    L10:
        return GARAGE_TELEMETRY_TYPE_SCAN_FEATURE;
    L12:
        return GARAGE_TELEMETRY_TYPE_RAW_WINDOW;
    L14:
        return GARAGE_TELEMETRY_TYPE_UNKNOWN;
    }

    public static final Descriptors.EnumDescriptor getDescriptor() {
        return (Descriptors.EnumDescriptor) ZeusTransformUtils.preCheckCast(GarageDetectProto.getDescriptor().getEnumTypes().get(2), Descriptors.EnumDescriptor.class, "com.obric.memorydata.plugin");
    }

    public static Internal.EnumLiteMap<GarageTelemetryType> internalGetValueMap() {
        return internalValueMap;
    }

    @Deprecated
    public static GarageTelemetryType valueOf(int r0) {
        return forNumber(r0);
    }

    public static GarageTelemetryType valueOf(Descriptors.EnumValueDescriptor r2) {
        if (r2.getType() != getDescriptor()) goto L7;
        return VALUES[r2.getIndex()];
    L7:
        throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
    }

    public static GarageTelemetryType valueOf(String r2) {
        return (GarageTelemetryType) ZeusTransformUtils.preCheckCast(Enum.valueOf(GarageTelemetryType.class, r2), GarageTelemetryType.class, "com.obric.memorydata.plugin");
    }

    public static GarageTelemetryType[] values() {
        return (GarageTelemetryType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), GarageTelemetryType[].class, "com.obric.memorydata.plugin");
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
        return (Descriptors.EnumValueDescriptor) ZeusTransformUtils.preCheckCast(getDescriptor().getValues().get(ordinal()), Descriptors.EnumValueDescriptor.class, "com.obric.memorydata.plugin");
    }
}
