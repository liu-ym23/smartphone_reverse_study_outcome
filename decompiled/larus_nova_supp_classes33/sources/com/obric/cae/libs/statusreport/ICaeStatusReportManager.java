package com.obric.cae.libs.statusreport;

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
public interface ICaeStatusReportManager extends IInterface {

    public static class Default implements ICaeStatusReportManager {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.statusreport.ICaeStatusReportManager
        public String getCaeVersion() throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.statusreport.ICaeStatusReportManager
        public LinkLayerQuality getLinkLayerQuality(String r1) throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.statusreport.ICaeStatusReportManager
        public boolean registerLinkLayerQualityChangedListener(String r1, ILinkLayerQualityListener r2) throws RemoteException {
            return false;
        }

        @Override // com.obric.cae.libs.statusreport.ICaeStatusReportManager
        public boolean unregisterLinkLayerQualityChangedListener(String r1, ILinkLayerQualityListener r2) throws RemoteException {
            return false;
        }
    }

    public static abstract class Stub extends Binder implements ICaeStatusReportManager {
        private static final String DESCRIPTOR = "com.obric.cae.libs.statusreport.ICaeStatusReportManager";
        static final int TRANSACTION_getCaeVersion = 4;
        static final int TRANSACTION_getLinkLayerQuality = 3;
        static final int TRANSACTION_registerLinkLayerQualityChangedListener = 1;
        static final int TRANSACTION_unregisterLinkLayerQualityChangedListener = 2;

        public static class Proxy implements ICaeStatusReportManager {
            public static ICaeStatusReportManager sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.statusreport.ICaeStatusReportManager
            public String getCaeVersion() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_statusreport_ICaeStatusReportManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                String r2 = r1.readString();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r3 = Stub.getDefaultImpl().getCaeVersion();     // Catch: Throwable -> L13
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

            @Override // com.obric.cae.libs.statusreport.ICaeStatusReportManager
            public LinkLayerQuality getLinkLayerQuality(String r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r6);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_statusreport_ICaeStatusReportManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L17
                if (r1.readInt() == 0) goto L14;
                LinkLayerQuality r7 = LinkLayerQuality.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L17
            L15:
                r1.recycle();
                r0.recycle();
                return r7;
            L14:
                r7 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                LinkLayerQuality r8 = Stub.getDefaultImpl().getLinkLayerQuality(r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r8;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.statusreport.ICaeStatusReportManager
            public boolean registerLinkLayerQualityChangedListener(String r6, ILinkLayerQualityListener r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                r0.writeString(r6);     // Catch: Throwable -> L19
                if (r7 == null) goto L6;
                IBinder r2 = r7.asBinder();     // Catch: Throwable -> L19
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L19
                boolean r3 = false;
                if (INVOKEINTERFACE_com_obric_cae_libs_statusreport_ICaeStatusReportManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L19
                if (r1.readInt() == 0) goto L17;
                r3 = true;
            L17:
                r1.recycle();
                r0.recycle();
                return r3;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                boolean r8 = Stub.getDefaultImpl().registerLinkLayerQualityChangedListener(r6, r7);     // Catch: Throwable -> L19
                r1.recycle();
                r0.recycle();
                return r8;
            L6:
                r2 = null;
            L19:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.statusreport.ICaeStatusReportManager
            public boolean unregisterLinkLayerQualityChangedListener(String r6, ILinkLayerQualityListener r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                r0.writeString(r6);     // Catch: Throwable -> L19
                if (r7 == null) goto L6;
                IBinder r2 = r7.asBinder();     // Catch: Throwable -> L19
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L19
                boolean r4 = false;
                if (INVOKEINTERFACE_com_obric_cae_libs_statusreport_ICaeStatusReportManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L19
                if (r1.readInt() == 0) goto L17;
                r4 = true;
            L17:
                r1.recycle();
                r0.recycle();
                return r4;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                boolean r8 = Stub.getDefaultImpl().unregisterLinkLayerQualityChangedListener(r6, r7);     // Catch: Throwable -> L19
                r1.recycle();
                r0.recycle();
                return r8;
            L6:
                r2 = null;
            L19:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_cae_libs_statusreport_ICaeStatusReportManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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

        public static ICaeStatusReportManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static ICaeStatusReportManager asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ICaeStatusReportManager) == false) goto L12;
            return (ICaeStatusReportManager) r0;
        L12:
            return new Proxy(r2);
        }

        public static boolean setDefaultImpl(ICaeStatusReportManager r1) {
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
            if (r4 == 1598968902) goto L24;
            if (r4 != 1) goto L6;
            r5.enforceInterface(DESCRIPTOR);
            boolean r8 = registerLinkLayerQualityChangedListener(r5.readString(), ILinkLayerQualityListener.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            r6.writeInt(r8 ? 1 : 0);
            return true;
        L6:
            if (r4 != 2) goto L8;
            r5.enforceInterface(DESCRIPTOR);
            boolean r9 = unregisterLinkLayerQualityChangedListener(r5.readString(), ILinkLayerQualityListener.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            r6.writeInt(r9 ? 1 : 0);
            return true;
        L8:
            if (r4 != 3) goto L10;
            r5.enforceInterface(DESCRIPTOR);
            LinkLayerQuality r10 = getLinkLayerQuality(r5.readString());
            r6.writeNoException();
            if (r10 == null) goto L18;
            r6.writeInt(1);
            r10.writeToParcel(r6, 1);
        L19:
            return true;
        L18:
            r6.writeInt(0);
            goto L19
        L10:
            if (r4 != 4) goto L12;
            r5.enforceInterface(DESCRIPTOR);
            String r11 = getCaeVersion();
            r6.writeNoException();
            r6.writeString(r11);
            return true;
        L12:
            return super.onTransact(r4, r5, r6, r7);
        L24:
            r6.writeString(DESCRIPTOR);
            return true;
        }
    }

    String getCaeVersion() throws RemoteException;

    LinkLayerQuality getLinkLayerQuality(String r1) throws RemoteException;

    boolean registerLinkLayerQualityChangedListener(String r1, ILinkLayerQualityListener r2) throws RemoteException;

    boolean unregisterLinkLayerQualityChangedListener(String r1, ILinkLayerQualityListener r2) throws RemoteException;
}
