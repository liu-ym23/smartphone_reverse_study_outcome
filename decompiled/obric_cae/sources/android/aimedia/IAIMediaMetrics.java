package android.aimedia;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface IAIMediaMetrics extends IInterface {

    public static class Default implements IAIMediaMetrics {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.aimedia.IAIMediaMetrics
        public int submitEvent(MediaEventEnvelope r8) {
            return 0;
        }
    }

    public static abstract class Stub extends Binder implements IAIMediaMetrics {
        private static final String DESCRIPTOR = "android.aimedia.IAIMediaMetrics";
        static final int TRANSACTION_submitEvent = 1;

        public static class Proxy implements IAIMediaMetrics {
            public static IAIMediaMetrics sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r8) {
                this.mRemote = r8;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // android.aimedia.IAIMediaMetrics
            public int submitEvent(MediaEventEnvelope r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r8 == null) goto L6;
                r10.writeInt(1);     // Catch: Throwable -> L17
                r8.writeToParcel(r10, 0);     // Catch: Throwable -> L17
            L8:
                if (this.mRemote.transact(1, r10, r11, 0) == false) goto L10;
            L14:
                r11.readException();     // Catch: Throwable -> L17
                int r12 = r11.readInt();     // Catch: Throwable -> L17
                r11.recycle();
                r10.recycle();
                return r12;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                int r13 = Stub.getDefaultImpl().submitEvent(r8);     // Catch: Throwable -> L17
                r11.recycle();
                r10.recycle();
                return r13;
            L6:
                r10.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IAIMediaMetrics asInterface(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface(DESCRIPTOR);
            if (r10 == null) goto L12;
            if ((r10 instanceof IAIMediaMetrics) == false) goto L12;
            return (IAIMediaMetrics) r10;
        L12:
            return new Proxy(r8);
        }

        public static IAIMediaMetrics getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IAIMediaMetrics r8) {
            if (Proxy.sDefaultImpl != null) goto L10;
            if (r8 == null) goto L7;
            Proxy.sDefaultImpl = r8;
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
            MediaEventEnvelope r13 = MediaEventEnvelope.CREATOR.createFromParcel(r10);
        L14:
            int r14 = submitEvent(r13);
            r11.writeNoException();
            r11.writeInt(r14);
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

    int submitEvent(MediaEventEnvelope r8);
}
