package androidx.core.app.unusedapprestrictions;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes.dex */
public interface IUnusedAppRestrictionsBackportCallback extends IInterface {
    public static final String DESCRIPTOR = null;

    public static class Default implements IUnusedAppRestrictionsBackportCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback
        public void onIsPermissionRevocationEnabledForAppResult(boolean r10, boolean r11) {
        }
    }

    public static abstract class Stub extends Binder implements IUnusedAppRestrictionsBackportCallback {
        static final int TRANSACTION_onIsPermissionRevocationEnabledForAppResult = 1;

        private static class Proxy implements IUnusedAppRestrictionsBackportCallback {
            private IBinder mRemote;

            Proxy(IBinder r10) {
                this.mRemote = r10;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IUnusedAppRestrictionsBackportCallback.DESCRIPTOR;
            }

            @Override // androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback
            public void onIsPermissionRevocationEnabledForAppResult(boolean r10, boolean r11) {
                Parcel r12 = Parcel.obtain();
                r12.writeInterfaceToken(IUnusedAppRestrictionsBackportCallback.DESCRIPTOR);     // Catch: Throwable -> L13
                int r13 = 0;
                if (r10 == false) goto L6;
                int r14 = 1;
            L7:
                r12.writeInt(r14);     // Catch: Throwable -> L13
                if (r11 == false) goto L10;
                r13 = 1;
            L10:
                r12.writeInt(r13);     // Catch: Throwable -> L13
                this.mRemote.transact(1, r12, null, 1);     // Catch: Throwable -> L13
                r12.recycle();
                return;
            L6:
                r14 = 0;
            L13:
                th = move-exception;
                r12.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, IUnusedAppRestrictionsBackportCallback.DESCRIPTOR);
        }

        public static IUnusedAppRestrictionsBackportCallback asInterface(IBinder r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            IInterface r11 = r10.queryLocalInterface(IUnusedAppRestrictionsBackportCallback.DESCRIPTOR);
            if (r11 == null) goto L12;
            if ((r11 instanceof IUnusedAppRestrictionsBackportCallback) == false) goto L12;
            return (IUnusedAppRestrictionsBackportCallback) r11;
        L12:
            return new Proxy(r10);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) {
            String r14 = IUnusedAppRestrictionsBackportCallback.DESCRIPTOR;
            if (r10 < 1) goto L8;
            if (r10 > 16777215) goto L8;
            r11.enforceInterface(r14);
        L8:
            if (r10 == 1598968902) goto L21;
            if (r10 != 1) goto L11;
            boolean r15 = false;
            if (r11.readInt() == 0) goto L15;
            boolean r16 = true;
        L17:
            if (r11.readInt() == 0) goto L19;
            r15 = true;
        L19:
            onIsPermissionRevocationEnabledForAppResult(r16, r15);
            return true;
        L15:
            r16 = false;
            goto L17
        L11:
            return super.onTransact(r10, r11, r12, r13);
        L21:
            r12.writeString(r14);
            return true;
        }
    }

    static {
        DESCRIPTOR = "androidx$core$app$unusedapprestrictions$IUnusedAppRestrictionsBackportCallback".replace(Typography.dollar, '.');
    }

    void onIsPermissionRevocationEnabledForAppResult(boolean r10, boolean r11);
}
