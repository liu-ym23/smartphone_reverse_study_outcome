package com.obric.cae.network;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.obric.cae.BWDL.BwdlDrop.provider.BwdlDropProvider;

/* JADX INFO: loaded from: classes.dex */
public final class CaeNetpolicyEvent {
    private static Descriptors.FileDescriptor descriptor;
    static final Descriptors.Descriptor internal_static_com_obric_cae_network_AppNetOpChangedEvent_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_cae_network_AppNetOpChangedEvent_fieldAccessorTable = null;
    static final Descriptors.Descriptor internal_static_com_obric_cae_network_BlockedReasonChangedEvent_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_cae_network_BlockedReasonChangedEvent_fieldAccessorTable = null;
    static final Descriptors.Descriptor internal_static_com_obric_cae_network_MeteredIfacesChangedEvent_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_cae_network_MeteredIfacesChangedEvent_fieldAccessorTable = null;
    static final Descriptors.Descriptor internal_static_com_obric_cae_network_NetpolicyEvents_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_cae_network_NetpolicyEvents_fieldAccessorTable = null;
    static final Descriptors.Descriptor internal_static_com_obric_cae_network_PowerStateEvent_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_cae_network_PowerStateEvent_fieldAccessorTable = null;
    static final Descriptors.Descriptor internal_static_com_obric_cae_network_RestrictBackgroundChangedEvent_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_cae_network_RestrictBackgroundChangedEvent_fieldAccessorTable = null;
    static final Descriptors.Descriptor internal_static_com_obric_cae_network_SleepModeChangedEvent_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_cae_network_SleepModeChangedEvent_fieldAccessorTable = null;
    static final Descriptors.Descriptor internal_static_com_obric_cae_network_SubscriptionOverrideChangedEvent_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_cae_network_SubscriptionOverrideChangedEvent_fieldAccessorTable = null;
    static final Descriptors.Descriptor internal_static_com_obric_cae_network_SubscriptionPlansChangedEvent_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_cae_network_SubscriptionPlansChangedEvent_fieldAccessorTable = null;
    static final Descriptors.Descriptor internal_static_com_obric_cae_network_UidPoliciesChangedEvent_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_cae_network_UidPoliciesChangedEvent_fieldAccessorTable = null;
    static final Descriptors.Descriptor internal_static_com_obric_cae_network_UidRulesChangedEvent_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_cae_network_UidRulesChangedEvent_fieldAccessorTable = null;

