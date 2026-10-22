package com.obric.capabilitykit.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public abstract class IGetRunningTaskCallback$Stub extends Binder implements IGetRunningTaskCallback {
    private static final String DESCRIPTOR = "com.obric.capabilitykit.common.IGetRunningTaskCallback";
    public static final int TRANSACTION_onResult = 1;

    public static class Proxy implements IGetRunningTaskCallback {
        public static IGetRunningTaskCallback sDefaultImpl;
        private IBinder mRemote;

        public Proxy(IBinder r1) {
            this.mRemote = r1;
        }

        public IBinder asBinder() {
            return this.mRemote;
        }

        public String getInterfaceDescriptor() {
            return IGetRunningTaskCallback$Stub.DESCRIPTOR;
        }

        public void onResult(String r6) throws RemoteException {
            Parcel r0 = Parcel.obtain();
            Parcel r1 = Parcel.obtain();
            r0.writeInterfaceToken(IGetRunningTaskCallback$Stub.DESCRIPTOR);     // Catch: Throwable -> L12
            r0.writeString(r6);     // Catch: Throwable -> L12
            if (INVOKEINTERFACE_com_obric_capabilitykit_common_IGetRunningTaskCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, r1, 0) == false) goto L6;
        L10:
            r1.readException();     // Catch: Throwable -> L12
        L8:
            r1.recycle();
            r0.recycle();
            return;
        L6:
            if (IGetRunningTaskCallback$Stub.getDefaultImpl() == null) goto L10;
            IGetRunningTaskCallback$Stub.getDefaultImpl().onResult(r6);     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            r1.recycle();
            r0.recycle();
            throw th;
        }

        @Skip({"com.obric.assistant.interaction.impl.performance"})
        public static boolean INVOKEINTERFACE_com_obric_capabilitykit_common_IGetRunningTaskCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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

    /* JADX WARN: Multi-variable type inference failed */
    public IGetRunningTaskCallback$Stub() {
        attachInterface(this, DESCRIPTOR);
    }

    public static IGetRunningTaskCallback asInterface(IBinder r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        IGetRunningTaskCallback r0 = r2.queryLocalInterface(DESCRIPTOR);
        if (r0 == null) goto L12;
        if ((r0 instanceof IGetRunningTaskCallback) == false) goto L12;
        return r0;
    L12:
        return new Proxy(r2);
    }

    public static IGetRunningTaskCallback getDefaultImpl() {
        return Proxy.sDefaultImpl;
    }

    public static boolean setDefaultImpl(IGetRunningTaskCallback r1) {
        if (Proxy.sDefaultImpl != null) goto L7;
        if (r1 == null) goto L9;
        Proxy.sDefaultImpl = r1;
        return true;
    L9:
        return false;
    L7:
        return false;
    }

    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
        if (r4 != 1) goto L5;
        r5.enforceInterface(DESCRIPTOR);
        onResult(r5.readString());
        r6.writeNoException();
        return true;
    L5:
        if (r4 != 1598968902) goto L7;
        r6.writeString(DESCRIPTOR);
        return true;
    L7:
        return super.onTransact(r4, r5, r6, r7);
    }
}
