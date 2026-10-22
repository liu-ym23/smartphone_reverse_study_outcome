package com.obric.cae.network;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* JADX INFO: loaded from: classes.dex */
public final enum NetworkType extends Enum<NetworkType> implements ProtocolMessageEnum {
    private static final /* synthetic */ NetworkType[] $VALUES = null;
    public static final NetworkType NETWORK_TYPE_1xRTT = null;
    public static final int NETWORK_TYPE_1xRTT_VALUE = 7;
    public static final NetworkType NETWORK_TYPE_CDMA = null;
    public static final int NETWORK_TYPE_CDMA_VALUE = 4;
    public static final NetworkType NETWORK_TYPE_EDGE = null;
    public static final int NETWORK_TYPE_EDGE_VALUE = 2;
    public static final NetworkType NETWORK_TYPE_EHRPD = null;
    public static final int NETWORK_TYPE_EHRPD_VALUE = 14;
    public static final NetworkType NETWORK_TYPE_EVDO_0 = null;
    public static final int NETWORK_TYPE_EVDO_0_VALUE = 5;
    public static final NetworkType NETWORK_TYPE_EVDO_A = null;
    public static final int NETWORK_TYPE_EVDO_A_VALUE = 6;
    public static final NetworkType NETWORK_TYPE_EVDO_B = null;
    public static final int NETWORK_TYPE_EVDO_B_VALUE = 12;
    public static final NetworkType NETWORK_TYPE_GPRS = null;
    public static final int NETWORK_TYPE_GPRS_VALUE = 1;
    public static final NetworkType NETWORK_TYPE_GSM = null;
    public static final int NETWORK_TYPE_GSM_VALUE = 16;
    public static final NetworkType NETWORK_TYPE_HSDPA = null;
    public static final int NETWORK_TYPE_HSDPA_VALUE = 8;
    public static final NetworkType NETWORK_TYPE_HSPA = null;
    public static final NetworkType NETWORK_TYPE_HSPAP = null;
    public static final int NETWORK_TYPE_HSPAP_VALUE = 15;
    public static final int NETWORK_TYPE_HSPA_VALUE = 10;
    public static final NetworkType NETWORK_TYPE_HSUPA = null;
    public static final int NETWORK_TYPE_HSUPA_VALUE = 9;
    public static final NetworkType NETWORK_TYPE_IDEN = null;
    public static final int NETWORK_TYPE_IDEN_VALUE = 11;
    public static final NetworkType NETWORK_TYPE_IWLAN = null;
    public static final int NETWORK_TYPE_IWLAN_VALUE = 18;
    public static final NetworkType NETWORK_TYPE_LTE = null;
    public static final NetworkType NETWORK_TYPE_LTE_CA = null;
    public static final int NETWORK_TYPE_LTE_CA_VALUE = 19;
    public static final int NETWORK_TYPE_LTE_VALUE = 13;
    public static final NetworkType NETWORK_TYPE_NR = null;
    public static final int NETWORK_TYPE_NR_VALUE = 20;
    public static final NetworkType NETWORK_TYPE_TD_SCDMA = null;
    public static final int NETWORK_TYPE_TD_SCDMA_VALUE = 17;
    public static final NetworkType NETWORK_TYPE_UMTS = null;
    public static final int NETWORK_TYPE_UMTS_VALUE = 3;
    public static final NetworkType NETWORK_TYPE_UNSPECIFIED = null;
    public static final int NETWORK_TYPE_UNSPECIFIED_VALUE = 0;
    private static final NetworkType[] VALUES = null;
    private static final Internal.EnumLiteMap<NetworkType> internalValueMap = null;
    private final int value;

    private static /* synthetic */ NetworkType[] $values() {
        return new NetworkType[]{NETWORK_TYPE_UNSPECIFIED, NETWORK_TYPE_GPRS, NETWORK_TYPE_EDGE, NETWORK_TYPE_UMTS, NETWORK_TYPE_CDMA, NETWORK_TYPE_EVDO_0, NETWORK_TYPE_EVDO_A, NETWORK_TYPE_1xRTT, NETWORK_TYPE_HSDPA, NETWORK_TYPE_HSUPA, NETWORK_TYPE_HSPA, NETWORK_TYPE_IDEN, NETWORK_TYPE_EVDO_B, NETWORK_TYPE_LTE, NETWORK_TYPE_EHRPD, NETWORK_TYPE_HSPAP, NETWORK_TYPE_GSM, NETWORK_TYPE_TD_SCDMA, NETWORK_TYPE_IWLAN, NETWORK_TYPE_LTE_CA, NETWORK_TYPE_NR};
    }

