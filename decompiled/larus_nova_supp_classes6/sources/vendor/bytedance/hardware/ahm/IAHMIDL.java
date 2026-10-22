package vendor.bytedance.hardware.ahm;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public interface IAHMIDL extends IInterface {

    public static abstract class Stub extends Binder implements IAHMIDL {
        private static final String DESCRIPTOR = "vendor.bytedance.hardware.ahm.IAHMIDL";
        static final int TRANSACTION_ipc_ahm_close = 2;
        static final int TRANSACTION_ipc_ahm_open = 1;
        static final int TRANSACTION_ipc_ahm_open_v2 = 3;

        public static class Proxy implements IAHMIDL {
            public static IAHMIDL sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // vendor.bytedance.hardware.ahm.IAHMIDL
            public long ipc_ahm_close() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_vendor_bytedance_hardware_ahm_IAHMIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                long r2 = r1.readLong();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                long r3 = Stub.getDefaultImpl().ipc_ahm_close();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r3;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // vendor.bytedance.hardware.ahm.IAHMIDL
            public long ipc_ahm_open(IAHMCallbackIDL r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_vendor_bytedance_hardware_ahm_IAHMIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                long r3 = r1.readLong();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r3;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                long r4 = Stub.getDefaultImpl().ipc_ahm_open(r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // vendor.bytedance.hardware.ahm.IAHMIDL
            public long ipc_ahm_open_v2(IAHMCallbackIDL r6, int r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                r0.writeInt(r7);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_vendor_bytedance_hardware_ahm_IAHMIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                long r8 = r1.readLong();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r8;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                long r9 = Stub.getDefaultImpl().ipc_ahm_open_v2(r6, r7);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r9;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_vendor_bytedance_hardware_ahm_IAHMIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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

        public static IAHMIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IAHMIDL asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IAHMIDL) == false) goto L12;
            return (IAHMIDL) r0;
        L12:
            return new Proxy(r2);
        }

        public static boolean setDefaultImpl(IAHMIDL r1) {
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
            long r8 = ipc_ahm_open(IAHMCallbackIDL.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            r6.writeLong(r8);
            return true;
        L5:
            if (r4 != 2) goto L7;
            r5.enforceInterface(DESCRIPTOR);
            long r9 = ipc_ahm_close();
            r6.writeNoException();
            r6.writeLong(r9);
            return true;
        L7:
            if (r4 != 3) goto L9;
            r5.enforceInterface(DESCRIPTOR);
            long r10 = ipc_ahm_open_v2(IAHMCallbackIDL.Stub.asInterface(r5.readStrongBinder()), r5.readInt());
            r6.writeNoException();
            r6.writeLong(r10);
            return true;
        L9:
            if (r4 != 1598968902) goto L11;
            r6.writeString(DESCRIPTOR);
            return true;
        L11:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    long ipc_ahm_close() throws RemoteException;

    long ipc_ahm_open(IAHMCallbackIDL r1) throws RemoteException;

    long ipc_ahm_open_v2(IAHMCallbackIDL r1, int r2) throws RemoteException;
}
