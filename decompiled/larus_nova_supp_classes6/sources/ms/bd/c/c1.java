package ms.bd.c;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class c1 extends Binder implements IInterface {
    public static final String d = null;
    public volatile String a;
    public final y2 b;
    public final /* synthetic */ d1 c;

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    static {
        d = (String) p2.a(16777217, 0, 0, "2297c9", new byte[]{32, 63, 71, 13, 84, 39, 57, 28, 102, 104, 49, 126, 73, 79, 83, 59, 53, 0, 109, 117, 53, 57, 73, 70, 18, 33, 48, 26, 108, 41, 10, 31, 107, 106, 120, 13, 48, 31, 100, 69, 34, 51, 65});
    }

    public c1(d1 r7, y2 r8) {
        this.c = r7;
        attachInterface(this, (String) p2.a(16777217, 0, 0, "eac9a7", new byte[]{119, 108, 29, 3, 86, 41, 110, 79, 60, 102, 102, 45, 19, 65, 81, 53, 98, 83, 55, 123, 98, 106, 19, 72, 16, 47, 103, 73, 54, 39, 93, 76, 49, 100, 122, 3, 103, 76, 62, 75, 117, 96, 27}));
        this.a = "";
        this.b = r8;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
        String r0 = d;
        if (r4 != 1) goto L5;
        r5.enforceInterface(r0);
        r5.readInt();
        r5.readLong();
        r5.readInt();
        r5.readFloat();
        r5.readDouble();
        r5.readString();
        r6.writeNoException();
        return true;
    L5:
        if (r4 != 2) goto L7;
        r5.enforceInterface(r0);
        int r8 = r5.readInt();
        if (r5.readInt() == 0) goto L15;
        Bundle r9 = (Bundle) Bundle.CREATOR.createFromParcel(r5);
    L16:
        this.c.getClass();
        if (r8 != 0) goto L22;
        if (r9 == null) goto L22;
        this.a = r9.getString(this.c.a);
        y2 r10 = this.b;
        if (r10 == null) goto L22;
        r10.a.a = this.a;
    L22:
        r6.writeNoException();
        return true;
    L15:
        r9 = null;
        goto L16
    L7:
        if (r4 != 1598968902) goto L9;
        r6.writeString(r0);
        return true;
    L9:
        return super.onTransact(r4, r5, r6, r7);
    }
}
