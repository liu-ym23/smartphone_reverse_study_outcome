package com.obric.cae.userAware.Garage.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final enum GarageReportReason extends Enum<GarageReportReason> implements ProtocolMessageEnum {
    private static final /* synthetic */ GarageReportReason[] $VALUES = null;
    public static final GarageReportReason GARAGE_REPORT_REASON_AP_DONE = null;
    public static final int GARAGE_REPORT_REASON_AP_DONE_VALUE = 3;
    public static final GarageReportReason GARAGE_REPORT_REASON_ERROR = null;
    public static final int GARAGE_REPORT_REASON_ERROR_VALUE = 4;
    public static final GarageReportReason GARAGE_REPORT_REASON_RUNTIME_STATE_CHANGED = null;
    public static final int GARAGE_REPORT_REASON_RUNTIME_STATE_CHANGED_VALUE = 5;
    public static final GarageReportReason GARAGE_REPORT_REASON_TRIGGERED = null;
    public static final int GARAGE_REPORT_REASON_TRIGGERED_VALUE = 1;
    public static final GarageReportReason GARAGE_REPORT_REASON_UNKNOWN = null;
    public static final int GARAGE_REPORT_REASON_UNKNOWN_VALUE = 0;
    public static final GarageReportReason GARAGE_REPORT_REASON_WIFI_DONE = null;
    public static final int GARAGE_REPORT_REASON_WIFI_DONE_VALUE = 2;
    private static final GarageReportReason[] VALUES = null;
    private static final Internal.EnumLiteMap<GarageReportReason> internalValueMap = null;
    private final int value;

    private static /* synthetic */ GarageReportReason[] $values() {
        return new GarageReportReason[]{GARAGE_REPORT_REASON_UNKNOWN, GARAGE_REPORT_REASON_TRIGGERED, GARAGE_REPORT_REASON_WIFI_DONE, GARAGE_REPORT_REASON_AP_DONE, GARAGE_REPORT_REASON_ERROR, GARAGE_REPORT_REASON_RUNTIME_STATE_CHANGED};
    }

    static {
        GARAGE_REPORT_REASON_UNKNOWN = new GarageReportReason("GARAGE_REPORT_REASON_UNKNOWN", 0, 0);
        GARAGE_REPORT_REASON_TRIGGERED = new GarageReportReason("GARAGE_REPORT_REASON_TRIGGERED", 1, 1);
        GARAGE_REPORT_REASON_WIFI_DONE = new GarageReportReason("GARAGE_REPORT_REASON_WIFI_DONE", 2, 2);
        GARAGE_REPORT_REASON_AP_DONE = new GarageReportReason("GARAGE_REPORT_REASON_AP_DONE", 3, 3);
        GARAGE_REPORT_REASON_ERROR = new GarageReportReason("GARAGE_REPORT_REASON_ERROR", 4, 4);
        GARAGE_REPORT_REASON_RUNTIME_STATE_CHANGED = new GarageReportReason("GARAGE_REPORT_REASON_RUNTIME_STATE_CHANGED", 5, 5);
        $VALUES = $values();
        internalValueMap = new AnonymousClass1();
        VALUES = values();
    }

    private GarageReportReason(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static GarageReportReason forNumber(int r1) {
        if (r1 == 0) goto L26;
        if (r1 == 1) goto L24;
        if (r1 == 2) goto L22;
        if (r1 == 3) goto L20;
        if (r1 == 4) goto L18;
        if (r1 == 5) goto L16;
        return null;
    L16:
        return GARAGE_REPORT_REASON_RUNTIME_STATE_CHANGED;
    L18:
        return GARAGE_REPORT_REASON_ERROR;
    L20:
        return GARAGE_REPORT_REASON_AP_DONE;
    L22:
        return GARAGE_REPORT_REASON_WIFI_DONE;
    L24:
        return GARAGE_REPORT_REASON_TRIGGERED;
    L26:
        return GARAGE_REPORT_REASON_UNKNOWN;
    }

    public static final Descriptors.EnumDescriptor getDescriptor() {
        return (Descriptors.EnumDescriptor) ZeusTransformUtils.preCheckCast(GarageDetectProto.getDescriptor().getEnumTypes().get(0), Descriptors.EnumDescriptor.class, "com.obric.memorydata.plugin");
    }

    public static Internal.EnumLiteMap<GarageReportReason> internalGetValueMap() {
        return internalValueMap;
    }

    @Deprecated
    public static GarageReportReason valueOf(int r0) {
        return forNumber(r0);
    }

    public static GarageReportReason valueOf(Descriptors.EnumValueDescriptor r2) {
        if (r2.getType() != getDescriptor()) goto L7;
        return VALUES[r2.getIndex()];
    L7:
        throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
    }

    public static GarageReportReason valueOf(String r2) {
        return (GarageReportReason) ZeusTransformUtils.preCheckCast(Enum.valueOf(GarageReportReason.class, r2), GarageReportReason.class, "com.obric.memorydata.plugin");
    }

    public static GarageReportReason[] values() {
        return (GarageReportReason[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), GarageReportReason[].class, "com.obric.memorydata.plugin");
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
