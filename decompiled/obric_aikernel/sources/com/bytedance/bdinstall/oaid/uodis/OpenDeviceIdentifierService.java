package com.bytedance.bdinstall.oaid.uodis;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface OpenDeviceIdentifierService extends IInterface {

    public static abstract class Stub extends Binder implements OpenDeviceIdentifierService {
        private static final String DESCRIPTOR = "com.uodis.opendevice.aidl.OpenDeviceIdentifierService";
        static final int TRANSACTION_getOaid = 1;
        static final int TRANSACTION_isOaidTrackLimited = 2;

        private static class Proxy implements OpenDeviceIdentifierService {
            private IBinder mRemote;

            Proxy(IBinder r10) {
                this.mRemote = r10;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.bytedance.bdinstall.oaid.uodis.OpenDeviceIdentifierService
            public String getOaid() {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(1, r10, r11, 0);     // Catch: Throwable -> L6
                r11.readException();     // Catch: Throwable -> L6
                String r12 = r11.readString();     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.bytedance.bdinstall.oaid.uodis.OpenDeviceIdentifierService
            public boolean isOaidTrackLimited() {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean r12 = false;
                this.mRemote.transact(2, r10, r11, 0);     // Catch: Throwable -> L8
                r11.readException();     // Catch: Throwable -> L8
                if (r11.readInt() == 0) goto L6;
                r12 = true;
            L6:
                r11.recycle();
                r10.recycle();
                return r12;
            L8:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static OpenDeviceIdentifierService asInterface(IBinder r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            IInterface r11 = r10.queryLocalInterface(DESCRIPTOR);
            if (r11 == null) goto L12;
            if ((r11 instanceof OpenDeviceIdentifierService) == false) goto L12;
            return (OpenDeviceIdentifierService) r11;
        L12:
            return new Proxy(r10);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) {
            if (r10 != 1) goto L5;
            r11.enforceInterface(DESCRIPTOR);
            String r14 = getOaid();
            r12.writeNoException();
            r12.writeString(r14);
            return true;
        L5:
            if (r10 != 2) goto L7;
            r11.enforceInterface(DESCRIPTOR);
            boolean r15 = isOaidTrackLimited();
            r12.writeNoException();
            r12.writeInt(r15 ? 1 : 0);
            return true;
        L7:
            if (r10 != 1598968902) goto L9;
            r12.writeString(DESCRIPTOR);
            return true;
        L9:
            return super.onTransact(r10, r11, r12, r13);
        }
    }

    String getOaid();

    boolean isOaidTrackLimited();
}
