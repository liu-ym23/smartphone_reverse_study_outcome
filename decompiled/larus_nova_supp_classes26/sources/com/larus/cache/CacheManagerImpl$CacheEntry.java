package com.larus.cache;

import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/larus/cache/CacheManagerImpl$CacheEntry;", "Ljava/io/Serializable;", "json", "", "expireDate", "", "<init>", "(Ljava/lang/String;J)V", "getJson", "()Ljava/lang/String;", "getExpireDate", "()J", "Companion", "utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CacheManagerImpl$CacheEntry implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = -5682307075359201485L;
    private final long expireDate;
    private final String json;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final long getExpireDate() {
        return this.expireDate;
    }

    public final String getJson() {
        return this.json;
    }

    public CacheManagerImpl$CacheEntry(String r1, long r2) {
        this.json = r1;
        this.expireDate = r2;
    }
}
