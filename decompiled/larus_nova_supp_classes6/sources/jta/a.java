package jta;

import android.accounts.Account;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import java.util.Iterator;
import java.util.UUID;
import nta.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public abstract class a implements mta.a {
    public static String e;
    public static String f;
    public static volatile String g;
    public final Context a;
    public final nta.e b;
    public final b c;
    public final String d;

    public final String c() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (StringUtils.isEmpty(g) == true) goto L8;
        String r0 = g;     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        return r0;
    L8:
        g = this.b.d("", "");     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        return g;
    }

    public final String b() {
        if (TextUtils.isEmpty(f) == false) goto L5;
        SharedPreferences r1 = this.a.getSharedPreferences(kta.b.a(), 0);     // Catch: Exception -> L14
        String r2 = r1.getString("clientudid", null);     // Catch: Exception -> L14
        if (pta.b.b(r2) == true) goto L10;
        r2 = UUID.randomUUID().toString();     // Catch: Exception -> L14
        SharedPreferences.Editor r3 = r1.edit();     // Catch: Exception -> L14
        r3.putString("clientudid", r2);     // Catch: Exception -> L14
        r3.commit();     // Catch: Exception -> L14
    L10:
        if (StringUtils.isEmpty(r2) == true) goto L12;
        r2 = r2 + this.d;     // Catch: Exception -> L14
    L12:
        f = r2;     // Catch: Exception -> L14
        return r2;
    L14:
        e = move-exception;
        ita.j.g("DeviceParamsProvider exception when making client_udid: ", e);
        return "";
    L5:
        return f;
    }

    public final void a(String r3) {
        if (TextUtils.equals(r3, "device_id") == false) goto L6;
        g = null;
    L6:
        if (TextUtils.equals(r3, "openudid") == false) goto L9;
        e = null;
    L9:
        if (TextUtils.equals(r3, "clientudid") == false) goto L11;
        f = null;
    L11:
        this.b.b(r3);
    }

    public final void d(Account r7) {
        b r0 = this.c;
        if (r7 == null) goto L24;
        monitor-enter(r0);
        r0.c = r7;     // Catch: Throwable -> L21
        if (r0.d.size() > 0) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L21
        return;
    L10:
        if (r0.e == null) goto L19;
        Iterator<String> r1 = r0.e.iterator();     // Catch: Throwable -> L21
    L13:
        if (r1.hasNext() == false) goto L19;
        String r2 = r1.next();     // Catch: Throwable -> L21
        r0.b.setUserData(r0.c, r2, null);     // Catch: Exception -> L17 Throwable -> L21
    L17:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L21
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L21
        ThreadPlus.submitRunnable(new nta.a(r0, r7));
        return;
    L21:
        th = move-exception;
        throw th;
    L24:
        r0.getClass();
    }

    public a(Context r6, boolean r7) {
        if (r7 == false) goto L5;
        String r8 = "_local";
    L6:
        this.d = r8;
        Context r9 = r6.getApplicationContext();
        this.a = r9;
        d r0 = new d(r6, kta.b.c);
        nta.e r1 = new nta.e(r9);
        this.b = r1;
        b r2 = new b(r9);
        this.c = r2;
        r1.a = r2;
        pta.d.a r10 = pta.d.a;
        int r11 = Build.VERSION.SDK_INT;
        boolean r3 = false;
        if (r11 < 30) goto L9;
    L14:
        boolean r12 = true;
    L15:
        if (r12 == true) goto L17;
    L20:
        g r13 = g.a;
    L21:
        g r14 = g.a;
        c r15 = new c(r0);
        TTExecutors.getIOThreadPool().submit(r15);
        return;
    L17:
        if (r6.getApplicationInfo().targetSdkVersion < 30) goto L19;
        r3 = true;
    L19:
        if (r3 == true) goto L21;
    L9:
        if (r11 == 29) goto L11;
    L13:
        r12 = false;
        goto L15
    L11:
        if (Build.VERSION.PREVIEW_SDK_INT <= 0) goto L13;
    L5:
        r8 = "";
        goto L6
    }
}
