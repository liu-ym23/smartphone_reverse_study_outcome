package na;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: na.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0249a extends Binder implements a {
        public AbstractBinderC0249a() {
            attachInterface(this, "com.obric.processservice.WatchInterface");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) {
            if (r10 != 1) goto L5;
            r11.enforceInterface("com.obric.processservice.WatchInterface");
            boolean r14 = init();
            r12.writeNoException();
            r12.writeInt(r14 ? 1 : 0);
            return true;
        L5:
            if (r10 != 1598968902) goto L7;
            r12.writeString("com.obric.processservice.WatchInterface");
            return true;
        L7:
            return super.onTransact(r10, r11, r12, r13);
        }
    }

    boolean init();
}
