package g5;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes.dex */
public final class t<SERVICE, RESULT> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CountDownLatch f7682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Intent f7683b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b<SERVICE, RESULT> f7684c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f7685d;

    public class a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CountDownLatch f7686a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b<SERVICE, RESULT> f7687b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public SERVICE f7688m;

        public a(CountDownLatch r8, b r10) {
            this.f7686a = r8;
            this.f7687b = r10;
        }

        @Override // android.content.ServiceConnection
        public final void onBindingDied(ComponentName r8) {
        }

        @Override // android.content.ServiceConnection
        public final void onNullBinding(ComponentName r8) {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r8, IBinder r10) {
            CountDownLatch r11 = this.f7686a;
            Objects.toString(r8);
            int r12 = x4.r.f13543a;
            this.f7688m = this.f7687b.a(r10);     // Catch: Throwable -> L8
            r11.countDown();     // Catch: Exception -> L6
        L24:
            return;
        L8:
            th = move-exception;
            th.printStackTrace();     // Catch: Throwable -> L12
            th.toString();     // Catch: Throwable -> L12
            int r13 = x4.r.f13543a;     // Catch: Throwable -> L12
            r11.countDown();     // Catch: Exception -> L6
        L12:
            th = move-exception;
            r11.countDown();     // Catch: Exception -> L15
        L17:
            throw th;
        L15:
            e = move-exception;
            e.printStackTrace();
        L6:
            e = move-exception;
            e.printStackTrace();
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r8) {
            Objects.toString(r8);
            int r10 = x4.r.f13543a;
            this.f7686a.countDown();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            e.printStackTrace();
        }
    }

    public interface b<T, RESULT> {
        T a(IBinder r8);

        RESULT b(T r8);
    }

    public t(Context r8, Intent r10, b<SERVICE, RESULT> r11) {
        this.f7685d = r8;
        this.f7683b = r10;
        this.f7684c = r11;
        this.f7682a = new CountDownLatch(1);
    }

    public final RESULT a() {
        Context r8 = this.f7685d;
        b<SERVICE, RESULT> r10 = this.f7684c;
    L16:
        th = th;
        a r11 = null;
    L40:
        th.printStackTrace();     // Catch: Throwable -> L25
        if (r11 != null) goto L36;
    L24:
        return null;
    L36:
        r8.unbindService(r11);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        th.printStackTrace();
    L25:
        th = move-exception;
        if (r11 != null) goto L32;
    L31:
        throw th;
    L32:
        r8.unbindService(r11);     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        th.printStackTrace();
        goto L31
    L4:
        CountDownLatch r12 = this.f7682a;
        r11 = new a(r12, r10);     // Catch: Throwable -> L16
        if (r8.bindService(this.f7683b, r11, 1) == false) goto L24;
        r12.await();     // Catch: Throwable -> L16
        RESULT r13 = r10.b(r11.f7688m);     // Catch: Throwable -> L14
        r8.unbindService(r11);     // Catch: Throwable -> L11
    L13:
        return r13;
    L11:
        th = move-exception;
        th.printStackTrace();
    L14:
        th = th;
        goto L40
    }
}
