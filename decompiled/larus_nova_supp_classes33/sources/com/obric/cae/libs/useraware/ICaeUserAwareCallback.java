package com.obric.cae.libs.useraware;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public interface ICaeUserAwareCallback extends IInterface {

    public static class Default implements ICaeUserAwareCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
        public void onCellInfoChange(CellAwareInfo r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
        public void onCellNeighbourInfoChange(List<CellAwareInfo> r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
        public void onInSubWayChange(int r1, String r2) throws RemoteException {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
        public void onUserAwareReportData(String r1, String r2) throws RemoteException {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
        public void onWifiConnectInfoChanged(WifiStandardData r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
        public void onWifiNetworkAvailable(boolean r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
        public void onWifiScanInfoChanged(List<WifiStandardData> r1) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ICaeUserAwareCallback {
        private static final String DESCRIPTOR = "com.obric.cae.libs.useraware.ICaeUserAwareCallback";
        static final int TRANSACTION_onCellInfoChange = 4;
        static final int TRANSACTION_onCellNeighbourInfoChange = 5;
        static final int TRANSACTION_onInSubWayChange = 7;
        static final int TRANSACTION_onUserAwareReportData = 6;
        static final int TRANSACTION_onWifiConnectInfoChanged = 2;
        static final int TRANSACTION_onWifiNetworkAvailable = 3;
        static final int TRANSACTION_onWifiScanInfoChanged = 1;

        public static class Proxy implements ICaeUserAwareCallback {
            public static ICaeUserAwareCallback sDefaultImpl;
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

            @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
            public void onCellInfoChange(CellAwareInfo r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L8:
                if (INVOKEINTERFACE_com_obric_cae_libs_useraware_ICaeUserAwareCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onCellInfoChange(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
            public void onCellNeighbourInfoChange(List<CellAwareInfo> r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeTypedList(r6);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_cae_libs_useraware_ICaeUserAwareCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onCellNeighbourInfoChange(r6);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
            public void onWifiConnectInfoChanged(WifiStandardData r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L8:
                if (INVOKEINTERFACE_com_obric_cae_libs_useraware_ICaeUserAwareCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onWifiConnectInfoChanged(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
            public void onWifiNetworkAvailable(boolean r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeInt(r6 ? 1 : 0);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_cae_libs_useraware_ICaeUserAwareCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onWifiNetworkAvailable(r6);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
            public void onWifiScanInfoChanged(List<WifiStandardData> r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeTypedList(r5);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_cae_libs_useraware_ICaeUserAwareCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onWifiScanInfoChanged(r5);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
            public void onInSubWayChange(int r6, String r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeInt(r6);     // Catch: Throwable -> L12
                r0.writeString(r7);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_cae_libs_useraware_ICaeUserAwareCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onInSubWayChange(r6, r7);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
            public void onUserAwareReportData(String r6, String r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r6);     // Catch: Throwable -> L12
                r0.writeString(r7);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_cae_libs_useraware_ICaeUserAwareCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onUserAwareReportData(r6, r7);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_cae_libs_useraware_ICaeUserAwareCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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

        public static ICaeUserAwareCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static ICaeUserAwareCallback asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ICaeUserAwareCallback) == false) goto L12;
            return (ICaeUserAwareCallback) r0;
        L12:
            return new Proxy(r2);
        }

        public static boolean setDefaultImpl(ICaeUserAwareCallback r1) {
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
            if (r4 == 1598968902) goto L32;
            CellAwareInfo r0 = null;
            switch(r4) {
                case 1: goto L30;
                case 2: goto L25;
                case 3: goto L19;
                case 4: goto L14;
                case 5: goto L12;
                case 6: goto L10;
                case 7: goto L8;
                default: goto L7;
            };
        L8:
            r5.enforceInterface(DESCRIPTOR);
            onInSubWayChange(r5.readInt(), r5.readString());
            return true;
        L10:
            r5.enforceInterface(DESCRIPTOR);
            onUserAwareReportData(r5.readString(), r5.readString());
            return true;
        L12:
            r5.enforceInterface(DESCRIPTOR);
            onCellNeighbourInfoChange(r5.createTypedArrayList(CellAwareInfo.CREATOR));
            return true;
        L14:
            r5.enforceInterface(DESCRIPTOR);
            if (r5.readInt() == 0) goto L17;
            r0 = (CellAwareInfo) CellAwareInfo.CREATOR.createFromParcel(r5);
        L17:
            onCellInfoChange(r0);
            return true;
        L19:
            r5.enforceInterface(DESCRIPTOR);
            if (r5.readInt() == 0) goto L22;
            boolean r8 = true;
        L23:
            onWifiNetworkAvailable(r8);
            return true;
        L22:
            r8 = false;
            goto L23
        L25:
            r5.enforceInterface(DESCRIPTOR);
            if (r5.readInt() == 0) goto L28;
            r0 = (WifiStandardData) WifiStandardData.CREATOR.createFromParcel(r5);
        L28:
            onWifiConnectInfoChanged(r0);
            return true;
        L30:
            r5.enforceInterface(DESCRIPTOR);
            onWifiScanInfoChanged(r5.createTypedArrayList(WifiStandardData.CREATOR));
            return true;
        L7:
            return super.onTransact(r4, r5, r6, r7);
        L32:
            r6.writeString(DESCRIPTOR);
            return true;
        }
    }

    void onCellInfoChange(CellAwareInfo r1) throws RemoteException;

    void onCellNeighbourInfoChange(List<CellAwareInfo> r1) throws RemoteException;

    void onInSubWayChange(int r1, String r2) throws RemoteException;

    void onUserAwareReportData(String r1, String r2) throws RemoteException;

    void onWifiConnectInfoChanged(WifiStandardData r1) throws RemoteException;

    void onWifiNetworkAvailable(boolean r1) throws RemoteException;

    void onWifiScanInfoChanged(List<WifiStandardData> r1) throws RemoteException;
}
