package android.app;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public interface IDisplayInfoCallbackEx extends IInterface {

    public static abstract class a extends Binder implements IDisplayInfoCallbackEx {
        private static final String DESCRIPTOR = "android.app.IDisplayInfoCallbackEx";
        static final int TRANSACTION_onDisplaySecureChanged = 1;

        /* JADX INFO: renamed from: android.app.IDisplayInfoCallbackEx$a$a, reason: collision with other inner class name */
        private static class C0003a implements IDisplayInfoCallbackEx {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static IDisplayInfoCallbackEx f25a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f26b;

            C0003a(IBinder r3) {
                this.f26b = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f26b;
            }

            @Override // android.app.IDisplayInfoCallbackEx
            public void onDisplaySecureChanged(int r4, boolean r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(a.DESCRIPTOR);     // Catch: Throwable -> L16
                r0.writeInt(r4);     // Catch: Throwable -> L16
                if (r5 == false) goto L6;
                int r2 = 1;
            L7:
                r0.writeInt(r2);     // Catch: Throwable -> L16
                if (this.f26b.transact(1, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (a.getDefaultImpl() == null) goto L14;
                a.getDefaultImpl().onDisplaySecureChanged(r4, r5);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = 0;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }
        }

        public a() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IDisplayInfoCallbackEx asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IDisplayInfoCallbackEx.class) == false) goto L13;
            return (IDisplayInfoCallbackEx) ZeusTransformUtils.preCheckCast(r0, IDisplayInfoCallbackEx.class, "com.obric.memorydata.plugin");
        L13:
            return new C0003a(r4);
        }

        public static IDisplayInfoCallbackEx getDefaultImpl() {
            return C0003a.f25a;
        }

        public static boolean setDefaultImpl(IDisplayInfoCallbackEx r2) {
            IDisplayInfoCallbackEx r3 = (IDisplayInfoCallbackEx) ZeusTransformUtils.wrapperContextForParams(r2, IDisplayInfoCallbackEx.class, "com.obric.memorydata.plugin");
            if (C0003a.f25a != null) goto L7;
            if (r3 == null) goto L9;
            C0003a.f25a = r3;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface(DESCRIPTOR);
            int r8 = r5.readInt();
            if (r5.readInt() == 0) goto L13;
            boolean r9 = true;
        L14:
            onDisplaySecureChanged(r8, r9);
            return true;
        L13:
            r9 = false;
            goto L14
        L5:
            if (r4 != 1598968902) goto L7;
            r6.writeString(DESCRIPTOR);
            return true;
        L7:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    void onDisplaySecureChanged(int r1, boolean r2);
}
