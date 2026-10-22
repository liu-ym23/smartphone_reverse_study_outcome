package com.obric.matrix.platform.sdk.ones.internal.tunnel;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.obric.matrix.proto.Response;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/internal/tunnel/MatrixServiceResultReceiver;", "Landroid/os/ResultReceiver;", "a", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0})
public final class MatrixServiceResultReceiver extends ResultReceiver {

    public static final class a {
    }

    static {
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int r5, Bundle r6) {
        super.onReceiveResult(r5, r6);
        if (r6 == null) goto L24;
        byte[] r1 = r6.getByteArray("RESPONSE_BYTE_ARRAY");     // Catch: Exception -> L25
        if (r1 == null) goto L24;
        Response r2 = (Response) Response.ADAPTER.decode(r1);     // Catch: Exception -> L25
        int r3 = gka.a.a;     // Catch: Exception -> L21
        String r7 = r6.getString("EXTRA_DATA");     // Catch: Exception -> L21
        if (r7 != null) goto L10;
    L13:
        boolean r4 = true;
    L14:
        if (r4 == false) goto L38;
        new JSONObject();     // Catch: Exception -> L21
        throw null;     // Catch: Exception -> L21
    L38:
        new JSONObject(r7);     // Catch: Throwable -> L19
    L42:
        throw null;     // Catch: Exception -> L21
    L19:
        new JSONObject();     // Catch: Exception -> L21
        throw null;     // Catch: Exception -> L21
    L10:
        if (r7.length() == 0) goto L13;
        r4 = false;
    L21:
        e = e;
    L27:
        gka.b.a("MatrixServiceResultReceiver", "onReceiveResult exception " + e.getMessage());
        if (r2 != null) goto L34;
        if (r5 != 0) goto L32;
        r5 = -20004;
    L32:
        new Response.Builder().statusCode(Integer.valueOf(r5)).errorMsg("receive result exception").build();
        new JSONObject();
        throw null;
    L34:
        new JSONObject();
        throw null;
    L25:
        e = e;
        r2 = null;
    L24:
        throw new IllegalStateException("RESPONSE_BYTE_ARRAY not found");     // Catch: Exception -> L25
    }
}
