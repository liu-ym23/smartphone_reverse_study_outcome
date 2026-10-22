package com.obric.cae.smartNetwork.qoe;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartNetwork.SmartNetworkService;
import com.obric.cae.smartNetwork.throughtput.InternalThroughputListener;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class WiFiQoEStateTracker implements NetworkQoEStateTraker {
    private static final String TAG = "WiFiQoEStateTracker";
    public static final int WIFI_BAND_24_GHZ = 0;
    public static final int WIFI_BAND_5_GHZ = 1;
    public static final int WIFI_BAND_6_GHZ = 2;
    public static final int WIFI_BAND_UNKNOWN = -1;
    private IntentFilter filter;
    private int mBand;
    private Context mContext;
    private SmartNetworkService mSmartNetworkService;
    private final Set<WiFiQoECallback> mWiFiQoECallbackSet;
    private WiFiThroughputListener mWiFiThroughputListener;
    private final BroadcastReceiver mWifiBandReceiver;
    private WifiManager mWifiManager;

    public class WiFiThroughputListener implements InternalThroughputListener {
        final /* synthetic */ WiFiQoEStateTracker this$0;

        private WiFiThroughputListener(WiFiQoEStateTracker r8) {
            this.this$0 = r8;
        }

        @Override // com.obric.cae.smartNetwork.throughtput.InternalThroughputListener
        public void onSecondaryThroughputChanged(int r8, int r10) {
        }

        @Override // com.obric.cae.smartNetwork.throughtput.InternalThroughputListener
        public void onThroughputChanged(int r8, int r10) {
            WiFiQoEParam r11 = new WiFiQoEParam();
            r11.setBand(WiFiQoEStateTracker.access$000(this.this$0));
            r11.setRxThroughput(r8);
            r11.setTxThroughput(r10);
            Set r12 = WiFiQoEStateTracker.access$100(this.this$0);
            monitor-enter(r12);
            Iterator r13 = WiFiQoEStateTracker.access$100(this.this$0).iterator();     // Catch: Throwable -> L10
        L6:
            if (r13.hasNext() == false) goto L8;
            ((WiFiQoECallback) r13.next()).onWiFiQoEParamUpdate(r11);     // Catch: Throwable -> L10
            goto L6
        L8:
            monitor-exit(r12);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }

        public /* synthetic */ WiFiThroughputListener(WiFiQoEStateTracker r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public WiFiQoEStateTracker(Context r8, SmartNetworkService r10) {
        this.mWiFiQoECallbackSet = Collections.synchronizedSet(new HashSet());
        this.mBand = -1;
        BroadcastReceiver r11 = new AnonymousClass1(this);
        this.mWifiBandReceiver = r11;
        this.mContext = r8;
        this.mSmartNetworkService = r10;
        this.mWiFiThroughputListener = new WiFiThroughputListener(this, null);
        WifiManager r12 = (WifiManager) this.mContext.getSystemService("wifi");
        this.mWifiManager = r12;
        if (r12 != null) goto L6;
        CaeLog.e(TAG, "WiFiQoEStateTracker: mWifiManager is null");
        return;
    L6:
        WifiInfo r13 = r12.getConnectionInfo();
        if (r13 == null) goto L9;
        this.mBand = getWifiBand(r13.getFrequency());
    L9:
        IntentFilter r14 = new IntentFilter();
        this.filter = r14;
        r14.addAction("android.net.wifi.STATE_CHANGE");
        this.mContext.registerReceiver(r11, this.filter);
    }

    public static /* synthetic */ int access$000(WiFiQoEStateTracker r8) {
        return r8.mBand;
    }

    public static /* synthetic */ int access$002(WiFiQoEStateTracker r8, int r10) {
        r8.mBand = r10;
        return r10;
    }

    public static /* synthetic */ Set access$100(WiFiQoEStateTracker r8) {
        return r8.mWiFiQoECallbackSet;
    }

    public static /* synthetic */ WifiManager access$300(WiFiQoEStateTracker r8) {
        return r8.mWifiManager;
    }

    public static /* synthetic */ int access$400(WiFiQoEStateTracker r8, int r10) {
        return r8.getWifiBand(r10);
    }

    private int getWifiBand(int r8) {
        if (r8 < 2412) goto L9;
        if (r8 > 2484) goto L9;
        return 0;
    L9:
        if (r8 < 5160) goto L15;
        if (r8 > 5885) goto L15;
        return 1;
    L15:
        if (r8 != 5935) goto L17;
        return 2;
    L17:
        if (r8 >= 5955) goto L19;
        return -1;
    L19:
        if (r8 <= 7115) goto L26;
        return -1;
    L26:
        return 2;
    }

    public void registerQoECallback(WiFiQoECallback r8) {
        this.mWiFiQoECallbackSet.add(r8);
    }

    @Override // com.obric.cae.smartNetwork.qoe.NetworkQoEStateTraker
    public void startTracker() {
        SmartNetworkService r8 = this.mSmartNetworkService;
        if (r8 == null) goto L9;
        WiFiThroughputListener r10 = this.mWiFiThroughputListener;
        if (r10 == null) goto L9;
        r8.registerInternalThroughputListener(r10);
        return;
    L9:
        CaeLog.e(TAG, "Internal call error, mSmartNetworkService and mWiFiThroughputListener must be not null!");
    }

    @Override // com.obric.cae.smartNetwork.qoe.NetworkQoEStateTraker
    public void stopTracker() {
        SmartNetworkService r8 = this.mSmartNetworkService;
        if (r8 == null) goto L9;
        WiFiThroughputListener r10 = this.mWiFiThroughputListener;
        if (r10 == null) goto L9;
        r8.unregisterInternalThroughputListener(r10);
        return;
    L9:
        CaeLog.e(TAG, "Internal call error, mSmartNetworkService and mWiFiThroughputListener must be not null!");
    }

    public void unRegisterQoECallback(WiFiQoECallback r8) {
        if (this.mWiFiQoECallbackSet.contains(r8) == false) goto L6;
        this.mWiFiQoECallbackSet.remove(r8);
        return;
    }
}
