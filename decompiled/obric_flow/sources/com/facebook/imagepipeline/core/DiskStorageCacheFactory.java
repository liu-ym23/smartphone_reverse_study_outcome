package com.facebook.imagepipeline.core;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.cache.disk.DiskStorageCache;
import com.facebook.cache.disk.DynamicDefaultDiskStorage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes2.dex */
public class DiskStorageCacheFactory {
    public DiskStorageCacheFactory(DynamicDefaultDiskStorageFactory r5) {
    }

    public final DiskStorageCache a(DiskCacheConfig r15) {
        DynamicDefaultDiskStorage r14 = new DynamicDefaultDiskStorage(r15.f7604a, r15.f7606c, r15.f7605b, r15.f7611l, r15.f7610k, r15.f7607h);
        ExecutorService r10 = Executors.newSingleThreadExecutor();
        DiskStorageCache.Params r5 = new DiskStorageCache.Params(r15.f, r15.e, r15.d);
        return new DiskStorageCache(r14, r15.g, r5, r15.f7608i, r15.f7607h, r10);
    }
}
