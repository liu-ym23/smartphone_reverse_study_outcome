package com.sdk.bwdl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.sdk.bwdl.ExternalAPI.BWDLCallback;
import com.sdk.bwdl.ExternalAPI.BWDLManager;
import com.sdk.bwdl.Utils.BWDLLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class BWDLReceiver {
    private static final String TAG = "BWDLReceiver";
    private static volatile BWDLReceiver sInstance;
    private BWDLBroadcastReceiver mBWDLBroadcastReceiver;
    private BWDLManager mBWDLManager;
    private Context mContext;
    private List<ISystemBroadcastListener> mListenerList;

    public class BWDLBroadcastReceiver extends BroadcastReceiver {
        final /* synthetic */ BWDLReceiver this$0;

        public BWDLBroadcastReceiver(BWDLReceiver r8) {
            this.this$0 = r8;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r8, Intent r10) {
            String r11 = r10.getAction();
            BWDLLog.d(BWDLReceiver.TAG, "action: " + r11);
            if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(r11) == false) goto L6;
            int r12 = r10.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE);
            BWDLLog.d(BWDLReceiver.TAG, "BTState: " + r12);
            BWDLReceiver.access$000(this.this$0, r12);
            return;
        L6:
            if ("android.net.wifi.WIFI_STATE_CHANGED".equals(r11) == false) goto L9;
            int r13 = r10.getIntExtra("wifi_state", 4);
            BWDLLog.d(BWDLReceiver.TAG, "WifiState: " + r13);
            BWDLReceiver.access$100(this.this$0, r13);
            return;
        L9:
            if ("android.intent.action.SCREEN_ON".equals(r11) == false) goto L12;
            BWDLLog.d(BWDLReceiver.TAG, "screen on");
            BWDLReceiver.access$200(this.this$0);
            return;
        L12:
            if ("android.intent.action.SCREEN_OFF".equals(r11) == false) goto L18;
            BWDLLog.d(BWDLReceiver.TAG, "screen off");
            BWDLReceiver.access$300(this.this$0);
            return;
        }
    }

    public interface ISystemBroadcastListener {
        void onBtStateChanged(int r8);

        void onScreenOff();

        void onScreenOn();

        void onWifiStateChanged(int r8);
    }

    private BWDLReceiver(Context r8) {
        this.mBWDLBroadcastReceiver = new BWDLBroadcastReceiver(this);
        this.mListenerList = new CopyOnWriteArrayList();
        this.mContext = r8;
        registerBroadcastReceiver();
        this.mBWDLManager = BWDLManager.getInstance(this.mContext);
    }

    public static /* synthetic */ void access$000(BWDLReceiver r8, int r10) {
        r8.sendBTStateChangeToListener(r10);
    }

    public static /* synthetic */ void access$100(BWDLReceiver r8, int r10) {
        r8.sendWifiStateChangeToListener(r10);
    }

    public static /* synthetic */ void access$200(BWDLReceiver r8) {
        r8.sendScreenOnToListener();
    }

    public static /* synthetic */ void access$300(BWDLReceiver r8) {
        r8.sendScreenOffToListener();
    }

    public static BWDLReceiver getInstance(Context r8) {
        if (sInstance != null) goto L15;
        monitor-enter(BWDLReceiver.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new BWDLReceiver(r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(BWDLReceiver.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private void registerBroadcastReceiver() {
        IntentFilter r8 = new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED");
        r8.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        r8.addAction("android.intent.action.SCREEN_ON");
        r8.addAction("android.intent.action.SCREEN_OFF");
        this.mContext.registerReceiver(this.mBWDLBroadcastReceiver, r8);
    }

    private void sendBTStateChangeToListener(int r8) {
        Iterator<ISystemBroadcastListener> r10 = this.mListenerList.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().onBtStateChanged(r8);
        goto L4
    L6:
        BWDLCallback r11 = BWDLManager.mBWDLCallback;
        if (r11 == null) goto L11;
        r11.onBtStateChanged(r8);
        return;
    }

    private void sendScreenOffToListener() {
        Iterator<ISystemBroadcastListener> r8 = this.mListenerList.iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        r8.next().onScreenOff();
        goto L4
    L6:
        BWDLCallback r10 = BWDLManager.mBWDLCallback;
        if (r10 == null) goto L11;
        r10.onScreenOff();
        return;
    }

    private void sendScreenOnToListener() {
        Iterator<ISystemBroadcastListener> r8 = this.mListenerList.iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        r8.next().onScreenOn();
        goto L4
    L6:
        BWDLCallback r10 = BWDLManager.mBWDLCallback;
        if (r10 == null) goto L11;
        r10.onScreenOn();
        return;
    }

    private void sendWifiStateChangeToListener(int r8) {
        Iterator<ISystemBroadcastListener> r10 = this.mListenerList.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().onWifiStateChanged(r8);
        goto L4
    L6:
        BWDLCallback r11 = BWDLManager.mBWDLCallback;
        if (r11 == null) goto L11;
        r11.onWifiStateChanged(r8);
        return;
    }

    public void cleanup() {
        this.mContext.unregisterReceiver(this.mBWDLBroadcastReceiver);
    }

    public void removeSystemBroadcastListener(ISystemBroadcastListener r8) {
        List<ISystemBroadcastListener> r10 = this.mListenerList;
        monitor-enter(r10);
        this.mListenerList.remove(r8);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setSystemBroadcastListener(ISystemBroadcastListener r8) {
        List<ISystemBroadcastListener> r10 = this.mListenerList;
        monitor-enter(r10);
        this.mListenerList.add(r8);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
