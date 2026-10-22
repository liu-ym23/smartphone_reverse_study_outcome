package com.loc;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.AutoEndConversationTime;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.net.URL;
import java.util.ArrayList;
import n4a.c4;
import n4a.e3;
import n4a.f5;
import n4a.h4;
import n4a.i4;
import n4a.k1;
import n4a.l1;
import n4a.x3;
import n4a.y3;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f {
    public static f i;
    public long a;
    public final ArrayList<String> b;
    public final e3 c;
    public final e3 d;
    public long e;
    public final Context f;
    public String g;
    public boolean h;

    public class a extends l1 {
        public final /* synthetic */ int b;
        public final /* synthetic */ f c;

        public a(f r1, int r2) {
            this.c = r1;
            this.b = r2;
        }

        @Override // n4a.l1
        public final void a() {
            StringBuilder r3 = new StringBuilder("http://");
            r3.append(f5.o(h.B));
            r3.append("?host=dualstack-a.apilocate.amap.com&query=");
            if (this.b != 2) goto L5;
            int r4 = 6;
        L6:
            r3.append(r4);
            String r5 = r3.toString();
            x3 r6 = new x3();
            r6.m = r5;
            r6.o = r5;
            r6.i = bo.a.e;
            r6.b(bo.c.a);
            c.c();     // Catch: Throwable -> L27
            JSONObject r7 = new JSONObject(new String(c.a(r6).a));     // Catch: Throwable -> L27
            String[] r8 = f.e(r7.optJSONArray("ips"), 1);     // Catch: Throwable -> L27
            if (r8.length > 0) goto L10;
        L12:
            String[] r9 = f.e(r7.optJSONArray("ipsv6"), 2);     // Catch: Throwable -> L27
            if (r9.length <= 0) goto L18;
            if (f.d(r9, this.c.f(2).a) == true) goto L18;
            this.c.f(2).a = r9;     // Catch: Throwable -> L27
            f.g(this.c, 2);     // Catch: Throwable -> L27
        L18:
            if (r7.has("ips") == true) goto L22;
            if (r7.has("ipsv6") == true) goto L22;
            return;
        L22:
            if (r7.has("ttl") == false) goto L38;
            int r0 = JSONObjectProtectorUtils.getInt(r7, "ttl");     // Catch: Throwable -> L27
            if (r0 <= 30) goto L39;
            this.c.e = r0 * 1000;     // Catch: Throwable -> L27
            return;
        L39:
            return;
        L38:
            return;
        L10:
            if (f.d(r8, this.c.f(1).a) == true) goto L12;
            this.c.f(1).a = r8;     // Catch: Throwable -> L27
            f.g(this.c, 1);     // Catch: Throwable -> L27
        L27:
            th = move-exception;
            JSONObject r1 = new JSONObject();
            r1.put("key", "dnsError");     // Catch: Throwable -> L32
            r1.put("reason", th.getMessage());     // Catch: Throwable -> L32
        L30:
            h4.i(this.c.f, "O018", r1);
            return;
        L5:
            r4 = 4;
            goto L6
        }
    }

    public f(Context r3) {
        this.a = 0;
        this.b = new ArrayList();
        this.c = new e3();
        this.d = new e3();
        this.e = 120000;
        this.h = false;
        this.f = r3;
    }

    public static synchronized f a(Context r2) {
        monitor-enter(f.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (i != null) goto L7;
        i = new f(r2);     // Catch: Throwable -> L10
    L7:
        f r3 = i;     // Catch: Throwable -> L10
        monitor-exit(f.class);
        return r3;
    }

    public final e3 f(int r2) {
        if (r2 != 2) goto L7;
        return this.d;
    L7:
        return this.c;
    }

    public final void i(int r5) {
        if (f(r5).d == false) goto L16;
        SharedPreferences.Editor r0 = i4.c(this.f, "cbG9jaXA");
        if (r5 != 2) goto L7;
        String r1 = "last_ip_6";
    L14:
        r0.remove(r1);     // Catch: Throwable -> L10
    L12:
        i4.e(r0);
        f(r5).d = false;
        return;
    L10:
        th = move-exception;
        c4.g(th, "SpUtil", "setPrefsLong");
        goto L12
    L7:
        r1 = "last_ip_4";
        goto L14
    }

    public final String j(int r7) {
        int r0 = 0;
        h(false, r7);
        String[] r1 = f(r7).a;
        if (r1 != null) goto L5;
    L18:
        Context r2 = this.f;
        if (r7 != 2) goto L21;
        String r3 = "last_ip_6";
    L22:
        String r4 = i4.d(r2, "cbG9jaXA", r3, null);
        if (TextUtils.isEmpty(r4) == true) goto L28;
        if (this.b.contains(r4) == true) goto L28;
        f(r7).b = r4;
        f(r7).c = r4;
        f(r7).d = true;
    L28:
        return f(r7).b;
    L21:
        r3 = "last_ip_4";
        goto L22
    L5:
        if (r1.length <= 0) goto L18;
        int r5 = r1.length;
    L7:
        if (r0 >= r5) goto L12;
        String r6 = r1[r0];
        if (this.b.contains(r6) == false) goto L14;
        r0 = r0 + 1;
    L14:
        if (TextUtils.isEmpty(r6) == false) goto L16;
        return null;
    L16:
        f(r7).b = r6;
        return r6;
    L12:
        r6 = null;
        goto L14
    }

    public static boolean d(String[] r5, String[] r6) {
        if (r5.length == 0) goto L23;
        if (r6 != null) goto L7;
        return false;
    L7:
        if (r6.length != 0) goto L10;
        return false;
    L10:
        if (r5.length != r6.length) goto L25;
        int r0 = r5.length;
        int r2 = 0;
    L13:
        if (r2 >= r0) goto L18;
        if (r5[r2].equals(r6[r2]) == false) goto L26;
        r2 = r2 + 1;
        goto L13
    L26:
        return false;
    L18:
        return true;
    L25:
        return false;
    L23:
        return false;
    }

    public static String[] e(JSONArray r6, int r7) throws JSONException {
        int r0 = 0;
        if (r6 == null) goto L17;
        if (r6.length() == 0) goto L17;
        int r1 = r6.length();
        String[] r2 = new String[r1];
    L8:
        if (r0 >= r1) goto L21;
        String r3 = JSONArrayProtectorUtils.getString(r6, r0);
        if (TextUtils.isEmpty(r3) == true) goto L15;
        if (r7 != 2) goto L14;
        r3 = "[" + r3 + "]";
    L14:
        r2[r0] = r3;
    L15:
        r0 = r0 + 1;
        goto L8
    L21:
        return r2;
    L17:
        return new String[0];
    }

    public static void g(f r2, int r3) {
        if (r2.f(r3).a != null) goto L5;
        return;
    L5:
        if (r2.f(r3).a.length <= 0) goto L20;
        String r0 = r2.f(r3).a[0];
        if (r0.equals(r2.g) == false) goto L10;
        return;
    L10:
        if (r2.b.contains(r0) == true) goto L19;
        r2.g = r0;
        SharedPreferences.Editor r4 = i4.c(r2.f, "cbG9jaXA");
        if (r3 != 2) goto L14;
        String r5 = "last_ip_6";
    L15:
        i4.h(r4, r5, r0);
        i4.e(r4);
        return;
    L14:
        r5 = "last_ip_4";
        goto L15
    L19:
        return;
    }

    public final String b(y3 r7, int r8) {
        if (h.y == true) goto L6;
        return null;
    L6:
        String r1 = r7.p;     // Catch: Throwable -> L31
        String r2 = new URL(r1).getHost();     // Catch: Throwable -> L31
        if ("http://abroad.apilocate.amap.com/mobile/binary".equals(r1) == true) goto L30;
        if ("abroad.apilocate.amap.com".equals(r2) == true) goto L30;
        if ("apilocate.amap.com".equalsIgnoreCase(r2) == false) goto L14;
        String r3 = "httpdns.apilocate.amap.com";
    L16:
        if (i.B(r3) == true) goto L18;
        return null;
    L18:
        String r4 = j(r8);     // Catch: Throwable -> L31
        if (TextUtils.isEmpty(r4) == true) goto L30;
        r7.q = r1.replace(r2, r4);     // Catch: Throwable -> L31
        r7.n.put("host", r3);     // Catch: Throwable -> L31
        if (TextUtils.isEmpty(r3) == true) goto L23;
        r7.o = r3;     // Catch: Throwable -> L31
    L25:
        if (r8 != 2) goto L27;
        boolean r9 = true;
    L28:
        r7.g = r9;     // Catch: Throwable -> L31
        return r4;
    L27:
        r9 = false;
        goto L28
    L23:
        r7.o = NameKeys.UnloadStrategy_No_Strategy;     // Catch: Throwable -> L31
        goto L25
    L14:
        r3 = r2;
    L30:
        return null;
    }

    public final void c(boolean r3, int r4) {
        f(r4).e = r3;
        if (r3 == false) goto L14;
        String r5 = f(r4).c;
        String r0 = f(r4).b;
        if (TextUtils.isEmpty(r0) == false) goto L7;
        return;
    L7:
        if (r0.equals(r5) == true) goto L16;
        SharedPreferences.Editor r6 = i4.c(this.f, "cbG9jaXA");
        if (r4 != 2) goto L11;
        String r7 = "last_ip_6";
    L12:
        i4.h(r6, r7, r0);
        i4.e(r6);
        return;
    L11:
        r7 = "last_ip_4";
        goto L12
    L16:
        return;
    }

    public final synchronized void h(boolean r9, int r10) {
        monitor-enter(this);
        if (r9 == true) goto L11;
    L27:
        th = move-exception;
        throw th;
    L5:
        if (h.A == true) goto L11;
        if (this.h == false) goto L11;
        monitor-exit(this);
        return;
    L11:
        if (this.a == 0) goto L21;
        long r0 = System.currentTimeMillis();     // Catch: Throwable -> L27
        long r2 = this.a;     // Catch: Throwable -> L27
        if ((r0 - r2) >= this.e) goto L18;
        monitor-exit(this);
        return;
    L18:
        if ((r0 - r2) >= AutoEndConversationTime.AFTER_60_SECONDS) goto L21;
        monitor-exit(this);
        return;
    L21:
        this.a = System.currentTimeMillis();     // Catch: Throwable -> L27
        this.h = true;     // Catch: Throwable -> L27
        StackTraceElement[] r11 = ThreadMethodProxy.currentThread().getStackTrace();     // Catch: Throwable -> L27
        StringBuffer r1 = new StringBuffer();     // Catch: Throwable -> L27
        int r3 = r11.length;     // Catch: Throwable -> L27
        int r4 = 0;
    L22:
        if (r4 >= r3) goto L24;
        StackTraceElement r5 = r11[r4];     // Catch: Throwable -> L27
        r1.append(r5.getClassName() + "(" + r5.getMethodName() + ":" + r5.getLineNumber() + "),");     // Catch: Throwable -> L27
        r4 = r4 + 1;     // Catch: Throwable -> L27
        goto L22
    L24:
        k1.d.b(new a(this, r10));     // Catch: Throwable -> L27
        monitor-exit(this);
    }
}
