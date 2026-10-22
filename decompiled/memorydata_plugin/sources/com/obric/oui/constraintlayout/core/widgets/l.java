package com.obric.oui.constraintlayout.core.widgets;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public class l extends ConstraintWidget {
    public ArrayList<ConstraintWidget> aV;

    public l() {
        this.aV = new ArrayList();
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.ConstraintWidget
    public void a(com.obric.oui.constraintlayout.core.c r6) {
        super.a(r6);
        int r0 = this.aV.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        ((ConstraintWidget) ZeusTransformUtils.preCheckCast(this.aV.get(r1), ConstraintWidget.class, "com.obric.memorydata.plugin")).a(r6);
        r1 = r1 + 1;
        goto L3
    }

    public void ah() {
        ArrayList<ConstraintWidget> r1 = this.aV;
        if (r1 != null) goto L5;
        return;
    L5:
        int r2 = r1.size();
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L11;
        ConstraintWidget r4 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(this.aV.get(r3), ConstraintWidget.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, l.class) == false) goto L10;
        ((l) ZeusTransformUtils.preCheckCast(r4, l.class, "com.obric.memorydata.plugin")).ah();
    L10:
        r3 = r3 + 1;
        goto L6
    }

    public ArrayList<ConstraintWidget> ak() {
        return this.aV;
    }

    public void al() {
        this.aV.clear();
    }

    public void b(ConstraintWidget r4) {
        this.aV.add(r4);
        if (r4.A() == null) goto L5;
        ((l) ZeusTransformUtils.preCheckCast(r4.A(), l.class, "com.obric.memorydata.plugin")).c(r4);
    L5:
        r4.a_(this);
    }

    public void c(ConstraintWidget r1) {
        this.aV.remove(r1);
        r1.w();
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.ConstraintWidget
    public void w() {
        this.aV.clear();
        super.w();
    }
}
