package com.obric.cae.smartNetwork.netAccel.cellularAccel;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.Message;
import com.android.internal.util.State;
import com.android.internal.util.StateMachine;
import com.obric.cae.log.CaeLog;
import defpackage.b;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class CellularConnector extends StateMachine {
    private static final int CMD_CONNECT = 1;
    private static final int CMD_DISCONNECT = 2;
    private static final int CMD_NETWORK_AVAILABLE = 4;
    private static final int CMD_NETWORK_LOST = 5;
    private static final int CMD_NETWORK_UNAVAILABLE = 6;
    private static final int CMD_RECONNECT = 3;
    private static final int CONNECT_TIMEOUT_MS = 6000;
    private static final String TAG = null;
    private final ConnectedState mConnectedState;
    private final ConnectingState mConnectingState;
    private final ConnectivityManager mConnectivityManager;
    private final Context mContext;
    private final IdleState mIdleState;
    private final Map<String, CellularConnectionListener> mListeners;
    private final ConnectivityManager.NetworkCallback mNetworkCallback;

    public interface CellularConnectionListener {
        void onCellularConnected(Network r8);

        void onCellularDisconnected();

        void onCellularLost();
    }

    public class ConnectedState extends State {
        private Network mNetwork;
        final /* synthetic */ CellularConnector this$0;

        private ConnectedState(CellularConnector r8) {
            this.this$0 = r8;
        }

        public void enter() {
            CaeLog.d(CellularConnector.access$300(), "ConnectedState, activeRequesters=" + CellularConnector.access$400(this.this$0).keySet());
            Network r8 = (Network) this.this$0.getCurrentMessage().obj;
            this.mNetwork = r8;
            CellularConnector.access$1100(this.this$0, r8);
        }

        public void exit() {
            CellularConnector.access$1200(this.this$0);
        }

        public boolean processMessage(Message r8) {
            int r10 = r8.what;
            if (r10 != 1) goto L5;
            RequesterInfo r11 = (RequesterInfo) r8.obj;
            CellularConnector.access$400(this.this$0).put(r11.packageName, r11.listener);
            CaeLog.i(CellularConnector.access$300(), "ConnectedState: " + r11.packageName + " also request cellular, total=" + CellularConnector.access$400(this.this$0).size());
            r11.listener.onCellularConnected(this.mNetwork);
            return true;
        L5:
            if (r10 != 2) goto L7;
            String r12 = (String) r8.obj;
            CellularConnectionListener r13 = (CellularConnectionListener) CellularConnector.access$400(this.this$0).remove(r12);
            String r14 = CellularConnector.access$300();
            StringBuilder r15 = b.h("ConnectedState: ", r12, " release cellular, remaining=");
            r15.append(CellularConnector.access$400(this.this$0).keySet());
            CaeLog.i(r14, r15.toString());
            if (r13 == null) goto L20;
            r13.onCellularDisconnected();
        L20:
            if (CellularConnector.access$400(this.this$0).isEmpty() == false) goto L22;
            CaeLog.i(CellularConnector.access$300(), "ConnectedState: no more requesters, disconnecting");
            CellularConnector.access$700(this.this$0);
            CellularConnector r16 = this.this$0;
            r16.transitionTo(CellularConnector.access$800(r16));
        L22:
            return true;
        L7:
            if (r10 != 5) goto L9;
            CaeLog.d(CellularConnector.access$300(), "ConnectedState: cellular lost, reconnecting");
            CellularConnector.access$1300(this.this$0);
            CellularConnector.access$700(this.this$0);
            CellularConnector r17 = this.this$0;
            r17.transitionTo(CellularConnector.access$500(r17));
            return true;
        L9:
            if (r10 == 6) goto L12;
            return false;
        L12:
            CaeLog.d(CellularConnector.access$300(), "ConnectedState: cellular unavailable, reconnecting");
            CellularConnector.access$1300(this.this$0);
            CellularConnector.access$700(this.this$0);
            CellularConnector r18 = this.this$0;
            r18.transitionTo(CellularConnector.access$500(r18));
            return true;
        }

        public /* synthetic */ ConnectedState(CellularConnector r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public class ConnectingState extends State {
        final /* synthetic */ CellularConnector this$0;

        private ConnectingState(CellularConnector r8) {
            this.this$0 = r8;
        }

        public void enter() {
            CaeLog.d(CellularConnector.access$300(), "ConnectingState, activeRequesters=" + CellularConnector.access$400(this.this$0).keySet());
            CellularConnector.access$600(this.this$0);
        }

        public boolean processMessage(Message r8) {
            switch(r8.what) {
                case 1: goto L19;
                case 2: goto L15;
                case 3: goto L11;
                case 4: goto L8;
                case 5: goto L6;
                case 6: goto L6;
                default: goto L4;
            };
        L4:
            return false;
        L6:
            CellularConnector.access$1000(this.this$0, 3);
            this.this$0.sendMessageDelayed(3, 6000);
            return true;
        L8:
            CellularConnector r10 = this.this$0;
            r10.transitionTo(CellularConnector.access$900(r10));
            return true;
        L15:
            String r11 = (String) r8.obj;
            CellularConnector.access$400(this.this$0).remove(r11);
            String r12 = CellularConnector.access$300();
            StringBuilder r13 = b.h("ConnectingState: ", r11, " release cellular, remaining=");
            r13.append(CellularConnector.access$400(this.this$0).keySet());
            CaeLog.i(r12, r13.toString());
            if (CellularConnector.access$400(this.this$0).isEmpty() == false) goto L18;
            CaeLog.i(CellularConnector.access$300(), "ConnectingState: no more requesters, releasing");
            CellularConnector.access$700(this.this$0);
            CellularConnector r14 = this.this$0;
            r14.transitionTo(CellularConnector.access$800(r14));
        L18:
            return true;
        L19:
            RequesterInfo r15 = (RequesterInfo) r8.obj;
            CellularConnector.access$400(this.this$0).put(r15.packageName, r15.listener);
            CaeLog.i(CellularConnector.access$300(), "ConnectingState: " + r15.packageName + " also request cellular, total=" + CellularConnector.access$400(this.this$0).size());
            return true;
        L11:
            if (CellularConnector.access$400(this.this$0).isEmpty() == false) goto L13;
            CellularConnector r16 = this.this$0;
            r16.transitionTo(CellularConnector.access$800(r16));
        L14:
            return true;
        L13:
            CellularConnector.access$700(this.this$0);
            CellularConnector.access$600(this.this$0);
            goto L14
        }

        public /* synthetic */ ConnectingState(CellularConnector r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public class IdleState extends State {
        final /* synthetic */ CellularConnector this$0;

        private IdleState(CellularConnector r8) {
            this.this$0 = r8;
        }

        public void enter() {
            CaeLog.d(CellularConnector.access$300(), "IdleState, activeRequesters=" + CellularConnector.access$400(this.this$0).size());
        }

        public boolean processMessage(Message r8) {
            int r10 = r8.what;
            if (r10 != 1) goto L5;
            RequesterInfo r11 = (RequesterInfo) r8.obj;
            CellularConnector.access$400(this.this$0).put(r11.packageName, r11.listener);
            CaeLog.i(CellularConnector.access$300(), "IdleState: " + r11.packageName + " request cellular, transitioning to ConnectingState");
            CellularConnector r12 = this.this$0;
            r12.transitionTo(CellularConnector.access$500(r12));
            return true;
        L5:
            if (r10 == 2) goto L8;
            return false;
        L8:
            String r13 = (String) r8.obj;
            CellularConnector.access$400(this.this$0).remove(r13);
            String r14 = CellularConnector.access$300();
            StringBuilder r15 = b.h("IdleState: ", r13, " disconnect (already idle), remaining=");
            r15.append(CellularConnector.access$400(this.this$0).keySet());
            CaeLog.d(r14, r15.toString());
            return true;
        }

        public /* synthetic */ IdleState(CellularConnector r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public static class RequesterInfo {
        final CellularConnectionListener listener;
        final String packageName;

        public RequesterInfo(String r8, CellularConnectionListener r10) {
            this.packageName = r8;
            this.listener = r10;
        }
    }

    static {
        TAG = "MultiNetwork-CellularConnector";
    }

    private CellularConnector(String r8, Context r10) {
        super(r8);
        AnonymousClass1 r11 = null;
        IdleState r12 = new IdleState(this, r11);
        this.mIdleState = r12;
        ConnectingState r13 = new ConnectingState(this, r11);
        this.mConnectingState = r13;
        ConnectedState r14 = new ConnectedState(this, r11);
        this.mConnectedState = r14;
        this.mListeners = new ConcurrentHashMap();
        this.mContext = r10;
        ConnectivityManager r15 = (ConnectivityManager) r10.getSystemService("connectivity");
        this.mConnectivityManager = r15;
        if (r15 != null) goto L5;
        CaeLog.e(TAG, "ConnectivityManager is null");
    L5:
        this.mNetworkCallback = createNetworkCallback();
        addState(r12);
        addState(r13);
        addState(r14);
        setInitialState(r12);
    }

    public static /* synthetic */ void access$1000(CellularConnector r8, int r10) {
        r8.removeMessages(r10);
    }

    public static /* synthetic */ void access$1100(CellularConnector r8, Network r10) {
        r8.notifyAllConnected(r10);
    }

    public static /* synthetic */ void access$1200(CellularConnector r8) {
        r8.notifyAllDisconnected();
    }

    public static /* synthetic */ void access$1300(CellularConnector r8) {
        r8.notifyAllLost();
    }

    public static /* synthetic */ String access$300() {
        return TAG;
    }

    public static /* synthetic */ Map access$400(CellularConnector r8) {
        return r8.mListeners;
    }

    public static /* synthetic */ ConnectingState access$500(CellularConnector r8) {
        return r8.mConnectingState;
    }

    public static /* synthetic */ void access$600(CellularConnector r8) {
        r8.requestCellularNetwork();
    }

    public static /* synthetic */ void access$700(CellularConnector r8) {
        r8.releaseCellularNetwork();
    }

    public static /* synthetic */ IdleState access$800(CellularConnector r8) {
        return r8.mIdleState;
    }

    public static /* synthetic */ ConnectedState access$900(CellularConnector r8) {
        return r8.mConnectedState;
    }

    private ConnectivityManager.NetworkCallback createNetworkCallback() {
        return new AnonymousClass1(this);
    }

    public static CellularConnector makeCellularConnector(Context r8) {
        CellularConnector r10 = new CellularConnector("CellularConnector", r8);
        r10.start();
        return r10;
    }

    private void notifyAllConnected(Network r8) {
        Iterator<CellularConnectionListener> r10 = this.mListeners.values().iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().onCellularConnected(r8);
        goto L4
    }

    private void notifyAllDisconnected() {
        Iterator<CellularConnectionListener> r8 = this.mListeners.values().iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        r8.next().onCellularDisconnected();
        goto L4
    }

    private void notifyAllLost() {
        Iterator<CellularConnectionListener> r8 = this.mListeners.values().iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        r8.next().onCellularLost();
        goto L4
    }

    private void releaseCellularNetwork() {
        String r8 = TAG;
        CaeLog.i(r8, "releaseCellularNetwork: releasing cellular network");
        ConnectivityManager r10 = this.mConnectivityManager;
        if (r10 != null) goto L10;
        CaeLog.e(r8, "releaseCellularNetwork: ConnectivityManager is null");
        return;
    L10:
        r10.unregisterNetworkCallback(this.mNetworkCallback);     // Catch: IllegalArgumentException -> L8
        return;
    L8:
        CaeLog.w(TAG, "unregisterNetworkCallback: callback not registered");
    }

    private void requestCellularNetwork() {
        if (this.mConnectivityManager != null) goto L6;
        CaeLog.e(TAG, "requestCellularNetwork: ConnectivityManager is null");
        return;
    L6:
        NetworkRequest r8 = new NetworkRequest.Builder().addTransportType(0).addCapability(12).build();
        CaeLog.i(TAG, "requestCellularNetwork: activeRequesters=" + this.mListeners.keySet());
        this.mConnectivityManager.requestNetwork(r8, this.mNetworkCallback, CONNECT_TIMEOUT_MS);
    }

    public void connect(String r8, CellularConnectionListener r10) {
        CaeLog.i(TAG, "connect() requested by: " + r8);
        Message r11 = obtainMessage(1);
        r11.obj = new RequesterInfo(r8, r10);
        sendMessage(r11);
    }

    public void disconnect(String r8) {
        CaeLog.i(TAG, "disconnect() requested by: " + r8);
        Message r10 = obtainMessage(2);
        r10.obj = r8;
        sendMessage(r10);
    }

    public boolean isAccelerating() {
        return !this.mListeners.isEmpty();
    }
}
