package com.samsung.android.deviceidservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public interface IDeviceIdService extends IInterface {

    public static class Default implements IDeviceIdService {
        public Default() {
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }

        @Override // com.samsung.android.deviceidservice.IDeviceIdService
        public final String b() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IDeviceIdService {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f6709a = 0;

        public static class Proxy implements IDeviceIdService {
            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return null;
            }

            @Override // com.samsung.android.deviceidservice.IDeviceIdService
            public final String b() {
                Parcel r8 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");     // Catch: Throwable -> L5
                throw null;     // Catch: Throwable -> L5
            L5:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, "com.samsung.android.deviceidservice.IDeviceIdService");
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
