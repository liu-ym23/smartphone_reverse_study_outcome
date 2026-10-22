package androidx.work.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface IWorkManagerImplCallback extends IInterface {

    public static class Default implements IWorkManagerImplCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IWorkManagerImplCallback {

        public static class Proxy implements IWorkManagerImplCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IBinder f2931a;

            public Proxy(IBinder r8) {
                this.f2931a = r8;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f2931a;
            }
        }

        public Stub() {
            attachInterface(this, "androidx.work.multiprocess.IWorkManagerImplCallback");
        }

        public static IWorkManagerImplCallback H2(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface("androidx.work.multiprocess.IWorkManagerImplCallback");
            if (r10 == null) goto L12;
            if ((r10 instanceof IWorkManagerImplCallback) == false) goto L12;
            return (IWorkManagerImplCallback) r10;
        L12:
            return new Proxy(r8);
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int r8, Parcel r10, Parcel r11, int r12) {
            if (r8 < 1) goto L8;
            if (r8 > 16777215) goto L8;
            r10.enforceInterface("androidx.work.multiprocess.IWorkManagerImplCallback");
        L8:
            if (r8 == 1598968902) goto L17;
            if (r8 != 1) goto L11;
            r10.createByteArray();
            onSuccess();
        L16:
            return true;
        L11:
            if (r8 != 2) goto L13;
            r10.readString();
            O();
            goto L16
        L13:
            return super.onTransact(r8, r10, r11, r12);
        L17:
            r11.writeString("androidx.work.multiprocess.IWorkManagerImplCallback");
            return true;
        }
    }

    void O();

    void onSuccess();
}
