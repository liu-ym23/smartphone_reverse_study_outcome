package e84;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class u<SERVICE, RESULT> {
    public final CountDownLatch a;
    public final Intent b;
    public final b<SERVICE, RESULT> c;
    public final Context d;

    public class a implements ServiceConnection {
        public final CountDownLatch a;
        public final b<SERVICE, RESULT> b;
        public SERVICE c;

        @Override // android.content.ServiceConnection
        public final void onBindingDied(ComponentName r1) {
        }

        @Override // android.content.ServiceConnection
        public final void onNullBinding(ComponentName r1) {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r3) {
            com.bytedance.bdinstall.t.a("Oaid#ServiceBlockBinder#onServiceDisconnected" + r3);
            this.a.countDown();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            e.printStackTrace();
        }

        public a(CountDownLatch r1, b r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r4, IBinder r5) {
            com.bytedance.bdinstall.t.a("Oaid#ServiceBlockBinder#onServiceConnected " + r4);
            this.c = this.b.b(r5);     // Catch: Throwable -> L8
            this.a.countDown();     // Catch: Exception -> L6
        L24:
            return;
        L8:
            th = move-exception;
            th.printStackTrace();     // Catch: Throwable -> L12
            com.bytedance.bdinstall.t.a("Oaid#ServiceBlockBinder#onServiceConnected #Throwable " + th);     // Catch: Throwable -> L12
            this.a.countDown();     // Catch: Exception -> L6
        L12:
            th = move-exception;
            this.a.countDown();     // Catch: Exception -> L15
        L17:
            throw th;
        L15:
            e = move-exception;
            e.printStackTrace();
        L6:
            e = move-exception;
            e.printStackTrace();
        }
    }

    public interface b<T, RESULT> {
        RESULT a(T r1) throws Exception;

        T b(IBinder r1);
    }

    public final RESULT a() {
        a r1 = new a(this.a, this.c);     // Catch: Throwable -> L14
        if (this.d.bindService(this.b, r1, 1) == false) goto L22;
        this.a.await();     // Catch: Throwable -> L14
        RESULT r0 = this.c.a(r1.c);     // Catch: Throwable -> L12
        this.d.unbindService(r1);     // Catch: Throwable -> L9
    L11:
        return r0;
    L9:
        th = move-exception;
        th.printStackTrace();
    L12:
        Throwable th = th;
    L30:
        th.printStackTrace();     // Catch: Throwable -> L23
        if (r1 == null) goto L22;
        this.d.unbindService(r1);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        th.printStackTrace();
    L23:
        th = move-exception;
        if (r1 != null) goto L34;
    L29:
        throw th;
    L34:
        this.d.unbindService(r1);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        th.printStackTrace();
    L22:
        return null;
    L14:
        th = move-exception;
        th = th;
        r1 = null;
        goto L30
    }

    public u(Context r1, Intent r2, b<SERVICE, RESULT> r3) {
        this.d = r1;
        this.b = r2;
        this.c = r3;
        this.a = new CountDownLatch(1);
    }
}
