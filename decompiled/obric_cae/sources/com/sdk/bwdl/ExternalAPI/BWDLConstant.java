package com.sdk.bwdl.ExternalAPI;

/* JADX INFO: loaded from: classes2.dex */
public final class BWDLConstant {
    public static final int ADV_OPTIONAL_CONFIG_NAME = 1;
    public static final int ADV_OPTIONAL_CONFIG_TX_POWER = 2;
    public static final int ADV_OPTIONAL_CONFIG_UUID = 4;
    public static final String BWDL_VERSION = "0.0.20";
    public static final int P2P_BAND_24GHZ = 1;
    public static final int P2P_BAND_5GHZ = 2;
    public static final int P2P_BAND_AUTO = 0;
    public static final int P2P_READY_FAIL_REASON_CONCURRENT = 11;
    public static final int P2P_READY_FAIL_REASON_NONE = 10;
    public static final int P2P_READY_SUCCESS = 0;

    public static final enum ADV_INTERVAL_LEVEL extends Enum<ADV_INTERVAL_LEVEL> {
        private static final /* synthetic */ ADV_INTERVAL_LEVEL[] $VALUES = null;
        public static final ADV_INTERVAL_LEVEL ADV_INTERVAL_HIGH = null;
        public static final ADV_INTERVAL_LEVEL ADV_INTERVAL_LOW = null;
        public static final ADV_INTERVAL_LEVEL ADV_INTERVAL_MEDIUM = null;

        private static /* synthetic */ ADV_INTERVAL_LEVEL[] $values() {
            return new ADV_INTERVAL_LEVEL[]{ADV_INTERVAL_HIGH, ADV_INTERVAL_MEDIUM, ADV_INTERVAL_LOW};
        }

        static {
            ADV_INTERVAL_HIGH = new ADV_INTERVAL_LEVEL("ADV_INTERVAL_HIGH", 0);
            ADV_INTERVAL_MEDIUM = new ADV_INTERVAL_LEVEL("ADV_INTERVAL_MEDIUM", 1);
            ADV_INTERVAL_LOW = new ADV_INTERVAL_LEVEL("ADV_INTERVAL_LOW", 2);
            $VALUES = $values();
        }

        private ADV_INTERVAL_LEVEL(String r8, int r10) {
            super(r8, r10);
        }

        public static ADV_INTERVAL_LEVEL valueOf(String r8) {
            return (ADV_INTERVAL_LEVEL) Enum.valueOf(ADV_INTERVAL_LEVEL.class, r8);
        }

        public static ADV_INTERVAL_LEVEL[] values() {
            return (ADV_INTERVAL_LEVEL[]) $VALUES.clone();
        }
    }

    public static final enum ADV_TX_POWER_LEVEL extends Enum<ADV_TX_POWER_LEVEL> {
        private static final /* synthetic */ ADV_TX_POWER_LEVEL[] $VALUES = null;
        public static final ADV_TX_POWER_LEVEL ADV_TX_POWER_HIGH = null;
        public static final ADV_TX_POWER_LEVEL ADV_TX_POWER_LOW = null;
        public static final ADV_TX_POWER_LEVEL ADV_TX_POWER_MEDIUM = null;

        private static /* synthetic */ ADV_TX_POWER_LEVEL[] $values() {
            return new ADV_TX_POWER_LEVEL[]{ADV_TX_POWER_HIGH, ADV_TX_POWER_MEDIUM, ADV_TX_POWER_LOW};
        }

        static {
            ADV_TX_POWER_HIGH = new ADV_TX_POWER_LEVEL("ADV_TX_POWER_HIGH", 0);
            ADV_TX_POWER_MEDIUM = new ADV_TX_POWER_LEVEL("ADV_TX_POWER_MEDIUM", 1);
            ADV_TX_POWER_LOW = new ADV_TX_POWER_LEVEL("ADV_TX_POWER_LOW", 2);
            $VALUES = $values();
        }

        private ADV_TX_POWER_LEVEL(String r8, int r10) {
            super(r8, r10);
        }

        public static ADV_TX_POWER_LEVEL valueOf(String r8) {
            return (ADV_TX_POWER_LEVEL) Enum.valueOf(ADV_TX_POWER_LEVEL.class, r8);
        }

        public static ADV_TX_POWER_LEVEL[] values() {
            return (ADV_TX_POWER_LEVEL[]) $VALUES.clone();
        }
    }

    public static final enum BROADCAST_TYPE extends Enum<BROADCAST_TYPE> {
        private static final /* synthetic */ BROADCAST_TYPE[] $VALUES = null;
        public static final BROADCAST_TYPE BROADCAST_EXTENDED = null;
        public static final BROADCAST_TYPE BROADCAST_LEGACY = null;

        private static /* synthetic */ BROADCAST_TYPE[] $values() {
            return new BROADCAST_TYPE[]{BROADCAST_LEGACY, BROADCAST_EXTENDED};
        }

