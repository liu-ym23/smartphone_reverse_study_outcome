package org.apache.commons.math3.exception;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.math3.exception.util.Localizable;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes6.dex */
public class OutOfRangeException extends MathIllegalNumberException {
    private static final long serialVersionUID = 111601815794403609L;
    private final Number hi;
    private final Number lo;

    public OutOfRangeException(Number r2, Number r3, Number r4) {
        this(LocalizedFormats.OUT_OF_RANGE_SIMPLE, r2, r3, r4);
    }

    public OutOfRangeException(Localizable r3, Number r4, Number r5, Number r6) {
        super((Localizable) ZeusTransformUtils.wrapperContextForParams(r3, Localizable.class, "com.obric.memorydata.plugin"), r4, new Object[]{r5, r6});
        this.lo = r5;
        this.hi = r6;
    }

    public Number getHi() {
        return this.hi;
    }

    public Number getLo() {
        return this.lo;
    }
}
