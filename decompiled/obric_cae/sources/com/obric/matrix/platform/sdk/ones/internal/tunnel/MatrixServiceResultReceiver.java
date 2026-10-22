package com.obric.matrix.platform.sdk.ones.internal.tunnel;

import android.os.Bundle;
import android.os.ResultReceiver;
import he.i;
import org.json.JSONObject;
import rb.q;

/* JADX INFO: loaded from: classes2.dex */
public final class MatrixServiceResultReceiver extends ResultReceiver {
    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int r8, Bundle r10) {
        super.onReceiveResult(r8, r10);
        if (r10 == null) goto L24;
        byte[] r11 = r10.getByteArray("RESPONSE_BYTE_ARRAY");     // Catch: Exception -> L25
        if (r11 == null) goto L24;
        q r12 = q.f11690t.decode(r11);     // Catch: Exception -> L25
        String r13 = r10.getString("EXTRA_DATA");     // Catch: Exception -> L21
        if (r13 != null) goto L10;
    L13:
        boolean r14 = true;
    L14:
        if (r14 == false) goto L38;
        new JSONObject();     // Catch: Exception -> L21
        throw null;     // Catch: Exception -> L21
    L38:
        new JSONObject(r13);     // Catch: Throwable -> L19
    L42:
        throw null;     // Catch: Exception -> L21
    L19:
        new JSONObject();     // Catch: Exception -> L21
        throw null;     // Catch: Exception -> L21
    L10:
        if (r13.length() == 0) goto L13;
        r14 = false;
    L21:
        e = e;
    L27:
        i.f("onReceiveResult exception " + e.getMessage(), "msg");
        if (r12 != null) goto L34;
        if (r8 != 0) goto L32;
        r8 = -20004;
    L32:
        q.a r15 = new q.a();
        r15.f11701b = Integer.valueOf(r8);
        r15.f11702c = "receive result exception";
        r15.a();
        new JSONObject();
        throw null;
    L34:
        new JSONObject();
        throw null;
    L25:
        e = e;
        r12 = null;
    L24:
        throw new IllegalStateException("RESPONSE_BYTE_ARRAY not found");     // Catch: Exception -> L25
    }
}
