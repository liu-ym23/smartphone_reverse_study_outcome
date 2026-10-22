package ms.bd.c;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.obric.sva.sdk.data.ISmModel;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class y0 {
    public final Context a;
    public final LinkedBlockingQueue b;
    public final x0 c;

    public y0(Context r3) {
        this.b = new LinkedBlockingQueue(ISmModel.VERSION_0400);
        this.c = new x0(this);
        this.a = r3;
    }

    public final void a(y2 r10) {
        if (z2.b(this.a, (String) p2.a(16777217, 0, 0, "abb5f2", new byte[]{115, 111, 28, 15, 81, 48, 99, 84, 54, 108, 62, 104, 6, 72, 93})) == true) goto L5;
        return;
    L5:
        Intent r0 = new Intent((String) p2.a(16777217, 0, 0, "34ed76", new byte[]{33, 57, 27, 94, 29, 46, 52, 28, 39, 122, 45, 38, 19, 30, 12, 36, 38, 28, 55, 49, 108, 25, 38, 53, 38, 8, 20, 38, 11, 7, 7, 4, 32, 57, 43, 4}));
        r0.setPackage((String) p2.a(16777217, 0, 0, "b54fa8", new byte[]{112, 56, 74, 92, 86, 58, 96, 3, 96, 63, 61, 63, 80, 27, 90}));
        if (this.a.bindService(r0, this.c, 1) == false) goto L17;
        r10.a.a = new z0((IBinder) this.b.take()).a();     // Catch: Throwable -> L9 Exception -> L14
    L9:
        th = move-exception;
        this.a.unbindService(this.c);
        throw th;
    L12:
        this.a.unbindService(this.c);
        return;
    }
}
