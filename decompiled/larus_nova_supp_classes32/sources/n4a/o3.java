package n4a;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Messenger;
import android.text.TextUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class o3 {
    public final s2 a;

    public o3(Context r2) {
        this.a = null;
        this.a = new s2(r2.getApplicationContext());
    }

    public final IBinder a(Intent r5) {
        s2 r0 = this.a;
        r0.getClass();
        String r1 = r5.getStringExtra("a");
        if (TextUtils.isEmpty(r1) == true) goto L10;
        Context r2 = r0.h;
        int r3 = com.loc.i.a;
        if (TextUtils.isEmpty(r1) == true) goto L10;
        v4.d = r1;
        if (r2 == null) goto L10;
        k1.d.b(new v4.a(r2, r1));
    L10:
        v4.b = r5.getStringExtra("b");
        String r4 = r5.getStringExtra("d");
        if (TextUtils.isEmpty(r4) == true) goto L13;
        x4.d = r4;
    L13:
        s2 r6 = this.a;
        r6.getClass();
        if ("true".equals(r5.getStringExtra("as")) == false) goto L19;
        s2.a r7 = r6.g;
        if (r7 == null) goto L19;
        r7.sendEmptyMessageDelayed(9, 100);
    L19:
        return new Messenger(this.a.g).getBinder();
    }
}
