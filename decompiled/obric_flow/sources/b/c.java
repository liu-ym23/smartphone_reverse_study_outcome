package b;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.os.ResultReceiver;

/* JADX INFO: loaded from: classes.dex */
public final class c extends Binder implements b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f803b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ResultReceiver f804a;

    public c(ResultReceiver r5) {
        this.f804a = r5;
        attachInterface(this, b.f802g1);
    }

    @Override // b.b
    public final void a(int r5, Bundle r10) {
        ResultReceiver r11 = this.f804a;
        r11.getClass();
        r11.c(r5, r10);
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int r5, Parcel r10, Parcel r11, int r12) {
        String r13 = b.f802g1;
        if (r5 < 1) goto L8;
        if (r5 > 16777215) goto L8;
        r10.enforceInterface(r13);
    L8:
        if (r5 != 1598968902) goto L11;
        r11.writeString(r13);
        return true;
    L11:
        if (r5 != 1) goto L13;
        int r14 = r10.readInt();
        Parcelable.Creator r15 = Bundle.CREATOR;
        if (r10.readInt() == 0) goto L17;
        Object r16 = r15.createFromParcel(r10);
    L18:
        a(r14, (Bundle) r16);
        return true;
    L17:
        r16 = null;
        goto L18
    L13:
        return super.onTransact(r5, r10, r11, r12);
    }
}
