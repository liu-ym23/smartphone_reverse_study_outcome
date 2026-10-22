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
public interface ICaeSmartNetworkManager extends IInterface {

    public static class Default implements ICaeSmartNetworkManager {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public String getCurrentSecondarySsid() throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public int getLinkThroughput() throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public int getLinkThroughputJitter() throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public float getLinkThroughputJitterWeight() throws RemoteException {
            return 0.0f;
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public void registerLinkThroughputListener(ICaeWifiLinkThroughputListener r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public void registerSecondaryWifiListener(ISecondaryWifiCallback r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public void releaseAll() throws RemoteException {
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public void releaseSecondaryWifi(ISecondaryWifiCallback r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public void requestSecondaryWifi(String r1, String r2, String r3, String r4, ISecondaryWifiCallback r5) throws RemoteException {
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public void unregisterLinkThroughputListener(ICaeWifiLinkThroughputListener r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public void unregisterSecondaryWifiListener(ISecondaryWifiCallback r1) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ICaeSmartNetworkManager {
        private static final String DESCRIPTOR = "com.obric.cae.libs.wifi.ICaeSmartNetworkManager";
        static final int TRANSACTION_getCurrentSecondarySsid = 11;
        static final int TRANSACTION_getLinkThroughput = 3;
        static final int TRANSACTION_getLinkThroughputJitter = 4;
        static final int TRANSACTION_getLinkThroughputJitterWeight = 5;
        static final int TRANSACTION_registerLinkThroughputListener = 1;
        static final int TRANSACTION_registerSecondaryWifiListener = 8;
        static final int TRANSACTION_releaseAll = 10;
        static final int TRANSACTION_releaseSecondaryWifi = 7;
        static final int TRANSACTION_requestSecondaryWifi = 6;
        static final int TRANSACTION_unregisterLinkThroughputListener = 2;
        static final int TRANSACTION_unregisterSecondaryWifiListener = 9;

        public static class Proxy implements ICaeSmartNetworkManager {
            public static ICaeSmartNetworkManager sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public String getCurrentSecondarySsid() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_wifi_ICaeSmartNetworkManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 11, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                String r2 = r1.readString();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r3 = Stub.getDefaultImpl().getCurrentSecondarySsid();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r3;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public int getLinkThroughput() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_wifi_ICaeSmartNetworkManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r2 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r3 = Stub.getDefaultImpl().getLinkThroughput();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r3;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public int getLinkThroughputJitter() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_wifi_ICaeSmartNetworkManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r2 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r3 = Stub.getDefaultImpl().getLinkThroughputJitter();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r3;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public float getLinkThroughputJitterWeight() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_wifi_ICaeSmartNetworkManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                float r2 = r1.readFloat();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                float r3 = Stub.getDefaultImpl().getLinkThroughputJitterWeight();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r3;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public void releaseAll() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_wifi_ICaeSmartNetworkManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 10, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().releaseAll();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
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

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public void registerLinkThroughputListener(ICaeWifiLinkThroughputListener r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_wifi_ICaeSmartNetworkManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerLinkThroughputListener(r6);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public void registerSecondaryWifiListener(ISecondaryWifiCallback r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_wifi_ICaeSmartNetworkManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerSecondaryWifiListener(r6);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public void releaseSecondaryWifi(ISecondaryWifiCallback r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_wifi_ICaeSmartNetworkManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().releaseSecondaryWifi(r6);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public void unregisterLinkThroughputListener(ICaeWifiLinkThroughputListener r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_wifi_ICaeSmartNetworkManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterLinkThroughputListener(r6);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public void unregisterSecondaryWifiListener(ISecondaryWifiCallback r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_wifi_ICaeSmartNetworkManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 9, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterSecondaryWifiListener(r6);     // Catch: Throwable -> L17
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
            public static boolean INVOKEINTERFACE_com_obric_cae_libs_wifi_ICaeSmartNetworkManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public void requestSecondaryWifi(String r10, String r11, String r12, String r13, ISecondaryWifiCallback r14) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r10);     // Catch: Throwable -> L17
                r0.writeString(r11);     // Catch: Throwable -> L17
                r0.writeString(r12);     // Catch: Throwable -> L17
                r0.writeString(r13);     // Catch: Throwable -> L17
                if (r14 == null) goto L6;
                IBinder r2 = r14.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_wifi_ICaeSmartNetworkManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().requestSecondaryWifi(r10, r11, r12, r13, r14);     // Catch: Throwable -> L17
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
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICaeSmartNetworkManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static ICaeSmartNetworkManager asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ICaeSmartNetworkManager) == false) goto L12;
            return (ICaeSmartNetworkManager) r0;
        L12:
            return new Proxy(r2);
        }

        public static boolean setDefaultImpl(ICaeSmartNetworkManager r1) {
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
        public boolean onTransact(int r9, Parcel r10, Parcel r11, int r12) throws RemoteException {
            if (r9 == 1598968902) goto L29;
            switch(r9) {
                case 1: goto L27;
                case 2: goto L25;
                case 3: goto L23;
                case 4: goto L21;
                case 5: goto L19;
                case 6: goto L17;
                case 7: goto L15;
                case 8: goto L13;
                case 9: goto L11;
                case 10: goto L9;
                case 11: goto L7;
                default: goto L6;
            };
        L7:
            r10.enforceInterface(DESCRIPTOR);
            String r13 = getCurrentSecondarySsid();
            r11.writeNoException();
            r11.writeString(r13);
            return true;
        L9:
            r10.enforceInterface(DESCRIPTOR);
            releaseAll();
            r11.writeNoException();
            return true;
        L11:
            r10.enforceInterface(DESCRIPTOR);
            unregisterSecondaryWifiListener(ISecondaryWifiCallback.Stub.asInterface(r10.readStrongBinder()));
            r11.writeNoException();
            return true;
        L13:
            r10.enforceInterface(DESCRIPTOR);
            registerSecondaryWifiListener(ISecondaryWifiCallback.Stub.asInterface(r10.readStrongBinder()));
            r11.writeNoException();
            return true;
        L15:
            r10.enforceInterface(DESCRIPTOR);
            releaseSecondaryWifi(ISecondaryWifiCallback.Stub.asInterface(r10.readStrongBinder()));
            r11.writeNoException();
            return true;
        L17:
            r10.enforceInterface(DESCRIPTOR);
            requestSecondaryWifi(r10.readString(), r10.readString(), r10.readString(), r10.readString(), ISecondaryWifiCallback.Stub.asInterface(r10.readStrongBinder()));
            r11.writeNoException();
            return true;
        L19:
            r10.enforceInterface(DESCRIPTOR);
            float r14 = getLinkThroughputJitterWeight();
            r11.writeNoException();
            r11.writeFloat(r14);
            return true;
        L21:
            r10.enforceInterface(DESCRIPTOR);
            int r15 = getLinkThroughputJitter();
            r11.writeNoException();
            r11.writeInt(r15);
            return true;
        L23:
            r10.enforceInterface(DESCRIPTOR);
            int r16 = getLinkThroughput();
            r11.writeNoException();
            r11.writeInt(r16);
            return true;
        L25:
            r10.enforceInterface(DESCRIPTOR);
            unregisterLinkThroughputListener(ICaeWifiLinkThroughputListener.Stub.asInterface(r10.readStrongBinder()));
            r11.writeNoException();
            return true;
        L27:
            r10.enforceInterface(DESCRIPTOR);
            registerLinkThroughputListener(ICaeWifiLinkThroughputListener.Stub.asInterface(r10.readStrongBinder()));
            r11.writeNoException();
            return true;
        L6:
            return super.onTransact(r9, r10, r11, r12);
        L29:
            r11.writeString(DESCRIPTOR);
            return true;
        }
    }

    String getCurrentSecondarySsid() throws RemoteException;

    int getLinkThroughput() throws RemoteException;

    int getLinkThroughputJitter() throws RemoteException;

    float getLinkThroughputJitterWeight() throws RemoteException;

    void registerLinkThroughputListener(ICaeWifiLinkThroughputListener r1) throws RemoteException;

    void registerSecondaryWifiListener(ISecondaryWifiCallback r1) throws RemoteException;

    void releaseAll() throws RemoteException;

    void releaseSecondaryWifi(ISecondaryWifiCallback r1) throws RemoteException;

    void requestSecondaryWifi(String r1, String r2, String r3, String r4, ISecondaryWifiCallback r5) throws RemoteException;

    void unregisterLinkThroughputListener(ICaeWifiLinkThroughputListener r1) throws RemoteException;

    void unregisterSecondaryWifiListener(ISecondaryWifiCallback r1) throws RemoteException;
}
