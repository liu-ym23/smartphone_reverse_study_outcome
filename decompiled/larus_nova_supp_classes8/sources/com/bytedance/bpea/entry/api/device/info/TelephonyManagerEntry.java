package com.bytedance.bpea.entry.api.device.info;

import android.os.PersistableBundle;
import android.telephony.CellIdentityLte;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.NetworkScan;
import android.telephony.NetworkScanRequest;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import android.telephony.TelephonyScanManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.emergency.EmergencyNumber;
import android.telephony.gsm.GsmCellLocation;
import com.bytedance.android.livesdk.chatroom.vs_base.base.service.inner.ReplayUIStateCode;
import com.bytedance.bpea.basics.BPEAException;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.bpea.entry.common.BaseAuthEntry;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/bpea/entry/api/device/info/TelephonyManagerEntry;", "", "()V", "Companion", "device-info-entry_release"}, k = 1, mv = {1, 1, ReplayUIStateCode.IS_FOLD_OPEN})
public final class TelephonyManagerEntry {
    private static final String CDMACELLLOCATION_PREFIX = "deviceInfo_cdmaCellLocation";
    private static final String CELLIDENTITYLTE_PREFIX = "deviceInfo_cellIdentityLte";
    public static final Companion Companion = null;
    public static final String GET_ALL_CELL_INFO = "deviceInfo_telephonyManager_getAllCellInfo";
    public static final String GET_BASE_STATION_ID = "deviceInfo_cdmaCellLocationgetBaseStationId";
    public static final String GET_BASE_STATION_LATITUDE = "deviceInfo_cdmaCellLocationgetBaseStationLatitude";
    public static final String GET_BASE_STATION_LONGITUDE = "deviceInfo_cdmaCellLocationgetBaseStationLongitude";
    public static final String GET_CARRIER_CONFIG = "deviceInfo_telephonyManager_getCarrierConfig";
    public static final String GET_CELL_LOCATION = "deviceInfo_telephonyManager_getCellLocation";
    public static final String GET_CID = "deviceInfo_gsmCellLocationgetCid";
    public static final String GET_DATA_NETWORK_TYPE = "deviceInfo_telephonyManager_getDataNetworkType";
    public static final String GET_DEVICE_ID = "deviceInfo_telephonyManager_getDeviceId";
    public static final String GET_DEVICE_SOFTWARE_VERSION = "deviceInfo_telephonyManager_getDeviceSoftwareVersion";
    public static final String GET_EMERGENCY_NUMBER_LIST = "deviceInfo_telephonyManager_getEmergencyNumberList";
    public static final String GET_FORBIDDEN_PLMNS = "deviceInfo_telephonyManager_getForbiddenPlmns";
    public static final String GET_GROUP_ID_LEVEL_1 = "deviceInfo_telephonyManager_getGroupIdLevel1";
    public static final String GET_IMEI = "deviceInfo_telephonyManager_getImei";
    public static final String GET_LAC = "deviceInfo_gsmCellLocationgetLac";
    public static final String GET_LINE_1_NUMBER = "deviceInfo_telephonyManager_getLine1Number";
    public static final String GET_MEID = "deviceInfo_telephonyManager_getMeid";
    public static final String GET_NETWORK_COUNTRY_ISO = "deviceInfo_telephonyManager_getNetworkCountryIso";
    public static final String GET_NETWORK_ID = "deviceInfo_cdmaCellLocationgetNetworkId";
    public static final String GET_NETWORK_OPERATOR = "deviceInfo_telephonyManager_getNetworkOperator";
    public static final String GET_NETWORK_OPERATOR_NAME = "deviceInfo_telephonyManager_getNetworkOperatorName";
    public static final String GET_NETWORK_TYPE = "deviceInfo_telephonyManager_getNetworkType";
    public static final String GET_PREFERRED_OPPORTUNISTIC_DATA_SUBSCRIPTION = "deviceInfo_telephonyManager_getPreferredOpportunisticDataSubscription";
    public static final String GET_PSC = "deviceInfo_gsmCellLocationgetPsc";
    public static final String GET_SERVICE_STATE = "deviceInfo_telephonyManager_getServiceState";
    public static final String GET_SIM_COUNT_ISO = "deviceInfo_telephonyManager_getSimCountIso";
    public static final String GET_SIM_OPERATOR = "deviceInfo_telephonyManager_getSimOperator";
    public static final String GET_SIM_SERIAL_NUMBER = "deviceInfo_telephonyManager_getSimSerialNumber";
    public static final String GET_SUBSCRIBER_ID = "deviceInfo_telephonyManager_getSubscriberId";
    public static final String GET_SUBSCRIPTION_ID = "deviceInfo_telephonyManager_getSubscriptionId";
    public static final String GET_SYSTEM_ID = "deviceInfo_cdmaCellLocationgetSystemId";
    public static final String GET_TAC = "deviceInfo_cellIdentityLtegetTac";
    private static final String GSMCELLLOCATION_PREFIX = "deviceInfo_gsmCellLocation";
    public static final String IS_DATA_ROAMING_ENABLED = "deviceInfo_telephonyManager_isDataRoamingEnabled";
    public static final String IS_MODEM_ENABLED_FOR_SLOT = "deviceInfo_telephonyManager_isModemEnabledForSlot";
    public static final String IS_MULTI_SIM_SUPPORTED = "deviceInfo_telephonyManager_isMultiSimSupported";
    public static final String IS_WORLD_PHONE = "deviceInfo_telephonyManager_isWorldPhone";
    public static final String LISTEN = "deviceInfo_telephonyManager_listen";
    public static final String REQUEST_CELL_INFO_UPDATE = "deviceInfo_telephonyManager_requestCellInfoUpdate";
    public static final String REQUEST_NETWORK_SCAN = "deviceInfo_telephonyManager_requestNetworkScan";
    public static final String SET_FORBIDDEN_PLMNS = "deviceInfo_telephonyManager_setForbiddenPlmns";
    private static final String TELEPHONY_PREFIX = "deviceInfo_telephonyManager_";

    public static final class Companion {
        public Companion() {
        }

        @JvmStatic
        public static String a(TelephonyManager r3, Cert r4) {
            TelephonyManagerEntry.Companion.getClass();     // Catch: BPEAException -> L4
            BaseAuthEntry.Companion r0 = BaseAuthEntry.a;     // Catch: BPEAException -> L4
            int r1 = a.a;     // Catch: BPEAException -> L4
            return (String) r0.a(a.C0370a.a(r4, TelephonyManagerEntry.GET_NETWORK_OPERATOR, 102020), new TelephonyManagerEntry$Companion$getNetworkOperatorUnsafe$1(r3));
        L4:
            e = move-exception;
            e.printStackTrace();
            return "";
        }

