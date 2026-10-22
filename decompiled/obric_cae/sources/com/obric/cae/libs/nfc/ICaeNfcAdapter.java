package com.obric.cae.libs.nfc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface ICaeNfcAdapter extends IInterface {

    public static class Default implements ICaeNfcAdapter {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcAdapter
        public ICaeNfcEventManager getEventManager() {
            return null;
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcAdapter
        public ICaeNfcOmapiExecutor getOmapiExecutor() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements ICaeNfcAdapter {
        private static final String DESCRIPTOR = "com.obric.cae.libs.nfc.ICaeNfcAdapter";
        static final int TRANSACTION_getEventManager = 2;
        static final int TRANSACTION_getOmapiExecutor = 1;

        public static class Proxy implements ICaeNfcAdapter {
            public static ICaeNfcAdapter sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r8) {
                this.mRemote = r8;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.cae.libs.nfc.ICaeNfcAdapter
            public ICaeNfcEventManager getEventManager() {
                Parcel r8 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(2, r8, r10, 0) == false) goto L6;
            L10:
                r10.readException();     // Catch: Throwable -> L12
                ICaeNfcEventManager r11 = ICaeNfcEventManager.Stub.asInterface(r10.readStrongBinder());     // Catch: Throwable -> L12
            L8:
                r10.recycle();
                r8.recycle();
                return r11;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r11 = Stub.getDefaultImpl().getEventManager();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.nfc.ICaeNfcAdapter
            public ICaeNfcOmapiExecutor getOmapiExecutor() {
                Parcel r8 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(1, r8, r10, 0) == false) goto L6;
            L10:
                r10.readException();     // Catch: Throwable -> L12
                ICaeNfcOmapiExecutor r11 = ICaeNfcOmapiExecutor.Stub.asInterface(r10.readStrongBinder());     // Catch: Throwable -> L12
            L8:
                r10.recycle();
                r8.recycle();
                return r11;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r11 = Stub.getDefaultImpl().getOmapiExecutor();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICaeNfcAdapter asInterface(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface(DESCRIPTOR);
            if (r10 == null) goto L12;
            if ((r10 instanceof ICaeNfcAdapter) == false) goto L12;
            return (ICaeNfcAdapter) r10;
        L12:
            return new Proxy(r8);
        }

        public static ICaeNfcAdapter getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICaeNfcAdapter r8) {
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
            IBinder r13 = null;
            if (r8 != 1) goto L5;
            r10.enforceInterface(DESCRIPTOR);
            ICaeNfcOmapiExecutor r14 = getOmapiExecutor();
            r11.writeNoException();
            if (r14 == null) goto L20;
            r13 = r14.asBinder();
        L20:
            r11.writeStrongBinder(r13);
            return true;
        L5:
            if (r8 != 2) goto L7;
            r10.enforceInterface(DESCRIPTOR);
            ICaeNfcEventManager r15 = getEventManager();
            r11.writeNoException();
            if (r15 == null) goto L15;
            r13 = r15.asBinder();
        L15:
            r11.writeStrongBinder(r13);
            return true;
        L7:
            if (r8 != 1598968902) goto L9;
            r11.writeString(DESCRIPTOR);
            return true;
        L9:
            return super.onTransact(r8, r10, r11, r12);
        }
    }

    ICaeNfcEventManager getEventManager();

    ICaeNfcOmapiExecutor getOmapiExecutor();
}
