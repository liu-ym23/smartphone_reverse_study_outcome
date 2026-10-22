package com.cronutils.model.time.generator;

import com.cronutils.model.field.CronField;
import com.cronutils.model.field.expression.FieldExpression;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h {
    protected CronField c;

    public h(CronField r4) {
        this.c = (CronField) ZeusTransformUtils.preCheckCast(com.cronutils.utils.a.a(r4, "CronField must not be null"), CronField.class, "com.obric.memorydata.plugin");
        com.cronutils.utils.a.a(a(r4.getExpression()), "FieldExpression does not match required class");
    }

    public abstract int a(int r1);

    public abstract List<Integer> a(int r1, int r2);

    public abstract boolean a(FieldExpression r1);

    public final List<Integer> b(int r3, int r4) {
        List<Integer> r0 = a(r3, r4);
        if (b(r3) == false) goto L6;
        r0.add(Integer.valueOf(r3));
    L6:
        if (b(r4) == false) goto L8;
        r0.add(Integer.valueOf(r4));
    L8:
        LinkedList r2 = new LinkedList(new HashSet(r0));
        Collections.sort(r2);
        return r2;
    }

    public abstract boolean b(int r1);
}
