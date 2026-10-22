package com.cronutils.model.time.generator;

import com.cronutils.model.field.CronField;
import com.cronutils.model.field.expression.Between;
import com.cronutils.model.field.expression.Every;
import com.cronutils.model.field.expression.FieldExpression;
import com.cronutils.model.field.expression.On;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class g extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final int f3439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final int f3440b;

    public g(CronField r4) {
        super(r4);
        FieldExpression r0 = ((Every) ZeusTransformUtils.preCheckCast(r4.getExpression(), Every.class, "com.obric.memorydata.plugin")).getExpression();
        if (ZeusTransformUtils.instanceOf(r0, Between.class) == false) goto L7;
        Between r1 = (Between) ZeusTransformUtils.preCheckCast(r0, Between.class, "com.obric.memorydata.plugin");
        this.f3439a = Math.max(r4.getConstraints().getStartRange(), e.a(r1.getFrom()));
        int r5 = Math.min(r4.getConstraints().getEndRange(), e.a(r1.getTo()));
    L5:
        this.f3440b = r5;
        return;
    L7:
        if (ZeusTransformUtils.instanceOf(r0, On.class) == false) goto L9;
        int r2 = ((On) ZeusTransformUtils.preCheckCast(r0, On.class, "com.obric.memorydata.plugin")).getTime().getValue().intValue();
    L10:
        this.f3439a = r2;
        r5 = r4.getConstraints().getEndRange();
        goto L5
    L9:
        r2 = r4.getConstraints().getStartRange();
        goto L10
    }

    private int a(int r1, Every r2) {
        int r0 = a();
        if (r1 < r0) goto L6;
        int r3 = r2.getPeriod().getValue().intValue();
        return r1 + (r3 - ((r1 - r0) % r3));
    L6:
        return r0;
    }

    int a() {
        FieldExpression r0 = ((Every) ZeusTransformUtils.preCheckCast(this.c.getExpression(), Every.class, "com.obric.memorydata.plugin")).getExpression();
        if (ZeusTransformUtils.instanceOf(r0, On.class) == false) goto L7;
        return ((On) ZeusTransformUtils.preCheckCast(r0, On.class, "com.obric.memorydata.plugin")).getTime().getValue().intValue();
    L7:
        return this.f3439a;
    }

    @Override // com.cronutils.model.time.generator.h
    public int a(int r4) {
        if (r4 >= this.f3440b) goto L13;
        int r5 = a(r4, (Every) ZeusTransformUtils.preCheckCast(this.c.getExpression(), Every.class, "com.obric.memorydata.plugin"));
        int r0 = this.f3439a;
        if (r5 >= r0) goto L8;
        return r0;
    L8:
        if (r5 > this.f3440b) goto L11;
        return r5;
    L11:
        throw new NoSuchValueException();
    L13:
        throw new NoSuchValueException();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x001c -> B:7:0x0011). Please report as a decompilation issue!!! */
    @Override // com.cronutils.model.time.generator.h
    public List<Integer> a(int r4, int r5) {
        ArrayList r0 = new ArrayList();
        int r1 = a();     // Catch: NoSuchValueException -> L14
        if (r4 >= r1) goto L8;
        if (r1 >= r5) goto L8;
        Integer r2 = Integer.valueOf(r1);     // Catch: NoSuchValueException -> L14
    L7:
        r0.add(r2);     // Catch: NoSuchValueException -> L14
    L8:
        r4 = a(r4);     // Catch: NoSuchValueException -> L14
        if (r4 >= r5) goto L13;
        if (r4 == r1) goto L8;
        r2 = Integer.valueOf(r4);     // Catch: NoSuchValueException -> L14
    L13:
        return r0;
    }

    @Override // com.cronutils.model.time.generator.h
    public boolean a(FieldExpression r1) {
        return ZeusTransformUtils.instanceOf(r1, Every.class);
    }

    @Override // com.cronutils.model.time.generator.h
    public boolean b(int r4) {
        Every r0 = (Every) ZeusTransformUtils.preCheckCast(this.c.getExpression(), Every.class, "com.obric.memorydata.plugin");
        int r1 = a();
        if (r4 >= r1) goto L5;
    L11:
        return false;
    L5:
        if (((r4 - r1) % r0.getPeriod().getValue().intValue()) != 0) goto L11;
        if (r4 < this.f3439a) goto L11;
        if (r4 > this.f3440b) goto L11;
        return true;
    }
}
