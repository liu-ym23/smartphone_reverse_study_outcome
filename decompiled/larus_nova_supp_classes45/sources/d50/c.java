package d50;

import android.os.Message;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class c extends a {
    public int e;
    public final long f;

    @Override // d50.a
    public final void b() {
        this.e = -1;
        g();
    }

    @Override // d50.a
    public final void f() {
        this.e = -1;
        g();
    }

    public final void g() {
        if (this.e == (-1)) goto L5;
        return;
    L5:
        Iterator<Map.Entry<Integer, c50.d>> r0 = this.b.entrySet().iterator();
        c50.c r2 = null;
    L7:
        if (r0.hasNext() == false) goto L29;
        Map.Entry<Integer, c50.d> r3 = r0.next();
        if (r3 == null) goto L7;
        if (r3.getKey() == null) goto L7;
        if (r3.getValue() == null) goto L7;
        if (this.d.contains(Integer.valueOf(r3.getKey().intValue())) == true) goto L7;
        c50.d r4 = r3.getValue();
        if (r4.d.size() > 0) goto L21;
        c50.c r5 = null;
    L22:
        if (r5 == null) goto L7;
        if (r2 == null) goto L28;
        if (r2.c <= r5.c) goto L7;
    L28:
        r2 = r5;
        goto L7
    L21:
        r5 = (c50.c) ListProtector.get(r4.d, 0);
        goto L22
    L29:
        h(r2);
    }

    @Override // d50.a
    public final boolean c(c50.c r1) {
        g();
        return true;
    }

    @Override // d50.a
    public final boolean d(c50.c r2) {
        if (this.e != r2.hashCode()) goto L7;
        this.e = -1;
        g();
        return true;
    L7:
        return true;
    }

    @Override // d50.a
    public final void e(int r1) {
        g();
    }

    public void h(c50.c r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        Message r0 = a(r7);
        if (r0 == null) goto L8;
        this.c.a(this.b, r7);
        this.e = r7.hashCode();
        this.a.sendMessageAtTime(r0, r7.c + this.f);
        return;
    }

    public c(c50.a r1, HashMap r2, f50.a r3, long r4) {
        super(r1, r2, r3);
        this.e = -1;
        this.f = 0;
        if (r4 > 0) goto L5;
        r4 = 0;
    L5:
        this.f = r4;
    }
}
