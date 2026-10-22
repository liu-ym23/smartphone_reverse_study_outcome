package org.apache.commons.math3.util;

import java.io.Serializable;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;

/* JADX INFO: loaded from: classes6.dex */
public class BigRealField implements Serializable, Field<BigReal> {
    private static final long serialVersionUID = 4756431066541037559L;

    /* JADX INFO: renamed from: org.apache.commons.math3.util.BigRealField$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class LazyHolder {
        private static final BigRealField INSTANCE = null;

        static {
            INSTANCE = new BigRealField(null);
        }

        static /* synthetic */ BigRealField access$000() {
            return INSTANCE;
        }
    }

    private BigRealField() {
    }

    /* synthetic */ BigRealField(AnonymousClass1 r1) {
        this();
    }

    public static BigRealField getInstance() {
        return LazyHolder.access$000();
    }

    private Object readResolve() {
        return LazyHolder.access$000();
    }

    @Override // org.apache.commons.math3.Field
    public /* bridge */ /* synthetic */ BigReal getOne() {
        return getOne2();
    }

    @Override // org.apache.commons.math3.Field
    /* JADX INFO: renamed from: getOne, reason: avoid collision after fix types in other method */
    public BigReal getOne2() {
        return BigReal.ONE;
    }

    @Override // org.apache.commons.math3.Field
    public Class<? extends FieldElement<BigReal>> getRuntimeClass() {
        return BigReal.class;
    }

    @Override // org.apache.commons.math3.Field
    public /* bridge */ /* synthetic */ BigReal getZero() {
        return getZero2();
    }

    @Override // org.apache.commons.math3.Field
    /* JADX INFO: renamed from: getZero, reason: avoid collision after fix types in other method */
    public BigReal getZero2() {
        return BigReal.ZERO;
    }
}
