package ms.bd.c;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class q1 extends View {
    public final /* synthetic */ r1 a;

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r9) {
        super.onTouchEvent(r9);
        long r0 = r9.getEventTime();
        u1 r2 = this.a.g;
        long r3 = r2.d;
        long r5 = 0;
        if (r3 == 0) goto L6;
        r5 = r0 - r3;
    L6:
        r2.c = r5;
        r2.d = r0;
        r2.e.a = r9.getX();
        this.a.g.e.b = r9.getY();
        this.a.g.b++;
        String r10 = (String) p2.a(16777217, 0, 0, "212cd9", new byte[]{7, 60, 84, 46, 82, 32, 29, 25, 117, 54});
        String r11 = (String) p2.a(16777217, 0, 0, "131d56", new byte[]{101, 53, 24, 80, 39, 46, 38, 27, 111, 58, 5, 39, 71, 30, 30, 123, 114, 87, 115});
        return true;
    }

    public q1(r1 r1, Context r2) {
        this.a = r1;
        super(r2);
    }
}
