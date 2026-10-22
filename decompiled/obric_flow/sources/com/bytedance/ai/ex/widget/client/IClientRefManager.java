package com.bytedance.ai.ex.widget.client;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public interface IClientRefManager extends IInterface {
    public static final String DESCRIPTOR = "com.bytedance.ai.ex.widget.client.IClientRefManager";

    public static class Default implements IClientRefManager {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.bytedance.ai.ex.widget.client.IClientRefManager
        public Bundle getAIPackageRef() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IClientRefManager {
        static final int TRANSACTION_getAIPackageRef = 1;

        public static class Proxy implements IClientRefManager {
            private IBinder mRemote;

            public Proxy(IBinder r5) {
                this.mRemote = r5;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.bytedance.ai.ex.widget.client.IClientRefManager
            public Bundle getAIPackageRef() {
                Parcel r5 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r5.writeInterfaceToken(IClientRefManager.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(1, r5, r10, 0);     // Catch: Throwable -> L6
                r10.readException();     // Catch: Throwable -> L6
                Bundle r11 = (Bundle) _Parcel.access$100(r10, Bundle.CREATOR);     // Catch: Throwable -> L6
                r10.recycle();
                r5.recycle();
                return r11;
            L6:
                th = move-exception;
                r10.recycle();
                r5.recycle();
                throw th;
            }

            public String getInterfaceDescriptor() {
                return IClientRefManager.DESCRIPTOR;
            }
        }

        public Stub() {
            attachInterface(this, IClientRefManager.DESCRIPTOR);
        }

        public static IClientRefManager asInterface(IBinder r5) {
            if (r5 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r5.queryLocalInterface(IClientRefManager.DESCRIPTOR);
            if (r10 == null) goto L12;
            if ((r10 instanceof IClientRefManager) == false) goto L12;
            return (IClientRefManager) r10;
        L12:
            return new Proxy(r5);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r5, Parcel r10, Parcel r11, int r12) {
            if (r5 < 1) goto L8;
            if (r5 > 16777215) goto L8;
            r10.enforceInterface(IClientRefManager.DESCRIPTOR);
        L8:
            if (r5 != 1598968902) goto L11;
            r11.writeString(IClientRefManager.DESCRIPTOR);
            return true;
        L11:
            if (r5 != 1) goto L13;
            Bundle r13 = getAIPackageRef();
            r11.writeNoException();
            _Parcel.access$000(r11, r13, 1);
            return true;
        L13:
            return super.onTransact(r5, r10, r11, r12);
        }
    }

    public static class _Parcel {
        public _Parcel() {
        }

        public static /* synthetic */ void access$000(Parcel r5, Parcelable r10, int r11) {
            writeTypedObject(r5, r10, r11);
        }

        public static /* synthetic */ Object access$100(Parcel r5, Parcelable.Creator r10) {
            return readTypedObject(r5, r10);
        }

        private static <T> T readTypedObject(Parcel r5, Parcelable.Creator<T> r10) {
            if (r5.readInt() != 0) goto L5;
            return null;
        L5:
            return r10.createFromParcel(r5);
        }

        private static <T extends Parcelable> void writeTypedObject(Parcel r5, T r10, int r11) {
            if (r10 == null) goto L5;
            r5.writeInt(1);
            r10.writeToParcel(r5, r11);
            return;
        L5:
            r5.writeInt(0);
        }
    }

    Bundle getAIPackageRef();
}