    static {
        descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0014NetPolicyEvent.proto\u0012\u0015com.obric.cae.network\"9\n\u0014UidRulesChangedEvent\u0012\u000b\n\u0003uid\u0018\u0001 \u0002(\r\u0012\u0014\n\fuidRulesMask\u0018\u0002 \u0002(\r\"2\n\u0019MeteredIfacesChangedEvent\u0012\u0015\n\rmeteredIfaces\u0018\u0001 \u0003(\t\"<\n\u001eRestrictBackgroundChangedEvent\u0012\u001a\n\u0012restrictBackground\u0018\u0001 \u0002(\b\"?\n\u0017UidPoliciesChangedEvent\u0012\u000b\n\u0003uid\u0018\u0001 \u0002(\r\u0012\u0017\n\u000fuidPoliciesMask\u0018\u0002 \u0002(\r\"\u0098\u0001\n SubscriptionOverrideChangedEvent\u0012\r\n\u0005subId\u0018\u0001 \u0002(\r\u0012\u0014\n\foverrideMask\u0018\u0002 \u0002(\r\u0012\u0015\n\roverrideValue\u0018\u0003 \u0002(\r\u00128\n\fnetworkTypes\u0018\u0004 \u0003(\u000e2\".com.obric.cae.network.NetworkType\"=\n\u001dSubscriptionPlansChangedEvent\u0012\r\n\u0005subId\u0018\u0001 \u0002(\r\u0012\r\n\u0005plans\u0018\u0002 \u0003(\t\"d\n\u0019BlockedReasonChangedEvent\u0012\u000b\n\u0003uid\u0018\u0001 \u0002(\r\u0012\u001c\n\u0014oldBlockedReasonMask\u0018\u0002 \u0002(\r\u0012\u001c\n\u0014newBlockedReasonMask\u0018\u0003 \u0002(\r\"m\n\u000fPowerStateEvent\u00128\n\u0004type\u0018\u0001 \u0002(\u000e2*.com.obric.cae.network.PowerStateEventType\u0012\r\n\u0005value\u0018\u0002 \u0002(\b\u0012\u0011\n\ttimestamp\u0018\u0003 \u0002(\u0003\"e\n\u0014AppNetOpChangedEvent\u0012\u000b\n\u0003uid\u0018\u0001 \u0002(\r\u0012\u000f\n\u0007pkgName\u0018\u0002 \u0002(\t\u0012\u000e\n\u0006opCode\u0018\u0003 \u0002(\r\u0012\f\n\u0004mode\u0018\u0004 \u0002(\u0005\u0012\u0011\n\ttimestamp\u0018\u0005 \u0002(\u0003\"?\n\u0015SleepModeChangedEvent\u0012\u0013\n\u000bisSleepMode\u0018\u0001 \u0002(\b\u0012\u0011\n\ttimestamp\u0018\u0002 \u0002(\u0003\"Ù\u0006\n\u000fNetpolicyEvents\u0012J\n\u0015uidRulesChangedEvents\u0018\u0001 \u0003(\u000b2+.com.obric.cae.network.UidRulesChangedEvent\u0012T\n\u001ameteredIfacesChangedEvents\u0018\u0002 \u0003(\u000b20.com.obric.cae.network.MeteredIfacesChangedEvent\u0012^\n\u001frestrictBackgroundChangedEvents\u0018\u0003 \u0003(\u000b25.com.obric.cae.network.RestrictBackgroundChangedEvent\u0012P\n\u0018uidPoliciesChangedEvents\u0018\u0004 \u0003(\u000b2..com.obric.cae.network.UidPoliciesChangedEvent\u0012b\n!subscriptionOverrideChangedEvents\u0018\u0005 \u0003(\u000b27.com.obric.cae.network.SubscriptionOverrideChangedEvent\u0012\\\n\u001esubscriptionPlansChangedEvents\u0018\u0006 \u0003(\u000b24.com.obric.cae.network.SubscriptionPlansChangedEvent\u0012T\n\u001ablockedReasonChangedEvents\u0018\u0007 \u0003(\u000b20.com.obric.cae.network.BlockedReasonChangedEvent\u0012@\n\u0010powerStateEvents\u0018\b \u0003(\u000b2&.com.obric.cae.network.PowerStateEvent\u0012J\n\u0015appNetOpChangedEvents\u0018\t \u0003(\u000b2+.com.obric.cae.network.AppNetOpChangedEvent\u0012L\n\u0016sleepModeChangedEvents\u0018\n \u0003(\u000b2,.com.obric.cae.network.SleepModeChangedEvent*Ï\u0001\n\u0007UidRule\u0012\r\n\tRULE_NONE\u0010\u0000\u0012\u0016\n\u0012RULE_ALLOW_METERED\u0010\u0001\u0012 \n\u001cRULE_TEMPORARY_ALLOW_METERED\u0010\u0002\u0012\u0017\n\u0013RULE_REJECT_METERED\u0010\u0004\u0012\u0012\n\u000eRULE_ALLOW_ALL\u0010 \u0012\u0013\n\u000fRULE_REJECT_ALL\u0010@\u0012\u0017\n\u0012RULE_REJECT_ALL_BG\u0010\u0080\u0001\u0012 \n\u001bRULE_REJECT_RESTRICTED_MODE\u0010\u0080\b*¶\u0001\n\tUidPolicy\u0012\u000f\n\u000bPOLICY_NONE\u0010\u0000\u0012$\n POLICY_REJECT_METERED_BACKGROUND\u0010\u0001\u0012#\n\u001fPOLICY_ALLOW_METERED_BACKGROUND\u0010\u0004\u0012+\n'POLICY_REJECT_ALL_BACKGROUND_SCREEN_OFF\u0010\b\u0012 \n\u001cPOLICY_REJECT_ALL_BACKGROUND\u0010\u0010*\u0090\u0001\n\u0018SubscriptionOverrideFlag\u0012*\n&SUBSCRIPTION_OVERRIDE_FLAG_UNSPECIFIED\u0010\u0000\u0012#\n\u001fSUBSCRIPTION_OVERRIDE_UNMETERED\u0010\u0001\u0012#\n\u001fSUBSCRIPTION_OVERRIDE_CONGESTED\u0010\u0002*\u0085\u0004\n\u000bNetworkType\u0012\u001c\n\u0018NETWORK_TYPE_UNSPECIFIED\u0010\u0000\u0012\u0015\n\u0011NETWORK_TYPE_GPRS\u0010\u0001\u0012\u0015\n\u0011NETWORK_TYPE_EDGE\u0010\u0002\u0012\u0015\n\u0011NETWORK_TYPE_UMTS\u0010\u0003\u0012\u0015\n\u0011NETWORK_TYPE_CDMA\u0010\u0004\u0012\u0017\n\u0013NETWORK_TYPE_EVDO_0\u0010\u0005\u0012\u0017\n\u0013NETWORK_TYPE_EVDO_A\u0010\u0006\u0012\u0016\n\u0012NETWORK_TYPE_1xRTT\u0010\u0007\u0012\u0016\n\u0012NETWORK_TYPE_HSDPA\u0010\b\u0012\u0016\n\u0012NETWORK_TYPE_HSUPA\u0010\t\u0012\u0015\n\u0011NETWORK_TYPE_HSPA\u0010\n\u0012\u0015\n\u0011NETWORK_TYPE_IDEN\u0010\u000b\u0012\u0017\n\u0013NETWORK_TYPE_EVDO_B\u0010\f\u0012\u0014\n\u0010NETWORK_TYPE_LTE\u0010\r\u0012\u0016\n\u0012NETWORK_TYPE_EHRPD\u0010\u000e\u0012\u0016\n\u0012NETWORK_TYPE_HSPAP\u0010\u000f\u0012\u0014\n\u0010NETWORK_TYPE_GSM\u0010\u0010\u0012\u0019\n\u0015NETWORK_TYPE_TD_SCDMA\u0010\u0011\u0012\u0016\n\u0012NETWORK_TYPE_IWLAN\u0010\u0012\u0012\u0017\n\u0013NETWORK_TYPE_LTE_CA\u0010\u0013\u0012\u0013\n\u000fNETWORK_TYPE_NR\u0010\u0014*ý\u0003\n\rBlockedReason\u0012\u0017\n\u0013BLOCKED_REASON_NONE\u0010\u0000\u0012 \n\u001cBLOCKED_REASON_BATTERY_SAVER\u0010\u0001\u0012\u0017\n\u0013BLOCKED_REASON_DOZE\u0010\u0002\u0012\u001e\n\u001aBLOCKED_REASON_APP_STANDBY\u0010\u0004\u0012\"\n\u001eBLOCKED_REASON_RESTRICTED_MODE\u0010\b\u0012\u001f\n\u001bBLOCKED_REASON_LOCKDOWN_VPN\u0010\u0010\u0012$\n BLOCKED_REASON_LOW_POWER_STANDBY\u0010 \u0012!\n\u001dBLOCKED_REASON_APP_BACKGROUND\u0010@\u0012\u001c\n\u0017BLOCKED_REASON_OEM_DENY\u0010\u0080\u0001\u0012&\n!BLOCKED_REASON_NETWORK_RESTRICTED\u0010\u0080\u0002\u0012'\n!BLOCKED_METERED_REASON_DATA_SAVER\u0010\u0080\u0080\u0004\u0012,\n&BLOCKED_METERED_REASON_USER_RESTRICTED\u0010\u0080\u0080\b\u0012+\n%BLOCKED_METERED_REASON_ADMIN_DISABLED\u0010\u0080\u0080\u0010\u0012 \n\u001aBLOCKED_REASON_BG_DISABLED\u0010\u0080\u0080@*¸\u0001\n\u0013PowerStateEventType\u0012&\n\"POWER_STATE_EVENT_TYPE_UNSPECIFIED\u0010\u0000\u0012*\n&POWER_STATE_EVENT_TYPE_POWER_SAVE_MODE\u0010\u0001\u0012$\n POWER_STATE_EVENT_TYPE_DOZE_MODE\u0010\u0002\u0012'\n#POWER_STATE_EVENT_TYPE_SCREEN_STATE\u0010\u0003B\u0015B\u0011CaeNetpolicyEventP\u0001"}, new Descriptors.FileDescriptor[0]);
        Descriptors.Descriptor r8 = getDescriptor().getMessageTypes().get(0);
        internal_static_com_obric_cae_network_UidRulesChangedEvent_descriptor = r8;
        internal_static_com_obric_cae_network_UidRulesChangedEvent_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r8, new String[]{"Uid", "UidRulesMask"});
        Descriptors.Descriptor r10 = getDescriptor().getMessageTypes().get(1);
        internal_static_com_obric_cae_network_MeteredIfacesChangedEvent_descriptor = r10;
        internal_static_com_obric_cae_network_MeteredIfacesChangedEvent_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r10, new String[]{"MeteredIfaces"});
        Descriptors.Descriptor r11 = getDescriptor().getMessageTypes().get(2);
        internal_static_com_obric_cae_network_RestrictBackgroundChangedEvent_descriptor = r11;
        internal_static_com_obric_cae_network_RestrictBackgroundChangedEvent_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r11, new String[]{"RestrictBackground"});
        Descriptors.Descriptor r12 = getDescriptor().getMessageTypes().get(3);
        internal_static_com_obric_cae_network_UidPoliciesChangedEvent_descriptor = r12;
        internal_static_com_obric_cae_network_UidPoliciesChangedEvent_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r12, new String[]{"Uid", "UidPoliciesMask"});
        Descriptors.Descriptor r13 = getDescriptor().getMessageTypes().get(4);
        internal_static_com_obric_cae_network_SubscriptionOverrideChangedEvent_descriptor = r13;
        internal_static_com_obric_cae_network_SubscriptionOverrideChangedEvent_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r13, new String[]{"SubId", "OverrideMask", "OverrideValue", "NetworkTypes"});
        Descriptors.Descriptor r14 = getDescriptor().getMessageTypes().get(5);
        internal_static_com_obric_cae_network_SubscriptionPlansChangedEvent_descriptor = r14;
        internal_static_com_obric_cae_network_SubscriptionPlansChangedEvent_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r14, new String[]{"SubId", "Plans"});
        Descriptors.Descriptor r15 = getDescriptor().getMessageTypes().get(6);
        internal_static_com_obric_cae_network_BlockedReasonChangedEvent_descriptor = r15;
        internal_static_com_obric_cae_network_BlockedReasonChangedEvent_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r15, new String[]{"Uid", "OldBlockedReasonMask", "NewBlockedReasonMask"});
        Descriptors.Descriptor r16 = getDescriptor().getMessageTypes().get(7);
        internal_static_com_obric_cae_network_PowerStateEvent_descriptor = r16;
        internal_static_com_obric_cae_network_PowerStateEvent_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r16, new String[]{"Type", "Value", BwdlDropProvider.BwdlDropEntry.TIMESTAMP});
        Descriptors.Descriptor r17 = getDescriptor().getMessageTypes().get(8);
        internal_static_com_obric_cae_network_AppNetOpChangedEvent_descriptor = r17;
        internal_static_com_obric_cae_network_AppNetOpChangedEvent_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r17, new String[]{"Uid", "PkgName", "OpCode", "Mode", BwdlDropProvider.BwdlDropEntry.TIMESTAMP});
        Descriptors.Descriptor r18 = getDescriptor().getMessageTypes().get(9);
        internal_static_com_obric_cae_network_SleepModeChangedEvent_descriptor = r18;
        internal_static_com_obric_cae_network_SleepModeChangedEvent_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r18, new String[]{"IsSleepMode", BwdlDropProvider.BwdlDropEntry.TIMESTAMP});
        Descriptors.Descriptor r19 = getDescriptor().getMessageTypes().get(10);
        internal_static_com_obric_cae_network_NetpolicyEvents_descriptor = r19;
        internal_static_com_obric_cae_network_NetpolicyEvents_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r19, new String[]{"UidRulesChangedEvents", "MeteredIfacesChangedEvents", "RestrictBackgroundChangedEvents", "UidPoliciesChangedEvents", "SubscriptionOverrideChangedEvents", "SubscriptionPlansChangedEvents", "BlockedReasonChangedEvents", "PowerStateEvents", "AppNetOpChangedEvents", "SleepModeChangedEvents"});
    }

    private CaeNetpolicyEvent() {
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    public static void registerAllExtensions(ExtensionRegistry r8) {
        registerAllExtensions(r8);
    }

    public static void registerAllExtensions(ExtensionRegistryLite r8) {
    }
}
