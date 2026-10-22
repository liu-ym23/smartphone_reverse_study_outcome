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
public final class c implements IInterface {
    public final IBinder a;

    public final String a() {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken((String) p2.a(16777217, 0, 0, "79bfa5", new byte[]{37, 52, 28, 92, 95, 49, 33, 11, 125, 59, 53, 58, 95, 33, 75, 50, 36, 20, 54, 59, 35, 53, 5, 19, 76, 59, 16, 49, 23, 120, 15, 31, 24, 22, 127, 43, 48, 20, 26, 56, 50, 62, 3, 20, 95, 33, 49}));     // Catch: Throwable -> L7
        INVOKEINTERFACE_ms_bd_c_c_com_obric_assistant_interaction_impl_BinderLancet_transact(this.a, 3, r0, r1, 0);     // Catch: Throwable -> L11
        r1.readException();     // Catch: Throwable -> L11
        String r3 = r1.readString();     // Catch: Throwable -> L11
    L9:
        r0.recycle();
        r1.recycle();
        return r3;
    L8:
        r0.recycle();
        r1.recycle();
        r3 = null;
        goto L9
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.a;
    }

    public c(IBinder r1) {
        this.a = r1;
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean INVOKEINTERFACE_ms_bd_c_c_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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
