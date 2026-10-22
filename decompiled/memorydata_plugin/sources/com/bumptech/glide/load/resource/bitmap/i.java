package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public class i extends f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final byte[] f861b = null;

    static {
        f861b = "com.bumptech.glide.load.resource.bitmap.CenterCrop".getBytes(f667a);
    }

    public i() {
    }

    @Override // com.bumptech.glide.load.resource.bitmap.f
    public Bitmap a(com.bumptech.glide.load.engine.bitmap_recycle.e r2, Bitmap r3, int r4, int r5) {
        return u.a((com.bumptech.glide.load.engine.bitmap_recycle.e) ZeusTransformUtils.wrapperContextForParams(r2, com.bumptech.glide.load.engine.bitmap_recycle.e.class, "com.obric.memorydata.plugin"), r3, r4, r5);
    }

    @Override // com.bumptech.glide.load.c
    public void a(MessageDigest r1) {
        r1.update(f861b);
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object r1) {
        return ZeusTransformUtils.instanceOf(r1, i.class);
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        return -599754482;
    }
}
