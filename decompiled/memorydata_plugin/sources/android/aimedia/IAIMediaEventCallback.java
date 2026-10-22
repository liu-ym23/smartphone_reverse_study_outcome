package android.aimedia;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public interface IAIMediaEventCallback extends IInterface {
    public static final String DESCRIPTOR = "android.aimedia.IAIMediaEventCallback";

    public static abstract class Stub extends Binder implements IAIMediaEventCallback {
        static final int TRANSACTION_onEvents = 1;
        static final int TRANSACTION_onSubscriptionClosed = 2;

        private static class a implements IAIMediaEventCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f23a;

            a(IBinder r3) {
                this.f23a = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f23a;
            }

            @Override // android.aimedia.IAIMediaEventCallback
            public void onEvents(int r3, MediaEventQueryResult r4) {
                Parcel r0 = Parcel.obtain(asBinder());
                r0.writeInterfaceToken(IAIMediaEventCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r3);     // Catch: Throwable -> L6
                r0.writeTypedObject(r4, 0);     // Catch: Throwable -> L6
                this.f23a.transact(1, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.aimedia.IAIMediaEventCallback
            public void onSubscriptionClosed(int r3, int r4) {
                Parcel r0 = Parcel.obtain(asBinder());
                r0.writeInterfaceToken(IAIMediaEventCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r3);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                this.f23a.transact(2, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, IAIMediaEventCallback.DESCRIPTOR);
        }

        public static IAIMediaEventCallback asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(IAIMediaEventCallback.DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IAIMediaEventCallback.class) == false) goto L13;
            return (IAIMediaEventCallback) ZeusTransformUtils.preCheckCast(r0, IAIMediaEventCallback.class, "com.obric.memorydata.plugin");
        L13:
            return new a(r4);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 < 1) goto L8;
            if (r4 > 16777215) goto L8;
            r5.enforceInterface(IAIMediaEventCallback.DESCRIPTOR);
        L8:
            if (r4 != 1598968902) goto L11;
            r6.writeString(IAIMediaEventCallback.DESCRIPTOR);
            return true;
        L11:
            if (r4 != 1) goto L13;
            int r8 = r5.readInt();
            MediaEventQueryResult r9 = (MediaEventQueryResult) ZeusTransformUtils.preCheckCast(r5.readTypedObject(MediaEventQueryResult.CREATOR), MediaEventQueryResult.class, "com.obric.memorydata.plugin");
            r5.enforceNoDataAvail();
            onEvents(r8, r9);
        L18:
            return true;
        L13:
            if (r4 != 2) goto L15;
            int r10 = r5.readInt();
            int r11 = r5.readInt();
            r5.enforceNoDataAvail();
            onSubscriptionClosed(r10, r11);
            goto L18
        L15:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    void onEvents(int r1, MediaEventQueryResult r2);

    void onSubscriptionClosed(int r1, int r2);
}
