package ms.bd.c;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class a implements ServiceConnection {
    public final /* synthetic */ b a;

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName r1) {
    }

    public a(b r1) {
        this.a = r1;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName r1, IBinder r2) {
        this.a.b.put(r2);     // Catch: Exception -> L4
        return;
    }
}
