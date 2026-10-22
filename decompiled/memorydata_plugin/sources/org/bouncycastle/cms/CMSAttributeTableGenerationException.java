package org.bouncycastle.cms;

/* JADX INFO: loaded from: classes7.dex */
public class CMSAttributeTableGenerationException extends CMSRuntimeException {
    Exception e;

    public CMSAttributeTableGenerationException(String r1) {
        super(r1);
    }

    public CMSAttributeTableGenerationException(String r1, Exception r2) {
        super(r1);
        this.e = r2;
    }

    @Override // org.bouncycastle.cms.CMSRuntimeException, java.lang.Throwable
    public Throwable getCause() {
        return this.e;
    }

    @Override // org.bouncycastle.cms.CMSRuntimeException
    public Exception getUnderlyingException() {
        return this.e;
    }
}
