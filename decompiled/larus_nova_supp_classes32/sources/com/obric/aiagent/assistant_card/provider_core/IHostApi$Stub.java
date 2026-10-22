package com.obric.aiagent.assistant_card.provider_core;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class IHostApi$Stub extends Binder implements IHostApi {
    private static final String DESCRIPTOR = "com.obric.aiagent.assistant_card.provider_core.IHostApi";
    static final int TRANSACTION_callMethod = 2;
    static final int TRANSACTION_notifyCardChanged = 1;

    public static class Proxy implements IHostApi {
        public static IHostApi sDefaultImpl;
        private IBinder mRemote;

        public String getInterfaceDescriptor() {
            return IHostApi$Stub.DESCRIPTOR;
        }

        public IBinder asBinder() {
            return this.mRemote;
        }

        public Proxy(IBinder r1) {
            this.mRemote = r1;
        }

        public void notifyCardChanged(Bundle r6) throws RemoteException {
            Parcel r0 = Parcel.obtain();
            Parcel r1 = Parcel.obtain();
            r0.writeInterfaceToken(IHostApi$Stub.DESCRIPTOR);     // Catch: Throwable -> L17
            if (r6 == null) goto L6;
            r0.writeInt(1);     // Catch: Throwable -> L17
            r6.writeToParcel(r0, 0);     // Catch: Throwable -> L17
        L8:
            if (INVOKEINTERFACE_com_obric_aiagent_assistant_card_provider_core_IHostApi$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, r1, 0) == false) goto L10;
        L14:
            r1.readException();     // Catch: Throwable -> L17
            r1.recycle();
            r0.recycle();
            return;
        L10:
            if (IHostApi$Stub.getDefaultImpl() == null) goto L14;
            IHostApi$Stub.getDefaultImpl().notifyCardChanged(r6);     // Catch: Throwable -> L17
            r1.recycle();
            r0.recycle();
            return;
        L6:
            r0.writeInt(0);     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            r1.recycle();
            r0.recycle();
            throw th;
        }

        public void callMethod(String r6, Bundle r7) throws RemoteException {
            Parcel r0 = Parcel.obtain();
            Parcel r1 = Parcel.obtain();
            r0.writeInterfaceToken(IHostApi$Stub.DESCRIPTOR);     // Catch: Throwable -> L17
            r0.writeString(r6);     // Catch: Throwable -> L17
            if (r7 == null) goto L6;
            r0.writeInt(1);     // Catch: Throwable -> L17
            r7.writeToParcel(r0, 0);     // Catch: Throwable -> L17
        L8:
            if (INVOKEINTERFACE_com_obric_aiagent_assistant_card_provider_core_IHostApi$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, r1, 0) == false) goto L10;
        L14:
            r1.readException();     // Catch: Throwable -> L17
            r1.recycle();
            r0.recycle();
            return;
        L10:
            if (IHostApi$Stub.getDefaultImpl() == null) goto L14;
            IHostApi$Stub.getDefaultImpl().callMethod(r6, r7);     // Catch: Throwable -> L17
            r1.recycle();
            r0.recycle();
            return;
        L6:
            r0.writeInt(0);     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            r1.recycle();
            r0.recycle();
            throw th;
        }

        @Skip({"com.obric.assistant.interaction.impl.performance"})
        public static boolean INVOKEINTERFACE_com_obric_aiagent_assistant_card_provider_core_IHostApi$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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
            String r1 = NameKeys.UnloadStrategy_No_Strategy;
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
    public IHostApi$Stub() {
        attachInterface(this, DESCRIPTOR);
    }

    public static IHostApi getDefaultImpl() {
        return Proxy.sDefaultImpl;
    }

    public static IHostApi asInterface(IBinder r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        IHostApi r0 = r2.queryLocalInterface(DESCRIPTOR);
        if (r0 == null) goto L12;
        if ((r0 instanceof IHostApi) == false) goto L12;
        return r0;
    L12:
        return new Proxy(r2);
    }

    public static boolean setDefaultImpl(IHostApi r1) {
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
    public boolean onTransact(int r5, Parcel r6, Parcel r7, int r8) throws RemoteException {
        Bundle r0 = null;
        if (r5 != 1) goto L5;
        r6.enforceInterface(DESCRIPTOR);
        if (r6.readInt() == 0) goto L20;
        r0 = (Bundle) Bundle.CREATOR.createFromParcel(r6);
    L20:
        notifyCardChanged(r0);
        r7.writeNoException();
        return true;
    L5:
        if (r5 != 2) goto L7;
        r6.enforceInterface(DESCRIPTOR);
        String r9 = r6.readString();
        if (r6.readInt() == 0) goto L15;
        r0 = (Bundle) Bundle.CREATOR.createFromParcel(r6);
    L15:
        callMethod(r9, r0);
        r7.writeNoException();
        return true;
    L7:
        if (r5 != 1598968902) goto L9;
        r7.writeString(DESCRIPTOR);
        return true;
    L9:
        return super.onTransact(r5, r6, r7, r8);
    }
}
