package org.apache.commons.math3.complex;

import java.io.Serializable;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;

/* JADX INFO: loaded from: classes6.dex */
public class ComplexField implements Serializable, Field<Complex> {
    private static final long serialVersionUID = -6130362688700788798L;

    /* JADX INFO: renamed from: org.apache.commons.math3.complex.ComplexField$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class LazyHolder {
        private static final ComplexField INSTANCE = null;

        static {
            INSTANCE = new ComplexField(null);
        }

        static /* synthetic */ ComplexField access$000() {
            return INSTANCE;
        }
    }

    private ComplexField() {
    }

    /* synthetic */ ComplexField(AnonymousClass1 r1) {
        this();
    }

    public static ComplexField getInstance() {
        return LazyHolder.access$000();
    }

    private Object readResolve() {
        return LazyHolder.access$000();
    }

    @Override // org.apache.commons.math3.Field
    public /* bridge */ /* synthetic */ Complex getOne() {
        return getOne2();
    }

    @Override // org.apache.commons.math3.Field
    /* JADX INFO: renamed from: getOne, reason: avoid collision after fix types in other method */
    public Complex getOne2() {
        return Complex.ONE;
    }

    @Override // org.apache.commons.math3.Field
    public Class<? extends FieldElement<Complex>> getRuntimeClass() {
        return Complex.class;
    }

    @Override // org.apache.commons.math3.Field
    public /* bridge */ /* synthetic */ Complex getZero() {
        return getZero2();
    }

    @Override // org.apache.commons.math3.Field
    /* JADX INFO: renamed from: getZero, reason: avoid collision after fix types in other method */
    public Complex getZero2() {
        return Complex.ZERO;
    }
}
