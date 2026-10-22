package org.apache.commons.math3.fraction;

import java.io.Serializable;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;

/* JADX INFO: loaded from: classes6.dex */
public class FractionField implements Serializable, Field<Fraction> {
    private static final long serialVersionUID = -1257768487499119313L;

    /* JADX INFO: renamed from: org.apache.commons.math3.fraction.FractionField$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class LazyHolder {
        private static final FractionField INSTANCE = null;

        static {
            INSTANCE = new FractionField(null);
        }

        static /* synthetic */ FractionField access$000() {
            return INSTANCE;
        }
    }

    private FractionField() {
    }

    /* synthetic */ FractionField(AnonymousClass1 r1) {
        this();
    }

    public static FractionField getInstance() {
        return LazyHolder.access$000();
    }

    private Object readResolve() {
        return LazyHolder.access$000();
    }

    @Override // org.apache.commons.math3.Field
    public /* bridge */ /* synthetic */ Fraction getOne() {
        return getOne2();
    }

    @Override // org.apache.commons.math3.Field
    /* JADX INFO: renamed from: getOne, reason: avoid collision after fix types in other method */
    public Fraction getOne2() {
        return Fraction.ONE;
    }

    @Override // org.apache.commons.math3.Field
    public Class<? extends FieldElement<Fraction>> getRuntimeClass() {
        return Fraction.class;
    }

    @Override // org.apache.commons.math3.Field
    public /* bridge */ /* synthetic */ Fraction getZero() {
        return getZero2();
    }

    @Override // org.apache.commons.math3.Field
    /* JADX INFO: renamed from: getZero, reason: avoid collision after fix types in other method */
    public Fraction getZero2() {
        return Fraction.ZERO;
    }
}
