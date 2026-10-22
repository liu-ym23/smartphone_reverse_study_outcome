package com.bytedance.bdinstall.oaid.impl;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface IOAIDCallBack extends IInterface {

    public static abstract class Stub extends Binder implements IOAIDCallBack {

        public static class Proxy implements IOAIDCallBack {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IBinder f3799a;

            public Proxy(IBinder r8) {
                this.f3799a = r8;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f3799a;
            }
        }

        public Stub() {
            attachInterface(this, "com.hihonor.cloudservice.oaid.IOAIDCallBack");
        }

        public static IOAIDCallBack H2(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface("com.hihonor.cloudservice.oaid.IOAIDCallBack");
            if (r10 == null) goto L12;
            if ((r10 instanceof IOAIDCallBack) == false) goto L12;
            return (IOAIDCallBack) r10;
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
            r10.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDCallBack");
            r10.readInt();
            r10.readLong();
            r10.readInt();
            r10.readFloat();
            r10.readDouble();
            r10.readString();
            k();
        L18:
            r11.writeNoException();
            return true;
        L5:
            if (r8 != 2) goto L7;
            r10.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDCallBack");
            int r13 = r10.readInt();
            if (r10.readInt() == 0) goto L15;
            Bundle r14 = (Bundle) Bundle.CREATOR.createFromParcel(r10);
        L16:
            D0(r13, r14);
            goto L18
        L15:
            r14 = null;
            goto L16
        L7:
            if (r8 != 1598968902) goto L9;
            r11.writeString("com.hihonor.cloudservice.oaid.IOAIDCallBack");
            return true;
        L9:
            return super.onTransact(r8, r10, r11, r12);
        }
    }

    void D0(int r8, Bundle r10);

    void k();
}
