package com.qualcomm.qti.qesdk.Dcf;

/* JADX INFO: loaded from: classes2.dex */
public final class DcfEnums {

    public static final enum AdvertisingInterval extends Enum<AdvertisingInterval> {
        private static final /* synthetic */ AdvertisingInterval[] $VALUES = null;
        public static final AdvertisingInterval ADVERTISINGINTERVAL_DEFAULT = null;
        public static final AdvertisingInterval ADVERTISINGINTERVAL_HIGH = null;
        public static final AdvertisingInterval ADVERTISINGINTERVAL_LOW = null;
        public static final AdvertisingInterval ADVERTISINGINTERVAL_MEDIUM = null;
        private int val;

        static {
            AdvertisingInterval r8 = new AdvertisingInterval("ADVERTISINGINTERVAL_DEFAULT", 0, 0);
            ADVERTISINGINTERVAL_DEFAULT = r8;
            AdvertisingInterval r10 = new AdvertisingInterval("ADVERTISINGINTERVAL_LOW", 1, 1);
            ADVERTISINGINTERVAL_LOW = r10;
            AdvertisingInterval r11 = new AdvertisingInterval("ADVERTISINGINTERVAL_MEDIUM", 2, 2);
            ADVERTISINGINTERVAL_MEDIUM = r11;
            AdvertisingInterval r12 = new AdvertisingInterval("ADVERTISINGINTERVAL_HIGH", 3, 3);
            ADVERTISINGINTERVAL_HIGH = r12;
            $VALUES = new AdvertisingInterval[]{r8, r10, r11, r12};
        }

        private AdvertisingInterval(String r8, int r10, int r11) {
            super(r8, r10);
            this.val = r11;
        }

        public static AdvertisingInterval valueOf(String r8) {
            return (AdvertisingInterval) Enum.valueOf(AdvertisingInterval.class, r8);
        }

        public static AdvertisingInterval[] values() {
            return (AdvertisingInterval[]) $VALUES.clone();
        }

        public int getValue() {
            return this.val;
        }
    }

    public static final enum BleAdvertiseStatus extends Enum<BleAdvertiseStatus> {
        private static final /* synthetic */ BleAdvertiseStatus[] $VALUES = null;
        public static final BleAdvertiseStatus BLEADVERTISESTATUS_EROR_TOOMANYADVERTISERS = null;
        public static final BleAdvertiseStatus BLEADVERTISESTATUS_ERROR_DATATOOLARGE = null;
        public static final BleAdvertiseStatus BLEADVERTISESTATUS_ERROR_FEATUREUNSUPPORTED = null;
        public static final BleAdvertiseStatus BLEADVERTISESTATUS_ERROR_INCORRECTPARAMETERS = null;
        public static final BleAdvertiseStatus BLEADVERTISESTATUS_ERROR_INTERNALERROR = null;
        public static final BleAdvertiseStatus BLEADVERTISESTATUS_ERROR_NOERROR = null;
        public static final BleAdvertiseStatus BLEADVERTISESTATUS_ERROR_TURNEDOFF = null;
        private int val;

