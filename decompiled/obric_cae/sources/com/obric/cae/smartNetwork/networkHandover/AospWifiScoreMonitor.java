package com.obric.cae.smartNetwork.networkHandover;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Message;
import com.obric.cae.log.CaeLog;

/* JADX INFO: loaded from: classes2.dex */
public class AospWifiScoreMonitor {
    public static final String ACTION_WIFI_SCORE_CHANGED = "com.android.wifi.action.WIFI_SCORE_CHANGED";
    public static final int AOSP_WIFI_SCORE_STATE_SWITCH = 1;
    public static final int AOSP_WIFI_SCORE_STATE_UNSWITCH = 0;
    public static final int DEFAULT_SCORE = 60;
    public static final String EXTRA_WIFI_SCORE = "wifi_score";
    public static final int SCORE_THRESHOLD = 50;
    private static final String TAG = "AospWifiScoreMonitor";
    private final Context mContext;
    private final NetworkPolicyCenter mPolicyCenter;
    private WifiScoreReceiver mWifiScoreReceiver;

    /* JADX INFO: renamed from: com.obric.cae.smartNetwork.networkHandover.AospWifiScoreMonitor$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class WifiScoreReceiver extends BroadcastReceiver {
        final /* synthetic */ AospWifiScoreMonitor this$0;

        private WifiScoreReceiver(AospWifiScoreMonitor r8) {
            this.this$0 = r8;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r8, Intent r10) {
            if (r10 != null) goto L4;
            return;
        L4:
            if (AospWifiScoreMonitor.ACTION_WIFI_SCORE_CHANGED.equals(r10.getAction()) == false) goto L13;
            int r11 = r10.getIntExtra(AospWifiScoreMonitor.EXTRA_WIFI_SCORE, 60);
            CaeLog.i(AospWifiScoreMonitor.TAG, "received AOSP Wi-Fi score: " + r11);
            Message r12 = Message.obtain();
            r12.arg1 = r11;
            if (r11 >= 50) goto L9;
            int r13 = 21;
        L10:
            r12.what = r13;
            AospWifiScoreMonitor.access$100(this.this$0).sendMessage(r12);
            return;
        L9:
            r13 = 22;
            goto L10
        }

        public /* synthetic */ WifiScoreReceiver(AospWifiScoreMonitor r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public AospWifiScoreMonitor(Context r8, NetworkPolicyCenter r10) {
        this.mContext = r8;
        this.mPolicyCenter = r10;
    }

    public static /* synthetic */ NetworkPolicyCenter access$100(AospWifiScoreMonitor r8) {
        return r8.mPolicyCenter;
    }

    public void start() {
        if (this.mWifiScoreReceiver == null) goto L5;
        return;
    L5:
        this.mWifiScoreReceiver = new WifiScoreReceiver(this, null);
        this.mContext.registerReceiver(this.mWifiScoreReceiver, new IntentFilter(ACTION_WIFI_SCORE_CHANGED), 2);     // Catch: Throwable -> L8
        CaeLog.i(TAG, "AOSP Wi-Fi score monitor started.");     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        CaeLog.e(TAG, "register receiver failed: " + th.getMessage());
        this.mWifiScoreReceiver = null;
    }

    public void stop() {
        WifiScoreReceiver r8 = this.mWifiScoreReceiver;
        if (r8 == null) goto L12;
        this.mContext.unregisterReceiver(r8);     // Catch: Throwable -> L6
        CaeLog.i(TAG, "AOSP Wi-Fi score monitor stopped.");     // Catch: Throwable -> L6
    L8:
        this.mWifiScoreReceiver = null;
        return;
    L6:
        th = move-exception;
        android.aimedia.a.s(th, new StringBuilder("unregister receiver failed: "), TAG);
        goto L8
    }
}
