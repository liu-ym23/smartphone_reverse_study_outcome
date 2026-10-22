package com.obric.memorydata.plugin_api.login;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Process;
import com.obric.memorydata.plugin_api.stub.activity.LoginRestartRelayActivity;
import com.volcengine.zeus.util.kv.KVStorage;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class LoginRestartClient {
    private static final String TAG = "LoginRestartClient";

    private static void clearPendingRecordQuietly() {
        KVStorage.INSTANCE.staticKV().erase("memorydata_login_restart_pending_page");     // Catch: RuntimeException -> L4
        return;
    }

    private LoginRestartClient() {
    }

    public static boolean restartAfterLogin(Context r7, String r8) {
        byte[] r0 = LoginRestartPageRecorder.consumeIntentBytes();
        if (r0 != null) goto L5;
    L20:
        clearPendingRecordQuietly();
        return false;
    L5:
        if (r0.length == 0) goto L20;
        long r2 = System.currentTimeMillis();
        int r4 = Process.myPid();
        if (r8 != null) goto L22;
        r8 = "";
    L22:
        Parcel r5 = Parcel.obtain();     // Catch: RuntimeException -> L18
        r5.writeInt(1296847442);     // Catch: Throwable -> L15
        r5.writeInt(1);     // Catch: Throwable -> L15
        r5.writeLong(r2);     // Catch: Throwable -> L15
        r5.writeInt(r4);     // Catch: Throwable -> L15
        r5.writeString(r8);     // Catch: Throwable -> L15
        r5.writeByteArray(r0);     // Catch: Throwable -> L15
        byte[] r9 = r5.marshall();     // Catch: Throwable -> L15
        r5.recycle();     // Catch: RuntimeException -> L18
        KVStorage.INSTANCE.staticKV().storeBytes("memorydata_login_restart_pending_page", r9);     // Catch: RuntimeException -> L18
        Intent r10 = new Intent(r7, LoginRestartRelayActivity.class);     // Catch: RuntimeException -> L18
        r10.addFlags(268435456);     // Catch: RuntimeException -> L18
        r7.startActivity(r10);     // Catch: RuntimeException -> L18
        return true;
    L15:
        th = move-exception;
        r5.recycle();     // Catch: RuntimeException -> L18
        throw th;     // Catch: RuntimeException -> L18
    L18:
        clearPendingRecordQuietly();
        return false;
    }
}
