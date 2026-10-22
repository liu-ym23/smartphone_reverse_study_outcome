package com.bytedance.bdinstall.oaid.impl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface IDeviceIdManager extends IInterface {

    public static class Default implements IDeviceIdManager {
        public Default() {
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }

        @Override // com.bytedance.bdinstall.oaid.impl.IDeviceIdManager
        public final String h0(String r8) {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IDeviceIdManager {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f3794a = 0;

        public static class Proxy implements IDeviceIdManager {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IBinder f3795a;

            public Proxy(IBinder r8) {
                this.f3795a = r8;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f3795a;
            }

            @Override // com.bytedance.bdinstall.oaid.impl.IDeviceIdManager
            public final String h0(String r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");     // Catch: Throwable -> L9
                r10.writeString(r8);     // Catch: Throwable -> L9
                if (this.f3795a.transact(2, r10, r11, 0) == true) goto L6;
                int r12 = Stub.f3794a;     // Catch: Throwable -> L9
            L6:
                r11.readException();     // Catch: Throwable -> L9
                String r13 = r11.readString();     // Catch: Throwable -> L9
                r11.recycle();
                r10.recycle();
                return r13;
            L9:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, "com.coolpad.deviceidsupport.IDeviceIdManager");
        }

        public static IDeviceIdManager H2(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
            if (r10 == null) goto L12;
            if ((r10 instanceof IDeviceIdManager) == false) goto L12;
            return (IDeviceIdManager) r10;
        L12:
            return new Proxy(r8);
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int r8, Parcel r10, Parcel r11, int r12) {
            if (r8 == 1598968902) goto L17;
            switch(r8) {
                case 1: goto L14;
                case 2: goto L13;
                case 3: goto L12;
                case 4: goto L11;
                case 5: goto L10;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L7:
            r10.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
            String r13 = A1();
        L15:
            r11.writeNoException();
            r11.writeString(r13);
            return true;
        L8:
            r10.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
            boolean r14 = Q0();
            r11.writeNoException();
            r11.writeInt(r14 ? 1 : 0);
            return true;
        L10:
            r10.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
            r10.readString();
            r13 = v1();
            goto L15
        L11:
            r10.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
            r10.readString();
            r13 = d();
            goto L15
        L12:
            r10.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
            r10.readString();
            r13 = e();
            goto L15
        L13:
            r10.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
            r13 = h0(r10.readString());
            goto L15
        L14:
            r10.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
            r10.readString();
            r13 = getUDID();
            goto L15
        L6:
            return super.onTransact(r8, r10, r11, r12);
        L17:
            r11.writeString("com.coolpad.deviceidsupport.IDeviceIdManager");
            return true;
        }
    }

    String A1();

    boolean Q0();

    String d();

    String e();

    String getUDID();

    String h0(String r8);

    String v1();
}
