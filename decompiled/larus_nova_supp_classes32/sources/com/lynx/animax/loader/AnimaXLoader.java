package com.lynx.animax.loader;

import u4a.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class AnimaXLoader {
    public final k a;

    public AnimaXLoader(k r1) {
        this.a = r1;
    }

    public static AnimaXLoader create(k r1) {
        return new AnimaXLoader(r1);
    }

    public void load(AnimaXLoaderRequest r2, AnimaXLoaderCompletionHandler r3) {
        this.a.a(r2, r3);
    }
}
