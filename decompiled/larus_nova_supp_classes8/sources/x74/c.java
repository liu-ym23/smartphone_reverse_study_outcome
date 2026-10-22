package x74;

import com.bytedance.bdinstall.o0;
import com.bytedance.bdinstall.p0;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.Sword.Sword;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c {
    public static void a(JSONObject r6, boolean r7) {
        boolean r2 = false;
        byte[] r3 = new byte[0];
        r3 = r6.toString().getBytes("UTF-8");     // Catch: Exception -> L5
    L20:
        String r8 = UriProtector.parse("https://log.snssdk.com/service/2/dtrait/").buildUpon().appendQueryParameter("req_id", (String) y74.c.a.b(new Object[0])).build().toString();     // Catch: Exception -> L15
        p0.c r1 = n74.a.d;     // Catch: Exception -> L15
        if (r1 == null) goto L13;
        o0 r4 = r1.a;     // Catch: Exception -> L15
        if (r4.r == false) goto L12;
        r2 = r4.A;     // Catch: Exception -> L15
        goto L13
    L12:
        r2 = true;
    L13:
        b.a(r8, new String(r3, "UTF-8"), r2, r7);     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        m74.a.b("[dt] DTraitNetworkHelper# bindDTrait network error " + e.getMessage());
        return;
    L5:
        e = move-exception;
        m74.a.b("[dt] DTraitNetworkHelper# sword encrypt error, " + e.getMessage());
        goto L20
    }

    public static JSONObject b(JSONObject r6, boolean r7) {
        boolean r2 = false;
        byte[] r3 = new byte[0];
        r3 = r6.toString().getBytes("UTF-8");     // Catch: Exception -> L5
        byte[] r8 = Sword.clientPackedBase64(r3, r3.length).getBytes("UTF-8");     // Catch: Exception -> L5
    L20:
        String r1 = UriProtector.parse("https://log.snssdk.com/service/3/device_sdk/stats_collect/").buildUpon().appendQueryParameter("req_id", (String) y74.c.a.b(new Object[0])).build().toString();     // Catch: Exception -> L15
        p0.c r4 = n74.a.d;     // Catch: Exception -> L15
        if (r4 == null) goto L13;
        o0 r5 = r4.a;     // Catch: Exception -> L15
        if (r5.r == false) goto L12;
        r2 = r5.A;     // Catch: Exception -> L15
        goto L13
    L12:
        r2 = true;
    L13:
        JSONObject r9 = b.a(r1, new String(r8, "UTF-8"), r2, r7);     // Catch: Exception -> L15
    L17:
        if (r9 == null) goto L19;
        return r9;
    L19:
        return new JSONObject();
    L15:
        e = move-exception;
        m74.a.b("[dt] DTraitNetworkHelper# statsCollect network error " + e.getMessage());
        r9 = null;
    L5:
        e = move-exception;
        m74.a.b("[dt] DTraitNetworkHelper# sword encrypt error, " + e.getMessage());
        r8 = r3;
        goto L20
    }
}
