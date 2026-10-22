package org.apache.commons.math3.exception;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.math3.exception.util.Localizable;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes6.dex */
public class ConvergenceException extends MathIllegalStateException {
    private static final long serialVersionUID = 4330003017885151975L;

    public ConvergenceException() {
        this(LocalizedFormats.CONVERGENCE_FAILED, new Object[0]);
    }

    public ConvergenceException(Localizable r3, Object... r4) {
        Localizable r5 = (Localizable) ZeusTransformUtils.wrapperContextForParams(r3, Localizable.class, "com.obric.memorydata.plugin");
        getContext().addMessage(r5, r4);
    }
}
