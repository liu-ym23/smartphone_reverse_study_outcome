package a74;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.bytedance.badger.service.SensorDataService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h implements ServiceConnection {
    public h() {
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName r1) {
        p.b = null;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName r2, IBinder r3) {
        SensorDataService r0 = null;
        if ((r3 instanceof r) == false) goto L5;
        r r4 = (r) r3;
    L6:
        if (r4 == null) goto L8;
        r0 = r4.a;
    L8:
        if (r0 != null) goto L12;
        com.bytedance.badger.utils.m r5 = com.bytedance.badger.utils.m.a();
        Runnable r6 = new f();
    L10:
        r5.b(r6);
        return;
    L12:
        p.b = r0;
        r5 = com.bytedance.badger.utils.m.a();
        r6 = new g();
        goto L10
    L5:
        r4 = null;
        goto L6
    }
}
