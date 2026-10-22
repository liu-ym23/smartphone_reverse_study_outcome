package com.bytedance.android.livesdk.chatroom.ui;

import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class z3 implements com.bytedance.android.live.core.tetris.componentx.schedule.q {
    public final /* synthetic */ AbsInteractionFragment a;

    public final void i() {
        ALogger.i("AbsInteractionFragment", "endAllComponentLoad");
    }

    public z3(AbsInteractionFragment r1) {
        this.a = r1;
    }

    public final void d(f70.b r4, String r5) {
        if (r4 != null) goto L4;
        r4 = mg2.e.c;
    L4:
        ALogger.i("AbsInteractionFragment", "layerType = " + r4.a + "  batchKey = " + r5);
        String r0 = r4.a;
        f70.b r1 = mg2.e.c;
        if (TextUtils.equals(r0, r1.a) == false) goto L13;
        if (TextUtils.equals(r5, "0") == false) goto L13;
        AbsInteractionFragment r6 = this.a;
        List<String> r7 = AbsInteractionFragment.u4;
        if (r6.Ha0().booleanValue() == true) goto L11;
        AbsInteractionFragment r8 = this.a;
        r8.pr(r8.q);
    L11:
        AbsInteractionFragment r9 = this.a;
        r9.qx(r9.q, r9.Ha0().booleanValue());
        return;
    L13:
        if (TextUtils.equals(r4.a, r1.a) == false) goto L18;
        if (TextUtils.equals(r5, "1") == false) goto L18;
        AbsInteractionFragment r10 = this.a;
        r10.uF(r10.q);
        return;
    L18:
        if (TextUtils.equals(r4.a, r1.a) == false) goto L23;
        if (TextUtils.equals(r5, "2") == false) goto L23;
        AbsInteractionFragment r11 = this.a;
        r11.mf(r11.q);
        return;
    L23:
        if (TextUtils.equals(r4.a, r1.a) == true) goto L25;
        return;
    L25:
        if (TextUtils.equals(r5, "3") == false) goto L32;
        AbsInteractionFragment r12 = this.a;
        r12.bL(r12.q);
        return;
    }

    public final void l(f70.b r4, String r5) {
        if (r4 != null) goto L4;
        r4 = mg2.e.c;
    L4:
        ALogger.i("AbsInteractionFragment", "layerType = " + r4.a + "  batchKey = " + r5);
        String r0 = r4.a;
        f70.b r1 = mg2.e.c;
        if (TextUtils.equals(r0, r1.a) == false) goto L18;
        if (TextUtils.equals(r5, "0") == false) goto L18;
        AbsInteractionFragment r6 = this.a;
        r6.Ja0(r6.q);
        AbsInteractionFragment r7 = this.a;
        r7.M3 = true;
        if (r7.Ha0().booleanValue() == true) goto L11;
        AbsInteractionFragment r8 = this.a;
        r8.CM(r8.q);
        return;
    L11:
        AbsInteractionFragment r9 = this.a;
        if (r9.N3 == true) goto L14;
        return;
    L14:
        if (r9.M3 == false) goto L40;
        r9.XZ(r9.q);
        r9.CM(r9.q);
        return;
    L40:
        return;
    L18:
        if (TextUtils.equals(r4.a, r1.a) == false) goto L23;
        if (TextUtils.equals(r5, "1") == false) goto L23;
        this.a.Ka0();
        return;
    L23:
        if (TextUtils.equals(r4.a, r1.a) == false) goto L28;
        if (TextUtils.equals(r5, "2") == false) goto L28;
        this.a.La0();
        return;
    L28:
        if (TextUtils.equals(r4.a, r1.a) == true) goto L30;
        return;
    L30:
        if (TextUtils.equals(r5, "3") == false) goto L39;
        this.a.Ia0();
        return;
    }
}