        static {
            BleAdvertiseStatus r8 = new BleAdvertiseStatus("BLEADVERTISESTATUS_ERROR_NOERROR", 0, 0);
            BLEADVERTISESTATUS_ERROR_NOERROR = r8;
            BleAdvertiseStatus r10 = new BleAdvertiseStatus("BLEADVERTISESTATUS_ERROR_DATATOOLARGE", 1, 1);
            BLEADVERTISESTATUS_ERROR_DATATOOLARGE = r10;
            BleAdvertiseStatus r11 = new BleAdvertiseStatus("BLEADVERTISESTATUS_EROR_TOOMANYADVERTISERS", 2, 2);
            BLEADVERTISESTATUS_EROR_TOOMANYADVERTISERS = r11;
            BleAdvertiseStatus r12 = new BleAdvertiseStatus("BLEADVERTISESTATUS_ERROR_INTERNALERROR", 3, 3);
            BLEADVERTISESTATUS_ERROR_INTERNALERROR = r12;
            BleAdvertiseStatus r13 = new BleAdvertiseStatus("BLEADVERTISESTATUS_ERROR_INCORRECTPARAMETERS", 4, 4);
            BLEADVERTISESTATUS_ERROR_INCORRECTPARAMETERS = r13;
            BleAdvertiseStatus r14 = new BleAdvertiseStatus("BLEADVERTISESTATUS_ERROR_FEATUREUNSUPPORTED", 5, 5);
            BLEADVERTISESTATUS_ERROR_FEATUREUNSUPPORTED = r14;
            BleAdvertiseStatus r15 = new BleAdvertiseStatus("BLEADVERTISESTATUS_ERROR_TURNEDOFF", 6, 6);
            BLEADVERTISESTATUS_ERROR_TURNEDOFF = r15;
            $VALUES = new BleAdvertiseStatus[]{r8, r10, r11, r12, r13, r14, r15};
        }

        private BleAdvertiseStatus(String r8, int r10, int r11) {
            super(r8, r10);
            this.val = r11;
        }

        public static BleAdvertiseStatus valueOf(String r8) {
            return (BleAdvertiseStatus) Enum.valueOf(BleAdvertiseStatus.class, r8);
        }

        public static BleAdvertiseStatus[] values() {
            return (BleAdvertiseStatus[]) $VALUES.clone();
        }

        public int getValue() {
            return this.val;
        }
    }

    public static final enum BleScanStatus extends Enum<BleScanStatus> {
        private static final /* synthetic */ BleScanStatus[] $VALUES = null;
        public static final BleScanStatus BLESCANSTATUS_ERROR = null;
        public static final BleScanStatus BLESCANSTATUS_SUCCESS = null;
        private int val;

        static {
            BleScanStatus r8 = new BleScanStatus("BLESCANSTATUS_SUCCESS", 0, 0);
            BLESCANSTATUS_SUCCESS = r8;
            BleScanStatus r10 = new BleScanStatus("BLESCANSTATUS_ERROR", 1, 1);
            BLESCANSTATUS_ERROR = r10;
            $VALUES = new BleScanStatus[]{r8, r10};
        }

        private BleScanStatus(String r8, int r10, int r11) {
            super(r8, r10);
            this.val = r11;
        }

        public static BleScanStatus valueOf(String r8) {
            return (BleScanStatus) Enum.valueOf(BleScanStatus.class, r8);
        }

        public static BleScanStatus[] values() {
            return (BleScanStatus[]) $VALUES.clone();
        }

        public int getValue() {
            return this.val;
        }
    }

    public static final enum ClientRegistrationStatus extends Enum<ClientRegistrationStatus> {
        private static final /* synthetic */ ClientRegistrationStatus[] $VALUES = null;
        public static final ClientRegistrationStatus CLIENTREGISTRATIONSTATUS_ERROR = null;
        public static final ClientRegistrationStatus CLIENTREGISTRATIONSTATUS_SUCCESS = null;
        private int val;

        static {
            ClientRegistrationStatus r8 = new ClientRegistrationStatus("CLIENTREGISTRATIONSTATUS_SUCCESS", 0, 0);
            CLIENTREGISTRATIONSTATUS_SUCCESS = r8;
            ClientRegistrationStatus r10 = new ClientRegistrationStatus("CLIENTREGISTRATIONSTATUS_ERROR", 1, 1);
            CLIENTREGISTRATIONSTATUS_ERROR = r10;
            $VALUES = new ClientRegistrationStatus[]{r8, r10};
        }

        private ClientRegistrationStatus(String r8, int r10, int r11) {
            super(r8, r10);
            this.val = r11;
        }

