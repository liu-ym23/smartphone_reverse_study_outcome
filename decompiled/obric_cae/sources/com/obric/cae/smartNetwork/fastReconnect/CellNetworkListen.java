package com.obric.cae.smartNetwork.fastReconnect;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.telephony.CellIdentityNr;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoNr;
import android.telephony.CellInfoTdscdma;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropConstant;
import com.obric.cae.log.CaeLog;
import com.obric.cae.userAware.CellAwareInfoManger;
import i.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import v0.d;

/* JADX INFO: loaded from: classes2.dex */
public class CellNetworkListen extends PhoneStateListener {
    private static final String ACTION_SIM_STATE_CHANGED = "android.intent.action.SIM_STATE_CHANGED";
    private static final int REQUEST_CELL_DELAY_TIME_MS = 30000;
    private static final long UNAVAILABLE = Long.MAX_VALUE;
    private final String TAG;
    private CellAwareInfoManger mCellAwareInfoManger;
    private long mCellId;
    private final Object mCellIdLock;
    private boolean mCellIdMatchSuccessStatus;
    private final TelephonyManager.CellInfoCallback mCellInfoCallback;
    private CellNetworkManager mCellNetworkManager;
    private final Context mContext;
    private Handler mHandler;
    private HandlerThread mHandlerThread;
    private final BroadcastReceiver mMediaMountedReceiver;
    private int mSimCardState;
    private final BroadcastReceiver mSimCardStateReceiver;
    private IntentFilter mTelephonyFilter;
    private TelephonyManager mTelephonyManager;
    private IntentFilter mWifiFilter;
    private WifiManager mWifiManager;
    private final WifiScanManager mWifiScanManager;
    private final BroadcastReceiver mWifiStateReceiver;
    private boolean register;

