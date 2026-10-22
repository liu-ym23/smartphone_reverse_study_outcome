package com.sdk.bwdl.Utils;

import android.os.ParcelUuid;

/* JADX INFO: loaded from: classes2.dex */
public class BWDLInnerConstant {
    public static final int AL_CONNECTION_STATE_CHANGE = 303;
    public static final int BondStateChange = 301;
    public static final int CAPABILITIES_EXCHANGE_COMPLETE = 107;
    public static final int CHANNEL_CONFIG_COMPLETE = 104;
    public static final int CHANNEL_CONFIG_RESP = 105;
    public static final int CHANNEL_CONFIG_TIMEOUT = 203;
    public static final int CHANNEL_CONFIG_TIME_TOUT = 5000;
    public static final ParcelUuid CHARACTERISTIC_INDICATE_UUID = null;
    public static final ParcelUuid CHARACTERISTIC_NOTIFY_UUID = null;
    public static final ParcelUuid CHARACTERISTIC_READ_UUID = null;
    public static final ParcelUuid CHARACTERISTIC_WRITE_UUID = null;
    public static final int CONNECT = 100;
    public static final int CONNECT_TIMEOUT = 200;
    public static final int CUSTOMIZED_CMD_TIMEOUT = 201;
    public static final int Connected = 4;
    public static final int Connecting = 3;
    public static final int ConnectionStateChange = 300;
    public static final int DATA_LINK_REQ_TIMEOUT = 202;
    public static final int DATA_LINK_TOUT = 15000;
    public static final int DISCONNECT = 101;
    public static final int D_BUILD_LINK = 1100;
    public static final int D_CUSTOMIZED_CMD = 1105;
    public static final int D_DISCONNECTALL = 1123;
    public static final int D_ENTER_POWER_SAVING = 1103;
    public static final int D_EXIT_POWER_SAVING = 1104;
    public static final int D_L2CONNECT = 1113;
    public static final int D_L2CONNECTED = 1114;
    public static final int D_L2CONNECTING_TIMEOUT = 1126;
    public static final int D_L2DISCONNECT = 1122;
    public static final int D_L2LISTEN = 1112;
    public static final int D_L2_SERVER_READY = 1124;
    public static final int D_L4CONNECT = 1116;
    public static final int D_L4CONNECTED = 1117;
    public static final int D_L4CONNECTING_TIMEOUT = 1121;
    public static final int D_L4DISCONNECTED = 1118;
    public static final int D_L4LISTEN = 1115;
    public static final int D_LINK_LOSS = 1120;
    public static final int D_LINK_RECOVERY = 1107;
    public static final int D_NATIVE_EVENT = 1106;
    public static final int D_REMOVE_LINK = 1110;
    public static final int D_ROLE_NEGOTIATION = 1101;
    public static final int D_SECURITY_COMPLETED = 1119;
    public static final int D_SECURITY_REQ = 1102;
    public static final int D_SET_UP_TOUT = 1111;
    public static final int D_START_STREAM = 1108;
    public static final int D_STOP_STREAM = 1109;
    public static final int D_WAIT_L2_SERVER_READY = 1125;
    public static final int Disconnected = 2;
    public static final int ENCRYPT = 106;
    public static final int ENTER_POWER_SAVING = 108;
    public static final int ERR_CONNECTION_TOUT = 8;
    public static final int ERR_CONN_CAUSE_LOCAL_HOST = 22;
    public static final int ERR_CONN_FAILED_SYNC_TOUT = 62;
    public static final int ERR_INSTANT_PASSED = 40;
    public static final int ERR_LMP_RESPONSE_TIMEOUT = 34;
    public static final int ERR_MIC_FAILURE = 61;
    public static final int ERR_PEER_USER_CAUSE = 19;
    public static final int EVENT_TIME_TOUT = 3000;
    public static final int EXIT_POWER_SAVING = 109;
    public static final int Encrypted = 6;
    public static final int Encrypting = 5;
    public static final int FAIL = 2;
    public static final String FEATURE_BWDL_DROP = "BWDL Drop";
    public static final int LINK_IDLE_TOUT = 30000;
    public static final int LINK_RECOVERY = 112;
    public static final int LINK_SET_UP_TOUT = 30000;
    public static final int LISTEN = 102;
    public static final int LL_CONNECTION_STATE_CHANGE = 302;
    public static final int LL_PARAM_AVAILABLE = 304;
    public static final int LL_PARAM_FAIL = 305;
    public static final int LinkLoss = 1;
    public static final int ROLE_NEGOTIATION = 103;
    public static final int ROLE_NEGOTIATION_COMPLETE = 113;
    public static final ParcelUuid SERVICE_UUID = null;
    public static final int SUCCESS = 1;
    public static final int Unencrypted = 7;