        public static ClientRegistrationStatus valueOf(String r8) {
            return (ClientRegistrationStatus) Enum.valueOf(ClientRegistrationStatus.class, r8);
        }

        public static ClientRegistrationStatus[] values() {
            return (ClientRegistrationStatus[]) $VALUES.clone();
        }

        public int getValue() {
            return this.val;
        }
    }

    public static final enum Condition extends Enum<Condition> {
        private static final /* synthetic */ Condition[] $VALUES = null;
        public static final Condition CONDITION_EQUALS = null;
        public static final Condition CONDITION_GREATEROREQUAL = null;
        public static final Condition CONDITION_LESSOREQUAL = null;
        private int val;

        static {
            Condition r8 = new Condition("CONDITION_LESSOREQUAL", 0, 0);
            CONDITION_LESSOREQUAL = r8;
            Condition r10 = new Condition("CONDITION_GREATEROREQUAL", 1, 1);
            CONDITION_GREATEROREQUAL = r10;
            Condition r11 = new Condition("CONDITION_EQUALS", 2, 2);
            CONDITION_EQUALS = r11;
            $VALUES = new Condition[]{r8, r10, r11};
        }

        private Condition(String r8, int r10, int r11) {
            super(r8, r10);
            this.val = r11;
        }

        public static Condition valueOf(String r8) {
            return (Condition) Enum.valueOf(Condition.class, r8);
        }

        public static Condition[] values() {
            return (Condition[]) $VALUES.clone();
        }

        public int getValue() {
            return this.val;
        }
    }

    public static final enum CustomRequestStatus extends Enum<CustomRequestStatus> {
        private static final /* synthetic */ CustomRequestStatus[] $VALUES = null;
        public static final CustomRequestStatus CUSTOMREQUESTSTATUS_ERROR = null;
        public static final CustomRequestStatus CUSTOMREQUESTSTATUS_SUCCESS = null;
        private int val;

        static {
            CustomRequestStatus r8 = new CustomRequestStatus("CUSTOMREQUESTSTATUS_SUCCESS", 0, 0);
            CUSTOMREQUESTSTATUS_SUCCESS = r8;
            CustomRequestStatus r10 = new CustomRequestStatus("CUSTOMREQUESTSTATUS_ERROR", 1, 1);
            CUSTOMREQUESTSTATUS_ERROR = r10;
            $VALUES = new CustomRequestStatus[]{r8, r10};
        }

        private CustomRequestStatus(String r8, int r10, int r11) {
            super(r8, r10);
            this.val = r11;
        }

        public static CustomRequestStatus valueOf(String r8) {
            return (CustomRequestStatus) Enum.valueOf(CustomRequestStatus.class, r8);
        }

        public static CustomRequestStatus[] values() {
            return (CustomRequestStatus[]) $VALUES.clone();
        }

        public int getValue() {
            return this.val;
        }
    }

    public static final enum DuplicateDetectionStatus extends Enum<DuplicateDetectionStatus> {
        private static final /* synthetic */ DuplicateDetectionStatus[] $VALUES = null;
        public static final DuplicateDetectionStatus DUPLICATEDETECTIONSTATUS_ERROR = null;
        public static final DuplicateDetectionStatus DUPLICATEDETECTIONSTATUS_SUCCESS = null;
        private int val;

        static {
            DuplicateDetectionStatus r8 = new DuplicateDetectionStatus("DUPLICATEDETECTIONSTATUS_SUCCESS", 0, 0);
            DUPLICATEDETECTIONSTATUS_SUCCESS = r8;
            DuplicateDetectionStatus r10 = new DuplicateDetectionStatus("DUPLICATEDETECTIONSTATUS_ERROR", 1, 1);
            DUPLICATEDETECTIONSTATUS_ERROR = r10;
            $VALUES = new DuplicateDetectionStatus[]{r8, r10};
        }

