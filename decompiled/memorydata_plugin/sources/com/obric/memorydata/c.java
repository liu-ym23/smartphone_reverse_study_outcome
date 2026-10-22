package com.obric.memorydata;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.manager.j;
import com.bumptech.glide.manager.o;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public class c extends com.bumptech.glide.i {
    public c(com.bumptech.glide.c r3, j r4, o r5, Context r6) {
        super(r3, (j) ZeusTransformUtils.wrapperContextForParams(r4, j.class, "com.obric.memorydata.plugin"), (o) ZeusTransformUtils.wrapperContextForParams(r5, o.class, "com.obric.memorydata.plugin"), (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.bumptech.glide.i
    public /* synthetic */ com.bumptech.glide.h a(Class r1) {
        return c(r1);
    }

    @Override // com.bumptech.glide.i
    public void a(com.bumptech.glide.request.f r2) {
        if (ZeusTransformUtils.instanceOf(r2, a.class) == true) goto L6;
        r2 = new a().a(r2);
    L6:
        super.a(r2);
    }

    public <ResourceType> b<ResourceType> c(Class<ResourceType> r4) {
        return new b(this.f561a, this, r4, this.f562b);
    }

    @Override // com.bumptech.glide.i
    public /* synthetic */ com.bumptech.glide.h h() {
        return k();
    }

    public b<Bitmap> k() {
        return (b) ZeusTransformUtils.preCheckCast(super.h(), b.class, "com.obric.memorydata.plugin");
    }
}
