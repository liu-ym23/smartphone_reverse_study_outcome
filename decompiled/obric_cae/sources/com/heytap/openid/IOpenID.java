package com.heytap.openid;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface IOpenID extends IInterface {

    public static class Default implements IOpenID {
        public Default() {
        }

        @Override // com.heytap.openid.IOpenID
        public final String a(String r8, String r10, String r11) {
            return null;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IOpenID {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f5196a = 0;

        public static class Proxy implements IOpenID {
            @Override // com.heytap.openid.IOpenID
            public final String a(String r8, String r10, String r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken("com.heytap.openid.IOpenID");     // Catch: Throwable -> L5
                r12.writeString(r8);     // Catch: Throwable -> L5
                r12.writeString(r10);     // Catch: Throwable -> L5
                r12.writeString(r11);     // Catch: Throwable -> L5
                throw null;     // Catch: Throwable -> L5
            L5:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return null;
            }
        }

        public Stub() {
            attachInterface(this, "com.heytap.openid.IOpenID");
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