    static {
        NETWORK_TYPE_UNSPECIFIED = new NetworkType("NETWORK_TYPE_UNSPECIFIED", 0, 0);
        NETWORK_TYPE_GPRS = new NetworkType("NETWORK_TYPE_GPRS", 1, 1);
        NETWORK_TYPE_EDGE = new NetworkType("NETWORK_TYPE_EDGE", 2, 2);
        NETWORK_TYPE_UMTS = new NetworkType("NETWORK_TYPE_UMTS", 3, 3);
        NETWORK_TYPE_CDMA = new NetworkType("NETWORK_TYPE_CDMA", 4, 4);
        NETWORK_TYPE_EVDO_0 = new NetworkType("NETWORK_TYPE_EVDO_0", 5, 5);
        NETWORK_TYPE_EVDO_A = new NetworkType("NETWORK_TYPE_EVDO_A", 6, 6);
        NETWORK_TYPE_1xRTT = new NetworkType("NETWORK_TYPE_1xRTT", 7, 7);
        NETWORK_TYPE_HSDPA = new NetworkType("NETWORK_TYPE_HSDPA", 8, 8);
        NETWORK_TYPE_HSUPA = new NetworkType("NETWORK_TYPE_HSUPA", 9, 9);
        NETWORK_TYPE_HSPA = new NetworkType("NETWORK_TYPE_HSPA", 10, 10);
        NETWORK_TYPE_IDEN = new NetworkType("NETWORK_TYPE_IDEN", 11, 11);
        NETWORK_TYPE_EVDO_B = new NetworkType("NETWORK_TYPE_EVDO_B", 12, 12);
        NETWORK_TYPE_LTE = new NetworkType("NETWORK_TYPE_LTE", 13, 13);
        NETWORK_TYPE_EHRPD = new NetworkType("NETWORK_TYPE_EHRPD", 14, 14);
        NETWORK_TYPE_HSPAP = new NetworkType("NETWORK_TYPE_HSPAP", 15, 15);
        NETWORK_TYPE_GSM = new NetworkType("NETWORK_TYPE_GSM", 16, 16);
        NETWORK_TYPE_TD_SCDMA = new NetworkType("NETWORK_TYPE_TD_SCDMA", 17, 17);
        NETWORK_TYPE_IWLAN = new NetworkType("NETWORK_TYPE_IWLAN", 18, 18);
        NETWORK_TYPE_LTE_CA = new NetworkType("NETWORK_TYPE_LTE_CA", 19, 19);
        NETWORK_TYPE_NR = new NetworkType("NETWORK_TYPE_NR", 20, 20);
        $VALUES = $values();
        internalValueMap = new AnonymousClass1();
        VALUES = values();
    }

    private NetworkType(String r8, int r10, int r11) {
        super(r8, r10);
        this.value = r11;
    }

    public static NetworkType forNumber(int r8) {
        switch(r8) {
            case 0: goto L46;
            case 1: goto L44;
            case 2: goto L42;
            case 3: goto L40;
            case 4: goto L38;
            case 5: goto L36;
            case 6: goto L34;
            case 7: goto L32;
            case 8: goto L30;
            case 9: goto L28;
            case 10: goto L26;
            case 11: goto L24;
            case 12: goto L22;
            case 13: goto L20;
            case 14: goto L18;
            case 15: goto L16;
            case 16: goto L14;
            case 17: goto L12;
            case 18: goto L10;
            case 19: goto L8;
            case 20: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return NETWORK_TYPE_NR;
    L8:
        return NETWORK_TYPE_LTE_CA;
    L10:
        return NETWORK_TYPE_IWLAN;
    L12:
        return NETWORK_TYPE_TD_SCDMA;
    L14:
        return NETWORK_TYPE_GSM;
    L16:
        return NETWORK_TYPE_HSPAP;
    L18:
        return NETWORK_TYPE_EHRPD;
    L20:
        return NETWORK_TYPE_LTE;
    L22:
        return NETWORK_TYPE_EVDO_B;
    L24:
        return NETWORK_TYPE_IDEN;
    L26:
        return NETWORK_TYPE_HSPA;
    L28:
        return NETWORK_TYPE_HSUPA;
    L30:
        return NETWORK_TYPE_HSDPA;
    L32:
        return NETWORK_TYPE_1xRTT;
    L34:
        return NETWORK_TYPE_EVDO_A;
    L36:
        return NETWORK_TYPE_EVDO_0;
    L38:
        return NETWORK_TYPE_CDMA;
    L40:
        return NETWORK_TYPE_UMTS;
    L42:
        return NETWORK_TYPE_EDGE;
    L44:
        return NETWORK_TYPE_GPRS;
    L46:
        return NETWORK_TYPE_UNSPECIFIED;
    }

    public static final Descriptors.EnumDescriptor getDescriptor() {
        return CaeNetpolicyEvent.getDescriptor().getEnumTypes().get(3);
    }

    public static Internal.EnumLiteMap<NetworkType> internalGetValueMap() {
        return internalValueMap;
    }

    @Deprecated
    public static NetworkType valueOf(int r8) {
        return forNumber(r8);
    }

    public static NetworkType[] values() {
        return (NetworkType[]) $VALUES.clone();
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

    public static NetworkType valueOf(Descriptors.EnumValueDescriptor r8) {
        if (r8.getType() != getDescriptor()) goto L7;
        return VALUES[r8.getIndex()];
    L7:
        throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
    }

    public static NetworkType valueOf(String r8) {
        return (NetworkType) Enum.valueOf(NetworkType.class, r8);
    }
}
