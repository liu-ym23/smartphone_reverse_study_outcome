package androidx.work.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface IListenableWorkerImpl extends IInterface {

    public static class Default implements IListenableWorkerImpl {
        public Default() {
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IListenableWorkerImpl {

        public static class Proxy implements IListenableWorkerImpl {
            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return null;
            }
        }

        public Stub() {
            attachInterface(this, "androidx.work.multiprocess.IListenableWorkerImpl");
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int r8, Parcel r10, Parcel r11, int r12) {
            if (r8 < 1) goto L8;
            if (r8 > 16777215) goto L8;
            r10.enforceInterface("androidx.work.multiprocess.IListenableWorkerImpl");
        L8:
            if (r8 == 1598968902) goto L17;
            if (r8 != 1) goto L11;
            r10.createByteArray();
            IWorkManagerImplCallback.Stub.H2(r10.readStrongBinder());
            j0();
        L16:
            return true;
        L11:
            if (r8 != 2) goto L13;
            r10.createByteArray();
            IWorkManagerImplCallback.Stub.H2(r10.readStrongBinder());
            d1();
            goto L16
        L13:
            return super.onTransact(r8, r10, r11, r12);
        L17:
            r11.writeString("androidx.work.multiprocess.IListenableWorkerImpl");
            return true;
        }
    }

    void d1();

    void j0();
}
