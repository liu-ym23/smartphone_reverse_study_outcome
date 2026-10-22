package org.apache.commons.math3.linear;

import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.util.ExceptionContext;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes6.dex */
public class NonPositiveDefiniteMatrixException extends NumberIsTooSmallException {
    private static final long serialVersionUID = 1641613838113738061L;
    private final int index;
    private final double threshold;

    public NonPositiveDefiniteMatrixException(double r4, int r6, double r7) {
        super(Double.valueOf(r4), Double.valueOf(r7), false);
        this.index = r6;
        this.threshold = r7;
        ExceptionContext r3 = getContext();
        r3.addMessage(LocalizedFormats.NOT_POSITIVE_DEFINITE_MATRIX, new Object[0]);
        r3.addMessage(LocalizedFormats.ARRAY_ELEMENT, new Object[]{Double.valueOf(r4), Integer.valueOf(r6)});
    }

    public int getColumn() {
        return this.index;
    }

    public int getRow() {
        return this.index;
    }

    public double getThreshold() {
        return this.threshold;
    }
}
