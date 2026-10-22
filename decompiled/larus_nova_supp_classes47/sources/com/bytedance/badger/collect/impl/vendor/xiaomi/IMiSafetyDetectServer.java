package com.bytedance.badger.collect.impl.vendor.xiaomi;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface IMiSafetyDetectServer extends IInterface {

    public static class Default implements IMiSafetyDetectServer {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.bytedance.badger.collect.impl.vendor.xiaomi.IMiSafetyDetectServer
        public void getRiskAppList(String r1, IMiSafetyDetectCallback r2) throws RemoteException {
        }

        @Override // com.bytedance.badger.collect.impl.vendor.xiaomi.IMiSafetyDetectServer
        public void getSimulatedTouchResult(String r1, long r2, IMiSafetyDetectCallback r4) throws RemoteException {
        }

        @Override // com.bytedance.badger.collect.impl.vendor.xiaomi.IMiSafetyDetectServer
        public void getTrustDeviceStatusInfo(String r1, String r2, int r3, IMiSafetyDetectCallback r4) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IMiSafetyDetectServer {
        private static final String DESCRIPTOR = "com.xiaomi.security.xsof.IMiSafetyDetectServer";
        static final int TRANSACTION_getRiskAppList = 2;
        static final int TRANSACTION_getSimulatedTouchResult = 3;
        static final int TRANSACTION_getTrustDeviceStatusInfo = 1;

        public static class Proxy implements IMiSafetyDetectServer {
            public static IMiSafetyDetectServer sDefaultImpl;
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

            @Override // com.bytedance.badger.collect.impl.vendor.xiaomi.IMiSafetyDetectServer
            public void getRiskAppList(String r6, IMiSafetyDetectCallback r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r6);     // Catch: Throwable -> L17
                if (r7 == null) goto L6;
                IBinder r2 = r7.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_bytedance_badger_collect_impl_vendor_xiaomi_IMiSafetyDetectServer$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().getRiskAppList(r6, r7);     // Catch: Throwable -> L17
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

            @Override // com.bytedance.badger.collect.impl.vendor.xiaomi.IMiSafetyDetectServer
            public void getSimulatedTouchResult(String r6, long r7, IMiSafetyDetectCallback r9) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r6);     // Catch: Throwable -> L17
                r0.writeLong(r7);     // Catch: Throwable -> L17
                if (r9 == null) goto L6;
                IBinder r2 = r9.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_bytedance_badger_collect_impl_vendor_xiaomi_IMiSafetyDetectServer$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().getSimulatedTouchResult(r6, r7, r9);     // Catch: Throwable -> L17
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

            @Override // com.bytedance.badger.collect.impl.vendor.xiaomi.IMiSafetyDetectServer
            public void getTrustDeviceStatusInfo(String r6, String r7, int r8, IMiSafetyDetectCallback r9) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r6);     // Catch: Throwable -> L17
                r0.writeString(r7);     // Catch: Throwable -> L17
                r0.writeInt(r8);     // Catch: Throwable -> L17
                if (r9 == null) goto L6;
                IBinder r2 = r9.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_bytedance_badger_collect_impl_vendor_xiaomi_IMiSafetyDetectServer$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().getTrustDeviceStatusInfo(r6, r7, r8, r9);     // Catch: Throwable -> L17
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
            public static boolean INVOKEINTERFACE_com_bytedance_badger_collect_impl_vendor_xiaomi_IMiSafetyDetectServer$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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

        public static IMiSafetyDetectServer getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IMiSafetyDetectServer asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IMiSafetyDetectServer) == false) goto L12;
            return (IMiSafetyDetectServer) r0;
        L12:
            return new Proxy(r2);
        }

        public static boolean setDefaultImpl(IMiSafetyDetectServer r1) {
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r1 == null) goto L9;
            Proxy.sDefaultImpl = r1;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
            if (r4 != 1) goto L5;
            r5.enforceInterface(DESCRIPTOR);
            getTrustDeviceStatusInfo(r5.readString(), r5.readString(), r5.readInt(), IMiSafetyDetectCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L5:
            if (r4 != 2) goto L7;
            r5.enforceInterface(DESCRIPTOR);
            getRiskAppList(r5.readString(), IMiSafetyDetectCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L7:
            if (r4 != 3) goto L9;
            r5.enforceInterface(DESCRIPTOR);
            getSimulatedTouchResult(r5.readString(), r5.readLong(), IMiSafetyDetectCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L9:
            if (r4 != 1598968902) goto L11;
            r6.writeString(DESCRIPTOR);
            return true;
        L11:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    void getRiskAppList(String r1, IMiSafetyDetectCallback r2) throws RemoteException;

    void getSimulatedTouchResult(String r1, long r2, IMiSafetyDetectCallback r4) throws RemoteException;

    void getTrustDeviceStatusInfo(String r1, String r2, int r3, IMiSafetyDetectCallback r4) throws RemoteException;
}
