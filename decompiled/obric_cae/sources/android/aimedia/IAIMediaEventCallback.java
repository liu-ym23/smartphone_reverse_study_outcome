package android.aimedia;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface IAIMediaEventCallback extends IInterface {

    public static class Default implements IAIMediaEventCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.aimedia.IAIMediaEventCallback
        public void onEvents(int r8, MediaEventQueryResult r10) {
        }

        @Override // android.aimedia.IAIMediaEventCallback
        public void onSubscriptionClosed(int r8, int r10) {
        }
    }

    public static abstract class Stub extends Binder implements IAIMediaEventCallback {
        private static final String DESCRIPTOR = "android.aimedia.IAIMediaEventCallback";
        static final int TRANSACTION_onEvents = 1;
        static final int TRANSACTION_onSubscriptionClosed = 2;

        public static class Proxy implements IAIMediaEventCallback {
            public static IAIMediaEventCallback sDefaultImpl;
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

            @Override // android.aimedia.IAIMediaEventCallback
            public void onEvents(int r8, MediaEventQueryResult r10) {
                Parcel r11 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r11.writeInt(r8);     // Catch: Throwable -> L16
                if (r10 == null) goto L6;
                r11.writeInt(1);     // Catch: Throwable -> L16
                r10.writeToParcel(r11, 0);     // Catch: Throwable -> L16
            L8:
                if (this.mRemote.transact(1, r11, null, 1) == false) goto L10;
            L14:
                r11.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onEvents(r8, r10);     // Catch: Throwable -> L16
                r11.recycle();
                return;
            L6:
                r11.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r11.recycle();
                throw th;
            }

            @Override // android.aimedia.IAIMediaEventCallback
            public void onSubscriptionClosed(int r8, int r10) {
                Parcel r11 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r11.writeInt(r8);     // Catch: Throwable -> L12
                r11.writeInt(r10);     // Catch: Throwable -> L12
                if (this.mRemote.transact(2, r11, null, 1) == false) goto L6;
            L10:
                r11.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onSubscriptionClosed(r8, r10);     // Catch: Throwable -> L12
                r11.recycle();
                return;
            L12:
                th = move-exception;
                r11.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IAIMediaEventCallback asInterface(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface(DESCRIPTOR);
            if (r10 == null) goto L12;
            if ((r10 instanceof IAIMediaEventCallback) == false) goto L12;
            return (IAIMediaEventCallback) r10;
        L12:
            return new Proxy(r8);
        }

        public static IAIMediaEventCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IAIMediaEventCallback r8) {
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
            int r13 = r10.readInt();
            if (r10.readInt() == 0) goto L17;
            MediaEventQueryResult r14 = MediaEventQueryResult.CREATOR.createFromParcel(r10);
        L18:
            onEvents(r13, r14);
            return true;
        L17:
            r14 = null;
            goto L18
        L5:
            if (r8 != 2) goto L7;
            r10.enforceInterface(DESCRIPTOR);
            onSubscriptionClosed(r10.readInt(), r10.readInt());
            return true;
        L7:
            if (r8 != 1598968902) goto L9;
            r11.writeString(DESCRIPTOR);
            return true;
        L9:
            return super.onTransact(r8, r10, r11, r12);
        }
    }

    void onEvents(int r8, MediaEventQueryResult r10);

    void onSubscriptionClosed(int r8, int r10);
}