        private DuplicateDetectionStatus(String r8, int r10, int r11) {
            super(r8, r10);
            this.val = r11;
        }

        public static DuplicateDetectionStatus valueOf(String r8) {
            return (DuplicateDetectionStatus) Enum.valueOf(DuplicateDetectionStatus.class, r8);
        }

        public static DuplicateDetectionStatus[] values() {
            return (DuplicateDetectionStatus[]) $VALUES.clone();
        }

        public int getValue() {
            return this.val;
        }
    }

    public static final enum PlatformStatus extends Enum<PlatformStatus> {
        private static final /* synthetic */ PlatformStatus[] $VALUES = null;
        public static final PlatformStatus PLATFORMSTATUS_AVAILABLE = null;
        public static final PlatformStatus PLATFORMSTATUS_UNAVAILABLE = null;
        public static final PlatformStatus PLATFORMSTATUS_UNAVAILABLE_RESET_BLE_TRANSPORT = null;
        private int val;

        static {
            PlatformStatus r8 = new PlatformStatus("PLATFORMSTATUS_AVAILABLE", 0, 0);
            PLATFORMSTATUS_AVAILABLE = r8;
            PlatformStatus r10 = new PlatformStatus("PLATFORMSTATUS_UNAVAILABLE", 1, 1);
            PLATFORMSTATUS_UNAVAILABLE = r10;
            PlatformStatus r11 = new PlatformStatus("PLATFORMSTATUS_UNAVAILABLE_RESET_BLE_TRANSPORT", 2, 2);
            PLATFORMSTATUS_UNAVAILABLE_RESET_BLE_TRANSPORT = r11;
            $VALUES = new PlatformStatus[]{r8, r10, r11};
        }

        private PlatformStatus(String r8, int r10, int r11) {
            super(r8, r10);
            this.val = r11;
        }

        public static PlatformStatus valueOf(String r8) {
            return (PlatformStatus) Enum.valueOf(PlatformStatus.class, r8);
        }

        public static PlatformStatus[] values() {
            return (PlatformStatus[]) $VALUES.clone();
        }

        public int getValue() {
            return this.val;
        }
    }

    public static final enum PropertyId extends Enum<PropertyId> {
        private static final /* synthetic */ PropertyId[] $VALUES = null;
        public static final PropertyId PROPERTYID_ADDRESS = null;
        public static final PropertyId PROPERTYID_ADDRESSTYPE = null;
        public static final PropertyId PROPERTYID_ADVERTISINGSID = null;
        public static final PropertyId PROPERTYID_DIRECTADDRESS = null;
        public static final PropertyId PROPERTYID_DIRECTADDRESSTYPE = null;
        public static final PropertyId PROPERTYID_EVENTTYPE = null;
        public static final PropertyId PROPERTYID_PERIODICADVERTISINGINTERVAL = null;
        public static final PropertyId PROPERTYID_PRIMARYPHY = null;
        public static final PropertyId PROPERTYID_RSSI = null;
        public static final PropertyId PROPERTYID_SECONDARYPHY = null;
        public static final PropertyId PROPERTYID_TIMESTAMP = null;
        public static final PropertyId PROPERTYID_TXPOWER = null;
        private int val;

