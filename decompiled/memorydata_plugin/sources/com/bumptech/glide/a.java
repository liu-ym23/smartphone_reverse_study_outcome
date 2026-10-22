package com.bumptech.glide;

import android.content.Context;
import com.bumptech.glide.manager.n;
import com.bumptech.glide.manager.o;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
final class a implements n.a {
    a() {
    }

    @Override // com.bumptech.glide.manager.n.a
    public i a(c r2, com.bumptech.glide.manager.j r3, o r4, Context r5) {
        return new com.obric.memorydata.c(r2, (com.bumptech.glide.manager.j) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.manager.j.class, "com.obric.memorydata.plugin"), (o) ZeusTransformUtils.wrapperContextForParams(r4, o.class, "com.obric.memorydata.plugin"), (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin"));
    }
}
