package com.obric.cae.network;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* JADX INFO: loaded from: classes.dex */
public final enum BlockedReason extends Enum<BlockedReason> implements ProtocolMessageEnum {
    private static final /* synthetic */ BlockedReason[] $VALUES = null;
    public static final BlockedReason BLOCKED_METERED_REASON_ADMIN_DISABLED = null;
    public static final int BLOCKED_METERED_REASON_ADMIN_DISABLED_VALUE = 262144;
    public static final BlockedReason BLOCKED_METERED_REASON_DATA_SAVER = null;
    public static final int BLOCKED_METERED_REASON_DATA_SAVER_VALUE = 65536;
    public static final BlockedReason BLOCKED_METERED_REASON_USER_RESTRICTED = null;
    public static final int BLOCKED_METERED_REASON_USER_RESTRICTED_VALUE = 131072;
    public static final BlockedReason BLOCKED_REASON_APP_BACKGROUND = null;
    public static final int BLOCKED_REASON_APP_BACKGROUND_VALUE = 64;
    public static final BlockedReason BLOCKED_REASON_APP_STANDBY = null;
    public static final int BLOCKED_REASON_APP_STANDBY_VALUE = 4;
    public static final BlockedReason BLOCKED_REASON_BATTERY_SAVER = null;
    public static final int BLOCKED_REASON_BATTERY_SAVER_VALUE = 1;
    public static final BlockedReason BLOCKED_REASON_BG_DISABLED = null;
    public static final int BLOCKED_REASON_BG_DISABLED_VALUE = 1048576;
    public static final BlockedReason BLOCKED_REASON_DOZE = null;
    public static final int BLOCKED_REASON_DOZE_VALUE = 2;
    public static final BlockedReason BLOCKED_REASON_LOCKDOWN_VPN = null;
    public static final int BLOCKED_REASON_LOCKDOWN_VPN_VALUE = 16;
    public static final BlockedReason BLOCKED_REASON_LOW_POWER_STANDBY = null;
    public static final int BLOCKED_REASON_LOW_POWER_STANDBY_VALUE = 32;
    public static final BlockedReason BLOCKED_REASON_NETWORK_RESTRICTED = null;
    public static final int BLOCKED_REASON_NETWORK_RESTRICTED_VALUE = 256;
    public static final BlockedReason BLOCKED_REASON_NONE = null;
    public static final int BLOCKED_REASON_NONE_VALUE = 0;
    public static final BlockedReason BLOCKED_REASON_OEM_DENY = null;
    public static final int BLOCKED_REASON_OEM_DENY_VALUE = 128;
    public static final BlockedReason BLOCKED_REASON_RESTRICTED_MODE = null;
    public static final int BLOCKED_REASON_RESTRICTED_MODE_VALUE = 8;
    private static final BlockedReason[] VALUES = null;
    private static final Internal.EnumLiteMap<BlockedReason> internalValueMap = null;
    private final int value;

    private static /* synthetic */ BlockedReason[] $values() {
        return new BlockedReason[]{BLOCKED_REASON_NONE, BLOCKED_REASON_BATTERY_SAVER, BLOCKED_REASON_DOZE, BLOCKED_REASON_APP_STANDBY, BLOCKED_REASON_RESTRICTED_MODE, BLOCKED_REASON_LOCKDOWN_VPN, BLOCKED_REASON_LOW_POWER_STANDBY, BLOCKED_REASON_APP_BACKGROUND, BLOCKED_REASON_OEM_DENY, BLOCKED_REASON_NETWORK_RESTRICTED, BLOCKED_METERED_REASON_DATA_SAVER, BLOCKED_METERED_REASON_USER_RESTRICTED, BLOCKED_METERED_REASON_ADMIN_DISABLED, BLOCKED_REASON_BG_DISABLED};
    }

