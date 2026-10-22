package com.obric.assistant.dora;

import android.os.Binder;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class IDoraPrivateProtocolService$Stub extends Binder implements IDoraPrivateProtocolService {
    private static final String DESCRIPTOR = "com.obric.assistant.dora.IDoraPrivateProtocolService";
    static final int TRANSACTION_getConnectionState = 3;
    static final int TRANSACTION_getCurrentDeviceInfo = 4;
    static final int TRANSACTION_registerCallback = 1;
    static final int TRANSACTION_registerCallbackWithExtra = 8;
    static final int TRANSACTION_syncBatteryChanged = 6;
    static final int TRANSACTION_syncChargeStateChanged = 7;
    static final int TRANSACTION_syncConnectionState = 5;
    static final int TRANSACTION_unregisterCallback = 2;

    public static class Proxy implements IDoraPrivateProtocolService {
        public static IDoraPrivateProtocolService sDefaultImpl;
        private IBinder mRemote;

        public String getInterfaceDescriptor() {
            return IDoraPrivateProtocolService$Stub.DESCRIPTOR;
        }

        public int getConnectionState() throws RemoteException {
            Parcel r0 = Parcel.obtain();
            Parcel r1 = Parcel.obtain();
            r0.writeInterfaceToken(IDoraPrivateProtocolService$Stub.DESCRIPTOR);     // Catch: Throwable -> L13
            if (INVOKEINTERFACE_com_obric_assistant_dora_IDoraPrivateProtocolService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r0, r1, 0) == false) goto L6;
        L10:
            r1.readException();     // Catch: Throwable -> L13
            int r2 = r1.readInt();     // Catch: Throwable -> L13
            r1.recycle();
            r0.recycle();
            return r2;
        L6:
            if (IDoraPrivateProtocolService$Stub.getDefaultImpl() == null) goto L10;
            int r3 = IDoraPrivateProtocolService$Stub.getDefaultImpl().getConnectionState();     // Catch: Throwable -> L13
            r1.recycle();
            r0.recycle();
            return r3;
        L13:
            th = move-exception;
            r1.recycle();
            r0.recycle();
            throw th;
        }

        public DoraDeviceInfo getCurrentDeviceInfo() throws RemoteException {
            Parcel r0 = Parcel.obtain();
            Parcel r1 = Parcel.obtain();
            r0.writeInterfaceToken(IDoraPrivateProtocolService$Stub.DESCRIPTOR);     // Catch: Throwable -> L17
            if (INVOKEINTERFACE_com_obric_assistant_dora_IDoraPrivateProtocolService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r0, r1, 0) == false) goto L6;
        L10:
            r1.readException();     // Catch: Throwable -> L17
            if (r1.readInt() == 0) goto L14;
            DoraDeviceInfo r2 = (DoraDeviceInfo) DoraDeviceInfo.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L17
        L15:
            r1.recycle();
            r0.recycle();
            return r2;
        L14:
            r2 = null;
            goto L15
        L6:
            if (IDoraPrivateProtocolService$Stub.getDefaultImpl() == null) goto L10;
            DoraDeviceInfo r3 = IDoraPrivateProtocolService$Stub.getDefaultImpl().getCurrentDeviceInfo();     // Catch: Throwable -> L17
            r1.recycle();
            r0.recycle();
            return r3;
        L17:
            th = move-exception;
            r1.recycle();
            r0.recycle();
            throw th;
        }

        public IBinder asBinder() {
            return this.mRemote;
        }

        public Proxy(IBinder r1) {
            this.mRemote = r1;
        }

        public void registerCallback(IDoraPrivateProtocolCallback r6) throws RemoteException {
            Parcel r0 = Parcel.obtain();
            Parcel r1 = Parcel.obtain();
            r0.writeInterfaceToken(IDoraPrivateProtocolService$Stub.DESCRIPTOR);     // Catch: Throwable -> L17
            if (r6 == null) goto L6;
            IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
        L7:
            r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
            if (INVOKEINTERFACE_com_obric_assistant_dora_IDoraPrivateProtocolService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, r1, 0) == false) goto L10;
        L14:
            r1.readException();     // Catch: Throwable -> L17
            r1.recycle();
            r0.recycle();
            return;
        L10:
            if (IDoraPrivateProtocolService$Stub.getDefaultImpl() == null) goto L14;
            IDoraPrivateProtocolService$Stub.getDefaultImpl().registerCallback(r6);     // Catch: Throwable -> L17
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

        public void syncBatteryChanged(DoraDeviceInfo r6) throws RemoteException {
            Parcel r0 = Parcel.obtain();
            Parcel r1 = Parcel.obtain();
            r0.writeInterfaceToken(IDoraPrivateProtocolService$Stub.DESCRIPTOR);     // Catch: Throwable -> L17
            if (r6 == null) goto L6;
            r0.writeInt(1);     // Catch: Throwable -> L17
            r6.writeToParcel(r0, 0);     // Catch: Throwable -> L17
        L8:
            if (INVOKEINTERFACE_com_obric_assistant_dora_IDoraPrivateProtocolService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r0, r1, 0) == false) goto L10;
        L14:
            r1.readException();     // Catch: Throwable -> L17
            r1.recycle();
            r0.recycle();
            return;
        L10:
            if (IDoraPrivateProtocolService$Stub.getDefaultImpl() == null) goto L14;
            IDoraPrivateProtocolService$Stub.getDefaultImpl().syncBatteryChanged(r6);     // Catch: Throwable -> L17
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

        public void syncChargeStateChanged(DoraDeviceInfo r6) throws RemoteException {
            Parcel r0 = Parcel.obtain();
            r0.writeInterfaceToken(IDoraPrivateProtocolService$Stub.DESCRIPTOR);     // Catch: Throwable -> L16
            if (r6 == null) goto L6;
            r0.writeInt(1);     // Catch: Throwable -> L16
            r6.writeToParcel(r0, 0);     // Catch: Throwable -> L16
        L8:
            if (INVOKEINTERFACE_com_obric_assistant_dora_IDoraPrivateProtocolService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r0, null, 1) == false) goto L10;
        L14:
            r0.recycle();
            return;
        L10:
            if (IDoraPrivateProtocolService$Stub.getDefaultImpl() == null) goto L14;
            IDoraPrivateProtocolService$Stub.getDefaultImpl().syncChargeStateChanged(r6);     // Catch: Throwable -> L16
            r0.recycle();
            return;
        L6:
            r0.writeInt(0);     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            r0.recycle();
            throw th;
        }

        public void unregisterCallback(IDoraPrivateProtocolCallback r6) throws RemoteException {
            Parcel r0 = Parcel.obtain();
            Parcel r1 = Parcel.obtain();
            r0.writeInterfaceToken(IDoraPrivateProtocolService$Stub.DESCRIPTOR);     // Catch: Throwable -> L17
            if (r6 == null) goto L6;
            IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
        L7:
            r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
            if (INVOKEINTERFACE_com_obric_assistant_dora_IDoraPrivateProtocolService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, r1, 0) == false) goto L10;
        L14:
            r1.readException();     // Catch: Throwable -> L17
            r1.recycle();
            r0.recycle();
            return;
        L10:
            if (IDoraPrivateProtocolService$Stub.getDefaultImpl() == null) goto L14;
            IDoraPrivateProtocolService$Stub.getDefaultImpl().unregisterCallback(r6);     // Catch: Throwable -> L17
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

        public void registerCallbackWithExtra(IDoraPrivateProtocolCallback r6, String r7) throws RemoteException {
            Parcel r0 = Parcel.obtain();
            Parcel r1 = Parcel.obtain();
            r0.writeInterfaceToken(IDoraPrivateProtocolService$Stub.DESCRIPTOR);     // Catch: Throwable -> L17
            if (r6 == null) goto L6;
            IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
        L7:
            r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
            r0.writeString(r7);     // Catch: Throwable -> L17
            if (INVOKEINTERFACE_com_obric_assistant_dora_IDoraPrivateProtocolService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r0, r1, 0) == false) goto L10;
        L14:
            r1.readException();     // Catch: Throwable -> L17
            r1.recycle();
            r0.recycle();
            return;
        L10:
            if (IDoraPrivateProtocolService$Stub.getDefaultImpl() == null) goto L14;
            IDoraPrivateProtocolService$Stub.getDefaultImpl().registerCallbackWithExtra(r6, r7);     // Catch: Throwable -> L17
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

        public void syncConnectionState(int r6, DoraDeviceInfo r7) throws RemoteException {
            Parcel r0 = Parcel.obtain();
            Parcel r1 = Parcel.obtain();
            r0.writeInterfaceToken(IDoraPrivateProtocolService$Stub.DESCRIPTOR);     // Catch: Throwable -> L17
            r0.writeInt(r6);     // Catch: Throwable -> L17
            if (r7 == null) goto L6;
            r0.writeInt(1);     // Catch: Throwable -> L17
            r7.writeToParcel(r0, 0);     // Catch: Throwable -> L17
        L8:
            if (INVOKEINTERFACE_com_obric_assistant_dora_IDoraPrivateProtocolService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r0, r1, 0) == false) goto L10;
        L14:
            r1.readException();     // Catch: Throwable -> L17
            r1.recycle();
            r0.recycle();
            return;
        L10:
            if (IDoraPrivateProtocolService$Stub.getDefaultImpl() == null) goto L14;
            IDoraPrivateProtocolService$Stub.getDefaultImpl().syncConnectionState(r6, r7);     // Catch: Throwable -> L17
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
        public static boolean INVOKEINTERFACE_com_obric_assistant_dora_IDoraPrivateProtocolService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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
    public IDoraPrivateProtocolService$Stub() {
        attachInterface(this, DESCRIPTOR);
    }

    public static IDoraPrivateProtocolService getDefaultImpl() {
        return Proxy.sDefaultImpl;
    }

    public static IDoraPrivateProtocolService asInterface(IBinder r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        IDoraPrivateProtocolService r0 = r2.queryLocalInterface(DESCRIPTOR);
        if (r0 == null) goto L12;
        if ((r0 instanceof IDoraPrivateProtocolService) == false) goto L12;
        return r0;
    L12:
        return new Proxy(r2);
    }

    public static boolean setDefaultImpl(IDoraPrivateProtocolService r1) {
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
        if (r4 == 1598968902) goto L36;
        DoraDeviceInfo r0 = null;
        switch(r4) {
            case 1: goto L34;
            case 2: goto L32;
            case 3: goto L30;
            case 4: goto L25;
            case 5: goto L20;
            case 6: goto L15;
            case 7: goto L10;
            case 8: goto L8;
            default: goto L7;
        };
    L8:
        r5.enforceInterface(DESCRIPTOR);
        registerCallbackWithExtra(IDoraPrivateProtocolCallback.Stub.asInterface(r5.readStrongBinder()), r5.readString());
        r6.writeNoException();
        return true;
    L10:
        r5.enforceInterface(DESCRIPTOR);
        if (r5.readInt() == 0) goto L13;
        r0 = (DoraDeviceInfo) DoraDeviceInfo.CREATOR.createFromParcel(r5);
    L13:
        syncChargeStateChanged(r0);
        return true;
    L15:
        r5.enforceInterface(DESCRIPTOR);
        if (r5.readInt() == 0) goto L18;
        r0 = (DoraDeviceInfo) DoraDeviceInfo.CREATOR.createFromParcel(r5);
    L18:
        syncBatteryChanged(r0);
        r6.writeNoException();
        return true;
    L20:
        r5.enforceInterface(DESCRIPTOR);
        int r8 = r5.readInt();
        if (r5.readInt() == 0) goto L23;
        r0 = (DoraDeviceInfo) DoraDeviceInfo.CREATOR.createFromParcel(r5);
    L23:
        syncConnectionState(r8, r0);
        r6.writeNoException();
        return true;
    L25:
        r5.enforceInterface(DESCRIPTOR);
        DoraDeviceInfo r9 = getCurrentDeviceInfo();
        r6.writeNoException();
        if (r9 == null) goto L28;
        r6.writeInt(1);
        r9.writeToParcel(r6, 1);
    L29:
        return true;
    L28:
        r6.writeInt(0);
        goto L29
    L30:
        r5.enforceInterface(DESCRIPTOR);
        int r10 = getConnectionState();
        r6.writeNoException();
        r6.writeInt(r10);
        return true;
    L32:
        r5.enforceInterface(DESCRIPTOR);
        unregisterCallback(IDoraPrivateProtocolCallback.Stub.asInterface(r5.readStrongBinder()));
        r6.writeNoException();
        return true;
    L34:
        r5.enforceInterface(DESCRIPTOR);
        registerCallback(IDoraPrivateProtocolCallback.Stub.asInterface(r5.readStrongBinder()));
        r6.writeNoException();
        return true;
    L7:
        return super.onTransact(r4, r5, r6, r7);
    L36:
        r6.writeString(DESCRIPTOR);
        return true;
    }
}
