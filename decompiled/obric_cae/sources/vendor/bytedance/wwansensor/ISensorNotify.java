package vendor.bytedance.wwansensor;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface ISensorNotify extends IInterface {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f12900i = null;

    public static class Default implements ISensorNotify {
        public Default() {
        }

        @Override // vendor.bytedance.wwansensor.ISensorNotify
        public final void I0(int r8, int r10, int r11, int r12) {
        }

        @Override // vendor.bytedance.wwansensor.ISensorNotify
        public final void X0(int r8, boolean r10, int r11, int r12) {
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }

        @Override // vendor.bytedance.wwansensor.ISensorNotify
        public final void c(int r8) {
        }

        @Override // vendor.bytedance.wwansensor.ISensorNotify
        public final int z0(ISensorNotifyCallback r8) {
            return 0;
        }
    }

    public static abstract class Stub extends Binder implements ISensorNotify {

        public static class Proxy implements ISensorNotify {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IBinder f12901a;

            public Proxy(IBinder r8) {
                this.f12901a = r8;
            }

            @Override // vendor.bytedance.wwansensor.ISensorNotify
            public final void I0(int r8, int r10, int r11, int r12) {
                Parcel r13 = Parcel.obtain(asBinder());
                r13.writeInterfaceToken(ISensorNotify.f12900i);     // Catch: Throwable -> L9
                r13.writeInt(r8);     // Catch: Throwable -> L9
                r13.writeInt(r10);     // Catch: Throwable -> L9
                r13.writeInt(r11);     // Catch: Throwable -> L9
                r13.writeInt(r12);     // Catch: Throwable -> L9
                if (this.f12901a.transact(3, r13, null, 1) == false) goto L8;
                r13.recycle();
                return;
            L8:
                throw new RemoteException("Method notifyDbUpdate is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                r13.recycle();
                throw th;
            }

            @Override // vendor.bytedance.wwansensor.ISensorNotify
            public final void X0(int r8, boolean r10, int r11, int r12) {
                Parcel r13 = Parcel.obtain(asBinder());
                r13.writeInterfaceToken(ISensorNotify.f12900i);     // Catch: Throwable -> L9
                r13.writeInt(r8);     // Catch: Throwable -> L9
                r13.writeInt(r11);     // Catch: Throwable -> L9
                r13.writeInt(r12);     // Catch: Throwable -> L9
                r13.writeBoolean(r10);     // Catch: Throwable -> L9
                if (this.f12901a.transact(4, r13, null, 1) == false) goto L8;
                r13.recycle();
                return;
            L8:
                throw new RemoteException("Method startOemSensor is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                r13.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f12901a;
            }

            @Override // vendor.bytedance.wwansensor.ISensorNotify
            public final void c(int r8) {
                Parcel r10 = Parcel.obtain(asBinder());
                r10.writeInterfaceToken(ISensorNotify.f12900i);     // Catch: Throwable -> L9
                r10.writeInt(r8);     // Catch: Throwable -> L9
                if (this.f12901a.transact(2, r10, null, 1) == false) goto L8;
                r10.recycle();
                return;
            L8:
                throw new RemoteException("Method unregisterCallback is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                r10.recycle();
                throw th;
            }

            @Override // vendor.bytedance.wwansensor.ISensorNotify
            public final int z0(ISensorNotifyCallback r8) {
                Parcel r10 = Parcel.obtain(asBinder());
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(ISensorNotify.f12900i);     // Catch: Throwable -> L10
                r10.writeStrongInterface(r8);     // Catch: Throwable -> L10
                if (this.f12901a.transact(1, r10, r11, 0) == false) goto L9;
                r11.readException();     // Catch: Throwable -> L10
                int r12 = r11.readInt();     // Catch: Throwable -> L10
                r11.recycle();
                r10.recycle();
                return r12;
            L9:
                throw new RemoteException("Method registerCallback is unimplemented.");     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }
        }

        public Stub() {
            markVintfStability();
            attachInterface(this, ISensorNotify.f12900i);
        }

        public static ISensorNotify H2(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface(ISensorNotify.f12900i);
            if (r10 == null) goto L12;
            if ((r10 instanceof ISensorNotify) == false) goto L12;
            return (ISensorNotify) r10;
        L12:
            return new Proxy(r8);
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int r8, Parcel r10, Parcel r11, int r12) {
            String r13 = ISensorNotify.f12900i;
            if (r8 < 1) goto L7;
            if (r8 > 16777215) goto L7;
            r10.enforceInterface(r13);
        L7:
            if (r8 != 1598968902) goto L10;
            r11.writeString(r13);
            return true;
        L10:
            if (r8 != 16777215) goto L14;
            r11.writeNoException();
            r11.writeInt(getInterfaceVersion());
            return true;
        L14:
            if (r8 != 16777214) goto L17;
            r11.writeNoException();
            r11.writeString(getInterfaceHash());
            return true;
        L17:
            if (r8 != 1) goto L19;
            ISensorNotifyCallback r14 = ISensorNotifyCallback.Stub.asInterface(r10.readStrongBinder());
            r10.enforceNoDataAvail();
            int r15 = z0(r14);
            r11.writeNoException();
            r11.writeInt(r15);
        L30:
            return true;
        L19:
            if (r8 != 2) goto L21;
            int r16 = r10.readInt();
            r10.enforceNoDataAvail();
            c(r16);
            goto L30
        L21:
            if (r8 != 3) goto L23;
            int r17 = r10.readInt();
            int r18 = r10.readInt();
            int r19 = r10.readInt();
            int r20 = r10.readInt();
            r10.enforceNoDataAvail();
            I0(r17, r18, r19, r20);
            goto L30
        L23:
            if (r8 != 4) goto L25;
            int r21 = r10.readInt();
            int r22 = r10.readInt();
            int r23 = r10.readInt();
            boolean r24 = r10.readBoolean();
            r10.enforceNoDataAvail();
            X0(r21, r24, r22, r23);
            goto L30
        L25:
            return super.onTransact(r8, r10, r11, r12);
        }
    }

    static {
        f12900i = "vendor$bytedance$wwansensor$ISensorNotify".replace('$', '.');
    }

    void I0(int r8, int r10, int r11, int r12);

    void X0(int r8, boolean r10, int r11, int r12);

    void c(int r8);

    String getInterfaceHash();

    int getInterfaceVersion();

    int z0(ISensorNotifyCallback r8);
}