        @JvmStatic
        public static Integer b(TelephonyManager r2, Cert r3) {
            int r0 = -1;
            TelephonyManagerEntry.Companion.getClass();     // Catch: BPEAException -> L5
            return Integer.valueOf(c(r2, r3));
        L5:
            e = move-exception;
            e.printStackTrace();
            return r0;
        }

        @JvmStatic
        public static int c(final TelephonyManager r3, Cert r4) throws BPEAException {
            BaseAuthEntry.Companion r0 = BaseAuthEntry.a;
            int r1 = a.a;
            return ((Number) r0.a(a.C0370a.a(r4, TelephonyManagerEntry.GET_NETWORK_TYPE, 102043), new TelephonyManagerEntry$Companion$getNetworkTypeUnsafe$1(r3))).intValue();
        }

        @JvmStatic
        public static int d(final TelephonyManager r3, Cert r4) throws BPEAException {
            BaseAuthEntry.Companion r0 = BaseAuthEntry.a;
            int r1 = a.a;
            return ((Number) r0.a(a.C0370a.a(r4, TelephonyManagerEntry.GET_PREFERRED_OPPORTUNISTIC_DATA_SUBSCRIPTION, 102037), new TelephonyManagerEntry$Companion$getPreferredOpportunisticDataSubscriptionUnsafe$1(r3))).intValue();
        }

        @JvmStatic
        public static String e(TelephonyManager r3, Cert r4) {
            TelephonyManagerEntry.Companion.getClass();     // Catch: BPEAException -> L4
            BaseAuthEntry.Companion r0 = BaseAuthEntry.a;     // Catch: BPEAException -> L4
            int r1 = a.a;     // Catch: BPEAException -> L4
            return (String) r0.a(a.C0370a.a(r4, TelephonyManagerEntry.GET_SIM_OPERATOR, 102021), new TelephonyManagerEntry$Companion$getSimOperatorUnsafe$1(r3));
        L4:
            e = move-exception;
            e.printStackTrace();
            return "";
        }

        @JvmStatic
        public static String f(TelephonyManager r3, Cert r4) {
            TelephonyManagerEntry.Companion.getClass();     // Catch: BPEAException -> L4
            BaseAuthEntry.Companion r0 = BaseAuthEntry.a;     // Catch: BPEAException -> L4
            int r1 = a.a;     // Catch: BPEAException -> L4
            return (String) r0.a(a.C0370a.a(r4, TelephonyManagerEntry.GET_SIM_SERIAL_NUMBER, 101400), new TelephonyManagerEntry$Companion$getSimSerialNumberUnsafe$1(r3));
        L4:
            e = move-exception;
            e.printStackTrace();
            return "";
        }

        @JvmStatic
        public static int g(final TelephonyManager r3, Cert r4) throws BPEAException {
            BaseAuthEntry.Companion r0 = BaseAuthEntry.a;
            int r1 = a.a;
            return ((Number) r0.a(a.C0370a.a(r4, TelephonyManagerEntry.GET_SUBSCRIPTION_ID, 102014), new TelephonyManagerEntry$Companion$getSubscriptionIdUnsafe$1(r3))).intValue();
        }

        @JvmStatic
        public static boolean h(final TelephonyManager r3, Cert r4) throws BPEAException {
            BaseAuthEntry.Companion r0 = BaseAuthEntry.a;
            int r1 = a.a;
            return ((Boolean) r0.a(a.C0370a.a(r4, TelephonyManagerEntry.IS_DATA_ROAMING_ENABLED, 102038), new TelephonyManagerEntry$Companion$isDataRoamingEnabledUnsafe$1(r3))).booleanValue();
        }

        @JvmStatic
        public static int j(final TelephonyManager r3, Cert r4) throws BPEAException {
            BaseAuthEntry.Companion r0 = BaseAuthEntry.a;
            int r1 = a.a;
            return ((Number) r0.a(a.C0370a.a(r4, TelephonyManagerEntry.IS_MULTI_SIM_SUPPORTED, 102040), new TelephonyManagerEntry$Companion$isMultiSimSupportedUnsafe$1(r3))).intValue();
        }

        @JvmStatic
        public static boolean k(final TelephonyManager r3, Cert r4) throws BPEAException {
            BaseAuthEntry.Companion r0 = BaseAuthEntry.a;
            int r1 = a.a;
            return ((Boolean) r0.a(a.C0370a.a(r4, TelephonyManagerEntry.IS_WORLD_PHONE, 102041), new TelephonyManagerEntry$Companion$isWorldPhoneUnsafe$1(r3))).booleanValue();
        }

        @JvmStatic
        public static boolean i(final TelephonyManager r3, final int r4, Cert r5) throws BPEAException {
            BaseAuthEntry.Companion r0 = BaseAuthEntry.a;
            int r1 = a.a;
            return ((Boolean) r0.a(a.C0370a.a(r5, TelephonyManagerEntry.IS_MODEM_ENABLED_FOR_SLOT, 102039), new TelephonyManagerEntry$Companion$isModemEnabledForSlotUnsafe$1(r3, r4))).booleanValue();
        }

        @JvmStatic
        public static int m(final TelephonyManager r3, final List r4, Cert r5) throws BPEAException {
            BaseAuthEntry.Companion r0 = BaseAuthEntry.a;
            int r1 = a.a;
            return ((Number) r0.a(a.C0370a.a(r5, TelephonyManagerEntry.SET_FORBIDDEN_PLMNS, 102042), new TelephonyManagerEntry$Companion$setForbiddenPlmnsUnsafe$1(r3, r4))).intValue();
        }

        @JvmStatic
        public static void l(TelephonyManager r3, PhoneStateListener r4, int r5, Cert r6) {
            Unit r0 = Unit.INSTANCE;
            TelephonyManagerEntry.Companion.getClass();     // Catch: BPEAException -> L5
            BaseAuthEntry.Companion r1 = BaseAuthEntry.a;     // Catch: BPEAException -> L5
            int r2 = a.a;     // Catch: BPEAException -> L5
            r1.a(a.C0370a.a(r6, TelephonyManagerEntry.LISTEN, 100913), new TelephonyManagerEntry$Companion$listenUnsafe$1(r3, r4, r5));     // Catch: BPEAException -> L5
            return;
        L5:
            e = move-exception;
            e.printStackTrace();
        }
    }

    static {
        Companion = new Companion();
    }

    public TelephonyManagerEntry() {
    }

