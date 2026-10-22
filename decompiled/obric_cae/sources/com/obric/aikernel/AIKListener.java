package com.obric.aikernel;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface AIKListener extends IInterface {

    public static class Default implements AIKListener {
        public Default() {
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements AIKListener {

        public static class Proxy implements AIKListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IBinder f5214a;

            public Proxy(IBinder r8) {
                this.f5214a = r8;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f5214a;
            }
        }

        public Stub() {
            attachInterface(this, "com.obric.aikernel.AIKListener");
        }

        public static AIKListener H2(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface("com.obric.aikernel.AIKListener");
            if (r10 == null) goto L12;
            if ((r10 instanceof AIKListener) == false) goto L12;
            return (AIKListener) r10;
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
            r10.enforceInterface("com.obric.aikernel.AIKListener");
            if (r10.readInt() == 0) goto L13;
            Bundle r13 = (Bundle) Bundle.CREATOR.createFromParcel(r10);
        L14:
            B2(r13);
            r11.writeNoException();
            return true;
        L13:
            r13 = null;
            goto L14
        L5:
            if (r8 != 1598968902) goto L7;
            r11.writeString("com.obric.aikernel.AIKListener");
            return true;
        L7:
            return super.onTransact(r8, r10, r11, r12);
        }
    }

    void B2(Bundle r8);
}
