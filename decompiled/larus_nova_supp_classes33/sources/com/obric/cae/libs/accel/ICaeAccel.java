package com.obric.cae.libs.accel;

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
public interface ICaeAccel extends IInterface {

    public static class Default implements ICaeAccel {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.accel.ICaeAccel
        public int setPackageAccelEnable(String r1, boolean r2) throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.accel.ICaeAccel
        public int setPackageAutoDualWlanMode(String r1, int r2) throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.accel.ICaeAccel
        public int setPackageFlowSched(String r1, boolean r2) throws RemoteException {
            return 0;
        }
    }

    public static abstract class Stub extends Binder implements ICaeAccel {
        private static final String DESCRIPTOR = "com.obric.cae.libs.accel.ICaeAccel";
        static final int TRANSACTION_setPackageAccelEnable = 1;
        static final int TRANSACTION_setPackageAutoDualWlanMode = 3;
        static final int TRANSACTION_setPackageFlowSched = 2;

        public static class Proxy implements ICaeAccel {
            public static ICaeAccel sDefaultImpl;
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

            @Override // com.obric.cae.libs.accel.ICaeAccel
            public int setPackageAccelEnable(String r6, boolean r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(r6);     // Catch: Throwable -> L13
                r0.writeInt(r7 ? 1 : 0);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_accel_ICaeAccel$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r8 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r8;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r9 = Stub.getDefaultImpl().setPackageAccelEnable(r6, r7);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r9;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.accel.ICaeAccel
            public int setPackageAutoDualWlanMode(String r6, int r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(r6);     // Catch: Throwable -> L13
                r0.writeInt(r7);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_accel_ICaeAccel$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r8 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r8;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r9 = Stub.getDefaultImpl().setPackageAutoDualWlanMode(r6, r7);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r9;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.accel.ICaeAccel
            public int setPackageFlowSched(String r6, boolean r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(r6);     // Catch: Throwable -> L13
                r0.writeInt(r7 ? 1 : 0);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_accel_ICaeAccel$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r8 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r8;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r9 = Stub.getDefaultImpl().setPackageFlowSched(r6, r7);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r9;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_cae_libs_accel_ICaeAccel$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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

        public static ICaeAccel getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static ICaeAccel asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ICaeAccel) == false) goto L12;
            return (ICaeAccel) r0;
        L12:
            return new Proxy(r2);
        }

        public static boolean setDefaultImpl(ICaeAccel r1) {
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
            boolean r0 = false;
            if (r5 != 1) goto L5;
            r6.enforceInterface(DESCRIPTOR);
            String r9 = r6.readString();
            if (r6.readInt() == 0) goto L24;
            r0 = true;
        L24:
            int r10 = setPackageAccelEnable(r9, r0);
            r7.writeNoException();
            r7.writeInt(r10);
            return true;
        L5:
            if (r5 != 2) goto L7;
            r6.enforceInterface(DESCRIPTOR);
            String r11 = r6.readString();
            if (r6.readInt() == 0) goto L19;
            r0 = true;
        L19:
            int r12 = setPackageFlowSched(r11, r0);
            r7.writeNoException();
            r7.writeInt(r12);
            return true;
        L7:
            if (r5 != 3) goto L9;
            r6.enforceInterface(DESCRIPTOR);
            int r13 = setPackageAutoDualWlanMode(r6.readString(), r6.readInt());
            r7.writeNoException();
            r7.writeInt(r13);
            return true;
        L9:
            if (r5 != 1598968902) goto L11;
            r7.writeString(DESCRIPTOR);
            return true;
        L11:
            return super.onTransact(r5, r6, r7, r8);
        }
    }

    int setPackageAccelEnable(String r1, boolean r2) throws RemoteException;

    int setPackageAutoDualWlanMode(String r1, int r2) throws RemoteException;

    int setPackageFlowSched(String r1, boolean r2) throws RemoteException;
}
