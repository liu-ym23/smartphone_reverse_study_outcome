package com.obric.cae.smartNfc;

import android.aimedia.a;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import com.obric.cae.libs.nfc.ICaeNfcCloudConfigCallback;
import com.obric.cae.libs.nfc.ICaeNfcDndConfigCallback;
import com.obric.cae.libs.nfc.ICaeNfcEventManager;
import com.obric.cae.libs.nfc.ICaeNfcForceFwEventCallback;
import com.obric.cae.libs.nfc.ICaeNfcPaymentChangeCallback;
import com.obric.cae.libs.nfc.ICaeNfcTransitEventCallback;
import com.obric.cae.libs.nfc.ICaeNfcVendorNciEventCallback;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartNfc.event.CloudConfigEvent;
import com.obric.cae.smartNfc.event.DndConfigEvent;
import com.obric.cae.smartNfc.event.ForceFwEvent;
import com.obric.cae.smartNfc.event.PaymentChangeEvent;
import com.obric.cae.smartNfc.event.TransitEvent;
import com.obric.cae.smartNfc.event.VendorNciEvent;

/* JADX INFO: loaded from: classes2.dex */
public class CaeNfcEventManagerService extends ICaeNfcEventManager.Stub {
    private static final String CAE_NFC_ACCESS_PERM_ERROR = "NFC_ACCESS permission required";
    private static final String TAG = "NFC:CaeNfcEventManagerService";
    private final CloudConfigEvent mCloudConfigEvent;
    private final Context mContext;
    private final DndConfigEvent mDndConfigEvent;
    private final ForceFwEvent mForceFwEvent;
    private volatile NfcStateListener mNfcStateListener;
    private final BroadcastReceiver mNfcStateReceiver;
    private boolean mNfcStateReceiverRegistered;
    private final PaymentChangeEvent mPaymentChangeEvent;
    private final TransitEvent mTransitEvent;
    private final VendorNciEvent mVendorNciEvent;

    public interface NfcStateListener {
        void onNfcStateChanged(int r8);
    }

    public CaeNfcEventManagerService(Context r8) {
        this.mNfcStateReceiver = new AnonymousClass1(this);
        this.mContext = r8;
        this.mCloudConfigEvent = new CloudConfigEvent();
        this.mDndConfigEvent = new DndConfigEvent(r8);
        this.mForceFwEvent = new ForceFwEvent(r8);
        this.mPaymentChangeEvent = new PaymentChangeEvent(r8);
        this.mTransitEvent = new TransitEvent(r8);
        this.mVendorNciEvent = new VendorNciEvent(r8);
    }

    public static /* synthetic */ NfcStateListener access$000(CaeNfcEventManagerService r8) {
        return r8.mNfcStateListener;
    }

    private void enforceAccessPermission() {
        this.mContext.enforceCallingOrSelfPermission(NfcConstants.CAE_NFC_ACCESS_PERM, CAE_NFC_ACCESS_PERM_ERROR);     // Catch: SecurityException -> L4
        return;
    L4:
        e = move-exception;
        CaeLog.e(TAG, "enforceAccessPermission: " + e);
        throw e;
    }

    private void registerNfcStateReceiver() {
        if (this.mNfcStateReceiverRegistered == false) goto L5;
        return;
    L5:
        IntentFilter r8 = new IntentFilter("android.nfc.action.ADAPTER_STATE_CHANGED");
        this.mContext.registerReceiver(this.mNfcStateReceiver, r8);
        this.mNfcStateReceiverRegistered = true;
    }

    private void unregisterNfcStateReceiver() {
        if (this.mNfcStateReceiverRegistered == true) goto L11;
        return;
    L11:
        this.mContext.unregisterReceiver(this.mNfcStateReceiver);     // Catch: Exception -> L7
    L9:
        this.mNfcStateReceiverRegistered = false;
        return;
    L7:
        e = move-exception;
        a.q("unregisterNfcStateReceiver: ", e, TAG);
        goto L9
    }

    public void cleanup() {
        this.mCloudConfigEvent.cleanup();
        this.mDndConfigEvent.cleanup();
        this.mForceFwEvent.cleanup();
        this.mPaymentChangeEvent.cleanup();
        this.mTransitEvent.cleanup();
        this.mVendorNciEvent.cleanup();
        unregisterNfcStateReceiver();
    }

    public PaymentChangeEvent getPaymentChangeEvent() {
        return this.mPaymentChangeEvent;
    }

