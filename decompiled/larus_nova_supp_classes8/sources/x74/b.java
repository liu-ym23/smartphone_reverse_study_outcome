package x74;

import android.util.Pair;
import com.bytedance.bdinstall.i;
import com.bytedance.bdinstall.p0;
import com.bytedance.bmmt.base.DeviceInfoAndroid;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;
import w74.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b {
    public static byte[] b(String r5, boolean r6) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream(DeviceInfoAndroid.BUFFER_SIZE);
        GZIPOutputStream r3 = null;
        if (r6 == false) goto L9;
        GZIPOutputStream r4 = new GZIPOutputStream(r0);     // Catch: Throwable -> L15
        r4.write(r5.getBytes("UTF-8"));     // Catch: Throwable -> L7
        r3 = r4;
    L10:
        if (r3 != null) goto L41;
    L20:
        byte[] r7 = r0.toByteArray();
        if (r6 == true) goto L23;
        return r7;
    L23:
        if (n74.a.d == null) goto L44;
        p0.b r8 = n74.a.e;
        int r1 = r7.length;
        return r8.a.s.encrypt(r7, r1);
    L44:
        return r7;
    L41:
        r3.close();     // Catch: IOException -> L13
    L13:
        e = move-exception;
        m74.a.c("Register#doRegister http error = ", e);
    L7:
        th = th;
        r3 = r4;
    L35:
        m74.a.c("Register#doRegister http error = ", th);     // Catch: Throwable -> L26
        if (r3 == null) goto L20;
    L26:
        th = move-exception;
        if (r3 != null) goto L33;
    L32:
        throw th;
    L33:
        r3.close();     // Catch: IOException -> L30
    L30:
        e = move-exception;
        m74.a.c("Register#doRegister http error = ", e);
        goto L32
    L9:
        r0.write(r5.getBytes("UTF-8"));     // Catch: Throwable -> L15
    L15:
        th = th;
        goto L35
    }

    public static JSONObject a(String r4, String r5, boolean r6, boolean r7) {
        HashMap r1 = new HashMap();
        Pair r8 = BDNetworkTagManager.getInstance().buildBDNetworkTag(new a(r7));     // Catch: Throwable -> L7
        if (r8 == null) goto L9;
        r1.put(r8.first, r8.second);     // Catch: Throwable -> L7
    L9:
        if (r6 == false) goto L11;
        r1.put("Content-Type", "application/octet-stream;tt-data=a");
    L12:
        e r9 = null;
        byte[] r10 = b(r5, r6);     // Catch: Exception -> L24
        if (r10 == null) goto L17;
        if (r6 == false) goto L17;
        r4 = r4 + "&tt_data=a";     // Catch: Exception -> L24
    L17:
        p0.b r11 = n74.a.e;     // Catch: Exception -> L24
        if (r11 == null) goto L26;
        i.b.g.getClass();     // Catch: Exception -> L24
        e r12 = new e(r4, null, r11.a.b.post(r4, r10, r1));     // Catch: Exception -> L24
        m74.a.a("ticket network client is ready. response is " + r12);     // Catch: Exception -> L22
        r9 = r12;
    L22:
        e = e;
        r9 = r12;
    L25:
        m74.a.c("Register#doRegister http error = ", e);
    L26:
        if (r9 != null) goto L33;
        r9 = new e(r4, new ArrayList(), "{}");
    L33:
        return new JSONObject(r9.c);
    L30:
        e = move-exception;
        m74.a.c("Register#doRegister new json error: ", e);
        return new JSONObject();
    L24:
        e = e;
        goto L25
    L11:
        r1.put("Content-Type", "application/json; charset=utf-8");
        goto L12
    }
}
