package vendor.oak.qshhar;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public interface IQshHarEventListener extends IInterface {

    public static class Default implements IQshHarEventListener {
        public Default() {
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IQshHarEventListener {
        private static final String DESCRIPTOR = "vendor.oak.qshhar.IQshHarEventListener";
        static final int TRANSACTION_OnRecvQshHarEvent = 1;

        public static class Proxy implements IQshHarEventListener {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static IQshHarEventListener f12922b;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IBinder f12923a;

            public Proxy(IBinder r8) {
                this.f12923a = r8;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f12923a;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IQshHarEventListener asInterface(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface(DESCRIPTOR);
            if (r10 == null) goto L12;
            if ((r10 instanceof IQshHarEventListener) == false) goto L12;
            return (IQshHarEventListener) r10;
        L12:
            return new Proxy(r8);
        }

        public static IQshHarEventListener getDefaultImpl() {
            return Proxy.f12922b;
        }

        public static boolean setDefaultImpl(IQshHarEventListener r8) {
            if (Proxy.f12922b != null) goto L10;
            if (r8 == null) goto L7;
            Proxy.f12922b = r8;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r8, Parcel r10, Parcel r11, int r12) {
            if (r8 != 1) goto L5;
            r10.enforceInterface(DESCRIPTOR);
            if (r10.readInt() == 0) goto L13;
            QshHarEventParcel r13 = QshHarEventParcel.CREATOR.createFromParcel(r10);
        L14:
            OnRecvQshHarEvent(r13);
            r11.writeNoException();
            return true;
        L13:
            r13 = null;
            goto L14
        L5:
            if (r8 != 1598968902) goto L7;
            r11.writeString(DESCRIPTOR);
            return true;
        L7:
            return super.onTransact(r8, r10, r11, r12);
        }
    }

    void OnRecvQshHarEvent(QshHarEventParcel r8);
}
