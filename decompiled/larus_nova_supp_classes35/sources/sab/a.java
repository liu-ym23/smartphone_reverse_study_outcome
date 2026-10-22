package sab;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.custom.repeat.widget.wheelview.WheelView;
import java.util.TimerTask;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends TimerTask {
    public final float a;
    public final WheelView b;
    public float c;

    public final void a() {
        if (this.c != 2.1474836E9f) goto L12;
        if (Math.abs(this.a) > 2000.0f) goto L7;
        this.c = this.a;
        goto L12
    L7:
        if (this.a <= 0.0f) goto L9;
        this.c = 2000.0f;
        goto L12
    L9:
        this.c = -2000.0f;
    L12:
        if (Math.abs(this.c) >= 0.0f) goto L14;
    L17:
        int r0 = (int) ((this.c * 10.0f) / 1000.0f);
        WheelView r3 = this.b;
        float r1 = r0;
        r3.v -= r1;
        if (r3.r == true) goto L31;
        float r4 = r3.l;
        float r5 = (-r3.w) * r4;
        int r6 = r3.getItemsCount() - 1;
        WheelView r7 = this.b;
        float r8 = (r6 - r7.w) * r4;
        float r9 = r7.v;
        float r10 = r4 * 0.25f;
        if ((r9 - r10) >= r5) goto L23;
        r5 = r9 + r1;
    L26:
        if (r9 > r5) goto L29;
        this.c = 40.0f;
        r7.v = (int) r5;
        goto L31
    L29:
        if (r9 < r8) goto L31;
        r7.v = (int) r8;
        this.c = -40.0f;
        goto L31
    L23:
        if ((r10 + r9) <= r8) goto L26;
        r8 = r9 + r1;
    L31:
        float r2 = this.c;
        if (r2 >= 0.0f) goto L34;
        this.c = r2 + 20.0f;
    L35:
        this.b.getClass();
        this.b.b.sendEmptyMessage(1000);
        return;
    L34:
        this.c = r2 - 20.0f;
        goto L35
    L14:
        if (Math.abs(this.c) > 20.0f) goto L17;
        this.b.a();
        this.b.b.sendEmptyMessage(2000);
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

    public a(WheelView r1, float r2) {
        this.b = r1;
        this.a = r2;
        this.c = 2.1474836E9f;
    }
}
