package vendor.bytedance.modemcap;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface IModemCapture extends IInterface {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f12896g = null;

    public static class Default implements IModemCapture {
        public Default() {
        }

        @Override // vendor.bytedance.modemcap.IModemCapture
        public final void J1(String r8, int r10, int r11, int r12, int r13) {
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }

        @Override // vendor.bytedance.modemcap.IModemCapture
        public final int t0(String r8, IModemCaptureResponse r10) {
            return 0;
        }

        @Override // vendor.bytedance.modemcap.IModemCapture
        public final void v(IModemCaptureResponse r8) {
        }

        @Override // vendor.bytedance.modemcap.IModemCapture
        public final void y2(int r8) {
        }
    }

    public static abstract class Stub extends Binder implements IModemCapture {

        public static class Proxy implements IModemCapture {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IBinder f12897a;

            public Proxy(IBinder r8) {
                this.f12897a = r8;
            }

            @Override // vendor.bytedance.modemcap.IModemCapture
            public final void J1(String r8, int r10, int r11, int r12, int r13) {
                Parcel r14 = Parcel.obtain(asBinder());
                r14.writeInterfaceToken(IModemCapture.f12896g);     // Catch: Throwable -> L9
                r14.writeString(r8);     // Catch: Throwable -> L9
                r14.writeInt(r10);     // Catch: Throwable -> L9
                r14.writeInt(r11);     // Catch: Throwable -> L9
                r14.writeInt(r12);     // Catch: Throwable -> L9
                r14.writeInt(r13);     // Catch: Throwable -> L9
                if (this.f12897a.transact(3, r14, null, 1) == false) goto L8;
                r14.recycle();
                return;
            L8:
                throw new RemoteException("Method startDiagMdlog is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                r14.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f12897a;
            }

            @Override // vendor.bytedance.modemcap.IModemCapture
            public final int t0(String r8, IModemCaptureResponse r10) {
                Parcel r11 = Parcel.obtain(asBinder());
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(IModemCapture.f12896g);     // Catch: Throwable -> L10
                r11.writeString(r8);     // Catch: Throwable -> L10
                r11.writeStrongInterface(r10);     // Catch: Throwable -> L10
                if (this.f12897a.transact(1, r11, r12, 0) == false) goto L9;
                r12.readException();     // Catch: Throwable -> L10
                int r13 = r12.readInt();     // Catch: Throwable -> L10
                r12.recycle();
                r11.recycle();
                return r13;
            L9:
                throw new RemoteException("Method registerCallback is unimplemented.");     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // vendor.bytedance.modemcap.IModemCapture
            public final void v(IModemCaptureResponse r8) {
                Parcel r10 = Parcel.obtain(asBinder());
                r10.writeInterfaceToken(IModemCapture.f12896g);     // Catch: Throwable -> L9
                r10.writeStrongInterface(r8);     // Catch: Throwable -> L9
                if (this.f12897a.transact(2, r10, null, 1) == false) goto L8;
                r10.recycle();
                return;
            L8:
                throw new RemoteException("Method unregisterCallback is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                r10.recycle();
                throw th;
            }

            @Override // vendor.bytedance.modemcap.IModemCapture
            public final void y2(int r8) {
                Parcel r10 = Parcel.obtain(asBinder());
                r10.writeInterfaceToken(IModemCapture.f12896g);     // Catch: Throwable -> L9
                r10.writeInt(r8);     // Catch: Throwable -> L9
                if (this.f12897a.transact(4, r10, null, 1) == false) goto L8;
                r10.recycle();
                return;
            L8:
                throw new RemoteException("Method stopDiagMdlog is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                r10.recycle();
                throw th;
            }
        }

        public Stub() {
            markVintfStability();
            attachInterface(this, IModemCapture.f12896g);
        }

        public static IModemCapture H2(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface(IModemCapture.f12896g);
            if (r10 == null) goto L12;
            if ((r10 instanceof IModemCapture) == false) goto L12;
            return (IModemCapture) r10;
        L12:
            return new Proxy(r8);
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) {
            String r8 = IModemCapture.f12896g;
            if (r10 < 1) goto L7;
            if (r10 > 16777215) goto L7;
            r11.enforceInterface(r8);
        L7:
            if (r10 != 1598968902) goto L10;
            r12.writeString(r8);
            return true;
        L10:
            if (r10 != 16777215) goto L14;
            r12.writeNoException();
            r12.writeInt(getInterfaceVersion());
            return true;
        L14:
            if (r10 != 16777214) goto L17;
            r12.writeNoException();
            r12.writeString(getInterfaceHash());
            return true;
        L17:
            switch(r10) {
                case 1: goto L25;
                case 2: goto L24;
                case 3: goto L23;
                case 4: goto L22;
                case 5: goto L21;
                case 6: goto L20;
                default: goto L19;
            };
        L20:
            r11.readInt();
            r11.enforceNoDataAvail();
            d2();
        L26:
            return true;
        L21:
            r11.readInt();
            r11.enforceNoDataAvail();
            Z0();
            goto L26
        L22:
            int r14 = r11.readInt();
            r11.enforceNoDataAvail();
            y2(r14);
            goto L26
        L23:
            String r15 = r11.readString();
            int r16 = r11.readInt();
            int r17 = r11.readInt();
            int r18 = r11.readInt();
            int r19 = r11.readInt();
            r11.enforceNoDataAvail();
            J1(r15, r16, r17, r18, r19);
            goto L26
        L24:
            IModemCaptureResponse r110 = IModemCaptureResponse.Stub.asInterface(r11.readStrongBinder());
            r11.enforceNoDataAvail();
            v(r110);
            goto L26
        L25:
            String r111 = r11.readString();
            IModemCaptureResponse r112 = IModemCaptureResponse.Stub.asInterface(r11.readStrongBinder());
            r11.enforceNoDataAvail();
            int r20 = t0(r111, r112);
            r12.writeNoException();
            r12.writeInt(r20);
            goto L26
        L19:
            return super.onTransact(r10, r11, r12, r13);
        }
    }

    static {
        f12896g = "vendor$bytedance$modemcap$IModemCapture".replace('$', '.');
    }

    void J1(String r8, int r10, int r11, int r12, int r13);

    void Z0();

    void d2();

    String getInterfaceHash();

    int getInterfaceVersion();

    int t0(String r8, IModemCaptureResponse r10);

    void v(IModemCaptureResponse r8);

    void y2(int r8);
}
