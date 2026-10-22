package ms.bd.c;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import java.util.concurrent.LinkedBlockingQueue;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class d1 {
    public final String a;
    public final Context b;
    public final LinkedBlockingQueue c;
    public final b1 d;

    public d1(Context r8) {
        this.a = (String) p2.a(16777217, 0, 0, "4a3723", new byte[]{42, 98, 127, 74, 9, 27, 49, 76, 99, 96});
        this.c = new LinkedBlockingQueue(1);
        this.d = new b1(this);
        this.b = r8;
    }

    public final void b(y2 r25) {
        if (z2.b(this.b, (String) p2.a(16777217, 0, 0, "4d227d", new byte[]{38, 105, 76, 8, 0, 122, 63, 74, 109, 109, 55, 40, 72, 66})) == true) goto L5;
        return;
    L5:
        Intent r0 = new Intent();
        r0.setAction((String) p2.a(16777217, 0, 0, "2cee9b", new byte[]{32, 110, 27, 95, 14, 124, 57, 77, 58, 58, 49, 47, 31, 21, 72, 93, 63, 109, 53, 28, 39, 82, 19, 3, 16, 124, 50, 71}));
        r0.setPackage((String) p2.a(16777217, 0, 0, "d4a8c6", new byte[]{118, 57, 31, 2, 84, 40, 111, 26, 62, 103, 103, 120, 27, 72}));
        if (this.b.bindService(r0, this.d, 1) == false) goto L32;
        IBinder r1 = (IBinder) this.c.take();     // Catch: Throwable -> L24 Exception -> L27
        if (r1 != null) goto L10;
        String r2 = f1.a;     // Catch: Throwable -> L24 Exception -> L27
        g1 r3 = null;
    L16:
        c1 r4 = new c1(this, r25);     // Catch: Throwable -> L24 Exception -> L27
        e1 r5 = (e1) r3;     // Catch: Throwable -> L24 Exception -> L27
        r5.getClass();     // Catch: Throwable -> L24 Exception -> L27
        Parcel r6 = Parcel.obtain();     // Catch: Throwable -> L24 Exception -> L27
        Parcel r7 = Parcel.obtain();     // Catch: Throwable -> L24 Exception -> L27
        r6.writeInterfaceToken((String) p2.a(16777217, 0, 0, "d8925d", new byte[]{118, 53, 71, 8, 2, 122, 111, 22, 102, 109, 103, 116, 73, 74, 5, 102, 99, 10, 109, 112, 99, 51, 73, 67, 68, 124, 102, 16, 108, 44, 92, 21, 107, 111, 46, 64, 98, 11, 126, 107, 118, 63}));     // Catch: Throwable -> L21
        r6.writeStrongBinder(r4);     // Catch: Throwable -> L21
        a(r5.a, r6, r7);     // Catch: Throwable -> L21
        r7.readException();     // Catch: Throwable -> L21
        r7.recycle();     // Catch: Throwable -> L24 Exception -> L27
        r6.recycle();     // Catch: Throwable -> L24 Exception -> L27
        this.b.unbindService(this.d);
        return;
    L21:
        th = move-exception;
        r7.recycle();     // Catch: Throwable -> L24 Exception -> L27
        r6.recycle();     // Catch: Throwable -> L24 Exception -> L27
        throw th;     // Catch: Throwable -> L24 Exception -> L27
    L10:
        e1 r8 = r1.queryLocalInterface(f1.a);     // Catch: Throwable -> L24 Exception -> L27
        if (r8 != null) goto L13;
    L15:
        r3 = new e1(r1);     // Catch: Throwable -> L24 Exception -> L27
        goto L16
    L13:
        if ((r8 instanceof g1) == false) goto L15;
        r3 = (g1) r8;     // Catch: Throwable -> L24 Exception -> L27
    L27:
        this.b.unbindService(this.d);
        return;
    L24:
        th = move-exception;
        this.b.unbindService(this.d);
        throw th;
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static void a(IBinder r13, Parcel r14, Parcel r15) throws RemoteException {
        if (Looper.myLooper() == Looper.getMainLooper()) goto L6;
        r13.transact(2, r14, r15, 0);
        return;
    L6:
        long r1 = SystemClock.uptimeMillis();
        r13.transact(2, r14, r15, 0);     // Catch: Throwable -> L12
        long r7 = SystemClock.uptimeMillis() - r1;
        if (r7 < 100) goto L22;
        BinderPerformanceReporter.report(r7, r13.getClass().getName(), 2, 0, new Throwable("Slow main-thread Binder transaction"));
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
        BinderPerformanceReporter.report(r8, r16, 2, 0, new Throwable("Slow main-thread Binder transaction"));
        goto L19
    L17:
        r16 = r13.getClass().getName();
    L19:
        throw th;
    }
}
