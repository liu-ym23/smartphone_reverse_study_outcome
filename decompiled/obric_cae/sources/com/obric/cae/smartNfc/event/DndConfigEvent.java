package com.obric.cae.smartNfc.event;

import android.aimedia.a;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteCallbackList;
import android.provider.Settings;
import com.obric.cae.libs.nfc.ICaeNfcDndConfigCallback;
import com.obric.cae.log.CaeLog;

/* JADX INFO: loaded from: classes2.dex */
public class DndConfigEvent implements EventComponent {
    private static final String NFC_DND_MODE_SETTING = "nfc_dnd_mode";
    private static final int SETTING_DND_DISABLED = 0;
    private static final int SETTING_DND_ENABLED = 1;
    private static final String TAG = "NFC:DndConfigEvent";
    private final RemoteCallbackList<ICaeNfcDndConfigCallback> mCallbacks;
    private final Context mContext;
    private boolean mDndEnabled;
    private final Object mLock;

    public DndConfigEvent(Context r8) {
        this.mLock = new Object();
        this.mCallbacks = new RemoteCallbackList();
        this.mContext = r8;
    }

    private void notifySingleCallback(ICaeNfcDndConfigCallback r8) {
        Object r10 = this.mLock;
        monitor-enter(r10);
        boolean r11 = this.mDndEnabled;     // Catch: Throwable -> L12
        monitor-exit(r10);     // Catch: Throwable -> L12
        r8.onDndConfigChanged(r11, 0);     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        a.q("notifySingleCallback error: ", e, TAG);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private void updateDndModeState() {
        boolean r8 = false;
        if (Settings.Global.getInt(this.mContext.getContentResolver(), NFC_DND_MODE_SETTING, 0) != 1) goto L9;
        r8 = true;
    L9:
        Object r10 = this.mLock;
        monitor-enter(r10);
        this.mDndEnabled = r8;     // Catch: Throwable -> L14
        monitor-exit(r10);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    L7:
        e = move-exception;
        a.q("updateDndModeState error: ", e, TAG);
        goto L9
    }

    @Override // com.obric.cae.smartNfc.event.EventComponent
    public void cleanup() {
        this.mCallbacks.kill();
    }

    public void handleCloudConfigUpdate(Bundle r8) {
        CaeLog.d(TAG, "ignore legacy NFC DND cloud config: state is owned by BDNfcAAR");
    }

    @Override // com.obric.cae.smartNfc.event.EventComponent
    public void init() {
        updateDndModeState();
    }

    public void registerCallback(ICaeNfcDndConfigCallback r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        updateDndModeState();
        this.mCallbacks.register(r8);
        notifySingleCallback(r8);
    }

    public void unregisterCallback(ICaeNfcDndConfigCallback r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        this.mCallbacks.unregister(r8);
    }
}
