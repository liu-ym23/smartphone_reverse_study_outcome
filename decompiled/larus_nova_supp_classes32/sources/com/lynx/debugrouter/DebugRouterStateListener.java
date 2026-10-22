package com.lynx.debugrouter;

import android.app.Application;
import com.lynx.debugrouter.base.UIThreadUtils;
import com.lynx.debugrouter.log.LLog;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class DebugRouterStateListener implements StateListener {
    private static final String TAG = "DebugRouterStateListener";
    private long mStartTime;

    @Override // com.lynx.debugrouter.StateListener
    public void onClose(int r1, String r2) {
    }

    @Override // com.lynx.debugrouter.StateListener
    public void onError(String r1) {
    }

    @Override // com.lynx.debugrouter.StateListener
    public void onMessage(String r1) {
    }

    public DebugRouterStateListener() {
        this.mStartTime = -1;
    }

    @Override // com.lynx.debugrouter.StateListener
    public void onOpen(ConnectionType r3) {
        LLog.i(TAG, "onOpen: " + r3);
        this.mStartTime = System.nanoTime();
    }

    private void toastUser(int r1, Throwable r2, boolean r3) {
        if (r3 == true) goto L5;
        return;
    L5:
        if (r1 == 0) goto L8;
        LLog.i(TAG, "only toast in first connection when error occurs");
        return;
    L8:
        if (r2 != null) goto L11;
        LLog.w(TAG, "toastUser: t == null");
        return;
    L11:
        final Application r4 = Utils.getApplicationContext();
        if (r4 != null) goto L14;
        return;
    L14:
        String r5 = r2.getMessage();
        if (r5 != null) goto L17;
    L22:
        if (r5 != null) goto L24;
        return;
    L24:
        if (r5.contains("WebSocket opening handshake timed out") == false) goto L26;
    L27:
        UIThreadUtils.runOnUiThreadImmediately(new AnonymousClass2(this, r4));
        return;
    L26:
        if (r5.contains("java.net.SocketTimeoutException") == true) goto L27;
        return;
    L17:
        if (r5.contains("ERR_INTERNET_DISCONNECTED") == false) goto L19;
    L20:
        UIThreadUtils.runOnUiThreadImmediately(new AnonymousClass1(this, r4));
        return;
    L19:
        if (r5.contains("java.net.ConnectException") == false) goto L22;
        goto L20
    }
}