        static {
            PropertyId r8 = new PropertyId("PROPERTYID_TIMESTAMP", 0, 0);
            PROPERTYID_TIMESTAMP = r8;
            PropertyId r10 = new PropertyId("PROPERTYID_EVENTTYPE", 1, 1);
            PROPERTYID_EVENTTYPE = r10;
            PropertyId r11 = new PropertyId("PROPERTYID_ADDRESSTYPE", 2, 2);
            PROPERTYID_ADDRESSTYPE = r11;
            PropertyId r12 = new PropertyId("PROPERTYID_ADDRESS", 3, 3);
            PROPERTYID_ADDRESS = r12;
            PropertyId r13 = new PropertyId("PROPERTYID_TXPOWER", 4, 4);
            PROPERTYID_TXPOWER = r13;
            PropertyId r14 = new PropertyId("PROPERTYID_RSSI", 5, 5);
            PROPERTYID_RSSI = r14;
            PropertyId r15 = new PropertyId("PROPERTYID_PRIMARYPHY", 6, 6);
            PROPERTYID_PRIMARYPHY = r15;
            PropertyId r16 = new PropertyId("PROPERTYID_SECONDARYPHY", 7, 7);
            PROPERTYID_SECONDARYPHY = r16;
            PropertyId r17 = new PropertyId("PROPERTYID_ADVERTISINGSID", 8, 8);
            PROPERTYID_ADVERTISINGSID = r17;
            PropertyId r18 = new PropertyId("PROPERTYID_PERIODICADVERTISINGINTERVAL", 9, 9);
            PROPERTYID_PERIODICADVERTISINGINTERVAL = r18;
            PropertyId r19 = new PropertyId("PROPERTYID_DIRECTADDRESSTYPE", 10, 10);
            PROPERTYID_DIRECTADDRESSTYPE = r19;
            PropertyId r110 = new PropertyId("PROPERTYID_DIRECTADDRESS", 11, 11);
            PROPERTYID_DIRECTADDRESS = r110;
            $VALUES = new PropertyId[]{r8, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110};
        }

        private PropertyId(String r8, int r10, int r11) {
            super(r8, r10);
            this.val = r11;
        }

        public static PropertyId valueOf(String r8) {
            return (PropertyId) Enum.valueOf(PropertyId.class, r8);
        }

        public static PropertyId[] values() {
            return (PropertyId[]) $VALUES.clone();
        }

        public int getValue() {
            return this.val;
        }
    }

    public static final enum ReferenceClientId extends Enum<ReferenceClientId> {
        private static final /* synthetic */ ReferenceClientId[] $VALUES = null;
        public static final ReferenceClientId REFERENCECLIENTID_DEFAULT = null;
        private int val;

        static {
            ReferenceClientId r8 = new ReferenceClientId("REFERENCECLIENTID_DEFAULT", 0, 1);
            REFERENCECLIENTID_DEFAULT = r8;
            $VALUES = new ReferenceClientId[]{r8};
        }

        private ReferenceClientId(String r8, int r10, int r11) {
            super(r8, r10);
            this.val = r11;
        }

        public static ReferenceClientId valueOf(String r8) {
            return (ReferenceClientId) Enum.valueOf(ReferenceClientId.class, r8);
        }

        public static ReferenceClientId[] values() {
            return (ReferenceClientId[]) $VALUES.clone();
        }

        public int getValue() {
            return this.val;
        }
    }

    public static final enum ScanMode extends Enum<ScanMode> {
        private static final /* synthetic */ ScanMode[] $VALUES = null;
        public static final ScanMode SCANMODE_AMBIENTDISCOVERY = null;
        public static final ScanMode SCANMODE_BALANCED = null;
        public static final ScanMode SCANMODE_LOWLATENCY = null;
        public static final ScanMode SCANMODE_LOWPOWER = null;
        public static final ScanMode SCANMODE_OEM_1 = null;
        public static final ScanMode SCANMODE_OEM_2 = null;
        public static final ScanMode SCANMODE_OEM_3 = null;
        public static final ScanMode SCANMODE_OEM_4 = null;
        public static final ScanMode SCANMODE_OEM_5 = null;
        public static final ScanMode SCANMODE_OEM_6 = null;
        public static final ScanMode SCANMODE_OPPORTUNISTIC = null;
        private int val;

