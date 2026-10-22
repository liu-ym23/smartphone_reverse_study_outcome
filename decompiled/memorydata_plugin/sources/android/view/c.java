package android.view;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public interface c extends IInterface {

    public static abstract class a extends Binder implements c {

        /* JADX INFO: renamed from: android.view.c$a$a, reason: collision with other inner class name */
        private static class cC0020a implements c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static c f85a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f86b;

            cC0020a(IBinder r3) {
                this.f86b = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // android.view.c
            public Bundle a() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("android.view.IFloatingTransitionStateProvider");     // Catch: Throwable -> L17
                if (this.f86b.transact(1, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L17
                if (r1.readInt() == 0) goto L14;
                Bundle r4 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r1), Bundle.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
            L15:
                r1.recycle();
                r0.recycle();
                return r4;
            L14:
                r4 = null;
                goto L15
            L6:
                if (a.b() == null) goto L10;
                Bundle r5 = a.b().a();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r5;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f86b;
            }
        }

        public a() {
            attachInterface(this, "android.view.IFloatingTransitionStateProvider");
        }

        public static c a(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface("android.view.IFloatingTransitionStateProvider");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, c.class) == false) goto L13;
            return (c) ZeusTransformUtils.preCheckCast(r0, c.class, "com.obric.memorydata.plugin");
        L13:
            return new cC0020a(r4);
        }

        public static c b() {
            return cC0020a.f85a;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface("android.view.IFloatingTransitionStateProvider");
            Bundle r3 = a();
            r6.writeNoException();
            if (r3 == null) goto L13;
            r6.writeInt(1);
            r3.writeToParcel(r6, 1);
        L14:
            return true;
        L13:
            r6.writeInt(0);
            goto L14
        L5:
            if (r4 != 1598968902) goto L7;
            r6.writeString("android.view.IFloatingTransitionStateProvider");
            return true;
        L7:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    Bundle a();
}
