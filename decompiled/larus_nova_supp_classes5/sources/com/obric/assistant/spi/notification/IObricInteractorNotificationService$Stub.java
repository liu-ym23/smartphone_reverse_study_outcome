package com.obric.assistant.spi.notification;

import android.os.Binder;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class IObricInteractorNotificationService$Stub extends Binder implements IObricInteractorNotificationService {
    private static final String DESCRIPTOR = "com.obric.assistant.spi.notification.IObricInteractorNotificationService";
    static final int TRANSACTION_registerCallback = 1;
    static final int TRANSACTION_unregisterCallback = 2;

    public static class Proxy implements IObricInteractorNotificationService {
        public static IObricInteractorNotificationService sDefaultImpl;
        private IBinder mRemote;

        public String getInterfaceDescriptor() {
            return IObricInteractorNotificationService$Stub.DESCRIPTOR;
        }

        public IBinder asBinder() {
            return this.mRemote;
        }

        public Proxy(IBinder r1) {
            this.mRemote = r1;
        }

        public void registerCallback(IObricInteractorNotificationCallback r6) throws RemoteException {
            Parcel r0 = Parcel.obtain();
            Parcel r1 = Parcel.obtain();
            r0.writeInterfaceToken(IObricInteractorNotificationService$Stub.DESCRIPTOR);     // Catch: Throwable -> L17
            if (r6 == null) goto L6;
            IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
        L7:
            r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
            if (INVOKEINTERFACE_com_obric_assistant_spi_notification_IObricInteractorNotificationService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, r1, 0) == false) goto L10;
        L14:
            r1.readException();     // Catch: Throwable -> L17
            r1.recycle();
            r0.recycle();
            return;
        L10:
            if (IObricInteractorNotificationService$Stub.getDefaultImpl() == null) goto L14;
            IObricInteractorNotificationService$Stub.getDefaultImpl().registerCallback(r6);     // Catch: Throwable -> L17
            r1.recycle();
            r0.recycle();
            return;
        L6:
            r2 = null;
        L17:
            th = move-exception;
            r1.recycle();
            r0.recycle();
            throw th;
        }

        public void unregisterCallback(IObricInteractorNotificationCallback r6) throws RemoteException {
            Parcel r0 = Parcel.obtain();
            Parcel r1 = Parcel.obtain();
            r0.writeInterfaceToken(IObricInteractorNotificationService$Stub.DESCRIPTOR);     // Catch: Throwable -> L17
            if (r6 == null) goto L6;
            IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
        L7:
            r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
            if (INVOKEINTERFACE_com_obric_assistant_spi_notification_IObricInteractorNotificationService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, r1, 0) == false) goto L10;
        L14:
            r1.readException();     // Catch: Throwable -> L17
            r1.recycle();
            r0.recycle();
            return;
        L10:
            if (IObricInteractorNotificationService$Stub.getDefaultImpl() == null) goto L14;
            IObricInteractorNotificationService$Stub.getDefaultImpl().unregisterCallback(r6);     // Catch: Throwable -> L17
            r1.recycle();
            r0.recycle();
            return;
        L6:
            r2 = null;
        L17:
            th = move-exception;
            r1.recycle();
            r0.recycle();
            throw th;
        }

        @Skip({"com.obric.assistant.interaction.impl.performance"})
        public static boolean INVOKEINTERFACE_com_obric_assistant_spi_notification_IObricInteractorNotificationService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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

    public IBinder asBinder() {
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public IObricInteractorNotificationService$Stub() {
        attachInterface(this, DESCRIPTOR);
    }

    public static IObricInteractorNotificationService getDefaultImpl() {
        return Proxy.sDefaultImpl;
    }

    public static IObricInteractorNotificationService asInterface(IBinder r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        IObricInteractorNotificationService r0 = r2.queryLocalInterface(DESCRIPTOR);
        if (r0 == null) goto L12;
        if ((r0 instanceof IObricInteractorNotificationService) == false) goto L12;
        return r0;
    L12:
        return new Proxy(r2);
    }

    public static boolean setDefaultImpl(IObricInteractorNotificationService r1) {
        if (Proxy.sDefaultImpl != null) goto L10;
        if (r1 == null) goto L7;
        Proxy.sDefaultImpl = r1;
        return true;
    L7:
        return false;
    L10:
        throw new IllegalStateException("setDefaultImpl() called twice");
    }

    @Override // android.os.Binder
    public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
        if (r4 != 1) goto L5;
        r5.enforceInterface(DESCRIPTOR);
        registerCallback(IObricInteractorNotificationCallback$Stub.asInterface(r5.readStrongBinder()));
        r6.writeNoException();
        return true;
    L5:
        if (r4 != 2) goto L7;
        r5.enforceInterface(DESCRIPTOR);
        unregisterCallback(IObricInteractorNotificationCallback$Stub.asInterface(r5.readStrongBinder()));
        r6.writeNoException();
        return true;
    L7:
        if (r4 != 1598968902) goto L9;
        r6.writeString(DESCRIPTOR);
        return true;
    L9:
        return super.onTransact(r4, r5, r6, r7);
    }
}
