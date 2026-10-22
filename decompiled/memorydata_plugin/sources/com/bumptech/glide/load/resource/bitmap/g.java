package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class g implements com.bumptech.glide.load.f<ByteBuffer, Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f859a;

    public g(j r1) {
        this.f859a = r1;
    }

    @Override // com.bumptech.glide.load.f
    public /* synthetic */ com.bumptech.glide.load.engine.s<Bitmap> a(ByteBuffer r3, int r4, int r5, com.bumptech.glide.load.e r6) {
        return a2((ByteBuffer) ZeusTransformUtils.preCheckCast(r3, ByteBuffer.class, "com.obric.memorydata.plugin"), r4, r5, r6);
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public com.bumptech.glide.load.engine.s<Bitmap> a2(ByteBuffer r1, int r2, int r3, com.bumptech.glide.load.e r4) {
        return this.f859a.a(r1, r2, r3, r4);
    }

    @Override // com.bumptech.glide.load.f
    public /* synthetic */ boolean a(ByteBuffer r3, com.bumptech.glide.load.e r4) {
        return a2((ByteBuffer) ZeusTransformUtils.preCheckCast(r3, ByteBuffer.class, "com.obric.memorydata.plugin"), r4);
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(ByteBuffer r1, com.bumptech.glide.load.e r2) {
        return this.f859a.a(r1);
    }
}
