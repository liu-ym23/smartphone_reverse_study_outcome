package androidx.room;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface IMultiInstanceInvalidationCallback extends IInterface {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f2576d = null;

    public static class Default implements IMultiInstanceInvalidationCallback {
        public Default() {
        }

        @Override // androidx.room.IMultiInstanceInvalidationCallback
        public final void M(String[] r8) {
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IMultiInstanceInvalidationCallback {

        public static class Proxy implements IMultiInstanceInvalidationCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IBinder f2577a;

            public Proxy(IBinder r8) {
                this.f2577a = r8;
            }

            @Override // androidx.room.IMultiInstanceInvalidationCallback
            public final void M(String[] r8) {
                Parcel r10 = Parcel.obtain();
                r10.writeInterfaceToken(IMultiInstanceInvalidationCallback.f2576d);     // Catch: Throwable -> L6
                r10.writeStringArray(r8);     // Catch: Throwable -> L6
                this.f2577a.transact(1, r10, null, 1);     // Catch: Throwable -> L6
                r10.recycle();
                return;
            L6:
                th = move-exception;
                r10.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f2577a;
            }
        }

        public Stub() {
            attachInterface(this, IMultiInstanceInvalidationCallback.f2576d);
        }

        public static IMultiInstanceInvalidationCallback H2(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface(IMultiInstanceInvalidationCallback.f2576d);
            if (r10 == null) goto L12;
            if ((r10 instanceof IMultiInstanceInvalidationCallback) == false) goto L12;
            return (IMultiInstanceInvalidationCallback) r10;
        L12:
            return new Proxy(r8);
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int r8, Parcel r10, Parcel r11, int r12) {
            String r13 = IMultiInstanceInvalidationCallback.f2576d;
            if (r8 < 1) goto L8;
            if (r8 > 16777215) goto L8;
            r10.enforceInterface(r13);
        L8:
            if (r8 != 1598968902) goto L11;
            r11.writeString(r13);
            return true;
        L11:
            if (r8 != 1) goto L13;
            MultiInstanceInvalidationClient$callback$1 r14 = (MultiInstanceInvalidationClient$callback$1) this;
            r14.M(r10.createStringArray());
            return true;
        L13:
            return super.onTransact(r8, r10, r11, r12);
        }
    }

    static {
        f2576d = "androidx$room$IMultiInstanceInvalidationCallback".replace('$', '.');
    }

    void M(String[] r8);
}
