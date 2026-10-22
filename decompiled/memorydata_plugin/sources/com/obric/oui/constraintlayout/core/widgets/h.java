package com.obric.oui.constraintlayout.core.widgets;

import com.obric.oui.constraintlayout.core.widgets.analyzer.n;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes5.dex */
public class h extends ConstraintWidget implements g {
    public int aA;
    public ConstraintWidget[] az;

    public h() {
        this.az = new ConstraintWidget[4];
        this.aA = 0;
    }

    public int L(int r5) {
        int r0 = 0;
    L4:
        if (r0 >= this.aA) goto L18;
        ConstraintWidget r1 = this.az[r0];
        if (r5 != 0) goto L12;
        if (r1.ax == (-1)) goto L12;
        return r1.ax;
    L12:
        if (r5 != 1) goto L17;
        if (r1.ay == (-1)) goto L17;
        return r1.ay;
    L17:
        r0 = r0 + 1;
        goto L4
    L18:
        return -1;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.g
    public void a(ConstraintWidget r4) {
        if (r4 == this) goto L10;
        if (r4 == null) goto L11;
        int r0 = this.aA + 1;
        ConstraintWidget[] r1 = this.az;
        if (r0 <= r1.length) goto L8;
        this.az = (ConstraintWidget[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r1, r1.length * 2), ConstraintWidget[].class, "com.obric.memorydata.plugin");
    L8:
        ConstraintWidget[] r2 = this.az;
        int r3 = this.aA;
        r2[r3] = r4;
        this.aA = r3 + 1;
        return;
    L11:
        return;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.ConstraintWidget
    public void a(ConstraintWidget r6, HashMap<ConstraintWidget, ConstraintWidget> r7) {
        super.a(r6, r7);
        h r8 = (h) ZeusTransformUtils.preCheckCast(r6, h.class, "com.obric.memorydata.plugin");
        int r0 = 0;
        this.aA = 0;
        int r2 = r8.aA;
    L3:
        if (r0 >= r2) goto L5;
        a((ConstraintWidget) ZeusTransformUtils.preCheckCast(r7.get(r8.az[r0]), ConstraintWidget.class, "com.obric.memorydata.plugin"));
        r0 = r0 + 1;
        goto L3
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.g
    public void a(d r1) {
    }

    public void a(ArrayList<n> r4, int r5, n r6) {
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r1 >= this.aA) goto L7;
        r6.a(this.az[r1]);
        r1 = r1 + 1;
    L7:
        if (r0 >= this.aA) goto L9;
        com.obric.oui.constraintlayout.core.widgets.analyzer.h.a(this.az[r0], r5, r4, r6);
        r0 = r0 + 1;
        goto L7
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.g
    public void j() {
        this.aA = 0;
        Arrays.fill(this.az, null);
    }
}
