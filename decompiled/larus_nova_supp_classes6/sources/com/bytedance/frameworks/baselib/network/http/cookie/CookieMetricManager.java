package com.bytedance.frameworks.baselib.network.http.cookie;

import android.text.TextUtils;
import com.bytedance.keva.Keva;
import ix5.b;
import java.net.URI;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import okio.ByteString;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class CookieMetricManager {
    public final Keva a;
    public final AtomicBoolean b;
    public volatile JSONObject c;

    public static class a {
        public static final CookieMetricManager a = null;

        static {
            a = new CookieMetricManager();
        }
    }

    public final JSONObject a() {
        JSONObject r2 = null;
        if ((!b.e) == false) goto L6;
        return null;
    L6:
        if (this.b.compareAndSet(true, false) == false) goto L49;
        Map r0 = this.a.getAll();     // Catch: Throwable -> L45
        if (r0 != null) goto L10;
    L47:
        this.c = r2;
        goto L49
    L10:
        if (r0.isEmpty() == true) goto L47;
        JSONObject r4 = new JSONObject();     // Catch: Throwable -> L45
        Iterator r1 = r0.entrySet().iterator();     // Catch: Throwable -> L45
    L14:
        if (r1.hasNext() == false) goto L42;
        Map.Entry r5 = (Map.Entry) r1.next();     // Catch: Throwable -> L45
        String r6 = (String) r5.getKey();     // Catch: Throwable -> L45
        if (TextUtils.isEmpty(r6) == true) goto L14;
        boolean r7 = r6.startsWith(";remove");     // Catch: Throwable -> L45
        if (r7 == false) goto L21;
    L50:
        String r8 = (String) r5.getValue();     // Catch: Throwable -> L31
    L34:
        if (TextUtils.isEmpty(r8) == true) goto L14;
        if (r7 == false) goto L38;
        r6 = r6.substring(1);     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L45
    L38:
        r4.put(r6, new JSONObject(r8));     // Catch: Throwable -> L40
    L31:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L45
        r8 = null;
        goto L34
    L21:
        if (TextUtils.isEmpty(r6) == false) goto L23;
    L25:
        boolean r9 = false;
    L26:
        if (r9 == true) goto L50;
        this.a.erase(r6);     // Catch: Throwable -> L45
        goto L14
    L23:
        if (((CopyOnWriteArraySet) b.g).contains(r6) == false) goto L25;
        r9 = true;
        goto L26
    L42:
        if (r4.length() <= 0) goto L47;
        r2 = r4;
    L45:
        th = move-exception;
        th.printStackTrace();
    L49:
        return this.c;
    }

    public CookieMetricManager() {
        this.b = new AtomicBoolean(true);
        this.c = null;
        this.a = Keva.getRepo("ttnetCookieDetailRepo", 1);
    }

    public final void b(URI r13, f r14) {
        if (r13 != null) goto L4;
        return;
    L4:
        if ((!b.e) == true) goto L51;
        String r0 = r14.e;
        if (TextUtils.isEmpty(r0) == false) goto L8;
    L10:
        boolean r1 = false;
    L11:
        if (r1 == false) goto L53;
        String r2 = e.c(r13);
        String r15 = r13.getPath();
        if (TextUtils.isEmpty(r14.h) == false) goto L46;
        String r3 = null;
    L20:
        String r4 = r14.a;
        String r5 = r14.f;
        boolean r6 = r14.g;
        long r7 = r14.c;
        if (r7 <= 0) goto L24;
        r7 = r7 - System.currentTimeMillis();
    L24:
        long r8 = r14.c;
        StringBuilder r10 = new StringBuilder("{\"r_host\":\"");
        if (r2 != null) goto L27;
        r2 = "-";
    L27:
        r10.append(r2);
        r10.append("\",\"r_path\":\"");
        if (r15 != null) goto L30;
        r15 = "-";
    L30:
        r10.append(r15);
        r10.append("\",\"v_md5\":\"");
        if (r3 != null) goto L33;
        r3 = "-";
    L33:
        r10.append(r3);
        r10.append("\",\"domain\":\"");
        if (r4 != null) goto L36;
        r4 = "-";
    L36:
        r10.append(r4);
        r10.append("\",\"path\":\"");
        if (r5 != null) goto L39;
        r5 = "-";
    L39:
        r10.append(r5);
        r10.append("\",\"sec\":");
        r10.append(r6);
        r10.append(",\"age\":");
        r10.append(r7);
        r10.append(",\"exp_t\":");
        r10.append(r8);
        r10.append("}");
        String r16 = r10.toString();
        if (TextUtils.isEmpty(r16) == true) goto L52;
        this.a.storeString(r14.e, r16);     // Catch: Throwable -> L43
        this.b.set(true);     // Catch: Throwable -> L43
        return;
    L43:
        th = move-exception;
        th.printStackTrace();
        return;
    L52:
        return;
    L46:
        r3 = ByteString.encodeUtf8(r14.h).md5().hex();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        String r9 = String.valueOf(r14.h.length());
        th.printStackTrace();
        r3 = r9;
        goto L20
    L53:
        return;
    L8:
        if (((CopyOnWriteArraySet) b.g).contains(r0) == false) goto L10;
        r1 = true;
        goto L11
    }
}