    public static final enum ConnectivityType extends Enum<ConnectivityType> {
        private static final /* synthetic */ ConnectivityType[] $VALUES = null;
        public static final ConnectivityType GATT = null;
        public static final ConnectivityType P2P = null;
        public static final ConnectivityType Socket = null;
        public static final ConnectivityType SocketChannel = null;

        private static /* synthetic */ ConnectivityType[] $values() {
            return new ConnectivityType[]{GATT, P2P, Socket, SocketChannel};
        }

        static {
            GATT = new ConnectivityType("GATT", 0);
            P2P = new ConnectivityType("P2P", 1);
            Socket = new ConnectivityType("Socket", 2);
            SocketChannel = new ConnectivityType("SocketChannel", 3);
            $VALUES = $values();
        }

        private ConnectivityType(String r8, int r10) {
            super(r8, r10);
        }

        public static ConnectivityType valueOf(String r8) {
            return (ConnectivityType) Enum.valueOf(ConnectivityType.class, r8);
        }

        public static ConnectivityType[] values() {
            return (ConnectivityType[]) $VALUES.clone();
        }
    }

    public static final enum ControlLinkSmState extends Enum<ControlLinkSmState> {
        private static final /* synthetic */ ControlLinkSmState[] $VALUES = null;
        public static final ControlLinkSmState ActiveState = null;
        public static final ControlLinkSmState CapabilityExchangeState = null;
        public static final ControlLinkSmState ConfigurationState = null;
        public static final ControlLinkSmState ConnectedState = null;
        public static final ControlLinkSmState ConnectingState = null;
        public static final ControlLinkSmState DisconnectedState = null;
        public static final ControlLinkSmState LinkLossState = null;
        public static final ControlLinkSmState PowerSavingState = null;
        public static final ControlLinkSmState RoleNegotiationState = null;
        public static final ControlLinkSmState SecurityState = null;

        private static /* synthetic */ ControlLinkSmState[] $values() {
            return new ControlLinkSmState[]{DisconnectedState, ConnectingState, ConnectedState, RoleNegotiationState, ConfigurationState, SecurityState, CapabilityExchangeState, ActiveState, PowerSavingState, LinkLossState};
        }

        static {
            DisconnectedState = new ControlLinkSmState("DisconnectedState", 0);
            ConnectingState = new ControlLinkSmState("ConnectingState", 1);
            ConnectedState = new ControlLinkSmState("ConnectedState", 2);
            RoleNegotiationState = new ControlLinkSmState("RoleNegotiationState", 3);
            ConfigurationState = new ControlLinkSmState("ConfigurationState", 4);
            SecurityState = new ControlLinkSmState("SecurityState", 5);
            CapabilityExchangeState = new ControlLinkSmState("CapabilityExchangeState", 6);
            ActiveState = new ControlLinkSmState("ActiveState", 7);
            PowerSavingState = new ControlLinkSmState("PowerSavingState", 8);
            LinkLossState = new ControlLinkSmState("LinkLossState", 9);
            $VALUES = $values();
        }

        private ControlLinkSmState(String r8, int r10) {
            super(r8, r10);
        }

        public static ControlLinkSmState valueOf(String r8) {
            return (ControlLinkSmState) Enum.valueOf(ControlLinkSmState.class, r8);
        }

