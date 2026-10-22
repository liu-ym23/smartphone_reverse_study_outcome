package com.lynx.debugrouter;

import com.lynx.debugrouter.log.LLog;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class NativeStateListenerDelegate {
    private static final String TAG = "NativeStateListenerDelegate";
    private StateListener listener;

    public NativeStateListenerDelegate(StateListener r1) {
        this.listener = r1;
    }

    public void onError(String r2) {
        StateListener r0 = this.listener;
        if (r0 == null) goto L6;
        r0.onError(r2);
        return;
    }

    public void onMessage(String r2) {
        StateListener r0 = this.listener;
        if (r0 == null) goto L6;
        r0.onMessage(r2);
        return;
    }

    public void onOpen(String r2) {
        if (this.listener == null) goto L12;
        r2.getClass();
        if (r2.equals("websocket") == false) goto L7;
        this.listener.onOpen(ConnectionType.WebSocket);
        return;
    L7:
        if (r2.equals("usb") == true) goto L9;
        LLog.e(TAG, "unknown type: ".concat(r2));
        return;
    L9:
        this.listener.onOpen(ConnectionType.USB);
        return;
    }

    public void onClose(int r2, String r3) {
        StateListener r0 = this.listener;
        if (r0 == null) goto L6;
        r0.onClose(r2, r3);
        return;
    }
}
