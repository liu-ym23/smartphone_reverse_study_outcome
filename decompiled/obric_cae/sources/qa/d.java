package qa;

import android.content.SharedPreferences;
import android.provider.Settings;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class d extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f10291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f10292b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ e f10293m;

    public d(e r8, String r10, int r11) {
        this.f10293m = r8;
        this.f10291a = r10;
        this.f10292b = r11;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        String r8 = defpackage.c.i(i.b(this.f10291a.getBytes("UTF-8")));     // Catch: Throwable -> L5
    L7:
        if (TextUtils.isEmpty(r8) == true) goto L25;
        int r10 = this.f10292b;
        int r11 = r10 & 1;
        e r12 = this.f10293m;
        if (r11 <= 0) goto L14;
        if (Settings.System.canWrite(r12.f10337b) == false) goto L14;
        Settings.System.putString(r12.f10337b.getContentResolver(), r12.f10336a, r8);     // Catch: Exception -> L20
    L14:
        if ((r10 & 16) <= 0) goto L17;
        f.a(r12.f10337b, r12.f10336a, r8);
    L17:
        if ((r10 & 256) <= 0) goto L26;
        SharedPreferences.Editor r13 = r12.f10337b.getSharedPreferences(e.f10334c, 0).edit();
        r13.putString(r12.f10336a, r8);
        r13.apply();
        return;
    L26:
        return;
    L25:
        return;
    L5:
        r8 = null;
        goto L7
    }
}
