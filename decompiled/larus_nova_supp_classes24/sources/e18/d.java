package e18;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.audio.call.dora.CommandStatus;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class d implements Runnable {
    public final WheelView a;
    public float b;

    public final void a() {
        float r0 = Math.abs(this.b);
        boolean r1 = false;
        if (0.0f <= r0) goto L5;
    L7:
        if (r1 == false) goto L10;
        this.a.cancelFuture();
        this.a.getWheelHandler().sendEmptyMessage(2000);
        return;
    L10:
        float r2 = (this.b * 10.0f) / 1000.0f;
        WheelView r3 = this.a;
        r3.setTotalScrollY(r3.getTotalScrollY() - r2);
        if (this.a.isLoop() == true) goto L25;
        float r4 = this.a.getItemHeight();
        float r5 = (-this.a.getInitPosition()) * r4;
        float r6 = ((this.a.getItemsCount() - 1) - this.a.getInitPosition()) * r4;
        double r8 = ((double) r4) * 0.25d;
        if ((((double) this.a.getTotalScrollY()) - r8) >= r5) goto L17;
        r5 = this.a.getTotalScrollY() + r2;
    L20:
        if (this.a.getTotalScrollY() > r5) goto L23;
        this.b = 40.0f;
        this.a.setTotalScrollY(r5);
        goto L25
    L23:
        if (this.a.getTotalScrollY() < r6) goto L25;
        this.a.setTotalScrollY(r6);
        this.b = -40.0f;
        goto L25
    L17:
        if ((((double) this.a.getTotalScrollY()) + r8) <= r6) goto L20;
        r6 = this.a.getTotalScrollY() + r2;
    L25:
        float r7 = this.b;
        if (r7 >= 0.0f) goto L28;
        float r9 = r7 + 20.0f;
    L29:
        this.b = r9;
        this.a.checkLoopChange(-r2);
        this.a.getWheelHandler().sendEmptyMessage(CommandStatus.DORA_TRACE);
        return;
    L28:
        r9 = r7 - 20.0f;
        goto L29
    L5:
        if (r0 > 20.0f) goto L7;
        r1 = true;
        goto L7
    }

    @Override // java.lang.Runnable
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

    public d(WheelView r2, float r3) {
        Intrinsics.checkNotNullParameter(r2, "wheelView");
        this.a = r2;
        if (Math.abs(r3) > 2000.0f) goto L5;
    L8:
        this.b = r3;
        return;
    L5:
        if (r3 <= 0.0f) goto L7;
        r3 = 2000.0f;
        goto L8
    L7:
        r3 = -2000.0f;
        goto L8
    }
}
