package android.app;

import android.content.ComponentName;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface IServiceConnection extends IInterface {

    public static abstract class Stub extends Binder implements IServiceConnection {

        public static class Proxy implements IServiceConnection {
            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return null;
            }
        }

        public Stub() {
            attachInterface(this, "android.app.IServiceConnection");
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int r8, Parcel r10, Parcel r11, int r12) {
            if (r8 != 1) goto L5;
            r10.enforceInterface("android.app.IServiceConnection");
            if (r10.readInt() == 0) goto L13;
            ComponentName r13 = (ComponentName) ComponentName.CREATOR.createFromParcel(r10);
        L13:
            z2(r10.readStrongBinder());
            return true;
        L5:
            if (r8 != 1598968902) goto L7;
            r11.writeString("android.app.IServiceConnection");
            return true;
        L7:
            return super.onTransact(r8, r10, r11, r12);
        }
    }

    void z2(IBinder r8);
}
