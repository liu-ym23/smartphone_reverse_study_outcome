package j5;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import x4.j0;

/* JADX INFO: loaded from: classes.dex */
public final class c extends e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AccountManager f8649b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f8650c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Account f8651d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConcurrentHashMap<String, String> f8652e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final j0 f8653f;

    public c(Context r8, String r10, j0 r11) {
        this.f8652e = new ConcurrentHashMap();
        this.f8649b = AccountManager.get(r8);
        this.f8650c = r10;
        this.f8653f = r11;
    }

    @Override // j5.m
    @SuppressLint({"MissingPermission"})
    public final void b(String r8, String r10) {
        String r11 = i(r8);
        Account r12 = this.f8651d;
        if (r12 != null) goto L6;
        this.f8652e.put(r11, r10);
        return;
    L6:
        if (r10 != null) goto L13;
        return;
    L13:
        this.f8649b.setUserData(r12, r11, r10);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // j5.m
    @SuppressLint({"MissingPermission"})
    public final String c(String r8) {
        String r10 = i(r8);
        String r11 = this.f8652e.get(r10);
        if (TextUtils.isEmpty(r11) == true) goto L5;
        return r11;
    L5:
        Account r12 = this.f8651d;
        if (r12 != null) goto L13;
        return null;
    L13:
        return this.f8649b.getUserData(r12, r10);
    L10:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    @Override // j5.e
    public final void d(String[] r8) {
        if (r8 == null) goto L6;
        b("sim_serial_number", TextUtils.join("\n", r8));
        return;
    }

    @Override // j5.e
    @SuppressLint({"MissingPermission"})
    public final void e(List<String> r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        Iterator<String> r10 = r8.iterator();
    L6:
        if (r10.hasNext() == false) goto L14;
        String r11 = i(r10.next());
        this.f8652e.remove(r11);
        Account r12 = this.f8651d;     // Catch: Exception -> L16
        if (r12 == null) goto L6;
        AccountManager r13 = this.f8649b;     // Catch: Exception -> L16
        if (r13 == null) goto L6;
        r13.setUserData(r12, r11, null);     // Catch: Exception -> L16
        goto L6
    L14:
        super.e(r8);
    }

    @Override // j5.e
    public final String[] f() {
        String r8 = c("sim_serial_number");
        if (TextUtils.isEmpty(r8) == false) goto L7;
        return null;
    L7:
        return r8.split("\n");
    }

    public final String i(String r8) {
        StringBuffer r10 = new StringBuffer(r8);
        r10.append(this.f8650c);
        j0 r11 = this.f8653f;
        if (r11.J == true) goto L6;
        r10.append("_");
        r10.append(r11.a());
    L6:
        return r10.toString();
    }
}
