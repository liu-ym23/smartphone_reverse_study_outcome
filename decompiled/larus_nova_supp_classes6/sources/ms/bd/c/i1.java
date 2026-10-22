package ms.bd.c;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class i1 implements ServiceConnection {
    public final /* synthetic */ j1 a;

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName r1) {
    }

    public i1(j1 r1) {
        this.a = r1;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName r2, IBinder r3) {
        j1 r4 = this.a;
        r4.b = new k1(r3);
    }
}
