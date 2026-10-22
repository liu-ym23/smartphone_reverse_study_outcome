package com.obric.cae.smartNfc.event;

import android.aimedia.a;
import android.os.Bundle;
import android.os.RemoteCallbackList;
import com.obric.cae.libs.nfc.ICaeNfcCloudConfigCallback;
import com.obric.cae.log.CaeLog;

/* JADX INFO: loaded from: classes2.dex */
public class CloudConfigEvent implements EventComponent {
    private static final String TAG = "NFC:CloudConfigEvent";
    private final RemoteCallbackList<ICaeNfcCloudConfigCallback> mCallbacks;

    public CloudConfigEvent() {
        this.mCallbacks = new RemoteCallbackList();
    }

    @Override // com.obric.cae.smartNfc.event.EventComponent
    public void cleanup() {
        this.mCallbacks.kill();
    }

    @Override // com.obric.cae.smartNfc.event.EventComponent
    public void init() {
    }

    public void notifyCloudConfigUpdate(Bundle r8) {
        CaeLog.d(TAG, "notifyCloudConfigUpdate: data=" + r8);
        int r10 = this.mCallbacks.beginBroadcast();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L9;
        ((ICaeNfcCloudConfigCallback) this.mCallbacks.getBroadcastItem(r11)).onCloudConfigUpdate(r8);     // Catch: Exception -> L6
    L8:
        r11 = r11 + 1;
    L6:
        e = move-exception;
        a.q("notifyCloudConfigUpdate error: ", e, TAG);
        goto L8
    L9:
        this.mCallbacks.finishBroadcast();
    }

    public void registerCallback(ICaeNfcCloudConfigCallback r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        this.mCallbacks.register(r8);
    }

    public void unregisterCallback(ICaeNfcCloudConfigCallback r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        this.mCallbacks.unregister(r8);
    }
}
