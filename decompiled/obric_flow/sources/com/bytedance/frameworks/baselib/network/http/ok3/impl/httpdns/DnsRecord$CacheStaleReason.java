package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns;

/* JADX INFO: loaded from: classes2.dex */
public final enum DnsRecord$CacheStaleReason extends Enum<DnsRecord$CacheStaleReason> {
    public static final DnsRecord$CacheStaleReason CACHE_STALE_BOTH = null;
    public static final DnsRecord$CacheStaleReason CACHE_STALE_EXPIRED = null;
    public static final DnsRecord$CacheStaleReason CACHE_STALE_NETCHANGED = null;
    public static final DnsRecord$CacheStaleReason CACHE_UNSET = null;
    public static final DnsRecord$CacheStaleReason CACHE_VALID = null;
    public static final DnsRecord$CacheStaleReason PRELOAD_BATCH = null;
    public static final DnsRecord$CacheStaleReason REFRESH_BATCH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DnsRecord$CacheStaleReason[] f4684a = null;

    static {
        DnsRecord$CacheStaleReason r5 = new DnsRecord$CacheStaleReason("CACHE_UNSET", 0);
        CACHE_UNSET = r5;
        DnsRecord$CacheStaleReason r10 = new DnsRecord$CacheStaleReason("CACHE_VALID", 1);
        CACHE_VALID = r10;
        DnsRecord$CacheStaleReason r11 = new DnsRecord$CacheStaleReason("CACHE_STALE_BOTH", 2);
        CACHE_STALE_BOTH = r11;
        DnsRecord$CacheStaleReason r12 = new DnsRecord$CacheStaleReason("CACHE_STALE_NETCHANGED", 3);
        CACHE_STALE_NETCHANGED = r12;
        DnsRecord$CacheStaleReason r13 = new DnsRecord$CacheStaleReason("CACHE_STALE_EXPIRED", 4);
        CACHE_STALE_EXPIRED = r13;
        DnsRecord$CacheStaleReason r14 = new DnsRecord$CacheStaleReason("PRELOAD_BATCH", 5);
        PRELOAD_BATCH = r14;
        DnsRecord$CacheStaleReason r15 = new DnsRecord$CacheStaleReason("REFRESH_BATCH", 6);
        REFRESH_BATCH = r15;
        f4684a = new DnsRecord$CacheStaleReason[]{r5, r10, r11, r12, r13, r14, r15};
    }

    public static DnsRecord$CacheStaleReason valueOf(String r5) {
        return (DnsRecord$CacheStaleReason) Enum.valueOf(DnsRecord$CacheStaleReason.class, r5);
    }

    public static DnsRecord$CacheStaleReason[] values() {
        return (DnsRecord$CacheStaleReason[]) f4684a.clone();
    }
}