    @JvmStatic
    public static final Integer getNetworkType(TelephonyManager r1, Cert r2) {
        Companion.getClass();
        return Companion.b(r1, r2);
    }

    @JvmStatic
    public static final int getNetworkTypeUnsafe(TelephonyManager r1, Cert r2) throws BPEAException {
        Companion.getClass();
        return Companion.c(r1, r2);
    }

    @JvmStatic
    public static final int getPreferredOpportunisticDataSubscriptionUnsafe(TelephonyManager r1, Cert r2) throws BPEAException {
        Companion.getClass();
        return Companion.d(r1, r2);
    }

    @JvmStatic
    public static final int getSubscriptionIdUnsafe(TelephonyManager r1, Cert r2) throws BPEAException {
        Companion.getClass();
        return Companion.g(r1, r2);
    }

    @JvmStatic
    public static final boolean isDataRoamingEnabledUnsafe(TelephonyManager r1, Cert r2) throws BPEAException {
        Companion.getClass();
        return Companion.h(r1, r2);
    }

    @JvmStatic
    public static final boolean isModemEnabledForSlotUnsafe(TelephonyManager r1, int r2, Cert r3) throws BPEAException {
        Companion.getClass();
        return Companion.i(r1, r2, r3);
    }

    @JvmStatic
    public static final int isMultiSimSupportedUnsafe(TelephonyManager r1, Cert r2) throws BPEAException {
        Companion.getClass();
        return Companion.j(r1, r2);
    }

    @JvmStatic
    public static final boolean isWorldPhoneUnsafe(TelephonyManager r1, Cert r2) throws BPEAException {
        Companion.getClass();
        return Companion.k(r1, r2);
    }

    @JvmStatic
    public static final int setForbiddenPlmnsUnsafe(TelephonyManager r1, List<String> r2, Cert r3) throws BPEAException {
        Companion.getClass();
        return Companion.m(r1, r2, r3);
    }

