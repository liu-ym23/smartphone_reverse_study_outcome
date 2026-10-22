package com.bumptech.glide.load.engine;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
class d<DataType> implements com.bumptech.glide.load.engine.a.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.a<DataType> f773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DataType f774b;
    private final com.bumptech.glide.load.e c;

    d(com.bumptech.glide.load.a<DataType> r3, DataType r4, com.bumptech.glide.load.e r5) {
        this.f773a = (com.bumptech.glide.load.a) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.a.class, "com.obric.memorydata.plugin");
        this.f774b = r4;
        this.c = r5;
    }

    @Override // com.bumptech.glide.load.engine.a.a.b
    public boolean a(File r3) {
        return this.f773a.a(this.f774b, r3, this.c);
    }
}
