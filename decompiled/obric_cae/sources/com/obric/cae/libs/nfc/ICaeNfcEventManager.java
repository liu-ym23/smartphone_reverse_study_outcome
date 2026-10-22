package com.obric.cae.libs.nfc;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface ICaeNfcEventManager extends IInterface {

    public static class Default implements ICaeNfcEventManager {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public int getTransitEventAllowedAidTypes() {
            return 0;
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public int getTransitEventSource() {
            return 0;
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public boolean isTransitEventFilterEnabled() {
            return false;
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void notifyTeaEvent(String r8, Bundle r10) {
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void notifyTransitEvent(Bundle r8) {
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void registerCloudConfigCallback(ICaeNfcCloudConfigCallback r8) {
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void registerDndConfigCallback(ICaeNfcDndConfigCallback r8) {
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void registerForceFwEventCallback(ICaeNfcForceFwEventCallback r8) {
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void registerPaymentChangeCallback(ICaeNfcPaymentChangeCallback r8) {
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void registerTransitEventCallback(ICaeNfcTransitEventCallback r8) {
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void registerVendorNciEventCallback(ICaeNfcVendorNciEventCallback r8) {
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public boolean setTransitEventAllowedAidTypes(int r8) {
            return false;
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public boolean setTransitEventFilterEnabled(boolean r8) {
            return false;
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public boolean setTransitEventSource(int r8) {
            return false;
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void unregisterCloudConfigCallback(ICaeNfcCloudConfigCallback r8) {
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void unregisterDndConfigCallback(ICaeNfcDndConfigCallback r8) {
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void unregisterForceFwEventCallback(ICaeNfcForceFwEventCallback r8) {
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void unregisterPaymentChangeCallback(ICaeNfcPaymentChangeCallback r8) {
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void unregisterTransitEventCallback(ICaeNfcTransitEventCallback r8) {
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void unregisterVendorNciEventCallback(ICaeNfcVendorNciEventCallback r8) {
        }
    }

    public static abstract class Stub extends Binder implements ICaeNfcEventManager {
        private static final String DESCRIPTOR = "com.obric.cae.libs.nfc.ICaeNfcEventManager";
        static final int TRANSACTION_getTransitEventAllowedAidTypes = 20;
        static final int TRANSACTION_getTransitEventSource = 16;
        static final int TRANSACTION_isTransitEventFilterEnabled = 18;
        static final int TRANSACTION_notifyTeaEvent = 14;
        static final int TRANSACTION_notifyTransitEvent = 13;
        static final int TRANSACTION_registerCloudConfigCallback = 1;
        static final int TRANSACTION_registerDndConfigCallback = 3;
        static final int TRANSACTION_registerForceFwEventCallback = 5;
        static final int TRANSACTION_registerPaymentChangeCallback = 11;
        static final int TRANSACTION_registerTransitEventCallback = 7;
        static final int TRANSACTION_registerVendorNciEventCallback = 9;
        static final int TRANSACTION_setTransitEventAllowedAidTypes = 19;
        static final int TRANSACTION_setTransitEventFilterEnabled = 17;
        static final int TRANSACTION_setTransitEventSource = 15;
        static final int TRANSACTION_unregisterCloudConfigCallback = 2;
        static final int TRANSACTION_unregisterDndConfigCallback = 4;
        static final int TRANSACTION_unregisterForceFwEventCallback = 6;
        static final int TRANSACTION_unregisterPaymentChangeCallback = 12;
        static final int TRANSACTION_unregisterTransitEventCallback = 8;
        static final int TRANSACTION_unregisterVendorNciEventCallback = 10;

        public static class Proxy implements ICaeNfcEventManager {
            public static ICaeNfcEventManager sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r8) {
                this.mRemote = r8;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public int getTransitEventAllowedAidTypes() {
                Parcel r8 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(20, r8, r10, 0) == false) goto L6;
            L10:
                r10.readException();     // Catch: Throwable -> L12
                int r11 = r10.readInt();     // Catch: Throwable -> L12
            L8:
                r10.recycle();
                r8.recycle();
                return r11;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r11 = Stub.getDefaultImpl().getTransitEventAllowedAidTypes();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public int getTransitEventSource() {
                Parcel r8 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(16, r8, r10, 0) == false) goto L6;
            L10:
                r10.readException();     // Catch: Throwable -> L12
                int r11 = r10.readInt();     // Catch: Throwable -> L12
            L8:
                r10.recycle();
                r8.recycle();
                return r11;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r11 = Stub.getDefaultImpl().getTransitEventSource();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public boolean isTransitEventFilterEnabled() {
                Parcel r8 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r11 = false;
                if (this.mRemote.transact(18, r8, r10, 0) == false) goto L6;
            L10:
                r10.readException();     // Catch: Throwable -> L15
                if (r10.readInt() == 0) goto L13;
                r11 = true;
            L13:
                r10.recycle();
                r8.recycle();
                return r11;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r12 = Stub.getDefaultImpl().isTransitEventFilterEnabled();     // Catch: Throwable -> L15
                r10.recycle();
                r8.recycle();
                return r12;
            L15:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void notifyTeaEvent(String r8, Bundle r10) {
                Parcel r11 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r11.writeString(r8);     // Catch: Throwable -> L16
                if (r10 == null) goto L6;
                r11.writeInt(1);     // Catch: Throwable -> L16
                r10.writeToParcel(r11, 0);     // Catch: Throwable -> L16
            L8:
                if (this.mRemote.transact(14, r11, null, 1) == false) goto L10;
            L14:
                r11.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().notifyTeaEvent(r8, r10);     // Catch: Throwable -> L16
                r11.recycle();
                return;
            L6:
                r11.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r11.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void notifyTransitEvent(Bundle r8) {
                Parcel r10 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r8 == null) goto L6;
                r10.writeInt(1);     // Catch: Throwable -> L16
                r8.writeToParcel(r10, 0);     // Catch: Throwable -> L16
            L8:
                if (this.mRemote.transact(13, r10, null, 1) == false) goto L10;
            L14:
                r10.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().notifyTransitEvent(r8);     // Catch: Throwable -> L16
                r10.recycle();
                return;
            L6:
                r10.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r10.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void registerCloudConfigCallback(ICaeNfcCloudConfigCallback r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r8 == null) goto L6;
                IBinder r12 = r8.asBinder();     // Catch: Throwable -> L16
            L7:
                r10.writeStrongBinder(r12);     // Catch: Throwable -> L16
                if (this.mRemote.transact(1, r10, r11, 0) == false) goto L10;
            L14:
                r11.readException();     // Catch: Throwable -> L16
            L12:
                r11.recycle();
                r10.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerCloudConfigCallback(r8);     // Catch: Throwable -> L16
                goto L12
            L6:
                r12 = null;
            L16:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void registerDndConfigCallback(ICaeNfcDndConfigCallback r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r8 == null) goto L6;
                IBinder r12 = r8.asBinder();     // Catch: Throwable -> L16
            L7:
                r10.writeStrongBinder(r12);     // Catch: Throwable -> L16
                if (this.mRemote.transact(3, r10, r11, 0) == false) goto L10;
            L14:
                r11.readException();     // Catch: Throwable -> L16
            L12:
                r11.recycle();
                r10.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerDndConfigCallback(r8);     // Catch: Throwable -> L16
                goto L12
            L6:
                r12 = null;
            L16:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void registerForceFwEventCallback(ICaeNfcForceFwEventCallback r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r8 == null) goto L6;
                IBinder r12 = r8.asBinder();     // Catch: Throwable -> L16
            L7:
                r10.writeStrongBinder(r12);     // Catch: Throwable -> L16
                if (this.mRemote.transact(5, r10, r11, 0) == false) goto L10;
            L14:
                r11.readException();     // Catch: Throwable -> L16
            L12:
                r11.recycle();
                r10.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerForceFwEventCallback(r8);     // Catch: Throwable -> L16
                goto L12
            L6:
                r12 = null;
            L16:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void registerPaymentChangeCallback(ICaeNfcPaymentChangeCallback r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r8 == null) goto L6;
                IBinder r12 = r8.asBinder();     // Catch: Throwable -> L16
            L7:
                r10.writeStrongBinder(r12);     // Catch: Throwable -> L16
                if (this.mRemote.transact(11, r10, r11, 0) == false) goto L10;
            L14:
                r11.readException();     // Catch: Throwable -> L16
            L12:
                r11.recycle();
                r10.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerPaymentChangeCallback(r8);     // Catch: Throwable -> L16
                goto L12
            L6:
                r12 = null;
            L16:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void registerTransitEventCallback(ICaeNfcTransitEventCallback r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r8 == null) goto L6;
                IBinder r12 = r8.asBinder();     // Catch: Throwable -> L16
            L7:
                r10.writeStrongBinder(r12);     // Catch: Throwable -> L16
                if (this.mRemote.transact(7, r10, r11, 0) == false) goto L10;
            L14:
                r11.readException();     // Catch: Throwable -> L16
            L12:
                r11.recycle();
                r10.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerTransitEventCallback(r8);     // Catch: Throwable -> L16
                goto L12
            L6:
                r12 = null;
            L16:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void registerVendorNciEventCallback(ICaeNfcVendorNciEventCallback r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r8 == null) goto L6;
                IBinder r12 = r8.asBinder();     // Catch: Throwable -> L16
            L7:
                r10.writeStrongBinder(r12);     // Catch: Throwable -> L16
                if (this.mRemote.transact(9, r10, r11, 0) == false) goto L10;
            L14:
                r11.readException();     // Catch: Throwable -> L16
            L12:
                r11.recycle();
                r10.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerVendorNciEventCallback(r8);     // Catch: Throwable -> L16
                goto L12
            L6:
                r12 = null;
            L16:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public boolean setTransitEventAllowedAidTypes(int r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r10.writeInt(r8);     // Catch: Throwable -> L15
                boolean r12 = false;
                if (this.mRemote.transact(19, r10, r11, 0) == false) goto L6;
            L10:
                r11.readException();     // Catch: Throwable -> L15
                if (r11.readInt() == 0) goto L13;
                r12 = true;
            L13:
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r13 = Stub.getDefaultImpl().setTransitEventAllowedAidTypes(r8);     // Catch: Throwable -> L15
                r11.recycle();
                r10.recycle();
                return r13;
            L15:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public boolean setTransitEventFilterEnabled(boolean r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r10.writeInt(r8 ? 1 : 0);     // Catch: Throwable -> L15
                boolean r12 = false;
                if (this.mRemote.transact(17, r10, r11, 0) == false) goto L6;
            L10:
                r11.readException();     // Catch: Throwable -> L15
                if (r11.readInt() == 0) goto L13;
                r12 = true;
            L13:
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r13 = Stub.getDefaultImpl().setTransitEventFilterEnabled(r8);     // Catch: Throwable -> L15
                r11.recycle();
                r10.recycle();
                return r13;
            L15:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public boolean setTransitEventSource(int r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r10.writeInt(r8);     // Catch: Throwable -> L15
                boolean r12 = false;
                if (this.mRemote.transact(15, r10, r11, 0) == false) goto L6;
            L10:
                r11.readException();     // Catch: Throwable -> L15
                if (r11.readInt() == 0) goto L13;
                r12 = true;
            L13:
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r13 = Stub.getDefaultImpl().setTransitEventSource(r8);     // Catch: Throwable -> L15
                r11.recycle();
                r10.recycle();
                return r13;
            L15:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void unregisterCloudConfigCallback(ICaeNfcCloudConfigCallback r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r8 == null) goto L6;
                IBinder r12 = r8.asBinder();     // Catch: Throwable -> L16
            L7:
                r10.writeStrongBinder(r12);     // Catch: Throwable -> L16
                if (this.mRemote.transact(2, r10, r11, 0) == false) goto L10;
            L14:
                r11.readException();     // Catch: Throwable -> L16
            L12:
                r11.recycle();
                r10.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterCloudConfigCallback(r8);     // Catch: Throwable -> L16
                goto L12
            L6:
                r12 = null;
            L16:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void unregisterDndConfigCallback(ICaeNfcDndConfigCallback r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r8 == null) goto L6;
                IBinder r12 = r8.asBinder();     // Catch: Throwable -> L16
            L7:
                r10.writeStrongBinder(r12);     // Catch: Throwable -> L16
                if (this.mRemote.transact(4, r10, r11, 0) == false) goto L10;
            L14:
                r11.readException();     // Catch: Throwable -> L16
            L12:
                r11.recycle();
                r10.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterDndConfigCallback(r8);     // Catch: Throwable -> L16
                goto L12
            L6:
                r12 = null;
            L16:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void unregisterForceFwEventCallback(ICaeNfcForceFwEventCallback r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r8 == null) goto L6;
                IBinder r12 = r8.asBinder();     // Catch: Throwable -> L16
            L7:
                r10.writeStrongBinder(r12);     // Catch: Throwable -> L16
                if (this.mRemote.transact(6, r10, r11, 0) == false) goto L10;
            L14:
                r11.readException();     // Catch: Throwable -> L16
            L12:
                r11.recycle();
                r10.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterForceFwEventCallback(r8);     // Catch: Throwable -> L16
                goto L12
            L6:
                r12 = null;
            L16:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void unregisterPaymentChangeCallback(ICaeNfcPaymentChangeCallback r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r8 == null) goto L6;
                IBinder r12 = r8.asBinder();     // Catch: Throwable -> L16
            L7:
                r10.writeStrongBinder(r12);     // Catch: Throwable -> L16
                if (this.mRemote.transact(12, r10, r11, 0) == false) goto L10;
            L14:
                r11.readException();     // Catch: Throwable -> L16
            L12:
                r11.recycle();
                r10.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterPaymentChangeCallback(r8);     // Catch: Throwable -> L16
                goto L12
            L6:
                r12 = null;
            L16:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void unregisterTransitEventCallback(ICaeNfcTransitEventCallback r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r8 == null) goto L6;
                IBinder r12 = r8.asBinder();     // Catch: Throwable -> L16
            L7:
                r10.writeStrongBinder(r12);     // Catch: Throwable -> L16
                if (this.mRemote.transact(8, r10, r11, 0) == false) goto L10;
            L14:
                r11.readException();     // Catch: Throwable -> L16
            L12:
                r11.recycle();
                r10.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterTransitEventCallback(r8);     // Catch: Throwable -> L16
                goto L12
            L6:
                r12 = null;
            L16:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void unregisterVendorNciEventCallback(ICaeNfcVendorNciEventCallback r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r8 == null) goto L6;
                IBinder r12 = r8.asBinder();     // Catch: Throwable -> L16
            L7:
                r10.writeStrongBinder(r12);     // Catch: Throwable -> L16
                if (this.mRemote.transact(10, r10, r11, 0) == false) goto L10;
            L14:
                r11.readException();     // Catch: Throwable -> L16
            L12:
                r11.recycle();
                r10.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterVendorNciEventCallback(r8);     // Catch: Throwable -> L16
                goto L12
            L6:
                r12 = null;
            L16:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICaeNfcEventManager asInterface(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface(DESCRIPTOR);
            if (r10 == null) goto L12;
            if ((r10 instanceof ICaeNfcEventManager) == false) goto L12;
            return (ICaeNfcEventManager) r10;
        L12:
            return new Proxy(r8);
        }

        public static ICaeNfcEventManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICaeNfcEventManager r8) {
            if (Proxy.sDefaultImpl != null) goto L10;
            if (r8 == null) goto L7;
            Proxy.sDefaultImpl = r8;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r8, Parcel r10, Parcel r11, int r12) {
            if (r8 == 1598968902) goto L58;
            Bundle r13 = null;
            switch(r8) {
                case 1: goto L56;
                case 2: goto L54;
                case 3: goto L52;
                case 4: goto L50;
                case 5: goto L48;
                case 6: goto L46;
                case 7: goto L44;
                case 8: goto L42;
                case 9: goto L40;
                case 10: goto L38;
                case 11: goto L36;
                case 12: goto L34;
                case 13: goto L29;
                case 14: goto L24;
                case 15: goto L22;
                case 16: goto L20;
                case 17: goto L14;
                case 18: goto L12;
                case 19: goto L10;
                case 20: goto L8;
                default: goto L7;
            };
        L8:
            r10.enforceInterface(DESCRIPTOR);
            int r14 = getTransitEventAllowedAidTypes();
            r11.writeNoException();
            r11.writeInt(r14);
            return true;
        L10:
            r10.enforceInterface(DESCRIPTOR);
            boolean r15 = setTransitEventAllowedAidTypes(r10.readInt());
            r11.writeNoException();
            r11.writeInt(r15 ? 1 : 0);
            return true;
        L12:
            r10.enforceInterface(DESCRIPTOR);
            boolean r16 = isTransitEventFilterEnabled();
            r11.writeNoException();
            r11.writeInt(r16 ? 1 : 0);
            return true;
        L14:
            r10.enforceInterface(DESCRIPTOR);
            if (r10.readInt() == 0) goto L17;
            boolean r17 = true;
        L18:
            boolean r18 = setTransitEventFilterEnabled(r17);
            r11.writeNoException();
            r11.writeInt(r18 ? 1 : 0);
            return true;
        L17:
            r17 = false;
            goto L18
        L20:
            r10.enforceInterface(DESCRIPTOR);
            int r19 = getTransitEventSource();
            r11.writeNoException();
            r11.writeInt(r19);
            return true;
        L22:
            r10.enforceInterface(DESCRIPTOR);
            boolean r20 = setTransitEventSource(r10.readInt());
            r11.writeNoException();
            r11.writeInt(r20 ? 1 : 0);
            return true;
        L24:
            r10.enforceInterface(DESCRIPTOR);
            String r21 = r10.readString();
            if (r10.readInt() == 0) goto L27;
            r13 = (Bundle) Bundle.CREATOR.createFromParcel(r10);
        L27:
            notifyTeaEvent(r21, r13);
            return true;
        L29:
            r10.enforceInterface(DESCRIPTOR);
            if (r10.readInt() == 0) goto L32;
            r13 = (Bundle) Bundle.CREATOR.createFromParcel(r10);
        L32:
            notifyTransitEvent(r13);
            return true;
        L34:
            r10.enforceInterface(DESCRIPTOR);
            unregisterPaymentChangeCallback(ICaeNfcPaymentChangeCallback.Stub.asInterface(r10.readStrongBinder()));
            r11.writeNoException();
            return true;
        L36:
            r10.enforceInterface(DESCRIPTOR);
            registerPaymentChangeCallback(ICaeNfcPaymentChangeCallback.Stub.asInterface(r10.readStrongBinder()));
            r11.writeNoException();
            return true;
        L38:
            r10.enforceInterface(DESCRIPTOR);
            unregisterVendorNciEventCallback(ICaeNfcVendorNciEventCallback.Stub.asInterface(r10.readStrongBinder()));
            r11.writeNoException();
            return true;
        L40:
            r10.enforceInterface(DESCRIPTOR);
            registerVendorNciEventCallback(ICaeNfcVendorNciEventCallback.Stub.asInterface(r10.readStrongBinder()));
            r11.writeNoException();
            return true;
        L42:
            r10.enforceInterface(DESCRIPTOR);
            unregisterTransitEventCallback(ICaeNfcTransitEventCallback.Stub.asInterface(r10.readStrongBinder()));
            r11.writeNoException();
            return true;
        L44:
            r10.enforceInterface(DESCRIPTOR);
            registerTransitEventCallback(ICaeNfcTransitEventCallback.Stub.asInterface(r10.readStrongBinder()));
            r11.writeNoException();
            return true;
        L46:
            r10.enforceInterface(DESCRIPTOR);
            unregisterForceFwEventCallback(ICaeNfcForceFwEventCallback.Stub.asInterface(r10.readStrongBinder()));
            r11.writeNoException();
            return true;
        L48:
            r10.enforceInterface(DESCRIPTOR);
            registerForceFwEventCallback(ICaeNfcForceFwEventCallback.Stub.asInterface(r10.readStrongBinder()));
            r11.writeNoException();
            return true;
        L50:
            r10.enforceInterface(DESCRIPTOR);
            unregisterDndConfigCallback(ICaeNfcDndConfigCallback.Stub.asInterface(r10.readStrongBinder()));
            r11.writeNoException();
            return true;
        L52:
            r10.enforceInterface(DESCRIPTOR);
            registerDndConfigCallback(ICaeNfcDndConfigCallback.Stub.asInterface(r10.readStrongBinder()));
            r11.writeNoException();
            return true;
        L54:
            r10.enforceInterface(DESCRIPTOR);
            unregisterCloudConfigCallback(ICaeNfcCloudConfigCallback.Stub.asInterface(r10.readStrongBinder()));
            r11.writeNoException();
            return true;
        L56:
            r10.enforceInterface(DESCRIPTOR);
            registerCloudConfigCallback(ICaeNfcCloudConfigCallback.Stub.asInterface(r10.readStrongBinder()));
            r11.writeNoException();
            return true;
        L7:
            return super.onTransact(r8, r10, r11, r12);
        L58:
            r11.writeString(DESCRIPTOR);
            return true;
        }
    }

    int getTransitEventAllowedAidTypes();

    int getTransitEventSource();

    boolean isTransitEventFilterEnabled();

    void notifyTeaEvent(String r8, Bundle r10);

    void notifyTransitEvent(Bundle r8);

    void registerCloudConfigCallback(ICaeNfcCloudConfigCallback r8);

    void registerDndConfigCallback(ICaeNfcDndConfigCallback r8);

    void registerForceFwEventCallback(ICaeNfcForceFwEventCallback r8);

    void registerPaymentChangeCallback(ICaeNfcPaymentChangeCallback r8);

    void registerTransitEventCallback(ICaeNfcTransitEventCallback r8);

    void registerVendorNciEventCallback(ICaeNfcVendorNciEventCallback r8);

    boolean setTransitEventAllowedAidTypes(int r8);

    boolean setTransitEventFilterEnabled(boolean r8);

    boolean setTransitEventSource(int r8);

    void unregisterCloudConfigCallback(ICaeNfcCloudConfigCallback r8);

    void unregisterDndConfigCallback(ICaeNfcDndConfigCallback r8);

    void unregisterForceFwEventCallback(ICaeNfcForceFwEventCallback r8);

    void unregisterPaymentChangeCallback(ICaeNfcPaymentChangeCallback r8);

    void unregisterTransitEventCallback(ICaeNfcTransitEventCallback r8);

    void unregisterVendorNciEventCallback(ICaeNfcVendorNciEventCallback r8);
}
