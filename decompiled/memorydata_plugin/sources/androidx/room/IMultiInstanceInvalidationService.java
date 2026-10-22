package androidx.room;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public interface IMultiInstanceInvalidationService extends IInterface {
    public static final String DESCRIPTOR = "androidx.room.IMultiInstanceInvalidationService";

    public static class Default implements IMultiInstanceInvalidationService {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // androidx.room.IMultiInstanceInvalidationService
        public void broadcastInvalidation(int r1, String[] r2) {
        }

        @Override // androidx.room.IMultiInstanceInvalidationService
        public int registerCallback(IMultiInstanceInvalidationCallback r1, String r2) {
            IMultiInstanceInvalidationCallback r0 = (IMultiInstanceInvalidationCallback) ZeusTransformUtils.wrapperContextForParams(r1, IMultiInstanceInvalidationCallback.class, "com.obric.memorydata.plugin");
            return 0;
        }

        @Override // androidx.room.IMultiInstanceInvalidationService
        public void unregisterCallback(IMultiInstanceInvalidationCallback r1, int r2) {
            IMultiInstanceInvalidationCallback r0 = (IMultiInstanceInvalidationCallback) ZeusTransformUtils.wrapperContextForParams(r1, IMultiInstanceInvalidationCallback.class, "com.obric.memorydata.plugin");
        }
    }

    public static abstract class Stub extends Binder implements IMultiInstanceInvalidationService {
        static final int TRANSACTION_broadcastInvalidation = 3;
        static final int TRANSACTION_registerCallback = 1;
        static final int TRANSACTION_unregisterCallback = 2;

        private static class Proxy implements IMultiInstanceInvalidationService {
            private IBinder mRemote;

            Proxy(IBinder r3) {
                this.mRemote = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // androidx.room.IMultiInstanceInvalidationService
            public void broadcastInvalidation(int r3, String[] r4) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(IMultiInstanceInvalidationService.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r3);     // Catch: Throwable -> L6
                r0.writeStringArray(r4);     // Catch: Throwable -> L6
                this.mRemote.transact(3, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            public String getInterfaceDescriptor() {
                return IMultiInstanceInvalidationService.DESCRIPTOR;
            }

            @Override // androidx.room.IMultiInstanceInvalidationService
            public int registerCallback(IMultiInstanceInvalidationCallback r4, String r5) {
                IMultiInstanceInvalidationCallback r6 = (IMultiInstanceInvalidationCallback) ZeusTransformUtils.wrapperContextForParams(r4, IMultiInstanceInvalidationCallback.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IMultiInstanceInvalidationService.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r6);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(1, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                int r3 = r1.readInt();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // androidx.room.IMultiInstanceInvalidationService
            public void unregisterCallback(IMultiInstanceInvalidationCallback r4, int r5) {
                IMultiInstanceInvalidationCallback r6 = (IMultiInstanceInvalidationCallback) ZeusTransformUtils.wrapperContextForParams(r4, IMultiInstanceInvalidationCallback.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IMultiInstanceInvalidationService.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r6);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(2, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, IMultiInstanceInvalidationService.DESCRIPTOR);
        }

        public static IMultiInstanceInvalidationService asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(IMultiInstanceInvalidationService.DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IMultiInstanceInvalidationService.class) == false) goto L13;
            return (IMultiInstanceInvalidationService) ZeusTransformUtils.preCheckCast(r0, IMultiInstanceInvalidationService.class, "com.obric.memorydata.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 < 1) goto L8;
            if (r4 > 16777215) goto L8;
            r5.enforceInterface(IMultiInstanceInvalidationService.DESCRIPTOR);
        L8:
            if (r4 == 1598968902) goto L20;
            if (r4 != 1) goto L11;
            int r3 = registerCallback(IMultiInstanceInvalidationCallback.Stub.asInterface(r5.readStrongBinder()), r5.readString());
            r6.writeNoException();
            r6.writeInt(r3);
        L19:
            return true;
        L11:
            if (r4 != 2) goto L13;
            unregisterCallback(IMultiInstanceInvalidationCallback.Stub.asInterface(r5.readStrongBinder()), r5.readInt());
            r6.writeNoException();
            goto L19
        L13:
            if (r4 != 3) goto L15;
            broadcastInvalidation(r5.readInt(), r5.createStringArray());
            goto L19
        L15:
            return super.onTransact(r4, r5, r6, r7);
        L20:
            r6.writeString(IMultiInstanceInvalidationService.DESCRIPTOR);
            return true;
        }
    }

    void broadcastInvalidation(int r1, String[] r2);

    int registerCallback(IMultiInstanceInvalidationCallback r1, String r2);

    void unregisterCallback(IMultiInstanceInvalidationCallback r1, int r2);
}
