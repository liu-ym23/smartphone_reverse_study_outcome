package d50;

import android.os.Handler;
import android.os.Message;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class a {
    public final Handler a;
    public final HashMap<Integer, c50.d> b;
    public final f50.a c;
    public final HashSet<Integer> d;

    public abstract void b();

    public abstract boolean c(c50.c r1);

    public abstract boolean d(c50.c r1);

    public abstract void e(int r1);

    public abstract void f();

    public final Message a(c50.c r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        int r1 = r4.d;
        if (r1 != (-1)) goto L8;
        return null;
    L8:
        Message r5 = Message.obtain(this.a, r4);
        r5.what = r1;
        return r5;
    }

    public a(c50.a r2, HashMap r3, f50.a r4) {
        this.d = new HashSet();
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
