package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.text.TextUtils;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.PreloadCompConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class y3 {
    public static volatile x3 a;
    public static volatile g3 b;
    public static volatile g3 c;
    public static volatile o d;
    public static volatile x3 e;
    public static volatile HashMap<String, x3> f;
    public static volatile HashMap<String, g3> g;
    public static volatile HashMap<String, g3> h;
    public static volatile HashMap<String, o> i;
    public static volatile HashMap<String, x3> j;

    static {
        f = new HashMap();
        g = new HashMap();
        h = new HashMap();
        i = new HashMap();
        j = new HashMap();
    }

    public static o a() {
        if (d != null) goto L15;
        monitor-enter(y3.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (d != null) goto L9;
        d = new o(l(), e());     // Catch: Throwable -> L11
    L9:
        monitor-exit(y3.class);     // Catch: Throwable -> L11
    L15:
        return d;
    }

    public static synchronized void d() {
        monitor-enter(y3.class);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (a == null) goto L8;
        a.H(true);     // Catch: Throwable -> L19
    L8:
        if (b == null) goto L11;
        b.H(true);     // Catch: Throwable -> L19
    L11:
        if (c == null) goto L14;
        c.H(true);     // Catch: Throwable -> L19
    L14:
        if (e == null) goto L16;
        e.H(true);     // Catch: Throwable -> L19
    L16:
        a = new x3(true);     // Catch: Throwable -> L19
        b = new g3();     // Catch: Throwable -> L19
        c = new g3();     // Catch: Throwable -> L19
        d = new o(a, b);     // Catch: Throwable -> L19
        e = new x3(true);     // Catch: Throwable -> L19
        monitor-exit(y3.class);
    }

    public static g3 e() {
        if (b != null) goto L15;
        monitor-enter(y3.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (b != null) goto L9;
        b = new g3();     // Catch: Throwable -> L11
    L9:
        monitor-exit(y3.class);     // Catch: Throwable -> L11
    L15:
        return b;
    }

    public static synchronized void j() {
        monitor-enter(y3.class);
    L21:
        th = move-exception;
        throw th;
    L5:
        if (b == null) goto L8;
        b.H(true);     // Catch: Throwable -> L21
        b = null;     // Catch: Throwable -> L21
    L8:
        if (a == null) goto L11;
        a.H(true);     // Catch: Throwable -> L21
        a = null;     // Catch: Throwable -> L21
    L11:
        if (c == null) goto L14;
        c.H(true);     // Catch: Throwable -> L21
        c = null;     // Catch: Throwable -> L21
    L14:
        if (e == null) goto L17;
        e.H(true);     // Catch: Throwable -> L21
        e = null;     // Catch: Throwable -> L21
    L17:
        if (d == null) goto L19;
        d = null;     // Catch: Throwable -> L21
    L19:
        monitor-exit(y3.class);
    }

    public static x3 l() {
        if (a != null) goto L15;
        monitor-enter(y3.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (a != null) goto L9;
        a = new x3(true);     // Catch: Throwable -> L11
    L9:
        monitor-exit(y3.class);     // Catch: Throwable -> L11
    L15:
        return a;
    }

    public y3() {
    }

    public static c0 b(DataCenter r3) {
        c(r3);
        if (h(r3) == false) goto L10;
        String r0 = (String) r3.get("data_room_unique_id", null);
        if (i.get(r0) != null) goto L8;
        o r1 = new o(m(r3), f(r3));
        i.put(r0, r1);
    L8:
        return i.get(r0);
    L10:
        return a();
    }

    public static void c(DataCenter r0) {
        if (r0 == null) goto L4;
        return;
    L4:
        if (com.bytedance.android.live.core.utils.v.a() == true) goto L9;
        com.bytedance.crash.d.b("ToolbarManagerProvider, dataCenter is null or unique is null");
        return;
    }

    public static g3 f(DataCenter r2) {
        c(r2);
        if (h(r2) == false) goto L10;
        String r3 = (String) r2.get("data_room_unique_id", null);
        if (g.get(r3) != null) goto L8;
        g3 r0 = new g3();
        g.put(r3, r0);
    L8:
        return g.get(r3);
    L10:
        return e();
    }

    public static synchronized void g(DataCenter r1) {
        monitor-enter(y3.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (h(r1) == true) goto L8;
        d();     // Catch: Throwable -> L10
    L8:
        monitor-exit(y3.class);
    }

    public static boolean h(DataCenter r4) {
        if (r4 == null) goto L11;
        boolean r1 = ((Boolean) r4.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        if (TextUtils.isEmpty((String) r4.get("data_room_unique_id", null)) == true) goto L12;
        if (r1 == false) goto L8;
        return false;
    L8:
        if (PreloadCompConfig.INSTANCE.enableToolbar() == false) goto L14;
        return true;
    L14:
        return false;
    L12:
        return false;
    L11:
        return false;
    }

    public static c0 i(DataCenter r2) {
        c(r2);
        if (h(r2) == false) goto L10;
        String r3 = (String) r2.get("data_room_unique_id", null);
        if (h.get(r3) != null) goto L8;
        g3 r0 = new g3();
        h.put(r3, r0);
    L8:
        return h.get(r3);
    L10:
        if (c != null) goto L22;
        monitor-enter(y3.class);
    L18:
        th = move-exception;
        throw th;
    L14:
        if (c != null) goto L16;
        c = new g3();     // Catch: Throwable -> L18
    L16:
        monitor-exit(y3.class);     // Catch: Throwable -> L18
    L22:
        return c;
    }

    public static synchronized void k(DataCenter r3) {
        monitor-enter(y3.class);
        c(r3);     // Catch: Throwable -> L24
        if (h(r3) == false) goto L21;
        String r4 = (String) r3.get("data_room_unique_id", null);     // Catch: Throwable -> L24
        if (f.get(r4) == null) goto L10;
        f.remove(r4).H(true);     // Catch: Throwable -> L24
    L10:
        if (g.get(r4) == null) goto L13;
        g.remove(r4).H(true);     // Catch: Throwable -> L24
    L13:
        if (h.get(r4) == null) goto L16;
        h.remove(r4).H(true);     // Catch: Throwable -> L24
    L16:
        if (j.get(r4) == null) goto L19;
        j.remove(r4).H(true);     // Catch: Throwable -> L24
    L19:
        if (i.get(r4) == null) goto L22;
        i.remove(r4);     // Catch: Throwable -> L24
    L22:
        monitor-exit(y3.class);
        return;
    L21:
        j();     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    public static c0 m(DataCenter r2) {
        c(r2);
        if (h(r2) == false) goto L10;
        String r3 = (String) r2.get("data_room_unique_id", null);
        if (f.get(r3) != null) goto L8;
        x3 r0 = new x3(true);
        f.put(r3, r0);
    L8:
        return f.get(r3);
    L10:
        return l();
    }

    public static c0 n(String r2) {
        if (TextUtils.isEmpty(r2) == true) goto L12;
        if (PreloadCompConfig.INSTANCE.enableToolbar() == false) goto L12;
        if (f.get(r2) != null) goto L10;
        x3 r0 = new x3(true);
        f.put(r2, r0);
    L10:
        return f.get(r2);
    L12:
        return l();
    }
}
