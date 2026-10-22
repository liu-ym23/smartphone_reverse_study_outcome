package org.apache.commons.math3.fraction;

import org.apache.commons.math3.exception.ConvergenceException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes6.dex */
public class FractionConversionException extends ConvergenceException {
    private static final long serialVersionUID = -4661812640132576263L;

    public FractionConversionException(double r3, int r5) {
        super(LocalizedFormats.FAILED_FRACTION_CONVERSION, new Object[]{Double.valueOf(r3), Integer.valueOf(r5)});
    }

    public FractionConversionException(double r3, long r5, long r7) {
        super(LocalizedFormats.FRACTION_CONVERSION_OVERFLOW, new Object[]{Double.valueOf(r3), Long.valueOf(r5), Long.valueOf(r7)});
    }
}
