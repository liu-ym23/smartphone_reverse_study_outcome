package vendor.bytedance.wwansensor;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public interface ISensorNotifyCallback extends IInterface {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f12902j = 1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f12903k = "44ab3fe75b6d6bed13a14ac4fb590d4501db5c40";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f12904l = null;

    public static class Default implements ISensorNotifyCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements ISensorNotifyCallback {
        static final int TRANSACTION_getInterfaceHash = 16777214;
        static final int TRANSACTION_getInterfaceVersion = 16777215;
        static final int TRANSACTION_onCellPoiStatusChange = 3;
        static final int TRANSACTION_onDbUpdateResult = 1;
        static final int TRANSACTION_onStartOemSensorResult = 2;

        public static class Proxy implements ISensorNotifyCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IBinder f12905a;

            public Proxy(IBinder r8) {
                this.f12905a = r8;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f12905a;
            }
        }

        public Stub() {
            markVintfStability();
            attachInterface(this, ISensorNotifyCallback.f12904l);
        }

        public static ISensorNotifyCallback asInterface(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface(ISensorNotifyCallback.f12904l);
            if (r10 == null) goto L12;
            if ((r10 instanceof ISensorNotifyCallback) == false) goto L12;
            return (ISensorNotifyCallback) r10;
        L12:
            return new Proxy(r8);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r20, Parcel r21, Parcel r22, int r23) {
            String r8 = ISensorNotifyCallback.f12904l;
            if (r20 < 1) goto L8;
            if (r20 > TRANSACTION_getInterfaceVersion) goto L8;
            r21.enforceInterface(r8);
        L8:
            if (r20 != 1598968902) goto L11;
            r22.writeString(r8);
            return true;
        L11:
            if (r20 != TRANSACTION_getInterfaceVersion) goto L15;
            r22.writeNoException();
            r22.writeInt(getInterfaceVersion());
            return true;
        L15:
            if (r20 != TRANSACTION_getInterfaceHash) goto L18;
            r22.writeNoException();
            r22.writeString(getInterfaceHash());
            return true;
        L18:
            if (r20 != 1) goto L20;
            int r10 = r21.readInt();
            int r11 = r21.readInt();
            int r12 = r21.readInt();
            int r13 = r21.readInt();
            int r14 = r21.readInt();
            r21.enforceNoDataAvail();
            onDbUpdateResult(r10, r11, r12, r13, r14);
        L28:
            return true;
        L20:
            if (r20 != 2) goto L22;
            int r15 = r21.readInt();
            int r16 = r21.readInt();
            int r17 = r21.readInt();
            boolean r18 = r21.readBoolean();
            int r19 = r21.readInt();
            r21.enforceNoDataAvail();
            onStartOemSensorResult(r15, r16, r17, r18, r19);
            goto L28
        L22:
            if (r20 != 3) goto L24;
            int r24 = r21.readInt();
            int r25 = r21.readInt();
            int r26 = r21.readInt();
            int r27 = r21.readInt();
            long r110 = r21.readLong();
            int r111 = r21.readInt();
            r21.enforceNoDataAvail();
            onCellPoiStatusChange(r24, r25, r26, r27, r110, r111);
            goto L28
        L24:
            return super.onTransact(r20, r21, r22, r23);
        }
    }

    static {
        f12904l = "vendor$bytedance$wwansensor$ISensorNotifyCallback".replace('$', '.');
    }

    String getInterfaceHash();

    int getInterfaceVersion();

    void onCellPoiStatusChange(int r8, int r10, int r11, int r12, long r13, int r14);

    void onDbUpdateResult(int r8, int r10, int r11, int r12, int r13);

    void onStartOemSensorResult(int r8, int r10, int r11, boolean r12, int r13);
}
