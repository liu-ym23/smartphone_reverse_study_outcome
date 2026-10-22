package org.bouncycastle.tsp;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;

/* JADX INFO: loaded from: classes7.dex */
public class TSPIOException extends IOException {
    Throwable underlyingException;

    public TSPIOException(String r1) {
        super(r1);
    }

    public TSPIOException(String r1, Throwable r2) {
        super(r1);
        this.underlyingException = r2;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.underlyingException;
    }

    public Exception getUnderlyingException() {
        return (Exception) ZeusTransformUtils.preCheckCast(this.underlyingException, Exception.class, "com.obric.memorydata.plugin");
    }
}
