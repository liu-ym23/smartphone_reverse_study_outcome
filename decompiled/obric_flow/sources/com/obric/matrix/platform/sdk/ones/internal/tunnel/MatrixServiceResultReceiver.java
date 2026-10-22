package com.obric.matrix.platform.sdk.ones.internal.tunnel;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.obric.matrix.proto.Response;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/internal/tunnel/MatrixServiceResultReceiver;", "Landroid/os/ResultReceiver;", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MatrixServiceResultReceiver extends ResultReceiver {
    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int r5, Bundle r10) {
        super.onReceiveResult(r5, r10);
        if (r10 == null) goto L22;
        byte[] r11 = r10.getByteArray("RESPONSE_BYTE_ARRAY");     // Catch: Exception -> L19
        if (r11 == null) goto L22;
        Response r12 = Response.ADAPTER.decode(r11);     // Catch: Exception -> L19
        String r13 = r10.getString("EXTRA_DATA");     // Catch: Exception -> L17
        if (r13 != null) goto L10;
    L15:
        new JSONObject();     // Catch: Exception -> L17
        throw null;     // Catch: Exception -> L17
    L10:
        if (r13.length() == 0) goto L15;
        new JSONObject(r13);     // Catch: Throwable -> L14
    L38:
        throw null;     // Catch: Exception -> L17
    L14:
        new JSONObject();     // Catch: Exception -> L17
        throw null;     // Catch: Exception -> L17
    L17:
        e = e;
    L23:
        com.lynx.jsbridge.a.q("MatrixServiceResultReceiver", "onReceiveResult exception " + e.getMessage());
        if (r12 != null) goto L30;
        if (r5 != 0) goto L28;
        r5 = -20004;
    L28:
        new Response.Builder().statusCode(Integer.valueOf(r5)).errorMsg("receive result exception").build();
        new JSONObject();
        throw null;
    L30:
        new JSONObject();
        throw null;
    L19:
        e = e;
        r12 = null;
    L22:
        throw new IllegalStateException("RESPONSE_BYTE_ARRAY not found");     // Catch: Exception -> L19
    }
}
