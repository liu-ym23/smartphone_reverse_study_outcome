package android.support.v4.os;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public interface IResultReceiver extends IInterface {

    public static class Default implements IResultReceiver {
        public Default() {
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IResultReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f432a = 0;

        public static class Proxy implements IResultReceiver {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IBinder f433a;

            public Proxy(IBinder r8) {
                this.f433a = r8;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f433a;
            }
        }

        public Stub() {
            attachInterface(this, "android.support.v4.os.IResultReceiver");
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int r8, Parcel r10, Parcel r11, int r12) {
            if (r8 < 1) goto L8;
            if (r8 > 16777215) goto L8;
            r10.enforceInterface("android.support.v4.os.IResultReceiver");
        L8:
            if (r8 == 1598968902) goto L14;
            if (r8 != 1) goto L11;
            ResultReceiver.MyResultReceiver r13 = (ResultReceiver.MyResultReceiver) this;
            r13.send(r10.readInt(), (Bundle) a.a(r10, Bundle.CREATOR));
            return true;
        L11:
            return super.onTransact(r8, r10, r11, r12);
        L14:
            r11.writeString("android.support.v4.os.IResultReceiver");
            return true;
        }
    }

    public static class a {
        public static Object a(Parcel r8, Parcelable.Creator r10) {
            if (r8.readInt() != 0) goto L7;
            return null;
        L7:
            return r10.createFromParcel(r8);
        }
    }
}