    static {
        BLOCKED_REASON_NONE = new BlockedReason("BLOCKED_REASON_NONE", 0, 0);
        BLOCKED_REASON_BATTERY_SAVER = new BlockedReason("BLOCKED_REASON_BATTERY_SAVER", 1, 1);
        BLOCKED_REASON_DOZE = new BlockedReason("BLOCKED_REASON_DOZE", 2, 2);
        BLOCKED_REASON_APP_STANDBY = new BlockedReason("BLOCKED_REASON_APP_STANDBY", 3, 4);
        BLOCKED_REASON_RESTRICTED_MODE = new BlockedReason("BLOCKED_REASON_RESTRICTED_MODE", 4, 8);
        BLOCKED_REASON_LOCKDOWN_VPN = new BlockedReason("BLOCKED_REASON_LOCKDOWN_VPN", 5, 16);
        BLOCKED_REASON_LOW_POWER_STANDBY = new BlockedReason("BLOCKED_REASON_LOW_POWER_STANDBY", 6, 32);
        BLOCKED_REASON_APP_BACKGROUND = new BlockedReason("BLOCKED_REASON_APP_BACKGROUND", 7, 64);
        BLOCKED_REASON_OEM_DENY = new BlockedReason("BLOCKED_REASON_OEM_DENY", 8, 128);
        BLOCKED_REASON_NETWORK_RESTRICTED = new BlockedReason("BLOCKED_REASON_NETWORK_RESTRICTED", 9, 256);
        BLOCKED_METERED_REASON_DATA_SAVER = new BlockedReason("BLOCKED_METERED_REASON_DATA_SAVER", 10, 65536);
        BLOCKED_METERED_REASON_USER_RESTRICTED = new BlockedReason("BLOCKED_METERED_REASON_USER_RESTRICTED", 11, 131072);
        BLOCKED_METERED_REASON_ADMIN_DISABLED = new BlockedReason("BLOCKED_METERED_REASON_ADMIN_DISABLED", 12, 262144);
        BLOCKED_REASON_BG_DISABLED = new BlockedReason("BLOCKED_REASON_BG_DISABLED", 13, BLOCKED_REASON_BG_DISABLED_VALUE);
        $VALUES = $values();
        internalValueMap = new AnonymousClass1();
        VALUES = values();
    }

    private BlockedReason(String r8, int r10, int r11) {
        super(r8, r10);
        this.value = r11;
    }

    public static BlockedReason forNumber(int r8) {
        if (r8 == 0) goto L37;
        if (r8 == 1) goto L35;
        if (r8 == 2) goto L33;
        switch(r8) {
            case 4: goto L31;
            case 8: goto L29;
            case 16: goto L27;
            case 32: goto L25;
            case 64: goto L23;
            case 128: goto L21;
            case 256: goto L19;
            case 65536: goto L17;
            case 131072: goto L15;
            case 262144: goto L13;
            case 1048576: goto L11;
            default: goto L8;
        };
    L8:
        return null;
    L11:
        return BLOCKED_REASON_BG_DISABLED;
    L13:
        return BLOCKED_METERED_REASON_ADMIN_DISABLED;
    L15:
        return BLOCKED_METERED_REASON_USER_RESTRICTED;
    L17:
        return BLOCKED_METERED_REASON_DATA_SAVER;
    L19:
        return BLOCKED_REASON_NETWORK_RESTRICTED;
    L21:
        return BLOCKED_REASON_OEM_DENY;
    L23:
        return BLOCKED_REASON_APP_BACKGROUND;
    L25:
        return BLOCKED_REASON_LOW_POWER_STANDBY;
    L27:
        return BLOCKED_REASON_LOCKDOWN_VPN;
    L29:
        return BLOCKED_REASON_RESTRICTED_MODE;
    L31:
        return BLOCKED_REASON_APP_STANDBY;
    L33:
        return BLOCKED_REASON_DOZE;
    L35:
        return BLOCKED_REASON_BATTERY_SAVER;
    L37:
        return BLOCKED_REASON_NONE;
    }

    public static final Descriptors.EnumDescriptor getDescriptor() {
        return CaeNetpolicyEvent.getDescriptor().getEnumTypes().get(4);
    }

    public static Internal.EnumLiteMap<BlockedReason> internalGetValueMap() {
        return internalValueMap;
    }

    @Deprecated
    public static BlockedReason valueOf(int r8) {
        return forNumber(r8);
    }

    public static BlockedReason[] values() {
        return (BlockedReason[]) $VALUES.clone();
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

    public static BlockedReason valueOf(Descriptors.EnumValueDescriptor r8) {
        if (r8.getType() != getDescriptor()) goto L7;
        return VALUES[r8.getIndex()];
    L7:
        throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
    }

    public static BlockedReason valueOf(String r8) {
        return (BlockedReason) Enum.valueOf(BlockedReason.class, r8);
    }
}
