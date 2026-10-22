package androidx.core.app.unusedapprestrictions;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.annotation.RestrictTo;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
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
        public void onIsPermissionRevocationEnabledForAppResult(boolean r5, boolean r10) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IUnusedAppRestrictionsBackportCallback {
        static final int TRANSACTION_onIsPermissionRevocationEnabledForAppResult = 1;

        public static class Proxy implements IUnusedAppRestrictionsBackportCallback {
            private IBinder mRemote;

            public Proxy(IBinder r5) {
                this.mRemote = r5;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IUnusedAppRestrictionsBackportCallback.DESCRIPTOR;
            }

            @Override // androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback
            public void onIsPermissionRevocationEnabledForAppResult(boolean r5, boolean r10) throws RemoteException {
                Parcel r11 = Parcel.obtain();
                r11.writeInterfaceToken(IUnusedAppRestrictionsBackportCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r11.writeInt(r5 ? 1 : 0);     // Catch: Throwable -> L6
                r11.writeInt(r10 ? 1 : 0);     // Catch: Throwable -> L6
                this.mRemote.transact(1, r11, null, 1);     // Catch: Throwable -> L6
                r11.recycle();
                return;
            L6:
                th = move-exception;
                r11.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, IUnusedAppRestrictionsBackportCallback.DESCRIPTOR);
        }

        public static IUnusedAppRestrictionsBackportCallback asInterface(IBinder r5) {
            if (r5 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r5.queryLocalInterface(IUnusedAppRestrictionsBackportCallback.DESCRIPTOR);
            if (r10 == null) goto L12;
            if ((r10 instanceof IUnusedAppRestrictionsBackportCallback) == false) goto L12;
            return (IUnusedAppRestrictionsBackportCallback) r10;
        L12:
            return new Proxy(r5);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r5, Parcel r10, Parcel r11, int r12) throws RemoteException {
            String r13 = IUnusedAppRestrictionsBackportCallback.DESCRIPTOR;
            if (r5 < 1) goto L8;
            if (r5 > 16777215) goto L8;
            r10.enforceInterface(r13);
        L8:
            if (r5 != 1598968902) goto L11;
            r11.writeString(r13);
            return true;
        L11:
            if (r5 != 1) goto L13;
            boolean r14 = false;
            if (r10.readInt() == 0) goto L17;
            boolean r15 = true;
        L19:
            if (r10.readInt() == 0) goto L21;
            r14 = true;
        L21:
            onIsPermissionRevocationEnabledForAppResult(r15, r14);
            return true;
        L17:
            r15 = false;
            goto L19
        L13:
            return super.onTransact(r5, r10, r11, r12);
        }
    }

    static {
        DESCRIPTOR = "androidx$core$app$unusedapprestrictions$IUnusedAppRestrictionsBackportCallback".replace(Typography.dollar, '.');
    }

    void onIsPermissionRevocationEnabledForAppResult(boolean r5, boolean r10) throws RemoteException;
}
