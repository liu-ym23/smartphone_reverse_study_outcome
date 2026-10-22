package com.google.crypto.tink.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class TinkBugException extends RuntimeException {

    public interface a {
        void a();
    }

    public interface b<T> {
        T a();
    }

    public TinkBugException(String r1) {
        super(r1);
    }

    public TinkBugException(String r1, Throwable r2) {
        super(r1, r2);
    }

    public TinkBugException(Throwable r1) {
        super(r1);
    }

    public static <T> T exceptionIsBug(b<T> r2) {
        return (T) ((b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.memorydata.plugin")).a();
    L5:
        e = move-exception;
        throw new TinkBugException(e);
    }

    public static void exceptionIsBug(a r2) {
        ((a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin")).a();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        throw new TinkBugException(e);
    }
}
