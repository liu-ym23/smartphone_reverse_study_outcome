package m;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import androidx.constraintlayout.motion.widget.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class w extends y {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f19938b = null;

    static {
        f19938b = "Mi_R_".concat(w.class.getSimpleName());
    }

    @Override // m.y
    public final boolean a(String r10, String r11, Object... r12) {
        boolean r5 = false;
        String r13 = "";
        if (r12 == null) goto L8;
        int r14 = 0;
    L6:
        if (r14 >= r12.length) goto L8;
        r13 = r13 + " p" + r14 + ": " + r12[r14];
        r14 = r14 + 1;
    L8:
        StringBuilder r15 = a.y("test debug agent onLocalCallback in travel toolName:", r10, ",funcName:", r11, ",param=");
        r15.append(r13);
        String r16 = r15.toString();
        String r17 = f19938b;
        Log.d(r17, r16);
        if ("LocalFeichangzhunTool".equals(r10) == true) goto L11;
        return false;
    L11:
        if (r12 != null) goto L14;
        return false;
    L14:
        if ("extractFlightInfo".equals(r11) == true) goto L16;
    L45:
        return false;
    L16:
        if (r12.length != 1) goto L45;
        Object r18 = r12[0];
        if (r18 != null) goto L20;
        String r19 = null;
    L21:
        Log.d(r17, "callMiBoardOnTravelDataChanged 调用负一屏开始");
        Context r20 = this.f19940a;
        Uri r21 = b0.a(r20);
        Bundle r22 = new Bundle();
        JSONObject r110 = new JSONObject(r19).getJSONObject("flightInfo");     // Catch: Exception -> L24
        JSONObject r23 = new JSONObject();     // Catch: Exception -> L24
        r23.put("dataKey", "flight");     // Catch: Exception -> L24
        r23.put("eventType", "push");     // Catch: Exception -> L24
        r23.put("travelDataObj", r110);     // Catch: Exception -> L24
        String r111 = r23.toString();     // Catch: Exception -> L24
        Log.d(r17, "dataStr for miboard = " + r111);     // Catch: Exception -> L24
        r22.putString("travel_data", r111);     // Catch: Exception -> L24
    L48:
        ContentProviderClient r24 = r20.getContentResolver().acquireUnstableContentProviderClient(r21);     // Catch: Exception -> L35
        Bundle r112 = r24.call("on_travel_data_changed", null, r22);     // Catch: Throwable -> L30
        if (r112 == null) goto L32;
        r5 = r112.getBoolean("boolean_result", false);     // Catch: Throwable -> L30
    L32:
        Log.d(r17, "on_travel_data_changed handled=" + r5);     // Catch: Throwable -> L30
        r24.close();     // Catch: Exception -> L35
    L44:
        return true;
    L30:
        th = move-exception;
        if (r24 != null) goto L51;
    L42:
        throw th;     // Catch: Exception -> L35
    L51:
        r24.close();     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L35
    L35:
        e = move-exception;
        e.printStackTrace();
    L24:
        e = move-exception;
        e.printStackTrace();
        goto L48
    L20:
        r19 = r18.toString();
        goto L21
    }
}