        static {
            ScanMode r8 = new ScanMode("SCANMODE_OPPORTUNISTIC", 0, 0);
            SCANMODE_OPPORTUNISTIC = r8;
            ScanMode r10 = new ScanMode("SCANMODE_LOWPOWER", 1, 1);
            SCANMODE_LOWPOWER = r10;
            ScanMode r11 = new ScanMode("SCANMODE_BALANCED", 2, 2);
            SCANMODE_BALANCED = r11;
            ScanMode r12 = new ScanMode("SCANMODE_LOWLATENCY", 3, 3);
            SCANMODE_LOWLATENCY = r12;
            ScanMode r13 = new ScanMode("SCANMODE_AMBIENTDISCOVERY", 4, 4);
            SCANMODE_AMBIENTDISCOVERY = r13;
            ScanMode r14 = new ScanMode("SCANMODE_OEM_1", 5, 5);
            SCANMODE_OEM_1 = r14;
            ScanMode r15 = new ScanMode("SCANMODE_OEM_2", 6, 6);
            SCANMODE_OEM_2 = r15;
            ScanMode r16 = new ScanMode("SCANMODE_OEM_3", 7, 7);
            SCANMODE_OEM_3 = r16;
            ScanMode r17 = new ScanMode("SCANMODE_OEM_4", 8, 8);
            SCANMODE_OEM_4 = r17;
            ScanMode r18 = new ScanMode("SCANMODE_OEM_5", 9, 9);
            SCANMODE_OEM_5 = r18;
            ScanMode r19 = new ScanMode("SCANMODE_OEM_6", 10, 10);
            SCANMODE_OEM_6 = r19;
            $VALUES = new ScanMode[]{r8, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19};
        }

        private ScanMode(String r8, int r10, int r11) {
            super(r8, r10);
            this.val = r11;
        }

        public static ScanMode valueOf(String r8) {
            return (ScanMode) Enum.valueOf(ScanMode.class, r8);
        }

        public static ScanMode[] values() {
            return (ScanMode[]) $VALUES.clone();
        }

        public int getValue() {
            return this.val;
        }
    }

    public static final enum TriggerRequestType extends Enum<TriggerRequestType> {
        private static final /* synthetic */ TriggerRequestType[] $VALUES = null;
        public static final TriggerRequestType TRIGGERREQUESTTYPE_CANCEL = null;
        public static final TriggerRequestType TRIGGERREQUESTTYPE_SET = null;
        private int val;

        static {
            TriggerRequestType r8 = new TriggerRequestType("TRIGGERREQUESTTYPE_SET", 0, 0);
            TRIGGERREQUESTTYPE_SET = r8;
            TriggerRequestType r10 = new TriggerRequestType("TRIGGERREQUESTTYPE_CANCEL", 1, 1);
            TRIGGERREQUESTTYPE_CANCEL = r10;
            $VALUES = new TriggerRequestType[]{r8, r10};
        }

        private TriggerRequestType(String r8, int r10, int r11) {
            super(r8, r10);
            this.val = r11;
        }

        public static TriggerRequestType valueOf(String r8) {
            return (TriggerRequestType) Enum.valueOf(TriggerRequestType.class, r8);
        }

        public static TriggerRequestType[] values() {
            return (TriggerRequestType[]) $VALUES.clone();
        }

        public int getValue() {
            return this.val;
        }
    }

    public static final enum TriggerStatus extends Enum<TriggerStatus> {
        private static final /* synthetic */ TriggerStatus[] $VALUES = null;
        public static final TriggerStatus TRIGGERSTATUS_ERROR = null;
        public static final TriggerStatus TRIGGERSTATUS_SUCCESS = null;
        private int val;

        static {
            TriggerStatus r8 = new TriggerStatus("TRIGGERSTATUS_SUCCESS", 0, 0);
            TRIGGERSTATUS_SUCCESS = r8;
            TriggerStatus r10 = new TriggerStatus("TRIGGERSTATUS_ERROR", 1, 1);
            TRIGGERSTATUS_ERROR = r10;
            $VALUES = new TriggerStatus[]{r8, r10};
        }

