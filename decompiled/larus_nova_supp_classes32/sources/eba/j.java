package eba;

import android.view.SurfaceControl;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.activation.presentation.runtime.surface.ObricRootSurfaceEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class j implements hba.f {
    public final /* synthetic */ i a;

    public final void onRootSurfaceDestroyed() {
        this.a.a();
    }

    public j(i r1) {
        this.a = r1;
    }

    public final void onRootSurfaceUnavailable(String r4) {
        Intrinsics.checkNotNullParameter(r4, "reason");
        FLogger.a.w("ObricListeningChildWindow", "unavailable: side=child stage=surface reason=" + r4);
        this.a.f(null);
    }

    public final void onRootSurfaceAvailable(SurfaceControl r6, ObricRootSurfaceEvent r7, SurfaceControl.Transaction r8) {
        Intrinsics.checkNotNullParameter(r6, "surface");
        Intrinsics.checkNotNullParameter(r7, "event");
        i r0 = this.a;
        int r1 = r0.y;
        int r2 = r0.A;
        Intrinsics.checkNotNullParameter(r7, "event");
        ObricRootSurfaceEvent r9 = ObricRootSurfaceEvent.REPLACED;
        boolean r3 = true;
        if (r7 != r9) goto L7;
        if (r1 <= 0) goto L7;
        if (r2 != r1) goto L7;
        boolean r4 = true;
    L8:
        if (r7 != r9) goto L10;
    L11:
        i r10 = this.a;
        int r5 = r10.y;
        if (r5 != Integer.MAX_VALUE) goto L14;
        int r11 = 1;
    L15:
        r10.y = r11;
    L16:
        i r12 = this.a;
        r12.x = r6;
        if (r12.A == r12.y) goto L19;
        r12.i(false, "child_surface_generation_changed");
    L19:
        if (r4 == false) goto L21;
    L22:
        i r13 = this.a;
        r13.B = r13.y;
    L23:
        this.a.C = false;
        FLogger r14 = FLogger.a;
        StringBuilder r15 = new StringBuilder("publish: side=child stage=surface generation=");
        r15.append(this.a.y);
        r15.append(" source=");
        r15.append(r7);
        r15.append(" display=");
        r15.append(this.a.t);
        r15.append(" type=");
        r15.append(this.a.s);
        r15.append(" wait=");
        i r16 = this.a;
        if (r16.B == r16.y) goto L27;
        r3 = false;
    L27:
        r15.append(r3);
        r14.i("ObricListeningChildWindow", r15.toString());
        i r17 = this.a;
        r17.d.invoke(r6, Integer.valueOf(r17.y), Integer.valueOf(this.a.t), Integer.valueOf(this.a.s));
        return;
    L21:
        if (this.a.C == false) goto L23;
    L14:
        r11 = r5 + 1;
        goto L15
    L10:
        if (this.a.x == r6) goto L16;
    L7:
        r4 = false;
        goto L8
    }
}
