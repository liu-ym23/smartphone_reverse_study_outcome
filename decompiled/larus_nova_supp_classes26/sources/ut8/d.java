package ut8;

import android.view.MotionEvent;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d implements i.a {
    public final /* synthetic */ b a;

    public d(b r1) {
        this.a = r1;
    }

    @Override // ut8.i.a
    public final void b(i r5, MotionEvent r6) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("endCursor onOutsideTouched, hasInterceptor=");
        if (this.a.u == null) goto L5;
        boolean r2 = true;
    L6:
        r1.append(r2);
        r0.i("BaseWordSelector", r1.toString());
        f r3 = this.a.u;
        if (r3 != null) goto L9;
    L12:
        b.c(this.a, r5, r6, false);
        return;
    L9:
        if (r3.b(r6) == true) goto L12;
        r0.i("BaseWordSelector", "endCursor onOutsideTouched intercepted as keep-show, call onTouchOutside directly");
        this.a.j();
        return;
    L5:
        r2 = false;
        goto L6
    }

    @Override // ut8.i.a
    public final void a(boolean r6, boolean r7, int r8, int r9) {
        b r0 = this.a;
        if (r0.k != (-1)) goto L5;
        r0.k = r9;
    L5:
        b.a(r0, r6, r7, r8, r9);
        ArrayList r10 = new ArrayList(this.a.q);
        int r1 = r10.size();
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L8;
        st8.c r3 = (st8.c) ListProtector.get(r10, r2);
        b r4 = this.a;
        r3.a(r4.j, r7, r9, r4.k);
        r2 = r2 + 1;
        goto L6
    L8:
        b r11 = this.a;
        r11.k = r9;
        b.b(r11, r7, r6);
    }
}
