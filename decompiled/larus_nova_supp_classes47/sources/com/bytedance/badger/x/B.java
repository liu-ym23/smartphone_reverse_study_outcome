package com.bytedance.badger.x;

import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.bytedance.badger.BadgerCore;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class B implements D {
    private IBinder a;

    public B(IBinder r1) {
        this.a = r1;
    }

    @Override // com.bytedance.badger.x.D
    public int a(int r5) {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken(a());     // Catch: Throwable -> L9
        r0.writeInt(r5);     // Catch: Throwable -> L9
        if (INVOKEINTERFACE_com_bytedance_badger_x_B_com_obric_assistant_interaction_impl_BinderLancet_transact(this.a, 7, r0, r1, 0) == true) goto L6;
        int r6 = C.a;     // Catch: Throwable -> L9
    L6:
        r1.readException();     // Catch: Throwable -> L9
        int r7 = r1.readInt();     // Catch: Throwable -> L9
        r1.recycle();
        r0.recycle();
        return r7;
    L9:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public String a() {
        BadgerCore.Companion.getClass();
        return com.bytedance.badger.j.b(2418618557650235769L);
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.a;
    }

    @Override // com.bytedance.badger.x.D
    public int b(int r5) {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken(a());     // Catch: Throwable -> L9
        r0.writeInt(r5);     // Catch: Throwable -> L9
        if (INVOKEINTERFACE_com_bytedance_badger_x_B_com_obric_assistant_interaction_impl_BinderLancet_transact(this.a, 1, r0, r1, 0) == true) goto L6;
        int r6 = C.a;     // Catch: Throwable -> L9
    L6:
        r1.readException();     // Catch: Throwable -> L9
        int r7 = r1.readInt();     // Catch: Throwable -> L9
        r1.recycle();
        r0.recycle();
        return r7;
    L9:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    @Override // com.bytedance.badger.x.D
    public boolean c(int r5) {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken(a());     // Catch: Throwable -> L11
        r0.writeInt(r5);     // Catch: Throwable -> L11
        boolean r3 = false;
        if (INVOKEINTERFACE_com_bytedance_badger_x_B_com_obric_assistant_interaction_impl_BinderLancet_transact(this.a, 3, r0, r1, 0) == true) goto L6;
        int r6 = C.a;     // Catch: Throwable -> L11
    L6:
        r1.readException();     // Catch: Throwable -> L11
        if (r1.readInt() == 0) goto L9;
        r3 = true;
    L9:
        r1.recycle();
        r0.recycle();
        return r3;
    L11:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    @Override // com.bytedance.badger.x.D
    public A d(int r5) {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken(a());     // Catch: Throwable -> L13
        r0.writeInt(r5);     // Catch: Throwable -> L13
        if (INVOKEINTERFACE_com_bytedance_badger_x_B_com_obric_assistant_interaction_impl_BinderLancet_transact(this.a, 2, r0, r1, 0) == true) goto L6;
        int r6 = C.a;     // Catch: Throwable -> L13
    L6:
        r1.readException();     // Catch: Throwable -> L13
        if (r1.readInt() == 0) goto L10;
        A r7 = new A(r1);     // Catch: Throwable -> L13
    L11:
        r1.recycle();
        r0.recycle();
        return r7;
    L10:
        r7 = null;
    L13:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean INVOKEINTERFACE_com_bytedance_badger_x_B_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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
