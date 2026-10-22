package com.obric.cae.smartNetwork.networkHandover;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import com.obric.cae.log.CaeLog;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkKeepAlive {
    private static final boolean DEBUG = true;
    private static final int DEFAULT_NETWORK_SELECT_INTERVAL = 30000;
    private static final int MSG_DEFAULT_NETWORK_SELECT = 3;
    private static final int MSG_KEEP_ALIVE = 1;
    private static final int MSG_STOP_ALIVE = 2;
    private static final String PING_GATEWAY_CMD = "ping -I wlan0 -i ";
    private static final int PING_GATEWAY_INTERVAL = 3;
    private static final String TAG = "NetworkKeepAlive";
    private final ConnectivityManager mConnectivityManager;
    private final Context mContext;
    private int mDefaultNetworkType;
    private final IntentFilter mFilter;
    private final FusionBroadcastReceiver mFusionBroadcastReceiver;
    private String mGatewayIp;
    private final KeepAliveHandler mHandler;
    private final HandlerThread mHandlerThread;
    private final Object mLock;
    private ConnectivityManager.NetworkCallback mNetworkCallback;
    private final NetworkPolicyCenter mNetworkPolicyCenter;
    private NetworkRequest mNetworkRequest;
    private Process mPingProcess;
    private final PowerManager mPowerManager;
    private boolean mScreenOn;
    private boolean mWifiConnected;
    private final WifiManager mWifiManager;
    private boolean mWifiValid;

    public class FusionBroadcastReceiver extends BroadcastReceiver {
        final /* synthetic */ NetworkKeepAlive this$0;

        private FusionBroadcastReceiver(NetworkKeepAlive r8) {
            this.this$0 = r8;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r8, Intent r10) {
            Object r11 = NetworkKeepAlive.access$500(this.this$0);
            monitor-enter(r11);
            String r12 = r10.getAction();     // Catch: Throwable -> L37
            Objects.requireNonNull(r12);     // Catch: Throwable -> L37
            switch(r12.hashCode()) {
                case -2128145023: goto L17;
                case -1454123155: goto L14;
                case -1172645946: goto L11;
                case -343630553: goto L8;
                default: goto L19;
            };     // Catch: Throwable -> L37
        L19:
            byte r13 = -1;
        L20:
            if (r13 == 0) goto L28;
            if (r13 == 1) goto L27;
            if (r13 == 2) goto L26;
            if (r13 != 3) goto L34;
            NetworkKeepAlive.access$1102(this.this$0, false);     // Catch: Throwable -> L37
        L34:
            NetworkKeepAlive.access$1200(this.this$0);     // Catch: Throwable -> L37
            monitor-exit(r11);     // Catch: Throwable -> L37
            return;
        L26:
            NetworkKeepAlive.access$1102(this.this$0, true);     // Catch: Throwable -> L37
            goto L34
        L27:
            NetworkKeepAlive r14 = this.this$0;     // Catch: Throwable -> L37
            NetworkKeepAlive.access$802(r14, NetworkUtil.getNetworkType(NetworkKeepAlive.access$900(r14), NetworkKeepAlive.access$1000(this.this$0).getActiveNetwork()));     // Catch: Throwable -> L37
            goto L34
        L28:
            NetworkInfo r15 = (NetworkInfo) r10.getParcelableExtra("networkInfo");     // Catch: Throwable -> L37
            if (r15 != null) goto L31;
        L33:
            NetworkKeepAlive.access$602(this.this$0, false);     // Catch: Throwable -> L37
            NetworkKeepAlive.access$102(this.this$0, null);     // Catch: Throwable -> L37
            goto L34
        L31:
            if (r15.isConnected() == false) goto L33;
            NetworkKeepAlive.access$602(this.this$0, true);     // Catch: Throwable -> L37
            NetworkKeepAlive r16 = this.this$0;     // Catch: Throwable -> L37
            NetworkKeepAlive.access$102(r16, NetworkUtil.intToIp(NetworkKeepAlive.access$700(r16).getDhcpInfo().gateway));     // Catch: Throwable -> L37
            goto L34
        L8:
            if (r12.equals("android.net.wifi.STATE_CHANGE") == false) goto L19;
            r13 = 0;
            goto L20
        L11:
            if (r12.equals("android.net.conn.CONNECTIVITY_CHANGE") == false) goto L19;
            r13 = 1;
            goto L20
        L14:
            if (r12.equals("android.intent.action.SCREEN_ON") == false) goto L19;
            r13 = 2;
            goto L20
        L17:
            if (r12.equals("android.intent.action.SCREEN_OFF") == false) goto L19;
            r13 = 3;
        L37:
            th = move-exception;
            throw th;
        }

        public /* synthetic */ FusionBroadcastReceiver(NetworkKeepAlive r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public class KeepAliveHandler extends Handler {
        final /* synthetic */ NetworkKeepAlive this$0;

        public KeepAliveHandler(NetworkKeepAlive r8, Looper r10) {
            this.this$0 = r8;
            super(r10);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r8) {
            int r10 = r8.what;
            if (r10 != 1) goto L5;
            NetworkKeepAlive r11 = this.this$0;
            NetworkKeepAlive.access$200(r11, NetworkKeepAlive.access$100(r11));
            return;
        L5:
            if (r10 != 2) goto L7;
            NetworkKeepAlive.access$300(this.this$0);
            return;
        L7:
            if (r10 != 3) goto L15;
            NetworkKeepAlive.access$400(this.this$0);
            return;
        }
    }

    public NetworkKeepAlive(Context r8, NetworkPolicyCenter r10) {
        this.mNetworkRequest = new NetworkRequest.Builder().addCapability(12).build();
        this.mNetworkCallback = new AnonymousClass1(this);
        this.mContext = r8;
        this.mNetworkPolicyCenter = r10;
        this.mLock = new Object();
        HandlerThread r11 = new HandlerThread("KeepAliveThread");
        this.mHandlerThread = r11;
        r11.start();
        this.mPowerManager = (PowerManager) r8.getSystemService("power");
        this.mHandler = new KeepAliveHandler(this, r11.getLooper());
        this.mWifiManager = (WifiManager) r8.getSystemService("wifi");
        this.mConnectivityManager = (ConnectivityManager) r8.getSystemService("connectivity");
        this.mFusionBroadcastReceiver = new FusionBroadcastReceiver(this, null);
        IntentFilter r12 = new IntentFilter();
        this.mFilter = r12;
        r12.addAction("android.net.wifi.STATE_CHANGE");
        r12.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        r12.addAction("android.intent.action.SCREEN_ON");
        r12.addAction("android.intent.action.SCREEN_OFF");
    }

    public static /* synthetic */ String access$100(NetworkKeepAlive r8) {
        return r8.mGatewayIp;
    }

    public static /* synthetic */ ConnectivityManager access$1000(NetworkKeepAlive r8) {
        return r8.mConnectivityManager;
    }

    public static /* synthetic */ String access$102(NetworkKeepAlive r8, String r10) {
        r8.mGatewayIp = r10;
        return r10;
    }

    public static /* synthetic */ boolean access$1102(NetworkKeepAlive r8, boolean r10) {
        r8.mScreenOn = r10;
        return r10;
    }

    public static /* synthetic */ void access$1200(NetworkKeepAlive r8) {
        r8.mayChangeKeepAliveMode();
    }

    public static /* synthetic */ boolean access$1302(NetworkKeepAlive r8, boolean r10) {
        r8.mWifiValid = r10;
        return r10;
    }

    public static /* synthetic */ void access$200(NetworkKeepAlive r8, String r10) {
        r8.startKeepAlive(r10);
    }

    public static /* synthetic */ void access$300(NetworkKeepAlive r8) {
        r8.stopKeepAlive();
    }

    public static /* synthetic */ void access$400(NetworkKeepAlive r8) {
        r8.selectDefaultNetwork();
    }

    public static /* synthetic */ Object access$500(NetworkKeepAlive r8) {
        return r8.mLock;
    }

    public static /* synthetic */ boolean access$602(NetworkKeepAlive r8, boolean r10) {
        r8.mWifiConnected = r10;
        return r10;
    }

    public static /* synthetic */ WifiManager access$700(NetworkKeepAlive r8) {
        return r8.mWifiManager;
    }

    public static /* synthetic */ int access$802(NetworkKeepAlive r8, int r10) {
        r8.mDefaultNetworkType = r10;
        return r10;
    }

    public static /* synthetic */ Context access$900(NetworkKeepAlive r8) {
        return r8.mContext;
    }

    private void mayChangeKeepAliveMode() {
        if (this.mWifiConnected == true) goto L5;
    L11:
        this.mHandler.sendEmptyMessage(2);
        return;
    L5:
        if (this.mWifiValid == false) goto L11;
        if (this.mScreenOn == false) goto L11;
        if (this.mDefaultNetworkType == 1) goto L11;
        this.mHandler.sendEmptyMessage(1);
    }

    private void selectDefaultNetwork() {
        this.mNetworkPolicyCenter.sendEmptyMessage(13);
        this.mHandler.sendEmptyMessageDelayed(3, 30000);
    }

    private void startKeepAlive(String r8) {
        if (r8 != null) goto L6;
        CaeLog.e(TAG, "startKeepAlive failed: gateway is null.");
        return;
    L6:
        String r10 = "ping -I wlan0 -i 3 ".concat(r8);
        if (this.mPingProcess != null) goto L15;
        CaeLog.i(TAG, "startKeepAlive: " + r10);     // Catch: Exception -> L10
        this.mPingProcess = Runtime.getRuntime().exec(r10);     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        defpackage.b.k(e, new StringBuilder("startKeepAlive failed: "), TAG);
        return;
    }

    private void stopKeepAlive() {
        if (this.mPingProcess == null) goto L6;
        CaeLog.i(TAG, "stopKeepAlive: " + this.mPingProcess);
        this.mPingProcess.destroy();
        this.mPingProcess = null;
        return;
    }

    public void start() {
        CaeLog.d(TAG, "start keep alive.");
        this.mScreenOn = this.mPowerManager.isInteractive();
        this.mContext.registerReceiver(this.mFusionBroadcastReceiver, this.mFilter);
        this.mConnectivityManager.registerNetworkCallback(this.mNetworkRequest, this.mNetworkCallback);
        this.mHandler.sendEmptyMessageDelayed(3, 30000);
    }

    public void stop() {
        CaeLog.d(TAG, "stop keep alive.");
        this.mHandler.sendEmptyMessage(2);
        this.mHandler.removeMessages(3);
        this.mContext.unregisterReceiver(this.mFusionBroadcastReceiver);
        this.mConnectivityManager.unregisterNetworkCallback(this.mNetworkCallback);
        this.mWifiConnected = false;
        this.mWifiValid = false;
        this.mScreenOn = false;
        this.mGatewayIp = null;
        this.mDefaultNetworkType = -1;
    }
}
