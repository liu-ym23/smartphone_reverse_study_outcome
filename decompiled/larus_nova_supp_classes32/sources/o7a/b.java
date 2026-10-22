package o7a;

import android.view.Choreographer;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.utils.DeviceUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b implements Choreographer.FrameCallback {
    public final /* synthetic */ com.lynx.tasm.fluency.b a;

    public b(com.lynx.tasm.fluency.b r1) {
        this.a = r1;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long r9) {
        com.lynx.tasm.fluency.b r0 = this.a;
        if (r0.f != (-1)) goto L5;
        r0.f = r9;
    L5:
        r0.h++;
        if (r0.b == false) goto L8;
        Choreographer.getInstance().postFrameCallback(this);
    L8:
        com.lynx.tasm.fluency.b r1 = this.a;
        long r2 = r1.g;
        if (r2 <= 0) goto L34;
        double r3 = (r9 - r2) / 1000000.0d;
        if (((long) r3) <= 0) goto L34;
        if (r1.k != (-1)) goto L31;
        LynxContext r4 = r1.a.get();
        if (r4 == null) goto L28;
        float r5 = DeviceUtils.c(r4.getContext());
        if (Math.abs(r5 - 60.0f) < 5.1f) goto L28;
        if (Math.abs(r5 - 90.0f) >= 5.1f) goto L25;
        int r6 = 90;
    L29:
        r1.k = r6;
        goto L31
    L25:
        if (Math.abs(r5 - 120.0f) >= 5.1f) goto L27;
        r6 = 120;
        goto L29
    L27:
        r6 = (int) r5;
    L28:
        r6 = 60;
    L31:
        if (r1.e.size() <= 20000) goto L33;
        r1.e.poll();
    L33:
        r1.e.add(Long.valueOf((long) (r3 * 100.0d)));
    L34:
        this.a.g = r9;
    }
}
