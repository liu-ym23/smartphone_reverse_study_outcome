package c9;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public interface c extends IInterface {

    public static abstract class a extends Binder implements c {
        public a() {
            attachInterface(this, "com.obric.matrix.platform.sdk.ones.dataanalysis.IDeviceInfoCallback");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) {
            if (r10 != 1) goto L5;
            r11.enforceInterface("com.obric.matrix.platform.sdk.ones.dataanalysis.IDeviceInfoCallback");
            b1(r11.readString());
        L13:
            r12.writeNoException();
            return true;
        L5:
            if (r10 != 2) goto L7;
            r11.enforceInterface("com.obric.matrix.platform.sdk.ones.dataanalysis.IDeviceInfoCallback");
            O1(r11.readString());
            goto L13
        L7:
            if (r10 != 1598968902) goto L9;
            r12.writeString("com.obric.matrix.platform.sdk.ones.dataanalysis.IDeviceInfoCallback");
            return true;
        L9:
            return super.onTransact(r10, r11, r12, r13);
        }
    }

    void O1(String r10);

    void b1(String r10);
}