    @JvmStatic
    public static final List<CellInfo> getAllCellInfo(TelephonyManager r3, Cert r4) {
        Companion.getClass();
        BaseAuthEntry.Companion r0 = BaseAuthEntry.a;     // Catch: BPEAException -> L5
        int r1 = a.a;     // Catch: BPEAException -> L5
        return (List) r0.a(a.C0370a.a(r4, GET_ALL_CELL_INFO, 100909), new TelephonyManagerEntry$Companion$getAllCellInfoUnsafe$1(r3));
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @JvmStatic
    public static final List<CellInfo> getAllCellInfoUnsafe(TelephonyManager r3, Cert r4) throws BPEAException {
        Companion.getClass();
        BaseAuthEntry.Companion r0 = BaseAuthEntry.a;
        int r1 = a.a;
        return (List) r0.a(a.C0370a.a(r4, GET_ALL_CELL_INFO, 100909), new TelephonyManagerEntry$Companion$getAllCellInfoUnsafe$1(r3));
    }

    @JvmStatic
    public static final Integer getBaseStationId(CdmaCellLocation r3, Cert r4) {
        Companion.getClass();
        BaseAuthEntry.Companion r0 = BaseAuthEntry.a;     // Catch: BPEAException -> L5
        int r1 = a.a;     // Catch: BPEAException -> L5
        return (Integer) r0.a(a.C0370a.a(r4, GET_BASE_STATION_ID, 100901), new TelephonyManagerEntry$Companion$getBaseStationIdUnsafe$1(r3));
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @JvmStatic
    public static final Integer getBaseStationIdUnsafe(CdmaCellLocation r3, Cert r4) throws BPEAException {
        Companion.getClass();
        BaseAuthEntry.Companion r0 = BaseAuthEntry.a;
        int r1 = a.a;
        return (Integer) r0.a(a.C0370a.a(r4, GET_BASE_STATION_ID, 100901), new TelephonyManagerEntry$Companion$getBaseStationIdUnsafe$1(r3));
    }

    @JvmStatic
    public static final Integer getBaseStationLatitude(CdmaCellLocation r3, Cert r4) {
        Companion.getClass();
        BaseAuthEntry.Companion r0 = BaseAuthEntry.a;     // Catch: BPEAException -> L5
        int r1 = a.a;     // Catch: BPEAException -> L5
        return (Integer) r0.a(a.C0370a.a(r4, GET_BASE_STATION_LATITUDE, 100902), new TelephonyManagerEntry$Companion$getBaseStationLatitudeUnsafe$1(r3));
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @JvmStatic
    public static final Integer getBaseStationLatitudeUnsafe(CdmaCellLocation r3, Cert r4) throws BPEAException {
        Companion.getClass();
        BaseAuthEntry.Companion r0 = BaseAuthEntry.a;
        int r1 = a.a;
        return (Integer) r0.a(a.C0370a.a(r4, GET_BASE_STATION_LATITUDE, 100902), new TelephonyManagerEntry$Companion$getBaseStationLatitudeUnsafe$1(r3));
    }

    @JvmStatic
    public static final Integer getBaseStationLongitude(CdmaCellLocation r3, Cert r4) {
        Companion.getClass();
        BaseAuthEntry.Companion r0 = BaseAuthEntry.a;     // Catch: BPEAException -> L5
        int r1 = a.a;     // Catch: BPEAException -> L5
        return (Integer) r0.a(a.C0370a.a(r4, GET_BASE_STATION_LONGITUDE, 100903), new TelephonyManagerEntry$Companion$getBaseStationLongitudeUnsafe$1(r3));
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @JvmStatic
    public static final Integer getBaseStationLongitudeUnsafe(CdmaCellLocation r3, Cert r4) throws BPEAException {
        Companion.getClass();
        BaseAuthEntry.Companion r0 = BaseAuthEntry.a;
        int r1 = a.a;
        return (Integer) r0.a(a.C0370a.a(r4, GET_BASE_STATION_LONGITUDE, 100903), new TelephonyManagerEntry$Companion$getBaseStationLongitudeUnsafe$1(r3));
    }

    @JvmStatic
    public static final PersistableBundle getCarrierConfig(TelephonyManager r3, Cert r4) {
        Companion.getClass();
        BaseAuthEntry.Companion r0 = BaseAuthEntry.a;     // Catch: BPEAException -> L5
        int r1 = a.a;     // Catch: BPEAException -> L5
        return (PersistableBundle) r0.a(a.C0370a.a(r4, GET_CARRIER_CONFIG, 102045), new TelephonyManagerEntry$Companion$getCarrierConfigUnsafe$1(r3));
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @JvmStatic
    public static final PersistableBundle getCarrierConfigUnsafe(TelephonyManager r3, Cert r4) throws BPEAException {
        Companion.getClass();
        BaseAuthEntry.Companion r0 = BaseAuthEntry.a;
        int r1 = a.a;
        return (PersistableBundle) r0.a(a.C0370a.a(r4, GET_CARRIER_CONFIG, 102045), new TelephonyManagerEntry$Companion$getCarrierConfigUnsafe$1(r3));
    }

    @JvmStatic
    public static final CellLocation getCellLocation(TelephonyManager r3, Cert r4) {
        Companion.getClass();
        BaseAuthEntry.Companion r0 = BaseAuthEntry.a;     // Catch: BPEAException -> L5
        int r1 = a.a;     // Catch: BPEAException -> L5
        return (CellLocation) r0.a(a.C0370a.a(r4, GET_CELL_LOCATION, 100900), new TelephonyManagerEntry$Companion$getCellLocationUnsafe$1(r3));
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @JvmStatic
    public static final CellLocation getCellLocationUnsafe(TelephonyManager r3, Cert r4) throws BPEAException {
        Companion.getClass();
        BaseAuthEntry.Companion r0 = BaseAuthEntry.a;
        int r1 = a.a;
        return (CellLocation) r0.a(a.C0370a.a(r4, GET_CELL_LOCATION, 100900), new TelephonyManagerEntry$Companion$getCellLocationUnsafe$1(r3));
    }

    @JvmStatic
    public static final Integer getCid(GsmCellLocation r3, Cert r4) {
        Companion.getClass();
        BaseAuthEntry.Companion r0 = BaseAuthEntry.a;     // Catch: BPEAException -> L5
        int r1 = a.a;     // Catch: BPEAException -> L5
        return (Integer) r0.a(a.C0370a.a(r4, GET_CID, 100906), new TelephonyManagerEntry$Companion$getCidUnsafe$1(r3));
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @JvmStatic
    public static final Integer getCidUnsafe(GsmCellLocation r3, Cert r4) throws BPEAException {
        Companion.getClass();
        BaseAuthEntry.Companion r0 = BaseAuthEntry.a;
        int r1 = a.a;
        return (Integer) r0.a(a.C0370a.a(r4, GET_CID, 100906), new TelephonyManagerEntry$Companion$getCidUnsafe$1(r3));
    }

    @JvmStatic
    public static final Integer getDataNetworkType(TelephonyManager r4, Cert r5) {
        Companion.getClass();
        BaseAuthEntry.Companion r1 = BaseAuthEntry.a;     // Catch: BPEAException -> L5
        int r2 = a.a;     // Catch: BPEAException -> L5
        return (Integer) r1.a(a.C0370a.a(r5, GET_DATA_NETWORK_TYPE, 102044), new TelephonyManagerEntry$Companion$getDataNetworkTypeUnsafe$1(r4));
    L5:
        e = move-exception;
        e.printStackTrace();
        return -1;
    }

    @JvmStatic
    public static final Integer getDataNetworkTypeUnsafe(TelephonyManager r3, Cert r4) throws BPEAException {
        Companion.getClass();
        BaseAuthEntry.Companion r0 = BaseAuthEntry.a;
        int r1 = a.a;
        return (Integer) r0.a(a.C0370a.a(r4, GET_DATA_NETWORK_TYPE, 102044), new TelephonyManagerEntry$Companion$getDataNetworkTypeUnsafe$1(r3));
    }

    @JvmStatic
    public static final String getDeviceId(TelephonyManager r3, Cert r4) {
        Companion.getClass();
        BaseAuthEntry.Companion r0 = BaseAuthEntry.a;     // Catch: BPEAException -> L5
        int r1 = a.a;     // Catch: BPEAException -> L5
        return (String) r0.a(a.C0370a.a(r4, GET_DEVICE_ID, 101600), new TelephonyManagerEntry$Companion$getDeviceIdUnsafe$1(r3));
    L5:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    @JvmStatic
    public static final String getDeviceIdUnsafe(TelephonyManager r3, Cert r4) throws BPEAException {
        Companion.getClass();
        BaseAuthEntry.Companion r0 = BaseAuthEntry.a;
        int r1 = a.a;
        return (String) r0.a(a.C0370a.a(r4, GET_DEVICE_ID, 101600), new TelephonyManagerEntry$Companion$getDeviceIdUnsafe$1(r3));
    }

    @JvmStatic
    public static final String getDeviceSoftwareVersion(TelephonyManager r3, Cert r4) {
        Companion.getClass();
        BaseAuthEntry.Companion r0 = BaseAuthEntry.a;     // Catch: BPEAException -> L5
        int r1 = a.a;     // Catch: BPEAException -> L5
        return (String) r0.a(a.C0370a.a(r4, GET_DEVICE_SOFTWARE_VERSION, 102015), new TelephonyManagerEntry$Companion$getDeviceSoftwareVersionUnsafe$1(r3));
    L5:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    @JvmStatic
    public static final String getDeviceSoftwareVersionUnsafe(TelephonyManager r3, Cert r4) throws BPEAException {
        Companion.getClass();
        BaseAuthEntry.Companion r0 = BaseAuthEntry.a;
        int r1 = a.a;
        return (String) r0.a(a.C0370a.a(r4, GET_DEVICE_SOFTWARE_VERSION, 102015), new TelephonyManagerEntry$Companion$getDeviceSoftwareVersionUnsafe$1(r3));
    }

    @JvmStatic
    public static final Map<Integer, List<EmergencyNumber>> getEmergencyNumberList(TelephonyManager r4, Cert r5) {
        Companion.getClass();
        Map<Integer, List<EmergencyNumber>> r0 = new HashMap();
        BaseAuthEntry.Companion r1 = BaseAuthEntry.a;     // Catch: BPEAException -> L5
        int r2 = a.a;     // Catch: BPEAException -> L5
        r0 = (Map) r1.a(a.C0370a.a(r5, GET_EMERGENCY_NUMBER_LIST, 102034), new TelephonyManagerEntry$Companion$getEmergencyNumberListUnsafe$1(r4));     // Catch: BPEAException -> L5
    L8:
        return r0;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    @JvmStatic
    public static final Map<Integer, List<EmergencyNumber>> getEmergencyNumberListUnsafe(TelephonyManager r3, Cert r4) throws BPEAException {
        Companion.getClass();
        BaseAuthEntry.Companion r0 = BaseAuthEntry.a;
        int r1 = a.a;
        return (Map) r0.a(a.C0370a.a(r4, GET_EMERGENCY_NUMBER_LIST, 102034), new TelephonyManagerEntry$Companion$getEmergencyNumberListUnsafe$1(r3));
    }

    @JvmStatic
    public static final String[] getForbiddenPlmns(TelephonyManager r3, Cert r4) {
        Companion.getClass();
        BaseAuthEntry.Companion r0 = BaseAuthEntry.a;     // Catch: BPEAException -> L5
        int r1 = a.a;     // Catch: BPEAException -> L5
        return (String[]) r0.a(a.C0370a.a(r4, GET_FORBIDDEN_PLMNS, 102035), new TelephonyManagerEntry$Companion$getForbiddenPlmnsUnsafe$1(r3));
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @JvmStatic
    public static final String[] getForbiddenPlmnsUnsafe(TelephonyManager r3, Cert r4) throws BPEAException {
        Companion.getClass();
        BaseAuthEntry.Companion r0 = BaseAuthEntry.a;
        int r1 = a.a;
        return (String[]) r0.a(a.C0370a.a(r4, GET_FORBIDDEN_PLMNS, 102035), new TelephonyManagerEntry$Companion$getForbiddenPlmnsUnsafe$1(r3));
    }

    @JvmStatic
    public static final String getGroupIdLevel1(TelephonyManager r3, Cert r4) {
        Companion.getClass();
        BaseAuthEntry.Companion r0 = BaseAuthEntry.a;     // Catch: BPEAException -> L5
        int r1 = a.a;     // Catch: BPEAException -> L5
        return (String) r0.a(a.C0370a.a(r4, GET_GROUP_ID_LEVEL_1, 102036), new TelephonyManagerEntry$Companion$getGroupIdLevel1Unsafe$1(r3));
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @JvmStatic
    public static final String getGroupIdLevel1Unsafe(TelephonyManager r3, Cert r4) throws BPEAException {
        Companion.getClass();
        BaseAuthEntry.Companion r0 = BaseAuthEntry.a;
        int r1 = a.a;
        return (String) r0.a(a.C0370a.a(r4, GET_GROUP_ID_LEVEL_1, 102036), new TelephonyManagerEntry$Companion$getGroupIdLevel1Unsafe$1(r3));
    }

    @JvmStatic
    public static final String getImei(TelephonyManager r3, Cert r4) {
        Companion.getClass();
        BaseAuthEntry.Companion r0 = BaseAuthEntry.a;     // Catch: BPEAException -> L5
        int r1 = a.a;     // Catch: BPEAException -> L5
        return (String) r0.a(a.C0370a.a(r4, GET_IMEI, 101601), new TelephonyManagerEntry$Companion$getImeiUnsafe$1(r3));
    L5:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    @JvmStatic
    public static final String getImeiUnsafe(TelephonyManager r3, Cert r4) throws BPEAException {
        Companion.getClass();
        BaseAuthEntry.Companion r0 = BaseAuthEntry.a;
        int r1 = a.a;
        return (String) r0.a(a.C0370a.a(r4, GET_IMEI, 101601), new TelephonyManagerEntry$Companion$getImeiUnsafe$1(r3));
    }

    @JvmStatic
    public static final Integer getLac(GsmCellLocation r3, Cert r4) {
        Companion.getClass();
        BaseAuthEntry.Companion r0 = BaseAuthEntry.a;     // Catch: BPEAException -> L5
        int r1 = a.a;     // Catch: BPEAException -> L5
        return (Integer) r0.a(a.C0370a.a(r4, GET_LAC, 100907), new TelephonyManagerEntry$Companion$getLacUnsafe$1(r3));
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @JvmStatic
    public static final Integer getLacUnsafe(GsmCellLocation r3, Cert r4) throws BPEAException {
        Companion.getClass();
        BaseAuthEntry.Companion r0 = BaseAuthEntry.a;
        int r1 = a.a;
        return (Integer) r0.a(a.C0370a.a(r4, GET_LAC, 100907), new TelephonyManagerEntry$Companion$getLacUnsafe$1(r3));
    }

    @JvmStatic
    public static final String getLine1Number(TelephonyManager r3, Cert r4) {
        Companion.getClass();
        BaseAuthEntry.Companion r0 = BaseAuthEntry.a;     // Catch: BPEAException -> L5
        int r1 = a.a;     // Catch: BPEAException -> L5
        return (String) r0.a(a.C0370a.a(r4, GET_LINE_1_NUMBER, 102000), new TelephonyManagerEntry$Companion$getLine1NumberUnsafe$1(r3));
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @JvmStatic
    public static final String getLine1NumberUnsafe(TelephonyManager r3, Cert r4) throws BPEAException {
        Companion.getClass();
        BaseAuthEntry.Companion r0 = BaseAuthEntry.a;
        int r1 = a.a;
        return (String) r0.a(a.C0370a.a(r4, GET_LINE_1_NUMBER, 102000), new TelephonyManagerEntry$Companion$getLine1NumberUnsafe$1(r3));
    }

    @JvmStatic
    public static final String getMeid(TelephonyManager r3, Cert r4) {
        Companion.getClass();
        BaseAuthEntry.Companion r0 = BaseAuthEntry.a;     // Catch: BPEAException -> L5
        int r1 = a.a;     // Catch: BPEAException -> L5
        return (String) r0.a(a.C0370a.a(r4, GET_MEID, 101602), new TelephonyManagerEntry$Companion$getMeidUnsafe$1(r3));
    L5:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    @JvmStatic
    public static final String getMeidUnsafe(TelephonyManager r3, Cert r4) throws BPEAException {
        Companion.getClass();
        BaseAuthEntry.Companion r0 = BaseAuthEntry.a;
        int r1 = a.a;
        return (String) r0.a(a.C0370a.a(r4, GET_MEID, 101602), new TelephonyManagerEntry$Companion$getMeidUnsafe$1(r3));
    }

    @JvmStatic
    public static final String getNetworkCountryIso(TelephonyManager r3, Cert r4) {
        Companion.getClass();
        BaseAuthEntry.Companion r0 = BaseAuthEntry.a;     // Catch: BPEAException -> L5
        int r1 = a.a;     // Catch: BPEAException -> L5
        return (String) r0.a(a.C0370a.a(r4, GET_NETWORK_COUNTRY_ISO, 102022), new TelephonyManagerEntry$Companion$getNetworkCountryIsoUnsafe$1(r3));
    L5:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    @JvmStatic
    public static final String getNetworkCountryIsoUnsafe(TelephonyManager r3, Cert r4) throws BPEAException {
        Companion.getClass();
        BaseAuthEntry.Companion r0 = BaseAuthEntry.a;
        int r1 = a.a;
        return (String) r0.a(a.C0370a.a(r4, GET_NETWORK_COUNTRY_ISO, 102022), new TelephonyManagerEntry$Companion$getNetworkCountryIsoUnsafe$1(r3));
    }

    @JvmStatic
    public static final Integer getNetworkId(CdmaCellLocation r3, Cert r4) {
        Companion.getClass();
        BaseAuthEntry.Companion r0 = BaseAuthEntry.a;     // Catch: BPEAException -> L5
        int r1 = a.a;     // Catch: BPEAException -> L5
        return (Integer) r0.a(a.C0370a.a(r4, GET_NETWORK_ID, 100905), new TelephonyManagerEntry$Companion$getNetworkIdUnsafe$1(r3));
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @JvmStatic
    public static final Integer getNetworkIdUnsafe(CdmaCellLocation r3, Cert r4) throws BPEAException {
        Companion.getClass();
        BaseAuthEntry.Companion r0 = BaseAuthEntry.a;
        int r1 = a.a;
        return (Integer) r0.a(a.C0370a.a(r4, GET_NETWORK_ID, 100905), new TelephonyManagerEntry$Companion$getNetworkIdUnsafe$1(r3));
    }

    @JvmStatic
    public static final String getNetworkOperator(TelephonyManager r3, Cert r4) {
        Companion r0 = Companion;
        r0.getClass();
        r0.getClass();     // Catch: BPEAException -> L5
        BaseAuthEntry.Companion r1 = BaseAuthEntry.a;     // Catch: BPEAException -> L5
        int r2 = a.a;     // Catch: BPEAException -> L5
        return (String) r1.a(a.C0370a.a(r4, GET_NETWORK_OPERATOR, 102020), new TelephonyManagerEntry$Companion$getNetworkOperatorUnsafe$1(r3));
    L5:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    @JvmStatic
    public static final String getNetworkOperatorName(TelephonyManager r3, Cert r4) {
        Companion.getClass();
        BaseAuthEntry.Companion r0 = BaseAuthEntry.a;     // Catch: BPEAException -> L5
        int r1 = a.a;     // Catch: BPEAException -> L5
        return (String) r0.a(a.C0370a.a(r4, GET_NETWORK_OPERATOR_NAME, 102047), new TelephonyManagerEntry$Companion$getNetworkOperatorNameUnsafe$1(r3));
    L5:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    @JvmStatic
    public static final String getNetworkOperatorNameUnsafe(TelephonyManager r3, Cert r4) throws BPEAException {
        Companion.getClass();
        BaseAuthEntry.Companion r0 = BaseAuthEntry.a;
        int r1 = a.a;
        return (String) r0.a(a.C0370a.a(r4, GET_NETWORK_OPERATOR_NAME, 102047), new TelephonyManagerEntry$Companion$getNetworkOperatorNameUnsafe$1(r3));
    }

    @JvmStatic
    public static final String getNetworkOperatorUnsafe(TelephonyManager r3, Cert r4) throws BPEAException {
        Companion.getClass();
        BaseAuthEntry.Companion r0 = BaseAuthEntry.a;
        int r1 = a.a;
        return (String) r0.a(a.C0370a.a(r4, GET_NETWORK_OPERATOR, 102020), new TelephonyManagerEntry$Companion$getNetworkOperatorUnsafe$1(r3));
    }

    @JvmStatic
    public static final Integer getPreferredOpportunisticDataSubscription(TelephonyManager r1, Cert r2) {
        Companion.getClass();
        int r0 = -1;
        return Integer.valueOf(Companion.d(r1, r2));
    L5:
        e = move-exception;
        e.printStackTrace();
        return r0;
    }

    @JvmStatic
    public static final Integer getPsc(GsmCellLocation r3, Cert r4) {
        Companion.getClass();
        BaseAuthEntry.Companion r0 = BaseAuthEntry.a;     // Catch: BPEAException -> L5
        int r1 = a.a;     // Catch: BPEAException -> L5
        return (Integer) r0.a(a.C0370a.a(r4, GET_PSC, 100908), new TelephonyManagerEntry$Companion$getPscUnsafe$1(r3));
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @JvmStatic
    public static final Integer getPscUnsafe(GsmCellLocation r3, Cert r4) throws BPEAException {
        Companion.getClass();
        BaseAuthEntry.Companion r0 = BaseAuthEntry.a;
        int r1 = a.a;
        return (Integer) r0.a(a.C0370a.a(r4, GET_PSC, 100908), new TelephonyManagerEntry$Companion$getPscUnsafe$1(r3));
    }

    @JvmStatic
    public static final ServiceState getServiceState(TelephonyManager r3, Cert r4) {
        Companion.getClass();
        BaseAuthEntry.Companion r0 = BaseAuthEntry.a;     // Catch: BPEAException -> L5
        int r1 = a.a;     // Catch: BPEAException -> L5
        return (ServiceState) r0.a(a.C0370a.a(r4, GET_SERVICE_STATE, 102033), new TelephonyManagerEntry$Companion$getServiceStateUnsafe$1(r3));
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @JvmStatic
    public static final ServiceState getServiceStateUnsafe(TelephonyManager r3, Cert r4) throws BPEAException {
        Companion.getClass();
        BaseAuthEntry.Companion r0 = BaseAuthEntry.a;
        int r1 = a.a;
        return (ServiceState) r0.a(a.C0370a.a(r4, GET_SERVICE_STATE, 102033), new TelephonyManagerEntry$Companion$getServiceStateUnsafe$1(r3));
    }

    @JvmStatic
    public static final String getSimCountIso(TelephonyManager r3, Cert r4) {
        Companion.getClass();
        BaseAuthEntry.Companion r0 = BaseAuthEntry.a;     // Catch: BPEAException -> L5
        int r1 = a.a;     // Catch: BPEAException -> L5
        return (String) r0.a(a.C0370a.a(r4, GET_SIM_COUNT_ISO, 102031), new TelephonyManagerEntry$Companion$getSimCountIsoUnsafe$1(r3));
    L5:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    @JvmStatic
    public static final String getSimCountIsoUnsafe(TelephonyManager r3, Cert r4) throws BPEAException {
        Companion.getClass();
        BaseAuthEntry.Companion r0 = BaseAuthEntry.a;
        int r1 = a.a;
        return (String) r0.a(a.C0370a.a(r4, GET_SIM_COUNT_ISO, 102031), new TelephonyManagerEntry$Companion$getSimCountIsoUnsafe$1(r3));
    }

    @JvmStatic
    public static final String getSimOperator(TelephonyManager r3, Cert r4) {
        Companion r0 = Companion;
        r0.getClass();
        r0.getClass();     // Catch: BPEAException -> L5
        BaseAuthEntry.Companion r1 = BaseAuthEntry.a;     // Catch: BPEAException -> L5
        int r2 = a.a;     // Catch: BPEAException -> L5
        return (String) r1.a(a.C0370a.a(r4, GET_SIM_OPERATOR, 102021), new TelephonyManagerEntry$Companion$getSimOperatorUnsafe$1(r3));
    L5:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    @JvmStatic
    public static final String getSimOperatorUnsafe(TelephonyManager r3, Cert r4) throws BPEAException {
        Companion.getClass();
        BaseAuthEntry.Companion r0 = BaseAuthEntry.a;
        int r1 = a.a;
        return (String) r0.a(a.C0370a.a(r4, GET_SIM_OPERATOR, 102021), new TelephonyManagerEntry$Companion$getSimOperatorUnsafe$1(r3));
    }

    @JvmStatic
    public static final String getSimSerialNumber(TelephonyManager r3, Cert r4) {
        Companion r0 = Companion;
        r0.getClass();
        r0.getClass();     // Catch: BPEAException -> L5
        BaseAuthEntry.Companion r1 = BaseAuthEntry.a;     // Catch: BPEAException -> L5
        int r2 = a.a;     // Catch: BPEAException -> L5
        return (String) r1.a(a.C0370a.a(r4, GET_SIM_SERIAL_NUMBER, 101400), new TelephonyManagerEntry$Companion$getSimSerialNumberUnsafe$1(r3));
    L5:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    @JvmStatic
    public static final String getSimSerialNumberUnsafe(TelephonyManager r3, Cert r4) throws BPEAException {
        Companion.getClass();
        BaseAuthEntry.Companion r0 = BaseAuthEntry.a;
        int r1 = a.a;
        return (String) r0.a(a.C0370a.a(r4, GET_SIM_SERIAL_NUMBER, 101400), new TelephonyManagerEntry$Companion$getSimSerialNumberUnsafe$1(r3));
    }

    @JvmStatic
    public static final String getSubscriberId(TelephonyManager r3, Cert r4) {
        Companion.getClass();
        BaseAuthEntry.Companion r0 = BaseAuthEntry.a;     // Catch: BPEAException -> L5
        int r1 = a.a;     // Catch: BPEAException -> L5
        return (String) r0.a(a.C0370a.a(r4, GET_SUBSCRIBER_ID, 101900), new TelephonyManagerEntry$Companion$getSubscriberIdUnsafe$1(r3));
    L5:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    @JvmStatic
    public static final String getSubscriberIdUnsafe(TelephonyManager r3, Cert r4) throws BPEAException {
        Companion.getClass();
        BaseAuthEntry.Companion r0 = BaseAuthEntry.a;
        int r1 = a.a;
        return (String) r0.a(a.C0370a.a(r4, GET_SUBSCRIBER_ID, 101900), new TelephonyManagerEntry$Companion$getSubscriberIdUnsafe$1(r3));
    }

    @JvmStatic
    public static final Integer getSubscriptionId(TelephonyManager r1, Cert r2) {
        Companion.getClass();
        int r0 = -1;
        return Integer.valueOf(Companion.g(r1, r2));
    L5:
        e = move-exception;
        e.printStackTrace();
        return r0;
    }

    @JvmStatic
    public static final Integer getSystemId(CdmaCellLocation r3, Cert r4) {
        Companion.getClass();
        BaseAuthEntry.Companion r0 = BaseAuthEntry.a;     // Catch: BPEAException -> L5
        int r1 = a.a;     // Catch: BPEAException -> L5
        return (Integer) r0.a(a.C0370a.a(r4, GET_SYSTEM_ID, 100904), new TelephonyManagerEntry$Companion$getSystemIdUnsafe$1(r3));
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @JvmStatic
    public static final Integer getSystemIdUnsafe(CdmaCellLocation r3, Cert r4) throws BPEAException {
        Companion.getClass();
        BaseAuthEntry.Companion r0 = BaseAuthEntry.a;
        int r1 = a.a;
        return (Integer) r0.a(a.C0370a.a(r4, GET_SYSTEM_ID, 100904), new TelephonyManagerEntry$Companion$getSystemIdUnsafe$1(r3));
    }

    @JvmStatic
    public static final Integer getTac(CellIdentityLte r3, Cert r4) {
        Companion.getClass();
        BaseAuthEntry.Companion r0 = BaseAuthEntry.a;     // Catch: BPEAException -> L5
        int r1 = a.a;     // Catch: BPEAException -> L5
        return (Integer) r0.a(a.C0370a.a(r4, GET_TAC, 102016), new TelephonyManagerEntry$Companion$getTacUnsafe$1(r3));
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @JvmStatic
    public static final Integer getTacUnsafe(CellIdentityLte r3, Cert r4) throws BPEAException {
        Companion.getClass();
        BaseAuthEntry.Companion r0 = BaseAuthEntry.a;
        int r1 = a.a;
        return (Integer) r0.a(a.C0370a.a(r4, GET_TAC, 102016), new TelephonyManagerEntry$Companion$getTacUnsafe$1(r3));
    }

    @JvmStatic
    public static final Boolean isDataRoamingEnabled(TelephonyManager r1, Cert r2) {
        Companion.getClass();
        Boolean r0 = Boolean.FALSE;
        return Boolean.valueOf(Companion.h(r1, r2));
    L5:
        e = move-exception;
        e.printStackTrace();
        return r0;
    }

    @JvmStatic
    public static final Integer isMultiSimSupported(TelephonyManager r1, Cert r2) {
        Companion.getClass();
        int r0 = 1;
        return Integer.valueOf(Companion.j(r1, r2));
    L5:
        e = move-exception;
        e.printStackTrace();
        return r0;
    }

    @JvmStatic
    public static final Boolean isWorldPhone(TelephonyManager r1, Cert r2) {
        Companion.getClass();
        Boolean r0 = Boolean.FALSE;
        return Boolean.valueOf(Companion.k(r1, r2));
    L5:
        e = move-exception;
        e.printStackTrace();
        return r0;
    }

    @JvmStatic
    public static final String getDeviceId(TelephonyManager r3, int r4, Cert r5) {
        Companion.getClass();
        BaseAuthEntry.Companion r0 = BaseAuthEntry.a;     // Catch: BPEAException -> L5
        int r1 = a.a;     // Catch: BPEAException -> L5
        return (String) r0.a(a.C0370a.a(r5, GET_DEVICE_ID, 101600), new TelephonyManagerEntry$Companion$getDeviceIdUnsafe$2(r3, r4));
    L5:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    @JvmStatic
    public static final String getDeviceIdUnsafe(TelephonyManager r3, int r4, Cert r5) throws BPEAException {
        Companion.getClass();
        BaseAuthEntry.Companion r0 = BaseAuthEntry.a;
        int r1 = a.a;
        return (String) r0.a(a.C0370a.a(r5, GET_DEVICE_ID, 101600), new TelephonyManagerEntry$Companion$getDeviceIdUnsafe$2(r3, r4));
    }

    @JvmStatic
    public static final String getImei(TelephonyManager r3, int r4, Cert r5) {
        Companion.getClass();
        BaseAuthEntry.Companion r0 = BaseAuthEntry.a;     // Catch: BPEAException -> L5
        int r1 = a.a;     // Catch: BPEAException -> L5
        return (String) r0.a(a.C0370a.a(r5, GET_IMEI, 101601), new TelephonyManagerEntry$Companion$getImeiUnsafe$2(r3, r4));
    L5:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    @JvmStatic
    public static final String getImeiUnsafe(TelephonyManager r3, int r4, Cert r5) throws BPEAException {
        Companion.getClass();
        BaseAuthEntry.Companion r0 = BaseAuthEntry.a;
        int r1 = a.a;
        return (String) r0.a(a.C0370a.a(r5, GET_IMEI, 101601), new TelephonyManagerEntry$Companion$getImeiUnsafe$2(r3, r4));
    }

    @JvmStatic
    public static final String getMeid(TelephonyManager r3, int r4, Cert r5) {
        Companion.getClass();
        BaseAuthEntry.Companion r0 = BaseAuthEntry.a;     // Catch: BPEAException -> L5
        int r1 = a.a;     // Catch: BPEAException -> L5
        return (String) r0.a(a.C0370a.a(r5, GET_MEID, 101602), new TelephonyManagerEntry$Companion$getMeidUnsafe$2(r3, r4));
    L5:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    @JvmStatic
    public static final String getMeidUnsafe(TelephonyManager r3, int r4, Cert r5) throws BPEAException {
        Companion.getClass();
        BaseAuthEntry.Companion r0 = BaseAuthEntry.a;
        int r1 = a.a;
        return (String) r0.a(a.C0370a.a(r5, GET_MEID, 101602), new TelephonyManagerEntry$Companion$getMeidUnsafe$2(r3, r4));
    }

    @JvmStatic
    public static final Boolean isModemEnabledForSlot(TelephonyManager r1, int r2, Cert r3) {
        Companion.getClass();
        Boolean r0 = Boolean.FALSE;
        return Boolean.valueOf(Companion.i(r1, r2, r3));
    L5:
        e = move-exception;
        e.printStackTrace();
        return r0;
    }

    @JvmStatic
    public static final Integer setForbiddenPlmns(TelephonyManager r1, List<String> r2, Cert r3) {
        Companion.getClass();
        int r0 = -1;
        return Integer.valueOf(Companion.m(r1, r2, r3));
    L5:
        e = move-exception;
        e.printStackTrace();
        return r0;
    }

    @JvmStatic
    public static final void listen(TelephonyManager r3, PhoneStateListener r4, int r5, Cert r6) {
        Companion r0 = Companion;
        r0.getClass();
        Unit r1 = Unit.INSTANCE;
        r0.getClass();     // Catch: BPEAException -> L5
        BaseAuthEntry.Companion r2 = BaseAuthEntry.a;     // Catch: BPEAException -> L5
        int r7 = a.a;     // Catch: BPEAException -> L5
        r2.a(a.C0370a.a(r6, LISTEN, 100913), new TelephonyManagerEntry$Companion$listenUnsafe$1(r3, r4, r5));     // Catch: BPEAException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    @JvmStatic
    public static final void listenUnsafe(TelephonyManager r3, PhoneStateListener r4, int r5, Cert r6) throws BPEAException {
        Companion.getClass();
        BaseAuthEntry.Companion r0 = BaseAuthEntry.a;
        int r1 = a.a;
        r0.a(a.C0370a.a(r6, LISTEN, 100913), new TelephonyManagerEntry$Companion$listenUnsafe$1(r3, r4, r5));
    }

    @JvmStatic
    public static final void requestCellInfoUpdate(TelephonyManager r3, Executor r4, TelephonyManager.CellInfoCallback r5, Cert r6) {
        Companion.getClass();
        Unit r0 = Unit.INSTANCE;
        BaseAuthEntry.Companion r1 = BaseAuthEntry.a;     // Catch: BPEAException -> L5
        int r2 = a.a;     // Catch: BPEAException -> L5
        r1.a(a.C0370a.a(r6, REQUEST_CELL_INFO_UPDATE, 100910), new TelephonyManagerEntry$Companion$requestCellInfoUpdateUnsafe$1(r3, r4, r5));     // Catch: BPEAException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    @JvmStatic
    public static final void requestCellInfoUpdateUnsafe(TelephonyManager r3, Executor r4, TelephonyManager.CellInfoCallback r5, Cert r6) throws BPEAException {
        Companion.getClass();
        BaseAuthEntry.Companion r0 = BaseAuthEntry.a;
        int r1 = a.a;
        r0.a(a.C0370a.a(r6, REQUEST_CELL_INFO_UPDATE, 100910), new TelephonyManagerEntry$Companion$requestCellInfoUpdateUnsafe$1(r3, r4, r5));
    }

    @JvmStatic
    public static final NetworkScan requestNetworkScan(TelephonyManager r3, NetworkScanRequest r4, Executor r5, TelephonyScanManager.NetworkScanCallback r6, Cert r7) {
        Companion.getClass();
        BaseAuthEntry.Companion r0 = BaseAuthEntry.a;     // Catch: BPEAException -> L5
        int r1 = a.a;     // Catch: BPEAException -> L5
        return (NetworkScan) r0.a(a.C0370a.a(r7, REQUEST_NETWORK_SCAN, 102032), new TelephonyManagerEntry$Companion$requestNetworkScanUnsafe$1(r3, r4, r5, r6));
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @JvmStatic
    public static final NetworkScan requestNetworkScanUnsafe(TelephonyManager r3, NetworkScanRequest r4, Executor r5, TelephonyScanManager.NetworkScanCallback r6, Cert r7) throws BPEAException {
        Companion.getClass();
        BaseAuthEntry.Companion r0 = BaseAuthEntry.a;
        int r1 = a.a;
        return (NetworkScan) r0.a(a.C0370a.a(r7, REQUEST_NETWORK_SCAN, 102032), new TelephonyManagerEntry$Companion$requestNetworkScanUnsafe$1(r3, r4, r5, r6));
    }
}
