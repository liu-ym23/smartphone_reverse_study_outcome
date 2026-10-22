package org.apache.commons.math3.exception;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.math3.exception.util.Localizable;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes6.dex */
public class InsufficientDataException extends MathIllegalArgumentException {
    private static final long serialVersionUID = -2629324471511903359L;

    public InsufficientDataException() {
        this(LocalizedFormats.INSUFFICIENT_DATA, new Object[0]);
    }

    public InsufficientDataException(Localizable r3, Object... r4) {
        super((Localizable) ZeusTransformUtils.wrapperContextForParams(r3, Localizable.class, "com.obric.memorydata.plugin"), r4);
    }
}
