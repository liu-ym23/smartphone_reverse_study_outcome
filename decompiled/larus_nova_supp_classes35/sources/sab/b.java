package sab;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.custom.repeat.widget.wheelview.WheelView;
import java.util.TimerTask;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b extends TimerTask {
    public final WheelView a;
    public int b;
    public int c;
    public final int d;

    public final void a() {
        if (this.b != Integer.MAX_VALUE) goto L5;
        this.b = this.d;
    L5:
        int r0 = this.b;
        int r1 = (int) (r0 * 0.1f);
        this.c = r1;
        if (r1 != 0) goto L11;
        if (r0 >= 0) goto L9;
        this.c = -1;
        goto L11
    L9:
        this.c = 1;
    L11:
        if (Math.abs(r0) > 1) goto L13;
        this.a.a();
        this.a.b.sendEmptyMessage(3000);
        return;
    L13:
        WheelView r2 = this.a;
        r2.v += this.c;
        if (r2.r == true) goto L21;
        float r3 = r2.l;
        float r4 = (-r2.w) * r3;
        int r5 = r2.getItemsCount() - 1;
        WheelView r6 = this.a;
        float r7 = (r5 - r6.w) * r3;
        float r8 = r6.v;
        if (r8 > r4) goto L18;
    L19:
        r6.v = r8 - this.c;
        r6.a();
        this.a.b.sendEmptyMessage(3000);
        return;
    L18:
        if (r8 >= r7) goto L19;
    L21:
        this.a.getClass();
        this.a.b.sendEmptyMessage(1000);
        this.b -= this.c;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b(WheelView r1, int r2) {
        this.a = r1;
        this.d = r2;
        this.b = Integer.MAX_VALUE;
        this.c = 0;
    }
}