    public CellNetworkListen(Context r8, WifiScanManager r10) {
        super(r8.getMainExecutor());
        this.TAG = "CellNetworkListen";
        this.register = false;
        this.mCellId = UNAVAILABLE;
        this.mCellIdMatchSuccessStatus = false;
        this.mSimCardState = 0;
        this.mCellIdLock = new Object();
        this.mCellInfoCallback = new AnonymousClass2(this);
        this.mWifiStateReceiver = new AnonymousClass3(this);
        this.mSimCardStateReceiver = new AnonymousClass4(this);
        this.mMediaMountedReceiver = new AnonymousClass5(this);
        this.mContext = r8;
        this.mWifiScanManager = r10;
        HandlerThread r11 = new HandlerThread("CellNetworkListenThread");
        this.mHandlerThread = r11;
        r11.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper());
        init();
    }

    public static /* synthetic */ void access$000(CellNetworkListen r8) {
        r8.requestCellInfoUpdate();
    }

    public static /* synthetic */ long access$100(CellNetworkListen r8, List r10) {
        return r8.getCellIdFromCellInfo(r10);
    }

    public static /* synthetic */ Object access$200(CellNetworkListen r8) {
        return r8.mCellIdLock;
    }

    public static /* synthetic */ long access$300(CellNetworkListen r8) {
        return r8.mCellId;
    }

    public static /* synthetic */ long access$302(CellNetworkListen r8, long r10) {
        r8.mCellId = r10;
        return r10;
    }

    public static /* synthetic */ void access$400(CellNetworkListen r8, long r10) {
        r8.updateCellInfo(r10);
    }

    public static /* synthetic */ void access$500(CellNetworkListen r8) {
        r8.handleCellIdMatchChanged();
    }

    public static /* synthetic */ int access$600(CellNetworkListen r8) {
        return r8.mSimCardState;
    }

    public static /* synthetic */ int access$602(CellNetworkListen r8, int r10) {
        r8.mSimCardState = r10;
        return r10;
    }

    public static /* synthetic */ TelephonyManager access$700(CellNetworkListen r8) {
        return r8.mTelephonyManager;
    }

    private long getCellIdFromCellInfo(List<CellInfo> r8) {
        handleCellInfoChangedForAware(r8);
        Iterator<CellInfo> r10 = r8.iterator();
    L4:
        if (r10.hasNext() == false) goto L27;
        CellInfo r11 = r10.next();
        if (r11.isRegistered() == false) goto L4;
        if ((r11 instanceof CellInfoWcdma) == false) goto L13;
        int r12 = ((CellInfoWcdma) r11).getCellIdentity().getCid();
    L32:
        return r12;
    L13:
        if ((r11 instanceof CellInfoGsm) == false) goto L16;
        r12 = ((CellInfoGsm) r11).getCellIdentity().getCid();
        goto L32
    L16:
        if ((r11 instanceof CellInfoNr) == false) goto L19;
        return ((CellIdentityNr) ((CellInfoNr) r11).getCellIdentity()).getNci();
    L19:
        if ((r11 instanceof CellInfoLte) == false) goto L22;
        r12 = ((CellInfoLte) r11).getCellIdentity().getCi();
        goto L32
    L22:
        if ((r11 instanceof CellInfoTdscdma) == false) goto L25;
        r12 = ((CellInfoTdscdma) r11).getCellIdentity().getCid();
        goto L32
    L25:
        if ((r11 instanceof CellInfoCdma) == false) goto L27;
        r12 = ((CellInfoCdma) r11).getCellIdentity().getBasestationId();
    L27:
        return UNAVAILABLE;
    }

    private void handleCellIdMatchChanged() {
        boolean r8 = this.mCellNetworkManager.isCellIdMatchSuccess(this.mCellId);
        if (r8 == this.mCellIdMatchSuccessStatus) goto L6;
        this.mCellIdMatchSuccessStatus = r8;
        this.mWifiScanManager.handleCellIdMatchChanged(r8);
        return;
    }

    private void handleCellInfoChangedForAware(List<CellInfo> r8) {
        CaeLog.i("CellNetworkListen", "handleCellInfoChangedForAware");
        CellAwareInfoManger r10 = CellAwareInfoManger.getInstance(this.mContext);
        this.mCellAwareInfoManger = r10;
        if (r10 != null) goto L5;
        return;
    L5:
        Iterator<CellInfo> r11 = r8.iterator();
    L7:
        if (r11.hasNext() == false) goto L11;
        CellInfo r12 = r11.next();
        if (r12.isRegistered() == false) goto L7;
        this.mCellAwareInfoManger.handleCellInfoChange(r12);
    L11:
        this.mCellAwareInfoManger.handleCellNeighborInfoChange(r8);
    }

    private void init() {
        this.mTelephonyManager = (TelephonyManager) this.mContext.getSystemService("phone");
        CellNetworkManager r8 = new CellNetworkManager(this.mContext);
        this.mCellNetworkManager = r8;
        r8.loadFromStore();
        this.mWifiManager = (WifiManager) this.mContext.getSystemService("wifi");
        this.mWifiFilter = new IntentFilter("android.net.wifi.STATE_CHANGE");
        this.mTelephonyFilter = new IntentFilter(ACTION_SIM_STATE_CHANGED);
        this.mContext.registerReceiver(this.mWifiStateReceiver, this.mWifiFilter);
        this.mContext.registerReceiver(this.mSimCardStateReceiver, this.mTelephonyFilter);
        IntentFilter r10 = new IntentFilter();
        r10.addAction("android.intent.action.MEDIA_MOUNTED");
        r10.addDataScheme(BwdlDropConstant.FILE);
        this.mContext.registerReceiver(this.mMediaMountedReceiver, r10);
        if (isExternalStorageMounted() == false) goto L12;
        CaeLog.d("CellNetworkListen", "external storage already mounted and request cell info.");
        this.mTelephonyManager.requestCellInfoUpdate(new d(3), this.mCellInfoCallback);     // Catch: IllegalStateException -> L7
        return;
    L7:
        e = move-exception;
        CaeLog.e("CellNetworkListen", "IllegalStateException: " + e.getMessage());
        this.mHandler.postDelayed(new AnonymousClass1(this), 30000);
        return;
    }

    private void requestCellInfoUpdate() {
        if (isExternalStorageMounted() == false) goto L11;
        this.mTelephonyManager.requestCellInfoUpdate(new a(2), this.mCellInfoCallback);     // Catch: IllegalStateException -> L6
        return;
    L6:
        e = move-exception;
        CaeLog.e("CellNetworkListen", "IllegalStateException: " + e.getMessage());
        return;
    }

    private void updateCellInfo(long r8) {
        if (r8 != UNAVAILABLE) goto L6;
        return;
    L6:
        if (this.mWifiManager.isWifiEnabled() == true) goto L8;
        return;
    L8:
        WifiInfo r10 = this.mWifiManager.getConnectionInfo();
        if (r10 != null) goto L11;
        return;
    L11:
        if (r10.getNetworkId() == (-1)) goto L16;
        CaeLog.d("CellNetworkListen", "add or update cell info, cellId:" + r8 + ", ssid: " + r10.getSSID());
        ArrayList r11 = new ArrayList();
        r11.add(r10.getSSID());
        this.mCellNetworkManager.addOrUpdateCellInfo(new CellNetworkInfo(r8, r11));
        this.mCellNetworkManager.saveToStore();
        return;
    }

    public boolean isExternalStorageMounted() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    @Override // android.telephony.PhoneStateListener
    public void onCellLocationChanged(CellLocation r8) {
        super.onCellLocationChanged(r8);
        if (this.mSimCardState == 1) goto L6;
        requestCellInfoUpdate();
        return;
    }

    @Override // android.telephony.PhoneStateListener
    public void onServiceStateChanged(ServiceState r8) {
        super.onServiceStateChanged(r8);
        if (this.mSimCardState == 1) goto L6;
        requestCellInfoUpdate();
        return;
    }

    public void register() {
        if (this.register == true) goto L6;
        this.mTelephonyManager.listen(this, 17);
        CaeLog.d("CellNetworkListen", "register LISTEN_CELL_LOCATION and LISTEN_SERVICE_STATE Event!");
        this.register = true;
        return;
    }

    public void unregister() {
        if (this.register == false) goto L6;
        this.mTelephonyManager.listen(this, 0);
        CaeLog.d("CellNetworkListen", "unregister ANY_LISTEN Event!");
        this.register = false;
        return;
    }
}
