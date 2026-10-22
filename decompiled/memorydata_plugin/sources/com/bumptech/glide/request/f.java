package com.bumptech.glide.request;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class f extends a<f> {
    public f() {
    }

    public static f b(com.bumptech.glide.load.c r2) {
        com.bumptech.glide.load.c r3 = (com.bumptech.glide.load.c) ZeusTransformUtils.wrapperContextForParams(r2, com.bumptech.glide.load.c.class, "com.obric.memorydata.plugin");
        return (f) ZeusTransformUtils.preCheckCast(new f().a(r3), f.class, "com.obric.memorydata.plugin");
    }

    public static f b(com.bumptech.glide.load.engine.h r2) {
        return (f) ZeusTransformUtils.preCheckCast(new f().a(r2), f.class, "com.obric.memorydata.plugin");
    }

    public static f b(Class<?> r2) {
        return (f) ZeusTransformUtils.preCheckCast(new f().a(r2), f.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bumptech.glide.request.a
    public boolean equals(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, f.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (super.equals(r2) == false) goto L7;
        return true;
    }

    @Override // com.bumptech.glide.request.a
    public int hashCode() {
        return super.hashCode();
    }
}
