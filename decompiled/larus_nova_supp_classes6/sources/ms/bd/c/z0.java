package ms.bd.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class z0 implements IInterface {
    public final IBinder a;

    public final String a() {
        Parcel r1 = Parcel.obtain();
        Parcel r2 = Parcel.obtain();
        r1.writeInterfaceToken((String) p2.a(16777217, 0, 0, "7b5de8", new byte[]{37, 111, 75, 94, 79, 32, 48, 74, 119, 122, 41, 112, 67, 30, 94, 42, 34, 74, 103, 49, 104, 97, 79, 20, 86, 97, 27, 83, 97, 58, 2, 101, 80, 25, 89, 42, 29, 71, 97, 58, 50, 105, 64, 25, 95, 61, 7, 70, 118, 34, 47, 99, 67}));     // Catch: Throwable -> L9
        INVOKEINTERFACE_ms_bd_c_z0_com_obric_assistant_interaction_impl_BinderLancet_transact(this.a, 1, r1, r2, 0);     // Catch: Throwable -> L7
        r2.readException();     // Catch: Throwable -> L7
        String r0 = r2.readString();     // Catch: Throwable -> L7
    L12:
        r1.recycle();
        r2.recycle();
        return r0;
    L7:
        th = th;
    L11:
        r1.recycle();
        r2.recycle();
        th.printStackTrace();
        r0 = null;
    L9:
        th = th;
        goto L11
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.a;
    }

    public z0(IBinder r1) {
        this.a = r1;
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean INVOKEINTERFACE_ms_bd_c_z0_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        long r2 = SystemClock.uptimeMillis();
        boolean r0 = r15.transact(r16, r17, r18, r19);     // Catch: Throwable -> L12
        long r8 = SystemClock.uptimeMillis() - r2;
        if (r8 < 100) goto L11;
        BinderPerformanceReporter.report(r8, r15.getClass().getName(), r16, r19, new Throwable("Slow main-thread Binder transaction"));
    L11:
        return r0;
    L12:
        th = move-exception;
        long r9 = SystemClock.uptimeMillis() - r2;
        if (r9 < 100) goto L22;
        if (r15 != null) goto L17;
        String r1 = "";
    L18:
        BinderPerformanceReporter.report(r9, r1, r16, r19, new Throwable("Slow main-thread Binder transaction"));
        throw th;
    L17:
        r1 = r15.getClass().getName();
        goto L18
    L22:
        throw th;
    L5:
        return r15.transact(r16, r17, r18, r19);
    }
}
