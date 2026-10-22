package com.obric.cae.libs.wifi;

import android.net.wifi.ScanResult;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface ICaeSmartNetworkManager extends IInterface {

    public static class Default implements ICaeSmartNetworkManager {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public String getCurrentSecondarySsid() {
            return null;
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public int getLinkThroughput() {
            return 0;
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public int getLinkThroughputJitter() {
            return 0;
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public float getLinkThroughputJitterWeight() {
            return 0.0f;
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public List<ScanResult> getSecondaryWifiList() {
            return null;
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public void registerLinkThroughputListener(ICaeWifiLinkThroughputListener r8) {
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public void registerSecondaryWifiListener(ISecondaryWifiCallback r8) {
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public void releaseAll() {
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public void releaseSecondaryWifi(ISecondaryWifiCallback r8) {
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public void requestSecondaryWifi(String r8, String r10, String r11, String r12, ISecondaryWifiCallback r13) {
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public void unregisterLinkThroughputListener(ICaeWifiLinkThroughputListener r8) {
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public void unregisterSecondaryWifiListener(ISecondaryWifiCallback r8) {
        }
    }

    public static abstract class Stub extends Binder implements ICaeSmartNetworkManager {
        private static final String DESCRIPTOR = "com.obric.cae.libs.wifi.ICaeSmartNetworkManager";
        static final int TRANSACTION_getCurrentSecondarySsid = 11;
        static final int TRANSACTION_getLinkThroughput = 3;
        static final int TRANSACTION_getLinkThroughputJitter = 4;
        static final int TRANSACTION_getLinkThroughputJitterWeight = 5;
        static final int TRANSACTION_getSecondaryWifiList = 12;
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

            public Proxy(IBinder r8) {
                this.mRemote = r8;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public String getCurrentSecondarySsid() {
                Parcel r8 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(11, r8, r10, 0) == false) goto L6;
            L10:
                r10.readException();     // Catch: Throwable -> L12
                String r11 = r10.readString();     // Catch: Throwable -> L12
            L8:
                r10.recycle();
                r8.recycle();
                return r11;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r11 = Stub.getDefaultImpl().getCurrentSecondarySsid();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public int getLinkThroughput() {
                Parcel r8 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(3, r8, r10, 0) == false) goto L6;
            L10:
                r10.readException();     // Catch: Throwable -> L12
                int r11 = r10.readInt();     // Catch: Throwable -> L12
            L8:
                r10.recycle();
                r8.recycle();
                return r11;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r11 = Stub.getDefaultImpl().getLinkThroughput();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public int getLinkThroughputJitter() {
                Parcel r8 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(4, r8, r10, 0) == false) goto L6;
            L10:
                r10.readException();     // Catch: Throwable -> L12
                int r11 = r10.readInt();     // Catch: Throwable -> L12
            L8:
                r10.recycle();
                r8.recycle();
                return r11;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r11 = Stub.getDefaultImpl().getLinkThroughputJitter();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public float getLinkThroughputJitterWeight() {
                Parcel r8 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(5, r8, r10, 0) == false) goto L6;
            L10:
                r10.readException();     // Catch: Throwable -> L12
                float r11 = r10.readFloat();     // Catch: Throwable -> L12
            L8:
                r10.recycle();
                r8.recycle();
                return r11;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r11 = Stub.getDefaultImpl().getLinkThroughputJitterWeight();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public List<ScanResult> getSecondaryWifiList() {
                Parcel r8 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(12, r8, r10, 0) == false) goto L6;
            L10:
                r10.readException();     // Catch: Throwable -> L12
                List<ScanResult> r11 = r10.createTypedArrayList(ScanResult.CREATOR);     // Catch: Throwable -> L12
            L8:
                r10.recycle();
                r8.recycle();
                return r11;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r11 = Stub.getDefaultImpl().getSecondaryWifiList();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public void registerLinkThroughputListener(ICaeWifiLinkThroughputListener r8) {
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
                Stub.getDefaultImpl().registerLinkThroughputListener(r8);     // Catch: Throwable -> L16
                goto L12
            L6:
                r12 = null;
            L16:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public void registerSecondaryWifiListener(ISecondaryWifiCallback r8) {
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
                Stub.getDefaultImpl().registerSecondaryWifiListener(r8);     // Catch: Throwable -> L16
                goto L12
            L6:
                r12 = null;
            L16:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public void releaseAll() {
                Parcel r8 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(10, r8, r10, 0) == false) goto L6;
            L10:
                r10.readException();     // Catch: Throwable -> L12
            L8:
                r10.recycle();
                r8.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().releaseAll();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public void releaseSecondaryWifi(ISecondaryWifiCallback r8) {
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
                Stub.getDefaultImpl().releaseSecondaryWifi(r8);     // Catch: Throwable -> L16
                goto L12
            L6:
                r12 = null;
            L16:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public void requestSecondaryWifi(String r10, String r11, String r12, String r13, ISecondaryWifiCallback r14) {
                Parcel r8 = Parcel.obtain();
                Parcel r15 = Parcel.obtain();
                r8.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r8.writeString(r10);     // Catch: Throwable -> L16
                r8.writeString(r11);     // Catch: Throwable -> L16
                r8.writeString(r12);     // Catch: Throwable -> L16
                r8.writeString(r13);     // Catch: Throwable -> L16
                if (r14 == null) goto L6;
                IBinder r16 = r14.asBinder();     // Catch: Throwable -> L16
            L7:
                r8.writeStrongBinder(r16);     // Catch: Throwable -> L16
                if (this.mRemote.transact(6, r8, r15, 0) == false) goto L10;
            L14:
                r15.readException();     // Catch: Throwable -> L16
            L12:
                r15.recycle();
                r8.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().requestSecondaryWifi(r10, r11, r12, r13, r14);     // Catch: Throwable -> L16
                goto L12
            L6:
                r16 = null;
            L16:
                th = move-exception;
                r15.recycle();
                r8.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public void unregisterLinkThroughputListener(ICaeWifiLinkThroughputListener r8) {
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
                Stub.getDefaultImpl().unregisterLinkThroughputListener(r8);     // Catch: Throwable -> L16
                goto L12
            L6:
                r12 = null;
            L16:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public void unregisterSecondaryWifiListener(ISecondaryWifiCallback r8) {
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
                Stub.getDefaultImpl().unregisterSecondaryWifiListener(r8);     // Catch: Throwable -> L16
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

        public static ICaeSmartNetworkManager asInterface(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface(DESCRIPTOR);
            if (r10 == null) goto L12;
            if ((r10 instanceof ICaeSmartNetworkManager) == false) goto L12;
            return (ICaeSmartNetworkManager) r10;
        L12:
            return new Proxy(r8);
        }

        public static ICaeSmartNetworkManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICaeSmartNetworkManager r8) {
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
        public boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) {
            if (r10 == 1598968902) goto L31;
            switch(r10) {
                case 1: goto L29;
                case 2: goto L27;
                case 3: goto L25;
                case 4: goto L23;
                case 5: goto L21;
                case 6: goto L19;
                case 7: goto L17;
                case 8: goto L15;
                case 9: goto L13;
                case 10: goto L11;
                case 11: goto L9;
                case 12: goto L7;
                default: goto L6;
            };
        L7:
            r11.enforceInterface(DESCRIPTOR);
            List<ScanResult> r8 = getSecondaryWifiList();
            r12.writeNoException();
            r12.writeTypedList(r8);
            return true;
        L9:
            r11.enforceInterface(DESCRIPTOR);
            String r14 = getCurrentSecondarySsid();
            r12.writeNoException();
            r12.writeString(r14);
            return true;
        L11:
            r11.enforceInterface(DESCRIPTOR);
            releaseAll();
            r12.writeNoException();
            return true;
        L13:
            r11.enforceInterface(DESCRIPTOR);
            unregisterSecondaryWifiListener(ISecondaryWifiCallback.Stub.asInterface(r11.readStrongBinder()));
            r12.writeNoException();
            return true;
        L15:
            r11.enforceInterface(DESCRIPTOR);
            registerSecondaryWifiListener(ISecondaryWifiCallback.Stub.asInterface(r11.readStrongBinder()));
            r12.writeNoException();
            return true;
        L17:
            r11.enforceInterface(DESCRIPTOR);
            releaseSecondaryWifi(ISecondaryWifiCallback.Stub.asInterface(r11.readStrongBinder()));
            r12.writeNoException();
            return true;
        L19:
            r11.enforceInterface(DESCRIPTOR);
            requestSecondaryWifi(r11.readString(), r11.readString(), r11.readString(), r11.readString(), ISecondaryWifiCallback.Stub.asInterface(r11.readStrongBinder()));
            r12.writeNoException();
            return true;
        L21:
            r11.enforceInterface(DESCRIPTOR);
            float r15 = getLinkThroughputJitterWeight();
            r12.writeNoException();
            r12.writeFloat(r15);
            return true;
        L23:
            r11.enforceInterface(DESCRIPTOR);
            int r16 = getLinkThroughputJitter();
            r12.writeNoException();
            r12.writeInt(r16);
            return true;
        L25:
            r11.enforceInterface(DESCRIPTOR);
            int r17 = getLinkThroughput();
            r12.writeNoException();
            r12.writeInt(r17);
            return true;
        L27:
            r11.enforceInterface(DESCRIPTOR);
            unregisterLinkThroughputListener(ICaeWifiLinkThroughputListener.Stub.asInterface(r11.readStrongBinder()));
            r12.writeNoException();
            return true;
        L29:
            r11.enforceInterface(DESCRIPTOR);
            registerLinkThroughputListener(ICaeWifiLinkThroughputListener.Stub.asInterface(r11.readStrongBinder()));
            r12.writeNoException();
            return true;
        L6:
            return super.onTransact(r10, r11, r12, r13);
        L31:
            r12.writeString(DESCRIPTOR);
            return true;
        }
    }

    String getCurrentSecondarySsid();

    int getLinkThroughput();

    int getLinkThroughputJitter();

    float getLinkThroughputJitterWeight();

    List<ScanResult> getSecondaryWifiList();

    void registerLinkThroughputListener(ICaeWifiLinkThroughputListener r8);

    void registerSecondaryWifiListener(ISecondaryWifiCallback r8);

    void releaseAll();

    void releaseSecondaryWifi(ISecondaryWifiCallback r8);

    void requestSecondaryWifi(String r8, String r10, String r11, String r12, ISecondaryWifiCallback r13);

    void unregisterLinkThroughputListener(ICaeWifiLinkThroughputListener r8);

    void unregisterSecondaryWifiListener(ISecondaryWifiCallback r8);
}
