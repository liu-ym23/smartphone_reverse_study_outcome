package lha;

import android.os.Binder;
import android.os.Parcel;
import com.obric.assistant.system.DeviceLockedStateServiceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class c extends Binder {
    public final /* synthetic */ String a;
    public final /* synthetic */ DeviceLockedStateServiceImpl b;

    public c(String r1, DeviceLockedStateServiceImpl r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int r3, Parcel r4, Parcel r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "data");
        if (r3 != 1) goto L5;
        r4.enforceInterface(this.a);
        DeviceLockedStateServiceImpl r7 = this.b;
        if (r4.readInt() == 0) goto L12;
        boolean r8 = true;
    L13:
        int r9 = DeviceLockedStateServiceImpl.h;
        r7.h(r8, "onDeviceLockedStateChanged");
        return true;
    L12:
        r8 = false;
        goto L13
    L5:
        if (r3 != 1598968902) goto L15;
        if (r5 == null) goto L16;
        r5.writeString(this.a);
        return true;
    L16:
        return true;
    L15:
        return super.onTransact(r3, r4, r5, r6);
    }
}
