package android.aimedia;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface IAIMediaEvents extends IInterface {

    public static class Default implements IAIMediaEvents {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.aimedia.IAIMediaEvents
        public int queryEvents(MediaEventFilter r8, long r10, long r11, int r12, String r13, MediaEventQueryResult r14) {
            return 0;
        }

        @Override // android.aimedia.IAIMediaEvents
        public int queryEventsSince(MediaEventFilter r8, long r10, int r11, MediaEventQueryResult r12) {
            return 0;
        }

        @Override // android.aimedia.IAIMediaEvents
        public int subscribeEvents(MediaEventFilter r8, MediaEventSubscribeOptions r10, IAIMediaEventCallback r11) {
            return 0;
        }

        @Override // android.aimedia.IAIMediaEvents
        public int unsubscribeEvents(int r8) {
            return 0;
        }
    }

    public static abstract class Stub extends Binder implements IAIMediaEvents {
        private static final String DESCRIPTOR = "android.aimedia.IAIMediaEvents";
        static final int TRANSACTION_queryEvents = 1;
        static final int TRANSACTION_queryEventsSince = 2;
        static final int TRANSACTION_subscribeEvents = 3;
        static final int TRANSACTION_unsubscribeEvents = 4;

        public static class Proxy implements IAIMediaEvents {
            public static IAIMediaEvents sDefaultImpl;
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

            @Override // android.aimedia.IAIMediaEvents
            public int queryEvents(MediaEventFilter r13, long r14, long r16, int r18, String r19, MediaEventQueryResult r20) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                if (r13 == null) goto L6;
                r10.writeInt(1);     // Catch: Throwable -> L19
                r13.writeToParcel(r10, 0);     // Catch: Throwable -> L19
            L7:
                r10.writeLong(r14);     // Catch: Throwable -> L19
                r10.writeLong(r16);     // Catch: Throwable -> L19
                r10.writeInt(r18);     // Catch: Throwable -> L19
                r10.writeString(r19);     // Catch: Throwable -> L19
                if (this.mRemote.transact(1, r10, r11, 0) == false) goto L10;
            L14:
                r11.readException();     // Catch: Throwable -> L19
                int r8 = r11.readInt();     // Catch: Throwable -> L19
                if (r11.readInt() == 0) goto L17;
                r20.readFromParcel(r11);     // Catch: Throwable -> L19
            L17:
                r11.recycle();
                r10.recycle();
                return r8;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                int r12 = Stub.getDefaultImpl().queryEvents(r13, r14, r16, r18, r19, r20);     // Catch: Throwable -> L19
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                r10.writeInt(0);     // Catch: Throwable -> L19
            L19:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // android.aimedia.IAIMediaEvents
            public int queryEventsSince(MediaEventFilter r10, long r11, int r12, MediaEventQueryResult r13) {
                Parcel r8 = Parcel.obtain();
                Parcel r14 = Parcel.obtain();
                r8.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                if (r10 == null) goto L6;
                r8.writeInt(1);     // Catch: Throwable -> L19
                r10.writeToParcel(r8, 0);     // Catch: Throwable -> L19
            L7:
                r8.writeLong(r11);     // Catch: Throwable -> L19
                r8.writeInt(r12);     // Catch: Throwable -> L19
                if (this.mRemote.transact(2, r8, r14, 0) == false) goto L10;
            L14:
                r14.readException();     // Catch: Throwable -> L19
                int r15 = r14.readInt();     // Catch: Throwable -> L19
                if (r14.readInt() == 0) goto L17;
                r13.readFromParcel(r14);     // Catch: Throwable -> L19
            L17:
                r14.recycle();
                r8.recycle();
                return r15;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                int r16 = Stub.getDefaultImpl().queryEventsSince(r10, r11, r12, r13);     // Catch: Throwable -> L19
                r14.recycle();
                r8.recycle();
                return r16;
            L6:
                r8.writeInt(0);     // Catch: Throwable -> L19
            L19:
                th = move-exception;
                r14.recycle();
                r8.recycle();
                throw th;
            }

            @Override // android.aimedia.IAIMediaEvents
            public int subscribeEvents(MediaEventFilter r8, MediaEventSubscribeOptions r10, IAIMediaEventCallback r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L23
                if (r8 == null) goto L6;
                r12.writeInt(1);     // Catch: Throwable -> L23
                r8.writeToParcel(r12, 0);     // Catch: Throwable -> L23
            L7:
                if (r10 == null) goto L9;
                r12.writeInt(1);     // Catch: Throwable -> L23
                r10.writeToParcel(r12, 0);     // Catch: Throwable -> L23
            L10:
                if (r11 == null) goto L12;
                IBinder r14 = r11.asBinder();     // Catch: Throwable -> L23
            L13:
                r12.writeStrongBinder(r14);     // Catch: Throwable -> L23
                if (this.mRemote.transact(3, r12, r13, 0) == false) goto L16;
            L20:
                r13.readException();     // Catch: Throwable -> L23
                int r15 = r13.readInt();     // Catch: Throwable -> L23
                r13.recycle();
                r12.recycle();
                return r15;
            L16:
                if (Stub.getDefaultImpl() == null) goto L20;
                int r16 = Stub.getDefaultImpl().subscribeEvents(r8, r10, r11);     // Catch: Throwable -> L23
                r13.recycle();
                r12.recycle();
                return r16;
            L12:
                r14 = null;
                goto L13
            L9:
                r12.writeInt(0);     // Catch: Throwable -> L23
                goto L10
            L6:
                r12.writeInt(0);     // Catch: Throwable -> L23
            L23:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // android.aimedia.IAIMediaEvents
            public int unsubscribeEvents(int r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r10.writeInt(r8);     // Catch: Throwable -> L13
                if (this.mRemote.transact(4, r10, r11, 0) == false) goto L6;
            L10:
                r11.readException();     // Catch: Throwable -> L13
                int r12 = r11.readInt();     // Catch: Throwable -> L13
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r13 = Stub.getDefaultImpl().unsubscribeEvents(r8);     // Catch: Throwable -> L13
                r11.recycle();
                r10.recycle();
                return r13;
            L13:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IAIMediaEvents asInterface(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface(DESCRIPTOR);
            if (r10 == null) goto L12;
            if ((r10 instanceof IAIMediaEvents) == false) goto L12;
            return (IAIMediaEvents) r10;
        L12:
            return new Proxy(r8);
        }

        public static IAIMediaEvents getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IAIMediaEvents r8) {
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
        public boolean onTransact(int r12, Parcel r13, Parcel r14, int r15) {
            MediaEventFilter r8 = null;
            MediaEventSubscribeOptions r10 = null;
            MediaEventFilter r11 = null;
            if (r12 != 1) goto L5;
            r13.enforceInterface(DESCRIPTOR);
            if (r13.readInt() == 0) goto L35;
            r8 = MediaEventFilter.CREATOR.createFromParcel(r13);
        L35:
            long r16 = r13.readLong();
            long r17 = r13.readLong();
            int r18 = r13.readInt();
            String r19 = r13.readString();
            MediaEventQueryResult r110 = new MediaEventQueryResult();
            int r111 = queryEvents(r8, r16, r17, r18, r19, r110);
            r14.writeNoException();
            r14.writeInt(r111);
            r14.writeInt(1);
            r110.writeToParcel(r14, 1);
            return true;
        L5:
            if (r12 != 2) goto L7;
            r13.enforceInterface(DESCRIPTOR);
            if (r13.readInt() == 0) goto L30;
            r11 = MediaEventFilter.CREATOR.createFromParcel(r13);
        L30:
            long r20 = r13.readLong();
            int r21 = r13.readInt();
            MediaEventQueryResult r112 = new MediaEventQueryResult();
            int r113 = queryEventsSince(r11, r20, r21, r112);
            r14.writeNoException();
            r14.writeInt(r113);
            r14.writeInt(1);
            r112.writeToParcel(r14, 1);
            return true;
        L7:
            if (r12 != 3) goto L9;
            r13.enforceInterface(DESCRIPTOR);
            if (r13.readInt() == 0) goto L22;
            MediaEventFilter r114 = MediaEventFilter.CREATOR.createFromParcel(r13);
        L24:
            if (r13.readInt() == 0) goto L26;
            r10 = MediaEventSubscribeOptions.CREATOR.createFromParcel(r13);
        L26:
            int r115 = subscribeEvents(r114, r10, IAIMediaEventCallback.Stub.asInterface(r13.readStrongBinder()));
        L17:
            r14.writeNoException();
            r14.writeInt(r115);
            return true;
        L22:
            r114 = null;
            goto L24
        L9:
            if (r12 != 4) goto L11;
            r13.enforceInterface(DESCRIPTOR);
            r115 = unsubscribeEvents(r13.readInt());
            goto L17
        L11:
            if (r12 != 1598968902) goto L13;
            r14.writeString(DESCRIPTOR);
            return true;
        L13:
            return super.onTransact(r12, r13, r14, r15);
        }
    }

    int queryEvents(MediaEventFilter r8, long r10, long r11, int r12, String r13, MediaEventQueryResult r14);

    int queryEventsSince(MediaEventFilter r8, long r10, int r11, MediaEventQueryResult r12);

    int subscribeEvents(MediaEventFilter r8, MediaEventSubscribeOptions r10, IAIMediaEventCallback r11);

    int unsubscribeEvents(int r8);
}
