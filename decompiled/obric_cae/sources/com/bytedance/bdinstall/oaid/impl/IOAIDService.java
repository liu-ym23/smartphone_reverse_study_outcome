package com.bytedance.bdinstall.oaid.impl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface IOAIDService extends IInterface {

    public static abstract class Stub extends Binder implements IOAIDService {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f3800a = 0;

        public static class Proxy implements IOAIDService {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IBinder f3801a;

            public Proxy(IBinder r8) {
                this.f3801a = r8;
            }

            @Override // com.bytedance.bdinstall.oaid.impl.IOAIDService
            public final void K(IOAIDCallBack r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");     // Catch: Throwable -> L13
                if (r8 == null) goto L6;
                IBinder r12 = r8.asBinder();     // Catch: Throwable -> L13
            L7:
                r10.writeStrongBinder(r12);     // Catch: Throwable -> L13
                if (this.f3801a.transact(2, r10, r11, 0) == true) goto L10;
                int r13 = Stub.f3800a;     // Catch: Throwable -> L13
            L10:
                r11.readException();     // Catch: Throwable -> L13
                r11.recycle();
                r10.recycle();
                return;
            L6:
                r12 = null;
            L13:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f3801a;
            }

            @Override // com.bytedance.bdinstall.oaid.impl.IOAIDService
            public final void h1(IOAIDCallBack r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");     // Catch: Throwable -> L13
                if (r8 == null) goto L6;
                IBinder r12 = r8.asBinder();     // Catch: Throwable -> L13
            L7:
                r10.writeStrongBinder(r12);     // Catch: Throwable -> L13
                if (this.f3801a.transact(3, r10, r11, 0) == true) goto L10;
                int r13 = Stub.f3800a;     // Catch: Throwable -> L13
            L10:
                r11.readException();     // Catch: Throwable -> L13
                r11.recycle();
                r10.recycle();
                return;
            L6:
                r12 = null;
            L13:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, "com.hihonor.cloudservice.oaid.IOAIDService");
        }

        public static IOAIDService H2(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface("com.hihonor.cloudservice.oaid.IOAIDService");
            if (r10 == null) goto L12;
            if ((r10 instanceof IOAIDService) == false) goto L12;
            return (IOAIDService) r10;
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
            r10.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDService");
            r10.readInt();
            r10.readLong();
            r10.readInt();
            r10.readFloat();
            r10.readDouble();
            r10.readString();
            k();
        L17:
            r11.writeNoException();
            return true;
        L5:
            if (r8 != 2) goto L7;
            r10.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDService");
            K(IOAIDCallBack.Stub.H2(r10.readStrongBinder()));
            goto L17
        L7:
            if (r8 != 3) goto L9;
            r10.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDService");
            h1(IOAIDCallBack.Stub.H2(r10.readStrongBinder()));
            goto L17
        L9:
            if (r8 != 1598968902) goto L11;
            r11.writeString("com.hihonor.cloudservice.oaid.IOAIDService");
            return true;
        L11:
            return super.onTransact(r8, r10, r11, r12);
        }
    }

    void K(IOAIDCallBack r8);

    void h1(IOAIDCallBack r8);

    void k();
}
