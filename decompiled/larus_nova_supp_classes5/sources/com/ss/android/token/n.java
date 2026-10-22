package com.ss.android.token;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.ss.android.account.k;
import java.net.URI;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.regex.Matcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class n {
    public final String a;
    public final Set<String> b;
    public volatile boolean c;
    public final Object d;
    public boolean e;
    public Context f;
    public long g;
    public e h;

    public final void a() {
        if (this.f != null) goto L5;
        this.f = k.c();
    L5:
        Context r0 = this.f;
        int r1 = 0;
        SharedPreferences r2 = null;
        if (r0 == null) goto L8;
        SharedPreferences r3 = r0.getSharedPreferences("com_ss_android_token_sp_host", 0);
    L10:
        if (r3 == null) goto L15;
        Set<String> r4 = r3.getStringSet("share_cookie_host_list", null);
        if (r4 == null) goto L15;
        ((CopyOnWriteArraySet) this.b).addAll(r4);
    L15:
        if (this.f != null) goto L17;
        this.f = k.c();
    L17:
        Context r5 = this.f;
        if (r5 == null) goto L20;
        r2 = r5.getSharedPreferences("ss_app_config", 0);
    L20:
        if (r2 == null) goto L38;
        String r6 = r2.getString("share_cookie_host_list", "");
        HashSet r7 = new HashSet();
        if (TextUtils.isEmpty(r6) == true) goto L37;
        String[] r8 = r6.split(",");
        if (r8.length <= 0) goto L37;
        int r9 = r8.length;
    L26:
        if (r1 >= r9) goto L37;
        String r10 = r8[r1];
        if (TextUtils.isEmpty(r10) == true) goto L36;
        if (r10.length() > 1) goto L33;
    L35:
        r7.add(r10);
        goto L36
    L33:
        if (r10.startsWith(".") == false) goto L35;
        r10 = r10.substring(1);
    L36:
        r1 = r1 + 1;
    L37:
        ((CopyOnWriteArraySet) this.b).addAll(r7);
    L38:
        d();
        return;
    L8:
        r3 = null;
        goto L10
    }

    public final Set<String> c() {
        if (this.c == true) goto L16;
        Object r0 = this.d;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (this.c == true) goto L9;
        a();     // Catch: Throwable -> L12
    L9:
        this.c = true;     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
    L16:
        return this.b;
    }

    public final void d() {
        if (this.f != null) goto L5;
        this.f = k.c();
    L5:
        Context r0 = this.f;
        if (r0 == null) goto L8;
        SharedPreferences r1 = r0.getSharedPreferences("com_ss_android_token_sp_host", 0);
    L9:
        if (r1 == null) goto L14;
        ((CopyOnWriteArraySet) this.b).remove(null);
        if ((!((CopyOnWriteArraySet) this.b).isEmpty()) == false) goto L15;
        r1.edit().putStringSet("share_cookie_host_list", this.b).apply();
        return;
    L15:
        return;
    L14:
        return;
    L8:
        r1 = null;
        goto L9
    }

    public n() {
        this.b = new CopyOnWriteArraySet();
        this.d = new Object();
        this.e = false;
        this.g = 600000;
        String r0 = "https://" + k.d().S();
        this.a = r0;
        String r1 = "";
        r1 = new URI(r0).getHost().toLowerCase();     // Catch: Exception -> L7
        Matcher r2 = PatternProtector.compile("[^\\.]+(\\.com|\\.net|\\.org|\\.cc|\\.me|\\.tel|\\.mobi|\\.asia|\\.biz|\\.info|\\.name|\\.tv|\\.app|\\.edu)").matcher(r1);     // Catch: Exception -> L7
        if (r2.find() == false) goto L23;
        String r3 = r2.group();     // Catch: Exception -> L7
    L20:
        if (r3 == null) goto L27;
        this.b.add(r3);
        return;
    L27:
        return;
    L23:
    L17:
        e = move-exception;
        TTTokenMonitor.d(e);
    L19:
        r3 = null;
        goto L20
    L10:
        if (TextUtils.isEmpty(r1) == true) goto L19;
        String[] r4 = r1.split("\\.");     // Catch: Exception -> L17
        if (r4 == null) goto L19;
        if (r4.length <= 1) goto L19;
        r3 = r4[r4.length - 2] + "." + r4[r4.length - 1];     // Catch: Exception -> L17
    L7:
        e = move-exception;
        TTTokenMonitor.d(e);
        goto L23
    }

    public final void b(Collection<String> r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.size() <= 0) goto L18;
        this.e = true;
        ((CopyOnWriteArraySet) this.b).addAll(r2);
        Object r3 = this.d;
        monitor-enter(r3);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (this.c == false) goto L10;
        d();     // Catch: Throwable -> L12
    L10:
        monitor-exit(r3);     // Catch: Throwable -> L12
        return;
    }
}
