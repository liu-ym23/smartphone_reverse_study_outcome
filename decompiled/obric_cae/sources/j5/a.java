package j5;

import android.accounts.Account;
import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.text.TextUtils;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.UUID;
import x4.t;
import x4.x0;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements i5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f8639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f8640b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n f8641c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f8642d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f8643e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f8644f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile String f8645g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f8646h;

    public a(Context r8, o r10) {
        if (r10.f8682c == false) goto L5;
        String r11 = "_local";
    L6:
        this.f8646h = r11;
        Context r12 = r8.getApplicationContext();
        this.f8639a = r12;
        this.f8640b = r10;
        n r13 = new n(r12, r10.f8681b, r10.f8687h);
        this.f8641c = r13;
        boolean r14 = false;
        if (k5.a.a(r8, r10.f8687h).getBoolean("is_migrate", false) == true) goto L15;
        c r15 = new c(r8, r10.f8685f, r10.f8687h);
        this.f8642d = r15;
        r13.f8658a = r15;
        k5.j.a r16 = k5.j.f8942a;
        if (r8.getApplicationInfo().targetSdkVersion < 30) goto L11;
        r14 = true;
    L11:
        if (r14 == true) goto L15;
        if (r10.f8686g == false) goto L15;
        d(r10, r15);
    L15:
        Account r17 = r10.f8684e;
        c r18 = this.f8642d;
        if (r18 == null) goto L24;
        String r19 = r10.f8687h.a();
        if (r17 == null) goto L25;
        r18.f8651d = r17;
        if (r18.f8652e.size() <= 0) goto L26;
        t.f(new b(r18, r17), r19);
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L5:
        r11 = "";
        goto L6
    }

    @Override // i5.a
    public final void a(String r8) {
        if (x0.b(r8) == true) goto L5;
        return;
    L5:
        if (x0.e(r8, this.f8645g) == true) goto L10;
        this.f8645g = this.f8641c.a(r8, this.f8645g);
        return;
    }

    @Override // i5.a
    public String b() {
        if (TextUtils.isEmpty(this.f8644f) == false) goto L5;
        SharedPreferences r8 = k5.a.a(this.f8639a, this.f8640b.f8687h);     // Catch: Exception -> L14
        String r10 = r8.getString("clientudid", null);     // Catch: Exception -> L14
        if (x0.g(r10) == true) goto L10;
        r10 = UUID.randomUUID().toString();     // Catch: Exception -> L14
        SharedPreferences.Editor r11 = r8.edit();     // Catch: Exception -> L14
        r11.putString("clientudid", r10);     // Catch: Exception -> L14
        r11.apply();     // Catch: Exception -> L14
    L10:
        if (TextUtils.isEmpty(r10) == true) goto L12;
        r10 = r10 + this.f8646h;     // Catch: Exception -> L14
    L12:
        this.f8644f = r10;     // Catch: Exception -> L14
        return r10;
    L14:
        e = move-exception;
        e.printStackTrace();
        return "";
    L5:
        return this.f8644f;
    }

    public void d(o r8, c r10) {
    }

    @Override // i5.a
    public final String getDeviceId() {
        if (TextUtils.isEmpty(this.f8645g) == false) goto L5;
        this.f8645g = this.f8641c.a("", "");
        return this.f8645g;
    L5:
        return this.f8645g;
    }

    @Override // i5.a
    public String getOpenUdid() {
        if (TextUtils.isEmpty(this.f8643e) == false) goto L5;
        Context r8 = this.f8639a;
        String r10 = Settings.Secure.getString(r8.getContentResolver(), "android_id");     // Catch: Exception -> L9
    L11:
        SharedPreferences r11 = k5.a.a(r8, this.f8640b.f8687h);
        String r12 = r11.getString("openudid", null);
        if (x0.g(r10) == false) goto L17;
        if ("9774d56d682e549c".equals(r10) == false) goto L29;
    L17:
        if (x0.g(r12) == true) goto L28;
        r12 = new BigInteger(80, new SecureRandom()).toString(16);     // Catch: Exception -> L36
        if (r12.charAt(0) != '-') goto L21;
        r12 = r12.substring(1);     // Catch: Exception -> L36
    L21:
        int r13 = 13 - r12.length();     // Catch: Exception -> L36
        if (r13 <= 0) goto L28;
        StringBuilder r14 = new StringBuilder();     // Catch: Exception -> L36
    L24:
        if (r13 <= 0) goto L26;
        r14.append('F');     // Catch: Exception -> L36
        r13 = r13 - 1;     // Catch: Exception -> L36
        goto L24
    L26:
        r14.append(r12);     // Catch: Exception -> L36
        r10 = r14.toString();     // Catch: Exception -> L36
    L28:
        r10 = r12;
    L29:
        SharedPreferences.Editor r15 = r11.edit();
        r15.putString("openudid", r10);
        r15.apply();
        if (TextUtils.isEmpty(r10) == true) goto L33;
        StringBuilder r16 = android.aimedia.a.j(r10);
        r16.append(this.f8646h);
        r10 = r16.toString();
    L33:
        if (TextUtils.isEmpty(r10) == true) goto L35;
        this.f8643e = r10;
    L35:
        return r10;
    L9:
        e = move-exception;
        e.printStackTrace();
        r10 = null;
        goto L11
    L5:
        return this.f8643e;
    }
}
