package vendor.bytedance.modemcap;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public interface IModemCaptureResponse extends IInterface {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f12898h = null;

    public static class Default implements IModemCaptureResponse {
        public Default() {
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IModemCaptureResponse {
        static final int TRANSACTION_getInterfaceHash = 16777214;
        static final int TRANSACTION_getInterfaceVersion = 16777215;
        static final int TRANSACTION_onGetDiagBufferLog = 6;
        static final int TRANSACTION_onGetDiagMdlogStatus = 5;
        static final int TRANSACTION_onRegisterCallback = 3;
        static final int TRANSACTION_onStartDiagMdlog = 1;
        static final int TRANSACTION_onStopDiagMdlog = 2;
        static final int TRANSACTION_onUnregisterCallback = 4;

        public static class Proxy implements IModemCaptureResponse {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IBinder f12899a;

            public Proxy(IBinder r8) {
                this.f12899a = r8;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f12899a;
            }
        }

        public Stub() {
            markVintfStability();
            attachInterface(this, IModemCaptureResponse.f12898h);
        }

        public static IModemCaptureResponse asInterface(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface(IModemCaptureResponse.f12898h);
            if (r10 == null) goto L12;
            if ((r10 instanceof IModemCaptureResponse) == false) goto L12;
            return (IModemCaptureResponse) r10;
        L12:
            return new Proxy(r8);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r8, Parcel r10, Parcel r11, int r12) {
            String r13 = IModemCaptureResponse.f12898h;
            if (r8 < 1) goto L7;
            if (r8 > TRANSACTION_getInterfaceVersion) goto L7;
            r10.enforceInterface(r13);
        L7:
            if (r8 != 1598968902) goto L10;
            r11.writeString(r13);
            return true;
        L10:
            if (r8 != TRANSACTION_getInterfaceVersion) goto L14;
            r11.writeNoException();
            r11.writeInt(getInterfaceVersion());
            return true;
        L14:
            if (r8 != TRANSACTION_getInterfaceHash) goto L17;
            r11.writeNoException();
            r11.writeString(getInterfaceHash());
            return true;
        L17:
            switch(r8) {
                case 1: goto L25;
                case 2: goto L24;
                case 3: goto L23;
                case 4: goto L22;
                case 5: goto L21;
                case 6: goto L20;
                default: goto L19;
            };
        L20:
            int r14 = r10.readInt();
            r10.enforceNoDataAvail();
            onGetDiagBufferLog(r14);
        L26:
            return true;
        L21:
            int r15 = r10.readInt();
            int r16 = r10.readInt();
            r10.enforceNoDataAvail();
            onGetDiagMdlogStatus(r15, r16);
            goto L26
        L22:
            int r17 = r10.readInt();
            r10.enforceNoDataAvail();
            onUnregisterCallback(r17);
            goto L26
        L23:
            int r18 = r10.readInt();
            r10.enforceNoDataAvail();
            onRegisterCallback(r18);
            goto L26
        L24:
            int r19 = r10.readInt();
            r10.enforceNoDataAvail();
            onStopDiagMdlog(r19);
            goto L26
        L25:
            int r20 = r10.readInt();
            r10.enforceNoDataAvail();
            onStartDiagMdlog(r20);
            goto L26
        L19:
            return super.onTransact(r8, r10, r11, r12);
        }
    }

    static {
        f12898h = "vendor$bytedance$modemcap$IModemCaptureResponse".replace('$', '.');
    }

    String getInterfaceHash();

    int getInterfaceVersion();

    void onGetDiagBufferLog(int r8);

    void onGetDiagMdlogStatus(int r8, int r10);

    void onRegisterCallback(int r8);

    void onStartDiagMdlog(int r8);

    void onStopDiagMdlog(int r8);

    void onUnregisterCallback(int r8);
}
