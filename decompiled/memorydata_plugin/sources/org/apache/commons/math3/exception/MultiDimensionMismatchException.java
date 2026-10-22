package org.apache.commons.math3.exception;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.math3.exception.util.Localizable;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes6.dex */
public class MultiDimensionMismatchException extends MathIllegalArgumentException {
    private static final long serialVersionUID = -8415396756375798143L;
    private final Integer[] expected;
    private final Integer[] wrong;

    public MultiDimensionMismatchException(Localizable r4, Integer[] r5, Integer[] r6) {
        super((Localizable) ZeusTransformUtils.wrapperContextForParams(r4, Localizable.class, "com.obric.memorydata.plugin"), new Object[]{r5, r6});
        this.wrong = (Integer[]) ZeusTransformUtils.preCheckCast(r5.clone(), Integer[].class, "com.obric.memorydata.plugin");
        this.expected = (Integer[]) ZeusTransformUtils.preCheckCast(r6.clone(), Integer[].class, "com.obric.memorydata.plugin");
    }

    public MultiDimensionMismatchException(Integer[] r2, Integer[] r3) {
        this(LocalizedFormats.DIMENSIONS_MISMATCH, r2, r3);
    }

    public int getExpectedDimension(int r1) {
        return this.expected[r1].intValue();
    }

    public Integer[] getExpectedDimensions() {
        return (Integer[]) ZeusTransformUtils.preCheckCast(this.expected.clone(), Integer[].class, "com.obric.memorydata.plugin");
    }

    public int getWrongDimension(int r1) {
        return this.wrong[r1].intValue();
    }

    public Integer[] getWrongDimensions() {
        return (Integer[]) ZeusTransformUtils.preCheckCast(this.wrong.clone(), Integer[].class, "com.obric.memorydata.plugin");
    }
}
