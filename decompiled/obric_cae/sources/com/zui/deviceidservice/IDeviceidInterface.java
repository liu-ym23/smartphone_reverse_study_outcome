package com.zui.deviceidservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public interface IDeviceidInterface extends IInterface {

    public static class Default implements IDeviceidInterface {
        public Default() {
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }

        @Override // com.zui.deviceidservice.IDeviceidInterface
        public final String b() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IDeviceidInterface {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f6744a = 0;

        public static class Proxy implements IDeviceidInterface {
            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return null;
            }

            @Override // com.zui.deviceidservice.IDeviceidInterface
            public final String b() {
                Parcel r8 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");     // Catch: Throwable -> L5
                throw null;     // Catch: Throwable -> L5
            L5:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, "com.zui.deviceidservice.IDeviceidInterface");
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int r8, Parcel r10, Parcel r11, int r12) {
            if (r8 != 1) goto L5;
            r10.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
            String r13 = b();
        L24:
            r11.writeNoException();
            r11.writeString(r13);
            return true;
        L5:
            if (r8 != 2) goto L7;
            r10.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
            r13 = getUDID();
            goto L24
        L7:
            if (r8 != 3) goto L9;
            r10.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
            boolean r14 = l();
            r11.writeNoException();
            r11.writeInt(r14 ? 1 : 0);
            return true;
        L9:
            if (r8 != 4) goto L11;
            r10.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
            r10.readString();
            r13 = e();
            goto L24
        L11:
            if (r8 != 5) goto L13;
            r10.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
            r10.readString();
            r13 = d();
            goto L24
        L13:
            if (r8 != 1598968902) goto L15;
            r11.writeString("com.zui.deviceidservice.IDeviceidInterface");
            return true;
        L15:
            return super.onTransact(r8, r10, r11, r12);
        }
    }

    String b();

    String d();

    String e();

    String getUDID();

    boolean l();
}
