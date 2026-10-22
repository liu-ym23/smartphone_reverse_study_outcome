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
public final class k1 implements IInterface {
    public final IBinder a;

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return null;
    }

    public final String a() {
        Parcel r1 = Parcel.obtain();
        Parcel r2 = Parcel.obtain();
        r1.writeInterfaceToken((String) p2.a(16777217, 0, 0, "b19235", new byte[]{112, 60, 71, 8, 22, 55, 104, 94, 108, 103, 101, 58, 73, 67, 5, 38, 114, 21, 122, 116, 122, 48, 79, 8, 37, 6, 100, 6, 97, 97, 118, 58, 78, 111, 2, 54, 100, 2, 110, 99, 112, 54}));     // Catch: Throwable -> L10 Exception -> L12
    L21:
        INVOKEINTERFACE_ms_bd_c_k1_com_obric_assistant_interaction_impl_BinderLancet_transact(this.a, 1, r1, r2, 0);     // Catch: Exception -> L8 Throwable -> L17
        r2.readException();     // Catch: Exception -> L8 Throwable -> L17
        String r0 = r2.readString();     // Catch: Exception -> L8 Throwable -> L17
        r2.recycle();
        r1.recycle();
        return r0;
    L8:
        e = e;
    L14:
        e.printStackTrace();     // Catch: Throwable -> L17
        r2.recycle();
        r1.recycle();
        return null;
    L17:
        th = th;
    L18:
        r2.recycle();
        r1.recycle();
        throw th;
    L12:
        e = e;
    L10:
        th = th;
        goto L18
    }

    public k1(IBinder r1) {
        this.a = r1;
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean INVOKEINTERFACE_ms_bd_c_k1_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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