        private TriggerStatus(String r8, int r10, int r11) {
            super(r8, r10);
            this.val = r11;
        }

        public static TriggerStatus valueOf(String r8) {
            return (TriggerStatus) Enum.valueOf(TriggerStatus.class, r8);
        }

        public static TriggerStatus[] values() {
            return (TriggerStatus[]) $VALUES.clone();
        }

        public int getValue() {
            return this.val;
        }
    }

    public static final enum TxPowerLevel extends Enum<TxPowerLevel> {
        private static final /* synthetic */ TxPowerLevel[] $VALUES = null;
        public static final TxPowerLevel TXPOWERLEVEL_DEFAULT = null;
        public static final TxPowerLevel TXPOWERLEVEL_HIGH = null;
        public static final TxPowerLevel TXPOWERLEVEL_LOW = null;
        public static final TxPowerLevel TXPOWERLEVEL_MEDIUM = null;
        public static final TxPowerLevel TXPOWERLEVEL_ULTRALOW = null;
        private int val;

        static {
            TxPowerLevel r8 = new TxPowerLevel("TXPOWERLEVEL_DEFAULT", 0, 0);
            TXPOWERLEVEL_DEFAULT = r8;
            TxPowerLevel r10 = new TxPowerLevel("TXPOWERLEVEL_ULTRALOW", 1, 1);
            TXPOWERLEVEL_ULTRALOW = r10;
            TxPowerLevel r11 = new TxPowerLevel("TXPOWERLEVEL_LOW", 2, 2);
            TXPOWERLEVEL_LOW = r11;
            TxPowerLevel r12 = new TxPowerLevel("TXPOWERLEVEL_MEDIUM", 3, 3);
            TXPOWERLEVEL_MEDIUM = r12;
            TxPowerLevel r13 = new TxPowerLevel("TXPOWERLEVEL_HIGH", 4, 4);
            TXPOWERLEVEL_HIGH = r13;
            $VALUES = new TxPowerLevel[]{r8, r10, r11, r12, r13};
        }

        private TxPowerLevel(String r8, int r10, int r11) {
            super(r8, r10);
            this.val = r11;
        }

        public static TxPowerLevel valueOf(String r8) {
            return (TxPowerLevel) Enum.valueOf(TxPowerLevel.class, r8);
        }

        public static TxPowerLevel[] values() {
            return (TxPowerLevel[]) $VALUES.clone();
        }

        public int getValue() {
            return this.val;
        }
    }

    public static final enum Version extends Enum<Version> {
        private static final /* synthetic */ Version[] $VALUES = null;
        public static final Version VERSION_1 = null;
        public static final Version VERSION_2 = null;
        public static final Version VERSION_3 = null;
        public static final Version VERSION_4 = null;
        public static final Version VERSION_5 = null;
        public static final Version VERSION_6 = null;
        private int val;

        static {
            Version r8 = new Version("VERSION_1", 0, 1);
            VERSION_1 = r8;
            Version r10 = new Version("VERSION_2", 1, 2);
            VERSION_2 = r10;
            Version r11 = new Version("VERSION_3", 2, 3);
            VERSION_3 = r11;
            Version r12 = new Version("VERSION_4", 3, 4);
            VERSION_4 = r12;
            Version r13 = new Version("VERSION_5", 4, 5);
            VERSION_5 = r13;
            Version r14 = new Version("VERSION_6", 5, 6);
            VERSION_6 = r14;
            $VALUES = new Version[]{r8, r10, r11, r12, r13, r14};
        }

        private Version(String r8, int r10, int r11) {
            super(r8, r10);
            this.val = r11;
        }

        public static Version valueOf(String r8) {
            return (Version) Enum.valueOf(Version.class, r8);
        }

        public static Version[] values() {
            return (Version[]) $VALUES.clone();
        }

        public int getValue() {
            return this.val;
        }
    }

    public DcfEnums() {
    }
}
