package android.aimedia;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public interface IAIMediaEvents extends IInterface {
    public static final String DESCRIPTOR = "android.aimedia.IAIMediaEvents";

    public static abstract class Stub extends Binder implements IAIMediaEvents {
        static final int TRANSACTION_queryEvents = 1;
        static final int TRANSACTION_queryEventsSince = 2;
        static final int TRANSACTION_subscribeEvents = 3;
        static final int TRANSACTION_unsubscribeEvents = 4;

        private static class a implements IAIMediaEvents {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f24a;

            a(IBinder r3) {
                this.f24a = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f24a;
            }

            @Override // android.aimedia.IAIMediaEvents
            public int queryEvents(MediaEventFilter r4, long r5, long r7, int r9, String r10, MediaEventQueryResult r11) {
                Parcel r0 = Parcel.obtain(asBinder());
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IAIMediaEvents.DESCRIPTOR);     // Catch: Throwable -> L8
                r0.writeTypedObject(r4, 0);     // Catch: Throwable -> L8
                r0.writeLong(r5);     // Catch: Throwable -> L8
                r0.writeLong(r7);     // Catch: Throwable -> L8
                r0.writeInt(r9);     // Catch: Throwable -> L8
                r0.writeString(r10);     // Catch: Throwable -> L8
                this.f24a.transact(1, r0, r1, 0);     // Catch: Throwable -> L8
                r1.readException();     // Catch: Throwable -> L8
                int r3 = r1.readInt();     // Catch: Throwable -> L8
                if (r1.readInt() == 0) goto L6;
                r11.readFromParcel(r1);     // Catch: Throwable -> L8
            L6:
                r1.recycle();
                r0.recycle();
                return r3;
            L8:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.aimedia.IAIMediaEvents
            public int queryEventsSince(MediaEventFilter r4, long r5, int r7, MediaEventQueryResult r8) {
                Parcel r0 = Parcel.obtain(asBinder());
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IAIMediaEvents.DESCRIPTOR);     // Catch: Throwable -> L8
                r0.writeTypedObject(r4, 0);     // Catch: Throwable -> L8
                r0.writeLong(r5);     // Catch: Throwable -> L8
                r0.writeInt(r7);     // Catch: Throwable -> L8
                this.f24a.transact(2, r0, r1, 0);     // Catch: Throwable -> L8
                r1.readException();     // Catch: Throwable -> L8
                int r3 = r1.readInt();     // Catch: Throwable -> L8
                if (r1.readInt() == 0) goto L6;
                r8.readFromParcel(r1);     // Catch: Throwable -> L8
            L6:
                r1.recycle();
                r0.recycle();
                return r3;
            L8:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.aimedia.IAIMediaEvents
            public int subscribeEvents(MediaEventFilter r4, MediaEventSubscribeOptions r5, IAIMediaEventCallback r6) {
                IAIMediaEventCallback r7 = (IAIMediaEventCallback) ZeusTransformUtils.wrapperContextForParams(r6, IAIMediaEventCallback.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain(asBinder());
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IAIMediaEvents.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeTypedObject(r4, 0);     // Catch: Throwable -> L6
                r0.writeTypedObject(r5, 0);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r7);     // Catch: Throwable -> L6
                this.f24a.transact(3, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // android.aimedia.IAIMediaEvents
            public int unsubscribeEvents(int r4) {
                Parcel r0 = Parcel.obtain(asBinder());
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IAIMediaEvents.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                this.f24a.transact(4, r0, r1, 0);     // Catch: Throwable -> L6
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
        }

        public Stub() {
            attachInterface(this, IAIMediaEvents.DESCRIPTOR);
        }

        public static IAIMediaEvents asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(IAIMediaEvents.DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IAIMediaEvents.class) == false) goto L13;
            return (IAIMediaEvents) ZeusTransformUtils.preCheckCast(r0, IAIMediaEvents.class, "com.obric.memorydata.plugin");
        L13:
            return new a(r4);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r11, Parcel r12, Parcel r13, int r14) {
            if (r11 < 1) goto L8;
            if (r11 > 16777215) goto L8;
            r12.enforceInterface(IAIMediaEvents.DESCRIPTOR);
        L8:
            if (r11 != 1598968902) goto L12;
            r13.writeString(IAIMediaEvents.DESCRIPTOR);
            return true;
        L12:
            if (r11 != 1) goto L14;
            MediaEventFilter r2 = (MediaEventFilter) ZeusTransformUtils.preCheckCast(r12.readTypedObject(MediaEventFilter.CREATOR), MediaEventFilter.class, "com.obric.memorydata.plugin");
            long r3 = r12.readLong();
            long r5 = r12.readLong();
            int r7 = r12.readInt();
            String r8 = r12.readString();
            MediaEventQueryResult r15 = new MediaEventQueryResult();
            r12.enforceNoDataAvail();
            int r10 = queryEvents(r2, r3, r5, r7, r8, r15);
        L26:
            r13.writeNoException();
            r13.writeInt(r10);
            r13.writeTypedObject(r15, 1);
        L27:
            return true;
        L14:
            if (r11 != 2) goto L16;
            MediaEventFilter r4 = (MediaEventFilter) ZeusTransformUtils.preCheckCast(r12.readTypedObject(MediaEventFilter.CREATOR), MediaEventFilter.class, "com.obric.memorydata.plugin");
            long r6 = r12.readLong();
            int r9 = r12.readInt();
            r15 = new MediaEventQueryResult();
            r12.enforceNoDataAvail();
            r10 = queryEventsSince(r4, r6, r9, r15);
            goto L26
        L16:
            if (r11 != 3) goto L18;
            MediaEventFilter r16 = (MediaEventFilter) ZeusTransformUtils.preCheckCast(r12.readTypedObject(MediaEventFilter.CREATOR), MediaEventFilter.class, "com.obric.memorydata.plugin");
            MediaEventSubscribeOptions r17 = (MediaEventSubscribeOptions) ZeusTransformUtils.preCheckCast(r12.readTypedObject(MediaEventSubscribeOptions.CREATOR), MediaEventSubscribeOptions.class, "com.obric.memorydata.plugin");
            IAIMediaEventCallback r1 = IAIMediaEventCallback.Stub.asInterface(r12.readStrongBinder());
            r12.enforceNoDataAvail();
            int r18 = subscribeEvents(r16, r17, r1);
        L23:
            r13.writeNoException();
            r13.writeInt(r18);
            goto L27
        L18:
            if (r11 != 4) goto L20;
            int r19 = r12.readInt();
            r12.enforceNoDataAvail();
            r18 = unsubscribeEvents(r19);
            goto L23
        L20:
            return super.onTransact(r11, r12, r13, r14);
        }
    }

    int queryEvents(MediaEventFilter r1, long r2, long r4, int r6, String r7, MediaEventQueryResult r8);

    int queryEventsSince(MediaEventFilter r1, long r2, int r4, MediaEventQueryResult r5);

    int subscribeEvents(MediaEventFilter r1, MediaEventSubscribeOptions r2, IAIMediaEventCallback r3);

    int unsubscribeEvents(int r1);
}
