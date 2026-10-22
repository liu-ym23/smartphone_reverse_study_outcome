package cq;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class c implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IBinder f16499a;

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f16499a;
    }

    public final void o(int r5) {
        Parcel r10 = Parcel.obtain();
        Parcel r11 = Parcel.obtain();
        r10.writeInterfaceToken("com.obric.flow.ILauncherOverlayCallbackAidl");     // Catch: Throwable -> L6
        r10.writeInt(r5);     // Catch: Throwable -> L6
        this.f16499a.transact(2, r10, r11, 0);     // Catch: Throwable -> L6
        r11.readException();     // Catch: Throwable -> L6
        r11.recycle();
        r10.recycle();
        return;
    L6:
        th = move-exception;
        r11.recycle();
        r10.recycle();
        throw th;
    }

    public final void p(boolean r5) {
        Parcel r10 = Parcel.obtain();
        Parcel r11 = Parcel.obtain();
        r10.writeInterfaceToken("com.obric.flow.ILauncherOverlayCallbackAidl");     // Catch: Throwable -> L6
        r10.writeInt(r5 ? 1 : 0);     // Catch: Throwable -> L6
        this.f16499a.transact(4, r10, r11, 0);     // Catch: Throwable -> L6
        r11.readException();     // Catch: Throwable -> L6
        r11.recycle();
        r10.recycle();
        return;
    L6:
        th = move-exception;
        r11.recycle();
        r10.recycle();
        throw th;
    }
}
