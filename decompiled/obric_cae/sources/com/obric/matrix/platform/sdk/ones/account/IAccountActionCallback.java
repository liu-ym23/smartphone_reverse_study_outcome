package com.obric.matrix.platform.sdk.ones.account;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public interface IAccountActionCallback extends IInterface {

    public static class Default implements IAccountActionCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IAccountActionCallback {

        public static class Proxy implements IAccountActionCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IBinder f6093a;

            public Proxy(IBinder r8) {
                this.f6093a = r8;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f6093a;
            }
        }

        public Stub() {
            attachInterface(this, "com.obric.matrix.platform.sdk.ones.account.IAccountActionCallback");
        }

        public static IAccountActionCallback H2(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface("com.obric.matrix.platform.sdk.ones.account.IAccountActionCallback");
            if (r10 == null) goto L12;
            if ((r10 instanceof IAccountActionCallback) == false) goto L12;
            return (IAccountActionCallback) r10;
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
            r10.enforceInterface("com.obric.matrix.platform.sdk.ones.account.IAccountActionCallback");
            if (r10.readInt() == 0) goto L13;
            boolean r13 = true;
        L15:
            if (r10.readInt() == 0) goto L17;
            Bundle r14 = (Bundle) Bundle.CREATOR.createFromParcel(r10);
        L18:
            ((OAccount.AsyncResultCallback) this).I2(r13, r14);
            return true;
        L17:
            r14 = null;
            goto L18
        L13:
            r13 = false;
            goto L15
        L5:
            if (r8 != 1598968902) goto L7;
            r11.writeString("com.obric.matrix.platform.sdk.ones.account.IAccountActionCallback");
            return true;
        L7:
            return super.onTransact(r8, r10, r11, r12);
        }
    }
}
