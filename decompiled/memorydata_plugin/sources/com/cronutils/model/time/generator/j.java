package com.cronutils.model.time.generator;

import com.cronutils.model.field.CronField;
import com.cronutils.model.field.expression.FieldExpression;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class j extends h {
    public j(CronField r1) {
        super(r1);
    }

    @Override // com.cronutils.model.time.generator.h
    public int a(int r1) {
        throw new NoSuchValueException();
    }

    @Override // com.cronutils.model.time.generator.h
    public List<Integer> a(int r1, int r2) {
        return new ArrayList();
    }

    @Override // com.cronutils.model.time.generator.h
    public boolean a(FieldExpression r1) {
        return true;
    }

    @Override // com.cronutils.model.time.generator.h
    public boolean b(int r1) {
        return false;
    }
}
