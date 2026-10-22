package ms.bd.c;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class j1 {
    public final Context a;
    public k1 b;
    public final i1 c;

    public j1(Context r2) {
        this.c = new i1(this);
        this.a = r2;
    }

    public final void a(y2 r10) {
        Intent r0 = new Intent();
        r0.setClassName((String) p2.a(16777217, 0, 0, "24610a", new byte[]{32, 57, 72, 11, 21, 99, 56, 91, 99, 100, 53, 63, 70, 64, 6, 114, 34, 16, 117, 119, 42, 53, 64}), (String) p2.a(16777217, 0, 0, "da27f1", new byte[]{118, 108, 76, 13, 67, 51, 110, 14, 103, 98, 99, 106, 66, 70, 80, 34, 116, 69, 113, 113, 124, 96, 68, 13, 125, 35, 113, 73, 96, 98, 124, 103, 114, 70, 75, 48, 110, 67, 102}));
        if (this.a.bindService(r0, this.c, 1) == false) goto L12;
        k1 r1 = this.b;     // Catch: Throwable -> L9
        if (r1 == null) goto L7;
        r10.a.a = r1.a();     // Catch: Throwable -> L9
    L7:
        this.a.unbindService(this.c);
        return;
    }
}
