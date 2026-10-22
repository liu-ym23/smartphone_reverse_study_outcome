package nq;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.obric.matrix.platform.sdk.ones.dataanalysis.MatrixTeaManager;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MatrixTeaManager f20297a;

    public h(MatrixTeaManager r5) {
        this.f20297a = r5;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName r10, IBinder r11) {
        MatrixTeaManager r5 = this.f20297a;
        com.lynx.jsbridge.a.s("MatrixTeaManager", "onServiceConnected: ");     // Catch: Exception -> L26
        i r12 = null;
        MatrixTeaManager.access$getHandler$p(r5).removeCallbacksAndMessages(null);     // Catch: Exception -> L26
        int r13 = c.f20293a;     // Catch: Exception -> L26
        if (r11 != null) goto L7;
        d r14 = null;
    L13:
        MatrixTeaManager.access$setService$p(r5, r14);     // Catch: Exception -> L26
        MatrixTeaManager.access$setBound$p(r5, true);     // Catch: Exception -> L26
        d r15 = MatrixTeaManager.access$getService$p(r5);     // Catch: Exception -> L26
        if (r15 == null) goto L24;
        i r16 = MatrixTeaManager.access$getDeviceInfoCallback$p(r5);     // Catch: Exception -> L26
        b r17 = (b) r15;     // Catch: Exception -> L26
        Parcel r18 = Parcel.obtain();     // Catch: Exception -> L26
        Parcel r19 = Parcel.obtain();     // Catch: Exception -> L26
        r18.writeInterfaceToken("com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService");     // Catch: Throwable -> L21
        if (r16 == null) goto L19;
        r12 = r16;
    L19:
        r18.writeStrongBinder(r12);     // Catch: Throwable -> L21
        r17.f20292a.transact(3, r18, r19, 0);     // Catch: Throwable -> L21
        r19.readException();     // Catch: Throwable -> L21
        r19.recycle();     // Catch: Exception -> L26
        r18.recycle();     // Catch: Exception -> L26
        goto L24
    L21:
        th = move-exception;
        r19.recycle();     // Catch: Exception -> L26
        r18.recycle();     // Catch: Exception -> L26
        throw th;     // Catch: Exception -> L26
    L24:
        MatrixTeaManager.access$processPendingEvents(r5);     // Catch: Exception -> L26
        return;
    L7:
        IInterface r20 = r11.queryLocalInterface("com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService");     // Catch: Exception -> L26
        if (r20 != null) goto L10;
    L12:
        b r21 = new b();     // Catch: Exception -> L26
        r21.f20292a = r11;     // Catch: Exception -> L26
        r14 = r21;
        goto L13
    L10:
        if ((r20 instanceof d) == false) goto L12;
        r14 = (d) r20;     // Catch: Exception -> L26
    L26:
        com.lynx.jsbridge.a.r("MatrixTeaManager", "onServiceConnected error");
        r5.rebindService();
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName r5) {
        this.f20297a.rebindService();
    }
}