        public static ControlLinkSmState[] values() {
            return (ControlLinkSmState[]) $VALUES.clone();
        }
    }

    public static final enum DataLinkSmState extends Enum<DataLinkSmState> {
        private static final /* synthetic */ DataLinkSmState[] $VALUES = null;
        public static final DataLinkSmState ActiveState = null;
        public static final DataLinkSmState ConnectedState = null;
        public static final DataLinkSmState ConnectingState = null;
        public static final DataLinkSmState DisconnectedState = null;
        public static final DataLinkSmState LinkLossState = null;
        public static final DataLinkSmState PowerSavingState = null;
        public static final DataLinkSmState ProtocolConnectingState = null;
        public static final DataLinkSmState RoleNegotiationState = null;
        public static final DataLinkSmState SecurityState = null;
        public static final DataLinkSmState TransferringState = null;
        public static final DataLinkSmState WaitL2ServerReadyState = null;

        private static /* synthetic */ DataLinkSmState[] $values() {
            return new DataLinkSmState[]{DisconnectedState, ConnectingState, ConnectedState, RoleNegotiationState, SecurityState, ActiveState, PowerSavingState, LinkLossState, TransferringState, ProtocolConnectingState, WaitL2ServerReadyState};
        }

        static {
            DisconnectedState = new DataLinkSmState("DisconnectedState", 0);
            ConnectingState = new DataLinkSmState("ConnectingState", 1);
            ConnectedState = new DataLinkSmState("ConnectedState", 2);
            RoleNegotiationState = new DataLinkSmState("RoleNegotiationState", 3);
            SecurityState = new DataLinkSmState("SecurityState", 4);
            ActiveState = new DataLinkSmState("ActiveState", 5);
            PowerSavingState = new DataLinkSmState("PowerSavingState", 6);
            LinkLossState = new DataLinkSmState("LinkLossState", 7);
            TransferringState = new DataLinkSmState("TransferringState", 8);
            ProtocolConnectingState = new DataLinkSmState("ProtocolConnectingState", 9);
            WaitL2ServerReadyState = new DataLinkSmState("WaitL2ServerReadyState", 10);
            $VALUES = $values();
        }

        private DataLinkSmState(String r8, int r10) {
            super(r8, r10);
        }

        public static DataLinkSmState valueOf(String r8) {
            return (DataLinkSmState) Enum.valueOf(DataLinkSmState.class, r8);
        }

        public static DataLinkSmState[] values() {
            return (DataLinkSmState[]) $VALUES.clone();
        }
    }

    public static final enum Role extends Enum<Role> {
        private static final /* synthetic */ Role[] $VALUES = null;
        public static final Role Client = null;
        public static final Role Server = null;

        private static /* synthetic */ Role[] $values() {
            return new Role[]{Client, Server};
        }

        static {
            Client = new Role("Client", 0);
            Server = new Role("Server", 1);
            $VALUES = $values();
        }

        private Role(String r8, int r10) {
            super(r8, r10);
        }

        public static Role valueOf(String r8) {
            return (Role) Enum.valueOf(Role.class, r8);
        }

        public static Role[] values() {
            return (Role[]) $VALUES.clone();
        }
    }

    static {
        SERVICE_UUID = ParcelUuid.fromString("37841151-fb22-11ee-a244-fa163e6c466e");
        CHARACTERISTIC_READ_UUID = ParcelUuid.fromString("37841151-fb2c-11ee-a244-fa163e6c466e");
        CHARACTERISTIC_WRITE_UUID = ParcelUuid.fromString("37841151-fb40-11ee-a244-fa163e6c466e");
        CHARACTERISTIC_NOTIFY_UUID = ParcelUuid.fromString("37841151-fb54-11ee-a244-fa163e6c466e");
        CHARACTERISTIC_INDICATE_UUID = ParcelUuid.fromString("37841151-fb68-11ee-a244-fa163e6c466e");
    }

    public BWDLInnerConstant() {
    }
}
