package com.sdk.bwdl;

import android.content.Context;
import com.sdk.bwdl.AdapterLayer.Wifi.P2p.P2pAdapter;
import com.sdk.bwdl.ExternalAPI.BWDLConstant;
import com.sdk.bwdl.StateMachine.ControlLinkSM;
import com.sdk.bwdl.StateMachine.DataLinkSM;
import com.sdk.bwdl.Utils.BWDLInnerConstant;
import com.sdk.bwdl.Utils.BWDLLog;
import com.sdk.bwdl.Utils.BWDLUtil;
import java.net.InetSocketAddress;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class DataLink {
    private static final String TAG = "DataLink";
    private Context mContext;
    private ControlLinkProperty mControlLinkProperty;
    private ControlLinkSM mControlLinkSM;
    private DataLink mDataLink;
    private DataLinkSM mDataLinkSM;
    private boolean mExitFlag;
    private BWDLConstant.LinkType mL2Type;
    private BWDLConstant.LinkType mL4Type;
    private BWDLConstant.LinkType[] mLinkTypes;
    private P2pAdapter mP2pAdapter;
    private DataLinkSMListener mSMListener;

    /* JADX INFO: renamed from: com.sdk.bwdl.DataLink$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class DataLinkSMListener implements DataLinkSM.IDataLinkSMListener {
        final /* synthetic */ DataLink this$0;

        private DataLinkSMListener(DataLink r8) {
            this.this$0 = r8;
        }

        @Override // com.sdk.bwdl.StateMachine.DataLinkSM.IDataLinkSMListener
        public void onStateChanged(String r8, String r10) {
            BWDLLog.d(DataLink.TAG, "DataLinkSM transform：" + r8 + " to " + r10);
            if (r10.equals("TransferringState") == false) goto L6;
        L4:
            DataLink.access$100(this.this$0);
            return;
        L6:
            if (r10.equals("ActiveState") == false) goto L12;
            if (DataLink.access$200(this.this$0) == null) goto L4;
            DataLink.access$300(this.this$0);
            return;
        L12:
            if (r10.equals("DisconnectedState") == false) goto L19;
            DataLink.access$400(this.this$0).setDataLinkLLInfo(null);
            DataLink.access$500(this.this$0);
            if (DataLink.access$600(this.this$0) == false) goto L20;
            DataLink.access$700(this.this$0);
            return;
        L20:
            return;
        }

        public /* synthetic */ DataLinkSMListener(DataLink r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public DataLink(Context r8, ControlLinkProperty r10, BWDLConstant.LinkType[] r11) {
        BWDLLog.d(TAG, "new DataLink");
        this.mContext = r8;
        this.mLinkTypes = r11;
        this.mControlLinkProperty = r10;
        this.mDataLink = this;
        this.mControlLinkSM = r10.getControlLinkSM();
        this.mL2Type = BWDLUtil.getLinkLayerType(r11);
        this.mL4Type = BWDLUtil.getApplicationLayerType(r11);
        this.mDataLinkSM = createDataLinkSM();
        DataLinkSMListener r12 = new DataLinkSMListener(this, null);
        this.mSMListener = r12;
        this.mDataLinkSM.setDataLinkSMListener(r12);
        BWDLConstant.LinkType[] r13 = this.mLinkTypes;
        int r14 = r13.length;
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L8;
        if (r13[r15] != BWDLConstant.LinkType.P2P) goto L7;
        this.mP2pAdapter = P2pAdapter.getInstance(this.mContext, r10.getBWDLConfigs().getP2pBand());
    L7:
        r15 = r15 + 1;
        goto L3
    }

    public static /* synthetic */ void access$100(DataLink r8) {
        r8.sendConnectedToUpper();
    }

    public static /* synthetic */ BWDLConstant.LinkType access$200(DataLink r8) {
        return r8.mL4Type;
    }

    public static /* synthetic */ void access$300(DataLink r8) {
        r8.executeL4Connection();
    }

    public static /* synthetic */ ControlLinkProperty access$400(DataLink r8) {
        return r8.mControlLinkProperty;
    }

    public static /* synthetic */ void access$500(DataLink r8) {
        r8.sendDisconnectedToUpper();
    }

    public static /* synthetic */ boolean access$600(DataLink r8) {
        return r8.mExitFlag;
    }

    public static /* synthetic */ void access$700(DataLink r8) {
        r8.exit();
    }

    private DataLinkSM createDataLinkSM() {
        BWDLDevice r8 = isDataLinkLLExit(this.mL2Type);
        if (r8 == null) goto L5;
        DataLinkSM r10 = new DataLinkSM(this.mContext, this, this.mControlLinkProperty, BWDLInnerConstant.DataLinkSmState.ActiveState);
        r10.setBWDLDeviceL2(r8);
    L6:
        this.mControlLinkProperty.setDataLinkSM(r10);
        return r10;
    L5:
        r10 = new DataLinkSM(this.mContext, this, this.mControlLinkProperty, BWDLInnerConstant.DataLinkSmState.DisconnectedState);
        goto L6
    }

    private void executeL4Connection() {
        BWDLLog.d(TAG, "executeL4Connection");
        if (this.mP2pAdapter.getP2pRole() != 2) goto L5;
        protocolConnect();
        return;
    L5:
        protocolListen();
    }

    private void exit() {
        DataLinkSM r8 = this.mDataLinkSM;
        if (r8 == null) goto L5;
        r8.removeDataLinkSMListener(this.mSMListener);
        this.mDataLinkSM.cleanup();
    L5:
        this.mDataLink = null;
        this.mDataLinkSM = null;
    }

    private BWDLDevice isDataLinkLLExit(BWDLConstant.LinkType r8) {
        Iterator<ControlLink> r10 = this.mControlLinkSM.getControlLinkList().iterator();
    L4:
        if (r10.hasNext() == false) goto L13;
        Iterator<DataLink> r11 = r10.next().getDataLinkList().iterator();
    L7:
        if (r11.hasNext() == false) goto L4;
        BWDLDevice r12 = r11.next().getDataLinkSM().getBWDLDeviceL2();
        if (r12 == null) goto L7;
        if (r12.getConnectivityType().ordinal() != r8.ordinal()) goto L7;
        return r12;
    L13:
        return null;
    }

    private void protocolConnect() {
        BWDLLog.d(TAG, "protocolConnect:" + this.mL4Type);
        BWDLConstant.LinkType r8 = this.mL4Type;
        if (r8 != null) goto L5;
        return;
    L5:
        if (r8 != BWDLConstant.LinkType.SocketChannel) goto L9;
        this.mDataLinkSM.sendMessage(BWDLInnerConstant.D_L4CONNECT, 0, 0, new BWDLDevice(BWDLInnerConstant.ConnectivityType.SocketChannel, new InetSocketAddress(this.mP2pAdapter.getGroupOwnerIp().getHostAddress(), 54321)));
        return;
    }

    private void protocolListen() {
        BWDLLog.d(TAG, "protocolListen:" + this.mL4Type);
        BWDLConstant.LinkType r8 = this.mL4Type;
        if (r8 != null) goto L5;
        return;
    L5:
        if (r8 != BWDLConstant.LinkType.SocketChannel) goto L9;
        this.mDataLinkSM.sendMessage(BWDLInnerConstant.D_L4LISTEN, 0, 0, 54321);
        return;
    }

    private void sendConnectedToUpper() {
        BWDLLog.d(TAG, "sendConnectedToUpper");
        if (this.mControlLinkProperty.getBWDLCallback() == null) goto L13;
        BWDLConstant.LinkType r8 = this.mL4Type;
        if (r8 == null) goto L10;
        if (r8 != BWDLConstant.LinkType.SocketChannel) goto L10;
        BWDLDevice r10 = new BWDLDevice(BWDLInnerConstant.ConnectivityType.SocketChannel, this.mDataLinkSM.getSocketChannel());
        this.mControlLinkProperty.getBWDLCallback().onEventConnected(this.mControlLinkProperty.getControlLink(), this, r10);
        return;
    L10:
        if (this.mL2Type != BWDLConstant.LinkType.P2P) goto L15;
        this.mControlLinkProperty.getBWDLCallback().onEventConnected(this.mControlLinkProperty.getControlLink(), this, this.mDataLinkSM.getBWDLDeviceL2());
        return;
    L15:
        return;
    }

    private void sendDisconnectedToUpper() {
        BWDLLog.d(TAG, "sendDisconnectedToUpper");
        if (this.mControlLinkProperty.getBWDLCallback() == null) goto L6;
        this.mControlLinkProperty.getBWDLCallback().onEventDisconnected(this);
        return;
    }

    public void connect() {
        BWDLLog.d(TAG, "connect");
        if (this.mControlLinkProperty.getDataLinkLLInfo() != null) goto L5;
        this.mDataLinkSM.sendMessage(BWDLInnerConstant.D_WAIT_L2_SERVER_READY, 0, 0, 0);
        return;
    L5:
        if (this.mDataLinkSM.getCurrentSmStateName().equals("ActiveState") == true) goto L7;
    L10:
        this.mDataLinkSM.sendMessage(BWDLInnerConstant.D_L2CONNECT, 0, 0, this.mControlLinkProperty.getDataLinkLLInfo());
        return;
    L7:
        if (this.mL4Type != null) goto L9;
        sendConnectedToUpper();
        goto L10
    L9:
        protocolConnect();
        goto L10
    }

    public boolean disconnect() {
        BWDLLog.d(TAG, "disconnect");
        DataLinkSM r8 = this.mDataLinkSM;
        if (r8 != null) goto L5;
        return false;
    L5:
        if (r8.getCurrentSmStateName() != null) goto L9;
        BWDLLog.d(TAG, "getCurrentSmStateName == null");
        return false;
    L9:
        if (this.mDataLinkSM.getCurrentSmStateName().equals("TransferringState") == false) goto L13;
        DataLinkSM r10 = this.mDataLinkSM;
        int r11 = BWDLInnerConstant.D_DISCONNECTALL;
    L11:
        r10.sendMessage(r11);
        return true;
    L13:
        if (this.mDataLinkSM.getCurrentSmStateName().equals("DisconnectedState") == true) goto L15;
    L17:
        r10 = this.mDataLinkSM;
        r11 = BWDLInnerConstant.D_L2DISCONNECT;
        goto L11
    L15:
        if (this.mExitFlag == false) goto L17;
        exit();
        return true;
    }

    public DataLinkSM getDataLinkSM() {
        return this.mDataLinkSM;
    }

    public BWDLConstant.LinkType[] getLinkTypes() {
        return this.mLinkTypes;
    }

    public void listen() {
        BWDLLog.d(TAG, "listen");
        if (this.mDataLinkSM.getCurrentSmStateName().equals("ActiveState") == true) goto L5;
        this.mDataLinkSM.sendMessage(BWDLInnerConstant.D_L2LISTEN, 0, 0, null);
        return;
    L5:
        if (this.mL4Type != null) goto L7;
        sendConnectedToUpper();
        return;
    L7:
        protocolListen();
    }

    public void sendConnectFailToUpper() {
        BWDLLog.d(TAG, "sendConnectFailToUpper");
        if (this.mControlLinkProperty.getBWDLCallback() == null) goto L6;
        this.mControlLinkProperty.getBWDLCallback().onEventConnectFail(this.mDataLink);
        return;
    }

    public void setExitFlag(boolean r8) {
        this.mExitFlag = r8;
    }

    public void sendConnectFailToUpper(int r8) {
        BWDLLog.d(TAG, "sendConnectFailWithReasonToUpper");
        if (this.mControlLinkProperty.getBWDLCallback() == null) goto L6;
        this.mControlLinkProperty.getBWDLCallback().onEventConnectFailWithReason(this.mControlLinkProperty.getControlLink(), r8);
        return;
    }
}
