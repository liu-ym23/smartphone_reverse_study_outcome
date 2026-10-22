package com.obric.cae.smartBluetooth;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.obric.cae.libs.bluetooth.BdimPredictEvent;
import com.obric.cae.libs.bluetooth.BtDeviceInfoExtEvent;
import com.obric.cae.libs.bluetooth.CaeBluetoothEvent;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartBluetooth.deviceIdentification.BluetoothDeviceInfoExt;
import com.obric.cae.utils.CaeUtil;

/* JADX INFO: loaded from: classes.dex */
public class SmartBluetoothEventHandler {
    private static final int MSG_A2DP_CONNECTED_EVENT_REPORTED = 10;
    private static final int MSG_BLUETOOTH_COMPATIBILITY_EVENT_REPORTED = 1;
    private static final int MSG_BLUETOOTH_DEVICE_INFO_EXT_EVENT_REPORTED = 2;
    private static final int MSG_BLUETOOTH_DEVICE_INFO_FACTORS_REPORTED = 3;
    private static final int MSG_HFP_CONNECTED_EVENT_REPORTED = 11;
    private static final String TAG = "SmartBluetoothEventHandler";
    private final Context mContext;
    private EventHandler mEventHandler;
    private HandlerThread mEventHandlerThread;
    private BluetoothProfileEventReceiver mEventReceiver;

    /* JADX INFO: renamed from: com.obric.cae.smartBluetooth.SmartBluetoothEventHandler$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    @SuppressLint({"InlinedApi"})
    public class BluetoothProfileEventReceiver extends BroadcastReceiver {
        final /* synthetic */ SmartBluetoothEventHandler this$0;

        private BluetoothProfileEventReceiver(SmartBluetoothEventHandler r8) {
            this.this$0 = r8;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r8, Intent r10) {
            if (r8 == null) goto L25;
            if (r10 == null) goto L29;
            String r11 = r10.getAction();
            CaeLog.d(SmartBluetoothEventHandler.access$100(), "receive action: " + r11);
            if ("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED".equals(r11) == false) goto L15;
            int r12 = r10.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
            if (r12 == 2) goto L11;
            if (r12 == 0) goto L11;
            return;
        L11:
            BluetoothDevice r13 = (BluetoothDevice) r10.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            if (r12 != 2) goto L26;
            EventHandler r14 = SmartBluetoothEventHandler.access$300(this.this$0);
            int r15 = 10;
        L23:
            CaeUtil.sendMessageWithParam(r14, r15, r13);
            return;
        L26:
            return;
        L15:
            if ("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED".equals(r11) == false) goto L27;
            int r16 = r10.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
            if (r16 == 2) goto L20;
            if (r16 == 0) goto L20;
            return;
        L20:
            r13 = (BluetoothDevice) r10.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            if (r16 != 2) goto L28;
            r14 = SmartBluetoothEventHandler.access$300(this.this$0);
            r15 = 11;
            goto L23
        L28:
            return;
        L27:
            return;
        L29:
            return;
        }

        public /* synthetic */ BluetoothProfileEventReceiver(SmartBluetoothEventHandler r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public class EventHandler extends Handler {
        final /* synthetic */ SmartBluetoothEventHandler this$0;

        public EventHandler(SmartBluetoothEventHandler r8, Looper r10) {
            this.this$0 = r8;
            super(r10);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r8) {
            String r10 = SmartBluetoothEventHandler.access$100();
            defpackage.a.j(new StringBuilder("event handler: "), r8.what, r10);
            SmartBluetoothAnalyzer r11 = SmartBluetoothManager.getInstance(SmartBluetoothEventHandler.access$200(this.this$0)).getAnalyzer();
            BluetoothDeviceInfoExt r12 = SmartBluetoothManager.getInstance(SmartBluetoothEventHandler.access$200(this.this$0)).getBluetoothDeviceInfoExt();
            int r13 = r8.what;
            if (r13 != 1) goto L5;
            if (r11 == null) goto L32;
            r11.onEventReported((CaeBluetoothEvent) r8.obj);
            return;
        L32:
            return;
        L5:
            if (r13 != 2) goto L7;
            if (r12 == null) goto L30;
            r12.parseBluetoothDeviceInfo((BtDeviceInfoExtEvent) r8.obj);
            return;
        L30:
            return;
        L7:
            if (r13 != 3) goto L9;
            if (r12 == null) goto L28;
            r12.parseBluetoothDeviceFactors((BdimPredictEvent) r8.obj);
            return;
        L28:
            return;
        L9:
            if (r13 != 10) goto L11;
            if (r11 == null) goto L26;
            r11.onA2dpConnected((BluetoothDevice) r8.obj);
            return;
        L26:
            return;
        L11:
            if (r13 != 11) goto L33;
            if (r11 == null) goto L24;
            r11.onHfpConnected((BluetoothDevice) r8.obj);
            return;
        L24:
            return;
        }
    }

    public SmartBluetoothEventHandler(Context r8) {
        this.mContext = r8;
        HandlerThread r10 = new HandlerThread("event handler");
        this.mEventHandlerThread = r10;
        r10.start();
        this.mEventHandler = new EventHandler(this, this.mEventHandlerThread.getLooper());
        this.mEventReceiver = new BluetoothProfileEventReceiver(this, null);
        registerEventReceiver();
    }

    public static /* synthetic */ String access$100() {
        return TAG;
    }

    public static /* synthetic */ Context access$200(SmartBluetoothEventHandler r8) {
        return r8.mContext;
    }

    public static /* synthetic */ EventHandler access$300(SmartBluetoothEventHandler r8) {
        return r8.mEventHandler;
    }

    private void registerEventReceiver() {
        IntentFilter r8 = defpackage.a.c("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED", "android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
        this.mContext.registerReceiver(this.mEventReceiver, r8);
    }

    public void cleanup() {
        CaeLog.d(TAG, "cleanup");
        BluetoothProfileEventReceiver r8 = this.mEventReceiver;
        if (r8 == null) goto L5;
        this.mContext.unregisterReceiver(r8);
        this.mEventReceiver = null;
    L5:
        HandlerThread r10 = this.mEventHandlerThread;
        if (r10 == null) goto L9;
        r10.quitSafely();
        return;
    }

    public void onDeviceInfoEventReported(BtDeviceInfoExtEvent r8) {
        CaeUtil.sendMessageWithParam(this.mEventHandler, 2, r8);
    }

    public void onDeviceInfoFactorsReported(BdimPredictEvent r8) {
        CaeUtil.sendMessageWithParam(this.mEventHandler, 3, r8);
    }

    public void onEventReported(CaeBluetoothEvent r8) {
        CaeUtil.sendMessageWithParam(this.mEventHandler, 1, r8);
    }
}
