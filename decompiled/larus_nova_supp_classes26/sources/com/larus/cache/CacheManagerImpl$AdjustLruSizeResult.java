package com.larus.cache;

import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/larus/cache/CacheManagerImpl$AdjustLruSizeResult;", "Ljava/io/Serializable;", "<init>", "()V", "maxSize", "", "getMaxSize", "()J", "setMaxSize", "(J)V", "cachedFilesSize", "getCachedFilesSize", "setCachedFilesSize", "Companion", "utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CacheManagerImpl$AdjustLruSizeResult implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = -2890256138506813976L;
    private long cachedFilesSize;
    private long maxSize;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public CacheManagerImpl$AdjustLruSizeResult() {
    }

    public final long getCachedFilesSize() {
        return this.cachedFilesSize;
    }

    public final long getMaxSize() {
        return this.maxSize;
    }

    public final void setCachedFilesSize(long r1) {
        this.cachedFilesSize = r1;
    }

    public final void setMaxSize(long r1) {
        this.maxSize = r1;
    }
}
