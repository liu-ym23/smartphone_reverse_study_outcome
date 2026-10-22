package e18;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.audio.call.dora.CommandStatus;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class f implements Runnable {
    public final WheelView a;
    public float b;
    public float c;

    public final void a() {
        float r0 = this.b;
        float r1 = 0.1f * r0;
        this.c = r1;
        if (r1 != 0.0f) goto L5;
        boolean r2 = true;
    L7:
        if (r2 == false) goto L14;
        if (r0 >= 0.0f) goto L11;
        float r3 = -1.0f;
    L12:
        this.c = r3;
        goto L14
    L11:
        r3 = 1.0f;
    L14:
        if (Math.abs(r0) > 1.0f) goto L17;
        this.a.cancelFuture();
        this.a.getWheelHandler().sendEmptyMessage(3000);
        return;
    L17:
        WheelView r4 = this.a;
        r4.setTotalScrollY(r4.getTotalScrollY() + this.c);
        if (this.a.isLoop() == true) goto L25;
        float r5 = this.a.getItemHeight();
        float r6 = (-this.a.getInitPosition()) * r5;
        float r7 = ((this.a.getItemsCount() - 1) - this.a.getInitPosition()) * r5;
        if (this.a.getTotalScrollY() > r6) goto L22;
    L23:
        WheelView r8 = this.a;
        r8.setTotalScrollY(r8.getTotalScrollY() - this.c);
        this.a.cancelFuture();
        this.a.getWheelHandler().sendEmptyMessage(3000);
        return;
    L22:
        if (this.a.getTotalScrollY() >= r7) goto L23;
    L25:
        this.a.checkLoopChange(this.c);
        this.a.getWheelHandler().sendEmptyMessage(CommandStatus.DORA_TRACE);
        this.b -= this.c;
        return;
    L5:
        r2 = false;
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

    public f(WheelView r2, float r3) {
        Intrinsics.checkNotNullParameter(r2, "wheelView");
        this.a = r2;
        this.b = r3;
    }
}
