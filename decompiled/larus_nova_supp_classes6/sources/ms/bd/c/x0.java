package ms.bd.c;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class x0 implements ServiceConnection {
    public final /* synthetic */ y0 a;

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName r1) {
    }

    public x0(y0 r1) {
        this.a = r1;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName r1, IBinder r2) {
        this.a.b.put(r2);     // Catch: Exception -> L4
        return;
    }
}
