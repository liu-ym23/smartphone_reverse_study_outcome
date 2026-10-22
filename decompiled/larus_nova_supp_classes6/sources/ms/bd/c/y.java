package ms.bd.c;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class y {
    public final Context a;
    public final String b;
    public final LinkedBlockingQueue c;
    public final x d;

    public y(Context r8) {
        this.b = (String) p2.a(16777217, 0, 0, "80ea82", new byte[]{42, 61, 27, 91, 10, 33, 50, 21, 122, 60, 58, 51});
        this.c = new LinkedBlockingQueue(1);
        this.d = new x(this);
        this.a = r8;
    }

    public final void a(y2 r19) {
        if (Build.VERSION.SDK_INT > 28) goto L5;
        boolean r0 = false;
    L6:
        if (r0 == true) goto L8;
        return;
    L8:
        String r1 = this.a.getPackageName();
        Intent r2 = new Intent();
        r2.setClassName(this.b, (String) p2.a(16777217, 0, 0, "a4d262", new byte[]{115, 57, 26, 8, 4, 33, 107, 17, 123, 111, 99, 55, 89, 85, 12, 55, 116, 28, 54, 103, 62, 27, 4, 71, 34, 41, 81, 16, 39, 116, 121, 53, 18}));
        r2.setAction((String) p2.a(16777217, 0, 0, "408291", new byte[]{38, 61, 70, 8, 4, 51, 57, 95, 100, 113, 36, 124, 74, 69, 18, 47, 56, 31, 39, 113, 49, 51, 89, 82, 72, 53, 50, 3, 127, 107, 38, 55}));
        r2.putExtra((String) p2.a(16777217, 0, 0, "657e2e", new byte[]{36, 56, 73, 95, 15, 103, 59, 90, 107, 38, 38, 121, 84, 16, 31, 115, 56, 90, 118, 62, 32, 57, 69, 28, 8}), r1);
        r2.putExtra((String) p2.a(16777217, 0, 0, "4e702d", new byte[]{38, 104, 73, 10, 15, 102, 57, 10, 107, 115, 36, 41, 84, 69, 31, 114, 58, 10, 116, 117, 43, 110, 74, 87, 8, 103}), true);     // Catch: Exception -> L11
        this.a.startService(r2);     // Catch: Exception -> L11
    L12:
        Intent r3 = new Intent();
        r3.setClassName((String) p2.a(16777217, 0, 0, "16e73e", new byte[]{35, 59, 27, 13, 1, 118, 59, 19, 122, 106, 51, 53}), (String) p2.a(16777217, 0, 0, "7a0bb9", new byte[]{37, 108, 78, 88, 80, 42, 61, 68, 47, 63, 53, 98, 13, 5, 88, 60, 34, 73, 98, 55, 104, 78, 80, 23, 116, 42, 7, 69, 115, 36, 47, 96, 70}));
        r3.setAction((String) p2.a(16777217, 0, 0, "a8a0f8", new byte[]{115, 53, 31, 10, 91, 58, 108, 87, 61, 115, 113, 116, 19, 71, 77, 38, 109, 23, 126, 98, 121, 52, 22, 80, 86, 97, 113, 28, 34, 118, 121, 57, 23}));
        r3.putExtra((String) p2.a(16777217, 0, 0, "a3bfe1", new byte[]{115, 62, 28, 92, 88, 51, 108, 92, 62, 37, 113, 127, 1, 19, 72, 39, 111, 92, 35, 61, 119, 63, 16, 31, 95}), r1);
        if (this.a.bindService(r3, this.d, 1) == false) goto L26;
        r19.a.a = new z((IBinder) this.c.take()).a();     // Catch: Throwable -> L16 Exception -> L21
    L16:
        th = move-exception;
        this.a.unbindService(this.d);
        throw th;
    L19:
        this.a.unbindService(this.d);
        return;
    L26:
        return;
    L5:
        r0 = z2.b(this.a, this.b);
        goto L6
    }
}
