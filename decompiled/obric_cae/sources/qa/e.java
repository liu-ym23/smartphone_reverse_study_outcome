package qa;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f10334c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static e f10335d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f10336a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f10337b;

    public static final class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<e> f10338a;

        public a(Looper r8, e r10) {
            super(r8);
            this.f10338a = new WeakReference(r10);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r8) {
            e r10 = this.f10338a.get();
            if (r10 != null) goto L5;
            return;
        L5:
            if (r8 == null) goto L11;
            Object r11 = r8.obj;
            if (r11 == null) goto L12;
            int r12 = r8.what;
            r10.a(r12, (String) r11);
            return;
        L12:
            return;
        }

        public a(e r8) {
            this.f10338a = new WeakReference(r8);
        }
    }

    static {
        f10334c = t4.n("SU2hhcmVkUHJlZmVyZW5jZUFkaXU");
    }

    public e(Context r8) {
        this.f10337b = r8.getApplicationContext();
        if (Looper.myLooper() != null) goto L6;
        new a(Looper.getMainLooper(), this);
        return;
    L6:
        new a(this);
    }

    public final synchronized void a(int r8, String r10) {
        monitor-enter(this);
    L26:
        th = move-exception;
        throw th;
    L4:
        if (Looper.myLooper() != Looper.getMainLooper()) goto L31;
        new d(this, r10, r8).start();     // Catch: Throwable -> L26
        monitor-exit(this);
        return;
    L31:
        String r11 = defpackage.c.i(i.b(r10.getBytes("UTF-8")));     // Catch: Throwable -> L10
    L12:
        if (TextUtils.isEmpty(r11) == false) goto L14;
    L24:
        monitor-exit(this);
        return;
    L14:
        if ((r8 & 1) <= 0) goto L17;
        Settings.System.putString(this.f10337b.getContentResolver(), this.f10336a, r11);     // Catch: Exception -> L29 Throwable -> L26
    L17:
        if ((r8 & 16) <= 0) goto L20;
        f.a(this.f10337b, this.f10336a, r11);     // Catch: Throwable -> L26
    L20:
        if ((r8 & 256) <= 0) goto L24;
        SharedPreferences.Editor r12 = this.f10337b.getSharedPreferences(f10334c, 0).edit();     // Catch: Throwable -> L26
        r12.putString(this.f10336a, r11);     // Catch: Throwable -> L26
        r12.apply();     // Catch: Throwable -> L26
        monitor-exit(this);
        return;
    L10:
        r11 = null;
        goto L12
    }
}
