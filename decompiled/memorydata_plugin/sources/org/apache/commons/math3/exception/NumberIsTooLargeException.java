package org.apache.commons.math3.exception;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.math3.exception.util.Localizable;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes6.dex */
public class NumberIsTooLargeException extends MathIllegalNumberException {
    private static final long serialVersionUID = 4330003017885151975L;
    private final boolean boundIsAllowed;
    private final Number max;

    public NumberIsTooLargeException(Number r2, Number r3, boolean r4) {
        if (r4 == false) goto L4;
        LocalizedFormats r0 = LocalizedFormats.NUMBER_TOO_LARGE;
    L5:
        this(r0, r2, r3, r4);
        return;
    L4:
        r0 = LocalizedFormats.NUMBER_TOO_LARGE_BOUND_EXCLUDED;
        goto L5
    }

    public NumberIsTooLargeException(Localizable r3, Number r4, Number r5, boolean r6) {
        super((Localizable) ZeusTransformUtils.wrapperContextForParams(r3, Localizable.class, "com.obric.memorydata.plugin"), r4, new Object[]{r5});
        this.max = r5;
        this.boundIsAllowed = r6;
    }

    public boolean getBoundIsAllowed() {
        return this.boundIsAllowed;
    }

    public Number getMax() {
        return this.max;
    }
}
