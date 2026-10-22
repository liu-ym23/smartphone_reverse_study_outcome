package b;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IBinder f801a;

    @Override // b.b
    public final void a(int r5, Bundle r10) {
        Parcel r11 = Parcel.obtain();
        r11.writeInterfaceToken(b.f802g1);     // Catch: Throwable -> L10
        r11.writeInt(r5);     // Catch: Throwable -> L10
        if (r10 == null) goto L6;
        r11.writeInt(1);     // Catch: Throwable -> L10
        r10.writeToParcel(r11, 0);     // Catch: Throwable -> L10
    L7:
        this.f801a.transact(1, r11, null, 1);     // Catch: Throwable -> L10
        r11.recycle();
        return;
    L6:
        r11.writeInt(0);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        r11.recycle();
        throw th;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f801a;
    }
}
