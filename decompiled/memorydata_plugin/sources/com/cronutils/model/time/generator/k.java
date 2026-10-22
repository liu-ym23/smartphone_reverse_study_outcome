package com.cronutils.model.time.generator;

import com.cronutils.model.field.CronField;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
abstract class k extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f3441a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected int f3442b;

    k(CronField r1, int r2, int r3) {
        super(r1);
        this.f3441a = r2;
        this.f3442b = r3;
    }

    @Override // com.cronutils.model.time.generator.h
    public List<Integer> a(int r3, int r4) {
        ArrayList r0 = new ArrayList();
    L9:
        r3 = a(r3);     // Catch: NoSuchValueException -> L8
        if (r3 >= r4) goto L7;
        r0.add(Integer.valueOf(r3));     // Catch: NoSuchValueException -> L8
    L7:
        return r0;
    }
}
