package com.sdk.bwdl.StateMachine;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Message;
import com.obric.cae.userAware.SubwayFusionAware.SubwayUtils;
import com.sdk.bwdl.AdapterLayer.IBWDLAdapter;
import com.sdk.bwdl.AdapterLayer.Wifi.P2p.P2pAdapter;
import com.sdk.bwdl.BWDLDevice;
import com.sdk.bwdl.ControlLinkProperty;
import com.sdk.bwdl.DataLink;
import com.sdk.bwdl.ExternalAPI.BWDLConstant;
import com.sdk.bwdl.Utils.BWDLInnerConstant;
import com.sdk.bwdl.Utils.BWDLLog;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.NoRouteToHostException;
import java.net.SocketTimeoutException;
import java.nio.channels.NotYetBoundException;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class DataLinkSM extends BWDLStateMachine {
    private static final String TAG = "DataLinkSM";
    private ActiveState mActiveState;
    private IBWDLAdapter mBWDLAdapterL2;
    private BWDLDevice mBWDLDeviceL2;
    private ConnectedState mConnectedState;
    private ConnectingState mConnectingState;
    private final Context mContext;
    private ControlLinkProperty mControlLinkProperty;
    private BWDLInnerConstant.DataLinkSmState mCurrentState;
    private DataLink mDataLink;
    private DataLinkEventHandler mDataLinkEventHandler;
    private DataLinkNegotiation mDataLinkNegotiation;
    private DisconnectedState mDisconnectedState;
    private boolean mEncryptFlag;
    private LinkLossState mLinkLossState;
    private BWDLConstant.LinkType[] mLinkTypes;
    private List<IDataLinkSMListener> mListenerList;
    private PowerSavingState mPowerSavingState;
    private IBWDLState mPreState;
    private ProtocolConnectingState mProtocolConnectingState;
    private boolean mRoleNegotiateFlag;
    private RoleNegotiationState mRoleNegotiationState;
    private SecurityState mSecurityState;
    private ServerSocketChannel mServerSocketChannel;
    private SocketChannel mSocketChannel;
    private StateListener mStateListener;
    private TransferringState mTransferringState;
    private WaitL2ServerReadyState mWaitL2ServerReadyState;

    public class ActiveState implements IBWDLState {
        final /* synthetic */ DataLinkSM this$0;

        public ActiveState(DataLinkSM r8) {
            this.this$0 = r8;
        }

        @Override // com.sdk.bwdl.StateMachine.IBWDLState
        public void enter() {
            monitor-enter(this);
            DataLinkSM.access$202(this.this$0, BWDLInnerConstant.DataLinkSmState.ActiveState);     // Catch: Throwable -> L7
            monitor-exit(this);     // Catch: Throwable -> L7
            StringBuilder r8 = new StringBuilder("Enter:");
            android.aimedia.a.o(this.this$0, r8, DataLinkSM.TAG);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.sdk.bwdl.StateMachine.IBWDLState
        public void exit() {
            StringBuilder r8 = new StringBuilder("Exit:");
            android.aimedia.a.o(this.this$0, r8, DataLinkSM.TAG);
            DataLinkSM r10 = this.this$0;
            DataLinkSM.access$102(r10, DataLinkSM.access$1800(r10));
        }

        @Override // com.sdk.bwdl.StateMachine.IBWDLState
        @SuppressLint({"MissingPermission"})
        public boolean processMessage(Message r8) {
            BWDLLog.d(DataLinkSM.TAG, "ActiveState process message:" + DataLinkSM.access$400(r8.what));
            int r10 = r8.what;
            if (r10 != 302) goto L5;
            BWDLLog.d(DataLinkSM.TAG, "process message:" + DataLinkSM.access$400(r8.arg1));
            int r11 = r8.arg1;
            if (r11 == 2) goto L46;
            if (r11 == 1) goto L47;
        L55:
            return true;
        L47:
            DataLinkSM r12 = this.this$0;
            IBWDLState r13 = DataLinkSM.access$1300(r12);
        L49:
            r12.transitionTo(r13);
        L46:
            r12 = this.this$0;
            r13 = DataLinkSM.access$300(r12);
            goto L49
        L5:
            if (r10 != 1103) goto L7;
            r12 = this.this$0;
            r13 = DataLinkSM.access$1900(r12);
            goto L49
        L7:
            if (r10 == 1120) goto L47;
            if (r10 != 1122) goto L11;
            DataLinkSM.access$700(this.this$0).disconnect(DataLinkSM.access$600(this.this$0));
            goto L46
        L11:
            if (r10 != 1115) goto L13;
            int r14 = ((Integer) r8.obj).intValue();
        L42:
            e = move-exception;
            BWDLLog.d(DataLinkSM.TAG, e.getMessage());
        L44:
            r12 = this.this$0;
            r13 = DataLinkSM.access$2100(r12);
            goto L49
        L38:
            if (DataLinkSM.access$2000(this.this$0) == null) goto L40;
            DataLinkSM.access$2000(this.this$0).close();     // Catch: IOException -> L42
        L40:
            DataLinkSM.access$2002(this.this$0, ServerSocketChannel.open());     // Catch: IOException -> L42
            DataLinkSM.access$2000(this.this$0).socket().setReuseAddress(true);     // Catch: IOException -> L42
            DataLinkSM.access$2000(this.this$0).socket().bind(new InetSocketAddress(r14));     // Catch: IOException -> L42
            goto L44
        L13:
            if (r10 == 1116) goto L16;
            return false;
        L16:
            BWDLDevice r15 = (BWDLDevice) r8.obj;
            if (r15.getConnectivityType() != BWDLInnerConstant.ConnectivityType.SocketChannel) goto L55;
            InetSocketAddress r16 = (InetSocketAddress) r15.getDeviceInfo();
            DataLinkSM.access$2202(this.this$0, SocketChannel.open());     // Catch: IOException -> L21
            DataLinkSM.access$2200(this.this$0).connect(r16);     // Catch: IOException -> L21
        L34:
            if (DataLinkSM.access$2200(this.this$0).isConnected() == false) goto L55;
            r12 = this.this$0;
            r13 = DataLinkSM.access$2300(r12);
        L21:
            e = move-exception;
            if ((e instanceof NoRouteToHostException) == false) goto L25;
        L28:
            BWDLLog.e("NetworkError", "No route to host");
            DataLinkSM.access$2200(this.this$0).close();     // Catch: IOException -> L31
            DataLinkSM.access$2202(this.this$0, SocketChannel.open());     // Catch: IOException -> L31
            DataLinkSM.access$2200(this.this$0).connect(r16);     // Catch: IOException -> L31
        L31:
            e = move-exception;
            BWDLLog.e("IOException:", e.toString());
            goto L34
        L25:
            if ((e instanceof SocketTimeoutException) == true) goto L28;
            if ((e instanceof ConnectException) == false) goto L34;
            goto L28
        }
    }

    public class ConnectedState implements IBWDLState {
        final /* synthetic */ DataLinkSM this$0;

        public ConnectedState(DataLinkSM r8) {
            this.this$0 = r8;
        }

        @Override // com.sdk.bwdl.StateMachine.IBWDLState
        public void enter() {
            monitor-enter(this);
            DataLinkSM.access$202(this.this$0, BWDLInnerConstant.DataLinkSmState.ConnectedState);     // Catch: Throwable -> L14
            monitor-exit(this);     // Catch: Throwable -> L14
            if (DataLinkSM.access$1400(this.this$0) == false) goto L9;
            DataLinkSM r8 = this.this$0;
            IBWDLState r10 = DataLinkSM.access$1500(r8);
        L12:
            r8.transitionTo(r10);
            StringBuilder r11 = new StringBuilder("Enter:");
            android.aimedia.a.o(this.this$0, r11, DataLinkSM.TAG);
            return;
        L9:
            if (DataLinkSM.access$1600(this.this$0) == false) goto L11;
            r8 = this.this$0;
            r10 = DataLinkSM.access$1700(r8);
            goto L12
        L11:
            r8 = this.this$0;
            r10 = DataLinkSM.access$1800(r8);
        L14:
            th = move-exception;
            throw th;
        }

        @Override // com.sdk.bwdl.StateMachine.IBWDLState
        public void exit() {
            StringBuilder r8 = new StringBuilder("Exit:");
            android.aimedia.a.o(this.this$0, r8, DataLinkSM.TAG);
            DataLinkSM r10 = this.this$0;
            DataLinkSM.access$102(r10, DataLinkSM.access$1100(r10));
        }

        @Override // com.sdk.bwdl.StateMachine.IBWDLState
        @SuppressLint({"MissingPermission"})
        public boolean processMessage(Message r8) {
            BWDLLog.d(DataLinkSM.TAG, "ConnectedState process message:" + DataLinkSM.access$400(r8.what));
            if (r8.what == 302) goto L6;
            return false;
        L6:
            BWDLLog.d(DataLinkSM.TAG, "process message:" + DataLinkSM.access$400(r8.arg1));
            int r10 = r8.arg1;
            if (r10 != 2) goto L10;
            DataLinkSM r11 = this.this$0;
            IBWDLState r12 = DataLinkSM.access$300(r11);
        L9:
            r11.transitionTo(r12);
        L12:
            return true;
        L10:
            if (r10 != 1) goto L12;
            r11 = this.this$0;
            r12 = DataLinkSM.access$1300(r11);
            goto L9
        }
    }

    public class ConnectingState implements IBWDLState {
        final /* synthetic */ DataLinkSM this$0;

        public ConnectingState(DataLinkSM r8) {
            this.this$0 = r8;
        }

        @Override // com.sdk.bwdl.StateMachine.IBWDLState
        public void enter() {
            monitor-enter(this);
            DataLinkSM.access$202(this.this$0, BWDLInnerConstant.DataLinkSmState.ConnectingState);     // Catch: Throwable -> L7
            this.this$0.sendMessageDelayed(BWDLInnerConstant.D_L2CONNECTING_TIMEOUT, SubwayUtils.OUTDOOR_PUNISH_DELAY_TIME);     // Catch: Throwable -> L7
            monitor-exit(this);     // Catch: Throwable -> L7
            StringBuilder r8 = new StringBuilder("Enter:");
            android.aimedia.a.o(this.this$0, r8, DataLinkSM.TAG);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.sdk.bwdl.StateMachine.IBWDLState
        public void exit() {
            StringBuilder r8 = new StringBuilder("Exit:");
            android.aimedia.a.o(this.this$0, r8, DataLinkSM.TAG);
            DataLinkSM r10 = this.this$0;
            DataLinkSM.access$102(r10, DataLinkSM.access$800(r10));
            this.this$0.removeMessages(BWDLInnerConstant.D_L2CONNECTING_TIMEOUT);
        }

        @Override // com.sdk.bwdl.StateMachine.IBWDLState
        public boolean processMessage(Message r8) {
            BWDLLog.d(DataLinkSM.TAG, "ConnectingState process message:" + DataLinkSM.access$400(r8.what));
            int r10 = r8.what;
            if (r10 != 302) goto L5;
            BWDLLog.d(DataLinkSM.TAG, "process message:" + DataLinkSM.access$400(r8.arg1));
            int r11 = r8.arg1;
            if (r11 != 4) goto L24;
            this.this$0.setBWDLDeviceL2((BWDLDevice) r8.obj);
            DataLinkSM r12 = this.this$0;
            IBWDLState r13 = DataLinkSM.access$1100(r12);
        L16:
            r12.transitionTo(r13);
        L28:
            return true;
        L24:
            if (r11 == 2) goto L15;
            if (r11 != 1) goto L28;
            r12 = this.this$0;
            r13 = DataLinkSM.access$1300(r12);
        L15:
            r12 = this.this$0;
            r13 = DataLinkSM.access$300(r12);
            goto L16
        L5:
            if (r10 != 1122) goto L7;
            DataLinkSM.access$700(this.this$0).disconnect(DataLinkSM.access$600(this.this$0));
            goto L15
        L7:
            if (r10 != 1126) goto L9;
            DataLinkSM.access$1200(this.this$0).sendConnectFailToUpper();
            goto L15
        L9:
            if (r10 != 304) goto L11;
            DataLinkSM.access$1000(this.this$0).sendDataLinkReq(DataLinkSM.access$900(this.this$0));
            goto L28
        L11:
            if (r10 == 305) goto L14;
            return false;
        L14:
            DataLinkSM.access$700(this.this$0).disconnect(DataLinkSM.access$600(this.this$0));
            DataLinkSM.access$1200(this.this$0).sendConnectFailToUpper(r8.arg1);
            goto L15
        }
    }

    public class DisconnectedState implements IBWDLState {
        final /* synthetic */ DataLinkSM this$0;

        public DisconnectedState(DataLinkSM r8) {
            this.this$0 = r8;
        }

        @Override // com.sdk.bwdl.StateMachine.IBWDLState
        public void enter() {
            monitor-enter(this);
            DataLinkSM.access$202(this.this$0, BWDLInnerConstant.DataLinkSmState.DisconnectedState);     // Catch: Throwable -> L7
            this.this$0.setBWDLDeviceL2(null);     // Catch: Throwable -> L7
            monitor-exit(this);     // Catch: Throwable -> L7
            StringBuilder r8 = new StringBuilder("Enter:");
            android.aimedia.a.o(this.this$0, r8, DataLinkSM.TAG);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.sdk.bwdl.StateMachine.IBWDLState
        public void exit() {
            StringBuilder r8 = new StringBuilder("Exit:");
            android.aimedia.a.o(this.this$0, r8, DataLinkSM.TAG);
            DataLinkSM r10 = this.this$0;
            DataLinkSM.access$102(r10, DataLinkSM.access$300(r10));
        }

        @Override // com.sdk.bwdl.StateMachine.IBWDLState
        @SuppressLint({"MissingPermission"})
        public boolean processMessage(Message r8) {
            BWDLLog.d(DataLinkSM.TAG, "DisconnectedState process message:" + DataLinkSM.access$400(r8.what));
            int r10 = r8.what;
            if (r10 != 302) goto L5;
            BWDLLog.d(DataLinkSM.TAG, "process message:" + DataLinkSM.access$400(r8.arg1));
            if (r8.arg1 != 4) goto L26;
            this.this$0.setBWDLDeviceL2((BWDLDevice) r8.obj);
            DataLinkSM r11 = this.this$0;
            IBWDLState r12 = DataLinkSM.access$1100(r11);
        L19:
            r11.transitionTo(r12);
            return true;
        L26:
            return true;
        L5:
            if (r10 != 1112) goto L7;
            DataLinkSM.access$700(this.this$0).listen();
            DataLinkSM.access$1000(this.this$0).sendDataLinkReq(DataLinkSM.access$900(this.this$0));
        L18:
            r11 = this.this$0;
            r12 = DataLinkSM.access$800(r11);
            goto L19
        L7:
            if (r10 != 1113) goto L9;
            DataLinkSM.access$700(this.this$0).connect((BWDLDevice) r8.obj);
            goto L18
        L9:
            if (r10 != 1124) goto L11;
            DataLinkSM.access$602(this.this$0, (BWDLDevice) r8.obj);
            return true;
        L11:
            if (r10 == 1125) goto L14;
            return false;
        L14:
            r11 = this.this$0;
            r12 = DataLinkSM.access$500(r11);
            goto L19
        }
    }

    public interface IDataLinkSMListener {
        void onStateChanged(String r8, String r10);
    }

    public class LinkLossState implements IBWDLState {
        final /* synthetic */ DataLinkSM this$0;

        public LinkLossState(DataLinkSM r8) {
            this.this$0 = r8;
        }

        @Override // com.sdk.bwdl.StateMachine.IBWDLState
        public void enter() {
            monitor-enter(this);
            DataLinkSM.access$202(this.this$0, BWDLInnerConstant.DataLinkSmState.LinkLossState);     // Catch: Throwable -> L7
            monitor-exit(this);     // Catch: Throwable -> L7
            StringBuilder r8 = new StringBuilder("Enter:");
            android.aimedia.a.o(this.this$0, r8, DataLinkSM.TAG);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.sdk.bwdl.StateMachine.IBWDLState
        public void exit() {
            StringBuilder r8 = new StringBuilder("Exit:");
            android.aimedia.a.o(this.this$0, r8, DataLinkSM.TAG);
            DataLinkSM r10 = this.this$0;
            DataLinkSM.access$102(r10, DataLinkSM.access$1300(r10));
        }

        @Override // com.sdk.bwdl.StateMachine.IBWDLState
        @SuppressLint({"MissingPermission"})
        public boolean processMessage(Message r8) {
            BWDLLog.d(DataLinkSM.TAG, "LinkLossState process message:" + DataLinkSM.access$400(r8.what));
            if (r8.what == 1107) goto L6;
            return false;
        L6:
            return true;
        }
    }

    public class PowerSavingState implements IBWDLState {
        final /* synthetic */ DataLinkSM this$0;

        public PowerSavingState(DataLinkSM r8) {
            this.this$0 = r8;
        }

        @Override // com.sdk.bwdl.StateMachine.IBWDLState
        public void enter() {
            monitor-enter(this);
            DataLinkSM.access$202(this.this$0, BWDLInnerConstant.DataLinkSmState.PowerSavingState);     // Catch: Throwable -> L7
            monitor-exit(this);     // Catch: Throwable -> L7
            StringBuilder r8 = new StringBuilder("Enter:");
            android.aimedia.a.o(this.this$0, r8, DataLinkSM.TAG);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.sdk.bwdl.StateMachine.IBWDLState
        public void exit() {
            StringBuilder r8 = new StringBuilder("Exit:");
            android.aimedia.a.o(this.this$0, r8, DataLinkSM.TAG);
            DataLinkSM r10 = this.this$0;
            DataLinkSM.access$102(r10, DataLinkSM.access$1900(r10));
        }

        @Override // com.sdk.bwdl.StateMachine.IBWDLState
        public boolean processMessage(Message r8) {
            BWDLLog.d(DataLinkSM.TAG, "PowerSavingState process message:" + DataLinkSM.access$400(r8.what));
            if (r8.what == 1104) goto L6;
            return false;
        L6:
            DataLinkSM r10 = this.this$0;
            r10.transitionTo(DataLinkSM.access$1800(r10));
            return true;
        }
    }

    public class ProtocolConnectingState implements IBWDLState {
        final /* synthetic */ DataLinkSM this$0;

        public ProtocolConnectingState(DataLinkSM r8) {
            this.this$0 = r8;
        }

        @Override // com.sdk.bwdl.StateMachine.IBWDLState
        public void enter() {
            monitor-enter(this);
            DataLinkSM.access$202(this.this$0, BWDLInnerConstant.DataLinkSmState.ProtocolConnectingState);     // Catch: Throwable -> L17
            this.this$0.sendMessageDelayed(BWDLInnerConstant.D_L4CONNECTING_TIMEOUT, SubwayUtils.OUTDOOR_PUNISH_DELAY_TIME);     // Catch: Throwable -> L17
            monitor-exit(this);     // Catch: Throwable -> L17
            StringBuilder r8 = new StringBuilder("Enter:");
            android.aimedia.a.o(this.this$0, r8, DataLinkSM.TAG);
            if (DataLinkSM.access$2000(this.this$0) == null) goto L24;
            DataLinkSM r10 = this.this$0;     // Catch: IOException -> L13 NotYetBoundException -> L15
            DataLinkSM.access$2202(r10, DataLinkSM.access$2000(r10).accept());     // Catch: IOException -> L13 NotYetBoundException -> L15
            if (DataLinkSM.access$2200(this.this$0).isConnected() == false) goto L10;
            DataLinkSM r11 = this.this$0;     // Catch: IOException -> L13 NotYetBoundException -> L15
            IBWDLState r12 = DataLinkSM.access$2300(r11);     // Catch: IOException -> L13 NotYetBoundException -> L15
        L11:
            r11.transitionTo(r12);     // Catch: IOException -> L13 NotYetBoundException -> L15
        L26:
            return;
        L10:
            r11 = this.this$0;     // Catch: IOException -> L13 NotYetBoundException -> L15
            r12 = DataLinkSM.access$1800(r11);     // Catch: IOException -> L13 NotYetBoundException -> L15
        L13:
            e = move-exception;
            BWDLLog.d(DataLinkSM.TAG, e.getMessage());
            return;
        L15:
            BWDLLog.e("NetworkError", "NotYetBoundException");
            DataLinkSM r13 = this.this$0;
            r13.transitionTo(DataLinkSM.access$1800(r13));
            return;
        L24:
            return;
        L17:
            th = move-exception;
            throw th;
        }

        @Override // com.sdk.bwdl.StateMachine.IBWDLState
        public void exit() {
            StringBuilder r8 = new StringBuilder("Exit:");
            android.aimedia.a.o(this.this$0, r8, DataLinkSM.TAG);
            DataLinkSM r10 = this.this$0;
            DataLinkSM.access$102(r10, DataLinkSM.access$2100(r10));
            this.this$0.removeMessages(BWDLInnerConstant.D_L4CONNECTING_TIMEOUT);
        }

        @Override // com.sdk.bwdl.StateMachine.IBWDLState
        @SuppressLint({"MissingPermission"})
        public boolean processMessage(Message r8) {
            BWDLLog.d(DataLinkSM.TAG, "ProtocolListenState process message:" + DataLinkSM.access$400(r8.what));
            int r10 = r8.what;
            if (r10 != 1117) goto L5;
            DataLinkSM r11 = this.this$0;
            r11.transitionTo(DataLinkSM.access$2300(r11));
            return true;
        L5:
            if (r10 == 1121) goto L8;
            return false;
        L8:
            DataLinkSM r12 = this.this$0;
            r12.transitionTo(DataLinkSM.access$1800(r12));
            DataLinkSM.access$1200(this.this$0).sendConnectFailToUpper();
            return true;
        }
    }

    public class RoleNegotiationState implements IBWDLState {
        final /* synthetic */ DataLinkSM this$0;

        public RoleNegotiationState(DataLinkSM r8) {
            this.this$0 = r8;
        }

        @Override // com.sdk.bwdl.StateMachine.IBWDLState
        public void enter() {
            monitor-enter(this);
            DataLinkSM.access$202(this.this$0, BWDLInnerConstant.DataLinkSmState.RoleNegotiationState);     // Catch: Throwable -> L7
            monitor-exit(this);     // Catch: Throwable -> L7
            StringBuilder r8 = new StringBuilder("Enter:");
            android.aimedia.a.o(this.this$0, r8, DataLinkSM.TAG);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.sdk.bwdl.StateMachine.IBWDLState
        public void exit() {
            StringBuilder r8 = new StringBuilder("Exit:");
            android.aimedia.a.o(this.this$0, r8, DataLinkSM.TAG);
            DataLinkSM r10 = this.this$0;
            DataLinkSM.access$102(r10, DataLinkSM.access$1500(r10));
        }

        @Override // com.sdk.bwdl.StateMachine.IBWDLState
        @SuppressLint({"MissingPermission"})
        public boolean processMessage(Message r8) {
            BWDLLog.d(DataLinkSM.TAG, "RoleNegotiationState process message:" + DataLinkSM.access$400(r8.what));
            if (r8.what == 302) goto L6;
            return false;
        L6:
            BWDLLog.d(DataLinkSM.TAG, "process message:" + DataLinkSM.access$400(r8.arg1));
            int r10 = r8.arg1;
            if (r10 != 2) goto L10;
            DataLinkSM r11 = this.this$0;
            IBWDLState r12 = DataLinkSM.access$300(r11);
        L9:
            r11.transitionTo(r12);
        L12:
            return true;
        L10:
            if (r10 != 1) goto L12;
            r11 = this.this$0;
            r12 = DataLinkSM.access$1300(r11);
            goto L9
        }
    }

    public class SecurityState implements IBWDLState {
        final /* synthetic */ DataLinkSM this$0;

        public SecurityState(DataLinkSM r8) {
            this.this$0 = r8;
        }

        @Override // com.sdk.bwdl.StateMachine.IBWDLState
        public void enter() {
            monitor-enter(this);
            DataLinkSM.access$202(this.this$0, BWDLInnerConstant.DataLinkSmState.SecurityState);     // Catch: Throwable -> L7
            monitor-exit(this);     // Catch: Throwable -> L7
            StringBuilder r8 = new StringBuilder("Enter:");
            android.aimedia.a.o(this.this$0, r8, DataLinkSM.TAG);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.sdk.bwdl.StateMachine.IBWDLState
        public void exit() {
            StringBuilder r8 = new StringBuilder("Exit:");
            android.aimedia.a.o(this.this$0, r8, DataLinkSM.TAG);
            DataLinkSM r10 = this.this$0;
            DataLinkSM.access$102(r10, DataLinkSM.access$1700(r10));
        }

        @Override // com.sdk.bwdl.StateMachine.IBWDLState
        public boolean processMessage(Message r8) {
            BWDLLog.d(DataLinkSM.TAG, "SecurityState process message:" + DataLinkSM.access$400(r8.what));
            if (r8.what == 1119) goto L6;
            return false;
        L6:
            DataLinkSM r10 = this.this$0;
            r10.transitionTo(DataLinkSM.access$1800(r10));
            return true;
        }
    }

    public class StateListener implements BWDLStateMachine.IStateListener {
        final /* synthetic */ DataLinkSM this$0;

        public StateListener(DataLinkSM r8) {
            this.this$0 = r8;
        }

        @Override // com.sdk.bwdl.StateMachine.BWDLStateMachine.IStateListener
        public void onStateChanged(IBWDLState r8) {
            Iterator r10 = DataLinkSM.access$000(this.this$0).iterator();
        L4:
            if (r10.hasNext() == false) goto L6;
            ((IDataLinkSMListener) r10.next()).onStateChanged(DataLinkSM.access$100(this.this$0).getClass().getSimpleName(), r8.getClass().getSimpleName());
            goto L4
        }
    }

    public class TransferringState implements IBWDLState {
        final /* synthetic */ DataLinkSM this$0;

        public TransferringState(DataLinkSM r8) {
            this.this$0 = r8;
        }

        @Override // com.sdk.bwdl.StateMachine.IBWDLState
        public void enter() {
            monitor-enter(this);
            DataLinkSM.access$202(this.this$0, BWDLInnerConstant.DataLinkSmState.TransferringState);     // Catch: Throwable -> L7
            monitor-exit(this);     // Catch: Throwable -> L7
            StringBuilder r8 = new StringBuilder("Enter:");
            android.aimedia.a.o(this.this$0, r8, DataLinkSM.TAG);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.sdk.bwdl.StateMachine.IBWDLState
        public void exit() {
            StringBuilder r8 = new StringBuilder("Exit:");
            android.aimedia.a.o(this.this$0, r8, DataLinkSM.TAG);
            DataLinkSM r10 = this.this$0;
            DataLinkSM.access$102(r10, DataLinkSM.access$2300(r10));
        }

        @Override // com.sdk.bwdl.StateMachine.IBWDLState
        @SuppressLint({"MissingPermission"})
        public boolean processMessage(Message r8) {
            BWDLLog.d(DataLinkSM.TAG, "TransferringState process message:" + DataLinkSM.access$400(r8.what));
            int r10 = r8.what;
            if (r10 != 302) goto L5;
            BWDLLog.d(DataLinkSM.TAG, "process message:" + DataLinkSM.access$400(r8.arg1));
            int r11 = r8.arg1;
            if (r11 == 2) goto L36;
            if (r11 != 1) goto L35;
            DataLinkSM r12 = this.this$0;
            IBWDLState r13 = DataLinkSM.access$1300(r12);
        L34:
            r12.transitionTo(r13);
        L35:
            return true;
        L36:
        L30:
            e = e;
        L16:
            BWDLLog.d(DataLinkSM.TAG, e.getMessage());
        L17:
            r12 = this.this$0;
            r13 = DataLinkSM.access$300(r12);
            goto L34
        L26:
            if (DataLinkSM.access$2000(this.this$0) == null) goto L28;
            DataLinkSM.access$2000(this.this$0).close();     // Catch: IOException -> L30
        L28:
            DataLinkSM.access$2200(this.this$0).close();     // Catch: IOException -> L30
            goto L17
        L5:
            if (r10 != 1118) goto L7;
            DataLinkSM.access$2200(this.this$0).close();     // Catch: IOException -> L20
            DataLinkSM.access$2000(this.this$0).close();     // Catch: IOException -> L20
        L22:
            r12 = this.this$0;
            r13 = DataLinkSM.access$1800(r12);
        L20:
            e = move-exception;
            BWDLLog.d(DataLinkSM.TAG, e.getMessage());
            goto L22
        L7:
            if (r10 == 1123) goto L40;
            return false;
        L40:
            DataLinkSM.access$700(this.this$0).disconnect(DataLinkSM.access$600(this.this$0));     // Catch: IOException -> L15
            DataLinkSM.access$700(this.this$0).close();     // Catch: IOException -> L15
            if (DataLinkSM.access$2000(this.this$0) == null) goto L13;
            DataLinkSM.access$2000(this.this$0).close();     // Catch: IOException -> L15
        L13:
            DataLinkSM.access$2200(this.this$0).close();     // Catch: IOException -> L15
        L15:
            e = e;
            goto L16
        }
    }

    public class WaitL2ServerReadyState implements IBWDLState {
        final /* synthetic */ DataLinkSM this$0;

        public WaitL2ServerReadyState(DataLinkSM r8) {
            this.this$0 = r8;
        }

        @Override // com.sdk.bwdl.StateMachine.IBWDLState
        public void enter() {
            monitor-enter(this);
            DataLinkSM.access$202(this.this$0, BWDLInnerConstant.DataLinkSmState.WaitL2ServerReadyState);     // Catch: Throwable -> L7
            monitor-exit(this);     // Catch: Throwable -> L7
            StringBuilder r8 = new StringBuilder("Enter:");
            android.aimedia.a.o(this.this$0, r8, DataLinkSM.TAG);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.sdk.bwdl.StateMachine.IBWDLState
        public void exit() {
            StringBuilder r8 = new StringBuilder("Exit:");
            android.aimedia.a.o(this.this$0, r8, DataLinkSM.TAG);
            DataLinkSM r10 = this.this$0;
            DataLinkSM.access$102(r10, DataLinkSM.access$500(r10));
        }

        @Override // com.sdk.bwdl.StateMachine.IBWDLState
        public boolean processMessage(Message r8) {
            BWDLLog.d(DataLinkSM.TAG, "ConnectingState process message:" + DataLinkSM.access$400(r8.what));
            int r10 = r8.what;
            if (r10 != 1122) goto L5;
            DataLinkSM r11 = this.this$0;
            IBWDLState r12 = DataLinkSM.access$300(r11);
        L10:
            r11.transitionTo(r12);
            return true;
        L5:
            if (r10 == 1124) goto L8;
            return false;
        L8:
            DataLinkSM.access$602(this.this$0, (BWDLDevice) r8.obj);
            DataLinkSM.access$700(this.this$0).connect(DataLinkSM.access$600(this.this$0));
            r11 = this.this$0;
            r12 = DataLinkSM.access$800(r11);
            goto L10
        }
    }

    public DataLinkSM(Context r8, DataLink r10, ControlLinkProperty r11, BWDLInnerConstant.DataLinkSmState r12) {
        super(TAG);
        this.mListenerList = new CopyOnWriteArrayList();
        int r13 = 0;
        this.mEncryptFlag = false;
        this.mRoleNegotiateFlag = false;
        BWDLLog.d(TAG, "new DataLinkSM for:" + r10);
        this.mContext = r8;
        this.mLinkTypes = r10.getLinkTypes();
        this.mDataLink = r10;
        this.mControlLinkProperty = r11;
        this.mDataLinkNegotiation = new DataLinkNegotiation(r8, r11);
        if (this.mDataLinkEventHandler != null) goto L5;
        this.mDataLinkEventHandler = new DataLinkEventHandler(r8, this, this.mLinkTypes, r11);
    L5:
        init(r12);
        start();
        BWDLConstant.LinkType[] r14 = this.mLinkTypes;
        int r15 = r14.length;
    L6:
        if (r13 >= r15) goto L11;
        if (r14[r13] != BWDLConstant.LinkType.P2P) goto L10;
        this.mBWDLAdapterL2 = P2pAdapter.getInstance(this.mContext, r11.getBWDLConfigs().getP2pBand());
    L10:
        r13 = r13 + 1;
        goto L6
    L11:
        StateListener r16 = new StateListener(this);
        this.mStateListener = r16;
        setStateListener(r16);
    }

    public static /* synthetic */ List access$000(DataLinkSM r8) {
        return r8.mListenerList;
    }

    public static /* synthetic */ IBWDLState access$100(DataLinkSM r8) {
        return r8.mPreState;
    }

    public static /* synthetic */ DataLinkNegotiation access$1000(DataLinkSM r8) {
        return r8.mDataLinkNegotiation;
    }

    public static /* synthetic */ IBWDLState access$102(DataLinkSM r8, IBWDLState r10) {
        r8.mPreState = r10;
        return r10;
    }

    public static /* synthetic */ ConnectedState access$1100(DataLinkSM r8) {
        return r8.mConnectedState;
    }

    public static /* synthetic */ DataLink access$1200(DataLinkSM r8) {
        return r8.mDataLink;
    }

    public static /* synthetic */ LinkLossState access$1300(DataLinkSM r8) {
        return r8.mLinkLossState;
    }

    public static /* synthetic */ boolean access$1400(DataLinkSM r8) {
        return r8.mRoleNegotiateFlag;
    }

    public static /* synthetic */ RoleNegotiationState access$1500(DataLinkSM r8) {
        return r8.mRoleNegotiationState;
    }

    public static /* synthetic */ boolean access$1600(DataLinkSM r8) {
        return r8.mEncryptFlag;
    }

    public static /* synthetic */ SecurityState access$1700(DataLinkSM r8) {
        return r8.mSecurityState;
    }

    public static /* synthetic */ ActiveState access$1800(DataLinkSM r8) {
        return r8.mActiveState;
    }

    public static /* synthetic */ PowerSavingState access$1900(DataLinkSM r8) {
        return r8.mPowerSavingState;
    }

    public static /* synthetic */ BWDLInnerConstant.DataLinkSmState access$200(DataLinkSM r8) {
        return r8.mCurrentState;
    }

    public static /* synthetic */ ServerSocketChannel access$2000(DataLinkSM r8) {
        return r8.mServerSocketChannel;
    }

    public static /* synthetic */ ServerSocketChannel access$2002(DataLinkSM r8, ServerSocketChannel r10) {
        r8.mServerSocketChannel = r10;
        return r10;
    }

    public static /* synthetic */ BWDLInnerConstant.DataLinkSmState access$202(DataLinkSM r8, BWDLInnerConstant.DataLinkSmState r10) {
        r8.mCurrentState = r10;
        return r10;
    }

    public static /* synthetic */ ProtocolConnectingState access$2100(DataLinkSM r8) {
        return r8.mProtocolConnectingState;
    }

    public static /* synthetic */ SocketChannel access$2200(DataLinkSM r8) {
        return r8.mSocketChannel;
    }

    public static /* synthetic */ SocketChannel access$2202(DataLinkSM r8, SocketChannel r10) {
        r8.mSocketChannel = r10;
        return r10;
    }

    public static /* synthetic */ TransferringState access$2300(DataLinkSM r8) {
        return r8.mTransferringState;
    }

    public static /* synthetic */ DisconnectedState access$300(DataLinkSM r8) {
        return r8.mDisconnectedState;
    }

    public static /* synthetic */ String access$400(int r8) {
        return transformIntegerToString(r8);
    }

    public static /* synthetic */ WaitL2ServerReadyState access$500(DataLinkSM r8) {
        return r8.mWaitL2ServerReadyState;
    }

    public static /* synthetic */ BWDLDevice access$600(DataLinkSM r8) {
        return r8.mBWDLDeviceL2;
    }

    public static /* synthetic */ BWDLDevice access$602(DataLinkSM r8, BWDLDevice r10) {
        r8.mBWDLDeviceL2 = r10;
        return r10;
    }

    public static /* synthetic */ IBWDLAdapter access$700(DataLinkSM r8) {
        return r8.mBWDLAdapterL2;
    }

    public static /* synthetic */ ConnectingState access$800(DataLinkSM r8) {
        return r8.mConnectingState;
    }

    public static /* synthetic */ BWDLConstant.LinkType[] access$900(DataLinkSM r8) {
        return r8.mLinkTypes;
    }

    private void init(BWDLInnerConstant.DataLinkSmState r8) {
        this.mDisconnectedState = new DisconnectedState(this);
        this.mConnectingState = new ConnectingState(this);
        this.mConnectedState = new ConnectedState(this);
        this.mRoleNegotiationState = new RoleNegotiationState(this);
        this.mSecurityState = new SecurityState(this);
        this.mActiveState = new ActiveState(this);
        this.mPowerSavingState = new PowerSavingState(this);
        this.mLinkLossState = new LinkLossState(this);
        this.mTransferringState = new TransferringState(this);
        this.mProtocolConnectingState = new ProtocolConnectingState(this);
        this.mWaitL2ServerReadyState = new WaitL2ServerReadyState(this);
        DisconnectedState r10 = this.mDisconnectedState;
        this.mPreState = r10;
        this.mCurrentState = r8;
        addState(r10);
        addState(this.mConnectingState);
        addState(this.mConnectedState);
        addState(this.mRoleNegotiationState);
        addState(this.mSecurityState);
        addState(this.mActiveState);
        addState(this.mPowerSavingState);
        addState(this.mLinkLossState);
        addState(this.mTransferringState);
        addState(this.mProtocolConnectingState);
        addState(this.mWaitL2ServerReadyState);
        if (r8 != BWDLInnerConstant.DataLinkSmState.DisconnectedState) goto L7;
        IBWDLState r11 = this.mDisconnectedState;
    L5:
        setInitialState(r11);
        return;
    L7:
        if (r8 != BWDLInnerConstant.DataLinkSmState.ActiveState) goto L10;
        r11 = this.mActiveState;
        goto L5
    }

    private static String transformIntegerToString(int r8) {
        if (r8 != 1) goto L5;
        return "LinkLoss";
    L5:
        if (r8 != 2) goto L7;
        return "Disconnected";
    L7:
        if (r8 != 3) goto L9;
        return "Connecting";
    L9:
        if (r8 != 4) goto L11;
        return "Connected";
    L11:
        if (r8 != 302) goto L13;
        return "LL_CONNECTION_STATE_CHANGE";
    L13:
        if (r8 != 1107) goto L15;
        return "LINK_RECOVERY";
    L15:
        if (r8 != 304) goto L17;
        return "LL_PARAM_AVAILABLE";
    L17:
        if (r8 != 305) goto L19;
        return "LL_PARAM_FAIL";
    L19:
        if (r8 != 1112) goto L21;
        return "D_L2LISTEN";
    L21:
        if (r8 != 1113) goto L23;
        return "D_L2CONNECT";
    L23:
        if (r8 != 1115) goto L25;
        return "D_L4LISTEN";
    L25:
        if (r8 == 1116) goto L41;
        switch(r8) {
            case 1121: goto L39;
            case 1122: goto L37;
            case 1123: goto L35;
            case 1124: goto L33;
            case 1125: goto L31;
            case 1126: goto L29;
            default: goto L27;
        };
    L27:
        return "Unknown";
    L29:
        return "D_L2CONNECTING_TIMEOUT";
    L31:
        return "D_WAIT_L2_SERVER_READY";
    L33:
        return "D_L2_SERVER_READY";
    L35:
        return "D_DISCONNECTALL";
    L37:
        return "D_L2DISCONNECT";
    L39:
        return "D_L4CONNECTING_TIMEOUT";
    L41:
        return "D_L4CONNECT";
    }

    public void cleanup() {
        BWDLLog.d(TAG, "cleanup");
        this.mPreState = this.mDisconnectedState;
        ServerSocketChannel r8 = this.mServerSocketChannel;
        if (r8 != null) goto L19;
    L8:
        SocketChannel r10 = this.mSocketChannel;
        if (r10 != null) goto L21;
    L14:
        this.mCurrentState = BWDLInnerConstant.DataLinkSmState.DisconnectedState;
        this.mBWDLAdapterL2.close();
        DataLinkEventHandler r11 = this.mDataLinkEventHandler;
        if (r11 == null) goto L17;
        r11.cleanup();
        this.mDataLinkEventHandler = null;
    L17:
        quitNow();
        return;
    L21:
        r10.close();     // Catch: IOException -> L12
    L12:
        e = move-exception;
        BWDLLog.d(TAG, "IOException:" + e.getMessage());
        goto L14
    L19:
        r8.close();     // Catch: IOException -> L6
    L6:
        e = move-exception;
        BWDLLog.d(TAG, "IOException:" + e.getMessage());
        goto L8
    }

    public BWDLDevice getBWDLDeviceL2() {
        return this.mBWDLDeviceL2;
    }

    public String getCurrentSmStateName() {
        if (getCurrentState() != null) goto L5;
        return null;
    L5:
        return getCurrentState().getClass().getSimpleName();
    }

    public SocketChannel getSocketChannel() {
        return this.mSocketChannel;
    }

    public void removeDataLinkSMListener(IDataLinkSMListener r8) {
        List<IDataLinkSMListener> r10 = this.mListenerList;
        monitor-enter(r10);
        this.mListenerList.remove(r8);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setBWDLDeviceL2(BWDLDevice r8) {
        this.mBWDLDeviceL2 = r8;
    }

    public void setDataLinkSMListener(IDataLinkSMListener r8) {
        List<IDataLinkSMListener> r10 = this.mListenerList;
        monitor-enter(r10);
        this.mListenerList.add(r8);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
