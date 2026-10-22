package com.obric.cae.smartNfc.event;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.RemoteCallbackList;
import androidx.activity.d;
import com.obric.cae.libs.nfc.CaeNfcConstants;
import com.obric.cae.libs.nfc.ICaeNfcForceFwEventCallback;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartNfc.NfcConstants;

/* JADX INFO: loaded from: classes2.dex */
public class ForceFwEvent implements EventComponent {
    private static final String TAG = "NFC:ForceFwEvent";
    private Handler mCallbackHandler;
    private HandlerThread mCallbackThread;
    private final RemoteCallbackList<ICaeNfcForceFwEventCallback> mCallbacks;
    private final Context mContext;
    private BroadcastReceiver mReceiver;

    public ForceFwEvent(Context r8) {
        this.mCallbacks = new RemoteCallbackList();
        this.mContext = r8;
    }

    public static /* synthetic */ void a(ForceFwEvent r8) {
        r8.dispatchForceFwDownload();
    }

    public static /* synthetic */ boolean access$000(ForceFwEvent r8, Intent r10) {
        return r8.isTrustedSender(r10);
    }

    public static /* synthetic */ void access$100(ForceFwEvent r8) {
        r8.notifyForceFwDownload();
    }

    private void dispatchForceFwDownload() {
        int r8 = this.mCallbacks.beginBroadcast();
        int r10 = 0;
    L3:
        if (r10 >= r8) goto L13;
        ((ICaeNfcForceFwEventCallback) this.mCallbacks.getBroadcastItem(r10)).onForceFwDownload();     // Catch: Throwable -> L6 Exception -> L8
    L10:
        r10 = r10 + 1;
    L6:
        th = move-exception;
        this.mCallbacks.finishBroadcast();
        throw th;
    L8:
        e = move-exception;
        CaeLog.e(TAG, "notifyForceFwDownload error: " + e);     // Catch: Throwable -> L6
        goto L10
    L13:
        this.mCallbacks.finishBroadcast();
    }

    private static boolean isSystemApp(PackageManager r8, String r10) {
        if ((r8.getApplicationInfo(r10, 0).flags & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    L12:
        return false;
    }

    private boolean isTrustedSender(Intent r8) {
        PackageManager r10 = this.mContext.getPackageManager();
        String[] r11 = r10.getPackagesForUid(Binder.getCallingUid());
        if (r11 != null) goto L5;
        return false;
    L5:
        int r12 = r11.length;
        int r13 = 0;
    L6:
        if (r13 >= r12) goto L12;
        if (isSystemApp(r10, r11[r13]) == true) goto L9;
        r13 = r13 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    private void notifyForceFwDownload() {
        Handler r8 = this.mCallbackHandler;
        if (r8 != null) goto L5;
    L6:
        CaeLog.e(TAG, "notifyForceFwDownload: callback handler unavailable");
        return;
    L5:
        if (r8.post(new d(this, 26)) == false) goto L6;
    }

    private void registerReceiver() {
        if (this.mReceiver == null) goto L5;
        return;
    L5:
        this.mReceiver = new AnonymousClass1(this);
        IntentFilter r8 = new IntentFilter(CaeNfcConstants.ACTION_FORCE_FW_DOWNLOAD);
        this.mContext.registerReceiver(this.mReceiver, r8, NfcConstants.CAE_NFC_ACCESS_PERM, null, 4);
    }

    private void startCallbackThread() {
        if (this.mCallbackThread == null) goto L5;
        return;
    L5:
        HandlerThread r8 = new HandlerThread("CaeNfcForceFwEvent");
        this.mCallbackThread = r8;
        r8.start();
        this.mCallbackHandler = new Handler(this.mCallbackThread.getLooper());
    }

    private void stopCallbackThread() {
        HandlerThread r8 = this.mCallbackThread;
        Handler r10 = this.mCallbackHandler;
        this.mCallbackThread = null;
        this.mCallbackHandler = null;
        if (r10 == null) goto L5;
        r10.removeCallbacksAndMessages(null);
    L5:
        if (r8 == null) goto L8;
        r8.quitSafely();
        return;
    }

    private void unregisterReceiver() {
        BroadcastReceiver r8 = this.mReceiver;
        if (r8 != null) goto L5;
        return;
    L5:
        this.mContext.unregisterReceiver(r8);
        this.mReceiver = null;
    }

    @Override // com.obric.cae.smartNfc.event.EventComponent
    public void cleanup() {
        unregisterReceiver();
        stopCallbackThread();
        this.mCallbacks.kill();
    }

    @Override // com.obric.cae.smartNfc.event.EventComponent
    public void init() {
        startCallbackThread();
        registerReceiver();
    }

    public void registerCallback(ICaeNfcForceFwEventCallback r8) {
        if (r8 != null) goto L5;
        CaeLog.e(TAG, "registerCallback: callback is null");
        return;
    L5:
        this.mCallbacks.register(r8);
    }

    public void unregisterCallback(ICaeNfcForceFwEventCallback r8) {
        if (r8 != null) goto L5;
        CaeLog.e(TAG, "unregisterCallback: callback is null");
        return;
    L5:
        this.mCallbacks.unregister(r8);
    }
}
