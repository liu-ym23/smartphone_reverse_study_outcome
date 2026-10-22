package com.bytedance.bdinstall.oaid.impl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface IDeviceIdService extends IInterface {

    public static abstract class Stub extends Binder implements IDeviceIdService {

        public static class Proxy implements IDeviceIdService {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IBinder f3796a;

            public Proxy(IBinder r8) {
                this.f3796a = r8;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f3796a;
            }

            @Override // com.bytedance.bdinstall.oaid.impl.IDeviceIdService
            public final String b() {
                Parcel r8 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");     // Catch: Throwable -> L6
                this.f3796a.transact(1, r8, r10, 0);     // Catch: Throwable -> L6
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
        }

        public Stub() {
            attachInterface(this, "com.samsung.android.deviceidservice.IDeviceIdService");
        }

        public static IDeviceIdService H2(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface("com.samsung.android.deviceidservice.IDeviceIdService");
            if (r10 == null) goto L12;
            if ((r10 instanceof IDeviceIdService) == false) goto L12;
            return (IDeviceIdService) r10;
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
            r10.enforceInterface("com.samsung.android.deviceidservice.IDeviceIdService");
            String r13 = b();
        L17:
            r11.writeNoException();
            r11.writeString(r13);
            return true;
        L5:
            if (r8 != 2) goto L7;
            r10.enforceInterface("com.samsung.android.deviceidservice.IDeviceIdService");
            r10.readString();
            r13 = e();
            goto L17
        L7:
            if (r8 != 3) goto L9;
            r10.enforceInterface("com.samsung.android.deviceidservice.IDeviceIdService");
            r10.readString();
            r13 = d();
            goto L17
        L9:
            if (r8 != 1598968902) goto L11;
            r11.writeString("com.samsung.android.deviceidservice.IDeviceIdService");
            return true;
        L11:
            return super.onTransact(r8, r10, r11, r12);
        }
    }

    String b();

    String d();

    String e();
}
