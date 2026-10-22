package com.obric.cae.libs.cldReport;

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
public interface ICldReportManager extends IInterface {
    public static final int CLD_MODULE_TYPE_BT = 1;
    public static final int CLD_MODULE_TYPE_GNSS = 3;
    public static final int CLD_MODULE_TYPE_LOGCAT = 5;
    public static final int CLD_MODULE_TYPE_NETWORK = 2;
    public static final int CLD_MODULE_TYPE_NFC = 4;
    public static final int CLD_MODULE_TYPE_WIFI = 0;

    public static class Default implements ICldReportManager {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.cldReport.ICldReportManager
        public void reportErrorEvent(int r1, int r2, int r3, int r4, String r5) throws RemoteException {
        }

        @Override // com.obric.cae.libs.cldReport.ICldReportManager
        public void startCollect(ICldReportCallback r1, int r2, int r3, int r4, int r5, String r6, boolean r7) throws RemoteException {
        }

        @Override // com.obric.cae.libs.cldReport.ICldReportManager
        public void stopCollect(ICldReportCallback r1, int r2, int r3) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ICldReportManager {
        private static final String DESCRIPTOR = "com.obric.cae.libs.cldReport.ICldReportManager";
        static final int TRANSACTION_reportErrorEvent = 1;
        static final int TRANSACTION_startCollect = 2;
        static final int TRANSACTION_stopCollect = 3;

        public static class Proxy implements ICldReportManager {
            public static ICldReportManager sDefaultImpl;
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

            @Override // com.obric.cae.libs.cldReport.ICldReportManager
            public void stopCollect(ICldReportCallback r6, int r7, int r8) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                r0.writeInt(r7);     // Catch: Throwable -> L17
                r0.writeInt(r8);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_cldReport_ICldReportManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().stopCollect(r6, r7, r8);     // Catch: Throwable -> L17
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
            public static boolean INVOKEINTERFACE_com_obric_cae_libs_cldReport_ICldReportManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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

            @Override // com.obric.cae.libs.cldReport.ICldReportManager
            public void reportErrorEvent(int r10, int r11, int r12, int r13, String r14) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r10);     // Catch: Throwable -> L13
                r0.writeInt(r11);     // Catch: Throwable -> L13
                r0.writeInt(r12);     // Catch: Throwable -> L13
                r0.writeInt(r13);     // Catch: Throwable -> L13
                r0.writeString(r14);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_cldReport_ICldReportManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().reportErrorEvent(r10, r11, r12, r13, r14);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.cldReport.ICldReportManager
            public void startCollect(ICldReportCallback r13, int r14, int r15, int r16, int r17, String r18, boolean r19) throws RemoteException {
                Parcel r1 = Parcel.obtain();
                Parcel r2 = Parcel.obtain();
                r1.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                if (r13 == null) goto L6;
                IBinder r0 = r13.asBinder();     // Catch: Throwable -> L21
            L7:
                r1.writeStrongBinder(r0);     // Catch: Throwable -> L21
                r1.writeInt(r14);     // Catch: Throwable -> L21
                r1.writeInt(r15);     // Catch: Throwable -> L21
                r1.writeInt(r16);     // Catch: Throwable -> L21
                r1.writeInt(r17);     // Catch: Throwable -> L21
                r1.writeString(r18);     // Catch: Throwable -> L21
                r1.writeInt(r19 ? 1 : 0);     // Catch: Throwable -> L21
            L19:
                th = th;
            L23:
                r2.recycle();
                r1.recycle();
                throw th;
            L10:
                if (INVOKEINTERFACE_com_obric_cae_libs_cldReport_ICldReportManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r1, r2, 0) == false) goto L12;
            L16:
                r2.readException();     // Catch: Throwable -> L19
                r2.recycle();
                r1.recycle();
                return;
            L12:
                if (Stub.getDefaultImpl() == null) goto L16;
                Stub.getDefaultImpl().startCollect(r13, r14, r15, r16, r17, r18, r19);     // Catch: Throwable -> L19
                r2.recycle();
                r1.recycle();
                return;
            L6:
                r0 = null;
            L21:
                th = th;
                goto L23
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICldReportManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static ICldReportManager asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ICldReportManager) == false) goto L12;
            return (ICldReportManager) r0;
        L12:
            return new Proxy(r2);
        }

        public static boolean setDefaultImpl(ICldReportManager r1) {
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
        public boolean onTransact(int r15, Parcel r16, Parcel r17, int r18) throws RemoteException {
            if (r15 != 1) goto L5;
            r16.enforceInterface(DESCRIPTOR);
            reportErrorEvent(r16.readInt(), r16.readInt(), r16.readInt(), r16.readInt(), r16.readString());
            r17.writeNoException();
            return true;
        L5:
            if (r15 != 2) goto L7;
            r16.enforceInterface(DESCRIPTOR);
            ICldReportCallback r6 = ICldReportCallback.Stub.asInterface(r16.readStrongBinder());
            int r7 = r16.readInt();
            int r8 = r16.readInt();
            int r9 = r16.readInt();
            int r10 = r16.readInt();
            String r11 = r16.readString();
            if (r16.readInt() == 0) goto L19;
            boolean r12 = true;
        L20:
            startCollect(r6, r7, r8, r9, r10, r11, r12);
            r17.writeNoException();
            return true;
        L19:
            r12 = false;
            goto L20
        L7:
            if (r15 != 3) goto L9;
            r16.enforceInterface(DESCRIPTOR);
            stopCollect(ICldReportCallback.Stub.asInterface(r16.readStrongBinder()), r16.readInt(), r16.readInt());
            r17.writeNoException();
            return true;
        L9:
            if (r15 != 1598968902) goto L11;
            r17.writeString(DESCRIPTOR);
            return true;
        L11:
            return super.onTransact(r15, r16, r17, r18);
        }
    }

    void reportErrorEvent(int r1, int r2, int r3, int r4, String r5) throws RemoteException;

    void startCollect(ICldReportCallback r1, int r2, int r3, int r4, int r5, String r6, boolean r7) throws RemoteException;

    void stopCollect(ICldReportCallback r1, int r2, int r3) throws RemoteException;
}
