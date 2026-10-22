package com.bumptech.glide.manager;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class a implements j {
    a() {
    }

    @Override // com.bumptech.glide.manager.j
    public void addListener(k r2) {
        ((k) ZeusTransformUtils.wrapperContextForParams(r2, k.class, "com.obric.memorydata.plugin")).e();
    }

    @Override // com.bumptech.glide.manager.j
    public void removeListener(k r2) {
        k r1 = (k) ZeusTransformUtils.wrapperContextForParams(r2, k.class, "com.obric.memorydata.plugin");
    }
}
