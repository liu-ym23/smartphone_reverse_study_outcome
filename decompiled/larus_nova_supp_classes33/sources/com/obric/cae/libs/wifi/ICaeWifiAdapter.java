package com.obric.cae.libs.wifi;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public interface ICaeWifiAdapter extends IInterface {

    public static class Default implements ICaeWifiAdapter {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.wifi.ICaeWifiAdapter
        public int getRoamRssiThreshold(int r1) throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.wifi.ICaeWifiAdapter
        public boolean setLatencyLevel(int r1, int r2) throws RemoteException {
            return false;
        }

        @Override // com.obric.cae.libs.wifi.ICaeWifiAdapter
        public boolean setRoamRssiThreshold(int r1, int r2) throws RemoteException {
            return false;
        }
    }

    public static abstract class Stub extends Binder implements ICaeWifiAdapter {
        private static final String DESCRIPTOR = "com.obric.cae.libs.wifi.ICaeWifiAdapter";
        static final int TRANSACTION_getRoamRssiThreshold = 3;
        static final int TRANSACTION_setLatencyLevel = 1;
        static final int TRANSACTION_setRoamRssiThreshold = 2;

        public static class Proxy implements ICaeWifiAdapter {
            public static ICaeWifiAdapter sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // com.obric.cae.libs.wifi.ICaeWifiAdapter
            public int getRoamRssiThreshold(int r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r6);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_wifi_ICaeWifiAdapter$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r7 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r7;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r8 = Stub.getDefaultImpl().getRoamRssiThreshold(r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r8;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ICaeWifiAdapter
            public boolean setLatencyLevel(int r6, int r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeInt(r6);     // Catch: Throwable -> L15
                r0.writeInt(r7);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (INVOKEINTERFACE_com_obric_cae_libs_wifi_ICaeWifiAdapter$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r3 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r8 = Stub.getDefaultImpl().setLatencyLevel(r6, r7);     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r8;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ICaeWifiAdapter
            public boolean setRoamRssiThreshold(int r6, int r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeInt(r6);     // Catch: Throwable -> L15
                r0.writeInt(r7);     // Catch: Throwable -> L15
                boolean r4 = false;
                if (INVOKEINTERFACE_com_obric_cae_libs_wifi_ICaeWifiAdapter$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r4 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r8 = Stub.getDefaultImpl().setRoamRssiThreshold(r6, r7);     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r8;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_cae_libs_wifi_ICaeWifiAdapter$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICaeWifiAdapter getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static ICaeWifiAdapter asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ICaeWifiAdapter) == false) goto L12;
            return (ICaeWifiAdapter) r0;
        L12:
            return new Proxy(r2);
        }

        public static boolean setDefaultImpl(ICaeWifiAdapter r1) {
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
            boolean r8 = setLatencyLevel(r5.readInt(), r5.readInt());
            r6.writeNoException();
            r6.writeInt(r8 ? 1 : 0);
            return true;
        L5:
            if (r4 != 2) goto L7;
            r5.enforceInterface(DESCRIPTOR);
            boolean r9 = setRoamRssiThreshold(r5.readInt(), r5.readInt());
            r6.writeNoException();
            r6.writeInt(r9 ? 1 : 0);
            return true;
        L7:
            if (r4 != 3) goto L9;
            r5.enforceInterface(DESCRIPTOR);
            int r10 = getRoamRssiThreshold(r5.readInt());
            r6.writeNoException();
            r6.writeInt(r10);
            return true;
        L9:
            if (r4 != 1598968902) goto L11;
            r6.writeString(DESCRIPTOR);
            return true;
        L11:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    int getRoamRssiThreshold(int r1) throws RemoteException;

    boolean setLatencyLevel(int r1, int r2) throws RemoteException;

    boolean setRoamRssiThreshold(int r1, int r2) throws RemoteException;
}
