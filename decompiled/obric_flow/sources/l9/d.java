package l9;

import android.util.Log;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends n9.a {
    public d(String r5, JSONObject r10) {
        this.f20212a = r10;
        boolean r11 = false;
        if (r10 != null) goto L5;
    L7:
        this.e = r11;
        n9.a.f.put(r5, this);
        io.reactivex.exceptions.a.i("after update aid " + r5);
        return;
    L5:
        if (mh.e.c(r10, 0, new String[]{"exception_modules", "exception", "enable_upload"}) != 1) goto L7;
        r11 = true;
        goto L7
    }

    public static boolean d(String r13, Map r14) {
        boolean r5 = false;
        if (r13 == null) goto L61;
        boolean r10 = false;
    L9:
        com.bytedance.android.anniex.worker.a r11 = com.bytedance.crash.upload.b.f4096h;
        long r12 = 3600000;
        if (r14 != null) goto L16;
        io.reactivex.exceptions.a.i("config should be updated cause no config.");     // Catch: Throwable -> L6
        if (r10 == false) goto L14;
        o.e().c(r11, 3600000);     // Catch: Throwable -> L6
    L14:
        return true;
    L16:
        if (r14.get(r13) != null) goto L21;
        io.reactivex.exceptions.a.i("config should be updated cause config not complete.");     // Catch: Throwable -> L6
        if (r10 == false) goto L20;
        o.e().c(r11, 3600000);     // Catch: Throwable -> L6
    L20:
        return true;
    L21:
        long r15 = System.currentTimeMillis();     // Catch: Throwable -> L6
        if (r13 != null) goto L57;
        return false;
    L57:
        long r16 = Long.decode((String) r14.get(r13)).longValue();     // Catch: Throwable -> L44
        n9.a r17 = (n9.a) n9.a.f.get(r13);     // Catch: Throwable -> L44
        if (r17 != null) goto L59;
    L32:
        long r18 = r15 - r16;
        if (r18 <= r12) goto L40;
        if (r10 == true) goto L55;
    L39:
        r5 = true;
    L46:
        if (r5 == false) goto L48;
        io.reactivex.exceptions.a.i("config should be updated cause delayed");     // Catch: Throwable -> L6
    L49:
        return r5;
    L48:
        io.reactivex.exceptions.a.i("config should not be updated");     // Catch: Throwable -> L6
        goto L49
    L55:
        o.e().c(r11, r12);     // Catch: Throwable -> L37
    L37:
        th = th;
        r5 = true;
    L45:
        io.reactivex.exceptions.a.f(th);     // Catch: Throwable -> L6
        goto L46
    L40:
        if (r10 == false) goto L46;
        o.e().c(r11, r12 - r18);     // Catch: Throwable -> L44
        goto L46
    L59:
        String[] r19 = {"general", "slardar_api_settings", "fetch_setting", "fetch_setting_interval"};     // Catch: Throwable -> L54
        JSONObject r110 = mh.e.q(((d) r17).f20212a, r19);     // Catch: Throwable -> L54
        if (r110 != null) goto L29;
        String r111 = null;
    L30:
        r12 = 1000 * Long.decode(r111).longValue();
        goto L32
    L29:
        r111 = r110.optString(r19[3]);     // Catch: Throwable -> L54
    L44:
        th = th;
        goto L45
    L61:
        r13 = com.bytedance.crash.n.d().i();     // Catch: Throwable -> L6
        r10 = true;
    L6:
        th = move-exception;
        if (com.bytedance.crash.n.f4062j.isDebugMode() == false) goto L53;
        Log.e("npth", "npth err", th);
    L53:
        return true;
    }
}
