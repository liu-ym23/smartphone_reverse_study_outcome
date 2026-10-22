package com.obric.memorydata.plugin_api.login;

import android.content.Intent;
import android.os.Parcel;
import com.volcengine.zeus.util.kv.IKVStore;
import com.volcengine.zeus.util.kv.KVStorage;
import mka.a;
import mka.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class LoginRestartRelayProtocol {

    public static final class RestoreRequest {
        private final Intent intent;
        private final int sourcePid;

        public Intent getIntent() {
            return this.intent;
        }

        public int getSourcePid() {
            return this.sourcePid;
        }

        public RestoreRequest(int r1, Intent r2) {
            this.sourcePid = r1;
            this.intent = r2;
        }
    }

    public static RestoreRequest consume() {
        IKVStore r0 = KVStorage.INSTANCE.staticKV();
        byte[] r2 = r0.getBytes("memorydata_login_restart_pending_page", b.a);     // Catch: Throwable -> L39
        r0.erase("memorydata_login_restart_pending_page");
        Intent r1 = null;
        if (r2 != null) goto L7;
    L27:
        a r4 = null;
    L28:
        if (r4 != null) goto L30;
        return null;
    L30:
        int r3 = r4.a;
        Parcel r5 = Parcel.obtain();
        byte[] r6 = r4.b;     // Catch: Throwable -> L33 RuntimeException -> L36
        r5.unmarshall(r6, 0, r6.length);     // Catch: Throwable -> L33 RuntimeException -> L36
        r5.setDataPosition(0);     // Catch: Throwable -> L33 RuntimeException -> L36
        Intent r7 = (Intent) Intent.CREATOR.createFromParcel(r5);     // Catch: Throwable -> L33 RuntimeException -> L36
        r5.recycle();
        r1 = r7;
    L38:
        return new RestoreRequest(r3, r1);
    L36:
        r5.recycle();
    L33:
        th = move-exception;
        r5.recycle();
        throw th;
    L7:
        if (r2.length == 0) goto L27;
        Parcel r8 = Parcel.obtain();
        r8.unmarshall(r2, 0, r2.length);     // Catch: Throwable -> L23 RuntimeException -> L42
        r8.setDataPosition(0);     // Catch: Throwable -> L23 RuntimeException -> L42
        if (r8.readInt() != 1296847442) goto L26;
        if (r8.readInt() != 1) goto L26;
        long r9 = r8.readLong();     // Catch: Throwable -> L23 RuntimeException -> L42
        int r10 = r8.readInt();     // Catch: Throwable -> L23 RuntimeException -> L42
        String r11 = r8.readString();     // Catch: Throwable -> L23 RuntimeException -> L42
        byte[] r12 = r8.createByteArray();     // Catch: Throwable -> L23 RuntimeException -> L42
        if (r12 == null) goto L26;
        if (r11 != null) goto L21;
        r11 = "";
    L21:
        r4 = new a(r9, r10, r11, r12);     // Catch: Throwable -> L23 RuntimeException -> L42
        r8.recycle();
        goto L28
    L23:
        th = move-exception;
        r8.recycle();
        throw th;
    L26:
        r8.recycle();
    L39:
        th = move-exception;
        r0.erase("memorydata_login_restart_pending_page");
        throw th;
    }

    private LoginRestartRelayProtocol() {
    }
}
