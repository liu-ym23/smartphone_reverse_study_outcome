package com.obric.cae.smartNfc;

import android.os.Bundle;
import com.obric.cae.cloud.applog.ByteIOUtils;
import com.obric.cae.log.CaeLog;
import com.obric.cae.userAware.utils.MatrixDidUtils;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import r3.a;

/* JADX INFO: loaded from: classes2.dex */
final class NfcTeaReporter {
    private static final String TAG = "NFC:NfcTeaReporter";

    private NfcTeaReporter() {
    }

    private static void appendDeviceId(JSONObject r8) {
        String r10 = MatrixDidUtils.getDid();
        if (r10 != null) goto L5;
        r10 = "";
    L5:
        r8.put("device_id", r10);
    }

    public static void report(String r8, Bundle r10) {
        if (r8 != null) goto L5;
    L17:
        String r11 = "report skipped: empty eventName";
    L18:
        CaeLog.w(TAG, r11);
        return;
    L5:
        if (r8.isEmpty() == true) goto L17;
        if (ByteIOUtils.isInitialized() == true) goto L20;
        r11 = "report skipped: ByteIO not initialized, event=".concat(r8);
        goto L18
    L20:
        a.f11390a.k(r8, toJson(r10));     // Catch: Throwable -> L12 JSONException -> L14
        CaeLog.d(TAG, "reported event=".concat(r8));     // Catch: Throwable -> L12 JSONException -> L14
    L22:
        return;
    L14:
        String r12 = "report failed: invalid params, event=".concat(r8);
    L15:
        CaeLog.e(TAG, r12);
        return;
    L12:
        th = move-exception;
        r12 = "report failed: " + th.getClass().getSimpleName() + ", event=" + r8;
        goto L15
    }

    private static JSONObject toJson(Bundle r8) {
        JSONObject r10 = new JSONObject();
        if (r8 != null) goto L5;
    L35:
        appendDeviceId(r10);
        return r10;
    L5:
        if (r8.isEmpty() == true) goto L35;
        Iterator<String> r11 = r8.keySet().iterator();
    L9:
        if (r11.hasNext() == false) goto L33;
        String r12 = r11.next();
        if (r12 == null) goto L9;
        if (r12.isEmpty() == true) goto L9;
        if ("trace_viewers".equals(r12) == true) goto L9;
        if ("TraceView".equals(r12) == true) goto L9;
        Object r13 = r8.get(r12);
        if (r13 == null) goto L9;
        if ((r13 instanceof String) == true) goto L32;
        if ((r13 instanceof Number) == true) goto L32;
        if ((r13 instanceof Boolean) == true) goto L32;
        if ((r13 instanceof Character) == false) goto L9;
        r13 = String.valueOf(r13);
    L32:
        r10.put(r12, r13);
        goto L9
    L33:
        appendDeviceId(r10);
        return r10;
    }
}
