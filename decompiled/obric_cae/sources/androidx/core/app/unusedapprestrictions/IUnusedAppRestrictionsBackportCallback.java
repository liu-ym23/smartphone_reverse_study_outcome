package androidx.core.app.unusedapprestrictions;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface IUnusedAppRestrictionsBackportCallback extends IInterface {

    public static class Default implements IUnusedAppRestrictionsBackportCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IUnusedAppRestrictionsBackportCallback {

        public static class Proxy implements IUnusedAppRestrictionsBackportCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IBinder f1673a;

            public Proxy(IBinder r8) {
                this.f1673a = r8;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f1673a;
            }
        }

        public Stub() {
            attachInterface(this, "androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback");
        }

        public static IUnusedAppRestrictionsBackportCallback H2(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface("androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback");
            if (r10 == null) goto L12;
            if ((r10 instanceof IUnusedAppRestrictionsBackportCallback) == false) goto L12;
            return (IUnusedAppRestrictionsBackportCallback) r10;
        L12:
            return new Proxy(r8);
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int r8, Parcel r10, Parcel r11, int r12) {
            boolean r13 = true;
            if (r8 < 1) goto L8;
            if (r8 > 16777215) goto L8;
            r10.enforceInterface("androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback");
        L8:
            if (r8 == 1598968902) goto L22;
            if (r8 == 1) goto L13;
            return super.onTransact(r8, r10, r11, r12);
        L13:
            if (r10.readInt() == 0) goto L15;
            boolean r14 = true;
        L17:
            if (r10.readInt() != 0) goto L20;
            r13 = false;
        L20:
            R0(r14, r13);
            throw null;
        L15:
            r14 = false;
            goto L17
        L22:
            r11.writeString("androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback");
            return true;
        }
    }

    void R0(boolean r8, boolean r10);
}
