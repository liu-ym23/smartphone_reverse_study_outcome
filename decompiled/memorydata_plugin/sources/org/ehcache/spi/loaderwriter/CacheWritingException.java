package org.ehcache.spi.loaderwriter;

/* JADX INFO: loaded from: classes7.dex */
public class CacheWritingException extends RuntimeException {
    private static final long serialVersionUID = -3547750364991417531L;

    public CacheWritingException() {
    }

    public CacheWritingException(String r1) {
        super(r1);
    }

    public CacheWritingException(String r1, Throwable r2) {
        super(r1, r2);
    }

    public CacheWritingException(Throwable r1) {
        super(r1);
    }
}
