package com.sdk.bwdl.AdapterLayer.GATT.GattAdapter;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattService;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.sdk.bwdl.AdapterLayer.GATT.GATTEnhance.BluetoothGattCentralCallback;
import com.sdk.bwdl.AdapterLayer.GATT.GATTEnhance.BluetoothGattPeripheralCallback;
import com.sdk.bwdl.AdapterLayer.GATT.GATTEnhance.BluetoothLeManager;
import com.sdk.bwdl.AdapterLayer.IBWDLAdapter;
import com.sdk.bwdl.AdapterLayer.IBWDLAdapterEventListener;
import com.sdk.bwdl.BWDLDevice;
import com.sdk.bwdl.Utils.BWDLInnerConstant;
import com.sdk.bwdl.Utils.BWDLLog;
import com.sdk.bwdl.Utils.BWDLUtil;
import java.lang.reflect.InvocationTargetException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.crypto.SecretKey;

/* JADX INFO: loaded from: classes2.dex */
public class GattOriginal implements IBWDLAdapter {
    private static final String TAG = "GattOriginal";
    private static volatile GattOriginal sInstance;
    private List<IBWDLAdapterEventListener> mAdapterEventListenerList;
    private final ConcurrentMap<BluetoothDevice, IBWDLAdapterEventListener> mAdapterEventListenerMap;
    private List<BluetoothDevice> mBWDLDeviceList;
    private BluetoothGattService mBWDLService;
    private BluetoothLeManager mBluetoothLeManager;
    private final ConcurrentMap<BluetoothDevice, Queue<byte[]>> mCacheDataMap;
    private BluetoothGattCentralCallback mCentralCallback;
    private List<BluetoothDevice> mConnectDevicesList;
    private Context mContext;
    private BluetoothGattPeripheralCallback mPeripheralCallback;
    private BroadcastReceiver mReceiver;
    private SecretKey mSecretKey;

