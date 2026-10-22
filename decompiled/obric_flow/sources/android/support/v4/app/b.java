package android.support.v4.app;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public abstract class b extends Binder implements c {
    static final int TRANSACTION_cancel = 2;
    static final int TRANSACTION_cancelAll = 3;
    static final int TRANSACTION_notify = 1;

    public static c asInterface(IBinder r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        IInterface r10 = r5.queryLocalInterface(c.f1);
        if (r10 != null) goto L8;
    L11:
        a r11 = new a();
        r11.f353a = r5;
        return r11;
    L8:
        if ((r10 instanceof c) == false) goto L11;
        return (c) r10;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int r5, Parcel r10, Parcel r11, int r12) throws RemoteException {
        String r13 = c.f1;
        if (r5 < 1) goto L8;
        if (r5 > 16777215) goto L8;
        r10.enforceInterface(r13);
    L8:
        if (r5 != 1598968902) goto L11;
        r11.writeString(r13);
        return true;
    L11:
        if (r5 != 1) goto L13;
        String r14 = r10.readString();
        int r15 = r10.readInt();
        String r16 = r10.readString();
        Parcelable.Creator r17 = Notification.CREATOR;
        if (r10.readInt() == 0) goto L23;
        Object r18 = r17.createFromParcel(r10);
    L24:
        notify(r14, r15, r16, (Notification) r18);
    L25:
        return true;
    L23:
        r18 = null;
        goto L24
    L13:
        if (r5 != 2) goto L15;
        cancel(r10.readString(), r10.readInt(), r10.readString());
        goto L25
    L15:
        if (r5 != 3) goto L17;
        cancelAll(r10.readString());
        goto L25
    L17:
        return super.onTransact(r5, r10, r11, r12);
    }
}
