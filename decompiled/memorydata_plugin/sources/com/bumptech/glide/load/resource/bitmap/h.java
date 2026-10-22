package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class h implements com.bumptech.glide.load.f<ByteBuffer, Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f860a;

    public h() {
        this.f860a = new d();
    }

    @Override // com.bumptech.glide.load.f
    public /* synthetic */ com.bumptech.glide.load.engine.s<Bitmap> a(ByteBuffer r3, int r4, int r5, com.bumptech.glide.load.e r6) {
        return a2((ByteBuffer) ZeusTransformUtils.preCheckCast(r3, ByteBuffer.class, "com.obric.memorydata.plugin"), r4, r5, r6);
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public com.bumptech.glide.load.engine.s<Bitmap> a2(ByteBuffer r1, int r2, int r3, com.bumptech.glide.load.e r4) {
        ImageDecoder.Source r5 = ImageDecoder.createSource(r1);
        return this.f860a.a2(r5, r2, r3, r4);
    }

    @Override // com.bumptech.glide.load.f
    public /* synthetic */ boolean a(ByteBuffer r3, com.bumptech.glide.load.e r4) {
        return a2((ByteBuffer) ZeusTransformUtils.preCheckCast(r3, ByteBuffer.class, "com.obric.memorydata.plugin"), r4);
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(ByteBuffer r1, com.bumptech.glide.load.e r2) {
        return true;
    }
}