    @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
    public int getTransitEventAllowedAidTypes() {
        enforceAccessPermission();
        return this.mTransitEvent.getAllowedAidTypes();
    }

    @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
    public int getTransitEventSource() {
        enforceAccessPermission();
        return this.mTransitEvent.getEventSource();
    }

    public void init() {
        this.mCloudConfigEvent.init();
        this.mDndConfigEvent.init();
        this.mForceFwEvent.init();
        this.mPaymentChangeEvent.init();
        this.mTransitEvent.init();
        this.mVendorNciEvent.init();
        registerNfcStateReceiver();
    }

    @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
    public boolean isTransitEventFilterEnabled() {
        enforceAccessPermission();
        return this.mTransitEvent.isPreFilterEnabled();
    }

    public void notifyCloudConfigUpdate(Bundle r8) {
        this.mDndConfigEvent.handleCloudConfigUpdate(r8);
        this.mCloudConfigEvent.notifyCloudConfigUpdate(r8);
    }

    @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
    public void notifyTeaEvent(String r8, Bundle r10) {
        enforceAccessPermission();
        NfcTeaReporter.report(r8, r10);
    }

    @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
    public void notifyTransitEvent(Bundle r8) {
        enforceAccessPermission();
        this.mTransitEvent.notifyTransitEvent(r8, 2);
    }

    @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
    public void registerCloudConfigCallback(ICaeNfcCloudConfigCallback r8) {
        enforceAccessPermission();
        this.mCloudConfigEvent.registerCallback(r8);
    }

    @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
    public void registerDndConfigCallback(ICaeNfcDndConfigCallback r8) {
        enforceAccessPermission();
        this.mDndConfigEvent.registerCallback(r8);
    }

    @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
    public void registerForceFwEventCallback(ICaeNfcForceFwEventCallback r8) {
        enforceAccessPermission();
        this.mForceFwEvent.registerCallback(r8);
    }

    @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
    public void registerPaymentChangeCallback(ICaeNfcPaymentChangeCallback r8) {
        enforceAccessPermission();
        this.mPaymentChangeEvent.registerCallback(r8);
    }

    @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
    public void registerTransitEventCallback(ICaeNfcTransitEventCallback r8) {
        enforceAccessPermission();
        this.mTransitEvent.registerCallback(r8);
    }

    @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
    public void registerVendorNciEventCallback(ICaeNfcVendorNciEventCallback r8) {
        enforceAccessPermission();
        this.mVendorNciEvent.registerCallback(r8);
    }

    public void setNfcStateListener(NfcStateListener r8) {
        this.mNfcStateListener = r8;
    }

    @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
    public boolean setTransitEventAllowedAidTypes(int r8) {
        enforceAccessPermission();
        return this.mTransitEvent.setAllowedAidTypes(r8);
    }

    @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
    public boolean setTransitEventFilterEnabled(boolean r8) {
        enforceAccessPermission();
        this.mTransitEvent.setPreFilterEnabled(r8);
        return true;
    }

    @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
    public boolean setTransitEventSource(int r8) {
        enforceAccessPermission();
        return this.mTransitEvent.setEventSource(r8);
    }

    @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
    public void unregisterCloudConfigCallback(ICaeNfcCloudConfigCallback r8) {
        enforceAccessPermission();
        this.mCloudConfigEvent.unregisterCallback(r8);
    }

    @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
    public void unregisterDndConfigCallback(ICaeNfcDndConfigCallback r8) {
        enforceAccessPermission();
        this.mDndConfigEvent.unregisterCallback(r8);
    }

    @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
    public void unregisterForceFwEventCallback(ICaeNfcForceFwEventCallback r8) {
        enforceAccessPermission();
        this.mForceFwEvent.unregisterCallback(r8);
    }

    @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
    public void unregisterPaymentChangeCallback(ICaeNfcPaymentChangeCallback r8) {
        enforceAccessPermission();
        this.mPaymentChangeEvent.unregisterCallback(r8);
    }

    @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
    public void unregisterTransitEventCallback(ICaeNfcTransitEventCallback r8) {
        enforceAccessPermission();
        this.mTransitEvent.unregisterCallback(r8);
    }

    @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
    public void unregisterVendorNciEventCallback(ICaeNfcVendorNciEventCallback r8) {
        enforceAccessPermission();
        this.mVendorNciEvent.unregisterCallback(r8);
    }
}
