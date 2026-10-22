package nq;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IBinder f20292a;

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f20292a;
    }

    public final void d(String r5, String r10) {
        Parcel r11 = Parcel.obtain();
        Parcel r12 = Parcel.obtain();
        r11.writeInterfaceToken("com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService");     // Catch: Throwable -> L9
        r11.writeString(r5);     // Catch: Throwable -> L9
        r11.writeString(r10);     // Catch: Throwable -> L9
        if (this.f20292a.transact(5, r11, r12, 0) == true) goto L6;
        int r13 = c.f20293a;     // Catch: Throwable -> L9
    L6:
        r12.readException();     // Catch: Throwable -> L9
        r12.recycle();
        r11.recycle();
        return;
    L9:
        th = move-exception;
        r12.recycle();
        r11.recycle();
        throw th;
    }
}
