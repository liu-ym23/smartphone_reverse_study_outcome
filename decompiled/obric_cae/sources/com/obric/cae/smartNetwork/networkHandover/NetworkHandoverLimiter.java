package com.obric.cae.smartNetwork.networkHandover;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.obric.cae.log.CaeLog;
import java.util.ArrayDeque;
import java.util.Deque;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkHandoverLimiter {
    private static final boolean DEBUG = false;
    public static final int ENFORCE_LIMIT = 1;
    private static final int GET_DEFAULT_NETWORK_DELAY = 1000;
    private static final int MSG_ENFORCE_SWITCH_LIMIT = 2;
    private static final int MSG_GET_DEFAULT_NETWORK = 1;
    private static final int MSG_RELEASE_SWITCH_LIMIT = 3;
    public static final int RELEASE_LIMIT = 2;
    private static final String TAG = "NetworkHandoverLimiter";
    private final ConnectivityManager mConnectivityManager;
    private final Context mContext;
    private Network mDefaultNetwork;
    private final Handler mHandler;
    private final HandlerThread mHandlerThread;
    private final HandoverParameterManager mHandoverParameterManager;
    private int mLimitState;
    private final ConnectivityManager.NetworkCallback mNetworkCallback;
    private final NetworkPolicyCenter mNetworkPolicyCenter;
    private final Deque<SwitchRecord> mSwitchRecords;

    public class SwitchRecord {
        private Network network;
        final /* synthetic */ NetworkHandoverLimiter this$0;
        private long timestamp;

        public SwitchRecord(NetworkHandoverLimiter r8, long r10, Network r11) {
            this.this$0 = r8;
            this.timestamp = r10;
            this.network = r11;
        }

        public Network getNetwork() {
            return this.network;
        }

        public long getTimestamp() {
            return this.timestamp;
        }
    }

    public NetworkHandoverLimiter(Context r8, NetworkPolicyCenter r10) {
        this.mLimitState = 2;
        this.mDefaultNetwork = null;
        this.mSwitchRecords = new ArrayDeque();
        this.mNetworkCallback = new AnonymousClass1(this);
        this.mContext = r8;
        this.mNetworkPolicyCenter = r10;
        this.mHandoverParameterManager = HandoverParameterManager.getInstance(r8);
        this.mConnectivityManager = (ConnectivityManager) r8.getSystemService("connectivity");
        HandlerThread r11 = new HandlerThread("NetworkHandoverLimiterThread");
        this.mHandlerThread = r11;
        r11.start();
        final Looper r12 = r11.getLooper();
        this.mHandler = new AnonymousClass2(this, r12);
    }

    public static /* synthetic */ void access$000(NetworkHandoverLimiter r8) {
        r8.getDefaultNetworkToDelay();
    }

    public static /* synthetic */ void access$100(NetworkHandoverLimiter r8) {
        r8.mayUpdateDefaultNetwork();
    }

    public static /* synthetic */ void access$200(NetworkHandoverLimiter r8) {
        r8.enforceSwitchLimit();
    }

    public static /* synthetic */ void access$300(NetworkHandoverLimiter r8) {
        r8.releaseSwitchLimit();
    }

    private void checkSwitchLimit() {
        if (this.mSwitchRecords.size() != this.mHandoverParameterManager.getHandoverLimitTimes()) goto L11;
        long r8 = this.mSwitchRecords.getLast().getTimestamp() - this.mSwitchRecords.getFirst().getTimestamp();
        long r10 = this.mHandoverParameterManager.getHandoverLimitTimeout();
        if (r8 < r10) goto L7;
        return;
    L7:
        if (this.mLimitState != 2) goto L9;
        this.mHandler.sendEmptyMessage(2);
        CaeLog.i(TAG, "enforce switch limit. timeDiffMillis: " + r8 + " SwitchRecords: " + this.mSwitchRecords.size());
    L9:
        StringBuilder r11 = new StringBuilder("start release limit timer. timeDiffMillis: ");
        long r12 = r10 - r8;
        r11.append(r12);
        r11.append("ms");
        CaeLog.i(TAG, r11.toString());
        this.mHandler.removeMessages(3);
        this.mHandler.sendEmptyMessageDelayed(3, r12);
        return;
    }

    private void enforceSwitchLimit() {
        this.mLimitState = 1;
        defpackage.b.p(new StringBuilder("send message: MSG_SWITCH_LIMIT_STATE_CHANGED. mLimitState: "), this.mLimitState, TAG);
        NetworkPolicyCenter r8 = this.mNetworkPolicyCenter;
        r8.sendMessage(r8.obtainMessage(12, this.mLimitState, 0));
    }

    private void getDefaultNetworkToDelay() {
        if (this.mHandler.hasMessages(1) == false) goto L5;
        return;
    L5:
        this.mHandler.sendEmptyMessageDelayed(1, 1000);
    }

    private void mayUpdateDefaultNetwork() {
        Network r8 = this.mConnectivityManager.getActiveNetwork();
        if (r8 != null) goto L8;
        if (this.mDefaultNetwork != null) goto L8;
        return;
    L8:
        if (r8 != null) goto L12;
        this.mDefaultNetwork = null;
        NetworkPolicyCenter r10 = this.mNetworkPolicyCenter;
        r10.sendMessage(r10.obtainMessage(11, null));
        String r11 = "send default network changed message: MSG_DEFAULT_NETWORK_CHANGED. new network: null";
    L10:
        CaeLog.d(TAG, r11);
        return;
    L12:
        if (r8.equals(this.mDefaultNetwork) == true) goto L15;
        recordSwitch(this.mDefaultNetwork, r8);
        this.mDefaultNetwork = r8;
        NetworkPolicyCenter r12 = this.mNetworkPolicyCenter;
        r12.sendMessage(r12.obtainMessage(11, r8));
        r11 = "send default network changed message: MSG_DEFAULT_NETWORK_CHANGED. new network: " + this.mDefaultNetwork.toString();
        goto L10
    }

    private void recordSwitch(Network r8, Network r10) {
        if (r8 == null) goto L16;
        if (r10 != null) goto L6;
        return;
    L6:
        if (NetworkUtil.isDisconnectedNetwork(this.mContext, r8) == false) goto L9;
        return;
    L9:
        if (NetworkUtil.getNetworkType(this.mContext, r8) != NetworkUtil.getNetworkType(this.mContext, r10)) goto L12;
        return;
    L12:
        if (this.mSwitchRecords.size() < this.mHandoverParameterManager.getHandoverLimitTimes()) goto L14;
        this.mSwitchRecords.removeFirst();
    L14:
        this.mSwitchRecords.addLast(new SwitchRecord(this, System.currentTimeMillis(), r10));
        checkSwitchLimit();
        return;
    }

    private void releaseSwitchLimit() {
        this.mLimitState = 2;
        defpackage.b.p(new StringBuilder("send message: MSG_SWITCH_LIMIT_STATE_CHANGED. mLimitState: "), this.mLimitState, TAG);
        NetworkPolicyCenter r8 = this.mNetworkPolicyCenter;
        r8.sendMessage(r8.obtainMessage(12, this.mLimitState, 0));
    }

    public void start() {
        this.mConnectivityManager.registerDefaultNetworkCallback(this.mNetworkCallback);
    }

    public void stop() {
        this.mConnectivityManager.unregisterNetworkCallback(this.mNetworkCallback);
        this.mDefaultNetwork = null;
        this.mLimitState = 2;
    }
}