        static {
            BROADCAST_LEGACY = new BROADCAST_TYPE("BROADCAST_LEGACY", 0);
            BROADCAST_EXTENDED = new BROADCAST_TYPE("BROADCAST_EXTENDED", 1);
            $VALUES = $values();
        }

        private BROADCAST_TYPE(String r8, int r10) {
            super(r8, r10);
        }

        public static BROADCAST_TYPE valueOf(String r8) {
            return (BROADCAST_TYPE) Enum.valueOf(BROADCAST_TYPE.class, r8);
        }

        public static BROADCAST_TYPE[] values() {
            return (BROADCAST_TYPE[]) $VALUES.clone();
        }
    }

    public static final enum DISCOVERY_MODE_LEVEL extends Enum<DISCOVERY_MODE_LEVEL> {
        private static final /* synthetic */ DISCOVERY_MODE_LEVEL[] $VALUES = null;
        public static final DISCOVERY_MODE_LEVEL DISCOVERY_MODE_BALANCED = null;
        public static final DISCOVERY_MODE_LEVEL DISCOVERY_MODE_LOW_LATENCY = null;
        public static final DISCOVERY_MODE_LEVEL DISCOVERY_MODE_LOW_POWER = null;

        private static /* synthetic */ DISCOVERY_MODE_LEVEL[] $values() {
            return new DISCOVERY_MODE_LEVEL[]{DISCOVERY_MODE_LOW_POWER, DISCOVERY_MODE_BALANCED, DISCOVERY_MODE_LOW_LATENCY};
        }

        static {
            DISCOVERY_MODE_LOW_POWER = new DISCOVERY_MODE_LEVEL("DISCOVERY_MODE_LOW_POWER", 0);
            DISCOVERY_MODE_BALANCED = new DISCOVERY_MODE_LEVEL("DISCOVERY_MODE_BALANCED", 1);
            DISCOVERY_MODE_LOW_LATENCY = new DISCOVERY_MODE_LEVEL("DISCOVERY_MODE_LOW_LATENCY", 2);
            $VALUES = $values();
        }

        private DISCOVERY_MODE_LEVEL(String r8, int r10) {
            super(r8, r10);
        }

        public static DISCOVERY_MODE_LEVEL valueOf(String r8) {
            return (DISCOVERY_MODE_LEVEL) Enum.valueOf(DISCOVERY_MODE_LEVEL.class, r8);
        }

        public static DISCOVERY_MODE_LEVEL[] values() {
            return (DISCOVERY_MODE_LEVEL[]) $VALUES.clone();
        }
    }

    public static final enum LinkType extends Enum<LinkType> {
        private static final /* synthetic */ LinkType[] $VALUES = null;
        public static final LinkType GATT = null;
        public static final LinkType P2P = null;
        public static final LinkType Socket = null;
        public static final LinkType SocketChannel = null;

        private static /* synthetic */ LinkType[] $values() {
            return new LinkType[]{GATT, P2P, Socket, SocketChannel};
        }

        static {
            GATT = new LinkType("GATT", 0);
            P2P = new LinkType("P2P", 1);
            Socket = new LinkType("Socket", 2);
            SocketChannel = new LinkType("SocketChannel", 3);
            $VALUES = $values();
        }

        private LinkType(String r8, int r10) {
            super(r8, r10);
        }

        public static LinkType valueOf(String r8) {
            return (LinkType) Enum.valueOf(LinkType.class, r8);
        }

        public static LinkType[] values() {
            return (LinkType[]) $VALUES.clone();
        }
    }

    public static final enum LogLevel extends Enum<LogLevel> {
        private static final /* synthetic */ LogLevel[] $VALUES = null;
        public static final LogLevel CLOSE = null;
        public static final LogLevel DEBUG = null;
        public static final LogLevel ERROR = null;
        public static final LogLevel FATAL = null;
        public static final LogLevel INFO = null;
        public static final LogLevel WARN = null;

        private static /* synthetic */ LogLevel[] $values() {
            return new LogLevel[]{CLOSE, DEBUG, INFO, WARN, ERROR, FATAL};
        }

        static {
            CLOSE = new LogLevel("CLOSE", 0);
            DEBUG = new LogLevel("DEBUG", 1);
            INFO = new LogLevel("INFO", 2);
            WARN = new LogLevel("WARN", 3);
            ERROR = new LogLevel("ERROR", 4);
            FATAL = new LogLevel("FATAL", 5);
            $VALUES = $values();
        }

        private LogLevel(String r8, int r10) {
            super(r8, r10);
        }

        public static LogLevel valueOf(String r8) {
            return (LogLevel) Enum.valueOf(LogLevel.class, r8);
        }

        public static LogLevel[] values() {
            return (LogLevel[]) $VALUES.clone();
        }
    }

    public BWDLConstant() {
    }
}
