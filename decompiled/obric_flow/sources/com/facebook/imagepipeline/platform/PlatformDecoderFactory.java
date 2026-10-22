package com.facebook.imagepipeline.platform;

import androidx.core.util.Pools;
import com.facebook.imagepipeline.memory.PoolFactory;

/* JADX INFO: loaded from: classes2.dex */
public abstract class PlatformDecoderFactory {
    public static PlatformDecoder a(PoolFactory r5) {
        int r10 = r5.f8242a.f8238c.d;
        return new OreoDecoder(r5.a(), r10, new Pools.SynchronizedPool(r10));
    }
}
