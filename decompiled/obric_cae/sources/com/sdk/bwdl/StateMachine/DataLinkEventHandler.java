package com.sdk.bwdl.StateMachine;

import android.content.Context;
import android.net.wifi.p2p.WifiP2pGroup;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.sdk.bwdl.AdapterLayer.IBWDLAdapter;
import com.sdk.bwdl.AdapterLayer.IBWDLAdapterEventListener;
import com.sdk.bwdl.AdapterLayer.Wifi.P2p.P2pAdapter;
import com.sdk.bwdl.AdapterLayer.Wifi.P2p.P2pCallback;
import com.sdk.bwdl.BWDLDevice;
import com.sdk.bwdl.ControlLinkProperty;
import com.sdk.bwdl.ExternalAPI.BWDLConstant;
import com.sdk.bwdl.Utils.BWDLInnerConstant;
import com.sdk.bwdl.Utils.BWDLLog;
import java.net.InetAddress;

/* JADX INFO: loaded from: classes2.dex */
public class DataLinkEventHandler {
    private static final int MSG_CONNECTION_STATE_CHANGE = 1;
    private static final int MSG_IP_AVAILABLE = 2;
    private static final int MSG_P2P_GROUP_AVAILABLE = 3;
    private static final String TAG = "DataLinkEventHandler";
    private BWDLAdapterEventHandler mAdapterEventHandler;
    private BWDLAdapterEventListener mAdapterEventListener;
    private IBWDLAdapter mBWDLAdapter;
    private Context mContext;
    private ControlLinkProperty mControlLinkProperty;
    private DataLinkSM mDataLinkSM;
    private HandlerThread mEventHandlerThread;
    private BWDLConstant.LinkType[] mLinkTypes;
    private P2pAdapter mP2pAdapter;

    /* JADX INFO: renamed from: com.sdk.bwdl.StateMachine.DataLinkEventHandler$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class BWDLAdapterEventHandler extends Handler {
        final /* synthetic */ DataLinkEventHandler this$0;

        public BWDLAdapterEventHandler(DataLinkEventHandler r8, Looper r10) {
            this.this$0 = r8;
            super(r10);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r8) {
            BWDLLog.d(DataLinkEventHandler.TAG, "handleMessage: " + DataLinkEventHandler.access$100(this.this$0, r8.what));
            int r10 = r8.what;
            if (r10 != 1) goto L5;
            DataLinkEventHandler.access$200(this.this$0).sendMessage(BWDLInnerConstant.LL_CONNECTION_STATE_CHANGE, r8.arg1, 0, r8.obj);
            return;
        L5:
            if (r10 != 3) goto L11;
            DataLinkEventHandler.access$200(this.this$0).sendMessage(BWDLInnerConstant.LL_PARAM_AVAILABLE, new BWDLDevice(BWDLInnerConstant.ConnectivityType.P2P, r8.obj));
            return;
        }
    }

    public class BWDLAdapterEventListener implements IBWDLAdapterEventListener, P2pCallback {
        final /* synthetic */ DataLinkEventHandler this$0;

        private BWDLAdapterEventListener(DataLinkEventHandler r8) {
            this.this$0 = r8;
        }

        @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapterEventListener
        public void onBondStateChanged(BWDLDevice r8, int r10) {
        }

        @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapterEventListener
        public void onConnectTimeOut(IBWDLAdapter r8) {
        }

        @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapterEventListener
        public void onConnected(IBWDLAdapter r8) {
        }

        @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapterEventListener
        public void onConnectionStateChanged(BWDLDevice r8, int r10) {
            DataLinkEventHandler.access$300(this.this$0, 1, r10, 0, r8);
        }

        @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapterEventListener
        public void onDataReceived(byte[] r8) {
        }

        @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapterEventListener
        public void onDisconnected(IBWDLAdapter r8) {
        }

        @Override // com.sdk.bwdl.AdapterLayer.Wifi.P2p.P2pCallback
        public void onP2pGroupAvailable(WifiP2pGroup r8) {
            DataLinkEventHandler.access$300(this.this$0, 3, 0, 0, r8);
        }

        @Override // com.sdk.bwdl.AdapterLayer.Wifi.P2p.P2pCallback
        public void onP2pGroupIpAvailable(InetAddress r8) {
            DataLinkEventHandler.access$300(this.this$0, 2, 0, 0, r8);
        }

        @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapterEventListener
        public void onWriteComplete(int r8) {
        }

        public /* synthetic */ BWDLAdapterEventListener(DataLinkEventHandler r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public DataLinkEventHandler(Context r8, DataLinkSM r10, BWDLConstant.LinkType[] r11, ControlLinkProperty r12) {
        this.mContext = r8;
        this.mDataLinkSM = r10;
        this.mLinkTypes = r11;
        this.mControlLinkProperty = r12;
        this.mP2pAdapter = P2pAdapter.getInstance(r8, r12.getBWDLConfigs().getP2pBand());
        HandlerThread r13 = new HandlerThread("Data Link Event Handler");
        this.mEventHandlerThread = r13;
        r13.start();
        this.mAdapterEventHandler = new BWDLAdapterEventHandler(this, this.mEventHandlerThread.getLooper());
        init();
    }

    public static /* synthetic */ String access$100(DataLinkEventHandler r8, int r10) {
        return r8.transformIntegerToString(r10);
    }

    public static /* synthetic */ DataLinkSM access$200(DataLinkEventHandler r8) {
        return r8.mDataLinkSM;
    }

    public static /* synthetic */ void access$300(DataLinkEventHandler r8, int r10, int r11, int r12, Object r13) {
        r8.sendMessageWithParam(r10, r11, r12, r13);
    }

    private void init() {
        BWDLConstant.LinkType[] r8 = this.mLinkTypes;
        int r10 = r8.length;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L8;
        if (r8[r11] != BWDLConstant.LinkType.P2P) goto L7;
        this.mBWDLAdapter = this.mP2pAdapter;
        BWDLAdapterEventListener r12 = new BWDLAdapterEventListener(this, null);
        this.mAdapterEventListener = r12;
        this.mBWDLAdapter.setBWDLAdapterEventListener(r12);
        this.mP2pAdapter.registerP2pCallback(this.mAdapterEventListener);
    L7:
        r11 = r11 + 1;
        goto L3
    }

    private void sendMessageWithParam(int r8, int r10, int r11, Object r12) {
        Message.obtain(this.mAdapterEventHandler, r8, r10, r11, r12).sendToTarget();
    }

    private String transformIntegerToString(int r8) {
        if (r8 != 1) goto L5;
        return "MSG_CONNECTION_STATE_CHANGE";
    L5:
        if (r8 != 2) goto L7;
        return "MSG_IP_AVAILABLE";
    L7:
        if (r8 == 3) goto L10;
        return "Unknown";
    L10:
        return "MSG_P2P_GROUP_AVAILABLE";
    }

    public void cleanup() {
        BWDLLog.d(TAG, "cleanup");
        BWDLAdapterEventListener r8 = this.mAdapterEventListener;
        if (r8 == null) goto L5;
        this.mBWDLAdapter.removeBWDLAdapterEventListener(r8);
        this.mP2pAdapter.unRegisterP2pCallback(this.mAdapterEventListener);
    L5:
        HandlerThread r10 = this.mEventHandlerThread;
        if (r10 == null) goto L9;
        r10.quitSafely();
        return;
    }
}
