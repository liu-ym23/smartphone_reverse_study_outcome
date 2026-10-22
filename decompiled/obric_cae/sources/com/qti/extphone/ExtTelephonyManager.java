package com.qti.extphone;

import android.annotation.RequiresPermission;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.telephony.ImsiEncryptionInfo;
import android.telephony.NetworkScanRequest;
import android.util.Log;
import defpackage.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class ExtTelephonyManager {
    public static final int ACCESS_MODE_PLMN = 1;
    public static final int ACCESS_MODE_SNPN = 2;
    public static final String ACTION_SHOW_NOTICE_SCM_BLOCK_OTHERS = "org.codeaurora.intent.action.SHOW_NOTICE_SCM_BLOCK_OTHERS";
    public static final String ACTION_SMS_CALLBACK_MODE_CHANGED = "org.codeaurora.intent.action.SMS_CALLBACK_MODE_CHANGED";
    private static final boolean DBG = true;
    public static final String EXTRA_PHONE_IN_SCM_STATE = "org.codeaurora.extra.PHONE_IN_SCM_STATE";
    public static final int FEATURE_BACK_TO_BACK_SUPPLEMENTARY_SERVICE_REQ = 1;
    public static final int FEATURE_CELLULAR_ROAMING = 4;
    public static final int FEATURE_CIWLAN_MODE_PREFERENCE = 5;
    public static final int FEATURE_GET_CIWLAN_CONFIG = 3;
    public static final int FEATURE_PERSO_UNLOCK_TEMP = 2;
    public static final int FEATURE_SMART_TEMP_DDS_VIA_RADIO_CONFIG = 101;
    private static final int INVALID = -1;
    private static final String LOG_TAG = "ExtTelephonyManager";
    public static final String SIM_STATE_ESSENTIAL_RECORDS_LOADED = "ESSENTIAL_LOADED";
    private static ExtTelephonyManager mInstance;
    private ExtTelephonyServiceConnection mConnection;
    private Context mContext;
    private IExtPhone mExtTelephonyService;
    private List<ServiceCallback> mServiceCbs;
    private AtomicBoolean mServiceConnected;

    public class ExtTelephonyServiceConnection implements ServiceConnection {
        final /* synthetic */ ExtTelephonyManager this$0;

        private ExtTelephonyServiceConnection(ExtTelephonyManager r8) {
            this.this$0 = r8;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r8, IBinder r10) {
            ExtTelephonyManager.c(this.this$0, IExtPhone.Stub.asInterface(r10));
            if (ExtTelephonyManager.a(this.this$0) != null) goto L5;
            ExtTelephonyManager r11 = this.this$0;
            String r12 = "ExtTelephonyService Connect Failed (onServiceConnected)... ";
        L6:
            ExtTelephonyManager.d(r11, r12);
            ExtTelephonyManager.b(this.this$0).set(true);
            ExtTelephonyManager.e(this.this$0);
            return;
        L5:
            r11 = this.this$0;
            r12 = "ExtTelephonyService connected ... ";
            goto L6
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r8) {
            ExtTelephonyManager.d(this.this$0, "The connection to the service got disconnected!");
            ExtTelephonyManager.c(this.this$0, null);
            ExtTelephonyManager.b(this.this$0).set(false);
            ExtTelephonyManager.f(this.this$0);
        }

        public /* synthetic */ ExtTelephonyServiceConnection(ExtTelephonyManager r8, int r10) {
            this(r8);
        }
    }

    public ExtTelephonyManager(Context r8) {
        this.mConnection = new ExtTelephonyServiceConnection(this, 0);
        this.mExtTelephonyService = null;
        this.mServiceCbs = Collections.synchronizedList(new ArrayList());
        AtomicBoolean r10 = new AtomicBoolean();
        this.mServiceConnected = r10;
        if (r8 == null) goto L7;
        this.mContext = r8;
        r10.set(false);
        log("ExtTelephonyManager() ...");
        return;
    L7:
        throw new IllegalArgumentException("Context is null");
    }

    public static /* bridge */ /* synthetic */ IExtPhone a(ExtTelephonyManager r8) {
        return r8.mExtTelephonyService;
    }

    private void addServiceCallback(ServiceCallback r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (this.mServiceCbs.contains(r8) == true) goto L8;
        this.mServiceCbs.add(r8);
        return;
    }

    public static /* bridge */ /* synthetic */ AtomicBoolean b(ExtTelephonyManager r8) {
        return r8.mServiceConnected;
    }

    public static /* bridge */ /* synthetic */ void c(ExtTelephonyManager r8, IExtPhone r10) {
        r8.mExtTelephonyService = r10;
    }

    public static /* bridge */ /* synthetic */ void d(ExtTelephonyManager r8, String r10) {
        r8.log(r10);
    }

    public static /* bridge */ /* synthetic */ void e(ExtTelephonyManager r8) {
        r8.notifyConnected();
    }

    public static /* bridge */ /* synthetic */ void f(ExtTelephonyManager r8) {
        r8.notifyDisconnected();
    }

    public static synchronized ExtTelephonyManager getInstance(Context r8) {
        monitor-enter(ExtTelephonyManager.class);
        monitor-enter(ExtTelephonyManager.class);     // Catch: Throwable -> L19
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L7:
        if (mInstance != null) goto L12;
        if (r8 == null) goto L11;
        mInstance = new ExtTelephonyManager(r8.getApplicationContext());     // Catch: Throwable -> L16
        goto L12
    L11:
        throw new IllegalArgumentException("Context is null");     // Catch: Throwable -> L16
    L12:
        ExtTelephonyManager r10 = mInstance;     // Catch: Throwable -> L16
        monitor-exit(ExtTelephonyManager.class);     // Catch: Throwable -> L16
        monitor-exit(ExtTelephonyManager.class);
        return r10;
    L19:
        th = move-exception;
        throw th;
    }

    private void log(String r8) {
        Log.d(LOG_TAG, r8);
    }

    private void notifyConnected() {
        Iterator<ServiceCallback> r8 = this.mServiceCbs.iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        r8.next().onConnected();
        goto L4
    }

    private void notifyDisconnected() {
        Iterator<ServiceCallback> r8 = this.mServiceCbs.iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        r8.next().onDisconnected();
        goto L4
    }

    public boolean abortIncrementalScan(int r8) {
        if (isServiceConnected() == true) goto L11;
        Log.e(LOG_TAG, "service not connected!");
        return false;
    L11:
        return this.mExtTelephonyService.abortIncrementalScan(r8);
    L8:
        e = move-exception;
        Log.e(LOG_TAG, "abortIncrementalScan, remote exception", e);
        return false;
    }

    @RequiresPermission("android.permission.READ_PRIVILEGED_PHONE_STATE")
    public boolean checkSimPinLockStatus(int r8) {
        return this.mExtTelephonyService.checkSimPinLockStatus(r8);
    L5:
        throw new RemoteException("checkSimPinLockStatus ended in remote exception");
    }

    public boolean connectService(ServiceCallback r8) {
        if (isServiceConnected() == false) goto L5;
    L7:
        addServiceCallback(r8);
        if (isServiceConnected() == false) goto L13;
        if (r8 == null) goto L14;
        r8.onConnected();
        return true;
    L14:
        return true;
    L13:
        return true;
    L5:
        if (this.mServiceCbs.isEmpty() == false) goto L7;
        log("Creating ExtTelephonyService. If not started yet, start ...");
        addServiceCallback(r8);
        Intent r10 = new Intent();
        r10.setComponent(new ComponentName("com.qti.phone", "com.qti.phone.ExtTelephonyService"));
        boolean r11 = this.mContext.bindService(r10, this.mConnection, 1);
        log("bind Service result: " + r11);
        return r11;
    }

    public Token disable5g(int r8, Client r10) {
        if (isServiceConnected() == true) goto L11;
        Log.e(LOG_TAG, "service not connected!");
        return null;
    L11:
        return this.mExtTelephonyService.disable5g(r8, r10);
    L8:
        e = move-exception;
        Log.e(LOG_TAG, "disable5g, remote exception", e);
        return null;
    }

    public Token disableEndc(int r8, boolean r10, Client r11) {
        if (isServiceConnected() == true) goto L11;
        Log.e(LOG_TAG, "service not connected!");
        return null;
    L11:
        return this.mExtTelephonyService.disableEndc(r8, r10, r11);
    L8:
        e = move-exception;
        Log.e(LOG_TAG, "disableEndc, remote exception");
        e.printStackTrace();
        return null;
    }

    public void disconnectService() {
        disconnectService(null);
    }

    public Token enable5g(int r8, Client r10) {
        if (isServiceConnected() == true) goto L11;
        Log.e(LOG_TAG, "service not connected!");
        return null;
    L11:
        return this.mExtTelephonyService.enable5g(r8, r10);
    L8:
        e = move-exception;
        Log.e(LOG_TAG, "enable5g, remote exception", e);
        return null;
    }

    public Token enable5gOnly(int r8, Client r10) {
        if (isServiceConnected() == true) goto L11;
        Log.e(LOG_TAG, "service not connected!");
        return null;
    L11:
        return this.mExtTelephonyService.enable5gOnly(r8, r10);
    L8:
        e = move-exception;
        Log.e(LOG_TAG, "enable5gOnly, remote exception", e);
        return null;
    }

    public Token enableEndc(int r8, boolean r10, Client r11) {
        if (isServiceConnected() == true) goto L11;
        Log.e(LOG_TAG, "service not connected!");
        return null;
    L11:
        return this.mExtTelephonyService.enableEndc(r8, r10, r11);
    L8:
        e = move-exception;
        Log.e(LOG_TAG, "enableEndc, remote exception", e);
        return null;
    }

    @RequiresPermission("android.permission.READ_PRIVILEGED_PHONE_STATE")
    public boolean getAirplaneMode() {
        return this.mExtTelephonyService.getAirplaneMode();
    L5:
        throw new RemoteException("getAirplaneMode ended in remote exception");
    }

    public CellularRoamingPreference getCellularRoamingPreference(int r8) {
        if (isServiceConnected() == true) goto L11;
        Log.e(LOG_TAG, "getCellularRoamingPreference: service not connected!");
        return null;
    L11:
        return this.mExtTelephonyService.getCellularRoamingPreference(r8);
    L8:
        e = move-exception;
        Log.e(LOG_TAG, "getCellularRoamingPreference failed.", e);
        return null;
    }

    public CiwlanConfig getCiwlanConfig(int r8) {
        if (isServiceConnected() == true) goto L11;
        Log.e(LOG_TAG, "service not connected!");
        return null;
    L11:
        return this.mExtTelephonyService.getCiwlanConfig(r8);
    L8:
        e = move-exception;
        Log.e(LOG_TAG, "getCiwlanConfig ended in remote exception", e);
        return null;
    }

    public CiwlanConfig getCiwlanModeUserPreference(int r8) {
        if (isServiceConnected() == true) goto L11;
        Log.e(LOG_TAG, "service not connected!");
        return null;
    L11:
        return this.mExtTelephonyService.getCiwlanModeUserPreference(r8);
    L8:
        e = move-exception;
        Log.e(LOG_TAG, "getCiwlanModeUserPreference ended in remote exception", e);
        return null;
    }

    public int getCurrentPrimaryCardSlotId() {
        if (isServiceConnected() == true) goto L11;
        Log.e(LOG_TAG, "service not connected!");
        return -1;
    L11:
        return this.mExtTelephonyService.getCurrentPrimaryCardSlotId();
    L8:
        e = move-exception;
        Log.e(LOG_TAG, "getCurrentPrimaryCardSlotId, remote exception", e);
        return -1;
    }

    public QtiSimType[] getCurrentSimType() {
        if (isServiceConnected() == true) goto L11;
        Log.e(LOG_TAG, "getCurrentSimType, service not connected!");
        return null;
    L11:
        return this.mExtTelephonyService.getCurrentSimType();
    L6:
        e = move-exception;
        Log.e(LOG_TAG, "getCurrentSimType ended in remote exception", e);
        return null;
    }

    public Token getDdsSwitchCapability(int r8, Client r10) {
        if (isServiceConnected() == true) goto L11;
        Log.e(LOG_TAG, "service not connected!");
        return null;
    L11:
        return this.mExtTelephonyService.getDdsSwitchCapability(r8, r10);
    L8:
        e = move-exception;
        Log.e(LOG_TAG, "getDdsSwitchCapability, remote exception", e);
        return null;
    }

    public Token getDdsSwitchConfigCapability(Client r8) {
        if (isServiceConnected() == true) goto L11;
        Log.e(LOG_TAG, "service not connected!");
        return null;
    L11:
        return this.mExtTelephonyService.getDdsSwitchConfigCapability(r8);
    L8:
        e = move-exception;
        Log.e(LOG_TAG, "getDdsSwitchConfigCapability, remote exception", e);
        return null;
    }

    public Token getDiagInfo(int r8, int r10, Client r11) {
        if (isServiceConnected() == true) goto L11;
        Log.e(LOG_TAG, "service not connected!");
        return null;
    L11:
        return this.mExtTelephonyService.getDiagInfo(r8, r10, r11);
    L8:
        e = move-exception;
        Log.e(LOG_TAG, "getDiagInfo, remote exception");
        e.printStackTrace();
        return null;
    }

    public boolean getDualDataCapability() {
        if (isServiceConnected() == false) goto L12;
        return this.mExtTelephonyService.getDualDataCapability();
    L6:
        e = move-exception;
        Log.e(LOG_TAG, "getDualDataCapability Failed.", e);
        return false;
    L12:
        return false;
    }

    public void getFacilityLockForApp(int r10, String r11, String r12, int r13, String r14, boolean r15, Client r16) {
        this.mExtTelephonyService.getFacilityLockForApp(r10, r11, r12, r13, r14, r15, r16);     // Catch: RemoteException -> L4
        return;
    L5:
        throw new RemoteException("getFacilityLockForApp ended in remote exception");
    }

    public QtiImeiInfo[] getImeiInfo() {
        return this.mExtTelephonyService.getImeiInfo();
    L4:
        e = move-exception;
        Log.e(LOG_TAG, "getImeiInfo ended in remote exception", e);
        return null;
    }

    public Token getNetworkSelectionMode(int r8, Client r10) {
        if (isServiceConnected() == true) goto L11;
        Log.e(LOG_TAG, "service not connected!");
        return null;
    L11:
        return this.mExtTelephonyService.getNetworkSelectionMode(r8, r10);
    L8:
        e = move-exception;
        Log.e(LOG_TAG, "getNetworkSelectionMode, remote exception", e);
        return null;
    }

    public int getPrimaryCarrierSlotId() {
        if (isServiceConnected() == true) goto L11;
        Log.e(LOG_TAG, "service not connected!");
        return -1;
    L11:
        return this.mExtTelephonyService.getPrimaryCarrierSlotId();
    L8:
        e = move-exception;
        Log.e(LOG_TAG, "getPrimaryCarrierSlotId, remote exception", e);
        return -1;
    }

    public boolean getPropertyValueBool(String r8, boolean r10) {
        if (isServiceConnected() == true) goto L6;
        Log.e(LOG_TAG, "service not connected!");
        return r10;
    L6:
        log(b.c("getPropertyValueBool: property=", r8));
        return this.mExtTelephonyService.getPropertyValueBool(r8, r10);
    L9:
        e = move-exception;
        Log.e(LOG_TAG, "getPropertyValueBool, remote exception", e);
        return r10;
    }

    public int getPropertyValueInt(String r8, int r10) {
        if (isServiceConnected() == true) goto L6;
        Log.e(LOG_TAG, "service not connected!");
        return -1;
    L6:
        log(b.c("getPropertyValueInt: property=", r8));
        return this.mExtTelephonyService.getPropertyValueInt(r8, r10);
    L9:
        e = move-exception;
        Log.e(LOG_TAG, "getPropertyValueInt, remote exception", e);
        return -1;
    }

    public String getPropertyValueString(String r8, String r10) {
        if (isServiceConnected() == true) goto L6;
        Log.e(LOG_TAG, "service not connected!");
        return r10;
    L6:
        log(b.c("getPropertyValueString: property=", r8));
        return this.mExtTelephonyService.getPropertyValueString(r8, r10);
    L9:
        e = move-exception;
        Log.e(LOG_TAG, "getPropertyValueString, remote exception", e);
        return r10;
    }

    public Token getQosParameters(int r8, int r10, Client r11) {
        Log.d(LOG_TAG, "[" + r8 + "] getQosParameters, cid: " + r10);
        if (isServiceConnected() == true) goto L11;
        Log.e(LOG_TAG, "service not connected!");
        return null;
    L11:
        return this.mExtTelephonyService.getQosParameters(r8, r10, r11);
    L8:
        e = move-exception;
        Log.e(LOG_TAG, "getQosParameters ended in remote exception", e);
        return null;
    }

    public Token getQtiRadioCapability(int r8, Client r10) {
        if (isServiceConnected() == true) goto L7;
        Log.e(LOG_TAG, "service not connected!");
        return null;
    L7:
        return this.mExtTelephonyService.getQtiRadioCapability(r8, r10);
    }

    public Token getSecureModeStatus(Client r8) {
        if (isServiceConnected() == true) goto L11;
        Log.e(LOG_TAG, "service not connected!");
        return null;
    L11:
        return this.mExtTelephonyService.getSecureModeStatus(r8);
    L8:
        e = move-exception;
        Log.e(LOG_TAG, "getSecureModeStatus ended in remote exception", e);
        return null;
    }

    public QtiPersoUnlockStatus getSimPersoUnlockStatus(int r8) {
        if (isServiceConnected() == true) goto L11;
        Log.e(LOG_TAG, "service not connected!");
        return null;
    L11:
        return this.mExtTelephonyService.getSimPersoUnlockStatus(r8);
    L8:
        e = move-exception;
        Log.e(LOG_TAG, "Remote exception for getSimPersoUnlockStatus", e);
        return null;
    }

    public int[] getSimPinRetryTimes(int r8) {
        if (isServiceConnected() == true) goto L11;
        Log.e(LOG_TAG, "Service not connected!");
        return null;
    L11:
        return this.mExtTelephonyService.getSimPinRetryTimes(r8);
    L8:
        e = move-exception;
        Log.e(LOG_TAG, "getSimPinRetryTimes, remote exception", e);
        return null;
    }

    public QtiSimType[] getSupportedSimTypes() {
        if (isServiceConnected() == true) goto L11;
        Log.e(LOG_TAG, "service not connected!");
        return null;
    L11:
        return this.mExtTelephonyService.getSupportedSimTypes();
    L6:
        e = move-exception;
        Log.e(LOG_TAG, "getSupportedSimTypes ended in remote exception", e);
        return null;
    }

    public boolean isCiwlanAvailable(int r8) {
        if (isServiceConnected() == false) goto L12;
        return this.mExtTelephonyService.isCiwlanAvailable(r8);
    L6:
        e = move-exception;
        Log.e(LOG_TAG, "isCiwlanAvailable Failed.", e);
        return false;
    L12:
        return false;
    }

    public boolean isEpdgOverCellularDataSupported(int r8) {
        if (isServiceConnected() == true) goto L11;
        Log.e(LOG_TAG, "service not connected!");
        return false;
    L11:
        return this.mExtTelephonyService.isEpdgOverCellularDataSupported(r8);
    L8:
        e = move-exception;
        Log.e(LOG_TAG, "isEpdgOverCellularDataSupported, remote exception", e);
        return false;
    }

    public boolean isFeatureSupported(int r8) {
        if (isServiceConnected() == true) goto L11;
        Log.e(LOG_TAG, "service not connected!");
        return false;
    L11:
        return this.mExtTelephonyService.isFeatureSupported(r8);
    L8:
        e = move-exception;
        Log.e(LOG_TAG, "isFeatureSupported, remote exception", e);
        return false;
    }

    public boolean isPrimaryCarrierSlotId(int r8) {
        if (isServiceConnected() == true) goto L11;
        Log.e(LOG_TAG, "service not connected!");
        return false;
    L11:
        return this.mExtTelephonyService.isPrimaryCarrierSlotId(r8);
    L8:
        e = move-exception;
        Log.e(LOG_TAG, "isPrimaryCarrierSlotId, remote exception", e);
        return false;
    }

    public boolean isSMSPromptEnabled() {
        if (isServiceConnected() == true) goto L11;
        Log.e(LOG_TAG, "service not connected!");
        return false;
    L11:
        return this.mExtTelephonyService.isSMSPromptEnabled();
    L8:
        e = move-exception;
        Log.e(LOG_TAG, "isSMSPromptEnabled, remote exception", e);
        return false;
    }

    public boolean isServiceConnected() {
        return this.mServiceConnected.get();
    }

    public boolean isSmartDdsSwitchFeatureAvailable() {
        return this.mExtTelephonyService.isSmartDdsSwitchFeatureAvailable();
    L5:
        throw new RemoteException("isSmartDdsSwitchFeatureAvailable ended in remote exception");
    }

    public Token lockLteBand(int r8, int r10, Client r11) {
        if (isServiceConnected() == true) goto L11;
        Log.e(LOG_TAG, "service not connected!");
        return null;
    L11:
        return this.mExtTelephonyService.lockLteBand(r8, r10, r11);
    L8:
        e = move-exception;
        Log.e(LOG_TAG, "lockLteBand, remote exception");
        e.printStackTrace();
        return null;
    }

    public Token lockLteCell(int r8, int r10, int r11, Client r12) {
        if (isServiceConnected() == true) goto L11;
        Log.e(LOG_TAG, "service not connected!");
        return null;
    L11:
        return this.mExtTelephonyService.lockLteCell(r8, r10, r11, r12);
    L8:
        e = move-exception;
        Log.e(LOG_TAG, "lockLteCell, remote exception");
        e.printStackTrace();
        return null;
    }

    public Token lockNrBand(int r8, int r10, Client r11) {
        if (isServiceConnected() == true) goto L11;
        Log.e(LOG_TAG, "service not connected!");
        return null;
    L11:
        return this.mExtTelephonyService.lockNrBand(r8, r10, r11);
    L8:
        e = move-exception;
        Log.e(LOG_TAG, "lockNrBand, remote exception");
        e.printStackTrace();
        return null;
    }

    public Token lockNrCell(int r11, int r12, int r13, int r14, int r15, Client r16) {
        if (isServiceConnected() == true) goto L12;
        Log.e(LOG_TAG, "service not connected!");
        return null;
    L12:
        return this.mExtTelephonyService.lockNrCell(r11, r12, r13, r14, r15, r16);
    L9:
        e = move-exception;
        Log.e(LOG_TAG, "lockNrCell, remote exception");
        e.printStackTrace();
        return null;
    }

    public boolean performIncrementalScan(int r8) {
        if (isServiceConnected() == true) goto L11;
        Log.e(LOG_TAG, "service not connected!");
        return false;
    L11:
        return this.mExtTelephonyService.performIncrementalScan(r8);
    L8:
        e = move-exception;
        Log.e(LOG_TAG, "performIncrementalScan, remote exception", e);
        return false;
    }

    public Token query5gConfigInfo(int r8, Client r10) {
        if (isServiceConnected() == true) goto L11;
        Log.e(LOG_TAG, "service not connected!");
        return null;
    L11:
        return this.mExtTelephonyService.query5gConfigInfo(r8, r10);
    L8:
        e = move-exception;
        Log.e(LOG_TAG, "query5gConfigInfo, remote exception", e);
        return null;
    }

    public Token query5gStatus(int r8, Client r10) {
        if (isServiceConnected() == true) goto L11;
        Log.e(LOG_TAG, "service not connected!");
        return null;
    L11:
        return this.mExtTelephonyService.query5gStatus(r8, r10);
    L8:
        e = move-exception;
        Log.e(LOG_TAG, "query5gStatus, remote exception", e);
        return null;
    }

    public void queryCallForwardStatus(int r8, int r10, int r11, String r12, boolean r13, Client r14) {
        this.mExtTelephonyService.queryCallForwardStatus(r8, r10, r11, r12, r13, r14);     // Catch: RemoteException -> L4
        return;
    L5:
        throw new RemoteException("queryCallForwardStatus ended in remote exception");
    }

    public Token queryEndcStatus(int r8, Client r10) {
        if (isServiceConnected() == true) goto L11;
        Log.e(LOG_TAG, "service not connected!");
        return null;
    L11:
        return this.mExtTelephonyService.queryEndcStatus(r8, r10);
    L8:
        e = move-exception;
        Log.e(LOG_TAG, "queryEndcStatus, remote exception", e);
        return null;
    }

    public Token queryNrBearerAllocation(int r8, Client r10) {
        if (isServiceConnected() == true) goto L11;
        Log.e(LOG_TAG, "service not connected!");
        return null;
    L11:
        return this.mExtTelephonyService.queryNrBearerAllocation(r8, r10);
    L8:
        e = move-exception;
        Log.e(LOG_TAG, "queryNrBearerAllocation, remote exception", e);
        return null;
    }

    public Token queryNrConfig(int r8, Client r10) {
        if (isServiceConnected() == true) goto L11;
        Log.e(LOG_TAG, "service not connected!");
        return null;
    L11:
        return this.mExtTelephonyService.queryNrConfig(r8, r10);
    L8:
        e = move-exception;
        Log.e(LOG_TAG, "queryNrConfig, remote exception", e);
        return null;
    }

    public Token queryNrDcParam(int r8, Client r10) {
        if (isServiceConnected() == true) goto L11;
        Log.e(LOG_TAG, "service not connected!");
        return null;
    L11:
        return this.mExtTelephonyService.queryNrDcParam(r8, r10);
    L8:
        e = move-exception;
        Log.e(LOG_TAG, "queryNrDcParam, remote exception", e);
        return null;
    }

    public Token queryNrIcon(int r8, Client r10) {
        if (isServiceConnected() == true) goto L11;
        Log.e(LOG_TAG, "queryNrIcon: service not connected!");
        return null;
    L11:
        return this.mExtTelephonyService.queryNrIcon(r8, r10);
    L8:
        e = move-exception;
        Log.e(LOG_TAG, "queryNrIcon failed.", e);
        return null;
    }

    public Token queryNrIconType(int r8, Client r10) {
        if (isServiceConnected() == true) goto L11;
        Log.e(LOG_TAG, "service not connected!");
        return null;
    L11:
        return this.mExtTelephonyService.queryNrIconType(r8, r10);
    L8:
        e = move-exception;
        Log.e(LOG_TAG, "queryNrIconType, remote exception", e);
        return null;
    }

    public Token queryNrSignalStrength(int r8, Client r10) {
        if (isServiceConnected() == true) goto L11;
        Log.e(LOG_TAG, "service not connected!");
        return null;
    L11:
        return this.mExtTelephonyService.queryNrSignalStrength(r8, r10);
    L8:
        e = move-exception;
        Log.e(LOG_TAG, "queryNrSignalStrength, remote exception", e);
        return null;
    }

    public Token queryUpperLayerIndInfo(int r8, Client r10) {
        if (isServiceConnected() == true) goto L11;
        Log.e(LOG_TAG, "service not connected!");
        return null;
    L11:
        return this.mExtTelephonyService.queryUpperLayerIndInfo(r8, r10);
    L8:
        e = move-exception;
        Log.e(LOG_TAG, "queryUpperLayerIndInfo, remote exception", e);
        return null;
    }

    public Client registerCallback(String r8, IExtPhoneCallback r10) {
        if (isServiceConnected() == true) goto L11;
        Log.e(LOG_TAG, "service not connected!");
        return null;
    L11:
        return this.mExtTelephonyService.registerCallback(r8, r10);
    L8:
        e = move-exception;
        Log.e(LOG_TAG, "registerCallback, remote exception", e);
        return null;
    }

    public Client registerCallbackWithEvents(String r8, ExtPhoneCallbackListener r10, int[] r11) {
        if (r10 != null) goto L8;
        String r12 = "Callback is null";
    L5:
        Log.e(LOG_TAG, r12);
        return null;
    L8:
        if (isServiceConnected() == true) goto L10;
        r12 = "service not connected!";
        goto L5
    L10:
        r10.setup();
        return this.mExtTelephonyService.registerCallbackWithEvents(r8, r10.mCallback, r11);
    L13:
        e = move-exception;
        Log.e(LOG_TAG, "registerCallbackWithEvents, remote exception", e);
        return null;
    }

    public Client registerQtiRadioConfigCallback(String r8, IExtPhoneCallback r10) {
        if (isServiceConnected() == true) goto L11;
        Log.e(LOG_TAG, "Service not connected!");
        return null;
    L11:
        return this.mExtTelephonyService.registerQtiRadioConfigCallback(r8, r10);
    L8:
        e = move-exception;
        Log.e(LOG_TAG, "registerQtiRadioConfigCallback, remote exception", e);
        return null;
    }

    public Token sendCdmaSms(int r8, byte[] r10, boolean r11, Client r12) {
        if (isServiceConnected() == true) goto L11;
        Log.e(LOG_TAG, "service not connected!");
        return null;
    L11:
        return this.mExtTelephonyService.sendCdmaSms(r8, r10, r11, r12);
    L8:
        e = move-exception;
        Log.e(LOG_TAG, "sendCdmaSms, remote exception", e);
        return null;
    }

    public Token sendUserPreferenceConfigForDataDuringVoiceCall(boolean[] r8, Client r10) {
        if (isServiceConnected() == true) goto L11;
        Log.e(LOG_TAG, "service not connected!");
        return null;
    L11:
        return this.mExtTelephonyService.sendUserPreferenceConfigForDataDuringVoiceCall(r8, r10);
    L8:
        e = move-exception;
        Log.e(LOG_TAG, "sendUserPreferenceConfigForDataDuringVoiceCall, remote exception", e);
        return null;
    }

    public Token sendUserPreferenceForDataDuringVoiceCall(int r8, boolean r10, Client r11) {
        if (isServiceConnected() == true) goto L11;
        Log.e(LOG_TAG, "service not connected!");
        return null;
    L11:
        return this.mExtTelephonyService.sendUserPreferenceForDataDuringVoiceCall(r8, r10, r11);
    L8:
        e = move-exception;
        Log.e(LOG_TAG, "sendUserPreferenceForDataDuringVoiceCall, remote exception", e);
        return null;
    }

    @RequiresPermission("android.permission.MODIFY_PHONE_STATE")
    public boolean setAirplaneMode(boolean r8) {
        return this.mExtTelephonyService.setAirplaneMode(r8);
    L5:
        throw new RemoteException("setAirplaneMode ended in remote exception");
    }

    public Token setCarrierInfoForImsiEncryption(int r8, ImsiEncryptionInfo r10, Client r11) {
        if (isServiceConnected() == true) goto L11;
        Log.e(LOG_TAG, "service not connected!");
        return null;
    L11:
        return this.mExtTelephonyService.setCarrierInfoForImsiEncryption(r8, r10, r11);
    L8:
        e = move-exception;
        Log.e(LOG_TAG, "setCarrierInfoForImsiEncryption, remote exception", e);
        return null;
    }

    public Token setCellularRoamingPreference(Client r8, int r10, CellularRoamingPreference r11) {
        if (isServiceConnected() == true) goto L11;
        Log.e(LOG_TAG, "setCellularRoamingPreference: service not connected!");
        return null;
    L11:
        return this.mExtTelephonyService.setCellularRoamingPreference(r8, r10, r11);
    L8:
        e = move-exception;
        Log.e(LOG_TAG, "setCellularRoamingPreference failed.", e);
        return null;
    }

    public Token setCiwlanModeUserPreference(int r8, Client r10, CiwlanConfig r11) {
        if (isServiceConnected() == true) goto L11;
        Log.e(LOG_TAG, "service not connected!");
        return null;
    L11:
        return this.mExtTelephonyService.setCiwlanModeUserPreference(r8, r10, r11);
    L8:
        e = move-exception;
        Log.e(LOG_TAG, "setCiwlanModeUserPreference ended in remote exception", e);
        return null;
    }

    public Token setDualDataUserPreference(Client r8, boolean r10) {
        if (isServiceConnected() == true) goto L11;
        Log.e(LOG_TAG, "service not connected!");
        return null;
    L11:
        return this.mExtTelephonyService.setDualDataUserPreference(r8, r10);
    L8:
        e = move-exception;
        Log.e(LOG_TAG, "setDualDataUserPreference ended in remote exception", e);
        return null;
    }

    public Token setMsimPreference(Client r8, MsimPreference r10) {
        if (isServiceConnected() == true) goto L11;
        Log.e(LOG_TAG, "service not connected!");
        return null;
    L11:
        return this.mExtTelephonyService.setMsimPreference(r8, r10);
    L8:
        e = move-exception;
        Log.e(LOG_TAG, "setMsimPreference ended in remote exception", e);
        return null;
    }

    public Token setNetworkSelectionModeAutomatic(int r8, int r10, Client r11) {
        if (isServiceConnected() == true) goto L11;
        Log.e(LOG_TAG, "service not connected!");
        return null;
    L11:
        return this.mExtTelephonyService.setNetworkSelectionModeAutomatic(r8, r10, r11);
    L8:
        e = move-exception;
        Log.e(LOG_TAG, "setNetworkSelectionModeAutomatic, remote exception", e);
        return null;
    }

    public Token setNetworkSelectionModeManual(int r8, QtiSetNetworkSelectionMode r10, Client r11) {
        if (isServiceConnected() == true) goto L11;
        Log.e(LOG_TAG, "service not connected!");
        return null;
    L11:
        return this.mExtTelephonyService.setNetworkSelectionModeManual(r8, r10, r11);
    L8:
        e = move-exception;
        Log.e(LOG_TAG, "startNetworkScan, remote exception", e);
        return null;
    }

    public Token setNrConfig(int r8, NrConfig r10, Client r11) {
        if (isServiceConnected() == true) goto L11;
        Log.e(LOG_TAG, "service not connected!");
        return null;
    L11:
        return this.mExtTelephonyService.setNrConfig(r8, r10, r11);
    L8:
        e = move-exception;
        Log.e(LOG_TAG, "setNrConfig, remote exception", e);
        return null;
    }

    public void setPrimaryCardOnSlot(int r8) {
        if (isServiceConnected() == true) goto L11;
        Log.e(LOG_TAG, "service not connected!");
        return;
    L11:
        this.mExtTelephonyService.setPrimaryCardOnSlot(r8);     // Catch: RemoteException -> L8
        return;
    L8:
        e = move-exception;
        Log.e(LOG_TAG, "setPrimaryCardOnSlot, remote exception", e);
    }

    public void setSMSPromptEnabled(boolean r8) {
        if (isServiceConnected() == true) goto L11;
        Log.e(LOG_TAG, "service not connected!");
        return;
    L11:
        this.mExtTelephonyService.setSMSPromptEnabled(r8);     // Catch: RemoteException -> L8
        return;
    L8:
        e = move-exception;
        Log.e(LOG_TAG, "setSMSPromptEnabled, remote exception", e);
    }

    public Token setSimType(Client r8, QtiSimType[] r10) {
        if (isServiceConnected() == true) goto L11;
        Log.e(LOG_TAG, "setSimType, service not connected!");
        return null;
    L11:
        return this.mExtTelephonyService.setSimType(r8, r10);
    L6:
        e = move-exception;
        Log.e(LOG_TAG, "setSimType ended in remote exception", e);
        return null;
    }

    public void setSmartDdsSwitchToggle(boolean r8, Client r10) {
        this.mExtTelephonyService.setSmartDdsSwitchToggle(r8, r10);     // Catch: RemoteException -> L4
        return;
    L5:
        throw new RemoteException("setSmartDdsSwitchToggle ended in remote exception");
    }

    public Token startNetworkScan(int r8, NetworkScanRequest r10, Client r11) {
        if (isServiceConnected() == true) goto L11;
        Log.e(LOG_TAG, "service not connected!");
        return null;
    L11:
        return this.mExtTelephonyService.startNetworkScan(r8, r10, r11);
    L8:
        e = move-exception;
        Log.e(LOG_TAG, "startNetworkScan, remote exception", e);
        return null;
    }

    public Token stopNetworkScan(int r8, Client r10) {
        if (isServiceConnected() == true) goto L11;
        Log.e(LOG_TAG, "service not connected!");
        return null;
    L11:
        return this.mExtTelephonyService.stopNetworkScan(r8, r10);
    L8:
        e = move-exception;
        Log.e(LOG_TAG, "stopNetworkScan, remote exception", e);
        return null;
    }

    public void supplyIccDepersonalization(String r8, String r10, IDepersoResCallback r11, int r12) {
        if (isServiceConnected() == true) goto L11;
        Log.e(LOG_TAG, "service not connected!");
        return;
    L11:
        this.mExtTelephonyService.supplyIccDepersonalization(r8, r10, r11, r12);     // Catch: RemoteException -> L8
        return;
    L8:
        e = move-exception;
        Log.e(LOG_TAG, "supplyIccDepersonalization, remote exception", e);
    }

    @RequiresPermission("android.permission.MODIFY_PHONE_STATE")
    public boolean toggleSimPinLock(int r8, boolean r10, String r11) {
        return this.mExtTelephonyService.toggleSimPinLock(r8, r10, r11);
    L5:
        throw new RemoteException("toggleSimPinLock ended in remote exception");
    }

    public void unRegisterCallback(IExtPhoneCallback r8) {
        if (isServiceConnected() == true) goto L11;
        Log.e(LOG_TAG, "service not connected!");
        return;
    L11:
        this.mExtTelephonyService.unRegisterCallback(r8);     // Catch: RemoteException -> L8
        return;
    L8:
        e = move-exception;
        Log.e(LOG_TAG, "unRegisterCallback, remote exception ", e);
    }

    public void unregisterCallback(ExtPhoneCallbackListener r8) {
        if (r8 != null) goto L5;
        Log.e(LOG_TAG, "Callback is null");
        return;
    L5:
        r8.cleanup();
        unRegisterCallback(r8.mCallback);
    }

    public void unregisterQtiRadioConfigCallback(IExtPhoneCallback r8) {
        if (isServiceConnected() == true) goto L11;
        Log.e(LOG_TAG, "Service not connected!");
        return;
    L11:
        this.mExtTelephonyService.unregisterQtiRadioConfigCallback(r8);     // Catch: RemoteException -> L8
        return;
    L8:
        e = move-exception;
        Log.e(LOG_TAG, "unregisterQtiRadioConfigCallback, remote exception", e);
    }

    @RequiresPermission("android.permission.READ_PRIVILEGED_PHONE_STATE")
    public boolean verifySimPin(int r8, String r10) {
        return this.mExtTelephonyService.verifySimPin(r8, r10);
    L5:
        throw new RemoteException("verifySimPin ended in remote exception");
    }

    @RequiresPermission("android.permission.MODIFY_PHONE_STATE")
    public boolean verifySimPukChangePin(int r8, String r10, String r11) {
        return this.mExtTelephonyService.verifySimPukChangePin(r8, r10, r11);
    L5:
        throw new RemoteException("verifySimPukChangePin ended in remote exception");
    }

    public void disconnectService(ServiceCallback r8) {
        if (r8 == null) goto L10;
        if (isServiceConnected() == true) goto L7;
        r8.onDisconnected();
    L7:
        if (this.mServiceCbs.contains(r8) == false) goto L10;
        this.mServiceCbs.remove(r8);
    L10:
        if (isServiceConnected() == true) goto L12;
        return;
    L12:
        if (this.mServiceCbs.isEmpty() == false) goto L16;
        this.mContext.unbindService(this.mConnection);
        log("Set ServiceConnected to false");
        this.mServiceConnected.set(false);
        return;
    }
}
