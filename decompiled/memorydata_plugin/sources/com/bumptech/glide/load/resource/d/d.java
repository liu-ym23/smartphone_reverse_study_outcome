package com.bumptech.glide.load.resource.d;

import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class d implements e<GifDrawable, byte[]> {
    public d() {
    }

    @Override // com.bumptech.glide.load.resource.d.e
    public s<byte[]> a(s<GifDrawable> r1, com.bumptech.glide.load.e r2) {
        return new com.bumptech.glide.load.resource.a.b(com.bumptech.glide.util.a.a(((GifDrawable) ZeusTransformUtils.preCheckCast(((s) ZeusTransformUtils.wrapperContextForParams(r1, s.class, "com.obric.memorydata.plugin")).d(), GifDrawable.class, "com.obric.memorydata.plugin")).getBuffer()));
    }
}
