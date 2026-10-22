package com.obric.cae.smartBluetooth;

import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.hardware.display.DisplayManager;
import android.os.Parcelable;
import android.util.Log;
import android.view.Display;
import com.obric.cae.smartBluetooth.callback.SmartBluetoothEventCallback;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class SmartBluetoothEventReceiver extends BroadcastReceiver {
    public static final String EXTRA_UN_BOND_HCI_REASON = "android.bluetooth.device.extra.hciReason";
    private static final String TAG = "BluetoothEventReceiver";
    public static final List<SmartBluetoothEventCallback> mCallbackList = null;
    private static final DisplayManager.DisplayListener mDisplayListener = null;
    private static DisplayManager mDisplayManager;
    private static Context sContext;
    private static SmartBluetoothEventReceiver sInstance;
    private static boolean sScreenOn;

    static {
        mCallbackList = new CopyOnWriteArrayList();
        sScreenOn = false;
        mDisplayListener = new AnonymousClass1();
    }

    private SmartBluetoothEventReceiver(Context r8) {
        sContext = r8;
        DisplayManager r10 = (DisplayManager) r8.getSystemService("display");
        mDisplayManager = r10;
        if (r10 == null) goto L5;
        r10.registerDisplayListener(mDisplayListener, null);
    L5:
        sScreenOn = isScreenOn();
    }

    public static /* synthetic */ boolean access$000() {
        return isScreenOn();
    }

    public static void clean() {
        List<SmartBluetoothEventCallback> r8 = mCallbackList;
        monitor-enter(r8);
        r8.clear();     // Catch: Throwable -> L8
        monitor-exit(r8);     // Catch: Throwable -> L8
        sScreenOn = false;
        mDisplayManager.unregisterDisplayListener(mDisplayListener);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static SmartBluetoothEventReceiver getInstance(Context r8) {
        if (sInstance != null) goto L6;
        sInstance = new SmartBluetoothEventReceiver(r8);
    L6:
        return sInstance;
    }

    public static boolean getScreenState() {
        return sScreenOn;
    }

    private static boolean isScreenOn() {
        Display[] r8 = mDisplayManager.getDisplays();
        if (r8 != null) goto L5;
        return false;
    L5:
        int r10 = r8.length;
        int r11 = 0;
    L6:
        if (r11 >= r10) goto L12;
        if (r8[r11].getState() == 2) goto L9;
        r11 = r11 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    public static void registerEventCallback(SmartBluetoothEventCallback r8) {
        List<SmartBluetoothEventCallback> r10 = mCallbackList;
        monitor-enter(r10);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (r10.contains(r8) == false) goto L8;
        monitor-exit(r10);     // Catch: Throwable -> L11
        return;
    L8:
        r10.add(r8);     // Catch: Throwable -> L11
        monitor-exit(r10);     // Catch: Throwable -> L11
    }

    public static void unRegisterEventCallback(SmartBluetoothEventCallback r8) {
        List<SmartBluetoothEventCallback> r10 = mCallbackList;
        monitor-enter(r10);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (r10.contains(r8) == true) goto L8;
        monitor-exit(r10);     // Catch: Throwable -> L11
        return;
    L8:
        r10.remove(r8);     // Catch: Throwable -> L11
        monitor-exit(r10);     // Catch: Throwable -> L11
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r8, Intent r10) {
        String r11 = r10.getAction();
        if (r11 != null) goto L5;
        return;
    L5:
        Log.d(TAG, "action is ".concat(r11));
        byte r12 = -1;
        switch(r11.hashCode()) {
            case -1780914469: goto L61;
            case -1530327060: goto L57;
            case -1435586571: goto L53;
            case -855499628: goto L49;
            case -377527494: goto L45;
            case -301431627: goto L41;
            case 6759640: goto L37;
            case 360422632: goto L33;
            case 545516589: goto L29;
            case 921398788: goto L25;
            case 1167529923: goto L21;
            case 1244161670: goto L17;
            case 1821585647: goto L13;
            case 2116862345: goto L9;
            default: goto L65;
        };
    L9:
        if (r11.equals("android.bluetooth.device.action.BOND_STATE_CHANGED") == false) goto L65;
        r12 = 13;
        goto L65
    L13:
        if (r11.equals("android.bluetooth.device.action.ACL_DISCONNECTED") == false) goto L65;
        r12 = 12;
        goto L65
    L17:
        if (r11.equals("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED") == false) goto L65;
        r12 = 11;
        goto L65
    L21:
        if (r11.equals("android.bluetooth.device.action.FOUND") == false) goto L65;
        r12 = 10;
        goto L65
    L25:
        if (r11.equals("android.bluetooth.hiddevice.profile.action.CONNECTION_STATE_CHANGED") == false) goto L65;
        r12 = 9;
        goto L65
    L29:
        if (r11.equals("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED") == false) goto L65;
        r12 = 8;
        goto L65
    L33:
        if (r11.equals("android.bluetooth.adapter.action.BLE_STATE_CHANGED") == false) goto L65;
        r12 = 7;
        goto L65
    L37:
        if (r11.equals("android.bluetooth.adapter.action.DISCOVERY_STARTED") == false) goto L65;
        r12 = 6;
        goto L65
    L41:
        if (r11.equals("android.bluetooth.device.action.ACL_CONNECTED") == false) goto L65;
        r12 = 5;
        goto L65
    L45:
        if (r11.equals("android.bluetooth.device.action.UUID") == false) goto L65;
        r12 = 4;
        goto L65
    L49:
        if (r11.equals("android.bluetooth.a2dp.profile.action.PLAYING_STATE_CHANGED") == false) goto L65;
        r12 = 3;
        goto L65
    L53:
        if (r11.equals("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED") == false) goto L65;
        r12 = 2;
        goto L65
    L57:
        if (r11.equals("android.bluetooth.adapter.action.STATE_CHANGED") == false) goto L65;
        r12 = 1;
        goto L65
    L61:
        if (r11.equals("android.bluetooth.adapter.action.DISCOVERY_FINISHED") == false) goto L65;
        r12 = 0;
    L65:
        switch(r12) {
            case 0: goto L246;
            case 1: goto L235;
            case 2: goto L221;
            case 3: goto L207;
            case 4: goto L190;
            case 5: goto L176;
            case 6: goto L165;
            case 7: goto L154;
            case 8: goto L140;
            case 9: goto L126;
            case 10: goto L109;
            case 11: goto L95;
            case 12: goto L81;
            case 13: goto L67;
            default: goto L312;
        };
    L67:
        BluetoothDevice r13 = (BluetoothDevice) r10.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        if (r13 != null) goto L70;
        return;
    L70:
        int r14 = r10.getIntExtra("android.bluetooth.device.extra.BOND_STATE", Integer.MIN_VALUE);
        int r15 = r10.getIntExtra("android.bluetooth.device.extra.PREVIOUS_BOND_STATE", Integer.MIN_VALUE);
        int r16 = r10.getIntExtra(EXTRA_UN_BOND_HCI_REASON, Integer.MIN_VALUE);
        List<SmartBluetoothEventCallback> r17 = mCallbackList;
        monitor-enter(r17);
        Iterator<SmartBluetoothEventCallback> r18 = r17.iterator();     // Catch: Throwable -> L78
    L74:
        if (r18.hasNext() == false) goto L76;
        r18.next().onBondStateChangeCallback(r13, r15, r14, r16);     // Catch: Throwable -> L78
        goto L74
    L76:
        monitor-exit(r17);     // Catch: Throwable -> L78
        return;
    L78:
        th = move-exception;
        throw th;
    L81:
        BluetoothDevice r19 = (BluetoothDevice) r10.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        if (r19 != null) goto L84;
        return;
    L84:
        List<SmartBluetoothEventCallback> r20 = mCallbackList;
        monitor-enter(r20);
        Iterator<SmartBluetoothEventCallback> r21 = r20.iterator();     // Catch: Throwable -> L92
    L88:
        if (r21.hasNext() == false) goto L90;
        r21.next().onAclStateChangeEventCallback(r19, false);     // Catch: Throwable -> L92
        goto L88
    L90:
        monitor-exit(r20);     // Catch: Throwable -> L92
        return;
    L92:
        th = move-exception;
        throw th;
    L95:
        BluetoothDevice r22 = (BluetoothDevice) r10.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        if (r22 != null) goto L98;
        return;
    L98:
        int r23 = r10.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
        List<SmartBluetoothEventCallback> r24 = mCallbackList;
        monitor-enter(r24);
        Iterator<SmartBluetoothEventCallback> r25 = r24.iterator();     // Catch: Throwable -> L106
    L102:
        if (r25.hasNext() == false) goto L104;
        r25.next().onA2dpStateChangeEventCallback(r22, r23);     // Catch: Throwable -> L106
        goto L102
    L104:
        monitor-exit(r24);     // Catch: Throwable -> L106
        return;
    L106:
        th = move-exception;
        throw th;
    L109:
        BluetoothDevice r26 = (BluetoothDevice) r10.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        if (r26 != null) goto L112;
        return;
    L112:
        short r27 = r10.getShortExtra("android.bluetooth.device.extra.RSSI", Short.MIN_VALUE);
        BluetoothClass r28 = (BluetoothClass) r10.getParcelableExtra("android.bluetooth.device.extra.CLASS");
        if (r28 != null) goto L115;
        return;
    L115:
        int r29 = r28.hashCode();
        List<SmartBluetoothEventCallback> r30 = mCallbackList;
        monitor-enter(r30);
        Iterator<SmartBluetoothEventCallback> r31 = r30.iterator();     // Catch: Throwable -> L123
    L119:
        if (r31.hasNext() == false) goto L121;
        r31.next().onBrDeviceFoundCallback(r26, r27, r29);     // Catch: Throwable -> L123
        goto L119
    L121:
        monitor-exit(r30);     // Catch: Throwable -> L123
        return;
    L123:
        th = move-exception;
        throw th;
    L126:
        BluetoothDevice r32 = (BluetoothDevice) r10.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        if (r32 != null) goto L129;
        return;
    L129:
        int r33 = r10.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
        List<SmartBluetoothEventCallback> r34 = mCallbackList;
        monitor-enter(r34);
        Iterator<SmartBluetoothEventCallback> r35 = r34.iterator();     // Catch: Throwable -> L137
    L133:
        if (r35.hasNext() == false) goto L135;
        r35.next().onHidStateChangeEventCallback(r32, r33);     // Catch: Throwable -> L137
        goto L133
    L135:
        monitor-exit(r34);     // Catch: Throwable -> L137
        return;
    L137:
        th = move-exception;
        throw th;
    L140:
        BluetoothDevice r36 = (BluetoothDevice) r10.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        if (r36 != null) goto L143;
        return;
    L143:
        int r37 = r10.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
        List<SmartBluetoothEventCallback> r38 = mCallbackList;
        monitor-enter(r38);
        Iterator<SmartBluetoothEventCallback> r39 = r38.iterator();     // Catch: Throwable -> L151
    L147:
        if (r39.hasNext() == false) goto L149;
        r39.next().onHfpStateChangeEventCallback(r36, r37);     // Catch: Throwable -> L151
        goto L147
    L149:
        monitor-exit(r38);     // Catch: Throwable -> L151
        return;
    L151:
        th = move-exception;
        throw th;
    L154:
        int r40 = r10.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", 10);
        int r41 = r10.getIntExtra("android.bluetooth.adapter.extra.STATE", 10);
        List<SmartBluetoothEventCallback> r42 = mCallbackList;
        monitor-enter(r42);
        Iterator<SmartBluetoothEventCallback> r43 = r42.iterator();     // Catch: Throwable -> L162
    L158:
        if (r43.hasNext() == false) goto L160;
        r43.next().onBleAdapterStateChangeCallback(r40, r41);     // Catch: Throwable -> L162
        goto L158
    L160:
        monitor-exit(r42);     // Catch: Throwable -> L162
        return;
    L162:
        th = move-exception;
        throw th;
    L165:
        List<SmartBluetoothEventCallback> r44 = mCallbackList;
        monitor-enter(r44);
        Iterator<SmartBluetoothEventCallback> r45 = r44.iterator();     // Catch: Throwable -> L173
    L169:
        if (r45.hasNext() == false) goto L171;
        r45.next().onDiscoverStateChangeCallback(false);     // Catch: Throwable -> L173
        goto L169
    L171:
        monitor-exit(r44);     // Catch: Throwable -> L173
        return;
    L173:
        th = move-exception;
        throw th;
    L176:
        BluetoothDevice r46 = (BluetoothDevice) r10.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        if (r46 != null) goto L179;
        return;
    L179:
        List<SmartBluetoothEventCallback> r47 = mCallbackList;
        monitor-enter(r47);
        Iterator<SmartBluetoothEventCallback> r48 = r47.iterator();     // Catch: Throwable -> L187
    L183:
        if (r48.hasNext() == false) goto L185;
        r48.next().onAclStateChangeEventCallback(r46, true);     // Catch: Throwable -> L187
        goto L183
    L185:
        monitor-exit(r47);     // Catch: Throwable -> L187
        return;
    L187:
        th = move-exception;
        throw th;
    L190:
        BluetoothDevice r49 = (BluetoothDevice) r10.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        if (r49 != null) goto L193;
        return;
    L193:
        Parcelable[] r50 = r10.getParcelableArrayExtra("android.bluetooth.device.extra.UUID");
        if (r50 != null) goto L196;
        return;
    L196:
        List<SmartBluetoothEventCallback> r51 = mCallbackList;
        monitor-enter(r51);
        Iterator<SmartBluetoothEventCallback> r52 = r51.iterator();     // Catch: Throwable -> L204
    L200:
        if (r52.hasNext() == false) goto L202;
        r52.next().onDeviceUuidsFoundCallback(r49, r50);     // Catch: Throwable -> L204
        goto L200
    L202:
        monitor-exit(r51);     // Catch: Throwable -> L204
        return;
    L204:
        th = move-exception;
        throw th;
    L207:
        BluetoothDevice r53 = (BluetoothDevice) r10.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        if (r53 != null) goto L210;
        return;
    L210:
        int r54 = r10.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
        List<SmartBluetoothEventCallback> r55 = mCallbackList;
        monitor-enter(r55);
        Iterator<SmartBluetoothEventCallback> r56 = r55.iterator();     // Catch: Throwable -> L218
    L214:
        if (r56.hasNext() == false) goto L216;
        r56.next().onA2dpPlayingStateChangeEventCallback(r53, r54);     // Catch: Throwable -> L218
        goto L214
    L216:
        monitor-exit(r55);     // Catch: Throwable -> L218
        return;
    L218:
        th = move-exception;
        throw th;
    L221:
        BluetoothDevice r57 = (BluetoothDevice) r10.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        if (r57 != null) goto L224;
        return;
    L224:
        int r58 = r10.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
        List<SmartBluetoothEventCallback> r59 = mCallbackList;
        monitor-enter(r59);
        Iterator<SmartBluetoothEventCallback> r60 = r59.iterator();     // Catch: Throwable -> L232
    L228:
        if (r60.hasNext() == false) goto L230;
        r60.next().onHfpScoStateChangeEventCallback(r57, r58);     // Catch: Throwable -> L232
        goto L228
    L230:
        monitor-exit(r59);     // Catch: Throwable -> L232
        return;
    L232:
        th = move-exception;
        throw th;
    L235:
        int r61 = r10.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE);
        List<SmartBluetoothEventCallback> r62 = mCallbackList;
        monitor-enter(r62);
        Iterator<SmartBluetoothEventCallback> r63 = r62.iterator();     // Catch: Throwable -> L243
    L239:
        if (r63.hasNext() == false) goto L241;
        r63.next().onAdapterStateChangeCallback(r61);     // Catch: Throwable -> L243
        goto L239
    L241:
        monitor-exit(r62);     // Catch: Throwable -> L243
        return;
    L243:
        th = move-exception;
        throw th;
    L246:
        List<SmartBluetoothEventCallback> r64 = mCallbackList;
        monitor-enter(r64);
        Iterator<SmartBluetoothEventCallback> r65 = r64.iterator();     // Catch: Throwable -> L254
    L250:
        if (r65.hasNext() == false) goto L252;
        r65.next().onDiscoverStateChangeCallback(true);     // Catch: Throwable -> L254
        goto L250
    L252:
        monitor-exit(r64);     // Catch: Throwable -> L254
        return;
    L254:
        th = move-exception;
        throw th;
    }
}
