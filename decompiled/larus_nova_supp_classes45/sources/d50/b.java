package d50;

import android.os.Handler;
import android.os.Message;
import com.bytedance.android.live.core.utils.ListUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b extends a {
    @Override // d50.a
    public final void b() {
    }

    @Override // d50.a
    public final boolean d(c50.c r1) {
        return false;
    }

    @Override // d50.a
    public final void f() {
    }

    @Override // d50.a
    public final boolean c(c50.c r6) {
        int r0 = r6.d;
        if (this.d.contains(Integer.valueOf(r0)) == true) goto L10;
        Message r1 = a(r6);
        if (r1 == null) goto L8;
        this.c.a(this.b, r6);
        this.a.sendMessageAtTime(r1, r6.c);
        return true;
    L8:
        return false;
    L10:
        f50.a r2 = this.c;
        HashMap<Integer, c50.d> r3 = this.b;
        if (r2.a == false) goto L17;
        if (r3 == null) goto L17;
        c50.d r7 = r3.get(Integer.valueOf(r6.d));
        if (r7 == null) goto L17;
        r7.b();
    L17:
        return true;
    }

    @Override // d50.a
    public final void e(int r6) {
        if (r6 != (-1)) goto L5;
        return;
    L5:
        c50.d r0 = this.b.get(Integer.valueOf(r6));
        if (r0 != null) goto L8;
        return;
    L8:
        ArrayList<c50.c> r1 = r0.d;
        if (ListUtils.isEmpty(r1) == false) goto L11;
        return;
    L11:
        f50.a r2 = this.c;
        Handler r3 = this.a;
        HashMap<Integer, c50.d> r4 = this.b;
        if (r2.a == false) goto L19;
        if (r4 == null) goto L18;
        c50.d r7 = r4.get(Integer.valueOf(r6));
        if (r7 == null) goto L18;
        r7.b();
    L18:
        r2.b(r3, r4);
    L19:
        Iterator<c50.c> r8 = r1.iterator();
    L21:
        if (r8.hasNext() == false) goto L27;
        c50.c r5 = r8.next();
        if (r5 == null) goto L21;
        Message r9 = a(r5);
        if (r9 == null) goto L21;
        this.a.sendMessage(r9);
        goto L21
    L27:
        f50.a r11 = this.c;
        Handler r12 = this.a;
        HashMap<Integer, c50.d> r13 = this.b;
        if (r11.a == false) goto L39;
        r11.b(r12, r13);
        return;
    }

    public b(c50.a r1, HashMap r2, f50.a r3) {
        super(r1, r2, r3);
    }
}
