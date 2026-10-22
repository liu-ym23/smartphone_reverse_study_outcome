package com.obric.cae.libs.nfc;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public interface ICaeNfcEventManager extends IInterface {

    public static class Default implements ICaeNfcEventManager {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public int getTransitEventAllowedAidTypes() throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public int getTransitEventSource() throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public boolean isTransitEventFilterEnabled() throws RemoteException {
            return false;
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void notifyTransitEvent(Bundle r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void registerCloudConfigCallback(ICaeNfcCloudConfigCallback r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void registerDndConfigCallback(ICaeNfcDndConfigCallback r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void registerForceFwEventCallback(ICaeNfcForceFwEventCallback r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void registerPaymentChangeCallback(ICaeNfcPaymentChangeCallback r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void registerTransitEventCallback(ICaeNfcTransitEventCallback r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void registerVendorNciEventCallback(ICaeNfcVendorNciEventCallback r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public boolean setTransitEventAllowedAidTypes(int r1) throws RemoteException {
            return false;
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public boolean setTransitEventFilterEnabled(boolean r1) throws RemoteException {
            return false;
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public boolean setTransitEventSource(int r1) throws RemoteException {
            return false;
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void unregisterCloudConfigCallback(ICaeNfcCloudConfigCallback r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void unregisterDndConfigCallback(ICaeNfcDndConfigCallback r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void unregisterForceFwEventCallback(ICaeNfcForceFwEventCallback r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void unregisterPaymentChangeCallback(ICaeNfcPaymentChangeCallback r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void unregisterTransitEventCallback(ICaeNfcTransitEventCallback r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void unregisterVendorNciEventCallback(ICaeNfcVendorNciEventCallback r1) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ICaeNfcEventManager {
        private static final String DESCRIPTOR = "com.obric.cae.libs.nfc.ICaeNfcEventManager";
        static final int TRANSACTION_getTransitEventAllowedAidTypes = 19;
        static final int TRANSACTION_getTransitEventSource = 15;
        static final int TRANSACTION_isTransitEventFilterEnabled = 17;
        static final int TRANSACTION_notifyTransitEvent = 13;
        static final int TRANSACTION_registerCloudConfigCallback = 1;
        static final int TRANSACTION_registerDndConfigCallback = 3;
        static final int TRANSACTION_registerForceFwEventCallback = 5;
        static final int TRANSACTION_registerPaymentChangeCallback = 11;
        static final int TRANSACTION_registerTransitEventCallback = 7;
        static final int TRANSACTION_registerVendorNciEventCallback = 9;
        static final int TRANSACTION_setTransitEventAllowedAidTypes = 18;
        static final int TRANSACTION_setTransitEventFilterEnabled = 16;
        static final int TRANSACTION_setTransitEventSource = 14;
        static final int TRANSACTION_unregisterCloudConfigCallback = 2;
        static final int TRANSACTION_unregisterDndConfigCallback = 4;
        static final int TRANSACTION_unregisterForceFwEventCallback = 6;
        static final int TRANSACTION_unregisterPaymentChangeCallback = 12;
        static final int TRANSACTION_unregisterTransitEventCallback = 8;
        static final int TRANSACTION_unregisterVendorNciEventCallback = 10;

        public static class Proxy implements ICaeNfcEventManager {
            public static ICaeNfcEventManager sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public int getTransitEventAllowedAidTypes() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_nfc_ICaeNfcEventManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 19, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r2 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r3 = Stub.getDefaultImpl().getTransitEventAllowedAidTypes();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r3;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public int getTransitEventSource() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_nfc_ICaeNfcEventManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 15, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r2 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r3 = Stub.getDefaultImpl().getTransitEventSource();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r3;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public boolean isTransitEventFilterEnabled() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r4 = false;
                if (INVOKEINTERFACE_com_obric_cae_libs_nfc_ICaeNfcEventManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 17, r0, r1, 0) == false) goto L6;
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
                boolean r2 = Stub.getDefaultImpl().isTransitEventFilterEnabled();     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r2;
            L15:
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

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void notifyTransitEvent(Bundle r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L8:
                if (INVOKEINTERFACE_com_obric_cae_libs_nfc_ICaeNfcEventManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 13, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().notifyTransitEvent(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void registerCloudConfigCallback(ICaeNfcCloudConfigCallback r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_nfc_ICaeNfcEventManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerCloudConfigCallback(r6);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void registerDndConfigCallback(ICaeNfcDndConfigCallback r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_nfc_ICaeNfcEventManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerDndConfigCallback(r6);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void registerForceFwEventCallback(ICaeNfcForceFwEventCallback r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_nfc_ICaeNfcEventManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerForceFwEventCallback(r6);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void registerPaymentChangeCallback(ICaeNfcPaymentChangeCallback r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_nfc_ICaeNfcEventManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 11, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerPaymentChangeCallback(r6);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void registerTransitEventCallback(ICaeNfcTransitEventCallback r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_nfc_ICaeNfcEventManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerTransitEventCallback(r6);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void registerVendorNciEventCallback(ICaeNfcVendorNciEventCallback r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_nfc_ICaeNfcEventManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 9, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerVendorNciEventCallback(r6);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public boolean setTransitEventAllowedAidTypes(int r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeInt(r6);     // Catch: Throwable -> L15
                boolean r4 = false;
                if (INVOKEINTERFACE_com_obric_cae_libs_nfc_ICaeNfcEventManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 18, r0, r1, 0) == false) goto L6;
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
                boolean r7 = Stub.getDefaultImpl().setTransitEventAllowedAidTypes(r6);     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r7;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public boolean setTransitEventFilterEnabled(boolean r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeInt(r6 ? 1 : 0);     // Catch: Throwable -> L15
                boolean r4 = false;
                if (INVOKEINTERFACE_com_obric_cae_libs_nfc_ICaeNfcEventManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 16, r0, r1, 0) == false) goto L6;
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
                boolean r7 = Stub.getDefaultImpl().setTransitEventFilterEnabled(r6);     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r7;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public boolean setTransitEventSource(int r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeInt(r6);     // Catch: Throwable -> L15
                boolean r4 = false;
                if (INVOKEINTERFACE_com_obric_cae_libs_nfc_ICaeNfcEventManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 14, r0, r1, 0) == false) goto L6;
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
                boolean r7 = Stub.getDefaultImpl().setTransitEventSource(r6);     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r7;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void unregisterCloudConfigCallback(ICaeNfcCloudConfigCallback r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_nfc_ICaeNfcEventManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterCloudConfigCallback(r6);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void unregisterDndConfigCallback(ICaeNfcDndConfigCallback r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_nfc_ICaeNfcEventManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterDndConfigCallback(r6);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void unregisterForceFwEventCallback(ICaeNfcForceFwEventCallback r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_nfc_ICaeNfcEventManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterForceFwEventCallback(r6);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void unregisterPaymentChangeCallback(ICaeNfcPaymentChangeCallback r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_nfc_ICaeNfcEventManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 12, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterPaymentChangeCallback(r6);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void unregisterTransitEventCallback(ICaeNfcTransitEventCallback r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_nfc_ICaeNfcEventManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterTransitEventCallback(r6);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void unregisterVendorNciEventCallback(ICaeNfcVendorNciEventCallback r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_nfc_ICaeNfcEventManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 10, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterVendorNciEventCallback(r6);     // Catch: Throwable -> L17
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
            public static boolean INVOKEINTERFACE_com_obric_cae_libs_nfc_ICaeNfcEventManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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

        public static ICaeNfcEventManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static ICaeNfcEventManager asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ICaeNfcEventManager) == false) goto L12;
            return (ICaeNfcEventManager) r0;
        L12:
            return new Proxy(r2);
        }

        public static boolean setDefaultImpl(ICaeNfcEventManager r1) {
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
            if (r4 == 1598968902) goto L53;
            switch(r4) {
                case 1: goto L51;
                case 2: goto L49;
                case 3: goto L47;
                case 4: goto L45;
                case 5: goto L43;
                case 6: goto L41;
                case 7: goto L39;
                case 8: goto L37;
                case 9: goto L35;
                case 10: goto L33;
                case 11: goto L31;
                case 12: goto L29;
                case 13: goto L23;
                case 14: goto L21;
                case 15: goto L19;
                case 16: goto L13;
                case 17: goto L11;
                case 18: goto L9;
                case 19: goto L7;
                default: goto L6;
            };
        L7:
            r5.enforceInterface(DESCRIPTOR);
            int r8 = getTransitEventAllowedAidTypes();
            r6.writeNoException();
            r6.writeInt(r8);
            return true;
        L9:
            r5.enforceInterface(DESCRIPTOR);
            boolean r9 = setTransitEventAllowedAidTypes(r5.readInt());
            r6.writeNoException();
            r6.writeInt(r9 ? 1 : 0);
            return true;
        L11:
            r5.enforceInterface(DESCRIPTOR);
            boolean r10 = isTransitEventFilterEnabled();
            r6.writeNoException();
            r6.writeInt(r10 ? 1 : 0);
            return true;
        L13:
            r5.enforceInterface(DESCRIPTOR);
            if (r5.readInt() == 0) goto L16;
            boolean r11 = true;
        L17:
            boolean r12 = setTransitEventFilterEnabled(r11);
            r6.writeNoException();
            r6.writeInt(r12 ? 1 : 0);
            return true;
        L16:
            r11 = false;
            goto L17
        L19:
            r5.enforceInterface(DESCRIPTOR);
            int r13 = getTransitEventSource();
            r6.writeNoException();
            r6.writeInt(r13);
            return true;
        L21:
            r5.enforceInterface(DESCRIPTOR);
            boolean r14 = setTransitEventSource(r5.readInt());
            r6.writeNoException();
            r6.writeInt(r14 ? 1 : 0);
            return true;
        L23:
            r5.enforceInterface(DESCRIPTOR);
            if (r5.readInt() == 0) goto L26;
            Bundle r15 = (Bundle) Bundle.CREATOR.createFromParcel(r5);
        L27:
            notifyTransitEvent(r15);
            return true;
        L26:
            r15 = null;
            goto L27
        L29:
            r5.enforceInterface(DESCRIPTOR);
            unregisterPaymentChangeCallback(ICaeNfcPaymentChangeCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L31:
            r5.enforceInterface(DESCRIPTOR);
            registerPaymentChangeCallback(ICaeNfcPaymentChangeCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L33:
            r5.enforceInterface(DESCRIPTOR);
            unregisterVendorNciEventCallback(ICaeNfcVendorNciEventCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L35:
            r5.enforceInterface(DESCRIPTOR);
            registerVendorNciEventCallback(ICaeNfcVendorNciEventCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L37:
            r5.enforceInterface(DESCRIPTOR);
            unregisterTransitEventCallback(ICaeNfcTransitEventCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L39:
            r5.enforceInterface(DESCRIPTOR);
            registerTransitEventCallback(ICaeNfcTransitEventCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L41:
            r5.enforceInterface(DESCRIPTOR);
            unregisterForceFwEventCallback(ICaeNfcForceFwEventCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L43:
            r5.enforceInterface(DESCRIPTOR);
            registerForceFwEventCallback(ICaeNfcForceFwEventCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L45:
            r5.enforceInterface(DESCRIPTOR);
            unregisterDndConfigCallback(ICaeNfcDndConfigCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L47:
            r5.enforceInterface(DESCRIPTOR);
            registerDndConfigCallback(ICaeNfcDndConfigCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L49:
            r5.enforceInterface(DESCRIPTOR);
            unregisterCloudConfigCallback(ICaeNfcCloudConfigCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L51:
            r5.enforceInterface(DESCRIPTOR);
            registerCloudConfigCallback(ICaeNfcCloudConfigCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L6:
            return super.onTransact(r4, r5, r6, r7);
        L53:
            r6.writeString(DESCRIPTOR);
            return true;
        }
    }

    int getTransitEventAllowedAidTypes() throws RemoteException;

    int getTransitEventSource() throws RemoteException;

    boolean isTransitEventFilterEnabled() throws RemoteException;

    void notifyTransitEvent(Bundle r1) throws RemoteException;

    void registerCloudConfigCallback(ICaeNfcCloudConfigCallback r1) throws RemoteException;

    void registerDndConfigCallback(ICaeNfcDndConfigCallback r1) throws RemoteException;

    void registerForceFwEventCallback(ICaeNfcForceFwEventCallback r1) throws RemoteException;

    void registerPaymentChangeCallback(ICaeNfcPaymentChangeCallback r1) throws RemoteException;

    void registerTransitEventCallback(ICaeNfcTransitEventCallback r1) throws RemoteException;

    void registerVendorNciEventCallback(ICaeNfcVendorNciEventCallback r1) throws RemoteException;

    boolean setTransitEventAllowedAidTypes(int r1) throws RemoteException;

    boolean setTransitEventFilterEnabled(boolean r1) throws RemoteException;

    boolean setTransitEventSource(int r1) throws RemoteException;

    void unregisterCloudConfigCallback(ICaeNfcCloudConfigCallback r1) throws RemoteException;

    void unregisterDndConfigCallback(ICaeNfcDndConfigCallback r1) throws RemoteException;

    void unregisterForceFwEventCallback(ICaeNfcForceFwEventCallback r1) throws RemoteException;

    void unregisterPaymentChangeCallback(ICaeNfcPaymentChangeCallback r1) throws RemoteException;

    void unregisterTransitEventCallback(ICaeNfcTransitEventCallback r1) throws RemoteException;

    void unregisterVendorNciEventCallback(ICaeNfcVendorNciEventCallback r1) throws RemoteException;
}
