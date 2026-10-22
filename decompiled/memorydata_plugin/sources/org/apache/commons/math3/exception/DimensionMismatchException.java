package org.apache.commons.math3.exception;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.math3.exception.util.Localizable;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes6.dex */
public class DimensionMismatchException extends MathIllegalNumberException {
    private static final long serialVersionUID = -8415396756375798143L;
    private final int dimension;

    public DimensionMismatchException(int r2, int r3) {
        this(LocalizedFormats.DIMENSIONS_MISMATCH_SIMPLE, r2, r3);
    }

    public DimensionMismatchException(Localizable r4, int r5, int r6) {
        super((Localizable) ZeusTransformUtils.wrapperContextForParams(r4, Localizable.class, "com.obric.memorydata.plugin"), Integer.valueOf(r5), new Object[]{Integer.valueOf(r6)});
        this.dimension = r6;
    }

    public int getDimension() {
        return this.dimension;
    }
}
