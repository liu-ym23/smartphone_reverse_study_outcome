package org.bouncycastle.asn1.x9;

import org.bouncycastle.math.ec.ECCurve;

/* JADX INFO: loaded from: classes7.dex */
public abstract class X9ECParametersHolder {
    private ECCurve curve;
    private X9ECParameters params;

    public X9ECParametersHolder() {
    }

    public ECCurve createCurve() {
        return createParameters().getCurve();
    }

    public abstract X9ECParameters createParameters();

    public synchronized ECCurve getCurve() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.curve != null) goto L6;
        this.curve = createCurve();     // Catch: Throwable -> L9
    L6:
        ECCurve r0 = this.curve;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    public synchronized X9ECParameters getParameters() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.params != null) goto L6;
        this.params = createParameters();     // Catch: Throwable -> L9
    L6:
        X9ECParameters r0 = this.params;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }
}