    private GattOriginal(Context r8) {
        this.mAdapterEventListenerMap = new ConcurrentHashMap();
        this.mAdapterEventListenerList = new CopyOnWriteArrayList();
        this.mConnectDevicesList = new CopyOnWriteArrayList();
        this.mCacheDataMap = new ConcurrentHashMap();
        this.mBWDLDeviceList = new CopyOnWriteArrayList();
        this.mCentralCallback = new AnonymousClass1(this);
        this.mPeripheralCallback = new AnonymousClass2(this);
        this.mReceiver = new AnonymousClass3(this);
        this.mContext = r8;
        BluetoothLeManager r10 = BluetoothLeManager.getInstance(r8);
        this.mBluetoothLeManager = r10;
        this.mBWDLService = r10.buildGattService(BWDLInnerConstant.SERVICE_UUID, BWDLInnerConstant.CHARACTERISTIC_WRITE_UUID);
        this.mBluetoothLeManager.registerGattCentralCallback(this.mCentralCallback);
        this.mBluetoothLeManager.registerGattPeripheralCallback(this.mPeripheralCallback);
        IntentFilter r11 = new IntentFilter();
        r11.addAction("android.bluetooth.device.action.BOND_STATE_CHANGED");
        this.mContext.registerReceiver(this.mReceiver, r11);
        this.mSecretKey = BWDLUtil.generateKey();     // Catch: InvalidKeySpecException -> L5 NoSuchAlgorithmException -> L8
        return;
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static /* synthetic */ Boolean access$000(GattOriginal r8, int r10) {
        return r8.underLinkLoss(r10);
    }

    public static /* synthetic */ List access$100(GattOriginal r8) {
        return r8.mConnectDevicesList;
    }

    public static /* synthetic */ ConcurrentMap access$200(GattOriginal r8) {
        return r8.mCacheDataMap;
    }

    public static /* synthetic */ List access$300(GattOriginal r8) {
        return r8.mBWDLDeviceList;
    }

    public static /* synthetic */ BluetoothLeManager access$400(GattOriginal r8) {
        return r8.mBluetoothLeManager;
    }

    public static /* synthetic */ Context access$500(GattOriginal r8) {
        return r8.mContext;
    }

    public static /* synthetic */ SecretKey access$600(GattOriginal r8) {
        return r8.mSecretKey;
    }

    public static /* synthetic */ BluetoothGattService access$700(GattOriginal r8) {
        return r8.mBWDLService;
    }

    public static GattOriginal getInstance(Context r8) {
        if (sInstance != null) goto L15;
        monitor-enter(GattOriginal.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new GattOriginal(r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(GattOriginal.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private boolean isBWDLDeviceEncrypted(BWDLDevice r8) {
        if (r8 != null) goto L5;
    L17:
        return false;
    L5:
        if ((r8.getDeviceInfo() instanceof BluetoothDevice) == false) goto L17;
        BluetoothDevice r10 = (BluetoothDevice) r8.getDeviceInfo();     // Catch: InvocationTargetException -> L11 IllegalAccessException -> L13 NoSuchMethodException -> L15
        if (((Boolean) r10.getClass().getMethod("isEncrypted", new Class[0]).invoke(r10, new Object[0])).booleanValue() == false) goto L17;
        BWDLLog.d(TAG, "The link is already encrypted");     // Catch: InvocationTargetException -> L11 IllegalAccessException -> L13 NoSuchMethodException -> L15
        return true;
    L13:
        e = move-exception;
        e.printStackTrace();
    L15:
        e = move-exception;
        e.printStackTrace();
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }

    private Boolean underLinkLoss(int r8) {
        if (r8 == 8) goto L14;
        if (r8 == 40) goto L14;
        if (r8 == 62) goto L14;
        if (r8 == 61) goto L14;
        return Boolean.FALSE;
    L14:
        return Boolean.TRUE;
    }

    @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapter
    public void accept() {
    }

    public void cleanup() {
        this.mBluetoothLeManager.unregisterGattCentralCallback(this.mCentralCallback);
        this.mBluetoothLeManager.unregisterGattPeripheralCallback(this.mPeripheralCallback);
        this.mContext.unregisterReceiver(this.mReceiver);
        this.mAdapterEventListenerList.clear();
        this.mAdapterEventListenerMap.clear();
        this.mCacheDataMap.clear();
        this.mBWDLDeviceList.clear();
        this.mBluetoothLeManager.closeGattServer();
        sInstance = null;
    }

    @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapter
    public void close() {
        cleanup();
    }

    @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapter
    public boolean connect(BWDLDevice r8) {
        if (r8 != null) goto L5;
    L12:
        return false;
    L5:
        if ((r8.getDeviceInfo() instanceof BluetoothDevice) == false) goto L12;
        if (this.mConnectDevicesList.contains((BluetoothDevice) r8.getDeviceInfo()) == false) goto L10;
        BWDLLog.d(TAG, "connection already ongoing");
        return false;
    L10:
        this.mConnectDevicesList.add((BluetoothDevice) r8.getDeviceInfo());
        return this.mBluetoothLeManager.centralConnect((BluetoothDevice) r8.getDeviceInfo());
    }

    @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapter
    public boolean disconnect(BWDLDevice r8) {
        if (r8 != null) goto L4;
        return false;
    L4:
        if ((r8.getDeviceInfo() instanceof BluetoothDevice) == true) goto L6;
        return false;
    L6:
        return this.mBluetoothLeManager.centralDisconnect((BluetoothDevice) r8.getDeviceInfo());
    }

    @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapter
    public void encrypt(BWDLDevice r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        if ((r8.getDeviceInfo() instanceof BluetoothDevice) == true) goto L6;
        return;
    L6:
        if (isBWDLDeviceEncrypted(r8) == false) goto L20;
        sendBondStateToUpper(r8, 6);
        return;
    L20:
        BluetoothDevice r10 = (BluetoothDevice) r8.getDeviceInfo();     // Catch: IllegalAccessException -> L10 InvocationTargetException -> L13 NoSuchMethodException -> L16
        r10.getClass().getMethod("createBond", new Class[]{Integer.TYPE}).invoke(r10, new Object[]{2});     // Catch: IllegalAccessException -> L10 InvocationTargetException -> L13 NoSuchMethodException -> L16
    L24:
        return;
    L10:
        e = move-exception;
        throw new RuntimeException(e);
    L16:
        e = move-exception;
        throw new RuntimeException(e);
    L13:
        e = move-exception;
        throw new RuntimeException(e);
    }

    @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapter
    public Object getCapabilities() {
        return null;
    }

    @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapter
    public boolean init() {
        BluetoothLeManager r8 = this.mBluetoothLeManager;
        if (r8 == null) goto L7;
        r8.registerGattCentralCallback(this.mCentralCallback);
        this.mBluetoothLeManager.registerGattPeripheralCallback(this.mPeripheralCallback);
        this.mBluetoothLeManager.openGattServer(new BluetoothGattService[]{this.mBWDLService});
        BWDLLog.d(TAG, "openGattServer");
        return true;
    L7:
        return true;
    }

    @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapter
    public int isAdapterReady() {
        return 0;
    }

    @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapter
    public void listen() {
    }

    @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapter
    public int recv(byte[] r8) {
        return 0;
    }

    @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapter
    public void removeBWDLAdapterEventListener(IBWDLAdapterEventListener r8) {
        BWDLLog.d(TAG, "removeBWDLAdapterEventListener");
        List<IBWDLAdapterEventListener> r10 = this.mAdapterEventListenerList;
        monitor-enter(r10);
        if (r8 != null) goto L25;
    L6:
        monitor-exit(r10);     // Catch: Throwable -> L20
        ConcurrentMap<BluetoothDevice, IBWDLAdapterEventListener> r11 = this.mAdapterEventListenerMap;
        monitor-enter(r11);
        Iterator<BluetoothDevice> r12 = this.mAdapterEventListenerMap.keySet().iterator();     // Catch: Throwable -> L17
    L11:
        if (r12.hasNext() == false) goto L15;
        BluetoothDevice r13 = r12.next();     // Catch: Throwable -> L17
        if (this.mAdapterEventListenerMap.get(r13) != r8) goto L11;
        this.mAdapterEventListenerMap.remove(r13);     // Catch: Throwable -> L17
        BWDLLog.d(TAG, "removeAdapterEventListenerMap");     // Catch: Throwable -> L17
        goto L11
    L15:
        monitor-exit(r11);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    L20:
        th = move-exception;
        throw th;
    L25:
        this.mAdapterEventListenerList.remove(r8);     // Catch: Throwable -> L20
        BWDLLog.d(TAG, "removeAdapterEventListenerList");     // Catch: Throwable -> L20
        goto L6
    }

    @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapter
    public void send(BWDLDevice r8, byte[] r10) {
        if (r8 != null) goto L4;
        return;
    L4:
        if ((r8.getDeviceInfo() instanceof BluetoothDevice) == true) goto L12;
        return;
    L12:
        BWDLLog.d(TAG, "write result:" + this.mBluetoothLeManager.centralWriteCharacteristic((BluetoothDevice) r8.getDeviceInfo(), BWDLInnerConstant.CHARACTERISTIC_WRITE_UUID, BWDLUtil.AESEncrypt(r10, this.mSecretKey)));
        return;
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public void sendBondStateToUpper(BWDLDevice r8, int r10) {
        BWDLLog.d(TAG, "sendBondStateToUpper");
        ConcurrentMap<BluetoothDevice, IBWDLAdapterEventListener> r11 = this.mAdapterEventListenerMap;
        monitor-enter(r11);
    L21:
        th = move-exception;
        throw th;
    L5:
        if (this.mAdapterEventListenerMap.containsKey(r8.getDeviceInfo()) == false) goto L7;
        this.mAdapterEventListenerMap.get(r8.getDeviceInfo()).onBondStateChanged(r8, r10);     // Catch: Throwable -> L21
    L7:
        monitor-exit(r11);     // Catch: Throwable -> L21
        List<IBWDLAdapterEventListener> r12 = this.mAdapterEventListenerList;
        monitor-enter(r12);
        Iterator<IBWDLAdapterEventListener> r13 = this.mAdapterEventListenerList.iterator();     // Catch: Throwable -> L18
    L12:
        if (r13.hasNext() == false) goto L16;
        IBWDLAdapterEventListener r14 = r13.next();     // Catch: Throwable -> L18
        if (r14 == null) goto L12;
        r14.onBondStateChanged(r8, r10);     // Catch: Throwable -> L18
        goto L12
    L16:
        monitor-exit(r12);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        throw th;
    }

    public void sendCacheDataToUpper(BluetoothDevice r8) {
        ConcurrentMap<BluetoothDevice, Queue<byte[]>> r10 = this.mCacheDataMap;
        monitor-enter(r10);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.mCacheDataMap.containsKey(r8) == false) goto L11;
        BWDLLog.d(TAG, "sendCacheDataToUpper");     // Catch: Throwable -> L13
        BWDLDevice r11 = new BWDLDevice(BWDLInnerConstant.ConnectivityType.GATT, r8);     // Catch: Throwable -> L13
        Iterator<byte[]> r12 = this.mCacheDataMap.get(r8).iterator();     // Catch: Throwable -> L13
    L8:
        if (r12.hasNext() == false) goto L10;
        sendReceivedDataToUpper(r11, r12.next());     // Catch: Throwable -> L13
        r12.remove();     // Catch: Throwable -> L13
        goto L8
    L10:
        this.mCacheDataMap.remove(r8);     // Catch: Throwable -> L13
    L11:
        monitor-exit(r10);     // Catch: Throwable -> L13
    }

    public void sendConnectionStateToUpper(BWDLDevice r8, int r10) {
        BWDLLog.d(TAG, "sendConnectionStateToUpper");
        ConcurrentMap<BluetoothDevice, IBWDLAdapterEventListener> r11 = this.mAdapterEventListenerMap;
        monitor-enter(r11);
    L21:
        th = move-exception;
        throw th;
    L5:
        if (this.mAdapterEventListenerMap.containsKey(r8.getDeviceInfo()) == false) goto L7;
        this.mAdapterEventListenerMap.get(r8.getDeviceInfo()).onConnectionStateChanged(r8, r10);     // Catch: Throwable -> L21
    L7:
        monitor-exit(r11);     // Catch: Throwable -> L21
        List<IBWDLAdapterEventListener> r12 = this.mAdapterEventListenerList;
        monitor-enter(r12);
        Iterator<IBWDLAdapterEventListener> r13 = this.mAdapterEventListenerList.iterator();     // Catch: Throwable -> L18
    L12:
        if (r13.hasNext() == false) goto L16;
        IBWDLAdapterEventListener r14 = r13.next();     // Catch: Throwable -> L18
        if (r14 == null) goto L12;
        r14.onConnectionStateChanged(r8, r10);     // Catch: Throwable -> L18
        goto L12
    L16:
        monitor-exit(r12);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        throw th;
    }

    public void sendReceivedDataToUpper(BWDLDevice r8, byte[] r10) {
        BWDLLog.d(TAG, "sendReceivedDataToUpper");
        ConcurrentMap<BluetoothDevice, IBWDLAdapterEventListener> r11 = this.mAdapterEventListenerMap;
        monitor-enter(r11);
    L21:
        th = move-exception;
        throw th;
    L5:
        if (this.mAdapterEventListenerMap.containsKey(r8.getDeviceInfo()) == false) goto L7;
        this.mAdapterEventListenerMap.get(r8.getDeviceInfo()).onDataReceived(r10);     // Catch: Throwable -> L21
    L7:
        monitor-exit(r11);     // Catch: Throwable -> L21
        List<IBWDLAdapterEventListener> r12 = this.mAdapterEventListenerList;
        monitor-enter(r12);
        Iterator<IBWDLAdapterEventListener> r13 = this.mAdapterEventListenerList.iterator();     // Catch: Throwable -> L18
    L12:
        if (r13.hasNext() == false) goto L16;
        IBWDLAdapterEventListener r14 = r13.next();     // Catch: Throwable -> L18
        if (r14 == null) goto L12;
        r14.onDataReceived(r10);     // Catch: Throwable -> L18
        goto L12
    L16:
        monitor-exit(r12);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        throw th;
    }

    public void sendWriteCompleteToUpper(BWDLDevice r8, int r10) {
        BWDLLog.d(TAG, "sendWriteCompleteToUpper");
        ConcurrentMap<BluetoothDevice, IBWDLAdapterEventListener> r11 = this.mAdapterEventListenerMap;
        monitor-enter(r11);
    L21:
        th = move-exception;
        throw th;
    L5:
        if (this.mAdapterEventListenerMap.containsKey(r8.getDeviceInfo()) == false) goto L7;
        this.mAdapterEventListenerMap.get(r8.getDeviceInfo()).onWriteComplete(r10);     // Catch: Throwable -> L21
    L7:
        monitor-exit(r11);     // Catch: Throwable -> L21
        List<IBWDLAdapterEventListener> r12 = this.mAdapterEventListenerList;
        monitor-enter(r12);
        Iterator<IBWDLAdapterEventListener> r13 = this.mAdapterEventListenerList.iterator();     // Catch: Throwable -> L18
    L12:
        if (r13.hasNext() == false) goto L16;
        IBWDLAdapterEventListener r14 = r13.next();     // Catch: Throwable -> L18
        if (r14 == null) goto L12;
        r14.onWriteComplete(r10);     // Catch: Throwable -> L18
        goto L12
    L16:
        monitor-exit(r12);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        throw th;
    }

    @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapter
    public void setBWDLAdapterEventListener(IBWDLAdapterEventListener r8) {
        BWDLLog.d(TAG, "setBWDLAdapterEventListener");
        List<IBWDLAdapterEventListener> r10 = this.mAdapterEventListenerList;
        monitor-enter(r10);
        if (r8 != null) goto L11;
    L6:
        monitor-exit(r10);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    L11:
        this.mAdapterEventListenerList.add(r8);     // Catch: Throwable -> L8
        goto L6
    }

    @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapter
    public void setBWDLAdapterEventListener(BWDLDevice r8, IBWDLAdapterEventListener r10) {
        BWDLLog.d(TAG, "setBWDLAdapterEventListener");
        ConcurrentMap<BluetoothDevice, IBWDLAdapterEventListener> r11 = this.mAdapterEventListenerMap;
        monitor-enter(r11);
        if (r10 != null) goto L11;
    L6:
        monitor-exit(r11);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    L11:
        this.mAdapterEventListenerMap.put((BluetoothDevice) r8.getDeviceInfo(), r10);     // Catch: Throwable -> L8
        goto L6
    }
}
