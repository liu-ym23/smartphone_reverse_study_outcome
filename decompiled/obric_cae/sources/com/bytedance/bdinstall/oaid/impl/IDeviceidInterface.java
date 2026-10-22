package com.bytedance.bdinstall.oaid.impl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface IDeviceidInterface extends IInterface {

    public static abstract class Stub extends Binder implements IDeviceidInterface {

        public static class Proxy implements IDeviceidInterface {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IBinder f3797a;

            public Proxy(IBinder r8) {
                this.f3797a = r8;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f3797a;
            }

            @Override // com.bytedance.bdinstall.oaid.impl.IDeviceidInterface
            public final String b() {
                Parcel r8 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");     // Catch: Throwable -> L6
                this.f3797a.transact(1, r8, r10, 0);     // Catch: Throwable -> L6
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
            attachInterface(this, "com.zui.deviceidservice.IDeviceidInterface");
        }

        public static IDeviceidInterface H2(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface("com.zui.deviceidservice.IDeviceidInterface");
            if (r10 == null) goto L12;
            if ((r10 instanceof IDeviceidInterface) == false) goto L12;
            return (IDeviceidInterface) r10;
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
