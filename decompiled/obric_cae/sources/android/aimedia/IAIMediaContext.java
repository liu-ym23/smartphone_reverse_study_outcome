package android.aimedia;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface IAIMediaContext extends IInterface {

    public static class Default implements IAIMediaContext {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.aimedia.IAIMediaContext
        public int getCurrentMediaContext(MediaContextSnapshot r8) {
            return 0;
        }

        @Override // android.aimedia.IAIMediaContext
        public int getServiceCapabilities(MediaServiceCapabilities r8) {
            return 0;
        }
    }

    public static abstract class Stub extends Binder implements IAIMediaContext {
        private static final String DESCRIPTOR = "android.aimedia.IAIMediaContext";
        static final int TRANSACTION_getCurrentMediaContext = 1;
        static final int TRANSACTION_getServiceCapabilities = 2;

        public static class Proxy implements IAIMediaContext {
            public static IAIMediaContext sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r8) {
                this.mRemote = r8;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // android.aimedia.IAIMediaContext
            public int getCurrentMediaContext(MediaContextSnapshot r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                if (this.mRemote.transact(1, r10, r11, 0) == false) goto L6;
            L10:
                r11.readException();     // Catch: Throwable -> L15
                int r12 = r11.readInt();     // Catch: Throwable -> L15
                if (r11.readInt() == 0) goto L13;
                r8.readFromParcel(r11);     // Catch: Throwable -> L15
            L13:
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r13 = Stub.getDefaultImpl().getCurrentMediaContext(r8);     // Catch: Throwable -> L15
                r11.recycle();
                r10.recycle();
                return r13;
            L15:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // android.aimedia.IAIMediaContext
            public int getServiceCapabilities(MediaServiceCapabilities r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                if (this.mRemote.transact(2, r10, r11, 0) == false) goto L6;
            L10:
                r11.readException();     // Catch: Throwable -> L15
                int r12 = r11.readInt();     // Catch: Throwable -> L15
                if (r11.readInt() == 0) goto L13;
                r8.readFromParcel(r11);     // Catch: Throwable -> L15
            L13:
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r13 = Stub.getDefaultImpl().getServiceCapabilities(r8);     // Catch: Throwable -> L15
                r11.recycle();
                r10.recycle();
                return r13;
            L15:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IAIMediaContext asInterface(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface(DESCRIPTOR);
            if (r10 == null) goto L12;
            if ((r10 instanceof IAIMediaContext) == false) goto L12;
            return (IAIMediaContext) r10;
        L12:
            return new Proxy(r8);
        }

        public static IAIMediaContext getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IAIMediaContext r8) {
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
            MediaContextSnapshot r13 = new MediaContextSnapshot();
            int r14 = getCurrentMediaContext(r13);
            r11.writeNoException();
            r11.writeInt(r14);
            r11.writeInt(1);
            r13.writeToParcel(r11, 1);
            return true;
        L5:
            if (r8 != 2) goto L7;
            r10.enforceInterface(DESCRIPTOR);
            MediaServiceCapabilities r15 = new MediaServiceCapabilities();
            int r16 = getServiceCapabilities(r15);
            r11.writeNoException();
            r11.writeInt(r16);
            r11.writeInt(1);
            r15.writeToParcel(r11, 1);
            return true;
        L7:
            if (r8 != 1598968902) goto L9;
            r11.writeString(DESCRIPTOR);
            return true;
        L9:
            return super.onTransact(r8, r10, r11, r12);
        }
    }

    int getCurrentMediaContext(MediaContextSnapshot r8);

    int getServiceCapabilities(MediaServiceCapabilities r8);
}
