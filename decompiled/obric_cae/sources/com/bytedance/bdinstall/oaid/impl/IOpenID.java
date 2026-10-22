package com.bytedance.bdinstall.oaid.impl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface IOpenID extends IInterface {

    public static abstract class Stub extends Binder implements IOpenID {

        public static class Proxy implements IOpenID {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IBinder f3802a;

            public Proxy(IBinder r8) {
                this.f3802a = r8;
            }

            @Override // com.bytedance.bdinstall.oaid.impl.IOpenID
            public final String a(String r8, String r10, String r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken("com.heytap.openid.IOpenID");     // Catch: Throwable -> L6
                r12.writeString(r8);     // Catch: Throwable -> L6
                r12.writeString(r10);     // Catch: Throwable -> L6
                r12.writeString(r11);     // Catch: Throwable -> L6
                this.f3802a.transact(1, r12, r13, 0);     // Catch: Throwable -> L6
                r13.readException();     // Catch: Throwable -> L6
                String r14 = r13.readString();     // Catch: Throwable -> L6
                r13.recycle();
                r12.recycle();
                return r14;
            L6:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f3802a;
            }
        }

        public Stub() {
            attachInterface(this, "com.heytap.openid.IOpenID");
        }

        public static IOpenID H2(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface("com.heytap.openid.IOpenID");
            if (r10 == null) goto L12;
            if ((r10 instanceof IOpenID) == false) goto L12;
            return (IOpenID) r10;
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
            r10.enforceInterface("com.heytap.openid.IOpenID");
            String r13 = a(r10.readString(), r10.readString(), r10.readString());
            r11.writeNoException();
            r11.writeString(r13);
            return true;
        L5:
            if (r8 != 1598968902) goto L7;
            r11.writeString("com.heytap.openid.IOpenID");
            return true;
        L7:
            return super.onTransact(r8, r10, r11, r12);
        }
    }

    String a(String r8, String r10, String r11);
}
