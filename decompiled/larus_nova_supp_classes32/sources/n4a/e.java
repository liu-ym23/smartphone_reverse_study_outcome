package n4a;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class e {
    public static final String c = null;
    public static e d;
    public String a;
    public final Context b;

    public class a extends PthreadThreadV2 {
        public final /* synthetic */ String v;
        public final /* synthetic */ int w;
        public final /* synthetic */ e x;

        public a(e r1, String r2, int r3) {
            this.x = r1;
            this.v = r2;
            this.w = r3;
            super("com/loc/ad$1");
        }

        public final void l() {
            String r0 = this.v;
            byte[] r1 = k.a;
            byte[] r2 = k.b(r0.getBytes("UTF-8"));     // Catch: Throwable -> L5
            byte[] r3 = f.a;     // Catch: Throwable -> L5
            String r4 = f.a(r2, r2.length);
        L7:
            if (TextUtils.isEmpty(r4) == false) goto L9;
            return;
        L9:
            if ((this.w & 1) <= 0) goto L21;
            if (Build.VERSION.SDK_INT >= 23) goto L13;
            ContentResolver r5 = this.x.b.getContentResolver();     // Catch: Exception -> L19
            e r6 = this.x;     // Catch: Exception -> L19
        L17:
            Settings.System.putString(r5, r6.a, r4);     // Catch: Exception -> L19
            goto L21
        L13:
            if (Settings.System.canWrite(this.x.b) == false) goto L21;
            r5 = this.x.b.getContentResolver();     // Catch: Exception -> L19
            r6 = this.x;     // Catch: Exception -> L19
        L21:
            if ((this.w & 16) <= 0) goto L24;
            e r7 = this.x;
            g.a(r7.b, r7.a, r4);
        L24:
            if ((this.w & 256) <= 0) goto L32;
            SharedPreferences.Editor r8 = this.x.b.getSharedPreferences(e.c, 0).edit();
            r8.putString(this.x.a, r4);
            r8.apply();
            return;
        L32:
            return;
        L5:
            r4 = null;
            goto L7
        }

        public final void run() {
            l();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b extends Handler {
        public final WeakReference<e> a;

        public b(Looper r1, e r2) {
            super(r1);
            this.a = new WeakReference(r2);
        }

        public b(e r2) {
            this.a = new WeakReference(r2);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r3) {
            e r0 = this.a.get();
            if (r0 != null) goto L5;
            return;
        L5:
            if (r3 == null) goto L11;
            Object r1 = r3.obj;
            if (r1 == null) goto L12;
            r0.b((String) r1, r3.what);
            return;
        L12:
            return;
        }
    }

    static {
        c = f5.o("SU2hhcmVkUHJlZmVyZW5jZUFkaXU");
    }

    public e(Context r2) {
        this.b = r2.getApplicationContext();
        if (Looper.myLooper() != null) goto L6;
        new b(Looper.getMainLooper(), this);
        return;
    L6:
        new b(this);
    }

    public static e a(Context r2) {
        if (d != null) goto L15;
        monitor-enter(e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (d != null) goto L9;
        d = new e(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
    L15:
        return d;
    }

    public final synchronized void b(String r3, int r4) {
        monitor-enter(this);
    L34:
        th = move-exception;
        throw th;
    L4:
        if (Looper.myLooper() != Looper.getMainLooper()) goto L8;
        ThreadMethodProxy.start(new a(this, r3, r4));     // Catch: Throwable -> L34
        monitor-exit(this);
        return;
    L8:
        byte[] r0 = k.a;     // Catch: Throwable -> L34
        byte[] r5 = k.b(r3.getBytes("UTF-8"));     // Catch: Throwable -> L11
        byte[] r1 = f.a;     // Catch: Throwable -> L11
        String r6 = f.a(r5, r5.length);
    L13:
        if (TextUtils.isEmpty(r6) == false) goto L15;
    L32:
        monitor-exit(this);
        return;
    L15:
        if ((r4 & 1) <= 0) goto L25;
        if (Build.VERSION.SDK_INT < 23) goto L20;
        ContentResolver r2 = this.b.getContentResolver();     // Catch: Exception -> L23 Throwable -> L34
    L21:
        Settings.System.putString(r2, this.a, r6);     // Catch: Exception -> L23 Throwable -> L34
        goto L25
    L20:
        r2 = this.b.getContentResolver();     // Catch: Exception -> L23 Throwable -> L34
    L25:
        if ((r4 & 16) <= 0) goto L28;
        g.a(this.b, this.a, r6);     // Catch: Throwable -> L34
    L28:
        if ((r4 & 256) <= 0) goto L32;
        SharedPreferences.Editor r7 = this.b.getSharedPreferences(c, 0).edit();     // Catch: Throwable -> L34
        r7.putString(this.a, r6);     // Catch: Throwable -> L34
        r7.apply();     // Catch: Throwable -> L34
        monitor-exit(this);
        return;
    L11:
        r6 = null;
        goto L13
    }
}
