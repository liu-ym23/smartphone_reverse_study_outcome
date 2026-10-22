package com.obric.cae.userAware.Garage.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final enum GarageApScanStatus extends Enum<GarageApScanStatus> implements ProtocolMessageEnum {
    private static final /* synthetic */ GarageApScanStatus[] $VALUES = null;
    public static final GarageApScanStatus GARAGE_AP_SCAN_STATUS_CANCELLED = null;
    public static final int GARAGE_AP_SCAN_STATUS_CANCELLED_VALUE = 5;
    public static final GarageApScanStatus GARAGE_AP_SCAN_STATUS_PERMISSION_DENIED = null;
    public static final int GARAGE_AP_SCAN_STATUS_PERMISSION_DENIED_VALUE = 3;
    public static final GarageApScanStatus GARAGE_AP_SCAN_STATUS_SCANNER_UNAVAILABLE = null;
    public static final int GARAGE_AP_SCAN_STATUS_SCANNER_UNAVAILABLE_VALUE = 1;
    public static final GarageApScanStatus GARAGE_AP_SCAN_STATUS_SCAN_FAILED = null;
    public static final int GARAGE_AP_SCAN_STATUS_SCAN_FAILED_VALUE = 2;
    public static final GarageApScanStatus GARAGE_AP_SCAN_STATUS_SUCCESS = null;
    public static final int GARAGE_AP_SCAN_STATUS_SUCCESS_VALUE = 0;
    public static final GarageApScanStatus GARAGE_AP_SCAN_STATUS_TIMEOUT = null;
    public static final int GARAGE_AP_SCAN_STATUS_TIMEOUT_VALUE = 4;
    private static final GarageApScanStatus[] VALUES = null;
    private static final Internal.EnumLiteMap<GarageApScanStatus> internalValueMap = null;
    private final int value;

    private static /* synthetic */ GarageApScanStatus[] $values() {
        return new GarageApScanStatus[]{GARAGE_AP_SCAN_STATUS_SUCCESS, GARAGE_AP_SCAN_STATUS_SCANNER_UNAVAILABLE, GARAGE_AP_SCAN_STATUS_SCAN_FAILED, GARAGE_AP_SCAN_STATUS_PERMISSION_DENIED, GARAGE_AP_SCAN_STATUS_TIMEOUT, GARAGE_AP_SCAN_STATUS_CANCELLED};
    }

    static {
        GARAGE_AP_SCAN_STATUS_SUCCESS = new GarageApScanStatus("GARAGE_AP_SCAN_STATUS_SUCCESS", 0, 0);
        GARAGE_AP_SCAN_STATUS_SCANNER_UNAVAILABLE = new GarageApScanStatus("GARAGE_AP_SCAN_STATUS_SCANNER_UNAVAILABLE", 1, 1);
        GARAGE_AP_SCAN_STATUS_SCAN_FAILED = new GarageApScanStatus("GARAGE_AP_SCAN_STATUS_SCAN_FAILED", 2, 2);
        GARAGE_AP_SCAN_STATUS_PERMISSION_DENIED = new GarageApScanStatus("GARAGE_AP_SCAN_STATUS_PERMISSION_DENIED", 3, 3);
        GARAGE_AP_SCAN_STATUS_TIMEOUT = new GarageApScanStatus("GARAGE_AP_SCAN_STATUS_TIMEOUT", 4, 4);
        GARAGE_AP_SCAN_STATUS_CANCELLED = new GarageApScanStatus("GARAGE_AP_SCAN_STATUS_CANCELLED", 5, 5);
        $VALUES = $values();
        internalValueMap = new AnonymousClass1();
        VALUES = values();
    }

    private GarageApScanStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static GarageApScanStatus forNumber(int r1) {
        if (r1 == 0) goto L26;
        if (r1 == 1) goto L24;
        if (r1 == 2) goto L22;
        if (r1 == 3) goto L20;
        if (r1 == 4) goto L18;
        if (r1 == 5) goto L16;
        return null;
    L16:
        return GARAGE_AP_SCAN_STATUS_CANCELLED;
    L18:
        return GARAGE_AP_SCAN_STATUS_TIMEOUT;
    L20:
        return GARAGE_AP_SCAN_STATUS_PERMISSION_DENIED;
    L22:
        return GARAGE_AP_SCAN_STATUS_SCAN_FAILED;
    L24:
        return GARAGE_AP_SCAN_STATUS_SCANNER_UNAVAILABLE;
    L26:
        return GARAGE_AP_SCAN_STATUS_SUCCESS;
    }

    public static final Descriptors.EnumDescriptor getDescriptor() {
        return (Descriptors.EnumDescriptor) ZeusTransformUtils.preCheckCast(GarageDetectProto.getDescriptor().getEnumTypes().get(1), Descriptors.EnumDescriptor.class, "com.obric.memorydata.plugin");
    }

    public static Internal.EnumLiteMap<GarageApScanStatus> internalGetValueMap() {
        return internalValueMap;
    }

    @Deprecated
    public static GarageApScanStatus valueOf(int r0) {
        return forNumber(r0);
    }

    public static GarageApScanStatus valueOf(Descriptors.EnumValueDescriptor r2) {
        if (r2.getType() != getDescriptor()) goto L7;
        return VALUES[r2.getIndex()];
    L7:
        throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
    }

    public static GarageApScanStatus valueOf(String r2) {
        return (GarageApScanStatus) ZeusTransformUtils.preCheckCast(Enum.valueOf(GarageApScanStatus.class, r2), GarageApScanStatus.class, "com.obric.memorydata.plugin");
    }

    public static GarageApScanStatus[] values() {
        return (GarageApScanStatus[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), GarageApScanStatus[].class, "com.obric.memorydata.plugin");
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
