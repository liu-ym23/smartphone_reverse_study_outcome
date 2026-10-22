package com.obric.cae.smartNfc.event;

import android.aimedia.a;
import android.content.Context;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.os.RemoteCallbackList;
import com.obric.cae.libs.nfc.CaeNfcConstants;
import com.obric.cae.libs.nfc.ICaeNfcVendorNciEventCallback;
import com.obric.cae.log.CaeLog;
import v0.d;

/* JADX INFO: loaded from: classes2.dex */
public class VendorNciEvent implements EventComponent {
    private static final String TAG = "NFC:VendorNciEvent";
    private NfcAdapter.NfcVendorNciCallback mCallback;
    private final RemoteCallbackList<ICaeNfcVendorNciEventCallback> mCallbacks;
    private final Context mContext;
    private NfcAdapter mNfcAdapter;

    public VendorNciEvent(Context r8) {
        this.mCallbacks = new RemoteCallbackList();
        this.mContext = r8;
    }

    public static /* synthetic */ void access$000(VendorNciEvent r8, int r10, int r11, byte[] r12, int r13) {
        r8.handleVendorNciEvent(r10, r11, r12, r13);
    }

    private NfcAdapter getDefaultAdapterSafely() {
        return NfcAdapter.getDefaultAdapter(this.mContext);
    L4:
        e = move-exception;
        CaeLog.e(TAG, "getDefaultAdapterSafely: " + e);
        return null;
    }

    private void handleVendorNciEvent(int r8, int r10, byte[] r11, int r12) {
        Bundle r13 = new Bundle();
        r13.putInt(CaeNfcConstants.CAE_NFC_VENDOR_GID, r8);
        r13.putInt(CaeNfcConstants.CAE_NFC_VENDOR_OID, r10);
        r13.putByteArray(CaeNfcConstants.CAE_NFC_VENDOR_PAYLOAD, r11);
        r13.putInt(CaeNfcConstants.CAE_NFC_VENDOR_EVENT_TYPE, r12);
        notifyVendorNciEvent(r13);
    }

    private void notifyVendorNciEvent(Bundle r8) {
        int r10 = this.mCallbacks.beginBroadcast();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L9;
        ((ICaeNfcVendorNciEventCallback) this.mCallbacks.getBroadcastItem(r11)).onVendorNciEvent(r8);     // Catch: Exception -> L6
    L8:
        r11 = r11 + 1;
    L6:
        e = move-exception;
        a.q("notifyVendorNciEvent error: ", e, TAG);
        goto L8
    L9:
        this.mCallbacks.finishBroadcast();
    }

    private void registerCallbackInternal() {
        if (this.mCallback == null) goto L5;
        return;
    L5:
        NfcAdapter r8 = getDefaultAdapterSafely();
        this.mNfcAdapter = r8;
        if (r8 != null) goto L9;
        CaeLog.e(TAG, "registerCallbackInternal: NfcAdapter is null");
        return;
    L9:
        NfcAdapter.NfcVendorNciCallback r10 = new AnonymousClass1(this);
        this.mCallback = r10;
        this.mNfcAdapter.registerNfcVendorNciCallback(new d(5), r10);     // Catch: RuntimeException -> L12
        return;
    L12:
        e = move-exception;
        CaeLog.e(TAG, "registerCallbackInternal: " + e);
        this.mCallback = null;
    }

    private void unregisterCallbackInternal() {
        NfcAdapter r8 = this.mNfcAdapter;
        if (r8 == null) goto L15;
        NfcAdapter.NfcVendorNciCallback r10 = this.mCallback;
        if (r10 == null) goto L16;
        r8.unregisterNfcVendorNciCallback(r10);     // Catch: RuntimeException -> L9
    L11:
        this.mCallback = null;
        return;
    L9:
        e = move-exception;
        CaeLog.e(TAG, "unregisterCallbackInternal: " + e);
        goto L11
    L16:
        return;
    }

    @Override // com.obric.cae.smartNfc.event.EventComponent
    public void cleanup() {
        unregisterCallbackInternal();
        this.mCallbacks.kill();
    }

    @Override // com.obric.cae.smartNfc.event.EventComponent
    public void init() {
        registerCallbackInternal();
    }

    public void registerCallback(ICaeNfcVendorNciEventCallback r8) {
        if (r8 != null) goto L5;
        CaeLog.e(TAG, "registerCallback: callback is null");
        return;
    L5:
        this.mCallbacks.register(r8);
        if (this.mCallback != null) goto L9;
        registerCallbackInternal();
        return;
    }

    public void unregisterCallback(ICaeNfcVendorNciEventCallback r8) {
        if (r8 != null) goto L5;
        CaeLog.e(TAG, "unregisterCallback: callback is null");
        return;
    L5:
        this.mCallbacks.unregister(r8);
    }
}
