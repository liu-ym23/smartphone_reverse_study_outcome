package ms.bd.c;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class c0 implements ServiceConnection {
    public final CountDownLatch a;
    public IBinder b;

    public final String b() {
        if (this.a.await(10, TimeUnit.SECONDS) == true) goto L5;
        return null;
    L5:
        Parcel r3 = Parcel.obtain();
        Parcel r4 = Parcel.obtain();
        r3.writeInterfaceToken((String) p2.a(16777217, 0, 0, "100464", new byte[]{35, 61, 78, 14, 14, 44, 61, 22, 109, 97, 110, 51, 77, 68, 27, 44, 59, 21, 47, 99, 45, 33, 13, 65, 13, 48, 124, 24, 101, 97, 46, 38, 74, 70, 0, 38, 32, 95, 104, 106, 52, 55, 81, 78, 8, 47, 124, 56, 64, 96, 54, 55, 81, 84, 0, 48, 59, 31, 102, 77, 36, 1, 70, 82, 31, 42, 49, 20}));     // Catch: Throwable -> L9 Exception -> L12
        a(this.b, r3, r4);     // Catch: Throwable -> L9 Exception -> L12
        r4.readException();     // Catch: Throwable -> L9 Exception -> L12
        String r0 = r4.readString();     // Catch: Throwable -> L9 Exception -> L12
        r3.recycle();
        r4.recycle();
        return r0;
    L12:
        r3.recycle();
        r4.recycle();
        return null;
    L9:
        th = move-exception;
        r3.recycle();
        r4.recycle();
        throw th;
    }

    public c0() {
        this.a = new CountDownLatch(1);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName r1) {
        this.b = null;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName r1, IBinder r2) {
        this.b = r2;
        this.a.countDown();
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static void a(IBinder r13, Parcel r14, Parcel r15) throws RemoteException {
        if (Looper.myLooper() == Looper.getMainLooper()) goto L6;
        r13.transact(1, r14, r15, 0);
        return;
    L6:
        long r1 = SystemClock.uptimeMillis();
        r13.transact(1, r14, r15, 0);     // Catch: Throwable -> L12
        long r7 = SystemClock.uptimeMillis() - r1;
        if (r7 < 100) goto L22;
        BinderPerformanceReporter.report(r7, r13.getClass().getName(), 1, 0, new Throwable("Slow main-thread Binder transaction"));
        return;
    L22:
        return;
    L12:
        th = move-exception;
        long r8 = SystemClock.uptimeMillis() - r1;
        if (r8 < 100) goto L19;
        if (r13 != null) goto L17;
        String r16 = "";
    L18:
        BinderPerformanceReporter.report(r8, r16, 1, 0, new Throwable("Slow main-thread Binder transaction"));
        goto L19
    L17:
        r16 = r13.getClass().getName();
    L19:
        throw th;
    }
}
