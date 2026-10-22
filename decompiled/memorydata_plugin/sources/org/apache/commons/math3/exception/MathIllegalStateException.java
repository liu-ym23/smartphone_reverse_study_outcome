package org.apache.commons.math3.exception;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.math3.exception.util.ExceptionContext;
import org.apache.commons.math3.exception.util.Localizable;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes6.dex */
public class MathIllegalStateException extends IllegalStateException {
    private static final long serialVersionUID = -6024911025449780478L;
    private final ExceptionContext context;

    public MathIllegalStateException() {
        this(LocalizedFormats.ILLEGAL_STATE, new Object[0]);
    }

    public MathIllegalStateException(Throwable r3, Localizable r4, Object... r5) {
        Localizable r6 = (Localizable) ZeusTransformUtils.wrapperContextForParams(r4, Localizable.class, "com.obric.memorydata.plugin");
        super(r3);
        ExceptionContext r7 = new ExceptionContext(this);
        this.context = r7;
        r7.addMessage(r6, r5);
    }

    public MathIllegalStateException(Localizable r3, Object... r4) {
        Localizable r5 = (Localizable) ZeusTransformUtils.wrapperContextForParams(r3, Localizable.class, "com.obric.memorydata.plugin");
        ExceptionContext r0 = new ExceptionContext(this);
        this.context = r0;
        r0.addMessage(r5, r4);
    }

    public ExceptionContext getContext() {
        return this.context;
    }

    @Override // java.lang.Throwable
    public String getLocalizedMessage() {
        return this.context.getLocalizedMessage();
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.context.getMessage();
    }
}
