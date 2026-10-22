package nq;

import ai.j0;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.obric.matrix.platform.sdk.ones.dataanalysis.MatrixTeaManager;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends Binder implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MatrixTeaManager f20298a;

    public i(MatrixTeaManager r5) {
        this.f20298a = r5;
        attachInterface(this, "com.obric.matrix.platform.sdk.ones.dataanalysis.IDeviceInfoCallback");
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int r5, Parcel r10, Parcel r11, int r12) {
        MatrixTeaManager r13 = this.f20298a;
        if (r5 != 1) goto L5;
        r10.enforceInterface("com.obric.matrix.platform.sdk.ones.dataanalysis.IDeviceInfoCallback");
        String r14 = r10.readString();
        Intrinsics.checkNotNullParameter(r14, "deviceId");
        StringBuilder r15 = j0.x("回调deviceId: ", r14, "， listeners.size = ");
        r15.append(MatrixTeaManager.access$getListeners$p(r13).size());
        com.lynx.jsbridge.a.s("MatrixTeaManager", r15.toString());
        MatrixTeaManager.access$setDid$cp(r14);
        Iterator r16 = MatrixTeaManager.access$getListeners$p(r13).iterator();
        if (r16.hasNext() == true) goto L23;
        r11.writeNoException();
        return true;
    L23:
        if (r16.next() != null) goto L27;
        com.lynx.jsbridge.a.s("MatrixTeaManager", "回调deviceId了，开始回调listener: " + r14 + " , listener = null");
        throw null;
    L27:
        throw new ClassCastException();
    L5:
        if (r5 != 2) goto L7;
        r10.enforceInterface("com.obric.matrix.platform.sdk.ones.dataanalysis.IDeviceInfoCallback");
        String r17 = r10.readString();
        Intrinsics.checkNotNullParameter(r17, "installId");
        MatrixTeaManager.access$setMyInstallId$cp(r17);
        Iterator r18 = MatrixTeaManager.access$getListeners$p(r13).iterator();
        if (r18.hasNext() == true) goto L17;
        r11.writeNoException();
        return true;
    L17:
        throw androidx.constraintlayout.motion.widget.a.g(r18);
    L7:
        if (r5 != 1598968902) goto L9;
        r11.writeString("com.obric.matrix.platform.sdk.ones.dataanalysis.IDeviceInfoCallback");
        return true;
    L9:
        return super.onTransact(r5, r10, r11, r12);
    }
}
