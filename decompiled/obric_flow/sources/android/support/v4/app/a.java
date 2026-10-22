package android.support.v4.app;

import android.app.Notification;
import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IBinder f353a;

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f353a;
    }

    @Override // android.support.v4.app.c
    public final void cancel(String r5, int r10, String r11) {
        Parcel r12 = Parcel.obtain();
        r12.writeInterfaceToken(c.f1);     // Catch: Throwable -> L6
        r12.writeString(r5);     // Catch: Throwable -> L6
        r12.writeInt(r10);     // Catch: Throwable -> L6
        r12.writeString(r11);     // Catch: Throwable -> L6
        this.f353a.transact(2, r12, null, 1);     // Catch: Throwable -> L6
        r12.recycle();
        return;
    L6:
        th = move-exception;
        r12.recycle();
        throw th;
    }

    @Override // android.support.v4.app.c
    public final void cancelAll(String r5) {
        Parcel r10 = Parcel.obtain();
        r10.writeInterfaceToken(c.f1);     // Catch: Throwable -> L6
        r10.writeString(r5);     // Catch: Throwable -> L6
        this.f353a.transact(3, r10, null, 1);     // Catch: Throwable -> L6
        r10.recycle();
        return;
    L6:
        th = move-exception;
        r10.recycle();
        throw th;
    }

    @Override // android.support.v4.app.c
    public final void notify(String r5, int r10, String r11, Notification r12) {
        Parcel r13 = Parcel.obtain();
        r13.writeInterfaceToken(c.f1);     // Catch: Throwable -> L10
        r13.writeString(r5);     // Catch: Throwable -> L10
        r13.writeInt(r10);     // Catch: Throwable -> L10
        r13.writeString(r11);     // Catch: Throwable -> L10
        if (r12 == null) goto L6;
        r13.writeInt(1);     // Catch: Throwable -> L10
        r12.writeToParcel(r13, 0);     // Catch: Throwable -> L10
    L7:
        this.f353a.transact(1, r13, null, 1);     // Catch: Throwable -> L10
        r13.recycle();
        return;
    L6:
        r13.writeInt(0);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        r13.recycle();
        throw th;
    }
}
