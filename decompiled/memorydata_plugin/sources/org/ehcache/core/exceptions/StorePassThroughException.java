package org.ehcache.core.exceptions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.ehcache.spi.resilience.StoreAccessException;

/* JADX INFO: loaded from: classes7.dex */
public class StorePassThroughException extends RuntimeException {
    private static final long serialVersionUID = -2018452326214235671L;

    public StorePassThroughException(String r1, Throwable r2) {
        super(r1, r2);
    }

    public StorePassThroughException(Throwable r1) {
        super(r1);
    }

    public static StoreAccessException handleException(Exception r2) {
        if (ZeusTransformUtils.instanceOf(r2, StorePassThroughException.class) == false) goto L11;
        Throwable r3 = r2.getCause();
        if (ZeusTransformUtils.instanceOf(r3, RuntimeException.class) == true) goto L9;
        return new StoreAccessException(r3);
    L9:
        throw ((RuntimeException) ZeusTransformUtils.preCheckCast(r3, RuntimeException.class, "com.obric.memorydata.plugin"));
    L11:
        return new StoreAccessException(r2);
    }

    @Override // java.lang.Throwable
    public synchronized Throwable fillInStackTrace() {
        monitor-enter(this);
        monitor-exit(this);
        return this;
    }
}
