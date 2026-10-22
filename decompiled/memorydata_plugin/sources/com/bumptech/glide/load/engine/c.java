package com.bumptech.glide.load.engine;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
final class c implements com.bumptech.glide.load.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.c f772b;
    private final com.bumptech.glide.load.c c;

    c(com.bumptech.glide.load.c r3, com.bumptech.glide.load.c r4) {
        com.bumptech.glide.load.c r5 = (com.bumptech.glide.load.c) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.c.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.load.c r6 = (com.bumptech.glide.load.c) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.c.class, "com.obric.memorydata.plugin");
        this.f772b = r5;
        this.c = r6;
    }

    @Override // com.bumptech.glide.load.c
    public void a(MessageDigest r2) {
        this.f772b.a(r2);
        this.c.a(r2);
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, c.class) == false) goto L10;
        c r5 = (c) ZeusTransformUtils.preCheckCast(r4, c.class, "com.obric.memorydata.plugin");
        if (this.f772b.equals(r5.f772b) == true) goto L7;
        return false;
    L7:
        if (this.c.equals(r5.c) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        return (this.f772b.hashCode() * 31) + this.c.hashCode();
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.f772b + ", signature=" + this.c + '}';
    }
}
