package com.bytedance.bdinstall.oaid.uodis;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface OpenDeviceIdentifierService extends IInterface {

    public static abstract class Stub extends Binder implements OpenDeviceIdentifierService {

        public static class Proxy implements OpenDeviceIdentifierService {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IBinder f3805a;

            public Proxy(IBinder r8) {
                this.f3805a = r8;
            }

            @Override // com.bytedance.bdinstall.oaid.uodis.OpenDeviceIdentifierService
            public final String E2() {
                Parcel r8 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");     // Catch: Throwable -> L6
                this.f3805a.transact(1, r8, r10, 0);     // Catch: Throwable -> L6
                r10.readException();     // Catch: Throwable -> L6
                String r11 = r10.readString();     // Catch: Throwable -> L6
                r10.recycle();
                r8.recycle();
                return r11;
            L6:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f3805a;
            }

            @Override // com.bytedance.bdinstall.oaid.uodis.OpenDeviceIdentifierService
            public final boolean d0() {
                Parcel r8 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");     // Catch: Throwable -> L8
                boolean r11 = false;
                this.f3805a.transact(2, r8, r10, 0);     // Catch: Throwable -> L8
                r10.readException();     // Catch: Throwable -> L8
                if (r10.readInt() == 0) goto L6;
                r11 = true;
            L6:
                r10.recycle();
                r8.recycle();
                return r11;
            L8:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, "com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
        }

        public static OpenDeviceIdentifierService H2(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
            if (r10 == null) goto L12;
            if ((r10 instanceof OpenDeviceIdentifierService) == false) goto L12;
            return (OpenDeviceIdentifierService) r10;
        L12:
            return new Proxy(r8);
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int r8, Parcel r10, Parcel r11, int r12) {
            if (r8 != 1) goto L5;
            r10.enforceInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
            String r13 = E2();
            r11.writeNoException();
            r11.writeString(r13);
            return true;
        L5:
            if (r8 != 2) goto L7;
            r10.enforceInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
            boolean r14 = d0();
            r11.writeNoException();
            r11.writeInt(r14 ? 1 : 0);
            return true;
        L7:
            if (r8 != 1598968902) goto L9;
            r11.writeString("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
            return true;
        L9:
            return super.onTransact(r8, r10, r11, r12);
        }
    }

    String E2();

    boolean d0();
}
